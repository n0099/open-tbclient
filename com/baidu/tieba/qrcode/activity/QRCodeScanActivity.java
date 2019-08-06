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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.b.a;
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
    private View cCm;
    private int gZu;
    private QRCodeView iDJ;
    private TextView iDK;
    private ImageView iDL;
    private b iDM;
    private PopupWindow iDN;
    private ScanLoadingView iDO;
    private boolean iDP;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    Runnable iDQ = new Runnable() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.5
        @Override // java.lang.Runnable
        public void run() {
            if (!QRCodeScanActivity.this.isFinishing() && QRCodeScanActivity.this.iDJ.getScanBoxView() != null) {
                QRCodeScanActivity.this.iDJ.getScanBoxView().setQRCodeTipText(QRCodeScanActivity.this.getResources().getString(R.string.qr_code_scan_tip));
                QRCodeScanActivity.this.iDJ.getScanBoxView().setTipTextColor(QRCodeScanActivity.this.getResources().getColor(R.color.cp_bg_line_d));
                QRCodeScanActivity.this.iDJ.getScanBoxView().cht();
            }
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.gZu = TbadkCoreApplication.getInst().getSkinType();
        super.onCreate(bundle);
        setContentView(R.layout.activity_qr_code_scan);
        if (getIntent() != null) {
            this.iDP = getIntent().getBooleanExtra(QRCodeScanActivityConfig.IS_AIAPP, false);
        }
        this.iDO = (ScanLoadingView) findViewById(R.id.loading_view);
        this.iDJ = (ZXingView) findViewById(R.id.zxingview);
        if (this.iDJ.getScanBoxView() != null) {
            this.iDJ.getScanBoxView().setToolbarHeight(UtilHelper.getStatusBarHeight());
            this.iDJ.getScanBoxView().requestLayout();
        }
        this.mNavigationBar = (NavigationBar) findViewById(R.id.qrcode_navigation_bar);
        this.iDK = this.mNavigationBar.setCenterTextTitle(getString(R.string.qrcode_title));
        this.cCm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cCm.setOnClickListener(this);
        this.iDL = new ImageView(this);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.rightMargin = l.g(this, R.dimen.tbds18);
        this.iDL.setLayoutParams(marginLayoutParams);
        this.iDL.setImageResource(R.drawable.icon_sweep_image_n);
        this.iDL.setScaleType(ImageView.ScaleType.FIT_XY);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iDL, this);
        this.iDM = new b(this, getPageContext());
        this.iDM.qo(this.iDP);
        this.iDJ.setDelegate(this.iDM);
        this.iDM.chd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.iDJ.chm();
        this.iDJ.chk();
        this.iDJ.chn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        TbadkCoreApplication.getInst().setSkinTypeValue(this.gZu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        this.iDJ.stopCamera();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.iDN != null && this.iDN.isShowing()) {
            g.a(this.iDN, this);
        }
        e.iK().removeCallbacks(this.iDQ);
        TiebaStatic.log(new an("c12707"));
        this.iDJ.onDestroy();
        this.iDM.onDestroy();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.setBackgroundResource(R.drawable.transparent_bg);
        this.mNavigationBar.setmBackImageViewBg(R.drawable.btn_sml_back_selector_s, R.drawable.btn_sml_back_selector_s);
        this.iDK.setTextColor(getResources().getColor(R.color.cp_btn_a));
        if (UtilHelper.isFlyMeOs() && !UtilHelper.isMeizuE3()) {
            TbadkCoreApplication.getInst().setSkinTypeValue(1);
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void dU(String str, String str2) {
        b(this.iDL, str, str2);
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void cgY() {
        cha();
        if (this.iDJ.getScanBoxView() != null) {
            this.iDJ.getScanBoxView().setQRCodeTipText(getResources().getString(R.string.qrcode_error_not_found));
            this.iDJ.getScanBoxView().setTipTextColor(getResources().getColor(R.color.cp_cont_h));
            this.iDJ.getScanBoxView().cht();
        }
        e.iK().removeCallbacks(this.iDQ);
        e.iK().postDelayed(this.iDQ, 3000L);
        if (this.iDJ != null) {
            this.iDJ.chn();
        }
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void cgZ() {
        this.iDO.showLoading();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void cha() {
        this.iDO.brb();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void Dp(final String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.dX(true);
        aVar.mN(getString(R.string.qr_url_jump_external_title));
        aVar.dW(true);
        aVar.mO(getString(R.string.qr_url_jump_external_message));
        aVar.hw(R.color.cp_cont_b);
        aVar.a(getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                QRCodeScanActivity.this.iDM.openUrl(str);
            }
        });
        aVar.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                QRCodeScanActivity.this.iDJ.chn();
                aVar2.dismiss();
            }
        });
        aVar.dQ(false);
        aVar.dR(false);
        aVar.b(getPageContext()).agK();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void chb() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.mN(null);
        aVar.dW(true);
        aVar.mO(getString(R.string.qr_url_risk_forbid));
        aVar.a(getPageContext().getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                QRCodeScanActivity.this.iDJ.chn();
                aVar2.dismiss();
            }
        });
        aVar.dQ(false);
        aVar.dR(false);
        aVar.b(getPageContext()).agK();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cCm) {
            finish();
        } else if (view == this.iDL) {
            this.writeImagesInfo.setFromQRCode(true);
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(12002);
            if (!a(this, albumActivityConfig)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                TiebaStatic.log(new an("c13409"));
            }
        }
    }

    private boolean a(Activity activity, final AlbumActivityConfig albumActivityConfig) {
        if (this.mPermissionJudgePolicy == null) {
            this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
        }
        this.mPermissionJudgePolicy.ajS();
        this.mPermissionJudgePolicy.e(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        this.mPermissionJudgePolicy.a(new a.InterfaceC0243a() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.4
            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0243a
            public void ajT() {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
        });
        return this.mPermissionJudgePolicy.ad(activity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 12002:
                    if (intent != null) {
                        ao(intent);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void ao(Intent intent) {
        ImageFileInfo imageFileInfo;
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            if (writeImagesInfo.getChosedFiles() != null && writeImagesInfo.getChosedFiles().size() > 0 && (imageFileInfo = writeImagesInfo.getChosedFiles().get(0)) != null) {
                this.iDM.Dv(imageFileInfo.getFilePath());
            }
            writeImagesInfo.clear();
        }
    }

    public void b(final View view, String str, final String str2) {
        if (view != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.iDN != null && this.iDN.isShowing()) {
                this.iDN.dismiss();
            }
            View inflate = LayoutInflater.from(this).inflate(R.layout.popup_tip_image_layout, (ViewGroup) null);
            final ArrowView arrowView = (ArrowView) inflate.findViewById(R.id.tip_arrow);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.qr_image);
            tbImageView.setDrawBorder(true);
            tbImageView.setBorderWidth(1);
            tbImageView.setDrawCorner(true);
            tbImageView.setRadius(l.g(this, R.dimen.tbds5));
            tbImageView.setConrers(15);
            am.j((TextView) inflate.findViewById(R.id.qr_tip), R.color.cp_cont_f);
            tbImageView.startLoad(str, 36, false);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    g.a(QRCodeScanActivity.this.iDN, QRCodeScanActivity.this);
                    if (QRCodeScanActivity.this.iDM != null) {
                        QRCodeScanActivity.this.iDM.Dq(str2);
                    }
                }
            });
            inflate.measure(0, 0);
            this.iDN = new PopupWindow(getPageContext().getPageActivity());
            this.iDN.setContentView(inflate);
            this.iDN.setWidth(-2);
            this.iDN.setHeight(-2);
            this.iDN.setBackgroundDrawable(getPageContext().getResources().getDrawable(R.drawable.popup_window_transparent));
            this.iDN.setOutsideTouchable(true);
            this.iDN.setFocusable(false);
            this.iDN.setTouchable(true);
            e.iK().post(new Runnable() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.7
                @Override // java.lang.Runnable
                public void run() {
                    int[] iArr = new int[2];
                    view.getLocationOnScreen(iArr);
                    int i = iArr[0];
                    int measuredHeight = (iArr[1] + view.getMeasuredHeight()) - l.g(QRCodeScanActivity.this, R.dimen.tbds12);
                    int af = l.af(QRCodeScanActivity.this);
                    if (i > 0 && af > 0 && af > i && (view.getParent() instanceof View)) {
                        int abs = (((af - Math.abs(((View) view.getParent()).getLeft())) - (view.getMeasuredWidth() / 2)) - l.g(QRCodeScanActivity.this, R.dimen.tbds17)) - (l.g(QRCodeScanActivity.this, R.dimen.tbds26) / 2);
                        if (arrowView.getLayoutParams() != null && (arrowView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                            ((ViewGroup.MarginLayoutParams) arrowView.getLayoutParams()).rightMargin = abs;
                            g.showPopupWindowAtLocation(QRCodeScanActivity.this.iDN, view, 0, i, measuredHeight);
                            e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (QRCodeScanActivity.this.iDN != null && QRCodeScanActivity.this.iDN.isShowing()) {
                                        QRCodeScanActivity.this.iDN.dismiss();
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
