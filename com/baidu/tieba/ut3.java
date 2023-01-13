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
/* loaded from: classes6.dex */
public class ut3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends ResponseCallback<bs3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xs3 a;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }

        public a(xs3 xs3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xs3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xs3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(bs3 bs3Var, int i) {
            xs3 xs3Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, bs3Var, i) == null) && bs3Var != null && (xs3Var = this.a) != null) {
                xs3Var.d(bs3Var.a, bs3Var.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public bs3 parseResponse(Response response, int i) {
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
                            bs3 bs3Var = new bs3();
                            bs3Var.a = optJSONObject.optString("clickid");
                            bs3Var.b = optJSONObject.optString("dstlink");
                            return bs3Var;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception | OutOfMemoryError unused) {
                }
                return null;
            }
            return (bs3) invokeLI.objValue;
        }
    }

    public static void a(rt3 rt3Var, AdElementInfo adElementInfo, at3 at3Var, xs3 xs3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65536, null, rt3Var, adElementInfo, at3Var, xs3Var) == null) && adElementInfo != null && !TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            String c = c(adElementInfo.getClickUrl(), rt3Var);
            a aVar = new a(xs3Var);
            if (NetworkUtils.f(AppRuntime.getAppContext()) && at3Var != null) {
                at3Var.c(c, aVar);
            }
        }
    }

    public static void b(String str, at3 at3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, at3Var) == null) {
            at3Var.e(str);
        }
    }

    public static void d(AdElementInfo adElementInfo, at3 at3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, adElementInfo, at3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), at3Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, at3 at3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65541, null, adElementInfo, at3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), at3Var);
        }
    }

    public static String c(String str, rt3 rt3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, rt3Var)) == null) {
            if (rt3Var == null) {
                return str;
            }
            return str.replaceAll("\\{REQ_WIDTH\\}", rt3Var.a).replaceAll("\\{REQ_HEIGHT\\}", rt3Var.b).replaceAll("\\{WIDTH\\}", rt3Var.c).replaceAll("\\{HEIGHT\\}", rt3Var.d).replaceAll("\\{DOWN_X\\}", rt3Var.e).replaceAll("\\{DOWN_Y\\}", rt3Var.f).replaceAll("\\{UP_X\\}", rt3Var.g).replaceAll("\\{UP_Y\\}", rt3Var.h).replaceAll("\\{VIDEO_TIME\\}", rt3Var.i).replaceAll("\\{BEGIN_TIME\\}", rt3Var.j).replaceAll("\\{END_TIME\\}", rt3Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", rt3Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", rt3Var.m).replaceAll("\\{SCENE\\}", rt3Var.n).replaceAll("\\{TYPE\\}", rt3Var.o).replaceAll("\\{BEHAVIOR\\}", rt3Var.p).replaceAll("\\{STATUS\\}", rt3Var.q).replaceAll("\\{CONVERSION_ACTION\\}", rt3Var.r).replaceAll("\\{CLICK_ID\\}", rt3Var.s);
        }
        return (String) invokeLL.objValue;
    }

    public static void e(rt3 rt3Var, AdElementInfo adElementInfo, at3 at3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, rt3Var, adElementInfo, at3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, rt3Var), at3Var);
        }
    }

    public static void g(rt3 rt3Var, AdElementInfo adElementInfo, at3 at3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, rt3Var, adElementInfo, at3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, rt3Var), at3Var);
        }
    }
}
