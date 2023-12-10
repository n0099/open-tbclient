package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.pose.PoseAR;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.hihonor.push.framework.aidl.entity.PushTokenResult;
import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.common.data.DownMsgType;
import com.hihonor.push.sdk.common.data.UpMsgType;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.util.concurrent.Callable;
/* loaded from: classes9.dex */
public class y9c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public kac b;

    public y9c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = new kac();
    }

    public static /* synthetic */ void f(l9c l9cVar, int i, String str) {
        if (l9cVar != null) {
            l9cVar.onFailure(i, str);
        }
    }

    public final void b(final l9c<?> l9cVar, final int i, final String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l9cVar, i, str) == null) {
            jac.b(new Runnable() { // from class: com.baidu.tieba.k9c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        y9c.f(l9c.this, i, str);
                    }
                }
            });
        }
    }

    public static /* synthetic */ void g(l9c l9cVar, Object obj) {
        if (l9cVar != null) {
            l9cVar.onSuccess(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(Callable callable, l9c l9cVar) {
        try {
            c(l9cVar, callable.call());
        } catch (ApiException e) {
            b(l9cVar, e.getErrorCode(), e.getMessage());
        } catch (Exception unused) {
            HonorPushErrorEnum honorPushErrorEnum = HonorPushErrorEnum.ERROR_INTERNAL_ERROR;
            b(l9cVar, honorPushErrorEnum.getErrorCode(), honorPushErrorEnum.getMessage());
        }
    }

    public final <T> void c(final l9c<T> l9cVar, final T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, l9cVar, t) == null) {
            jac.b(new Runnable() { // from class: com.baidu.tieba.j9c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        y9c.g(l9c.this, t);
                    }
                }
            });
        }
    }

    public void d(l9c<String> l9cVar, final boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, l9cVar, z) == null) {
            e(new Callable() { // from class: com.baidu.tieba.d9c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? y9c.this.a(z) : invokeV.objValue;
                }
            }, l9cVar);
        }
    }

    public final <T> void e(final Callable<T> callable, final l9c<T> l9cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, callable, l9cVar) == null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.i9c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        y9c.this.h(callable, l9cVar);
                    }
                }
            };
            jac jacVar = jac.f;
            if (jacVar.d == null) {
                synchronized (jacVar.e) {
                    if (jacVar.d == null) {
                        jacVar.d = jacVar.c();
                    }
                }
            }
            jacVar.d.execute(runnable);
        }
    }

    public final String a(boolean z) throws Exception {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            this.b.getClass();
            try {
                pac pacVar = new pac(UpMsgType.REQUEST_PUSH_TOKEN, null);
                pacVar.d = p9c.a();
                String pushToken = ((PushTokenResult) p9c.d(hac.c.a(pacVar))).getPushToken();
                if (z && !TextUtils.isEmpty(pushToken)) {
                    Bundle bundle = new Bundle();
                    bundle.putString(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, DownMsgType.RECEIVE_TOKEN);
                    bundle.putString("push_token", pushToken);
                    tac tacVar = new tac();
                    Context context = this.a;
                    Log.i("MessengerSrvConnection", "start bind service.");
                    try {
                        Intent intent = new Intent();
                        intent.setPackage(context.getPackageName());
                        intent.setAction("com.hihonor.push.action.MESSAGING_EVENT");
                        Context applicationContext = context.getApplicationContext();
                        tacVar.c = applicationContext;
                        tacVar.b = bundle;
                        if (applicationContext.bindService(intent, tacVar, 1)) {
                            Log.i("MessengerSrvConnection", "bind service succeeded.");
                        }
                    } catch (Exception e) {
                        String str = "bind service failed." + e.getMessage();
                    }
                }
                return pushToken;
            } catch (Exception e2) {
                throw p9c.b(e2);
            }
        }
        return (String) invokeZ.objValue;
    }
}
