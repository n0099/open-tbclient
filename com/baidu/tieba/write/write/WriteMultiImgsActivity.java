package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
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
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.write.write.b;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class WriteMultiImgsActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, b.a {
    private View gHA;
    private com.baidu.tbadk.core.dialog.a gHx;
    private WriteImagesInfo gHk = null;
    private View rootView = null;
    private ViewPager bxe = null;
    private b gHl = null;
    private LinearLayout gHm = null;
    private RadioGroup ePo = null;
    private RadioButton gHn = null;
    private RadioButton gHo = null;
    private LinearLayout gHp = null;
    private View gHq = null;
    private NavigationBar baN = null;
    private TextView Se = null;
    private TextView gHr = null;
    private String gHs = "";
    private String gHt = "";
    private String gHu = "";
    private String gHv = "(1/1)";
    private boolean gHw = true;
    private HashMap<String, String> gHy = new HashMap<>();
    private int gHz = 0;
    private int gHB = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int al = com.baidu.adp.lib.b.d.fh().al("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || al == 1 || PluginPackageManager.jE().bv(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.gHw = false;
        } else {
            this.gHw = true;
        }
        setContentView(d.j.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.gHw) {
            if (this.gHk != null) {
                i = this.gHk.size();
                i2 = this.gHk.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.gHl.getCurrentIndex());
        this.gHl.bzK();
        bundle.putString("OutState_Write_Img_Info", this.gHk.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.gHs = getResources().getString(d.l.beautify);
        this.gHt = getResources().getString(d.l.rotate);
        this.gHu = this.gHs;
        this.rootView = findViewById(d.h.write_multi_imgs_rootlayout);
        this.bxe = (ViewPager) findViewById(d.h.write_multi_imgs_viewpager);
        this.gHm = (LinearLayout) findViewById(d.h.write_multi_imgs_beautify);
        this.ePo = (RadioGroup) findViewById(d.h.beautify_tabs);
        this.gHn = (RadioButton) findViewById(d.h.beautify_btn);
        this.gHo = (RadioButton) findViewById(d.h.rotate_btn);
        this.gHn.setOnCheckedChangeListener(this);
        this.gHo.setOnCheckedChangeListener(this);
        this.gHp = (LinearLayout) findViewById(d.h.filters_layout);
        this.gHq = findViewById(d.h.rotate);
        Button button = (Button) findViewById(d.h.rotate_left);
        Button button2 = (Button) findViewById(d.h.rotate_right);
        Button button3 = (Button) findViewById(d.h.rotate_left_right);
        Button button4 = (Button) findViewById(d.h.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteMultiImgsActivity.this.gHl.uB(Integer.parseInt(view.getTag().toString()));
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        this.baN = (NavigationBar) findViewById(d.h.write_multi_imgs_navibar);
        this.gHA = this.baN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteMultiImgsActivity.this.setResult(0);
                WriteMultiImgsActivity.this.finish();
            }
        });
        this.gHr = this.baN.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(d.l.done), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteMultiImgsActivity.this.gHl.bzK();
                if (WriteMultiImgsActivity.this.gHk == null || WriteMultiImgsActivity.this.gHk.getChosedFiles() == null || WriteMultiImgsActivity.this.gHk.getChosedFiles().size() <= 0 || !WriteMultiImgsActivity.this.gHk.isOriginalImg() || WriteMultiImgsActivity.this.gHz <= 0 || !WriteMultiImgsActivity.this.bAy()) {
                    WriteMultiImgsActivity.this.bAB();
                    return;
                }
                if (WriteMultiImgsActivity.this.gHx == null) {
                    WriteMultiImgsActivity.this.gHx = new com.baidu.tbadk.core.dialog.a(WriteMultiImgsActivity.this.getActivity());
                    WriteMultiImgsActivity.this.gHx.cc(d.l.orginal_conflict_tip);
                    WriteMultiImgsActivity.this.gHx.a(d.l.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.3.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            if (WriteMultiImgsActivity.this.gHx != null) {
                                WriteMultiImgsActivity.this.gHx.dismiss();
                            }
                            WriteMultiImgsActivity.this.bAB();
                        }
                    });
                    WriteMultiImgsActivity.this.gHx.b(d.l.alert_no_button, new a.b() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.3.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            if (WriteMultiImgsActivity.this.gHx != null) {
                                WriteMultiImgsActivity.this.gHx.dismiss();
                            }
                            WriteMultiImgsActivity.this.setResult(0);
                            WriteMultiImgsActivity.this.finish();
                        }
                    });
                    WriteMultiImgsActivity.this.gHx.b(WriteMultiImgsActivity.this.getPageContext());
                }
                WriteMultiImgsActivity.this.gHx.tr();
            }
        });
        this.Se = this.baN.setTitleText(getPageContext().getString(d.l.beautify));
        this.gHn.setChecked(true);
        if (!this.gHw) {
            this.gHo.setChecked(true);
            this.gHo.setPadding(0, this.gHo.getPaddingTop(), this.gHo.getPaddingRight(), this.gHo.getPaddingBottom());
            this.gHp.setVisibility(8);
            this.gHn.setVisibility(8);
            this.ePo.setVisibility(8);
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
            this.gHk = new WriteImagesInfo();
            this.gHk.parseJson(str);
            bAx();
            this.gHl = new b(this, this.bxe, this.gHk.getChosedFiles(), i, this);
            this.bxe.setAdapter(this.gHl);
            this.bxe.setCurrentItem(i, true);
            if (i == 0) {
                this.gHl.onPageSelected(0);
            }
            this.gHm.setVisibility(0);
        }
    }

    private void bAx() {
        if (this.gHk != null && this.gHk.isOriginalImg() && this.gHk.getChosedFiles() != null && this.gHk.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.gHk.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.gHy.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bAy() {
        if (this.gHk == null || !this.gHk.isOriginalImg() || this.gHk.getChosedFiles() == null || this.gHk.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.gHk.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.gHy.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bzL() {
        if (this.baN.getVisibility() == 0) {
            this.baN.setVisibility(8);
            this.gHm.setVisibility(8);
            return;
        }
        this.baN.setVisibility(0);
        this.gHm.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void a(com.baidu.tbadk.coreExtra.view.a aVar, int i) {
        this.gHp.removeAllViews();
        this.gHp.addView(aVar);
        this.gHv = "（" + (i + 1) + "/" + this.gHk.size() + "）";
        this.Se.setText(this.gHu + this.gHv);
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bzN() {
        this.gHB--;
        if (this.gHB == 0) {
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bzM() {
        this.gHB++;
        if (this.gHB > 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bAz() {
        this.gHz++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bAA() {
        this.gHz--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAB() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.gHk.toJsonString());
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
            if (compoundButton == this.gHn) {
                this.gHp.setVisibility(0);
                this.gHq.setVisibility(8);
                this.gHu = this.gHs;
                this.Se.setText(this.gHu + this.gHv);
                return;
            }
            this.gHp.setVisibility(8);
            this.gHq.setVisibility(0);
            this.gHu = this.gHt;
            this.Se.setText(this.gHu + this.gHv);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.rootView);
        aAc();
    }

    private void aAc() {
        ai.k(this.baN, d.e.common_color_10222);
        ai.c(this.Se, d.e.cp_cont_g, 1);
        ai.a(this.baN.getBackImageView(), d.g.icon_return_s, d.g.icon_return_s_w, 0);
        ai.c(this.gHr, d.e.cp_cont_g, 1);
    }
}
