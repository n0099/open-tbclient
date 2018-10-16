package com.baidu.tieba.qrcode.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.e;
import com.baidu.tieba.qrcode.lib.core.QRCodeView;
import com.baidu.tieba.qrcode.lib.zxing.ZXingView;
/* loaded from: classes3.dex */
public class QRCodeScanActivity extends BaseActivity implements View.OnClickListener, a {
    private View bdE;
    private int eZs;
    private QRCodeView gAi;
    private TextView gAj;
    private b gAk;
    private View gAl;
    private TextView gAm;
    private TextView gAn;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.eZs = TbadkCoreApplication.getInst().getSkinType();
        super.onCreate(bundle);
        setContentView(e.h.activity_qr_code_scan);
        this.gAi = (ZXingView) findViewById(e.g.zxingview);
        if (this.gAi.getScanBoxView() != null) {
            this.gAi.getScanBoxView().setToolbarHeight(UtilHelper.getStatusBarHeight());
            this.gAi.getScanBoxView().requestLayout();
        }
        this.mNavigationBar = (NavigationBar) findViewById(e.g.qrcode_navigation_bar);
        this.gAl = findViewById(e.g.qrcode_black_error_view);
        this.gAl.setOnClickListener(this);
        this.gAm = (TextView) findViewById(e.g.qrcode_error_tv_not_found);
        this.gAn = (TextView) findViewById(e.g.qrcode_error_tv_tap_to_continue);
        this.gAj = this.mNavigationBar.setCenterTextTitle(getString(e.j.qrcode_title));
        this.bdE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bdE.setOnClickListener(this);
        this.gAk = new b(this, getPageContext());
        this.gAi.setDelegate(this.gAk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.gAi.bsB();
        this.gAi.bsz();
        this.gAi.bsC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        TbadkCoreApplication.getInst().setSkinTypeValue(this.eZs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        this.gAi.stopCamera();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaStatic.log(new am("c12707"));
        this.gAi.onDestroy();
        this.gAk.onDestroy();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.setBackgroundResource(e.f.transparent_bg);
        this.mNavigationBar.setmBackImageViewBg(e.f.btn_sml_back_selector_s, e.f.btn_sml_back_selector_s);
        this.gAj.setTextColor(getResources().getColor(e.d.cp_cont_i));
        this.gAl.setBackgroundColor(getResources().getColor(e.d.black_alpha80));
        this.gAm.setTextColor(getResources().getColor(e.d.cp_cont_g));
        this.gAn.setTextColor(getResources().getColor(e.d.cp_cont_j));
        if (UtilHelper.isFlyMeOs() && !UtilHelper.isMeizuE3()) {
            TbadkCoreApplication.getInst().setSkinTypeValue(1);
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bsq() {
        bss();
        this.gAl.setVisibility(0);
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bsr() {
        showProgressBar();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bss() {
        hideProgressBar();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bst() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.aV(true);
        aVar.aU(true);
        aVar.cy(e.j.confirm_title);
        aVar.ej(getString(e.j.qr_code_scan_tip));
        aVar.a(getPageContext().getString(e.j.confirm), new a.b() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                QRCodeScanActivity.this.gAi.bsC();
                aVar2.dismiss();
            }
        });
        aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                QRCodeScanActivity.this.gAi.bsC();
            }
        });
        aVar.b(getPageContext()).Au();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bdE) {
            finish();
        } else if (view == this.gAl) {
            this.gAl.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        S(intent);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void S(Intent intent) {
        ImageFileInfo imageFileInfo;
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            if (writeImagesInfo.getChosedFiles() != null && writeImagesInfo.getChosedFiles().size() > 0 && (imageFileInfo = writeImagesInfo.getChosedFiles().get(0)) != null) {
                this.gAk.tI(imageFileInfo.getFilePath());
            }
            writeImagesInfo.clear();
        }
    }
}
