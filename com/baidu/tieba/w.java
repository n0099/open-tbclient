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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.tbadkCore.al;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class w extends Dialog {
    private VersionData aHE;
    private CombineDownload aHF;
    private boolean aHG;
    private boolean aHH;
    private boolean aHI;
    private boolean aHJ;
    private LinearLayout aHK;
    private TextView aHL;
    private TextView aHM;
    private TextView aHN;
    private String aHO;
    private TextView aHP;
    private TextView aHQ;
    private TextView aHR;
    private View aHS;
    private TextView aHT;
    private TextView aHU;
    private View aHV;
    private LinearLayout aHW;
    private TextView aHX;
    private TextView aHY;
    private TextView aHZ;
    private View aIa;
    private LinearLayout aIb;
    private a aIc;
    private View.OnClickListener aId;
    private View.OnClickListener aIe;
    private boolean aIf;
    private boolean aIg;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void HS();

        void HT();

        void bW(boolean z);

        void bX(boolean z);

        void stopService();
    }

    public w(Context context, int i) {
        super(context, i);
        this.aHG = false;
        this.aHH = true;
        this.aHI = false;
        this.aHJ = false;
        this.aIf = true;
        this.aIg = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(u.h.app_download_dialog);
        this.aHK = (LinearLayout) findViewById(u.g.app_info);
        this.aHL = (TextView) findViewById(u.g.app_version_and_size);
        this.aHM = (TextView) findViewById(u.g.app_description);
        this.aHR = (TextView) findViewById(u.g.fullsize_download_button);
        this.aHQ = (TextView) findViewById(u.g.cancel_download_button);
        this.aHS = findViewById(u.g.divider_line);
        this.aHN = (TextView) findViewById(u.g.download_process);
        this.aHT = (TextView) findViewById(u.g.incremental_download_button);
        this.aHU = (TextView) findViewById(u.g.not_install_as_tip);
        this.aHV = findViewById(u.g.incremental_download_layout);
        this.aHP = (TextView) findViewById(u.g.other_app_recommend);
        this.aIa = findViewById(u.g.divider_under_button);
        this.aIb = (LinearLayout) findViewById(u.g.cancel_confirm_ll);
        this.aHO = this.aHN.getText().toString();
        this.aHW = (LinearLayout) findViewById(u.g.cancel_dialog);
        this.aHY = (TextView) findViewById(u.g.sure_cancel);
        this.aHZ = (TextView) findViewById(u.g.cancel_button);
        this.aHX = (TextView) findViewById(u.g.cancel_tip);
        this.aHY.setOnClickListener(this.aId);
        this.aHZ.setOnClickListener(this.aIe);
        if (com.baidu.adp.lib.c.e.cT().Z("android_shouzhu_update") == 1) {
            this.aIf = true;
        } else {
            this.aIf = false;
        }
        String size = this.aHE.getSize();
        String newVersion = this.aHE.getNewVersion();
        String newVersionDesc = this.aHE.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(u.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.h.b.a(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aHL.setText(sb.toString());
        this.aHM.setText(newVersionDesc);
        if (this.aHE.forceUpdate()) {
            this.aHJ = true;
            this.aHQ.setText(this.mContext.getString(u.j.quit));
        } else {
            this.aHQ.setText(this.mContext.getString(u.j.update_after));
        }
        if (this.aHF != null && this.aHF.showCombineDownload() && !TextUtils.isEmpty(this.aHF.getApkMD5RSA())) {
            this.aHP.setText(this.aHF.getAppName());
            if (!al.isInstalledPackage(this.mContext, this.aHF.getAppProc()) && !TextUtils.isEmpty(this.aHF.getAppUrl())) {
                this.aHP.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(u.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aHP.setCompoundDrawables(drawable, null, null, null);
                this.aHG = true;
            } else {
                this.aHP.setVisibility(8);
                this.aHG = false;
            }
        } else {
            this.aHP.setVisibility(8);
            this.aHG = false;
        }
        bV(this.aIf);
        this.aHR.setOnClickListener(new x(this));
        this.aHT.setOnClickListener(new y(this));
        this.aHQ.setOnClickListener(new z(this));
        this.aHP.setOnClickListener(new aa(this));
        HQ();
    }

    private void HQ() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void bV(boolean z) {
        if (ai.b(this.mContext.getPackageManager())) {
            this.aHU.setVisibility(8);
        } else {
            this.aHU.setVisibility(0);
        }
        if (z) {
            if (this.aHE == null || TextUtils.isEmpty(this.aHE.getPatch()) || this.aHE.getNewVersionCode() < 0) {
                this.aHV.setVisibility(0);
                this.aHT.setText(u.j.super_update);
                av.k(this.aHT, u.f.dialog_middle_item_bg_selector);
                this.aIb.setVisibility(0);
                this.aIg = false;
                com.baidu.tbadk.core.util.TiebaStatic.log("c10008");
                com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
                return;
            }
            this.aHV.setVisibility(0);
            this.aHT.setText(u.j.incremental_update);
            av.k(this.aHT, u.f.dialog_single_button_bg_selector);
            this.aIa.setVisibility(8);
            this.aIb.setVisibility(8);
            this.aIg = true;
            com.baidu.tbadk.core.util.TiebaStatic.log("c10002");
        } else if (this.aHE == null || TextUtils.isEmpty(this.aHE.getPatch()) || this.aHE.getNewVersionCode() < 0) {
            this.aHV.setVisibility(8);
            this.aIb.setVisibility(0);
            com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
        } else {
            this.aHV.setVisibility(0);
            av.k(this.aHT, u.f.dialog_middle_item_bg_selector);
            this.aHT.setText(u.j.incremental_update);
            this.aIb.setVisibility(0);
            this.aIg = true;
            com.baidu.tbadk.core.util.TiebaStatic.log("c10002");
            com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
        }
    }

    public void fq(int i) {
        this.aHR.setVisibility(8);
        this.aHV.setVisibility(8);
        this.aHQ.setVisibility(8);
        this.aHS.setVisibility(8);
        this.aHI = true;
        this.aIb.setVisibility(0);
        this.aHN.setVisibility(0);
        this.aHN.setText(String.valueOf(this.aHO) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aHI) {
            this.aIc.stopService();
            this.aHK.setVisibility(8);
            if (this.aHJ) {
                this.aHX.setText(getContext().getString(u.j.download_exit));
            }
            this.aHW.setVisibility(0);
            return;
        }
        this.aIc.HT();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aHE = versionData;
        this.aHF = combineDownload;
        this.aIc = aVar;
    }

    public void HR() {
        this.aHW.setVisibility(8);
        this.aHK.setVisibility(0);
    }

    public void j(View.OnClickListener onClickListener) {
        this.aId = onClickListener;
    }

    public void k(View.OnClickListener onClickListener) {
        this.aIe = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ad(i == 1);
            tbPageContext.getLayoutMode().w(findViewById(u.g.app_download_dialog_layout));
        }
    }
}
