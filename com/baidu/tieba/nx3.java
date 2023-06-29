package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.tieba.nb3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Service
/* loaded from: classes7.dex */
public class nx3 implements vx1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pr3 a;

    @Override // com.baidu.tieba.vx1
    public void d(String str, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, context) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements nb3.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;
        public final /* synthetic */ String b;

        public a(nx3 nx3Var, SwanAppActivity swanAppActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx3Var, swanAppActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppActivity;
            this.b = str;
        }

        @Override // com.baidu.tieba.nb3.a
        public void a(nb3 nb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nb3Var) == null) {
                b03.d(nb3Var.c(), this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends zo2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;
        public final /* synthetic */ nx3 b;

        public b(nx3 nx3Var, SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx3Var, swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nx3Var;
            this.a = swanAppActivity;
        }

        @Override // com.baidu.tieba.zo2, com.baidu.tieba.ap2
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.a.j();
                this.a.G0(this);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948017792, "Lcom/baidu/tieba/nx3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948017792, "Lcom/baidu/tieba/nx3;");
                return;
            }
        }
        boolean z = ms1.a;
    }

    public nx3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.vx1
    public void a(NgWebView ngWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ngWebView) == null) {
            ngWebView.doSelectionCancel();
        }
    }

    @Override // com.baidu.tieba.vx1
    public void b(NgWebView ngWebView, String str) {
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ngWebView, str) == null) && (w = bc3.K().w()) != null && !TextUtils.isEmpty(str)) {
            this.a = new pr3(ngWebView.covertToView());
            int[] g = g(w);
            int[] h = h(w);
            for (int i = 0; i < g.length; i++) {
                this.a.e(g[i], h[i]);
            }
            this.a.r(new a(this, w, str));
            this.a.t();
            w.u0(new b(this, w));
        }
    }

    @Override // com.baidu.tieba.vx1
    public void c(NgWebView ngWebView, int i, int i2, int i3, int i4, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{ngWebView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Boolean.valueOf(z)}) == null) {
            ngWebView.updateAndShowPopupWindow(i3, i4, i, i2, str, true);
            if (z) {
                i("show", null, null);
            }
        }
    }

    @Override // com.baidu.tieba.vx1
    public void e(String str, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, str, context) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        xp3.b(context).c(str);
        i("click", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, null);
    }

    public int[] g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            int[] iArr = {7, 6, 8};
            if (!ep3.a(context, "android.permission.SET_WALLPAPER")) {
                int[] iArr2 = new int[2];
                System.arraycopy(iArr, 0, iArr2, 0, 2);
                return iArr2;
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public int[] h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            int[] iArr = {R.string.obfuscated_res_0x7f0f148b, R.string.obfuscated_res_0x7f0f148d, R.string.obfuscated_res_0x7f0f1491};
            if (!ep3.a(context, "android.permission.SET_WALLPAPER")) {
                int[] iArr2 = new int[2];
                System.arraycopy(iArr, 0, iArr2, 0, 2);
                return iArr2;
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public void i(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, str3) == null) {
            ej3 ej3Var = new ej3();
            ej3Var.a = "tool";
            ej3Var.f = bc3.K().getAppId();
            ej3Var.c = "miniapp";
            ej3Var.g = "text";
            ej3Var.b = str;
            ej3Var.e = str2;
            if (!TextUtils.isEmpty(str3)) {
                ej3Var.a("query", str3);
            }
            vi3.x("810", ej3Var);
        }
    }
}
