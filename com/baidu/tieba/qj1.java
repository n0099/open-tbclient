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
import com.baidu.tieba.d9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class qj1 implements fm1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dm1 a;
    public String b;
    public final Context c;
    public final lj1 d;
    public d9.b e;
    public int f;
    public int g;
    public vj1 h;
    public int i;
    public jj1 j;
    public final kj1 k;

    /* loaded from: classes5.dex */
    public class a implements kj1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qj1 a;

        public a(qj1 qj1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qj1Var;
        }

        @Override // com.baidu.tieba.kj1
        public void a(Throwable th) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (this.a.e != null) {
                    this.a.e.onFailed();
                } else if (this.a.d != null) {
                    lj1 lj1Var = this.a.d;
                    if (th == null) {
                        message = "unKnow";
                    } else {
                        message = th.getMessage();
                    }
                    lj1Var.b(message);
                }
            }
        }

        @Override // com.baidu.tieba.kj1
        public void b(@NonNull vj1 vj1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vj1Var) != null) || d9.f().i()) {
                return;
            }
            int f = tj1.f(vj1Var, this.a.i);
            if (f == 0) {
                this.a.h = vj1Var;
                dm1 a = new ll1().a(this.a.c, rj1.a(vj1Var));
                if (a == null) {
                    if (this.a.d != null) {
                        this.a.d.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (!vj1Var.q()) {
                    this.a.a = a;
                    if (this.a.d != null) {
                        mj1 mj1Var = new mj1(a, this.a.d.g(), vj1Var);
                        mj1Var.m(this.a.d);
                        a.c(mj1Var);
                        a.a(mj1Var);
                        mj1Var.l(this.a);
                        this.a.k(!vj1Var.n());
                        this.a.n(!vj1Var.l());
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
                lj1 lj1Var = this.a.d;
                lj1Var.b("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public qj1(Context context, String str, nl1 nl1Var, lj1 lj1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, nl1Var, lj1Var};
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
        this.d = lj1Var;
        if (nl1Var != null && nl1Var.a() != null && nl1Var.a().containsKey("launch_type")) {
            try {
                this.i = Integer.parseInt(nl1Var.a().get("launch_type"));
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

    public void l(dm1 dm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dm1Var) == null) {
            this.a = dm1Var;
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.g = i;
        }
    }

    @Override // com.baidu.tieba.fm1
    @Nullable
    public vj1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return (vj1) invokeV.objValue;
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
            if (!d9.f().h()) {
                m(tj1.n(this.i));
                return;
            }
            jj1 jj1Var = new jj1();
            this.j = jj1Var;
            jj1Var.j(this.b, this.k);
        }
    }

    @Override // com.baidu.tieba.fm1
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

    public void m(vj1 vj1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vj1Var) == null) {
            if (vj1Var != null) {
                this.h = vj1Var;
                ml1 a2 = rj1.a(vj1Var);
                dm1 a3 = new ll1().a(this.c, a2);
                if (a3 == null) {
                    if (ej1.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    lj1 lj1Var = this.d;
                    if (lj1Var != null) {
                        lj1Var.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (vj1Var.q()) {
                    new BaseVM(this.h).c(null);
                    lj1 lj1Var2 = this.d;
                    if (lj1Var2 != null) {
                        lj1Var2.b("virtual order cannot show");
                        return;
                    }
                    return;
                } else {
                    this.a = a3;
                    lj1 lj1Var3 = this.d;
                    if (lj1Var3 != null) {
                        mj1 mj1Var = new mj1(a3, lj1Var3.g(), vj1Var);
                        mj1Var.m(this.d);
                        a3.c(mj1Var);
                        a3.a(mj1Var);
                        mj1Var.l(this);
                        k(!vj1Var.n());
                        n(!vj1Var.l());
                        this.d.e(this);
                    }
                    d9.b bVar = this.e;
                    if (bVar != null) {
                        bVar.onSuccess();
                        return;
                    }
                    return;
                }
            }
            d9.b bVar2 = this.e;
            if (bVar2 != null) {
                bVar2.onFailed();
                return;
            }
            lj1 lj1Var4 = this.d;
            if (lj1Var4 != null) {
                lj1Var4.b("本地物料null");
            }
        }
    }

    public void o(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) == null) {
            dm1 dm1Var = this.a;
            if (viewGroup != null && dm1Var != null) {
                dm1Var.load();
                View adView = dm1Var.getAdView();
                if (adView != null && adView.getParent() == null) {
                    viewGroup.addView(adView);
                    return;
                }
                i();
                lj1 lj1Var = this.d;
                if (lj1Var != null) {
                    lj1Var.f();
                    return;
                }
                return;
            }
            i();
            lj1 lj1Var2 = this.d;
            if (lj1Var2 != null) {
                lj1Var2.f();
            }
        }
    }
}
