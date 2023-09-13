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
public class s04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends ResponseCallback<zy3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz3 a;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }

        public a(vz3 vz3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vz3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(zy3 zy3Var, int i) {
            vz3 vz3Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, zy3Var, i) == null) && zy3Var != null && (vz3Var = this.a) != null) {
                vz3Var.d(zy3Var.a, zy3Var.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public zy3 parseResponse(Response response, int i) {
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
                            zy3 zy3Var = new zy3();
                            zy3Var.a = optJSONObject.optString("clickid");
                            zy3Var.b = optJSONObject.optString("dstlink");
                            return zy3Var;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception | OutOfMemoryError unused) {
                }
                return null;
            }
            return (zy3) invokeLI.objValue;
        }
    }

    public static void a(p04 p04Var, AdElementInfo adElementInfo, yz3 yz3Var, vz3 vz3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65536, null, p04Var, adElementInfo, yz3Var, vz3Var) == null) && adElementInfo != null && !TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            String c = c(adElementInfo.getClickUrl(), p04Var);
            a aVar = new a(vz3Var);
            if (NetworkUtils.f(AppRuntime.getAppContext()) && yz3Var != null) {
                yz3Var.c(c, aVar);
            }
        }
    }

    public static void b(String str, yz3 yz3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, yz3Var) == null) {
            yz3Var.e(str);
        }
    }

    public static void d(AdElementInfo adElementInfo, yz3 yz3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, adElementInfo, yz3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), yz3Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, yz3 yz3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65541, null, adElementInfo, yz3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), yz3Var);
        }
    }

    public static String c(String str, p04 p04Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, p04Var)) == null) {
            if (p04Var == null) {
                return str;
            }
            return str.replaceAll("\\{REQ_WIDTH\\}", p04Var.a).replaceAll("\\{REQ_HEIGHT\\}", p04Var.b).replaceAll("\\{WIDTH\\}", p04Var.c).replaceAll("\\{HEIGHT\\}", p04Var.d).replaceAll("\\{DOWN_X\\}", p04Var.e).replaceAll("\\{DOWN_Y\\}", p04Var.f).replaceAll("\\{UP_X\\}", p04Var.g).replaceAll("\\{UP_Y\\}", p04Var.h).replaceAll("\\{VIDEO_TIME\\}", p04Var.i).replaceAll("\\{BEGIN_TIME\\}", p04Var.j).replaceAll("\\{END_TIME\\}", p04Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", p04Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", p04Var.m).replaceAll("\\{SCENE\\}", p04Var.n).replaceAll("\\{TYPE\\}", p04Var.o).replaceAll("\\{BEHAVIOR\\}", p04Var.p).replaceAll("\\{STATUS\\}", p04Var.q).replaceAll("\\{CONVERSION_ACTION\\}", p04Var.r).replaceAll("\\{CLICK_ID\\}", p04Var.s);
        }
        return (String) invokeLL.objValue;
    }

    public static void e(p04 p04Var, AdElementInfo adElementInfo, yz3 yz3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, p04Var, adElementInfo, yz3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, p04Var), yz3Var);
        }
    }

    public static void g(p04 p04Var, AdElementInfo adElementInfo, yz3 yz3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, p04Var, adElementInfo, yz3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, p04Var), yz3Var);
        }
    }
}
