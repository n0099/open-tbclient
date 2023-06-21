package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AlertDialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes7.dex */
public final class r65 extends j65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBAlertBuilder a;
        public final /* synthetic */ AlertDialog b;

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public a(TBAlertBuilder tBAlertBuilder, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBAlertBuilder, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBAlertBuilder;
            this.b = alertDialog;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String key, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, key, z) == null) {
                Intrinsics.checkNotNullParameter(key, "key");
                if (!z) {
                    return;
                }
                this.a.A(this.b);
            }
        }
    }

    public r65() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.j65
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a65.s("operateNew");
        }
    }

    @Override // com.baidu.tieba.j65
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a65.m("operateNew");
        }
    }

    public static final void f(AlertDialog dialog, yg5 yg5Var, View view2) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, dialog, yg5Var, view2) == null) {
            Intrinsics.checkNotNullParameter(dialog, "$dialog");
            if (view2 != null && view2.getContext() != null) {
                dialog.dismiss();
                LoginDialogData loginDialogData = new LoginDialogData(view2.getContext(), LoginDialogData.HOME_OPERATE_DIALOG);
                String b = yg5Var.b();
                Intrinsics.checkNotNullExpressionValue(b, "operateData.getHomeOperateUrl()");
                if (TextUtils.isEmpty(b)) {
                    return;
                }
                if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                    str = "skin=dark";
                } else {
                    str = "skin=default";
                }
                if (StringsKt__StringsKt.contains$default((CharSequence) b, (CharSequence) "?", false, 2, (Object) null)) {
                    str2 = b + "&customfullscreen=1&nonavigationbar=1&" + str;
                } else {
                    str2 = b + "?customfullscreen=1&nonavigationbar=1&" + str;
                }
                loginDialogData.setJumpUrl(str2);
                if (DialogLoginHelper.checkUpIsLogin(loginDialogData)) {
                    rx4.v(view2.getContext(), null, str2, true);
                }
            }
        }
    }

    @Override // com.baidu.tieba.j65
    public void b(TBAlertBuilder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, builder) == null) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            final yg5 homeOperateData = TbSingleton.getInstance().getHomeOperateData();
            o95.p().A(f75.a.a(), false);
            int h = TBAlertBuilder.h(TbadkCoreApplication.getInst());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(h, (h * 4) / 3);
            TbImageView tbImageView = new TbImageView(getActivity());
            tbImageView.setLayoutParams(layoutParams);
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            builder.k(tbImageView);
            builder.r(true);
            builder.v(true);
            builder.j(false);
            final AlertDialog d = builder.d();
            Intrinsics.checkNotNullExpressionValue(d, "builder.create()");
            tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d65
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        r65.f(AlertDialog.this, homeOperateData, view2);
                    }
                }
            });
            tbImageView.setEvent(new a(builder, d));
            tbImageView.N(homeOperateData.a(), 10, false);
        }
    }
}
