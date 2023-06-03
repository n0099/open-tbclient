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
import com.baidu.tieba.o8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jk1 implements pm1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nm1 a;
    public String b;
    public final Context c;
    public final ek1 d;
    public o8.b e;
    public int f;
    public int g;
    public ok1 h;
    public int i;
    public ck1 j;
    public final dk1 k;

    /* loaded from: classes6.dex */
    public class a implements dk1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jk1 a;

        public a(jk1 jk1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jk1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jk1Var;
        }

        @Override // com.baidu.tieba.dk1
        public void a(Throwable th) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (this.a.e != null) {
                    this.a.e.onFailed();
                } else if (this.a.d != null) {
                    ek1 ek1Var = this.a.d;
                    if (th == null) {
                        message = "unKnow";
                    } else {
                        message = th.getMessage();
                    }
                    ek1Var.b(message);
                }
            }
        }

        @Override // com.baidu.tieba.dk1
        public void b(@NonNull ok1 ok1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ok1Var) != null) || o8.f().i()) {
                return;
            }
            int f = mk1.f(ok1Var, this.a.i);
            if (f == 0) {
                this.a.h = ok1Var;
                nm1 a = new vl1().a(this.a.c, kk1.a(ok1Var));
                if (a == null) {
                    if (this.a.d != null) {
                        this.a.d.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (!ok1Var.q()) {
                    this.a.a = a;
                    if (this.a.d != null) {
                        fk1 fk1Var = new fk1(a, this.a.d.g(), ok1Var);
                        fk1Var.m(this.a.d);
                        a.c(fk1Var);
                        a.a(fk1Var);
                        fk1Var.l(this.a);
                        this.a.k(!ok1Var.n());
                        this.a.n(!ok1Var.l());
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
                ek1 ek1Var = this.a.d;
                ek1Var.b("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public jk1(Context context, String str, xl1 xl1Var, ek1 ek1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, xl1Var, ek1Var};
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
        this.d = ek1Var;
        if (xl1Var != null && xl1Var.a() != null && xl1Var.a().containsKey("launch_type")) {
            try {
                this.i = Integer.parseInt(xl1Var.a().get("launch_type"));
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

    public void l(nm1 nm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, nm1Var) == null) {
            this.a = nm1Var;
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.g = i;
        }
    }

    @Override // com.baidu.tieba.pm1
    @Nullable
    public ok1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return (ok1) invokeV.objValue;
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
            if (!o8.f().h()) {
                m(mk1.n(this.i));
                return;
            }
            ck1 ck1Var = new ck1();
            this.j = ck1Var;
            ck1Var.j(this.b, this.k);
        }
    }

    @Override // com.baidu.tieba.pm1
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

    public void m(ok1 ok1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ok1Var) == null) {
            if (ok1Var != null) {
                this.h = ok1Var;
                wl1 a2 = kk1.a(ok1Var);
                nm1 a3 = new vl1().a(this.c, a2);
                if (a3 == null) {
                    if (xj1.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    ek1 ek1Var = this.d;
                    if (ek1Var != null) {
                        ek1Var.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (ok1Var.q()) {
                    new BaseVM(this.h).c(null);
                    ek1 ek1Var2 = this.d;
                    if (ek1Var2 != null) {
                        ek1Var2.b("virtual order cannot show");
                        return;
                    }
                    return;
                } else {
                    this.a = a3;
                    ek1 ek1Var3 = this.d;
                    if (ek1Var3 != null) {
                        fk1 fk1Var = new fk1(a3, ek1Var3.g(), ok1Var);
                        fk1Var.m(this.d);
                        a3.c(fk1Var);
                        a3.a(fk1Var);
                        fk1Var.l(this);
                        k(!ok1Var.n());
                        n(!ok1Var.l());
                        this.d.e(this);
                    }
                    o8.b bVar = this.e;
                    if (bVar != null) {
                        bVar.onSuccess();
                        return;
                    }
                    return;
                }
            }
            o8.b bVar2 = this.e;
            if (bVar2 != null) {
                bVar2.onFailed();
                return;
            }
            ek1 ek1Var4 = this.d;
            if (ek1Var4 != null) {
                ek1Var4.b("本地物料null");
            }
        }
    }

    public void o(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) == null) {
            nm1 nm1Var = this.a;
            if (viewGroup != null && nm1Var != null) {
                nm1Var.load();
                View adView = nm1Var.getAdView();
                if (adView != null && adView.getParent() == null) {
                    viewGroup.addView(adView);
                    return;
                }
                i();
                ek1 ek1Var = this.d;
                if (ek1Var != null) {
                    ek1Var.f();
                    return;
                }
                return;
            }
            i();
            ek1 ek1Var2 = this.d;
            if (ek1Var2 != null) {
                ek1Var2.f();
            }
        }
    }
}
