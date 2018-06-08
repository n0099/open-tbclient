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
/* loaded from: classes3.dex */
public class QRCodeScanActivity extends BaseActivity implements View.OnClickListener, a {
    private View aUR;
    private int eCQ;
    private QRCodeView ggd;
    private TextView gge;
    private b ggf;
    private View ggg;
    private TextView ggh;
    private TextView ggi;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.eCQ = TbadkCoreApplication.getInst().getSkinType();
        super.onCreate(bundle);
        setContentView(d.i.activity_qr_code_scan);
        this.ggd = (ZXingView) findViewById(d.g.zxingview);
        if (this.ggd.getScanBoxView() != null) {
            this.ggd.getScanBoxView().setToolbarHeight(UtilHelper.getStatusBarHeight());
            this.ggd.getScanBoxView().requestLayout();
        }
        this.mNavigationBar = (NavigationBar) findViewById(d.g.qrcode_navigation_bar);
        this.ggg = findViewById(d.g.qrcode_black_error_view);
        this.ggg.setOnClickListener(this);
        this.ggh = (TextView) findViewById(d.g.qrcode_error_tv_not_found);
        this.ggi = (TextView) findViewById(d.g.qrcode_error_tv_tap_to_continue);
        this.gge = this.mNavigationBar.setCenterTextTitle(getString(d.k.qrcode_title));
        this.aUR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aUR.setOnClickListener(this);
        this.ggf = new b(this, getPageContext());
        this.ggd.setDelegate(this.ggf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.ggd.bnw();
        this.ggd.bnu();
        this.ggd.bnx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        TbadkCoreApplication.getInst().setSkinTypeValue(this.eCQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        this.ggd.stopCamera();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaStatic.log(new am("c12707"));
        this.ggd.onDestroy();
        this.ggf.onDestroy();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.setBackgroundResource(d.f.transparent_bg);
        this.mNavigationBar.setmBackImageViewBg(d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
        this.gge.setTextColor(getResources().getColor(d.C0141d.cp_cont_i));
        this.ggg.setBackgroundColor(getResources().getColor(d.C0141d.black_alpha80));
        this.ggh.setTextColor(getResources().getColor(d.C0141d.cp_cont_g));
        this.ggi.setTextColor(getResources().getColor(d.C0141d.cp_cont_j));
        if (UtilHelper.isFlyMeOs()) {
            TbadkCoreApplication.getInst().setSkinTypeValue(1);
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bnm() {
        bno();
        this.ggg.setVisibility(0);
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bnn() {
        showProgressBar();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bno() {
        hideProgressBar();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bnp() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.aB(true);
        aVar.aA(true);
        aVar.cb(d.k.confirm_title);
        aVar.dB(getString(d.k.qr_code_scan_tip));
        aVar.a(getPageContext().getString(d.k.confirm), new a.b() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                QRCodeScanActivity.this.ggd.bnx();
                aVar2.dismiss();
            }
        });
        aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                QRCodeScanActivity.this.ggd.bnx();
            }
        });
        aVar.b(getPageContext()).xa();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aUR) {
            finish();
        } else if (view == this.ggg) {
            this.ggg.setVisibility(8);
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
                this.ggf.sC(imageFileInfo.getFilePath());
            }
            writeImagesInfo.clear();
        }
    }
}
