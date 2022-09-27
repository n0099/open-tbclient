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
import com.baidu.tieba.x8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class wd1 implements lg1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jg1 a;
    public String b;
    public final Context c;
    public final rd1 d;
    public x8.b e;
    public int f;
    public int g;
    public be1 h;
    public int i;
    public pd1 j;
    public final qd1 k;

    /* loaded from: classes6.dex */
    public class a implements qd1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wd1 a;

        public a(wd1 wd1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wd1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wd1Var;
        }

        @Override // com.baidu.tieba.qd1
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (this.a.e != null) {
                    this.a.e.onFailed();
                } else if (this.a.d != null) {
                    this.a.d.b(th == null ? "unKnow" : th.getMessage());
                }
            }
        }

        @Override // com.baidu.tieba.qd1
        public void b(@NonNull be1 be1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, be1Var) == null) || x8.f().i()) {
                return;
            }
            int f = zd1.f(be1Var, this.a.i);
            if (f == 0) {
                this.a.h = be1Var;
                jg1 a = new rf1().a(this.a.c, xd1.a(be1Var));
                if (a == null) {
                    if (this.a.d != null) {
                        this.a.d.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                }
                this.a.a = a;
                if (this.a.d != null) {
                    sd1 sd1Var = new sd1(a, this.a.d.g(), be1Var);
                    sd1Var.l(this.a.d);
                    a.c(sd1Var);
                    a.a(sd1Var);
                    sd1Var.k(this.a);
                    this.a.j(!be1Var.i());
                    this.a.m(!be1Var.g());
                    this.a.d.e(this.a);
                }
                if (this.a.e != null) {
                    this.a.e.onSuccess();
                    return;
                }
                return;
            }
            if (this.a.e != null) {
                this.a.e.onFailed();
            } else if (this.a.d != null) {
                rd1 rd1Var = this.a.d;
                rd1Var.b("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public wd1(Context context, String str, tf1 tf1Var, rd1 rd1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, tf1Var, rd1Var};
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
        this.d = rd1Var;
        if (tf1Var == null || tf1Var.a() == null || !tf1Var.a().containsKey("launch_type")) {
            return;
        }
        try {
            this.i = Integer.parseInt(tf1Var.a().get("launch_type"));
        } catch (NumberFormatException unused) {
            this.i = 0;
        }
    }

    @Override // com.baidu.tieba.lg1
    @Nullable
    public be1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.h : (be1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lg1
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

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a == null) {
            return;
        }
        this.a = null;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!x8.f().h()) {
                l(zd1.p(this.i));
                return;
            }
            pd1 pd1Var = new pd1();
            this.j = pd1Var;
            pd1Var.j(this.b, this.k);
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f = i;
        }
    }

    public void k(jg1 jg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jg1Var) == null) {
            this.a = jg1Var;
        }
    }

    public void l(be1 be1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, be1Var) == null) {
            if (be1Var != null) {
                this.h = be1Var;
                sf1 a2 = xd1.a(be1Var);
                jg1 a3 = new rf1().a(this.c, a2);
                if (a3 == null) {
                    if (kd1.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    rd1 rd1Var = this.d;
                    if (rd1Var != null) {
                        rd1Var.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                }
                this.a = a3;
                rd1 rd1Var2 = this.d;
                if (rd1Var2 != null) {
                    sd1 sd1Var = new sd1(a3, rd1Var2.g(), be1Var);
                    sd1Var.l(this.d);
                    a3.c(sd1Var);
                    a3.a(sd1Var);
                    sd1Var.k(this);
                    j(!be1Var.i());
                    m(!be1Var.g());
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
            rd1 rd1Var3 = this.d;
            if (rd1Var3 != null) {
                rd1Var3.b("本地物料null");
            }
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
            jg1 jg1Var = this.a;
            if (viewGroup != null && jg1Var != null) {
                jg1Var.load();
                View adView = jg1Var.getAdView();
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
}
