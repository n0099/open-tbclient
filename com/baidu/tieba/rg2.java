package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes7.dex */
public final class rg2 implements ig2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a b;
    public OutputStream c;
    public File d;
    public boolean e;

    /* loaded from: classes7.dex */
    public interface a {
        void a(File file);

        void b(File file);
    }

    public rg2(File file, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = file;
        this.b = aVar;
        b(file);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.c == null) {
            return;
        }
        a aVar = this.b;
        if (aVar != null) {
            if (this.e) {
                aVar.a(this.d);
            } else {
                aVar.b(this.d);
            }
        }
        ds4.d(this.c);
    }

    public final void b(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) == null) {
            try {
                if (this.c == null && file != null) {
                    ds4.h(this.d);
                    this.c = new FileOutputStream(file);
                }
            } catch (Exception e) {
                if (ig2.a) {
                    Log.e("HybridIntercept", Log.getStackTraceString(e));
                }
            }
        }
    }

    public void c(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, inputStream) == null) && inputStream != null && !this.e) {
            ds4.Q(inputStream, this.d);
            this.e = true;
        }
    }

    public void d(byte[] bArr, int i, int i2) {
        OutputStream outputStream;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048579, this, bArr, i, i2) == null) && (outputStream = this.c) != null) {
            try {
                if (i2 > 0) {
                    outputStream.write(bArr, i, i2);
                } else {
                    this.e = true;
                }
            } catch (IOException unused) {
                ds4.d(this.c);
                this.c = null;
                a aVar = this.b;
                if (aVar != null) {
                    aVar.b(this.d);
                }
            }
        }
    }
}
