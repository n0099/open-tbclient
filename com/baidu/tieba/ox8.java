package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
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
import com.baidu.tieba.bw4;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ox8 extends ew4 {
    public static /* synthetic */ Interceptable $ic;
    public static final String i;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity f;
    public final av8 g;
    public l55 h;

    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ox8 a;

        public a(ox8 ox8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ox8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ox8Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                iw4.t("operateNew");
                this.a.c();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ ox8 b;

        public b(ox8 ox8Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ox8Var, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ox8Var;
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
    public class c implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBAlertBuilder a;
        public final /* synthetic */ AlertDialog b;
        public final /* synthetic */ ox8 c;

        public c(ox8 ox8Var, TBAlertBuilder tBAlertBuilder, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ox8Var, tBAlertBuilder, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ox8Var;
            this.a = tBAlertBuilder;
            this.b = alertDialog;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
                if (!z) {
                    this.c.c();
                } else {
                    this.a.z(this.b);
                }
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948047738, "Lcom/baidu/tieba/ox8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948047738, "Lcom/baidu/tieba/ox8;");
                return;
            }
        }
        i = "key_home_operate_dialog_" + TbConfig.getBigAppVersion();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ox8(@NonNull MainTabActivity mainTabActivity, @NonNull av8 av8Var) {
        super(mainTabActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, av8Var};
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
        this.g = av8Var;
        this.f = mainTabActivity;
    }

    @Override // com.baidu.tieba.bw4
    public void d(@NonNull bw4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            boolean z = false;
            if (iw4.l()) {
                aVar.a(false);
            } else if (!ry4.l().i(i, true)) {
                aVar.a(false);
            } else {
                l55 homeOperateData = TbSingleton.getInstance().getHomeOperateData();
                this.h = homeOperateData;
                if (homeOperateData == null) {
                    aVar.a(false);
                } else if (!homeOperateData.c()) {
                    aVar.a(false);
                } else {
                    if (!TextUtils.isEmpty(this.h.a()) && this.h.a().contains("not_show")) {
                        ry4.l().v(i, false);
                    } else if (this.g.x() != null && this.g.x().getCurrentTabType() == 2) {
                        z = true;
                    }
                    aVar.a(z);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ew4
    public void g(TBAlertBuilder tBAlertBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tBAlertBuilder) == null) {
            ry4.l().v(i, false);
            int h = TBAlertBuilder.h(TbadkCoreApplication.getInst());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(h, (h * 4) / 3);
            TbImageView tbImageView = new TbImageView(this.b);
            tbImageView.setLayoutParams(layoutParams);
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            tBAlertBuilder.k(tbImageView);
            tBAlertBuilder.r(true);
            tBAlertBuilder.u(true);
            tBAlertBuilder.j(false);
            tBAlertBuilder.s(new a(this));
            AlertDialog d = tBAlertBuilder.d();
            tbImageView.setOnClickListener(new b(this, d));
            tbImageView.setEvent(new c(this, tBAlertBuilder, d));
            tbImageView.K(this.h.a(), 10, false);
        }
    }

    @Override // com.baidu.tieba.ew4
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            iw4.n("operateNew");
        }
    }
}
