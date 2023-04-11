package com.baidu.tieba;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b50;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class x40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Class[] a;
        public final /* synthetic */ b50.a b;

        public a(Class[] clsArr, b50.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {clsArr, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = clsArr;
            this.b = aVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                try {
                    this.b.a(true, (String) this.a[0].getMethod("a", new Class[0]).invoke(this.a[0].getMethod("asInterface", IBinder.class).invoke(null, iBinder), new Object[0]));
                } catch (Throwable unused) {
                    this.b.a(false, null);
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
            }
        }
    }

    public static void a(Context context, b50.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, context, aVar) == null) {
            if (context == null) {
                aVar.a(false, null);
                return;
            }
            Class[] clsArr = new Class[1];
            try {
                clsArr[0] = Class.forName("com.zui.deviceidservice.IDeviceidInterface$Stub");
            } catch (Throwable unused) {
            }
            if (clsArr[0] == null) {
                aVar.a(false, null);
                return;
            }
            try {
                a aVar2 = new a(clsArr, aVar);
                Intent intent = new Intent();
                intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
                context.bindService(intent, aVar2, 1);
            } catch (Throwable unused2) {
                aVar.a(false, null);
            }
        }
    }
}
