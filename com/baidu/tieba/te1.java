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
public class te1 implements zg1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xg1 a;
    public String b;
    public final Context c;
    public final oe1 d;
    public e4.b e;
    public int f;
    public int g;
    public ye1 h;
    public int i;
    public me1 j;
    public final ne1 k;

    /* loaded from: classes8.dex */
    public class a implements ne1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ te1 a;

        public a(te1 te1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {te1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = te1Var;
        }

        @Override // com.baidu.tieba.ne1
        public void a(Throwable th) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (this.a.e != null) {
                    this.a.e.onFailed();
                } else if (this.a.d != null) {
                    oe1 oe1Var = this.a.d;
                    if (th == null) {
                        message = "unKnow";
                    } else {
                        message = th.getMessage();
                    }
                    oe1Var.a(message);
                }
            }
        }

        @Override // com.baidu.tieba.ne1
        public void b(@NonNull ye1 ye1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ye1Var) != null) || e4.f().i()) {
                return;
            }
            int f = we1.f(ye1Var, this.a.i);
            if (f == 0) {
                this.a.h = ye1Var;
                xg1 a = new fg1().a(this.a.c, ue1.a(ye1Var));
                if (a == null) {
                    if (this.a.d != null) {
                        this.a.d.a("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (!ye1Var.q()) {
                    this.a.a = a;
                    if (this.a.d != null) {
                        pe1 pe1Var = new pe1(a, this.a.d.f(), ye1Var);
                        pe1Var.k(this.a.d);
                        a.c(pe1Var);
                        a.b(pe1Var);
                        pe1Var.j(this.a);
                        this.a.k(!ye1Var.n());
                        this.a.n(!ye1Var.l());
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
                oe1 oe1Var = this.a.d;
                oe1Var.a("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public te1(Context context, String str, hg1 hg1Var, oe1 oe1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, hg1Var, oe1Var};
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
        this.d = oe1Var;
        if (hg1Var != null && hg1Var.a() != null && hg1Var.a().containsKey("launch_type")) {
            try {
                this.i = Integer.parseInt(hg1Var.a().get("launch_type"));
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

    public void l(xg1 xg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, xg1Var) == null) {
            this.a = xg1Var;
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.g = i;
        }
    }

    @Override // com.baidu.tieba.zg1
    @Nullable
    public ye1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return (ye1) invokeV.objValue;
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
                m(we1.n(this.i));
                return;
            }
            me1 me1Var = new me1();
            this.j = me1Var;
            me1Var.j(this.b, this.k);
        }
    }

    @Override // com.baidu.tieba.zg1
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

    public void m(ye1 ye1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ye1Var) == null) {
            if (ye1Var != null) {
                this.h = ye1Var;
                gg1 a2 = ue1.a(ye1Var);
                xg1 a3 = new fg1().a(this.c, a2);
                if (a3 == null) {
                    if (he1.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    oe1 oe1Var = this.d;
                    if (oe1Var != null) {
                        oe1Var.a("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (ye1Var.q()) {
                    new BaseVM(this.h).c(null);
                    oe1 oe1Var2 = this.d;
                    if (oe1Var2 != null) {
                        oe1Var2.a("virtual order cannot show");
                        return;
                    }
                    return;
                } else {
                    this.a = a3;
                    oe1 oe1Var3 = this.d;
                    if (oe1Var3 != null) {
                        pe1 pe1Var = new pe1(a3, oe1Var3.f(), ye1Var);
                        pe1Var.k(this.d);
                        a3.c(pe1Var);
                        a3.b(pe1Var);
                        pe1Var.j(this);
                        k(!ye1Var.n());
                        n(!ye1Var.l());
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
            oe1 oe1Var4 = this.d;
            if (oe1Var4 != null) {
                oe1Var4.a("本地物料null");
            }
        }
    }

    public void o(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) == null) {
            xg1 xg1Var = this.a;
            if (viewGroup != null && xg1Var != null) {
                xg1Var.load();
                View a2 = xg1Var.a();
                if (a2 != null && a2.getParent() == null) {
                    viewGroup.addView(a2);
                    return;
                }
                i();
                oe1 oe1Var = this.d;
                if (oe1Var != null) {
                    oe1Var.e();
                    return;
                }
                return;
            }
            i();
            oe1 oe1Var2 = this.d;
            if (oe1Var2 != null) {
                oe1Var2.e();
            }
        }
    }
}
