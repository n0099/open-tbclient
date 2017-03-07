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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class y extends Dialog {
    private View aTA;
    private LinearLayout aTB;
    private TextView aTC;
    private TextView aTD;
    private TextView aTE;
    private View aTF;
    private LinearLayout aTG;
    private a aTH;
    private View.OnClickListener aTI;
    private View.OnClickListener aTJ;
    private boolean aTK;
    private boolean aTL;
    private VersionData aTj;
    private CombineDownload aTk;
    private boolean aTl;
    private boolean aTm;
    private boolean aTn;
    private boolean aTo;
    private LinearLayout aTp;
    private TextView aTq;
    private TextView aTr;
    private TextView aTs;
    private String aTt;
    private TextView aTu;
    private TextView aTv;
    private TextView aTw;
    private View aTx;
    private TextView aTy;
    private TextView aTz;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void KN();

        void KO();

        void ci(boolean z);

        void cj(boolean z);

        void stopService();
    }

    public y(Context context, int i) {
        super(context, i);
        this.aTl = false;
        this.aTm = true;
        this.aTn = false;
        this.aTo = false;
        this.aTK = true;
        this.aTL = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.app_download_dialog);
        this.aTp = (LinearLayout) findViewById(w.h.app_info);
        this.aTq = (TextView) findViewById(w.h.app_version_and_size);
        this.aTr = (TextView) findViewById(w.h.app_description);
        this.aTw = (TextView) findViewById(w.h.fullsize_download_button);
        this.aTv = (TextView) findViewById(w.h.cancel_download_button);
        this.aTx = findViewById(w.h.divider_line);
        this.aTs = (TextView) findViewById(w.h.download_process);
        this.aTy = (TextView) findViewById(w.h.incremental_download_button);
        this.aTz = (TextView) findViewById(w.h.not_install_as_tip);
        this.aTA = findViewById(w.h.incremental_download_layout);
        this.aTu = (TextView) findViewById(w.h.other_app_recommend);
        this.aTF = findViewById(w.h.divider_under_button);
        this.aTG = (LinearLayout) findViewById(w.h.cancel_confirm_ll);
        this.aTt = this.aTs.getText().toString();
        this.aTB = (LinearLayout) findViewById(w.h.cancel_dialog);
        this.aTD = (TextView) findViewById(w.h.sure_cancel);
        this.aTE = (TextView) findViewById(w.h.cancel_button);
        this.aTC = (TextView) findViewById(w.h.cancel_tip);
        this.aTD.setOnClickListener(this.aTI);
        this.aTE.setOnClickListener(this.aTJ);
        if (com.baidu.adp.lib.b.e.eT().ab("android_shouzhu_update") == 1) {
            this.aTK = true;
        } else {
            this.aTK = false;
        }
        String size = this.aTj.getSize();
        String newVersion = this.aTj.getNewVersion();
        String newVersionDesc = this.aTj.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(w.l.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.b(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aTq.setText(sb.toString());
        this.aTr.setText(newVersionDesc);
        if (this.aTj.forceUpdate()) {
            this.aTo = true;
            this.aTv.setText(this.mContext.getString(w.l.quit));
        } else {
            this.aTv.setText(this.mContext.getString(w.l.update_after));
        }
        if (this.aTk != null && this.aTk.showCombineDownload() && !TextUtils.isEmpty(this.aTk.getApkMD5RSA())) {
            this.aTu.setText(this.aTk.getAppName());
            if (!com.baidu.tieba.tbadkCore.ae.isInstalledPackage(this.mContext, this.aTk.getAppProc()) && !TextUtils.isEmpty(this.aTk.getAppUrl())) {
                this.aTu.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(w.g.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aTu.setCompoundDrawables(drawable, null, null, null);
                this.aTl = true;
            } else {
                this.aTu.setVisibility(8);
                this.aTl = false;
            }
        } else {
            this.aTu.setVisibility(8);
            this.aTl = false;
        }
        ch(this.aTK);
        this.aTw.setOnClickListener(new z(this));
        this.aTy.setOnClickListener(new aa(this));
        this.aTv.setOnClickListener(new ab(this));
        this.aTu.setOnClickListener(new ac(this));
        KL();
    }

    private void KL() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void ch(boolean z) {
        if (ak.b(this.mContext.getPackageManager())) {
            this.aTz.setVisibility(8);
        } else {
            this.aTz.setVisibility(0);
        }
        if (z) {
            if (this.aTj == null || TextUtils.isEmpty(this.aTj.getPatch()) || this.aTj.getNewVersionCode() < 0) {
                this.aTA.setVisibility(0);
                this.aTy.setText(w.l.super_update);
                aq.j(this.aTy, w.g.dialog_middle_item_bg_selector);
                this.aTG.setVisibility(0);
                this.aTL = false;
                com.baidu.tbadk.core.util.TiebaStatic.log("c10008");
                com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
                return;
            }
            this.aTA.setVisibility(0);
            this.aTy.setText(w.l.incremental_update);
            aq.j(this.aTy, w.g.dialog_single_button_bg_selector);
            this.aTF.setVisibility(8);
            this.aTG.setVisibility(8);
            this.aTL = true;
            com.baidu.tbadk.core.util.TiebaStatic.log("c10002");
        } else if (this.aTj == null || TextUtils.isEmpty(this.aTj.getPatch()) || this.aTj.getNewVersionCode() < 0) {
            this.aTA.setVisibility(8);
            this.aTG.setVisibility(0);
            com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
        } else {
            this.aTA.setVisibility(0);
            aq.j(this.aTy, w.g.dialog_middle_item_bg_selector);
            this.aTy.setText(w.l.incremental_update);
            this.aTG.setVisibility(0);
            this.aTL = true;
            com.baidu.tbadk.core.util.TiebaStatic.log("c10002");
            com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
        }
    }

    public void fG(int i) {
        this.aTw.setVisibility(8);
        this.aTA.setVisibility(8);
        this.aTv.setVisibility(8);
        this.aTx.setVisibility(8);
        this.aTn = true;
        this.aTG.setVisibility(0);
        this.aTs.setVisibility(0);
        this.aTs.setText(String.valueOf(this.aTt) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aTn) {
            this.aTH.stopService();
            this.aTp.setVisibility(8);
            if (this.aTo) {
                this.aTC.setText(getContext().getString(w.l.download_exit));
            }
            this.aTB.setVisibility(0);
            return;
        }
        this.aTH.KO();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aTj = versionData;
        this.aTk = combineDownload;
        this.aTH = aVar;
    }

    public void KM() {
        this.aTB.setVisibility(8);
        this.aTp.setVisibility(0);
    }

    public void j(View.OnClickListener onClickListener) {
        this.aTI = onClickListener;
    }

    public void k(View.OnClickListener onClickListener) {
        this.aTJ = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ah(i == 1);
            tbPageContext.getLayoutMode().t(findViewById(w.h.app_download_dialog_layout));
        }
    }
}
