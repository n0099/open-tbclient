package com.bumptech.glide.provider;

import androidx.collection.ArrayMap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.resource.transcode.UnitTranscoder;
import com.bumptech.glide.util.MultiClassKey;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public class LoadPathCache {
    public static /* synthetic */ Interceptable $ic;
    public static final LoadPath NO_PATHS_SIGNAL;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayMap cache;
    public final AtomicReference keyRef;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1205402065, "Lcom/bumptech/glide/provider/LoadPathCache;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1205402065, "Lcom/bumptech/glide/provider/LoadPathCache;");
                return;
            }
        }
        NO_PATHS_SIGNAL = new LoadPath(Object.class, Object.class, Object.class, Collections.singletonList(new DecodePath(Object.class, Object.class, Object.class, Collections.emptyList(), new UnitTranscoder(), null)), null);
    }

    public LoadPathCache() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.cache = new ArrayMap();
        this.keyRef = new AtomicReference();
    }

    private MultiClassKey getKey(Class cls, Class cls2, Class cls3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, cls, cls2, cls3)) == null) {
            MultiClassKey multiClassKey = (MultiClassKey) this.keyRef.getAndSet(null);
            if (multiClassKey == null) {
                multiClassKey = new MultiClassKey();
            }
            multiClassKey.set(cls, cls2, cls3);
            return multiClassKey;
        }
        return (MultiClassKey) invokeLLL.objValue;
    }

    public LoadPath get(Class cls, Class cls2, Class cls3) {
        InterceptResult invokeLLL;
        LoadPath loadPath;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, cls, cls2, cls3)) == null) {
            MultiClassKey key = getKey(cls, cls2, cls3);
            synchronized (this.cache) {
                loadPath = (LoadPath) this.cache.get(key);
            }
            this.keyRef.set(key);
            return loadPath;
        }
        return (LoadPath) invokeLLL.objValue;
    }

    public boolean isEmptyLoadPath(LoadPath loadPath) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, loadPath)) == null) {
            return NO_PATHS_SIGNAL.equals(loadPath);
        }
        return invokeL.booleanValue;
    }

    public void put(Class cls, Class cls2, Class cls3, LoadPath loadPath) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, cls, cls2, cls3, loadPath) == null) {
            synchronized (this.cache) {
                ArrayMap arrayMap = this.cache;
                MultiClassKey multiClassKey = new MultiClassKey(cls, cls2, cls3);
                if (loadPath == null) {
                    loadPath = NO_PATHS_SIGNAL;
                }
                arrayMap.put(multiClassKey, loadPath);
            }
        }
    }
}
