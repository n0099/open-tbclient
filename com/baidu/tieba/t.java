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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class t extends Dialog {
    private boolean aNA;
    private boolean aNB;
    private LinearLayout aNC;
    private TextView aND;
    private TextView aNE;
    private TextView aNF;
    private String aNG;
    private TextView aNH;
    private TextView aNI;
    private TextView aNJ;
    private View aNK;
    private TextView aNL;
    private TextView aNM;
    private View aNN;
    private LinearLayout aNO;
    private TextView aNP;
    private TextView aNQ;
    private TextView aNR;
    private View aNS;
    private LinearLayout aNT;
    private a aNU;
    private View.OnClickListener aNV;
    private View.OnClickListener aNW;
    private boolean aNX;
    private boolean aNY;
    private VersionData aNw;
    private CombineDownload aNx;
    private boolean aNy;
    private boolean aNz;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void Ki();

        void Kj();

        void cj(boolean z);

        void ck(boolean z);

        void stopService();
    }

    public t(Context context, int i) {
        super(context, i);
        this.aNy = false;
        this.aNz = true;
        this.aNA = false;
        this.aNB = false;
        this.aNX = true;
        this.aNY = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.j.app_download_dialog);
        this.aNC = (LinearLayout) findViewById(r.h.app_info);
        this.aND = (TextView) findViewById(r.h.app_version_and_size);
        this.aNE = (TextView) findViewById(r.h.app_description);
        this.aNJ = (TextView) findViewById(r.h.fullsize_download_button);
        this.aNI = (TextView) findViewById(r.h.cancel_download_button);
        this.aNK = findViewById(r.h.divider_line);
        this.aNF = (TextView) findViewById(r.h.download_process);
        this.aNL = (TextView) findViewById(r.h.incremental_download_button);
        this.aNM = (TextView) findViewById(r.h.not_install_as_tip);
        this.aNN = findViewById(r.h.incremental_download_layout);
        this.aNH = (TextView) findViewById(r.h.other_app_recommend);
        this.aNS = findViewById(r.h.divider_under_button);
        this.aNT = (LinearLayout) findViewById(r.h.cancel_confirm_ll);
        this.aNG = this.aNF.getText().toString();
        this.aNO = (LinearLayout) findViewById(r.h.cancel_dialog);
        this.aNQ = (TextView) findViewById(r.h.sure_cancel);
        this.aNR = (TextView) findViewById(r.h.cancel_button);
        this.aNP = (TextView) findViewById(r.h.cancel_tip);
        this.aNQ.setOnClickListener(this.aNV);
        this.aNR.setOnClickListener(this.aNW);
        if (com.baidu.adp.lib.b.e.dL().ac("android_shouzhu_update") == 1) {
            this.aNX = true;
        } else {
            this.aNX = false;
        }
        String size = this.aNw.getSize();
        String newVersion = this.aNw.getNewVersion();
        String newVersionDesc = this.aNw.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(r.l.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.b(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aND.setText(sb.toString());
        this.aNE.setText(newVersionDesc);
        if (this.aNw.forceUpdate()) {
            this.aNB = true;
            this.aNI.setText(this.mContext.getString(r.l.quit));
        } else {
            this.aNI.setText(this.mContext.getString(r.l.update_after));
        }
        if (this.aNx != null && this.aNx.showCombineDownload() && !TextUtils.isEmpty(this.aNx.getApkMD5RSA())) {
            this.aNH.setText(this.aNx.getAppName());
            if (!com.baidu.tieba.tbadkCore.af.isInstalledPackage(this.mContext, this.aNx.getAppProc()) && !TextUtils.isEmpty(this.aNx.getAppUrl())) {
                this.aNH.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(r.g.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aNH.setCompoundDrawables(drawable, null, null, null);
                this.aNy = true;
            } else {
                this.aNH.setVisibility(8);
                this.aNy = false;
            }
        } else {
            this.aNH.setVisibility(8);
            this.aNy = false;
        }
        ci(this.aNX);
        this.aNJ.setOnClickListener(new u(this));
        this.aNL.setOnClickListener(new v(this));
        this.aNI.setOnClickListener(new w(this));
        this.aNH.setOnClickListener(new x(this));
        Kg();
    }

    private void Kg() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void ci(boolean z) {
        if (af.b(this.mContext.getPackageManager())) {
            this.aNM.setVisibility(8);
        } else {
            this.aNM.setVisibility(0);
        }
        if (z) {
            if (this.aNw == null || TextUtils.isEmpty(this.aNw.getPatch()) || this.aNw.getNewVersionCode() < 0) {
                this.aNN.setVisibility(0);
                this.aNL.setText(r.l.super_update);
                ap.j((View) this.aNL, r.g.dialog_middle_item_bg_selector);
                this.aNT.setVisibility(0);
                this.aNY = false;
                com.baidu.tbadk.core.util.TiebaStatic.log("c10008");
                com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
                return;
            }
            this.aNN.setVisibility(0);
            this.aNL.setText(r.l.incremental_update);
            ap.j((View) this.aNL, r.g.dialog_single_button_bg_selector);
            this.aNS.setVisibility(8);
            this.aNT.setVisibility(8);
            this.aNY = true;
            com.baidu.tbadk.core.util.TiebaStatic.log("c10002");
        } else if (this.aNw == null || TextUtils.isEmpty(this.aNw.getPatch()) || this.aNw.getNewVersionCode() < 0) {
            this.aNN.setVisibility(8);
            this.aNT.setVisibility(0);
            com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
        } else {
            this.aNN.setVisibility(0);
            ap.j((View) this.aNL, r.g.dialog_middle_item_bg_selector);
            this.aNL.setText(r.l.incremental_update);
            this.aNT.setVisibility(0);
            this.aNY = true;
            com.baidu.tbadk.core.util.TiebaStatic.log("c10002");
            com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
        }
    }

    public void fM(int i) {
        this.aNJ.setVisibility(8);
        this.aNN.setVisibility(8);
        this.aNI.setVisibility(8);
        this.aNK.setVisibility(8);
        this.aNA = true;
        this.aNT.setVisibility(0);
        this.aNF.setVisibility(0);
        this.aNF.setText(String.valueOf(this.aNG) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aNA) {
            this.aNU.stopService();
            this.aNC.setVisibility(8);
            if (this.aNB) {
                this.aNP.setText(getContext().getString(r.l.download_exit));
            }
            this.aNO.setVisibility(0);
            return;
        }
        this.aNU.Kj();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aNw = versionData;
        this.aNx = combineDownload;
        this.aNU = aVar;
    }

    public void Kh() {
        this.aNO.setVisibility(8);
        this.aNC.setVisibility(0);
    }

    public void j(View.OnClickListener onClickListener) {
        this.aNV = onClickListener;
    }

    public void k(View.OnClickListener onClickListener) {
        this.aNW = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ai(i == 1);
            tbPageContext.getLayoutMode().v(findViewById(r.h.app_download_dialog_layout));
        }
    }
}
