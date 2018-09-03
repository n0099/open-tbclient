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
import com.baidu.tieba.f;
import com.baidu.tieba.qrcode.lib.core.QRCodeView;
import com.baidu.tieba.qrcode.lib.zxing.ZXingView;
/* loaded from: classes3.dex */
public class QRCodeScanActivity extends BaseActivity implements View.OnClickListener, a {
    private View aVP;
    private int eKv;
    private QRCodeView glq;
    private TextView glr;
    private b gls;
    private View glt;
    private TextView glu;
    private TextView glv;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.eKv = TbadkCoreApplication.getInst().getSkinType();
        super.onCreate(bundle);
        setContentView(f.h.activity_qr_code_scan);
        this.glq = (ZXingView) findViewById(f.g.zxingview);
        if (this.glq.getScanBoxView() != null) {
            this.glq.getScanBoxView().setToolbarHeight(UtilHelper.getStatusBarHeight());
            this.glq.getScanBoxView().requestLayout();
        }
        this.mNavigationBar = (NavigationBar) findViewById(f.g.qrcode_navigation_bar);
        this.glt = findViewById(f.g.qrcode_black_error_view);
        this.glt.setOnClickListener(this);
        this.glu = (TextView) findViewById(f.g.qrcode_error_tv_not_found);
        this.glv = (TextView) findViewById(f.g.qrcode_error_tv_tap_to_continue);
        this.glr = this.mNavigationBar.setCenterTextTitle(getString(f.j.qrcode_title));
        this.aVP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aVP.setOnClickListener(this);
        this.gls = new b(this, getPageContext());
        this.glq.setDelegate(this.gls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.glq.bmF();
        this.glq.bmD();
        this.glq.bmG();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        TbadkCoreApplication.getInst().setSkinTypeValue(this.eKv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        this.glq.stopCamera();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaStatic.log(new an("c12707"));
        this.glq.onDestroy();
        this.gls.onDestroy();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.setBackgroundResource(f.C0146f.transparent_bg);
        this.mNavigationBar.setmBackImageViewBg(f.C0146f.btn_sml_back_selector_s, f.C0146f.btn_sml_back_selector_s);
        this.glr.setTextColor(getResources().getColor(f.d.cp_cont_i));
        this.glt.setBackgroundColor(getResources().getColor(f.d.black_alpha80));
        this.glu.setTextColor(getResources().getColor(f.d.cp_cont_g));
        this.glv.setTextColor(getResources().getColor(f.d.cp_cont_j));
        if (UtilHelper.isFlyMeOs()) {
            TbadkCoreApplication.getInst().setSkinTypeValue(1);
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void bmu() {
        bmw();
        this.glt.setVisibility(0);
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
        aVar.aC(true);
        aVar.aB(true);
        aVar.ce(f.j.confirm_title);
        aVar.dB(getString(f.j.qr_code_scan_tip));
        aVar.a(getPageContext().getString(f.j.confirm), new a.b() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                QRCodeScanActivity.this.glq.bmG();
                aVar2.dismiss();
            }
        });
        aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                QRCodeScanActivity.this.glq.bmG();
            }
        });
        aVar.b(getPageContext()).xe();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aVP) {
            finish();
        } else if (view == this.glt) {
            this.glt.setVisibility(8);
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
                this.gls.sA(imageFileInfo.getFilePath());
            }
            writeImagesInfo.clear();
        }
    }
}
