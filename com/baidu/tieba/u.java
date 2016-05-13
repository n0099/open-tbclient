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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.ah;
/* loaded from: classes.dex */
public class u extends Dialog {
    private a aHA;
    private View.OnClickListener aHB;
    private View.OnClickListener aHC;
    private boolean aHD;
    private boolean aHE;
    private VersionData aHc;
    private CombineDownload aHd;
    private boolean aHe;
    private boolean aHf;
    private boolean aHg;
    private boolean aHh;
    private LinearLayout aHi;
    private TextView aHj;
    private TextView aHk;
    private TextView aHl;
    private String aHm;
    private TextView aHn;
    private TextView aHo;
    private TextView aHp;
    private View aHq;
    private TextView aHr;
    private TextView aHs;
    private View aHt;
    private LinearLayout aHu;
    private TextView aHv;
    private TextView aHw;
    private TextView aHx;
    private View aHy;
    private LinearLayout aHz;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void HR();

        void HS();

        void bX(boolean z);

        void bY(boolean z);

        void stopService();
    }

    public u(Context context, int i) {
        super(context, i);
        this.aHe = false;
        this.aHf = true;
        this.aHg = false;
        this.aHh = false;
        this.aHD = true;
        this.aHE = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.app_download_dialog);
        this.aHi = (LinearLayout) findViewById(t.g.app_info);
        this.aHj = (TextView) findViewById(t.g.app_version_and_size);
        this.aHk = (TextView) findViewById(t.g.app_description);
        this.aHp = (TextView) findViewById(t.g.fullsize_download_button);
        this.aHo = (TextView) findViewById(t.g.cancel_download_button);
        this.aHq = findViewById(t.g.divider_line);
        this.aHl = (TextView) findViewById(t.g.download_process);
        this.aHr = (TextView) findViewById(t.g.incremental_download_button);
        this.aHs = (TextView) findViewById(t.g.not_install_as_tip);
        this.aHt = findViewById(t.g.incremental_download_layout);
        this.aHn = (TextView) findViewById(t.g.other_app_recommend);
        this.aHy = findViewById(t.g.divider_under_button);
        this.aHz = (LinearLayout) findViewById(t.g.cancel_confirm_ll);
        this.aHm = this.aHl.getText().toString();
        this.aHu = (LinearLayout) findViewById(t.g.cancel_dialog);
        this.aHw = (TextView) findViewById(t.g.sure_cancel);
        this.aHx = (TextView) findViewById(t.g.cancel_button);
        this.aHv = (TextView) findViewById(t.g.cancel_tip);
        this.aHw.setOnClickListener(this.aHB);
        this.aHx.setOnClickListener(this.aHC);
        if (com.baidu.adp.lib.c.e.cS().Z("android_shouzhu_update") == 1) {
            this.aHD = true;
        } else {
            this.aHD = false;
        }
        String size = this.aHc.getSize();
        String newVersion = this.aHc.getNewVersion();
        String newVersionDesc = this.aHc.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(t.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.h.b.a(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aHj.setText(sb.toString());
        this.aHk.setText(newVersionDesc);
        if (this.aHc.forceUpdate()) {
            this.aHh = true;
            this.aHo.setText(this.mContext.getString(t.j.quit));
        } else {
            this.aHo.setText(this.mContext.getString(t.j.update_after));
        }
        if (this.aHd != null && this.aHd.showCombineDownload() && !TextUtils.isEmpty(this.aHd.getApkMD5RSA())) {
            this.aHn.setText(this.aHd.getAppName());
            if (!ah.isInstalledPackage(this.mContext, this.aHd.getAppProc()) && !TextUtils.isEmpty(this.aHd.getAppUrl())) {
                this.aHn.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(t.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aHn.setCompoundDrawables(drawable, null, null, null);
                this.aHe = true;
            } else {
                this.aHn.setVisibility(8);
                this.aHe = false;
            }
        } else {
            this.aHn.setVisibility(8);
            this.aHe = false;
        }
        bW(this.aHD);
        this.aHp.setOnClickListener(new v(this));
        this.aHr.setOnClickListener(new w(this));
        this.aHo.setOnClickListener(new x(this));
        this.aHn.setOnClickListener(new y(this));
        HP();
    }

    private void HP() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void bW(boolean z) {
        if (ag.a(this.mContext.getPackageManager())) {
            this.aHs.setVisibility(8);
        } else {
            this.aHs.setVisibility(0);
        }
        if (z) {
            if (this.aHc == null || TextUtils.isEmpty(this.aHc.getPatch()) || this.aHc.getNewVersionCode() < 0) {
                this.aHt.setVisibility(0);
                this.aHr.setText(t.j.super_update);
                at.k(this.aHr, t.f.dialog_middle_item_bg_selector);
                this.aHz.setVisibility(0);
                this.aHE = false;
                com.baidu.tbadk.core.util.TiebaStatic.log("c10008");
                com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
                return;
            }
            this.aHt.setVisibility(0);
            this.aHr.setText(t.j.incremental_update);
            at.k(this.aHr, t.f.dialog_single_button_bg_selector);
            this.aHy.setVisibility(8);
            this.aHz.setVisibility(8);
            this.aHE = true;
            com.baidu.tbadk.core.util.TiebaStatic.log("c10002");
        } else if (this.aHc == null || TextUtils.isEmpty(this.aHc.getPatch()) || this.aHc.getNewVersionCode() < 0) {
            this.aHt.setVisibility(8);
            this.aHz.setVisibility(0);
            com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
        } else {
            this.aHt.setVisibility(0);
            at.k(this.aHr, t.f.dialog_middle_item_bg_selector);
            this.aHr.setText(t.j.incremental_update);
            this.aHz.setVisibility(0);
            this.aHE = true;
            com.baidu.tbadk.core.util.TiebaStatic.log("c10002");
            com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
        }
    }

    public void fk(int i) {
        this.aHp.setVisibility(8);
        this.aHt.setVisibility(8);
        this.aHo.setVisibility(8);
        this.aHq.setVisibility(8);
        this.aHg = true;
        this.aHz.setVisibility(0);
        this.aHl.setVisibility(0);
        this.aHl.setText(String.valueOf(this.aHm) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aHg) {
            this.aHA.stopService();
            this.aHi.setVisibility(8);
            if (this.aHh) {
                this.aHv.setText(getContext().getString(t.j.download_exit));
            }
            this.aHu.setVisibility(0);
            return;
        }
        this.aHA.HS();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aHc = versionData;
        this.aHd = combineDownload;
        this.aHA = aVar;
    }

    public void HQ() {
        this.aHu.setVisibility(8);
        this.aHi.setVisibility(0);
    }

    public void j(View.OnClickListener onClickListener) {
        this.aHB = onClickListener;
    }

    public void k(View.OnClickListener onClickListener) {
        this.aHC = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ae(i == 1);
            tbPageContext.getLayoutMode().x(findViewById(t.g.app_download_dialog_layout));
        }
    }
}
