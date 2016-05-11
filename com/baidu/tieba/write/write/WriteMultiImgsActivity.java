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
    private com.baidu.tbadk.core.dialog.a feI;
    private View feL;
    private WriteImagesInfo fev = null;
    private View awk = null;
    private ViewPager eHi = null;
    private r few = null;
    private LinearLayout fex = null;
    private RadioGroup EA = null;
    private RadioButton fey = null;
    private RadioButton fez = null;
    private LinearLayout feA = null;
    private View feB = null;
    private NavigationBar aKU = null;
    private TextView KC = null;
    private TextView feC = null;
    private String feD = "";
    private String feE = "";
    private String feF = "";
    private String feG = "(1/1)";
    private boolean feH = true;
    private HashMap<String, String> feJ = new HashMap<>();
    private int feK = 0;
    private int feM = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int Z = com.baidu.adp.lib.c.e.cS().Z("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || Z == 1 || PluginPackageManager.hF().bs(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.feH = false;
        } else {
            this.feH = true;
        }
        setContentView(t.h.write_multi_imgs_activity);
        nq();
        initData(bundle);
        if (this.feH) {
            if (this.fev != null) {
                i = this.fev.size();
                i2 = this.fev.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m11getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.few.getCurrentIndex());
        this.few.bdp();
        bundle.putString("OutState_Write_Img_Info", this.fev.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void nq() {
        this.feD = getResources().getString(t.j.beautify);
        this.feE = getResources().getString(t.j.rotate);
        this.feF = this.feD;
        this.awk = findViewById(t.g.write_multi_imgs_rootlayout);
        this.eHi = (ViewPager) findViewById(t.g.write_multi_imgs_viewpager);
        this.fex = (LinearLayout) findViewById(t.g.write_multi_imgs_beautify);
        this.EA = (RadioGroup) findViewById(t.g.beautify_tabs);
        this.fey = (RadioButton) findViewById(t.g.beautify_btn);
        this.fez = (RadioButton) findViewById(t.g.rotate_btn);
        this.fey.setOnCheckedChangeListener(this);
        this.fez.setOnCheckedChangeListener(this);
        this.feA = (LinearLayout) findViewById(t.g.filters_layout);
        this.feB = findViewById(t.g.rotate);
        Button button = (Button) findViewById(t.g.rotate_left);
        Button button2 = (Button) findViewById(t.g.rotate_right);
        Button button3 = (Button) findViewById(t.g.rotate_left_right);
        Button button4 = (Button) findViewById(t.g.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        ce ceVar = new ce(this);
        button.setOnClickListener(ceVar);
        button2.setOnClickListener(ceVar);
        button3.setOnClickListener(ceVar);
        button4.setOnClickListener(ceVar);
        this.aKU = (NavigationBar) findViewById(t.g.write_multi_imgs_navibar);
        this.feL = this.aKU.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new cf(this));
        this.feC = this.aKU.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(t.j.done), new cg(this));
        this.KC = this.aKU.setTitleText(getPageContext().getString(t.j.beautify));
        this.fey.setChecked(true);
        if (!this.feH) {
            this.fez.setChecked(true);
            this.fez.setPadding(0, this.fez.getPaddingTop(), this.fez.getPaddingRight(), this.fez.getPaddingBottom());
            this.feA.setVisibility(8);
            this.fey.setVisibility(8);
            this.EA.setVisibility(8);
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
            this.fev = new WriteImagesInfo();
            this.fev.parseJson(str);
            bec();
            this.few = new r(this, this.eHi, this.fev.getChosedFiles(), i, this);
            this.eHi.setAdapter(this.few);
            this.eHi.setCurrentItem(i, true);
            if (i == 0) {
                this.few.onPageSelected(0);
            }
            this.fex.setVisibility(0);
        }
    }

    private void bec() {
        if (this.fev != null && this.fev.isOriginalImg() && this.fev.getChosedFiles() != null && this.fev.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.fev.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.feJ.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bed() {
        if (this.fev == null || !this.fev.isOriginalImg() || this.fev.getChosedFiles() == null || this.fev.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.fev.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.feJ.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void bdq() {
        if (this.aKU.getVisibility() == 0) {
            this.aKU.setVisibility(8);
            this.fex.setVisibility(8);
            return;
        }
        this.aKU.setVisibility(0);
        this.fex.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void a(com.baidu.tbadk.coreExtra.view.c cVar, int i) {
        this.feA.removeAllViews();
        this.feA.addView(cVar);
        this.feG = "（" + (i + 1) + "/" + this.fev.size() + "）";
        this.KC.setText(String.valueOf(this.feF) + this.feG);
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void bds() {
        this.feM--;
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void bdr() {
        this.feM++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bee() {
        this.feK++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bef() {
        this.feK--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beg() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.fev.toJsonString());
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
            if (compoundButton == this.fey) {
                this.feA.setVisibility(0);
                this.feB.setVisibility(8);
                this.feF = this.feD;
                this.KC.setText(String.valueOf(this.feF) + this.feG);
                return;
            }
            this.feA.setVisibility(8);
            this.feB.setVisibility(0);
            this.feF = this.feE;
            this.KC.setText(String.valueOf(this.feF) + this.feG);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ae(i == 1);
        getLayoutMode().x(this.awk);
        amb();
    }

    private void amb() {
        com.baidu.tbadk.core.util.at.l(this.aKU, t.d.alpha80_black);
        com.baidu.tbadk.core.util.at.c(this.KC, t.d.cp_cont_g, 1);
        com.baidu.tbadk.core.util.at.a(this.aKU.getBackImageView(), t.f.icon_return_s, t.f.icon_return_s_w, 0);
        com.baidu.tbadk.core.util.at.c(this.feC, t.d.cp_cont_g, 1);
    }
}
