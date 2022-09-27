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
public class ws3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends ResponseCallback<dr3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zr3 a;

        public a(zr3 zr3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zr3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zr3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(dr3 dr3Var, int i) {
            zr3 zr3Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dr3Var, i) == null) || dr3Var == null || (zr3Var = this.a) == null) {
                return;
            }
            zr3Var.d(dr3Var.a, dr3Var.b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public dr3 parseResponse(Response response, int i) {
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
                            if (TextUtils.equals(jSONObject.optString(Constants.KEYS.RET, ""), "0") && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                                dr3 dr3Var = new dr3();
                                dr3Var.a = optJSONObject.optString("clickid");
                                dr3Var.b = optJSONObject.optString("dstlink");
                                return dr3Var;
                            }
                            return null;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception | OutOfMemoryError unused) {
                }
                return null;
            }
            return (dr3) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }
    }

    public static void a(ts3 ts3Var, AdElementInfo adElementInfo, cs3 cs3Var, zr3 zr3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65536, null, ts3Var, adElementInfo, cs3Var, zr3Var) == null) || adElementInfo == null || TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            return;
        }
        String c = c(adElementInfo.getClickUrl(), ts3Var);
        a aVar = new a(zr3Var);
        if (!NetworkUtils.f(AppRuntime.getAppContext()) || cs3Var == null) {
            return;
        }
        cs3Var.c(c, aVar);
    }

    public static void b(String str, cs3 cs3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, cs3Var) == null) {
            cs3Var.e(str);
        }
    }

    public static String c(String str, ts3 ts3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, ts3Var)) == null) ? ts3Var == null ? str : str.replaceAll("\\{REQ_WIDTH\\}", ts3Var.a).replaceAll("\\{REQ_HEIGHT\\}", ts3Var.b).replaceAll("\\{WIDTH\\}", ts3Var.c).replaceAll("\\{HEIGHT\\}", ts3Var.d).replaceAll("\\{DOWN_X\\}", ts3Var.e).replaceAll("\\{DOWN_Y\\}", ts3Var.f).replaceAll("\\{UP_X\\}", ts3Var.g).replaceAll("\\{UP_Y\\}", ts3Var.h).replaceAll("\\{VIDEO_TIME\\}", ts3Var.i).replaceAll("\\{BEGIN_TIME\\}", ts3Var.j).replaceAll("\\{END_TIME\\}", ts3Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", ts3Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", ts3Var.m).replaceAll("\\{SCENE\\}", ts3Var.n).replaceAll("\\{TYPE\\}", ts3Var.o).replaceAll("\\{BEHAVIOR\\}", ts3Var.p).replaceAll("\\{STATUS\\}", ts3Var.q).replaceAll("\\{CONVERSION_ACTION\\}", ts3Var.r).replaceAll("\\{CLICK_ID\\}", ts3Var.s) : (String) invokeLL.objValue;
    }

    public static void d(AdElementInfo adElementInfo, cs3 cs3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, adElementInfo, cs3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), cs3Var);
        }
    }

    public static void e(ts3 ts3Var, AdElementInfo adElementInfo, cs3 cs3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ts3Var, adElementInfo, cs3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, ts3Var), cs3Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, cs3 cs3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, null, adElementInfo, cs3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), cs3Var);
        }
    }

    public static void g(ts3 ts3Var, AdElementInfo adElementInfo, cs3 cs3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, ts3Var, adElementInfo, cs3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, ts3Var), cs3Var);
        }
    }
}
