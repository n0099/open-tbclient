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
    private View csB;
    private int gBn;
    private QRCodeView idV;
    private TextView idW;
    private b idX;
    private View idY;
    private TextView idZ;
    private TextView iea;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.gBn = TbadkCoreApplication.getInst().getSkinType();
        super.onCreate(bundle);
        setContentView(d.h.activity_qr_code_scan);
        this.idV = (ZXingView) findViewById(d.g.zxingview);
        if (this.idV.getScanBoxView() != null) {
            this.idV.getScanBoxView().setToolbarHeight(UtilHelper.getStatusBarHeight());
            this.idV.getScanBoxView().requestLayout();
        }
        this.mNavigationBar = (NavigationBar) findViewById(d.g.qrcode_navigation_bar);
        this.idY = findViewById(d.g.qrcode_black_error_view);
        this.idY.setOnClickListener(this);
        this.idZ = (TextView) findViewById(d.g.qrcode_error_tv_not_found);
        this.iea = (TextView) findViewById(d.g.qrcode_error_tv_tap_to_continue);
        this.idW = this.mNavigationBar.setCenterTextTitle(getString(d.j.qrcode_title));
        this.csB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.csB.setOnClickListener(this);
        this.idX = new b(this, getPageContext());
        this.idV.setDelegate(this.idX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.idV.bWa();
        this.idV.bVY();
        this.idV.bWb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        TbadkCoreApplication.getInst().setSkinTypeValue(this.gBn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        this.idV.stopCamera();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaStatic.log(new am("c12707"));
        this.idV.onDestroy();
        this.idX.onDestroy();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.setBackgroundResource(d.f.transparent_bg);
        this.mNavigationBar.setmBackImageViewBg(d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
        this.idW.setTextColor(getResources().getColor(d.C0277d.cp_btn_a));
        this.idY.setBackgroundColor(getResources().getColor(d.C0277d.black_alpha80));
        this.idZ.setTextColor(getResources().getColor(d.C0277d.cp_cont_g));
        this.iea.setTextColor(getResources().getColor(d.C0277d.cp_cont_j));
        if (UtilHelper.isFlyMeOs() && !UtilHelper.isMeizuE3()) {
            TbadkCoreApplication.getInst().setSkinTypeValue(1);
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bVO() {
        bVQ();
        this.idY.setVisibility(0);
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bVP() {
        showProgressBar();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bVQ() {
        hideProgressBar();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bVR() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.dx(true);
        aVar.dw(true);
        aVar.gC(d.j.confirm_title);
        aVar.ly(getString(d.j.qr_code_scan_tip));
        aVar.a(getPageContext().getString(d.j.confirm), new a.b() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                QRCodeScanActivity.this.idV.bWb();
                aVar2.dismiss();
            }
        });
        aVar.b(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                QRCodeScanActivity.this.idV.bWb();
            }
        });
        aVar.b(getPageContext()).aaZ();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.csB) {
            finish();
        } else if (view == this.idY) {
            this.idY.setVisibility(8);
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
                this.idX.Bl(imageFileInfo.getFilePath());
            }
            writeImagesInfo.clear();
        }
    }
}
