package com.bytedance.sdk.openadsdk.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.e.e;
import com.bytedance.sdk.component.e.g;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.j;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
/* loaded from: classes5.dex */
public abstract class b implements com.bytedance.sdk.openadsdk.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Callable<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f31001a;

        /* renamed from: b  reason: collision with root package name */
        public final File f31002b;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f31001a.b(this.f31002b);
                return null;
            }
            return (Void) invokeV.objValue;
        }

        public a(b bVar, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31001a = bVar;
            this.f31002b = file;
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private File b(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, file)) == null) {
            List<File> a2 = f.a(file);
            if (a2 == null || a2.size() <= 0) {
                return null;
            }
            for (File file2 : a2) {
                if (file2 != null && str.equals(file2.getName())) {
                    j.f("TTFullScreenVideoAdImpl", "datastoreGet .........get cache video....");
                    return file2;
                }
            }
            return null;
        }
        return (File) invokeLL.objValue;
    }

    public abstract void a(List<File> list);

    public abstract boolean a(long j, int i2);

    public abstract boolean a(File file, long j, int i2);

    @Override // com.bytedance.sdk.openadsdk.d.a
    public void a(File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) == null) {
            com.bytedance.sdk.component.e.f fVar = new com.bytedance.sdk.component.e.f(new a(file), 1, 2);
            e.a(new g(this, "touch", fVar.a(), fVar) { // from class: com.bytedance.sdk.openadsdk.d.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.component.e.f f30999a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f31000b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, Integer.valueOf(r10), fVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f31000b = this;
                    this.f30999a = fVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f30999a.run();
                    }
                }
            });
        }
    }

    public File a(String str, File file) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, file)) == null) ? b(str, file) : (File) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, file) == null) {
            try {
                f.b(file);
            } catch (Throwable th) {
                j.a("LruDiskFile", "setLastModifiedNowError", th);
            }
            List<File> a2 = f.a(file.getParentFile());
            j.f("splashLoadAd", "LruDiskFile touchInBackground files.size() " + a2.size());
            a(a2);
        }
    }

    public long b(List<File> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            long j = 0;
            for (File file : list) {
                j += file.length();
            }
            return j;
        }
        return invokeL.longValue;
    }
}
