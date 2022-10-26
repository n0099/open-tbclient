package com.bumptech.glide.load.engine;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.UnitTransformation;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public final class DecodeHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List cacheKeys;
    public DecodeJob.DiskCacheProvider diskCacheProvider;
    public DiskCacheStrategy diskCacheStrategy;
    public GlideContext glideContext;
    public int height;
    public boolean isCacheKeysSet;
    public boolean isLoadDataSet;
    public boolean isScaleOnlyOrNoTransform;
    public boolean isTransformationRequired;
    public final List loadData;
    public Object model;
    public Options options;
    public Priority priority;
    public Class resourceClass;
    public Key signature;
    public Class transcodeClass;
    public Map transformations;
    public int width;

    public DecodeHelper() {
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
        this.loadData = new ArrayList();
        this.cacheKeys = new ArrayList();
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.glideContext = null;
            this.model = null;
            this.signature = null;
            this.resourceClass = null;
            this.transcodeClass = null;
            this.options = null;
            this.priority = null;
            this.transformations = null;
            this.diskCacheStrategy = null;
            this.loadData.clear();
            this.isLoadDataSet = false;
            this.cacheKeys.clear();
            this.isCacheKeysSet = false;
        }
    }

    public ArrayPool getArrayPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.glideContext.getArrayPool();
        }
        return (ArrayPool) invokeV.objValue;
    }

    public DiskCache getDiskCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.diskCacheProvider.getDiskCache();
        }
        return (DiskCache) invokeV.objValue;
    }

    public DiskCacheStrategy getDiskCacheStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.diskCacheStrategy;
        }
        return (DiskCacheStrategy) invokeV.objValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.height;
        }
        return invokeV.intValue;
    }

    public Class getModelClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.model.getClass();
        }
        return (Class) invokeV.objValue;
    }

    public Options getOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.options;
        }
        return (Options) invokeV.objValue;
    }

    public Priority getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.priority;
        }
        return (Priority) invokeV.objValue;
    }

    public List getRegisteredResourceClasses() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.glideContext.getRegistry().getRegisteredResourceClasses(this.model.getClass(), this.resourceClass, this.transcodeClass);
        }
        return (List) invokeV.objValue;
    }

    public Key getSignature() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.signature;
        }
        return (Key) invokeV.objValue;
    }

    public Class getTranscodeClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.transcodeClass;
        }
        return (Class) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.width;
        }
        return invokeV.intValue;
    }

    public boolean isScaleOnlyOrNoTransform() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.isScaleOnlyOrNoTransform;
        }
        return invokeV.booleanValue;
    }

    public List getCacheKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!this.isCacheKeysSet) {
                this.isCacheKeysSet = true;
                this.cacheKeys.clear();
                List loadData = getLoadData();
                int size = loadData.size();
                for (int i = 0; i < size; i++) {
                    ModelLoader.LoadData loadData2 = (ModelLoader.LoadData) loadData.get(i);
                    if (!this.cacheKeys.contains(loadData2.sourceKey)) {
                        this.cacheKeys.add(loadData2.sourceKey);
                    }
                    for (int i2 = 0; i2 < loadData2.alternateKeys.size(); i2++) {
                        if (!this.cacheKeys.contains(loadData2.alternateKeys.get(i2))) {
                            this.cacheKeys.add(loadData2.alternateKeys.get(i2));
                        }
                    }
                }
            }
            return this.cacheKeys;
        }
        return (List) invokeV.objValue;
    }

    public List getLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!this.isLoadDataSet) {
                this.isLoadDataSet = true;
                this.loadData.clear();
                List modelLoaders = this.glideContext.getRegistry().getModelLoaders(this.model);
                int size = modelLoaders.size();
                for (int i = 0; i < size; i++) {
                    ModelLoader.LoadData buildLoadData = ((ModelLoader) modelLoaders.get(i)).buildLoadData(this.model, this.width, this.height, this.options);
                    if (buildLoadData != null) {
                        this.loadData.add(buildLoadData);
                    }
                }
            }
            return this.loadData;
        }
        return (List) invokeV.objValue;
    }

    public LoadPath getLoadPath(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cls)) == null) {
            return this.glideContext.getRegistry().getLoadPath(cls, this.resourceClass, this.transcodeClass);
        }
        return (LoadPath) invokeL.objValue;
    }

    public List getModelLoaders(File file) throws Registry.NoModelLoaderAvailableException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, file)) == null) {
            return this.glideContext.getRegistry().getModelLoaders(file);
        }
        return (List) invokeL.objValue;
    }

    public ResourceEncoder getResultEncoder(Resource resource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, resource)) == null) {
            return this.glideContext.getRegistry().getResultEncoder(resource);
        }
        return (ResourceEncoder) invokeL.objValue;
    }

    public Encoder getSourceEncoder(Object obj) throws Registry.NoSourceEncoderAvailableException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) {
            return this.glideContext.getRegistry().getSourceEncoder(obj);
        }
        return (Encoder) invokeL.objValue;
    }

    public boolean hasLoadPath(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, cls)) == null) {
            if (getLoadPath(cls) != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean isResourceEncoderAvailable(Resource resource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, resource)) == null) {
            return this.glideContext.getRegistry().isResourceEncoderAvailable(resource);
        }
        return invokeL.booleanValue;
    }

    public boolean isSourceKey(Key key) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, key)) == null) {
            List loadData = getLoadData();
            int size = loadData.size();
            for (int i = 0; i < size; i++) {
                if (((ModelLoader.LoadData) loadData.get(i)).sourceKey.equals(key)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Transformation getTransformation(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, cls)) == null) {
            Transformation transformation = (Transformation) this.transformations.get(cls);
            if (transformation == null) {
                Iterator it = this.transformations.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                        transformation = (Transformation) entry.getValue();
                        break;
                    }
                }
            }
            if (transformation == null) {
                if (this.transformations.isEmpty() && this.isTransformationRequired) {
                    throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
                }
                return UnitTransformation.get();
            }
            return transformation;
        }
        return (Transformation) invokeL.objValue;
    }

    public void init(GlideContext glideContext, Object obj, Key key, int i, int i2, DiskCacheStrategy diskCacheStrategy, Class cls, Class cls2, Priority priority, Options options, Map map, boolean z, boolean z2, DecodeJob.DiskCacheProvider diskCacheProvider) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{glideContext, obj, key, Integer.valueOf(i), Integer.valueOf(i2), diskCacheStrategy, cls, cls2, priority, options, map, Boolean.valueOf(z), Boolean.valueOf(z2), diskCacheProvider}) == null) {
            this.glideContext = glideContext;
            this.model = obj;
            this.signature = key;
            this.width = i;
            this.height = i2;
            this.diskCacheStrategy = diskCacheStrategy;
            this.resourceClass = cls;
            this.diskCacheProvider = diskCacheProvider;
            this.transcodeClass = cls2;
            this.priority = priority;
            this.options = options;
            this.transformations = map;
            this.isTransformationRequired = z;
            this.isScaleOnlyOrNoTransform = z2;
        }
    }
}
