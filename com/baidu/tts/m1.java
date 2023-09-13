package com.baidu.tts;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public abstract class m1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public URI a;

    public abstract void a(int i, Map<String, List<String>> map, String str, byte[] bArr);

    public abstract void a(int i, Map<String, List<String>> map, String str, byte[] bArr, Throwable th);

    public m1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
    }

    public void a(i1 i1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, i1Var) == null) && !Thread.currentThread().isInterrupted()) {
            LoggerProxy.d("TtsResponseHandler", "response: " + i1Var.d);
            int i = i1Var.d;
            Map<String, List<String>> map = i1Var.c;
            String str = i1Var.e;
            try {
                InputStream inputStream = i1Var.b;
                if (inputStream != null) {
                    if (i == 200) {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            if (read != -1) {
                                byteArrayOutputStream.write(bArr, 0, read);
                            } else {
                                bufferedInputStream.close();
                                a(i, map, str, byteArrayOutputStream.toByteArray());
                                return;
                            }
                        }
                    } else {
                        LoggerProxy.d("TtsResponseHandler", "request fail statusCode: " + i);
                        a(i, map, i1Var.e, null, null);
                    }
                } else {
                    throw new IllegalStateException("response getInputstream is null");
                }
            } catch (IOException e) {
                if (!Thread.currentThread().isInterrupted()) {
                    e.printStackTrace();
                    a(i, i1Var.c, i1Var.e, null, e);
                }
            }
        }
    }
}
