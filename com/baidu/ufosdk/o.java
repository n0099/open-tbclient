package com.baidu.ufosdk;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public WeakReference b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o(WebView webView) {
        this(webView, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((WebView) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void a(String str) {
        WebView webView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                if (this.b == null) {
                    webView = null;
                } else {
                    webView = (WebView) this.b.get();
                }
                if (webView != null) {
                    webView.loadUrl(String.format("javascript:" + this.a + "(%s)", str));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public o(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (webView != null) {
            this.b = new WeakReference(webView);
        }
        this.a = str;
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(StatConstants.KEY_EXT_ERR_CODE, str);
                jSONObject.put("msg", str2);
                a(jSONObject.toString());
            } catch (JSONException unused) {
            }
        }
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(StatConstants.KEY_EXT_ERR_CODE, "10000");
                jSONObject2.put("msg", "success");
                jSONObject2.put("data", jSONObject);
                a(jSONObject2.toString());
            } catch (JSONException unused) {
            }
        }
    }
}
