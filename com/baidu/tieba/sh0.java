package com.baidu.tieba;

import android.app.Activity;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public final class sh0 implements nn0, mn0, on0, pn0 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean d;
    public static sh0 e;
    public transient /* synthetic */ FieldHolder $fh;
    public final CopyOnWriteArrayList a;
    public final LinkedList b;
    public int c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948151278, "Lcom/baidu/tieba/sh0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948151278, "Lcom/baidu/tieba/sh0;");
        }
    }

    public sh0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new CopyOnWriteArrayList();
        this.b = new LinkedList();
    }

    public static sh0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (e == null) {
                synchronized (sh0.class) {
                    if (e == null) {
                        e = new sh0();
                    }
                }
            }
            return e;
        }
        return (sh0) invokeV.objValue;
    }

    public Activity f() {
        InterceptResult invokeV;
        WeakReference weakReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.b.isEmpty() || (weakReference = (WeakReference) this.b.getLast()) == null) {
                return null;
            }
            return (Activity) weakReference.get();
        }
        return (Activity) invokeV.objValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a.size() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.mn0
    public Activity a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!this.b.isEmpty() && this.b.size() >= 2) {
                LinkedList linkedList = this.b;
                return (Activity) ((WeakReference) linkedList.get(linkedList.size() - 2)).get();
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mn0
    public Activity c() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int size = this.b.size();
            if (size < 2) {
                return f();
            }
            for (int i = size - 1; i >= 0; i--) {
                WeakReference weakReference = (WeakReference) this.b.get(i);
                if (weakReference != null && (activity = (Activity) weakReference.get()) != null && !activity.isFinishing()) {
                    return activity;
                }
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pn0
    public void b(nn0 nn0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nn0Var) == null) && nn0Var != null && !this.a.contains(nn0Var)) {
            if (d && this.a.size() > 0) {
                CopyOnWriteArrayList copyOnWriteArrayList = this.a;
                copyOnWriteArrayList.add(copyOnWriteArrayList.size() - 1, nn0Var);
                return;
            }
            this.a.add(nn0Var);
        }
    }

    @Override // com.baidu.tieba.nn0
    public void onActivityStarted(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, activity) == null) {
            if (g()) {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    ((nn0) it.next()).onActivityStarted(activity);
                }
            }
            int i = this.c + 1;
            this.c = i;
            if (i == 1) {
                onBackgroundToForeground(activity);
            }
        }
    }

    @Override // com.baidu.tieba.nn0
    public void onActivityStopped(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, activity) == null) {
            if (g()) {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    ((nn0) it.next()).onActivityStopped(activity);
                }
            }
            int i = this.c - 1;
            this.c = i;
            if (i == 0) {
                onForegroundToBackground(activity);
            }
        }
    }

    @Override // com.baidu.tieba.pn0
    public void d(nn0 nn0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, nn0Var) == null) && nn0Var != null && this.a.contains(nn0Var)) {
            this.a.remove(nn0Var);
        }
    }

    public void h(nn0 nn0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, nn0Var) == null) && nn0Var != null && !this.a.contains(nn0Var)) {
            d = true;
            this.a.add(nn0Var);
        }
    }

    @Override // com.baidu.tieba.nn0
    public void onActivityPaused(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, activity) != null) || !g()) {
            return;
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((nn0) it.next()).onActivityPaused(activity);
        }
    }

    @Override // com.baidu.tieba.nn0
    public void onActivityResumed(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, activity) != null) || !g()) {
            return;
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((nn0) it.next()).onActivityResumed(activity);
        }
    }

    @Override // com.baidu.tieba.nn0
    public void onBackgroundToForeground(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, activity) != null) || !g()) {
            return;
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((nn0) it.next()).onBackgroundToForeground(activity);
        }
    }

    @Override // com.baidu.tieba.nn0
    public void onForegroundToBackground(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, activity) != null) || !g()) {
            return;
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((nn0) it.next()).onForegroundToBackground(activity);
        }
    }

    @Override // com.baidu.tieba.nn0
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, activity, bundle) == null) {
            this.b.add(new WeakReference(activity));
            if (!g()) {
                return;
            }
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((nn0) it.next()).onActivityCreated(activity, bundle);
            }
        }
    }

    @Override // com.baidu.tieba.nn0
    public void onActivityDestroyed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity) == null) {
            if (g()) {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    ((nn0) it.next()).onActivityDestroyed(activity);
                }
            }
            if (this.b.isEmpty()) {
                return;
            }
            int size = this.b.size();
            while (true) {
                size--;
                if (size >= 0) {
                    if (((Activity) ((WeakReference) this.b.get(size)).get()) == activity) {
                        break;
                    }
                } else {
                    size = -1;
                    break;
                }
            }
            if (size != -1) {
                this.b.remove(size);
            }
        }
    }

    @Override // com.baidu.tieba.nn0
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, activity, bundle) != null) || !g()) {
            return;
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((nn0) it.next()).onActivitySaveInstanceState(activity, bundle);
        }
    }
}
