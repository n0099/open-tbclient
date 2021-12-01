package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;
/* loaded from: classes12.dex */
public class DataCacheGenerator implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public File cacheFile;
    public final List<Key> cacheKeys;
    public final DataFetcherGenerator.FetcherReadyCallback cb;
    public final DecodeHelper<?> helper;
    public volatile ModelLoader.LoadData<?> loadData;
    public int modelLoaderIndex;
    public List<ModelLoader<File, ?>> modelLoaders;
    public int sourceIdIndex;
    public Key sourceKey;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataCacheGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this(decodeHelper.getCacheKeys(), decodeHelper, fetcherReadyCallback);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {decodeHelper, fetcherReadyCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((List) objArr2[0], (DecodeHelper) objArr2[1], (DataFetcherGenerator.FetcherReadyCallback) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private boolean hasNextModelLoader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.modelLoaderIndex < this.modelLoaders.size() : invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        ModelLoader.LoadData<?> loadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (loadData = this.loadData) == null) {
            return;
        }
        loadData.fetcher.cancel();
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onDataReady(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            this.cb.onDataFetcherReady(this.sourceKey, obj, this.loadData.fetcher, DataSource.DATA_DISK_CACHE, this.sourceKey);
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onLoadFailed(@NonNull Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            this.cb.onDataFetcherFailed(this.sourceKey, exc, this.loadData.fetcher, DataSource.DATA_DISK_CACHE);
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean startNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048579, this)) != null) {
            return invokeV.booleanValue;
        }
        while (true) {
            boolean z = false;
            if (this.modelLoaders != null && hasNextModelLoader()) {
                this.loadData = null;
                while (!z && hasNextModelLoader()) {
                    List<ModelLoader<File, ?>> list = this.modelLoaders;
                    int i2 = this.modelLoaderIndex;
                    this.modelLoaderIndex = i2 + 1;
                    this.loadData = list.get(i2).buildLoadData(this.cacheFile, this.helper.getWidth(), this.helper.getHeight(), this.helper.getOptions());
                    if (this.loadData != null && this.helper.hasLoadPath(this.loadData.fetcher.getDataClass())) {
                        this.loadData.fetcher.loadData(this.helper.getPriority(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i3 = this.sourceIdIndex + 1;
            this.sourceIdIndex = i3;
            if (i3 >= this.cacheKeys.size()) {
                return false;
            }
            Key key = this.cacheKeys.get(this.sourceIdIndex);
            File file = this.helper.getDiskCache().get(new DataCacheKey(key, this.helper.getSignature()));
            this.cacheFile = file;
            if (file != null) {
                this.sourceKey = key;
                this.modelLoaders = this.helper.getModelLoaders(file);
                this.modelLoaderIndex = 0;
            }
        }
    }

    public DataCacheGenerator(List<Key> list, DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, decodeHelper, fetcherReadyCallback};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.sourceIdIndex = -1;
        this.cacheKeys = list;
        this.helper = decodeHelper;
        this.cb = fetcherReadyCallback;
    }
}
