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
    private com.baidu.tbadk.core.dialog.a gXE;
    private View gXH;
    private WriteImagesInfo gXr = null;
    private View rootView = null;
    private ViewPager bHs = null;
    private b gXs = null;
    private LinearLayout gXt = null;
    private RadioGroup bBw = null;
    private RadioButton gXu = null;
    private RadioButton gXv = null;
    private LinearLayout gXw = null;
    private View gXx = null;
    private NavigationBar bcB = null;
    private TextView Rz = null;
    private TextView gXy = null;
    private String gXz = "";
    private String gXA = "";
    private String gXB = "";
    private String gXC = "(1/1)";
    private boolean gXD = true;
    private HashMap<String, String> gXF = new HashMap<>();
    private int gXG = 0;
    private int gXI = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int af = com.baidu.adp.lib.b.d.eV().af("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || af == 1 || PluginPackageManager.js().bs(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.gXD = false;
        } else {
            this.gXD = true;
        }
        setContentView(d.h.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.gXD) {
            if (this.gXr != null) {
                i = this.gXr.size();
                i2 = this.gXr.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.gXs.getCurrentIndex());
        this.gXs.bEo();
        bundle.putString("OutState_Write_Img_Info", this.gXr.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.gXz = getResources().getString(d.j.beautify);
        this.gXA = getResources().getString(d.j.rotate);
        this.gXB = this.gXz;
        this.rootView = findViewById(d.g.write_multi_imgs_rootlayout);
        this.bHs = (ViewPager) findViewById(d.g.write_multi_imgs_viewpager);
        this.gXt = (LinearLayout) findViewById(d.g.write_multi_imgs_beautify);
        this.bBw = (RadioGroup) findViewById(d.g.beautify_tabs);
        this.gXu = (RadioButton) findViewById(d.g.beautify_btn);
        this.gXv = (RadioButton) findViewById(d.g.rotate_btn);
        this.gXu.setOnCheckedChangeListener(this);
        this.gXv.setOnCheckedChangeListener(this);
        this.gXw = (LinearLayout) findViewById(d.g.filters_layout);
        this.gXx = findViewById(d.g.rotate);
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
                WriteMultiImgsActivity.this.gXs.vE(Integer.parseInt(view.getTag().toString()));
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        this.bcB = (NavigationBar) findViewById(d.g.write_multi_imgs_navibar);
        this.gXH = this.bcB.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteMultiImgsActivity.this.setResult(0);
                WriteMultiImgsActivity.this.finish();
            }
        });
        this.gXy = this.bcB.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(d.j.done), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteMultiImgsActivity.this.gXs.bEo();
                if (WriteMultiImgsActivity.this.gXr == null || WriteMultiImgsActivity.this.gXr.getChosedFiles() == null || WriteMultiImgsActivity.this.gXr.getChosedFiles().size() <= 0 || !WriteMultiImgsActivity.this.gXr.isOriginalImg() || WriteMultiImgsActivity.this.gXG <= 0 || !WriteMultiImgsActivity.this.bFc()) {
                    WriteMultiImgsActivity.this.bFf();
                    return;
                }
                if (WriteMultiImgsActivity.this.gXE == null) {
                    WriteMultiImgsActivity.this.gXE = new com.baidu.tbadk.core.dialog.a(WriteMultiImgsActivity.this.getActivity());
                    WriteMultiImgsActivity.this.gXE.cc(d.j.orginal_conflict_tip);
                    WriteMultiImgsActivity.this.gXE.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.3.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            if (WriteMultiImgsActivity.this.gXE != null) {
                                WriteMultiImgsActivity.this.gXE.dismiss();
                            }
                            WriteMultiImgsActivity.this.bFf();
                        }
                    });
                    WriteMultiImgsActivity.this.gXE.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.3.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            if (WriteMultiImgsActivity.this.gXE != null) {
                                WriteMultiImgsActivity.this.gXE.dismiss();
                            }
                            WriteMultiImgsActivity.this.setResult(0);
                            WriteMultiImgsActivity.this.finish();
                        }
                    });
                    WriteMultiImgsActivity.this.gXE.b(WriteMultiImgsActivity.this.getPageContext());
                }
                WriteMultiImgsActivity.this.gXE.th();
            }
        });
        this.Rz = this.bcB.setTitleText(getPageContext().getString(d.j.beautify));
        this.gXu.setChecked(true);
        if (!this.gXD) {
            this.gXv.setChecked(true);
            this.gXv.setPadding(0, this.gXv.getPaddingTop(), this.gXv.getPaddingRight(), this.gXv.getPaddingBottom());
            this.gXw.setVisibility(8);
            this.gXu.setVisibility(8);
            this.bBw.setVisibility(8);
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
            this.gXr = new WriteImagesInfo();
            this.gXr.parseJson(str);
            bFb();
            this.gXs = new b(this, this.bHs, this.gXr.getChosedFiles(), i, this);
            this.bHs.setAdapter(this.gXs);
            this.bHs.setCurrentItem(i, true);
            if (i == 0) {
                this.gXs.onPageSelected(0);
            }
            this.gXt.setVisibility(0);
        }
    }

    private void bFb() {
        if (this.gXr != null && this.gXr.isOriginalImg() && this.gXr.getChosedFiles() != null && this.gXr.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.gXr.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.gXF.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bFc() {
        if (this.gXr == null || !this.gXr.isOriginalImg() || this.gXr.getChosedFiles() == null || this.gXr.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.gXr.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.gXF.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bEp() {
        if (this.bcB.getVisibility() == 0) {
            this.bcB.setVisibility(8);
            this.gXt.setVisibility(8);
            return;
        }
        this.bcB.setVisibility(0);
        this.gXt.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void a(com.baidu.tbadk.coreExtra.view.a aVar, int i) {
        this.gXw.removeAllViews();
        this.gXw.addView(aVar);
        this.gXC = "（" + (i + 1) + "/" + this.gXr.size() + "）";
        this.Rz.setText(this.gXB + this.gXC);
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bEr() {
        this.gXI--;
        if (this.gXI == 0) {
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bEq() {
        this.gXI++;
        if (this.gXI > 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bFd() {
        this.gXG++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bFe() {
        this.gXG--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFf() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.gXr.toJsonString());
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
            if (compoundButton == this.gXu) {
                this.gXw.setVisibility(0);
                this.gXx.setVisibility(8);
                this.gXB = this.gXz;
                this.Rz.setText(this.gXB + this.gXC);
                return;
            }
            this.gXw.setVisibility(8);
            this.gXx.setVisibility(0);
            this.gXB = this.gXA;
            this.Rz.setText(this.gXB + this.gXC);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().ag(i == 1);
        getLayoutMode().t(this.rootView);
        aDF();
    }

    private void aDF() {
        aj.k(this.bcB, d.C0080d.common_color_10222);
        aj.c(this.Rz, d.C0080d.cp_cont_g, 1);
        aj.b(this.bcB.getBackImageView(), d.f.icon_topbar_return_s, d.f.icon_topbar_return_white_s, 0);
        aj.c(this.gXy, d.C0080d.cp_cont_g, 1);
    }
}
