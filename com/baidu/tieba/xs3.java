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
public class xs3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public final class a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as3 a;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }

        public a(as3 as3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = as3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(er3 er3Var, int i) {
            as3 as3Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, er3Var, i) == null) && er3Var != null && (as3Var = this.a) != null) {
                as3Var.d(er3Var.a, er3Var.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public er3 parseResponse(Response response, int i) {
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
                            er3 er3Var = new er3();
                            er3Var.a = optJSONObject.optString("clickid");
                            er3Var.b = optJSONObject.optString("dstlink");
                            return er3Var;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception | OutOfMemoryError unused) {
                }
                return null;
            }
            return (er3) invokeLI.objValue;
        }
    }

    public static void a(us3 us3Var, AdElementInfo adElementInfo, ds3 ds3Var, as3 as3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65536, null, us3Var, adElementInfo, ds3Var, as3Var) == null) && adElementInfo != null && !TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            String c = c(adElementInfo.getClickUrl(), us3Var);
            a aVar = new a(as3Var);
            if (NetworkUtils.f(AppRuntime.getAppContext()) && ds3Var != null) {
                ds3Var.c(c, aVar);
            }
        }
    }

    public static void b(String str, ds3 ds3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, ds3Var) == null) {
            ds3Var.e(str);
        }
    }

    public static void d(AdElementInfo adElementInfo, ds3 ds3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, adElementInfo, ds3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), ds3Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, ds3 ds3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65541, null, adElementInfo, ds3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), ds3Var);
        }
    }

    public static String c(String str, us3 us3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, us3Var)) == null) {
            if (us3Var == null) {
                return str;
            }
            return str.replaceAll("\\{REQ_WIDTH\\}", us3Var.a).replaceAll("\\{REQ_HEIGHT\\}", us3Var.b).replaceAll("\\{WIDTH\\}", us3Var.c).replaceAll("\\{HEIGHT\\}", us3Var.d).replaceAll("\\{DOWN_X\\}", us3Var.e).replaceAll("\\{DOWN_Y\\}", us3Var.f).replaceAll("\\{UP_X\\}", us3Var.g).replaceAll("\\{UP_Y\\}", us3Var.h).replaceAll("\\{VIDEO_TIME\\}", us3Var.i).replaceAll("\\{BEGIN_TIME\\}", us3Var.j).replaceAll("\\{END_TIME\\}", us3Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", us3Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", us3Var.m).replaceAll("\\{SCENE\\}", us3Var.n).replaceAll("\\{TYPE\\}", us3Var.o).replaceAll("\\{BEHAVIOR\\}", us3Var.p).replaceAll("\\{STATUS\\}", us3Var.q).replaceAll("\\{CONVERSION_ACTION\\}", us3Var.r).replaceAll("\\{CLICK_ID\\}", us3Var.s);
        }
        return (String) invokeLL.objValue;
    }

    public static void e(us3 us3Var, AdElementInfo adElementInfo, ds3 ds3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, us3Var, adElementInfo, ds3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, us3Var), ds3Var);
        }
    }

    public static void g(us3 us3Var, AdElementInfo adElementInfo, ds3 ds3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, us3Var, adElementInfo, ds3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, us3Var), ds3Var);
        }
    }
}
