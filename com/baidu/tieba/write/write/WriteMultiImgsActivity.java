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
    private com.baidu.tbadk.core.dialog.a dsA;
    private WriteImagesInfo dsn = null;
    private View rootView = null;
    private ViewPager caX = null;
    private q dso = null;
    private LinearLayout dsp = null;
    private RadioGroup MT = null;
    private RadioButton dsq = null;
    private RadioButton dsr = null;
    private LinearLayout dss = null;
    private View dst = null;
    private NavigationBar aGn = null;
    private TextView aIX = null;
    private TextView dsu = null;
    private String dsv = "";
    private String dsw = "";
    private String dsx = "";
    private String dsy = "(1/1)";
    private boolean dsz = true;
    private HashMap<String, String> dsB = new HashMap<>();
    private int dsC = 0;
    private int dsD = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int af = com.baidu.adp.lib.b.e.gv().af("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || af == 1 || PluginPackageManager.lS().bu(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.dsz = false;
        } else {
            this.dsz = true;
        }
        setContentView(i.g.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.dsz) {
            if (this.dsn != null) {
                i = this.dsn.size();
                i2 = this.dsn.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.m411getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.dso.getCurrentIndex());
        this.dso.aDN();
        bundle.putString("OutState_Write_Img_Info", this.dsn.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.dsv = getResources().getString(i.h.beautify);
        this.dsw = getResources().getString(i.h.rotate);
        this.dsx = this.dsv;
        this.rootView = findViewById(i.f.write_multi_imgs_rootlayout);
        this.caX = (ViewPager) findViewById(i.f.write_multi_imgs_viewpager);
        this.dsp = (LinearLayout) findViewById(i.f.write_multi_imgs_beautify);
        this.MT = (RadioGroup) findViewById(i.f.beautify_tabs);
        this.dsq = (RadioButton) findViewById(i.f.beautify_btn);
        this.dsr = (RadioButton) findViewById(i.f.rotate_btn);
        this.dsq.setOnCheckedChangeListener(this);
        this.dsr.setOnCheckedChangeListener(this);
        this.dss = (LinearLayout) findViewById(i.f.filters_layout);
        this.dst = findViewById(i.f.rotate);
        Button button = (Button) findViewById(i.f.rotate_left);
        Button button2 = (Button) findViewById(i.f.rotate_right);
        Button button3 = (Button) findViewById(i.f.rotate_left_right);
        Button button4 = (Button) findViewById(i.f.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        ca caVar = new ca(this);
        button.setOnClickListener(caVar);
        button2.setOnClickListener(caVar);
        button3.setOnClickListener(caVar);
        button4.setOnClickListener(caVar);
        this.aGn = (NavigationBar) findViewById(i.f.write_multi_imgs_navibar);
        this.aGn.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new cb(this));
        this.dsu = this.aGn.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(i.h.done), new cc(this));
        this.aIX = this.aGn.setTitleText(getPageContext().getString(i.h.beautify));
        this.dsq.setChecked(true);
        if (!this.dsz) {
            this.dsr.setChecked(true);
            this.dsr.setPadding(0, this.dsr.getPaddingTop(), this.dsr.getPaddingRight(), this.dsr.getPaddingBottom());
            this.dss.setVisibility(8);
            this.dsq.setVisibility(8);
            this.MT.setVisibility(8);
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
            this.dsn = new WriteImagesInfo();
            this.dsn.parseJson(str);
            aEy();
            this.dso = new q(this, this.caX, this.dsn.getChosedFiles(), i, this);
            this.caX.setAdapter(this.dso);
            this.caX.setCurrentItem(i, true);
            if (i == 0) {
                this.dso.onPageSelected(0);
            }
            this.dsp.setVisibility(0);
        }
    }

    private void aEy() {
        if (this.dsn != null && this.dsn.isOriginalImg() && this.dsn.getChosedFiles() != null && this.dsn.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.dsn.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.dsB.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aEz() {
        if (this.dsn == null || !this.dsn.isOriginalImg() || this.dsn.getChosedFiles() == null || this.dsn.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.dsn.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.dsB.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void aDO() {
        if (this.aGn.getVisibility() == 0) {
            this.aGn.setVisibility(8);
            this.dsp.setVisibility(8);
            return;
        }
        this.aGn.setVisibility(0);
        this.dsp.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void a(com.baidu.tbadk.coreExtra.view.d dVar, int i) {
        this.dss.removeAllViews();
        this.dss.addView(dVar);
        this.dsy = "（" + (i + 1) + "/" + this.dsn.size() + "）";
        this.aIX.setText(String.valueOf(this.dsx) + this.dsy);
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void aDQ() {
        this.dsD--;
    }

    @Override // com.baidu.tieba.write.write.q.a
    public void aDP() {
        this.dsD++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aEA() {
        this.dsC++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aEB() {
        this.dsC--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEC() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.dsn.toJsonString());
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
            if (compoundButton == this.dsq) {
                this.dss.setVisibility(0);
                this.dst.setVisibility(8);
                this.dsx = this.dsv;
                this.aIX.setText(String.valueOf(this.dsx) + this.dsy);
                return;
            }
            this.dss.setVisibility(8);
            this.dst.setVisibility(0);
            this.dsx = this.dsw;
            this.aIX.setText(String.valueOf(this.dsx) + this.dsy);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.rootView);
        this.aGn.onChangeSkinType(getPageContext(), i);
        if (this.dsu.isEnabled()) {
            com.baidu.tbadk.core.util.an.i((View) this.dsu, i.e.navi_done_text_bg);
            com.baidu.tbadk.core.util.an.b(this.dsu, i.c.navi_done_text, 1);
            return;
        }
        com.baidu.tbadk.core.util.an.i((View) this.dsu, i.e.btn_titlebar_finish_d);
        com.baidu.tbadk.core.util.an.b(this.dsu, i.c.navi_done_text_d, 1);
    }
}
