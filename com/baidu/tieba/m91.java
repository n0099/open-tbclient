package com.baidu.tieba;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes5.dex */
public class m91 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile m91 b;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    public m91() {
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
        this.a = false;
    }

    public static m91 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (m91.class) {
                    if (b == null) {
                        b = new m91();
                    }
                }
            }
            return b;
        }
        return (m91) invokeV.objValue;
    }

    public void b(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || this.a) {
            return;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            c(context);
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new l91(context, countDownLatch).sendMessage(Message.obtain());
        try {
            countDownLatch.await();
        } catch (Exception unused) {
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            x81.a().c();
            try {
                new WebView(context);
            } catch (Exception unused) {
            }
            this.a = true;
        }
    }
}
