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
public class mwb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public ywb b;

    public mwb(Context context) {
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
        this.b = new ywb();
    }

    public static /* synthetic */ void f(zvb zvbVar, int i, String str) {
        if (zvbVar != null) {
            zvbVar.onFailure(i, str);
        }
    }

    public final void b(final zvb<?> zvbVar, final int i, final String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zvbVar, i, str) == null) {
            xwb.b(new Runnable() { // from class: com.baidu.tieba.yvb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        mwb.f(zvb.this, i, str);
                    }
                }
            });
        }
    }

    public static /* synthetic */ void g(zvb zvbVar, Object obj) {
        if (zvbVar != null) {
            zvbVar.onSuccess(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(Callable callable, zvb zvbVar) {
        try {
            c(zvbVar, callable.call());
        } catch (ApiException e) {
            b(zvbVar, e.getErrorCode(), e.getMessage());
        } catch (Exception unused) {
            HonorPushErrorEnum honorPushErrorEnum = HonorPushErrorEnum.ERROR_INTERNAL_ERROR;
            b(zvbVar, honorPushErrorEnum.getErrorCode(), honorPushErrorEnum.getMessage());
        }
    }

    public final <T> void c(final zvb<T> zvbVar, final T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, zvbVar, t) == null) {
            xwb.b(new Runnable() { // from class: com.baidu.tieba.xvb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        mwb.g(zvb.this, t);
                    }
                }
            });
        }
    }

    public void d(zvb<String> zvbVar, final boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, zvbVar, z) == null) {
            e(new Callable() { // from class: com.baidu.tieba.rvb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? mwb.this.a(z) : invokeV.objValue;
                }
            }, zvbVar);
        }
    }

    public final <T> void e(final Callable<T> callable, final zvb<T> zvbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, callable, zvbVar) == null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.wvb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        mwb.this.h(callable, zvbVar);
                    }
                }
            };
            xwb xwbVar = xwb.f;
            if (xwbVar.d == null) {
                synchronized (xwbVar.e) {
                    if (xwbVar.d == null) {
                        xwbVar.d = xwbVar.c();
                    }
                }
            }
            xwbVar.d.execute(runnable);
        }
    }

    public final String a(boolean z) throws Exception {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            this.b.getClass();
            try {
                dxb dxbVar = new dxb(UpMsgType.REQUEST_PUSH_TOKEN, null);
                dxbVar.d = dwb.a();
                String pushToken = ((PushTokenResult) dwb.d(vwb.c.a(dxbVar))).getPushToken();
                if (z && !TextUtils.isEmpty(pushToken)) {
                    Bundle bundle = new Bundle();
                    bundle.putString(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, DownMsgType.RECEIVE_TOKEN);
                    bundle.putString("push_token", pushToken);
                    hxb hxbVar = new hxb();
                    Context context = this.a;
                    Log.i("MessengerSrvConnection", "start bind service.");
                    try {
                        Intent intent = new Intent();
                        intent.setPackage(context.getPackageName());
                        intent.setAction("com.hihonor.push.action.MESSAGING_EVENT");
                        Context applicationContext = context.getApplicationContext();
                        hxbVar.c = applicationContext;
                        hxbVar.b = bundle;
                        if (applicationContext.bindService(intent, hxbVar, 1)) {
                            Log.i("MessengerSrvConnection", "bind service succeeded.");
                        }
                    } catch (Exception e) {
                        String str = "bind service failed." + e.getMessage();
                    }
                }
                return pushToken;
            } catch (Exception e2) {
                throw dwb.b(e2);
            }
        }
        return (String) invokeZ.objValue;
    }
}
