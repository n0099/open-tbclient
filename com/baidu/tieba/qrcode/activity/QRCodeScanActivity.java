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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
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
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.c.e.p.l;
import d.a.j0.r.s.a;
/* loaded from: classes5.dex */
public class QRCodeScanActivity extends BaseActivity<QRCodeScanActivity> implements d.a.k0.p2.a.a, View.OnClickListener {
    public View mBackButton;
    public TextView mCenterTtileTv;
    public ImageView mGalleryButton;
    public PopupWindow mGalleryTipPopupWindow;
    public boolean mIsAiapp;
    public ScanLoadingView mLoadingView;
    public NavigationBar mNavigationBar;
    public PermissionJudgePolicy mPermissionJudgePolicy;
    public d.a.k0.p2.a.b mQRCodeScanPresenter;
    public QRCodeView mQRCodeView;
    public int skinTypeRecord;
    public WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    public Runnable mResetTipRunnable = new e();

    /* loaded from: classes5.dex */
    public class a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f20165e;

        public a(String str) {
            this.f20165e = str;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
            QRCodeScanActivity.this.mQRCodeScanPresenter.j(this.f20165e);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public b() {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            QRCodeScanActivity.this.mQRCodeView.j();
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            QRCodeScanActivity.this.mQRCodeView.j();
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements PermissionJudgePolicy.OnPermissionsGrantedListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlbumActivityConfig f20169a;

        public d(AlbumActivityConfig albumActivityConfig) {
            this.f20169a = albumActivityConfig;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, this.f20169a));
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (QRCodeScanActivity.this.isFinishing() || QRCodeScanActivity.this.mQRCodeView.getScanBoxView() == null) {
                return;
            }
            QRCodeScanActivity.this.mQRCodeView.getScanBoxView().setQRCodeTipText(QRCodeScanActivity.this.getResources().getString(R.string.qr_code_scan_tip));
            QRCodeScanActivity.this.mQRCodeView.getScanBoxView().setTipTextColor(QRCodeScanActivity.this.getResources().getColor(R.color.CAM_X0201));
            QRCodeScanActivity.this.mQRCodeView.getScanBoxView().m();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f20172e;

        public f(String str) {
            this.f20172e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.c.e.m.g.d(QRCodeScanActivity.this.mGalleryTipPopupWindow, QRCodeScanActivity.this);
            if (QRCodeScanActivity.this.mQRCodeScanPresenter != null) {
                QRCodeScanActivity.this.mQRCodeScanPresenter.b(this.f20172e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f20174e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrowView f20175f;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeScanActivity.this.mGalleryTipPopupWindow == null || !QRCodeScanActivity.this.mGalleryTipPopupWindow.isShowing()) {
                    return;
                }
                d.a.c.e.m.g.d(QRCodeScanActivity.this.mGalleryTipPopupWindow, QRCodeScanActivity.this);
            }
        }

        public g(View view, ArrowView arrowView) {
            this.f20174e = view;
            this.f20175f = arrowView;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[2];
            this.f20174e.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int measuredHeight = (iArr[1] + this.f20174e.getMeasuredHeight()) - l.g(QRCodeScanActivity.this, R.dimen.tbds12);
            int k = l.k(QRCodeScanActivity.this);
            if (i2 <= 0 || k <= 0 || k <= i2 || !(this.f20174e.getParent() instanceof View)) {
                return;
            }
            int abs = (((k - Math.abs(((View) this.f20174e.getParent()).getLeft())) - (this.f20174e.getMeasuredWidth() / 2)) - l.g(QRCodeScanActivity.this, R.dimen.tbds17)) - (l.g(QRCodeScanActivity.this, R.dimen.tbds26) / 2);
            if (this.f20175f.getLayoutParams() == null || !(this.f20175f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            ((ViewGroup.MarginLayoutParams) this.f20175f.getLayoutParams()).rightMargin = abs;
            d.a.c.e.m.g.m(QRCodeScanActivity.this.mGalleryTipPopupWindow, this.f20174e, 0, i2, measuredHeight);
            d.a.c.e.m.e.a().postDelayed(new a(), 3000L);
        }
    }

    private void getAlbumDataFromImage(Intent intent) {
        ImageFileInfo imageFileInfo;
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            if (writeImagesInfo.getChosedFiles() != null && writeImagesInfo.getChosedFiles().size() > 0 && (imageFileInfo = writeImagesInfo.getChosedFiles().get(0)) != null) {
                this.mQRCodeScanPresenter.n(imageFileInfo.getFilePath());
            }
            writeImagesInfo.clear();
        }
    }

    private boolean requestPermission(Activity activity, AlbumActivityConfig albumActivityConfig) {
        if (this.mPermissionJudgePolicy == null) {
            this.mPermissionJudgePolicy = new PermissionJudgePolicy();
        }
        this.mPermissionJudgePolicy.clearRequestPermissionList();
        this.mPermissionJudgePolicy.appendRequestPermission(activity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        this.mPermissionJudgePolicy.setOnPermissionsGrantedListener(new d(albumActivityConfig));
        return this.mPermissionJudgePolicy.startRequestPermission(activity);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 12002 && intent != null) {
            getAlbumDataFromImage(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mNavigationBar.setBackgroundResource(R.drawable.transparent_bg);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mNavigationBar.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mCenterTtileTv.setTextColor(getResources().getColor(R.color.CAM_X0101));
        if (UtilHelper.isFlyMeOs() && !UtilHelper.isMeizuE3() && !UtilHelper.isMeizuPro7Plus()) {
            TbadkCoreApplication.getInst().setSkinTypeValue(1);
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mBackButton) {
            finish();
        } else if (view == this.mGalleryButton) {
            this.writeImagesInfo.setFromQRCode(true);
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(12002);
            if (requestPermission(this, albumActivityConfig)) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            TiebaStatic.log(new StatisticItem("c13409"));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.skinTypeRecord = TbadkCoreApplication.getInst().getSkinType();
        super.onCreate(bundle);
        setContentView(R.layout.activity_qr_code_scan);
        if (getIntent() != null) {
            this.mIsAiapp = getIntent().getBooleanExtra(QRCodeScanActivityConfig.IS_AIAPP, false);
        }
        this.mLoadingView = (ScanLoadingView) findViewById(R.id.loading_view);
        ZXingView zXingView = (ZXingView) findViewById(R.id.zxingview);
        this.mQRCodeView = zXingView;
        if (zXingView.getScanBoxView() != null) {
            this.mQRCodeView.getScanBoxView().setToolbarHeight(UtilHelper.getStatusBarHeight());
            this.mQRCodeView.getScanBoxView().requestLayout();
        }
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.qrcode_navigation_bar);
        this.mNavigationBar = navigationBar;
        this.mCenterTtileTv = navigationBar.setCenterTextTitle(getString(R.string.qrcode_title));
        View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mBackButton = addSystemImageButton;
        addSystemImageButton.setOnClickListener(this);
        this.mGalleryButton = new ImageView(this);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.rightMargin = l.g(this, R.dimen.tbds18);
        this.mGalleryButton.setLayoutParams(marginLayoutParams);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mGalleryButton, R.drawable.icon_pure_topbar_image44_svg, R.color.white_alpha100, null);
        this.mGalleryButton.setScaleType(ImageView.ScaleType.FIT_XY);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mGalleryButton, this);
        d.a.k0.p2.a.b bVar = new d.a.k0.p2.a.b(this, getPageContext());
        this.mQRCodeScanPresenter = bVar;
        bVar.o(this.mIsAiapp);
        this.mQRCodeView.setDelegate(this.mQRCodeScanPresenter);
        this.mQRCodeScanPresenter.g();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        PopupWindow popupWindow = this.mGalleryTipPopupWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            d.a.c.e.m.g.d(this.mGalleryTipPopupWindow, this);
        }
        d.a.c.e.m.e.a().removeCallbacks(this.mResetTipRunnable);
        TiebaStatic.log(new StatisticItem("c12707"));
        this.mQRCodeView.e();
        this.mQRCodeScanPresenter.h();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        TbadkCoreApplication.getInst().setSkinTypeValue(this.skinTypeRecord);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mQRCodeView.g();
        this.mQRCodeView.f();
        this.mQRCodeView.j();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        this.mQRCodeView.l();
        super.onStop();
    }

