package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.util.MultiClassKey;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public class ModelToResourceClassCache {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayMap<MultiClassKey, List<Class<?>>> registeredResourceClassCache;
    public final AtomicReference<MultiClassKey> resourceClassKeyRef;

    public ModelToResourceClassCache() {
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
        this.resourceClassKeyRef = new AtomicReference<>();
        this.registeredResourceClassCache = new ArrayMap<>();
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this.registeredResourceClassCache) {
                this.registeredResourceClassCache.clear();
            }
        }
    }

    @Nullable
    public List<Class<?>> get(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        InterceptResult invokeLL;
        List<Class<?>> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, cls2)) == null) {
            MultiClassKey andSet = this.resourceClassKeyRef.getAndSet(null);
            if (andSet == null) {
                andSet = new MultiClassKey(cls, cls2);
            } else {
                andSet.set(cls, cls2);
            }
            synchronized (this.registeredResourceClassCache) {
                list = this.registeredResourceClassCache.get(andSet);
            }
            this.resourceClassKeyRef.set(andSet);
            return list;
        }
        return (List) invokeLL.objValue;
    }

    public void put(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull List<Class<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cls, cls2, list) == null) {
            synchronized (this.registeredResourceClassCache) {
                this.registeredResourceClassCache.put(new MultiClassKey(cls, cls2), list);
            }
        }
    }
}
