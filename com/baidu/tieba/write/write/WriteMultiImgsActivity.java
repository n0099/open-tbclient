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
import com.baidu.tieba.t;
import com.baidu.tieba.write.write.q;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class WriteMultiImgsActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, q.a {
    private com.baidu.tbadk.core.dialog.a etS;
    private WriteImagesInfo etE = null;
    private View azA = null;
    private ViewPager etF = null;
    private q etG = null;
    private LinearLayout etH = null;
    private RadioGroup Od = null;
    private RadioButton etI = null;
    private RadioButton etJ = null;
    private LinearLayout etK = null;
    private View etL = null;
    private NavigationBar aLP = null;
    private TextView aQR = null;
    private TextView etM = null;
    private String etN = "";
    private String etO = "";
    private String etP = "";
    private String etQ = "(1/1)";
    private boolean etR = true;
    private HashMap<String, String> etT = new HashMap<>();
    private int etU = 0;
    private int etV = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int ai = com.baidu.adp.lib.c.e.gE().ai("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || ai == 1 || PluginPackageManager.lD().bB(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.etR = false;
        } else {
            this.etR = true;
        }
        setContentView(t.h.write_multi_imgs_activity);
        qD();
        initData(bundle);
        if (this.etR) {
            if (this.etE != null) {
                i = this.etE.size();
                i2 = this.etE.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m411getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.etG.getCurrentIndex());
        this.etG.aUA();
        bundle.putString("OutState_Write_Img_Info", this.etE.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void qD() {
        this.etN = getResources().getString(t.j.beautify);
        this.etO = getResources().getString(t.j.rotate);
        this.etP = this.etN;
        this.azA = findViewById(t.g.write_multi_imgs_rootlayout);
        this.etF = (ViewPager) findViewById(t.g.write_multi_imgs_viewpager);
        this.etH = (LinearLayout) findViewById(t.g.write_multi_imgs_beautify);
        this.Od = (RadioGroup) findViewById(t.g.beautify_tabs);
        this.etI = (RadioButton) findViewById(t.g.beautify_btn);
        this.etJ = (RadioButton) findViewById(t.g.rotate_btn);
        this.etI.setOnCheckedChangeListener(this);
        this.etJ.setOnCheckedChangeListener(this);
        this.etK = (LinearLayout) findViewById(t.g.filters_layout);
        this.etL = findViewById(t.g.rotate);
        Button button = (Button) findViewById(t.g.rotate_left);
        Button button2 = (Button) findViewById(t.g.rotate_right);
        Button button3 = (Button) findViewById(t.g.rotate_left_right);
        Button button4 = (Button) findViewById(t.g.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        bx bxVar = new bx(this);
        button.setOnClickListener(bxVar);
        button2.setOnClickListener(bxVar);
        button3.setOnClickListener(bxVar);
        button4.setOnClickListener(bxVar);
        this.aLP = (NavigationBar) findViewById(t.g.write_multi_imgs_navibar);
        this.aLP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new by(this));
        this.etM = this.aLP.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(t.j.done), new bz(this));
        this.aQR = this.aLP.setTitleText(getPageContext().getString(t.j.beautify));
        this.etI.setChecked(true);
        if (!this.etR) {
            this.etJ.setChecked(true);
            this.etJ.setPadding(0, this.etJ.getPaddingTop(), this.etJ.getPaddingRight(), this.etJ.getPaddingBottom());
            this.etK.setVisibility(8);
            this.etI.setVisibility(8);
            this.Od.setVisibility(8);
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
            this.etE = new WriteImagesInfo();
            this.etE.parseJson(str);
            aVk();
            this.etG = new q(this, this.etF, this.etE.getChosedFiles(), i, this);
            this.etF.setAdapter(this.etG);
            this.etF.setCurrentItem(i, true);
            if (i == 0) {
                this.etG.onPageSelected(0);
            }
            this.etH.setVisibility(0);
        }
    }

    private void aVk() {
        if (this.etE != null && this.etE.isOriginalImg() && this.etE.getChosedFiles() != null && this.etE.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.etE.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.etT.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aVl() {
        if (this.etE == null || !this.etE.isOriginalImg() || this.etE.getChosedFiles() == null || this.etE.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.etE.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.etT.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void aUB() {
        if (this.aLP.getVisibility() == 0) {
            this.aLP.setVisibility(8);
            this.etH.setVisibility(8);
            return;
        }
        this.aLP.setVisibility(0);
        this.etH.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void a(com.baidu.tbadk.coreExtra.view.c cVar, int i) {
        this.etK.removeAllViews();
        this.etK.addView(cVar);
        this.etQ = "（" + (i + 1) + "/" + this.etE.size() + "）";
        this.aQR.setText(String.valueOf(this.etP) + this.etQ);
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void aUD() {
        this.etV--;
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void aUC() {
        this.etV++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aVm() {
        this.etU++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aVn() {
        this.etU--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVo() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.etE.toJsonString());
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
            if (compoundButton == this.etI) {
                this.etK.setVisibility(0);
                this.etL.setVisibility(8);
                this.etP = this.etN;
                this.aQR.setText(String.valueOf(this.etP) + this.etQ);
                return;
            }
            this.etK.setVisibility(8);
            this.etL.setVisibility(0);
            this.etP = this.etO;
            this.aQR.setText(String.valueOf(this.etP) + this.etQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ac(i == 1);
        getLayoutMode().x(this.azA);
        this.aLP.onChangeSkinType(getPageContext(), i);
        if (this.etM.isEnabled()) {
            com.baidu.tbadk.core.util.ar.k(this.etM, t.f.navi_done_text_bg);
            com.baidu.tbadk.core.util.ar.b(this.etM, t.d.navi_done_text, 1);
            return;
        }
        com.baidu.tbadk.core.util.ar.k(this.etM, t.f.btn_titlebar_finish_d);
        com.baidu.tbadk.core.util.ar.b(this.etM, t.d.navi_done_text_d, 1);
    }
}
