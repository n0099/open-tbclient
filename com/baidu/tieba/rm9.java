package com.baidu.tieba;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n55;
import com.baidu.tieba.om9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class rm9 extends n55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final om9 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rm9(Activity activity, om9 controller) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, controller};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.c = controller;
    }

    public static final void g(rm9 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.c();
        }
    }

    @Override // com.baidu.tieba.n55
    public void d(n55.a shouldShowCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shouldShowCallback) == null) {
            Intrinsics.checkNotNullParameter(shouldShowCallback, "shouldShowCallback");
            shouldShowCallback.callback(this.c.d());
        }
    }

    @Override // com.baidu.tieba.n55
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.g();
        }
    }

    @Override // com.baidu.tieba.n55
    public void e() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.p(new om9.d() { // from class: com.baidu.tieba.yl9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.om9.d
                public final void onDismiss() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        rm9.g(rm9.this);
                    }
                }
            });
            if (co5.f(true)) {
                z = this.c.r();
            } else {
                z = false;
            }
            if (!z) {
                c();
            }
        }
    }
}
