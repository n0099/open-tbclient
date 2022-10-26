package com.bumptech.glide.provider;

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
    public final ArrayMap registeredResourceClassCache;
    public final AtomicReference resourceClassKeyRef;

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
        this.resourceClassKeyRef = new AtomicReference();
        this.registeredResourceClassCache = new ArrayMap();
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this.registeredResourceClassCache) {
                this.registeredResourceClassCache.clear();
            }
        }
    }

    public List get(Class cls, Class cls2, Class cls3) {
        InterceptResult invokeLLL;
        List list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, cls2, cls3)) == null) {
            MultiClassKey multiClassKey = (MultiClassKey) this.resourceClassKeyRef.getAndSet(null);
            if (multiClassKey == null) {
                multiClassKey = new MultiClassKey(cls, cls2, cls3);
            } else {
                multiClassKey.set(cls, cls2, cls3);
            }
            synchronized (this.registeredResourceClassCache) {
                list = (List) this.registeredResourceClassCache.get(multiClassKey);
            }
            this.resourceClassKeyRef.set(multiClassKey);
            return list;
        }
        return (List) invokeLLL.objValue;
    }

    public void put(Class cls, Class cls2, Class cls3, List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, cls, cls2, cls3, list) == null) {
            synchronized (this.registeredResourceClassCache) {
                this.registeredResourceClassCache.put(new MultiClassKey(cls, cls2, cls3), list);
            }
        }
    }
}
