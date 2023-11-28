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
public class sv3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends ResponseCallback<zt3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vu3 a;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }

        public a(vu3 vu3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vu3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vu3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(zt3 zt3Var, int i) {
            vu3 vu3Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, zt3Var, i) == null) && zt3Var != null && (vu3Var = this.a) != null) {
                vu3Var.d(zt3Var.a, zt3Var.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public zt3 parseResponse(Response response, int i) {
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
                            zt3 zt3Var = new zt3();
                            zt3Var.a = optJSONObject.optString("clickid");
                            zt3Var.b = optJSONObject.optString("dstlink");
                            return zt3Var;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception | OutOfMemoryError unused) {
                }
                return null;
            }
            return (zt3) invokeLI.objValue;
        }
    }

    public static void a(pv3 pv3Var, AdElementInfo adElementInfo, yu3 yu3Var, vu3 vu3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65536, null, pv3Var, adElementInfo, yu3Var, vu3Var) == null) && adElementInfo != null && !TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            String c = c(adElementInfo.getClickUrl(), pv3Var);
            a aVar = new a(vu3Var);
            if (NetworkUtils.f(AppRuntime.getAppContext()) && yu3Var != null) {
                yu3Var.c(c, aVar);
            }
        }
    }

    public static void b(String str, yu3 yu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, yu3Var) == null) {
            yu3Var.e(str);
        }
    }

    public static void d(AdElementInfo adElementInfo, yu3 yu3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, adElementInfo, yu3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), yu3Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, yu3 yu3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65541, null, adElementInfo, yu3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), yu3Var);
        }
    }

    public static String c(String str, pv3 pv3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, pv3Var)) == null) {
            if (pv3Var == null) {
                return str;
            }
            return str.replaceAll("\\{REQ_WIDTH\\}", pv3Var.a).replaceAll("\\{REQ_HEIGHT\\}", pv3Var.b).replaceAll("\\{WIDTH\\}", pv3Var.c).replaceAll("\\{HEIGHT\\}", pv3Var.d).replaceAll("\\{DOWN_X\\}", pv3Var.e).replaceAll("\\{DOWN_Y\\}", pv3Var.f).replaceAll("\\{UP_X\\}", pv3Var.g).replaceAll("\\{UP_Y\\}", pv3Var.h).replaceAll("\\{VIDEO_TIME\\}", pv3Var.i).replaceAll("\\{BEGIN_TIME\\}", pv3Var.j).replaceAll("\\{END_TIME\\}", pv3Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", pv3Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", pv3Var.m).replaceAll("\\{SCENE\\}", pv3Var.n).replaceAll("\\{TYPE\\}", pv3Var.o).replaceAll("\\{BEHAVIOR\\}", pv3Var.p).replaceAll("\\{STATUS\\}", pv3Var.q).replaceAll("\\{CONVERSION_ACTION\\}", pv3Var.r).replaceAll("\\{CLICK_ID\\}", pv3Var.s);
        }
        return (String) invokeLL.objValue;
    }

    public static void e(pv3 pv3Var, AdElementInfo adElementInfo, yu3 yu3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, pv3Var, adElementInfo, yu3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, pv3Var), yu3Var);
        }
    }

    public static void g(pv3 pv3Var, AdElementInfo adElementInfo, yu3 yu3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, pv3Var, adElementInfo, yu3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, pv3Var), yu3Var);
        }
    }
}
