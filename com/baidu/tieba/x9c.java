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
public class x9c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public jac b;

    public x9c(Context context) {
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
        this.b = new jac();
    }

    public static /* synthetic */ void f(k9c k9cVar, int i, String str) {
        if (k9cVar != null) {
            k9cVar.onFailure(i, str);
        }
    }

    public final void b(final k9c<?> k9cVar, final int i, final String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k9cVar, i, str) == null) {
            iac.b(new Runnable() { // from class: com.baidu.tieba.j9c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        x9c.f(k9c.this, i, str);
                    }
                }
            });
        }
    }

    public static /* synthetic */ void g(k9c k9cVar, Object obj) {
        if (k9cVar != null) {
            k9cVar.onSuccess(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(Callable callable, k9c k9cVar) {
        try {
            c(k9cVar, callable.call());
        } catch (ApiException e) {
            b(k9cVar, e.getErrorCode(), e.getMessage());
        } catch (Exception unused) {
            HonorPushErrorEnum honorPushErrorEnum = HonorPushErrorEnum.ERROR_INTERNAL_ERROR;
            b(k9cVar, honorPushErrorEnum.getErrorCode(), honorPushErrorEnum.getMessage());
        }
    }

    public final <T> void c(final k9c<T> k9cVar, final T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, k9cVar, t) == null) {
            iac.b(new Runnable() { // from class: com.baidu.tieba.i9c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        x9c.g(k9c.this, t);
                    }
                }
            });
        }
    }

    public void d(k9c<String> k9cVar, final boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, k9cVar, z) == null) {
            e(new Callable() { // from class: com.baidu.tieba.c9c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? x9c.this.a(z) : invokeV.objValue;
                }
            }, k9cVar);
        }
    }

    public final <T> void e(final Callable<T> callable, final k9c<T> k9cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, callable, k9cVar) == null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.h9c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        x9c.this.h(callable, k9cVar);
                    }
                }
            };
            iac iacVar = iac.f;
            if (iacVar.d == null) {
                synchronized (iacVar.e) {
                    if (iacVar.d == null) {
                        iacVar.d = iacVar.c();
                    }
                }
            }
            iacVar.d.execute(runnable);
        }
    }

    public final String a(boolean z) throws Exception {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            this.b.getClass();
            try {
                oac oacVar = new oac(UpMsgType.REQUEST_PUSH_TOKEN, null);
                oacVar.d = o9c.a();
                String pushToken = ((PushTokenResult) o9c.d(gac.c.a(oacVar))).getPushToken();
                if (z && !TextUtils.isEmpty(pushToken)) {
                    Bundle bundle = new Bundle();
                    bundle.putString(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, DownMsgType.RECEIVE_TOKEN);
                    bundle.putString("push_token", pushToken);
                    sac sacVar = new sac();
                    Context context = this.a;
                    Log.i("MessengerSrvConnection", "start bind service.");
                    try {
                        Intent intent = new Intent();
                        intent.setPackage(context.getPackageName());
                        intent.setAction("com.hihonor.push.action.MESSAGING_EVENT");
                        Context applicationContext = context.getApplicationContext();
                        sacVar.c = applicationContext;
                        sacVar.b = bundle;
                        if (applicationContext.bindService(intent, sacVar, 1)) {
                            Log.i("MessengerSrvConnection", "bind service succeeded.");
                        }
                    } catch (Exception e) {
                        String str = "bind service failed." + e.getMessage();
                    }
                }
                return pushToken;
            } catch (Exception e2) {
                throw o9c.b(e2);
            }
        }
        return (String) invokeZ.objValue;
    }
}
