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
import com.baidu.tieba.e4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class se1 implements yg1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wg1 a;
    public String b;
    public final Context c;
    public final ne1 d;
    public e4.b e;
    public int f;
    public int g;
    public xe1 h;
    public int i;
    public le1 j;
    public final me1 k;

    /* loaded from: classes8.dex */
    public class a implements me1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ se1 a;

        public a(se1 se1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {se1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = se1Var;
        }

        @Override // com.baidu.tieba.me1
        public void a(Throwable th) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (this.a.e != null) {
                    this.a.e.onFailed();
                } else if (this.a.d != null) {
                    ne1 ne1Var = this.a.d;
                    if (th == null) {
                        message = "unKnow";
                    } else {
                        message = th.getMessage();
                    }
                    ne1Var.a(message);
                }
            }
        }

        @Override // com.baidu.tieba.me1
        public void b(@NonNull xe1 xe1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xe1Var) != null) || e4.f().i()) {
                return;
            }
            int f = ve1.f(xe1Var, this.a.i);
            if (f == 0) {
                this.a.h = xe1Var;
                wg1 a = new eg1().a(this.a.c, te1.a(xe1Var));
                if (a == null) {
                    if (this.a.d != null) {
                        this.a.d.a("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (!xe1Var.q()) {
                    this.a.a = a;
                    if (this.a.d != null) {
                        oe1 oe1Var = new oe1(a, this.a.d.f(), xe1Var);
                        oe1Var.k(this.a.d);
                        a.c(oe1Var);
                        a.b(oe1Var);
                        oe1Var.j(this.a);
                        this.a.k(!xe1Var.n());
                        this.a.n(!xe1Var.l());
                        this.a.d.d(this.a);
                    }
                    if (this.a.e != null) {
                        this.a.e.onSuccess();
                        return;
                    }
                    return;
                } else {
                    new BaseVM(this.a.h).c(null);
                    if (this.a.d != null) {
                        this.a.d.a("virtual order cannot show");
                        return;
                    }
                    return;
                }
            }
            if (this.a.e != null) {
                this.a.e.onFailed();
            } else if (this.a.d != null) {
                ne1 ne1Var = this.a.d;
                ne1Var.a("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public se1(Context context, String str, gg1 gg1Var, ne1 ne1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, gg1Var, ne1Var};
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
        this.d = ne1Var;
        if (gg1Var != null && gg1Var.a() != null && gg1Var.a().containsKey("launch_type")) {
            try {
                this.i = Integer.parseInt(gg1Var.a().get("launch_type"));
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

    public void l(wg1 wg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, wg1Var) == null) {
            this.a = wg1Var;
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.g = i;
        }
    }

    @Override // com.baidu.tieba.yg1
    @Nullable
    public xe1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return (xe1) invokeV.objValue;
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
            if (!e4.f().h()) {
                m(ve1.n(this.i));
                return;
            }
            le1 le1Var = new le1();
            this.j = le1Var;
            le1Var.j(this.b, this.k);
        }
    }

    @Override // com.baidu.tieba.yg1
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

    public void m(xe1 xe1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, xe1Var) == null) {
            if (xe1Var != null) {
                this.h = xe1Var;
                fg1 a2 = te1.a(xe1Var);
                wg1 a3 = new eg1().a(this.c, a2);
                if (a3 == null) {
                    if (ge1.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    ne1 ne1Var = this.d;
                    if (ne1Var != null) {
                        ne1Var.a("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (xe1Var.q()) {
                    new BaseVM(this.h).c(null);
                    ne1 ne1Var2 = this.d;
                    if (ne1Var2 != null) {
                        ne1Var2.a("virtual order cannot show");
                        return;
                    }
                    return;
                } else {
                    this.a = a3;
                    ne1 ne1Var3 = this.d;
                    if (ne1Var3 != null) {
                        oe1 oe1Var = new oe1(a3, ne1Var3.f(), xe1Var);
                        oe1Var.k(this.d);
                        a3.c(oe1Var);
                        a3.b(oe1Var);
                        oe1Var.j(this);
                        k(!xe1Var.n());
                        n(!xe1Var.l());
                        this.d.d(this);
                    }
                    e4.b bVar = this.e;
                    if (bVar != null) {
                        bVar.onSuccess();
                        return;
                    }
                    return;
                }
            }
            e4.b bVar2 = this.e;
            if (bVar2 != null) {
                bVar2.onFailed();
                return;
            }
            ne1 ne1Var4 = this.d;
            if (ne1Var4 != null) {
                ne1Var4.a("本地物料null");
            }
        }
    }

    public void o(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) == null) {
            wg1 wg1Var = this.a;
            if (viewGroup != null && wg1Var != null) {
                wg1Var.load();
                View a2 = wg1Var.a();
                if (a2 != null && a2.getParent() == null) {
                    viewGroup.addView(a2);
                    return;
                }
                i();
                ne1 ne1Var = this.d;
                if (ne1Var != null) {
                    ne1Var.e();
                    return;
                }
                return;
            }
            i();
            ne1 ne1Var2 = this.d;
            if (ne1Var2 != null) {
                ne1Var2.e();
            }
        }
    }
}
