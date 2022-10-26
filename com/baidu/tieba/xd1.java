package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.sdk.container.interfaces.LoadState;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.x8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class xd1 implements mg1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kg1 a;
    public String b;
    public final Context c;
    public final sd1 d;
    public x8.b e;
    public int f;
    public int g;
    public ce1 h;
    public int i;
    public qd1 j;
    public final rd1 k;

    /* loaded from: classes6.dex */
    public class a implements rd1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xd1 a;

        public a(xd1 xd1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xd1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xd1Var;
        }

        @Override // com.baidu.tieba.rd1
        public void a(Throwable th) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (this.a.e != null) {
                    this.a.e.onFailed();
                } else if (this.a.d == null) {
                } else {
                    sd1 sd1Var = this.a.d;
                    if (th == null) {
                        message = "unKnow";
                    } else {
                        message = th.getMessage();
                    }
                    sd1Var.b(message);
                }
            }
        }

        @Override // com.baidu.tieba.rd1
        public void b(ce1 ce1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ce1Var) != null) || x8.f().i()) {
                return;
            }
            int f = ae1.f(ce1Var, this.a.i);
            if (f == 0) {
                this.a.h = ce1Var;
                kg1 a = new sf1().a(this.a.c, yd1.a(ce1Var));
                if (a != null) {
                    this.a.a = a;
                    if (this.a.d != null) {
                        td1 td1Var = new td1(a, this.a.d.g(), ce1Var);
                        td1Var.l(this.a.d);
                        a.c(td1Var);
                        a.a(td1Var);
                        td1Var.k(this.a);
                        this.a.j(!ce1Var.i());
                        this.a.m(!ce1Var.g());
                        this.a.d.e(this.a);
                    }
                    if (this.a.e != null) {
                        this.a.e.onSuccess();
                        return;
                    }
                    return;
                } else if (this.a.d != null) {
                    this.a.d.b("创建 AdContainer 失败");
                    return;
                } else {
                    return;
                }
            }
            if (this.a.e != null) {
                this.a.e.onFailed();
            } else if (this.a.d != null) {
                sd1 sd1Var = this.a.d;
                sd1Var.b("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public xd1(Context context, String str, uf1 uf1Var, sd1 sd1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, uf1Var, sd1Var};
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
        this.d = sd1Var;
        if (uf1Var != null && uf1Var.a() != null && uf1Var.a().containsKey("launch_type")) {
            try {
                this.i = Integer.parseInt((String) uf1Var.a().get("launch_type"));
            } catch (NumberFormatException unused) {
                this.i = 0;
            }
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f = i;
        }
    }

    public void k(kg1 kg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, kg1Var) == null) {
            this.a = kg1Var;
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.g = i;
        }
    }

    public void n(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) == null) {
            kg1 kg1Var = this.a;
            if (viewGroup != null && kg1Var != null) {
                kg1Var.load();
                View adView = kg1Var.getAdView();
                if (adView != null && adView.getParent() == null) {
                    viewGroup.addView(adView);
                    return;
                } else {
                    h();
                    return;
                }
            }
            h();
        }
    }

    @Override // com.baidu.tieba.mg1
    public ce1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return (ce1) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a != null) {
            this.a = null;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!x8.f().h()) {
                l(ae1.p(this.i));
                return;
            }
            qd1 qd1Var = new qd1();
            this.j = qd1Var;
            qd1Var.j(this.b, this.k);
        }
    }

    @Override // com.baidu.tieba.mg1
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

    public void l(ce1 ce1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ce1Var) == null) {
            if (ce1Var != null) {
                this.h = ce1Var;
                tf1 a2 = yd1.a(ce1Var);
                kg1 a3 = new sf1().a(this.c, a2);
                if (a3 == null) {
                    if (((ld1) ld1.a.get()).a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    sd1 sd1Var = this.d;
                    if (sd1Var != null) {
                        sd1Var.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                }
                this.a = a3;
                sd1 sd1Var2 = this.d;
                if (sd1Var2 != null) {
                    td1 td1Var = new td1(a3, sd1Var2.g(), ce1Var);
                    td1Var.l(this.d);
                    a3.c(td1Var);
                    a3.a(td1Var);
                    td1Var.k(this);
                    j(!ce1Var.i());
                    m(!ce1Var.g());
                    this.d.e(this);
                }
                x8.b bVar = this.e;
                if (bVar != null) {
                    bVar.onSuccess();
                    return;
                }
                return;
            }
            x8.b bVar2 = this.e;
            if (bVar2 != null) {
                bVar2.onFailed();
                return;
            }
            sd1 sd1Var3 = this.d;
            if (sd1Var3 != null) {
                sd1Var3.b("本地物料null");
            }
        }
    }
}
