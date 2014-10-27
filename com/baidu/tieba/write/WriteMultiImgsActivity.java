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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
/* loaded from: classes.dex */
public class WriteMultiImgsActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, s {
    private WriteImagesInfo bUk = null;
    private View Xi = null;
    private ViewPager bUl = null;
    private r bUm = null;
    private LinearLayout bUn = null;
    private RadioButton bUo = null;
    private RadioButton bUp = null;
    private LinearLayout bUq = null;
    private View bUr = null;
    private NavigationBar bhx = null;
    private TextView bUs = null;
    private TextView bUt = null;
    private String bUu = "";
    private String bUv = "";
    private String bUw = "";
    private String bUx = "(1/1)";
    private boolean bUy = true;
    private int bUz = 0;

    static {
        TbadkApplication.m251getInst().RegisterIntent(WriteMulitImageActivityConfig.class, WriteMultiImgsActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        int U = com.baidu.adp.lib.b.f.db().U("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || U == 1 || PluginCenter.getInstance().getNetConfigInfo(PluginNameList.NAME_MOTUSDK) == null) {
            this.bUy = false;
        } else {
            this.bUy = true;
        }
        setContentView(com.baidu.tieba.w.write_multi_imgs_activity);
        initUI();
        d(bundle);
        if (this.bUy) {
            if (this.bUk != null) {
                i = this.bUk.size();
                i2 = this.bUk.size();
            } else {
                i = 1;
            }
            TbadkApplication.m251getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.bUm.getCurrentIndex());
        this.bUm.afe();
        bundle.putString("OutState_Write_Img_Info", this.bUk.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.bUu = getResources().getString(com.baidu.tieba.y.beautify);
        this.bUv = getResources().getString(com.baidu.tieba.y.rotate);
        this.bUw = this.bUu;
        this.Xi = findViewById(com.baidu.tieba.v.write_multi_imgs_rootlayout);
        this.bUl = (ViewPager) findViewById(com.baidu.tieba.v.write_multi_imgs_viewpager);
        this.bUn = (LinearLayout) findViewById(com.baidu.tieba.v.write_multi_imgs_beautify);
        this.bUo = (RadioButton) findViewById(com.baidu.tieba.v.beautify_btn);
        this.bUp = (RadioButton) findViewById(com.baidu.tieba.v.rotate_btn);
        this.bUo.setOnCheckedChangeListener(this);
        this.bUp.setOnCheckedChangeListener(this);
        this.bUq = (LinearLayout) findViewById(com.baidu.tieba.v.filters_layout);
        this.bUr = findViewById(com.baidu.tieba.v.rotate);
        Button button = (Button) findViewById(com.baidu.tieba.v.rotate_left);
        Button button2 = (Button) findViewById(com.baidu.tieba.v.rotate_right);
        Button button3 = (Button) findViewById(com.baidu.tieba.v.rotate_left_right);
        Button button4 = (Button) findViewById(com.baidu.tieba.v.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        ce ceVar = new ce(this);
        button.setOnClickListener(ceVar);
        button2.setOnClickListener(ceVar);
        button3.setOnClickListener(ceVar);
        button4.setOnClickListener(ceVar);
        this.bhx = (NavigationBar) findViewById(com.baidu.tieba.v.write_multi_imgs_navibar);
        this.bhx.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new cf(this));
        this.bUt = this.bhx.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.y.done), new cg(this));
        this.bUs = this.bhx.setTitleText(getString(com.baidu.tieba.y.beautify));
        this.bUo.setChecked(true);
        if (!this.bUy) {
            this.bUp.setChecked(true);
            this.bUp.setPadding(0, this.bUp.getPaddingTop(), this.bUp.getPaddingRight(), this.bUp.getPaddingBottom());
            this.bUq.setVisibility(8);
            this.bUo.setVisibility(8);
        }
    }

    private void d(Bundle bundle) {
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
            this.bUk = new WriteImagesInfo();
            this.bUk.parseJson(str);
            this.bUm = new r(this, this.bUl, this.bUk.getChosedFiles(), i, this);
            this.bUl.setAdapter(this.bUm);
            this.bUl.setCurrentItem(i, true);
            if (i == 0) {
                this.bUm.onPageSelected(0);
            }
            this.bUn.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.write.s
    public void aff() {
        if (this.bhx.getVisibility() == 0) {
            this.bhx.setVisibility(8);
            this.bUn.setVisibility(8);
            return;
        }
        this.bhx.setVisibility(0);
        this.bUn.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.s
    public void a(com.baidu.tbadk.coreExtra.view.j jVar, int i) {
        this.bUq.removeAllViews();
        this.bUq.addView(jVar);
        this.bUx = "（" + (i + 1) + "/" + this.bUk.size() + "）";
        this.bUs.setText(String.valueOf(this.bUw) + this.bUx);
    }

    @Override // com.baidu.tieba.write.s
    public void afh() {
        this.bUz--;
    }

    @Override // com.baidu.tieba.write.s
    public void afg() {
        this.bUz++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afH() {
        this.bUm.afe();
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.bUk.toJsonString());
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
            if (compoundButton == this.bUo) {
                this.bUq.setVisibility(0);
                this.bUr.setVisibility(8);
                this.bUw = this.bUu;
                this.bUs.setText(String.valueOf(this.bUw) + this.bUx);
                return;
            }
            this.bUq.setVisibility(8);
            this.bUr.setVisibility(0);
            this.bUw = this.bUv;
            this.bUs.setText(String.valueOf(this.bUw) + this.bUx);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().L(i == 1);
        getLayoutMode().h(this.Xi);
        this.bhx.onChangeSkinType(i);
        if (this.bUt.isEnabled()) {
            com.baidu.tbadk.core.util.aw.h((View) this.bUt, com.baidu.tieba.u.navi_done_text_bg);
            com.baidu.tbadk.core.util.aw.b(this.bUt, com.baidu.tieba.s.navi_done_text, 1);
            return;
        }
        com.baidu.tbadk.core.util.aw.h((View) this.bUt, com.baidu.tieba.u.btn_titlebar_finish_d);
        com.baidu.tbadk.core.util.aw.b(this.bUt, com.baidu.tieba.s.navi_done_text_d, 1);
    }
}