    @Override // d.a.k0.p2.a.a
    public void setErrorView() {
        viewHideLoading();
        if (this.mQRCodeView.getScanBoxView() != null) {
            this.mQRCodeView.getScanBoxView().setQRCodeTipText(getResources().getString(R.string.qrcode_error_not_found));
            this.mQRCodeView.getScanBoxView().setTipTextColor(getResources().getColor(R.color.CAM_X0301));
            this.mQRCodeView.getScanBoxView().m();
        }
        d.a.c.e.m.e.a().removeCallbacks(this.mResetTipRunnable);
        d.a.c.e.m.e.a().postDelayed(this.mResetTipRunnable, 3000L);
        QRCodeView qRCodeView = this.mQRCodeView;
        if (qRCodeView != null) {
            qRCodeView.j();
        }
    }

    @Override // d.a.k0.p2.a.a
    public void showGalleryLastImageTip(String str, String str2) {
        showPopupWindowAtView(this.mGalleryButton, str, str2);
    }

    @Override // d.a.k0.p2.a.a
    public void showJumpExternalDialog(String str) {
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(getPageContext().getPageActivity());
        aVar.setTitleShowCenter(true);
        aVar.setTitle(getString(R.string.qr_url_jump_external_title));
        aVar.setMessageShowCenter(true);
        aVar.setMessage(getString(R.string.qr_url_jump_external_message));
        aVar.setNegativeTextColor(R.color.CAM_X0105);
        aVar.setPositiveButton(getPageContext().getString(R.string.confirm), new a(str));
        aVar.setNegativeButton(getPageContext().getString(R.string.cancel), new b());
        aVar.setCancelable(false);
        aVar.setCanceledOnTouchOutside(false);
        aVar.create(getPageContext()).show();
    }

