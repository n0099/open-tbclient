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
    private com.baidu.tbadk.core.dialog.a fSR;
    private View fSU;
    private WriteImagesInfo fSE = null;
    private View rootView = null;
    private ViewPager bka = null;
    private q fSF = null;
    private LinearLayout fSG = null;
    private RadioGroup epV = null;
    private RadioButton fSH = null;
    private RadioButton fSI = null;
    private LinearLayout fSJ = null;
    private View fSK = null;
    private NavigationBar aYR = null;
    private TextView Rs = null;
    private TextView fSL = null;
    private String fSM = "";
    private String fSN = "";
    private String fSO = "";
    private String fSP = "(1/1)";
    private boolean fSQ = true;
    private HashMap<String, String> fSS = new HashMap<>();
    private int fST = 0;
    private int fSV = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int Y = com.baidu.adp.lib.b.e.eY().Y("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || Y == 1 || PluginPackageManager.jx().bi(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.fSQ = false;
        } else {
            this.fSQ = true;
        }
        setContentView(w.j.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.fSQ) {
            if (this.fSE != null) {
                i = this.fSE.size();
                i2 = this.fSE.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m9getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.fSF.getCurrentIndex());
        this.fSF.boV();
        bundle.putString("OutState_Write_Img_Info", this.fSE.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.fSM = getResources().getString(w.l.beautify);
        this.fSN = getResources().getString(w.l.rotate);
        this.fSO = this.fSM;
        this.rootView = findViewById(w.h.write_multi_imgs_rootlayout);
        this.bka = (ViewPager) findViewById(w.h.write_multi_imgs_viewpager);
        this.fSG = (LinearLayout) findViewById(w.h.write_multi_imgs_beautify);
        this.epV = (RadioGroup) findViewById(w.h.beautify_tabs);
        this.fSH = (RadioButton) findViewById(w.h.beautify_btn);
        this.fSI = (RadioButton) findViewById(w.h.rotate_btn);
        this.fSH.setOnCheckedChangeListener(this);
        this.fSI.setOnCheckedChangeListener(this);
        this.fSJ = (LinearLayout) findViewById(w.h.filters_layout);
        this.fSK = findViewById(w.h.rotate);
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
        this.aYR = (NavigationBar) findViewById(w.h.write_multi_imgs_navibar);
        this.fSU = this.aYR.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bz(this));
        this.fSL = this.aYR.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(w.l.done), new ca(this));
        this.Rs = this.aYR.setTitleText(getPageContext().getString(w.l.beautify));
        this.fSH.setChecked(true);
        if (!this.fSQ) {
            this.fSI.setChecked(true);
            this.fSI.setPadding(0, this.fSI.getPaddingTop(), this.fSI.getPaddingRight(), this.fSI.getPaddingBottom());
            this.fSJ.setVisibility(8);
            this.fSH.setVisibility(8);
            this.epV.setVisibility(8);
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
            this.fSE = new WriteImagesInfo();
            this.fSE.parseJson(str);
            bpF();
            this.fSF = new q(this, this.bka, this.fSE.getChosedFiles(), i, this);
            this.bka.setAdapter(this.fSF);
            this.bka.setCurrentItem(i, true);
            if (i == 0) {
                this.fSF.onPageSelected(0);
            }
            this.fSG.setVisibility(0);
        }
    }

    private void bpF() {
        if (this.fSE != null && this.fSE.isOriginalImg() && this.fSE.getChosedFiles() != null && this.fSE.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.fSE.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.fSS.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bpG() {
        if (this.fSE == null || !this.fSE.isOriginalImg() || this.fSE.getChosedFiles() == null || this.fSE.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.fSE.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.fSS.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void boW() {
        if (this.aYR.getVisibility() == 0) {
            this.aYR.setVisibility(8);
            this.fSG.setVisibility(8);
            return;
        }
        this.aYR.setVisibility(0);
        this.fSG.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void a(com.baidu.tbadk.coreExtra.view.c cVar, int i) {
        this.fSJ.removeAllViews();
        this.fSJ.addView(cVar);
        this.fSP = "（" + (i + 1) + "/" + this.fSE.size() + "）";
        this.Rs.setText(String.valueOf(this.fSO) + this.fSP);
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void boY() {
        this.fSV--;
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void boX() {
        this.fSV++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bpH() {
        this.fST++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bpI() {
        this.fST--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpJ() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.fSE.toJsonString());
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
            if (compoundButton == this.fSH) {
                this.fSJ.setVisibility(0);
                this.fSK.setVisibility(8);
                this.fSO = this.fSM;
                this.Rs.setText(String.valueOf(this.fSO) + this.fSP);
                return;
            }
            this.fSJ.setVisibility(8);
            this.fSK.setVisibility(0);
            this.fSO = this.fSN;
            this.Rs.setText(String.valueOf(this.fSO) + this.fSP);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().aj(i == 1);
        getLayoutMode().t(this.rootView);
        avP();
    }

    private void avP() {
        com.baidu.tbadk.core.util.aq.k(this.aYR, w.e.common_color_10222);
        com.baidu.tbadk.core.util.aq.c(this.Rs, w.e.cp_cont_g, 1);
        com.baidu.tbadk.core.util.aq.a(this.aYR.getBackImageView(), w.g.icon_return_s, w.g.icon_return_s_w, 0);
        com.baidu.tbadk.core.util.aq.c(this.fSL, w.e.cp_cont_g, 1);
    }
}
