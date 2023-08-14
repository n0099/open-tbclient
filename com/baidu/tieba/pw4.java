package com.baidu.tieba;

import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class pw4 implements ItemCardHelper.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final rh6<WebView> a;

    public pw4(@NonNull rh6<WebView> rh6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rh6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = rh6Var;
    }

    @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            c(this.a.call(), String.valueOf(j), 0);
        }
    }

    @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            c(this.a.call(), String.valueOf(j), 1);
        }
    }

    public final void c(WebView webView, @NonNull String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, webView, str, i) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("id", str);
            hashMap.put("resultCode", Integer.valueOf(i));
            hashMap.put("name", null);
            rk6.a().d(webView, "orderGameApkResult", hashMap);
        }
    }
}
