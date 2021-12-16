package com.bumptech.glide.load.model;

import android.util.Base64;
import androidx.annotation.NonNull;
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
/* loaded from: classes2.dex */
public final class DataUrlLoader<Model, Data> implements ModelLoader<Model, Data> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BASE64_TAG = ";base64";
    public static final String DATA_SCHEME_IMAGE = "data:image";
    public transient /* synthetic */ FieldHolder $fh;
    public final DataDecoder<Data> dataDecoder;

    /* loaded from: classes2.dex */
    public interface DataDecoder<Data> {
        void close(Data data) throws IOException;

        Data decode(String str) throws IllegalArgumentException;

        Class<Data> getDataClass();
    }

    /* loaded from: classes2.dex */
    public static final class DataUriFetcher<Data> implements DataFetcher<Data> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Data data;
        public final String dataUri;
        public final DataDecoder<Data> reader;

        public DataUriFetcher(String str, DataDecoder<Data> dataDecoder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, dataDecoder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.dataUri = str;
            this.reader = dataDecoder;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
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
        @NonNull
        public Class<Data> getDataClass() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.reader.getDataClass() : (Class) invokeV.objValue;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public DataSource getDataSource() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? DataSource.LOCAL : (DataSource) invokeV.objValue;
        }

        /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object, Data] */
        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super Data> dataCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, priority, dataCallback) == null) {
                try {
                    Data decode = this.reader.decode(this.dataUri);
                    this.data = decode;
                    dataCallback.onDataReady(decode);
                } catch (IllegalArgumentException e2) {
                    dataCallback.onLoadFailed(e2);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class StreamFactory<Model> implements ModelLoaderFactory<Model, InputStream> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final DataDecoder<InputStream> opener;

        public StreamFactory() {
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
            this.opener = new DataDecoder<InputStream>(this) { // from class: com.bumptech.glide.load.model.DataUrlLoader.StreamFactory.1
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
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.bumptech.glide.load.model.DataUrlLoader.DataDecoder
                public Class<InputStream> getDataClass() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) ? InputStream.class : (Class) invokeV.objValue;
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
                /* JADX WARN: Can't rename method to resolve collision */
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
            };
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<Model, InputStream> build(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, multiModelLoaderFactory)) == null) ? new DataUrlLoader(this.opener) : (ModelLoader) invokeL.objValue;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    public DataUrlLoader(DataDecoder<Data> dataDecoder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dataDecoder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.dataDecoder = dataDecoder;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> buildLoadData(@NonNull Model model, int i2, int i3, @NonNull Options options) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{model, Integer.valueOf(i2), Integer.valueOf(i3), options})) == null) ? new ModelLoader.LoadData<>(new ObjectKey(model), new DataUriFetcher(model.toString(), this.dataDecoder)) : (ModelLoader.LoadData) invokeCommon.objValue;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@NonNull Model model) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, model)) == null) ? model.toString().startsWith(DATA_SCHEME_IMAGE) : invokeL.booleanValue;
    }
}
