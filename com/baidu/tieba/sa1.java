package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
import com.baidu.tieba.c91;
import com.baidu.tieba.db1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes7.dex */
public final class sa1 extends pa1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final jk0 a;
    public final ta1 b;

    /* loaded from: classes7.dex */
    public static final class a implements jk0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sa1 a;

        public a(sa1 sa1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sa1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sa1Var;
        }

        @Override // com.baidu.tieba.jk0
        public final void a(boolean z, Map<String, String> map) {
            AbsNadBrowserView m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, map) == null) {
                String p = ok0.p(map);
                if (!TextUtils.isEmpty(p) && (m = this.a.b.m()) != null) {
                    AbsNadBrowserView.B(m, p, null, 2, null);
                }
            }
        }
    }

    public sa1(ta1 container) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {container};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(container, "container");
        this.b = container;
        this.a = new a(this);
    }

    @Override // com.baidu.tieba.pa1
    public boolean f(AbsNadBrowserView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) == null) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            String e = z71.e(str);
            Intrinsics.checkNotNullExpressionValue(e, "UrlUtil.handleAbnormalUrlIfNeeded(url)");
            if (!TextUtils.isEmpty(e) && (StringsKt__StringsJVMKt.startsWith$default(e, "http://", false, 2, null) || StringsKt__StringsJVMKt.startsWith$default(e, "https://", false, 2, null) || StringsKt__StringsJVMKt.startsWith$default(e, "ftp://", false, 2, null) || StringsKt__StringsJVMKt.startsWith$default(e, "sftp://", false, 2, null) || StringsKt__StringsJVMKt.startsWith$default(e, "ftps://", false, 2, null))) {
                return false;
            }
            if (str != null && this.b.a(str)) {
                return true;
            }
            o(webView, str);
            if (this.b.l() != null) {
                db1.d l = this.b.l();
                Intrinsics.checkNotNull(l);
                if (!l.a()) {
                    return true;
                }
            }
            if (!mk0.a(this.b.c(), str) || yj0.b(this.b.c(), str, false) || c91.b.a().a(this.b.c(), str, webView.getUrl(), this.a) || ak0.c(str, this.b.c())) {
                return true;
            }
            if (pb1.b() && ik0.b.a(this.b.c(), str, null, this.a)) {
                return true;
            }
            AbsNadBrowserView m = this.b.m();
            if (m != null) {
                m.U();
            }
            return super.f(webView, str);
        }
        return invokeLL.booleanValue;
    }

    public final void o(AbsNadBrowserView absNadBrowserView, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absNadBrowserView, str) == null) && str != null) {
            String str3 = null;
            if (StringsKt__StringsJVMKt.startsWith$default(str, "tel:", false, 2, null) && this.b.c() != null) {
                db1.d l = this.b.l();
                if (l != null) {
                    str2 = l.f();
                } else {
                    str2 = null;
                }
                if (!TextUtils.isEmpty(str2)) {
                    oe1 oe1Var = new oe1();
                    Activity c = this.b.c();
                    Intrinsics.checkNotNull(c);
                    db1.d l2 = this.b.l();
                    if (l2 != null) {
                        str3 = l2.f();
                    }
                    oe1Var.p(c, str3, "tel");
                }
            }
        }
    }
}
