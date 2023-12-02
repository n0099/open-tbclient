package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
import com.baidu.tieba.v31;
import com.baidu.tieba.v51;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes6.dex */
public final class k51 extends h51 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ze0 a;
    public final l51 b;

    /* loaded from: classes6.dex */
    public static final class a implements ze0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k51 a;

        public a(k51 k51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k51Var;
        }

        @Override // com.baidu.tieba.ze0
        public final void a(boolean z, Map<String, String> map) {
            AbsNadBrowserView m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, map) == null) {
                String p = ef0.p(map);
                if (!TextUtils.isEmpty(p) && (m = this.a.b.m()) != null) {
                    AbsNadBrowserView.C(m, p, null, 2, null);
                }
            }
        }
    }

    public k51(l51 container) {
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

    @Override // com.baidu.tieba.h51
    public boolean f(AbsNadBrowserView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) == null) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            String e = s21.e(str);
            Intrinsics.checkNotNullExpressionValue(e, "UrlUtil.handleAbnormalUrlIfNeeded(url)");
            if (!TextUtils.isEmpty(e) && (StringsKt__StringsJVMKt.startsWith$default(e, "http://", false, 2, null) || StringsKt__StringsJVMKt.startsWith$default(e, "https://", false, 2, null) || StringsKt__StringsJVMKt.startsWith$default(e, "ftp://", false, 2, null) || StringsKt__StringsJVMKt.startsWith$default(e, "sftp://", false, 2, null) || StringsKt__StringsJVMKt.startsWith$default(e, "ftps://", false, 2, null))) {
                return false;
            }
            if (str != null && this.b.a(str)) {
                return true;
            }
            if (this.b.l() != null) {
                v51.d l = this.b.l();
                Intrinsics.checkNotNull(l);
                if (!l.a()) {
                    return true;
                }
            }
            if (!cf0.a(this.b.b(), str) || oe0.b(this.b.b(), str, false) || v31.b.a().a(this.b.b(), str, webView.getUrl(), this.a) || qe0.c(str, this.b.b())) {
                return true;
            }
            if (h61.b() && ye0.b.a(this.b.b(), str, null, this.a)) {
                return true;
            }
            AbsNadBrowserView m = this.b.m();
            if (m != null) {
                m.V();
            }
            return super.f(webView, str);
        }
        return invokeLL.booleanValue;
    }
}
