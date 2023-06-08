package com.baidu.tieba;

import android.app.Activity;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.gametab.FrsSpriteGuideTipController;
import com.baidu.tieba.or6;
import com.baidu.tieba.s55;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class pk7 extends s55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ok7 c;
    public final FrsSpriteGuideTipController d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pk7(Activity activity, ok7 ok7Var, FrsSpriteGuideTipController frsSpriteGuideTipController) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, ok7Var, frsSpriteGuideTipController};
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
        this.c = ok7Var;
        this.d = frsSpriteGuideTipController;
    }

    public static final void g(pk7 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.c();
        }
    }

    public static final void h(pk7 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.c();
        }
    }

    @Override // com.baidu.tieba.s55
    public void d(s55.a shouldShowCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shouldShowCallback) == null) {
            Intrinsics.checkNotNullParameter(shouldShowCallback, "shouldShowCallback");
            shouldShowCallback.callback(true);
        }
    }

    @Override // com.baidu.tieba.s55
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ok7 ok7Var = this.c;
            if (ok7Var != null) {
                ok7Var.o();
            }
            FrsSpriteGuideTipController frsSpriteGuideTipController = this.d;
            if (frsSpriteGuideTipController != null) {
                frsSpriteGuideTipController.g();
            }
        }
    }

    @Override // com.baidu.tieba.s55
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            DefaultLog.getInstance().c("FrsGuide", "开始显示frs吧引导");
            ok7 ok7Var = this.c;
            if (ok7Var != null) {
                DefaultLog.getInstance().c("FrsGuide", "展示线上吧引导样式");
                ok7Var.t(new or6.e() { // from class: com.baidu.tieba.kk7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.or6.e
                    public final void onDismiss() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            pk7.g(pk7.this);
                        }
                    }
                });
                ok7Var.w();
            }
            FrsSpriteGuideTipController frsSpriteGuideTipController = this.d;
            if (frsSpriteGuideTipController != null) {
                DefaultLog.getInstance().c("FrsGuide", "展示精灵吧引导样式");
                frsSpriteGuideTipController.j(new or6.e() { // from class: com.baidu.tieba.lk7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.or6.e
                    public final void onDismiss() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            pk7.h(pk7.this);
                        }
                    }
                });
                frsSpriteGuideTipController.l();
            }
        }
    }
}
