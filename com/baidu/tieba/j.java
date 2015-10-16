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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.ag;
/* loaded from: classes.dex */
public class j extends Dialog {
    private VersionData aDC;
    private CombineDownload aDD;
    private boolean aDE;
    private boolean aDF;
    private boolean aDG;
    private boolean aDH;
    private LinearLayout aDI;
    private TextView aDJ;
    private TextView aDK;
    private TextView aDL;
    private String aDM;
    private TextView aDN;
    private TextView aDO;
    private TextView aDP;
    private View aDQ;
    private TextView aDR;
    private TextView aDS;
    private View aDT;
    private LinearLayout aDU;
    private TextView aDV;
    private TextView aDW;
    private TextView aDX;
    private View aDY;
    private LinearLayout aDZ;
    private a aEa;
    private View.OnClickListener aEb;
    private View.OnClickListener aEc;
    private boolean aEd;
    private boolean aEe;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void FM();

        void FN();

        void bw(boolean z);

        void bx(boolean z);

        void stopService();
    }

    public j(Context context, int i) {
        super(context, i);
        this.aDE = false;
        this.aDF = true;
        this.aDG = false;
        this.aDH = false;
        this.aEd = true;
        this.aEe = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.app_download_dialog);
        this.aDI = (LinearLayout) findViewById(i.f.app_info);
        this.aDJ = (TextView) findViewById(i.f.app_version_and_size);
        this.aDK = (TextView) findViewById(i.f.app_description);
        this.aDP = (TextView) findViewById(i.f.fullsize_download_button);
        this.aDO = (TextView) findViewById(i.f.cancel_download_button);
        this.aDQ = findViewById(i.f.divider_line);
        this.aDL = (TextView) findViewById(i.f.download_process);
        this.aDR = (TextView) findViewById(i.f.incremental_download_button);
        this.aDS = (TextView) findViewById(i.f.not_install_as_tip);
        this.aDT = findViewById(i.f.incremental_download_layout);
        this.aDN = (TextView) findViewById(i.f.other_app_recommend);
        this.aDY = findViewById(i.f.divider_under_button);
        this.aDZ = (LinearLayout) findViewById(i.f.cancel_confirm_ll);
        this.aDM = this.aDL.getText().toString();
        this.aDU = (LinearLayout) findViewById(i.f.cancel_dialog);
        this.aDW = (TextView) findViewById(i.f.sure_cancel);
        this.aDX = (TextView) findViewById(i.f.cancel_button);
        this.aDV = (TextView) findViewById(i.f.cancel_tip);
        this.aDW.setOnClickListener(this.aEb);
        this.aDX.setOnClickListener(this.aEc);
        if (com.baidu.adp.lib.b.e.gv().ah("android_shouzhu_update") == 1) {
            this.aEd = true;
        } else {
            this.aEd = false;
        }
        String size = this.aDC.getSize();
        String newVersion = this.aDC.getNewVersion();
        String newVersionDesc = this.aDC.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(i.h.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.a(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aDJ.setText(sb.toString());
        this.aDK.setText(newVersionDesc);
        if (this.aDC.forceUpdate()) {
            this.aDH = true;
            this.aDO.setText(this.mContext.getString(i.h.quit));
        } else {
            this.aDO.setText(this.mContext.getString(i.h.update_after));
        }
        if (this.aDD != null && this.aDD.showCombineDownload()) {
            this.aDN.setText(this.aDD.getAppName());
            if (!ag.isInstalledPackage(this.mContext, this.aDD.getAppProc()) && !TextUtils.isEmpty(this.aDD.getAppUrl())) {
                this.aDN.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(i.e.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aDN.setCompoundDrawables(drawable, null, null, null);
                this.aDE = true;
            } else {
                this.aDN.setVisibility(8);
                this.aDE = false;
            }
        } else {
            this.aDN.setVisibility(8);
            this.aDE = false;
        }
        bv(this.aEd);
        this.aDP.setOnClickListener(new k(this));
        this.aDR.setOnClickListener(new l(this));
        this.aDO.setOnClickListener(new m(this));
        this.aDN.setOnClickListener(new n(this));
        FK();
    }

    private void FK() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void bv(boolean z) {
        if (t.a(this.mContext.getPackageManager())) {
            this.aDS.setVisibility(8);
        } else {
            this.aDS.setVisibility(0);
        }
        if (z) {
            if (this.aDC == null || TextUtils.isEmpty(this.aDC.getPatch()) || this.aDC.getNewVersionCode() < 0) {
                this.aDT.setVisibility(0);
                this.aDR.setText(i.h.super_update);
                an.i((View) this.aDR, i.e.dialog_middle_item_bg_selector);
                this.aDZ.setVisibility(0);
                this.aEe = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.aDT.setVisibility(0);
            this.aDR.setText(i.h.incremental_update);
            an.i((View) this.aDR, i.e.dialog_single_button_bg_selector);
            this.aDY.setVisibility(8);
            this.aDZ.setVisibility(8);
            this.aEe = true;
            TiebaStatic.log("c10002");
        } else if (this.aDC == null || TextUtils.isEmpty(this.aDC.getPatch()) || this.aDC.getNewVersionCode() < 0) {
            this.aDT.setVisibility(8);
            this.aDZ.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.aDT.setVisibility(0);
            an.i((View) this.aDR, i.e.dialog_middle_item_bg_selector);
            this.aDR.setText(i.h.incremental_update);
            this.aDZ.setVisibility(0);
            this.aEe = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void eP(int i) {
        this.aDP.setVisibility(8);
        this.aDT.setVisibility(8);
        this.aDO.setVisibility(8);
        this.aDQ.setVisibility(8);
        this.aDG = true;
        this.aDZ.setVisibility(0);
        this.aDL.setVisibility(0);
        this.aDL.setText(String.valueOf(this.aDM) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aDG) {
            this.aEa.stopService();
            this.aDI.setVisibility(8);
            if (this.aDH) {
                this.aDV.setText(getContext().getString(i.h.download_exit));
            }
            this.aDU.setVisibility(0);
            return;
        }
        this.aEa.FN();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aDC = versionData;
        this.aDD = combineDownload;
        this.aEa = aVar;
    }

    public void FL() {
        this.aDU.setVisibility(8);
        this.aDI.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.aEb = onClickListener;
    }

    public void g(View.OnClickListener onClickListener) {
        this.aEc = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ad(i == 1);
            tbPageContext.getLayoutMode().k(findViewById(i.f.app_download_dialog_layout));
        }
    }
}
