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
/* loaded from: classes8.dex */
public final class v46 {
    public static /* synthetic */ Interceptable $ic;
    public static final v46 a;
    public static final HashMap<String, wg0> b;
    public static boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static final class a implements oh0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wg0 a;

        public a(wg0 wg0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wg0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wg0Var;
        }

        @Override // com.baidu.tieba.oh0
        public void a(AdDownloadAction action, wg0 data) {
            wg0 wg0Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, action, data) == null) {
                Intrinsics.checkNotNullParameter(action, "action");
                Intrinsics.checkNotNullParameter(data, "data");
                if (action == AdDownloadAction.INSTALL_FINISH && !ny0.h(v46.b)) {
                    String str = data.d;
                    if (!TextUtils.isEmpty(str) && (wg0Var = (wg0) py0.b(v46.b, str)) != null && wg0Var.e() != null) {
                        zh0.l().t(this.a, true);
                        fh0.f().a(wg0Var.e().hashCode());
                        fh0.f().h(ClogBuilder.LogType.INSTALL_COMPLETE.type, ClogBuilder.Area.AD_NOTIFICATION_NOTIFY.type, wg0Var.p.a, wg0Var.q.m);
                        py0.g(v46.b, str);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.oh0
        public wg0 getData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a;
            }
            return (wg0) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948190865, "Lcom/baidu/tieba/v46;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948190865, "Lcom/baidu/tieba/v46;");
                return;
            }
        }
        a = new v46();
        b = new HashMap<>();
    }

    public v46() {
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

    public final void b(wg0 wg0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, wg0Var) != null) || wg0Var == null) {
            return;
        }
        a aVar = new a(wg0Var);
        AdAppStateManager.instance().register(wg0Var);
        jg0.c().k(wg0Var.e(), aVar);
    }

    public final void c(wg0 adDownloadBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadBean) == null) {
            Intrinsics.checkNotNullParameter(adDownloadBean, "adDownloadBean");
            b(adDownloadBean);
            HashMap<String, wg0> hashMap = b;
            String str = adDownloadBean.d;
            Intrinsics.checkNotNullExpressionValue(str, "adDownloadBean.packageName");
            hashMap.put(str, adDownloadBean);
            fh0.f().h(ClogBuilder.LogType.FREE_SHOW.type, ClogBuilder.Area.AD_NOTIFICATION_SHOW.type, adDownloadBean.p.a, adDownloadBean.q.m);
            if (!c) {
                fh0.f().h(ClogBuilder.LogType.FREE_SHOW.type, ClogBuilder.Area.AD_NOTIFICATION_NOTIFY.type, "", String.valueOf(w46.b.a() + 1));
                c = true;
            }
            zh0.l().t(adDownloadBean, false);
        }
    }
}
