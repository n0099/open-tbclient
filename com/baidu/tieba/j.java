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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.ag;
/* loaded from: classes.dex */
public class j extends Dialog {
    private TextView aDA;
    private String aDB;
    private TextView aDC;
    private TextView aDD;
    private TextView aDE;
    private View aDF;
    private TextView aDG;
    private TextView aDH;
    private View aDI;
    private LinearLayout aDJ;
    private TextView aDK;
    private TextView aDL;
    private TextView aDM;
    private View aDN;
    private LinearLayout aDO;
    private a aDP;
    private View.OnClickListener aDQ;
    private View.OnClickListener aDR;
    private boolean aDS;
    private boolean aDT;
    private VersionData aDr;
    private CombineDownload aDs;
    private boolean aDt;
    private boolean aDu;
    private boolean aDv;
    private boolean aDw;
    private LinearLayout aDx;
    private TextView aDy;
    private TextView aDz;
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
        this.aDt = false;
        this.aDu = true;
        this.aDv = false;
        this.aDw = false;
        this.aDS = true;
        this.aDT = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.app_download_dialog);
        this.aDx = (LinearLayout) findViewById(i.f.app_info);
        this.aDy = (TextView) findViewById(i.f.app_version_and_size);
        this.aDz = (TextView) findViewById(i.f.app_description);
        this.aDE = (TextView) findViewById(i.f.fullsize_download_button);
        this.aDD = (TextView) findViewById(i.f.cancel_download_button);
        this.aDF = findViewById(i.f.divider_line);
        this.aDA = (TextView) findViewById(i.f.download_process);
        this.aDG = (TextView) findViewById(i.f.incremental_download_button);
        this.aDH = (TextView) findViewById(i.f.not_install_as_tip);
        this.aDI = findViewById(i.f.incremental_download_layout);
        this.aDC = (TextView) findViewById(i.f.other_app_recommend);
        this.aDN = findViewById(i.f.divider_under_button);
        this.aDO = (LinearLayout) findViewById(i.f.cancel_confirm_ll);
        this.aDB = this.aDA.getText().toString();
        this.aDJ = (LinearLayout) findViewById(i.f.cancel_dialog);
        this.aDL = (TextView) findViewById(i.f.sure_cancel);
        this.aDM = (TextView) findViewById(i.f.cancel_button);
        this.aDK = (TextView) findViewById(i.f.cancel_tip);
        this.aDL.setOnClickListener(this.aDQ);
        this.aDM.setOnClickListener(this.aDR);
        if (com.baidu.adp.lib.b.e.gv().ah("android_shouzhu_update") == 1) {
            this.aDS = true;
        } else {
            this.aDS = false;
        }
        String size = this.aDr.getSize();
        String newVersion = this.aDr.getNewVersion();
        String newVersionDesc = this.aDr.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(i.h.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.a(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aDy.setText(sb.toString());
        this.aDz.setText(newVersionDesc);
        if (this.aDr.forceUpdate()) {
            this.aDw = true;
            this.aDD.setText(this.mContext.getString(i.h.quit));
        } else {
            this.aDD.setText(this.mContext.getString(i.h.update_after));
        }
        if (this.aDs != null && this.aDs.showCombineDownload()) {
            this.aDC.setText(this.aDs.getAppName());
            if (!ag.isInstalledPackage(this.mContext, this.aDs.getAppProc()) && !TextUtils.isEmpty(this.aDs.getAppUrl())) {
                this.aDC.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(i.e.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aDC.setCompoundDrawables(drawable, null, null, null);
                this.aDt = true;
            } else {
                this.aDC.setVisibility(8);
                this.aDt = false;
            }
        } else {
            this.aDC.setVisibility(8);
            this.aDt = false;
        }
        bv(this.aDS);
        this.aDE.setOnClickListener(new k(this));
        this.aDG.setOnClickListener(new l(this));
        this.aDD.setOnClickListener(new m(this));
        this.aDC.setOnClickListener(new n(this));
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
            this.aDH.setVisibility(8);
        } else {
            this.aDH.setVisibility(0);
        }
        if (z) {
            if (this.aDr == null || TextUtils.isEmpty(this.aDr.getPatch()) || this.aDr.getNewVersionCode() < 0) {
                this.aDI.setVisibility(0);
                this.aDG.setText(i.h.super_update);
                am.i((View) this.aDG, i.e.dialog_middle_item_bg_selector);
                this.aDO.setVisibility(0);
                this.aDT = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.aDI.setVisibility(0);
            this.aDG.setText(i.h.incremental_update);
            am.i((View) this.aDG, i.e.dialog_single_button_bg_selector);
            this.aDN.setVisibility(8);
            this.aDO.setVisibility(8);
            this.aDT = true;
            TiebaStatic.log("c10002");
        } else if (this.aDr == null || TextUtils.isEmpty(this.aDr.getPatch()) || this.aDr.getNewVersionCode() < 0) {
            this.aDI.setVisibility(8);
            this.aDO.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.aDI.setVisibility(0);
            am.i((View) this.aDG, i.e.dialog_middle_item_bg_selector);
            this.aDG.setText(i.h.incremental_update);
            this.aDO.setVisibility(0);
            this.aDT = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void eP(int i) {
        this.aDE.setVisibility(8);
        this.aDI.setVisibility(8);
        this.aDD.setVisibility(8);
        this.aDF.setVisibility(8);
        this.aDv = true;
        this.aDO.setVisibility(0);
        this.aDA.setVisibility(0);
        this.aDA.setText(String.valueOf(this.aDB) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aDv) {
            this.aDP.stopService();
            this.aDx.setVisibility(8);
            if (this.aDw) {
                this.aDK.setText(getContext().getString(i.h.download_exit));
            }
            this.aDJ.setVisibility(0);
            return;
        }
        this.aDP.FN();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aDr = versionData;
        this.aDs = combineDownload;
        this.aDP = aVar;
    }

    public void FL() {
        this.aDJ.setVisibility(8);
        this.aDx.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.aDQ = onClickListener;
    }

    public void g(View.OnClickListener onClickListener) {
        this.aDR = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ad(i == 1);
            tbPageContext.getLayoutMode().k(findViewById(i.f.app_download_dialog_layout));
        }
    }
}
