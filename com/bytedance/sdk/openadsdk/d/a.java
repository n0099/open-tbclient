package com.bytedance.sdk.openadsdk.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.d.e;
import com.bytedance.sdk.component.d.g;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.k;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
/* loaded from: classes5.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.bytedance.sdk.openadsdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class CallableC0350a implements Callable<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31185a;

        /* renamed from: b  reason: collision with root package name */
        public final File f31186b;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f31185a.b(this.f31186b);
                return null;
            }
            return (Void) invokeV.objValue;
        }

        public CallableC0350a(a aVar, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31185a = aVar;
            this.f31186b = file;
        }
    }

    public a() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b(File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, file) == null) {
            try {
                f.b(file);
            } catch (Throwable th) {
                k.a("LruDiskFile", "setLastModifiedNowError", th);
            }
            List<File> a2 = f.a(file.getParentFile());
            k.f("splashLoadAd", "LruDiskFile touchInBackground files.size() " + a2.size());
            a(a2);
        }
    }

    public abstract void a(List<File> list);

    public abstract boolean a(long j, int i2);

    public abstract boolean a(File file, long j, int i2);

    public void a(File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
            com.bytedance.sdk.component.d.f fVar = new com.bytedance.sdk.component.d.f(new CallableC0350a(file), 1, 2);
            e.a(new g(this, "touch", fVar.a(), fVar) { // from class: com.bytedance.sdk.openadsdk.d.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.component.d.f f31183a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f31184b;

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
                    this.f31184b = this;
                    this.f31183a = fVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f31183a.run();
                    }
                }
            });
        }
    }

    public long b(List<File> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            long j = 0;
            for (File file : list) {
                j += file.length();
            }
            return j;
        }
        return invokeL.longValue;
    }
}
