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
    private com.baidu.tbadk.core.dialog.a fVT;
    private View fVW;
    private WriteImagesInfo fVG = null;
    private View axO = null;
    private ViewPager fze = null;
    private r fVH = null;
    private LinearLayout fVI = null;
    private RadioGroup Fh = null;
    private RadioButton fVJ = null;
    private RadioButton fVK = null;
    private LinearLayout fVL = null;
    private View fVM = null;
    private NavigationBar aPm = null;
    private TextView KB = null;
    private TextView fVN = null;
    private String fVO = "";
    private String fVP = "";
    private String fVQ = "";
    private String fVR = "(1/1)";
    private boolean fVS = true;
    private HashMap<String, String> fVU = new HashMap<>();
    private int fVV = 0;
    private int fVX = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int ab = com.baidu.adp.lib.c.e.cS().ab("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || ab == 1 || PluginPackageManager.hG().bt(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.fVS = false;
        } else {
            this.fVS = true;
        }
        setContentView(u.h.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.fVS) {
            if (this.fVG != null) {
                i = this.fVG.size();
                i2 = this.fVG.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m10getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.fVH.getCurrentIndex());
        this.fVH.boN();
        bundle.putString("OutState_Write_Img_Info", this.fVG.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.fVO = getResources().getString(u.j.beautify);
        this.fVP = getResources().getString(u.j.rotate);
        this.fVQ = this.fVO;
        this.axO = findViewById(u.g.write_multi_imgs_rootlayout);
        this.fze = (ViewPager) findViewById(u.g.write_multi_imgs_viewpager);
        this.fVI = (LinearLayout) findViewById(u.g.write_multi_imgs_beautify);
        this.Fh = (RadioGroup) findViewById(u.g.beautify_tabs);
        this.fVJ = (RadioButton) findViewById(u.g.beautify_btn);
        this.fVK = (RadioButton) findViewById(u.g.rotate_btn);
        this.fVJ.setOnCheckedChangeListener(this);
        this.fVK.setOnCheckedChangeListener(this);
        this.fVL = (LinearLayout) findViewById(u.g.filters_layout);
        this.fVM = findViewById(u.g.rotate);
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
        this.aPm = (NavigationBar) findViewById(u.g.write_multi_imgs_navibar);
        this.fVW = this.aPm.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new cb(this));
        this.fVN = this.aPm.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(u.j.done), new cc(this));
        this.KB = this.aPm.setTitleText(getPageContext().getString(u.j.beautify));
        this.fVJ.setChecked(true);
        if (!this.fVS) {
            this.fVK.setChecked(true);
            this.fVK.setPadding(0, this.fVK.getPaddingTop(), this.fVK.getPaddingRight(), this.fVK.getPaddingBottom());
            this.fVL.setVisibility(8);
            this.fVJ.setVisibility(8);
            this.Fh.setVisibility(8);
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
            this.fVG = new WriteImagesInfo();
            this.fVG.parseJson(str);
            bpy();
            this.fVH = new r(this, this.fze, this.fVG.getChosedFiles(), i, this);
            this.fze.setAdapter(this.fVH);
            this.fze.setCurrentItem(i, true);
            if (i == 0) {
                this.fVH.onPageSelected(0);
            }
            this.fVI.setVisibility(0);
        }
    }

    private void bpy() {
        if (this.fVG != null && this.fVG.isOriginalImg() && this.fVG.getChosedFiles() != null && this.fVG.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.fVG.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.fVU.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bpz() {
        if (this.fVG == null || !this.fVG.isOriginalImg() || this.fVG.getChosedFiles() == null || this.fVG.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.fVG.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.fVU.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void boO() {
        if (this.aPm.getVisibility() == 0) {
            this.aPm.setVisibility(8);
            this.fVI.setVisibility(8);
            return;
        }
        this.aPm.setVisibility(0);
        this.fVI.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void a(com.baidu.tbadk.coreExtra.view.c cVar, int i) {
        this.fVL.removeAllViews();
        this.fVL.addView(cVar);
        this.fVR = "（" + (i + 1) + "/" + this.fVG.size() + "）";
        this.KB.setText(String.valueOf(this.fVQ) + this.fVR);
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void boQ() {
        this.fVX--;
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void boP() {
        this.fVX++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bpA() {
        this.fVV++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bpB() {
        this.fVV--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpC() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.fVG.toJsonString());
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
            if (compoundButton == this.fVJ) {
                this.fVL.setVisibility(0);
                this.fVM.setVisibility(8);
                this.fVQ = this.fVO;
                this.KB.setText(String.valueOf(this.fVQ) + this.fVR);
                return;
            }
            this.fVL.setVisibility(8);
            this.fVM.setVisibility(0);
            this.fVQ = this.fVP;
            this.KB.setText(String.valueOf(this.fVQ) + this.fVR);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().af(i == 1);
        getLayoutMode().w(this.axO);
        avb();
    }

    private void avb() {
        com.baidu.tbadk.core.util.av.l(this.aPm, u.d.common_color_10222);
        com.baidu.tbadk.core.util.av.c(this.KB, u.d.cp_cont_g, 1);
        com.baidu.tbadk.core.util.av.a(this.aPm.getBackImageView(), u.f.icon_return_s, u.f.icon_return_s_w, 0);
        com.baidu.tbadk.core.util.av.c(this.fVN, u.d.cp_cont_g, 1);
    }
}
