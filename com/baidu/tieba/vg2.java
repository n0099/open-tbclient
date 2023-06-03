package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.tg2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebResourceResponse;
import com.baidubce.http.Headers;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class vg2 extends mg2 implements hg2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public eg2 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vg2(@NonNull Context context, bg2 bg2Var) {
        super(context, bg2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bg2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (bg2) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new wg2();
    }

    public final WebResourceResponse b(String str, InputStream inputStream) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, inputStream)) == null) {
            HashMap hashMap = new HashMap(1);
            hashMap.put(Headers.CACHE_CONTROL, "max-age=86400");
            return new WebResourceResponse(true, str, "UTF-8", 200, DnsModel.MSG_OK, hashMap, new BufferedInputStream(inputStream));
        }
        return (WebResourceResponse) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.tg2
    @SuppressLint({"BDThrowableCheck"})
    public WebResourceResponse a(@NonNull tg2.a aVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            String d = aVar.d();
            if (!d(aVar)) {
                return aVar.b(d, aVar.getRequestHeaders(), aVar.c());
            }
            if (hg2.a) {
                Log.d("HybridIntercept", "intercept file = " + d);
            }
            String c = c(d);
            if (TextUtils.isEmpty(c)) {
                if (!hg2.a) {
                    return null;
                }
                throw new IllegalArgumentException("file path can't be null, src = " + d);
            }
            File file = new File(c);
            if (file.exists() && file.isFile()) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    if (c.endsWith(FileHelper.FILE_CACHE_CSS)) {
                        str = "text/css";
                    } else if (c.endsWith(".js")) {
                        str = "application/javascript";
                    } else {
                        str = "text/plan";
                    }
                    return b(str, fileInputStream);
                } catch (Throwable th) {
                    if (hg2.a) {
                        Log.e("HybridIntercept", Log.getStackTraceString(th));
                    }
                }
            }
            y82.c("HybridIntercept", "file intercept error, src = " + d);
            return null;
        }
        return (WebResourceResponse) invokeL.objValue;
    }

    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (str.startsWith("interceptfile://") && str.length() > 16) {
                str = str.substring(16);
            }
            if (hg2.a) {
                Log.d("HybridIntercept", "file request url = " + str);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public boolean d(@NonNull tg2.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) {
            if (!aVar.c()) {
                return true;
            }
            return this.b.a(aVar);
        }
        return invokeL.booleanValue;
    }
}
