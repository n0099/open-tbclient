package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.activity.NadWebViewActivity;
import com.baidu.nadcore.webview.activity.NadWebViewActivityStandard;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tieba.eb1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
@Service
/* loaded from: classes9.dex */
public final class z91 extends fj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    @Override // com.baidu.tieba.fj0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "easybrowse" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fj0
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "interceptorEasybrowse" : (String) invokeV.objValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes9.dex */
    public static final class a implements eb1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z91 a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ HashMap c;
        public final /* synthetic */ lj0 d;
        public final /* synthetic */ hj0 e;

        public a(z91 z91Var, Context context, HashMap hashMap, lj0 lj0Var, hj0 hj0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z91Var, context, hashMap, lj0Var, hj0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z91Var;
            this.b = context;
            this.c = hashMap;
            this.d = lj0Var;
            this.e = hj0Var;
        }

        @Override // com.baidu.tieba.eb1.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = 0;
                boolean i2 = this.a.i(this.b, this.c, false);
                String str = this.a.a;
                jb1.a(str, "调起SDK落地页, 结果 " + i2);
                z91 z91Var = this.a;
                lj0 lj0Var = this.d;
                hj0 hj0Var = this.e;
                if (!i2) {
                    i = 1001;
                }
                z91Var.c(lj0Var, hj0Var, i, i2);
            }
        }

        @Override // com.baidu.tieba.eb1.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                jb1.c(this.b, "初始化失败，降级为原生打开");
            }
        }
    }

    public z91() {
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
        this.a = "EasyBrowseInterceptor";
    }

    @Override // com.baidu.tieba.fj0
    public boolean d(Context context, hj0 schemeModel, Map<String, Object> map, lj0 lj0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, schemeModel, map, lj0Var)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(schemeModel, "schemeModel");
            int i = 0;
            if (!j()) {
                jb1.c(context, "未命中新架构");
                return false;
            }
            HashMap<String, String> d = schemeModel.d();
            Intrinsics.checkNotNullExpressionValue(d, "schemeModel.params");
            y31.b((String) j31.b(d, "charge_url"));
            int b = aa1.b(context.getApplicationContext(), new a(this, context, d, lj0Var, schemeModel));
            if (b == 0) {
                c(lj0Var, schemeModel, 1001, false);
                jb1.d(new IllegalStateException("web app init failed, state=" + b));
                return false;
            } else if (2 != b && 1 != b) {
                if (4 == b) {
                    jb1.c(context, "初始化失败，降级为原生打开");
                    h(context, schemeModel, lj0Var);
                    return true;
                } else if (5 == b) {
                    jb1.c(context, "低版本不支持t7，降级为原生打开");
                    h(context, schemeModel, lj0Var);
                    return true;
                } else {
                    boolean i2 = i(context, d, false);
                    String str = this.a;
                    jb1.a(str, "调起SDK落地页, 结果 " + i2);
                    if (!i2) {
                        i = 1001;
                    }
                    c(lj0Var, schemeModel, i, i2);
                    return true;
                }
            } else {
                jb1.c(context, "正在初始化，降级为原生打开");
                h(context, schemeModel, lj0Var);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void h(Context context, hj0 hj0Var, lj0 lj0Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, hj0Var, lj0Var) == null) {
            HashMap<String, String> d = hj0Var.d();
            Intrinsics.checkNotNullExpressionValue(d, "schemeModel.params");
            d.put("downgrade_to_native", "1");
            boolean i2 = i(context, hj0Var.d(), true);
            if (i2) {
                i = 0;
            } else {
                i = 1001;
            }
            c(lj0Var, hj0Var, i, i2);
        }
    }

    public final boolean i(Context context, HashMap<String, String> hashMap, boolean z) {
        InterceptResult invokeLLZ;
        String str;
        Class cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, context, hashMap, z)) == null) {
            if (!z && !w91.a().b(hashMap, w91.b())) {
                jb1.a(this.a, "调起SDK落地页, Activity 调起失败, 内核未成功初始化");
                return false;
            }
            if (hashMap != null) {
                str = hashMap.remove("newbrowser");
            } else {
                str = null;
            }
            if (Intrinsics.areEqual("1", str)) {
                cls = NadWebViewActivityStandard.class;
            } else {
                cls = NadWebViewActivity.class;
            }
            Intent intent = new Intent(context, cls);
            intent.putExtra("map", hashMap);
            return i61.d(context, intent);
        }
        return invokeLLZ.booleanValue;
    }
}
