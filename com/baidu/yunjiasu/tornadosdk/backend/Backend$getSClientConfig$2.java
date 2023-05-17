package com.baidu.yunjiasu.tornadosdk.backend;

import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import com.heytap.mcssdk.constant.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/baidu/yunjiasu/tornadosdk/backend/SClientConfig;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.baidu.yunjiasu.tornadosdk.backend.Backend$getSClientConfig$2", f = "Backend.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
public final class Backend$getSClientConfig$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SClientConfig>, Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Backend$getSClientConfig$2(Continuation<? super Backend$getSClientConfig$2> continuation) {
        super(2, continuation);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {continuation};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (Continuation) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, continuation)) == null) ? new Backend$getSClientConfig$2(continuation) : (Continuation) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SClientConfig> continuation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, coroutineScope, continuation)) == null) ? ((Backend$getSClientConfig$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : invokeLL.objValue;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        InterceptResult invokeL;
        String url;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String string;
        Gson gson;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    OkHttpClient okHttpClient = new OkHttpClient();
                    Request.Builder builder = new Request.Builder();
                    url = Backend.INSTANCE.getUrl();
                    Request.Builder url2 = builder.url(Intrinsics.stringPlus(url, "/v1/server/game/config?format=true"));
                    str = Backend.channel;
                    if (str == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("channel");
                        str = null;
                    }
                    Request.Builder addHeader = url2.addHeader("X-Channel-Name", str);
                    str2 = Backend.device;
                    if (str2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(Config.DEVICE_PART);
                        str2 = null;
                    }
                    Request.Builder addHeader2 = addHeader.addHeader("X-Device-Name", str2);
                    str3 = Backend.cuid;
                    if (str3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("cuid");
                        str3 = null;
                    }
                    Request.Builder addHeader3 = addHeader2.addHeader("X-Client-Cuid", str3);
                    str4 = Backend.token;
                    if (str4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("token");
                        str4 = null;
                    }
                    Request.Builder addHeader4 = addHeader3.addHeader("Authorization", Intrinsics.stringPlus("Bearer ", str4));
                    StringBuilder sb = new StringBuilder();
                    str5 = Backend.clientVersion;
                    if (str5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("clientVersion");
                        str5 = null;
                    }
                    sb.append(str5);
                    sb.append(',');
                    str6 = Backend.sdkVersion;
                    if (str6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(b.C);
                        str6 = null;
                    }
                    sb.append(str6);
                    Request build = addHeader4.addHeader("X-Client-Version", sb.toString()).addHeader("X-System-Version", Build.VERSION.RELEASE).addHeader("X-Auth-Timestamp", String.valueOf(System.currentTimeMillis())).build();
                    Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …                 .build()");
                    ResponseBody body = okHttpClient.newCall(build).execute().body();
                    if (body == null) {
                        string = null;
                    } else {
                        string = body.string();
                    }
                    gson = Backend.gson;
                    return gson.fromJson(string, (Class<Object>) SClientConfig.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return invokeL.objValue;
    }
}
