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
/* loaded from: classes4.dex */
public class kq3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends ResponseCallback<ro3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ np3 a;

        public a(np3 np3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {np3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = np3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(ro3 ro3Var, int i) {
            np3 np3Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, ro3Var, i) == null) || ro3Var == null || (np3Var = this.a) == null) {
                return;
            }
            np3Var.d(ro3Var.a, ro3Var.b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public ro3 parseResponse(Response response, int i) {
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
                                ro3 ro3Var = new ro3();
                                ro3Var.a = optJSONObject.optString("clickid");
                                ro3Var.b = optJSONObject.optString("dstlink");
                                return ro3Var;
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
            return (ro3) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }
    }

    public static void a(hq3 hq3Var, AdElementInfo adElementInfo, qp3 qp3Var, np3 np3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65536, null, hq3Var, adElementInfo, qp3Var, np3Var) == null) || adElementInfo == null || TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            return;
        }
        String c = c(adElementInfo.getClickUrl(), hq3Var);
        a aVar = new a(np3Var);
        if (!NetworkUtils.f(AppRuntime.getAppContext()) || qp3Var == null) {
            return;
        }
        qp3Var.c(c, aVar);
    }

    public static void b(String str, qp3 qp3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, qp3Var) == null) {
            qp3Var.e(str);
        }
    }

    public static String c(String str, hq3 hq3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, hq3Var)) == null) ? hq3Var == null ? str : str.replaceAll("\\{REQ_WIDTH\\}", hq3Var.a).replaceAll("\\{REQ_HEIGHT\\}", hq3Var.b).replaceAll("\\{WIDTH\\}", hq3Var.c).replaceAll("\\{HEIGHT\\}", hq3Var.d).replaceAll("\\{DOWN_X\\}", hq3Var.e).replaceAll("\\{DOWN_Y\\}", hq3Var.f).replaceAll("\\{UP_X\\}", hq3Var.g).replaceAll("\\{UP_Y\\}", hq3Var.h).replaceAll("\\{VIDEO_TIME\\}", hq3Var.i).replaceAll("\\{BEGIN_TIME\\}", hq3Var.j).replaceAll("\\{END_TIME\\}", hq3Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", hq3Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", hq3Var.m).replaceAll("\\{SCENE\\}", hq3Var.n).replaceAll("\\{TYPE\\}", hq3Var.o).replaceAll("\\{BEHAVIOR\\}", hq3Var.p).replaceAll("\\{STATUS\\}", hq3Var.q).replaceAll("\\{CONVERSION_ACTION\\}", hq3Var.r).replaceAll("\\{CLICK_ID\\}", hq3Var.s) : (String) invokeLL.objValue;
    }

    public static void d(AdElementInfo adElementInfo, qp3 qp3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, adElementInfo, qp3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), qp3Var);
        }
    }

    public static void e(hq3 hq3Var, AdElementInfo adElementInfo, qp3 qp3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, hq3Var, adElementInfo, qp3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, hq3Var), qp3Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, qp3 qp3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, null, adElementInfo, qp3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), qp3Var);
        }
    }

    public static void g(hq3 hq3Var, AdElementInfo adElementInfo, qp3 qp3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, hq3Var, adElementInfo, qp3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, hq3Var), qp3Var);
        }
    }
}
