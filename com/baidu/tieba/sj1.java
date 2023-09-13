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
import com.baidu.tieba.q8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class sj1 implements yl1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wl1 a;
    public String b;
    public final Context c;
    public final nj1 d;
    public q8.b e;
    public int f;
    public int g;
    public xj1 h;
    public int i;
    public lj1 j;
    public final mj1 k;

    /* loaded from: classes8.dex */
    public class a implements mj1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sj1 a;

        public a(sj1 sj1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sj1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sj1Var;
        }

        @Override // com.baidu.tieba.mj1
        public void a(Throwable th) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (this.a.e != null) {
                    this.a.e.onFailed();
                } else if (this.a.d != null) {
                    nj1 nj1Var = this.a.d;
                    if (th == null) {
                        message = "unKnow";
                    } else {
                        message = th.getMessage();
                    }
                    nj1Var.b(message);
                }
            }
        }

        @Override // com.baidu.tieba.mj1
        public void b(@NonNull xj1 xj1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xj1Var) != null) || q8.f().i()) {
                return;
            }
            int f = vj1.f(xj1Var, this.a.i);
            if (f == 0) {
                this.a.h = xj1Var;
                wl1 a = new el1().a(this.a.c, tj1.a(xj1Var));
                if (a == null) {
                    if (this.a.d != null) {
                        this.a.d.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (!xj1Var.q()) {
                    this.a.a = a;
                    if (this.a.d != null) {
                        oj1 oj1Var = new oj1(a, this.a.d.g(), xj1Var);
                        oj1Var.m(this.a.d);
                        a.c(oj1Var);
                        a.a(oj1Var);
                        oj1Var.l(this.a);
                        this.a.k(!xj1Var.n());
                        this.a.n(!xj1Var.l());
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
                nj1 nj1Var = this.a.d;
                nj1Var.b("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public sj1(Context context, String str, gl1 gl1Var, nj1 nj1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, gl1Var, nj1Var};
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
        this.d = nj1Var;
        if (gl1Var != null && gl1Var.a() != null && gl1Var.a().containsKey("launch_type")) {
            try {
                this.i = Integer.parseInt(gl1Var.a().get("launch_type"));
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

    public void l(wl1 wl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, wl1Var) == null) {
            this.a = wl1Var;
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.g = i;
        }
    }

    @Override // com.baidu.tieba.yl1
    @Nullable
    public xj1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return (xj1) invokeV.objValue;
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
            if (!q8.f().h()) {
                m(vj1.n(this.i));
                return;
            }
            lj1 lj1Var = new lj1();
            this.j = lj1Var;
            lj1Var.j(this.b, this.k);
        }
    }

    @Override // com.baidu.tieba.yl1
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

    public void m(xj1 xj1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, xj1Var) == null) {
            if (xj1Var != null) {
                this.h = xj1Var;
                fl1 a2 = tj1.a(xj1Var);
                wl1 a3 = new el1().a(this.c, a2);
                if (a3 == null) {
                    if (gj1.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    nj1 nj1Var = this.d;
                    if (nj1Var != null) {
                        nj1Var.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (xj1Var.q()) {
                    new BaseVM(this.h).c(null);
                    nj1 nj1Var2 = this.d;
                    if (nj1Var2 != null) {
                        nj1Var2.b("virtual order cannot show");
                        return;
                    }
                    return;
                } else {
                    this.a = a3;
                    nj1 nj1Var3 = this.d;
                    if (nj1Var3 != null) {
                        oj1 oj1Var = new oj1(a3, nj1Var3.g(), xj1Var);
                        oj1Var.m(this.d);
                        a3.c(oj1Var);
                        a3.a(oj1Var);
                        oj1Var.l(this);
                        k(!xj1Var.n());
                        n(!xj1Var.l());
                        this.d.e(this);
                    }
                    q8.b bVar = this.e;
                    if (bVar != null) {
                        bVar.onSuccess();
                        return;
                    }
                    return;
                }
            }
            q8.b bVar2 = this.e;
            if (bVar2 != null) {
                bVar2.onFailed();
                return;
            }
            nj1 nj1Var4 = this.d;
            if (nj1Var4 != null) {
                nj1Var4.b("本地物料null");
            }
        }
    }

    public void o(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) == null) {
            wl1 wl1Var = this.a;
            if (viewGroup != null && wl1Var != null) {
                wl1Var.load();
                View adView = wl1Var.getAdView();
                if (adView != null && adView.getParent() == null) {
                    viewGroup.addView(adView);
                    return;
                }
                i();
                nj1 nj1Var = this.d;
                if (nj1Var != null) {
                    nj1Var.f();
                    return;
                }
                return;
            }
            i();
            nj1 nj1Var2 = this.d;
            if (nj1Var2 != null) {
                nj1Var2.f();
            }
        }
    }
}
