package com.baidu.tieba;

import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class mr8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbWebView a;

    public mr8(TbWebView webView) {
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
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.a = webView;
    }

    public static final void b(mr8 this$0, String name, HashMap params) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, this$0, name, params) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(name, "$name");
            Intrinsics.checkNotNullParameter(params, "$params");
            rj6.a().d(this$0.a, name, params);
        }
    }

    public static final void d(mr8 this$0, String eventName, String json) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, this$0, eventName, json) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(eventName, "$eventName");
            Intrinsics.checkNotNullParameter(json, "$json");
            rj6.a().i(this$0.a, eventName, new JSONObject(json));
        }
    }

    public final void a(final String name, final HashMap<String, Object> params) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, name, params) == null) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(params, "params");
            UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.hr8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        mr8.b(mr8.this, name, params);
                    }
                }
            });
        }
    }

    public final void c(final String eventName, final String json) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eventName, json) == null) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(json, "json");
            UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.ir8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        mr8.d(mr8.this, eventName, json);
                    }
                }
            });
        }
    }
}
