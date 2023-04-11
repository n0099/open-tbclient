package com.baidu.tieba;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
/* loaded from: classes7.dex */
public final class yg0 implements ym0, xm0, zm0, an0 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean d;
    public static yg0 e;
    public transient /* synthetic */ FieldHolder $fh;
    public final CopyOnWriteArrayList<ym0> a;
    public final LinkedList<WeakReference<Activity>> b;
    public int c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948329063, "Lcom/baidu/tieba/yg0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948329063, "Lcom/baidu/tieba/yg0;");
        }
    }

    public yg0() {
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
        this.a = new CopyOnWriteArrayList<>();
        this.b = new LinkedList<>();
    }

    public static yg0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (e == null) {
                synchronized (yg0.class) {
                    if (e == null) {
                        e = new yg0();
                    }
                }
            }
            return e;
        }
        return (yg0) invokeV.objValue;
    }

    @Nullable
    public Activity f() {
        InterceptResult invokeV;
        WeakReference<Activity> last;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.b.isEmpty() || (last = this.b.getLast()) == null) {
                return null;
            }
            return last.get();
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

    @Override // com.baidu.tieba.xm0
    @Nullable
    public Activity a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!this.b.isEmpty() && this.b.size() >= 2) {
                LinkedList<WeakReference<Activity>> linkedList = this.b;
                return linkedList.get(linkedList.size() - 2).get();
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xm0
    @Nullable
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
                WeakReference<Activity> weakReference = this.b.get(i);
                if (weakReference != null && (activity = weakReference.get()) != null && !activity.isFinishing()) {
                    return activity;
                }
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.an0
    public void b(@Nullable ym0 ym0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ym0Var) == null) && ym0Var != null && !this.a.contains(ym0Var)) {
            if (d && this.a.size() > 0) {
                CopyOnWriteArrayList<ym0> copyOnWriteArrayList = this.a;
                copyOnWriteArrayList.add(copyOnWriteArrayList.size() - 1, ym0Var);
                return;
            }
            this.a.add(ym0Var);
        }
    }

    @Override // com.baidu.tieba.ym0
    public void onActivityStarted(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, activity) == null) {
            if (g()) {
                Iterator<ym0> it = this.a.iterator();
                while (it.hasNext()) {
                    it.next().onActivityStarted(activity);
                }
            }
            int i = this.c + 1;
            this.c = i;
            if (i == 1) {
                onBackgroundToForeground(activity);
            }
        }
    }

    @Override // com.baidu.tieba.ym0
    public void onActivityStopped(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, activity) == null) {
            if (g()) {
                Iterator<ym0> it = this.a.iterator();
                while (it.hasNext()) {
                    it.next().onActivityStopped(activity);
                }
            }
            int i = this.c - 1;
            this.c = i;
            if (i == 0) {
                onForegroundToBackground(activity);
            }
        }
    }

    @Override // com.baidu.tieba.an0
    public void d(@Nullable ym0 ym0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, ym0Var) == null) && ym0Var != null && this.a.contains(ym0Var)) {
            this.a.remove(ym0Var);
        }
    }

    public void h(@Nullable ym0 ym0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, ym0Var) == null) && ym0Var != null && !this.a.contains(ym0Var)) {
            d = true;
            this.a.add(ym0Var);
        }
    }

    @Override // com.baidu.tieba.ym0
    public void onActivityPaused(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, activity) != null) || !g()) {
            return;
        }
        Iterator<ym0> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onActivityPaused(activity);
        }
    }

    @Override // com.baidu.tieba.ym0
    public void onActivityResumed(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, activity) != null) || !g()) {
            return;
        }
        Iterator<ym0> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onActivityResumed(activity);
        }
    }

    @Override // com.baidu.tieba.ym0
    public void onBackgroundToForeground(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, activity) != null) || !g()) {
            return;
        }
        Iterator<ym0> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onBackgroundToForeground(activity);
        }
    }

    @Override // com.baidu.tieba.ym0
    public void onForegroundToBackground(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, activity) != null) || !g()) {
            return;
        }
        Iterator<ym0> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onForegroundToBackground(activity);
        }
    }

    @Override // com.baidu.tieba.ym0
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, activity, bundle) == null) {
            this.b.add(new WeakReference<>(activity));
            if (!g()) {
                return;
            }
            Iterator<ym0> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onActivityCreated(activity, bundle);
            }
        }
    }

    @Override // com.baidu.tieba.ym0
    public void onActivityDestroyed(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity) == null) {
            if (g()) {
                Iterator<ym0> it = this.a.iterator();
                while (it.hasNext()) {
                    it.next().onActivityDestroyed(activity);
                }
            }
            if (this.b.isEmpty()) {
                return;
            }
            int size = this.b.size();
            while (true) {
                size--;
                if (size >= 0) {
                    if (this.b.get(size).get() == activity) {
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

    @Override // com.baidu.tieba.ym0
    public void onActivitySaveInstanceState(@NonNull Activity activity, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, activity, bundle) != null) || !g()) {
            return;
        }
        Iterator<ym0> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onActivitySaveInstanceState(activity, bundle);
        }
    }
}
