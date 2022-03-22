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
import c.a.o0.r.t.a;
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
/* loaded from: classes5.dex */
public class QRCodeScanActivity extends BaseActivity<QRCodeScanActivity> implements c.a.p0.i3.a.a, View.OnClickListener {
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
    public c.a.p0.i3.a.b mQRCodeScanPresenter;
    public QRCodeView mQRCodeView;
    public Runnable mResetTipRunnable;
    public int skinTypeRecord;
    public WriteImagesInfo writeImagesInfo;

    /* loaded from: classes5.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ QRCodeScanActivity f35659b;

        public a(QRCodeScanActivity qRCodeScanActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qRCodeScanActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35659b = qRCodeScanActivity;
            this.a = str;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f35659b.mQRCodeScanPresenter.j(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ QRCodeScanActivity a;

        public b(QRCodeScanActivity qRCodeScanActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qRCodeScanActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qRCodeScanActivity;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.mQRCodeView.j();
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ QRCodeScanActivity a;

        public c(QRCodeScanActivity qRCodeScanActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qRCodeScanActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qRCodeScanActivity;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.mQRCodeView.j();
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlbumActivityConfig a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ QRCodeScanActivity f35660b;

        public d(QRCodeScanActivity qRCodeScanActivity, AlbumActivityConfig albumActivityConfig) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qRCodeScanActivity, albumActivityConfig};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35660b = qRCodeScanActivity;
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

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ QRCodeScanActivity a;

        public e(QRCodeScanActivity qRCodeScanActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qRCodeScanActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qRCodeScanActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.isFinishing() || this.a.mQRCodeView.getScanBoxView() == null) {
                return;
            }
            this.a.mQRCodeView.getScanBoxView().setQRCodeTipText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0f14));
            this.a.mQRCodeView.getScanBoxView().setTipTextColor(this.a.getResources().getColor(R.color.CAM_X0201));
            this.a.mQRCodeView.getScanBoxView().m();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ QRCodeScanActivity f35661b;

        public f(QRCodeScanActivity qRCodeScanActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qRCodeScanActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35661b = qRCodeScanActivity;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.d.f.m.g.d(this.f35661b.mGalleryTipPopupWindow, this.f35661b);
                if (this.f35661b.mQRCodeScanPresenter != null) {
                    this.f35661b.mQRCodeScanPresenter.b(this.a);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrowView f35662b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ QRCodeScanActivity f35663c;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.f35663c.mGalleryTipPopupWindow != null && this.a.f35663c.mGalleryTipPopupWindow.isShowing()) {
                    c.a.d.f.m.g.d(this.a.f35663c.mGalleryTipPopupWindow, this.a.f35663c);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35663c = qRCodeScanActivity;
            this.a = view;
            this.f35662b = arrowView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int[] iArr = new int[2];
                this.a.getLocationOnScreen(iArr);
                int i = iArr[0];
                int measuredHeight = (iArr[1] + this.a.getMeasuredHeight()) - n.f(this.f35663c, R.dimen.tbds12);
                int k = n.k(this.f35663c);
                if (i <= 0 || k <= 0 || k <= i || !(this.a.getParent() instanceof View)) {
                    return;
                }
                int abs = (((k - Math.abs(((View) this.a.getParent()).getLeft())) - (this.a.getMeasuredWidth() / 2)) - n.f(this.f35663c, R.dimen.tbds17)) - (n.f(this.f35663c, R.dimen.tbds26) / 2);
                if (this.f35662b.getLayoutParams() == null || !(this.f35662b.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    return;
                }
                ((ViewGroup.MarginLayoutParams) this.f35662b.getLayoutParams()).rightMargin = abs;
                c.a.d.f.m.g.m(this.f35663c.mGalleryTipPopupWindow, this.a, 0, i, measuredHeight);
                c.a.d.f.m.e.a().postDelayed(new a(this), 3000L);
            }
        }
    }

    public QRCodeScanActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1 && i == 12002 && intent != null) {
                getAlbumDataFromImage(intent);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            this.mNavigationBar.setBackgroundResource(R.drawable.obfuscated_res_0x7f081200);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mNavigationBar.getBackImageView(), R.drawable.obfuscated_res_0x7f080624, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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
            setContentView(R.layout.obfuscated_res_0x7f0d004d);
            if (getIntent() != null) {
                this.mIsAiapp = getIntent().getBooleanExtra(QRCodeScanActivityConfig.IS_AIAPP, false);
            }
            this.mLoadingView = (ScanLoadingView) findViewById(R.id.obfuscated_res_0x7f09131a);
            ZXingView zXingView = (ZXingView) findViewById(R.id.obfuscated_res_0x7f0924df);
            this.mQRCodeView = zXingView;
            if (zXingView.getScanBoxView() != null) {
                this.mQRCodeView.getScanBoxView().setToolbarHeight(UtilHelper.getStatusBarHeight());
                this.mQRCodeView.getScanBoxView().requestLayout();
            }
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f09199a);
            this.mNavigationBar = navigationBar;
            this.mCenterTtileTv = navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0f1c));
            View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mBackButton = addSystemImageButton;
            addSystemImageButton.setOnClickListener(this);
            this.mGalleryButton = new ImageView(this);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
            marginLayoutParams.rightMargin = n.f(this, R.dimen.tbds18);
            this.mGalleryButton.setLayoutParams(marginLayoutParams);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mGalleryButton, R.drawable.obfuscated_res_0x7f0809b7, R.color.white_alpha100, null);
            this.mGalleryButton.setScaleType(ImageView.ScaleType.FIT_XY);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mGalleryButton, this);
            c.a.p0.i3.a.b bVar = new c.a.p0.i3.a.b(this, getPageContext());
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
            this.mQRCodeView.e();
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
            this.mQRCodeView.g();
            this.mQRCodeView.f();
            this.mQRCodeView.j();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mQRCodeView.l();
            super.onStop();
        }
    }

    @Override // c.a.p0.i3.a.a
    public void setErrorView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            viewHideLoading();
            if (this.mQRCodeView.getScanBoxView() != null) {
                this.mQRCodeView.getScanBoxView().setQRCodeTipText(getResources().getString(R.string.obfuscated_res_0x7f0f0f1b));
                this.mQRCodeView.getScanBoxView().setTipTextColor(getResources().getColor(R.color.CAM_X0301));
                this.mQRCodeView.getScanBoxView().m();
            }
            c.a.d.f.m.e.a().removeCallbacks(this.mResetTipRunnable);
            c.a.d.f.m.e.a().postDelayed(this.mResetTipRunnable, 3000L);
            QRCodeView qRCodeView = this.mQRCodeView;
            if (qRCodeView != null) {
                qRCodeView.j();
            }
        }
    }

    @Override // c.a.p0.i3.a.a
    public void showGalleryLastImageTip(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            showPopupWindowAtView(this.mGalleryButton, str, str2);
        }
    }

    @Override // c.a.p0.i3.a.a
    public void showJumpExternalDialog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(getPageContext().getPageActivity());
            aVar.setTitleShowCenter(true);
            aVar.setTitle(getString(R.string.obfuscated_res_0x7f0f0f18));
            aVar.setMessageShowCenter(true);
            aVar.setMessage(getString(R.string.obfuscated_res_0x7f0f0f17));
            aVar.setNegativeTextColor(R.color.CAM_X0105);
            aVar.setPositiveButton(getPageContext().getString(R.string.obfuscated_res_0x7f0f041a), new a(this, str));
            aVar.setNegativeButton(getPageContext().getString(R.string.obfuscated_res_0x7f0f036c), new b(this));
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
        View inflate = LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d06fb, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091995);
        tbImageView.setDrawBorder(true);
        tbImageView.setBorderWidth(1);
        tbImageView.setDrawCorner(true);
        tbImageView.setRadius(n.f(this, R.dimen.tbds5));
        tbImageView.setConrers(15);
        SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091996), (int) R.color.CAM_X0106);
        tbImageView.J(str, 36, false);
        inflate.setOnClickListener(new f(this, str2));
        inflate.measure(0, 0);
        PopupWindow popupWindow2 = new PopupWindow(getPageContext().getPageActivity());
        this.mGalleryTipPopupWindow = popupWindow2;
        popupWindow2.setContentView(inflate);
        this.mGalleryTipPopupWindow.setWidth(-2);
        this.mGalleryTipPopupWindow.setHeight(-2);
        this.mGalleryTipPopupWindow.setBackgroundDrawable(getPageContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f88));
        this.mGalleryTipPopupWindow.setOutsideTouchable(true);
        this.mGalleryTipPopupWindow.setFocusable(false);
        this.mGalleryTipPopupWindow.setTouchable(true);
        c.a.d.f.m.e.a().post(new g(this, view, (ArrowView) inflate.findViewById(R.id.obfuscated_res_0x7f09200a)));
    }

    @Override // c.a.p0.i3.a.a
    public void showRiskForbidDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(getPageContext().getPageActivity());
            aVar.setTitle((String) null);
            aVar.setMessageShowCenter(true);
            aVar.setMessage(getString(R.string.obfuscated_res_0x7f0f0f19));
            aVar.setPositiveButton(getPageContext().getString(R.string.obfuscated_res_0x7f0f0f1a), new c(this));
            aVar.setCancelable(false);
            aVar.setCanceledOnTouchOutside(false);
            aVar.create(getPageContext()).show();
        }
    }

    @Override // c.a.p0.i3.a.a
    public void viewHideLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.mLoadingView.a();
        }
    }

    @Override // c.a.p0.i3.a.a
    public void viewShowLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.mLoadingView.c();
        }
    }
}
