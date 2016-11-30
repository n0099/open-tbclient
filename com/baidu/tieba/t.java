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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.aj;
/* loaded from: classes.dex */
public class t extends Dialog {
    private a aPA;
    private View.OnClickListener aPB;
    private View.OnClickListener aPC;
    private boolean aPD;
    private boolean aPE;
    private VersionData aPc;
    private CombineDownload aPd;
    private boolean aPe;
    private boolean aPf;
    private boolean aPg;
    private boolean aPh;
    private LinearLayout aPi;
    private TextView aPj;
    private TextView aPk;
    private TextView aPl;
    private String aPm;
    private TextView aPn;
    private TextView aPo;
    private TextView aPp;
    private View aPq;
    private TextView aPr;
    private TextView aPs;
    private View aPt;
    private LinearLayout aPu;
    private TextView aPv;
    private TextView aPw;
    private TextView aPx;
    private View aPy;
    private LinearLayout aPz;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void KA();

        void KB();

        void cg(boolean z);

        void ch(boolean z);

        void stopService();
    }

    public t(Context context, int i) {
        super(context, i);
        this.aPe = false;
        this.aPf = true;
        this.aPg = false;
        this.aPh = false;
        this.aPD = true;
        this.aPE = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.h.app_download_dialog);
        this.aPi = (LinearLayout) findViewById(r.g.app_info);
        this.aPj = (TextView) findViewById(r.g.app_version_and_size);
        this.aPk = (TextView) findViewById(r.g.app_description);
        this.aPp = (TextView) findViewById(r.g.fullsize_download_button);
        this.aPo = (TextView) findViewById(r.g.cancel_download_button);
        this.aPq = findViewById(r.g.divider_line);
        this.aPl = (TextView) findViewById(r.g.download_process);
        this.aPr = (TextView) findViewById(r.g.incremental_download_button);
        this.aPs = (TextView) findViewById(r.g.not_install_as_tip);
        this.aPt = findViewById(r.g.incremental_download_layout);
        this.aPn = (TextView) findViewById(r.g.other_app_recommend);
        this.aPy = findViewById(r.g.divider_under_button);
        this.aPz = (LinearLayout) findViewById(r.g.cancel_confirm_ll);
        this.aPm = this.aPl.getText().toString();
        this.aPu = (LinearLayout) findViewById(r.g.cancel_dialog);
        this.aPw = (TextView) findViewById(r.g.sure_cancel);
        this.aPx = (TextView) findViewById(r.g.cancel_button);
        this.aPv = (TextView) findViewById(r.g.cancel_tip);
        this.aPw.setOnClickListener(this.aPB);
        this.aPx.setOnClickListener(this.aPC);
        if (com.baidu.adp.lib.c.e.dN().ac("android_shouzhu_update") == 1) {
            this.aPD = true;
        } else {
            this.aPD = false;
        }
        String size = this.aPc.getSize();
        String newVersion = this.aPc.getNewVersion();
        String newVersionDesc = this.aPc.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(r.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.h.b.b(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aPj.setText(sb.toString());
        this.aPk.setText(newVersionDesc);
        if (this.aPc.forceUpdate()) {
            this.aPh = true;
            this.aPo.setText(this.mContext.getString(r.j.quit));
        } else {
            this.aPo.setText(this.mContext.getString(r.j.update_after));
        }
        if (this.aPd != null && this.aPd.showCombineDownload() && !TextUtils.isEmpty(this.aPd.getApkMD5RSA())) {
            this.aPn.setText(this.aPd.getAppName());
            if (!aj.isInstalledPackage(this.mContext, this.aPd.getAppProc()) && !TextUtils.isEmpty(this.aPd.getAppUrl())) {
                this.aPn.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(r.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aPn.setCompoundDrawables(drawable, null, null, null);
                this.aPe = true;
            } else {
                this.aPn.setVisibility(8);
                this.aPe = false;
            }
        } else {
            this.aPn.setVisibility(8);
            this.aPe = false;
        }
        cf(this.aPD);
        this.aPp.setOnClickListener(new u(this));
        this.aPr.setOnClickListener(new v(this));
        this.aPo.setOnClickListener(new w(this));
        this.aPn.setOnClickListener(new x(this));
        Ky();
    }

    private void Ky() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void cf(boolean z) {
        if (af.b(this.mContext.getPackageManager())) {
            this.aPs.setVisibility(8);
        } else {
            this.aPs.setVisibility(0);
        }
        if (z) {
            if (this.aPc == null || TextUtils.isEmpty(this.aPc.getPatch()) || this.aPc.getNewVersionCode() < 0) {
                this.aPt.setVisibility(0);
                this.aPr.setText(r.j.super_update);
                at.k(this.aPr, r.f.dialog_middle_item_bg_selector);
                this.aPz.setVisibility(0);
                this.aPE = false;
                com.baidu.tbadk.core.util.TiebaStatic.log("c10008");
                com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
                return;
            }
            this.aPt.setVisibility(0);
            this.aPr.setText(r.j.incremental_update);
            at.k(this.aPr, r.f.dialog_single_button_bg_selector);
            this.aPy.setVisibility(8);
            this.aPz.setVisibility(8);
            this.aPE = true;
            com.baidu.tbadk.core.util.TiebaStatic.log("c10002");
        } else if (this.aPc == null || TextUtils.isEmpty(this.aPc.getPatch()) || this.aPc.getNewVersionCode() < 0) {
            this.aPt.setVisibility(8);
            this.aPz.setVisibility(0);
            com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
        } else {
            this.aPt.setVisibility(0);
            at.k(this.aPr, r.f.dialog_middle_item_bg_selector);
            this.aPr.setText(r.j.incremental_update);
            this.aPz.setVisibility(0);
            this.aPE = true;
            com.baidu.tbadk.core.util.TiebaStatic.log("c10002");
            com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
        }
    }

    public void fJ(int i) {
        this.aPp.setVisibility(8);
        this.aPt.setVisibility(8);
        this.aPo.setVisibility(8);
        this.aPq.setVisibility(8);
        this.aPg = true;
        this.aPz.setVisibility(0);
        this.aPl.setVisibility(0);
        this.aPl.setText(String.valueOf(this.aPm) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aPg) {
            this.aPA.stopService();
            this.aPi.setVisibility(8);
            if (this.aPh) {
                this.aPv.setText(getContext().getString(r.j.download_exit));
            }
            this.aPu.setVisibility(0);
            return;
        }
        this.aPA.KB();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aPc = versionData;
        this.aPd = combineDownload;
        this.aPA = aVar;
    }

    public void Kz() {
        this.aPu.setVisibility(8);
        this.aPi.setVisibility(0);
    }

    public void k(View.OnClickListener onClickListener) {
        this.aPB = onClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.aPC = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ai(i == 1);
            tbPageContext.getLayoutMode().x(findViewById(r.g.app_download_dialog_layout));
        }
    }
}
