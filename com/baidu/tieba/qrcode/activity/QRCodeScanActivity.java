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
    private View biG;
    private int flq;
    private TextView gMA;
    private QRCodeView gMv;
    private TextView gMw;
    private b gMx;
    private View gMy;
    private TextView gMz;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.flq = TbadkCoreApplication.getInst().getSkinType();
        super.onCreate(bundle);
        setContentView(e.h.activity_qr_code_scan);
        this.gMv = (ZXingView) findViewById(e.g.zxingview);
        if (this.gMv.getScanBoxView() != null) {
            this.gMv.getScanBoxView().setToolbarHeight(UtilHelper.getStatusBarHeight());
            this.gMv.getScanBoxView().requestLayout();
        }
        this.mNavigationBar = (NavigationBar) findViewById(e.g.qrcode_navigation_bar);
        this.gMy = findViewById(e.g.qrcode_black_error_view);
        this.gMy.setOnClickListener(this);
        this.gMz = (TextView) findViewById(e.g.qrcode_error_tv_not_found);
        this.gMA = (TextView) findViewById(e.g.qrcode_error_tv_tap_to_continue);
        this.gMw = this.mNavigationBar.setCenterTextTitle(getString(e.j.qrcode_title));
        this.biG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.biG.setOnClickListener(this);
        this.gMx = new b(this, getPageContext());
        this.gMv.setDelegate(this.gMx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.gMv.bvk();
        this.gMv.bvi();
        this.gMv.bvl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        TbadkCoreApplication.getInst().setSkinTypeValue(this.flq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        this.gMv.stopCamera();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaStatic.log(new am("c12707"));
        this.gMv.onDestroy();
        this.gMx.onDestroy();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.setBackgroundResource(e.f.transparent_bg);
        this.mNavigationBar.setmBackImageViewBg(e.f.btn_sml_back_selector_s, e.f.btn_sml_back_selector_s);
        this.gMw.setTextColor(getResources().getColor(e.d.cp_cont_i));
        this.gMy.setBackgroundColor(getResources().getColor(e.d.black_alpha80));
        this.gMz.setTextColor(getResources().getColor(e.d.cp_cont_g));
        this.gMA.setTextColor(getResources().getColor(e.d.cp_cont_j));
        if (UtilHelper.isFlyMeOs() && !UtilHelper.isMeizuE3()) {
            TbadkCoreApplication.getInst().setSkinTypeValue(1);
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void buZ() {
        bvb();
        this.gMy.setVisibility(0);
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bva() {
        showProgressBar();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bvb() {
        hideProgressBar();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bvc() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bn(true);
        aVar.bm(true);
        aVar.da(e.j.confirm_title);
        aVar.eK(getString(e.j.qr_code_scan_tip));
        aVar.a(getPageContext().getString(e.j.confirm), new a.b() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                QRCodeScanActivity.this.gMv.bvl();
                aVar2.dismiss();
            }
        });
        aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                QRCodeScanActivity.this.gMv.bvl();
            }
        });
        aVar.b(getPageContext()).BS();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.biG) {
            finish();
        } else if (view == this.gMy) {
            this.gMy.setVisibility(8);
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
                this.gMx.uH(imageFileInfo.getFilePath());
            }
            writeImagesInfo.clear();
        }
    }
}
