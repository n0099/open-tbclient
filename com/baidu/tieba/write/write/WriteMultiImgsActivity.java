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
public class WriteMultiImgsActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, w {
    private WriteImagesInfo cyr = null;
    private View rootView = null;
    private ViewPager anv = null;
    private v cys = null;
    private LinearLayout cyt = null;
    private RadioGroup MI = null;
    private RadioButton cyu = null;
    private RadioButton cyv = null;
    private LinearLayout cyw = null;
    private View cyx = null;
    private NavigationBar anm = null;
    private TextView aBm = null;
    private TextView cyy = null;
    private String cyz = "";
    private String cyA = "";
    private String cyB = "";
    private String cyC = "(1/1)";
    private boolean cyD = true;
    private int cyE = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int ag = com.baidu.adp.lib.b.f.gz().ag("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || ag == 1 || PluginPackageManager.ls().br(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.cyD = false;
        } else {
            this.cyD = true;
        }
        setContentView(com.baidu.tieba.w.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.cyD) {
            if (this.cyr != null) {
                i = this.cyr.size();
                i2 = this.cyr.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m411getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.cys.getCurrentIndex());
        this.cys.aqO();
        bundle.putString("OutState_Write_Img_Info", this.cyr.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.cyz = getResources().getString(com.baidu.tieba.y.beautify);
        this.cyA = getResources().getString(com.baidu.tieba.y.rotate);
        this.cyB = this.cyz;
        this.rootView = findViewById(com.baidu.tieba.v.write_multi_imgs_rootlayout);
        this.anv = (ViewPager) findViewById(com.baidu.tieba.v.write_multi_imgs_viewpager);
        this.cyt = (LinearLayout) findViewById(com.baidu.tieba.v.write_multi_imgs_beautify);
        this.MI = (RadioGroup) findViewById(com.baidu.tieba.v.beautify_tabs);
        this.cyu = (RadioButton) findViewById(com.baidu.tieba.v.beautify_btn);
        this.cyv = (RadioButton) findViewById(com.baidu.tieba.v.rotate_btn);
        this.cyu.setOnCheckedChangeListener(this);
        this.cyv.setOnCheckedChangeListener(this);
        this.cyw = (LinearLayout) findViewById(com.baidu.tieba.v.filters_layout);
        this.cyx = findViewById(com.baidu.tieba.v.rotate);
        Button button = (Button) findViewById(com.baidu.tieba.v.rotate_left);
        Button button2 = (Button) findViewById(com.baidu.tieba.v.rotate_right);
        Button button3 = (Button) findViewById(com.baidu.tieba.v.rotate_left_right);
        Button button4 = (Button) findViewById(com.baidu.tieba.v.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        cj cjVar = new cj(this);
        button.setOnClickListener(cjVar);
        button2.setOnClickListener(cjVar);
        button3.setOnClickListener(cjVar);
        button4.setOnClickListener(cjVar);
        this.anm = (NavigationBar) findViewById(com.baidu.tieba.v.write_multi_imgs_navibar);
        this.anm.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ck(this));
        this.cyy = this.anm.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.y.done), new cl(this));
        this.aBm = this.anm.setTitleText(getPageContext().getString(com.baidu.tieba.y.beautify));
        this.cyu.setChecked(true);
        if (!this.cyD) {
            this.cyv.setChecked(true);
            this.cyv.setPadding(0, this.cyv.getPaddingTop(), this.cyv.getPaddingRight(), this.cyv.getPaddingBottom());
            this.cyw.setVisibility(8);
            this.cyu.setVisibility(8);
            this.MI.setVisibility(8);
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
            this.cyr = new WriteImagesInfo();
            this.cyr.parseJson(str);
            this.cys = new v(this, this.anv, this.cyr.getChosedFiles(), i, this);
            this.anv.setAdapter(this.cys);
            this.anv.setCurrentItem(i, true);
            if (i == 0) {
                this.cys.onPageSelected(0);
            }
            this.cyt.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.write.write.w
    public void aqP() {
        if (this.anm.getVisibility() == 0) {
            this.anm.setVisibility(8);
            this.cyt.setVisibility(8);
            return;
        }
        this.anm.setVisibility(0);
        this.cyt.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.w
    public void a(com.baidu.tbadk.coreExtra.view.j jVar, int i) {
        this.cyw.removeAllViews();
        this.cyw.addView(jVar);
        this.cyC = "（" + (i + 1) + "/" + this.cyr.size() + "）";
        this.aBm.setText(String.valueOf(this.cyB) + this.cyC);
    }

    @Override // com.baidu.tieba.write.write.w
    public void aqR() {
        this.cyE--;
    }

    @Override // com.baidu.tieba.write.write.w
    public void aqQ() {
        this.cyE++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ars() {
        this.cys.aqO();
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.cyr.toJsonString());
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
            if (compoundButton == this.cyu) {
                this.cyw.setVisibility(0);
                this.cyx.setVisibility(8);
                this.cyB = this.cyz;
                this.aBm.setText(String.valueOf(this.cyB) + this.cyC);
                return;
            }
            this.cyw.setVisibility(8);
            this.cyx.setVisibility(0);
            this.cyB = this.cyA;
            this.aBm.setText(String.valueOf(this.cyB) + this.cyC);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().X(i == 1);
        getLayoutMode().h(this.rootView);
        this.anm.onChangeSkinType(getPageContext(), i);
        if (this.cyy.isEnabled()) {
            com.baidu.tbadk.core.util.ba.i((View) this.cyy, com.baidu.tieba.u.navi_done_text_bg);
            com.baidu.tbadk.core.util.ba.b(this.cyy, com.baidu.tieba.s.navi_done_text, 1);
            return;
        }
        com.baidu.tbadk.core.util.ba.i((View) this.cyy, com.baidu.tieba.u.btn_titlebar_finish_d);
        com.baidu.tbadk.core.util.ba.b(this.cyy, com.baidu.tieba.s.navi_done_text_d, 1);
    }
}
