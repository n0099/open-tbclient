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
public class xy3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends ResponseCallback<ex3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ay3 a;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }

        public a(ay3 ay3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ay3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ay3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(ex3 ex3Var, int i) {
            ay3 ay3Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, ex3Var, i) == null) && ex3Var != null && (ay3Var = this.a) != null) {
                ay3Var.d(ex3Var.a, ex3Var.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public ex3 parseResponse(Response response, int i) {
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
                            ex3 ex3Var = new ex3();
                            ex3Var.a = optJSONObject.optString("clickid");
                            ex3Var.b = optJSONObject.optString("dstlink");
                            return ex3Var;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception | OutOfMemoryError unused) {
                }
                return null;
            }
            return (ex3) invokeLI.objValue;
        }
    }

    public static void a(uy3 uy3Var, AdElementInfo adElementInfo, dy3 dy3Var, ay3 ay3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65536, null, uy3Var, adElementInfo, dy3Var, ay3Var) == null) && adElementInfo != null && !TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            String c = c(adElementInfo.getClickUrl(), uy3Var);
            a aVar = new a(ay3Var);
            if (NetworkUtils.f(AppRuntime.getAppContext()) && dy3Var != null) {
                dy3Var.c(c, aVar);
            }
        }
    }

    public static void b(String str, dy3 dy3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, dy3Var) == null) {
            dy3Var.e(str);
        }
    }

    public static void d(AdElementInfo adElementInfo, dy3 dy3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, adElementInfo, dy3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), dy3Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, dy3 dy3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65541, null, adElementInfo, dy3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), dy3Var);
        }
    }

    public static String c(String str, uy3 uy3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, uy3Var)) == null) {
            if (uy3Var == null) {
                return str;
            }
            return str.replaceAll("\\{REQ_WIDTH\\}", uy3Var.a).replaceAll("\\{REQ_HEIGHT\\}", uy3Var.b).replaceAll("\\{WIDTH\\}", uy3Var.c).replaceAll("\\{HEIGHT\\}", uy3Var.d).replaceAll("\\{DOWN_X\\}", uy3Var.e).replaceAll("\\{DOWN_Y\\}", uy3Var.f).replaceAll("\\{UP_X\\}", uy3Var.g).replaceAll("\\{UP_Y\\}", uy3Var.h).replaceAll("\\{VIDEO_TIME\\}", uy3Var.i).replaceAll("\\{BEGIN_TIME\\}", uy3Var.j).replaceAll("\\{END_TIME\\}", uy3Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", uy3Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", uy3Var.m).replaceAll("\\{SCENE\\}", uy3Var.n).replaceAll("\\{TYPE\\}", uy3Var.o).replaceAll("\\{BEHAVIOR\\}", uy3Var.p).replaceAll("\\{STATUS\\}", uy3Var.q).replaceAll("\\{CONVERSION_ACTION\\}", uy3Var.r).replaceAll("\\{CLICK_ID\\}", uy3Var.s);
        }
        return (String) invokeLL.objValue;
    }

    public static void e(uy3 uy3Var, AdElementInfo adElementInfo, dy3 dy3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, uy3Var, adElementInfo, dy3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, uy3Var), dy3Var);
        }
    }

    public static void g(uy3 uy3Var, AdElementInfo adElementInfo, dy3 dy3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, uy3Var, adElementInfo, dy3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, uy3Var), dy3Var);
        }
    }
}
