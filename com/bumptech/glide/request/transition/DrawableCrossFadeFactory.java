package com.bumptech.glide.request.transition;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.DataSource;
/* loaded from: classes7.dex */
public class DrawableCrossFadeFactory implements TransitionFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int duration;
    public final boolean isCrossFadeEnabled;
    public DrawableCrossFadeTransition resourceTransition;

    /* loaded from: classes7.dex */
    public class Builder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int DEFAULT_DURATION_MS = 300;
        public transient /* synthetic */ FieldHolder $fh;
        public final int durationMillis;
        public boolean isCrossFadeEnabled;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder() {
            this(300);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    this(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public DrawableCrossFadeFactory build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new DrawableCrossFadeFactory(this.durationMillis, this.isCrossFadeEnabled);
            }
            return (DrawableCrossFadeFactory) invokeV.objValue;
        }

        public Builder(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.durationMillis = i;
        }

        public Builder setCrossFadeEnabled(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.isCrossFadeEnabled = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }
    }

    public DrawableCrossFadeFactory(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.duration = i;
        this.isCrossFadeEnabled = z;
    }

    private Transition getResourceTransition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.resourceTransition == null) {
                this.resourceTransition = new DrawableCrossFadeTransition(this.duration, this.isCrossFadeEnabled);
            }
            return this.resourceTransition;
        }
        return (Transition) invokeV.objValue;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition build(DataSource dataSource, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, dataSource, z)) == null) {
            if (dataSource == DataSource.MEMORY_CACHE) {
                return NoTransition.get();
            }
            return getResourceTransition();
        }
        return (Transition) invokeLZ.objValue;
    }
}
