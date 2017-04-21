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
import com.baidu.tieba.w;
import com.baidu.tieba.write.write.q;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class WriteMultiImgsActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, q.a {
    private com.baidu.tbadk.core.dialog.a fVn;
    private View fVq;
    private WriteImagesInfo fVa = null;
    private View rootView = null;
    private ViewPager bmr = null;
    private q fVb = null;
    private LinearLayout fVc = null;
    private RadioGroup esm = null;
    private RadioButton fVd = null;
    private RadioButton fVe = null;
    private LinearLayout fVf = null;
    private View fVg = null;
    private NavigationBar aYU = null;
    private TextView Ru = null;
    private TextView fVh = null;
    private String fVi = "";
    private String fVj = "";
    private String fVk = "";
    private String fVl = "(1/1)";
    private boolean fVm = true;
    private HashMap<String, String> fVo = new HashMap<>();
    private int fVp = 0;
    private int fVr = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int Y = com.baidu.adp.lib.b.e.eZ().Y("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || Y == 1 || PluginPackageManager.jy().bi(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.fVm = false;
        } else {
            this.fVm = true;
        }
        setContentView(w.j.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.fVm) {
            if (this.fVa != null) {
                i = this.fVa.size();
                i2 = this.fVa.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m9getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.fVb.getCurrentIndex());
        this.fVb.bpW();
        bundle.putString("OutState_Write_Img_Info", this.fVa.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.fVi = getResources().getString(w.l.beautify);
        this.fVj = getResources().getString(w.l.rotate);
        this.fVk = this.fVi;
        this.rootView = findViewById(w.h.write_multi_imgs_rootlayout);
        this.bmr = (ViewPager) findViewById(w.h.write_multi_imgs_viewpager);
        this.fVc = (LinearLayout) findViewById(w.h.write_multi_imgs_beautify);
        this.esm = (RadioGroup) findViewById(w.h.beautify_tabs);
        this.fVd = (RadioButton) findViewById(w.h.beautify_btn);
        this.fVe = (RadioButton) findViewById(w.h.rotate_btn);
        this.fVd.setOnCheckedChangeListener(this);
        this.fVe.setOnCheckedChangeListener(this);
        this.fVf = (LinearLayout) findViewById(w.h.filters_layout);
        this.fVg = findViewById(w.h.rotate);
        Button button = (Button) findViewById(w.h.rotate_left);
        Button button2 = (Button) findViewById(w.h.rotate_right);
        Button button3 = (Button) findViewById(w.h.rotate_left_right);
        Button button4 = (Button) findViewById(w.h.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        by byVar = new by(this);
        button.setOnClickListener(byVar);
        button2.setOnClickListener(byVar);
        button3.setOnClickListener(byVar);
        button4.setOnClickListener(byVar);
        this.aYU = (NavigationBar) findViewById(w.h.write_multi_imgs_navibar);
        this.fVq = this.aYU.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bz(this));
        this.fVh = this.aYU.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(w.l.done), new ca(this));
        this.Ru = this.aYU.setTitleText(getPageContext().getString(w.l.beautify));
        this.fVd.setChecked(true);
        if (!this.fVm) {
            this.fVe.setChecked(true);
            this.fVe.setPadding(0, this.fVe.getPaddingTop(), this.fVe.getPaddingRight(), this.fVe.getPaddingBottom());
            this.fVf.setVisibility(8);
            this.fVd.setVisibility(8);
            this.esm.setVisibility(8);
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
            this.fVa = new WriteImagesInfo();
            this.fVa.parseJson(str);
            bqG();
            this.fVb = new q(this, this.bmr, this.fVa.getChosedFiles(), i, this);
            this.bmr.setAdapter(this.fVb);
            this.bmr.setCurrentItem(i, true);
            if (i == 0) {
                this.fVb.onPageSelected(0);
            }
            this.fVc.setVisibility(0);
        }
    }

    private void bqG() {
        if (this.fVa != null && this.fVa.isOriginalImg() && this.fVa.getChosedFiles() != null && this.fVa.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.fVa.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.fVo.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bqH() {
        if (this.fVa == null || !this.fVa.isOriginalImg() || this.fVa.getChosedFiles() == null || this.fVa.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.fVa.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.fVo.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void bpX() {
        if (this.aYU.getVisibility() == 0) {
            this.aYU.setVisibility(8);
            this.fVc.setVisibility(8);
            return;
        }
        this.aYU.setVisibility(0);
        this.fVc.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void a(com.baidu.tbadk.coreExtra.view.c cVar, int i) {
        this.fVf.removeAllViews();
        this.fVf.addView(cVar);
        this.fVl = "（" + (i + 1) + "/" + this.fVa.size() + "）";
        this.Ru.setText(String.valueOf(this.fVk) + this.fVl);
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void bpZ() {
        this.fVr--;
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void bpY() {
        this.fVr++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bqI() {
        this.fVp++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bqJ() {
        this.fVp--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqK() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.fVa.toJsonString());
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
            if (compoundButton == this.fVd) {
                this.fVf.setVisibility(0);
                this.fVg.setVisibility(8);
                this.fVk = this.fVi;
                this.Ru.setText(String.valueOf(this.fVk) + this.fVl);
                return;
            }
            this.fVf.setVisibility(8);
            this.fVg.setVisibility(0);
            this.fVk = this.fVj;
            this.Ru.setText(String.valueOf(this.fVk) + this.fVl);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().aj(i == 1);
        getLayoutMode().t(this.rootView);
        awQ();
    }

    private void awQ() {
        com.baidu.tbadk.core.util.aq.k(this.aYU, w.e.common_color_10222);
        com.baidu.tbadk.core.util.aq.c(this.Ru, w.e.cp_cont_g, 1);
        com.baidu.tbadk.core.util.aq.a(this.aYU.getBackImageView(), w.g.icon_return_s, w.g.icon_return_s_w, 0);
        com.baidu.tbadk.core.util.aq.c(this.fVh, w.e.cp_cont_g, 1);
    }
}
