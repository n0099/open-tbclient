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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.qrcode.lib.a.e;
import com.baidu.tieba.qrcode.lib.zxing.ZXingView;
/* loaded from: classes3.dex */
public class QRCodeScanActivity extends BaseActivity implements View.OnClickListener, a {
    private View bCs;
    private int eVP;
    private e gyY;
    private TextView gyZ;
    private b gza;
    private View gzb;
    private TextView gzc;
    private TextView gzd;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.eVP = TbadkCoreApplication.getInst().getSkinType();
        super.onCreate(bundle);
        setContentView(d.h.activity_qr_code_scan);
        this.gyY = (ZXingView) findViewById(d.g.zxingview);
        if (this.gyY.getScanBoxView() != null) {
            this.gyY.getScanBoxView().setToolbarHeight(UtilHelper.getStatusBarHeight());
            this.gyY.getScanBoxView().requestLayout();
        }
        this.mNavigationBar = (NavigationBar) findViewById(d.g.qrcode_navigation_bar);
        this.gzb = findViewById(d.g.qrcode_black_error_view);
        this.gzb.setOnClickListener(this);
        this.gzc = (TextView) findViewById(d.g.qrcode_error_tv_not_found);
        this.gzd = (TextView) findViewById(d.g.qrcode_error_tv_tap_to_continue);
        this.gyZ = this.mNavigationBar.setCenterTextTitle(getString(d.j.qrcode_title));
        this.bCs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bCs.setOnClickListener(this);
        this.gza = new b(this, getPageContext());
        this.gyY.setDelegate(this.gza);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.gyY.bns();
        this.gyY.bnq();
        this.gyY.bnt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        TbadkCoreApplication.getInst().setSkinTypeValue(this.eVP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        this.gyY.stopCamera();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaStatic.log(new ak("c12707"));
        this.gyY.onDestroy();
        this.gza.onDestroy();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.setBackgroundResource(d.f.transparent_bg);
        this.mNavigationBar.setmBackImageViewBg(d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
        this.gyZ.setTextColor(getResources().getColor(d.C0141d.cp_cont_i));
        this.gzb.setBackgroundColor(getResources().getColor(d.C0141d.black_alpha80));
        this.gzc.setTextColor(getResources().getColor(d.C0141d.cp_cont_g));
        this.gzd.setTextColor(getResources().getColor(d.C0141d.cp_cont_j));
        if (UtilHelper.isFlyMeOs()) {
            TbadkCoreApplication.getInst().setSkinTypeValue(1);
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bni() {
        bnk();
        this.gzb.setVisibility(0);
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bnj() {
        showProgressBar();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bnk() {
        hideProgressBar();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bnl() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bg(true);
        aVar.bf(true);
        aVar.fa(d.j.confirm_title);
        aVar.dk(getString(d.j.qr_code_scan_tip));
        aVar.a(getPageContext().getString(d.j.confirm), new a.b() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                QRCodeScanActivity.this.gyY.bnt();
                aVar2.dismiss();
            }
        });
        aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                QRCodeScanActivity.this.gyY.bnt();
            }
        });
        aVar.b(getPageContext()).AV();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bCs) {
            finish();
        } else if (view == this.gzb) {
            this.gzb.setVisibility(8);
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
                        P(intent);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void P(Intent intent) {
        ImageFileInfo imageFileInfo;
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            if (writeImagesInfo.getChosedFiles() != null && writeImagesInfo.getChosedFiles().size() > 0 && (imageFileInfo = writeImagesInfo.getChosedFiles().get(0)) != null) {
                this.gza.rB(imageFileInfo.getFilePath());
            }
            writeImagesInfo.clear();
        }
    }
}
