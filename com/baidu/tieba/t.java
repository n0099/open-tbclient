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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.ak;
/* loaded from: classes.dex */
public class t extends Dialog {
    private VersionData aMW;
    private CombineDownload aMX;
    private boolean aMY;
    private boolean aMZ;
    private boolean aNa;
    private boolean aNb;
    private LinearLayout aNc;
    private TextView aNd;
    private TextView aNe;
    private TextView aNf;
    private String aNg;
    private TextView aNh;
    private TextView aNi;
    private TextView aNj;
    private View aNk;
    private TextView aNl;
    private TextView aNm;
    private View aNn;
    private LinearLayout aNo;
    private TextView aNp;
    private TextView aNq;
    private TextView aNr;
    private View aNs;
    private LinearLayout aNt;
    private a aNu;
    private View.OnClickListener aNv;
    private View.OnClickListener aNw;
    private boolean aNx;
    private boolean aNy;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void JW();

        void JX();

        void cb(boolean z);

        void cc(boolean z);

        void stopService();
    }

    public t(Context context, int i) {
        super(context, i);
        this.aMY = false;
        this.aMZ = true;
        this.aNa = false;
        this.aNb = false;
        this.aNx = true;
        this.aNy = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.h.app_download_dialog);
        this.aNc = (LinearLayout) findViewById(r.g.app_info);
        this.aNd = (TextView) findViewById(r.g.app_version_and_size);
        this.aNe = (TextView) findViewById(r.g.app_description);
        this.aNj = (TextView) findViewById(r.g.fullsize_download_button);
        this.aNi = (TextView) findViewById(r.g.cancel_download_button);
        this.aNk = findViewById(r.g.divider_line);
        this.aNf = (TextView) findViewById(r.g.download_process);
        this.aNl = (TextView) findViewById(r.g.incremental_download_button);
        this.aNm = (TextView) findViewById(r.g.not_install_as_tip);
        this.aNn = findViewById(r.g.incremental_download_layout);
        this.aNh = (TextView) findViewById(r.g.other_app_recommend);
        this.aNs = findViewById(r.g.divider_under_button);
        this.aNt = (LinearLayout) findViewById(r.g.cancel_confirm_ll);
        this.aNg = this.aNf.getText().toString();
        this.aNo = (LinearLayout) findViewById(r.g.cancel_dialog);
        this.aNq = (TextView) findViewById(r.g.sure_cancel);
        this.aNr = (TextView) findViewById(r.g.cancel_button);
        this.aNp = (TextView) findViewById(r.g.cancel_tip);
        this.aNq.setOnClickListener(this.aNv);
        this.aNr.setOnClickListener(this.aNw);
        if (com.baidu.adp.lib.c.e.dN().ac("android_shouzhu_update") == 1) {
            this.aNx = true;
        } else {
            this.aNx = false;
        }
        String size = this.aMW.getSize();
        String newVersion = this.aMW.getNewVersion();
        String newVersionDesc = this.aMW.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(r.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.h.b.b(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aNd.setText(sb.toString());
        this.aNe.setText(newVersionDesc);
        if (this.aMW.forceUpdate()) {
            this.aNb = true;
            this.aNi.setText(this.mContext.getString(r.j.quit));
        } else {
            this.aNi.setText(this.mContext.getString(r.j.update_after));
        }
        if (this.aMX != null && this.aMX.showCombineDownload() && !TextUtils.isEmpty(this.aMX.getApkMD5RSA())) {
            this.aNh.setText(this.aMX.getAppName());
            if (!ak.isInstalledPackage(this.mContext, this.aMX.getAppProc()) && !TextUtils.isEmpty(this.aMX.getAppUrl())) {
                this.aNh.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(r.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aNh.setCompoundDrawables(drawable, null, null, null);
                this.aMY = true;
            } else {
                this.aNh.setVisibility(8);
                this.aMY = false;
            }
        } else {
            this.aNh.setVisibility(8);
            this.aMY = false;
        }
        ca(this.aNx);
        this.aNj.setOnClickListener(new u(this));
        this.aNl.setOnClickListener(new v(this));
        this.aNi.setOnClickListener(new w(this));
        this.aNh.setOnClickListener(new x(this));
        JU();
    }

    private void JU() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void ca(boolean z) {
        if (af.b(this.mContext.getPackageManager())) {
            this.aNm.setVisibility(8);
        } else {
            this.aNm.setVisibility(0);
        }
        if (z) {
            if (this.aMW == null || TextUtils.isEmpty(this.aMW.getPatch()) || this.aMW.getNewVersionCode() < 0) {
                this.aNn.setVisibility(0);
                this.aNl.setText(r.j.super_update);
                av.k(this.aNl, r.f.dialog_middle_item_bg_selector);
                this.aNt.setVisibility(0);
                this.aNy = false;
                com.baidu.tbadk.core.util.TiebaStatic.log("c10008");
                com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
                return;
            }
            this.aNn.setVisibility(0);
            this.aNl.setText(r.j.incremental_update);
            av.k(this.aNl, r.f.dialog_single_button_bg_selector);
            this.aNs.setVisibility(8);
            this.aNt.setVisibility(8);
            this.aNy = true;
            com.baidu.tbadk.core.util.TiebaStatic.log("c10002");
        } else if (this.aMW == null || TextUtils.isEmpty(this.aMW.getPatch()) || this.aMW.getNewVersionCode() < 0) {
            this.aNn.setVisibility(8);
            this.aNt.setVisibility(0);
            com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
        } else {
            this.aNn.setVisibility(0);
            av.k(this.aNl, r.f.dialog_middle_item_bg_selector);
            this.aNl.setText(r.j.incremental_update);
            this.aNt.setVisibility(0);
            this.aNy = true;
            com.baidu.tbadk.core.util.TiebaStatic.log("c10002");
            com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
        }
    }

    public void fJ(int i) {
        this.aNj.setVisibility(8);
        this.aNn.setVisibility(8);
        this.aNi.setVisibility(8);
        this.aNk.setVisibility(8);
        this.aNa = true;
        this.aNt.setVisibility(0);
        this.aNf.setVisibility(0);
        this.aNf.setText(String.valueOf(this.aNg) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aNa) {
            this.aNu.stopService();
            this.aNc.setVisibility(8);
            if (this.aNb) {
                this.aNp.setText(getContext().getString(r.j.download_exit));
            }
            this.aNo.setVisibility(0);
            return;
        }
        this.aNu.JX();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aMW = versionData;
        this.aMX = combineDownload;
        this.aNu = aVar;
    }

    public void JV() {
        this.aNo.setVisibility(8);
        this.aNc.setVisibility(0);
    }

    public void i(View.OnClickListener onClickListener) {
        this.aNv = onClickListener;
    }

    public void j(View.OnClickListener onClickListener) {
        this.aNw = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ah(i == 1);
            tbPageContext.getLayoutMode().x(findViewById(r.g.app_download_dialog_layout));
        }
    }
}
