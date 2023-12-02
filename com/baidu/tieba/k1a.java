package com.baidu.tieba;

import android.app.Activity;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.j1a;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.u05;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class k1a extends u05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final j1a c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947861614, "Lcom/baidu/tieba/k1a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947861614, "Lcom/baidu/tieba/k1a;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k1a(Activity activity, j1a pbTopicRecommendTipController) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, pbTopicRecommendTipController};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(pbTopicRecommendTipController, "pbTopicRecommendTipController");
        this.c = pbTopicRecommendTipController;
    }

    public static final void g(k1a this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.c();
        }
    }

    @Override // com.baidu.tieba.u05
    public void d(u05.a shouldShowCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shouldShowCallback) == null) {
            Intrinsics.checkNotNullParameter(shouldShowCallback, "shouldShowCallback");
            shouldShowCallback.callback(this.c.f());
        }
    }

    @Override // com.baidu.tieba.u05
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.j();
        }
    }

    @Override // com.baidu.tieba.u05
    public void e() {
        boolean s;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.p(new j1a.f() { // from class: com.baidu.tieba.cz9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.j1a.f
                public final void onDismiss() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        k1a.g(k1a.this);
                    }
                }
            });
            if (lk5.g(false, 1, null)) {
                DefaultLog.getInstance().i("PbTopicTip", "开始展示精灵动画提示控件");
                s = this.c.t();
            } else {
                DefaultLog.getInstance().i("PbTopicTip", "开始展示线上动画提示控件");
                s = this.c.s();
            }
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.i("PbTopicTip", "pb相关话题引导tip触发展示：" + s);
            if (!s) {
                c();
            }
        }
    }
}
