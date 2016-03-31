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
/* loaded from: classes.dex */
public class u extends Dialog {
    private VersionData aKR;
    private CombineDownload aKS;
    private boolean aKT;
    private boolean aKU;
    private boolean aKV;
    private boolean aKW;
    private LinearLayout aKX;
    private TextView aKY;
    private TextView aKZ;
    private TextView aLa;
    private String aLb;
    private TextView aLc;
    private TextView aLd;
    private TextView aLe;
    private View aLf;
    private TextView aLg;
    private TextView aLh;
    private View aLi;
    private LinearLayout aLj;
    private TextView aLk;
    private TextView aLl;
    private TextView aLm;
    private View aLn;
    private LinearLayout aLo;
    private a aLp;
    private View.OnClickListener aLq;
    private View.OnClickListener aLr;
    private boolean aLs;
    private boolean aLt;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void Jy();

        void Jz();

        void bR(boolean z);

        void bS(boolean z);

        void stopService();
    }

    public u(Context context, int i) {
        super(context, i);
        this.aKT = false;
        this.aKU = true;
        this.aKV = false;
        this.aKW = false;
        this.aLs = true;
        this.aLt = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.app_download_dialog);
        this.aKX = (LinearLayout) findViewById(t.g.app_info);
        this.aKY = (TextView) findViewById(t.g.app_version_and_size);
        this.aKZ = (TextView) findViewById(t.g.app_description);
        this.aLe = (TextView) findViewById(t.g.fullsize_download_button);
        this.aLd = (TextView) findViewById(t.g.cancel_download_button);
        this.aLf = findViewById(t.g.divider_line);
        this.aLa = (TextView) findViewById(t.g.download_process);
        this.aLg = (TextView) findViewById(t.g.incremental_download_button);
        this.aLh = (TextView) findViewById(t.g.not_install_as_tip);
        this.aLi = findViewById(t.g.incremental_download_layout);
        this.aLc = (TextView) findViewById(t.g.other_app_recommend);
        this.aLn = findViewById(t.g.divider_under_button);
        this.aLo = (LinearLayout) findViewById(t.g.cancel_confirm_ll);
        this.aLb = this.aLa.getText().toString();
        this.aLj = (LinearLayout) findViewById(t.g.cancel_dialog);
        this.aLl = (TextView) findViewById(t.g.sure_cancel);
        this.aLm = (TextView) findViewById(t.g.cancel_button);
        this.aLk = (TextView) findViewById(t.g.cancel_tip);
        this.aLl.setOnClickListener(this.aLq);
        this.aLm.setOnClickListener(this.aLr);
        if (com.baidu.adp.lib.c.e.gE().ai("android_shouzhu_update") == 1) {
            this.aLs = true;
        } else {
            this.aLs = false;
        }
        String size = this.aKR.getSize();
        String newVersion = this.aKR.getNewVersion();
        String newVersionDesc = this.aKR.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(t.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.h.b.a(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aKY.setText(sb.toString());
        this.aKZ.setText(newVersionDesc);
        if (this.aKR.forceUpdate()) {
            this.aKW = true;
            this.aLd.setText(this.mContext.getString(t.j.quit));
        } else {
            this.aLd.setText(this.mContext.getString(t.j.update_after));
        }
        if (this.aKS != null && this.aKS.showCombineDownload() && !TextUtils.isEmpty(this.aKS.getApkMD5RSA())) {
            this.aLc.setText(this.aKS.getAppName());
            if (!com.baidu.tieba.tbadkCore.ag.isInstalledPackage(this.mContext, this.aKS.getAppProc()) && !TextUtils.isEmpty(this.aKS.getAppUrl())) {
                this.aLc.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(t.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aLc.setCompoundDrawables(drawable, null, null, null);
                this.aKT = true;
            } else {
                this.aLc.setVisibility(8);
                this.aKT = false;
            }
        } else {
            this.aLc.setVisibility(8);
            this.aKT = false;
        }
        bQ(this.aLs);
        this.aLe.setOnClickListener(new v(this));
        this.aLg.setOnClickListener(new w(this));
        this.aLd.setOnClickListener(new x(this));
        this.aLc.setOnClickListener(new y(this));
        Jw();
    }

    private void Jw() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void bQ(boolean z) {
        if (ag.a(this.mContext.getPackageManager())) {
            this.aLh.setVisibility(8);
        } else {
            this.aLh.setVisibility(0);
        }
        if (z) {
            if (this.aKR == null || TextUtils.isEmpty(this.aKR.getPatch()) || this.aKR.getNewVersionCode() < 0) {
                this.aLi.setVisibility(0);
                this.aLg.setText(t.j.super_update);
                at.k(this.aLg, t.f.dialog_middle_item_bg_selector);
                this.aLo.setVisibility(0);
                this.aLt = false;
                com.baidu.tbadk.core.util.TiebaStatic.log("c10008");
                com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
                return;
            }
            this.aLi.setVisibility(0);
            this.aLg.setText(t.j.incremental_update);
            at.k(this.aLg, t.f.dialog_single_button_bg_selector);
            this.aLn.setVisibility(8);
            this.aLo.setVisibility(8);
            this.aLt = true;
            com.baidu.tbadk.core.util.TiebaStatic.log("c10002");
        } else if (this.aKR == null || TextUtils.isEmpty(this.aKR.getPatch()) || this.aKR.getNewVersionCode() < 0) {
            this.aLi.setVisibility(8);
            this.aLo.setVisibility(0);
            com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
        } else {
            this.aLi.setVisibility(0);
            at.k(this.aLg, t.f.dialog_middle_item_bg_selector);
            this.aLg.setText(t.j.incremental_update);
            this.aLo.setVisibility(0);
            this.aLt = true;
            com.baidu.tbadk.core.util.TiebaStatic.log("c10002");
            com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
        }
    }

    public void fF(int i) {
        this.aLe.setVisibility(8);
        this.aLi.setVisibility(8);
        this.aLd.setVisibility(8);
        this.aLf.setVisibility(8);
        this.aKV = true;
        this.aLo.setVisibility(0);
        this.aLa.setVisibility(0);
        this.aLa.setText(String.valueOf(this.aLb) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aKV) {
            this.aLp.stopService();
            this.aKX.setVisibility(8);
            if (this.aKW) {
                this.aLk.setText(getContext().getString(t.j.download_exit));
            }
            this.aLj.setVisibility(0);
            return;
        }
        this.aLp.Jz();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aKR = versionData;
        this.aKS = combineDownload;
        this.aLp = aVar;
    }

    public void Jx() {
        this.aLj.setVisibility(8);
        this.aKX.setVisibility(0);
    }

    public void j(View.OnClickListener onClickListener) {
        this.aLq = onClickListener;
    }

    public void k(View.OnClickListener onClickListener) {
        this.aLr = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ab(i == 1);
            tbPageContext.getLayoutMode().x(findViewById(t.g.app_download_dialog_layout));
        }
    }
}
