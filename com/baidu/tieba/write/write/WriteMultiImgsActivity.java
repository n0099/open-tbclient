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
import com.baidu.tieba.r;
import com.baidu.tieba.write.write.r;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class WriteMultiImgsActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, r.a {
    private com.baidu.tbadk.core.dialog.a gij;
    private View gim;
    private WriteImagesInfo ghV = null;
    private View aAy = null;
    private ViewPager fJW = null;
    private r ghW = null;
    private LinearLayout ghX = null;
    private RadioGroup Hu = null;
    private RadioButton ghY = null;
    private RadioButton ghZ = null;
    private LinearLayout gia = null;
    private View gib = null;
    private NavigationBar aVp = null;
    private TextView MN = null;
    private TextView gic = null;
    private String gie = "";
    private String gif = "";
    private String gig = "";
    private String gih = "(1/1)";
    private boolean gii = true;
    private HashMap<String, String> gik = new HashMap<>();
    private int gil = 0;
    private int gin = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int ac = com.baidu.adp.lib.c.e.dN().ac("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || ac == 1 || PluginPackageManager.iB().bu(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.gii = false;
        } else {
            this.gii = true;
        }
        setContentView(r.h.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.gii) {
            if (this.ghV != null) {
                i = this.ghV.size();
                i2 = this.ghV.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m9getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.ghW.getCurrentIndex());
        this.ghW.btI();
        bundle.putString("OutState_Write_Img_Info", this.ghV.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.gie = getResources().getString(r.j.beautify);
        this.gif = getResources().getString(r.j.rotate);
        this.gig = this.gie;
        this.aAy = findViewById(r.g.write_multi_imgs_rootlayout);
        this.fJW = (ViewPager) findViewById(r.g.write_multi_imgs_viewpager);
        this.ghX = (LinearLayout) findViewById(r.g.write_multi_imgs_beautify);
        this.Hu = (RadioGroup) findViewById(r.g.beautify_tabs);
        this.ghY = (RadioButton) findViewById(r.g.beautify_btn);
        this.ghZ = (RadioButton) findViewById(r.g.rotate_btn);
        this.ghY.setOnCheckedChangeListener(this);
        this.ghZ.setOnCheckedChangeListener(this);
        this.gia = (LinearLayout) findViewById(r.g.filters_layout);
        this.gib = findViewById(r.g.rotate);
        Button button = (Button) findViewById(r.g.rotate_left);
        Button button2 = (Button) findViewById(r.g.rotate_right);
        Button button3 = (Button) findViewById(r.g.rotate_left_right);
        Button button4 = (Button) findViewById(r.g.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        ca caVar = new ca(this);
        button.setOnClickListener(caVar);
        button2.setOnClickListener(caVar);
        button3.setOnClickListener(caVar);
        button4.setOnClickListener(caVar);
        this.aVp = (NavigationBar) findViewById(r.g.write_multi_imgs_navibar);
        this.gim = this.aVp.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new cb(this));
        this.gic = this.aVp.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(r.j.done), new cc(this));
        this.MN = this.aVp.setTitleText(getPageContext().getString(r.j.beautify));
        this.ghY.setChecked(true);
        if (!this.gii) {
            this.ghZ.setChecked(true);
            this.ghZ.setPadding(0, this.ghZ.getPaddingTop(), this.ghZ.getPaddingRight(), this.ghZ.getPaddingBottom());
            this.gia.setVisibility(8);
            this.ghY.setVisibility(8);
            this.Hu.setVisibility(8);
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
            this.ghV = new WriteImagesInfo();
            this.ghV.parseJson(str);
            but();
            this.ghW = new r(this, this.fJW, this.ghV.getChosedFiles(), i, this);
            this.fJW.setAdapter(this.ghW);
            this.fJW.setCurrentItem(i, true);
            if (i == 0) {
                this.ghW.onPageSelected(0);
            }
            this.ghX.setVisibility(0);
        }
    }

    private void but() {
        if (this.ghV != null && this.ghV.isOriginalImg() && this.ghV.getChosedFiles() != null && this.ghV.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.ghV.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.gik.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean buu() {
        if (this.ghV == null || !this.ghV.isOriginalImg() || this.ghV.getChosedFiles() == null || this.ghV.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.ghV.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.gik.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void btJ() {
        if (this.aVp.getVisibility() == 0) {
            this.aVp.setVisibility(8);
            this.ghX.setVisibility(8);
            return;
        }
        this.aVp.setVisibility(0);
        this.ghX.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void a(com.baidu.tbadk.coreExtra.view.c cVar, int i) {
        this.gia.removeAllViews();
        this.gia.addView(cVar);
        this.gih = "（" + (i + 1) + "/" + this.ghV.size() + "）";
        this.MN.setText(String.valueOf(this.gig) + this.gih);
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void btL() {
        this.gin--;
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void btK() {
        this.gin++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void buv() {
        this.gil++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void buw() {
        this.gil--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bux() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.ghV.toJsonString());
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
            if (compoundButton == this.ghY) {
                this.gia.setVisibility(0);
                this.gib.setVisibility(8);
                this.gig = this.gie;
                this.MN.setText(String.valueOf(this.gig) + this.gih);
                return;
            }
            this.gia.setVisibility(8);
            this.gib.setVisibility(0);
            this.gig = this.gif;
            this.MN.setText(String.valueOf(this.gig) + this.gih);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ah(i == 1);
        getLayoutMode().x(this.aAy);
        aAm();
    }

    private void aAm() {
        com.baidu.tbadk.core.util.av.l(this.aVp, r.d.common_color_10222);
        com.baidu.tbadk.core.util.av.c(this.MN, r.d.cp_cont_g, 1);
        com.baidu.tbadk.core.util.av.a(this.aVp.getBackImageView(), r.f.icon_return_s, r.f.icon_return_s_w, 0);
        com.baidu.tbadk.core.util.av.c(this.gic, r.d.cp_cont_g, 1);
    }
}
