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
    private com.baidu.tbadk.core.dialog.a gpU;
    private View gpX;
    private WriteImagesInfo gpH = null;
    private View aBq = null;
    private ViewPager fRy = null;
    private r gpI = null;
    private LinearLayout gpJ = null;
    private RadioGroup Hw = null;
    private RadioButton gpK = null;
    private RadioButton gpL = null;
    private LinearLayout gpM = null;
    private View gpN = null;
    private NavigationBar aXB = null;
    private TextView MN = null;
    private TextView gpO = null;
    private String gpP = "";
    private String gpQ = "";
    private String gpR = "";
    private String gpS = "(1/1)";
    private boolean gpT = true;
    private HashMap<String, String> gpV = new HashMap<>();
    private int gpW = 0;
    private int gpY = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int ac = com.baidu.adp.lib.c.e.dN().ac("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || ac == 1 || PluginPackageManager.iB().bu(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.gpT = false;
        } else {
            this.gpT = true;
        }
        setContentView(r.h.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.gpT) {
            if (this.gpH != null) {
                i = this.gpH.size();
                i2 = this.gpH.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m9getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.gpI.getCurrentIndex());
        this.gpI.bwd();
        bundle.putString("OutState_Write_Img_Info", this.gpH.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.gpP = getResources().getString(r.j.beautify);
        this.gpQ = getResources().getString(r.j.rotate);
        this.gpR = this.gpP;
        this.aBq = findViewById(r.g.write_multi_imgs_rootlayout);
        this.fRy = (ViewPager) findViewById(r.g.write_multi_imgs_viewpager);
        this.gpJ = (LinearLayout) findViewById(r.g.write_multi_imgs_beautify);
        this.Hw = (RadioGroup) findViewById(r.g.beautify_tabs);
        this.gpK = (RadioButton) findViewById(r.g.beautify_btn);
        this.gpL = (RadioButton) findViewById(r.g.rotate_btn);
        this.gpK.setOnCheckedChangeListener(this);
        this.gpL.setOnCheckedChangeListener(this);
        this.gpM = (LinearLayout) findViewById(r.g.filters_layout);
        this.gpN = findViewById(r.g.rotate);
        Button button = (Button) findViewById(r.g.rotate_left);
        Button button2 = (Button) findViewById(r.g.rotate_right);
        Button button3 = (Button) findViewById(r.g.rotate_left_right);
        Button button4 = (Button) findViewById(r.g.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        cb cbVar = new cb(this);
        button.setOnClickListener(cbVar);
        button2.setOnClickListener(cbVar);
        button3.setOnClickListener(cbVar);
        button4.setOnClickListener(cbVar);
        this.aXB = (NavigationBar) findViewById(r.g.write_multi_imgs_navibar);
        this.gpX = this.aXB.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new cc(this));
        this.gpO = this.aXB.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(r.j.done), new cd(this));
        this.MN = this.aXB.setTitleText(getPageContext().getString(r.j.beautify));
        this.gpK.setChecked(true);
        if (!this.gpT) {
            this.gpL.setChecked(true);
            this.gpL.setPadding(0, this.gpL.getPaddingTop(), this.gpL.getPaddingRight(), this.gpL.getPaddingBottom());
            this.gpM.setVisibility(8);
            this.gpK.setVisibility(8);
            this.Hw.setVisibility(8);
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
            this.gpH = new WriteImagesInfo();
            this.gpH.parseJson(str);
            bwM();
            this.gpI = new r(this, this.fRy, this.gpH.getChosedFiles(), i, this);
            this.fRy.setAdapter(this.gpI);
            this.fRy.setCurrentItem(i, true);
            if (i == 0) {
                this.gpI.onPageSelected(0);
            }
            this.gpJ.setVisibility(0);
        }
    }

    private void bwM() {
        if (this.gpH != null && this.gpH.isOriginalImg() && this.gpH.getChosedFiles() != null && this.gpH.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.gpH.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.gpV.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bwN() {
        if (this.gpH == null || !this.gpH.isOriginalImg() || this.gpH.getChosedFiles() == null || this.gpH.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.gpH.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.gpV.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void bwe() {
        if (this.aXB.getVisibility() == 0) {
            this.aXB.setVisibility(8);
            this.gpJ.setVisibility(8);
            return;
        }
        this.aXB.setVisibility(0);
        this.gpJ.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void a(com.baidu.tbadk.coreExtra.view.c cVar, int i) {
        this.gpM.removeAllViews();
        this.gpM.addView(cVar);
        this.gpS = "（" + (i + 1) + "/" + this.gpH.size() + "）";
        this.MN.setText(String.valueOf(this.gpR) + this.gpS);
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void bwg() {
        this.gpY--;
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void bwf() {
        this.gpY++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bwO() {
        this.gpW++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bwP() {
        this.gpW--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwQ() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.gpH.toJsonString());
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
            if (compoundButton == this.gpK) {
                this.gpM.setVisibility(0);
                this.gpN.setVisibility(8);
                this.gpR = this.gpP;
                this.MN.setText(String.valueOf(this.gpR) + this.gpS);
                return;
            }
            this.gpM.setVisibility(8);
            this.gpN.setVisibility(0);
            this.gpR = this.gpQ;
            this.MN.setText(String.valueOf(this.gpR) + this.gpS);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ai(i == 1);
        getLayoutMode().x(this.aBq);
        aCi();
    }

    private void aCi() {
        com.baidu.tbadk.core.util.at.l(this.aXB, r.d.common_color_10222);
        com.baidu.tbadk.core.util.at.c(this.MN, r.d.cp_cont_g, 1);
        com.baidu.tbadk.core.util.at.a(this.aXB.getBackImageView(), r.f.icon_return_s, r.f.icon_return_s_w, 0);
        com.baidu.tbadk.core.util.at.c(this.gpO, r.d.cp_cont_g, 1);
    }
}
