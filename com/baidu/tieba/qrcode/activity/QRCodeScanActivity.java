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
import com.repackage.a98;
import com.repackage.mi;
import com.repackage.ng;
import com.repackage.nr4;
import com.repackage.pg;
import com.repackage.z88;
/* loaded from: classes3.dex */
public class QRCodeScanActivity extends BaseActivity<QRCodeScanActivity> implements z88, View.OnClickListener {
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
    public a98 mQRCodeScanPresenter;
    public QRCodeView mQRCodeView;
    public Runnable mResetTipRunnable;
    public int skinTypeRecord;
    public WriteImagesInfo writeImagesInfo;

    /* loaded from: classes3.dex */
    public class a implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ QRCodeScanActivity b;

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
            this.b = qRCodeScanActivity;
            this.a = str;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                nr4Var.dismiss();
                this.b.mQRCodeScanPresenter.j(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements nr4.e {
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

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                this.a.mQRCodeView.j();
                nr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements nr4.e {
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

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                this.a.mQRCodeView.j();
                nr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlbumActivityConfig a;
        public final /* synthetic */ QRCodeScanActivity b;

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
            this.b = qRCodeScanActivity;
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

    /* loaded from: classes3.dex */
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
            this.a.mQRCodeView.getScanBoxView().setQRCodeTipText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0f34));
            this.a.mQRCodeView.getScanBoxView().setTipTextColor(this.a.getResources().getColor(R.color.CAM_X0201));
            this.a.mQRCodeView.getScanBoxView().m();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ QRCodeScanActivity b;

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
            this.b = qRCodeScanActivity;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                pg.d(this.b.mGalleryTipPopupWindow, this.b);
                if (this.b.mQRCodeScanPresenter != null) {
                    this.b.mQRCodeScanPresenter.b(this.a);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ ArrowView b;
        public final /* synthetic */ QRCodeScanActivity c;

        /* loaded from: classes3.dex */
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.c.mGalleryTipPopupWindow != null && this.a.c.mGalleryTipPopupWindow.isShowing()) {
                    pg.d(this.a.c.mGalleryTipPopupWindow, this.a.c);
                }
            }
        }

        public g(QRCodeScanActivity qRCodeScanActivity, View view2, ArrowView arrowView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qRCodeScanActivity, view2, arrowView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qRCodeScanActivity;
            this.a = view2;
            this.b = arrowView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int[] iArr = new int[2];
                this.a.getLocationOnScreen(iArr);
                int i = iArr[0];
                int measuredHeight = (iArr[1] + this.a.getMeasuredHeight()) - mi.f(this.c, R.dimen.tbds12);
                int k = mi.k(this.c);
                if (i <= 0 || k <= 0 || k <= i || !(this.a.getParent() instanceof View)) {
                    return;
                }
                int abs = (((k - Math.abs(((View) this.a.getParent()).getLeft())) - (this.a.getMeasuredWidth() / 2)) - mi.f(this.c, R.dimen.tbds17)) - (mi.f(this.c, R.dimen.tbds26) / 2);
                if (this.b.getLayoutParams() == null || !(this.b.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    return;
                }
                ((ViewGroup.MarginLayoutParams) this.b.getLayoutParams()).rightMargin = abs;
                pg.m(this.c.mGalleryTipPopupWindow, this.a, 0, i, measuredHeight);
                ng.a().postDelayed(new a(this), 3000L);
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
            this.mNavigationBar.setBackgroundResource(R.drawable.obfuscated_res_0x7f081221);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mNavigationBar.getBackImageView(), R.drawable.obfuscated_res_0x7f080611, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.mCenterTtileTv.setTextColor(getResources().getColor(R.color.CAM_X0101));
            if (UtilHelper.isFlyMeOs() && !UtilHelper.isMeizuE3() && !UtilHelper.isMeizuPro7Plus()) {
                TbadkCoreApplication.getInst().setSkinTypeValue(1);
            }
            UtilHelper.changeStatusBarIconAndTextColor(true, this);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            if (view2 == this.mBackButton) {
                finish();
            } else if (view2 == this.mGalleryButton) {
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
            setContentView(R.layout.obfuscated_res_0x7f0d004f);
            if (getIntent() != null) {
                this.mIsAiapp = getIntent().getBooleanExtra(QRCodeScanActivityConfig.IS_AIAPP, false);
            }
            this.mLoadingView = (ScanLoadingView) findViewById(R.id.obfuscated_res_0x7f09131e);
            ZXingView zXingView = (ZXingView) findViewById(R.id.obfuscated_res_0x7f092511);
            this.mQRCodeView = zXingView;
            if (zXingView.getScanBoxView() != null) {
                this.mQRCodeView.getScanBoxView().setToolbarHeight(UtilHelper.getStatusBarHeight());
                this.mQRCodeView.getScanBoxView().requestLayout();
            }
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0919e4);
            this.mNavigationBar = navigationBar;
            this.mCenterTtileTv = navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0f3c));
            View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mBackButton = addSystemImageButton;
            addSystemImageButton.setOnClickListener(this);
            this.mGalleryButton = new ImageView(this);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
            marginLayoutParams.rightMargin = mi.f(this, R.dimen.tbds18);
            this.mGalleryButton.setLayoutParams(marginLayoutParams);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mGalleryButton, R.drawable.obfuscated_res_0x7f0809d8, R.color.white_alpha100, null);
            this.mGalleryButton.setScaleType(ImageView.ScaleType.FIT_XY);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mGalleryButton, this);
            a98 a98Var = new a98(this, getPageContext());
            this.mQRCodeScanPresenter = a98Var;
            a98Var.o(this.mIsAiapp);
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
                pg.d(this.mGalleryTipPopupWindow, this);
            }
            ng.a().removeCallbacks(this.mResetTipRunnable);
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

    @Override // com.repackage.z88
    public void setErrorView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            viewHideLoading();
            if (this.mQRCodeView.getScanBoxView() != null) {
                this.mQRCodeView.getScanBoxView().setQRCodeTipText(getResources().getString(R.string.obfuscated_res_0x7f0f0f3b));
                this.mQRCodeView.getScanBoxView().setTipTextColor(getResources().getColor(R.color.CAM_X0301));
                this.mQRCodeView.getScanBoxView().m();
            }
            ng.a().removeCallbacks(this.mResetTipRunnable);
            ng.a().postDelayed(this.mResetTipRunnable, 3000L);
            QRCodeView qRCodeView = this.mQRCodeView;
            if (qRCodeView != null) {
                qRCodeView.j();
            }
        }
    }

    @Override // com.repackage.z88
    public void showGalleryLastImageTip(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            showPopupWindowAtView(this.mGalleryButton, str, str2);
        }
    }

    @Override // com.repackage.z88
    public void showJumpExternalDialog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            nr4 nr4Var = new nr4(getPageContext().getPageActivity());
            nr4Var.setTitleShowCenter(true);
            nr4Var.setTitle(getString(R.string.obfuscated_res_0x7f0f0f38));
            nr4Var.setMessageShowCenter(true);
            nr4Var.setMessage(getString(R.string.obfuscated_res_0x7f0f0f37));
            nr4Var.setNegativeTextColor(R.color.CAM_X0105);
            nr4Var.setPositiveButton(getPageContext().getString(R.string.obfuscated_res_0x7f0f0428), new a(this, str));
            nr4Var.setNegativeButton(getPageContext().getString(R.string.obfuscated_res_0x7f0f0374), new b(this));
            nr4Var.setCancelable(false);
            nr4Var.setCanceledOnTouchOutside(false);
            nr4Var.create(getPageContext()).show();
        }
    }

    public void showPopupWindowAtView(View view2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048587, this, view2, str, str2) == null) || view2 == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        PopupWindow popupWindow = this.mGalleryTipPopupWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.mGalleryTipPopupWindow.dismiss();
        }
        View inflate = LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d06ea, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0919df);
        tbImageView.setDrawBorder(true);
        tbImageView.setBorderWidth(1);
        tbImageView.setDrawCorner(true);
        tbImageView.setRadius(mi.f(this, R.dimen.tbds5));
        tbImageView.setConrers(15);
        SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0919e0), (int) R.color.CAM_X0106);
        tbImageView.K(str, 36, false);
        inflate.setOnClickListener(new f(this, str2));
        inflate.measure(0, 0);
        PopupWindow popupWindow2 = new PopupWindow(getPageContext().getPageActivity());
        this.mGalleryTipPopupWindow = popupWindow2;
        popupWindow2.setContentView(inflate);
        this.mGalleryTipPopupWindow.setWidth(-2);
        this.mGalleryTipPopupWindow.setHeight(-2);
        this.mGalleryTipPopupWindow.setBackgroundDrawable(getPageContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080fa9));
        this.mGalleryTipPopupWindow.setOutsideTouchable(true);
        this.mGalleryTipPopupWindow.setFocusable(false);
        this.mGalleryTipPopupWindow.setTouchable(true);
        ng.a().post(new g(this, view2, (ArrowView) inflate.findViewById(R.id.obfuscated_res_0x7f092054)));
    }

    @Override // com.repackage.z88
    public void showRiskForbidDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            nr4 nr4Var = new nr4(getPageContext().getPageActivity());
            nr4Var.setTitle((String) null);
            nr4Var.setMessageShowCenter(true);
            nr4Var.setMessage(getString(R.string.obfuscated_res_0x7f0f0f39));
            nr4Var.setPositiveButton(getPageContext().getString(R.string.obfuscated_res_0x7f0f0f3a), new c(this));
            nr4Var.setCancelable(false);
            nr4Var.setCanceledOnTouchOutside(false);
            nr4Var.create(getPageContext()).show();
        }
    }

    @Override // com.repackage.z88
    public void viewHideLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.mLoadingView.a();
        }
    }

    @Override // com.repackage.z88
    public void viewShowLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.mLoadingView.c();
        }
    }
}
