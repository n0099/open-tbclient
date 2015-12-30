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
    private VersionData aGT;
    private CombineDownload aGU;
    private boolean aGV;
    private boolean aGW;
    private boolean aGX;
    private boolean aGY;
    private LinearLayout aGZ;
    private TextView aHa;
    private TextView aHb;
    private TextView aHc;
    private String aHd;
    private TextView aHe;
    private TextView aHf;
    private TextView aHg;
    private View aHh;
    private TextView aHi;
    private TextView aHj;
    private View aHk;
    private LinearLayout aHl;
    private TextView aHm;
    private TextView aHn;
    private TextView aHo;
    private View aHp;
    private LinearLayout aHq;
    private a aHr;
    private View.OnClickListener aHs;
    private View.OnClickListener aHt;
    private boolean aHu;
    private boolean aHv;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void GB();

        void GC();

        void bH(boolean z);

        void bI(boolean z);

        void stopService();
    }

    public o(Context context, int i) {
        super(context, i);
        this.aGV = false;
        this.aGW = true;
        this.aGX = false;
        this.aGY = false;
        this.aHu = true;
        this.aHv = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.h.app_download_dialog);
        this.aGZ = (LinearLayout) findViewById(n.g.app_info);
        this.aHa = (TextView) findViewById(n.g.app_version_and_size);
        this.aHb = (TextView) findViewById(n.g.app_description);
        this.aHg = (TextView) findViewById(n.g.fullsize_download_button);
        this.aHf = (TextView) findViewById(n.g.cancel_download_button);
        this.aHh = findViewById(n.g.divider_line);
        this.aHc = (TextView) findViewById(n.g.download_process);
        this.aHi = (TextView) findViewById(n.g.incremental_download_button);
        this.aHj = (TextView) findViewById(n.g.not_install_as_tip);
        this.aHk = findViewById(n.g.incremental_download_layout);
        this.aHe = (TextView) findViewById(n.g.other_app_recommend);
        this.aHp = findViewById(n.g.divider_under_button);
        this.aHq = (LinearLayout) findViewById(n.g.cancel_confirm_ll);
        this.aHd = this.aHc.getText().toString();
        this.aHl = (LinearLayout) findViewById(n.g.cancel_dialog);
        this.aHn = (TextView) findViewById(n.g.sure_cancel);
        this.aHo = (TextView) findViewById(n.g.cancel_button);
        this.aHm = (TextView) findViewById(n.g.cancel_tip);
        this.aHn.setOnClickListener(this.aHs);
        this.aHo.setOnClickListener(this.aHt);
        if (com.baidu.adp.lib.c.e.gw().aj("android_shouzhu_update") == 1) {
            this.aHu = true;
        } else {
            this.aHu = false;
        }
        String size = this.aGT.getSize();
        String newVersion = this.aGT.getNewVersion();
        String newVersionDesc = this.aGT.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(n.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.h.b.a(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aHa.setText(sb.toString());
        this.aHb.setText(newVersionDesc);
        if (this.aGT.forceUpdate()) {
            this.aGY = true;
            this.aHf.setText(this.mContext.getString(n.j.quit));
        } else {
            this.aHf.setText(this.mContext.getString(n.j.update_after));
        }
        if (this.aGU != null && this.aGU.showCombineDownload()) {
            this.aHe.setText(this.aGU.getAppName());
            if (!ah.isInstalledPackage(this.mContext, this.aGU.getAppProc()) && !TextUtils.isEmpty(this.aGU.getAppUrl())) {
                this.aHe.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(n.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aHe.setCompoundDrawables(drawable, null, null, null);
                this.aGV = true;
            } else {
                this.aHe.setVisibility(8);
                this.aGV = false;
            }
        } else {
            this.aHe.setVisibility(8);
            this.aGV = false;
        }
        bG(this.aHu);
        this.aHg.setOnClickListener(new p(this));
        this.aHi.setOnClickListener(new q(this));
        this.aHf.setOnClickListener(new r(this));
        this.aHe.setOnClickListener(new s(this));
        Gz();
    }

    private void Gz() {
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
            this.aHj.setVisibility(8);
        } else {
            this.aHj.setVisibility(0);
        }
        if (z) {
            if (this.aGT == null || TextUtils.isEmpty(this.aGT.getPatch()) || this.aGT.getNewVersionCode() < 0) {
                this.aHk.setVisibility(0);
                this.aHi.setText(n.j.super_update);
                as.i((View) this.aHi, n.f.dialog_middle_item_bg_selector);
                this.aHq.setVisibility(0);
                this.aHv = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.aHk.setVisibility(0);
            this.aHi.setText(n.j.incremental_update);
            as.i((View) this.aHi, n.f.dialog_single_button_bg_selector);
            this.aHp.setVisibility(8);
            this.aHq.setVisibility(8);
            this.aHv = true;
            TiebaStatic.log("c10002");
        } else if (this.aGT == null || TextUtils.isEmpty(this.aGT.getPatch()) || this.aGT.getNewVersionCode() < 0) {
            this.aHk.setVisibility(8);
            this.aHq.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.aHk.setVisibility(0);
            as.i((View) this.aHi, n.f.dialog_middle_item_bg_selector);
            this.aHi.setText(n.j.incremental_update);
            this.aHq.setVisibility(0);
            this.aHv = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void eW(int i) {
        this.aHg.setVisibility(8);
        this.aHk.setVisibility(8);
        this.aHf.setVisibility(8);
        this.aHh.setVisibility(8);
        this.aGX = true;
        this.aHq.setVisibility(0);
        this.aHc.setVisibility(0);
        this.aHc.setText(String.valueOf(this.aHd) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aGX) {
            this.aHr.stopService();
            this.aGZ.setVisibility(8);
            if (this.aGY) {
                this.aHm.setText(getContext().getString(n.j.download_exit));
            }
            this.aHl.setVisibility(0);
            return;
        }
        this.aHr.GC();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aGT = versionData;
        this.aGU = combineDownload;
        this.aHr = aVar;
    }

    public void GA() {
        this.aHl.setVisibility(8);
        this.aGZ.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.aHs = onClickListener;
    }

    public void g(View.OnClickListener onClickListener) {
        this.aHt = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ac(i == 1);
            tbPageContext.getLayoutMode().k(findViewById(n.g.app_download_dialog_layout));
        }
    }
}
