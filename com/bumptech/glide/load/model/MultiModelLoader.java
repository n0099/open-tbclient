package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes7.dex */
public class MultiModelLoader implements ModelLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Pools.Pool exceptionListPool;
    public final List modelLoaders;

    /* loaded from: classes7.dex */
    public class MultiFetcher implements DataFetcher, DataFetcher.DataCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public DataFetcher.DataCallback callback;
        public int currentIndex;
        public List exceptions;
        public final List fetchers;
        public boolean isCancelled;
        public Priority priority;
        public final Pools.Pool throwableListPool;

        public MultiFetcher(List list, Pools.Pool pool) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list, pool};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.throwableListPool = pool;
            Preconditions.checkNotEmpty(list);
            this.fetchers = list;
            this.currentIndex = 0;
        }

        private void startNextOrFail() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(65537, this) != null) || this.isCancelled) {
                return;
            }
            if (this.currentIndex < this.fetchers.size() - 1) {
                this.currentIndex++;
                loadData(this.priority, this.callback);
                return;
            }
            Preconditions.checkNotNull(this.exceptions);
            this.callback.onLoadFailed(new GlideException("Fetch failed", new ArrayList(this.exceptions)));
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.isCancelled = true;
                for (DataFetcher dataFetcher : this.fetchers) {
                    dataFetcher.cancel();
                }
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                List list = this.exceptions;
                if (list != null) {
                    this.throwableListPool.release(list);
                }
                this.exceptions = null;
                for (DataFetcher dataFetcher : this.fetchers) {
                    dataFetcher.cleanup();
                }
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class getDataClass() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return ((DataFetcher) this.fetchers.get(0)).getDataClass();
            }
            return (Class) invokeV.objValue;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return ((DataFetcher) this.fetchers.get(0)).getDataSource();
            }
            return (DataSource) invokeV.objValue;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority priority, DataFetcher.DataCallback dataCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, priority, dataCallback) == null) {
                this.priority = priority;
                this.callback = dataCallback;
                this.exceptions = (List) this.throwableListPool.acquire();
                ((DataFetcher) this.fetchers.get(this.currentIndex)).loadData(priority, this);
                if (this.isCancelled) {
                    cancel();
                }
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public void onDataReady(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, obj) == null) {
                if (obj != null) {
                    this.callback.onDataReady(obj);
                } else {
                    startNextOrFail();
                }
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public void onLoadFailed(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, exc) == null) {
                ((List) Preconditions.checkNotNull(this.exceptions)).add(exc);
                startNextOrFail();
            }
        }
    }

    public MultiModelLoader(List list, Pools.Pool pool) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, pool};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.modelLoaders = list;
        this.exceptionListPool = pool;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData buildLoadData(Object obj, int i, int i2, Options options) {
        InterceptResult invokeCommon;
        ModelLoader.LoadData buildLoadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{obj, Integer.valueOf(i), Integer.valueOf(i2), options})) == null) {
            int size = this.modelLoaders.size();
            ArrayList arrayList = new ArrayList(size);
            Key key = null;
            for (int i3 = 0; i3 < size; i3++) {
                ModelLoader modelLoader = (ModelLoader) this.modelLoaders.get(i3);
                if (modelLoader.handles(obj) && (buildLoadData = modelLoader.buildLoadData(obj, i, i2, options)) != null) {
                    key = buildLoadData.sourceKey;
                    arrayList.add(buildLoadData.fetcher);
                }
            }
            if (arrayList.isEmpty() || key == null) {
                return null;
            }
            return new ModelLoader.LoadData(key, new MultiFetcher(arrayList, this.exceptionListPool));
        }
        return (ModelLoader.LoadData) invokeCommon.objValue;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            for (ModelLoader modelLoader : this.modelLoaders) {
                if (modelLoader.handles(obj)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.modelLoaders.toArray()) + '}';
        }
        return (String) invokeV.objValue;
    }
}
