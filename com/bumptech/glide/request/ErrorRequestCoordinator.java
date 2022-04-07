package com.bumptech.glide.request;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class ErrorRequestCoordinator implements RequestCoordinator, Request {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Request error;
    @Nullable
    public final RequestCoordinator parent;
    public Request primary;

    public ErrorRequestCoordinator(@Nullable RequestCoordinator requestCoordinator) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {requestCoordinator};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.parent = requestCoordinator;
    }

    private boolean isValidRequest(Request request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, request)) == null) ? request.equals(this.primary) || (this.primary.isFailed() && request.equals(this.error)) : invokeL.booleanValue;
    }

    private boolean parentCanNotifyCleared() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            RequestCoordinator requestCoordinator = this.parent;
            return requestCoordinator == null || requestCoordinator.canNotifyCleared(this);
        }
        return invokeV.booleanValue;
    }

    private boolean parentCanNotifyStatusChanged() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            RequestCoordinator requestCoordinator = this.parent;
            return requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this);
        }
        return invokeV.booleanValue;
    }

    private boolean parentCanSetImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            RequestCoordinator requestCoordinator = this.parent;
            return requestCoordinator == null || requestCoordinator.canSetImage(this);
        }
        return invokeV.booleanValue;
    }

    private boolean parentIsAnyResourceSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            RequestCoordinator requestCoordinator = this.parent;
            return requestCoordinator != null && requestCoordinator.isAnyResourceSet();
        }
        return invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.request.Request
    public void begin() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.primary.isRunning()) {
            return;
        }
        this.primary.begin();
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyCleared(Request request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request)) == null) ? parentCanNotifyCleared() && isValidRequest(request) : invokeL.booleanValue;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyStatusChanged(Request request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, request)) == null) ? parentCanNotifyStatusChanged() && isValidRequest(request) : invokeL.booleanValue;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canSetImage(Request request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, request)) == null) ? parentCanSetImage() && isValidRequest(request) : invokeL.booleanValue;
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.primary.clear();
            if (this.error.isRunning()) {
                this.error.clear();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean isAnyResourceSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? parentIsAnyResourceSet() || isResourceSet() : invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isCleared() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return (this.primary.isFailed() ? this.error : this.primary).isCleared();
        }
        return invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return (this.primary.isFailed() ? this.error : this.primary).isComplete();
        }
        return invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, request)) == null) {
            if (request instanceof ErrorRequestCoordinator) {
                ErrorRequestCoordinator errorRequestCoordinator = (ErrorRequestCoordinator) request;
                return this.primary.isEquivalentTo(errorRequestCoordinator.primary) && this.error.isEquivalentTo(errorRequestCoordinator.error);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isFailed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.primary.isFailed() && this.error.isFailed() : invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isResourceSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return (this.primary.isFailed() ? this.error : this.primary).isResourceSet();
        }
        return invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return (this.primary.isFailed() ? this.error : this.primary).isRunning();
        }
        return invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestFailed(Request request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, request) == null) {
            if (!request.equals(this.error)) {
                if (this.error.isRunning()) {
                    return;
                }
                this.error.begin();
                return;
            }
            RequestCoordinator requestCoordinator = this.parent;
            if (requestCoordinator != null) {
                requestCoordinator.onRequestFailed(this);
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestSuccess(Request request) {
        RequestCoordinator requestCoordinator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, request) == null) || (requestCoordinator = this.parent) == null) {
            return;
        }
        requestCoordinator.onRequestSuccess(this);
    }

    @Override // com.bumptech.glide.request.Request
    public void recycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.primary.recycle();
            this.error.recycle();
        }
    }

    public void setRequests(Request request, Request request2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, request, request2) == null) {
            this.primary = request;
            this.error = request2;
        }
    }
}
