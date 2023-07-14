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
/* loaded from: classes7.dex */
public class snb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public eob b;

    public snb(Context context) {
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
        this.b = new eob();
    }

    public static /* synthetic */ void f(fnb fnbVar, int i, String str) {
        if (fnbVar != null) {
            fnbVar.onFailure(i, str);
        }
    }

    public final void b(final fnb<?> fnbVar, final int i, final String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fnbVar, i, str) == null) {
            dob.b(new Runnable() { // from class: com.baidu.tieba.enb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        snb.f(fnb.this, i, str);
                    }
                }
            });
        }
    }

    public static /* synthetic */ void g(fnb fnbVar, Object obj) {
        if (fnbVar != null) {
            fnbVar.onSuccess(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(Callable callable, fnb fnbVar) {
        try {
            c(fnbVar, callable.call());
        } catch (ApiException e) {
            b(fnbVar, e.getErrorCode(), e.getMessage());
        } catch (Exception unused) {
            HonorPushErrorEnum honorPushErrorEnum = HonorPushErrorEnum.ERROR_INTERNAL_ERROR;
            b(fnbVar, honorPushErrorEnum.getErrorCode(), honorPushErrorEnum.getMessage());
        }
    }

    public final <T> void c(final fnb<T> fnbVar, final T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fnbVar, t) == null) {
            dob.b(new Runnable() { // from class: com.baidu.tieba.dnb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        snb.g(fnb.this, t);
                    }
                }
            });
        }
    }

    public void d(fnb<String> fnbVar, final boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, fnbVar, z) == null) {
            e(new Callable() { // from class: com.baidu.tieba.xmb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? snb.this.a(z) : invokeV.objValue;
                }
            }, fnbVar);
        }
    }

    public final <T> void e(final Callable<T> callable, final fnb<T> fnbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, callable, fnbVar) == null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.cnb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        snb.this.h(callable, fnbVar);
                    }
                }
            };
            dob dobVar = dob.f;
            if (dobVar.d == null) {
                synchronized (dobVar.e) {
                    if (dobVar.d == null) {
                        dobVar.d = dobVar.c();
                    }
                }
            }
            dobVar.d.execute(runnable);
        }
    }

    public final String a(boolean z) throws Exception {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            this.b.getClass();
            try {
                job jobVar = new job(UpMsgType.REQUEST_PUSH_TOKEN, null);
                jobVar.d = jnb.a();
                String pushToken = ((PushTokenResult) jnb.d(bob.c.a(jobVar))).getPushToken();
                if (z && !TextUtils.isEmpty(pushToken)) {
                    Bundle bundle = new Bundle();
                    bundle.putString(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, DownMsgType.RECEIVE_TOKEN);
                    bundle.putString("push_token", pushToken);
                    nob nobVar = new nob();
                    Context context = this.a;
                    Log.i("MessengerSrvConnection", "start bind service.");
                    try {
                        Intent intent = new Intent();
                        intent.setPackage(context.getPackageName());
                        intent.setAction("com.hihonor.push.action.MESSAGING_EVENT");
                        Context applicationContext = context.getApplicationContext();
                        nobVar.c = applicationContext;
                        nobVar.b = bundle;
                        if (applicationContext.bindService(intent, nobVar, 1)) {
                            Log.i("MessengerSrvConnection", "bind service succeeded.");
                        }
                    } catch (Exception e) {
                        String str = "bind service failed." + e.getMessage();
                    }
                }
                return pushToken;
            } catch (Exception e2) {
                throw jnb.b(e2);
            }
        }
        return (String) invokeZ.objValue;
    }
}
