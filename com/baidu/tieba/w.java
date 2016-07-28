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
import com.baidu.tieba.tbadkCore.al;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class w extends Dialog {
    private boolean aIA;
    private LinearLayout aIB;
    private TextView aIC;
    private TextView aID;
    private TextView aIE;
    private String aIF;
    private TextView aIG;
    private TextView aIH;
    private TextView aII;
    private View aIJ;
    private TextView aIK;
    private TextView aIL;
    private View aIM;
    private LinearLayout aIN;
    private TextView aIO;
    private TextView aIP;
    private TextView aIQ;
    private View aIR;
    private LinearLayout aIS;
    private a aIT;
    private View.OnClickListener aIU;
    private View.OnClickListener aIV;
    private boolean aIW;
    private boolean aIX;
    private VersionData aIv;
    private CombineDownload aIw;
    private boolean aIx;
    private boolean aIy;
    private boolean aIz;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void HQ();

        void HR();

        void bY(boolean z);

        void bZ(boolean z);

        void stopService();
    }

    public w(Context context, int i) {
        super(context, i);
        this.aIx = false;
        this.aIy = true;
        this.aIz = false;
        this.aIA = false;
        this.aIW = true;
        this.aIX = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(u.h.app_download_dialog);
        this.aIB = (LinearLayout) findViewById(u.g.app_info);
        this.aIC = (TextView) findViewById(u.g.app_version_and_size);
        this.aID = (TextView) findViewById(u.g.app_description);
        this.aII = (TextView) findViewById(u.g.fullsize_download_button);
        this.aIH = (TextView) findViewById(u.g.cancel_download_button);
        this.aIJ = findViewById(u.g.divider_line);
        this.aIE = (TextView) findViewById(u.g.download_process);
        this.aIK = (TextView) findViewById(u.g.incremental_download_button);
        this.aIL = (TextView) findViewById(u.g.not_install_as_tip);
        this.aIM = findViewById(u.g.incremental_download_layout);
        this.aIG = (TextView) findViewById(u.g.other_app_recommend);
        this.aIR = findViewById(u.g.divider_under_button);
        this.aIS = (LinearLayout) findViewById(u.g.cancel_confirm_ll);
        this.aIF = this.aIE.getText().toString();
        this.aIN = (LinearLayout) findViewById(u.g.cancel_dialog);
        this.aIP = (TextView) findViewById(u.g.sure_cancel);
        this.aIQ = (TextView) findViewById(u.g.cancel_button);
        this.aIO = (TextView) findViewById(u.g.cancel_tip);
        this.aIP.setOnClickListener(this.aIU);
        this.aIQ.setOnClickListener(this.aIV);
        if (com.baidu.adp.lib.c.e.cS().ab("android_shouzhu_update") == 1) {
            this.aIW = true;
        } else {
            this.aIW = false;
        }
        String size = this.aIv.getSize();
        String newVersion = this.aIv.getNewVersion();
        String newVersionDesc = this.aIv.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(u.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.h.b.b(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aIC.setText(sb.toString());
        this.aID.setText(newVersionDesc);
        if (this.aIv.forceUpdate()) {
            this.aIA = true;
            this.aIH.setText(this.mContext.getString(u.j.quit));
        } else {
            this.aIH.setText(this.mContext.getString(u.j.update_after));
        }
        if (this.aIw != null && this.aIw.showCombineDownload() && !TextUtils.isEmpty(this.aIw.getApkMD5RSA())) {
            this.aIG.setText(this.aIw.getAppName());
            if (!al.isInstalledPackage(this.mContext, this.aIw.getAppProc()) && !TextUtils.isEmpty(this.aIw.getAppUrl())) {
                this.aIG.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(u.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aIG.setCompoundDrawables(drawable, null, null, null);
                this.aIx = true;
            } else {
                this.aIG.setVisibility(8);
                this.aIx = false;
            }
        } else {
            this.aIG.setVisibility(8);
            this.aIx = false;
        }
        bX(this.aIW);
        this.aII.setOnClickListener(new x(this));
        this.aIK.setOnClickListener(new y(this));
        this.aIH.setOnClickListener(new z(this));
        this.aIG.setOnClickListener(new aa(this));
        HO();
    }

    private void HO() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void bX(boolean z) {
        if (ai.b(this.mContext.getPackageManager())) {
            this.aIL.setVisibility(8);
        } else {
            this.aIL.setVisibility(0);
        }
        if (z) {
            if (this.aIv == null || TextUtils.isEmpty(this.aIv.getPatch()) || this.aIv.getNewVersionCode() < 0) {
                this.aIM.setVisibility(0);
                this.aIK.setText(u.j.super_update);
                av.k(this.aIK, u.f.dialog_middle_item_bg_selector);
                this.aIS.setVisibility(0);
                this.aIX = false;
                com.baidu.tbadk.core.util.TiebaStatic.log("c10008");
                com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
                return;
            }
            this.aIM.setVisibility(0);
            this.aIK.setText(u.j.incremental_update);
            av.k(this.aIK, u.f.dialog_single_button_bg_selector);
            this.aIR.setVisibility(8);
            this.aIS.setVisibility(8);
            this.aIX = true;
            com.baidu.tbadk.core.util.TiebaStatic.log("c10002");
        } else if (this.aIv == null || TextUtils.isEmpty(this.aIv.getPatch()) || this.aIv.getNewVersionCode() < 0) {
            this.aIM.setVisibility(8);
            this.aIS.setVisibility(0);
            com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
        } else {
            this.aIM.setVisibility(0);
            av.k(this.aIK, u.f.dialog_middle_item_bg_selector);
            this.aIK.setText(u.j.incremental_update);
            this.aIS.setVisibility(0);
            this.aIX = true;
            com.baidu.tbadk.core.util.TiebaStatic.log("c10002");
            com.baidu.tbadk.core.util.TiebaStatic.log("c10010");
        }
    }

    public void fp(int i) {
        this.aII.setVisibility(8);
        this.aIM.setVisibility(8);
        this.aIH.setVisibility(8);
        this.aIJ.setVisibility(8);
        this.aIz = true;
        this.aIS.setVisibility(0);
        this.aIE.setVisibility(0);
        this.aIE.setText(String.valueOf(this.aIF) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aIz) {
            this.aIT.stopService();
            this.aIB.setVisibility(8);
            if (this.aIA) {
                this.aIO.setText(getContext().getString(u.j.download_exit));
            }
            this.aIN.setVisibility(0);
            return;
        }
        this.aIT.HR();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aIv = versionData;
        this.aIw = combineDownload;
        this.aIT = aVar;
    }

    public void HP() {
        this.aIN.setVisibility(8);
        this.aIB.setVisibility(0);
    }

    public void j(View.OnClickListener onClickListener) {
        this.aIU = onClickListener;
    }

    public void k(View.OnClickListener onClickListener) {
        this.aIV = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().af(i == 1);
            tbPageContext.getLayoutMode().w(findViewById(u.g.app_download_dialog_layout));
        }
    }
}
