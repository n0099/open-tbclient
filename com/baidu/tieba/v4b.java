package com.baidu.tieba;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.o4b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes8.dex */
public final class v4b implements Application.ActivityLifecycleCallbacks {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public o4b a;

    public v4b(o4b o4bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {o4bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = o4bVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
            synchronized (this.a.b()) {
                Iterator<o4b.a> it = this.a.b().iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
            synchronized (this.a.b()) {
                Iterator<o4b.a> it = this.a.b().iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) {
            synchronized (this.a.b()) {
                for (o4b.a aVar : this.a.b()) {
                    aVar.a(activity);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            synchronized (this.a.b()) {
                for (o4b.a aVar : this.a.b()) {
                    aVar.onActivityDestroyed(activity);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
            synchronized (this.a.b()) {
                for (o4b.a aVar : this.a.b()) {
                    aVar.U();
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
            synchronized (this.a.b()) {
                for (o4b.a aVar : this.a.b()) {
                    aVar.b();
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, activity, bundle) == null) {
            synchronized (this.a.b()) {
                Iterator<o4b.a> it = this.a.b().iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }
}
