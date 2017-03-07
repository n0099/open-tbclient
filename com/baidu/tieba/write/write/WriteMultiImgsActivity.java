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
import com.baidu.tieba.w;
import com.baidu.tieba.write.write.q;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class WriteMultiImgsActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, q.a {
    private com.baidu.tbadk.core.dialog.a fRh;
    private View fRk;
    private WriteImagesInfo fQU = null;
    private View rootView = null;
    private ViewPager bkh = null;
    private q fQV = null;
    private LinearLayout fQW = null;
    private RadioGroup erM = null;
    private RadioButton fQX = null;
    private RadioButton fQY = null;
    private LinearLayout fQZ = null;
    private View fRa = null;
    private NavigationBar aYD = null;
    private TextView Ra = null;
    private TextView fRb = null;
    private String fRc = "";
    private String fRd = "";
    private String fRe = "";
    private String fRf = "(1/1)";
    private boolean fRg = true;
    private HashMap<String, String> fRi = new HashMap<>();
    private int fRj = 0;
    private int fRl = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int ab = com.baidu.adp.lib.b.e.eT().ab("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || ab == 1 || PluginPackageManager.jt().bn(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.fRg = false;
        } else {
            this.fRg = true;
        }
        setContentView(w.j.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.fRg) {
            if (this.fQU != null) {
                i = this.fQU.size();
                i2 = this.fQU.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m9getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.fQV.getCurrentIndex());
        this.fQV.bom();
        bundle.putString("OutState_Write_Img_Info", this.fQU.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.fRc = getResources().getString(w.l.beautify);
        this.fRd = getResources().getString(w.l.rotate);
        this.fRe = this.fRc;
        this.rootView = findViewById(w.h.write_multi_imgs_rootlayout);
        this.bkh = (ViewPager) findViewById(w.h.write_multi_imgs_viewpager);
        this.fQW = (LinearLayout) findViewById(w.h.write_multi_imgs_beautify);
        this.erM = (RadioGroup) findViewById(w.h.beautify_tabs);
        this.fQX = (RadioButton) findViewById(w.h.beautify_btn);
        this.fQY = (RadioButton) findViewById(w.h.rotate_btn);
        this.fQX.setOnCheckedChangeListener(this);
        this.fQY.setOnCheckedChangeListener(this);
        this.fQZ = (LinearLayout) findViewById(w.h.filters_layout);
        this.fRa = findViewById(w.h.rotate);
        Button button = (Button) findViewById(w.h.rotate_left);
        Button button2 = (Button) findViewById(w.h.rotate_right);
        Button button3 = (Button) findViewById(w.h.rotate_left_right);
        Button button4 = (Button) findViewById(w.h.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        by byVar = new by(this);
        button.setOnClickListener(byVar);
        button2.setOnClickListener(byVar);
        button3.setOnClickListener(byVar);
        button4.setOnClickListener(byVar);
        this.aYD = (NavigationBar) findViewById(w.h.write_multi_imgs_navibar);
        this.fRk = this.aYD.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bz(this));
        this.fRb = this.aYD.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(w.l.done), new ca(this));
        this.Ra = this.aYD.setTitleText(getPageContext().getString(w.l.beautify));
        this.fQX.setChecked(true);
        if (!this.fRg) {
            this.fQY.setChecked(true);
            this.fQY.setPadding(0, this.fQY.getPaddingTop(), this.fQY.getPaddingRight(), this.fQY.getPaddingBottom());
            this.fQZ.setVisibility(8);
            this.fQX.setVisibility(8);
            this.erM.setVisibility(8);
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
            this.fQU = new WriteImagesInfo();
            this.fQU.parseJson(str);
            boX();
            this.fQV = new q(this, this.bkh, this.fQU.getChosedFiles(), i, this);
            this.bkh.setAdapter(this.fQV);
            this.bkh.setCurrentItem(i, true);
            if (i == 0) {
                this.fQV.onPageSelected(0);
            }
            this.fQW.setVisibility(0);
        }
    }

    private void boX() {
        if (this.fQU != null && this.fQU.isOriginalImg() && this.fQU.getChosedFiles() != null && this.fQU.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.fQU.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.fRi.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean boY() {
        if (this.fQU == null || !this.fQU.isOriginalImg() || this.fQU.getChosedFiles() == null || this.fQU.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.fQU.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.fRi.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void bon() {
        if (this.aYD.getVisibility() == 0) {
            this.aYD.setVisibility(8);
            this.fQW.setVisibility(8);
            return;
        }
        this.aYD.setVisibility(0);
        this.fQW.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void a(com.baidu.tbadk.coreExtra.view.c cVar, int i) {
        this.fQZ.removeAllViews();
        this.fQZ.addView(cVar);
        this.fRf = "（" + (i + 1) + "/" + this.fQU.size() + "）";
        this.Ra.setText(String.valueOf(this.fRe) + this.fRf);
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void bop() {
        this.fRl--;
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void boo() {
        this.fRl++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void boZ() {
        this.fRj++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bpa() {
        this.fRj--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpb() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.fQU.toJsonString());
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
            if (compoundButton == this.fQX) {
                this.fQZ.setVisibility(0);
                this.fRa.setVisibility(8);
                this.fRe = this.fRc;
                this.Ra.setText(String.valueOf(this.fRe) + this.fRf);
                return;
            }
            this.fQZ.setVisibility(8);
            this.fRa.setVisibility(0);
            this.fRe = this.fRd;
            this.Ra.setText(String.valueOf(this.fRe) + this.fRf);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.rootView);
        avW();
    }

    private void avW() {
        com.baidu.tbadk.core.util.aq.k(this.aYD, w.e.common_color_10222);
        com.baidu.tbadk.core.util.aq.c(this.Ra, w.e.cp_cont_g, 1);
        com.baidu.tbadk.core.util.aq.a(this.aYD.getBackImageView(), w.g.icon_return_s, w.g.icon_return_s_w, 0);
        com.baidu.tbadk.core.util.aq.c(this.fRb, w.e.cp_cont_g, 1);
    }
}
