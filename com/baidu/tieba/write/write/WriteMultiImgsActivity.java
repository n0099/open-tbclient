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
    private com.baidu.tbadk.core.dialog.a dRF;
    private WriteImagesInfo dRr = null;
    private View rootView = null;
    private ViewPager dRs = null;
    private q dRt = null;
    private LinearLayout dRu = null;
    private RadioGroup Nk = null;
    private RadioButton dRv = null;
    private RadioButton dRw = null;
    private LinearLayout dRx = null;
    private View dRy = null;
    private NavigationBar aJm = null;
    private TextView aNy = null;
    private TextView dRz = null;
    private String dRA = "";
    private String dRB = "";
    private String dRC = "";
    private String dRD = "(1/1)";
    private boolean dRE = true;
    private HashMap<String, String> dRG = new HashMap<>();
    private int dRH = 0;
    private int dRI = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int aj = com.baidu.adp.lib.c.e.gw().aj("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || aj == 1 || PluginPackageManager.lU().by(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.dRE = false;
        } else {
            this.dRE = true;
        }
        setContentView(n.g.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.dRE) {
            if (this.dRr != null) {
                i = this.dRr.size();
                i2 = this.dRr.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m411getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.dRt.getCurrentIndex());
        this.dRt.aJk();
        bundle.putString("OutState_Write_Img_Info", this.dRr.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.dRA = getResources().getString(n.i.beautify);
        this.dRB = getResources().getString(n.i.rotate);
        this.dRC = this.dRA;
        this.rootView = findViewById(n.f.write_multi_imgs_rootlayout);
        this.dRs = (ViewPager) findViewById(n.f.write_multi_imgs_viewpager);
        this.dRu = (LinearLayout) findViewById(n.f.write_multi_imgs_beautify);
        this.Nk = (RadioGroup) findViewById(n.f.beautify_tabs);
        this.dRv = (RadioButton) findViewById(n.f.beautify_btn);
        this.dRw = (RadioButton) findViewById(n.f.rotate_btn);
        this.dRv.setOnCheckedChangeListener(this);
        this.dRw.setOnCheckedChangeListener(this);
        this.dRx = (LinearLayout) findViewById(n.f.filters_layout);
        this.dRy = findViewById(n.f.rotate);
        Button button = (Button) findViewById(n.f.rotate_left);
        Button button2 = (Button) findViewById(n.f.rotate_right);
        Button button3 = (Button) findViewById(n.f.rotate_left_right);
        Button button4 = (Button) findViewById(n.f.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        ca caVar = new ca(this);
        button.setOnClickListener(caVar);
        button2.setOnClickListener(caVar);
        button3.setOnClickListener(caVar);
        button4.setOnClickListener(caVar);
        this.aJm = (NavigationBar) findViewById(n.f.write_multi_imgs_navibar);
        this.aJm.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new cb(this));
        this.dRz = this.aJm.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(n.i.done), new cc(this));
        this.aNy = this.aJm.setTitleText(getPageContext().getString(n.i.beautify));
        this.dRv.setChecked(true);
        if (!this.dRE) {
            this.dRw.setChecked(true);
            this.dRw.setPadding(0, this.dRw.getPaddingTop(), this.dRw.getPaddingRight(), this.dRw.getPaddingBottom());
            this.dRx.setVisibility(8);
            this.dRv.setVisibility(8);
            this.Nk.setVisibility(8);
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
            this.dRr = new WriteImagesInfo();
            this.dRr.parseJson(str);
            aJV();
            this.dRt = new q(this, this.dRs, this.dRr.getChosedFiles(), i, this);
            this.dRs.setAdapter(this.dRt);
            this.dRs.setCurrentItem(i, true);
            if (i == 0) {
                this.dRt.onPageSelected(0);
            }
            this.dRu.setVisibility(0);
        }
    }

    private void aJV() {
        if (this.dRr != null && this.dRr.isOriginalImg() && this.dRr.getChosedFiles() != null && this.dRr.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.dRr.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.dRG.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aJW() {
        if (this.dRr == null || !this.dRr.isOriginalImg() || this.dRr.getChosedFiles() == null || this.dRr.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.dRr.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.dRG.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void aJl() {
        if (this.aJm.getVisibility() == 0) {
            this.aJm.setVisibility(8);
            this.dRu.setVisibility(8);
            return;
        }
        this.aJm.setVisibility(0);
        this.dRu.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void a(com.baidu.tbadk.coreExtra.view.d dVar, int i) {
        this.dRx.removeAllViews();
        this.dRx.addView(dVar);
        this.dRD = "（" + (i + 1) + "/" + this.dRr.size() + "）";
        this.aNy.setText(String.valueOf(this.dRC) + this.dRD);
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void aJn() {
        this.dRI--;
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void aJm() {
        this.dRI++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aJX() {
        this.dRH++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aJY() {
        this.dRH--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJZ() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.dRr.toJsonString());
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
            if (compoundButton == this.dRv) {
                this.dRx.setVisibility(0);
                this.dRy.setVisibility(8);
                this.dRC = this.dRA;
                this.aNy.setText(String.valueOf(this.dRC) + this.dRD);
                return;
            }
            this.dRx.setVisibility(8);
            this.dRy.setVisibility(0);
            this.dRC = this.dRB;
            this.aNy.setText(String.valueOf(this.dRC) + this.dRD);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().af(i == 1);
        getLayoutMode().k(this.rootView);
        this.aJm.onChangeSkinType(getPageContext(), i);
        if (this.dRz.isEnabled()) {
            com.baidu.tbadk.core.util.as.i((View) this.dRz, n.e.navi_done_text_bg);
            com.baidu.tbadk.core.util.as.b(this.dRz, n.c.navi_done_text, 1);
            return;
        }
        com.baidu.tbadk.core.util.as.i((View) this.dRz, n.e.btn_titlebar_finish_d);
        com.baidu.tbadk.core.util.as.b(this.dRz, n.c.navi_done_text_d, 1);
    }
}
