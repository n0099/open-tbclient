package com.bumptech.glide.load.engine;

import androidx.annotation.VisibleForTesting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.Key;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public final class Jobs {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<Key, EngineJob<?>> jobs;
    public final Map<Key, EngineJob<?>> onlyCacheJobs;

    public Jobs() {
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
        this.jobs = new HashMap();
        this.onlyCacheJobs = new HashMap();
    }

    private Map<Key, EngineJob<?>> getJobMap(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65537, this, z)) == null) ? z ? this.onlyCacheJobs : this.jobs : (Map) invokeZ.objValue;
    }

    public EngineJob<?> get(Key key, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, key, z)) == null) ? getJobMap(z).get(key) : (EngineJob) invokeLZ.objValue;
    }

    @VisibleForTesting
    public Map<Key, EngineJob<?>> getAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Collections.unmodifiableMap(this.jobs) : (Map) invokeV.objValue;
    }

    public void put(Key key, EngineJob<?> engineJob) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, key, engineJob) == null) {
            getJobMap(engineJob.onlyRetrieveFromCache()).put(key, engineJob);
        }
    }

    public void removeIfCurrent(Key key, EngineJob<?> engineJob) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, key, engineJob) == null) {
            Map<Key, EngineJob<?>> jobMap = getJobMap(engineJob.onlyRetrieveFromCache());
            if (engineJob.equals(jobMap.get(key))) {
                jobMap.remove(key);
            }
        }
    }
}
