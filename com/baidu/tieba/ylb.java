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
public final class ylb implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Activity a;
    public final /* synthetic */ ulb b;
    public final /* synthetic */ tlb c;

    public ylb(tlb tlbVar, Activity activity, ulb ulbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tlbVar, activity, ulbVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = tlbVar;
        this.a = activity;
        this.b = ulbVar;
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
                tlb tlbVar = this.c;
                l = tlb.l();
                aVar.a(str, Collections.singletonList(l), new Bundle(), new com.google.ar.core.x(this, atomicBoolean));
                new Handler().postDelayed(new zlb(this, atomicBoolean), 3000L);
            } catch (RemoteException e) {
                Log.w("ARCore-InstallService", "requestInstall threw, launching fullscreen.", e);
                tlb tlbVar2 = this.c;
                tlb.n(this.a, this.b);
            }
        }
    }
}
