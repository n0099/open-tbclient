package com.baidu.tieba;

import android.text.TextUtils;
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
/* loaded from: classes8.dex */
public final class ut0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface b {
        void a(String str, int i);

        void b();
    }

    /* loaded from: classes8.dex */
    public static class a implements jt0 {
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

        @Override // com.baidu.tieba.jt0
        public void a(Exception exc, int i) {
            b bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) && (bVar = this.b) != null) {
                bVar.a(exc.getMessage(), i);
            }
        }

        @Override // com.baidu.tieba.jt0
        public void c(Headers headers, InputStream inputStream, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, headers, inputStream, i) == null) {
                if (i == 200) {
                    try {
                        ut0.b(inputStream, this.a);
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

    public static void a(@NonNull File file, @NonNull String str, @Nullable b bVar, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, file, str, bVar, str2) == null) {
            dt0 a2 = zs0.b().a();
            st0 st0Var = new st0();
            st0Var.l(str);
            st0Var.c();
            if (!TextUtils.isEmpty(str2)) {
                st0Var.d("User-Agent", str2);
            }
            a2.b(st0Var, new a(file, bVar));
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
                    nk0.a(fileOutputStream);
                }
            }
        }
    }
}
