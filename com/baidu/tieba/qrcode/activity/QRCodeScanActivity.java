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
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
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
    private View cAN;
    private int gSq;
    private QRCodeView iwn;
    private TextView iwo;
    private ImageView iwp;
    private b iwq;
    private PopupWindow iwr;
    private ScanLoadingView iws;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    Runnable iwt = new Runnable() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.5
        @Override // java.lang.Runnable
        public void run() {
            if (!QRCodeScanActivity.this.isFinishing() && QRCodeScanActivity.this.iwn.getScanBoxView() != null) {
                QRCodeScanActivity.this.iwn.getScanBoxView().setQRCodeTipText(QRCodeScanActivity.this.getResources().getString(R.string.qr_code_scan_tip));
                QRCodeScanActivity.this.iwn.getScanBoxView().setTipTextColor(QRCodeScanActivity.this.getResources().getColor(R.color.cp_bg_line_d));
                QRCodeScanActivity.this.iwn.getScanBoxView().cej();
            }
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.gSq = TbadkCoreApplication.getInst().getSkinType();
        super.onCreate(bundle);
        setContentView(R.layout.activity_qr_code_scan);
        this.iws = (ScanLoadingView) findViewById(R.id.loading_view);
        this.iwn = (ZXingView) findViewById(R.id.zxingview);
        if (this.iwn.getScanBoxView() != null) {
            this.iwn.getScanBoxView().setToolbarHeight(UtilHelper.getStatusBarHeight());
            this.iwn.getScanBoxView().requestLayout();
        }
        this.mNavigationBar = (NavigationBar) findViewById(R.id.qrcode_navigation_bar);
        this.iwo = this.mNavigationBar.setCenterTextTitle(getString(R.string.qrcode_title));
        this.cAN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cAN.setOnClickListener(this);
        this.iwp = new ImageView(this);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.rightMargin = l.g(this, R.dimen.tbds18);
        this.iwp.setLayoutParams(marginLayoutParams);
        this.iwp.setImageResource(R.drawable.icon_sweep_image_n);
        this.iwp.setScaleType(ImageView.ScaleType.FIT_XY);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iwp, this);
        this.iwq = new b(this, getPageContext());
        this.iwn.setDelegate(this.iwq);
        this.iwq.cdT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.iwn.cec();
        this.iwn.cea();
        this.iwn.ced();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        TbadkCoreApplication.getInst().setSkinTypeValue(this.gSq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        this.iwn.stopCamera();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.iwr != null && this.iwr.isShowing()) {
            g.a(this.iwr, this);
        }
        e.iB().removeCallbacks(this.iwt);
        TiebaStatic.log(new am("c12707"));
        this.iwn.onDestroy();
        this.iwq.onDestroy();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.setBackgroundResource(R.drawable.transparent_bg);
        this.mNavigationBar.setmBackImageViewBg(R.drawable.btn_sml_back_selector_s, R.drawable.btn_sml_back_selector_s);
        this.iwo.setTextColor(getResources().getColor(R.color.cp_btn_a));
        if (UtilHelper.isFlyMeOs() && !UtilHelper.isMeizuE3()) {
            TbadkCoreApplication.getInst().setSkinTypeValue(1);
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void dT(String str, String str2) {
        b(this.iwp, str, str2);
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void cdO() {
        cdQ();
        if (this.iwn.getScanBoxView() != null) {
            this.iwn.getScanBoxView().setQRCodeTipText(getResources().getString(R.string.qrcode_error_not_found));
            this.iwn.getScanBoxView().setTipTextColor(getResources().getColor(R.color.cp_cont_h));
            this.iwn.getScanBoxView().cej();
        }
        e.iB().removeCallbacks(this.iwt);
        e.iB().postDelayed(this.iwt, 3000L);
        if (this.iwn != null) {
            this.iwn.ced();
        }
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void cdP() {
        this.iws.showLoading();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void cdQ() {
        this.iws.boL();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void Cz(final String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.dT(true);
        aVar.mD(getString(R.string.qr_url_jump_external_title));
        aVar.dS(true);
        aVar.mE(getString(R.string.qr_url_jump_external_message));
        aVar.hq(R.color.cp_cont_b);
        aVar.a(getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                QRCodeScanActivity.this.iwq.openUrl(str);
            }
        });
        aVar.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                QRCodeScanActivity.this.iwn.ced();
                aVar2.dismiss();
            }
        });
        aVar.dM(false);
        aVar.dN(false);
        aVar.b(getPageContext()).afG();
    }

    @Override // com.baidu.tieba.qrcode.activity.a
    public void cdR() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.mD(null);
        aVar.dS(true);
        aVar.mE(getString(R.string.qr_url_risk_forbid));
        aVar.a(getPageContext().getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                QRCodeScanActivity.this.iwn.ced();
                aVar2.dismiss();
            }
        });
        aVar.dM(false);
        aVar.dN(false);
        aVar.b(getPageContext()).afG();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cAN) {
            finish();
        } else if (view == this.iwp) {
            this.writeImagesInfo.setFromQRCode(true);
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            if (!a(this, albumActivityConfig)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                TiebaStatic.log(new am("c13409"));
            }
        }
    }

    private boolean a(Activity activity, final AlbumActivityConfig albumActivityConfig) {
        if (this.mPermissionJudgePolicy == null) {
            this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
        }
        this.mPermissionJudgePolicy.aiM();
        this.mPermissionJudgePolicy.e(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        this.mPermissionJudgePolicy.a(new a.InterfaceC0241a() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.4
            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0241a
            public void aiN() {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
        });
        return this.mPermissionJudgePolicy.aa(activity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        am(intent);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void am(Intent intent) {
        ImageFileInfo imageFileInfo;
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            if (writeImagesInfo.getChosedFiles() != null && writeImagesInfo.getChosedFiles().size() > 0 && (imageFileInfo = writeImagesInfo.getChosedFiles().get(0)) != null) {
                this.iwq.CF(imageFileInfo.getFilePath());
            }
            writeImagesInfo.clear();
        }
    }

    public void b(final View view, String str, final String str2) {
        if (view != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.iwr != null && this.iwr.isShowing()) {
                this.iwr.dismiss();
            }
            View inflate = LayoutInflater.from(this).inflate(R.layout.popup_tip_image_layout, (ViewGroup) null);
            final ArrowView arrowView = (ArrowView) inflate.findViewById(R.id.tip_arrow);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.qr_image);
            tbImageView.setDrawBorder(true);
            tbImageView.setBorderWidth(1);
            tbImageView.setDrawCorner(true);
            tbImageView.setRadius(l.g(this, R.dimen.tbds5));
            tbImageView.setConrers(15);
            al.j((TextView) inflate.findViewById(R.id.qr_tip), R.color.cp_cont_f);
            tbImageView.startLoad(str, 36, false);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    g.a(QRCodeScanActivity.this.iwr, QRCodeScanActivity.this);
                    if (QRCodeScanActivity.this.iwq != null) {
                        QRCodeScanActivity.this.iwq.CA(str2);
                    }
                }
            });
            inflate.measure(0, 0);
            this.iwr = new PopupWindow(getPageContext().getPageActivity());
            this.iwr.setContentView(inflate);
            this.iwr.setWidth(-2);
            this.iwr.setHeight(-2);
            this.iwr.setBackgroundDrawable(getPageContext().getResources().getDrawable(R.drawable.popup_window_transparent));
            this.iwr.setOutsideTouchable(true);
            this.iwr.setFocusable(false);
            this.iwr.setTouchable(true);
            e.iB().post(new Runnable() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.7
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
                            g.showPopupWindowAtLocation(QRCodeScanActivity.this.iwr, view, 0, i, measuredHeight);
                            e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.qrcode.activity.QRCodeScanActivity.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (QRCodeScanActivity.this.iwr != null && QRCodeScanActivity.this.iwr.isShowing()) {
                                        QRCodeScanActivity.this.iwr.dismiss();
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
