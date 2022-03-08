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
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.q0.r.t.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class QRCodeScanActivity extends BaseActivity<QRCodeScanActivity> implements c.a.r0.g3.a.a, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View mBackButton;
    public TextView mCenterTtileTv;
    public ImageView mGalleryButton;
    public PopupWindow mGalleryTipPopupWindow;
    public boolean mIsAiapp;
    public ScanLoadingView mLoadingView;
    public NavigationBar mNavigationBar;
    public PermissionJudgePolicy mPermissionJudgePolicy;
    public c.a.r0.g3.a.b mQRCodeScanPresenter;
    public QRCodeView mQRCodeView;
    public Runnable mResetTipRunnable;
    public int skinTypeRecord;
    public WriteImagesInfo writeImagesInfo;

    /* loaded from: classes6.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46041e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ QRCodeScanActivity f46042f;

        public a(QRCodeScanActivity qRCodeScanActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qRCodeScanActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46042f = qRCodeScanActivity;
            this.f46041e = str;
        }

        @Override // c.a.q0.r.t.a.e
        public void onClick(c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f46042f.mQRCodeScanPresenter.j(this.f46041e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ QRCodeScanActivity f46043e;

        public b(QRCodeScanActivity qRCodeScanActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qRCodeScanActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46043e = qRCodeScanActivity;
        }

        @Override // c.a.q0.r.t.a.e
        public void onClick(c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f46043e.mQRCodeView.startSpot();
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ QRCodeScanActivity f46044e;

        public c(QRCodeScanActivity qRCodeScanActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qRCodeScanActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46044e = qRCodeScanActivity;
        }

        @Override // c.a.q0.r.t.a.e
        public void onClick(c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f46044e.mQRCodeView.startSpot();
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlbumActivityConfig a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ QRCodeScanActivity f46045b;

        public d(QRCodeScanActivity qRCodeScanActivity, AlbumActivityConfig albumActivityConfig) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qRCodeScanActivity, albumActivityConfig};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46045b = qRCodeScanActivity;
            this.a = albumActivityConfig;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, this.a));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ QRCodeScanActivity f46046e;

        public e(QRCodeScanActivity qRCodeScanActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qRCodeScanActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46046e = qRCodeScanActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f46046e.isFinishing() || this.f46046e.mQRCodeView.getScanBoxView() == null) {
                return;
            }
            this.f46046e.mQRCodeView.getScanBoxView().setQRCodeTipText(this.f46046e.getResources().getString(R.string.qr_code_scan_tip));
            this.f46046e.mQRCodeView.getScanBoxView().setTipTextColor(this.f46046e.getResources().getColor(R.color.CAM_X0201));
            this.f46046e.mQRCodeView.getScanBoxView().refreshTipText();
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46047e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ QRCodeScanActivity f46048f;

        public f(QRCodeScanActivity qRCodeScanActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qRCodeScanActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46048f = qRCodeScanActivity;
            this.f46047e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.d.f.m.g.d(this.f46048f.mGalleryTipPopupWindow, this.f46048f);
                if (this.f46048f.mQRCodeScanPresenter != null) {
                    this.f46048f.mQRCodeScanPresenter.b(this.f46047e);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f46049e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrowView f46050f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ QRCodeScanActivity f46051g;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f46052e;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f46052e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f46052e.f46051g.mGalleryTipPopupWindow != null && this.f46052e.f46051g.mGalleryTipPopupWindow.isShowing()) {
                    c.a.d.f.m.g.d(this.f46052e.f46051g.mGalleryTipPopupWindow, this.f46052e.f46051g);
                }
            }
        }

        public g(QRCodeScanActivity qRCodeScanActivity, View view, ArrowView arrowView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qRCodeScanActivity, view, arrowView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46051g = qRCodeScanActivity;
            this.f46049e = view;
            this.f46050f = arrowView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int[] iArr = new int[2];
                this.f46049e.getLocationOnScreen(iArr);
                int i2 = iArr[0];
                int measuredHeight = (iArr[1] + this.f46049e.getMeasuredHeight()) - n.f(this.f46051g, R.dimen.tbds12);
                int k = n.k(this.f46051g);
                if (i2 <= 0 || k <= 0 || k <= i2 || !(this.f46049e.getParent() instanceof View)) {
                    return;
                }
                int abs = (((k - Math.abs(((View) this.f46049e.getParent()).getLeft())) - (this.f46049e.getMeasuredWidth() / 2)) - n.f(this.f46051g, R.dimen.tbds17)) - (n.f(this.f46051g, R.dimen.tbds26) / 2);
                if (this.f46050f.getLayoutParams() == null || !(this.f46050f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    return;
                }
                ((ViewGroup.MarginLayoutParams) this.f46050f.getLayoutParams()).rightMargin = abs;
                c.a.d.f.m.g.m(this.f46051g.mGalleryTipPopupWindow, this.f46049e, 0, i2, measuredHeight);
                c.a.d.f.m.e.a().postDelayed(new a(this), 3000L);
            }
        }
    }

    public QRCodeScanActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.writeImagesInfo = new WriteImagesInfo();
        this.mResetTipRunnable = new e(this);
    }

    private void getAlbumDataFromImage(Intent intent) {
        String stringExtra;
        ImageFileInfo imageFileInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, intent) == null) || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
        writeImagesInfo.parseJson(stringExtra);
        if (writeImagesInfo.getChosedFiles() != null && writeImagesInfo.getChosedFiles().size() > 0 && (imageFileInfo = writeImagesInfo.getChosedFiles().get(0)) != null) {
            this.mQRCodeScanPresenter.n(imageFileInfo.getFilePath());
        }
        writeImagesInfo.clear();
    }

    private boolean requestPermission(Activity activity, AlbumActivityConfig albumActivityConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, activity, albumActivityConfig)) == null) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
            this.mPermissionJudgePolicy.setOnPermissionsGrantedListener(new d(this, albumActivityConfig));
            return this.mPermissionJudgePolicy.startRequestPermission(activity);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 12002 && intent != null) {
                getAlbumDataFromImage(intent);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
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
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            if (view == this.mBackButton) {
                finish();
            } else if (view == this.mGalleryButton) {
                this.writeImagesInfo.setFromQRCode(true);
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString());
                albumActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                if (requestPermission(this, albumActivityConfig)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                TiebaStatic.log(new StatisticItem("c13409"));
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
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
            marginLayoutParams.rightMargin = n.f(this, R.dimen.tbds18);
            this.mGalleryButton.setLayoutParams(marginLayoutParams);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mGalleryButton, R.drawable.icon_pure_topbar_image44_svg, R.color.white_alpha100, null);
            this.mGalleryButton.setScaleType(ImageView.ScaleType.FIT_XY);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mGalleryButton, this);
            c.a.r0.g3.a.b bVar = new c.a.r0.g3.a.b(this, getPageContext());
            this.mQRCodeScanPresenter = bVar;
            bVar.o(this.mIsAiapp);
            this.mQRCodeView.setDelegate(this.mQRCodeScanPresenter);
            this.mQRCodeScanPresenter.g();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            PopupWindow popupWindow = this.mGalleryTipPopupWindow;
            if (popupWindow != null && popupWindow.isShowing()) {
                c.a.d.f.m.g.d(this.mGalleryTipPopupWindow, this);
            }
            c.a.d.f.m.e.a().removeCallbacks(this.mResetTipRunnable);
            TiebaStatic.log(new StatisticItem("c12707"));
            this.mQRCodeView.onDestroy();
            this.mQRCodeScanPresenter.h();
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onPause();
            TbadkCoreApplication.getInst().setSkinTypeValue(this.skinTypeRecord);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onStart();
            this.mQRCodeView.startCamera();
            this.mQRCodeView.showScanRect();
            this.mQRCodeView.startSpot();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mQRCodeView.stopCamera();
            super.onStop();
        }
    }

    @Override // c.a.r0.g3.a.a
    public void setErrorView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            viewHideLoading();
            if (this.mQRCodeView.getScanBoxView() != null) {
                this.mQRCodeView.getScanBoxView().setQRCodeTipText(getResources().getString(R.string.qrcode_error_not_found));
                this.mQRCodeView.getScanBoxView().setTipTextColor(getResources().getColor(R.color.CAM_X0301));
                this.mQRCodeView.getScanBoxView().refreshTipText();
            }
            c.a.d.f.m.e.a().removeCallbacks(this.mResetTipRunnable);
            c.a.d.f.m.e.a().postDelayed(this.mResetTipRunnable, 3000L);
            QRCodeView qRCodeView = this.mQRCodeView;
            if (qRCodeView != null) {
                qRCodeView.startSpot();
            }
        }
    }

    @Override // c.a.r0.g3.a.a
    public void showGalleryLastImageTip(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            showPopupWindowAtView(this.mGalleryButton, str, str2);
        }
    }

    @Override // c.a.r0.g3.a.a
    public void showJumpExternalDialog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            c.a.q0.r.t.a aVar = new c.a.q0.r.t.a(getPageContext().getPageActivity());
            aVar.setTitleShowCenter(true);
            aVar.setTitle(getString(R.string.qr_url_jump_external_title));
            aVar.setMessageShowCenter(true);
            aVar.setMessage(getString(R.string.qr_url_jump_external_message));
            aVar.setNegativeTextColor(R.color.CAM_X0105);
            aVar.setPositiveButton(getPageContext().getString(R.string.confirm), new a(this, str));
            aVar.setNegativeButton(getPageContext().getString(R.string.cancel), new b(this));
            aVar.setCancelable(false);
            aVar.setCanceledOnTouchOutside(false);
            aVar.create(getPageContext()).show();
        }
    }

    public void showPopupWindowAtView(View view, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048587, this, view, str, str2) == null) || view == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
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
        tbImageView.setRadius(n.f(this, R.dimen.tbds5));
        tbImageView.setConrers(15);
        SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.qr_tip), (int) R.color.CAM_X0106);
        tbImageView.startLoad(str, 36, false);
        inflate.setOnClickListener(new f(this, str2));
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
        c.a.d.f.m.e.a().post(new g(this, view, (ArrowView) inflate.findViewById(R.id.tip_arrow)));
    }

    @Override // c.a.r0.g3.a.a
    public void showRiskForbidDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            c.a.q0.r.t.a aVar = new c.a.q0.r.t.a(getPageContext().getPageActivity());
            aVar.setTitle((String) null);
            aVar.setMessageShowCenter(true);
            aVar.setMessage(getString(R.string.qr_url_risk_forbid));
            aVar.setPositiveButton(getPageContext().getString(R.string.qr_url_risk_forbid_button), new c(this));
            aVar.setCancelable(false);
            aVar.setCanceledOnTouchOutside(false);
            aVar.create(getPageContext()).show();
        }
    }

    @Override // c.a.r0.g3.a.a
    public void viewHideLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.mLoadingView.hideLoading();
        }
    }

    @Override // c.a.r0.g3.a.a
    public void viewShowLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.mLoadingView.showLoading();
        }
    }
}
