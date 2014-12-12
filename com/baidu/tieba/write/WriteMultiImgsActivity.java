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
    private WriteImagesInfo cfI = null;
    private View rootView = null;
    private ViewPager aeH = null;
    private r cfJ = null;
    private LinearLayout cfK = null;
    private RadioButton cfL = null;
    private RadioButton cfM = null;
    private LinearLayout cfN = null;
    private View cfO = null;
    private NavigationBar aey = null;
    private TextView cfP = null;
    private TextView cfQ = null;
    private String cfR = "";
    private String cfS = "";
    private String cfT = "";
    private String cfU = "(1/1)";
    private boolean cfV = true;
    private int cfW = 0;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(WriteMulitImageActivityConfig.class, WriteMultiImgsActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        int Z = com.baidu.adp.lib.b.f.dc().Z("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || Z == 1 || PluginPackageManager.ic().bm("com.baidu.tieba.pluginMotu") == PluginPackageManager.PluginStatus.DISABLE) {
            this.cfV = false;
        } else {
            this.cfV = true;
        }
        setContentView(com.baidu.tieba.x.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.cfV) {
            if (this.cfI != null) {
                i = this.cfI.size();
                i2 = this.cfI.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m255getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.cfJ.getCurrentIndex());
        this.cfJ.ajL();
        bundle.putString("OutState_Write_Img_Info", this.cfI.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.cfR = getResources().getString(com.baidu.tieba.z.beautify);
        this.cfS = getResources().getString(com.baidu.tieba.z.rotate);
        this.cfT = this.cfR;
        this.rootView = findViewById(com.baidu.tieba.w.write_multi_imgs_rootlayout);
        this.aeH = (ViewPager) findViewById(com.baidu.tieba.w.write_multi_imgs_viewpager);
        this.cfK = (LinearLayout) findViewById(com.baidu.tieba.w.write_multi_imgs_beautify);
        this.cfL = (RadioButton) findViewById(com.baidu.tieba.w.beautify_btn);
        this.cfM = (RadioButton) findViewById(com.baidu.tieba.w.rotate_btn);
        this.cfL.setOnCheckedChangeListener(this);
        this.cfM.setOnCheckedChangeListener(this);
        this.cfN = (LinearLayout) findViewById(com.baidu.tieba.w.filters_layout);
        this.cfO = findViewById(com.baidu.tieba.w.rotate);
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
        this.aey = (NavigationBar) findViewById(com.baidu.tieba.w.write_multi_imgs_navibar);
        this.aey.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new cf(this));
        this.cfQ = this.aey.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.z.done), new cg(this));
        this.cfP = this.aey.setTitleText(getPageContext().getString(com.baidu.tieba.z.beautify));
        this.cfL.setChecked(true);
        if (!this.cfV) {
            this.cfM.setChecked(true);
            this.cfM.setPadding(0, this.cfM.getPaddingTop(), this.cfM.getPaddingRight(), this.cfM.getPaddingBottom());
            this.cfN.setVisibility(8);
            this.cfL.setVisibility(8);
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
            this.cfI = new WriteImagesInfo();
            this.cfI.parseJson(str);
            this.cfJ = new r(this, this.aeH, this.cfI.getChosedFiles(), i, this);
            this.aeH.setAdapter(this.cfJ);
            this.aeH.setCurrentItem(i, true);
            if (i == 0) {
                this.cfJ.onPageSelected(0);
            }
            this.cfK.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.write.s
    public void ajM() {
        if (this.aey.getVisibility() == 0) {
            this.aey.setVisibility(8);
            this.cfK.setVisibility(8);
            return;
        }
        this.aey.setVisibility(0);
        this.cfK.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.s
    public void a(com.baidu.tbadk.coreExtra.view.j jVar, int i) {
        this.cfN.removeAllViews();
        this.cfN.addView(jVar);
        this.cfU = "（" + (i + 1) + "/" + this.cfI.size() + "）";
        this.cfP.setText(String.valueOf(this.cfT) + this.cfU);
    }

    @Override // com.baidu.tieba.write.s
    public void ajO() {
        this.cfW--;
    }

    @Override // com.baidu.tieba.write.s
    public void ajN() {
        this.cfW++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ako() {
        this.cfJ.ajL();
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.cfI.toJsonString());
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
            if (compoundButton == this.cfL) {
                this.cfN.setVisibility(0);
                this.cfO.setVisibility(8);
                this.cfT = this.cfR;
                this.cfP.setText(String.valueOf(this.cfT) + this.cfU);
                return;
            }
            this.cfN.setVisibility(8);
            this.cfO.setVisibility(0);
            this.cfT = this.cfS;
            this.cfP.setText(String.valueOf(this.cfT) + this.cfU);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(this.rootView);
        this.aey.onChangeSkinType(getPageContext(), i);
        if (this.cfQ.isEnabled()) {
            com.baidu.tbadk.core.util.ax.i((View) this.cfQ, com.baidu.tieba.v.navi_done_text_bg);
            com.baidu.tbadk.core.util.ax.b(this.cfQ, com.baidu.tieba.t.navi_done_text, 1);
            return;
        }
        com.baidu.tbadk.core.util.ax.i((View) this.cfQ, com.baidu.tieba.v.btn_titlebar_finish_d);
        com.baidu.tbadk.core.util.ax.b(this.cfQ, com.baidu.tieba.t.navi_done_text_d, 1);
    }
}
