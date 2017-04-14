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
    private boolean aTA;
    private boolean aTB;
    private boolean aTC;
    private boolean aTD;
    private LinearLayout aTE;
    private TextView aTF;
    private TextView aTG;
    private TextView aTH;
    private String aTI;
    private TextView aTJ;
    private TextView aTK;
    private TextView aTL;
    private View aTM;
    private TextView aTN;
    private TextView aTO;
    private View aTP;
    private LinearLayout aTQ;
    private TextView aTR;
    private TextView aTS;
    private TextView aTT;
    private View aTU;
    private LinearLayout aTV;
    private a aTW;
    private View.OnClickListener aTX;
    private View.OnClickListener aTY;
    private boolean aTZ;
    private VersionData aTy;
    private CombineDownload aTz;
    private boolean aUa;
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
        this.aTA = false;
        this.aTB = true;
        this.aTC = false;
        this.aTD = false;
        this.aTZ = true;
        this.aUa = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.app_download_dialog);
        this.aTE = (LinearLayout) findViewById(w.h.app_info);
        this.aTF = (TextView) findViewById(w.h.app_version_and_size);
        this.aTG = (TextView) findViewById(w.h.app_description);
        this.aTL = (TextView) findViewById(w.h.fullsize_download_button);
        this.aTK = (TextView) findViewById(w.h.cancel_download_button);
        this.aTM = findViewById(w.h.divider_line);
        this.aTH = (TextView) findViewById(w.h.download_process);
        this.aTN = (TextView) findViewById(w.h.incremental_download_button);
        this.aTO = (TextView) findViewById(w.h.not_install_as_tip);
        this.aTP = findViewById(w.h.incremental_download_layout);
        this.aTJ = (TextView) findViewById(w.h.other_app_recommend);
        this.aTU = findViewById(w.h.divider_under_button);
        this.aTV = (LinearLayout) findViewById(w.h.cancel_confirm_ll);
        this.aTI = this.aTH.getText().toString();
        this.aTQ = (LinearLayout) findViewById(w.h.cancel_dialog);
        this.aTS = (TextView) findViewById(w.h.sure_cancel);
        this.aTT = (TextView) findViewById(w.h.cancel_button);
        this.aTR = (TextView) findViewById(w.h.cancel_tip);
        this.aTS.setOnClickListener(this.aTX);
        this.aTT.setOnClickListener(this.aTY);
        if (com.baidu.adp.lib.b.e.eY().Y("android_shouzhu_update") == 1) {
            this.aTZ = true;
        } else {
            this.aTZ = false;
        }
        String size = this.aTy.getSize();
        String newVersion = this.aTy.getNewVersion();
        String newVersionDesc = this.aTy.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(w.l.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.b(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aTF.setText(sb.toString());
        this.aTG.setText(newVersionDesc);
        if (this.aTy.forceUpdate()) {
            this.aTD = true;
            this.aTK.setText(this.mContext.getString(w.l.quit));
        } else {
            this.aTK.setText(this.mContext.getString(w.l.update_after));
        }
        if (this.aTz != null && this.aTz.showCombineDownload() && !TextUtils.isEmpty(this.aTz.getApkMD5RSA())) {
            this.aTJ.setText(this.aTz.getAppName());
            if (!com.baidu.tieba.tbadkCore.ae.isInstalledPackage(this.mContext, this.aTz.getAppProc()) && !TextUtils.isEmpty(this.aTz.getAppUrl())) {
                this.aTJ.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(w.g.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aTJ.setCompoundDrawables(drawable, null, null, null);
                this.aTA = true;
            } else {
                this.aTJ.setVisibility(8);
                this.aTA = false;
            }
        } else {
            this.aTJ.setVisibility(8);
            this.aTA = false;
        }
        cj(this.aTZ);
        this.aTL.setOnClickListener(new z(this));
        this.aTN.setOnClickListener(new aa(this));
        this.aTK.setOnClickListener(new ab(this));
        this.aTJ.setOnClickListener(new ac(this));
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
            this.aTO.setVisibility(8);
        } else {
            this.aTO.setVisibility(0);
        }
        if (z) {
            if (this.aTy == null || TextUtils.isEmpty(this.aTy.getPatch()) || this.aTy.getNewVersionCode() < 0) {
                this.aTP.setVisibility(0);
                this.aTN.setText(w.l.super_update);
                aq.j(this.aTN, w.g.dialog_middle_item_bg_selector);
                this.aTV.setVisibility(0);
                this.aUa = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.aTP.setVisibility(0);
            this.aTN.setText(w.l.incremental_update);
            aq.j(this.aTN, w.g.dialog_single_button_bg_selector);
            this.aTU.setVisibility(8);
            this.aTV.setVisibility(8);
            this.aUa = true;
            TiebaStatic.log("c10002");
        } else if (this.aTy == null || TextUtils.isEmpty(this.aTy.getPatch()) || this.aTy.getNewVersionCode() < 0) {
            this.aTP.setVisibility(8);
            this.aTV.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.aTP.setVisibility(0);
            aq.j(this.aTN, w.g.dialog_middle_item_bg_selector);
            this.aTN.setText(w.l.incremental_update);
            this.aTV.setVisibility(0);
            this.aUa = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void fJ(int i) {
        this.aTL.setVisibility(8);
        this.aTP.setVisibility(8);
        this.aTK.setVisibility(8);
        this.aTM.setVisibility(8);
        this.aTC = true;
        this.aTV.setVisibility(0);
        this.aTH.setVisibility(0);
        this.aTH.setText(String.valueOf(this.aTI) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aTC) {
            this.aTW.stopService();
            this.aTE.setVisibility(8);
            if (this.aTD) {
                this.aTR.setText(getContext().getString(w.l.download_exit));
            }
            this.aTQ.setVisibility(0);
            return;
        }
        this.aTW.Lo();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aTy = versionData;
        this.aTz = combineDownload;
        this.aTW = aVar;
    }

    public void Lm() {
        this.aTQ.setVisibility(8);
        this.aTE.setVisibility(0);
    }

    public void j(View.OnClickListener onClickListener) {
        this.aTX = onClickListener;
    }

    public void k(View.OnClickListener onClickListener) {
        this.aTY = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().aj(i == 1);
            tbPageContext.getLayoutMode().t(findViewById(w.h.app_download_dialog_layout));
        }
    }
}
