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
    private com.baidu.tbadk.core.dialog.a fEs;
    private View fEv;
    private WriteImagesInfo fEe = null;
    private View aAK = null;
    private ViewPager fEf = null;
    private r fEg = null;
    private LinearLayout fEh = null;
    private RadioGroup Hv = null;
    private RadioButton fEi = null;
    private RadioButton fEj = null;
    private LinearLayout fEk = null;
    private View fEl = null;
    private NavigationBar aWS = null;
    private TextView MK = null;
    private TextView fEm = null;
    private String fEn = "";
    private String fEo = "";
    private String fEp = "";
    private String fEq = "(1/1)";
    private boolean fEr = true;
    private HashMap<String, String> fEt = new HashMap<>();
    private int fEu = 0;
    private int fEw = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int ac = com.baidu.adp.lib.c.e.dN().ac("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || ac == 1 || PluginPackageManager.iB().bu(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.fEr = false;
        } else {
            this.fEr = true;
        }
        setContentView(r.h.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.fEr) {
            if (this.fEe != null) {
                i = this.fEe.size();
                i2 = this.fEe.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m9getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.fEg.getCurrentIndex());
        this.fEg.bnb();
        bundle.putString("OutState_Write_Img_Info", this.fEe.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.fEn = getResources().getString(r.j.beautify);
        this.fEo = getResources().getString(r.j.rotate);
        this.fEp = this.fEn;
        this.aAK = findViewById(r.g.write_multi_imgs_rootlayout);
        this.fEf = (ViewPager) findViewById(r.g.write_multi_imgs_viewpager);
        this.fEh = (LinearLayout) findViewById(r.g.write_multi_imgs_beautify);
        this.Hv = (RadioGroup) findViewById(r.g.beautify_tabs);
        this.fEi = (RadioButton) findViewById(r.g.beautify_btn);
        this.fEj = (RadioButton) findViewById(r.g.rotate_btn);
        this.fEi.setOnCheckedChangeListener(this);
        this.fEj.setOnCheckedChangeListener(this);
        this.fEk = (LinearLayout) findViewById(r.g.filters_layout);
        this.fEl = findViewById(r.g.rotate);
        Button button = (Button) findViewById(r.g.rotate_left);
        Button button2 = (Button) findViewById(r.g.rotate_right);
        Button button3 = (Button) findViewById(r.g.rotate_left_right);
        Button button4 = (Button) findViewById(r.g.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        bz bzVar = new bz(this);
        button.setOnClickListener(bzVar);
        button2.setOnClickListener(bzVar);
        button3.setOnClickListener(bzVar);
        button4.setOnClickListener(bzVar);
        this.aWS = (NavigationBar) findViewById(r.g.write_multi_imgs_navibar);
        this.fEv = this.aWS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ca(this));
        this.fEm = this.aWS.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(r.j.done), new cb(this));
        this.MK = this.aWS.setTitleText(getPageContext().getString(r.j.beautify));
        this.fEi.setChecked(true);
        if (!this.fEr) {
            this.fEj.setChecked(true);
            this.fEj.setPadding(0, this.fEj.getPaddingTop(), this.fEj.getPaddingRight(), this.fEj.getPaddingBottom());
            this.fEk.setVisibility(8);
            this.fEi.setVisibility(8);
            this.Hv.setVisibility(8);
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
            this.fEe = new WriteImagesInfo();
            this.fEe.parseJson(str);
            bnL();
            this.fEg = new r(this, this.fEf, this.fEe.getChosedFiles(), i, this);
            this.fEf.setAdapter(this.fEg);
            this.fEf.setCurrentItem(i, true);
            if (i == 0) {
                this.fEg.onPageSelected(0);
            }
            this.fEh.setVisibility(0);
        }
    }

    private void bnL() {
        if (this.fEe != null && this.fEe.isOriginalImg() && this.fEe.getChosedFiles() != null && this.fEe.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.fEe.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.fEt.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bnM() {
        if (this.fEe == null || !this.fEe.isOriginalImg() || this.fEe.getChosedFiles() == null || this.fEe.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.fEe.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.fEt.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void bnc() {
        if (this.aWS.getVisibility() == 0) {
            this.aWS.setVisibility(8);
            this.fEh.setVisibility(8);
            return;
        }
        this.aWS.setVisibility(0);
        this.fEh.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void a(com.baidu.tbadk.coreExtra.view.c cVar, int i) {
        this.fEk.removeAllViews();
        this.fEk.addView(cVar);
        this.fEq = "（" + (i + 1) + "/" + this.fEe.size() + "）";
        this.MK.setText(String.valueOf(this.fEp) + this.fEq);
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void bne() {
        this.fEw--;
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void bnd() {
        this.fEw++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bnN() {
        this.fEu++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bnO() {
        this.fEu--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnP() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.fEe.toJsonString());
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
            if (compoundButton == this.fEi) {
                this.fEk.setVisibility(0);
                this.fEl.setVisibility(8);
                this.fEp = this.fEn;
                this.MK.setText(String.valueOf(this.fEp) + this.fEq);
                return;
            }
            this.fEk.setVisibility(8);
            this.fEl.setVisibility(0);
            this.fEp = this.fEo;
            this.MK.setText(String.valueOf(this.fEp) + this.fEq);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ai(i == 1);
        getLayoutMode().x(this.aAK);
        avt();
    }

    private void avt() {
        com.baidu.tbadk.core.util.ar.l(this.aWS, r.d.common_color_10222);
        com.baidu.tbadk.core.util.ar.c(this.MK, r.d.cp_cont_g, 1);
        com.baidu.tbadk.core.util.ar.a(this.aWS.getBackImageView(), r.f.icon_return_s, r.f.icon_return_s_w, 0);
        com.baidu.tbadk.core.util.ar.c(this.fEm, r.d.cp_cont_g, 1);
    }
}
