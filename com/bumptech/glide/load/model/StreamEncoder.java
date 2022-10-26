package com.bumptech.glide.load.model;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class StreamEncoder implements Encoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "StreamEncoder";
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayPool byteArrayPool;

    public StreamEncoder(ArrayPool arrayPool) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arrayPool};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.byteArrayPool = arrayPool;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.load.Encoder
    public boolean encode(InputStream inputStream, File file, Options options) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, inputStream, file, options)) == null) {
            byte[] bArr = (byte[]) this.byteArrayPool.get(65536, byte[].class);
            boolean z = false;
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        while (true) {
                            try {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, read);
                            } catch (IOException e) {
                                e = e;
                                fileOutputStream = fileOutputStream2;
                                if (Log.isLoggable(TAG, 3)) {
                                    Log.d(TAG, "Failed to encode data onto the OutputStream", e);
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                this.byteArrayPool.put(bArr);
                                return z;
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = fileOutputStream2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException unused) {
                                    }
                                }
                                this.byteArrayPool.put(bArr);
                                throw th;
                            }
                        }
                        fileOutputStream2.close();
                        z = true;
                        fileOutputStream2.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (IOException unused2) {
            }
            this.byteArrayPool.put(bArr);
            return z;
        }
        return invokeLLL.booleanValue;
    }
}
