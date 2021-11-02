package com.bumptech.glide.load.model;

import android.util.Log;
import androidx.annotation.NonNull;
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
/* loaded from: classes11.dex */
public class StreamEncoder implements Encoder<InputStream> {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.byteArrayPool = arrayPool;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.load.Encoder
    public boolean encode(@NonNull InputStream inputStream, @NonNull File file, @NonNull Options options) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(1048576, this, inputStream, file, options)) != null) {
            return invokeLLL.booleanValue;
        }
        byte[] bArr = (byte[]) this.byteArrayPool.get(65536, byte[].class);
        boolean z = false;
        FileOutputStream fileOutputStream = null;
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
                    } catch (IOException unused) {
                        fileOutputStream = fileOutputStream2;
                        Log.isLoggable(TAG, 3);
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
                            } catch (IOException unused2) {
                            }
                        }
                        this.byteArrayPool.put(bArr);
                        throw th;
                    }
                }
                fileOutputStream2.close();
                z = true;
                fileOutputStream2.close();
            } catch (IOException unused3) {
            }
            this.byteArrayPool.put(bArr);
            return z;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
