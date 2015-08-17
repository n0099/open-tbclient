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
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.i;
import com.baidu.tieba.write.write.q;
/* loaded from: classes.dex */
public class WriteMultiImgsActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, q.a {
    private WriteImagesInfo cUZ = null;
    private View rootView = null;
    private ViewPager bVT = null;
    private q cVa = null;
    private LinearLayout cVb = null;
    private RadioGroup MU = null;
    private RadioButton cVc = null;
    private RadioButton cVd = null;
    private LinearLayout cVe = null;
    private View cVf = null;
    private NavigationBar aIc = null;
    private TextView aKN = null;
    private TextView cVg = null;
    private String cVh = "";
    private String cVi = "";
    private String cVj = "";
    private String cVk = "(1/1)";
    private boolean cVl = true;
    private int cVm = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int ah = com.baidu.adp.lib.b.e.gy().ah("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || ah == 1 || PluginPackageManager.lT().bv(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.cVl = false;
        } else {
            this.cVl = true;
        }
        setContentView(i.g.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.cVl) {
            if (this.cUZ != null) {
                i = this.cUZ.size();
                i2 = this.cUZ.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m411getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.cVa.getCurrentIndex());
        this.cVa.auL();
        bundle.putString("OutState_Write_Img_Info", this.cUZ.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.cVh = getResources().getString(i.C0057i.beautify);
        this.cVi = getResources().getString(i.C0057i.rotate);
        this.cVj = this.cVh;
        this.rootView = findViewById(i.f.write_multi_imgs_rootlayout);
        this.bVT = (ViewPager) findViewById(i.f.write_multi_imgs_viewpager);
        this.cVb = (LinearLayout) findViewById(i.f.write_multi_imgs_beautify);
        this.MU = (RadioGroup) findViewById(i.f.beautify_tabs);
        this.cVc = (RadioButton) findViewById(i.f.beautify_btn);
        this.cVd = (RadioButton) findViewById(i.f.rotate_btn);
        this.cVc.setOnCheckedChangeListener(this);
        this.cVd.setOnCheckedChangeListener(this);
        this.cVe = (LinearLayout) findViewById(i.f.filters_layout);
        this.cVf = findViewById(i.f.rotate);
        Button button = (Button) findViewById(i.f.rotate_left);
        Button button2 = (Button) findViewById(i.f.rotate_right);
        Button button3 = (Button) findViewById(i.f.rotate_left_right);
        Button button4 = (Button) findViewById(i.f.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        bu buVar = new bu(this);
        button.setOnClickListener(buVar);
        button2.setOnClickListener(buVar);
        button3.setOnClickListener(buVar);
        button4.setOnClickListener(buVar);
        this.aIc = (NavigationBar) findViewById(i.f.write_multi_imgs_navibar);
        this.aIc.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bv(this));
        this.cVg = this.aIc.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(i.C0057i.done), new bw(this));
        this.aKN = this.aIc.setTitleText(getPageContext().getString(i.C0057i.beautify));
        this.cVc.setChecked(true);
        if (!this.cVl) {
            this.cVd.setChecked(true);
            this.cVd.setPadding(0, this.cVd.getPaddingTop(), this.cVd.getPaddingRight(), this.cVd.getPaddingBottom());
            this.cVe.setVisibility(8);
            this.cVc.setVisibility(8);
            this.MU.setVisibility(8);
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
            this.cUZ = new WriteImagesInfo();
            this.cUZ.parseJson(str);
            this.cVa = new q(this, this.bVT, this.cUZ.getChosedFiles(), i, this);
            this.bVT.setAdapter(this.cVa);
            this.bVT.setCurrentItem(i, true);
            if (i == 0) {
                this.cVa.onPageSelected(0);
            }
            this.cVb.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void auM() {
        if (this.aIc.getVisibility() == 0) {
            this.aIc.setVisibility(8);
            this.cVb.setVisibility(8);
            return;
        }
        this.aIc.setVisibility(0);
        this.cVb.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void a(com.baidu.tbadk.coreExtra.view.d dVar, int i) {
        this.cVe.removeAllViews();
        this.cVe.addView(dVar);
        this.cVk = "（" + (i + 1) + "/" + this.cUZ.size() + "）";
        this.aKN.setText(String.valueOf(this.cVj) + this.cVk);
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void auO() {
        this.cVm--;
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void auN() {
        this.cVm++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avr() {
        this.cVa.auL();
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.cUZ.toJsonString());
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
            if (compoundButton == this.cVc) {
                this.cVe.setVisibility(0);
                this.cVf.setVisibility(8);
                this.cVj = this.cVh;
                this.aKN.setText(String.valueOf(this.cVj) + this.cVk);
                return;
            }
            this.cVe.setVisibility(8);
            this.cVf.setVisibility(0);
            this.cVj = this.cVi;
            this.aKN.setText(String.valueOf(this.cVj) + this.cVk);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.rootView);
        this.aIc.onChangeSkinType(getPageContext(), i);
        if (this.cVg.isEnabled()) {
            com.baidu.tbadk.core.util.al.i((View) this.cVg, i.e.navi_done_text_bg);
            com.baidu.tbadk.core.util.al.b(this.cVg, i.c.navi_done_text, 1);
            return;
        }
        com.baidu.tbadk.core.util.al.i((View) this.cVg, i.e.btn_titlebar_finish_d);
        com.baidu.tbadk.core.util.al.b(this.cVg, i.c.navi_done_text_d, 1);
    }
}
