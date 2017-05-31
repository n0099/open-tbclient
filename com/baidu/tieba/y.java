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
    private boolean aRA;
    private boolean aRB;
    private boolean aRC;
    private LinearLayout aRD;
    private TextView aRE;
    private TextView aRF;
    private TextView aRG;
    private String aRH;
    private TextView aRI;
    private TextView aRJ;
    private TextView aRK;
    private View aRL;
    private TextView aRM;
    private TextView aRN;
    private View aRO;
    private LinearLayout aRP;
    private TextView aRQ;
    private TextView aRR;
    private TextView aRS;
    private View aRT;
    private LinearLayout aRU;
    private a aRV;
    private View.OnClickListener aRW;
    private View.OnClickListener aRX;
    private boolean aRY;
    private boolean aRZ;
    private VersionData aRx;
    private CombineDownload aRy;
    private boolean aRz;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void Jw();

        void Jx();

        void cj(boolean z);

        void ck(boolean z);

        void stopService();
    }

    public y(Context context, int i) {
        super(context, i);
        this.aRz = false;
        this.aRA = true;
        this.aRB = false;
        this.aRC = false;
        this.aRY = true;
        this.aRZ = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.app_download_dialog);
        this.aRD = (LinearLayout) findViewById(w.h.app_info);
        this.aRE = (TextView) findViewById(w.h.app_version_and_size);
        this.aRF = (TextView) findViewById(w.h.app_description);
        this.aRK = (TextView) findViewById(w.h.fullsize_download_button);
        this.aRJ = (TextView) findViewById(w.h.cancel_download_button);
        this.aRL = findViewById(w.h.divider_line);
        this.aRG = (TextView) findViewById(w.h.download_process);
        this.aRM = (TextView) findViewById(w.h.incremental_download_button);
        this.aRN = (TextView) findViewById(w.h.not_install_as_tip);
        this.aRO = findViewById(w.h.incremental_download_layout);
        this.aRI = (TextView) findViewById(w.h.other_app_recommend);
        this.aRT = findViewById(w.h.divider_under_button);
        this.aRU = (LinearLayout) findViewById(w.h.cancel_confirm_ll);
        this.aRH = this.aRG.getText().toString();
        this.aRP = (LinearLayout) findViewById(w.h.cancel_dialog);
        this.aRR = (TextView) findViewById(w.h.sure_cancel);
        this.aRS = (TextView) findViewById(w.h.cancel_button);
        this.aRQ = (TextView) findViewById(w.h.cancel_tip);
        this.aRR.setOnClickListener(this.aRW);
        this.aRS.setOnClickListener(this.aRX);
        if (com.baidu.adp.lib.b.e.eZ().Y("android_shouzhu_update") == 1) {
            this.aRY = true;
        } else {
            this.aRY = false;
        }
        String size = this.aRx.getSize();
        String newVersion = this.aRx.getNewVersion();
        String newVersionDesc = this.aRx.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(w.l.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.b(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aRE.setText(sb.toString());
        this.aRF.setText(newVersionDesc);
        if (this.aRx.forceUpdate()) {
            this.aRC = true;
            this.aRJ.setText(this.mContext.getString(w.l.quit));
        } else {
            this.aRJ.setText(this.mContext.getString(w.l.update_after));
        }
        if (this.aRy != null && this.aRy.showCombineDownload() && !TextUtils.isEmpty(this.aRy.getApkMD5RSA())) {
            this.aRI.setText(this.aRy.getAppName());
            if (!com.baidu.tieba.tbadkCore.ac.isInstalledPackage(this.mContext, this.aRy.getAppProc()) && !TextUtils.isEmpty(this.aRy.getAppUrl())) {
                this.aRI.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(w.g.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aRI.setCompoundDrawables(drawable, null, null, null);
                this.aRz = true;
            } else {
                this.aRI.setVisibility(8);
                this.aRz = false;
            }
        } else {
            this.aRI.setVisibility(8);
            this.aRz = false;
        }
        ci(this.aRY);
        this.aRK.setOnClickListener(new z(this));
        this.aRM.setOnClickListener(new aa(this));
        this.aRJ.setOnClickListener(new ab(this));
        this.aRI.setOnClickListener(new ac(this));
        Ju();
    }

    private void Ju() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void ci(boolean z) {
        if (aj.b(this.mContext.getPackageManager())) {
            this.aRN.setVisibility(8);
        } else {
            this.aRN.setVisibility(0);
        }
        if (z) {
            if (this.aRx == null || TextUtils.isEmpty(this.aRx.getPatch()) || this.aRx.getNewVersionCode() < 0) {
                this.aRO.setVisibility(0);
                this.aRM.setText(w.l.super_update);
                aq.j(this.aRM, w.g.dialog_middle_item_bg_selector);
                this.aRU.setVisibility(0);
                this.aRZ = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.aRO.setVisibility(0);
            this.aRM.setText(w.l.incremental_update);
            aq.j(this.aRM, w.g.dialog_single_button_bg_selector);
            this.aRT.setVisibility(8);
            this.aRU.setVisibility(8);
            this.aRZ = true;
            TiebaStatic.log("c10002");
        } else if (this.aRx == null || TextUtils.isEmpty(this.aRx.getPatch()) || this.aRx.getNewVersionCode() < 0) {
            this.aRO.setVisibility(8);
            this.aRU.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.aRO.setVisibility(0);
            aq.j(this.aRM, w.g.dialog_middle_item_bg_selector);
            this.aRM.setText(w.l.incremental_update);
            this.aRU.setVisibility(0);
            this.aRZ = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void fG(int i) {
        this.aRK.setVisibility(8);
        this.aRO.setVisibility(8);
        this.aRJ.setVisibility(8);
        this.aRL.setVisibility(8);
        this.aRB = true;
        this.aRU.setVisibility(0);
        this.aRG.setVisibility(0);
        this.aRG.setText(String.valueOf(this.aRH) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aRB) {
            this.aRV.stopService();
            this.aRD.setVisibility(8);
            if (this.aRC) {
                this.aRQ.setText(getContext().getString(w.l.download_exit));
            }
            this.aRP.setVisibility(0);
            return;
        }
        this.aRV.Jx();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aRx = versionData;
        this.aRy = combineDownload;
        this.aRV = aVar;
    }

    public void Jv() {
        this.aRP.setVisibility(8);
        this.aRD.setVisibility(0);
    }

    public void i(View.OnClickListener onClickListener) {
        this.aRW = onClickListener;
    }

    public void j(View.OnClickListener onClickListener) {
        this.aRX = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ah(i == 1);
            tbPageContext.getLayoutMode().t(findViewById(w.h.app_download_dialog_layout));
        }
    }
}
