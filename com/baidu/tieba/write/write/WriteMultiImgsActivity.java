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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.write.write.b;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class WriteMultiImgsActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, b.a {
    private com.baidu.tbadk.core.dialog.a gNL;
    private View gNO;
    private WriteImagesInfo gNy = null;
    private View rootView = null;
    private ViewPager bBg = null;
    private b gNz = null;
    private LinearLayout gNA = null;
    private RadioGroup bwb = null;
    private RadioButton gNB = null;
    private RadioButton gNC = null;
    private LinearLayout gND = null;
    private View gNE = null;
    private NavigationBar bcj = null;
    private TextView Ru = null;
    private TextView gNF = null;
    private String gNG = "";
    private String gNH = "";
    private String gNI = "";
    private String gNJ = "(1/1)";
    private boolean gNK = true;
    private HashMap<String, String> gNM = new HashMap<>();
    private int gNN = 0;
    private int gNP = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int af = com.baidu.adp.lib.b.d.eV().af("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || af == 1 || PluginPackageManager.jv().bs(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.gNK = false;
        } else {
            this.gNK = true;
        }
        setContentView(d.j.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.gNK) {
            if (this.gNy != null) {
                i = this.gNy.size();
                i2 = this.gNy.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.gNz.getCurrentIndex());
        this.gNz.bAY();
        bundle.putString("OutState_Write_Img_Info", this.gNy.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.gNG = getResources().getString(d.l.beautify);
        this.gNH = getResources().getString(d.l.rotate);
        this.gNI = this.gNG;
        this.rootView = findViewById(d.h.write_multi_imgs_rootlayout);
        this.bBg = (ViewPager) findViewById(d.h.write_multi_imgs_viewpager);
        this.gNA = (LinearLayout) findViewById(d.h.write_multi_imgs_beautify);
        this.bwb = (RadioGroup) findViewById(d.h.beautify_tabs);
        this.gNB = (RadioButton) findViewById(d.h.beautify_btn);
        this.gNC = (RadioButton) findViewById(d.h.rotate_btn);
        this.gNB.setOnCheckedChangeListener(this);
        this.gNC.setOnCheckedChangeListener(this);
        this.gND = (LinearLayout) findViewById(d.h.filters_layout);
        this.gNE = findViewById(d.h.rotate);
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
                WriteMultiImgsActivity.this.gNz.vk(Integer.parseInt(view.getTag().toString()));
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        this.bcj = (NavigationBar) findViewById(d.h.write_multi_imgs_navibar);
        this.gNO = this.bcj.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteMultiImgsActivity.this.setResult(0);
                WriteMultiImgsActivity.this.finish();
            }
        });
        this.gNF = this.bcj.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(d.l.done), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteMultiImgsActivity.this.gNz.bAY();
                if (WriteMultiImgsActivity.this.gNy == null || WriteMultiImgsActivity.this.gNy.getChosedFiles() == null || WriteMultiImgsActivity.this.gNy.getChosedFiles().size() <= 0 || !WriteMultiImgsActivity.this.gNy.isOriginalImg() || WriteMultiImgsActivity.this.gNN <= 0 || !WriteMultiImgsActivity.this.bBM()) {
                    WriteMultiImgsActivity.this.bBP();
                    return;
                }
                if (WriteMultiImgsActivity.this.gNL == null) {
                    WriteMultiImgsActivity.this.gNL = new com.baidu.tbadk.core.dialog.a(WriteMultiImgsActivity.this.getActivity());
                    WriteMultiImgsActivity.this.gNL.cd(d.l.orginal_conflict_tip);
                    WriteMultiImgsActivity.this.gNL.a(d.l.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.3.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            if (WriteMultiImgsActivity.this.gNL != null) {
                                WriteMultiImgsActivity.this.gNL.dismiss();
                            }
                            WriteMultiImgsActivity.this.bBP();
                        }
                    });
                    WriteMultiImgsActivity.this.gNL.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.3.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            if (WriteMultiImgsActivity.this.gNL != null) {
                                WriteMultiImgsActivity.this.gNL.dismiss();
                            }
                            WriteMultiImgsActivity.this.setResult(0);
                            WriteMultiImgsActivity.this.finish();
                        }
                    });
                    WriteMultiImgsActivity.this.gNL.b(WriteMultiImgsActivity.this.getPageContext());
                }
                WriteMultiImgsActivity.this.gNL.ti();
            }
        });
        this.Ru = this.bcj.setTitleText(getPageContext().getString(d.l.beautify));
        this.gNB.setChecked(true);
        if (!this.gNK) {
            this.gNC.setChecked(true);
            this.gNC.setPadding(0, this.gNC.getPaddingTop(), this.gNC.getPaddingRight(), this.gNC.getPaddingBottom());
            this.gND.setVisibility(8);
            this.gNB.setVisibility(8);
            this.bwb.setVisibility(8);
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
            this.gNy = new WriteImagesInfo();
            this.gNy.parseJson(str);
            bBL();
            this.gNz = new b(this, this.bBg, this.gNy.getChosedFiles(), i, this);
            this.bBg.setAdapter(this.gNz);
            this.bBg.setCurrentItem(i, true);
            if (i == 0) {
                this.gNz.onPageSelected(0);
            }
            this.gNA.setVisibility(0);
        }
    }

    private void bBL() {
        if (this.gNy != null && this.gNy.isOriginalImg() && this.gNy.getChosedFiles() != null && this.gNy.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.gNy.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.gNM.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bBM() {
        if (this.gNy == null || !this.gNy.isOriginalImg() || this.gNy.getChosedFiles() == null || this.gNy.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.gNy.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.gNM.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bAZ() {
        if (this.bcj.getVisibility() == 0) {
            this.bcj.setVisibility(8);
            this.gNA.setVisibility(8);
            return;
        }
        this.bcj.setVisibility(0);
        this.gNA.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void a(com.baidu.tbadk.coreExtra.view.a aVar, int i) {
        this.gND.removeAllViews();
        this.gND.addView(aVar);
        this.gNJ = "（" + (i + 1) + "/" + this.gNy.size() + "）";
        this.Ru.setText(this.gNI + this.gNJ);
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bBb() {
        this.gNP--;
        if (this.gNP == 0) {
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bBa() {
        this.gNP++;
        if (this.gNP > 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bBN() {
        this.gNN++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bBO() {
        this.gNN--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBP() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.gNy.toJsonString());
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
            if (compoundButton == this.gNB) {
                this.gND.setVisibility(0);
                this.gNE.setVisibility(8);
                this.gNI = this.gNG;
                this.Ru.setText(this.gNI + this.gNJ);
                return;
            }
            this.gND.setVisibility(8);
            this.gNE.setVisibility(0);
            this.gNI = this.gNH;
            this.Ru.setText(this.gNI + this.gNJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().ai(i == 1);
        getLayoutMode().t(this.rootView);
        aBp();
    }

    private void aBp() {
        aj.k(this.bcj, d.e.common_color_10222);
        aj.c(this.Ru, d.e.cp_cont_g, 1);
        aj.b(this.bcj.getBackImageView(), d.g.icon_return_s, d.g.icon_return_s_w, 0);
        aj.c(this.gNF, d.e.cp_cont_g, 1);
    }
}
