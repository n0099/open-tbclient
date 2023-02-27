package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import okhttp3.CacheControl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes5.dex */
public class oc6 implements lc6<Pair<String, Map<String, String>>, Response> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final OkHttpClient a;

    public oc6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = sb6.b(wd6.getContext());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lc6
    @Nullable
    /* renamed from: b */
    public Response a(Pair<String, Map<String, String>> pair) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pair)) == null) {
            if (pair != null && !TextUtils.isEmpty(pair.first)) {
                return c(pair.first, pair.second);
            }
            return null;
        }
        return (Response) invokeL.objValue;
    }

    public final Response c(String str, @Nullable Map<String, String> map) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, map)) == null) {
            Request.Builder url = new Request.Builder().url(str);
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    url.addHeader(entry.getKey(), entry.getValue());
                }
            }
            if (!wd6.c()) {
                url.cacheControl(CacheControl.FORCE_CACHE);
            }
            return this.a.newCall(url.build()).execute();
        }
        return (Response) invokeLL.objValue;
    }
}
