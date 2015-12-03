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
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.ah;
/* loaded from: classes.dex */
public class o extends Dialog {
    private TextView aFA;
    private TextView aFB;
    private TextView aFC;
    private String aFD;
    private TextView aFE;
    private TextView aFF;
    private TextView aFG;
    private View aFH;
    private TextView aFI;
    private TextView aFJ;
    private View aFK;
    private LinearLayout aFL;
    private TextView aFM;
    private TextView aFN;
    private TextView aFO;
    private View aFP;
    private LinearLayout aFQ;
    private a aFR;
    private View.OnClickListener aFS;
    private View.OnClickListener aFT;
    private boolean aFU;
    private boolean aFV;
    private VersionData aFt;
    private CombineDownload aFu;
    private boolean aFv;
    private boolean aFw;
    private boolean aFx;
    private boolean aFy;
    private LinearLayout aFz;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void GM();

        void GN();

        void bH(boolean z);

        void bI(boolean z);

        void stopService();
    }

    public o(Context context, int i) {
        super(context, i);
        this.aFv = false;
        this.aFw = true;
        this.aFx = false;
        this.aFy = false;
        this.aFU = true;
        this.aFV = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.g.app_download_dialog);
        this.aFz = (LinearLayout) findViewById(n.f.app_info);
        this.aFA = (TextView) findViewById(n.f.app_version_and_size);
        this.aFB = (TextView) findViewById(n.f.app_description);
        this.aFG = (TextView) findViewById(n.f.fullsize_download_button);
        this.aFF = (TextView) findViewById(n.f.cancel_download_button);
        this.aFH = findViewById(n.f.divider_line);
        this.aFC = (TextView) findViewById(n.f.download_process);
        this.aFI = (TextView) findViewById(n.f.incremental_download_button);
        this.aFJ = (TextView) findViewById(n.f.not_install_as_tip);
        this.aFK = findViewById(n.f.incremental_download_layout);
        this.aFE = (TextView) findViewById(n.f.other_app_recommend);
        this.aFP = findViewById(n.f.divider_under_button);
        this.aFQ = (LinearLayout) findViewById(n.f.cancel_confirm_ll);
        this.aFD = this.aFC.getText().toString();
        this.aFL = (LinearLayout) findViewById(n.f.cancel_dialog);
        this.aFN = (TextView) findViewById(n.f.sure_cancel);
        this.aFO = (TextView) findViewById(n.f.cancel_button);
        this.aFM = (TextView) findViewById(n.f.cancel_tip);
        this.aFN.setOnClickListener(this.aFS);
        this.aFO.setOnClickListener(this.aFT);
        if (com.baidu.adp.lib.c.e.gw().aj("android_shouzhu_update") == 1) {
            this.aFU = true;
        } else {
            this.aFU = false;
        }
        String size = this.aFt.getSize();
        String newVersion = this.aFt.getNewVersion();
        String newVersionDesc = this.aFt.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(n.i.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.h.b.a(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aFA.setText(sb.toString());
        this.aFB.setText(newVersionDesc);
        if (this.aFt.forceUpdate()) {
            this.aFy = true;
            this.aFF.setText(this.mContext.getString(n.i.quit));
        } else {
            this.aFF.setText(this.mContext.getString(n.i.update_after));
        }
        if (this.aFu != null && this.aFu.showCombineDownload()) {
            this.aFE.setText(this.aFu.getAppName());
            if (!ah.isInstalledPackage(this.mContext, this.aFu.getAppProc()) && !TextUtils.isEmpty(this.aFu.getAppUrl())) {
                this.aFE.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(n.e.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aFE.setCompoundDrawables(drawable, null, null, null);
                this.aFv = true;
            } else {
                this.aFE.setVisibility(8);
                this.aFv = false;
            }
        } else {
            this.aFE.setVisibility(8);
            this.aFv = false;
        }
        bG(this.aFU);
        this.aFG.setOnClickListener(new p(this));
        this.aFI.setOnClickListener(new q(this));
        this.aFF.setOnClickListener(new r(this));
        this.aFE.setOnClickListener(new s(this));
        GK();
    }

    private void GK() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void bG(boolean z) {
        if (y.a(this.mContext.getPackageManager())) {
            this.aFJ.setVisibility(8);
        } else {
            this.aFJ.setVisibility(0);
        }
        if (z) {
            if (this.aFt == null || TextUtils.isEmpty(this.aFt.getPatch()) || this.aFt.getNewVersionCode() < 0) {
                this.aFK.setVisibility(0);
                this.aFI.setText(n.i.super_update);
                as.i((View) this.aFI, n.e.dialog_middle_item_bg_selector);
                this.aFQ.setVisibility(0);
                this.aFV = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.aFK.setVisibility(0);
            this.aFI.setText(n.i.incremental_update);
            as.i((View) this.aFI, n.e.dialog_single_button_bg_selector);
            this.aFP.setVisibility(8);
            this.aFQ.setVisibility(8);
            this.aFV = true;
            TiebaStatic.log("c10002");
        } else if (this.aFt == null || TextUtils.isEmpty(this.aFt.getPatch()) || this.aFt.getNewVersionCode() < 0) {
            this.aFK.setVisibility(8);
            this.aFQ.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.aFK.setVisibility(0);
            as.i((View) this.aFI, n.e.dialog_middle_item_bg_selector);
            this.aFI.setText(n.i.incremental_update);
            this.aFQ.setVisibility(0);
            this.aFV = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void fc(int i) {
        this.aFG.setVisibility(8);
        this.aFK.setVisibility(8);
        this.aFF.setVisibility(8);
        this.aFH.setVisibility(8);
        this.aFx = true;
        this.aFQ.setVisibility(0);
        this.aFC.setVisibility(0);
        this.aFC.setText(String.valueOf(this.aFD) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aFx) {
            this.aFR.stopService();
            this.aFz.setVisibility(8);
            if (this.aFy) {
                this.aFM.setText(getContext().getString(n.i.download_exit));
            }
            this.aFL.setVisibility(0);
            return;
        }
        this.aFR.GN();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aFt = versionData;
        this.aFu = combineDownload;
        this.aFR = aVar;
    }

    public void GL() {
        this.aFL.setVisibility(8);
        this.aFz.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.aFS = onClickListener;
    }

    public void g(View.OnClickListener onClickListener) {
        this.aFT = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().af(i == 1);
            tbPageContext.getLayoutMode().k(findViewById(n.f.app_download_dialog_layout));
        }
    }
}
