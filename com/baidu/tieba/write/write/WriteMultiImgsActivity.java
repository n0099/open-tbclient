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
    private WriteImagesInfo cDg = null;
    private View rootView = null;
    private ViewPager aoG = null;
    private w cDh = null;
    private LinearLayout cDi = null;
    private RadioGroup MG = null;
    private RadioButton cDj = null;
    private RadioButton cDk = null;
    private LinearLayout cDl = null;
    private View cDm = null;
    private NavigationBar aox = null;
    private TextView aDq = null;
    private TextView cDn = null;
    private String cDo = "";
    private String cDp = "";
    private String cDq = "";
    private String cDr = "(1/1)";
    private boolean cDs = true;
    private int cDt = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int ai = com.baidu.adp.lib.b.f.gD().ai("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || ai == 1 || PluginPackageManager.lM().bB(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.cDs = false;
        } else {
            this.cDs = true;
        }
        setContentView(com.baidu.tieba.r.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.cDs) {
            if (this.cDg != null) {
                i = this.cDg.size();
                i2 = this.cDg.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m411getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.cDh.getCurrentIndex());
        this.cDh.asU();
        bundle.putString("OutState_Write_Img_Info", this.cDg.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.cDo = getResources().getString(com.baidu.tieba.t.beautify);
        this.cDp = getResources().getString(com.baidu.tieba.t.rotate);
        this.cDq = this.cDo;
        this.rootView = findViewById(com.baidu.tieba.q.write_multi_imgs_rootlayout);
        this.aoG = (ViewPager) findViewById(com.baidu.tieba.q.write_multi_imgs_viewpager);
        this.cDi = (LinearLayout) findViewById(com.baidu.tieba.q.write_multi_imgs_beautify);
        this.MG = (RadioGroup) findViewById(com.baidu.tieba.q.beautify_tabs);
        this.cDj = (RadioButton) findViewById(com.baidu.tieba.q.beautify_btn);
        this.cDk = (RadioButton) findViewById(com.baidu.tieba.q.rotate_btn);
        this.cDj.setOnCheckedChangeListener(this);
        this.cDk.setOnCheckedChangeListener(this);
        this.cDl = (LinearLayout) findViewById(com.baidu.tieba.q.filters_layout);
        this.cDm = findViewById(com.baidu.tieba.q.rotate);
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
        this.cDn = this.aox.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.t.done), new cm(this));
        this.aDq = this.aox.setTitleText(getPageContext().getString(com.baidu.tieba.t.beautify));
        this.cDj.setChecked(true);
        if (!this.cDs) {
            this.cDk.setChecked(true);
            this.cDk.setPadding(0, this.cDk.getPaddingTop(), this.cDk.getPaddingRight(), this.cDk.getPaddingBottom());
            this.cDl.setVisibility(8);
            this.cDj.setVisibility(8);
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
            this.cDg = new WriteImagesInfo();
            this.cDg.parseJson(str);
            this.cDh = new w(this, this.aoG, this.cDg.getChosedFiles(), i, this);
            this.aoG.setAdapter(this.cDh);
            this.aoG.setCurrentItem(i, true);
            if (i == 0) {
                this.cDh.onPageSelected(0);
            }
            this.cDi.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.write.write.x
    public void asV() {
        if (this.aox.getVisibility() == 0) {
            this.aox.setVisibility(8);
            this.cDi.setVisibility(8);
            return;
        }
        this.aox.setVisibility(0);
        this.cDi.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.x
    public void a(com.baidu.tbadk.coreExtra.view.j jVar, int i) {
        this.cDl.removeAllViews();
        this.cDl.addView(jVar);
        this.cDr = "（" + (i + 1) + "/" + this.cDg.size() + "）";
        this.aDq.setText(String.valueOf(this.cDq) + this.cDr);
    }

    @Override // com.baidu.tieba.write.write.x
    public void asX() {
        this.cDt--;
    }

    @Override // com.baidu.tieba.write.write.x
    public void asW() {
        this.cDt++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aty() {
        this.cDh.asU();
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.cDg.toJsonString());
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
            if (compoundButton == this.cDj) {
                this.cDl.setVisibility(0);
                this.cDm.setVisibility(8);
                this.cDq = this.cDo;
                this.aDq.setText(String.valueOf(this.cDq) + this.cDr);
                return;
            }
            this.cDl.setVisibility(8);
            this.cDm.setVisibility(0);
            this.cDq = this.cDp;
            this.aDq.setText(String.valueOf(this.cDq) + this.cDr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ab(i == 1);
        getLayoutMode().j(this.rootView);
        this.aox.onChangeSkinType(getPageContext(), i);
        if (this.cDn.isEnabled()) {
            com.baidu.tbadk.core.util.ay.i((View) this.cDn, com.baidu.tieba.p.navi_done_text_bg);
            com.baidu.tbadk.core.util.ay.b(this.cDn, com.baidu.tieba.n.navi_done_text, 1);
            return;
        }
        com.baidu.tbadk.core.util.ay.i((View) this.cDn, com.baidu.tieba.p.btn_titlebar_finish_d);
        com.baidu.tbadk.core.util.ay.b(this.cDn, com.baidu.tieba.n.navi_done_text_d, 1);
    }
}
