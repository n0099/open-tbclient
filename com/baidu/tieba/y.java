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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class y extends Dialog {
    private VersionData aTA;
    private CombineDownload aTB;
    private boolean aTC;
    private boolean aTD;
    private boolean aTE;
    private boolean aTF;
    private LinearLayout aTG;
    private TextView aTH;
    private TextView aTI;
    private TextView aTJ;
    private String aTK;
    private TextView aTL;
    private TextView aTM;
    private TextView aTN;
    private View aTO;
    private TextView aTP;
    private TextView aTQ;
    private View aTR;
    private LinearLayout aTS;
    private TextView aTT;
    private TextView aTU;
    private TextView aTV;
    private View aTW;
    private LinearLayout aTX;
    private a aTY;
    private View.OnClickListener aTZ;
    private View.OnClickListener aUa;
    private boolean aUb;
    private boolean aUc;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void Ln();

        void Lo();

        void ck(boolean z);

        void cl(boolean z);

        void stopService();
    }

    public y(Context context, int i) {
        super(context, i);
        this.aTC = false;
        this.aTD = true;
        this.aTE = false;
        this.aTF = false;
        this.aUb = true;
        this.aUc = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.app_download_dialog);
        this.aTG = (LinearLayout) findViewById(w.h.app_info);
        this.aTH = (TextView) findViewById(w.h.app_version_and_size);
        this.aTI = (TextView) findViewById(w.h.app_description);
        this.aTN = (TextView) findViewById(w.h.fullsize_download_button);
        this.aTM = (TextView) findViewById(w.h.cancel_download_button);
        this.aTO = findViewById(w.h.divider_line);
        this.aTJ = (TextView) findViewById(w.h.download_process);
        this.aTP = (TextView) findViewById(w.h.incremental_download_button);
        this.aTQ = (TextView) findViewById(w.h.not_install_as_tip);
        this.aTR = findViewById(w.h.incremental_download_layout);
        this.aTL = (TextView) findViewById(w.h.other_app_recommend);
        this.aTW = findViewById(w.h.divider_under_button);
        this.aTX = (LinearLayout) findViewById(w.h.cancel_confirm_ll);
        this.aTK = this.aTJ.getText().toString();
        this.aTS = (LinearLayout) findViewById(w.h.cancel_dialog);
        this.aTU = (TextView) findViewById(w.h.sure_cancel);
        this.aTV = (TextView) findViewById(w.h.cancel_button);
        this.aTT = (TextView) findViewById(w.h.cancel_tip);
        this.aTU.setOnClickListener(this.aTZ);
        this.aTV.setOnClickListener(this.aUa);
        if (com.baidu.adp.lib.b.e.eZ().Y("android_shouzhu_update") == 1) {
            this.aUb = true;
        } else {
            this.aUb = false;
        }
        String size = this.aTA.getSize();
        String newVersion = this.aTA.getNewVersion();
        String newVersionDesc = this.aTA.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(w.l.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.b(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aTH.setText(sb.toString());
        this.aTI.setText(newVersionDesc);
        if (this.aTA.forceUpdate()) {
            this.aTF = true;
            this.aTM.setText(this.mContext.getString(w.l.quit));
        } else {
            this.aTM.setText(this.mContext.getString(w.l.update_after));
        }
        if (this.aTB != null && this.aTB.showCombineDownload() && !TextUtils.isEmpty(this.aTB.getApkMD5RSA())) {
            this.aTL.setText(this.aTB.getAppName());
            if (!com.baidu.tieba.tbadkCore.ae.isInstalledPackage(this.mContext, this.aTB.getAppProc()) && !TextUtils.isEmpty(this.aTB.getAppUrl())) {
                this.aTL.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(w.g.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aTL.setCompoundDrawables(drawable, null, null, null);
                this.aTC = true;
            } else {
                this.aTL.setVisibility(8);
                this.aTC = false;
            }
        } else {
            this.aTL.setVisibility(8);
            this.aTC = false;
        }
        cj(this.aUb);
        this.aTN.setOnClickListener(new z(this));
        this.aTP.setOnClickListener(new aa(this));
        this.aTM.setOnClickListener(new ab(this));
        this.aTL.setOnClickListener(new ac(this));
        Ll();
    }

    private void Ll() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void cj(boolean z) {
        if (aj.b(this.mContext.getPackageManager())) {
            this.aTQ.setVisibility(8);
        } else {
            this.aTQ.setVisibility(0);
        }
        if (z) {
            if (this.aTA == null || TextUtils.isEmpty(this.aTA.getPatch()) || this.aTA.getNewVersionCode() < 0) {
                this.aTR.setVisibility(0);
                this.aTP.setText(w.l.super_update);
                aq.j(this.aTP, w.g.dialog_middle_item_bg_selector);
                this.aTX.setVisibility(0);
                this.aUc = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.aTR.setVisibility(0);
            this.aTP.setText(w.l.incremental_update);
            aq.j(this.aTP, w.g.dialog_single_button_bg_selector);
            this.aTW.setVisibility(8);
            this.aTX.setVisibility(8);
            this.aUc = true;
            TiebaStatic.log("c10002");
        } else if (this.aTA == null || TextUtils.isEmpty(this.aTA.getPatch()) || this.aTA.getNewVersionCode() < 0) {
            this.aTR.setVisibility(8);
            this.aTX.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.aTR.setVisibility(0);
            aq.j(this.aTP, w.g.dialog_middle_item_bg_selector);
            this.aTP.setText(w.l.incremental_update);
            this.aTX.setVisibility(0);
            this.aUc = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void fJ(int i) {
        this.aTN.setVisibility(8);
        this.aTR.setVisibility(8);
        this.aTM.setVisibility(8);
        this.aTO.setVisibility(8);
        this.aTE = true;
        this.aTX.setVisibility(0);
        this.aTJ.setVisibility(0);
        this.aTJ.setText(String.valueOf(this.aTK) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aTE) {
            this.aTY.stopService();
            this.aTG.setVisibility(8);
            if (this.aTF) {
                this.aTT.setText(getContext().getString(w.l.download_exit));
            }
            this.aTS.setVisibility(0);
            return;
        }
        this.aTY.Lo();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aTA = versionData;
        this.aTB = combineDownload;
        this.aTY = aVar;
    }

    public void Lm() {
        this.aTS.setVisibility(8);
        this.aTG.setVisibility(0);
    }

    public void j(View.OnClickListener onClickListener) {
        this.aTZ = onClickListener;
    }

    public void k(View.OnClickListener onClickListener) {
        this.aUa = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().aj(i == 1);
            tbPageContext.getLayoutMode().t(findViewById(w.h.app_download_dialog_layout));
        }
    }
}
