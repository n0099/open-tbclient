package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.sdk.container.interfaces.LoadState;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.p8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jj1 implements pl1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nl1 a;
    public String b;
    public final Context c;
    public final ej1 d;
    public p8.b e;
    public int f;
    public int g;
    public oj1 h;
    public int i;
    public cj1 j;
    public final dj1 k;

    /* loaded from: classes6.dex */
    public class a implements dj1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jj1 a;

        public a(jj1 jj1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jj1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jj1Var;
        }

        @Override // com.baidu.tieba.dj1
        public void a(Throwable th) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (this.a.e != null) {
                    this.a.e.onFailed();
                } else if (this.a.d != null) {
                    ej1 ej1Var = this.a.d;
                    if (th == null) {
                        message = "unKnow";
                    } else {
                        message = th.getMessage();
                    }
                    ej1Var.b(message);
                }
            }
        }

        @Override // com.baidu.tieba.dj1
        public void b(@NonNull oj1 oj1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oj1Var) != null) || p8.f().i()) {
                return;
            }
            int f = mj1.f(oj1Var, this.a.i);
            if (f == 0) {
                this.a.h = oj1Var;
                nl1 a = new vk1().a(this.a.c, kj1.a(oj1Var));
                if (a == null) {
                    if (this.a.d != null) {
                        this.a.d.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (!oj1Var.q()) {
                    this.a.a = a;
                    if (this.a.d != null) {
                        fj1 fj1Var = new fj1(a, this.a.d.g(), oj1Var);
                        fj1Var.m(this.a.d);
                        a.c(fj1Var);
                        a.a(fj1Var);
                        fj1Var.l(this.a);
                        this.a.k(!oj1Var.n());
                        this.a.n(!oj1Var.l());
                        this.a.d.e(this.a);
                    }
                    if (this.a.e != null) {
                        this.a.e.onSuccess();
                        return;
                    }
                    return;
                } else {
                    new BaseVM(this.a.h).c(null);
                    if (this.a.d != null) {
                        this.a.d.b("virtual order cannot show");
                        return;
                    }
                    return;
                }
            }
            if (this.a.e != null) {
                this.a.e.onFailed();
            } else if (this.a.d != null) {
                ej1 ej1Var = this.a.d;
                ej1Var.b("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public jj1(Context context, String str, xk1 xk1Var, ej1 ej1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, xk1Var, ej1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        LoadState loadState = LoadState.INIT;
        this.i = 0;
        this.k = new a(this);
        this.c = context;
        this.b = str;
        this.d = ej1Var;
        if (xk1Var != null && xk1Var.a() != null && xk1Var.a().containsKey("launch_type")) {
            try {
                this.i = Integer.parseInt(xk1Var.a().get("launch_type"));
            } catch (NumberFormatException unused) {
                this.i = 0;
            }
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f = i;
        }
    }

    public void l(nl1 nl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, nl1Var) == null) {
            this.a = nl1Var;
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.g = i;
        }
    }

    @Override // com.baidu.tieba.pl1
    @Nullable
    public oj1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return (oj1) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a != null) {
            this.a = null;
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!p8.f().h()) {
                m(mj1.n(this.i));
                return;
            }
            cj1 cj1Var = new cj1();
            this.j = cj1Var;
            cj1Var.j(this.b, this.k);
        }
    }

    @Override // com.baidu.tieba.pl1
    public JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.h != null) {
                    jSONObject.put("source", this.h.E);
                    jSONObject.put(QuickPersistConfigConst.KEY_SPLASH_SORT, this.h.F);
                }
                jSONObject.put(TiebaStatic.Params.AD_TYPE, this.f);
                jSONObject.put("full_type", this.g);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void m(oj1 oj1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, oj1Var) == null) {
            if (oj1Var != null) {
                this.h = oj1Var;
                wk1 a2 = kj1.a(oj1Var);
                nl1 a3 = new vk1().a(this.c, a2);
                if (a3 == null) {
                    if (xi1.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    ej1 ej1Var = this.d;
                    if (ej1Var != null) {
                        ej1Var.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (oj1Var.q()) {
                    new BaseVM(this.h).c(null);
                    ej1 ej1Var2 = this.d;
                    if (ej1Var2 != null) {
                        ej1Var2.b("virtual order cannot show");
                        return;
                    }
                    return;
                } else {
                    this.a = a3;
                    ej1 ej1Var3 = this.d;
                    if (ej1Var3 != null) {
                        fj1 fj1Var = new fj1(a3, ej1Var3.g(), oj1Var);
                        fj1Var.m(this.d);
                        a3.c(fj1Var);
                        a3.a(fj1Var);
                        fj1Var.l(this);
                        k(!oj1Var.n());
                        n(!oj1Var.l());
                        this.d.e(this);
                    }
                    p8.b bVar = this.e;
                    if (bVar != null) {
                        bVar.onSuccess();
                        return;
                    }
                    return;
                }
            }
            p8.b bVar2 = this.e;
            if (bVar2 != null) {
                bVar2.onFailed();
                return;
            }
            ej1 ej1Var4 = this.d;
            if (ej1Var4 != null) {
                ej1Var4.b("本地物料null");
            }
        }
    }

    public void o(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) == null) {
            nl1 nl1Var = this.a;
            if (viewGroup != null && nl1Var != null) {
                nl1Var.load();
                View adView = nl1Var.getAdView();
                if (adView != null && adView.getParent() == null) {
                    viewGroup.addView(adView);
                    return;
                }
                i();
                ej1 ej1Var = this.d;
                if (ej1Var != null) {
                    ej1Var.f();
                    return;
                }
                return;
            }
            i();
            ej1 ej1Var2 = this.d;
            if (ej1Var2 != null) {
                ej1Var2.f();
            }
        }
    }
}
