package com.bumptech.glide.load.model;

import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public final class DataUrlLoader implements ModelLoader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BASE64_TAG = ";base64";
    public static final String DATA_SCHEME_IMAGE = "data:image";
    public transient /* synthetic */ FieldHolder $fh;
    public final DataDecoder dataDecoder;

    /* loaded from: classes7.dex */
    public interface DataDecoder {
        void close(Object obj) throws IOException;

        Object decode(String str) throws IllegalArgumentException;

        Class getDataClass();
    }

    /* loaded from: classes7.dex */
    public final class DataUriFetcher implements DataFetcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Object data;
        public final String dataUri;
        public final DataDecoder reader;

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public DataUriFetcher(String str, DataDecoder dataDecoder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, dataDecoder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.dataUri = str;
            this.reader = dataDecoder;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    this.reader.close(this.data);
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class getDataClass() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.reader.getDataClass();
            }
            return (Class) invokeV.objValue;
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
        public void loadData(Priority priority, DataFetcher.DataCallback dataCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, priority, dataCallback) == null) {
                try {
                    Object decode = this.reader.decode(this.dataUri);
                    this.data = decode;
                    dataCallback.onDataReady(decode);
                } catch (IllegalArgumentException e) {
                    dataCallback.onLoadFailed(e);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class StreamFactory implements ModelLoaderFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final DataDecoder opener;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public StreamFactory() {
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
            this.opener = new DataDecoder(this) { // from class: com.bumptech.glide.load.model.DataUrlLoader.StreamFactory.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StreamFactory this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i3 = newInitContext2.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bumptech.glide.load.model.DataUrlLoader.DataDecoder
                public void close(InputStream inputStream) throws IOException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, inputStream) == null) {
                        inputStream.close();
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bumptech.glide.load.model.DataUrlLoader.DataDecoder
                public InputStream decode(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        if (str.startsWith(DataUrlLoader.DATA_SCHEME_IMAGE)) {
                            int indexOf = str.indexOf(44);
                            if (indexOf != -1) {
                                if (str.substring(0, indexOf).endsWith(DataUrlLoader.BASE64_TAG)) {
                                    return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                                }
                                throw new IllegalArgumentException("Not a base64 image data URL.");
                            }
                            throw new IllegalArgumentException("Missing comma in data URL.");
                        }
                        throw new IllegalArgumentException("Not a valid image data URL.");
                    }
                    return (InputStream) invokeL.objValue;
                }

                @Override // com.bumptech.glide.load.model.DataUrlLoader.DataDecoder
                public Class getDataClass() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        return InputStream.class;
                    }
                    return (Class) invokeV.objValue;
                }
            };
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, multiModelLoaderFactory)) == null) {
                return new DataUrlLoader(this.opener);
            }
            return (ModelLoader) invokeL.objValue;
        }
    }

    public DataUrlLoader(DataDecoder dataDecoder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dataDecoder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.dataDecoder = dataDecoder;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            return obj.toString().startsWith(DATA_SCHEME_IMAGE);
        }
        return invokeL.booleanValue;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData buildLoadData(Object obj, int i, int i2, Options options) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{obj, Integer.valueOf(i), Integer.valueOf(i2), options})) == null) {
            return new ModelLoader.LoadData(new ObjectKey(obj), new DataUriFetcher(obj.toString(), this.dataDecoder));
        }
        return (ModelLoader.LoadData) invokeCommon.objValue;
    }
}
