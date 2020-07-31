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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
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
/* loaded from: classes17.dex */
public class QRCodeScanActivity extends BaseActivity<QRCodeScanActivity> implements View.OnClickListener, a {
    private View eJG;
    private int jtp;
    private ScanLoadingView liA;
    private boolean liB;
    private QRCodeView liv;
    private TextView liw;
    private ImageView lix;
    private b liy;
    private PopupWindow liz;
    private NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    Runnable liC = new Runnable() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.5
        @Override // java.lang.Runnable
        public void run() {
            if (!QRCodeScanActivity.this.isFinishing() && QRCodeScanActivity.this.liv.getScanBoxView() != null) {
                QRCodeScanActivity.this.liv.getScanBoxView().setQRCodeTipText(QRCodeScanActivity.this.getResources().getString(R.string.qr_code_scan_tip));
                QRCodeScanActivity.this.liv.getScanBoxView().setTipTextColor(QRCodeScanActivity.this.getResources().getColor(R.color.cp_bg_line_d));
                QRCodeScanActivity.this.liv.getScanBoxView().dbw();
            }
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.jtp = TbadkCoreApplication.getInst().getSkinType();
        super.onCreate(bundle);
        setContentView(R.layout.activity_qr_code_scan);
        if (getIntent() != null) {
            this.liB = getIntent().getBooleanExtra(QRCodeScanActivityConfig.IS_AIAPP, false);
        }
        this.liA = (ScanLoadingView) findViewById(R.id.loading_view);
        this.liv = (ZXingView) findViewById(R.id.zxingview);
        if (this.liv.getScanBoxView() != null) {
            this.liv.getScanBoxView().setToolbarHeight(UtilHelper.getStatusBarHeight());
            this.liv.getScanBoxView().requestLayout();
        }
        this.mNavigationBar = (NavigationBar) findViewById(R.id.qrcode_navigation_bar);
        this.liw = this.mNavigationBar.setCenterTextTitle(getString(R.string.qrcode_title));
        this.eJG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eJG.setOnClickListener(this);
        this.lix = new ImageView(this);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.rightMargin = l.getDimens(this, R.dimen.tbds18);
        this.lix.setLayoutParams(marginLayoutParams);
        SvgManager.baR().a(this.lix, R.drawable.icon_pure_topbar_image44_svg, R.color.white_alpha100, (SvgManager.SvgResourceStateType) null);
        this.lix.setScaleType(ImageView.ScaleType.FIT_XY);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.lix, this);
        this.liy = new b(this, getPageContext());
        this.liy.ux(this.liB);
        this.liv.setDelegate(this.liy);
        this.liy.dbg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.liv.dbp();
        this.liv.dbn();
        this.liv.dbq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        TbadkCoreApplication.getInst().setSkinTypeValue(this.jtp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        this.liv.stopCamera();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.liz != null && this.liz.isShowing()) {
            g.dismissPopupWindow(this.liz, this);
        }
        e.lt().removeCallbacks(this.liC);
        TiebaStatic.log(new ap("c12707"));
        this.liv.onDestroy();
        this.liy.onDestroy();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.setBackgroundResource(R.drawable.transparent_bg);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.baR().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.liw.setTextColor(getResources().getColor(R.color.cp_cont_a));
        if (UtilHelper.isFlyMeOs() && !UtilHelper.isMeizuE3() && !UtilHelper.isMeizuPro7Plus()) {
            TbadkCoreApplication.getInst().setSkinTypeValue(1);
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void fi(String str, String str2) {
        b(this.lix, str, str2);
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void dbb() {
        dbd();
        if (this.liv.getScanBoxView() != null) {
            this.liv.getScanBoxView().setQRCodeTipText(getResources().getString(R.string.qrcode_error_not_found));
            this.liv.getScanBoxView().setTipTextColor(getResources().getColor(R.color.cp_cont_h));
            this.liv.getScanBoxView().dbw();
        }
        e.lt().removeCallbacks(this.liC);
        e.lt().postDelayed(this.liC, 3000L);
        if (this.liv != null) {
            this.liv.dbq();
        }
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void dbc() {
        this.liA.showLoading();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void dbd() {
        this.liA.hideLoading();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void LY(final String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.setTitleShowCenter(true);
        aVar.xk(getString(R.string.qr_url_jump_external_title));
        aVar.setMessageShowCenter(true);
        aVar.xl(getString(R.string.qr_url_jump_external_message));
        aVar.lp(R.color.cp_cont_b);
        aVar.a(getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                QRCodeScanActivity.this.liy.openUrl(str);
            }
        });
        aVar.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                QRCodeScanActivity.this.liv.dbq();
                aVar2.dismiss();
            }
        });
        aVar.hJ(false);
        aVar.hK(false);
        aVar.b(getPageContext()).aYL();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void dbe() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.xk(null);
        aVar.setMessageShowCenter(true);
        aVar.xl(getString(R.string.qr_url_risk_forbid));
        aVar.a(getPageContext().getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                QRCodeScanActivity.this.liv.dbq();
                aVar2.dismiss();
            }
        });
        aVar.hJ(false);
        aVar.hK(false);
        aVar.b(getPageContext()).aYL();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eJG) {
            finish();
        } else if (view == this.lix) {
            this.writeImagesInfo.setFromQRCode(true);
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            if (!a(this, albumActivityConfig)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                TiebaStatic.log(new ap("c13409"));
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
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        Z(intent);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void Z(Intent intent) {
        ImageFileInfo imageFileInfo;
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            if (writeImagesInfo.getChosedFiles() != null && writeImagesInfo.getChosedFiles().size() > 0 && (imageFileInfo = writeImagesInfo.getChosedFiles().get(0)) != null) {
                this.liy.Me(imageFileInfo.getFilePath());
            }
            writeImagesInfo.clear();
        }
    }

    public void b(final View view, String str, final String str2) {
        if (view != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.liz != null && this.liz.isShowing()) {
                this.liz.dismiss();
            }
            View inflate = LayoutInflater.from(this).inflate(R.layout.popup_tip_image_layout, (ViewGroup) null);
            final ArrowView arrowView = (ArrowView) inflate.findViewById(R.id.tip_arrow);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.qr_image);
            tbImageView.setDrawBorder(true);
            tbImageView.setBorderWidth(1);
            tbImageView.setDrawCorner(true);
            tbImageView.setRadius(l.getDimens(this, R.dimen.tbds5));
            tbImageView.setConrers(15);
            ao.setViewTextColor((TextView) inflate.findViewById(R.id.qr_tip), R.color.cp_cont_f);
            tbImageView.startLoad(str, 36, false);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    g.dismissPopupWindow(QRCodeScanActivity.this.liz, QRCodeScanActivity.this);
                    if (QRCodeScanActivity.this.liy != null) {
                        QRCodeScanActivity.this.liy.LZ(str2);
                    }
                }
            });
            inflate.measure(0, 0);
            this.liz = new PopupWindow(getPageContext().getPageActivity());
            this.liz.setContentView(inflate);
            this.liz.setWidth(-2);
            this.liz.setHeight(-2);
            this.liz.setBackgroundDrawable(getPageContext().getResources().getDrawable(R.drawable.popup_window_transparent));
            this.liz.setOutsideTouchable(true);
            this.liz.setFocusable(false);
            this.liz.setTouchable(true);
            e.lt().post(new Runnable() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.7
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
                            g.showPopupWindowAtLocation(QRCodeScanActivity.this.liz, view, 0, i, measuredHeight);
                            e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (QRCodeScanActivity.this.liz != null && QRCodeScanActivity.this.liz.isShowing()) {
                                        g.dismissPopupWindow(QRCodeScanActivity.this.liz, QRCodeScanActivity.this);
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
