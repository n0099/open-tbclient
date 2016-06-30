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
import com.baidu.tieba.u;
import com.baidu.tieba.write.write.r;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class WriteMultiImgsActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, r.a {
    private com.baidu.tbadk.core.dialog.a fKc;
    private View fKf;
    private WriteImagesInfo fJP = null;
    private View axa = null;
    private ViewPager fmb = null;
    private r fJQ = null;
    private LinearLayout fJR = null;
    private RadioGroup EH = null;
    private RadioButton fJS = null;
    private RadioButton fJT = null;
    private LinearLayout fJU = null;
    private View fJV = null;
    private NavigationBar aOs = null;
    private TextView KC = null;
    private TextView fJW = null;
    private String fJX = "";
    private String fJY = "";
    private String fJZ = "";
    private String fKa = "(1/1)";
    private boolean fKb = true;
    private HashMap<String, String> fKd = new HashMap<>();
    private int fKe = 0;
    private int fKg = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int Z = com.baidu.adp.lib.c.e.cT().Z("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || Z == 1 || PluginPackageManager.hH().bs(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.fKb = false;
        } else {
            this.fKb = true;
        }
        setContentView(u.h.write_multi_imgs_activity);
        nl();
        initData(bundle);
        if (this.fKb) {
            if (this.fJP != null) {
                i = this.fJP.size();
                i2 = this.fJP.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m9getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.fJQ.getCurrentIndex());
        this.fJQ.blS();
        bundle.putString("OutState_Write_Img_Info", this.fJP.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void nl() {
        this.fJX = getResources().getString(u.j.beautify);
        this.fJY = getResources().getString(u.j.rotate);
        this.fJZ = this.fJX;
        this.axa = findViewById(u.g.write_multi_imgs_rootlayout);
        this.fmb = (ViewPager) findViewById(u.g.write_multi_imgs_viewpager);
        this.fJR = (LinearLayout) findViewById(u.g.write_multi_imgs_beautify);
        this.EH = (RadioGroup) findViewById(u.g.beautify_tabs);
        this.fJS = (RadioButton) findViewById(u.g.beautify_btn);
        this.fJT = (RadioButton) findViewById(u.g.rotate_btn);
        this.fJS.setOnCheckedChangeListener(this);
        this.fJT.setOnCheckedChangeListener(this);
        this.fJU = (LinearLayout) findViewById(u.g.filters_layout);
        this.fJV = findViewById(u.g.rotate);
        Button button = (Button) findViewById(u.g.rotate_left);
        Button button2 = (Button) findViewById(u.g.rotate_right);
        Button button3 = (Button) findViewById(u.g.rotate_left_right);
        Button button4 = (Button) findViewById(u.g.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        ca caVar = new ca(this);
        button.setOnClickListener(caVar);
        button2.setOnClickListener(caVar);
        button3.setOnClickListener(caVar);
        button4.setOnClickListener(caVar);
        this.aOs = (NavigationBar) findViewById(u.g.write_multi_imgs_navibar);
        this.fKf = this.aOs.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new cb(this));
        this.fJW = this.aOs.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(u.j.done), new cc(this));
        this.KC = this.aOs.setTitleText(getPageContext().getString(u.j.beautify));
        this.fJS.setChecked(true);
        if (!this.fKb) {
            this.fJT.setChecked(true);
            this.fJT.setPadding(0, this.fJT.getPaddingTop(), this.fJT.getPaddingRight(), this.fJT.getPaddingBottom());
            this.fJU.setVisibility(8);
            this.fJS.setVisibility(8);
            this.EH.setVisibility(8);
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
            this.fJP = new WriteImagesInfo();
            this.fJP.parseJson(str);
            bmE();
            this.fJQ = new r(this, this.fmb, this.fJP.getChosedFiles(), i, this);
            this.fmb.setAdapter(this.fJQ);
            this.fmb.setCurrentItem(i, true);
            if (i == 0) {
                this.fJQ.onPageSelected(0);
            }
            this.fJR.setVisibility(0);
        }
    }

    private void bmE() {
        if (this.fJP != null && this.fJP.isOriginalImg() && this.fJP.getChosedFiles() != null && this.fJP.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.fJP.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.fKd.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bmF() {
        if (this.fJP == null || !this.fJP.isOriginalImg() || this.fJP.getChosedFiles() == null || this.fJP.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.fJP.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.fKd.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void blT() {
        if (this.aOs.getVisibility() == 0) {
            this.aOs.setVisibility(8);
            this.fJR.setVisibility(8);
            return;
        }
        this.aOs.setVisibility(0);
        this.fJR.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void a(com.baidu.tbadk.coreExtra.view.c cVar, int i) {
        this.fJU.removeAllViews();
        this.fJU.addView(cVar);
        this.fKa = "（" + (i + 1) + "/" + this.fJP.size() + "）";
        this.KC.setText(String.valueOf(this.fJZ) + this.fKa);
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void blV() {
        this.fKg--;
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void blU() {
        this.fKg++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bmG() {
        this.fKe++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bmH() {
        this.fKe--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmI() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.fJP.toJsonString());
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
            if (compoundButton == this.fJS) {
                this.fJU.setVisibility(0);
                this.fJV.setVisibility(8);
                this.fJZ = this.fJX;
                this.KC.setText(String.valueOf(this.fJZ) + this.fKa);
                return;
            }
            this.fJU.setVisibility(8);
            this.fJV.setVisibility(0);
            this.fJZ = this.fJY;
            this.KC.setText(String.valueOf(this.fJZ) + this.fKa);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ad(i == 1);
        getLayoutMode().w(this.axa);
        aup();
    }

    private void aup() {
        com.baidu.tbadk.core.util.av.l(this.aOs, u.d.common_color_10222);
        com.baidu.tbadk.core.util.av.c(this.KC, u.d.cp_cont_g, 1);
        com.baidu.tbadk.core.util.av.a(this.aOs.getBackImageView(), u.f.icon_return_s, u.f.icon_return_s_w, 0);
        com.baidu.tbadk.core.util.av.c(this.fJW, u.d.cp_cont_g, 1);
    }
}
