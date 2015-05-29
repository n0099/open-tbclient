package com.baidu.tieba;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.tbadkCore.au;
/* loaded from: classes.dex */
public class w extends Dialog {
    private View avA;
    private TextView avB;
    private TextView avC;
    private View avD;
    private LinearLayout avE;
    private TextView avF;
    private TextView avG;
    private TextView avH;
    private View avI;
    private LinearLayout avJ;
    private ab avK;
    private View.OnClickListener avL;
    private View.OnClickListener avM;
    private boolean avN;
    private VersionData avm;
    private CombineDownload avn;
    private boolean avo;
    private boolean avp;
    private boolean avq;
    private boolean avr;
    private LinearLayout avs;
    private TextView avt;
    private TextView avu;
    private TextView avv;
    private String avw;
    private TextView avx;
    private TextView avy;
    private TextView avz;
    private Context mContext;

    public w(Context context, int i) {
        super(context, i);
        this.avo = false;
        this.avp = true;
        this.avq = false;
        this.avr = false;
        this.avN = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.app_download_dialog);
        this.avs = (LinearLayout) findViewById(q.app_info);
        this.avt = (TextView) findViewById(q.app_version_and_size);
        this.avu = (TextView) findViewById(q.app_description);
        this.avz = (TextView) findViewById(q.fullsize_download_button);
        this.avy = (TextView) findViewById(q.cancel_download_button);
        this.avA = findViewById(q.divider_line);
        this.avv = (TextView) findViewById(q.download_process);
        this.avB = (TextView) findViewById(q.incremental_download_button);
        this.avC = (TextView) findViewById(q.not_install_as_tip);
        this.avD = findViewById(q.incremental_download_layout);
        this.avx = (TextView) findViewById(q.other_app_recommend);
        this.avI = findViewById(q.divider_under_button);
        this.avJ = (LinearLayout) findViewById(q.cancel_confirm_ll);
        this.avw = this.avv.getText().toString();
        this.avE = (LinearLayout) findViewById(q.cancel_dialog);
        this.avG = (TextView) findViewById(q.sure_cancel);
        this.avH = (TextView) findViewById(q.cancel_button);
        this.avF = (TextView) findViewById(q.cancel_tip);
        this.avG.setOnClickListener(this.avL);
        this.avH.setOnClickListener(this.avM);
        if (com.baidu.adp.lib.b.f.gD().ai("android_shouzhu_update") == 1) {
            this.avN = true;
        } else {
            this.avN = false;
        }
        String size = this.avm.getSize();
        String newVersion = this.avm.getNewVersion();
        String newVersionDesc = this.avm.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(t.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.c.a(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.avt.setText(sb.toString());
        this.avu.setText(newVersionDesc);
        if (this.avm.forceUpdate()) {
            this.avr = true;
            this.avy.setText(this.mContext.getString(t.quit));
        } else {
            this.avy.setText(this.mContext.getString(t.update_after));
        }
        if (this.avn != null && this.avn.showCombineDownload()) {
            this.avx.setText(this.avn.getAppName());
            if (!au.isInstalledPackage(this.mContext, this.avn.getAppProc()) && !TextUtils.isEmpty(this.avn.getAppUrl())) {
                this.avx.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(p.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.avx.setCompoundDrawables(drawable, null, null, null);
                this.avo = true;
            } else {
                this.avx.setVisibility(8);
                this.avo = false;
            }
        } else {
            this.avx.setVisibility(8);
            this.avo = false;
        }
        bq(this.avN);
        this.avz.setOnClickListener(new x(this));
        this.avB.setOnClickListener(new y(this));
        this.avy.setOnClickListener(new z(this));
        this.avx.setOnClickListener(new aa(this));
        EP();
    }

    private void EP() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void bq(boolean z) {
        if (aj.a(this.mContext.getPackageManager())) {
            this.avC.setVisibility(8);
        } else {
            this.avC.setVisibility(0);
        }
        if (z) {
            if (this.avm == null || TextUtils.isEmpty(this.avm.getPatch()) || this.avm.getNewVersionCode() < 0) {
                this.avD.setVisibility(0);
                this.avB.setText(t.super_update);
                ay.i((View) this.avB, p.dialog_middle_item_bg_selector);
                this.avJ.setVisibility(0);
                return;
            }
            this.avD.setVisibility(0);
            this.avB.setText(t.incremental_update);
            ay.i((View) this.avB, p.dialog_single_button_bg_selector);
            this.avI.setVisibility(8);
            this.avJ.setVisibility(8);
        } else if (this.avm == null || TextUtils.isEmpty(this.avm.getPatch()) || this.avm.getNewVersionCode() < 0) {
            this.avD.setVisibility(8);
            this.avJ.setVisibility(0);
        } else {
            this.avD.setVisibility(0);
            ay.i((View) this.avB, p.dialog_middle_item_bg_selector);
            this.avB.setText(t.incremental_update);
            this.avJ.setVisibility(0);
        }
    }

    public void updateProgress(int i) {
        this.avz.setVisibility(8);
        this.avD.setVisibility(8);
        this.avy.setVisibility(8);
        this.avA.setVisibility(8);
        this.avq = true;
        this.avJ.setVisibility(0);
        this.avv.setVisibility(0);
        this.avv.setText(String.valueOf(this.avw) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.avq) {
            this.avK.stopService();
            this.avs.setVisibility(8);
            if (this.avr) {
                this.avF.setText(getContext().getString(t.download_exit));
            }
            this.avE.setVisibility(0);
            return;
        }
        this.avK.ES();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, ab abVar) {
        this.avm = versionData;
        this.avn = combineDownload;
        this.avK = abVar;
    }

    public void EQ() {
        this.avE.setVisibility(8);
        this.avs.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.avL = onClickListener;
    }

    public void g(View.OnClickListener onClickListener) {
        this.avM = onClickListener;
    }

    public void b(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ab(i == 1);
            tbPageContext.getLayoutMode().j(findViewById(q.app_download_dialog_layout));
        }
    }
}
