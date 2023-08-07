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
public class j04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends ResponseCallback<qy3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mz3 a;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }

        public a(mz3 mz3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mz3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(qy3 qy3Var, int i) {
            mz3 mz3Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, qy3Var, i) == null) && qy3Var != null && (mz3Var = this.a) != null) {
                mz3Var.d(qy3Var.a, qy3Var.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public qy3 parseResponse(Response response, int i) {
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
                            qy3 qy3Var = new qy3();
                            qy3Var.a = optJSONObject.optString("clickid");
                            qy3Var.b = optJSONObject.optString("dstlink");
                            return qy3Var;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception | OutOfMemoryError unused) {
                }
                return null;
            }
            return (qy3) invokeLI.objValue;
        }
    }

    public static void a(g04 g04Var, AdElementInfo adElementInfo, pz3 pz3Var, mz3 mz3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65536, null, g04Var, adElementInfo, pz3Var, mz3Var) == null) && adElementInfo != null && !TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            String c = c(adElementInfo.getClickUrl(), g04Var);
            a aVar = new a(mz3Var);
            if (NetworkUtils.f(AppRuntime.getAppContext()) && pz3Var != null) {
                pz3Var.c(c, aVar);
            }
        }
    }

    public static void b(String str, pz3 pz3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, pz3Var) == null) {
            pz3Var.e(str);
        }
    }

    public static void d(AdElementInfo adElementInfo, pz3 pz3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, adElementInfo, pz3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), pz3Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, pz3 pz3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65541, null, adElementInfo, pz3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), pz3Var);
        }
    }

    public static String c(String str, g04 g04Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, g04Var)) == null) {
            if (g04Var == null) {
                return str;
            }
            return str.replaceAll("\\{REQ_WIDTH\\}", g04Var.a).replaceAll("\\{REQ_HEIGHT\\}", g04Var.b).replaceAll("\\{WIDTH\\}", g04Var.c).replaceAll("\\{HEIGHT\\}", g04Var.d).replaceAll("\\{DOWN_X\\}", g04Var.e).replaceAll("\\{DOWN_Y\\}", g04Var.f).replaceAll("\\{UP_X\\}", g04Var.g).replaceAll("\\{UP_Y\\}", g04Var.h).replaceAll("\\{VIDEO_TIME\\}", g04Var.i).replaceAll("\\{BEGIN_TIME\\}", g04Var.j).replaceAll("\\{END_TIME\\}", g04Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", g04Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", g04Var.m).replaceAll("\\{SCENE\\}", g04Var.n).replaceAll("\\{TYPE\\}", g04Var.o).replaceAll("\\{BEHAVIOR\\}", g04Var.p).replaceAll("\\{STATUS\\}", g04Var.q).replaceAll("\\{CONVERSION_ACTION\\}", g04Var.r).replaceAll("\\{CLICK_ID\\}", g04Var.s);
        }
        return (String) invokeLL.objValue;
    }

    public static void e(g04 g04Var, AdElementInfo adElementInfo, pz3 pz3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, g04Var, adElementInfo, pz3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, g04Var), pz3Var);
        }
    }

    public static void g(g04 g04Var, AdElementInfo adElementInfo, pz3 pz3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, g04Var, adElementInfo, pz3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, g04Var), pz3Var);
        }
    }
}
