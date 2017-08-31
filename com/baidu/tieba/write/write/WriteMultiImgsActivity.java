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
    private com.baidu.tbadk.core.dialog.a gHV;
    private View gHY;
    private WriteImagesInfo gHI = null;
    private View rootView = null;
    private ViewPager byG = null;
    private b gHJ = null;
    private LinearLayout gHK = null;
    private RadioGroup btC = null;
    private RadioButton gHL = null;
    private RadioButton gHM = null;
    private LinearLayout gHN = null;
    private View gHO = null;
    private NavigationBar baz = null;
    private TextView Ri = null;
    private TextView gHP = null;
    private String gHQ = "";
    private String gHR = "";
    private String gHS = "";
    private String gHT = "(1/1)";
    private boolean gHU = true;
    private HashMap<String, String> gHW = new HashMap<>();
    private int gHX = 0;
    private int gHZ = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int af = com.baidu.adp.lib.b.d.eW().af("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || af == 1 || PluginPackageManager.jw().bs(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.gHU = false;
        } else {
            this.gHU = true;
        }
        setContentView(d.j.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.gHU) {
            if (this.gHI != null) {
                i = this.gHI.size();
                i2 = this.gHI.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.gHJ.getCurrentIndex());
        this.gHJ.bzz();
        bundle.putString("OutState_Write_Img_Info", this.gHI.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.gHQ = getResources().getString(d.l.beautify);
        this.gHR = getResources().getString(d.l.rotate);
        this.gHS = this.gHQ;
        this.rootView = findViewById(d.h.write_multi_imgs_rootlayout);
        this.byG = (ViewPager) findViewById(d.h.write_multi_imgs_viewpager);
        this.gHK = (LinearLayout) findViewById(d.h.write_multi_imgs_beautify);
        this.btC = (RadioGroup) findViewById(d.h.beautify_tabs);
        this.gHL = (RadioButton) findViewById(d.h.beautify_btn);
        this.gHM = (RadioButton) findViewById(d.h.rotate_btn);
        this.gHL.setOnCheckedChangeListener(this);
        this.gHM.setOnCheckedChangeListener(this);
        this.gHN = (LinearLayout) findViewById(d.h.filters_layout);
        this.gHO = findViewById(d.h.rotate);
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
                WriteMultiImgsActivity.this.gHJ.uM(Integer.parseInt(view.getTag().toString()));
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        this.baz = (NavigationBar) findViewById(d.h.write_multi_imgs_navibar);
        this.gHY = this.baz.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteMultiImgsActivity.this.setResult(0);
                WriteMultiImgsActivity.this.finish();
            }
        });
        this.gHP = this.baz.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(d.l.done), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteMultiImgsActivity.this.gHJ.bzz();
                if (WriteMultiImgsActivity.this.gHI == null || WriteMultiImgsActivity.this.gHI.getChosedFiles() == null || WriteMultiImgsActivity.this.gHI.getChosedFiles().size() <= 0 || !WriteMultiImgsActivity.this.gHI.isOriginalImg() || WriteMultiImgsActivity.this.gHX <= 0 || !WriteMultiImgsActivity.this.bAn()) {
                    WriteMultiImgsActivity.this.bAq();
                    return;
                }
                if (WriteMultiImgsActivity.this.gHV == null) {
                    WriteMultiImgsActivity.this.gHV = new com.baidu.tbadk.core.dialog.a(WriteMultiImgsActivity.this.getActivity());
                    WriteMultiImgsActivity.this.gHV.cc(d.l.orginal_conflict_tip);
                    WriteMultiImgsActivity.this.gHV.a(d.l.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.3.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            if (WriteMultiImgsActivity.this.gHV != null) {
                                WriteMultiImgsActivity.this.gHV.dismiss();
                            }
                            WriteMultiImgsActivity.this.bAq();
                        }
                    });
                    WriteMultiImgsActivity.this.gHV.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.3.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            if (WriteMultiImgsActivity.this.gHV != null) {
                                WriteMultiImgsActivity.this.gHV.dismiss();
                            }
                            WriteMultiImgsActivity.this.setResult(0);
                            WriteMultiImgsActivity.this.finish();
                        }
                    });
                    WriteMultiImgsActivity.this.gHV.b(WriteMultiImgsActivity.this.getPageContext());
                }
                WriteMultiImgsActivity.this.gHV.to();
            }
        });
        this.Ri = this.baz.setTitleText(getPageContext().getString(d.l.beautify));
        this.gHL.setChecked(true);
        if (!this.gHU) {
            this.gHM.setChecked(true);
            this.gHM.setPadding(0, this.gHM.getPaddingTop(), this.gHM.getPaddingRight(), this.gHM.getPaddingBottom());
            this.gHN.setVisibility(8);
            this.gHL.setVisibility(8);
            this.btC.setVisibility(8);
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
            this.gHI = new WriteImagesInfo();
            this.gHI.parseJson(str);
            bAm();
            this.gHJ = new b(this, this.byG, this.gHI.getChosedFiles(), i, this);
            this.byG.setAdapter(this.gHJ);
            this.byG.setCurrentItem(i, true);
            if (i == 0) {
                this.gHJ.onPageSelected(0);
            }
            this.gHK.setVisibility(0);
        }
    }

    private void bAm() {
        if (this.gHI != null && this.gHI.isOriginalImg() && this.gHI.getChosedFiles() != null && this.gHI.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.gHI.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.gHW.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bAn() {
        if (this.gHI == null || !this.gHI.isOriginalImg() || this.gHI.getChosedFiles() == null || this.gHI.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.gHI.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.gHW.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bzA() {
        if (this.baz.getVisibility() == 0) {
            this.baz.setVisibility(8);
            this.gHK.setVisibility(8);
            return;
        }
        this.baz.setVisibility(0);
        this.gHK.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void a(com.baidu.tbadk.coreExtra.view.a aVar, int i) {
        this.gHN.removeAllViews();
        this.gHN.addView(aVar);
        this.gHT = "（" + (i + 1) + "/" + this.gHI.size() + "）";
        this.Ri.setText(this.gHS + this.gHT);
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bzC() {
        this.gHZ--;
        if (this.gHZ == 0) {
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bzB() {
        this.gHZ++;
        if (this.gHZ > 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bAo() {
        this.gHX++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bAp() {
        this.gHX--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAq() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.gHI.toJsonString());
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
            if (compoundButton == this.gHL) {
                this.gHN.setVisibility(0);
                this.gHO.setVisibility(8);
                this.gHS = this.gHQ;
                this.Ri.setText(this.gHS + this.gHT);
                return;
            }
            this.gHN.setVisibility(8);
            this.gHO.setVisibility(0);
            this.gHS = this.gHR;
            this.Ri.setText(this.gHS + this.gHT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.rootView);
        aCt();
    }

    private void aCt() {
        aj.k(this.baz, d.e.common_color_10222);
        aj.c(this.Ri, d.e.cp_cont_g, 1);
        aj.b(this.baz.getBackImageView(), d.g.icon_return_s, d.g.icon_return_s_w, 0);
        aj.c(this.gHP, d.e.cp_cont_g, 1);
    }
}
