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
public class k14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends ResponseCallback<rz3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n04 a;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }

        public a(n04 n04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n04Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(rz3 rz3Var, int i) {
            n04 n04Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, rz3Var, i) == null) && rz3Var != null && (n04Var = this.a) != null) {
                n04Var.d(rz3Var.a, rz3Var.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public rz3 parseResponse(Response response, int i) {
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
                            rz3 rz3Var = new rz3();
                            rz3Var.a = optJSONObject.optString("clickid");
                            rz3Var.b = optJSONObject.optString("dstlink");
                            return rz3Var;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception | OutOfMemoryError unused) {
                }
                return null;
            }
            return (rz3) invokeLI.objValue;
        }
    }

    public static void a(h14 h14Var, AdElementInfo adElementInfo, q04 q04Var, n04 n04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65536, null, h14Var, adElementInfo, q04Var, n04Var) == null) && adElementInfo != null && !TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            String c = c(adElementInfo.getClickUrl(), h14Var);
            a aVar = new a(n04Var);
            if (NetworkUtils.f(AppRuntime.getAppContext()) && q04Var != null) {
                q04Var.c(c, aVar);
            }
        }
    }

    public static void b(String str, q04 q04Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, q04Var) == null) {
            q04Var.e(str);
        }
    }

    public static void d(AdElementInfo adElementInfo, q04 q04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, adElementInfo, q04Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), q04Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, q04 q04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65541, null, adElementInfo, q04Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), q04Var);
        }
    }

    public static String c(String str, h14 h14Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, h14Var)) == null) {
            if (h14Var == null) {
                return str;
            }
            return str.replaceAll("\\{REQ_WIDTH\\}", h14Var.a).replaceAll("\\{REQ_HEIGHT\\}", h14Var.b).replaceAll("\\{WIDTH\\}", h14Var.c).replaceAll("\\{HEIGHT\\}", h14Var.d).replaceAll("\\{DOWN_X\\}", h14Var.e).replaceAll("\\{DOWN_Y\\}", h14Var.f).replaceAll("\\{UP_X\\}", h14Var.g).replaceAll("\\{UP_Y\\}", h14Var.h).replaceAll("\\{VIDEO_TIME\\}", h14Var.i).replaceAll("\\{BEGIN_TIME\\}", h14Var.j).replaceAll("\\{END_TIME\\}", h14Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", h14Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", h14Var.m).replaceAll("\\{SCENE\\}", h14Var.n).replaceAll("\\{TYPE\\}", h14Var.o).replaceAll("\\{BEHAVIOR\\}", h14Var.p).replaceAll("\\{STATUS\\}", h14Var.q).replaceAll("\\{CONVERSION_ACTION\\}", h14Var.r).replaceAll("\\{CLICK_ID\\}", h14Var.s);
        }
        return (String) invokeLL.objValue;
    }

    public static void e(h14 h14Var, AdElementInfo adElementInfo, q04 q04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, h14Var, adElementInfo, q04Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, h14Var), q04Var);
        }
    }

    public static void g(h14 h14Var, AdElementInfo adElementInfo, q04 q04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, h14Var, adElementInfo, q04Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, h14Var), q04Var);
        }
    }
}
