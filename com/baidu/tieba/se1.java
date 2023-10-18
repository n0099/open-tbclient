package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.searchbox.schemedispatch.forbid.InvokeStatisticKt;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkItem;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"LongLogTag"})
/* loaded from: classes8.dex */
public class se1 extends oe1 {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] a;
    public static final String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements le1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(se1 se1Var, ke1 ke1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {se1Var, ke1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements je0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean[] a;

        public b(se1 se1Var, boolean[] zArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {se1Var, zArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zArr;
        }

        @Override // com.baidu.tieba.je0
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a[0] = z;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948148426, "Lcom/baidu/tieba/se1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948148426, "Lcom/baidu/tieba/se1;");
                return;
            }
        }
        a = new String[]{InvokeStatisticKt.SCHEME_INVOKE_PAGE_DEEPLINK, "open", "mnprogram"};
        b = if0.a().a();
    }

    public se1() {
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

    @Override // com.baidu.tieba.oe1
    public void a(HashMap<String, String> hashMap) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) {
            for (String str : a) {
                hashMap.put("splash/ad/" + str, "splash_ad/" + str);
            }
        }
    }

    @Override // com.baidu.tieba.oe1
    @SuppressLint({"LongLogTag"})
    public boolean c(Context context, qe1 qe1Var, ke1 ke1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, qe1Var, ke1Var)) == null) {
            String d = qe1Var.d(true);
            if (!TextUtils.isEmpty(d) && context != null) {
                if (qe1Var.e()) {
                    return true;
                }
                char c = 65535;
                int hashCode = d.hashCode();
                if (hashCode != -1317819965) {
                    if (hashCode != 3417674) {
                        if (hashCode == 629233382 && d.equals(InvokeStatisticKt.SCHEME_INVOKE_PAGE_DEEPLINK)) {
                            c = 0;
                        }
                    } else if (d.equals("open")) {
                        c = 1;
                    }
                } else if (d.equals("mnprogram")) {
                    c = 2;
                }
                if (c != 0) {
                    if (c != 1) {
                        if (c != 2) {
                            return false;
                        }
                        return f(context, qe1Var, ke1Var);
                    }
                    return g(qe1Var, ke1Var);
                }
                return e(context, qe1Var, ke1Var);
            }
            qe1Var.i = te1.h(201);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final boolean e(@NonNull Context context, @NonNull qe1 qe1Var, ke1 ke1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, qe1Var, ke1Var)) == null) {
            String str = qe1Var.c().get("params");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString(DeepLinkItem.DEEPLINK_APPURL_KEY);
                String optString2 = jSONObject.optString(DeepLinkItem.DEEPLINK_WEBURL_KEY);
                String optString3 = jSONObject.optString("pkgName");
                if (!TextUtils.isEmpty(optString)) {
                    boolean[] zArr = new boolean[1];
                    le0.a(context, optString, optString3, new b(this, zArr), false);
                    if (zArr[0]) {
                        BaseVM.f(GrsBaseInfo.CountryCodeSource.APP);
                        return true;
                    }
                }
                if (!TextUtils.isEmpty(optString3) && le0.b(context, optString3)) {
                    BaseVM.f(GrsBaseInfo.CountryCodeSource.APP);
                    return true;
                } else if (TextUtils.isEmpty(optString2)) {
                    return false;
                } else {
                    BaseVM.f("URL");
                    return h(optString2, ke1Var);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean f(Context context, qe1 qe1Var, ke1 ke1Var) {
        InterceptResult invokeLLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, context, qe1Var, ke1Var)) == null) {
            if (TextUtils.isEmpty(b)) {
                if (ke1Var != null) {
                    ke1Var.handleSchemeDispatchCallback(String.valueOf(303), null);
                }
                return false;
            }
            String str2 = qe1Var.c().get("params");
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (TextUtils.isEmpty(jSONObject.optString("mnProgramType"))) {
                    if (ke1Var != null) {
                        ke1Var.handleSchemeDispatchCallback(String.valueOf(202), null);
                    }
                    return false;
                }
                WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
                req.userName = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
                req.path = jSONObject.optString("path");
                req.miniprogramType = jSONObject.optInt("mnProgramType");
                String optString = jSONObject.optString("extInfo");
                IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, b);
                boolean sendReq = createWXAPI.sendReq(req);
                if (!sendReq) {
                    if (!createWXAPI.isWXAppInstalled()) {
                        str = "1001";
                    } else {
                        str = "1002";
                    }
                    i("URL", optString, str);
                    return h(jSONObject.optString(DeepLinkItem.DEEPLINK_WEBURL_KEY), ke1Var);
                }
                i(ClogBuilder.Area.APP.type, optString, null);
                ke1Var.handleSchemeDispatchCallback(String.valueOf(0), null);
                return sendReq;
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean g(qe1 qe1Var, ke1 ke1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, qe1Var, ke1Var)) == null) {
            String str = qe1Var.c().get("params");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString(DeepLinkItem.DEEPLINK_WEBURL_KEY);
                if (TextUtils.isEmpty(optString)) {
                    optString = jSONObject.optString("innerUrl");
                }
                return h(optString, ke1Var);
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final boolean h(@NonNull String str, ke1 ke1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, ke1Var)) == null) {
            boolean a2 = sd1.b().a(str, new a(this, ke1Var));
            if (!a2 && ke1Var != null) {
                return ke1Var.b(str);
            }
            return a2;
        }
        return invokeLL.booleanValue;
    }

    public final void i(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) && !TextUtils.isEmpty(str2)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.u(ClogBuilder.Page.MINI_PROGRAM);
            clogBuilder.y(ClogBuilder.LogType.MINI_PROGRAM);
            clogBuilder.j(str);
            clogBuilder.p(str2);
            if (!TextUtils.isEmpty(str3)) {
                clogBuilder.k(str3);
            }
            jy0.e(clogBuilder);
        }
    }
}
