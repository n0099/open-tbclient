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
    private com.baidu.tbadk.core.dialog.a gbs;
    private View gbv;
    private WriteImagesInfo gbf = null;
    private View rootView = null;
    private ViewPager bnV = null;
    private q gbg = null;
    private LinearLayout gbh = null;
    private RadioGroup etJ = null;
    private RadioButton gbi = null;
    private RadioButton gbj = null;
    private LinearLayout gbk = null;
    private View gbl = null;
    private NavigationBar aWS = null;
    private TextView Qy = null;
    private TextView gbm = null;
    private String gbn = "";
    private String gbo = "";
    private String gbp = "";
    private String gbq = "(1/1)";
    private boolean gbr = true;
    private HashMap<String, String> gbt = new HashMap<>();
    private int gbu = 0;
    private int gbw = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int Y = com.baidu.adp.lib.b.e.eZ().Y("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || Y == 1 || PluginPackageManager.jx().bi(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.gbr = false;
        } else {
            this.gbr = true;
        }
        setContentView(w.j.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.gbr) {
            if (this.gbf != null) {
                i = this.gbf.size();
                i2 = this.gbf.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m9getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.gbg.getCurrentIndex());
        this.gbg.bpx();
        bundle.putString("OutState_Write_Img_Info", this.gbf.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.gbn = getResources().getString(w.l.beautify);
        this.gbo = getResources().getString(w.l.rotate);
        this.gbp = this.gbn;
        this.rootView = findViewById(w.h.write_multi_imgs_rootlayout);
        this.bnV = (ViewPager) findViewById(w.h.write_multi_imgs_viewpager);
        this.gbh = (LinearLayout) findViewById(w.h.write_multi_imgs_beautify);
        this.etJ = (RadioGroup) findViewById(w.h.beautify_tabs);
        this.gbi = (RadioButton) findViewById(w.h.beautify_btn);
        this.gbj = (RadioButton) findViewById(w.h.rotate_btn);
        this.gbi.setOnCheckedChangeListener(this);
        this.gbj.setOnCheckedChangeListener(this);
        this.gbk = (LinearLayout) findViewById(w.h.filters_layout);
        this.gbl = findViewById(w.h.rotate);
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
        this.aWS = (NavigationBar) findViewById(w.h.write_multi_imgs_navibar);
        this.gbv = this.aWS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new cd(this));
        this.gbm = this.aWS.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(w.l.done), new ce(this));
        this.Qy = this.aWS.setTitleText(getPageContext().getString(w.l.beautify));
        this.gbi.setChecked(true);
        if (!this.gbr) {
            this.gbj.setChecked(true);
            this.gbj.setPadding(0, this.gbj.getPaddingTop(), this.gbj.getPaddingRight(), this.gbj.getPaddingBottom());
            this.gbk.setVisibility(8);
            this.gbi.setVisibility(8);
            this.etJ.setVisibility(8);
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
            this.gbf = new WriteImagesInfo();
            this.gbf.parseJson(str);
            bqj();
            this.gbg = new q(this, this.bnV, this.gbf.getChosedFiles(), i, this);
            this.bnV.setAdapter(this.gbg);
            this.bnV.setCurrentItem(i, true);
            if (i == 0) {
                this.gbg.onPageSelected(0);
            }
            this.gbh.setVisibility(0);
        }
    }

    private void bqj() {
        if (this.gbf != null && this.gbf.isOriginalImg() && this.gbf.getChosedFiles() != null && this.gbf.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.gbf.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.gbt.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bqk() {
        if (this.gbf == null || !this.gbf.isOriginalImg() || this.gbf.getChosedFiles() == null || this.gbf.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.gbf.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.gbt.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void bpy() {
        if (this.aWS.getVisibility() == 0) {
            this.aWS.setVisibility(8);
            this.gbh.setVisibility(8);
            return;
        }
        this.aWS.setVisibility(0);
        this.gbh.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void a(com.baidu.tbadk.coreExtra.view.c cVar, int i) {
        this.gbk.removeAllViews();
        this.gbk.addView(cVar);
        this.gbq = "（" + (i + 1) + "/" + this.gbf.size() + "）";
        this.Qy.setText(String.valueOf(this.gbp) + this.gbq);
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void bpA() {
        this.gbw--;
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void bpz() {
        this.gbw++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bql() {
        this.gbu++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bqm() {
        this.gbu--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqn() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.gbf.toJsonString());
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
            if (compoundButton == this.gbi) {
                this.gbk.setVisibility(0);
                this.gbl.setVisibility(8);
                this.gbp = this.gbn;
                this.Qy.setText(String.valueOf(this.gbp) + this.gbq);
                return;
            }
            this.gbk.setVisibility(8);
            this.gbl.setVisibility(0);
            this.gbp = this.gbo;
            this.Qy.setText(String.valueOf(this.gbp) + this.gbq);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.rootView);
        auH();
    }

    private void auH() {
        com.baidu.tbadk.core.util.aq.k(this.aWS, w.e.common_color_10222);
        com.baidu.tbadk.core.util.aq.c(this.Qy, w.e.cp_cont_g, 1);
        com.baidu.tbadk.core.util.aq.a(this.aWS.getBackImageView(), w.g.icon_return_s, w.g.icon_return_s_w, 0);
        com.baidu.tbadk.core.util.aq.c(this.gbm, w.e.cp_cont_g, 1);
    }
}
