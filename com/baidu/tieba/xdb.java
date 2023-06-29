package com.baidu.tieba;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public final class xdb implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Activity a;
    public final /* synthetic */ tdb b;
    public final /* synthetic */ sdb c;

    public xdb(sdb sdbVar, Activity activity, tdb tdbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sdbVar, activity, tdbVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = sdbVar;
        this.a = activity;
        this.b = tdbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.a.b.a.a.a.a aVar;
        Bundle l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                aVar = this.c.d;
                String str = this.a.getApplicationInfo().packageName;
                sdb sdbVar = this.c;
                l = sdb.l();
                aVar.a(str, Collections.singletonList(l), new Bundle(), new com.google.ar.core.x(this, atomicBoolean));
                new Handler().postDelayed(new ydb(this, atomicBoolean), 3000L);
            } catch (RemoteException e) {
                Log.w("ARCore-InstallService", "requestInstall threw, launching fullscreen.", e);
                sdb sdbVar2 = this.c;
                sdb.n(this.a, this.b);
            }
        }
    }
}
