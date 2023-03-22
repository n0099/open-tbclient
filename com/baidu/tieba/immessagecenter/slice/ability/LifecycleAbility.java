package com.baidu.tieba.immessagecenter.slice.ability;

import androidx.annotation.CallSuper;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\b\u0010\b\u001a\u00020\u0003H\u0017J\b\u0010\t\u001a\u00020\u0003H\u0017J\b\u0010\n\u001a\u00020\u0003H\u0017J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\b\u0010\f\u001a\u00020\u0003H\u0017J\b\u0010\r\u001a\u00020\u0003H\u0017J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\b\u0010\u000f\u001a\u00020\u0003H\u0017J\b\u0010\u0010\u001a\u00020\u0003H\u0017J\b\u0010\u0011\u001a\u00020\u0003H\u0017J\b\u0010\u0012\u001a\u00020\u0003H\u0017J\b\u0010\u0013\u001a\u00020\u0003H\u0017J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\b\u0010\u0015\u001a\u00020\u0003H\u0017J\b\u0010\u0016\u001a\u00020\u0003H\u0017¨\u0006\u0017"}, d2 = {"Lcom/baidu/tieba/immessagecenter/slice/ability/LifecycleAbility;", "Landroidx/lifecycle/LifecycleObserver;", "onAny", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "onCreate", MissionEvent.MESSAGE_DESTROY, MissionEvent.MESSAGE_PAUSE, "onPostAny", "onPostCreate", "onPostDestroy", "onPreAny", "onPreCreate", "onPreDestroy", "onResume", "onStart", MissionEvent.MESSAGE_STOP, "performAny", "performCreate", "performDestroy", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface LifecycleAbility extends LifecycleObserver {
    @CallSuper
    void I();

    @CallSuper
    void M(LifecycleOwner lifecycleOwner, Lifecycle.Event event);

    @CallSuper
    void N();

    @CallSuper
    void f(LifecycleOwner lifecycleOwner, Lifecycle.Event event);

    @CallSuper
    void onCreate();

    @CallSuper
    void onDestroy();

    @CallSuper
    void p();

    @CallSuper
    void t();

    @CallSuper
    void y(LifecycleOwner lifecycleOwner, Lifecycle.Event event);

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @CallSuper
        public static void a(LifecycleAbility lifecycleAbility, LifecycleOwner owner, Lifecycle.Event event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65536, null, lifecycleAbility, owner, event) == null) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                Intrinsics.checkNotNullParameter(event, "event");
            }
        }

        @CallSuper
        public static void b(LifecycleAbility lifecycleAbility) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, null, lifecycleAbility) == null) {
            }
        }

        @CallSuper
        public static void c(LifecycleAbility lifecycleAbility) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, null, lifecycleAbility) == null) {
            }
        }

        @CallSuper
        public static void d(LifecycleAbility lifecycleAbility, LifecycleOwner owner, Lifecycle.Event event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65539, null, lifecycleAbility, owner, event) == null) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                Intrinsics.checkNotNullParameter(event, "event");
            }
        }

        @CallSuper
        public static void e(LifecycleAbility lifecycleAbility) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, lifecycleAbility) == null) {
            }
        }

        @CallSuper
        public static void f(LifecycleAbility lifecycleAbility) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65541, null, lifecycleAbility) == null) {
            }
        }

        @CallSuper
        public static void g(LifecycleAbility lifecycleAbility, LifecycleOwner owner, Lifecycle.Event event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65542, null, lifecycleAbility, owner, event) == null) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                Intrinsics.checkNotNullParameter(event, "event");
            }
        }

        @CallSuper
        public static void h(LifecycleAbility lifecycleAbility) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65543, null, lifecycleAbility) == null) {
            }
        }

        @CallSuper
        public static void i(LifecycleAbility lifecycleAbility) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65544, null, lifecycleAbility) == null) {
            }
        }

        @CallSuper
        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        public static void onPause(LifecycleAbility lifecycleAbility) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65545, null, lifecycleAbility) == null) {
            }
        }

        @CallSuper
        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public static void onResume(LifecycleAbility lifecycleAbility) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65546, null, lifecycleAbility) == null) {
            }
        }

        @CallSuper
        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public static void onStart(LifecycleAbility lifecycleAbility) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65547, null, lifecycleAbility) == null) {
            }
        }

        @CallSuper
        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public static void onStop(LifecycleAbility lifecycleAbility) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65548, null, lifecycleAbility) == null) {
            }
        }

        @CallSuper
        @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
        public static void performAny(LifecycleAbility lifecycleAbility, LifecycleOwner owner, Lifecycle.Event event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65549, null, lifecycleAbility, owner, event) == null) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                Intrinsics.checkNotNullParameter(event, "event");
                lifecycleAbility.y(owner, event);
                lifecycleAbility.M(owner, event);
                lifecycleAbility.f(owner, event);
            }
        }

        @CallSuper
        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        public static void performCreate(LifecycleAbility lifecycleAbility) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65550, null, lifecycleAbility) == null) {
                lifecycleAbility.p();
                lifecycleAbility.onCreate();
                lifecycleAbility.t();
            }
        }

        @CallSuper
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public static void performDestroy(LifecycleAbility lifecycleAbility) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65551, null, lifecycleAbility) == null) {
                lifecycleAbility.N();
                lifecycleAbility.onDestroy();
                lifecycleAbility.I();
            }
        }
    }
}
