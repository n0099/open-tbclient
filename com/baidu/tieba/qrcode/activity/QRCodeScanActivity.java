package com.baidu.tieba.qrcode.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.c.a;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.qrcode.lib.core.QRCodeView;
import com.baidu.tieba.qrcode.lib.zxing.ZXingView;
import com.baidu.tieba.qrcode.view.ArrowView;
import com.baidu.tieba.qrcode.view.ScanLoadingView;
/* loaded from: classes5.dex */
public class QRCodeScanActivity extends BaseActivity<QRCodeScanActivity> implements View.OnClickListener, a {
    private View cOr;
    private int gZr;
    private PopupWindow iEA;
    private ScanLoadingView iEB;
    private boolean iEC;
    private QRCodeView iEw;
    private TextView iEx;
    private ImageView iEy;
    private b iEz;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgePolicy;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    Runnable iED = new Runnable() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.5
        @Override // java.lang.Runnable
        public void run() {
            if (!QRCodeScanActivity.this.isFinishing() && QRCodeScanActivity.this.iEw.getScanBoxView() != null) {
                QRCodeScanActivity.this.iEw.getScanBoxView().setQRCodeTipText(QRCodeScanActivity.this.getResources().getString(R.string.qr_code_scan_tip));
                QRCodeScanActivity.this.iEw.getScanBoxView().setTipTextColor(QRCodeScanActivity.this.getResources().getColor(R.color.cp_bg_line_d));
                QRCodeScanActivity.this.iEw.getScanBoxView().cfg();
            }
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.gZr = TbadkCoreApplication.getInst().getSkinType();
        super.onCreate(bundle);
        setContentView(R.layout.activity_qr_code_scan);
        if (getIntent() != null) {
            this.iEC = getIntent().getBooleanExtra(QRCodeScanActivityConfig.IS_AIAPP, false);
        }
        this.iEB = (ScanLoadingView) findViewById(R.id.loading_view);
        this.iEw = (ZXingView) findViewById(R.id.zxingview);
        if (this.iEw.getScanBoxView() != null) {
            this.iEw.getScanBoxView().setToolbarHeight(UtilHelper.getStatusBarHeight());
            this.iEw.getScanBoxView().requestLayout();
        }
        this.mNavigationBar = (NavigationBar) findViewById(R.id.qrcode_navigation_bar);
        this.iEx = this.mNavigationBar.setCenterTextTitle(getString(R.string.qrcode_title));
        this.cOr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cOr.setOnClickListener(this);
        this.iEy = new ImageView(this);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.rightMargin = l.getDimens(this, R.dimen.tbds18);
        this.iEy.setLayoutParams(marginLayoutParams);
        SvgManager.amN().a(this.iEy, R.drawable.icon_pure_topbar_image_n_svg, R.color.white_alpha100, null);
        this.iEy.setScaleType(ImageView.ScaleType.FIT_XY);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iEy, this);
        this.iEz = new b(this, getPageContext());
        this.iEz.pY(this.iEC);
        this.iEw.setDelegate(this.iEz);
        this.iEz.ceQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.iEw.ceZ();
        this.iEw.ceX();
        this.iEw.cfa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        TbadkCoreApplication.getInst().setSkinTypeValue(this.gZr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        this.iEw.stopCamera();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.iEA != null && this.iEA.isShowing()) {
            g.dismissPopupWindow(this.iEA, this);
        }
        e.fZ().removeCallbacks(this.iED);
        TiebaStatic.log(new an("c12707"));
        this.iEw.onDestroy();
        this.iEz.onDestroy();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.setBackgroundResource(R.drawable.transparent_bg);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.amN().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.iEx.setTextColor(getResources().getColor(R.color.cp_cont_a));
        if (UtilHelper.isFlyMeOs() && !UtilHelper.isMeizuE3()) {
            TbadkCoreApplication.getInst().setSkinTypeValue(1);
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void dH(String str, String str2) {
        c(this.iEy, str, str2);
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void ceL() {
        ceN();
        if (this.iEw.getScanBoxView() != null) {
            this.iEw.getScanBoxView().setQRCodeTipText(getResources().getString(R.string.qrcode_error_not_found));
            this.iEw.getScanBoxView().setTipTextColor(getResources().getColor(R.color.cp_cont_h));
            this.iEw.getScanBoxView().cfg();
        }
        e.fZ().removeCallbacks(this.iED);
        e.fZ().postDelayed(this.iED, 3000L);
        if (this.iEw != null) {
            this.iEw.cfa();
        }
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void ceM() {
        this.iEB.showLoading();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void ceN() {
        this.iEB.boQ();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void Ch(final String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.setTitleShowCenter(true);
        aVar.nm(getString(R.string.qr_url_jump_external_title));
        aVar.setMessageShowCenter(true);
        aVar.nn(getString(R.string.qr_url_jump_external_message));
        aVar.hW(R.color.cp_cont_b);
        aVar.a(getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                QRCodeScanActivity.this.iEz.openUrl(str);
            }
        });
        aVar.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                QRCodeScanActivity.this.iEw.cfa();
                aVar2.dismiss();
            }
        });
        aVar.eg(false);
        aVar.eh(false);
        aVar.b(getPageContext()).akO();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void ceO() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.nm(null);
        aVar.setMessageShowCenter(true);
        aVar.nn(getString(R.string.qr_url_risk_forbid));
        aVar.a(getPageContext().getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                QRCodeScanActivity.this.iEw.cfa();
                aVar2.dismiss();
            }
        });
        aVar.eg(false);
        aVar.eh(false);
        aVar.b(getPageContext()).akO();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cOr) {
            finish();
        } else if (view == this.iEy) {
            this.writeImagesInfo.setFromQRCode(true);
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            if (!a(this, albumActivityConfig)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                TiebaStatic.log(new an("c13409"));
            }
        }
    }

    private boolean a(Activity activity, final AlbumActivityConfig albumActivityConfig) {
        if (this.mPermissionJudgePolicy == null) {
            this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.c.a();
        }
        this.mPermissionJudgePolicy.clearRequestPermissionList();
        this.mPermissionJudgePolicy.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        this.mPermissionJudgePolicy.a(new a.InterfaceC0284a() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.4
            @Override // com.baidu.tbadk.core.util.c.a.InterfaceC0284a
            public void onPermissionsGranted() {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
            }
        });
        return this.mPermissionJudgePolicy.startRequestPermission(activity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        aw(intent);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void aw(Intent intent) {
        ImageFileInfo imageFileInfo;
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            if (writeImagesInfo.getChosedFiles() != null && writeImagesInfo.getChosedFiles().size() > 0 && (imageFileInfo = writeImagesInfo.getChosedFiles().get(0)) != null) {
                this.iEz.Cn(imageFileInfo.getFilePath());
            }
            writeImagesInfo.clear();
        }
    }

    public void c(final View view, String str, final String str2) {
        if (view != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.iEA != null && this.iEA.isShowing()) {
                this.iEA.dismiss();
            }
            View inflate = LayoutInflater.from(this).inflate(R.layout.popup_tip_image_layout, (ViewGroup) null);
            final ArrowView arrowView = (ArrowView) inflate.findViewById(R.id.tip_arrow);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.qr_image);
            tbImageView.setDrawBorder(true);
            tbImageView.setBorderWidth(1);
            tbImageView.setDrawCorner(true);
            tbImageView.setRadius(l.getDimens(this, R.dimen.tbds5));
            tbImageView.setConrers(15);
            am.setViewTextColor((TextView) inflate.findViewById(R.id.qr_tip), (int) R.color.cp_cont_f);
            tbImageView.startLoad(str, 36, false);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    g.dismissPopupWindow(QRCodeScanActivity.this.iEA, QRCodeScanActivity.this);
                    if (QRCodeScanActivity.this.iEz != null) {
                        QRCodeScanActivity.this.iEz.Ci(str2);
                    }
                }
            });
            inflate.measure(0, 0);
            this.iEA = new PopupWindow(getPageContext().getPageActivity());
            this.iEA.setContentView(inflate);
            this.iEA.setWidth(-2);
            this.iEA.setHeight(-2);
            this.iEA.setBackgroundDrawable(getPageContext().getResources().getDrawable(R.drawable.popup_window_transparent));
            this.iEA.setOutsideTouchable(true);
            this.iEA.setFocusable(false);
            this.iEA.setTouchable(true);
            e.fZ().post(new Runnable() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.7
                @Override // java.lang.Runnable
                public void run() {
                    int[] iArr = new int[2];
                    view.getLocationOnScreen(iArr);
                    int i = iArr[0];
                    int measuredHeight = (iArr[1] + view.getMeasuredHeight()) - l.getDimens(QRCodeScanActivity.this, R.dimen.tbds12);
                    int equipmentWidth = l.getEquipmentWidth(QRCodeScanActivity.this);
                    if (i > 0 && equipmentWidth > 0 && equipmentWidth > i && (view.getParent() instanceof View)) {
                        int abs = (((equipmentWidth - Math.abs(((View) view.getParent()).getLeft())) - (view.getMeasuredWidth() / 2)) - l.getDimens(QRCodeScanActivity.this, R.dimen.tbds17)) - (l.getDimens(QRCodeScanActivity.this, R.dimen.tbds26) / 2);
                        if (arrowView.getLayoutParams() != null && (arrowView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                            ((ViewGroup.MarginLayoutParams) arrowView.getLayoutParams()).rightMargin = abs;
                            g.showPopupWindowAtLocation(QRCodeScanActivity.this.iEA, view, 0, i, measuredHeight);
                            e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (QRCodeScanActivity.this.iEA != null && QRCodeScanActivity.this.iEA.isShowing()) {
                                        QRCodeScanActivity.this.iEA.dismiss();
                                    }
                                }
                            }, 3000L);
                        }
                    }
                }
            });
        }
    }
}
