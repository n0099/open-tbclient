package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AlertDialog;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.fv4;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ps8 extends iv4 {
    public static /* synthetic */ Interceptable $ic;
    public static final String i;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity f;
    public final eq8 g;
    public l45 h;

    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ps8 a;

        public a(ps8 ps8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ps8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ps8Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.c();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ ps8 b;

        public b(ps8 ps8Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ps8Var, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ps8Var;
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && view2.getContext() != null) {
                this.a.dismiss();
                LoginDialogData loginDialogData = new LoginDialogData(view2.getContext(), LoginDialogData.HOME_OPERATE_DIALOG);
                String b = this.b.h.b();
                if (TextUtils.isEmpty(b)) {
                    return;
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (skinType == 1) {
                    str = "skin=night";
                } else if (skinType == 4) {
                    str = "skin=dark";
                } else {
                    str = "skin=default";
                }
                if (b.contains("?")) {
                    str2 = b + "&customfullscreen=1&nonavigationbar=1&" + str;
                } else {
                    str2 = b + "?customfullscreen=1&nonavigationbar=1&" + str;
                }
                loginDialogData.setJumpUrl(str2);
                if (DialogLoginHelper.checkUpIsLogin(loginDialogData)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view2.getContext(), null, str2, true)));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBAlertBuilder a;
        public final /* synthetic */ AlertDialog b;
        public final /* synthetic */ ps8 c;

        public c(ps8 ps8Var, TBAlertBuilder tBAlertBuilder, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ps8Var, tBAlertBuilder, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ps8Var;
            this.a = tBAlertBuilder;
            this.b = alertDialog;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
                if (!z) {
                    this.c.c();
                } else {
                    this.a.x(this.b);
                }
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.c.c();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948072724, "Lcom/baidu/tieba/ps8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948072724, "Lcom/baidu/tieba/ps8;");
                return;
            }
        }
        i = "key_home_operate_dialog_" + TbConfig.getBigAppVersion();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ps8(MainTabActivity mainTabActivity, eq8 eq8Var) {
        super(mainTabActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, eq8Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = eq8Var;
        this.f = mainTabActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0068, code lost:
        if (r4.g.B().getCurrentTabType() == 2) goto L22;
     */
    @Override // com.baidu.tieba.fv4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(fv4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            boolean z = true;
            if (!ux4.k().h(i, true)) {
                aVar.a(false);
                return;
            }
            l45 homeOperateData = TbSingleton.getInstance().getHomeOperateData();
            this.h = homeOperateData;
            if (homeOperateData == null) {
                aVar.a(false);
            } else if (!homeOperateData.c()) {
                aVar.a(false);
            } else {
                if (!TextUtils.isEmpty(this.h.a()) && this.h.a().contains("not_show")) {
                    ux4.k().u(i, false);
                } else if (this.g.B() != null) {
                }
                z = false;
                aVar.a(z);
            }
        }
    }

    @Override // com.baidu.tieba.iv4
    public void g(TBAlertBuilder tBAlertBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tBAlertBuilder) == null) {
            ux4.k().u(i, false);
            int f = TBAlertBuilder.f(TbadkCoreApplication.getInst());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f, (f * 4) / 3);
            TbImageView tbImageView = new TbImageView(this.b);
            tbImageView.setLayoutParams(layoutParams);
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            tBAlertBuilder.i(tbImageView);
            tBAlertBuilder.p(true);
            tBAlertBuilder.s(true);
            tBAlertBuilder.h(false);
            tBAlertBuilder.q(new a(this));
            AlertDialog c2 = tBAlertBuilder.c();
            tbImageView.setOnClickListener(new b(this, c2));
            tbImageView.setEvent(new c(this, tBAlertBuilder, c2));
            tbImageView.L(this.h.a(), 10, false);
        }
    }
}
