package com.bumptech.glide.load.engine;

import android.util.Log;
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
/* loaded from: classes7.dex */
public class SourceGenerator implements DataFetcherGenerator, DataFetcherGenerator.FetcherReadyCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SourceGenerator";
    public transient /* synthetic */ FieldHolder $fh;
    public final DataFetcherGenerator.FetcherReadyCallback cb;
    public Object dataToCache;
    public final DecodeHelper helper;
    public volatile ModelLoader.LoadData loadData;
    public int loadDataListIndex;
    public DataCacheKey originalKey;
    public DataCacheGenerator sourceCacheGenerator;

    public SourceGenerator(DecodeHelper decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {decodeHelper, fetcherReadyCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.helper = decodeHelper;
        this.cb = fetcherReadyCallback;
    }

    public void onDataReadyInternal(ModelLoader.LoadData loadData, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, loadData, obj) == null) {
            DiskCacheStrategy diskCacheStrategy = this.helper.getDiskCacheStrategy();
            if (obj != null && diskCacheStrategy.isDataCacheable(loadData.fetcher.getDataSource())) {
                this.dataToCache = obj;
                this.cb.reschedule();
                return;
            }
            DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback = this.cb;
            Key key = loadData.sourceKey;
            DataFetcher dataFetcher = loadData.fetcher;
            fetcherReadyCallback.onDataFetcherReady(key, obj, dataFetcher, dataFetcher.getDataSource(), this.originalKey);
        }
    }

    private void cacheData(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, obj) == null) {
            long logTime = LogTime.getLogTime();
            try {
                Encoder sourceEncoder = this.helper.getSourceEncoder(obj);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (this.loadDataListIndex < this.helper.getLoadData().size()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        ModelLoader.LoadData loadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (loadData = this.loadData) != null) {
            loadData.fetcher.cancel();
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void reschedule() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            throw new UnsupportedOperationException();
        }
    }

    private void startNextLoad(ModelLoader.LoadData loadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, loadData) == null) {
            this.loadData.fetcher.loadData(this.helper.getPriority(), new DataFetcher.DataCallback(this, loadData) { // from class: com.bumptech.glide.load.engine.SourceGenerator.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SourceGenerator this$0;
                public final /* synthetic */ ModelLoader.LoadData val$toStart;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, loadData};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$toStart = loadData;
                }

                @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
                public void onDataReady(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) && this.this$0.isCurrentRequest(this.val$toStart)) {
                        this.this$0.onDataReadyInternal(this.val$toStart, obj);
                    }
                }

                @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
                public void onLoadFailed(Exception exc) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) && this.this$0.isCurrentRequest(this.val$toStart)) {
                        this.this$0.onLoadFailedInternal(this.val$toStart, exc);
                    }
                }
            });
        }
    }

    public boolean isCurrentRequest(ModelLoader.LoadData loadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, loadData)) == null) {
            ModelLoader.LoadData loadData2 = this.loadData;
            if (loadData2 != null && loadData2 == loadData) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherFailed(Key key, Exception exc, DataFetcher dataFetcher, DataSource dataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, key, exc, dataFetcher, dataSource) == null) {
            this.cb.onDataFetcherFailed(key, exc, dataFetcher, this.loadData.fetcher.getDataSource());
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherReady(Key key, Object obj, DataFetcher dataFetcher, DataSource dataSource, Key key2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, key, obj, dataFetcher, dataSource, key2) == null) {
            this.cb.onDataFetcherReady(key, obj, dataFetcher, this.loadData.fetcher.getDataSource(), key);
        }
    }

    public void onLoadFailedInternal(ModelLoader.LoadData loadData, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, loadData, exc) == null) {
            DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback = this.cb;
            DataCacheKey dataCacheKey = this.originalKey;
            DataFetcher dataFetcher = loadData.fetcher;
            fetcherReadyCallback.onDataFetcherFailed(dataCacheKey, exc, dataFetcher, dataFetcher.getDataSource());
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean startNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Object obj = this.dataToCache;
            if (obj != null) {
                this.dataToCache = null;
                cacheData(obj);
            }
            DataCacheGenerator dataCacheGenerator = this.sourceCacheGenerator;
            if (dataCacheGenerator != null && dataCacheGenerator.startNext()) {
                return true;
            }
            this.sourceCacheGenerator = null;
            this.loadData = null;
            boolean z = false;
            while (!z && hasNextModelLoader()) {
                List loadData = this.helper.getLoadData();
                int i = this.loadDataListIndex;
                this.loadDataListIndex = i + 1;
                this.loadData = (ModelLoader.LoadData) loadData.get(i);
                if (this.loadData != null && (this.helper.getDiskCacheStrategy().isDataCacheable(this.loadData.fetcher.getDataSource()) || this.helper.hasLoadPath(this.loadData.fetcher.getDataClass()))) {
                    startNextLoad(this.loadData);
                    z = true;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }
}
