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
    private com.baidu.tbadk.core.dialog.a gGm;
    private View gGp;
    private WriteImagesInfo gFZ = null;
    private View rootView = null;
    private ViewPager bvU = null;
    private b gGa = null;
    private LinearLayout gGb = null;
    private RadioGroup eOb = null;
    private RadioButton gGc = null;
    private RadioButton gGd = null;
    private LinearLayout gGe = null;
    private View gGf = null;
    private NavigationBar aZB = null;
    private TextView QF = null;
    private TextView gGg = null;
    private String gGh = "";
    private String gGi = "";
    private String gGj = "";
    private String gGk = "(1/1)";
    private boolean gGl = true;
    private HashMap<String, String> gGn = new HashMap<>();
    private int gGo = 0;
    private int gGq = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int af = com.baidu.adp.lib.b.d.eW().af("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || af == 1 || PluginPackageManager.ju().bp(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.gGl = false;
        } else {
            this.gGl = true;
        }
        setContentView(d.j.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.gGl) {
            if (this.gFZ != null) {
                i = this.gFZ.size();
                i2 = this.gFZ.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.gGa.getCurrentIndex());
        this.gGa.bzD();
        bundle.putString("OutState_Write_Img_Info", this.gFZ.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.gGh = getResources().getString(d.l.beautify);
        this.gGi = getResources().getString(d.l.rotate);
        this.gGj = this.gGh;
        this.rootView = findViewById(d.h.write_multi_imgs_rootlayout);
        this.bvU = (ViewPager) findViewById(d.h.write_multi_imgs_viewpager);
        this.gGb = (LinearLayout) findViewById(d.h.write_multi_imgs_beautify);
        this.eOb = (RadioGroup) findViewById(d.h.beautify_tabs);
        this.gGc = (RadioButton) findViewById(d.h.beautify_btn);
        this.gGd = (RadioButton) findViewById(d.h.rotate_btn);
        this.gGc.setOnCheckedChangeListener(this);
        this.gGd.setOnCheckedChangeListener(this);
        this.gGe = (LinearLayout) findViewById(d.h.filters_layout);
        this.gGf = findViewById(d.h.rotate);
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
                WriteMultiImgsActivity.this.gGa.uC(Integer.parseInt(view.getTag().toString()));
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        this.aZB = (NavigationBar) findViewById(d.h.write_multi_imgs_navibar);
        this.gGp = this.aZB.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteMultiImgsActivity.this.setResult(0);
                WriteMultiImgsActivity.this.finish();
            }
        });
        this.gGg = this.aZB.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(d.l.done), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteMultiImgsActivity.this.gGa.bzD();
                if (WriteMultiImgsActivity.this.gFZ == null || WriteMultiImgsActivity.this.gFZ.getChosedFiles() == null || WriteMultiImgsActivity.this.gFZ.getChosedFiles().size() <= 0 || !WriteMultiImgsActivity.this.gFZ.isOriginalImg() || WriteMultiImgsActivity.this.gGo <= 0 || !WriteMultiImgsActivity.this.bAr()) {
                    WriteMultiImgsActivity.this.bAu();
                    return;
                }
                if (WriteMultiImgsActivity.this.gGm == null) {
                    WriteMultiImgsActivity.this.gGm = new com.baidu.tbadk.core.dialog.a(WriteMultiImgsActivity.this.getActivity());
                    WriteMultiImgsActivity.this.gGm.ca(d.l.orginal_conflict_tip);
                    WriteMultiImgsActivity.this.gGm.a(d.l.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.3.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            if (WriteMultiImgsActivity.this.gGm != null) {
                                WriteMultiImgsActivity.this.gGm.dismiss();
                            }
                            WriteMultiImgsActivity.this.bAu();
                        }
                    });
                    WriteMultiImgsActivity.this.gGm.b(d.l.alert_no_button, new a.b() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.3.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            if (WriteMultiImgsActivity.this.gGm != null) {
                                WriteMultiImgsActivity.this.gGm.dismiss();
                            }
                            WriteMultiImgsActivity.this.setResult(0);
                            WriteMultiImgsActivity.this.finish();
                        }
                    });
                    WriteMultiImgsActivity.this.gGm.b(WriteMultiImgsActivity.this.getPageContext());
                }
                WriteMultiImgsActivity.this.gGm.th();
            }
        });
        this.QF = this.aZB.setTitleText(getPageContext().getString(d.l.beautify));
        this.gGc.setChecked(true);
        if (!this.gGl) {
            this.gGd.setChecked(true);
            this.gGd.setPadding(0, this.gGd.getPaddingTop(), this.gGd.getPaddingRight(), this.gGd.getPaddingBottom());
            this.gGe.setVisibility(8);
            this.gGc.setVisibility(8);
            this.eOb.setVisibility(8);
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
            this.gFZ = new WriteImagesInfo();
            this.gFZ.parseJson(str);
            bAq();
            this.gGa = new b(this, this.bvU, this.gFZ.getChosedFiles(), i, this);
            this.bvU.setAdapter(this.gGa);
            this.bvU.setCurrentItem(i, true);
            if (i == 0) {
                this.gGa.onPageSelected(0);
            }
            this.gGb.setVisibility(0);
        }
    }

    private void bAq() {
        if (this.gFZ != null && this.gFZ.isOriginalImg() && this.gFZ.getChosedFiles() != null && this.gFZ.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.gFZ.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.gGn.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bAr() {
        if (this.gFZ == null || !this.gFZ.isOriginalImg() || this.gFZ.getChosedFiles() == null || this.gFZ.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.gFZ.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.gGn.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bzE() {
        if (this.aZB.getVisibility() == 0) {
            this.aZB.setVisibility(8);
            this.gGb.setVisibility(8);
            return;
        }
        this.aZB.setVisibility(0);
        this.gGb.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void a(com.baidu.tbadk.coreExtra.view.a aVar, int i) {
        this.gGe.removeAllViews();
        this.gGe.addView(aVar);
        this.gGk = "（" + (i + 1) + "/" + this.gFZ.size() + "）";
        this.QF.setText(this.gGj + this.gGk);
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bzG() {
        this.gGq--;
        if (this.gGq == 0) {
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bzF() {
        this.gGq++;
        if (this.gGq > 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bAs() {
        this.gGo++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bAt() {
        this.gGo--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAu() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.gFZ.toJsonString());
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
            if (compoundButton == this.gGc) {
                this.gGe.setVisibility(0);
                this.gGf.setVisibility(8);
                this.gGj = this.gGh;
                this.QF.setText(this.gGj + this.gGk);
                return;
            }
            this.gGe.setVisibility(8);
            this.gGf.setVisibility(0);
            this.gGj = this.gGi;
            this.QF.setText(this.gGj + this.gGk);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.rootView);
        azR();
    }

    private void azR() {
        ai.k(this.aZB, d.e.common_color_10222);
        ai.c(this.QF, d.e.cp_cont_g, 1);
        ai.a(this.aZB.getBackImageView(), d.g.icon_return_s, d.g.icon_return_s_w, 0);
        ai.c(this.gGg, d.e.cp_cont_g, 1);
    }
}
