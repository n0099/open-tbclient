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
    private com.baidu.tbadk.core.dialog.a feH;
    private View feK;
    private WriteImagesInfo feu = null;
    private View awk = null;
    private ViewPager eHh = null;
    private r fev = null;
    private LinearLayout few = null;
    private RadioGroup EA = null;
    private RadioButton fex = null;
    private RadioButton fey = null;
    private LinearLayout fez = null;
    private View feA = null;
    private NavigationBar aKU = null;
    private TextView KC = null;
    private TextView feB = null;
    private String feC = "";
    private String feD = "";
    private String feE = "";
    private String feF = "(1/1)";
    private boolean feG = true;
    private HashMap<String, String> feI = new HashMap<>();
    private int feJ = 0;
    private int feL = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int Z = com.baidu.adp.lib.c.e.cS().Z("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || Z == 1 || PluginPackageManager.hF().bs(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.feG = false;
        } else {
            this.feG = true;
        }
        setContentView(t.h.write_multi_imgs_activity);
        nq();
        initData(bundle);
        if (this.feG) {
            if (this.feu != null) {
                i = this.feu.size();
                i2 = this.feu.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m11getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.fev.getCurrentIndex());
        this.fev.bdw();
        bundle.putString("OutState_Write_Img_Info", this.feu.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void nq() {
        this.feC = getResources().getString(t.j.beautify);
        this.feD = getResources().getString(t.j.rotate);
        this.feE = this.feC;
        this.awk = findViewById(t.g.write_multi_imgs_rootlayout);
        this.eHh = (ViewPager) findViewById(t.g.write_multi_imgs_viewpager);
        this.few = (LinearLayout) findViewById(t.g.write_multi_imgs_beautify);
        this.EA = (RadioGroup) findViewById(t.g.beautify_tabs);
        this.fex = (RadioButton) findViewById(t.g.beautify_btn);
        this.fey = (RadioButton) findViewById(t.g.rotate_btn);
        this.fex.setOnCheckedChangeListener(this);
        this.fey.setOnCheckedChangeListener(this);
        this.fez = (LinearLayout) findViewById(t.g.filters_layout);
        this.feA = findViewById(t.g.rotate);
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
        this.feK = this.aKU.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new cf(this));
        this.feB = this.aKU.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(t.j.done), new cg(this));
        this.KC = this.aKU.setTitleText(getPageContext().getString(t.j.beautify));
        this.fex.setChecked(true);
        if (!this.feG) {
            this.fey.setChecked(true);
            this.fey.setPadding(0, this.fey.getPaddingTop(), this.fey.getPaddingRight(), this.fey.getPaddingBottom());
            this.fez.setVisibility(8);
            this.fex.setVisibility(8);
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
            this.feu = new WriteImagesInfo();
            this.feu.parseJson(str);
            bej();
            this.fev = new r(this, this.eHh, this.feu.getChosedFiles(), i, this);
            this.eHh.setAdapter(this.fev);
            this.eHh.setCurrentItem(i, true);
            if (i == 0) {
                this.fev.onPageSelected(0);
            }
            this.few.setVisibility(0);
        }
    }

    private void bej() {
        if (this.feu != null && this.feu.isOriginalImg() && this.feu.getChosedFiles() != null && this.feu.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.feu.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.feI.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bek() {
        if (this.feu == null || !this.feu.isOriginalImg() || this.feu.getChosedFiles() == null || this.feu.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.feu.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.feI.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void bdx() {
        if (this.aKU.getVisibility() == 0) {
            this.aKU.setVisibility(8);
            this.few.setVisibility(8);
            return;
        }
        this.aKU.setVisibility(0);
        this.few.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void a(com.baidu.tbadk.coreExtra.view.c cVar, int i) {
        this.fez.removeAllViews();
        this.fez.addView(cVar);
        this.feF = "（" + (i + 1) + "/" + this.feu.size() + "）";
        this.KC.setText(String.valueOf(this.feE) + this.feF);
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void bdz() {
        this.feL--;
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void bdy() {
        this.feL++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bel() {
        this.feJ++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bem() {
        this.feJ--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ben() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.feu.toJsonString());
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
            if (compoundButton == this.fex) {
                this.fez.setVisibility(0);
                this.feA.setVisibility(8);
                this.feE = this.feC;
                this.KC.setText(String.valueOf(this.feE) + this.feF);
                return;
            }
            this.fez.setVisibility(8);
            this.feA.setVisibility(0);
            this.feE = this.feD;
            this.KC.setText(String.valueOf(this.feE) + this.feF);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ae(i == 1);
        getLayoutMode().x(this.awk);
        amd();
    }

    private void amd() {
        com.baidu.tbadk.core.util.at.l(this.aKU, t.d.alpha80_black);
        com.baidu.tbadk.core.util.at.c(this.KC, t.d.cp_cont_g, 1);
        com.baidu.tbadk.core.util.at.a(this.aKU.getBackImageView(), t.f.icon_return_s, t.f.icon_return_s_w, 0);
        com.baidu.tbadk.core.util.at.c(this.feB, t.d.cp_cont_g, 1);
    }
}
