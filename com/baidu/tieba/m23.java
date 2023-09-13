package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
/* loaded from: classes7.dex */
public final class m23 extends RequestBody {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MediaType a;
    public final FormBody b;

    public m23(FormBody formBody) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {formBody};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = formBody;
    }

    public void b(MediaType mediaType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mediaType) == null) {
            this.a = mediaType;
        }
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bufferedSink) == null) {
            this.b.writeTo(bufferedSink);
        }
    }

    public static m23 a(FormBody formBody, MediaType mediaType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, formBody, mediaType)) == null) {
            m23 m23Var = new m23(formBody);
            m23Var.b(mediaType);
            return m23Var;
        }
        return (m23) invokeLL.objValue;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b.contentLength();
        }
        return invokeV.longValue;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            MediaType mediaType = this.a;
            if (mediaType == null) {
                return this.b.contentType();
            }
            return mediaType;
        }
        return (MediaType) invokeV.objValue;
    }
}
