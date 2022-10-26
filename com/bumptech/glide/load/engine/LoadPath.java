package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes7.dex */
public class LoadPath {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Class dataClass;
    public final List decodePaths;
    public final String failureMessage;
    public final Pools.Pool listPool;

    public LoadPath(Class cls, Class cls2, Class cls3, List list, Pools.Pool pool) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, cls2, cls3, list, pool};
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
        this.listPool = pool;
        this.decodePaths = (List) Preconditions.checkNotEmpty(list);
        this.failureMessage = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private Resource loadWithExceptionList(DataRewinder dataRewinder, Options options, int i, int i2, DecodePath.DecodeCallback decodeCallback, List list) throws GlideException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{dataRewinder, options, Integer.valueOf(i), Integer.valueOf(i2), decodeCallback, list})) == null) {
            int size = this.decodePaths.size();
            Resource resource = null;
            for (int i3 = 0; i3 < size; i3++) {
                try {
                    resource = ((DecodePath) this.decodePaths.get(i3)).decode(dataRewinder, i, i2, options, decodeCallback);
                } catch (GlideException e) {
                    list.add(e);
                }
                if (resource != null) {
                    break;
                }
            }
            if (resource != null) {
                return resource;
            }
            throw new GlideException(this.failureMessage, new ArrayList(list));
        }
        return (Resource) invokeCommon.objValue;
    }

    public Class getDataClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.dataClass;
        }
        return (Class) invokeV.objValue;
    }

    public Resource load(DataRewinder dataRewinder, Options options, int i, int i2, DecodePath.DecodeCallback decodeCallback) throws GlideException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{dataRewinder, options, Integer.valueOf(i), Integer.valueOf(i2), decodeCallback})) == null) {
            List list = (List) Preconditions.checkNotNull(this.listPool.acquire());
            try {
                return loadWithExceptionList(dataRewinder, options, i, i2, decodeCallback, list);
            } finally {
                this.listPool.release(list);
            }
        }
        return (Resource) invokeCommon.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "LoadPath{decodePaths=" + Arrays.toString(this.decodePaths.toArray()) + '}';
        }
        return (String) invokeV.objValue;
    }
}
