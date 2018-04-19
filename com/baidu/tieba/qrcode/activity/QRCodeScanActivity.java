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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.qrcode.lib.core.QRCodeView;
import com.baidu.tieba.qrcode.lib.zxing.ZXingView;
/* loaded from: classes3.dex */
public class QRCodeScanActivity extends BaseActivity implements View.OnClickListener, a {
    private View aMS;
    private int eqv;
    private QRCodeView fTL;
    private TextView fTM;
    private b fTN;
    private View fTO;
    private TextView fTP;
    private TextView fTQ;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.eqv = TbadkCoreApplication.getInst().getSkinType();
        super.onCreate(bundle);
        setContentView(d.i.activity_qr_code_scan);
        this.fTL = (ZXingView) findViewById(d.g.zxingview);
        if (this.fTL.getScanBoxView() != null) {
            this.fTL.getScanBoxView().setToolbarHeight(UtilHelper.getStatusBarHeight());
            this.fTL.getScanBoxView().requestLayout();
        }
        this.mNavigationBar = (NavigationBar) findViewById(d.g.qrcode_navigation_bar);
        this.fTO = findViewById(d.g.qrcode_black_error_view);
        this.fTO.setOnClickListener(this);
        this.fTP = (TextView) findViewById(d.g.qrcode_error_tv_not_found);
        this.fTQ = (TextView) findViewById(d.g.qrcode_error_tv_tap_to_continue);
        this.fTM = this.mNavigationBar.setCenterTextTitle(getString(d.k.qrcode_title));
        this.aMS = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aMS.setOnClickListener(this);
        this.fTN = new b(this, getPageContext());
        this.fTL.setDelegate(this.fTN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.fTL.biy();
        this.fTL.biw();
        this.fTL.biz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        TbadkCoreApplication.getInst().setSkinTypeValue(this.eqv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        this.fTL.stopCamera();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaStatic.log(new al("c12707"));
        this.fTL.onDestroy();
        this.fTN.onDestroy();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.setBackgroundResource(d.f.transparent_bg);
        this.mNavigationBar.setmBackImageViewBg(d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
        this.fTM.setTextColor(getResources().getColor(d.C0126d.cp_cont_i));
        this.fTO.setBackgroundColor(getResources().getColor(d.C0126d.black_alpha80));
        this.fTP.setTextColor(getResources().getColor(d.C0126d.cp_cont_g));
        this.fTQ.setTextColor(getResources().getColor(d.C0126d.cp_cont_j));
        if (UtilHelper.isFlyMeOs()) {
            TbadkCoreApplication.getInst().setSkinTypeValue(1);
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bio() {
        biq();
        this.fTO.setVisibility(0);
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bip() {
        showProgressBar();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void biq() {
        hideProgressBar();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bir() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ay(true);
        aVar.ax(true);
        aVar.bY(d.k.confirm_title);
        aVar.dc(getString(d.k.qr_code_scan_tip));
        aVar.a(getPageContext().getString(d.k.confirm), new a.b() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                QRCodeScanActivity.this.fTL.biz();
                aVar2.dismiss();
            }
        });
        aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                QRCodeScanActivity.this.fTL.biz();
            }
        });
        aVar.b(getPageContext()).tD();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.aMS) {
            finish();
        } else if (view2 == this.fTO) {
            this.fTO.setVisibility(8);
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
                        O(intent);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void O(Intent intent) {
        ImageFileInfo imageFileInfo;
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            if (writeImagesInfo.getChosedFiles() != null && writeImagesInfo.getChosedFiles().size() > 0 && (imageFileInfo = writeImagesInfo.getChosedFiles().get(0)) != null) {
                this.fTN.rH(imageFileInfo.getFilePath());
            }
            writeImagesInfo.clear();
        }
    }
}
