package com.baidu.tieba.write;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
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
public class WriteMultiImgsActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, s {
    private WriteImagesInfo chh = null;
    private View rootView = null;
    private ViewPager afb = null;
    private r chi = null;
    private LinearLayout chj = null;
    private RadioButton chk = null;
    private RadioButton chl = null;
    private LinearLayout chm = null;
    private View chn = null;
    private NavigationBar aeS = null;
    private TextView cho = null;
    private TextView chp = null;
    private String chq = "";
    private String chr = "";
    private String chs = "";
    private String cht = "(1/1)";
    private boolean chu = true;
    private int chv = 0;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(WriteMulitImageActivityConfig.class, WriteMultiImgsActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        int Z = com.baidu.adp.lib.b.f.da().Z("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || Z == 1 || PluginPackageManager.hV().bj(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.chu = false;
        } else {
            this.chu = true;
        }
        setContentView(com.baidu.tieba.x.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.chu) {
            if (this.chh != null) {
                i = this.chh.size();
                i2 = this.chh.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m255getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.chi.getCurrentIndex());
        this.chi.akd();
        bundle.putString("OutState_Write_Img_Info", this.chh.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.chq = getResources().getString(com.baidu.tieba.z.beautify);
        this.chr = getResources().getString(com.baidu.tieba.z.rotate);
        this.chs = this.chq;
        this.rootView = findViewById(com.baidu.tieba.w.write_multi_imgs_rootlayout);
        this.afb = (ViewPager) findViewById(com.baidu.tieba.w.write_multi_imgs_viewpager);
        this.chj = (LinearLayout) findViewById(com.baidu.tieba.w.write_multi_imgs_beautify);
        this.chk = (RadioButton) findViewById(com.baidu.tieba.w.beautify_btn);
        this.chl = (RadioButton) findViewById(com.baidu.tieba.w.rotate_btn);
        this.chk.setOnCheckedChangeListener(this);
        this.chl.setOnCheckedChangeListener(this);
        this.chm = (LinearLayout) findViewById(com.baidu.tieba.w.filters_layout);
        this.chn = findViewById(com.baidu.tieba.w.rotate);
        Button button = (Button) findViewById(com.baidu.tieba.w.rotate_left);
        Button button2 = (Button) findViewById(com.baidu.tieba.w.rotate_right);
        Button button3 = (Button) findViewById(com.baidu.tieba.w.rotate_left_right);
        Button button4 = (Button) findViewById(com.baidu.tieba.w.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        ce ceVar = new ce(this);
        button.setOnClickListener(ceVar);
        button2.setOnClickListener(ceVar);
        button3.setOnClickListener(ceVar);
        button4.setOnClickListener(ceVar);
        this.aeS = (NavigationBar) findViewById(com.baidu.tieba.w.write_multi_imgs_navibar);
        this.aeS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new cf(this));
        this.chp = this.aeS.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.z.done), new cg(this));
        this.cho = this.aeS.setTitleText(getPageContext().getString(com.baidu.tieba.z.beautify));
        this.chk.setChecked(true);
        if (!this.chu) {
            this.chl.setChecked(true);
            this.chl.setPadding(0, this.chl.getPaddingTop(), this.chl.getPaddingRight(), this.chl.getPaddingBottom());
            this.chm.setVisibility(8);
            this.chk.setVisibility(8);
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
            this.chh = new WriteImagesInfo();
            this.chh.parseJson(str);
            this.chi = new r(this, this.afb, this.chh.getChosedFiles(), i, this);
            this.afb.setAdapter(this.chi);
            this.afb.setCurrentItem(i, true);
            if (i == 0) {
                this.chi.onPageSelected(0);
            }
            this.chj.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.write.s
    public void ake() {
        if (this.aeS.getVisibility() == 0) {
            this.aeS.setVisibility(8);
            this.chj.setVisibility(8);
            return;
        }
        this.aeS.setVisibility(0);
        this.chj.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.s
    public void a(com.baidu.tbadk.coreExtra.view.j jVar, int i) {
        this.chm.removeAllViews();
        this.chm.addView(jVar);
        this.cht = "（" + (i + 1) + "/" + this.chh.size() + "）";
        this.cho.setText(String.valueOf(this.chs) + this.cht);
    }

    @Override // com.baidu.tieba.write.s
    public void akg() {
        this.chv--;
    }

    @Override // com.baidu.tieba.write.s
    public void akf() {
        this.chv++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akJ() {
        this.chi.akd();
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.chh.toJsonString());
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
            if (compoundButton == this.chk) {
                this.chm.setVisibility(0);
                this.chn.setVisibility(8);
                this.chs = this.chq;
                this.cho.setText(String.valueOf(this.chs) + this.cht);
                return;
            }
            this.chm.setVisibility(8);
            this.chn.setVisibility(0);
            this.chs = this.chr;
            this.cho.setText(String.valueOf(this.chs) + this.cht);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(this.rootView);
        this.aeS.onChangeSkinType(getPageContext(), i);
        if (this.chp.isEnabled()) {
            com.baidu.tbadk.core.util.bc.i((View) this.chp, com.baidu.tieba.v.navi_done_text_bg);
            com.baidu.tbadk.core.util.bc.b(this.chp, com.baidu.tieba.t.navi_done_text, 1);
            return;
        }
        com.baidu.tbadk.core.util.bc.i((View) this.chp, com.baidu.tieba.v.btn_titlebar_finish_d);
        com.baidu.tbadk.core.util.bc.b(this.chp, com.baidu.tieba.t.navi_done_text_d, 1);
    }
}
