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
    private com.baidu.tbadk.core.dialog.a dqI;
    private WriteImagesInfo dqv = null;
    private View rootView = null;
    private ViewPager caw = null;
    private q dqw = null;
    private LinearLayout dqx = null;
    private RadioGroup MS = null;
    private RadioButton dqy = null;
    private RadioButton dqz = null;
    private LinearLayout dqA = null;
    private View dqB = null;
    private NavigationBar aHt = null;
    private TextView aKd = null;
    private TextView dqC = null;
    private String dqD = "";
    private String dqE = "";
    private String dqF = "";
    private String dqG = "(1/1)";
    private boolean dqH = true;
    private HashMap<String, String> dqJ = new HashMap<>();
    private int dqK = 0;
    private int dqL = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int ah = com.baidu.adp.lib.b.e.gv().ah("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || ah == 1 || PluginPackageManager.lR().bw(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.dqH = false;
        } else {
            this.dqH = true;
        }
        setContentView(i.g.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.dqH) {
            if (this.dqv != null) {
                i = this.dqv.size();
                i2 = this.dqv.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m411getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.dqw.getCurrentIndex());
        this.dqw.aCZ();
        bundle.putString("OutState_Write_Img_Info", this.dqv.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.dqD = getResources().getString(i.h.beautify);
        this.dqE = getResources().getString(i.h.rotate);
        this.dqF = this.dqD;
        this.rootView = findViewById(i.f.write_multi_imgs_rootlayout);
        this.caw = (ViewPager) findViewById(i.f.write_multi_imgs_viewpager);
        this.dqx = (LinearLayout) findViewById(i.f.write_multi_imgs_beautify);
        this.MS = (RadioGroup) findViewById(i.f.beautify_tabs);
        this.dqy = (RadioButton) findViewById(i.f.beautify_btn);
        this.dqz = (RadioButton) findViewById(i.f.rotate_btn);
        this.dqy.setOnCheckedChangeListener(this);
        this.dqz.setOnCheckedChangeListener(this);
        this.dqA = (LinearLayout) findViewById(i.f.filters_layout);
        this.dqB = findViewById(i.f.rotate);
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
        this.aHt = (NavigationBar) findViewById(i.f.write_multi_imgs_navibar);
        this.aHt.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bz(this));
        this.dqC = this.aHt.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(i.h.done), new ca(this));
        this.aKd = this.aHt.setTitleText(getPageContext().getString(i.h.beautify));
        this.dqy.setChecked(true);
        if (!this.dqH) {
            this.dqz.setChecked(true);
            this.dqz.setPadding(0, this.dqz.getPaddingTop(), this.dqz.getPaddingRight(), this.dqz.getPaddingBottom());
            this.dqA.setVisibility(8);
            this.dqy.setVisibility(8);
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
            this.dqv = new WriteImagesInfo();
            this.dqv.parseJson(str);
            aDI();
            this.dqw = new q(this, this.caw, this.dqv.getChosedFiles(), i, this);
            this.caw.setAdapter(this.dqw);
            this.caw.setCurrentItem(i, true);
            if (i == 0) {
                this.dqw.onPageSelected(0);
            }
            this.dqx.setVisibility(0);
        }
    }

    private void aDI() {
        if (this.dqv != null && this.dqv.isOriginalImg() && this.dqv.getChosedFiles() != null && this.dqv.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.dqv.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.dqJ.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aDJ() {
        if (this.dqv == null || !this.dqv.isOriginalImg() || this.dqv.getChosedFiles() == null || this.dqv.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.dqv.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.dqJ.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void aDa() {
        if (this.aHt.getVisibility() == 0) {
            this.aHt.setVisibility(8);
            this.dqx.setVisibility(8);
            return;
        }
        this.aHt.setVisibility(0);
        this.dqx.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void a(com.baidu.tbadk.coreExtra.view.d dVar, int i) {
        this.dqA.removeAllViews();
        this.dqA.addView(dVar);
        this.dqG = "（" + (i + 1) + "/" + this.dqv.size() + "）";
        this.aKd.setText(String.valueOf(this.dqF) + this.dqG);
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void aDc() {
        this.dqL--;
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void aDb() {
        this.dqL++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aDK() {
        this.dqK++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aDL() {
        this.dqK--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDM() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.dqv.toJsonString());
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
            if (compoundButton == this.dqy) {
                this.dqA.setVisibility(0);
                this.dqB.setVisibility(8);
                this.dqF = this.dqD;
                this.aKd.setText(String.valueOf(this.dqF) + this.dqG);
                return;
            }
            this.dqA.setVisibility(8);
            this.dqB.setVisibility(0);
            this.dqF = this.dqE;
            this.aKd.setText(String.valueOf(this.dqF) + this.dqG);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.rootView);
        this.aHt.onChangeSkinType(getPageContext(), i);
        if (this.dqC.isEnabled()) {
            com.baidu.tbadk.core.util.an.i((View) this.dqC, i.e.navi_done_text_bg);
            com.baidu.tbadk.core.util.an.b(this.dqC, i.c.navi_done_text, 1);
            return;
        }
        com.baidu.tbadk.core.util.an.i((View) this.dqC, i.e.btn_titlebar_finish_d);
        com.baidu.tbadk.core.util.an.b(this.dqC, i.c.navi_done_text_d, 1);
    }
}
