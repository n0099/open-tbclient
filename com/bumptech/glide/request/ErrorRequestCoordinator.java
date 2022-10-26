package com.bumptech.glide.request;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.request.RequestCoordinator;
/* loaded from: classes7.dex */
public final class ErrorRequestCoordinator implements RequestCoordinator, Request {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile Request error;
    public RequestCoordinator.RequestState errorState;
    public final RequestCoordinator parent;
    public volatile Request primary;
    public RequestCoordinator.RequestState primaryState;
    public final Object requestLock;

    public ErrorRequestCoordinator(Object obj, RequestCoordinator requestCoordinator) {
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
        this.primaryState = requestState;
        this.errorState = requestState;
        this.requestLock = obj;
        this.parent = requestCoordinator;
    }

    private boolean isValidRequest(Request request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, request)) == null) {
            if (!request.equals(this.primary) && (this.primaryState != RequestCoordinator.RequestState.FAILED || !request.equals(this.error))) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyCleared(Request request) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request)) == null) {
            synchronized (this.requestLock) {
                if (parentCanNotifyCleared() && isValidRequest(request)) {
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
                if (parentCanNotifyStatusChanged() && isValidRequest(request)) {
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
                if (parentCanSetImage() && isValidRequest(request)) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, request)) == null) {
            if (!(request instanceof ErrorRequestCoordinator)) {
                return false;
            }
            ErrorRequestCoordinator errorRequestCoordinator = (ErrorRequestCoordinator) request;
            if (!this.primary.isEquivalentTo(errorRequestCoordinator.primary) || !this.error.isEquivalentTo(errorRequestCoordinator.error)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean parentCanNotifyCleared() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            RequestCoordinator requestCoordinator = this.parent;
            if (requestCoordinator != null && !requestCoordinator.canNotifyCleared(this)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private boolean parentCanNotifyStatusChanged() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            RequestCoordinator requestCoordinator = this.parent;
            if (requestCoordinator != null && !requestCoordinator.canNotifyStatusChanged(this)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private boolean parentCanSetImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            RequestCoordinator requestCoordinator = this.parent;
            if (requestCoordinator != null && !requestCoordinator.canSetImage(this)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.request.Request
    public void begin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this.requestLock) {
                if (this.primaryState != RequestCoordinator.RequestState.RUNNING) {
                    this.primaryState = RequestCoordinator.RequestState.RUNNING;
                    this.primary.begin();
                }
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this.requestLock) {
                this.primaryState = RequestCoordinator.RequestState.CLEARED;
                this.primary.clear();
                if (this.errorState != RequestCoordinator.RequestState.CLEARED) {
                    this.errorState = RequestCoordinator.RequestState.CLEARED;
                    this.error.clear();
                }
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
                if (!this.primary.isAnyResourceSet() && !this.error.isAnyResourceSet()) {
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
                if (this.primaryState == RequestCoordinator.RequestState.CLEARED && this.errorState == RequestCoordinator.RequestState.CLEARED) {
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
                if (this.primaryState != RequestCoordinator.RequestState.SUCCESS && this.errorState != RequestCoordinator.RequestState.SUCCESS) {
                    z = false;
                }
                z = true;
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
                if (this.primaryState != RequestCoordinator.RequestState.RUNNING && this.errorState != RequestCoordinator.RequestState.RUNNING) {
                    z = false;
                }
                z = true;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestFailed(Request request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, request) == null) {
            synchronized (this.requestLock) {
                if (!request.equals(this.error)) {
                    this.primaryState = RequestCoordinator.RequestState.FAILED;
                    if (this.errorState != RequestCoordinator.RequestState.RUNNING) {
                        this.errorState = RequestCoordinator.RequestState.RUNNING;
                        this.error.begin();
                    }
                    return;
                }
                this.errorState = RequestCoordinator.RequestState.FAILED;
                if (this.parent != null) {
                    this.parent.onRequestFailed(this);
                }
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestSuccess(Request request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, request) == null) {
            synchronized (this.requestLock) {
                if (request.equals(this.primary)) {
                    this.primaryState = RequestCoordinator.RequestState.SUCCESS;
                } else if (request.equals(this.error)) {
                    this.errorState = RequestCoordinator.RequestState.SUCCESS;
                }
                if (this.parent != null) {
                    this.parent.onRequestSuccess(this);
                }
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this.requestLock) {
                if (this.primaryState == RequestCoordinator.RequestState.RUNNING) {
                    this.primaryState = RequestCoordinator.RequestState.PAUSED;
                    this.primary.pause();
                }
                if (this.errorState == RequestCoordinator.RequestState.RUNNING) {
                    this.errorState = RequestCoordinator.RequestState.PAUSED;
                    this.error.pause();
                }
            }
        }
    }

    public void setRequests(Request request, Request request2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, request, request2) == null) {
            this.primary = request;
            this.error = request2;
        }
    }
}
