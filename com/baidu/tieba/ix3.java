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
public class ix3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends ResponseCallback<pv3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lw3 a;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }

        public a(lw3 lw3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lw3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lw3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(pv3 pv3Var, int i) {
            lw3 lw3Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, pv3Var, i) == null) && pv3Var != null && (lw3Var = this.a) != null) {
                lw3Var.d(pv3Var.a, pv3Var.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public pv3 parseResponse(Response response, int i) {
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
                            pv3 pv3Var = new pv3();
                            pv3Var.a = optJSONObject.optString("clickid");
                            pv3Var.b = optJSONObject.optString("dstlink");
                            return pv3Var;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception | OutOfMemoryError unused) {
                }
                return null;
            }
            return (pv3) invokeLI.objValue;
        }
    }

    public static void a(fx3 fx3Var, AdElementInfo adElementInfo, ow3 ow3Var, lw3 lw3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65536, null, fx3Var, adElementInfo, ow3Var, lw3Var) == null) && adElementInfo != null && !TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            String c = c(adElementInfo.getClickUrl(), fx3Var);
            a aVar = new a(lw3Var);
            if (NetworkUtils.f(AppRuntime.getAppContext()) && ow3Var != null) {
                ow3Var.c(c, aVar);
            }
        }
    }

    public static void b(String str, ow3 ow3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, ow3Var) == null) {
            ow3Var.e(str);
        }
    }

    public static void d(AdElementInfo adElementInfo, ow3 ow3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, adElementInfo, ow3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), ow3Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, ow3 ow3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65541, null, adElementInfo, ow3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), ow3Var);
        }
    }

    public static String c(String str, fx3 fx3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, fx3Var)) == null) {
            if (fx3Var == null) {
                return str;
            }
            return str.replaceAll("\\{REQ_WIDTH\\}", fx3Var.a).replaceAll("\\{REQ_HEIGHT\\}", fx3Var.b).replaceAll("\\{WIDTH\\}", fx3Var.c).replaceAll("\\{HEIGHT\\}", fx3Var.d).replaceAll("\\{DOWN_X\\}", fx3Var.e).replaceAll("\\{DOWN_Y\\}", fx3Var.f).replaceAll("\\{UP_X\\}", fx3Var.g).replaceAll("\\{UP_Y\\}", fx3Var.h).replaceAll("\\{VIDEO_TIME\\}", fx3Var.i).replaceAll("\\{BEGIN_TIME\\}", fx3Var.j).replaceAll("\\{END_TIME\\}", fx3Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", fx3Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", fx3Var.m).replaceAll("\\{SCENE\\}", fx3Var.n).replaceAll("\\{TYPE\\}", fx3Var.o).replaceAll("\\{BEHAVIOR\\}", fx3Var.p).replaceAll("\\{STATUS\\}", fx3Var.q).replaceAll("\\{CONVERSION_ACTION\\}", fx3Var.r).replaceAll("\\{CLICK_ID\\}", fx3Var.s);
        }
        return (String) invokeLL.objValue;
    }

    public static void e(fx3 fx3Var, AdElementInfo adElementInfo, ow3 ow3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, fx3Var, adElementInfo, ow3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, fx3Var), ow3Var);
        }
    }

    public static void g(fx3 fx3Var, AdElementInfo adElementInfo, ow3 ow3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, fx3Var, adElementInfo, ow3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, fx3Var), ow3Var);
        }
    }
}
