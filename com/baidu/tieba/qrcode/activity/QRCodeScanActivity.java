package com.baidu.tieba.qrcode.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
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
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StatusbarColorUtils;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.f05;
import com.baidu.tieba.mga;
import com.baidu.tieba.nga;
import com.baidu.tieba.qrcode.lib.core.QRCodeView;
import com.baidu.tieba.qrcode.lib.zxing.ZXingView;
import com.baidu.tieba.qrcode.view.ArrowView;
import com.baidu.tieba.qrcode.view.ScanLoadingView;
import com.baidu.tieba.yb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class QRCodeScanActivity extends BaseActivity<QRCodeScanActivity> implements mga, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public QRCodeView a;
    public NavigationBar b;
    public View c;
    public TextView d;
    public ImageView e;
    public nga f;
    public int g;
    public PopupWindow h;
    public WriteImagesInfo i;
    public PermissionJudgePolicy j;
    public ScanLoadingView k;
    public boolean l;
    public Runnable m;

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ ArrowView b;
        public final /* synthetic */ QRCodeScanActivity c;

        /* loaded from: classes7.dex */
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
                    yb.d(this.a.c.h, this.a.c);
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
                int measuredHeight = (iArr[1] + this.a.getMeasuredHeight()) - BdUtilHelper.getDimens(this.c, R.dimen.tbds12);
                int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.c);
                if (i > 0 && equipmentWidth > 0 && equipmentWidth > i && (this.a.getParent() instanceof View)) {
                    int abs = (((equipmentWidth - Math.abs(((View) this.a.getParent()).getLeft())) - (this.a.getMeasuredWidth() / 2)) - BdUtilHelper.getDimens(this.c, R.dimen.tbds17)) - (BdUtilHelper.getDimens(this.c, R.dimen.tbds26) / 2);
                    if (this.b.getLayoutParams() != null && (this.b.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                        ((ViewGroup.MarginLayoutParams) this.b.getLayoutParams()).rightMargin = abs;
                        yb.m(this.c.h, this.a, 0, i, measuredHeight);
                        SafeHandler.getInst().postDelayed(new a(this), 3000L);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements f05.e {
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

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                f05Var.dismiss();
                this.b.f.j(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements f05.e {
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

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                this.a.a.k();
                f05Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements f05.e {
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

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                this.a.a.k();
                f05Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.isFinishing() || this.a.a.getScanBoxView() == null) {
                return;
            }
            this.a.a.getScanBoxView().setQRCodeTipText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f11fa));
            this.a.a.getScanBoxView().setTipTextColor(this.a.getResources().getColor(R.color.CAM_X0201));
            this.a.a.getScanBoxView().m();
        }
    }

    /* loaded from: classes7.dex */
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
                yb.d(this.b.h, this.b);
                if (this.b.f != null) {
                    this.b.f.b(this.a);
                }
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

    @Override // com.baidu.tieba.mga
    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.k.a();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPause();
            TbadkCoreApplication.getInst().setSkinTypeValue(this.g);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onStart();
            this.a.h();
            this.a.g();
            this.a.k();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.a.m();
            super.onStop();
        }
    }

    @Override // com.baidu.tieba.mga
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.k.c();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            QRCodeView qRCodeView = this.a;
            if (qRCodeView != null) {
                qRCodeView.f();
            }
        }
    }

    @Override // com.baidu.tieba.mga
    public void D(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            O0(this.e, str, str2);
        }
    }

    @Override // com.baidu.tieba.mga
    public void I(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            f05 f05Var = new f05(getPageContext().getPageActivity());
            f05Var.setTitleShowCenter(true);
            f05Var.setTitle(getString(R.string.qr_url_jump_external_title));
            f05Var.setMessageShowCenter(true);
            f05Var.setMessage(getString(R.string.qr_url_jump_external_message));
            f05Var.setNegativeTextColor(R.color.CAM_X0105);
            f05Var.setPositiveButton(getPageContext().getString(R.string.obfuscated_res_0x7f0f04d2), new a(this, str));
            f05Var.setNegativeButton(getPageContext().getString(R.string.obfuscated_res_0x7f0f03db), new b(this));
            f05Var.setCancelable(false);
            f05Var.setCanceledOnTouchOutside(false);
            f05Var.create(getPageContext()).show();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            super.onChangeSkinType(i);
            this.b.setBackgroundResource(R.drawable.transparent_bg);
            if (this.b.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.b.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.d.setTextColor(getResources().getColor(R.color.CAM_X0101));
            if (UtilHelper.isFlyMeOs() && !UtilHelper.isMeizuE3() && !UtilHelper.isMeizuPro7Plus()) {
                StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity(), false);
            }
            UtilHelper.changeStatusBarIconAndTextColor(true, this);
        }
    }

    public final void L0(Intent intent) {
        String stringExtra;
        ImageFileInfo imageFileInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            if (writeImagesInfo.getChosedFiles() != null && writeImagesInfo.getChosedFiles().size() > 0 && (imageFileInfo = writeImagesInfo.getChosedFiles().get(0)) != null) {
                this.f.n(imageFileInfo.getFilePath());
            }
            writeImagesInfo.clear();
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
                if (M0(this, albumActivityConfig)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                TiebaStatic.log(new StatisticItem("c13409"));
            }
        }
    }

    public final boolean M0(Activity activity, AlbumActivityConfig albumActivityConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, activity, albumActivityConfig)) == null) {
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

    public void O0(View view2, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048580, this, view2, str, str2) == null) && view2 != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            PopupWindow popupWindow = this.h;
            if (popupWindow != null && popupWindow.isShowing()) {
                this.h.dismiss();
            }
            View inflate = LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d0848, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091ed9);
            tbImageView.setDrawBorder(true);
            tbImageView.setBorderWidth(1);
            tbImageView.setDrawCorner(true);
            tbImageView.setRadius(BdUtilHelper.getDimens(this, R.dimen.tbds5));
            tbImageView.setConrers(15);
            SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091eda), (int) R.color.CAM_X0106);
            tbImageView.startLoad(str, 36, false);
            inflate.setOnClickListener(new f(this, str2));
            inflate.measure(0, 0);
            PopupWindow popupWindow2 = new PopupWindow(getPageContext().getPageActivity());
            this.h = popupWindow2;
            popupWindow2.setContentView(inflate);
            GreyUtil.grey(this.h);
            this.h.setWidth(-2);
            this.h.setHeight(-2);
            this.h.setBackgroundDrawable(getPageContext().getResources().getDrawable(R.drawable.popup_window_transparent));
            this.h.setOutsideTouchable(true);
            this.h.setFocusable(false);
            this.h.setTouchable(true);
            SafeHandler.getInst().post(new g(this, view2, (ArrowView) inflate.findViewById(R.id.obfuscated_res_0x7f092660)));
        }
    }

    @Override // com.baidu.tieba.mga
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            f05 f05Var = new f05(getPageContext().getPageActivity());
            f05Var.setTitle((String) null);
            f05Var.setMessageShowCenter(true);
            f05Var.setMessage(getString(R.string.qr_url_risk_forbid));
            f05Var.setPositiveButton(getPageContext().getString(R.string.qr_url_risk_forbid_button), new c(this));
            f05Var.setCancelable(false);
            f05Var.setCanceledOnTouchOutside(false);
            f05Var.create(getPageContext()).show();
        }
    }

    @Override // com.baidu.tieba.mga
    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            h0();
            if (this.a.getScanBoxView() != null) {
                this.a.getScanBoxView().setQRCodeTipText(getResources().getString(R.string.obfuscated_res_0x7f0f1201));
                this.a.getScanBoxView().setTipTextColor(getResources().getColor(R.color.CAM_X0301));
                this.a.getScanBoxView().m();
            }
            SafeHandler.getInst().removeCallbacks(this.m);
            SafeHandler.getInst().postDelayed(this.m, 3000L);
            QRCodeView qRCodeView = this.a;
            if (qRCodeView != null) {
                qRCodeView.k();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1 && i == 12002 && intent != null) {
                L0(intent);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            this.g = TbadkCoreApplication.getInst().getSkinType();
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0052);
            if (getIntent() != null) {
                this.l = getIntent().getBooleanExtra(QRCodeScanActivityConfig.IS_AIAPP, false);
            }
            this.k = (ScanLoadingView) findViewById(R.id.obfuscated_res_0x7f091714);
            ZXingView zXingView = (ZXingView) findViewById(R.id.obfuscated_res_0x7f092ba1);
            this.a = zXingView;
            if (zXingView.getScanBoxView() != null) {
                this.a.getScanBoxView().setToolbarHeight(UtilHelper.getStatusBarHeight());
                this.a.getScanBoxView().requestLayout();
            }
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091ede);
            this.b = navigationBar;
            this.d = navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f1202));
            View addSystemImageButton = this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.c = addSystemImageButton;
            addSystemImageButton.setOnClickListener(this);
            this.e = new ImageView(this);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
            marginLayoutParams.rightMargin = BdUtilHelper.getDimens(this, R.dimen.tbds18);
            this.e.setLayoutParams(marginLayoutParams);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.e, R.drawable.obfuscated_res_0x7f080c4c, R.color.white_alpha100, null);
            this.e.setScaleType(ImageView.ScaleType.FIT_XY);
            this.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.e, this);
            nga ngaVar = new nga(this, getPageContext());
            this.f = ngaVar;
            ngaVar.o(this.l);
            this.a.setDelegate(this.f);
            this.f.g();
            StatisticItem statisticItem = new StatisticItem("qrcodevisit");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            PopupWindow popupWindow = this.h;
            if (popupWindow != null && popupWindow.isShowing()) {
                yb.d(this.h, this);
            }
            SafeHandler.getInst().removeCallbacks(this.m);
            TiebaStatic.log(new StatisticItem("c12707"));
            this.a.e();
            this.f.h();
            super.onDestroy();
        }
    }
}
