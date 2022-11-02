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
/* loaded from: classes5.dex */
public class pt3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends ResponseCallback<wr3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ss3 a;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }

        public a(ss3 ss3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ss3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ss3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(wr3 wr3Var, int i) {
            ss3 ss3Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, wr3Var, i) == null) && wr3Var != null && (ss3Var = this.a) != null) {
                ss3Var.d(wr3Var.a, wr3Var.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public wr3 parseResponse(Response response, int i) {
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
                            wr3 wr3Var = new wr3();
                            wr3Var.a = optJSONObject.optString("clickid");
                            wr3Var.b = optJSONObject.optString("dstlink");
                            return wr3Var;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception | OutOfMemoryError unused) {
                }
                return null;
            }
            return (wr3) invokeLI.objValue;
        }
    }

    public static void a(mt3 mt3Var, AdElementInfo adElementInfo, vs3 vs3Var, ss3 ss3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65536, null, mt3Var, adElementInfo, vs3Var, ss3Var) == null) && adElementInfo != null && !TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            String c = c(adElementInfo.getClickUrl(), mt3Var);
            a aVar = new a(ss3Var);
            if (NetworkUtils.f(AppRuntime.getAppContext()) && vs3Var != null) {
                vs3Var.c(c, aVar);
            }
        }
    }

    public static void b(String str, vs3 vs3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, vs3Var) == null) {
            vs3Var.e(str);
        }
    }

    public static void d(AdElementInfo adElementInfo, vs3 vs3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, adElementInfo, vs3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), vs3Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, vs3 vs3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65541, null, adElementInfo, vs3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), vs3Var);
        }
    }

    public static String c(String str, mt3 mt3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, mt3Var)) == null) {
            if (mt3Var == null) {
                return str;
            }
            return str.replaceAll("\\{REQ_WIDTH\\}", mt3Var.a).replaceAll("\\{REQ_HEIGHT\\}", mt3Var.b).replaceAll("\\{WIDTH\\}", mt3Var.c).replaceAll("\\{HEIGHT\\}", mt3Var.d).replaceAll("\\{DOWN_X\\}", mt3Var.e).replaceAll("\\{DOWN_Y\\}", mt3Var.f).replaceAll("\\{UP_X\\}", mt3Var.g).replaceAll("\\{UP_Y\\}", mt3Var.h).replaceAll("\\{VIDEO_TIME\\}", mt3Var.i).replaceAll("\\{BEGIN_TIME\\}", mt3Var.j).replaceAll("\\{END_TIME\\}", mt3Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", mt3Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", mt3Var.m).replaceAll("\\{SCENE\\}", mt3Var.n).replaceAll("\\{TYPE\\}", mt3Var.o).replaceAll("\\{BEHAVIOR\\}", mt3Var.p).replaceAll("\\{STATUS\\}", mt3Var.q).replaceAll("\\{CONVERSION_ACTION\\}", mt3Var.r).replaceAll("\\{CLICK_ID\\}", mt3Var.s);
        }
        return (String) invokeLL.objValue;
    }

    public static void e(mt3 mt3Var, AdElementInfo adElementInfo, vs3 vs3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, mt3Var, adElementInfo, vs3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, mt3Var), vs3Var);
        }
    }

    public static void g(mt3 mt3Var, AdElementInfo adElementInfo, vs3 vs3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, mt3Var, adElementInfo, vs3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, mt3Var), vs3Var);
        }
    }
}