    public void showPopupWindowAtView(View view, String str, String str2) {
        if (view == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        PopupWindow popupWindow = this.mGalleryTipPopupWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.mGalleryTipPopupWindow.dismiss();
        }
        View inflate = LayoutInflater.from(this).inflate(R.layout.popup_tip_image_layout, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.qr_image);
        tbImageView.setDrawBorder(true);
        tbImageView.setBorderWidth(1);
        tbImageView.setDrawCorner(true);
        tbImageView.setRadius(l.g(this, R.dimen.tbds5));
        tbImageView.setConrers(15);
        SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.qr_tip), R.color.CAM_X0106);
        tbImageView.V(str, 36, false);
        inflate.setOnClickListener(new f(str2));
        inflate.measure(0, 0);
        PopupWindow popupWindow2 = new PopupWindow(getPageContext().getPageActivity());
        this.mGalleryTipPopupWindow = popupWindow2;
        popupWindow2.setContentView(inflate);
        this.mGalleryTipPopupWindow.setWidth(-2);
        this.mGalleryTipPopupWindow.setHeight(-2);
        this.mGalleryTipPopupWindow.setBackgroundDrawable(getPageContext().getResources().getDrawable(R.drawable.popup_window_transparent));
        this.mGalleryTipPopupWindow.setOutsideTouchable(true);
        this.mGalleryTipPopupWindow.setFocusable(false);
        this.mGalleryTipPopupWindow.setTouchable(true);
        d.a.c.e.m.e.a().post(new g(view, (ArrowView) inflate.findViewById(R.id.tip_arrow)));
    }

    @Override // d.a.k0.p2.a.a
    public void showRiskForbidDialog() {
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(getPageContext().getPageActivity());
        aVar.setTitle((String) null);
        aVar.setMessageShowCenter(true);
        aVar.setMessage(getString(R.string.qr_url_risk_forbid));
        aVar.setPositiveButton(getPageContext().getString(R.string.qr_url_risk_forbid_button), new c());
        aVar.setCancelable(false);
        aVar.setCanceledOnTouchOutside(false);
        aVar.create(getPageContext()).show();
    }

    @Override // d.a.k0.p2.a.a
    public void viewHideLoading() {
        this.mLoadingView.a();
    }

    @Override // d.a.k0.p2.a.a
    public void viewShowLoading() {
        this.mLoadingView.c();
    }
}
