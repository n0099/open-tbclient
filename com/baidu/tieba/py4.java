package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.tieba.browser.jscore.jsinterface.AbsJsInterface;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class py4 extends AbsJsInterface {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView a;
        public final /* synthetic */ String b;

        public a(py4 py4Var, WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {py4Var, webView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = webView;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a != null && !TextUtils.isEmpty(this.b)) {
                    TbLog hybridLog = HybridLog.getInstance();
                    hybridLog.i("TbNativeInvokeJsInterface", "js注入端能力开始执行:" + this.b + " " + this.a);
                    wl6.a().c(this.a, this.b, null);
                    return;
                }
                TbLog hybridLog2 = HybridLog.getInstance();
                hybridLog2.i("TbNativeInvokeJsInterface", "js注入端能力执行失败:" + this.b + " " + this.a);
            }
        }
    }

    public py4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @JavascriptInterface
    public void process(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            SafeHandler.getInst().post(new a(this, this.mWebView, str));
        }
    }
}
