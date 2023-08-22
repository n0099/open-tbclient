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
public class ltb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public xtb b;

    public ltb(Context context) {
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
        this.b = new xtb();
    }

    public static /* synthetic */ void f(ysb ysbVar, int i, String str) {
        if (ysbVar != null) {
            ysbVar.onFailure(i, str);
        }
    }

    public final void b(final ysb<?> ysbVar, final int i, final String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ysbVar, i, str) == null) {
            wtb.b(new Runnable() { // from class: com.baidu.tieba.xsb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ltb.f(ysb.this, i, str);
                    }
                }
            });
        }
    }

    public static /* synthetic */ void g(ysb ysbVar, Object obj) {
        if (ysbVar != null) {
            ysbVar.onSuccess(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(Callable callable, ysb ysbVar) {
        try {
            c(ysbVar, callable.call());
        } catch (ApiException e) {
            b(ysbVar, e.getErrorCode(), e.getMessage());
        } catch (Exception unused) {
            HonorPushErrorEnum honorPushErrorEnum = HonorPushErrorEnum.ERROR_INTERNAL_ERROR;
            b(ysbVar, honorPushErrorEnum.getErrorCode(), honorPushErrorEnum.getMessage());
        }
    }

    public final <T> void c(final ysb<T> ysbVar, final T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ysbVar, t) == null) {
            wtb.b(new Runnable() { // from class: com.baidu.tieba.wsb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ltb.g(ysb.this, t);
                    }
                }
            });
        }
    }

    public void d(ysb<String> ysbVar, final boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, ysbVar, z) == null) {
            e(new Callable() { // from class: com.baidu.tieba.qsb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? ltb.this.a(z) : invokeV.objValue;
                }
            }, ysbVar);
        }
    }

    public final <T> void e(final Callable<T> callable, final ysb<T> ysbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, callable, ysbVar) == null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.vsb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ltb.this.h(callable, ysbVar);
                    }
                }
            };
            wtb wtbVar = wtb.f;
            if (wtbVar.d == null) {
                synchronized (wtbVar.e) {
                    if (wtbVar.d == null) {
                        wtbVar.d = wtbVar.c();
                    }
                }
            }
            wtbVar.d.execute(runnable);
        }
    }

    public final String a(boolean z) throws Exception {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            this.b.getClass();
            try {
                cub cubVar = new cub(UpMsgType.REQUEST_PUSH_TOKEN, null);
                cubVar.d = ctb.a();
                String pushToken = ((PushTokenResult) ctb.d(utb.c.a(cubVar))).getPushToken();
                if (z && !TextUtils.isEmpty(pushToken)) {
                    Bundle bundle = new Bundle();
                    bundle.putString(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, DownMsgType.RECEIVE_TOKEN);
                    bundle.putString("push_token", pushToken);
                    gub gubVar = new gub();
                    Context context = this.a;
                    Log.i("MessengerSrvConnection", "start bind service.");
                    try {
                        Intent intent = new Intent();
                        intent.setPackage(context.getPackageName());
                        intent.setAction("com.hihonor.push.action.MESSAGING_EVENT");
                        Context applicationContext = context.getApplicationContext();
                        gubVar.c = applicationContext;
                        gubVar.b = bundle;
                        if (applicationContext.bindService(intent, gubVar, 1)) {
                            Log.i("MessengerSrvConnection", "bind service succeeded.");
                        }
                    } catch (Exception e) {
                        String str = "bind service failed." + e.getMessage();
                    }
                }
                return pushToken;
            } catch (Exception e2) {
                throw ctb.b(e2);
            }
        }
        return (String) invokeZ.objValue;
    }
}
