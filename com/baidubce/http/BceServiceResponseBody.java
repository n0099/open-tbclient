package com.baidubce.http;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.callback.BceProgressCallback;
import com.baidubce.model.AbstractBceRequest;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
/* loaded from: classes7.dex */
public class BceServiceResponseBody extends ResponseBody {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BceProgressCallback bceProgressCallback;
    public BufferedSource bceRespBufferedSource;
    public final ResponseBody bceResponseBody;
    public AbstractBceRequest request;

    public BceServiceResponseBody(ResponseBody responseBody, AbstractBceRequest abstractBceRequest, BceProgressCallback bceProgressCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {responseBody, abstractBceRequest, bceProgressCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.bceResponseBody = responseBody;
        this.request = abstractBceRequest;
        this.bceProgressCallback = bceProgressCallback;
    }

    private Source source(BufferedSource bufferedSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bufferedSource)) == null) {
            return new ForwardingSource(this, bufferedSource) { // from class: com.baidubce.http.BceServiceResponseBody.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BceServiceResponseBody this$0;
                public long totalBytesRead;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(bufferedSource);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bufferedSource};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super((Source) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.totalBytesRead = 0L;
                }

                @Override // okio.ForwardingSource, okio.Source
                public long read(Buffer buffer, long j) throws IOException {
                    InterceptResult invokeLJ;
                    long j2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLJ = interceptable2.invokeLJ(1048576, this, buffer, j)) == null) {
                        long read = super.read(buffer, j);
                        long j3 = this.totalBytesRead;
                        if (read != -1) {
                            j2 = read;
                        } else {
                            j2 = 0;
                        }
                        this.totalBytesRead = j3 + j2;
                        if (this.this$0.bceProgressCallback != null && this.totalBytesRead > 0) {
                            this.this$0.bceProgressCallback.onProgress(this.this$0.request, this.totalBytesRead, this.this$0.bceResponseBody.contentLength());
                        }
                        return read;
                    }
                    return invokeLJ.longValue;
                }
            };
        }
        return (Source) invokeL.objValue;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.bceResponseBody.contentLength();
        }
        return invokeV.longValue;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.bceResponseBody.contentType();
        }
        return (MediaType) invokeV.objValue;
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.bceRespBufferedSource == null) {
                this.bceRespBufferedSource = Okio.buffer(source(this.bceResponseBody.source()));
            }
            return this.bceRespBufferedSource;
        }
        return (BufferedSource) invokeV.objValue;
    }
}
