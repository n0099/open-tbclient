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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.ai;
/* loaded from: classes.dex */
public class t extends Dialog {
    private TextView aOA;
    private TextView aOB;
    private TextView aOC;
    private String aOD;
    private TextView aOE;
    private TextView aOF;
    private TextView aOG;
    private View aOH;
    private TextView aOI;
    private TextView aOJ;
    private View aOK;
    private LinearLayout aOL;
    private TextView aOM;
    private TextView aON;
    private TextView aOO;
    private View aOP;
    private LinearLayout aOQ;
    private a aOR;
    private View.OnClickListener aOS;
    private View.OnClickListener aOT;
    private boolean aOU;
    private boolean aOV;
    private VersionData aOt;
    private CombineDownload aOu;
    private boolean aOv;
    private boolean aOw;
    private boolean aOx;
    private boolean aOy;
    private LinearLayout aOz;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void JT();

        void JU();

        void cf(boolean z);

        void cg(boolean z);

        void stopService();
    }

    public t(Context context, int i) {
        super(context, i);
        this.aOv = false;
        this.aOw = true;
        this.aOx = false;
        this.aOy = false;
        this.aOU = true;
        this.aOV = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.h.app_download_dialog);
        this.aOz = (LinearLayout) findViewById(r.g.app_info);
        this.aOA = (TextView) findViewById(r.g.app_version_and_size);
        this.aOB = (TextView) findViewById(r.g.app_description);
        this.aOG = (TextView) findViewById(r.g.fullsize_download_button);
        this.aOF = (TextView) findViewById(r.g.cancel_download_button);
        this.aOH = findViewById(r.g.divider_line);
        this.aOC = (TextView) findViewById(r.g.download_process);
        this.aOI = (TextView) findViewById(r.g.incremental_download_button);
        this.aOJ = (TextView) findViewById(r.g.not_install_as_tip);
        this.aOK = findViewById(r.g.incremental_download_layout);
        this.aOE = (TextView) findViewById(r.g.other_app_recommend);
        this.aOP = findViewById(r.g.divider_under_button);
        this.aOQ = (LinearLayout) findViewById(r.g.cancel_confirm_ll);
        this.aOD = this.aOC.getText().toString();
        this.aOL = (LinearLayout) findViewById(r.g.cancel_dialog);
        this.aON = (TextView) findViewById(r.g.sure_cancel);
        this.aOO = (TextView) findViewById(r.g.cancel_button);
        this.aOM = (TextView) findViewById(r.g.cancel_tip);
        this.aON.setOnClickListener(this.aOS);
        this.aOO.setOnClickListener(this.aOT);
        if (com.baidu.adp.lib.c.e.dN().ac("android_shouzhu_update") == 1) {
            this.aOU = true;
        } else {
            this.aOU = false;
        }
        String size = this.aOt.getSize();
        String newVersion = this.aOt.getNewVersion();
        String newVersionDesc = this.aOt.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(r.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.h.b.b(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aOA.setText(sb.toString());
        this.aOB.setText(newVersionDesc);
        if (this.aOt.forceUpdate()) {
            this.aOy = true;
            this.aOF.setText(this.mContext.getString(r.j.quit));
        } else {
            this.aOF.setText(this.mContext.getString(r.j.update_after));
        }
        if (this.aOu != null && this.aOu.showCombineDownload() && !TextUtils.isEmpty(this.aOu.getApkMD5RSA())) {
            this.aOE.setText(this.aOu.getAppName());
            if (!ai.isInstalledPackage(this.mContext, this.aOu.getAppProc()) && !TextUtils.isEmpty(this.aOu.getAppUrl())) {
                this.aOE.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(r.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aOE.setCompoundDrawables(drawable, null, null, null);
                this.aOv = true;
            } else {
                this.aOE.setVisibility(8);
                this.aOv = false;
            }
        } else {
            this.aOE.setVisibility(8);
            this.aOv = false;
        }
        ce(this.aOU);
        this.aOG.setOnClickListener(new u(this));
        this.aOI.setOnClickListener(new v(this));
        this.aOF.setOnClickListener(new w(this));
        this.aOE.setOnClickListener(new x(this));
        JR();
    }

    private void JR() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void ce(boolean z) {
        if (af.b(this.mContext.getPackageManager())) {
            this.aOJ.setVisibility(8);
        } else {
            this.aOJ.setVisibility(0);
        }
        if (z) {
            if (this.aOt == null || TextUtils.isEmpty(this.aOt.getPatch()) || this.aOt.getNewVersionCode() < 0) {
                this.aOK.setVisibility(0);
                this.aOI.setText(r.j.super_update);
                ar.k(this.aOI, r.f.dialog_middle_item_bg_selector);
                this.aOQ.setVisibility(0);
                this.aOV = false;
                com.baidu.tbadk.core.util.TiebaStatic.log("c10008");
                com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
                return;
            }
            this.aOK.setVisibility(0);
            this.aOI.setText(r.j.incremental_update);
            ar.k(this.aOI, r.f.dialog_single_button_bg_selector);
            this.aOP.setVisibility(8);
            this.aOQ.setVisibility(8);
            this.aOV = true;
            com.baidu.tbadk.core.util.TiebaStatic.log("c10002");
        } else if (this.aOt == null || TextUtils.isEmpty(this.aOt.getPatch()) || this.aOt.getNewVersionCode() < 0) {
            this.aOK.setVisibility(8);
            this.aOQ.setVisibility(0);
            com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
        } else {
            this.aOK.setVisibility(0);
            ar.k(this.aOI, r.f.dialog_middle_item_bg_selector);
            this.aOI.setText(r.j.incremental_update);
            this.aOQ.setVisibility(0);
            this.aOV = true;
            com.baidu.tbadk.core.util.TiebaStatic.log("c10002");
            com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
        }
    }

    public void fI(int i) {
        this.aOG.setVisibility(8);
        this.aOK.setVisibility(8);
        this.aOF.setVisibility(8);
        this.aOH.setVisibility(8);
        this.aOx = true;
        this.aOQ.setVisibility(0);
        this.aOC.setVisibility(0);
        this.aOC.setText(String.valueOf(this.aOD) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aOx) {
            this.aOR.stopService();
            this.aOz.setVisibility(8);
            if (this.aOy) {
                this.aOM.setText(getContext().getString(r.j.download_exit));
            }
            this.aOL.setVisibility(0);
            return;
        }
        this.aOR.JU();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aOt = versionData;
        this.aOu = combineDownload;
        this.aOR = aVar;
    }

    public void JS() {
        this.aOL.setVisibility(8);
        this.aOz.setVisibility(0);
    }

    public void j(View.OnClickListener onClickListener) {
        this.aOS = onClickListener;
    }

    public void k(View.OnClickListener onClickListener) {
        this.aOT = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ai(i == 1);
            tbPageContext.getLayoutMode().x(findViewById(r.g.app_download_dialog_layout));
        }
    }
}
