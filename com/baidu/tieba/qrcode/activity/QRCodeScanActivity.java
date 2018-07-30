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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.qrcode.lib.core.QRCodeView;
import com.baidu.tieba.qrcode.lib.zxing.ZXingView;
/* loaded from: classes3.dex */
public class QRCodeScanActivity extends BaseActivity implements View.OnClickListener, a {
    private View aVP;
    private int eKA;
    private QRCodeView gln;
    private TextView glo;
    private b glp;
    private View glq;
    private TextView glr;
    private TextView gls;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.eKA = TbadkCoreApplication.getInst().getSkinType();
        super.onCreate(bundle);
        setContentView(d.h.activity_qr_code_scan);
        this.gln = (ZXingView) findViewById(d.g.zxingview);
        if (this.gln.getScanBoxView() != null) {
            this.gln.getScanBoxView().setToolbarHeight(UtilHelper.getStatusBarHeight());
            this.gln.getScanBoxView().requestLayout();
        }
        this.mNavigationBar = (NavigationBar) findViewById(d.g.qrcode_navigation_bar);
        this.glq = findViewById(d.g.qrcode_black_error_view);
        this.glq.setOnClickListener(this);
        this.glr = (TextView) findViewById(d.g.qrcode_error_tv_not_found);
        this.gls = (TextView) findViewById(d.g.qrcode_error_tv_tap_to_continue);
        this.glo = this.mNavigationBar.setCenterTextTitle(getString(d.j.qrcode_title));
        this.aVP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aVP.setOnClickListener(this);
        this.glp = new b(this, getPageContext());
        this.gln.setDelegate(this.glp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.gln.bmE();
        this.gln.bmC();
        this.gln.bmF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        TbadkCoreApplication.getInst().setSkinTypeValue(this.eKA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        this.gln.stopCamera();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaStatic.log(new an("c12707"));
        this.gln.onDestroy();
        this.glp.onDestroy();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.setBackgroundResource(d.f.transparent_bg);
        this.mNavigationBar.setmBackImageViewBg(d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
        this.glo.setTextColor(getResources().getColor(d.C0140d.cp_cont_i));
        this.glq.setBackgroundColor(getResources().getColor(d.C0140d.black_alpha80));
        this.glr.setTextColor(getResources().getColor(d.C0140d.cp_cont_g));
        this.gls.setTextColor(getResources().getColor(d.C0140d.cp_cont_j));
        if (UtilHelper.isFlyMeOs()) {
            TbadkCoreApplication.getInst().setSkinTypeValue(1);
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bmu() {
        bmw();
        this.glq.setVisibility(0);
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bmv() {
        showProgressBar();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bmw() {
        hideProgressBar();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bmx() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.aB(true);
        aVar.aA(true);
        aVar.ce(d.j.confirm_title);
        aVar.dB(getString(d.j.qr_code_scan_tip));
        aVar.a(getPageContext().getString(d.j.confirm), new a.b() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                QRCodeScanActivity.this.gln.bmF();
                aVar2.dismiss();
            }
        });
        aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                QRCodeScanActivity.this.gln.bmF();
            }
        });
        aVar.b(getPageContext()).xf();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aVP) {
            finish();
        } else if (view == this.glq) {
            this.glq.setVisibility(8);
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
                this.glp.sw(imageFileInfo.getFilePath());
            }
            writeImagesInfo.clear();
        }
    }
}
