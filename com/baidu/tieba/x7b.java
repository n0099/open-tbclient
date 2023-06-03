package com.baidu.tieba;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.Callable;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class x7b implements Callable<w7b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Intent a;

    public x7b(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {intent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = intent;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, com.baidu.tieba.w7b] */
    @Override // java.util.concurrent.Callable
    public w7b call() throws Exception {
        InterceptResult invokeV;
        byte[] bArr;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Intent intent = this.a;
            if (intent == null) {
                return null;
            }
            long j = 0;
            try {
                j = intent.getLongExtra("msg_id", 0L);
            } catch (Exception e) {
                a8b.b("PassByMsgIntentParser", "parserMsgId", e);
            }
            try {
                bArr = this.a.getByteArrayExtra("msg_content");
            } catch (Exception e2) {
                a8b.b("PassByMsgIntentParser", "parseMsgContent", e2);
                bArr = null;
            }
            Inflater inflater = new Inflater();
            inflater.setInput(bArr);
            byte[] bArr2 = new byte[256];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(256);
            while (!inflater.finished()) {
                try {
                    byteArrayOutputStream.write(bArr2, 0, inflater.inflate(bArr2));
                } catch (DataFormatException unused) {
                    inflater.end();
                    str = null;
                } catch (Throwable th) {
                    inflater.end();
                    throw th;
                }
            }
            inflater.end();
            str = byteArrayOutputStream.toString("utf-8");
            if (str == null) {
                return null;
            }
            String optString = new JSONObject(str).optString("data");
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            w7b w7bVar = new w7b();
            w7bVar.d(j);
            w7bVar.c(optString);
            return w7bVar;
        }
        return invokeV.objValue;
    }
}
