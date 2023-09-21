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
public class r04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends ResponseCallback<yy3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uz3 a;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }

        public a(uz3 uz3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uz3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(yy3 yy3Var, int i) {
            uz3 uz3Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, yy3Var, i) == null) && yy3Var != null && (uz3Var = this.a) != null) {
                uz3Var.d(yy3Var.a, yy3Var.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public yy3 parseResponse(Response response, int i) {
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
                            yy3 yy3Var = new yy3();
                            yy3Var.a = optJSONObject.optString("clickid");
                            yy3Var.b = optJSONObject.optString("dstlink");
                            return yy3Var;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception | OutOfMemoryError unused) {
                }
                return null;
            }
            return (yy3) invokeLI.objValue;
        }
    }

    public static void a(o04 o04Var, AdElementInfo adElementInfo, xz3 xz3Var, uz3 uz3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65536, null, o04Var, adElementInfo, xz3Var, uz3Var) == null) && adElementInfo != null && !TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            String c = c(adElementInfo.getClickUrl(), o04Var);
            a aVar = new a(uz3Var);
            if (NetworkUtils.f(AppRuntime.getAppContext()) && xz3Var != null) {
                xz3Var.c(c, aVar);
            }
        }
    }

    public static void b(String str, xz3 xz3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, xz3Var) == null) {
            xz3Var.e(str);
        }
    }

    public static void d(AdElementInfo adElementInfo, xz3 xz3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, adElementInfo, xz3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), xz3Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, xz3 xz3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65541, null, adElementInfo, xz3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), xz3Var);
        }
    }

    public static String c(String str, o04 o04Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, o04Var)) == null) {
            if (o04Var == null) {
                return str;
            }
            return str.replaceAll("\\{REQ_WIDTH\\}", o04Var.a).replaceAll("\\{REQ_HEIGHT\\}", o04Var.b).replaceAll("\\{WIDTH\\}", o04Var.c).replaceAll("\\{HEIGHT\\}", o04Var.d).replaceAll("\\{DOWN_X\\}", o04Var.e).replaceAll("\\{DOWN_Y\\}", o04Var.f).replaceAll("\\{UP_X\\}", o04Var.g).replaceAll("\\{UP_Y\\}", o04Var.h).replaceAll("\\{VIDEO_TIME\\}", o04Var.i).replaceAll("\\{BEGIN_TIME\\}", o04Var.j).replaceAll("\\{END_TIME\\}", o04Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", o04Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", o04Var.m).replaceAll("\\{SCENE\\}", o04Var.n).replaceAll("\\{TYPE\\}", o04Var.o).replaceAll("\\{BEHAVIOR\\}", o04Var.p).replaceAll("\\{STATUS\\}", o04Var.q).replaceAll("\\{CONVERSION_ACTION\\}", o04Var.r).replaceAll("\\{CLICK_ID\\}", o04Var.s);
        }
        return (String) invokeLL.objValue;
    }

    public static void e(o04 o04Var, AdElementInfo adElementInfo, xz3 xz3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, o04Var, adElementInfo, xz3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, o04Var), xz3Var);
        }
    }

    public static void g(o04 o04Var, AdElementInfo adElementInfo, xz3 xz3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, o04Var, adElementInfo, xz3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, o04Var), xz3Var);
        }
    }
}
