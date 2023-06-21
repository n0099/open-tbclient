package com.baidu.tieba;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class u65 extends k65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public u65() {
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

    public static final void b(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, dialogInterface) == null) {
            a65.s("userIcon");
        }
    }

    @Override // com.baidu.tieba.k65
    public void a(Context context, c65 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, data) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            if (!PollingModel.y0()) {
                a65.s("userIcon");
                return;
            }
            bx9 bx9Var = new bx9();
            bx9Var.f(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.e65
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                        u65.b(dialogInterface);
                    }
                }
            });
            bx9Var.d(TbSingleton.getInstance().getIconPopData());
            a65.m("userIcon");
        }
    }
}
