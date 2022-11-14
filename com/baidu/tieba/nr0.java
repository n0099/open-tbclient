package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
/* loaded from: classes5.dex */
public final class nr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface b {
        void a(String str, int i);

        void b();
    }

    /* loaded from: classes5.dex */
    public static class a implements cr0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;
        public final /* synthetic */ b b;

        public a(File file, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = file;
            this.b = bVar;
        }

        @Override // com.baidu.tieba.cr0
        public void a(Exception exc, int i) {
            b bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) && (bVar = this.b) != null) {
                bVar.a(exc.getMessage(), i);
            }
        }

        @Override // com.baidu.tieba.cr0
        public void c(Headers headers, InputStream inputStream, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, headers, inputStream, i) == null) {
                if (i == 200) {
                    try {
                        nr0.b(inputStream, this.a);
                        if (this.b != null) {
                            this.b.b();
                            return;
                        }
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                        b bVar = this.b;
                        if (bVar != null) {
                            bVar.a(e.getMessage(), -1);
                            return;
                        }
                        return;
                    }
                }
                b bVar2 = this.b;
                if (bVar2 != null) {
                    bVar2.a("", i);
                }
            }
        }
    }

    public static void a(@NonNull File file, @NonNull String str, @Nullable b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, file, str, bVar) == null) {
            wq0 a2 = sq0.b().a();
            lr0 lr0Var = new lr0();
            lr0Var.l(str);
            lr0Var.c();
            a2.b(lr0Var, new a(file, bVar));
        }
    }

    public static void b(@NonNull InputStream inputStream, @NonNull File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, inputStream, file) == null) {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ReadableByteChannel newChannel = Channels.newChannel(inputStream);
            FileChannel channel = fileOutputStream.getChannel();
            long j = 4096;
            long j2 = 0;
            while (j > 0) {
                try {
                    j = channel.transferFrom(newChannel, j2, 4096L);
                    j2 += j;
                } finally {
                    dj0.a(fileOutputStream);
                }
            }
        }
    }
}
