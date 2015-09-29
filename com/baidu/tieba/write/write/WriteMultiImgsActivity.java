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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.i;
import com.baidu.tieba.write.write.q;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class WriteMultiImgsActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, q.a {
    private com.baidu.tbadk.core.dialog.a dqi;
    private WriteImagesInfo dpV = null;
    private View rootView = null;
    private ViewPager cal = null;
    private q dpW = null;
    private LinearLayout dpX = null;
    private RadioGroup MR = null;
    private RadioButton dpY = null;
    private RadioButton dpZ = null;
    private LinearLayout dqa = null;
    private View dqb = null;
    private NavigationBar aHi = null;
    private TextView aJS = null;
    private TextView dqc = null;
    private String dqd = "";
    private String dqe = "";
    private String dqf = "";
    private String dqg = "(1/1)";
    private boolean dqh = true;
    private HashMap<String, String> dqj = new HashMap<>();
    private int dqk = 0;
    private int dql = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int ah = com.baidu.adp.lib.b.e.gv().ah("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || ah == 1 || PluginPackageManager.lR().bw(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.dqh = false;
        } else {
            this.dqh = true;
        }
        setContentView(i.g.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.dqh) {
            if (this.dpV != null) {
                i = this.dpV.size();
                i2 = this.dpV.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m411getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.dpW.getCurrentIndex());
        this.dpW.aCP();
        bundle.putString("OutState_Write_Img_Info", this.dpV.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.dqd = getResources().getString(i.h.beautify);
        this.dqe = getResources().getString(i.h.rotate);
        this.dqf = this.dqd;
        this.rootView = findViewById(i.f.write_multi_imgs_rootlayout);
        this.cal = (ViewPager) findViewById(i.f.write_multi_imgs_viewpager);
        this.dpX = (LinearLayout) findViewById(i.f.write_multi_imgs_beautify);
        this.MR = (RadioGroup) findViewById(i.f.beautify_tabs);
        this.dpY = (RadioButton) findViewById(i.f.beautify_btn);
        this.dpZ = (RadioButton) findViewById(i.f.rotate_btn);
        this.dpY.setOnCheckedChangeListener(this);
        this.dpZ.setOnCheckedChangeListener(this);
        this.dqa = (LinearLayout) findViewById(i.f.filters_layout);
        this.dqb = findViewById(i.f.rotate);
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
        this.aHi = (NavigationBar) findViewById(i.f.write_multi_imgs_navibar);
        this.aHi.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bz(this));
        this.dqc = this.aHi.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(i.h.done), new ca(this));
        this.aJS = this.aHi.setTitleText(getPageContext().getString(i.h.beautify));
        this.dpY.setChecked(true);
        if (!this.dqh) {
            this.dpZ.setChecked(true);
            this.dpZ.setPadding(0, this.dpZ.getPaddingTop(), this.dpZ.getPaddingRight(), this.dpZ.getPaddingBottom());
            this.dqa.setVisibility(8);
            this.dpY.setVisibility(8);
            this.MR.setVisibility(8);
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
            this.dpV = new WriteImagesInfo();
            this.dpV.parseJson(str);
            aDy();
            this.dpW = new q(this, this.cal, this.dpV.getChosedFiles(), i, this);
            this.cal.setAdapter(this.dpW);
            this.cal.setCurrentItem(i, true);
            if (i == 0) {
                this.dpW.onPageSelected(0);
            }
            this.dpX.setVisibility(0);
        }
    }

    private void aDy() {
        if (this.dpV != null && this.dpV.isOriginalImg() && this.dpV.getChosedFiles() != null && this.dpV.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.dpV.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.dqj.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aDz() {
        if (this.dpV == null || !this.dpV.isOriginalImg() || this.dpV.getChosedFiles() == null || this.dpV.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.dpV.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.dqj.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void aCQ() {
        if (this.aHi.getVisibility() == 0) {
            this.aHi.setVisibility(8);
            this.dpX.setVisibility(8);
            return;
        }
        this.aHi.setVisibility(0);
        this.dpX.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void a(com.baidu.tbadk.coreExtra.view.d dVar, int i) {
        this.dqa.removeAllViews();
        this.dqa.addView(dVar);
        this.dqg = "（" + (i + 1) + "/" + this.dpV.size() + "）";
        this.aJS.setText(String.valueOf(this.dqf) + this.dqg);
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void aCS() {
        this.dql--;
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void aCR() {
        this.dql++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aDA() {
        this.dqk++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aDB() {
        this.dqk--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDC() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.dpV.toJsonString());
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
            if (compoundButton == this.dpY) {
                this.dqa.setVisibility(0);
                this.dqb.setVisibility(8);
                this.dqf = this.dqd;
                this.aJS.setText(String.valueOf(this.dqf) + this.dqg);
                return;
            }
            this.dqa.setVisibility(8);
            this.dqb.setVisibility(0);
            this.dqf = this.dqe;
            this.aJS.setText(String.valueOf(this.dqf) + this.dqg);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.rootView);
        this.aHi.onChangeSkinType(getPageContext(), i);
        if (this.dqc.isEnabled()) {
            com.baidu.tbadk.core.util.am.i((View) this.dqc, i.e.navi_done_text_bg);
            com.baidu.tbadk.core.util.am.b(this.dqc, i.c.navi_done_text, 1);
            return;
        }
        com.baidu.tbadk.core.util.am.i((View) this.dqc, i.e.btn_titlebar_finish_d);
        com.baidu.tbadk.core.util.am.b(this.dqc, i.c.navi_done_text_d, 1);
    }
}
