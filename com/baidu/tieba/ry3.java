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
/* loaded from: classes7.dex */
public class ry3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends ResponseCallback<yw3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux3 a;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }

        public a(ux3 ux3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(yw3 yw3Var, int i) {
            ux3 ux3Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, yw3Var, i) == null) && yw3Var != null && (ux3Var = this.a) != null) {
                ux3Var.d(yw3Var.a, yw3Var.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public yw3 parseResponse(Response response, int i) {
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
                            yw3 yw3Var = new yw3();
                            yw3Var.a = optJSONObject.optString("clickid");
                            yw3Var.b = optJSONObject.optString("dstlink");
                            return yw3Var;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception | OutOfMemoryError unused) {
                }
                return null;
            }
            return (yw3) invokeLI.objValue;
        }
    }

    public static void a(oy3 oy3Var, AdElementInfo adElementInfo, xx3 xx3Var, ux3 ux3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65536, null, oy3Var, adElementInfo, xx3Var, ux3Var) == null) && adElementInfo != null && !TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            String c = c(adElementInfo.getClickUrl(), oy3Var);
            a aVar = new a(ux3Var);
            if (NetworkUtils.f(AppRuntime.getAppContext()) && xx3Var != null) {
                xx3Var.c(c, aVar);
            }
        }
    }

    public static void b(String str, xx3 xx3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, xx3Var) == null) {
            xx3Var.e(str);
        }
    }

    public static void d(AdElementInfo adElementInfo, xx3 xx3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, adElementInfo, xx3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), xx3Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, xx3 xx3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65541, null, adElementInfo, xx3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), xx3Var);
        }
    }

    public static String c(String str, oy3 oy3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, oy3Var)) == null) {
            if (oy3Var == null) {
                return str;
            }
            return str.replaceAll("\\{REQ_WIDTH\\}", oy3Var.a).replaceAll("\\{REQ_HEIGHT\\}", oy3Var.b).replaceAll("\\{WIDTH\\}", oy3Var.c).replaceAll("\\{HEIGHT\\}", oy3Var.d).replaceAll("\\{DOWN_X\\}", oy3Var.e).replaceAll("\\{DOWN_Y\\}", oy3Var.f).replaceAll("\\{UP_X\\}", oy3Var.g).replaceAll("\\{UP_Y\\}", oy3Var.h).replaceAll("\\{VIDEO_TIME\\}", oy3Var.i).replaceAll("\\{BEGIN_TIME\\}", oy3Var.j).replaceAll("\\{END_TIME\\}", oy3Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", oy3Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", oy3Var.m).replaceAll("\\{SCENE\\}", oy3Var.n).replaceAll("\\{TYPE\\}", oy3Var.o).replaceAll("\\{BEHAVIOR\\}", oy3Var.p).replaceAll("\\{STATUS\\}", oy3Var.q).replaceAll("\\{CONVERSION_ACTION\\}", oy3Var.r).replaceAll("\\{CLICK_ID\\}", oy3Var.s);
        }
        return (String) invokeLL.objValue;
    }

    public static void e(oy3 oy3Var, AdElementInfo adElementInfo, xx3 xx3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, oy3Var, adElementInfo, xx3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, oy3Var), xx3Var);
        }
    }

    public static void g(oy3 oy3Var, AdElementInfo adElementInfo, xx3 xx3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, oy3Var, adElementInfo, xx3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, oy3Var), xx3Var);
        }
    }
}
