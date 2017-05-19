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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class y extends Dialog {
    private VersionData aTV;
    private CombineDownload aTW;
    private boolean aTX;
    private boolean aTY;
    private boolean aTZ;
    private boolean aUa;
    private LinearLayout aUb;
    private TextView aUc;
    private TextView aUd;
    private TextView aUe;
    private String aUf;
    private TextView aUg;
    private TextView aUh;
    private TextView aUi;
    private View aUj;
    private TextView aUk;
    private TextView aUl;
    private View aUm;
    private LinearLayout aUn;
    private TextView aUo;
    private TextView aUp;
    private TextView aUq;
    private View aUr;
    private LinearLayout aUs;
    private a aUt;
    private View.OnClickListener aUu;
    private View.OnClickListener aUv;
    private boolean aUw;
    private boolean aUx;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void KB();

        void KC();

        void cm(boolean z);

        void cn(boolean z);

        void stopService();
    }

    public y(Context context, int i) {
        super(context, i);
        this.aTX = false;
        this.aTY = true;
        this.aTZ = false;
        this.aUa = false;
        this.aUw = true;
        this.aUx = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.app_download_dialog);
        this.aUb = (LinearLayout) findViewById(w.h.app_info);
        this.aUc = (TextView) findViewById(w.h.app_version_and_size);
        this.aUd = (TextView) findViewById(w.h.app_description);
        this.aUi = (TextView) findViewById(w.h.fullsize_download_button);
        this.aUh = (TextView) findViewById(w.h.cancel_download_button);
        this.aUj = findViewById(w.h.divider_line);
        this.aUe = (TextView) findViewById(w.h.download_process);
        this.aUk = (TextView) findViewById(w.h.incremental_download_button);
        this.aUl = (TextView) findViewById(w.h.not_install_as_tip);
        this.aUm = findViewById(w.h.incremental_download_layout);
        this.aUg = (TextView) findViewById(w.h.other_app_recommend);
        this.aUr = findViewById(w.h.divider_under_button);
        this.aUs = (LinearLayout) findViewById(w.h.cancel_confirm_ll);
        this.aUf = this.aUe.getText().toString();
        this.aUn = (LinearLayout) findViewById(w.h.cancel_dialog);
        this.aUp = (TextView) findViewById(w.h.sure_cancel);
        this.aUq = (TextView) findViewById(w.h.cancel_button);
        this.aUo = (TextView) findViewById(w.h.cancel_tip);
        this.aUp.setOnClickListener(this.aUu);
        this.aUq.setOnClickListener(this.aUv);
        if (com.baidu.adp.lib.b.e.eZ().Y("android_shouzhu_update") == 1) {
            this.aUw = true;
        } else {
            this.aUw = false;
        }
        String size = this.aTV.getSize();
        String newVersion = this.aTV.getNewVersion();
        String newVersionDesc = this.aTV.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(w.l.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.b(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aUc.setText(sb.toString());
        this.aUd.setText(newVersionDesc);
        if (this.aTV.forceUpdate()) {
            this.aUa = true;
            this.aUh.setText(this.mContext.getString(w.l.quit));
        } else {
            this.aUh.setText(this.mContext.getString(w.l.update_after));
        }
        if (this.aTW != null && this.aTW.showCombineDownload() && !TextUtils.isEmpty(this.aTW.getApkMD5RSA())) {
            this.aUg.setText(this.aTW.getAppName());
            if (!com.baidu.tieba.tbadkCore.ac.isInstalledPackage(this.mContext, this.aTW.getAppProc()) && !TextUtils.isEmpty(this.aTW.getAppUrl())) {
                this.aUg.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(w.g.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aUg.setCompoundDrawables(drawable, null, null, null);
                this.aTX = true;
            } else {
                this.aUg.setVisibility(8);
                this.aTX = false;
            }
        } else {
            this.aUg.setVisibility(8);
            this.aTX = false;
        }
        cl(this.aUw);
        this.aUi.setOnClickListener(new z(this));
        this.aUk.setOnClickListener(new aa(this));
        this.aUh.setOnClickListener(new ab(this));
        this.aUg.setOnClickListener(new ac(this));
        Kz();
    }

    private void Kz() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void cl(boolean z) {
        if (aj.b(this.mContext.getPackageManager())) {
            this.aUl.setVisibility(8);
        } else {
            this.aUl.setVisibility(0);
        }
        if (z) {
            if (this.aTV == null || TextUtils.isEmpty(this.aTV.getPatch()) || this.aTV.getNewVersionCode() < 0) {
                this.aUm.setVisibility(0);
                this.aUk.setText(w.l.super_update);
                aq.j(this.aUk, w.g.dialog_middle_item_bg_selector);
                this.aUs.setVisibility(0);
                this.aUx = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.aUm.setVisibility(0);
            this.aUk.setText(w.l.incremental_update);
            aq.j(this.aUk, w.g.dialog_single_button_bg_selector);
            this.aUr.setVisibility(8);
            this.aUs.setVisibility(8);
            this.aUx = true;
            TiebaStatic.log("c10002");
        } else if (this.aTV == null || TextUtils.isEmpty(this.aTV.getPatch()) || this.aTV.getNewVersionCode() < 0) {
            this.aUm.setVisibility(8);
            this.aUs.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.aUm.setVisibility(0);
            aq.j(this.aUk, w.g.dialog_middle_item_bg_selector);
            this.aUk.setText(w.l.incremental_update);
            this.aUs.setVisibility(0);
            this.aUx = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void fG(int i) {
        this.aUi.setVisibility(8);
        this.aUm.setVisibility(8);
        this.aUh.setVisibility(8);
        this.aUj.setVisibility(8);
        this.aTZ = true;
        this.aUs.setVisibility(0);
        this.aUe.setVisibility(0);
        this.aUe.setText(String.valueOf(this.aUf) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aTZ) {
            this.aUt.stopService();
            this.aUb.setVisibility(8);
            if (this.aUa) {
                this.aUo.setText(getContext().getString(w.l.download_exit));
            }
            this.aUn.setVisibility(0);
            return;
        }
        this.aUt.KC();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aTV = versionData;
        this.aTW = combineDownload;
        this.aUt = aVar;
    }

    public void KA() {
        this.aUn.setVisibility(8);
        this.aUb.setVisibility(0);
    }

    public void j(View.OnClickListener onClickListener) {
        this.aUu = onClickListener;
    }

    public void k(View.OnClickListener onClickListener) {
        this.aUv = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ai(i == 1);
            tbPageContext.getLayoutMode().t(findViewById(w.h.app_download_dialog_layout));
        }
    }
}
