package com.bumptech.glide.request;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.booster.data.TornadoLiteRuntime;
/* loaded from: classes7.dex */
public interface RequestCoordinator {
    boolean canNotifyCleared(Request request);

    boolean canNotifyStatusChanged(Request request);

    boolean canSetImage(Request request);

    RequestCoordinator getRoot();

    boolean isAnyResourceSet();

    void onRequestFailed(Request request);

    void onRequestSuccess(Request request);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public final class RequestState {
        public static final /* synthetic */ RequestState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RequestState CLEARED;
        public static final RequestState FAILED;
        public static final RequestState PAUSED;
        public static final RequestState RUNNING;
        public static final RequestState SUCCESS;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean isComplete;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1467626217, "Lcom/bumptech/glide/request/RequestCoordinator$RequestState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1467626217, "Lcom/bumptech/glide/request/RequestCoordinator$RequestState;");
                    return;
                }
            }
            RUNNING = new RequestState(TornadoLiteRuntime.STATE_RUNNING, 0, false);
            PAUSED = new RequestState("PAUSED", 1, false);
            CLEARED = new RequestState("CLEARED", 2, false);
            SUCCESS = new RequestState("SUCCESS", 3, true);
            RequestState requestState = new RequestState("FAILED", 4, true);
            FAILED = requestState;
            $VALUES = new RequestState[]{RUNNING, PAUSED, CLEARED, SUCCESS, requestState};
        }

        public RequestState(String str, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.isComplete = z;
        }

        public static RequestState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (RequestState) Enum.valueOf(RequestState.class, str);
            }
            return (RequestState) invokeL.objValue;
        }

        public static RequestState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (RequestState[]) $VALUES.clone();
            }
            return (RequestState[]) invokeV.objValue;
        }

        public boolean isComplete() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.isComplete;
            }
            return invokeV.booleanValue;
        }
    }
}
