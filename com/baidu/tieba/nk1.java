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
/* loaded from: classes7.dex */
public class nk1 implements tm1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rm1 a;
    public String b;
    public final Context c;
    public final ik1 d;
    public p8.b e;
    public int f;
    public int g;
    public sk1 h;
    public int i;
    public gk1 j;
    public final hk1 k;

    /* loaded from: classes7.dex */
    public class a implements hk1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nk1 a;

        public a(nk1 nk1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nk1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nk1Var;
        }

        @Override // com.baidu.tieba.hk1
        public void a(Throwable th) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (this.a.e != null) {
                    this.a.e.onFailed();
                } else if (this.a.d != null) {
                    ik1 ik1Var = this.a.d;
                    if (th == null) {
                        message = "unKnow";
                    } else {
                        message = th.getMessage();
                    }
                    ik1Var.b(message);
                }
            }
        }

        @Override // com.baidu.tieba.hk1
        public void b(@NonNull sk1 sk1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sk1Var) != null) || p8.f().i()) {
                return;
            }
            int f = qk1.f(sk1Var, this.a.i);
            if (f == 0) {
                this.a.h = sk1Var;
                rm1 a = new zl1().a(this.a.c, ok1.a(sk1Var));
                if (a == null) {
                    if (this.a.d != null) {
                        this.a.d.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (!sk1Var.q()) {
                    this.a.a = a;
                    if (this.a.d != null) {
                        jk1 jk1Var = new jk1(a, this.a.d.g(), sk1Var);
                        jk1Var.m(this.a.d);
                        a.c(jk1Var);
                        a.a(jk1Var);
                        jk1Var.l(this.a);
                        this.a.k(!sk1Var.n());
                        this.a.n(!sk1Var.l());
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
                ik1 ik1Var = this.a.d;
                ik1Var.b("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public nk1(Context context, String str, bm1 bm1Var, ik1 ik1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, bm1Var, ik1Var};
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
        this.d = ik1Var;
        if (bm1Var != null && bm1Var.a() != null && bm1Var.a().containsKey("launch_type")) {
            try {
                this.i = Integer.parseInt(bm1Var.a().get("launch_type"));
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

    public void l(rm1 rm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, rm1Var) == null) {
            this.a = rm1Var;
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.g = i;
        }
    }

    @Override // com.baidu.tieba.tm1
    @Nullable
    public sk1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return (sk1) invokeV.objValue;
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
                m(qk1.n(this.i));
                return;
            }
            gk1 gk1Var = new gk1();
            this.j = gk1Var;
            gk1Var.j(this.b, this.k);
        }
    }

    @Override // com.baidu.tieba.tm1
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

    public void m(sk1 sk1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sk1Var) == null) {
            if (sk1Var != null) {
                this.h = sk1Var;
                am1 a2 = ok1.a(sk1Var);
                rm1 a3 = new zl1().a(this.c, a2);
                if (a3 == null) {
                    if (bk1.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    ik1 ik1Var = this.d;
                    if (ik1Var != null) {
                        ik1Var.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (sk1Var.q()) {
                    new BaseVM(this.h).c(null);
                    ik1 ik1Var2 = this.d;
                    if (ik1Var2 != null) {
                        ik1Var2.b("virtual order cannot show");
                        return;
                    }
                    return;
                } else {
                    this.a = a3;
                    ik1 ik1Var3 = this.d;
                    if (ik1Var3 != null) {
                        jk1 jk1Var = new jk1(a3, ik1Var3.g(), sk1Var);
                        jk1Var.m(this.d);
                        a3.c(jk1Var);
                        a3.a(jk1Var);
                        jk1Var.l(this);
                        k(!sk1Var.n());
                        n(!sk1Var.l());
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
            ik1 ik1Var4 = this.d;
            if (ik1Var4 != null) {
                ik1Var4.b("本地物料null");
            }
        }
    }

    public void o(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) == null) {
            rm1 rm1Var = this.a;
            if (viewGroup != null && rm1Var != null) {
                rm1Var.load();
                View adView = rm1Var.getAdView();
                if (adView != null && adView.getParent() == null) {
                    viewGroup.addView(adView);
                    return;
                }
                i();
                ik1 ik1Var = this.d;
                if (ik1Var != null) {
                    ik1Var.f();
                    return;
                }
                return;
            }
            i();
            ik1 ik1Var2 = this.d;
            if (ik1Var2 != null) {
                ik1Var2.f();
            }
        }
    }
}
