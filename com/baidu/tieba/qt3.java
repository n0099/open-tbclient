package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class qt3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends ResponseCallback<xr3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ts3 a;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }

        public a(ts3 ts3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ts3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ts3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(xr3 xr3Var, int i) {
            ts3 ts3Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, xr3Var, i) == null) && xr3Var != null && (ts3Var = this.a) != null) {
                ts3Var.d(xr3Var.a, xr3Var.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public xr3 parseResponse(Response response, int i) {
            InterceptResult invokeLI;
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i)) == null) {
                if (response == null || response.body() == null || !response.isSuccessful()) {
                    return null;
                }
                try {
                    String string = response.body().string();
                    if (!TextUtils.isEmpty(string)) {
                        try {
                            JSONObject jSONObject = new JSONObject(string);
                            if (!TextUtils.equals(jSONObject.optString(Constants.KEYS.RET, ""), "0") || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                                return null;
                            }
                            xr3 xr3Var = new xr3();
                            xr3Var.a = optJSONObject.optString("clickid");
                            xr3Var.b = optJSONObject.optString("dstlink");
                            return xr3Var;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception | OutOfMemoryError unused) {
                }
                return null;
            }
            return (xr3) invokeLI.objValue;
        }
    }

    public static void a(nt3 nt3Var, AdElementInfo adElementInfo, ws3 ws3Var, ts3 ts3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65536, null, nt3Var, adElementInfo, ws3Var, ts3Var) == null) && adElementInfo != null && !TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            String c = c(adElementInfo.getClickUrl(), nt3Var);
            a aVar = new a(ts3Var);
            if (NetworkUtils.f(AppRuntime.getAppContext()) && ws3Var != null) {
                ws3Var.c(c, aVar);
            }
        }
    }

    public static void b(String str, ws3 ws3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, ws3Var) == null) {
            ws3Var.e(str);
        }
    }

    public static void d(AdElementInfo adElementInfo, ws3 ws3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, adElementInfo, ws3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), ws3Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, ws3 ws3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65541, null, adElementInfo, ws3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), ws3Var);
        }
    }

    public static String c(String str, nt3 nt3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, nt3Var)) == null) {
            if (nt3Var == null) {
                return str;
            }
            return str.replaceAll("\\{REQ_WIDTH\\}", nt3Var.a).replaceAll("\\{REQ_HEIGHT\\}", nt3Var.b).replaceAll("\\{WIDTH\\}", nt3Var.c).replaceAll("\\{HEIGHT\\}", nt3Var.d).replaceAll("\\{DOWN_X\\}", nt3Var.e).replaceAll("\\{DOWN_Y\\}", nt3Var.f).replaceAll("\\{UP_X\\}", nt3Var.g).replaceAll("\\{UP_Y\\}", nt3Var.h).replaceAll("\\{VIDEO_TIME\\}", nt3Var.i).replaceAll("\\{BEGIN_TIME\\}", nt3Var.j).replaceAll("\\{END_TIME\\}", nt3Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", nt3Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", nt3Var.m).replaceAll("\\{SCENE\\}", nt3Var.n).replaceAll("\\{TYPE\\}", nt3Var.o).replaceAll("\\{BEHAVIOR\\}", nt3Var.p).replaceAll("\\{STATUS\\}", nt3Var.q).replaceAll("\\{CONVERSION_ACTION\\}", nt3Var.r).replaceAll("\\{CLICK_ID\\}", nt3Var.s);
        }
        return (String) invokeLL.objValue;
    }

    public static void e(nt3 nt3Var, AdElementInfo adElementInfo, ws3 ws3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, nt3Var, adElementInfo, ws3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, nt3Var), ws3Var);
        }
    }

    public static void g(nt3 nt3Var, AdElementInfo adElementInfo, ws3 ws3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, nt3Var, adElementInfo, ws3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, nt3Var), ws3Var);
        }
    }
}
