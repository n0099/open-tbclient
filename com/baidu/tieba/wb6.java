package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import okhttp3.Response;
/* loaded from: classes6.dex */
public class wb6 implements sb6<Pair<String, Map<String, String>>, Response> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HttpManager a;

    /* loaded from: classes6.dex */
    public class a extends ResponseCallback<Response> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dsa a;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: parseResponse  reason: avoid collision after fix types in other method */
        public Response parseResponse2(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i)) == null) ? response : (Response) invokeLI.objValue;
        }

        public a(wb6 wb6Var, dsa dsaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wb6Var, dsaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dsaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(Response response, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, response, i) == null) {
                this.a.call(response, null);
            }
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public /* bridge */ /* synthetic */ Response parseResponse(Response response, int i) throws Exception {
            parseResponse2(response, i);
            return response;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                this.a.call(null, exc);
            }
        }
    }

    public wb6() {
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
        this.a = HttpManager.getDefault(zc6.getContext());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sb6
    @Nullable
    /* renamed from: c */
    public Response a(Pair<String, Map<String, String>> pair) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pair)) == null) {
            if (pair != null && !TextUtils.isEmpty(pair.first)) {
                return this.a.getRequest().url(pair.first).tag(this).addHeaders(pair.second).connectionTimeout(10000).readTimeout(10000).followRedirects(false).followSslRedirects(false).cookieManager(CookieManager.WEBKIT_COOKIES).build().executeSync();
            }
            return null;
        }
        return (Response) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sb6
    /* renamed from: d */
    public void b(Pair<String, Map<String, String>> pair, dsa<Response, Exception> dsaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, pair, dsaVar) == null) {
            if (pair != null && !TextUtils.isEmpty(pair.first)) {
                this.a.getRequest().url(pair.first).tag(this).followRedirects(false).followSslRedirects(false).addHeaders(pair.second).connectionTimeout(10000).readTimeout(10000).cookieManager(CookieManager.WEBKIT_COOKIES).build().executeAsync(new a(this, dsaVar));
            } else {
                dsaVar.call(null, new IllegalArgumentException("url is null !"));
            }
        }
    }
}
