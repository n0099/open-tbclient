package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.webkit.WebView;
import androidx.collection.ArrayMap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tieba.browser.exception.JsInterfaceException;
import com.baidu.tieba.browser.jscore.jsinterface.AbsJsInterface;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
/* loaded from: classes7.dex */
public class yd6 extends zd6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final WebView a;
    public final Map<String, AbsJsInterface> b;

    public yd6(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView};
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
        this.b = new ArrayMap();
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            kg6.c("lt-log", "remove k:" + str);
            AbsJsInterface absJsInterface = this.b.get(str);
            if (absJsInterface != null) {
                absJsInterface.deAttachWebView();
            }
            this.a.removeJavascriptInterface(str);
        }
    }

    public static yd6 g(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, webView)) == null) {
            return new yd6(webView);
        }
        return (yd6) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xd6
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (String str : this.b.keySet()) {
                h(str);
            }
            this.b.clear();
        }
    }

    @Override // com.baidu.tieba.xd6
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Map<String, Class<? extends AbsJsInterface>> b = ag6.a().b();
            if (!b.isEmpty()) {
                try {
                    e(b);
                } catch (JsInterfaceException e) {
                    if (!nf6.a()) {
                        ((lg6) ServiceManager.getService(lg6.a)).a(e);
                        return;
                    }
                    throw e;
                }
            }
        }
    }

    public final void e(Map<String, Class<? extends AbsJsInterface>> map) throws JsInterfaceException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
            if (d()) {
                for (Map.Entry<String, Class<? extends AbsJsInterface>> entry : map.entrySet()) {
                    Class<? extends AbsJsInterface> value = entry.getValue();
                    if (c(value)) {
                        try {
                            f(entry.getKey(), value);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        throw new JsInterfaceException("This object has not offer method javascript to call ,please check addJavascriptInterface annotation was be added");
                    }
                }
                return;
            }
            throw new JsInterfaceException("The injected object is not safe, give up injection");
        }
    }

    @SuppressLint({"JavascriptInterface"})
    public final void f(String str, Class<? extends AbsJsInterface> cls) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, cls) == null) {
            kg6.c("lt-log", "inject k:" + str + "  v:" + cls);
            AbsJsInterface newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            newInstance.attachWebView(this.a);
            this.b.put(str, newInstance);
            this.a.addJavascriptInterface(newInstance, str);
        }
    }
}
