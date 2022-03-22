package com.bumptech.glide.manager;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes6.dex */
public class RequestTracker {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "RequestTracker";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isPaused;
    public final List<Request> pendingRequests;
    public final Set<Request> requests;

    public RequestTracker() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.requests = Collections.newSetFromMap(new WeakHashMap());
        this.pendingRequests = new ArrayList();
    }

    private boolean clearRemoveAndMaybeRecycle(@Nullable Request request, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, this, request, z)) == null) {
            boolean z2 = true;
            if (request == null) {
                return true;
            }
            boolean remove = this.requests.remove(request);
            if (!this.pendingRequests.remove(request) && !remove) {
                z2 = false;
            }
            if (z2) {
                request.clear();
                if (z) {
                    request.recycle();
                }
            }
            return z2;
        }
        return invokeLZ.booleanValue;
    }

    @VisibleForTesting
    public void addRequest(Request request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, request) == null) {
            this.requests.add(request);
        }
    }

    public boolean clearRemoveAndRecycle(@Nullable Request request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request)) == null) ? clearRemoveAndMaybeRecycle(request, true) : invokeL.booleanValue;
    }

    public void clearRequests() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (Request request : Util.getSnapshot(this.requests)) {
                clearRemoveAndMaybeRecycle(request, false);
            }
            this.pendingRequests.clear();
        }
    }

    public boolean isPaused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.isPaused : invokeV.booleanValue;
    }

    public void pauseAllRequests() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.isPaused = true;
            for (Request request : Util.getSnapshot(this.requests)) {
                if (request.isRunning() || request.isComplete()) {
                    request.clear();
                    this.pendingRequests.add(request);
                }
            }
        }
    }

    public void pauseRequests() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.isPaused = true;
            for (Request request : Util.getSnapshot(this.requests)) {
                if (request.isRunning()) {
                    request.clear();
                    this.pendingRequests.add(request);
                }
            }
        }
    }

    public void restartRequests() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            for (Request request : Util.getSnapshot(this.requests)) {
                if (!request.isComplete() && !request.isCleared()) {
                    request.clear();
                    if (!this.isPaused) {
                        request.begin();
                    } else {
                        this.pendingRequests.add(request);
                    }
                }
            }
        }
    }

    public void resumeRequests() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.isPaused = false;
            for (Request request : Util.getSnapshot(this.requests)) {
                if (!request.isComplete() && !request.isRunning()) {
                    request.begin();
                }
            }
            this.pendingRequests.clear();
        }
    }

    public void runRequest(@NonNull Request request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, request) == null) {
            this.requests.add(request);
            if (!this.isPaused) {
                request.begin();
                return;
            }
            request.clear();
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Paused, delaying request");
            }
            this.pendingRequests.add(request);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return super.toString() + "{numRequests=" + this.requests.size() + ", isPaused=" + this.isPaused + "}";
        }
        return (String) invokeV.objValue;
    }
}
