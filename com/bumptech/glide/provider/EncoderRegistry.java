package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.Encoder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class EncoderRegistry {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<Entry<?>> encoders;

    /* loaded from: classes6.dex */
    public static final class Entry<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Class<T> dataClass;
        public final Encoder<T> encoder;

        public Entry(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls, encoder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.dataClass = cls;
            this.encoder = encoder;
        }

        public boolean handles(@NonNull Class<?> cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) ? this.dataClass.isAssignableFrom(cls) : invokeL.booleanValue;
        }
    }

    public EncoderRegistry() {
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
        this.encoders = new ArrayList();
    }

    public synchronized <T> void append(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, cls, encoder) == null) {
            synchronized (this) {
                this.encoders.add(new Entry<>(cls, encoder));
            }
        }
    }

    @Nullable
    public synchronized <T> Encoder<T> getEncoder(@NonNull Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) {
            synchronized (this) {
                for (Entry<?> entry : this.encoders) {
                    if (entry.handles(cls)) {
                        return (Encoder<T>) entry.encoder;
                    }
                }
                return null;
            }
        }
        return (Encoder) invokeL.objValue;
    }

    public synchronized <T> void prepend(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cls, encoder) == null) {
            synchronized (this) {
                this.encoders.add(0, new Entry<>(cls, encoder));
            }
        }
    }
}
