package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes7.dex */
public abstract class LocalUriFetcher implements DataFetcher {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "LocalUriFetcher";
    public transient /* synthetic */ FieldHolder $fh;
    public final ContentResolver contentResolver;
    public Object data;
    public final Uri uri;

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public abstract void close(Object obj) throws IOException;

    public abstract Object loadResource(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    public LocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {contentResolver, uri};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.contentResolver = contentResolver;
        this.uri = uri;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        Object obj;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (obj = this.data) != null) {
            try {
                close(obj);
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public DataSource getDataSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return DataSource.LOCAL;
        }
        return (DataSource) invokeV.objValue;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void loadData(Priority priority, DataFetcher.DataCallback dataCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, priority, dataCallback) == null) {
            try {
                Object loadResource = loadResource(this.uri, this.contentResolver);
                this.data = loadResource;
                dataCallback.onDataReady(loadResource);
            } catch (FileNotFoundException e) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Failed to open Uri", e);
                }
                dataCallback.onLoadFailed(e);
            }
        }
    }
}
