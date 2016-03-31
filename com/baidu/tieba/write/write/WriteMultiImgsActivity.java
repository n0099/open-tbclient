package com.baidu.tieba.write.write;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.t;
import com.baidu.tieba.write.write.r;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class WriteMultiImgsActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, r.a {
    private com.baidu.tbadk.core.dialog.a eNJ;
    private WriteImagesInfo eNv = null;
    private View aAh = null;
    private ViewPager eNw = null;
    private r eNx = null;
    private LinearLayout eNy = null;
    private RadioGroup Ok = null;
    private RadioButton eNz = null;
    private RadioButton eNA = null;
    private LinearLayout eNB = null;
    private View eNC = null;
    private NavigationBar aOK = null;
    private TextView aUx = null;
    private TextView eND = null;
    private String eNE = "";
    private String eNF = "";
    private String eNG = "";
    private String eNH = "(1/1)";
    private boolean eNI = true;
    private HashMap<String, String> eNK = new HashMap<>();
    private int eNL = 0;
    private int eNM = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int ai = com.baidu.adp.lib.c.e.gE().ai("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || ai == 1 || PluginPackageManager.ls().bz(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.eNI = false;
        } else {
            this.eNI = true;
        }
        setContentView(t.h.write_multi_imgs_activity);
        pU();
        initData(bundle);
        if (this.eNI) {
            if (this.eNv != null) {
                i = this.eNv.size();
                i2 = this.eNv.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m411getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.eNx.getCurrentIndex());
        this.eNx.bbc();
        bundle.putString("OutState_Write_Img_Info", this.eNv.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void pU() {
        this.eNE = getResources().getString(t.j.beautify);
        this.eNF = getResources().getString(t.j.rotate);
        this.eNG = this.eNE;
        this.aAh = findViewById(t.g.write_multi_imgs_rootlayout);
        this.eNw = (ViewPager) findViewById(t.g.write_multi_imgs_viewpager);
        this.eNy = (LinearLayout) findViewById(t.g.write_multi_imgs_beautify);
        this.Ok = (RadioGroup) findViewById(t.g.beautify_tabs);
        this.eNz = (RadioButton) findViewById(t.g.beautify_btn);
        this.eNA = (RadioButton) findViewById(t.g.rotate_btn);
        this.eNz.setOnCheckedChangeListener(this);
        this.eNA.setOnCheckedChangeListener(this);
        this.eNB = (LinearLayout) findViewById(t.g.filters_layout);
        this.eNC = findViewById(t.g.rotate);
        Button button = (Button) findViewById(t.g.rotate_left);
        Button button2 = (Button) findViewById(t.g.rotate_right);
        Button button3 = (Button) findViewById(t.g.rotate_left_right);
        Button button4 = (Button) findViewById(t.g.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        cb cbVar = new cb(this);
        button.setOnClickListener(cbVar);
        button2.setOnClickListener(cbVar);
        button3.setOnClickListener(cbVar);
        button4.setOnClickListener(cbVar);
        this.aOK = (NavigationBar) findViewById(t.g.write_multi_imgs_navibar);
        this.aOK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new cc(this));
        this.eND = this.aOK.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(t.j.done), new cd(this));
        this.aUx = this.aOK.setTitleText(getPageContext().getString(t.j.beautify));
        this.eNz.setChecked(true);
        if (!this.eNI) {
            this.eNA.setChecked(true);
            this.eNA.setPadding(0, this.eNA.getPaddingTop(), this.eNA.getPaddingRight(), this.eNA.getPaddingBottom());
            this.eNB.setVisibility(8);
            this.eNz.setVisibility(8);
            this.Ok.setVisibility(8);
        }
    }

    private void initData(Bundle bundle) {
        int i;
        String str = null;
        if (bundle != null) {
            str = bundle.getString("OutState_Write_Img_Info");
            i = bundle.getInt("OutState_Current_Index");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                str = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
                i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            } else {
                i = -1;
            }
        }
        if (str != null && i != -1) {
            this.eNv = new WriteImagesInfo();
            this.eNv.parseJson(str);
            bbK();
            this.eNx = new r(this, this.eNw, this.eNv.getChosedFiles(), i, this);
            this.eNw.setAdapter(this.eNx);
            this.eNw.setCurrentItem(i, true);
            if (i == 0) {
                this.eNx.onPageSelected(0);
            }
            this.eNy.setVisibility(0);
        }
    }

    private void bbK() {
        if (this.eNv != null && this.eNv.isOriginalImg() && this.eNv.getChosedFiles() != null && this.eNv.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.eNv.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.eNK.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bbL() {
        if (this.eNv == null || !this.eNv.isOriginalImg() || this.eNv.getChosedFiles() == null || this.eNv.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.eNv.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.eNK.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void bbd() {
        if (this.aOK.getVisibility() == 0) {
            this.aOK.setVisibility(8);
            this.eNy.setVisibility(8);
            return;
        }
        this.aOK.setVisibility(0);
        this.eNy.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void a(com.baidu.tbadk.coreExtra.view.c cVar, int i) {
        this.eNB.removeAllViews();
        this.eNB.addView(cVar);
        this.eNH = "（" + (i + 1) + "/" + this.eNv.size() + "）";
        this.aUx.setText(String.valueOf(this.eNG) + this.eNH);
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void bbf() {
        this.eNM--;
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void bbe() {
        this.eNM++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bbM() {
        this.eNL++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bbN() {
        this.eNL--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbO() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.eNv.toJsonString());
        setResult(-1, intent);
        finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        setResult(0);
        finish();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            if (compoundButton == this.eNz) {
                this.eNB.setVisibility(0);
                this.eNC.setVisibility(8);
                this.eNG = this.eNE;
                this.aUx.setText(String.valueOf(this.eNG) + this.eNH);
                return;
            }
            this.eNB.setVisibility(8);
            this.eNC.setVisibility(0);
            this.eNG = this.eNF;
            this.aUx.setText(String.valueOf(this.eNG) + this.eNH);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ab(i == 1);
        getLayoutMode().x(this.aAh);
        this.aOK.onChangeSkinType(getPageContext(), i);
        if (this.eND.isEnabled()) {
            com.baidu.tbadk.core.util.at.k(this.eND, t.f.navi_done_text_bg);
            com.baidu.tbadk.core.util.at.b(this.eND, t.d.navi_done_text, 1);
            return;
        }
        com.baidu.tbadk.core.util.at.k(this.eND, t.f.btn_titlebar_finish_d);
        com.baidu.tbadk.core.util.at.b(this.eND, t.d.navi_done_text_d, 1);
    }
}
