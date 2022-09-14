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
/* loaded from: classes4.dex */
public class jd1 implements yf1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wf1 a;
    public String b;
    public final Context c;
    public final ed1 d;
    public x8.b e;
    public int f;
    public int g;
    public od1 h;
    public int i;
    public cd1 j;
    public final dd1 k;

    /* loaded from: classes4.dex */
    public class a implements dd1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jd1 a;

        public a(jd1 jd1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jd1Var;
        }

        @Override // com.baidu.tieba.dd1
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

        @Override // com.baidu.tieba.dd1
        public void b(@NonNull od1 od1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, od1Var) == null) || x8.f().i()) {
                return;
            }
            int f = md1.f(od1Var, this.a.i);
            if (f == 0) {
                this.a.h = od1Var;
                wf1 a = new ef1().a(this.a.c, kd1.a(od1Var));
                if (a == null) {
                    if (this.a.d != null) {
                        this.a.d.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                }
                this.a.a = a;
                if (this.a.d != null) {
                    fd1 fd1Var = new fd1(a, this.a.d.g(), od1Var);
                    fd1Var.l(this.a.d);
                    a.c(fd1Var);
                    a.a(fd1Var);
                    fd1Var.k(this.a);
                    this.a.j(!od1Var.i());
                    this.a.m(!od1Var.g());
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
                ed1 ed1Var = this.a.d;
                ed1Var.b("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public jd1(Context context, String str, gf1 gf1Var, ed1 ed1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, gf1Var, ed1Var};
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
        this.d = ed1Var;
        if (gf1Var == null || gf1Var.a() == null || !gf1Var.a().containsKey("launch_type")) {
            return;
        }
        try {
            this.i = Integer.parseInt(gf1Var.a().get("launch_type"));
        } catch (NumberFormatException unused) {
            this.i = 0;
        }
    }

    @Override // com.baidu.tieba.yf1
    @Nullable
    public od1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.h : (od1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yf1
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
                l(md1.p(this.i));
                return;
            }
            cd1 cd1Var = new cd1();
            this.j = cd1Var;
            cd1Var.j(this.b, this.k);
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f = i;
        }
    }

    public void k(wf1 wf1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, wf1Var) == null) {
            this.a = wf1Var;
        }
    }

    public void l(od1 od1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, od1Var) == null) {
            if (od1Var != null) {
                this.h = od1Var;
                ff1 a2 = kd1.a(od1Var);
                wf1 a3 = new ef1().a(this.c, a2);
                if (a3 == null) {
                    if (xc1.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    ed1 ed1Var = this.d;
                    if (ed1Var != null) {
                        ed1Var.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                }
                this.a = a3;
                ed1 ed1Var2 = this.d;
                if (ed1Var2 != null) {
                    fd1 fd1Var = new fd1(a3, ed1Var2.g(), od1Var);
                    fd1Var.l(this.d);
                    a3.c(fd1Var);
                    a3.a(fd1Var);
                    fd1Var.k(this);
                    j(!od1Var.i());
                    m(!od1Var.g());
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
            ed1 ed1Var3 = this.d;
            if (ed1Var3 != null) {
                ed1Var3.b("本地物料null");
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
            wf1 wf1Var = this.a;
            if (viewGroup != null && wf1Var != null) {
                wf1Var.load();
                View adView = wf1Var.getAdView();
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
