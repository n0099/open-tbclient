package com.bumptech.glide.request;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class ThumbnailRequestCoordinator implements RequestCoordinator, Request {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Request full;
    public boolean isRunning;
    @Nullable
    public final RequestCoordinator parent;
    public Request thumb;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @VisibleForTesting
    public ThumbnailRequestCoordinator() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((RequestCoordinator) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.isRunning = true;
            if (!this.full.isComplete() && !this.thumb.isRunning()) {
                this.thumb.begin();
            }
            if (!this.isRunning || this.full.isRunning()) {
                return;
            }
            this.full.begin();
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyCleared(Request request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request)) == null) ? parentCanNotifyCleared() && request.equals(this.full) : invokeL.booleanValue;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyStatusChanged(Request request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, request)) == null) ? parentCanNotifyStatusChanged() && request.equals(this.full) && !isAnyResourceSet() : invokeL.booleanValue;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canSetImage(Request request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, request)) == null) ? parentCanSetImage() && (request.equals(this.full) || !this.full.isResourceSet()) : invokeL.booleanValue;
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.isRunning = false;
            this.thumb.clear();
            this.full.clear();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.full.isCleared() : invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.full.isComplete() || this.thumb.isComplete() : invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, request)) == null) {
            if (request instanceof ThumbnailRequestCoordinator) {
                ThumbnailRequestCoordinator thumbnailRequestCoordinator = (ThumbnailRequestCoordinator) request;
                Request request2 = this.full;
                if (request2 == null) {
                    if (thumbnailRequestCoordinator.full != null) {
                        return false;
                    }
                } else if (!request2.isEquivalentTo(thumbnailRequestCoordinator.full)) {
                    return false;
                }
                Request request3 = this.thumb;
                Request request4 = thumbnailRequestCoordinator.thumb;
                if (request3 == null) {
                    if (request4 != null) {
                        return false;
                    }
                } else if (!request3.isEquivalentTo(request4)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isFailed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.full.isFailed() : invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isResourceSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.full.isResourceSet() || this.thumb.isResourceSet() : invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.full.isRunning() : invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestFailed(Request request) {
        RequestCoordinator requestCoordinator;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, request) == null) && request.equals(this.full) && (requestCoordinator = this.parent) != null) {
            requestCoordinator.onRequestFailed(this);
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestSuccess(Request request) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, request) == null) || request.equals(this.thumb)) {
            return;
        }
        RequestCoordinator requestCoordinator = this.parent;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestSuccess(this);
        }
        if (this.thumb.isComplete()) {
            return;
        }
        this.thumb.clear();
    }

    @Override // com.bumptech.glide.request.Request
    public void recycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.full.recycle();
            this.thumb.recycle();
        }
    }

    public void setRequests(Request request, Request request2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, request, request2) == null) {
            this.full = request;
            this.thumb = request2;
        }
    }

    public ThumbnailRequestCoordinator(@Nullable RequestCoordinator requestCoordinator) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {requestCoordinator};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.parent = requestCoordinator;
    }
}
