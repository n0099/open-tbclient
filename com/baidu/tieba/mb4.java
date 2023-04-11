package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
/* loaded from: classes5.dex */
public class mb4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, callback) == null) {
            b(callback, "6");
        }
    }

    public static void b(Callback callback, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, callback, str) != null) || u73.M() == null) {
            return;
        }
        HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/exchange/list").newBuilder();
        newBuilder.addQueryParameter(Constants.EXTRA_CONFIG_LIMIT, str);
        newBuilder.addQueryParameter(GameGuideConfigInfo.KEY_APP_KEY, u73.M().O());
        newBuilder.addQueryParameter("source", "4");
        ((b64) u73.M().i0()).call(new Request.Builder().url(newBuilder.build()).build(), callback);
    }
}
