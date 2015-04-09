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
    private WriteImagesInfo cyN = null;
    private View rootView = null;
    private ViewPager anD = null;
    private v cyO = null;
    private LinearLayout cyP = null;
    private RadioGroup MK = null;
    private RadioButton cyQ = null;
    private RadioButton cyR = null;
    private LinearLayout cyS = null;
    private View cyT = null;
    private NavigationBar anu = null;
    private TextView aBu = null;
    private TextView cyU = null;
    private String cyV = "";
    private String cyW = "";
    private String cyX = "";
    private String cyY = "(1/1)";
    private boolean cyZ = true;
    private int cza = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int ag = com.baidu.adp.lib.b.f.gz().ag("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || ag == 1 || PluginPackageManager.ls().br(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.cyZ = false;
        } else {
            this.cyZ = true;
        }
        setContentView(com.baidu.tieba.w.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.cyZ) {
            if (this.cyN != null) {
                i = this.cyN.size();
                i2 = this.cyN.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m411getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.cyO.getCurrentIndex());
        this.cyO.ard();
        bundle.putString("OutState_Write_Img_Info", this.cyN.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.cyV = getResources().getString(com.baidu.tieba.y.beautify);
        this.cyW = getResources().getString(com.baidu.tieba.y.rotate);
        this.cyX = this.cyV;
        this.rootView = findViewById(com.baidu.tieba.v.write_multi_imgs_rootlayout);
        this.anD = (ViewPager) findViewById(com.baidu.tieba.v.write_multi_imgs_viewpager);
        this.cyP = (LinearLayout) findViewById(com.baidu.tieba.v.write_multi_imgs_beautify);
        this.MK = (RadioGroup) findViewById(com.baidu.tieba.v.beautify_tabs);
        this.cyQ = (RadioButton) findViewById(com.baidu.tieba.v.beautify_btn);
        this.cyR = (RadioButton) findViewById(com.baidu.tieba.v.rotate_btn);
        this.cyQ.setOnCheckedChangeListener(this);
        this.cyR.setOnCheckedChangeListener(this);
        this.cyS = (LinearLayout) findViewById(com.baidu.tieba.v.filters_layout);
        this.cyT = findViewById(com.baidu.tieba.v.rotate);
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
        this.anu = (NavigationBar) findViewById(com.baidu.tieba.v.write_multi_imgs_navibar);
        this.anu.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ck(this));
        this.cyU = this.anu.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.y.done), new cl(this));
        this.aBu = this.anu.setTitleText(getPageContext().getString(com.baidu.tieba.y.beautify));
        this.cyQ.setChecked(true);
        if (!this.cyZ) {
            this.cyR.setChecked(true);
            this.cyR.setPadding(0, this.cyR.getPaddingTop(), this.cyR.getPaddingRight(), this.cyR.getPaddingBottom());
            this.cyS.setVisibility(8);
            this.cyQ.setVisibility(8);
            this.MK.setVisibility(8);
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
            this.cyN = new WriteImagesInfo();
            this.cyN.parseJson(str);
            this.cyO = new v(this, this.anD, this.cyN.getChosedFiles(), i, this);
            this.anD.setAdapter(this.cyO);
            this.anD.setCurrentItem(i, true);
            if (i == 0) {
                this.cyO.onPageSelected(0);
            }
            this.cyP.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.write.write.w
    public void are() {
        if (this.anu.getVisibility() == 0) {
            this.anu.setVisibility(8);
            this.cyP.setVisibility(8);
            return;
        }
        this.anu.setVisibility(0);
        this.cyP.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.w
    public void a(com.baidu.tbadk.coreExtra.view.j jVar, int i) {
        this.cyS.removeAllViews();
        this.cyS.addView(jVar);
        this.cyY = "（" + (i + 1) + "/" + this.cyN.size() + "）";
        this.aBu.setText(String.valueOf(this.cyX) + this.cyY);
    }

    @Override // com.baidu.tieba.write.write.w
    public void arg() {
        this.cza--;
    }

    @Override // com.baidu.tieba.write.write.w
    public void arf() {
        this.cza++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arH() {
        this.cyO.ard();
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.cyN.toJsonString());
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
            if (compoundButton == this.cyQ) {
                this.cyS.setVisibility(0);
                this.cyT.setVisibility(8);
                this.cyX = this.cyV;
                this.aBu.setText(String.valueOf(this.cyX) + this.cyY);
                return;
            }
            this.cyS.setVisibility(8);
            this.cyT.setVisibility(0);
            this.cyX = this.cyW;
            this.aBu.setText(String.valueOf(this.cyX) + this.cyY);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().X(i == 1);
        getLayoutMode().h(this.rootView);
        this.anu.onChangeSkinType(getPageContext(), i);
        if (this.cyU.isEnabled()) {
            com.baidu.tbadk.core.util.ba.i((View) this.cyU, com.baidu.tieba.u.navi_done_text_bg);
            com.baidu.tbadk.core.util.ba.b(this.cyU, com.baidu.tieba.s.navi_done_text, 1);
            return;
        }
        com.baidu.tbadk.core.util.ba.i((View) this.cyU, com.baidu.tieba.u.btn_titlebar_finish_d);
        com.baidu.tbadk.core.util.ba.b(this.cyU, com.baidu.tieba.s.navi_done_text_d, 1);
    }
}
