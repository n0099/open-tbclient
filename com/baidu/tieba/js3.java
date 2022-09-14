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
public class js3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends ResponseCallback<qq3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mr3 a;

        public a(mr3 mr3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mr3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mr3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(qq3 qq3Var, int i) {
            mr3 mr3Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, qq3Var, i) == null) || qq3Var == null || (mr3Var = this.a) == null) {
                return;
            }
            mr3Var.d(qq3Var.a, qq3Var.b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public qq3 parseResponse(Response response, int i) {
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
                                qq3 qq3Var = new qq3();
                                qq3Var.a = optJSONObject.optString("clickid");
                                qq3Var.b = optJSONObject.optString("dstlink");
                                return qq3Var;
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
            return (qq3) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }
    }

    public static void a(gs3 gs3Var, AdElementInfo adElementInfo, pr3 pr3Var, mr3 mr3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65536, null, gs3Var, adElementInfo, pr3Var, mr3Var) == null) || adElementInfo == null || TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            return;
        }
        String c = c(adElementInfo.getClickUrl(), gs3Var);
        a aVar = new a(mr3Var);
        if (!NetworkUtils.f(AppRuntime.getAppContext()) || pr3Var == null) {
            return;
        }
        pr3Var.c(c, aVar);
    }

    public static void b(String str, pr3 pr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, pr3Var) == null) {
            pr3Var.e(str);
        }
    }

    public static String c(String str, gs3 gs3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, gs3Var)) == null) ? gs3Var == null ? str : str.replaceAll("\\{REQ_WIDTH\\}", gs3Var.a).replaceAll("\\{REQ_HEIGHT\\}", gs3Var.b).replaceAll("\\{WIDTH\\}", gs3Var.c).replaceAll("\\{HEIGHT\\}", gs3Var.d).replaceAll("\\{DOWN_X\\}", gs3Var.e).replaceAll("\\{DOWN_Y\\}", gs3Var.f).replaceAll("\\{UP_X\\}", gs3Var.g).replaceAll("\\{UP_Y\\}", gs3Var.h).replaceAll("\\{VIDEO_TIME\\}", gs3Var.i).replaceAll("\\{BEGIN_TIME\\}", gs3Var.j).replaceAll("\\{END_TIME\\}", gs3Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", gs3Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", gs3Var.m).replaceAll("\\{SCENE\\}", gs3Var.n).replaceAll("\\{TYPE\\}", gs3Var.o).replaceAll("\\{BEHAVIOR\\}", gs3Var.p).replaceAll("\\{STATUS\\}", gs3Var.q).replaceAll("\\{CONVERSION_ACTION\\}", gs3Var.r).replaceAll("\\{CLICK_ID\\}", gs3Var.s) : (String) invokeLL.objValue;
    }

    public static void d(AdElementInfo adElementInfo, pr3 pr3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, adElementInfo, pr3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), pr3Var);
        }
    }

    public static void e(gs3 gs3Var, AdElementInfo adElementInfo, pr3 pr3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, gs3Var, adElementInfo, pr3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, gs3Var), pr3Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, pr3 pr3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, null, adElementInfo, pr3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), pr3Var);
        }
    }

    public static void g(gs3 gs3Var, AdElementInfo adElementInfo, pr3 pr3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, gs3Var, adElementInfo, pr3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, gs3Var), pr3Var);
        }
    }
}
