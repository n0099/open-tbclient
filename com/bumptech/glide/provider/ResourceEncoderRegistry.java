package com.bumptech.glide.provider;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.ResourceEncoder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class ResourceEncoderRegistry {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List encoders;

    /* loaded from: classes7.dex */
    public final class Entry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ResourceEncoder encoder;
        public final Class resourceClass;

        public Entry(Class cls, ResourceEncoder resourceEncoder) {
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

        public boolean handles(Class cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
                return this.resourceClass.isAssignableFrom(cls);
            }
            return invokeL.booleanValue;
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

    public synchronized void append(Class cls, ResourceEncoder resourceEncoder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, cls, resourceEncoder) == null) {
            synchronized (this) {
                this.encoders.add(new Entry(cls, resourceEncoder));
            }
        }
    }

    public synchronized void prepend(Class cls, ResourceEncoder resourceEncoder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cls, resourceEncoder) == null) {
            synchronized (this) {
                this.encoders.add(0, new Entry(cls, resourceEncoder));
            }
        }
    }

    public synchronized ResourceEncoder get(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) {
            synchronized (this) {
                int size = this.encoders.size();
                for (int i = 0; i < size; i++) {
                    Entry entry = (Entry) this.encoders.get(i);
                    if (entry.handles(cls)) {
                        return entry.encoder;
                    }
                }
                return null;
            }
        }
        return (ResourceEncoder) invokeL.objValue;
    }
}
