package com.baidu.tieba;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class jr9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a a;
    public gsa b;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public int b;
        public int c;
        public int d;
        public kr9 e;

        public a(View contentView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {contentView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(contentView, "contentView");
            this.a = contentView;
            this.d = 51;
        }

        public final jr9 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new jr9(this);
            }
            return (jr9) invokeV.objValue;
        }

        public final View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a;
            }
            return (View) invokeV.objValue;
        }

        public final int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.d;
            }
            return invokeV.intValue;
        }

        public final kr9 d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.e;
            }
            return (kr9) invokeV.objValue;
        }

        public final int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.b;
            }
            return invokeV.intValue;
        }

        public final int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.c;
            }
            return invokeV.intValue;
        }

        public final a g(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                this.d = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a h(kr9 kr9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, kr9Var)) == null) {
                this.e = kr9Var;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a i(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                this.b = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a j(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
                this.c = i;
                return this;
            }
            return (a) invokeI.objValue;
        }
    }

    public jr9(a builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.a = builder;
    }

    public static final void c(jr9 this$0, DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, dialogInterface) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            kr9 d = this$0.a.d();
            if (d != null) {
                d.onShow();
            }
        }
    }

    public static final void d(jr9 this$0, DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, dialogInterface) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            kr9 d = this$0.a.d();
            if (d != null) {
                d.onDismiss();
            }
        }
    }

    public final void a() {
        gsa gsaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (gsaVar = this.b) != null) {
            gsaVar.dismiss();
        }
    }

    public final void b() {
        Window window;
        Window window2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Context context = this.a.b().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            gsa gsaVar = new gsa(context, R.style.obfuscated_res_0x7f1003d4);
            this.b = gsaVar;
            if (gsaVar != null && (window2 = gsaVar.getWindow()) != null) {
                window2.setWindowAnimations(R.style.obfuscated_res_0x7f1003bf);
            }
            gsa gsaVar2 = this.b;
            if (gsaVar2 != null && (window = gsaVar2.getWindow()) != null) {
                if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                    window.getDecorView().setSystemUiVisibility(1280);
                } else {
                    window.getDecorView().setSystemUiVisibility(9472);
                }
                window.addFlags(Integer.MIN_VALUE);
                window.addFlags(512);
                window.setType(1000);
                window.setStatusBarColor(0);
                window.setNavigationBarColor(0);
                window.setDimAmount(0.0f);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -2;
                attributes.height = -2;
                attributes.x = this.a.e();
                attributes.y = this.a.f();
                attributes.gravity = this.a.c();
                window.setAttributes(attributes);
                gsa gsaVar3 = this.b;
                if (gsaVar3 != null) {
                    gsaVar3.setContentView(this.a.b());
                }
                GreyUtil.grey(this.b);
                gsa gsaVar4 = this.b;
                if (gsaVar4 != null) {
                    gsaVar4.setCancelable(true);
                }
                gsa gsaVar5 = this.b;
                if (gsaVar5 != null) {
                    gsaVar5.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.tieba.hr9
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.content.DialogInterface.OnShowListener
                        public final void onShow(DialogInterface dialogInterface) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                                jr9.c(jr9.this, dialogInterface);
                            }
                        }
                    });
                }
                gsa gsaVar6 = this.b;
                if (gsaVar6 != null) {
                    gsaVar6.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ir9
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                                jr9.d(jr9.this, dialogInterface);
                            }
                        }
                    });
                }
                gsa gsaVar7 = this.b;
                if (gsaVar7 != null) {
                    gsaVar7.show();
                }
            }
        }
    }
}
