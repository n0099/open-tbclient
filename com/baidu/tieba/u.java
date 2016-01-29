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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class u extends Dialog {
    private VersionData aHV;
    private CombineDownload aHW;
    private boolean aHX;
    private boolean aHY;
    private boolean aHZ;
    private boolean aIa;
    private LinearLayout aIb;
    private TextView aIc;
    private TextView aId;
    private TextView aIe;
    private String aIf;
    private TextView aIg;
    private TextView aIh;
    private TextView aIi;
    private View aIj;
    private TextView aIk;
    private TextView aIl;
    private View aIm;
    private LinearLayout aIn;
    private TextView aIo;
    private TextView aIp;
    private TextView aIq;
    private View aIr;
    private LinearLayout aIs;
    private a aIt;
    private View.OnClickListener aIu;
    private View.OnClickListener aIv;
    private boolean aIw;
    private boolean aIx;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void Ic();

        void Id();

        void bI(boolean z);

        void bJ(boolean z);

        void stopService();
    }

    public u(Context context, int i) {
        super(context, i);
        this.aHX = false;
        this.aHY = true;
        this.aHZ = false;
        this.aIa = false;
        this.aIw = true;
        this.aIx = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.app_download_dialog);
        this.aIb = (LinearLayout) findViewById(t.g.app_info);
        this.aIc = (TextView) findViewById(t.g.app_version_and_size);
        this.aId = (TextView) findViewById(t.g.app_description);
        this.aIi = (TextView) findViewById(t.g.fullsize_download_button);
        this.aIh = (TextView) findViewById(t.g.cancel_download_button);
        this.aIj = findViewById(t.g.divider_line);
        this.aIe = (TextView) findViewById(t.g.download_process);
        this.aIk = (TextView) findViewById(t.g.incremental_download_button);
        this.aIl = (TextView) findViewById(t.g.not_install_as_tip);
        this.aIm = findViewById(t.g.incremental_download_layout);
        this.aIg = (TextView) findViewById(t.g.other_app_recommend);
        this.aIr = findViewById(t.g.divider_under_button);
        this.aIs = (LinearLayout) findViewById(t.g.cancel_confirm_ll);
        this.aIf = this.aIe.getText().toString();
        this.aIn = (LinearLayout) findViewById(t.g.cancel_dialog);
        this.aIp = (TextView) findViewById(t.g.sure_cancel);
        this.aIq = (TextView) findViewById(t.g.cancel_button);
        this.aIo = (TextView) findViewById(t.g.cancel_tip);
        this.aIp.setOnClickListener(this.aIu);
        this.aIq.setOnClickListener(this.aIv);
        if (com.baidu.adp.lib.c.e.gE().ai("android_shouzhu_update") == 1) {
            this.aIw = true;
        } else {
            this.aIw = false;
        }
        String size = this.aHV.getSize();
        String newVersion = this.aHV.getNewVersion();
        String newVersionDesc = this.aHV.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(t.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.h.b.a(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aIc.setText(sb.toString());
        this.aId.setText(newVersionDesc);
        if (this.aHV.forceUpdate()) {
            this.aIa = true;
            this.aIh.setText(this.mContext.getString(t.j.quit));
        } else {
            this.aIh.setText(this.mContext.getString(t.j.update_after));
        }
        if (this.aHW != null && this.aHW.showCombineDownload() && !TextUtils.isEmpty(this.aHW.getApkMD5RSA())) {
            this.aIg.setText(this.aHW.getAppName());
            if (!com.baidu.tieba.tbadkCore.ag.isInstalledPackage(this.mContext, this.aHW.getAppProc()) && !TextUtils.isEmpty(this.aHW.getAppUrl())) {
                this.aIg.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(t.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aIg.setCompoundDrawables(drawable, null, null, null);
                this.aHX = true;
            } else {
                this.aIg.setVisibility(8);
                this.aHX = false;
            }
        } else {
            this.aIg.setVisibility(8);
            this.aHX = false;
        }
        bH(this.aIw);
        this.aIi.setOnClickListener(new v(this));
        this.aIk.setOnClickListener(new w(this));
        this.aIh.setOnClickListener(new x(this));
        this.aIg.setOnClickListener(new y(this));
        Ia();
    }

    private void Ia() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void bH(boolean z) {
        if (ag.a(this.mContext.getPackageManager())) {
            this.aIl.setVisibility(8);
        } else {
            this.aIl.setVisibility(0);
        }
        if (z) {
            if (this.aHV == null || TextUtils.isEmpty(this.aHV.getPatch()) || this.aHV.getNewVersionCode() < 0) {
                this.aIm.setVisibility(0);
                this.aIk.setText(t.j.super_update);
                ar.k(this.aIk, t.f.dialog_middle_item_bg_selector);
                this.aIs.setVisibility(0);
                this.aIx = false;
                com.baidu.tbadk.core.util.TiebaStatic.log("c10008");
                com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
                return;
            }
            this.aIm.setVisibility(0);
            this.aIk.setText(t.j.incremental_update);
            ar.k(this.aIk, t.f.dialog_single_button_bg_selector);
            this.aIr.setVisibility(8);
            this.aIs.setVisibility(8);
            this.aIx = true;
            com.baidu.tbadk.core.util.TiebaStatic.log("c10002");
        } else if (this.aHV == null || TextUtils.isEmpty(this.aHV.getPatch()) || this.aHV.getNewVersionCode() < 0) {
            this.aIm.setVisibility(8);
            this.aIs.setVisibility(0);
            com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
        } else {
            this.aIm.setVisibility(0);
            ar.k(this.aIk, t.f.dialog_middle_item_bg_selector);
            this.aIk.setText(t.j.incremental_update);
            this.aIs.setVisibility(0);
            this.aIx = true;
            com.baidu.tbadk.core.util.TiebaStatic.log("c10002");
            com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
        }
    }

    public void fs(int i) {
        this.aIi.setVisibility(8);
        this.aIm.setVisibility(8);
        this.aIh.setVisibility(8);
        this.aIj.setVisibility(8);
        this.aHZ = true;
        this.aIs.setVisibility(0);
        this.aIe.setVisibility(0);
        this.aIe.setText(String.valueOf(this.aIf) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aHZ) {
            this.aIt.stopService();
            this.aIb.setVisibility(8);
            if (this.aIa) {
                this.aIo.setText(getContext().getString(t.j.download_exit));
            }
            this.aIn.setVisibility(0);
            return;
        }
        this.aIt.Id();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aHV = versionData;
        this.aHW = combineDownload;
        this.aIt = aVar;
    }

    public void Ib() {
        this.aIn.setVisibility(8);
        this.aIb.setVisibility(0);
    }

    public void j(View.OnClickListener onClickListener) {
        this.aIu = onClickListener;
    }

    public void k(View.OnClickListener onClickListener) {
        this.aIv = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ac(i == 1);
            tbPageContext.getLayoutMode().x(findViewById(t.g.app_download_dialog_layout));
        }
    }
}
