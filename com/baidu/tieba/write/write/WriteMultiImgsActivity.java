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
    private com.baidu.tbadk.core.dialog.a gYO;
    private View gYR;
    private WriteImagesInfo gYB = null;
    private View rootView = null;
    private ViewPager bHF = null;
    private b gYC = null;
    private LinearLayout gYD = null;
    private RadioGroup bBI = null;
    private RadioButton gYE = null;
    private RadioButton gYF = null;
    private LinearLayout gYG = null;
    private View gYH = null;
    private NavigationBar bcK = null;
    private TextView Rz = null;
    private TextView gYI = null;
    private String gYJ = "";
    private String gYK = "";
    private String gYL = "";
    private String gYM = "(1/1)";
    private boolean gYN = true;
    private HashMap<String, String> gYP = new HashMap<>();
    private int gYQ = 0;
    private int gYS = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int af = com.baidu.adp.lib.b.d.eV().af("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || af == 1 || PluginPackageManager.js().bs(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.gYN = false;
        } else {
            this.gYN = true;
        }
        setContentView(d.h.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.gYN) {
            if (this.gYB != null) {
                i = this.gYB.size();
                i2 = this.gYB.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.gYC.getCurrentIndex());
        this.gYC.bEB();
        bundle.putString("OutState_Write_Img_Info", this.gYB.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.gYJ = getResources().getString(d.j.beautify);
        this.gYK = getResources().getString(d.j.rotate);
        this.gYL = this.gYJ;
        this.rootView = findViewById(d.g.write_multi_imgs_rootlayout);
        this.bHF = (ViewPager) findViewById(d.g.write_multi_imgs_viewpager);
        this.gYD = (LinearLayout) findViewById(d.g.write_multi_imgs_beautify);
        this.bBI = (RadioGroup) findViewById(d.g.beautify_tabs);
        this.gYE = (RadioButton) findViewById(d.g.beautify_btn);
        this.gYF = (RadioButton) findViewById(d.g.rotate_btn);
        this.gYE.setOnCheckedChangeListener(this);
        this.gYF.setOnCheckedChangeListener(this);
        this.gYG = (LinearLayout) findViewById(d.g.filters_layout);
        this.gYH = findViewById(d.g.rotate);
        Button button = (Button) findViewById(d.g.rotate_left);
        Button button2 = (Button) findViewById(d.g.rotate_right);
        Button button3 = (Button) findViewById(d.g.rotate_left_right);
        Button button4 = (Button) findViewById(d.g.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteMultiImgsActivity.this.gYC.vI(Integer.parseInt(view.getTag().toString()));
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        this.bcK = (NavigationBar) findViewById(d.g.write_multi_imgs_navibar);
        this.gYR = this.bcK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteMultiImgsActivity.this.setResult(0);
                WriteMultiImgsActivity.this.finish();
            }
        });
        this.gYI = this.bcK.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(d.j.done), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteMultiImgsActivity.this.gYC.bEB();
                if (WriteMultiImgsActivity.this.gYB == null || WriteMultiImgsActivity.this.gYB.getChosedFiles() == null || WriteMultiImgsActivity.this.gYB.getChosedFiles().size() <= 0 || !WriteMultiImgsActivity.this.gYB.isOriginalImg() || WriteMultiImgsActivity.this.gYQ <= 0 || !WriteMultiImgsActivity.this.bFp()) {
                    WriteMultiImgsActivity.this.bFs();
                    return;
                }
                if (WriteMultiImgsActivity.this.gYO == null) {
                    WriteMultiImgsActivity.this.gYO = new com.baidu.tbadk.core.dialog.a(WriteMultiImgsActivity.this.getActivity());
                    WriteMultiImgsActivity.this.gYO.cc(d.j.orginal_conflict_tip);
                    WriteMultiImgsActivity.this.gYO.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.3.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            if (WriteMultiImgsActivity.this.gYO != null) {
                                WriteMultiImgsActivity.this.gYO.dismiss();
                            }
                            WriteMultiImgsActivity.this.bFs();
                        }
                    });
                    WriteMultiImgsActivity.this.gYO.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.3.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            if (WriteMultiImgsActivity.this.gYO != null) {
                                WriteMultiImgsActivity.this.gYO.dismiss();
                            }
                            WriteMultiImgsActivity.this.setResult(0);
                            WriteMultiImgsActivity.this.finish();
                        }
                    });
                    WriteMultiImgsActivity.this.gYO.b(WriteMultiImgsActivity.this.getPageContext());
                }
                WriteMultiImgsActivity.this.gYO.th();
            }
        });
        this.Rz = this.bcK.setTitleText(getPageContext().getString(d.j.beautify));
        this.gYE.setChecked(true);
        if (!this.gYN) {
            this.gYF.setChecked(true);
            this.gYF.setPadding(0, this.gYF.getPaddingTop(), this.gYF.getPaddingRight(), this.gYF.getPaddingBottom());
            this.gYG.setVisibility(8);
            this.gYE.setVisibility(8);
            this.bBI.setVisibility(8);
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
            this.gYB = new WriteImagesInfo();
            this.gYB.parseJson(str);
            bFo();
            this.gYC = new b(this, this.bHF, this.gYB.getChosedFiles(), i, this);
            this.bHF.setAdapter(this.gYC);
            this.bHF.setCurrentItem(i, true);
            if (i == 0) {
                this.gYC.onPageSelected(0);
            }
            this.gYD.setVisibility(0);
        }
    }

    private void bFo() {
        if (this.gYB != null && this.gYB.isOriginalImg() && this.gYB.getChosedFiles() != null && this.gYB.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.gYB.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.gYP.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bFp() {
        if (this.gYB == null || !this.gYB.isOriginalImg() || this.gYB.getChosedFiles() == null || this.gYB.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.gYB.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.gYP.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bEC() {
        if (this.bcK.getVisibility() == 0) {
            this.bcK.setVisibility(8);
            this.gYD.setVisibility(8);
            return;
        }
        this.bcK.setVisibility(0);
        this.gYD.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void a(com.baidu.tbadk.coreExtra.view.a aVar, int i) {
        this.gYG.removeAllViews();
        this.gYG.addView(aVar);
        this.gYM = "（" + (i + 1) + "/" + this.gYB.size() + "）";
        this.Rz.setText(this.gYL + this.gYM);
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bEE() {
        this.gYS--;
        if (this.gYS == 0) {
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bED() {
        this.gYS++;
        if (this.gYS > 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bFq() {
        this.gYQ++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bFr() {
        this.gYQ--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFs() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.gYB.toJsonString());
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
            if (compoundButton == this.gYE) {
                this.gYG.setVisibility(0);
                this.gYH.setVisibility(8);
                this.gYL = this.gYJ;
                this.Rz.setText(this.gYL + this.gYM);
                return;
            }
            this.gYG.setVisibility(8);
            this.gYH.setVisibility(0);
            this.gYL = this.gYK;
            this.Rz.setText(this.gYL + this.gYM);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().ag(i == 1);
        getLayoutMode().t(this.rootView);
        aDJ();
    }

    private void aDJ() {
        aj.k(this.bcK, d.C0080d.common_color_10222);
        aj.c(this.Rz, d.C0080d.cp_cont_g, 1);
        aj.b(this.bcK.getBackImageView(), d.f.icon_topbar_return_s, d.f.icon_topbar_return_white_s, 0);
        aj.c(this.gYI, d.C0080d.cp_cont_g, 1);
    }
}
