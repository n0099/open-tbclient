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
    private com.baidu.tbadk.core.dialog.a gJp;
    private View gJs;
    private WriteImagesInfo gJc = null;
    private View rootView = null;
    private ViewPager bxO = null;
    private b gJd = null;
    private LinearLayout gJe = null;
    private RadioGroup eRj = null;
    private RadioButton gJf = null;
    private RadioButton gJg = null;
    private LinearLayout gJh = null;
    private View gJi = null;
    private NavigationBar baP = null;
    private TextView Sh = null;
    private TextView gJj = null;
    private String gJk = "";
    private String gJl = "";
    private String gJm = "";
    private String gJn = "(1/1)";
    private boolean gJo = true;
    private HashMap<String, String> gJq = new HashMap<>();
    private int gJr = 0;
    private int gJt = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int am = com.baidu.adp.lib.b.d.fh().am("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || am == 1 || PluginPackageManager.jE().bw(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.gJo = false;
        } else {
            this.gJo = true;
        }
        setContentView(d.j.write_multi_imgs_activity);
        initUI();
        initData(bundle);
        if (this.gJo) {
            if (this.gJc != null) {
                i = this.gJc.size();
                i2 = this.gJc.size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.gJd.getCurrentIndex());
        this.gJd.bAj();
        bundle.putString("OutState_Write_Img_Info", this.gJc.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    private void initUI() {
        this.gJk = getResources().getString(d.l.beautify);
        this.gJl = getResources().getString(d.l.rotate);
        this.gJm = this.gJk;
        this.rootView = findViewById(d.h.write_multi_imgs_rootlayout);
        this.bxO = (ViewPager) findViewById(d.h.write_multi_imgs_viewpager);
        this.gJe = (LinearLayout) findViewById(d.h.write_multi_imgs_beautify);
        this.eRj = (RadioGroup) findViewById(d.h.beautify_tabs);
        this.gJf = (RadioButton) findViewById(d.h.beautify_btn);
        this.gJg = (RadioButton) findViewById(d.h.rotate_btn);
        this.gJf.setOnCheckedChangeListener(this);
        this.gJg.setOnCheckedChangeListener(this);
        this.gJh = (LinearLayout) findViewById(d.h.filters_layout);
        this.gJi = findViewById(d.h.rotate);
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
                WriteMultiImgsActivity.this.gJd.uK(Integer.parseInt(view.getTag().toString()));
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        this.baP = (NavigationBar) findViewById(d.h.write_multi_imgs_navibar);
        this.gJs = this.baP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteMultiImgsActivity.this.setResult(0);
                WriteMultiImgsActivity.this.finish();
            }
        });
        this.gJj = this.baP.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(d.l.done), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteMultiImgsActivity.this.gJd.bAj();
                if (WriteMultiImgsActivity.this.gJc == null || WriteMultiImgsActivity.this.gJc.getChosedFiles() == null || WriteMultiImgsActivity.this.gJc.getChosedFiles().size() <= 0 || !WriteMultiImgsActivity.this.gJc.isOriginalImg() || WriteMultiImgsActivity.this.gJr <= 0 || !WriteMultiImgsActivity.this.bAX()) {
                    WriteMultiImgsActivity.this.bBa();
                    return;
                }
                if (WriteMultiImgsActivity.this.gJp == null) {
                    WriteMultiImgsActivity.this.gJp = new com.baidu.tbadk.core.dialog.a(WriteMultiImgsActivity.this.getActivity());
                    WriteMultiImgsActivity.this.gJp.cc(d.l.orginal_conflict_tip);
                    WriteMultiImgsActivity.this.gJp.a(d.l.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.3.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            if (WriteMultiImgsActivity.this.gJp != null) {
                                WriteMultiImgsActivity.this.gJp.dismiss();
                            }
                            WriteMultiImgsActivity.this.bBa();
                        }
                    });
                    WriteMultiImgsActivity.this.gJp.b(d.l.alert_no_button, new a.b() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.3.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            if (WriteMultiImgsActivity.this.gJp != null) {
                                WriteMultiImgsActivity.this.gJp.dismiss();
                            }
                            WriteMultiImgsActivity.this.setResult(0);
                            WriteMultiImgsActivity.this.finish();
                        }
                    });
                    WriteMultiImgsActivity.this.gJp.b(WriteMultiImgsActivity.this.getPageContext());
                }
                WriteMultiImgsActivity.this.gJp.ts();
            }
        });
        this.Sh = this.baP.setTitleText(getPageContext().getString(d.l.beautify));
        this.gJf.setChecked(true);
        if (!this.gJo) {
            this.gJg.setChecked(true);
            this.gJg.setPadding(0, this.gJg.getPaddingTop(), this.gJg.getPaddingRight(), this.gJg.getPaddingBottom());
            this.gJh.setVisibility(8);
            this.gJf.setVisibility(8);
            this.eRj.setVisibility(8);
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
            this.gJc = new WriteImagesInfo();
            this.gJc.parseJson(str);
            bAW();
            this.gJd = new b(this, this.bxO, this.gJc.getChosedFiles(), i, this);
            this.bxO.setAdapter(this.gJd);
            this.bxO.setCurrentItem(i, true);
            if (i == 0) {
                this.gJd.onPageSelected(0);
            }
            this.gJe.setVisibility(0);
        }
    }

    private void bAW() {
        if (this.gJc != null && this.gJc.isOriginalImg() && this.gJc.getChosedFiles() != null && this.gJc.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.gJc.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.gJq.put(next.getFilePath(), "1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bAX() {
        if (this.gJc == null || !this.gJc.isOriginalImg() || this.gJc.getChosedFiles() == null || this.gJc.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.gJc.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.gJq.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bAk() {
        if (this.baP.getVisibility() == 0) {
            this.baP.setVisibility(8);
            this.gJe.setVisibility(8);
            return;
        }
        this.baP.setVisibility(0);
        this.gJe.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void a(com.baidu.tbadk.coreExtra.view.a aVar, int i) {
        this.gJh.removeAllViews();
        this.gJh.addView(aVar);
        this.gJn = "（" + (i + 1) + "/" + this.gJc.size() + "）";
        this.Sh.setText(this.gJm + this.gJn);
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bAm() {
        this.gJt--;
        if (this.gJt == 0) {
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bAl() {
        this.gJt++;
        if (this.gJt > 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bAY() {
        this.gJr++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bAZ() {
        this.gJr--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBa() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.gJc.toJsonString());
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
            if (compoundButton == this.gJf) {
                this.gJh.setVisibility(0);
                this.gJi.setVisibility(8);
                this.gJm = this.gJk;
                this.Sh.setText(this.gJm + this.gJn);
                return;
            }
            this.gJh.setVisibility(8);
            this.gJi.setVisibility(0);
            this.gJm = this.gJl;
            this.Sh.setText(this.gJm + this.gJn);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.rootView);
        aAE();
    }

    private void aAE() {
        ai.k(this.baP, d.e.common_color_10222);
        ai.c(this.Sh, d.e.cp_cont_g, 1);
        ai.a(this.baP.getBackImageView(), d.g.icon_return_s, d.g.icon_return_s_w, 0);
        ai.c(this.gJj, d.e.cp_cont_g, 1);
    }
}
