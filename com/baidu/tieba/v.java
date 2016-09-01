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
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.ak;
/* loaded from: classes.dex */
public class v extends Dialog {
    private VersionData aLM;
    private CombineDownload aLN;
    private boolean aLO;
    private boolean aLP;
    private boolean aLQ;
    private boolean aLR;
    private LinearLayout aLS;
    private TextView aLT;
    private TextView aLU;
    private TextView aLV;
    private String aLW;
    private TextView aLX;
    private TextView aLY;
    private TextView aLZ;
    private View aMa;
    private TextView aMb;
    private TextView aMc;
    private View aMd;
    private LinearLayout aMe;
    private TextView aMf;
    private TextView aMg;
    private TextView aMh;
    private View aMi;
    private LinearLayout aMj;
    private a aMk;
    private View.OnClickListener aMl;
    private View.OnClickListener aMm;
    private boolean aMn;
    private boolean aMo;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void Jk();

        void Jl();

        void cb(boolean z);

        void cc(boolean z);

        void stopService();
    }

    public v(Context context, int i) {
        super(context, i);
        this.aLO = false;
        this.aLP = true;
        this.aLQ = false;
        this.aLR = false;
        this.aMn = true;
        this.aMo = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.app_download_dialog);
        this.aLS = (LinearLayout) findViewById(t.g.app_info);
        this.aLT = (TextView) findViewById(t.g.app_version_and_size);
        this.aLU = (TextView) findViewById(t.g.app_description);
        this.aLZ = (TextView) findViewById(t.g.fullsize_download_button);
        this.aLY = (TextView) findViewById(t.g.cancel_download_button);
        this.aMa = findViewById(t.g.divider_line);
        this.aLV = (TextView) findViewById(t.g.download_process);
        this.aMb = (TextView) findViewById(t.g.incremental_download_button);
        this.aMc = (TextView) findViewById(t.g.not_install_as_tip);
        this.aMd = findViewById(t.g.incremental_download_layout);
        this.aLX = (TextView) findViewById(t.g.other_app_recommend);
        this.aMi = findViewById(t.g.divider_under_button);
        this.aMj = (LinearLayout) findViewById(t.g.cancel_confirm_ll);
        this.aLW = this.aLV.getText().toString();
        this.aMe = (LinearLayout) findViewById(t.g.cancel_dialog);
        this.aMg = (TextView) findViewById(t.g.sure_cancel);
        this.aMh = (TextView) findViewById(t.g.cancel_button);
        this.aMf = (TextView) findViewById(t.g.cancel_tip);
        this.aMg.setOnClickListener(this.aMl);
        this.aMh.setOnClickListener(this.aMm);
        if (com.baidu.adp.lib.c.e.dN().ac("android_shouzhu_update") == 1) {
            this.aMn = true;
        } else {
            this.aMn = false;
        }
        String size = this.aLM.getSize();
        String newVersion = this.aLM.getNewVersion();
        String newVersionDesc = this.aLM.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(t.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.h.b.b(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aLT.setText(sb.toString());
        this.aLU.setText(newVersionDesc);
        if (this.aLM.forceUpdate()) {
            this.aLR = true;
            this.aLY.setText(this.mContext.getString(t.j.quit));
        } else {
            this.aLY.setText(this.mContext.getString(t.j.update_after));
        }
        if (this.aLN != null && this.aLN.showCombineDownload() && !TextUtils.isEmpty(this.aLN.getApkMD5RSA())) {
            this.aLX.setText(this.aLN.getAppName());
            if (!ak.isInstalledPackage(this.mContext, this.aLN.getAppProc()) && !TextUtils.isEmpty(this.aLN.getAppUrl())) {
                this.aLX.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(t.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aLX.setCompoundDrawables(drawable, null, null, null);
                this.aLO = true;
            } else {
                this.aLX.setVisibility(8);
                this.aLO = false;
            }
        } else {
            this.aLX.setVisibility(8);
            this.aLO = false;
        }
        ca(this.aMn);
        this.aLZ.setOnClickListener(new w(this));
        this.aMb.setOnClickListener(new x(this));
        this.aLY.setOnClickListener(new y(this));
        this.aLX.setOnClickListener(new z(this));
        Ji();
    }

    private void Ji() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void ca(boolean z) {
        if (ah.b(this.mContext.getPackageManager())) {
            this.aMc.setVisibility(8);
        } else {
            this.aMc.setVisibility(0);
        }
        if (z) {
            if (this.aLM == null || TextUtils.isEmpty(this.aLM.getPatch()) || this.aLM.getNewVersionCode() < 0) {
                this.aMd.setVisibility(0);
                this.aMb.setText(t.j.super_update);
                av.k(this.aMb, t.f.dialog_middle_item_bg_selector);
                this.aMj.setVisibility(0);
                this.aMo = false;
                com.baidu.tbadk.core.util.TiebaStatic.log("c10008");
                com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
                return;
            }
            this.aMd.setVisibility(0);
            this.aMb.setText(t.j.incremental_update);
            av.k(this.aMb, t.f.dialog_single_button_bg_selector);
            this.aMi.setVisibility(8);
            this.aMj.setVisibility(8);
            this.aMo = true;
            com.baidu.tbadk.core.util.TiebaStatic.log("c10002");
        } else if (this.aLM == null || TextUtils.isEmpty(this.aLM.getPatch()) || this.aLM.getNewVersionCode() < 0) {
            this.aMd.setVisibility(8);
            this.aMj.setVisibility(0);
            com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
        } else {
            this.aMd.setVisibility(0);
            av.k(this.aMb, t.f.dialog_middle_item_bg_selector);
            this.aMb.setText(t.j.incremental_update);
            this.aMj.setVisibility(0);
            this.aMo = true;
            com.baidu.tbadk.core.util.TiebaStatic.log("c10002");
            com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
        }
    }

    public void fF(int i) {
        this.aLZ.setVisibility(8);
        this.aMd.setVisibility(8);
        this.aLY.setVisibility(8);
        this.aMa.setVisibility(8);
        this.aLQ = true;
        this.aMj.setVisibility(0);
        this.aLV.setVisibility(0);
        this.aLV.setText(String.valueOf(this.aLW) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aLQ) {
            this.aMk.stopService();
            this.aLS.setVisibility(8);
            if (this.aLR) {
                this.aMf.setText(getContext().getString(t.j.download_exit));
            }
            this.aMe.setVisibility(0);
            return;
        }
        this.aMk.Jl();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aLM = versionData;
        this.aLN = combineDownload;
        this.aMk = aVar;
    }

    public void Jj() {
        this.aMe.setVisibility(8);
        this.aLS.setVisibility(0);
    }

    public void j(View.OnClickListener onClickListener) {
        this.aMl = onClickListener;
    }

    public void k(View.OnClickListener onClickListener) {
        this.aMm = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ah(i == 1);
            tbPageContext.getLayoutMode().x(findViewById(t.g.app_download_dialog_layout));
        }
    }
}
