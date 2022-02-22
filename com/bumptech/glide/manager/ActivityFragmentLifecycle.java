package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes3.dex */
public class ActivityFragmentLifecycle implements Lifecycle {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isDestroyed;
    public boolean isStarted;
    public final Set<LifecycleListener> lifecycleListeners;

    public ActivityFragmentLifecycle() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.lifecycleListeners = Collections.newSetFromMap(new WeakHashMap());
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void addListener(@NonNull LifecycleListener lifecycleListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lifecycleListener) == null) {
            this.lifecycleListeners.add(lifecycleListener);
            if (this.isDestroyed) {
                lifecycleListener.onDestroy();
            } else if (this.isStarted) {
                lifecycleListener.onStart();
            } else {
                lifecycleListener.onStop();
            }
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.isDestroyed = true;
            for (LifecycleListener lifecycleListener : Util.getSnapshot(this.lifecycleListeners)) {
                lifecycleListener.onDestroy();
            }
        }
    }

    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.isStarted = true;
            for (LifecycleListener lifecycleListener : Util.getSnapshot(this.lifecycleListeners)) {
                lifecycleListener.onStart();
            }
        }
    }

    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.isStarted = false;
            for (LifecycleListener lifecycleListener : Util.getSnapshot(this.lifecycleListeners)) {
                lifecycleListener.onStop();
            }
        }
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void removeListener(@NonNull LifecycleListener lifecycleListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, lifecycleListener) == null) {
            this.lifecycleListeners.remove(lifecycleListener);
        }
    }
}
