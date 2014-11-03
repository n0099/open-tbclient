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
    private WriteImagesInfo bUz = null;
    private View Xm = null;
    private ViewPager bUA = null;
    private r bUB = null;
    private LinearLayout bUC = null;
    private RadioButton bUD = null;
    private RadioButton bUE = null;
    private LinearLayout bUF = null;
    private View bUG = null;
    private NavigationBar bhL = null;
    private TextView bUH = null;
    private TextView bUI = null;
    private String bUJ = "";
    private String bUK = "";
    private String bUL = "";
    private String bUM = "(1/1)";
    private boolean bUN = true;
    private int bUO = 0;

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
            this.bUN = false;
        } else {
            this.bUN = true;
        }
        setContentView(com.baidu.tieba.w.write_multi_imgs_activity);
        initUI();
        d(bundle);
        if (this.bUN) {
            if (this.bUz != null) {
                i = this.bUz.size();
                i2 = this.bUz.size();
            } else {
                i = 1;
            }
            TbadkApplication.m251getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.bUB.getCurrentIndex());
        this.bUB.afh();
        bundle.putString("OutState_Write_Img_Info", this.bUz.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.bUJ = getResources().getString(com.baidu.tieba.y.beautify);
        this.bUK = getResources().getString(com.baidu.tieba.y.rotate);
        this.bUL = this.bUJ;
        this.Xm = findViewById(com.baidu.tieba.v.write_multi_imgs_rootlayout);
        this.bUA = (ViewPager) findViewById(com.baidu.tieba.v.write_multi_imgs_viewpager);
        this.bUC = (LinearLayout) findViewById(com.baidu.tieba.v.write_multi_imgs_beautify);
        this.bUD = (RadioButton) findViewById(com.baidu.tieba.v.beautify_btn);
        this.bUE = (RadioButton) findViewById(com.baidu.tieba.v.rotate_btn);
        this.bUD.setOnCheckedChangeListener(this);
        this.bUE.setOnCheckedChangeListener(this);
        this.bUF = (LinearLayout) findViewById(com.baidu.tieba.v.filters_layout);
        this.bUG = findViewById(com.baidu.tieba.v.rotate);
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
        this.bhL = (NavigationBar) findViewById(com.baidu.tieba.v.write_multi_imgs_navibar);
        this.bhL.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new cf(this));
        this.bUI = this.bhL.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.y.done), new cg(this));
        this.bUH = this.bhL.setTitleText(getString(com.baidu.tieba.y.beautify));
        this.bUD.setChecked(true);
        if (!this.bUN) {
            this.bUE.setChecked(true);
            this.bUE.setPadding(0, this.bUE.getPaddingTop(), this.bUE.getPaddingRight(), this.bUE.getPaddingBottom());
            this.bUF.setVisibility(8);
            this.bUD.setVisibility(8);
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
            this.bUz = new WriteImagesInfo();
            this.bUz.parseJson(str);
            this.bUB = new r(this, this.bUA, this.bUz.getChosedFiles(), i, this);
            this.bUA.setAdapter(this.bUB);
            this.bUA.setCurrentItem(i, true);
            if (i == 0) {
                this.bUB.onPageSelected(0);
            }
            this.bUC.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.write.s
    public void afi() {
        if (this.bhL.getVisibility() == 0) {
            this.bhL.setVisibility(8);
            this.bUC.setVisibility(8);
            return;
        }
        this.bhL.setVisibility(0);
        this.bUC.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.s
    public void a(com.baidu.tbadk.coreExtra.view.j jVar, int i) {
        this.bUF.removeAllViews();
        this.bUF.addView(jVar);
        this.bUM = "（" + (i + 1) + "/" + this.bUz.size() + "）";
        this.bUH.setText(String.valueOf(this.bUL) + this.bUM);
    }

    @Override // com.baidu.tieba.write.s
    public void afk() {
        this.bUO--;
    }

    @Override // com.baidu.tieba.write.s
    public void afj() {
        this.bUO++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afK() {
        this.bUB.afh();
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.bUz.toJsonString());
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
            if (compoundButton == this.bUD) {
                this.bUF.setVisibility(0);
                this.bUG.setVisibility(8);
                this.bUL = this.bUJ;
                this.bUH.setText(String.valueOf(this.bUL) + this.bUM);
                return;
            }
            this.bUF.setVisibility(8);
            this.bUG.setVisibility(0);
            this.bUL = this.bUK;
            this.bUH.setText(String.valueOf(this.bUL) + this.bUM);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().L(i == 1);
        getLayoutMode().h(this.Xm);
        this.bhL.onChangeSkinType(i);
        if (this.bUI.isEnabled()) {
            com.baidu.tbadk.core.util.aw.h((View) this.bUI, com.baidu.tieba.u.navi_done_text_bg);
            com.baidu.tbadk.core.util.aw.b(this.bUI, com.baidu.tieba.s.navi_done_text, 1);
            return;
        }
        com.baidu.tbadk.core.util.aw.h((View) this.bUI, com.baidu.tieba.u.btn_titlebar_finish_d);
        com.baidu.tbadk.core.util.aw.b(this.bUI, com.baidu.tieba.s.navi_done_text_d, 1);
    }
}
