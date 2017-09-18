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
    private com.baidu.tbadk.core.dialog.a gIO;
    private View gIR;
    private WriteImagesInfo gIB = null;
    private View rootView = null;
    private ViewPager bzv = null;
    private b gIC = null;
    private LinearLayout gID = null;
    private RadioGroup buq = null;
    private RadioButton gIE = null;
    private RadioButton gIF = null;
    private LinearLayout gIG = null;
    private View gIH = null;
    private NavigationBar baw = null;
    private TextView Ri = null;
    private TextView gII = null;
    private String gIJ = "";
    private String gIK = "";
    private String gIL = "";
    private String gIM = "(1/1)";
    private boolean gIN = true;
    private HashMap<String, String> gIP = new HashMap<>();
    private int gIQ = 0;
    private int gIS = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int af = com.baidu.adp.lib.b.d.eW().af("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || af == 1 || PluginPackageManager.jw().bs(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.gIN = false;
        } else {
            this.gIN = true;
        }
        setContentView(d.j.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.gIN) {
            if (this.gIB != null) {
                i = this.gIB.size();
                i2 = this.gIB.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.gIC.getCurrentIndex());
        this.gIC.bzK();
        bundle.putString("OutState_Write_Img_Info", this.gIB.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.gIJ = getResources().getString(d.l.beautify);
        this.gIK = getResources().getString(d.l.rotate);
        this.gIL = this.gIJ;
        this.rootView = findViewById(d.h.write_multi_imgs_rootlayout);
        this.bzv = (ViewPager) findViewById(d.h.write_multi_imgs_viewpager);
        this.gID = (LinearLayout) findViewById(d.h.write_multi_imgs_beautify);
        this.buq = (RadioGroup) findViewById(d.h.beautify_tabs);
        this.gIE = (RadioButton) findViewById(d.h.beautify_btn);
        this.gIF = (RadioButton) findViewById(d.h.rotate_btn);
        this.gIE.setOnCheckedChangeListener(this);
        this.gIF.setOnCheckedChangeListener(this);
        this.gIG = (LinearLayout) findViewById(d.h.filters_layout);
        this.gIH = findViewById(d.h.rotate);
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
                WriteMultiImgsActivity.this.gIC.uO(Integer.parseInt(view.getTag().toString()));
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        this.baw = (NavigationBar) findViewById(d.h.write_multi_imgs_navibar);
        this.gIR = this.baw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteMultiImgsActivity.this.setResult(0);
                WriteMultiImgsActivity.this.finish();
            }
        });
        this.gII = this.baw.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(d.l.done), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteMultiImgsActivity.this.gIC.bzK();
                if (WriteMultiImgsActivity.this.gIB == null || WriteMultiImgsActivity.this.gIB.getChosedFiles() == null || WriteMultiImgsActivity.this.gIB.getChosedFiles().size() <= 0 || !WriteMultiImgsActivity.this.gIB.isOriginalImg() || WriteMultiImgsActivity.this.gIQ <= 0 || !WriteMultiImgsActivity.this.bAy()) {
                    WriteMultiImgsActivity.this.bAB();
                    return;
                }
                if (WriteMultiImgsActivity.this.gIO == null) {
                    WriteMultiImgsActivity.this.gIO = new com.baidu.tbadk.core.dialog.a(WriteMultiImgsActivity.this.getActivity());
                    WriteMultiImgsActivity.this.gIO.cc(d.l.orginal_conflict_tip);
                    WriteMultiImgsActivity.this.gIO.a(d.l.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.3.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            if (WriteMultiImgsActivity.this.gIO != null) {
                                WriteMultiImgsActivity.this.gIO.dismiss();
                            }
                            WriteMultiImgsActivity.this.bAB();
                        }
                    });
                    WriteMultiImgsActivity.this.gIO.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.3.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            if (WriteMultiImgsActivity.this.gIO != null) {
                                WriteMultiImgsActivity.this.gIO.dismiss();
                            }
                            WriteMultiImgsActivity.this.setResult(0);
                            WriteMultiImgsActivity.this.finish();
                        }
                    });
                    WriteMultiImgsActivity.this.gIO.b(WriteMultiImgsActivity.this.getPageContext());
                }
                WriteMultiImgsActivity.this.gIO.to();
            }
        });
        this.Ri = this.baw.setTitleText(getPageContext().getString(d.l.beautify));
        this.gIE.setChecked(true);
        if (!this.gIN) {
            this.gIF.setChecked(true);
            this.gIF.setPadding(0, this.gIF.getPaddingTop(), this.gIF.getPaddingRight(), this.gIF.getPaddingBottom());
            this.gIG.setVisibility(8);
            this.gIE.setVisibility(8);
            this.buq.setVisibility(8);
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
            this.gIB = new WriteImagesInfo();
            this.gIB.parseJson(str);
            bAx();
            this.gIC = new b(this, this.bzv, this.gIB.getChosedFiles(), i, this);
            this.bzv.setAdapter(this.gIC);
            this.bzv.setCurrentItem(i, true);
            if (i == 0) {
                this.gIC.onPageSelected(0);
            }
            this.gID.setVisibility(0);
        }
    }

    private void bAx() {
        if (this.gIB != null && this.gIB.isOriginalImg() && this.gIB.getChosedFiles() != null && this.gIB.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.gIB.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.gIP.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bAy() {
        if (this.gIB == null || !this.gIB.isOriginalImg() || this.gIB.getChosedFiles() == null || this.gIB.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.gIB.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.gIP.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bzL() {
        if (this.baw.getVisibility() == 0) {
            this.baw.setVisibility(8);
            this.gID.setVisibility(8);
            return;
        }
        this.baw.setVisibility(0);
        this.gID.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void a(com.baidu.tbadk.coreExtra.view.a aVar, int i) {
        this.gIG.removeAllViews();
        this.gIG.addView(aVar);
        this.gIM = "（" + (i + 1) + "/" + this.gIB.size() + "）";
        this.Ri.setText(this.gIL + this.gIM);
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bzN() {
        this.gIS--;
        if (this.gIS == 0) {
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bzM() {
        this.gIS++;
        if (this.gIS > 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bAz() {
        this.gIQ++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bAA() {
        this.gIQ--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAB() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.gIB.toJsonString());
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
            if (compoundButton == this.gIE) {
                this.gIG.setVisibility(0);
                this.gIH.setVisibility(8);
                this.gIL = this.gIJ;
                this.Ri.setText(this.gIL + this.gIM);
                return;
            }
            this.gIG.setVisibility(8);
            this.gIH.setVisibility(0);
            this.gIL = this.gIK;
            this.Ri.setText(this.gIL + this.gIM);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.rootView);
        aCE();
    }

    private void aCE() {
        aj.k(this.baw, d.e.common_color_10222);
        aj.c(this.Ri, d.e.cp_cont_g, 1);
        aj.b(this.baw.getBackImageView(), d.g.icon_return_s, d.g.icon_return_s_w, 0);
        aj.c(this.gII, d.e.cp_cont_g, 1);
    }
}
