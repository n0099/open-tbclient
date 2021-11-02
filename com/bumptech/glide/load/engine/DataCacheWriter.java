package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;
/* loaded from: classes11.dex */
public class DataCacheWriter<DataType> implements DiskCache.Writer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final DataType data;
    public final Encoder<DataType> encoder;
    public final Options options;

    public DataCacheWriter(Encoder<DataType> encoder, DataType datatype, Options options) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {encoder, datatype, options};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.encoder = encoder;
        this.data = datatype;
        this.options = options;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache.Writer
    public boolean write(@NonNull File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) ? this.encoder.encode(this.data, file, this.options) : invokeL.booleanValue;
    }
}
