package com.bumptech.glide.request;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.request.RequestCoordinator;
/* loaded from: classes7.dex */
public class ThumbnailRequestCoordinator implements RequestCoordinator, Request {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile Request full;
    @GuardedBy("requestLock")
    public RequestCoordinator.RequestState fullState;
    @GuardedBy("requestLock")
    public boolean isRunningDuringBegin;
    @Nullable
    public final RequestCoordinator parent;
    public final Object requestLock;
    public volatile Request thumb;
    @GuardedBy("requestLock")
    public RequestCoordinator.RequestState thumbState;

    public ThumbnailRequestCoordinator(Object obj, @Nullable RequestCoordinator requestCoordinator) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj, requestCoordinator};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.fullState = requestState;
        this.thumbState = requestState;
        this.requestLock = obj;
        this.parent = requestCoordinator;
    }

    @GuardedBy("requestLock")
    private boolean parentCanNotifyCleared() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            RequestCoordinator requestCoordinator = this.parent;
            if (requestCoordinator != null && !requestCoordinator.canNotifyCleared(this)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @GuardedBy("requestLock")
    private boolean parentCanNotifyStatusChanged() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            RequestCoordinator requestCoordinator = this.parent;
            if (requestCoordinator != null && !requestCoordinator.canNotifyStatusChanged(this)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @GuardedBy("requestLock")
    private boolean parentCanSetImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            RequestCoordinator requestCoordinator = this.parent;
            if (requestCoordinator != null && !requestCoordinator.canSetImage(this)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this.requestLock) {
                this.isRunningDuringBegin = false;
                this.fullState = RequestCoordinator.RequestState.CLEARED;
                this.thumbState = RequestCoordinator.RequestState.CLEARED;
                this.thumb.clear();
                this.full.clear();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        InterceptResult invokeV;
        RequestCoordinator requestCoordinator;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this.requestLock) {
                if (this.parent != null) {
                    requestCoordinator = this.parent.getRoot();
                } else {
                    requestCoordinator = this;
                }
            }
            return requestCoordinator;
        }
        return (RequestCoordinator) invokeV.objValue;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.Request
    public boolean isAnyResourceSet() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this.requestLock) {
                if (!this.thumb.isAnyResourceSet() && !this.full.isAnyResourceSet()) {
                    z = false;
                }
                z = true;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isCleared() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this.requestLock) {
                if (this.fullState == RequestCoordinator.RequestState.CLEARED) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this.requestLock) {
                if (this.fullState == RequestCoordinator.RequestState.SUCCESS) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this.requestLock) {
                if (this.fullState == RequestCoordinator.RequestState.RUNNING) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.request.Request
    public void begin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this.requestLock) {
                this.isRunningDuringBegin = true;
                if (this.fullState != RequestCoordinator.RequestState.SUCCESS && this.thumbState != RequestCoordinator.RequestState.RUNNING) {
                    this.thumbState = RequestCoordinator.RequestState.RUNNING;
                    this.thumb.begin();
                }
                if (this.isRunningDuringBegin && this.fullState != RequestCoordinator.RequestState.RUNNING) {
                    this.fullState = RequestCoordinator.RequestState.RUNNING;
                    this.full.begin();
                }
                this.isRunningDuringBegin = false;
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyCleared(Request request) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request)) == null) {
            synchronized (this.requestLock) {
                if (parentCanNotifyCleared() && request.equals(this.full) && this.fullState != RequestCoordinator.RequestState.PAUSED) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyStatusChanged(Request request) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, request)) == null) {
            synchronized (this.requestLock) {
                if (parentCanNotifyStatusChanged() && request.equals(this.full) && !isAnyResourceSet()) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canSetImage(Request request) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, request)) == null) {
            synchronized (this.requestLock) {
                if (parentCanSetImage() && (request.equals(this.full) || this.fullState != RequestCoordinator.RequestState.SUCCESS)) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestFailed(Request request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, request) == null) {
            synchronized (this.requestLock) {
                if (!request.equals(this.full)) {
                    this.thumbState = RequestCoordinator.RequestState.FAILED;
                    return;
                }
                this.fullState = RequestCoordinator.RequestState.FAILED;
                if (this.parent != null) {
                    this.parent.onRequestFailed(this);
                }
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, request)) == null) {
            if (!(request instanceof ThumbnailRequestCoordinator)) {
                return false;
            }
            ThumbnailRequestCoordinator thumbnailRequestCoordinator = (ThumbnailRequestCoordinator) request;
            if (this.full == null) {
                if (thumbnailRequestCoordinator.full != null) {
                    return false;
                }
            } else if (!this.full.isEquivalentTo(thumbnailRequestCoordinator.full)) {
                return false;
            }
            if (this.thumb == null) {
                if (thumbnailRequestCoordinator.thumb != null) {
                    return false;
                }
            } else if (!this.thumb.isEquivalentTo(thumbnailRequestCoordinator.thumb)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestSuccess(Request request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, request) == null) {
            synchronized (this.requestLock) {
                if (request.equals(this.thumb)) {
                    this.thumbState = RequestCoordinator.RequestState.SUCCESS;
                    return;
                }
                this.fullState = RequestCoordinator.RequestState.SUCCESS;
                if (this.parent != null) {
                    this.parent.onRequestSuccess(this);
                }
                if (!this.thumbState.isComplete()) {
                    this.thumb.clear();
                }
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this.requestLock) {
                if (!this.thumbState.isComplete()) {
                    this.thumbState = RequestCoordinator.RequestState.PAUSED;
                    this.thumb.pause();
                }
                if (!this.fullState.isComplete()) {
                    this.fullState = RequestCoordinator.RequestState.PAUSED;
                    this.full.pause();
                }
            }
        }
    }

    public void setRequests(Request request, Request request2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, request, request2) == null) {
            this.full = request;
            this.thumb = request2;
        }
    }
}
