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
    private WriteImagesInfo ded = null;
    private View rootView = null;
    private ViewPager bWz = null;
    private q dee = null;
    private LinearLayout def = null;
    private RadioGroup MS = null;
    private RadioButton deg = null;
    private RadioButton deh = null;
    private LinearLayout dei = null;
    private View dej = null;
    private NavigationBar aIp = null;
    private TextView aLa = null;
    private TextView dek = null;
    private String del = "";
    private String dem = "";
    private String den = "";
    private String deo = "(1/1)";
    private boolean dep = true;
    private int deq = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int ah = com.baidu.adp.lib.b.e.gv().ah("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || ah == 1 || PluginPackageManager.lQ().bv(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.dep = false;
        } else {
            this.dep = true;
        }
        setContentView(i.g.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.dep) {
            if (this.ded != null) {
                i = this.ded.size();
                i2 = this.ded.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m411getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.dee.getCurrentIndex());
        this.dee.azj();
        bundle.putString("OutState_Write_Img_Info", this.ded.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.del = getResources().getString(i.h.beautify);
        this.dem = getResources().getString(i.h.rotate);
        this.den = this.del;
        this.rootView = findViewById(i.f.write_multi_imgs_rootlayout);
        this.bWz = (ViewPager) findViewById(i.f.write_multi_imgs_viewpager);
        this.def = (LinearLayout) findViewById(i.f.write_multi_imgs_beautify);
        this.MS = (RadioGroup) findViewById(i.f.beautify_tabs);
        this.deg = (RadioButton) findViewById(i.f.beautify_btn);
        this.deh = (RadioButton) findViewById(i.f.rotate_btn);
        this.deg.setOnCheckedChangeListener(this);
        this.deh.setOnCheckedChangeListener(this);
        this.dei = (LinearLayout) findViewById(i.f.filters_layout);
        this.dej = findViewById(i.f.rotate);
        Button button = (Button) findViewById(i.f.rotate_left);
        Button button2 = (Button) findViewById(i.f.rotate_right);
        Button button3 = (Button) findViewById(i.f.rotate_left_right);
        Button button4 = (Button) findViewById(i.f.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        by byVar = new by(this);
        button.setOnClickListener(byVar);
        button2.setOnClickListener(byVar);
        button3.setOnClickListener(byVar);
        button4.setOnClickListener(byVar);
        this.aIp = (NavigationBar) findViewById(i.f.write_multi_imgs_navibar);
        this.aIp.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bz(this));
        this.dek = this.aIp.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(i.h.done), new ca(this));
        this.aLa = this.aIp.setTitleText(getPageContext().getString(i.h.beautify));
        this.deg.setChecked(true);
        if (!this.dep) {
            this.deh.setChecked(true);
            this.deh.setPadding(0, this.deh.getPaddingTop(), this.deh.getPaddingRight(), this.deh.getPaddingBottom());
            this.dei.setVisibility(8);
            this.deg.setVisibility(8);
            this.MS.setVisibility(8);
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
            this.ded = new WriteImagesInfo();
            this.ded.parseJson(str);
            this.dee = new q(this, this.bWz, this.ded.getChosedFiles(), i, this);
            this.bWz.setAdapter(this.dee);
            this.bWz.setCurrentItem(i, true);
            if (i == 0) {
                this.dee.onPageSelected(0);
            }
            this.def.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void azk() {
        if (this.aIp.getVisibility() == 0) {
            this.aIp.setVisibility(8);
            this.def.setVisibility(8);
            return;
        }
        this.aIp.setVisibility(0);
        this.def.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void a(com.baidu.tbadk.coreExtra.view.d dVar, int i) {
        this.dei.removeAllViews();
        this.dei.addView(dVar);
        this.deo = "（" + (i + 1) + "/" + this.ded.size() + "）";
        this.aLa.setText(String.valueOf(this.den) + this.deo);
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void azm() {
        this.deq--;
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void azl() {
        this.deq++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azX() {
        this.dee.azj();
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.ded.toJsonString());
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
            if (compoundButton == this.deg) {
                this.dei.setVisibility(0);
                this.dej.setVisibility(8);
                this.den = this.del;
                this.aLa.setText(String.valueOf(this.den) + this.deo);
                return;
            }
            this.dei.setVisibility(8);
            this.dej.setVisibility(0);
            this.den = this.dem;
            this.aLa.setText(String.valueOf(this.den) + this.deo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.rootView);
        this.aIp.onChangeSkinType(getPageContext(), i);
        if (this.dek.isEnabled()) {
            com.baidu.tbadk.core.util.al.h((View) this.dek, i.e.navi_done_text_bg);
            com.baidu.tbadk.core.util.al.b(this.dek, i.c.navi_done_text, 1);
            return;
        }
        com.baidu.tbadk.core.util.al.h((View) this.dek, i.e.btn_titlebar_finish_d);
        com.baidu.tbadk.core.util.al.b(this.dek, i.c.navi_done_text_d, 1);
    }
}
