package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.LogTime;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class SourceGenerator implements DataFetcherGenerator, DataFetcher.DataCallback<Object>, DataFetcherGenerator.FetcherReadyCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SourceGenerator";
    public transient /* synthetic */ FieldHolder $fh;
    public final DataFetcherGenerator.FetcherReadyCallback cb;
    public Object dataToCache;
    public final DecodeHelper<?> helper;
    public volatile ModelLoader.LoadData<?> loadData;
    public int loadDataListIndex;
    public DataCacheKey originalKey;
    public DataCacheGenerator sourceCacheGenerator;

    public SourceGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {decodeHelper, fetcherReadyCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.helper = decodeHelper;
        this.cb = fetcherReadyCallback;
    }

    private void cacheData(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, obj) == null) {
            long logTime = LogTime.getLogTime();
            try {
                Encoder<X> sourceEncoder = this.helper.getSourceEncoder(obj);
                DataCacheWriter dataCacheWriter = new DataCacheWriter(sourceEncoder, obj, this.helper.getOptions());
                this.originalKey = new DataCacheKey(this.loadData.sourceKey, this.helper.getSignature());
                this.helper.getDiskCache().put(this.originalKey, dataCacheWriter);
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "Finished encoding source to cache, key: " + this.originalKey + ", data: " + obj + ", encoder: " + sourceEncoder + ", duration: " + LogTime.getElapsedMillis(logTime));
                }
                this.loadData.fetcher.cleanup();
                this.sourceCacheGenerator = new DataCacheGenerator(Collections.singletonList(this.loadData.sourceKey), this.helper, this);
            } catch (Throwable th) {
                this.loadData.fetcher.cleanup();
                throw th;
            }
        }
    }

    private boolean hasNextModelLoader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.loadDataListIndex < this.helper.getLoadData().size() : invokeV.booleanValue;
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

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherFailed(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, key, exc, dataFetcher, dataSource) == null) {
            this.cb.onDataFetcherFailed(key, exc, dataFetcher, this.loadData.fetcher.getDataSource());
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherReady(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, key, obj, dataFetcher, dataSource, key2) == null) {
            this.cb.onDataFetcherReady(key, obj, dataFetcher, this.loadData.fetcher.getDataSource(), key);
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onDataReady(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
            DiskCacheStrategy diskCacheStrategy = this.helper.getDiskCacheStrategy();
            if (obj != null && diskCacheStrategy.isDataCacheable(this.loadData.fetcher.getDataSource())) {
                this.dataToCache = obj;
                this.cb.reschedule();
                return;
            }
            this.cb.onDataFetcherReady(this.loadData.sourceKey, obj, this.loadData.fetcher, this.loadData.fetcher.getDataSource(), this.originalKey);
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onLoadFailed(@NonNull Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, exc) == null) {
            this.cb.onDataFetcherFailed(this.originalKey, exc, this.loadData.fetcher, this.loadData.fetcher.getDataSource());
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void reschedule() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean startNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Object obj = this.dataToCache;
            if (obj != null) {
                this.dataToCache = null;
                cacheData(obj);
            }
            DataCacheGenerator dataCacheGenerator = this.sourceCacheGenerator;
            if (dataCacheGenerator == null || !dataCacheGenerator.startNext()) {
                this.sourceCacheGenerator = null;
                this.loadData = null;
                boolean z = false;
                while (!z && hasNextModelLoader()) {
                    List<ModelLoader.LoadData<?>> loadData = this.helper.getLoadData();
                    int i2 = this.loadDataListIndex;
                    this.loadDataListIndex = i2 + 1;
                    this.loadData = loadData.get(i2);
                    if (this.loadData != null && (this.helper.getDiskCacheStrategy().isDataCacheable(this.loadData.fetcher.getDataSource()) || this.helper.hasLoadPath(this.loadData.fetcher.getDataClass()))) {
                        this.loadData.fetcher.loadData(this.helper.getPriority(), this);
                        z = true;
                    }
                }
                return z;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
