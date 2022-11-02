package com.bumptech.glide.util.pool;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class StateVerifier {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG = false;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.bumptech.glide.util.pool.StateVerifier$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public abstract void setRecycled(boolean z);

    public abstract void throwIfRecycled();

    /* loaded from: classes7.dex */
    public static class DebugStateVerifier extends StateVerifier {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile RuntimeException recycledAtStackTraceException;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DebugStateVerifier() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((AnonymousClass1) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void throwIfRecycled() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.recycledAtStackTraceException == null) {
                return;
            }
            throw new IllegalStateException("Already released", this.recycledAtStackTraceException);
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void setRecycled(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.recycledAtStackTraceException = new RuntimeException("Released");
                } else {
                    this.recycledAtStackTraceException = null;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class DefaultStateVerifier extends StateVerifier {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean isReleased;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DefaultStateVerifier() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((AnonymousClass1) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void throwIfRecycled() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !this.isReleased) {
                return;
            }
            throw new IllegalStateException("Already released");
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void setRecycled(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.isReleased = z;
            }
        }
    }

    public StateVerifier() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @NonNull
    public static StateVerifier newInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new DefaultStateVerifier();
        }
        return (StateVerifier) invokeV.objValue;
    }

    public /* synthetic */ StateVerifier(AnonymousClass1 anonymousClass1) {
        this();
    }
}
