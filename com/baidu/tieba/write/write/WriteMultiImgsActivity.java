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
    private com.baidu.tbadk.core.dialog.a fTw;
    private View fTz;
    private WriteImagesInfo fTj = null;
    private View rootView = null;
    private ViewPager bmO = null;
    private q fTk = null;
    private LinearLayout fTl = null;
    private RadioGroup enU = null;
    private RadioButton fTm = null;
    private RadioButton fTn = null;
    private LinearLayout fTo = null;
    private View fTp = null;
    private NavigationBar aZq = null;
    private TextView QL = null;
    private TextView fTq = null;
    private String fTr = "";
    private String fTs = "";
    private String fTt = "";
    private String fTu = "(1/1)";
    private boolean fTv = true;
    private HashMap<String, String> fTx = new HashMap<>();
    private int fTy = 0;
    private int fTA = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int Y = com.baidu.adp.lib.b.e.eZ().Y("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || Y == 1 || PluginPackageManager.jx().bi(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.fTv = false;
        } else {
            this.fTv = true;
        }
        setContentView(w.j.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.fTv) {
            if (this.fTj != null) {
                i = this.fTj.size();
                i2 = this.fTj.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m9getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.fTk.getCurrentIndex());
        this.fTk.bnY();
        bundle.putString("OutState_Write_Img_Info", this.fTj.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.fTr = getResources().getString(w.l.beautify);
        this.fTs = getResources().getString(w.l.rotate);
        this.fTt = this.fTr;
        this.rootView = findViewById(w.h.write_multi_imgs_rootlayout);
        this.bmO = (ViewPager) findViewById(w.h.write_multi_imgs_viewpager);
        this.fTl = (LinearLayout) findViewById(w.h.write_multi_imgs_beautify);
        this.enU = (RadioGroup) findViewById(w.h.beautify_tabs);
        this.fTm = (RadioButton) findViewById(w.h.beautify_btn);
        this.fTn = (RadioButton) findViewById(w.h.rotate_btn);
        this.fTm.setOnCheckedChangeListener(this);
        this.fTn.setOnCheckedChangeListener(this);
        this.fTo = (LinearLayout) findViewById(w.h.filters_layout);
        this.fTp = findViewById(w.h.rotate);
        Button button = (Button) findViewById(w.h.rotate_left);
        Button button2 = (Button) findViewById(w.h.rotate_right);
        Button button3 = (Button) findViewById(w.h.rotate_left_right);
        Button button4 = (Button) findViewById(w.h.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        cc ccVar = new cc(this);
        button.setOnClickListener(ccVar);
        button2.setOnClickListener(ccVar);
        button3.setOnClickListener(ccVar);
        button4.setOnClickListener(ccVar);
        this.aZq = (NavigationBar) findViewById(w.h.write_multi_imgs_navibar);
        this.fTz = this.aZq.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new cd(this));
        this.fTq = this.aZq.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(w.l.done), new ce(this));
        this.QL = this.aZq.setTitleText(getPageContext().getString(w.l.beautify));
        this.fTm.setChecked(true);
        if (!this.fTv) {
            this.fTn.setChecked(true);
            this.fTn.setPadding(0, this.fTn.getPaddingTop(), this.fTn.getPaddingRight(), this.fTn.getPaddingBottom());
            this.fTo.setVisibility(8);
            this.fTm.setVisibility(8);
            this.enU.setVisibility(8);
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
            this.fTj = new WriteImagesInfo();
            this.fTj.parseJson(str);
            boK();
            this.fTk = new q(this, this.bmO, this.fTj.getChosedFiles(), i, this);
            this.bmO.setAdapter(this.fTk);
            this.bmO.setCurrentItem(i, true);
            if (i == 0) {
                this.fTk.onPageSelected(0);
            }
            this.fTl.setVisibility(0);
        }
    }

    private void boK() {
        if (this.fTj != null && this.fTj.isOriginalImg() && this.fTj.getChosedFiles() != null && this.fTj.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.fTj.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.fTx.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean boL() {
        if (this.fTj == null || !this.fTj.isOriginalImg() || this.fTj.getChosedFiles() == null || this.fTj.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.fTj.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.fTx.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void bnZ() {
        if (this.aZq.getVisibility() == 0) {
            this.aZq.setVisibility(8);
            this.fTl.setVisibility(8);
            return;
        }
        this.aZq.setVisibility(0);
        this.fTl.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void a(com.baidu.tbadk.coreExtra.view.c cVar, int i) {
        this.fTo.removeAllViews();
        this.fTo.addView(cVar);
        this.fTu = "（" + (i + 1) + "/" + this.fTj.size() + "）";
        this.QL.setText(String.valueOf(this.fTt) + this.fTu);
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void bob() {
        this.fTA--;
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void boa() {
        this.fTA++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void boM() {
        this.fTy++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void boN() {
        this.fTy--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boO() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.fTj.toJsonString());
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
            if (compoundButton == this.fTm) {
                this.fTo.setVisibility(0);
                this.fTp.setVisibility(8);
                this.fTt = this.fTr;
                this.QL.setText(String.valueOf(this.fTt) + this.fTu);
                return;
            }
            this.fTo.setVisibility(8);
            this.fTp.setVisibility(0);
            this.fTt = this.fTs;
            this.QL.setText(String.valueOf(this.fTt) + this.fTu);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ai(i == 1);
        getLayoutMode().t(this.rootView);
        atM();
    }

    private void atM() {
        com.baidu.tbadk.core.util.aq.k(this.aZq, w.e.common_color_10222);
        com.baidu.tbadk.core.util.aq.c(this.QL, w.e.cp_cont_g, 1);
        com.baidu.tbadk.core.util.aq.a(this.aZq.getBackImageView(), w.g.icon_return_s, w.g.icon_return_s_w, 0);
        com.baidu.tbadk.core.util.aq.c(this.fTq, w.e.cp_cont_g, 1);
    }
}
