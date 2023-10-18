package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.transmit.transmitter.exception.ExceptionMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallbacks;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes9.dex */
public class z92 implements s92, y92 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public aa2 b;

    @Override // com.baidu.tieba.s92
    public boolean isClosed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes9.dex */
    public class a implements ca2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t92 a;

        @Override // com.baidu.tieba.ca2
        public void a(ImageRequest imageRequest) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, imageRequest) == null) {
            }
        }

        public a(z92 z92Var, t92 t92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z92Var, t92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t92Var;
        }

        @Override // com.baidu.tieba.ca2
        public void b(ImageRequest imageRequest) {
            t92 t92Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageRequest) == null) && (t92Var = this.a) != null) {
                t92Var.onFinished();
            }
        }

        @Override // com.baidu.tieba.ca2
        public void onCancel(String str) {
            t92 t92Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (t92Var = this.a) != null) {
                t92Var.onFinished();
            }
        }

        @Override // com.baidu.tieba.ca2
        public void c(ImageRequest imageRequest, Throwable th) {
            t92 t92Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, imageRequest, th) == null) && (t92Var = this.a) != null) {
                t92Var.onFinished();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements aa2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(z92 z92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.aa2
        public CacheKey a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return DefaultCacheKeyFactory.getInstance().getEncodedCacheKey(ImageRequest.fromUri(Uri.parse(str)), null);
            }
            return (CacheKey) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static z92 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-275323721, "Lcom/baidu/tieba/z92$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-275323721, "Lcom/baidu/tieba/z92$c;");
                    return;
                }
            }
            a = new z92(null);
        }
    }

    public z92() {
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
        this.b = new b(this);
    }

    public static z92 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return c.a;
        }
        return (z92) invokeV.objValue;
    }

    public /* synthetic */ z92(a aVar) {
        this();
    }

    @Override // com.baidu.tieba.s92
    public void a(String str, File file, t92 t92Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048576, this, str, file, t92Var) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = false;
        if (file != null && file.exists()) {
            z = b(str, file);
        }
        if (z) {
            t92Var.onFinished();
        } else {
            e(str, new a(this, t92Var));
        }
    }

    public final boolean b(String str, File file) {
        InterceptResult invokeLL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, file)) == null) {
            CacheKey a2 = this.b.a(str);
            boolean z = false;
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                BinaryResource insert = Fresco.getImagePipelineFactory().getMainFileCache().insert(a2, WriterCallbacks.from(fileInputStream));
                if (insert != null) {
                    if (insert.size() > 0) {
                        z = true;
                    }
                }
                sl4.d(fileInputStream);
                return z;
            } catch (IOException e2) {
                e = e2;
                fileInputStream2 = fileInputStream;
                if (y92.a) {
                    Log.e("HybridIntercept", Log.getStackTraceString(e));
                }
                sl4.d(fileInputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                sl4.d(fileInputStream2);
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }

    public final DataSource<Void> e(String str, ca2 ca2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, ca2Var)) == null) {
            if (!TextUtils.isEmpty(str)) {
                ImagePipeline imagePipeline = Fresco.getImagePipeline();
                ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.parse(str));
                if (ca2Var != null) {
                    newBuilderWithSource.setRequestListener(wo2.B().a(ca2Var));
                }
                return imagePipeline.prefetchToDiskCache(newBuilderWithSource.build(), null);
            }
            if (ca2Var != null) {
                ca2Var.c(null, new Exception(ExceptionMessage.URL_EMPTY));
            }
            return null;
        }
        return (DataSource) invokeLL.objValue;
    }

    public final File c(String str) {
        InterceptResult invokeL;
        BinaryResource resource;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            CacheKey a2 = this.b.a(str);
            if (a2 == null) {
                return null;
            }
            if (ImagePipelineFactory.getInstance().getMainFileCache().hasKey(a2)) {
                BinaryResource resource2 = ImagePipelineFactory.getInstance().getMainFileCache().getResource(a2);
                if (resource2 == null) {
                    return null;
                }
                return ((FileBinaryResource) resource2).getFile();
            } else if (!ImagePipelineFactory.getInstance().getSmallImageFileCache().hasKey(a2) || (resource = ImagePipelineFactory.getInstance().getSmallImageFileCache().getResource(a2)) == null) {
                return null;
            } else {
                return ((FileBinaryResource) resource).getFile();
            }
        }
        return (File) invokeL.objValue;
    }

    @Override // com.baidu.tieba.s92
    public InputStream get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            File c2 = c(str);
            if (c2 != null && c2.exists()) {
                try {
                    return new FileInputStream(c2);
                } catch (IOException e) {
                    if (y92.a) {
                        Log.e("HybridIntercept", Log.getStackTraceString(e));
                        return null;
                    }
                    return null;
                }
            }
            return null;
        }
        return (InputStream) invokeL.objValue;
    }
}
