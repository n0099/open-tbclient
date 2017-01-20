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
import com.baidu.tieba.write.write.q;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class WriteMultiImgsActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, q.a {
    private com.baidu.tbadk.core.dialog.a fMM;
    private View fMP;
    private WriteImagesInfo fMz = null;
    private View rootView = null;
    private ViewPager bdu = null;
    private q fMA = null;
    private LinearLayout fMB = null;
    private RadioGroup GF = null;
    private RadioButton fMC = null;
    private RadioButton fMD = null;
    private LinearLayout fME = null;
    private View fMF = null;
    private NavigationBar aSs = null;
    private TextView LX = null;
    private TextView fMG = null;
    private String fMH = "";
    private String fMI = "";
    private String fMJ = "";
    private String fMK = "(1/1)";
    private boolean fML = true;
    private HashMap<String, String> fMN = new HashMap<>();
    private int fMO = 0;
    private int fMQ = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int ac = com.baidu.adp.lib.b.e.dL().ac("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || ac == 1 || PluginPackageManager.iz().bt(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.fML = false;
        } else {
            this.fML = true;
        }
        setContentView(r.j.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.fML) {
            if (this.fMz != null) {
                i = this.fMz.size();
                i2 = this.fMz.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m9getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.fMA.getCurrentIndex());
        this.fMA.boz();
        bundle.putString("OutState_Write_Img_Info", this.fMz.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.fMH = getResources().getString(r.l.beautify);
        this.fMI = getResources().getString(r.l.rotate);
        this.fMJ = this.fMH;
        this.rootView = findViewById(r.h.write_multi_imgs_rootlayout);
        this.bdu = (ViewPager) findViewById(r.h.write_multi_imgs_viewpager);
        this.fMB = (LinearLayout) findViewById(r.h.write_multi_imgs_beautify);
        this.GF = (RadioGroup) findViewById(r.h.beautify_tabs);
        this.fMC = (RadioButton) findViewById(r.h.beautify_btn);
        this.fMD = (RadioButton) findViewById(r.h.rotate_btn);
        this.fMC.setOnCheckedChangeListener(this);
        this.fMD.setOnCheckedChangeListener(this);
        this.fME = (LinearLayout) findViewById(r.h.filters_layout);
        this.fMF = findViewById(r.h.rotate);
        Button button = (Button) findViewById(r.h.rotate_left);
        Button button2 = (Button) findViewById(r.h.rotate_right);
        Button button3 = (Button) findViewById(r.h.rotate_left_right);
        Button button4 = (Button) findViewById(r.h.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        by byVar = new by(this);
        button.setOnClickListener(byVar);
        button2.setOnClickListener(byVar);
        button3.setOnClickListener(byVar);
        button4.setOnClickListener(byVar);
        this.aSs = (NavigationBar) findViewById(r.h.write_multi_imgs_navibar);
        this.fMP = this.aSs.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bz(this));
        this.fMG = this.aSs.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(r.l.done), new ca(this));
        this.LX = this.aSs.setTitleText(getPageContext().getString(r.l.beautify));
        this.fMC.setChecked(true);
        if (!this.fML) {
            this.fMD.setChecked(true);
            this.fMD.setPadding(0, this.fMD.getPaddingTop(), this.fMD.getPaddingRight(), this.fMD.getPaddingBottom());
            this.fME.setVisibility(8);
            this.fMC.setVisibility(8);
            this.GF.setVisibility(8);
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
            this.fMz = new WriteImagesInfo();
            this.fMz.parseJson(str);
            bpj();
            this.fMA = new q(this, this.bdu, this.fMz.getChosedFiles(), i, this);
            this.bdu.setAdapter(this.fMA);
            this.bdu.setCurrentItem(i, true);
            if (i == 0) {
                this.fMA.onPageSelected(0);
            }
            this.fMB.setVisibility(0);
        }
    }

    private void bpj() {
        if (this.fMz != null && this.fMz.isOriginalImg() && this.fMz.getChosedFiles() != null && this.fMz.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.fMz.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.fMN.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bpk() {
        if (this.fMz == null || !this.fMz.isOriginalImg() || this.fMz.getChosedFiles() == null || this.fMz.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.fMz.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.fMN.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void boA() {
        if (this.aSs.getVisibility() == 0) {
            this.aSs.setVisibility(8);
            this.fMB.setVisibility(8);
            return;
        }
        this.aSs.setVisibility(0);
        this.fMB.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void a(com.baidu.tbadk.coreExtra.view.c cVar, int i) {
        this.fME.removeAllViews();
        this.fME.addView(cVar);
        this.fMK = "（" + (i + 1) + "/" + this.fMz.size() + "）";
        this.LX.setText(String.valueOf(this.fMJ) + this.fMK);
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void boC() {
        this.fMQ--;
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void boB() {
        this.fMQ++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bpl() {
        this.fMO++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bpm() {
        this.fMO--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpn() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.fMz.toJsonString());
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
            if (compoundButton == this.fMC) {
                this.fME.setVisibility(0);
                this.fMF.setVisibility(8);
                this.fMJ = this.fMH;
                this.LX.setText(String.valueOf(this.fMJ) + this.fMK);
                return;
            }
            this.fME.setVisibility(8);
            this.fMF.setVisibility(0);
            this.fMJ = this.fMI;
            this.LX.setText(String.valueOf(this.fMJ) + this.fMK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ai(i == 1);
        getLayoutMode().v(this.rootView);
        awA();
    }

    private void awA() {
        com.baidu.tbadk.core.util.ap.k(this.aSs, r.e.common_color_10222);
        com.baidu.tbadk.core.util.ap.c(this.LX, r.e.cp_cont_g, 1);
        com.baidu.tbadk.core.util.ap.a(this.aSs.getBackImageView(), r.g.icon_return_s, r.g.icon_return_s_w, 0);
        com.baidu.tbadk.core.util.ap.c(this.fMG, r.e.cp_cont_g, 1);
    }
}
