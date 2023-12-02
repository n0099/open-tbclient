package com.baidu.tieba;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class se1 implements zg1, bh1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final ah1 a;
    @NonNull
    public ViewGroup b;
    @NonNull
    public final bf1 c;
    @NonNull
    public final BaseVM d;
    @Nullable
    public re1 e;
    public long f;
    public long g;
    public final long h;
    public long i;
    public boolean j;
    public we1 k;

    @Override // com.baidu.tieba.zg1
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.tieba.zg1
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.baidu.tieba.zg1
    public void onPrivacyClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements ff1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ se1 a;

        @Override // com.baidu.tieba.ff1
        public void handleSchemeDispatchCallback(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            }
        }

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

        @Override // com.baidu.tieba.ff1
        public boolean b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (this.a.e != null) {
                    return this.a.e.b(str);
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ se1 a;

        public b(se1 se1Var) {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e.c();
            }
        }
    }

    public se1(@NonNull ah1 ah1Var, @NonNull ViewGroup viewGroup, @NonNull bf1 bf1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ah1Var, viewGroup, bf1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = true;
        this.h = System.currentTimeMillis();
        this.a = ah1Var;
        this.b = viewGroup;
        this.c = bf1Var;
        this.d = new BaseVM(bf1Var);
        ve1.b(bf1Var);
    }

    public final void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.i = System.currentTimeMillis() - this.f;
            e4.f().e();
            if (!this.j) {
                return;
            }
            this.j = false;
            this.d.e(str, this.i);
        }
    }

    public void j(we1 we1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, we1Var) == null) {
            this.k = we1Var;
            ah1 ah1Var = this.a;
            if (ah1Var != null) {
                we1Var.l(ah1Var);
            }
        }
    }

    public void k(@NonNull re1 re1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, re1Var) == null) {
            this.e = re1Var;
        }
    }

    @Override // com.baidu.tieba.bh1
    public void onAdError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.i = System.currentTimeMillis() - this.f;
            re1 re1Var = this.e;
            if (re1Var != null) {
                re1Var.e();
            }
        }
    }

    @Override // com.baidu.tieba.bh1
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.g = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.zg1
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            re1 re1Var = this.e;
            if (re1Var != null) {
                re1Var.onSkip();
            }
            h(BaseVM.CloseType.CLICK_SKIP_BUTTON.value);
        }
    }

    @Override // com.baidu.tieba.bh1
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("adShowScene", this.c.D);
                jSONObject.put("adSplashType", this.c.e);
                if (this.c.D == 1) {
                    long j = this.g - this.h;
                    if (j > 0) {
                        jSONObject.put("adLoadCostTime", j);
                    }
                }
                jSONObject.put("adRenderCostTime", this.f - this.h);
                long currentTimeMillis = System.currentTimeMillis();
                jSONObject.put("show_time", currentTimeMillis);
                i(currentTimeMillis);
            } catch (JSONException unused) {
            }
            this.d.c(jSONObject);
            ze1.D(this.c);
            df1.e(this.c);
            re1 re1Var = this.e;
            if (re1Var != null) {
                re1Var.onAdShow();
            }
        }
    }

    @Override // com.baidu.tieba.zg1
    public void onAdClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (af1.s() && !TextUtils.isEmpty(this.c.p)) {
                qe0.b(this.c.p);
                if (qc0.a) {
                    y01.a().showToast(this.a.a().getContext(), "执行nad统一新协议跳转");
                }
            } else {
                if1.a(hf0.b(), this.c.o, new a(this));
                if (qc0.a) {
                    y01.a().showToast(this.a.a().getContext(), "执行splash旧协议跳转");
                }
            }
            h(BaseVM.CloseType.CLICK_AD_AREA.value);
            this.d.b("");
            re1 re1Var = this.e;
            if (re1Var != null) {
                re1Var.onAdClick();
            }
        }
    }

    @Override // com.baidu.tieba.bh1
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.i = System.currentTimeMillis() - this.f;
            if ("time_end".equals(str)) {
                h(BaseVM.CloseType.COUNTDOWN_TIME_FINISH.value);
            } else if ("click_skip_button".equals(str)) {
                h(BaseVM.CloseType.CLICK_SKIP_BUTTON.value);
            } else if ("click_ad_area".equals(str)) {
                h(BaseVM.CloseType.CLICK_AD_AREA.value);
            } else {
                h(BaseVM.CloseType.OTHER.value);
            }
            if (this.e != null) {
                wf0.c(new b(this));
            }
        }
    }

    public final void i(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            String str = this.c.p;
            if (!TextUtils.isEmpty(str)) {
                this.c.p = str.replace("SplashShowTime", String.valueOf(j));
            }
            String str2 = this.c.O;
            if (!TextUtils.isEmpty(str2)) {
                this.c.O = str2.replace("SplashShowTime", String.valueOf(j));
            }
        }
    }
}
