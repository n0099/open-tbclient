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
/* loaded from: classes7.dex */
public class rj1 implements xl1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vl1 a;
    public String b;
    public final Context c;
    public final mj1 d;
    public q8.b e;
    public int f;
    public int g;
    public wj1 h;
    public int i;
    public kj1 j;
    public final lj1 k;

    /* loaded from: classes7.dex */
    public class a implements lj1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rj1 a;

        public a(rj1 rj1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rj1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rj1Var;
        }

        @Override // com.baidu.tieba.lj1
        public void a(Throwable th) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (this.a.e != null) {
                    this.a.e.onFailed();
                } else if (this.a.d != null) {
                    mj1 mj1Var = this.a.d;
                    if (th == null) {
                        message = "unKnow";
                    } else {
                        message = th.getMessage();
                    }
                    mj1Var.b(message);
                }
            }
        }

        @Override // com.baidu.tieba.lj1
        public void b(@NonNull wj1 wj1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wj1Var) != null) || q8.f().i()) {
                return;
            }
            int f = uj1.f(wj1Var, this.a.i);
            if (f == 0) {
                this.a.h = wj1Var;
                vl1 a = new dl1().a(this.a.c, sj1.a(wj1Var));
                if (a == null) {
                    if (this.a.d != null) {
                        this.a.d.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (!wj1Var.q()) {
                    this.a.a = a;
                    if (this.a.d != null) {
                        nj1 nj1Var = new nj1(a, this.a.d.g(), wj1Var);
                        nj1Var.m(this.a.d);
                        a.c(nj1Var);
                        a.a(nj1Var);
                        nj1Var.l(this.a);
                        this.a.k(!wj1Var.n());
                        this.a.n(!wj1Var.l());
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
                mj1 mj1Var = this.a.d;
                mj1Var.b("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public rj1(Context context, String str, fl1 fl1Var, mj1 mj1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, fl1Var, mj1Var};
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
        this.d = mj1Var;
        if (fl1Var != null && fl1Var.a() != null && fl1Var.a().containsKey("launch_type")) {
            try {
                this.i = Integer.parseInt(fl1Var.a().get("launch_type"));
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

    public void l(vl1 vl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, vl1Var) == null) {
            this.a = vl1Var;
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.g = i;
        }
    }

    @Override // com.baidu.tieba.xl1
    @Nullable
    public wj1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return (wj1) invokeV.objValue;
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
                m(uj1.n(this.i));
                return;
            }
            kj1 kj1Var = new kj1();
            this.j = kj1Var;
            kj1Var.j(this.b, this.k);
        }
    }

    @Override // com.baidu.tieba.xl1
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

    public void m(wj1 wj1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, wj1Var) == null) {
            if (wj1Var != null) {
                this.h = wj1Var;
                el1 a2 = sj1.a(wj1Var);
                vl1 a3 = new dl1().a(this.c, a2);
                if (a3 == null) {
                    if (fj1.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    mj1 mj1Var = this.d;
                    if (mj1Var != null) {
                        mj1Var.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (wj1Var.q()) {
                    new BaseVM(this.h).c(null);
                    mj1 mj1Var2 = this.d;
                    if (mj1Var2 != null) {
                        mj1Var2.b("virtual order cannot show");
                        return;
                    }
                    return;
                } else {
                    this.a = a3;
                    mj1 mj1Var3 = this.d;
                    if (mj1Var3 != null) {
                        nj1 nj1Var = new nj1(a3, mj1Var3.g(), wj1Var);
                        nj1Var.m(this.d);
                        a3.c(nj1Var);
                        a3.a(nj1Var);
                        nj1Var.l(this);
                        k(!wj1Var.n());
                        n(!wj1Var.l());
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
            mj1 mj1Var4 = this.d;
            if (mj1Var4 != null) {
                mj1Var4.b("本地物料null");
            }
        }
    }

    public void o(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) == null) {
            vl1 vl1Var = this.a;
            if (viewGroup != null && vl1Var != null) {
                vl1Var.load();
                View adView = vl1Var.getAdView();
                if (adView != null && adView.getParent() == null) {
                    viewGroup.addView(adView);
                    return;
                }
                i();
                mj1 mj1Var = this.d;
                if (mj1Var != null) {
                    mj1Var.f();
                    return;
                }
                return;
            }
            i();
            mj1 mj1Var2 = this.d;
            if (mj1Var2 != null) {
                mj1Var2.f();
            }
        }
    }
}
