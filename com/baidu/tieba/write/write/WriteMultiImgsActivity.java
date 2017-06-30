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
    private com.baidu.tbadk.core.dialog.a gmq;
    private View gmt;
    private WriteImagesInfo gmd = null;
    private View rootView = null;
    private ViewPager brL = null;
    private q gme = null;
    private LinearLayout gmf = null;
    private RadioGroup eCT = null;
    private RadioButton gmg = null;
    private RadioButton gmh = null;
    private LinearLayout gmi = null;
    private View gmj = null;
    private NavigationBar aYl = null;
    private TextView Qs = null;
    private TextView gmk = null;
    private String gml = "";
    private String gmm = "";
    private String gmn = "";
    private String gmo = "(1/1)";
    private boolean gmp = true;
    private HashMap<String, String> gmr = new HashMap<>();
    private int gms = 0;
    private int gmu = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int ad = com.baidu.adp.lib.b.e.eY().ad("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || ad == 1 || PluginPackageManager.jw().bn(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.gmp = false;
        } else {
            this.gmp = true;
        }
        setContentView(w.j.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.gmp) {
            if (this.gmd != null) {
                i = this.gmd.size();
                i2 = this.gmd.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m9getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.gme.getCurrentIndex());
        this.gme.btV();
        bundle.putString("OutState_Write_Img_Info", this.gmd.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.gml = getResources().getString(w.l.beautify);
        this.gmm = getResources().getString(w.l.rotate);
        this.gmn = this.gml;
        this.rootView = findViewById(w.h.write_multi_imgs_rootlayout);
        this.brL = (ViewPager) findViewById(w.h.write_multi_imgs_viewpager);
        this.gmf = (LinearLayout) findViewById(w.h.write_multi_imgs_beautify);
        this.eCT = (RadioGroup) findViewById(w.h.beautify_tabs);
        this.gmg = (RadioButton) findViewById(w.h.beautify_btn);
        this.gmh = (RadioButton) findViewById(w.h.rotate_btn);
        this.gmg.setOnCheckedChangeListener(this);
        this.gmh.setOnCheckedChangeListener(this);
        this.gmi = (LinearLayout) findViewById(w.h.filters_layout);
        this.gmj = findViewById(w.h.rotate);
        Button button = (Button) findViewById(w.h.rotate_left);
        Button button2 = (Button) findViewById(w.h.rotate_right);
        Button button3 = (Button) findViewById(w.h.rotate_left_right);
        Button button4 = (Button) findViewById(w.h.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        ca caVar = new ca(this);
        button.setOnClickListener(caVar);
        button2.setOnClickListener(caVar);
        button3.setOnClickListener(caVar);
        button4.setOnClickListener(caVar);
        this.aYl = (NavigationBar) findViewById(w.h.write_multi_imgs_navibar);
        this.gmt = this.aYl.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new cb(this));
        this.gmk = this.aYl.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(w.l.done), new cc(this));
        this.Qs = this.aYl.setTitleText(getPageContext().getString(w.l.beautify));
        this.gmg.setChecked(true);
        if (!this.gmp) {
            this.gmh.setChecked(true);
            this.gmh.setPadding(0, this.gmh.getPaddingTop(), this.gmh.getPaddingRight(), this.gmh.getPaddingBottom());
            this.gmi.setVisibility(8);
            this.gmg.setVisibility(8);
            this.eCT.setVisibility(8);
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
            this.gmd = new WriteImagesInfo();
            this.gmd.parseJson(str);
            buI();
            this.gme = new q(this, this.brL, this.gmd.getChosedFiles(), i, this);
            this.brL.setAdapter(this.gme);
            this.brL.setCurrentItem(i, true);
            if (i == 0) {
                this.gme.onPageSelected(0);
            }
            this.gmf.setVisibility(0);
        }
    }

    private void buI() {
        if (this.gmd != null && this.gmd.isOriginalImg() && this.gmd.getChosedFiles() != null && this.gmd.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.gmd.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.gmr.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean buJ() {
        if (this.gmd == null || !this.gmd.isOriginalImg() || this.gmd.getChosedFiles() == null || this.gmd.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.gmd.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.gmr.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void btW() {
        if (this.aYl.getVisibility() == 0) {
            this.aYl.setVisibility(8);
            this.gmf.setVisibility(8);
            return;
        }
        this.aYl.setVisibility(0);
        this.gmf.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void a(com.baidu.tbadk.coreExtra.view.c cVar, int i) {
        this.gmi.removeAllViews();
        this.gmi.addView(cVar);
        this.gmo = "（" + (i + 1) + "/" + this.gmd.size() + "）";
        this.Qs.setText(String.valueOf(this.gmn) + this.gmo);
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void btY() {
        this.gmu--;
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void btX() {
        this.gmu++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void buK() {
        this.gms++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void buL() {
        this.gms--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buM() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.gmd.toJsonString());
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
            if (compoundButton == this.gmg) {
                this.gmi.setVisibility(0);
                this.gmj.setVisibility(8);
                this.gmn = this.gml;
                this.Qs.setText(String.valueOf(this.gmn) + this.gmo);
                return;
            }
            this.gmi.setVisibility(8);
            this.gmj.setVisibility(0);
            this.gmn = this.gmm;
            this.Qs.setText(String.valueOf(this.gmn) + this.gmo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.rootView);
        ayo();
    }

    private void ayo() {
        com.baidu.tbadk.core.util.as.k(this.aYl, w.e.common_color_10222);
        com.baidu.tbadk.core.util.as.c(this.Qs, w.e.cp_cont_g, 1);
        com.baidu.tbadk.core.util.as.a(this.aYl.getBackImageView(), w.g.icon_return_s, w.g.icon_return_s_w, 0);
        com.baidu.tbadk.core.util.as.c(this.gmk, w.e.cp_cont_g, 1);
    }
}
