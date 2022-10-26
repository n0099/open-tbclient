package com.bumptech.glide.load.model;

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
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class ByteArrayLoader implements ModelLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Converter converter;

    /* loaded from: classes7.dex */
    public interface Converter {
        Object convert(byte[] bArr);

        Class getDataClass();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bArr)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class ByteBufferFactory implements ModelLoaderFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public ByteBufferFactory() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, multiModelLoaderFactory)) == null) {
                return new ByteArrayLoader(new Converter(this) { // from class: com.bumptech.glide.load.model.ByteArrayLoader.ByteBufferFactory.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ByteBufferFactory this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
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
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
                    public ByteBuffer convert(byte[] bArr) {
                        InterceptResult invokeL2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) {
                            return ByteBuffer.wrap(bArr);
                        }
                        return (ByteBuffer) invokeL2.objValue;
                    }

                    @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
                    public Class getDataClass() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                            return ByteBuffer.class;
                        }
                        return (Class) invokeV.objValue;
                    }
                });
            }
            return (ModelLoader) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class Fetcher implements DataFetcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Converter converter;
        public final byte[] model;

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
            }
        }

        public Fetcher(byte[] bArr, Converter converter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bArr, converter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.model = bArr;
            this.converter = converter;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class getDataClass() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.converter.getDataClass();
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
                dataCallback.onDataReady(this.converter.convert(this.model));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class StreamFactory implements ModelLoaderFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, multiModelLoaderFactory)) == null) {
                return new ByteArrayLoader(new Converter(this) { // from class: com.bumptech.glide.load.model.ByteArrayLoader.StreamFactory.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ StreamFactory this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
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
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
                    public InputStream convert(byte[] bArr) {
                        InterceptResult invokeL2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, bArr)) == null) {
                            return new ByteArrayInputStream(bArr);
                        }
                        return (InputStream) invokeL2.objValue;
                    }

                    @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
                    public Class getDataClass() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                            return InputStream.class;
                        }
                        return (Class) invokeV.objValue;
                    }
                });
            }
            return (ModelLoader) invokeL.objValue;
        }
    }

    public ByteArrayLoader(Converter converter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {converter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.converter = converter;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData buildLoadData(byte[] bArr, int i, int i2, Options options) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), options})) == null) {
            return new ModelLoader.LoadData(new ObjectKey(bArr), new Fetcher(bArr, this.converter));
        }
        return (ModelLoader.LoadData) invokeCommon.objValue;
    }
}
