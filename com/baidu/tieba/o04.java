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
public class o04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends ResponseCallback<vy3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rz3 a;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }

        public a(rz3 rz3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rz3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rz3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(vy3 vy3Var, int i) {
            rz3 rz3Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, vy3Var, i) == null) && vy3Var != null && (rz3Var = this.a) != null) {
                rz3Var.d(vy3Var.a, vy3Var.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public vy3 parseResponse(Response response, int i) {
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
                            vy3 vy3Var = new vy3();
                            vy3Var.a = optJSONObject.optString("clickid");
                            vy3Var.b = optJSONObject.optString("dstlink");
                            return vy3Var;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception | OutOfMemoryError unused) {
                }
                return null;
            }
            return (vy3) invokeLI.objValue;
        }
    }

    public static void a(l04 l04Var, AdElementInfo adElementInfo, uz3 uz3Var, rz3 rz3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65536, null, l04Var, adElementInfo, uz3Var, rz3Var) == null) && adElementInfo != null && !TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            String c = c(adElementInfo.getClickUrl(), l04Var);
            a aVar = new a(rz3Var);
            if (NetworkUtils.f(AppRuntime.getAppContext()) && uz3Var != null) {
                uz3Var.c(c, aVar);
            }
        }
    }

    public static void b(String str, uz3 uz3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, uz3Var) == null) {
            uz3Var.e(str);
        }
    }

    public static void d(AdElementInfo adElementInfo, uz3 uz3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, adElementInfo, uz3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), uz3Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, uz3 uz3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65541, null, adElementInfo, uz3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), uz3Var);
        }
    }

    public static String c(String str, l04 l04Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, l04Var)) == null) {
            if (l04Var == null) {
                return str;
            }
            return str.replaceAll("\\{REQ_WIDTH\\}", l04Var.a).replaceAll("\\{REQ_HEIGHT\\}", l04Var.b).replaceAll("\\{WIDTH\\}", l04Var.c).replaceAll("\\{HEIGHT\\}", l04Var.d).replaceAll("\\{DOWN_X\\}", l04Var.e).replaceAll("\\{DOWN_Y\\}", l04Var.f).replaceAll("\\{UP_X\\}", l04Var.g).replaceAll("\\{UP_Y\\}", l04Var.h).replaceAll("\\{VIDEO_TIME\\}", l04Var.i).replaceAll("\\{BEGIN_TIME\\}", l04Var.j).replaceAll("\\{END_TIME\\}", l04Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", l04Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", l04Var.m).replaceAll("\\{SCENE\\}", l04Var.n).replaceAll("\\{TYPE\\}", l04Var.o).replaceAll("\\{BEHAVIOR\\}", l04Var.p).replaceAll("\\{STATUS\\}", l04Var.q).replaceAll("\\{CONVERSION_ACTION\\}", l04Var.r).replaceAll("\\{CLICK_ID\\}", l04Var.s);
        }
        return (String) invokeLL.objValue;
    }

    public static void e(l04 l04Var, AdElementInfo adElementInfo, uz3 uz3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, l04Var, adElementInfo, uz3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, l04Var), uz3Var);
        }
    }

    public static void g(l04 l04Var, AdElementInfo adElementInfo, uz3 uz3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, l04Var, adElementInfo, uz3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, l04Var), uz3Var);
        }
    }
}
