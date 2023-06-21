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
public class kk1 implements qm1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public om1 a;
    public String b;
    public final Context c;
    public final fk1 d;
    public o8.b e;
    public int f;
    public int g;
    public pk1 h;
    public int i;
    public dk1 j;
    public final ek1 k;

    /* loaded from: classes6.dex */
    public class a implements ek1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kk1 a;

        public a(kk1 kk1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kk1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kk1Var;
        }

        @Override // com.baidu.tieba.ek1
        public void a(Throwable th) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (this.a.e != null) {
                    this.a.e.onFailed();
                } else if (this.a.d != null) {
                    fk1 fk1Var = this.a.d;
                    if (th == null) {
                        message = "unKnow";
                    } else {
                        message = th.getMessage();
                    }
                    fk1Var.b(message);
                }
            }
        }

        @Override // com.baidu.tieba.ek1
        public void b(@NonNull pk1 pk1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pk1Var) != null) || o8.f().i()) {
                return;
            }
            int f = nk1.f(pk1Var, this.a.i);
            if (f == 0) {
                this.a.h = pk1Var;
                om1 a = new wl1().a(this.a.c, lk1.a(pk1Var));
                if (a == null) {
                    if (this.a.d != null) {
                        this.a.d.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (!pk1Var.q()) {
                    this.a.a = a;
                    if (this.a.d != null) {
                        gk1 gk1Var = new gk1(a, this.a.d.g(), pk1Var);
                        gk1Var.m(this.a.d);
                        a.c(gk1Var);
                        a.a(gk1Var);
                        gk1Var.l(this.a);
                        this.a.k(!pk1Var.n());
                        this.a.n(!pk1Var.l());
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
                fk1 fk1Var = this.a.d;
                fk1Var.b("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public kk1(Context context, String str, yl1 yl1Var, fk1 fk1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, yl1Var, fk1Var};
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
        this.d = fk1Var;
        if (yl1Var != null && yl1Var.a() != null && yl1Var.a().containsKey("launch_type")) {
            try {
                this.i = Integer.parseInt(yl1Var.a().get("launch_type"));
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

    public void l(om1 om1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, om1Var) == null) {
            this.a = om1Var;
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.g = i;
        }
    }

    @Override // com.baidu.tieba.qm1
    @Nullable
    public pk1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return (pk1) invokeV.objValue;
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
                m(nk1.n(this.i));
                return;
            }
            dk1 dk1Var = new dk1();
            this.j = dk1Var;
            dk1Var.j(this.b, this.k);
        }
    }

    @Override // com.baidu.tieba.qm1
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

    public void m(pk1 pk1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, pk1Var) == null) {
            if (pk1Var != null) {
                this.h = pk1Var;
                xl1 a2 = lk1.a(pk1Var);
                om1 a3 = new wl1().a(this.c, a2);
                if (a3 == null) {
                    if (yj1.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    fk1 fk1Var = this.d;
                    if (fk1Var != null) {
                        fk1Var.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (pk1Var.q()) {
                    new BaseVM(this.h).c(null);
                    fk1 fk1Var2 = this.d;
                    if (fk1Var2 != null) {
                        fk1Var2.b("virtual order cannot show");
                        return;
                    }
                    return;
                } else {
                    this.a = a3;
                    fk1 fk1Var3 = this.d;
                    if (fk1Var3 != null) {
                        gk1 gk1Var = new gk1(a3, fk1Var3.g(), pk1Var);
                        gk1Var.m(this.d);
                        a3.c(gk1Var);
                        a3.a(gk1Var);
                        gk1Var.l(this);
                        k(!pk1Var.n());
                        n(!pk1Var.l());
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
            fk1 fk1Var4 = this.d;
            if (fk1Var4 != null) {
                fk1Var4.b("本地物料null");
            }
        }
    }

    public void o(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) == null) {
            om1 om1Var = this.a;
            if (viewGroup != null && om1Var != null) {
                om1Var.load();
                View adView = om1Var.getAdView();
                if (adView != null && adView.getParent() == null) {
                    viewGroup.addView(adView);
                    return;
                }
                i();
                fk1 fk1Var = this.d;
                if (fk1Var != null) {
                    fk1Var.f();
                    return;
                }
                return;
            }
            i();
            fk1 fk1Var2 = this.d;
            if (fk1Var2 != null) {
                fk1Var2.f();
            }
        }
    }
}
