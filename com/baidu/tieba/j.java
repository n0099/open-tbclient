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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.af;
/* loaded from: classes.dex */
public class j extends Dialog {
    private VersionData aCE;
    private CombineDownload aCF;
    private boolean aCG;
    private boolean aCH;
    private boolean aCI;
    private boolean aCJ;
    private LinearLayout aCK;
    private TextView aCL;
    private TextView aCM;
    private TextView aCN;
    private String aCO;
    private TextView aCP;
    private TextView aCQ;
    private TextView aCR;
    private View aCS;
    private TextView aCT;
    private TextView aCU;
    private View aCV;
    private LinearLayout aCW;
    private TextView aCX;
    private TextView aCY;
    private TextView aCZ;
    private View aDa;
    private LinearLayout aDb;
    private a aDc;
    private View.OnClickListener aDd;
    private View.OnClickListener aDe;
    private boolean aDf;
    private boolean aDg;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void FI();

        void FJ();

        void bs(boolean z);

        void bt(boolean z);

        void stopService();
    }

    public j(Context context, int i) {
        super(context, i);
        this.aCG = false;
        this.aCH = true;
        this.aCI = false;
        this.aCJ = false;
        this.aDf = true;
        this.aDg = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.app_download_dialog);
        this.aCK = (LinearLayout) findViewById(i.f.app_info);
        this.aCL = (TextView) findViewById(i.f.app_version_and_size);
        this.aCM = (TextView) findViewById(i.f.app_description);
        this.aCR = (TextView) findViewById(i.f.fullsize_download_button);
        this.aCQ = (TextView) findViewById(i.f.cancel_download_button);
        this.aCS = findViewById(i.f.divider_line);
        this.aCN = (TextView) findViewById(i.f.download_process);
        this.aCT = (TextView) findViewById(i.f.incremental_download_button);
        this.aCU = (TextView) findViewById(i.f.not_install_as_tip);
        this.aCV = findViewById(i.f.incremental_download_layout);
        this.aCP = (TextView) findViewById(i.f.other_app_recommend);
        this.aDa = findViewById(i.f.divider_under_button);
        this.aDb = (LinearLayout) findViewById(i.f.cancel_confirm_ll);
        this.aCO = this.aCN.getText().toString();
        this.aCW = (LinearLayout) findViewById(i.f.cancel_dialog);
        this.aCY = (TextView) findViewById(i.f.sure_cancel);
        this.aCZ = (TextView) findViewById(i.f.cancel_button);
        this.aCX = (TextView) findViewById(i.f.cancel_tip);
        this.aCY.setOnClickListener(this.aDd);
        this.aCZ.setOnClickListener(this.aDe);
        if (com.baidu.adp.lib.b.e.gy().ah("android_shouzhu_update") == 1) {
            this.aDf = true;
        } else {
            this.aDf = false;
        }
        String size = this.aCE.getSize();
        String newVersion = this.aCE.getNewVersion();
        String newVersionDesc = this.aCE.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(i.C0057i.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.a(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aCL.setText(sb.toString());
        this.aCM.setText(newVersionDesc);
        if (this.aCE.forceUpdate()) {
            this.aCJ = true;
            this.aCQ.setText(this.mContext.getString(i.C0057i.quit));
        } else {
            this.aCQ.setText(this.mContext.getString(i.C0057i.update_after));
        }
        if (this.aCF != null && this.aCF.showCombineDownload()) {
            this.aCP.setText(this.aCF.getAppName());
            if (!af.isInstalledPackage(this.mContext, this.aCF.getAppProc()) && !TextUtils.isEmpty(this.aCF.getAppUrl())) {
                this.aCP.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(i.e.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aCP.setCompoundDrawables(drawable, null, null, null);
                this.aCG = true;
            } else {
                this.aCP.setVisibility(8);
                this.aCG = false;
            }
        } else {
            this.aCP.setVisibility(8);
            this.aCG = false;
        }
        br(this.aDf);
        this.aCR.setOnClickListener(new k(this));
        this.aCT.setOnClickListener(new l(this));
        this.aCQ.setOnClickListener(new m(this));
        this.aCP.setOnClickListener(new n(this));
        FG();
    }

    private void FG() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void br(boolean z) {
        if (t.a(this.mContext.getPackageManager())) {
            this.aCU.setVisibility(8);
        } else {
            this.aCU.setVisibility(0);
        }
        if (z) {
            if (this.aCE == null || TextUtils.isEmpty(this.aCE.getPatch()) || this.aCE.getNewVersionCode() < 0) {
                this.aCV.setVisibility(0);
                this.aCT.setText(i.C0057i.super_update);
                al.i((View) this.aCT, i.e.dialog_middle_item_bg_selector);
                this.aDb.setVisibility(0);
                this.aDg = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.aCV.setVisibility(0);
            this.aCT.setText(i.C0057i.incremental_update);
            al.i((View) this.aCT, i.e.dialog_single_button_bg_selector);
            this.aDa.setVisibility(8);
            this.aDb.setVisibility(8);
            this.aDg = true;
            TiebaStatic.log("c10002");
        } else if (this.aCE == null || TextUtils.isEmpty(this.aCE.getPatch()) || this.aCE.getNewVersionCode() < 0) {
            this.aCV.setVisibility(8);
            this.aDb.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.aCV.setVisibility(0);
            al.i((View) this.aCT, i.e.dialog_middle_item_bg_selector);
            this.aCT.setText(i.C0057i.incremental_update);
            this.aDb.setVisibility(0);
            this.aDg = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void eC(int i) {
        this.aCR.setVisibility(8);
        this.aCV.setVisibility(8);
        this.aCQ.setVisibility(8);
        this.aCS.setVisibility(8);
        this.aCI = true;
        this.aDb.setVisibility(0);
        this.aCN.setVisibility(0);
        this.aCN.setText(String.valueOf(this.aCO) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aCI) {
            this.aDc.stopService();
            this.aCK.setVisibility(8);
            if (this.aCJ) {
                this.aCX.setText(getContext().getString(i.C0057i.download_exit));
            }
            this.aCW.setVisibility(0);
            return;
        }
        this.aDc.FJ();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aCE = versionData;
        this.aCF = combineDownload;
        this.aDc = aVar;
    }

    public void FH() {
        this.aCW.setVisibility(8);
        this.aCK.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.aDd = onClickListener;
    }

    public void g(View.OnClickListener onClickListener) {
        this.aDe = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ad(i == 1);
            tbPageContext.getLayoutMode().k(findViewById(i.f.app_download_dialog_layout));
        }
    }
}
