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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class y extends Dialog {
    private VersionData aSQ;
    private CombineDownload aSR;
    private boolean aSS;
    private boolean aST;
    private boolean aSU;
    private boolean aSV;
    private LinearLayout aSW;
    private TextView aSX;
    private TextView aSY;
    private TextView aSZ;
    private String aTa;
    private TextView aTb;
    private TextView aTc;
    private TextView aTd;
    private View aTe;
    private TextView aTf;
    private TextView aTg;
    private View aTh;
    private LinearLayout aTi;
    private TextView aTj;
    private TextView aTk;
    private TextView aTl;
    private View aTm;
    private LinearLayout aTn;
    private a aTo;
    private View.OnClickListener aTp;
    private View.OnClickListener aTq;
    private boolean aTr;
    private boolean aTs;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void JU();

        void JV();

        void cl(boolean z);

        void cm(boolean z);

        void stopService();
    }

    public y(Context context, int i) {
        super(context, i);
        this.aSS = false;
        this.aST = true;
        this.aSU = false;
        this.aSV = false;
        this.aTr = true;
        this.aTs = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.app_download_dialog);
        this.aSW = (LinearLayout) findViewById(w.h.app_info);
        this.aSX = (TextView) findViewById(w.h.app_version_and_size);
        this.aSY = (TextView) findViewById(w.h.app_description);
        this.aTd = (TextView) findViewById(w.h.fullsize_download_button);
        this.aTc = (TextView) findViewById(w.h.cancel_download_button);
        this.aTe = findViewById(w.h.divider_line);
        this.aSZ = (TextView) findViewById(w.h.download_process);
        this.aTf = (TextView) findViewById(w.h.incremental_download_button);
        this.aTg = (TextView) findViewById(w.h.not_install_as_tip);
        this.aTh = findViewById(w.h.incremental_download_layout);
        this.aTb = (TextView) findViewById(w.h.other_app_recommend);
        this.aTm = findViewById(w.h.divider_under_button);
        this.aTn = (LinearLayout) findViewById(w.h.cancel_confirm_ll);
        this.aTa = this.aSZ.getText().toString();
        this.aTi = (LinearLayout) findViewById(w.h.cancel_dialog);
        this.aTk = (TextView) findViewById(w.h.sure_cancel);
        this.aTl = (TextView) findViewById(w.h.cancel_button);
        this.aTj = (TextView) findViewById(w.h.cancel_tip);
        this.aTk.setOnClickListener(this.aTp);
        this.aTl.setOnClickListener(this.aTq);
        if (com.baidu.adp.lib.b.e.eY().ad("android_shouzhu_update") == 1) {
            this.aTr = true;
        } else {
            this.aTr = false;
        }
        String size = this.aSQ.getSize();
        String newVersion = this.aSQ.getNewVersion();
        String newVersionDesc = this.aSQ.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(w.l.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.b(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aSX.setText(sb.toString());
        this.aSY.setText(newVersionDesc);
        if (this.aSQ.forceUpdate()) {
            this.aSV = true;
            this.aTc.setText(this.mContext.getString(w.l.quit));
        } else {
            this.aTc.setText(this.mContext.getString(w.l.update_after));
        }
        if (this.aSR != null && this.aSR.showCombineDownload() && !TextUtils.isEmpty(this.aSR.getApkMD5RSA())) {
            this.aTb.setText(this.aSR.getAppName());
            if (!com.baidu.tieba.tbadkCore.ac.isInstalledPackage(this.mContext, this.aSR.getAppProc()) && !TextUtils.isEmpty(this.aSR.getAppUrl())) {
                this.aTb.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(w.g.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aTb.setCompoundDrawables(drawable, null, null, null);
                this.aSS = true;
            } else {
                this.aTb.setVisibility(8);
                this.aSS = false;
            }
        } else {
            this.aTb.setVisibility(8);
            this.aSS = false;
        }
        ck(this.aTr);
        this.aTd.setOnClickListener(new z(this));
        this.aTf.setOnClickListener(new aa(this));
        this.aTc.setOnClickListener(new ab(this));
        this.aTb.setOnClickListener(new ac(this));
        JS();
    }

    private void JS() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void ck(boolean z) {
        if (aj.b(this.mContext.getPackageManager())) {
            this.aTg.setVisibility(8);
        } else {
            this.aTg.setVisibility(0);
        }
        if (z) {
            if (this.aSQ == null || TextUtils.isEmpty(this.aSQ.getPatch()) || this.aSQ.getNewVersionCode() < 0) {
                this.aTh.setVisibility(0);
                this.aTf.setText(w.l.super_update);
                as.j(this.aTf, w.g.dialog_middle_item_bg_selector);
                this.aTn.setVisibility(0);
                this.aTs = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.aTh.setVisibility(0);
            this.aTf.setText(w.l.incremental_update);
            as.j(this.aTf, w.g.dialog_single_button_bg_selector);
            this.aTm.setVisibility(8);
            this.aTn.setVisibility(8);
            this.aTs = true;
            TiebaStatic.log("c10002");
        } else if (this.aSQ == null || TextUtils.isEmpty(this.aSQ.getPatch()) || this.aSQ.getNewVersionCode() < 0) {
            this.aTh.setVisibility(8);
            this.aTn.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.aTh.setVisibility(0);
            as.j(this.aTf, w.g.dialog_middle_item_bg_selector);
            this.aTf.setText(w.l.incremental_update);
            this.aTn.setVisibility(0);
            this.aTs = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void fI(int i) {
        this.aTd.setVisibility(8);
        this.aTh.setVisibility(8);
        this.aTc.setVisibility(8);
        this.aTe.setVisibility(8);
        this.aSU = true;
        this.aTn.setVisibility(0);
        this.aSZ.setVisibility(0);
        this.aSZ.setText(String.valueOf(this.aTa) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aSU) {
            this.aTo.stopService();
            this.aSW.setVisibility(8);
            if (this.aSV) {
                this.aTj.setText(getContext().getString(w.l.download_exit));
            }
            this.aTi.setVisibility(0);
            return;
        }
        this.aTo.JV();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aSQ = versionData;
        this.aSR = combineDownload;
        this.aTo = aVar;
    }

    public void JT() {
        this.aTi.setVisibility(8);
        this.aSW.setVisibility(0);
    }

    public void i(View.OnClickListener onClickListener) {
        this.aTp = onClickListener;
    }

    public void j(View.OnClickListener onClickListener) {
        this.aTq = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ah(i == 1);
            tbPageContext.getLayoutMode().t(findViewById(w.h.app_download_dialog_layout));
        }
    }
}
