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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.ag;
/* loaded from: classes.dex */
public class j extends Dialog {
    private View aEA;
    private TextView aEB;
    private TextView aEC;
    private View aED;
    private LinearLayout aEE;
    private TextView aEF;
    private TextView aEG;
    private TextView aEH;
    private View aEI;
    private LinearLayout aEJ;
    private a aEK;
    private View.OnClickListener aEL;
    private View.OnClickListener aEM;
    private boolean aEN;
    private boolean aEO;
    private VersionData aEm;
    private CombineDownload aEn;
    private boolean aEo;
    private boolean aEp;
    private boolean aEq;
    private boolean aEr;
    private LinearLayout aEs;
    private TextView aEt;
    private TextView aEu;
    private TextView aEv;
    private String aEw;
    private TextView aEx;
    private TextView aEy;
    private TextView aEz;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void FS();

        void FT();

        void bA(boolean z);

        void bz(boolean z);

        void stopService();
    }

    public j(Context context, int i) {
        super(context, i);
        this.aEo = false;
        this.aEp = true;
        this.aEq = false;
        this.aEr = false;
        this.aEN = true;
        this.aEO = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.app_download_dialog);
        this.aEs = (LinearLayout) findViewById(i.f.app_info);
        this.aEt = (TextView) findViewById(i.f.app_version_and_size);
        this.aEu = (TextView) findViewById(i.f.app_description);
        this.aEz = (TextView) findViewById(i.f.fullsize_download_button);
        this.aEy = (TextView) findViewById(i.f.cancel_download_button);
        this.aEA = findViewById(i.f.divider_line);
        this.aEv = (TextView) findViewById(i.f.download_process);
        this.aEB = (TextView) findViewById(i.f.incremental_download_button);
        this.aEC = (TextView) findViewById(i.f.not_install_as_tip);
        this.aED = findViewById(i.f.incremental_download_layout);
        this.aEx = (TextView) findViewById(i.f.other_app_recommend);
        this.aEI = findViewById(i.f.divider_under_button);
        this.aEJ = (LinearLayout) findViewById(i.f.cancel_confirm_ll);
        this.aEw = this.aEv.getText().toString();
        this.aEE = (LinearLayout) findViewById(i.f.cancel_dialog);
        this.aEG = (TextView) findViewById(i.f.sure_cancel);
        this.aEH = (TextView) findViewById(i.f.cancel_button);
        this.aEF = (TextView) findViewById(i.f.cancel_tip);
        this.aEG.setOnClickListener(this.aEL);
        this.aEH.setOnClickListener(this.aEM);
        if (com.baidu.adp.lib.b.e.gv().ah("android_shouzhu_update") == 1) {
            this.aEN = true;
        } else {
            this.aEN = false;
        }
        String size = this.aEm.getSize();
        String newVersion = this.aEm.getNewVersion();
        String newVersionDesc = this.aEm.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(i.h.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.a(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aEt.setText(sb.toString());
        this.aEu.setText(newVersionDesc);
        if (this.aEm.forceUpdate()) {
            this.aEr = true;
            this.aEy.setText(this.mContext.getString(i.h.quit));
        } else {
            this.aEy.setText(this.mContext.getString(i.h.update_after));
        }
        if (this.aEn != null && this.aEn.showCombineDownload()) {
            this.aEx.setText(this.aEn.getAppName());
            if (!ag.isInstalledPackage(this.mContext, this.aEn.getAppProc()) && !TextUtils.isEmpty(this.aEn.getAppUrl())) {
                this.aEx.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(i.e.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aEx.setCompoundDrawables(drawable, null, null, null);
                this.aEo = true;
            } else {
                this.aEx.setVisibility(8);
                this.aEo = false;
            }
        } else {
            this.aEx.setVisibility(8);
            this.aEo = false;
        }
        by(this.aEN);
        this.aEz.setOnClickListener(new k(this));
        this.aEB.setOnClickListener(new l(this));
        this.aEy.setOnClickListener(new m(this));
        this.aEx.setOnClickListener(new n(this));
        FQ();
    }

    private void FQ() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void by(boolean z) {
        if (t.a(this.mContext.getPackageManager())) {
            this.aEC.setVisibility(8);
        } else {
            this.aEC.setVisibility(0);
        }
        if (z) {
            if (this.aEm == null || TextUtils.isEmpty(this.aEm.getPatch()) || this.aEm.getNewVersionCode() < 0) {
                this.aED.setVisibility(0);
                this.aEB.setText(i.h.super_update);
                al.h((View) this.aEB, i.e.dialog_middle_item_bg_selector);
                this.aEJ.setVisibility(0);
                this.aEO = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.aED.setVisibility(0);
            this.aEB.setText(i.h.incremental_update);
            al.h((View) this.aEB, i.e.dialog_single_button_bg_selector);
            this.aEI.setVisibility(8);
            this.aEJ.setVisibility(8);
            this.aEO = true;
            TiebaStatic.log("c10002");
        } else if (this.aEm == null || TextUtils.isEmpty(this.aEm.getPatch()) || this.aEm.getNewVersionCode() < 0) {
            this.aED.setVisibility(8);
            this.aEJ.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.aED.setVisibility(0);
            al.h((View) this.aEB, i.e.dialog_middle_item_bg_selector);
            this.aEB.setText(i.h.incremental_update);
            this.aEJ.setVisibility(0);
            this.aEO = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void eK(int i) {
        this.aEz.setVisibility(8);
        this.aED.setVisibility(8);
        this.aEy.setVisibility(8);
        this.aEA.setVisibility(8);
        this.aEq = true;
        this.aEJ.setVisibility(0);
        this.aEv.setVisibility(0);
        this.aEv.setText(String.valueOf(this.aEw) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aEq) {
            this.aEK.stopService();
            this.aEs.setVisibility(8);
            if (this.aEr) {
                this.aEF.setText(getContext().getString(i.h.download_exit));
            }
            this.aEE.setVisibility(0);
            return;
        }
        this.aEK.FT();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aEm = versionData;
        this.aEn = combineDownload;
        this.aEK = aVar;
    }

    public void FR() {
        this.aEE.setVisibility(8);
        this.aEs.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.aEL = onClickListener;
    }

    public void g(View.OnClickListener onClickListener) {
        this.aEM = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ad(i == 1);
            tbPageContext.getLayoutMode().k(findViewById(i.f.app_download_dialog_layout));
        }
    }
}
