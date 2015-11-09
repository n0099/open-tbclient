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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.ag;
/* loaded from: classes.dex */
public class j extends Dialog {
    private boolean aCA;
    private boolean aCB;
    private LinearLayout aCC;
    private TextView aCD;
    private TextView aCE;
    private TextView aCF;
    private String aCG;
    private TextView aCH;
    private TextView aCI;
    private TextView aCJ;
    private View aCK;
    private TextView aCL;
    private TextView aCM;
    private View aCN;
    private LinearLayout aCO;
    private TextView aCP;
    private TextView aCQ;
    private TextView aCR;
    private View aCS;
    private LinearLayout aCT;
    private a aCU;
    private View.OnClickListener aCV;
    private View.OnClickListener aCW;
    private boolean aCX;
    private boolean aCY;
    private VersionData aCw;
    private CombineDownload aCx;
    private boolean aCy;
    private boolean aCz;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void FF();

        void FG();

        void by(boolean z);

        void bz(boolean z);

        void stopService();
    }

    public j(Context context, int i) {
        super(context, i);
        this.aCy = false;
        this.aCz = true;
        this.aCA = false;
        this.aCB = false;
        this.aCX = true;
        this.aCY = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.app_download_dialog);
        this.aCC = (LinearLayout) findViewById(i.f.app_info);
        this.aCD = (TextView) findViewById(i.f.app_version_and_size);
        this.aCE = (TextView) findViewById(i.f.app_description);
        this.aCJ = (TextView) findViewById(i.f.fullsize_download_button);
        this.aCI = (TextView) findViewById(i.f.cancel_download_button);
        this.aCK = findViewById(i.f.divider_line);
        this.aCF = (TextView) findViewById(i.f.download_process);
        this.aCL = (TextView) findViewById(i.f.incremental_download_button);
        this.aCM = (TextView) findViewById(i.f.not_install_as_tip);
        this.aCN = findViewById(i.f.incremental_download_layout);
        this.aCH = (TextView) findViewById(i.f.other_app_recommend);
        this.aCS = findViewById(i.f.divider_under_button);
        this.aCT = (LinearLayout) findViewById(i.f.cancel_confirm_ll);
        this.aCG = this.aCF.getText().toString();
        this.aCO = (LinearLayout) findViewById(i.f.cancel_dialog);
        this.aCQ = (TextView) findViewById(i.f.sure_cancel);
        this.aCR = (TextView) findViewById(i.f.cancel_button);
        this.aCP = (TextView) findViewById(i.f.cancel_tip);
        this.aCQ.setOnClickListener(this.aCV);
        this.aCR.setOnClickListener(this.aCW);
        if (com.baidu.adp.lib.b.e.gv().af("android_shouzhu_update") == 1) {
            this.aCX = true;
        } else {
            this.aCX = false;
        }
        String size = this.aCw.getSize();
        String newVersion = this.aCw.getNewVersion();
        String newVersionDesc = this.aCw.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(i.h.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.a(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aCD.setText(sb.toString());
        this.aCE.setText(newVersionDesc);
        if (this.aCw.forceUpdate()) {
            this.aCB = true;
            this.aCI.setText(this.mContext.getString(i.h.quit));
        } else {
            this.aCI.setText(this.mContext.getString(i.h.update_after));
        }
        if (this.aCx != null && this.aCx.showCombineDownload()) {
            this.aCH.setText(this.aCx.getAppName());
            if (!ag.isInstalledPackage(this.mContext, this.aCx.getAppProc()) && !TextUtils.isEmpty(this.aCx.getAppUrl())) {
                this.aCH.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(i.e.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aCH.setCompoundDrawables(drawable, null, null, null);
                this.aCy = true;
            } else {
                this.aCH.setVisibility(8);
                this.aCy = false;
            }
        } else {
            this.aCH.setVisibility(8);
            this.aCy = false;
        }
        bx(this.aCX);
        this.aCJ.setOnClickListener(new k(this));
        this.aCL.setOnClickListener(new l(this));
        this.aCI.setOnClickListener(new m(this));
        this.aCH.setOnClickListener(new n(this));
        FD();
    }

    private void FD() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void bx(boolean z) {
        if (t.a(this.mContext.getPackageManager())) {
            this.aCM.setVisibility(8);
        } else {
            this.aCM.setVisibility(0);
        }
        if (z) {
            if (this.aCw == null || TextUtils.isEmpty(this.aCw.getPatch()) || this.aCw.getNewVersionCode() < 0) {
                this.aCN.setVisibility(0);
                this.aCL.setText(i.h.super_update);
                an.i((View) this.aCL, i.e.dialog_middle_item_bg_selector);
                this.aCT.setVisibility(0);
                this.aCY = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.aCN.setVisibility(0);
            this.aCL.setText(i.h.incremental_update);
            an.i((View) this.aCL, i.e.dialog_single_button_bg_selector);
            this.aCS.setVisibility(8);
            this.aCT.setVisibility(8);
            this.aCY = true;
            TiebaStatic.log("c10002");
        } else if (this.aCw == null || TextUtils.isEmpty(this.aCw.getPatch()) || this.aCw.getNewVersionCode() < 0) {
            this.aCN.setVisibility(8);
            this.aCT.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.aCN.setVisibility(0);
            an.i((View) this.aCL, i.e.dialog_middle_item_bg_selector);
            this.aCL.setText(i.h.incremental_update);
            this.aCT.setVisibility(0);
            this.aCY = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void eP(int i) {
        this.aCJ.setVisibility(8);
        this.aCN.setVisibility(8);
        this.aCI.setVisibility(8);
        this.aCK.setVisibility(8);
        this.aCA = true;
        this.aCT.setVisibility(0);
        this.aCF.setVisibility(0);
        this.aCF.setText(String.valueOf(this.aCG) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aCA) {
            this.aCU.stopService();
            this.aCC.setVisibility(8);
            if (this.aCB) {
                this.aCP.setText(getContext().getString(i.h.download_exit));
            }
            this.aCO.setVisibility(0);
            return;
        }
        this.aCU.FG();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aCw = versionData;
        this.aCx = combineDownload;
        this.aCU = aVar;
    }

    public void FE() {
        this.aCO.setVisibility(8);
        this.aCC.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.aCV = onClickListener;
    }

    public void g(View.OnClickListener onClickListener) {
        this.aCW = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ad(i == 1);
            tbPageContext.getLayoutMode().k(findViewById(i.f.app_download_dialog_layout));
        }
    }
}
