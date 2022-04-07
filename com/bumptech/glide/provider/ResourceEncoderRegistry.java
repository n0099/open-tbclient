package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.ResourceEncoder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ResourceEncoderRegistry {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<Entry<?>> encoders;

    /* loaded from: classes4.dex */
    public static final class Entry<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ResourceEncoder<T> encoder;
        public final Class<T> resourceClass;

        public Entry(@NonNull Class<T> cls, @NonNull ResourceEncoder<T> resourceEncoder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls, resourceEncoder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.resourceClass = cls;
            this.encoder = resourceEncoder;
        }

        public boolean handles(@NonNull Class<?> cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) ? this.resourceClass.isAssignableFrom(cls) : invokeL.booleanValue;
        }
    }

    public ResourceEncoderRegistry() {
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
        this.encoders = new ArrayList();
    }

    public synchronized <Z> void append(@NonNull Class<Z> cls, @NonNull ResourceEncoder<Z> resourceEncoder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, cls, resourceEncoder) == null) {
            synchronized (this) {
                this.encoders.add(new Entry<>(cls, resourceEncoder));
            }
        }
    }

    @Nullable
    public synchronized <Z> ResourceEncoder<Z> get(@NonNull Class<Z> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) {
            synchronized (this) {
                int size = this.encoders.size();
                for (int i = 0; i < size; i++) {
                    Entry<?> entry = this.encoders.get(i);
                    if (entry.handles(cls)) {
                        return (ResourceEncoder<Z>) entry.encoder;
                    }
                }
                return null;
            }
        }
        return (ResourceEncoder) invokeL.objValue;
    }

    public synchronized <Z> void prepend(@NonNull Class<Z> cls, @NonNull ResourceEncoder<Z> resourceEncoder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cls, resourceEncoder) == null) {
            synchronized (this) {
                this.encoders.add(0, new Entry<>(cls, resourceEncoder));
            }
        }
    }
}
