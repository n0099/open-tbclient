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
import com.baidu.tieba.n;
import com.baidu.tieba.write.write.q;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class WriteMultiImgsActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, q.a {
    private com.baidu.tbadk.core.dialog.a dZd;
    private WriteImagesInfo dYP = null;
    private View rootView = null;
    private ViewPager dYQ = null;
    private q dYR = null;
    private LinearLayout dYS = null;
    private RadioGroup NA = null;
    private RadioButton dYT = null;
    private RadioButton dYU = null;
    private LinearLayout dYV = null;
    private View dYW = null;
    private NavigationBar aKK = null;
    private TextView aOS = null;
    private TextView dYX = null;
    private String dYY = "";
    private String dYZ = "";
    private String dZa = "";
    private String dZb = "(1/1)";
    private boolean dZc = true;
    private HashMap<String, String> dZe = new HashMap<>();
    private int dZf = 0;
    private int dZg = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int aj = com.baidu.adp.lib.c.e.gw().aj("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || aj == 1 || PluginPackageManager.ls().bB(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.dZc = false;
        } else {
            this.dZc = true;
        }
        setContentView(n.h.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.dZc) {
            if (this.dYP != null) {
                i = this.dYP.size();
                i2 = this.dYP.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m411getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.dYR.getCurrentIndex());
        this.dYR.aLF();
        bundle.putString("OutState_Write_Img_Info", this.dYP.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.dYY = getResources().getString(n.j.beautify);
        this.dYZ = getResources().getString(n.j.rotate);
        this.dZa = this.dYY;
        this.rootView = findViewById(n.g.write_multi_imgs_rootlayout);
        this.dYQ = (ViewPager) findViewById(n.g.write_multi_imgs_viewpager);
        this.dYS = (LinearLayout) findViewById(n.g.write_multi_imgs_beautify);
        this.NA = (RadioGroup) findViewById(n.g.beautify_tabs);
        this.dYT = (RadioButton) findViewById(n.g.beautify_btn);
        this.dYU = (RadioButton) findViewById(n.g.rotate_btn);
        this.dYT.setOnCheckedChangeListener(this);
        this.dYU.setOnCheckedChangeListener(this);
        this.dYV = (LinearLayout) findViewById(n.g.filters_layout);
        this.dYW = findViewById(n.g.rotate);
        Button button = (Button) findViewById(n.g.rotate_left);
        Button button2 = (Button) findViewById(n.g.rotate_right);
        Button button3 = (Button) findViewById(n.g.rotate_left_right);
        Button button4 = (Button) findViewById(n.g.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        ca caVar = new ca(this);
        button.setOnClickListener(caVar);
        button2.setOnClickListener(caVar);
        button3.setOnClickListener(caVar);
        button4.setOnClickListener(caVar);
        this.aKK = (NavigationBar) findViewById(n.g.write_multi_imgs_navibar);
        this.aKK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new cb(this));
        this.dYX = this.aKK.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(n.j.done), new cc(this));
        this.aOS = this.aKK.setTitleText(getPageContext().getString(n.j.beautify));
        this.dYT.setChecked(true);
        if (!this.dZc) {
            this.dYU.setChecked(true);
            this.dYU.setPadding(0, this.dYU.getPaddingTop(), this.dYU.getPaddingRight(), this.dYU.getPaddingBottom());
            this.dYV.setVisibility(8);
            this.dYT.setVisibility(8);
            this.NA.setVisibility(8);
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
            this.dYP = new WriteImagesInfo();
            this.dYP.parseJson(str);
            aMq();
            this.dYR = new q(this, this.dYQ, this.dYP.getChosedFiles(), i, this);
            this.dYQ.setAdapter(this.dYR);
            this.dYQ.setCurrentItem(i, true);
            if (i == 0) {
                this.dYR.onPageSelected(0);
            }
            this.dYS.setVisibility(0);
        }
    }

    private void aMq() {
        if (this.dYP != null && this.dYP.isOriginalImg() && this.dYP.getChosedFiles() != null && this.dYP.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.dYP.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.dZe.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aMr() {
        if (this.dYP == null || !this.dYP.isOriginalImg() || this.dYP.getChosedFiles() == null || this.dYP.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.dYP.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.dZe.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void aLG() {
        if (this.aKK.getVisibility() == 0) {
            this.aKK.setVisibility(8);
            this.dYS.setVisibility(8);
            return;
        }
        this.aKK.setVisibility(0);
        this.dYS.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void a(com.baidu.tbadk.coreExtra.view.d dVar, int i) {
        this.dYV.removeAllViews();
        this.dYV.addView(dVar);
        this.dZb = "（" + (i + 1) + "/" + this.dYP.size() + "）";
        this.aOS.setText(String.valueOf(this.dZa) + this.dZb);
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void aLI() {
        this.dZg--;
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void aLH() {
        this.dZg++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aMs() {
        this.dZf++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aMt() {
        this.dZf--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMu() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.dYP.toJsonString());
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
            if (compoundButton == this.dYT) {
                this.dYV.setVisibility(0);
                this.dYW.setVisibility(8);
                this.dZa = this.dYY;
                this.aOS.setText(String.valueOf(this.dZa) + this.dZb);
                return;
            }
            this.dYV.setVisibility(8);
            this.dYW.setVisibility(0);
            this.dZa = this.dYZ;
            this.aOS.setText(String.valueOf(this.dZa) + this.dZb);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ac(i == 1);
        getLayoutMode().k(this.rootView);
        this.aKK.onChangeSkinType(getPageContext(), i);
        if (this.dYX.isEnabled()) {
            com.baidu.tbadk.core.util.as.i((View) this.dYX, n.f.navi_done_text_bg);
            com.baidu.tbadk.core.util.as.b(this.dYX, n.d.navi_done_text, 1);
            return;
        }
        com.baidu.tbadk.core.util.as.i((View) this.dYX, n.f.btn_titlebar_finish_d);
        com.baidu.tbadk.core.util.as.b(this.dYX, n.d.navi_done_text_d, 1);
    }
}
