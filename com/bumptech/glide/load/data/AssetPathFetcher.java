package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.IOException;
/* loaded from: classes11.dex */
public abstract class AssetPathFetcher<T> implements DataFetcher<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AssetPathFetcher";
    public transient /* synthetic */ FieldHolder $fh;
    public final AssetManager assetManager;
    public final String assetPath;
    public T data;

    public AssetPathFetcher(AssetManager assetManager, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {assetManager, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.assetManager = assetManager;
        this.assetPath = str;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (t = this.data) == null) {
            return;
        }
        try {
            close(t);
        } catch (IOException unused) {
        }
    }

    public abstract void close(T t) throws IOException;

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource getDataSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? DataSource.LOCAL : (DataSource) invokeV.objValue;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super T> dataCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, priority, dataCallback) == null) {
            try {
                T loadResource = loadResource(this.assetManager, this.assetPath);
                this.data = loadResource;
                dataCallback.onDataReady(loadResource);
            } catch (IOException e2) {
                Log.isLoggable(TAG, 3);
                dataCallback.onLoadFailed(e2);
            }
        }
    }

    public abstract T loadResource(AssetManager assetManager, String str) throws IOException;
}
