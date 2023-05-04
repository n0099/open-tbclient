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
import com.baidu.tieba.g8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ki1 implements qk1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ok1 a;
    public String b;
    public final Context c;
    public final fi1 d;
    public g8.b e;
    public int f;
    public int g;
    public pi1 h;
    public int i;
    public di1 j;
    public final ei1 k;

    /* loaded from: classes5.dex */
    public class a implements ei1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ki1 a;

        public a(ki1 ki1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ki1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ki1Var;
        }

        @Override // com.baidu.tieba.ei1
        public void a(Throwable th) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (this.a.e != null) {
                    this.a.e.onFailed();
                } else if (this.a.d != null) {
                    fi1 fi1Var = this.a.d;
                    if (th == null) {
                        message = "unKnow";
                    } else {
                        message = th.getMessage();
                    }
                    fi1Var.b(message);
                }
            }
        }

        @Override // com.baidu.tieba.ei1
        public void b(@NonNull pi1 pi1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pi1Var) != null) || g8.f().i()) {
                return;
            }
            int f = ni1.f(pi1Var, this.a.i);
            if (f == 0) {
                this.a.h = pi1Var;
                ok1 a = new wj1().a(this.a.c, li1.a(pi1Var));
                if (a == null) {
                    if (this.a.d != null) {
                        this.a.d.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (!pi1Var.q()) {
                    this.a.a = a;
                    if (this.a.d != null) {
                        gi1 gi1Var = new gi1(a, this.a.d.g(), pi1Var);
                        gi1Var.m(this.a.d);
                        a.c(gi1Var);
                        a.a(gi1Var);
                        gi1Var.l(this.a);
                        this.a.k(!pi1Var.n());
                        this.a.n(!pi1Var.l());
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
                fi1 fi1Var = this.a.d;
                fi1Var.b("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public ki1(Context context, String str, yj1 yj1Var, fi1 fi1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, yj1Var, fi1Var};
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
        this.d = fi1Var;
        if (yj1Var != null && yj1Var.a() != null && yj1Var.a().containsKey("launch_type")) {
            try {
                this.i = Integer.parseInt(yj1Var.a().get("launch_type"));
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

    public void l(ok1 ok1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ok1Var) == null) {
            this.a = ok1Var;
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.g = i;
        }
    }

    @Override // com.baidu.tieba.qk1
    @Nullable
    public pi1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return (pi1) invokeV.objValue;
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
            if (!g8.f().h()) {
                m(ni1.n(this.i));
                return;
            }
            di1 di1Var = new di1();
            this.j = di1Var;
            di1Var.j(this.b, this.k);
        }
    }

    @Override // com.baidu.tieba.qk1
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

    public void m(pi1 pi1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, pi1Var) == null) {
            if (pi1Var != null) {
                this.h = pi1Var;
                xj1 a2 = li1.a(pi1Var);
                ok1 a3 = new wj1().a(this.c, a2);
                if (a3 == null) {
                    if (yh1.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    fi1 fi1Var = this.d;
                    if (fi1Var != null) {
                        fi1Var.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (pi1Var.q()) {
                    new BaseVM(this.h).c(null);
                    fi1 fi1Var2 = this.d;
                    if (fi1Var2 != null) {
                        fi1Var2.b("virtual order cannot show");
                        return;
                    }
                    return;
                } else {
                    this.a = a3;
                    fi1 fi1Var3 = this.d;
                    if (fi1Var3 != null) {
                        gi1 gi1Var = new gi1(a3, fi1Var3.g(), pi1Var);
                        gi1Var.m(this.d);
                        a3.c(gi1Var);
                        a3.a(gi1Var);
                        gi1Var.l(this);
                        k(!pi1Var.n());
                        n(!pi1Var.l());
                        this.d.e(this);
                    }
                    g8.b bVar = this.e;
                    if (bVar != null) {
                        bVar.onSuccess();
                        return;
                    }
                    return;
                }
            }
            g8.b bVar2 = this.e;
            if (bVar2 != null) {
                bVar2.onFailed();
                return;
            }
            fi1 fi1Var4 = this.d;
            if (fi1Var4 != null) {
                fi1Var4.b("本地物料null");
            }
        }
    }

    public void o(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) == null) {
            ok1 ok1Var = this.a;
            if (viewGroup != null && ok1Var != null) {
                ok1Var.load();
                View adView = ok1Var.getAdView();
                if (adView != null && adView.getParent() == null) {
                    viewGroup.addView(adView);
                    return;
                }
                i();
                fi1 fi1Var = this.d;
                if (fi1Var != null) {
                    fi1Var.f();
                    return;
                }
                return;
            }
            i();
            fi1 fi1Var2 = this.d;
            if (fi1Var2 != null) {
                fi1Var2.f();
            }
        }
    }
}
