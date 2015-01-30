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
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
public class WriteMultiImgsActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, s {
    private WriteImagesInfo chi = null;
    private View rootView = null;
    private ViewPager afe = null;
    private r chj = null;
    private LinearLayout chk = null;
    private RadioButton chl = null;
    private RadioButton chm = null;
    private LinearLayout chn = null;
    private View cho = null;
    private NavigationBar aeV = null;
    private TextView chp = null;
    private TextView chq = null;
    private String chr = "";
    private String chs = "";
    private String cht = "";
    private String chu = "(1/1)";
    private boolean chv = true;
    private int chw = 0;

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
        if (Build.VERSION.SDK_INT < 7 || Z == 1 || PluginPackageManager.ic().bm("com.baidu.tieba.pluginMotu") == PluginPackageManager.PluginStatus.DISABLE) {
            this.chv = false;
        } else {
            this.chv = true;
        }
        setContentView(com.baidu.tieba.x.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.chv) {
            if (this.chi != null) {
                i = this.chi.size();
                i2 = this.chi.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m255getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.chj.getCurrentIndex());
        this.chj.aki();
        bundle.putString("OutState_Write_Img_Info", this.chi.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.chr = getResources().getString(com.baidu.tieba.z.beautify);
        this.chs = getResources().getString(com.baidu.tieba.z.rotate);
        this.cht = this.chr;
        this.rootView = findViewById(com.baidu.tieba.w.write_multi_imgs_rootlayout);
        this.afe = (ViewPager) findViewById(com.baidu.tieba.w.write_multi_imgs_viewpager);
        this.chk = (LinearLayout) findViewById(com.baidu.tieba.w.write_multi_imgs_beautify);
        this.chl = (RadioButton) findViewById(com.baidu.tieba.w.beautify_btn);
        this.chm = (RadioButton) findViewById(com.baidu.tieba.w.rotate_btn);
        this.chl.setOnCheckedChangeListener(this);
        this.chm.setOnCheckedChangeListener(this);
        this.chn = (LinearLayout) findViewById(com.baidu.tieba.w.filters_layout);
        this.cho = findViewById(com.baidu.tieba.w.rotate);
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
        this.aeV = (NavigationBar) findViewById(com.baidu.tieba.w.write_multi_imgs_navibar);
        this.aeV.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new cf(this));
        this.chq = this.aeV.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.z.done), new cg(this));
        this.chp = this.aeV.setTitleText(getPageContext().getString(com.baidu.tieba.z.beautify));
        this.chl.setChecked(true);
        if (!this.chv) {
            this.chm.setChecked(true);
            this.chm.setPadding(0, this.chm.getPaddingTop(), this.chm.getPaddingRight(), this.chm.getPaddingBottom());
            this.chn.setVisibility(8);
            this.chl.setVisibility(8);
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
            this.chi = new WriteImagesInfo();
            this.chi.parseJson(str);
            this.chj = new r(this, this.afe, this.chi.getChosedFiles(), i, this);
            this.afe.setAdapter(this.chj);
            this.afe.setCurrentItem(i, true);
            if (i == 0) {
                this.chj.onPageSelected(0);
            }
            this.chk.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.write.s
    public void akj() {
        if (this.aeV.getVisibility() == 0) {
            this.aeV.setVisibility(8);
            this.chk.setVisibility(8);
            return;
        }
        this.aeV.setVisibility(0);
        this.chk.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.s
    public void a(com.baidu.tbadk.coreExtra.view.j jVar, int i) {
        this.chn.removeAllViews();
        this.chn.addView(jVar);
        this.chu = "（" + (i + 1) + "/" + this.chi.size() + "）";
        this.chp.setText(String.valueOf(this.cht) + this.chu);
    }

    @Override // com.baidu.tieba.write.s
    public void akl() {
        this.chw--;
    }

    @Override // com.baidu.tieba.write.s
    public void akk() {
        this.chw++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akO() {
        this.chj.aki();
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.chi.toJsonString());
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
            if (compoundButton == this.chl) {
                this.chn.setVisibility(0);
                this.cho.setVisibility(8);
                this.cht = this.chr;
                this.chp.setText(String.valueOf(this.cht) + this.chu);
                return;
            }
            this.chn.setVisibility(8);
            this.cho.setVisibility(0);
            this.cht = this.chs;
            this.chp.setText(String.valueOf(this.cht) + this.chu);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(this.rootView);
        this.aeV.onChangeSkinType(getPageContext(), i);
        if (this.chq.isEnabled()) {
            com.baidu.tbadk.core.util.bc.i((View) this.chq, com.baidu.tieba.v.navi_done_text_bg);
            com.baidu.tbadk.core.util.bc.b(this.chq, com.baidu.tieba.t.navi_done_text, 1);
            return;
        }
        com.baidu.tbadk.core.util.bc.i((View) this.chq, com.baidu.tieba.v.btn_titlebar_finish_d);
        com.baidu.tbadk.core.util.bc.b(this.chq, com.baidu.tieba.t.navi_done_text_d, 1);
    }
}
