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
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.qrcode.lib.core.QRCodeView;
import com.baidu.tieba.qrcode.lib.zxing.ZXingView;
import com.baidu.tieba.qrcode.view.ArrowView;
import com.baidu.tieba.qrcode.view.ScanLoadingView;
/* loaded from: classes8.dex */
public class QRCodeScanActivity extends BaseActivity<QRCodeScanActivity> implements View.OnClickListener, a {
    private View fLW;
    private int kVi;
    private NavigationBar mNavigationBar;
    private QRCodeView mOi;
    private TextView mOj;
    private ImageView mOk;
    private b mOl;
    private PopupWindow mOm;
    private ScanLoadingView mOn;
    private boolean mOo;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    Runnable mOp = new Runnable() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.5
        @Override // java.lang.Runnable
        public void run() {
            if (!QRCodeScanActivity.this.isFinishing() && QRCodeScanActivity.this.mOi.getScanBoxView() != null) {
                QRCodeScanActivity.this.mOi.getScanBoxView().setQRCodeTipText(QRCodeScanActivity.this.getResources().getString(R.string.qr_code_scan_tip));
                QRCodeScanActivity.this.mOi.getScanBoxView().setTipTextColor(QRCodeScanActivity.this.getResources().getColor(R.color.CAM_X0201));
                QRCodeScanActivity.this.mOi.getScanBoxView().dCL();
            }
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.kVi = TbadkCoreApplication.getInst().getSkinType();
        super.onCreate(bundle);
        setContentView(R.layout.activity_qr_code_scan);
        if (getIntent() != null) {
            this.mOo = getIntent().getBooleanExtra(QRCodeScanActivityConfig.IS_AIAPP, false);
        }
        this.mOn = (ScanLoadingView) findViewById(R.id.loading_view);
        this.mOi = (ZXingView) findViewById(R.id.zxingview);
        if (this.mOi.getScanBoxView() != null) {
            this.mOi.getScanBoxView().setToolbarHeight(UtilHelper.getStatusBarHeight());
            this.mOi.getScanBoxView().requestLayout();
        }
        this.mNavigationBar = (NavigationBar) findViewById(R.id.qrcode_navigation_bar);
        this.mOj = this.mNavigationBar.setCenterTextTitle(getString(R.string.qrcode_title));
        this.fLW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fLW.setOnClickListener(this);
        this.mOk = new ImageView(this);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.rightMargin = l.getDimens(this, R.dimen.tbds18);
        this.mOk.setLayoutParams(marginLayoutParams);
        SvgManager.bsR().a(this.mOk, R.drawable.icon_pure_topbar_image44_svg, R.color.white_alpha100, (SvgManager.SvgResourceStateType) null);
        this.mOk.setScaleType(ImageView.ScaleType.FIT_XY);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mOk, this);
        this.mOl = new b(this, getPageContext());
        this.mOl.xw(this.mOo);
        this.mOi.setDelegate(this.mOl);
        this.mOl.dCv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mOi.dCE();
        this.mOi.dCC();
        this.mOi.dCF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        TbadkCoreApplication.getInst().setSkinTypeValue(this.kVi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        this.mOi.stopCamera();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mOm != null && this.mOm.isShowing()) {
            g.dismissPopupWindow(this.mOm, this);
        }
        e.mA().removeCallbacks(this.mOp);
        TiebaStatic.log(new ar("c12707"));
        this.mOi.onDestroy();
        this.mOl.onDestroy();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.setBackgroundResource(R.drawable.transparent_bg);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bsR().a(this.mNavigationBar.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mOj.setTextColor(getResources().getColor(R.color.CAM_X0101));
        if (UtilHelper.isFlyMeOs() && !UtilHelper.isMeizuE3() && !UtilHelper.isMeizuPro7Plus()) {
            TbadkCoreApplication.getInst().setSkinTypeValue(1);
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void ga(String str, String str2) {
        b(this.mOk, str, str2);
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void dCq() {
        dCs();
        if (this.mOi.getScanBoxView() != null) {
            this.mOi.getScanBoxView().setQRCodeTipText(getResources().getString(R.string.qrcode_error_not_found));
            this.mOi.getScanBoxView().setTipTextColor(getResources().getColor(R.color.CAM_X0301));
            this.mOi.getScanBoxView().dCL();
        }
        e.mA().removeCallbacks(this.mOp);
        e.mA().postDelayed(this.mOp, IMConnection.RETRY_DELAY_TIMES);
        if (this.mOi != null) {
            this.mOi.dCF();
        }
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void dCr() {
        this.mOn.showLoading();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void dCs() {
        this.mOn.hideLoading();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void QR(final String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.setTitleShowCenter(true);
        aVar.At(getString(R.string.qr_url_jump_external_title));
        aVar.setMessageShowCenter(true);
        aVar.Au(getString(R.string.qr_url_jump_external_message));
        aVar.nz(R.color.CAM_X0105);
        aVar.a(getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                QRCodeScanActivity.this.mOl.openUrl(str);
            }
        });
        aVar.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                QRCodeScanActivity.this.mOi.dCF();
                aVar2.dismiss();
            }
        });
        aVar.jF(false);
        aVar.jG(false);
        aVar.b(getPageContext()).bqx();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void dCt() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.At(null);
        aVar.setMessageShowCenter(true);
        aVar.Au(getString(R.string.qr_url_risk_forbid));
        aVar.a(getPageContext().getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                QRCodeScanActivity.this.mOi.dCF();
                aVar2.dismiss();
            }
        });
        aVar.jF(false);
        aVar.jG(false);
        aVar.b(getPageContext()).bqx();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fLW) {
            finish();
        } else if (view == this.mOk) {
            this.writeImagesInfo.setFromQRCode(true);
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(12002);
            if (!a(this, albumActivityConfig)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                TiebaStatic.log(new ar("c13409"));
            }
        }
    }

    private boolean a(Activity activity, final AlbumActivityConfig albumActivityConfig) {
        if (this.mPermissionJudgePolicy == null) {
            this.mPermissionJudgePolicy = new PermissionJudgePolicy();
        }
        this.mPermissionJudgePolicy.clearRequestPermissionList();
        this.mPermissionJudgePolicy.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        this.mPermissionJudgePolicy.a(new PermissionJudgePolicy.b() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.4
            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.b
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
                case 12002:
                    if (intent != null) {
                        af(intent);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void af(Intent intent) {
        ImageFileInfo imageFileInfo;
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            if (writeImagesInfo.getChosedFiles() != null && writeImagesInfo.getChosedFiles().size() > 0 && (imageFileInfo = writeImagesInfo.getChosedFiles().get(0)) != null) {
                this.mOl.QX(imageFileInfo.getFilePath());
            }
            writeImagesInfo.clear();
        }
    }

    public void b(final View view, String str, final String str2) {
        if (view != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.mOm != null && this.mOm.isShowing()) {
                this.mOm.dismiss();
            }
            View inflate = LayoutInflater.from(this).inflate(R.layout.popup_tip_image_layout, (ViewGroup) null);
            final ArrowView arrowView = (ArrowView) inflate.findViewById(R.id.tip_arrow);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.qr_image);
            tbImageView.setDrawBorder(true);
            tbImageView.setBorderWidth(1);
            tbImageView.setDrawCorner(true);
            tbImageView.setRadius(l.getDimens(this, R.dimen.tbds5));
            tbImageView.setConrers(15);
            ap.setViewTextColor((TextView) inflate.findViewById(R.id.qr_tip), R.color.CAM_X0106);
            tbImageView.startLoad(str, 36, false);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    g.dismissPopupWindow(QRCodeScanActivity.this.mOm, QRCodeScanActivity.this);
                    if (QRCodeScanActivity.this.mOl != null) {
                        QRCodeScanActivity.this.mOl.QS(str2);
                    }
                }
            });
            inflate.measure(0, 0);
            this.mOm = new PopupWindow(getPageContext().getPageActivity());
            this.mOm.setContentView(inflate);
            this.mOm.setWidth(-2);
            this.mOm.setHeight(-2);
            this.mOm.setBackgroundDrawable(getPageContext().getResources().getDrawable(R.drawable.popup_window_transparent));
            this.mOm.setOutsideTouchable(true);
            this.mOm.setFocusable(false);
            this.mOm.setTouchable(true);
            e.mA().post(new Runnable() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.7
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
                            g.showPopupWindowAtLocation(QRCodeScanActivity.this.mOm, view, 0, i, measuredHeight);
                            e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (QRCodeScanActivity.this.mOm != null && QRCodeScanActivity.this.mOm.isShowing()) {
                                        g.dismissPopupWindow(QRCodeScanActivity.this.mOm, QRCodeScanActivity.this);
                                    }
                                }
                            }, IMConnection.RETRY_DELAY_TIMES);
                        }
                    }
                }
            });
        }
    }
}
