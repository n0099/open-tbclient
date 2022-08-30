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
import com.baidu.tieba.ri;
import com.baidu.tieba.sg;
import com.baidu.tieba.ug;
import com.baidu.tieba.wa8;
import com.baidu.tieba.wr4;
import com.baidu.tieba.xa8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class QRCodeScanActivity extends BaseActivity<QRCodeScanActivity> implements wa8, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public QRCodeView a;
    public NavigationBar b;
    public View c;
    public TextView d;
    public ImageView e;
    public xa8 f;
    public int g;
    public PopupWindow h;
    public WriteImagesInfo i;
    public PermissionJudgePolicy j;
    public ScanLoadingView k;
    public boolean l;
    public Runnable m;

    /* loaded from: classes5.dex */
    public class a implements wr4.e {
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

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                wr4Var.dismiss();
                this.b.f.j(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements wr4.e {
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

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                this.a.a.j();
                wr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements wr4.e {
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

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                this.a.a.j();
                wr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.isFinishing() || this.a.a.getScanBoxView() == null) {
                return;
            }
            this.a.a.getScanBoxView().setQRCodeTipText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0f64));
            this.a.a.getScanBoxView().setTipTextColor(this.a.getResources().getColor(R.color.CAM_X0201));
            this.a.a.getScanBoxView().m();
        }
    }

    /* loaded from: classes5.dex */
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
                ug.d(this.b.h, this.b);
                if (this.b.f != null) {
                    this.b.f.b(this.a);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ ArrowView b;
        public final /* synthetic */ QRCodeScanActivity c;

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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.c.h != null && this.a.c.h.isShowing()) {
                    ug.d(this.a.c.h, this.a.c);
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
                int measuredHeight = (iArr[1] + this.a.getMeasuredHeight()) - ri.f(this.c, R.dimen.tbds12);
                int k = ri.k(this.c);
                if (i <= 0 || k <= 0 || k <= i || !(this.a.getParent() instanceof View)) {
                    return;
                }
                int abs = (((k - Math.abs(((View) this.a.getParent()).getLeft())) - (this.a.getMeasuredWidth() / 2)) - ri.f(this.c, R.dimen.tbds17)) - (ri.f(this.c, R.dimen.tbds26) / 2);
                if (this.b.getLayoutParams() == null || !(this.b.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    return;
                }
                ((ViewGroup.MarginLayoutParams) this.b.getLayoutParams()).rightMargin = abs;
                ug.m(this.c.h, this.a, 0, i, measuredHeight);
                sg.a().postDelayed(new a(this), 3000L);
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
        this.i = new WriteImagesInfo();
        this.m = new e(this);
    }

    public final void C1(Intent intent) {
        String stringExtra;
        ImageFileInfo imageFileInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
        writeImagesInfo.parseJson(stringExtra);
        if (writeImagesInfo.getChosedFiles() != null && writeImagesInfo.getChosedFiles().size() > 0 && (imageFileInfo = writeImagesInfo.getChosedFiles().get(0)) != null) {
            this.f.n(imageFileInfo.getFilePath());
        }
        writeImagesInfo.clear();
    }

    public final boolean D1(Activity activity, AlbumActivityConfig albumActivityConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, albumActivityConfig)) == null) {
            if (this.j == null) {
                this.j = new PermissionJudgePolicy();
            }
            this.j.clearRequestPermissionList();
            this.j.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
            this.j.setOnPermissionsGrantedListener(new d(this, albumActivityConfig));
            return this.j.startRequestPermission(activity);
        }
        return invokeLL.booleanValue;
    }

    public void E1(View view2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, view2, str, str2) == null) || view2 == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        PopupWindow popupWindow = this.h;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.h.dismiss();
        }
        View inflate = LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d072c, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091ae4);
        tbImageView.setDrawBorder(true);
        tbImageView.setBorderWidth(1);
        tbImageView.setDrawCorner(true);
        tbImageView.setRadius(ri.f(this, R.dimen.tbds5));
        tbImageView.setConrers(15);
        SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091ae5), (int) R.color.CAM_X0106);
        tbImageView.K(str, 36, false);
        inflate.setOnClickListener(new f(this, str2));
        inflate.measure(0, 0);
        PopupWindow popupWindow2 = new PopupWindow(getPageContext().getPageActivity());
        this.h = popupWindow2;
        popupWindow2.setContentView(inflate);
        this.h.setWidth(-2);
        this.h.setHeight(-2);
        this.h.setBackgroundDrawable(getPageContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f98));
        this.h.setOutsideTouchable(true);
        this.h.setFocusable(false);
        this.h.setTouchable(true);
        sg.a().post(new g(this, view2, (ArrowView) inflate.findViewById(R.id.obfuscated_res_0x7f0921a1)));
    }

    @Override // com.baidu.tieba.wa8
    public void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            wr4 wr4Var = new wr4(getPageContext().getPageActivity());
            wr4Var.setTitle((String) null);
            wr4Var.setMessageShowCenter(true);
            wr4Var.setMessage(getString(R.string.obfuscated_res_0x7f0f0f69));
            wr4Var.setPositiveButton(getPageContext().getString(R.string.obfuscated_res_0x7f0f0f6a), new c(this));
            wr4Var.setCancelable(false);
            wr4Var.setCanceledOnTouchOutside(false);
            wr4Var.create(getPageContext()).show();
        }
    }

    @Override // com.baidu.tieba.wa8
    public void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.k.a();
        }
    }

    @Override // com.baidu.tieba.wa8
    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.k.c();
        }
    }

    @Override // com.baidu.tieba.wa8
    public void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c1();
            if (this.a.getScanBoxView() != null) {
                this.a.getScanBoxView().setQRCodeTipText(getResources().getString(R.string.obfuscated_res_0x7f0f0f6b));
                this.a.getScanBoxView().setTipTextColor(getResources().getColor(R.color.CAM_X0301));
                this.a.getScanBoxView().m();
            }
            sg.a().removeCallbacks(this.m);
            sg.a().postDelayed(this.m, 3000L);
            QRCodeView qRCodeView = this.a;
            if (qRCodeView != null) {
                qRCodeView.j();
            }
        }
    }

    @Override // com.baidu.tieba.wa8
    public void o0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            E1(this.e, str, str2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1 && i == 12002 && intent != null) {
                C1(intent);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            super.onChangeSkinType(i);
            this.b.setBackgroundResource(R.drawable.obfuscated_res_0x7f081211);
            if (this.b.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.b.getBackImageView(), R.drawable.obfuscated_res_0x7f080613, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.d.setTextColor(getResources().getColor(R.color.CAM_X0101));
            if (UtilHelper.isFlyMeOs() && !UtilHelper.isMeizuE3() && !UtilHelper.isMeizuPro7Plus()) {
                TbadkCoreApplication.getInst().setSkinTypeValue(1);
            }
            UtilHelper.changeStatusBarIconAndTextColor(true, this);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
            if (view2 == this.c) {
                finish();
            } else if (view2 == this.e) {
                this.i.setFromQRCode(true);
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getPageContext().getPageActivity(), this.i.toJsonString());
                albumActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                if (D1(this, albumActivityConfig)) {
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
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            this.g = TbadkCoreApplication.getInst().getSkinType();
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d004c);
            if (getIntent() != null) {
                this.l = getIntent().getBooleanExtra(QRCodeScanActivityConfig.IS_AIAPP, false);
            }
            this.k = (ScanLoadingView) findViewById(R.id.obfuscated_res_0x7f0913ff);
            ZXingView zXingView = (ZXingView) findViewById(R.id.obfuscated_res_0x7f0926a5);
            this.a = zXingView;
            if (zXingView.getScanBoxView() != null) {
                this.a.getScanBoxView().setToolbarHeight(UtilHelper.getStatusBarHeight());
                this.a.getScanBoxView().requestLayout();
            }
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091ae9);
            this.b = navigationBar;
            this.d = navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0f6c));
            View addSystemImageButton = this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.c = addSystemImageButton;
            addSystemImageButton.setOnClickListener(this);
            this.e = new ImageView(this);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
            marginLayoutParams.rightMargin = ri.f(this, R.dimen.tbds18);
            this.e.setLayoutParams(marginLayoutParams);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.e, R.drawable.obfuscated_res_0x7f0809fc, R.color.white_alpha100, null);
            this.e.setScaleType(ImageView.ScaleType.FIT_XY);
            this.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.e, this);
            xa8 xa8Var = new xa8(this, getPageContext());
            this.f = xa8Var;
            xa8Var.o(this.l);
            this.a.setDelegate(this.f);
            this.f.g();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            PopupWindow popupWindow = this.h;
            if (popupWindow != null && popupWindow.isShowing()) {
                ug.d(this.h, this);
            }
            sg.a().removeCallbacks(this.m);
            TiebaStatic.log(new StatisticItem("c12707"));
            this.a.e();
            this.f.h();
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPause();
            TbadkCoreApplication.getInst().setSkinTypeValue(this.g);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onStart();
            this.a.g();
            this.a.f();
            this.a.j();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.a.l();
            super.onStop();
        }
    }

    @Override // com.baidu.tieba.wa8
    public void w0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            wr4 wr4Var = new wr4(getPageContext().getPageActivity());
            wr4Var.setTitleShowCenter(true);
            wr4Var.setTitle(getString(R.string.obfuscated_res_0x7f0f0f68));
            wr4Var.setMessageShowCenter(true);
            wr4Var.setMessage(getString(R.string.obfuscated_res_0x7f0f0f67));
            wr4Var.setNegativeTextColor(R.color.CAM_X0105);
            wr4Var.setPositiveButton(getPageContext().getString(R.string.obfuscated_res_0x7f0f0432), new a(this, str));
            wr4Var.setNegativeButton(getPageContext().getString(R.string.obfuscated_res_0x7f0f0371), new b(this));
            wr4Var.setCancelable(false);
            wr4Var.setCanceledOnTouchOutside(false);
            wr4Var.create(getPageContext()).show();
        }
    }
}
