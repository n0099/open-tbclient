package com.baidu.turbonet.net;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public class FixedMultiPartBodyProvider extends UploadDataProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f57404e;

    /* renamed from: f  reason: collision with root package name */
    public int f57405f;

    @Override // com.baidu.turbonet.net.UploadDataProvider
    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f57404e.getBytes().length : invokeV.longValue;
    }

    @Override // com.baidu.turbonet.net.UploadDataProvider
    public void b(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uploadDataSink, byteBuffer) == null) {
            if (byteBuffer.hasRemaining()) {
                if (byteBuffer.remaining() >= this.f57404e.length() - this.f57405f) {
                    byteBuffer.put(this.f57404e.getBytes(), this.f57405f, this.f57404e.getBytes().length - this.f57405f);
                } else {
                    byteBuffer.put(this.f57404e.getBytes(), this.f57405f, byteBuffer.remaining());
                    this.f57405f += byteBuffer.remaining();
                }
                uploadDataSink.c(false);
                return;
            }
            throw new IllegalStateException("Cronet passed a buffer with no bytes remaining");
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataProvider
    public void c(UploadDataSink uploadDataSink) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uploadDataSink) == null) {
            this.f57405f = 0;
            uploadDataSink.a();
        }
    }
}
