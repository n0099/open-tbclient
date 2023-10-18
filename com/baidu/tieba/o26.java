package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.basic.AdAppStateManager;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class o26 {
    public static /* synthetic */ Interceptable $ic;
    public static final o26 a;
    public static final HashMap<String, eg0> b;
    public static boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a implements wg0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eg0 a;

        public a(eg0 eg0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eg0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eg0Var;
        }

        @Override // com.baidu.tieba.wg0
        public void a(AdDownloadAction action, eg0 data) {
            eg0 eg0Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, action, data) == null) {
                Intrinsics.checkNotNullParameter(action, "action");
                Intrinsics.checkNotNullParameter(data, "data");
                if (action == AdDownloadAction.INSTALL_FINISH && !tx0.h(o26.b)) {
                    String str = data.d;
                    if (!TextUtils.isEmpty(str) && (eg0Var = (eg0) vx0.b(o26.b, str)) != null && eg0Var.e() != null) {
                        hh0.l().t(this.a, true);
                        ng0.f().a(eg0Var.e().hashCode());
                        ng0.f().h(ClogBuilder.LogType.INSTALL_COMPLETE.type, ClogBuilder.Area.AD_NOTIFICATION_NOTIFY.type, eg0Var.p.a, eg0Var.q.m);
                        vx0.g(o26.b, str);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.wg0
        public eg0 getData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a;
            }
            return (eg0) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947980406, "Lcom/baidu/tieba/o26;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947980406, "Lcom/baidu/tieba/o26;");
                return;
            }
        }
        a = new o26();
        b = new HashMap<>();
    }

    public o26() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final void b(eg0 eg0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, eg0Var) != null) || eg0Var == null) {
            return;
        }
        a aVar = new a(eg0Var);
        AdAppStateManager.instance().register(eg0Var);
        rf0.c().k(eg0Var.e(), aVar);
    }

    public final void c(eg0 adDownloadBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadBean) == null) {
            Intrinsics.checkNotNullParameter(adDownloadBean, "adDownloadBean");
            b(adDownloadBean);
            HashMap<String, eg0> hashMap = b;
            String str = adDownloadBean.d;
            Intrinsics.checkNotNullExpressionValue(str, "adDownloadBean.packageName");
            hashMap.put(str, adDownloadBean);
            ng0.f().h(ClogBuilder.LogType.FREE_SHOW.type, ClogBuilder.Area.AD_NOTIFICATION_SHOW.type, adDownloadBean.p.a, adDownloadBean.q.m);
            if (!c) {
                ng0.f().h(ClogBuilder.LogType.FREE_SHOW.type, ClogBuilder.Area.AD_NOTIFICATION_NOTIFY.type, "", String.valueOf(p26.b.a() + 1));
                c = true;
            }
            hh0.l().t(adDownloadBean, false);
        }
    }
}
