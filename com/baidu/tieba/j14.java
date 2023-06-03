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
/* loaded from: classes6.dex */
public class j14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends ResponseCallback<qz3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m04 a;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }

        public a(m04 m04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m04Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(qz3 qz3Var, int i) {
            m04 m04Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, qz3Var, i) == null) && qz3Var != null && (m04Var = this.a) != null) {
                m04Var.d(qz3Var.a, qz3Var.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public qz3 parseResponse(Response response, int i) {
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
                            qz3 qz3Var = new qz3();
                            qz3Var.a = optJSONObject.optString("clickid");
                            qz3Var.b = optJSONObject.optString("dstlink");
                            return qz3Var;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception | OutOfMemoryError unused) {
                }
                return null;
            }
            return (qz3) invokeLI.objValue;
        }
    }

    public static void a(g14 g14Var, AdElementInfo adElementInfo, p04 p04Var, m04 m04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65536, null, g14Var, adElementInfo, p04Var, m04Var) == null) && adElementInfo != null && !TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            String c = c(adElementInfo.getClickUrl(), g14Var);
            a aVar = new a(m04Var);
            if (NetworkUtils.f(AppRuntime.getAppContext()) && p04Var != null) {
                p04Var.c(c, aVar);
            }
        }
    }

    public static void b(String str, p04 p04Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, p04Var) == null) {
            p04Var.e(str);
        }
    }

    public static void d(AdElementInfo adElementInfo, p04 p04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, adElementInfo, p04Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), p04Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, p04 p04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65541, null, adElementInfo, p04Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), p04Var);
        }
    }

    public static String c(String str, g14 g14Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, g14Var)) == null) {
            if (g14Var == null) {
                return str;
            }
            return str.replaceAll("\\{REQ_WIDTH\\}", g14Var.a).replaceAll("\\{REQ_HEIGHT\\}", g14Var.b).replaceAll("\\{WIDTH\\}", g14Var.c).replaceAll("\\{HEIGHT\\}", g14Var.d).replaceAll("\\{DOWN_X\\}", g14Var.e).replaceAll("\\{DOWN_Y\\}", g14Var.f).replaceAll("\\{UP_X\\}", g14Var.g).replaceAll("\\{UP_Y\\}", g14Var.h).replaceAll("\\{VIDEO_TIME\\}", g14Var.i).replaceAll("\\{BEGIN_TIME\\}", g14Var.j).replaceAll("\\{END_TIME\\}", g14Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", g14Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", g14Var.m).replaceAll("\\{SCENE\\}", g14Var.n).replaceAll("\\{TYPE\\}", g14Var.o).replaceAll("\\{BEHAVIOR\\}", g14Var.p).replaceAll("\\{STATUS\\}", g14Var.q).replaceAll("\\{CONVERSION_ACTION\\}", g14Var.r).replaceAll("\\{CLICK_ID\\}", g14Var.s);
        }
        return (String) invokeLL.objValue;
    }

    public static void e(g14 g14Var, AdElementInfo adElementInfo, p04 p04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, g14Var, adElementInfo, p04Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, g14Var), p04Var);
        }
    }

    public static void g(g14 g14Var, AdElementInfo adElementInfo, p04 p04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, g14Var, adElementInfo, p04Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, g14Var), p04Var);
        }
    }
}
