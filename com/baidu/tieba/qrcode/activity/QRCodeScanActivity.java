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
    private View bhS;
    private int fhC;
    private QRCodeView gIA;
    private TextView gIB;
    private b gIC;
    private View gID;
    private TextView gIE;
    private TextView gIF;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.fhC = TbadkCoreApplication.getInst().getSkinType();
        super.onCreate(bundle);
        setContentView(e.h.activity_qr_code_scan);
        this.gIA = (ZXingView) findViewById(e.g.zxingview);
        if (this.gIA.getScanBoxView() != null) {
            this.gIA.getScanBoxView().setToolbarHeight(UtilHelper.getStatusBarHeight());
            this.gIA.getScanBoxView().requestLayout();
        }
        this.mNavigationBar = (NavigationBar) findViewById(e.g.qrcode_navigation_bar);
        this.gID = findViewById(e.g.qrcode_black_error_view);
        this.gID.setOnClickListener(this);
        this.gIE = (TextView) findViewById(e.g.qrcode_error_tv_not_found);
        this.gIF = (TextView) findViewById(e.g.qrcode_error_tv_tap_to_continue);
        this.gIB = this.mNavigationBar.setCenterTextTitle(getString(e.j.qrcode_title));
        this.bhS = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bhS.setOnClickListener(this);
        this.gIC = new b(this, getPageContext());
        this.gIA.setDelegate(this.gIC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.gIA.btP();
        this.gIA.btN();
        this.gIA.btQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        TbadkCoreApplication.getInst().setSkinTypeValue(this.fhC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        this.gIA.stopCamera();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaStatic.log(new am("c12707"));
        this.gIA.onDestroy();
        this.gIC.onDestroy();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.setBackgroundResource(e.f.transparent_bg);
        this.mNavigationBar.setmBackImageViewBg(e.f.btn_sml_back_selector_s, e.f.btn_sml_back_selector_s);
        this.gIB.setTextColor(getResources().getColor(e.d.cp_cont_i));
        this.gID.setBackgroundColor(getResources().getColor(e.d.black_alpha80));
        this.gIE.setTextColor(getResources().getColor(e.d.cp_cont_g));
        this.gIF.setTextColor(getResources().getColor(e.d.cp_cont_j));
        if (UtilHelper.isFlyMeOs() && !UtilHelper.isMeizuE3()) {
            TbadkCoreApplication.getInst().setSkinTypeValue(1);
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void btE() {
        btG();
        this.gID.setVisibility(0);
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void btF() {
        showProgressBar();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void btG() {
        hideProgressBar();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void btH() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bm(true);
        aVar.bl(true);
        aVar.da(e.j.confirm_title);
        aVar.eB(getString(e.j.qr_code_scan_tip));
        aVar.a(getPageContext().getString(e.j.confirm), new a.b() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                QRCodeScanActivity.this.gIA.btQ();
                aVar2.dismiss();
            }
        });
        aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                QRCodeScanActivity.this.gIA.btQ();
            }
        });
        aVar.b(getPageContext()).BF();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bhS) {
            finish();
        } else if (view == this.gID) {
            this.gID.setVisibility(8);
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
                this.gIC.uo(imageFileInfo.getFilePath());
            }
            writeImagesInfo.clear();
        }
    }
}
