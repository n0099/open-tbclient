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
/* loaded from: classes8.dex */
public class rv3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends ResponseCallback<yt3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uu3 a;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }

        public a(uu3 uu3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uu3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uu3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(yt3 yt3Var, int i) {
            uu3 uu3Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, yt3Var, i) == null) && yt3Var != null && (uu3Var = this.a) != null) {
                uu3Var.d(yt3Var.a, yt3Var.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public yt3 parseResponse(Response response, int i) {
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
                            yt3 yt3Var = new yt3();
                            yt3Var.a = optJSONObject.optString("clickid");
                            yt3Var.b = optJSONObject.optString("dstlink");
                            return yt3Var;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception | OutOfMemoryError unused) {
                }
                return null;
            }
            return (yt3) invokeLI.objValue;
        }
    }

    public static void a(ov3 ov3Var, AdElementInfo adElementInfo, xu3 xu3Var, uu3 uu3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65536, null, ov3Var, adElementInfo, xu3Var, uu3Var) == null) && adElementInfo != null && !TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            String c = c(adElementInfo.getClickUrl(), ov3Var);
            a aVar = new a(uu3Var);
            if (NetworkUtils.f(AppRuntime.getAppContext()) && xu3Var != null) {
                xu3Var.c(c, aVar);
            }
        }
    }

    public static void b(String str, xu3 xu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, xu3Var) == null) {
            xu3Var.e(str);
        }
    }

    public static void d(AdElementInfo adElementInfo, xu3 xu3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, adElementInfo, xu3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), xu3Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, xu3 xu3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65541, null, adElementInfo, xu3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), xu3Var);
        }
    }

    public static String c(String str, ov3 ov3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, ov3Var)) == null) {
            if (ov3Var == null) {
                return str;
            }
            return str.replaceAll("\\{REQ_WIDTH\\}", ov3Var.a).replaceAll("\\{REQ_HEIGHT\\}", ov3Var.b).replaceAll("\\{WIDTH\\}", ov3Var.c).replaceAll("\\{HEIGHT\\}", ov3Var.d).replaceAll("\\{DOWN_X\\}", ov3Var.e).replaceAll("\\{DOWN_Y\\}", ov3Var.f).replaceAll("\\{UP_X\\}", ov3Var.g).replaceAll("\\{UP_Y\\}", ov3Var.h).replaceAll("\\{VIDEO_TIME\\}", ov3Var.i).replaceAll("\\{BEGIN_TIME\\}", ov3Var.j).replaceAll("\\{END_TIME\\}", ov3Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", ov3Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", ov3Var.m).replaceAll("\\{SCENE\\}", ov3Var.n).replaceAll("\\{TYPE\\}", ov3Var.o).replaceAll("\\{BEHAVIOR\\}", ov3Var.p).replaceAll("\\{STATUS\\}", ov3Var.q).replaceAll("\\{CONVERSION_ACTION\\}", ov3Var.r).replaceAll("\\{CLICK_ID\\}", ov3Var.s);
        }
        return (String) invokeLL.objValue;
    }

    public static void e(ov3 ov3Var, AdElementInfo adElementInfo, xu3 xu3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ov3Var, adElementInfo, xu3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, ov3Var), xu3Var);
        }
    }

    public static void g(ov3 ov3Var, AdElementInfo adElementInfo, xu3 xu3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, ov3Var, adElementInfo, xu3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, ov3Var), xu3Var);
        }
    }
}
