package com.baidu.tts;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.io.File;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public abstract class l1 extends m1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void a(int i, Map<String, List<String>> map, Throwable th, File file);

    public File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            w0.a(false, "Target file is null, fatal!");
            return null;
        }
        return (File) invokeV.objValue;
    }

    @Override // com.baidu.tts.m1
    public void a(int i, Map map, String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), map, str, bArr}) == null) {
            a();
            throw null;
        }
    }

    @Override // com.baidu.tts.m1
    public void a(int i, Map map, String str, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), map, str, bArr, th}) == null) {
            a();
            throw null;
        }
    }

    @Override // com.baidu.tts.m1
    public void a(i1 i1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, i1Var) == null) && !Thread.currentThread().isInterrupted()) {
            int i = i1Var.d;
            Map<String, List<String>> map = i1Var.c;
            if (i == 416) {
                if (!Thread.currentThread().isInterrupted()) {
                    a(i, map, (Throwable) null, (File) null);
                }
            } else if (i > 300) {
                if (!Thread.currentThread().isInterrupted()) {
                    a(i, map, new Exception("response failed "), (File) null);
                }
            } else if (!Thread.currentThread().isInterrupted()) {
                List<String> list = map.get("Content-Range");
                if (list != null) {
                    LoggerProxy.v("RangeFileAsyncHttpRH", " HEADER_CONTENT_RANGE: " + ((Object) list.get(0)));
                }
                try {
                    if (i1Var.b != null) {
                        a();
                        throw null;
                    }
                    throw new IllegalStateException("response getInputstream is null");
                } catch (Exception e) {
                    e.printStackTrace();
                    a();
                    throw null;
                }
            }
        }
    }
}
