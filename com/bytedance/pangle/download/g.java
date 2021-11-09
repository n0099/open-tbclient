package com.bytedance.pangle.download;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.Zeus;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile g f61344a;
    public transient /* synthetic */ FieldHolder $fh;

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static g a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f61344a == null) {
                synchronized (g.class) {
                    if (f61344a == null) {
                        f61344a = new g();
                    }
                }
            }
            return f61344a;
        }
        return (g) invokeV.objValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && com.bytedance.pangle.helper.c.b(Zeus.getAppApplication())) {
            h a2 = h.a();
            b a3 = b.a();
            a3.f61315b.add(new a(a2) { // from class: com.bytedance.pangle.download.h.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a */
                public final /* synthetic */ h f61354a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {a2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61354a = a2;
                }

                @Override // com.bytedance.pangle.download.a
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f61354a.b();
                    }
                }

                @Override // com.bytedance.pangle.download.a
                public final void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f61354a.a(1800L);
                    }
                }
            });
            Zeus.getAppApplication().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks(b.a()) { // from class: com.bytedance.pangle.download.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a */
                public final /* synthetic */ b f61318a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r6};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61318a = r6;
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityCreated(Activity activity, Bundle bundle) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, activity, bundle) == null) {
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityDestroyed(Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityPaused(Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityResumed(Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, activity) == null) {
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048580, this, activity, bundle) == null) {
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityStarted(Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048581, this, activity) == null) {
                        if (this.f61318a.f61317e == 0) {
                            this.f61318a.f61314a = false;
                            b bVar = this.f61318a;
                            if (!bVar.f61316c) {
                                for (a aVar : bVar.f61315b) {
                                    aVar.b();
                                }
                                this.f61318a.f61316c = true;
                            }
                            for (a aVar2 : this.f61318a.f61315b) {
                                aVar2.a();
                            }
                        }
                        b.c(this.f61318a);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityStopped(Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048582, this, activity) == null) {
                        b.d(this.f61318a);
                        if (this.f61318a.f61317e == 0) {
                            this.f61318a.f61314a = true;
                            Iterator it = this.f61318a.f61315b.iterator();
                            while (it.hasNext()) {
                                it.next();
                            }
                        }
                    }
                }
            });
        }
    }
}
