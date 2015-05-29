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
/* loaded from: classes.dex */
public class WriteMultiImgsActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, x {
    private WriteImagesInfo cDf = null;
    private View rootView = null;
    private ViewPager aoG = null;
    private w cDg = null;
    private LinearLayout cDh = null;
    private RadioGroup MG = null;
    private RadioButton cDi = null;
    private RadioButton cDj = null;
    private LinearLayout cDk = null;
    private View cDl = null;
    private NavigationBar aox = null;
    private TextView aDp = null;
    private TextView cDm = null;
    private String cDn = "";
    private String cDo = "";
    private String cDp = "";
    private String cDq = "(1/1)";
    private boolean cDr = true;
    private int cDs = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int ai = com.baidu.adp.lib.b.f.gD().ai("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || ai == 1 || PluginPackageManager.lM().bB(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.cDr = false;
        } else {
            this.cDr = true;
        }
        setContentView(com.baidu.tieba.r.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.cDr) {
            if (this.cDf != null) {
                i = this.cDf.size();
                i2 = this.cDf.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m411getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.cDg.getCurrentIndex());
        this.cDg.asT();
        bundle.putString("OutState_Write_Img_Info", this.cDf.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.cDn = getResources().getString(com.baidu.tieba.t.beautify);
        this.cDo = getResources().getString(com.baidu.tieba.t.rotate);
        this.cDp = this.cDn;
        this.rootView = findViewById(com.baidu.tieba.q.write_multi_imgs_rootlayout);
        this.aoG = (ViewPager) findViewById(com.baidu.tieba.q.write_multi_imgs_viewpager);
        this.cDh = (LinearLayout) findViewById(com.baidu.tieba.q.write_multi_imgs_beautify);
        this.MG = (RadioGroup) findViewById(com.baidu.tieba.q.beautify_tabs);
        this.cDi = (RadioButton) findViewById(com.baidu.tieba.q.beautify_btn);
        this.cDj = (RadioButton) findViewById(com.baidu.tieba.q.rotate_btn);
        this.cDi.setOnCheckedChangeListener(this);
        this.cDj.setOnCheckedChangeListener(this);
        this.cDk = (LinearLayout) findViewById(com.baidu.tieba.q.filters_layout);
        this.cDl = findViewById(com.baidu.tieba.q.rotate);
        Button button = (Button) findViewById(com.baidu.tieba.q.rotate_left);
        Button button2 = (Button) findViewById(com.baidu.tieba.q.rotate_right);
        Button button3 = (Button) findViewById(com.baidu.tieba.q.rotate_left_right);
        Button button4 = (Button) findViewById(com.baidu.tieba.q.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        ck ckVar = new ck(this);
        button.setOnClickListener(ckVar);
        button2.setOnClickListener(ckVar);
        button3.setOnClickListener(ckVar);
        button4.setOnClickListener(ckVar);
        this.aox = (NavigationBar) findViewById(com.baidu.tieba.q.write_multi_imgs_navibar);
        this.aox.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new cl(this));
        this.cDm = this.aox.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.t.done), new cm(this));
        this.aDp = this.aox.setTitleText(getPageContext().getString(com.baidu.tieba.t.beautify));
        this.cDi.setChecked(true);
        if (!this.cDr) {
            this.cDj.setChecked(true);
            this.cDj.setPadding(0, this.cDj.getPaddingTop(), this.cDj.getPaddingRight(), this.cDj.getPaddingBottom());
            this.cDk.setVisibility(8);
            this.cDi.setVisibility(8);
            this.MG.setVisibility(8);
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
            this.cDf = new WriteImagesInfo();
            this.cDf.parseJson(str);
            this.cDg = new w(this, this.aoG, this.cDf.getChosedFiles(), i, this);
            this.aoG.setAdapter(this.cDg);
            this.aoG.setCurrentItem(i, true);
            if (i == 0) {
                this.cDg.onPageSelected(0);
            }
            this.cDh.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.write.write.x
    public void asU() {
        if (this.aox.getVisibility() == 0) {
            this.aox.setVisibility(8);
            this.cDh.setVisibility(8);
            return;
        }
        this.aox.setVisibility(0);
        this.cDh.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.x
    public void a(com.baidu.tbadk.coreExtra.view.j jVar, int i) {
        this.cDk.removeAllViews();
        this.cDk.addView(jVar);
        this.cDq = "（" + (i + 1) + "/" + this.cDf.size() + "）";
        this.aDp.setText(String.valueOf(this.cDp) + this.cDq);
    }

    @Override // com.baidu.tieba.write.write.x
    public void asW() {
        this.cDs--;
    }

    @Override // com.baidu.tieba.write.write.x
    public void asV() {
        this.cDs++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atx() {
        this.cDg.asT();
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.cDf.toJsonString());
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
            if (compoundButton == this.cDi) {
                this.cDk.setVisibility(0);
                this.cDl.setVisibility(8);
                this.cDp = this.cDn;
                this.aDp.setText(String.valueOf(this.cDp) + this.cDq);
                return;
            }
            this.cDk.setVisibility(8);
            this.cDl.setVisibility(0);
            this.cDp = this.cDo;
            this.aDp.setText(String.valueOf(this.cDp) + this.cDq);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ab(i == 1);
        getLayoutMode().j(this.rootView);
        this.aox.onChangeSkinType(getPageContext(), i);
        if (this.cDm.isEnabled()) {
            com.baidu.tbadk.core.util.ay.i((View) this.cDm, com.baidu.tieba.p.navi_done_text_bg);
            com.baidu.tbadk.core.util.ay.b(this.cDm, com.baidu.tieba.n.navi_done_text, 1);
            return;
        }
        com.baidu.tbadk.core.util.ay.i((View) this.cDm, com.baidu.tieba.p.btn_titlebar_finish_d);
        com.baidu.tbadk.core.util.ay.b(this.cDm, com.baidu.tieba.n.navi_done_text_d, 1);
    }
}
