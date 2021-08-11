package com.bumptech.glide.load.model;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public class ByteBufferEncoder implements Encoder<ByteBuffer> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ByteBufferEncoder";
    public transient /* synthetic */ FieldHolder $fh;

    public ByteBufferEncoder() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.load.Encoder
    public boolean encode(@NonNull ByteBuffer byteBuffer, @NonNull File file, @NonNull Options options) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer, file, options)) == null) {
            try {
                ByteBufferUtil.toFile(byteBuffer, file);
                return true;
            } catch (IOException unused) {
                Log.isLoggable(TAG, 3);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }
}
