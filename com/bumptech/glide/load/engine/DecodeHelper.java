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
/* loaded from: classes11.dex */
public final class DecodeHelper<Transcode> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<Key> cacheKeys;
    public DecodeJob.DiskCacheProvider diskCacheProvider;
    public DiskCacheStrategy diskCacheStrategy;
    public GlideContext glideContext;
    public int height;
    public boolean isCacheKeysSet;
    public boolean isLoadDataSet;
    public boolean isScaleOnlyOrNoTransform;
    public boolean isTransformationRequired;
    public final List<ModelLoader.LoadData<?>> loadData;
    public Object model;
    public Options options;
    public Priority priority;
    public Class<?> resourceClass;
    public Key signature;
    public Class<Transcode> transcodeClass;
    public Map<Class<?>, Transformation<?>> transformations;
    public int width;

    public DecodeHelper() {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.glideContext.getArrayPool() : (ArrayPool) invokeV.objValue;
    }

    public List<Key> getCacheKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!this.isCacheKeysSet) {
                this.isCacheKeysSet = true;
                this.cacheKeys.clear();
                List<ModelLoader.LoadData<?>> loadData = getLoadData();
                int size = loadData.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ModelLoader.LoadData<?> loadData2 = loadData.get(i2);
                    if (!this.cacheKeys.contains(loadData2.sourceKey)) {
                        this.cacheKeys.add(loadData2.sourceKey);
                    }
                    for (int i3 = 0; i3 < loadData2.alternateKeys.size(); i3++) {
                        if (!this.cacheKeys.contains(loadData2.alternateKeys.get(i3))) {
                            this.cacheKeys.add(loadData2.alternateKeys.get(i3));
                        }
                    }
                }
            }
            return this.cacheKeys;
        }
        return (List) invokeV.objValue;
    }

    public DiskCache getDiskCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.diskCacheProvider.getDiskCache() : (DiskCache) invokeV.objValue;
    }

    public DiskCacheStrategy getDiskCacheStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.diskCacheStrategy : (DiskCacheStrategy) invokeV.objValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.height : invokeV.intValue;
    }

    public List<ModelLoader.LoadData<?>> getLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!this.isLoadDataSet) {
                this.isLoadDataSet = true;
                this.loadData.clear();
                List modelLoaders = this.glideContext.getRegistry().getModelLoaders(this.model);
                int size = modelLoaders.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ModelLoader.LoadData<?> buildLoadData = ((ModelLoader) modelLoaders.get(i2)).buildLoadData(this.model, this.width, this.height, this.options);
                    if (buildLoadData != null) {
                        this.loadData.add(buildLoadData);
                    }
                }
            }
            return this.loadData;
        }
        return (List) invokeV.objValue;
    }

    public <Data> LoadPath<Data, ?, Transcode> getLoadPath(Class<Data> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cls)) == null) ? this.glideContext.getRegistry().getLoadPath(cls, this.resourceClass, this.transcodeClass) : (LoadPath) invokeL.objValue;
    }

    public Class<?> getModelClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.model.getClass() : (Class) invokeV.objValue;
    }

    public List<ModelLoader<File, ?>> getModelLoaders(File file) throws Registry.NoModelLoaderAvailableException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, file)) == null) ? this.glideContext.getRegistry().getModelLoaders(file) : (List) invokeL.objValue;
    }

    public Options getOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.options : (Options) invokeV.objValue;
    }

    public Priority getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.priority : (Priority) invokeV.objValue;
    }

    public List<Class<?>> getRegisteredResourceClasses() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.glideContext.getRegistry().getRegisteredResourceClasses(this.model.getClass(), this.resourceClass, this.transcodeClass) : (List) invokeV.objValue;
    }

    public <Z> ResourceEncoder<Z> getResultEncoder(Resource<Z> resource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, resource)) == null) ? this.glideContext.getRegistry().getResultEncoder(resource) : (ResourceEncoder) invokeL.objValue;
    }

    public Key getSignature() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.signature : (Key) invokeV.objValue;
    }

    public <X> Encoder<X> getSourceEncoder(X x) throws Registry.NoSourceEncoderAvailableException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, x)) == null) ? this.glideContext.getRegistry().getSourceEncoder(x) : (Encoder) invokeL.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: java.lang.Class<Transcode>, java.lang.Class<?> */
    public Class<?> getTranscodeClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? (Class<Transcode>) this.transcodeClass : (Class) invokeV.objValue;
    }

    public <Z> Transformation<Z> getTransformation(Class<Z> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, cls)) == null) {
            Transformation<Z> transformation = (Transformation<Z>) this.transformations.get(cls);
            if (transformation == null) {
                Iterator<Map.Entry<Class<?>, Transformation<?>>> it = this.transformations.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<Class<?>, Transformation<?>> next = it.next();
                    if (next.getKey().isAssignableFrom(cls)) {
                        transformation = (Transformation<Z>) next.getValue();
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

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.width : invokeV.intValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Class<?> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean hasLoadPath(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, cls)) == null) ? getLoadPath(cls) != null : invokeL.booleanValue;
    }

    public <R> void init(GlideContext glideContext, Object obj, Key key, int i2, int i3, DiskCacheStrategy diskCacheStrategy, Class<?> cls, Class<R> cls2, Priority priority, Options options, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, DecodeJob.DiskCacheProvider diskCacheProvider) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{glideContext, obj, key, Integer.valueOf(i2), Integer.valueOf(i3), diskCacheStrategy, cls, cls2, priority, options, map, Boolean.valueOf(z), Boolean.valueOf(z2), diskCacheProvider}) == null) {
            this.glideContext = glideContext;
            this.model = obj;
            this.signature = key;
            this.width = i2;
            this.height = i3;
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

    public boolean isResourceEncoderAvailable(Resource<?> resource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, resource)) == null) ? this.glideContext.getRegistry().isResourceEncoderAvailable(resource) : invokeL.booleanValue;
    }

    public boolean isScaleOnlyOrNoTransform() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.isScaleOnlyOrNoTransform : invokeV.booleanValue;
    }

    public boolean isSourceKey(Key key) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, key)) == null) {
            List<ModelLoader.LoadData<?>> loadData = getLoadData();
            int size = loadData.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (loadData.get(i2).sourceKey.equals(key)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
