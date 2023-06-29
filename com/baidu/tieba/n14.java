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
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class n14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends ResponseCallback<uz3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q04 a;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }

        public a(q04 q04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q04Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(uz3 uz3Var, int i) {
            q04 q04Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, uz3Var, i) == null) && uz3Var != null && (q04Var = this.a) != null) {
                q04Var.d(uz3Var.a, uz3Var.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public uz3 parseResponse(Response response, int i) {
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
                            if (!TextUtils.equals(jSONObject.optString("ret", ""), "0") || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                                return null;
                            }
                            uz3 uz3Var = new uz3();
                            uz3Var.a = optJSONObject.optString("clickid");
                            uz3Var.b = optJSONObject.optString("dstlink");
                            return uz3Var;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception | OutOfMemoryError unused) {
                }
                return null;
            }
            return (uz3) invokeLI.objValue;
        }
    }

    public static void a(k14 k14Var, AdElementInfo adElementInfo, t04 t04Var, q04 q04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65536, null, k14Var, adElementInfo, t04Var, q04Var) == null) && adElementInfo != null && !TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            String c = c(adElementInfo.getClickUrl(), k14Var);
            a aVar = new a(q04Var);
            if (NetworkUtils.f(AppRuntime.getAppContext()) && t04Var != null) {
                t04Var.c(c, aVar);
            }
        }
    }

    public static void b(String str, t04 t04Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, t04Var) == null) {
            t04Var.e(str);
        }
    }

    public static void d(AdElementInfo adElementInfo, t04 t04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, adElementInfo, t04Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), t04Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, t04 t04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65541, null, adElementInfo, t04Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), t04Var);
        }
    }

    public static String c(String str, k14 k14Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, k14Var)) == null) {
            if (k14Var == null) {
                return str;
            }
            return str.replaceAll("\\{REQ_WIDTH\\}", k14Var.a).replaceAll("\\{REQ_HEIGHT\\}", k14Var.b).replaceAll("\\{WIDTH\\}", k14Var.c).replaceAll("\\{HEIGHT\\}", k14Var.d).replaceAll("\\{DOWN_X\\}", k14Var.e).replaceAll("\\{DOWN_Y\\}", k14Var.f).replaceAll("\\{UP_X\\}", k14Var.g).replaceAll("\\{UP_Y\\}", k14Var.h).replaceAll("\\{VIDEO_TIME\\}", k14Var.i).replaceAll("\\{BEGIN_TIME\\}", k14Var.j).replaceAll("\\{END_TIME\\}", k14Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", k14Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", k14Var.m).replaceAll("\\{SCENE\\}", k14Var.n).replaceAll("\\{TYPE\\}", k14Var.o).replaceAll("\\{BEHAVIOR\\}", k14Var.p).replaceAll("\\{STATUS\\}", k14Var.q).replaceAll("\\{CONVERSION_ACTION\\}", k14Var.r).replaceAll("\\{CLICK_ID\\}", k14Var.s);
        }
        return (String) invokeLL.objValue;
    }

    public static void e(k14 k14Var, AdElementInfo adElementInfo, t04 t04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, k14Var, adElementInfo, t04Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, k14Var), t04Var);
        }
    }

    public static void g(k14 k14Var, AdElementInfo adElementInfo, t04 t04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, k14Var, adElementInfo, t04Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, k14Var), t04Var);
        }
    }
}
