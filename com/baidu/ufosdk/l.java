package com.baidu.ufosdk;

import android.widget.FrameLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.hybrid.base.WebLoaderActivity;
/* loaded from: classes8.dex */
public class l implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ WebLoaderActivity a;

    public l(WebLoaderActivity webLoaderActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webLoaderActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = webLoaderActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            WebLoaderActivity webLoaderActivity = this.a;
            if (webLoaderActivity.d != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.a.o.getHeight());
                WebLoaderActivity webLoaderActivity2 = this.a;
                webLoaderActivity2.o.addView(webLoaderActivity2.d, layoutParams);
                return;
            }
            webLoaderActivity.y.obtainMessage(1002).sendToTarget();
        }
    }
}
