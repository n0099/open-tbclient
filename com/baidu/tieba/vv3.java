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
public class vv3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends ResponseCallback<cu3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yu3 a;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }

        public a(yu3 yu3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yu3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yu3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(cu3 cu3Var, int i) {
            yu3 yu3Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, cu3Var, i) == null) && cu3Var != null && (yu3Var = this.a) != null) {
                yu3Var.d(cu3Var.a, cu3Var.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public cu3 parseResponse(Response response, int i) {
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
                            cu3 cu3Var = new cu3();
                            cu3Var.a = optJSONObject.optString("clickid");
                            cu3Var.b = optJSONObject.optString("dstlink");
                            return cu3Var;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception | OutOfMemoryError unused) {
                }
                return null;
            }
            return (cu3) invokeLI.objValue;
        }
    }

    public static void a(sv3 sv3Var, AdElementInfo adElementInfo, bv3 bv3Var, yu3 yu3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65536, null, sv3Var, adElementInfo, bv3Var, yu3Var) == null) && adElementInfo != null && !TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            String c = c(adElementInfo.getClickUrl(), sv3Var);
            a aVar = new a(yu3Var);
            if (NetworkUtils.f(AppRuntime.getAppContext()) && bv3Var != null) {
                bv3Var.c(c, aVar);
            }
        }
    }

    public static void b(String str, bv3 bv3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, bv3Var) == null) {
            bv3Var.e(str);
        }
    }

    public static void d(AdElementInfo adElementInfo, bv3 bv3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, adElementInfo, bv3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), bv3Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, bv3 bv3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65541, null, adElementInfo, bv3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), bv3Var);
        }
    }

    public static String c(String str, sv3 sv3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, sv3Var)) == null) {
            if (sv3Var == null) {
                return str;
            }
            return str.replaceAll("\\{REQ_WIDTH\\}", sv3Var.a).replaceAll("\\{REQ_HEIGHT\\}", sv3Var.b).replaceAll("\\{WIDTH\\}", sv3Var.c).replaceAll("\\{HEIGHT\\}", sv3Var.d).replaceAll("\\{DOWN_X\\}", sv3Var.e).replaceAll("\\{DOWN_Y\\}", sv3Var.f).replaceAll("\\{UP_X\\}", sv3Var.g).replaceAll("\\{UP_Y\\}", sv3Var.h).replaceAll("\\{VIDEO_TIME\\}", sv3Var.i).replaceAll("\\{BEGIN_TIME\\}", sv3Var.j).replaceAll("\\{END_TIME\\}", sv3Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", sv3Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", sv3Var.m).replaceAll("\\{SCENE\\}", sv3Var.n).replaceAll("\\{TYPE\\}", sv3Var.o).replaceAll("\\{BEHAVIOR\\}", sv3Var.p).replaceAll("\\{STATUS\\}", sv3Var.q).replaceAll("\\{CONVERSION_ACTION\\}", sv3Var.r).replaceAll("\\{CLICK_ID\\}", sv3Var.s);
        }
        return (String) invokeLL.objValue;
    }

    public static void e(sv3 sv3Var, AdElementInfo adElementInfo, bv3 bv3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, sv3Var, adElementInfo, bv3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, sv3Var), bv3Var);
        }
    }

    public static void g(sv3 sv3Var, AdElementInfo adElementInfo, bv3 bv3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, sv3Var, adElementInfo, bv3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, sv3Var), bv3Var);
        }
    }
}
