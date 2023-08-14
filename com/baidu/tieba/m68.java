package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public final class m68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragment a;
    public boolean b;
    public String c;
    public String d;
    public final qy4 e;

    public m68(BaseFragment fragment) {
        py4 py4Var;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.a = fragment;
        if (fragment instanceof py4) {
            py4Var = (py4) fragment;
        } else {
            py4Var = null;
        }
        this.e = new qy4(py4Var);
    }

    @SuppressLint({"UseRequireInsteadOfGet"})
    public final void b(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            Bundle arguments = this.a.getArguments();
            if (arguments != null) {
                this.b = arguments.getBoolean("tab_is_second_tab");
                this.d = arguments.getString("tab_code");
                this.c = arguments.getString("tab_name");
            } else if (bundle != null) {
                this.b = bundle.getBoolean("tab_is_second_tab");
                this.d = bundle.getString("tab_code");
                this.c = bundle.getString("tab_name");
            }
        }
    }

    public final void a(TbWebView tbWebView) {
        HashMap<String, gg5> colourHeaderConfig;
        gg5 gg5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, tbWebView) == null) && !this.b && !StringUtils.isNull(this.c) && (colourHeaderConfig = TbSingleton.getInstance().getColourHeaderConfig()) != null && (gg5Var = colourHeaderConfig.get(this.c)) != null) {
            List<String> h5ImageUrlList = gg5Var.k();
            Intrinsics.checkNotNullExpressionValue(h5ImageUrlList, "h5ImageUrlList");
            JSONArray jSONArray = new JSONArray();
            for (String str : h5ImageUrlList) {
                jSONArray.put(str);
            }
            tbWebView.H("head_img", jSONArray);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e.b();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            YunDialogManager.onHidden(h55.h);
            YunDialogManager.onHidden(h55.a(this.d));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || this.b) {
            return;
        }
        if (this.a.isPrimary()) {
            e();
        } else {
            d();
        }
    }

    @SuppressLint({"UseRequireInsteadOfGet"})
    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.a.getContext() == null) {
            return;
        }
        Context context = this.a.getContext();
        Intrinsics.checkNotNull(context);
        YunDialogManager.onShow(context, h55.h);
        Context context2 = this.a.getContext();
        Intrinsics.checkNotNull(context2);
        YunDialogManager.onShow(context2, h55.a(this.d));
    }

    public final void h(TbWebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, webView) == null) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            a(webView);
        }
    }
}
