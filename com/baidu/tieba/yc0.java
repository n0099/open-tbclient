package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.HashMap;
import java.util.Map;
@Service
/* loaded from: classes9.dex */
public class yc0 extends re0 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.re0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "mnprogram" : (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948325219, "Lcom/baidu/tieba/yc0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948325219, "Lcom/baidu/tieba/yc0;");
                return;
            }
        }
        a = ag0.a().a();
    }

    public yc0() {
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

    @Override // com.baidu.tieba.re0
    public boolean b(@NonNull Context context, @NonNull ve0 ve0Var, @Nullable Map<String, Object> map, @Nullable ze0 ze0Var) {
        InterceptResult invokeLLLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ve0Var, map, ze0Var)) == null) {
            super.b(context, ve0Var, map, ze0Var);
            if (TextUtils.isEmpty(a)) {
                c(ze0Var, ve0Var, 303, false);
                return true;
            }
            HashMap<String, String> d = ve0Var.d();
            if (TextUtils.isEmpty((CharSequence) py0.b(d, "mn_program_type"))) {
                c(ze0Var, ve0Var, 202, false);
                return true;
            }
            WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
            req.userName = (String) py0.b(d, "user_name");
            req.path = (String) py0.b(d, "path");
            req.miniprogramType = Integer.parseInt((String) py0.b(d, "mn_program_type"));
            String str2 = (String) py0.b(d, MigrateStatisticUtils.EXT_INFO);
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, a);
            boolean sendReq = createWXAPI.sendReq(req);
            if (!sendReq) {
                if (!createWXAPI.isWXAppInstalled()) {
                    str = "1001";
                } else {
                    str = "1002";
                }
                e("URL", str2, str);
                return qe0.e((String) py0.b(d, "web_url"), context, map, ze0Var);
            }
            e(ClogBuilder.Area.APP.type, str2, null);
            c(ze0Var, ve0Var, 0, sendReq);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void e(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3) == null) && !TextUtils.isEmpty(str2)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.u(ClogBuilder.Page.MINI_PROGRAM);
            clogBuilder.y(ClogBuilder.LogType.MINI_PROGRAM);
            clogBuilder.j(str);
            clogBuilder.p(str2);
            if (!TextUtils.isEmpty(str3)) {
                clogBuilder.k(str3);
            }
            dz0.e(clogBuilder);
        }
    }
}
