package com.baidu.tieba;

import android.app.Activity;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.gametab.FrsSpriteGuideTipController;
import com.baidu.tieba.n55;
import com.baidu.tieba.yt6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class up7 extends n55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final tp7 c;
    public final FrsSpriteGuideTipController d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public up7(Activity activity, tp7 tp7Var, FrsSpriteGuideTipController frsSpriteGuideTipController) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, tp7Var, frsSpriteGuideTipController};
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
        this.c = tp7Var;
        this.d = frsSpriteGuideTipController;
    }

    public static final void g(up7 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.c();
        }
    }

    public static final void h(up7 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.c();
        }
    }

    @Override // com.baidu.tieba.n55
    public void d(n55.a shouldShowCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shouldShowCallback) == null) {
            Intrinsics.checkNotNullParameter(shouldShowCallback, "shouldShowCallback");
            shouldShowCallback.callback(true);
        }
    }

    @Override // com.baidu.tieba.n55
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            tp7 tp7Var = this.c;
            if (tp7Var != null) {
                tp7Var.o();
            }
            FrsSpriteGuideTipController frsSpriteGuideTipController = this.d;
            if (frsSpriteGuideTipController != null) {
                frsSpriteGuideTipController.g();
            }
        }
    }

    @Override // com.baidu.tieba.n55
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            DefaultLog.getInstance().i("FrsGuide", "开始显示frs吧引导");
            tp7 tp7Var = this.c;
            if (tp7Var != null) {
                DefaultLog.getInstance().i("FrsGuide", "展示线上吧引导样式");
                tp7Var.t(new yt6.e() { // from class: com.baidu.tieba.op7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.yt6.e
                    public final void onDismiss() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            up7.g(up7.this);
                        }
                    }
                });
                tp7Var.w();
            }
            FrsSpriteGuideTipController frsSpriteGuideTipController = this.d;
            if (frsSpriteGuideTipController != null) {
                DefaultLog.getInstance().i("FrsGuide", "展示精灵吧引导样式");
                frsSpriteGuideTipController.j(new yt6.e() { // from class: com.baidu.tieba.qp7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.yt6.e
                    public final void onDismiss() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            up7.h(up7.this);
                        }
                    }
                });
                frsSpriteGuideTipController.l();
            }
        }
    }
}
