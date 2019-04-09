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
import com.baidu.tieba.d;
import com.baidu.tieba.qrcode.lib.core.QRCodeView;
import com.baidu.tieba.qrcode.lib.zxing.ZXingView;
/* loaded from: classes5.dex */
public class QRCodeScanActivity extends BaseActivity implements View.OnClickListener, a {
    private View csE;
    private int gBc;
    private QRCodeView idI;
    private TextView idJ;
    private b idK;
    private View idL;
    private TextView idM;
    private TextView idN;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.gBc = TbadkCoreApplication.getInst().getSkinType();
        super.onCreate(bundle);
        setContentView(d.h.activity_qr_code_scan);
        this.idI = (ZXingView) findViewById(d.g.zxingview);
        if (this.idI.getScanBoxView() != null) {
            this.idI.getScanBoxView().setToolbarHeight(UtilHelper.getStatusBarHeight());
            this.idI.getScanBoxView().requestLayout();
        }
        this.mNavigationBar = (NavigationBar) findViewById(d.g.qrcode_navigation_bar);
        this.idL = findViewById(d.g.qrcode_black_error_view);
        this.idL.setOnClickListener(this);
        this.idM = (TextView) findViewById(d.g.qrcode_error_tv_not_found);
        this.idN = (TextView) findViewById(d.g.qrcode_error_tv_tap_to_continue);
        this.idJ = this.mNavigationBar.setCenterTextTitle(getString(d.j.qrcode_title));
        this.csE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.csE.setOnClickListener(this);
        this.idK = new b(this, getPageContext());
        this.idI.setDelegate(this.idK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.idI.bVW();
        this.idI.bVU();
        this.idI.bVX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        TbadkCoreApplication.getInst().setSkinTypeValue(this.gBc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        this.idI.stopCamera();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaStatic.log(new am("c12707"));
        this.idI.onDestroy();
        this.idK.onDestroy();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.setBackgroundResource(d.f.transparent_bg);
        this.mNavigationBar.setmBackImageViewBg(d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
        this.idJ.setTextColor(getResources().getColor(d.C0277d.cp_btn_a));
        this.idL.setBackgroundColor(getResources().getColor(d.C0277d.black_alpha80));
        this.idM.setTextColor(getResources().getColor(d.C0277d.cp_cont_g));
        this.idN.setTextColor(getResources().getColor(d.C0277d.cp_cont_j));
        if (UtilHelper.isFlyMeOs() && !UtilHelper.isMeizuE3()) {
            TbadkCoreApplication.getInst().setSkinTypeValue(1);
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bVK() {
        bVM();
        this.idL.setVisibility(0);
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bVL() {
        showProgressBar();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bVM() {
        hideProgressBar();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bVN() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.dx(true);
        aVar.dw(true);
        aVar.gB(d.j.confirm_title);
        aVar.lz(getString(d.j.qr_code_scan_tip));
        aVar.a(getPageContext().getString(d.j.confirm), new a.b() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                QRCodeScanActivity.this.idI.bVX();
                aVar2.dismiss();
            }
        });
        aVar.b(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                QRCodeScanActivity.this.idI.bVX();
            }
        });
        aVar.b(getPageContext()).aaW();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.csE) {
            finish();
        } else if (view == this.idL) {
            this.idL.setVisibility(8);
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
                        aj(intent);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void aj(Intent intent) {
        ImageFileInfo imageFileInfo;
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            if (writeImagesInfo.getChosedFiles() != null && writeImagesInfo.getChosedFiles().size() > 0 && (imageFileInfo = writeImagesInfo.getChosedFiles().get(0)) != null) {
                this.idK.Bk(imageFileInfo.getFilePath());
            }
            writeImagesInfo.clear();
        }
    }
}
