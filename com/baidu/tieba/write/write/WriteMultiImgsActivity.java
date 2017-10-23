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
    private com.baidu.tbadk.core.dialog.a gNv;
    private View gNy;
    private WriteImagesInfo gNi = null;
    private View rootView = null;
    private ViewPager bAU = null;
    private b gNj = null;
    private LinearLayout gNk = null;
    private RadioGroup bvP = null;
    private RadioButton gNl = null;
    private RadioButton gNm = null;
    private LinearLayout gNn = null;
    private View gNo = null;
    private NavigationBar bbV = null;
    private TextView Ri = null;
    private TextView gNp = null;
    private String gNq = "";
    private String gNr = "";
    private String gNs = "";
    private String gNt = "(1/1)";
    private boolean gNu = true;
    private HashMap<String, String> gNw = new HashMap<>();
    private int gNx = 0;
    private int gNz = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int af = com.baidu.adp.lib.b.d.eV().af("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || af == 1 || PluginPackageManager.jv().bs(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.gNu = false;
        } else {
            this.gNu = true;
        }
        setContentView(d.j.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.gNu) {
            if (this.gNi != null) {
                i = this.gNi.size();
                i2 = this.gNi.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.gNj.getCurrentIndex());
        this.gNj.bAR();
        bundle.putString("OutState_Write_Img_Info", this.gNi.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.gNq = getResources().getString(d.l.beautify);
        this.gNr = getResources().getString(d.l.rotate);
        this.gNs = this.gNq;
        this.rootView = findViewById(d.h.write_multi_imgs_rootlayout);
        this.bAU = (ViewPager) findViewById(d.h.write_multi_imgs_viewpager);
        this.gNk = (LinearLayout) findViewById(d.h.write_multi_imgs_beautify);
        this.bvP = (RadioGroup) findViewById(d.h.beautify_tabs);
        this.gNl = (RadioButton) findViewById(d.h.beautify_btn);
        this.gNm = (RadioButton) findViewById(d.h.rotate_btn);
        this.gNl.setOnCheckedChangeListener(this);
        this.gNm.setOnCheckedChangeListener(this);
        this.gNn = (LinearLayout) findViewById(d.h.filters_layout);
        this.gNo = findViewById(d.h.rotate);
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
                WriteMultiImgsActivity.this.gNj.vj(Integer.parseInt(view.getTag().toString()));
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        this.bbV = (NavigationBar) findViewById(d.h.write_multi_imgs_navibar);
        this.gNy = this.bbV.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteMultiImgsActivity.this.setResult(0);
                WriteMultiImgsActivity.this.finish();
            }
        });
        this.gNp = this.bbV.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(d.l.done), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteMultiImgsActivity.this.gNj.bAR();
                if (WriteMultiImgsActivity.this.gNi == null || WriteMultiImgsActivity.this.gNi.getChosedFiles() == null || WriteMultiImgsActivity.this.gNi.getChosedFiles().size() <= 0 || !WriteMultiImgsActivity.this.gNi.isOriginalImg() || WriteMultiImgsActivity.this.gNx <= 0 || !WriteMultiImgsActivity.this.bBF()) {
                    WriteMultiImgsActivity.this.bBI();
                    return;
                }
                if (WriteMultiImgsActivity.this.gNv == null) {
                    WriteMultiImgsActivity.this.gNv = new com.baidu.tbadk.core.dialog.a(WriteMultiImgsActivity.this.getActivity());
                    WriteMultiImgsActivity.this.gNv.cc(d.l.orginal_conflict_tip);
                    WriteMultiImgsActivity.this.gNv.a(d.l.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.3.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            if (WriteMultiImgsActivity.this.gNv != null) {
                                WriteMultiImgsActivity.this.gNv.dismiss();
                            }
                            WriteMultiImgsActivity.this.bBI();
                        }
                    });
                    WriteMultiImgsActivity.this.gNv.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.3.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            if (WriteMultiImgsActivity.this.gNv != null) {
                                WriteMultiImgsActivity.this.gNv.dismiss();
                            }
                            WriteMultiImgsActivity.this.setResult(0);
                            WriteMultiImgsActivity.this.finish();
                        }
                    });
                    WriteMultiImgsActivity.this.gNv.b(WriteMultiImgsActivity.this.getPageContext());
                }
                WriteMultiImgsActivity.this.gNv.tb();
            }
        });
        this.Ri = this.bbV.setTitleText(getPageContext().getString(d.l.beautify));
        this.gNl.setChecked(true);
        if (!this.gNu) {
            this.gNm.setChecked(true);
            this.gNm.setPadding(0, this.gNm.getPaddingTop(), this.gNm.getPaddingRight(), this.gNm.getPaddingBottom());
            this.gNn.setVisibility(8);
            this.gNl.setVisibility(8);
            this.bvP.setVisibility(8);
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
            this.gNi = new WriteImagesInfo();
            this.gNi.parseJson(str);
            bBE();
            this.gNj = new b(this, this.bAU, this.gNi.getChosedFiles(), i, this);
            this.bAU.setAdapter(this.gNj);
            this.bAU.setCurrentItem(i, true);
            if (i == 0) {
                this.gNj.onPageSelected(0);
            }
            this.gNk.setVisibility(0);
        }
    }

    private void bBE() {
        if (this.gNi != null && this.gNi.isOriginalImg() && this.gNi.getChosedFiles() != null && this.gNi.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.gNi.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.gNw.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bBF() {
        if (this.gNi == null || !this.gNi.isOriginalImg() || this.gNi.getChosedFiles() == null || this.gNi.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.gNi.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.gNw.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bAS() {
        if (this.bbV.getVisibility() == 0) {
            this.bbV.setVisibility(8);
            this.gNk.setVisibility(8);
            return;
        }
        this.bbV.setVisibility(0);
        this.gNk.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void a(com.baidu.tbadk.coreExtra.view.a aVar, int i) {
        this.gNn.removeAllViews();
        this.gNn.addView(aVar);
        this.gNt = "（" + (i + 1) + "/" + this.gNi.size() + "）";
        this.Ri.setText(this.gNs + this.gNt);
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bAU() {
        this.gNz--;
        if (this.gNz == 0) {
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bAT() {
        this.gNz++;
        if (this.gNz > 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bBG() {
        this.gNx++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bBH() {
        this.gNx--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBI() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.gNi.toJsonString());
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
            if (compoundButton == this.gNl) {
                this.gNn.setVisibility(0);
                this.gNo.setVisibility(8);
                this.gNs = this.gNq;
                this.Ri.setText(this.gNs + this.gNt);
                return;
            }
            this.gNn.setVisibility(8);
            this.gNo.setVisibility(0);
            this.gNs = this.gNr;
            this.Ri.setText(this.gNs + this.gNt);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.rootView);
        aBk();
    }

    private void aBk() {
        aj.k(this.bbV, d.e.common_color_10222);
        aj.c(this.Ri, d.e.cp_cont_g, 1);
        aj.b(this.bbV.getBackImageView(), d.g.icon_return_s, d.g.icon_return_s_w, 0);
        aj.c(this.gNp, d.e.cp_cont_g, 1);
    }
}
