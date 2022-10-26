package com.bumptech.glide.provider;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.Encoder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class EncoderRegistry {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List encoders;

    /* loaded from: classes7.dex */
    public final class Entry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Class dataClass;
        public final Encoder encoder;

        public Entry(Class cls, Encoder encoder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls, encoder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.dataClass = cls;
            this.encoder = encoder;
        }

        public boolean handles(Class cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
                return this.dataClass.isAssignableFrom(cls);
            }
            return invokeL.booleanValue;
        }
    }

    public EncoderRegistry() {
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

    public synchronized void append(Class cls, Encoder encoder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, cls, encoder) == null) {
            synchronized (this) {
                this.encoders.add(new Entry(cls, encoder));
            }
        }
    }

    public synchronized void prepend(Class cls, Encoder encoder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cls, encoder) == null) {
            synchronized (this) {
                this.encoders.add(0, new Entry(cls, encoder));
            }
        }
    }

    public synchronized Encoder getEncoder(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) {
            synchronized (this) {
                for (Entry entry : this.encoders) {
                    if (entry.handles(cls)) {
                        return entry.encoder;
                    }
                }
                return null;
            }
        }
        return (Encoder) invokeL.objValue;
    }
}
