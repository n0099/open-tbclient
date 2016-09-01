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
import com.baidu.tieba.write.write.r;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class WriteMultiImgsActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, r.a {
    private com.baidu.tbadk.core.dialog.a gfY;
    private View ggb;
    private WriteImagesInfo gfL = null;
    private View aAV = null;
    private ViewPager fHz = null;
    private r gfM = null;
    private LinearLayout gfN = null;
    private RadioGroup Hu = null;
    private RadioButton gfO = null;
    private RadioButton gfP = null;
    private LinearLayout gfQ = null;
    private View gfR = null;
    private NavigationBar aUG = null;
    private TextView MO = null;
    private TextView gfS = null;
    private String gfT = "";
    private String gfU = "";
    private String gfV = "";
    private String gfW = "(1/1)";
    private boolean gfX = true;
    private HashMap<String, String> gfZ = new HashMap<>();
    private int gga = 0;
    private int ggc = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int ac = com.baidu.adp.lib.c.e.dN().ac("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || ac == 1 || PluginPackageManager.iB().bu(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.gfX = false;
        } else {
            this.gfX = true;
        }
        setContentView(t.h.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.gfX) {
            if (this.gfL != null) {
                i = this.gfL.size();
                i2 = this.gfL.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m9getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.gfM.getCurrentIndex());
        this.gfM.btc();
        bundle.putString("OutState_Write_Img_Info", this.gfL.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.gfT = getResources().getString(t.j.beautify);
        this.gfU = getResources().getString(t.j.rotate);
        this.gfV = this.gfT;
        this.aAV = findViewById(t.g.write_multi_imgs_rootlayout);
        this.fHz = (ViewPager) findViewById(t.g.write_multi_imgs_viewpager);
        this.gfN = (LinearLayout) findViewById(t.g.write_multi_imgs_beautify);
        this.Hu = (RadioGroup) findViewById(t.g.beautify_tabs);
        this.gfO = (RadioButton) findViewById(t.g.beautify_btn);
        this.gfP = (RadioButton) findViewById(t.g.rotate_btn);
        this.gfO.setOnCheckedChangeListener(this);
        this.gfP.setOnCheckedChangeListener(this);
        this.gfQ = (LinearLayout) findViewById(t.g.filters_layout);
        this.gfR = findViewById(t.g.rotate);
        Button button = (Button) findViewById(t.g.rotate_left);
        Button button2 = (Button) findViewById(t.g.rotate_right);
        Button button3 = (Button) findViewById(t.g.rotate_left_right);
        Button button4 = (Button) findViewById(t.g.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        ca caVar = new ca(this);
        button.setOnClickListener(caVar);
        button2.setOnClickListener(caVar);
        button3.setOnClickListener(caVar);
        button4.setOnClickListener(caVar);
        this.aUG = (NavigationBar) findViewById(t.g.write_multi_imgs_navibar);
        this.ggb = this.aUG.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new cb(this));
        this.gfS = this.aUG.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(t.j.done), new cc(this));
        this.MO = this.aUG.setTitleText(getPageContext().getString(t.j.beautify));
        this.gfO.setChecked(true);
        if (!this.gfX) {
            this.gfP.setChecked(true);
            this.gfP.setPadding(0, this.gfP.getPaddingTop(), this.gfP.getPaddingRight(), this.gfP.getPaddingBottom());
            this.gfQ.setVisibility(8);
            this.gfO.setVisibility(8);
            this.Hu.setVisibility(8);
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
            this.gfL = new WriteImagesInfo();
            this.gfL.parseJson(str);
            btN();
            this.gfM = new r(this, this.fHz, this.gfL.getChosedFiles(), i, this);
            this.fHz.setAdapter(this.gfM);
            this.fHz.setCurrentItem(i, true);
            if (i == 0) {
                this.gfM.onPageSelected(0);
            }
            this.gfN.setVisibility(0);
        }
    }

    private void btN() {
        if (this.gfL != null && this.gfL.isOriginalImg() && this.gfL.getChosedFiles() != null && this.gfL.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.gfL.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.gfZ.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean btO() {
        if (this.gfL == null || !this.gfL.isOriginalImg() || this.gfL.getChosedFiles() == null || this.gfL.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.gfL.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.gfZ.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void btd() {
        if (this.aUG.getVisibility() == 0) {
            this.aUG.setVisibility(8);
            this.gfN.setVisibility(8);
            return;
        }
        this.aUG.setVisibility(0);
        this.gfN.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void a(com.baidu.tbadk.coreExtra.view.c cVar, int i) {
        this.gfQ.removeAllViews();
        this.gfQ.addView(cVar);
        this.gfW = "（" + (i + 1) + "/" + this.gfL.size() + "）";
        this.MO.setText(String.valueOf(this.gfV) + this.gfW);
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void btf() {
        this.ggc--;
    }

    @Override // com.baidu.tieba.write.write.r.a
    public void bte() {
        this.ggc++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void btP() {
        this.gga++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void btQ() {
        this.gga--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btR() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.gfL.toJsonString());
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
            if (compoundButton == this.gfO) {
                this.gfQ.setVisibility(0);
                this.gfR.setVisibility(8);
                this.gfV = this.gfT;
                this.MO.setText(String.valueOf(this.gfV) + this.gfW);
                return;
            }
            this.gfQ.setVisibility(8);
            this.gfR.setVisibility(0);
            this.gfV = this.gfU;
            this.MO.setText(String.valueOf(this.gfV) + this.gfW);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ah(i == 1);
        getLayoutMode().x(this.aAV);
        azO();
    }

    private void azO() {
        com.baidu.tbadk.core.util.av.l(this.aUG, t.d.common_color_10222);
        com.baidu.tbadk.core.util.av.c(this.MO, t.d.cp_cont_g, 1);
        com.baidu.tbadk.core.util.av.a(this.aUG.getBackImageView(), t.f.icon_return_s, t.f.icon_return_s_w, 0);
        com.baidu.tbadk.core.util.av.c(this.gfS, t.d.cp_cont_g, 1);
    }
}
