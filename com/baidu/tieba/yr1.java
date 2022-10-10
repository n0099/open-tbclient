package com.baidu.tieba;

import android.app.Activity;
import android.database.ContentObserver;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.bt2;
import com.baidu.tieba.r22;
import com.baidu.tieba.wr1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes6.dex */
public class yr1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yr1 i;
    public transient /* synthetic */ FieldHolder $fh;
    public PopupWindow a;
    public Timer b;
    public SwanAppActivity c;
    public r22 d;
    public ContentObserver e;
    public ig2 f;
    public wr1 g;
    public j h;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType a;
        public final /* synthetic */ yr1 b;

        public a(yr1 yr1Var, ShowFavoriteGuideApi.GuideType guideType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr1Var, guideType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yr1Var;
            this.a = guideType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.k();
                if (this.b.h != null) {
                    this.b.h.e(false);
                }
                ShowFavoriteGuideApi.F(this.a, "flow_close_close", "click");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ yr1 c;

        /* loaded from: classes6.dex */
        public class a implements bt2.h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // com.baidu.tieba.bt2.h
            public void onFail() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a.c.h != null) {
                        this.a.c.h.e(false);
                    }
                    l02.i("FavoriteGuideHelper", "add favorite result=false");
                }
            }

            @Override // com.baidu.tieba.bt2.h
            public void onSuccess() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    if (this.a.c.h != null) {
                        this.a.c.h.e(true);
                    }
                    l02.i("FavoriteGuideHelper", "add favorite result=true");
                }
            }
        }

        public b(yr1 yr1Var, ShowFavoriteGuideApi.GuideType guideType, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr1Var, guideType, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = yr1Var;
            this.a = guideType;
            this.b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                bt2.h(this.b, new a(this));
                this.c.k();
                if (this.c.b != null) {
                    this.c.b.cancel();
                }
                ShowFavoriteGuideApi.GuideType guideType = this.a;
                ShowFavoriteGuideApi.F(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", "click");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewTreeObserver a;
        public final /* synthetic */ u22 b;
        public final /* synthetic */ t22 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ l33 e;
        public final /* synthetic */ yr1 f;

        public c(yr1 yr1Var, ViewTreeObserver viewTreeObserver, u22 u22Var, t22 t22Var, String str, l33 l33Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr1Var, viewTreeObserver, u22Var, t22Var, str, l33Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = yr1Var;
            this.a = viewTreeObserver;
            this.b = u22Var;
            this.c = t22Var;
            this.d = str;
            this.e = l33Var;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            t22 t22Var;
            ViewTreeObserver viewTreeObserver;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f.a != null || (viewTreeObserver = this.a) == null || !viewTreeObserver.isAlive()) {
                    if (this.f.d != this.b.m() || (!((t22Var = this.c) == null || TextUtils.equals(this.d, t22Var.t3())) || (!this.e.w0() && ch3.J()))) {
                        this.f.k();
                        ViewTreeObserver viewTreeObserver2 = this.a;
                        if (viewTreeObserver2 == null || !viewTreeObserver2.isAlive()) {
                            return;
                        }
                        this.a.removeOnGlobalLayoutListener(this);
                        return;
                    }
                    return;
                }
                this.a.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l33 a;
        public final /* synthetic */ yr1 b;

        public d(yr1 yr1Var, l33 l33Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr1Var, l33Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yr1Var;
            this.a = l33Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.k();
                if (this.b.h != null) {
                    this.b.h.e(ja2.n(this.a.b));
                }
                if (this.b.b != null) {
                    this.b.b.cancel();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements wr1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yr1 a;

        public e(yr1 yr1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yr1Var;
        }

        @Override // com.baidu.tieba.wr1.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k();
            }
        }

        @Override // com.baidu.tieba.wr1.a
        public void b(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && i == 1) {
                this.a.k();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l33 a;
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType b;
        public final /* synthetic */ yr1 c;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && ja2.n(this.a.a.b)) {
                    f fVar = this.a;
                    if (fVar.b == ShowFavoriteGuideApi.GuideType.NORMAL && fVar.c.h != null) {
                        this.a.c.h.e(true);
                    }
                    this.a.c.k();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(yr1 yr1Var, Handler handler, l33 l33Var, ShowFavoriteGuideApi.GuideType guideType) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr1Var, handler, l33Var, guideType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Handler) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = yr1Var;
            this.a = l33Var;
            this.b = guideType;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.onChange(z);
                fg3.h().execute(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends ig2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l33 a;
        public final /* synthetic */ yr1 b;

        public g(yr1 yr1Var, l33 l33Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr1Var, l33Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yr1Var;
            this.a = l33Var;
        }

        @Override // com.baidu.tieba.ig2, com.baidu.tieba.jg2
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a != null && this.b.a.x()) {
                this.b.k();
            }
        }

        @Override // com.baidu.tieba.ig2, com.baidu.tieba.jg2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                l02.i("FavoriteGuideHelper", "call onActivityDestroyed");
                this.b.k();
                if (this.b.c == null || this.b.f == null) {
                    return;
                }
                this.b.c.F0(this.b.f);
            }
        }

        @Override // com.baidu.tieba.ig2, com.baidu.tieba.jg2
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.e();
                l02.i("FavoriteGuideHelper", "swanId=" + this.a.b + ", nowId=" + l33.g0());
                if (TextUtils.equals(this.a.b, l33.g0())) {
                    return;
                }
                this.b.k();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements r22.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yr1 a;

        public h(yr1 yr1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yr1Var;
        }

        @Override // com.baidu.tieba.r22.p
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yr1 a;

        public i(yr1 yr1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yr1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.a != null) {
                    this.a.a.r();
                    this.a.a = null;
                }
                if (this.a.e != null) {
                    AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(this.a.e);
                    this.a.e = null;
                }
                if (this.a.c != null && this.a.f != null) {
                    this.a.c.F0(this.a.f);
                }
                if (this.a.d != null) {
                    this.a.d.F2(null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface j {
        void e(boolean z);
    }

    public yr1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static yr1 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (i == null) {
                synchronized (yr1.class) {
                    if (i == null) {
                        i = new yr1();
                    }
                }
            }
            return i;
        }
        return (yr1) invokeV.objValue;
    }

    @AnyThread
    public final synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                fh3.e0(new i(this));
            }
        }
    }

    public final void m() {
        xk1 k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.g == null && (k = tm2.k()) != null) {
            wr1 xk1Var = k.getInstance();
            this.g = xk1Var;
            if (xk1Var != null) {
                xk1Var.a(new e(this));
            }
        }
    }

    public boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? TextUtils.isEmpty(str) || ShowFavoriteGuideApi.GuideType.parse(str) == ShowFavoriteGuideApi.GuideType.NORMAL : invokeL.booleanValue;
    }

    public final synchronized void o(@NonNull Activity activity, @NonNull l33 l33Var, ShowFavoriteGuideApi.GuideType guideType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, l33Var, guideType) == null) {
            synchronized (this) {
                this.e = new f(this, null, l33Var, guideType);
                AppRuntime.getAppContext().getContentResolver().registerContentObserver(ja2.d(), false, this.e);
                if (activity instanceof SwanAppActivity) {
                    SwanAppActivity swanAppActivity = (SwanAppActivity) activity;
                    this.c = swanAppActivity;
                    if (this.f != null) {
                        swanAppActivity.F0(this.f);
                    }
                    g gVar = new g(this, l33Var);
                    this.f = gVar;
                    this.c.t0(gVar);
                }
                u22 X = this.c.X();
                if (X == null) {
                    return;
                }
                r22 m = X.m();
                this.d = m;
                if (m == null) {
                    return;
                }
                m.F2(new h(this));
            }
        }
    }

    @UiThread
    public void p(@Nullable j jVar, @NonNull Activity activity, @NonNull l33 l33Var, @NonNull ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable String str2, long j2) {
        SwanAppActivity swanAppActivity;
        u22 X;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{jVar, activity, l33Var, guideType, str, str2, Long.valueOf(j2)}) == null) {
            String str3 = str;
            this.h = jVar;
            k();
            if (l33Var.w0()) {
                m();
                wr1 wr1Var = this.g;
                if (wr1Var != null) {
                    wr1Var.b(0);
                }
            }
            o(activity, l33Var, guideType);
            View inflate = LayoutInflater.from(activity).inflate(guideType == ShowFavoriteGuideApi.GuideType.TIPS ? R.layout.obfuscated_res_0x7f0d00a5 : R.layout.obfuscated_res_0x7f0d00a4, (ViewGroup) null, false);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0909a2);
            if (textView != null && str3 != null) {
                if (guideType.limit != -1 && str.length() > guideType.limit) {
                    str3 = str3.substring(0, guideType.limit - 1) + StringHelper.STRING_MORE;
                }
                textView.setText(str3);
            }
            View findViewById = activity.findViewById(R.id.obfuscated_res_0x7f09225f);
            if (guideType != ShowFavoriteGuideApi.GuideType.TIPS) {
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0909a1);
                ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
                int i2 = guideType.showWidth4px;
                int g2 = ch3.g(7.0f);
                int o = ch3.o(null);
                int i3 = g2 * 2;
                if (o - i2 < i3) {
                    i2 = o - i3;
                }
                layoutParams.width = i2;
                relativeLayout.setLayoutParams(layoutParams);
                fh3.X((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0909a3), str2, R.drawable.obfuscated_res_0x7f08013f);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0909a0);
                if (guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setOnClickListener(new a(this, guideType));
                }
                ((Button) inflate.findViewById(R.id.obfuscated_res_0x7f09099e)).setOnClickListener(new b(this, guideType, activity));
                PopupWindow popupWindow = new PopupWindow(inflate, -1, -2);
                this.a = popupWindow;
                popupWindow.L(16);
                this.a.O(activity.getWindow().getDecorView(), 81, 0, (int) ch3.h(50.0f));
            } else if (findViewById != null) {
                int[] iArr = new int[2];
                findViewById.getLocationOnScreen(iArr);
                inflate.findViewById(R.id.obfuscated_res_0x7f09099f).setPadding(0, 0, ((ch3.o(null) - iArr[0]) - (findViewById.getWidth() / 2)) - ch3.g(7.0f), 0);
                this.a = new PopupWindow(inflate, -2, -2);
                SwanAppActivity swanAppActivity2 = this.c;
                if (swanAppActivity2 != null && !swanAppActivity2.isFinishing() && !this.c.isDestroyed() && findViewById.isAttachedToWindow()) {
                    try {
                        this.a.N(findViewById, 0, -ch3.g(3.0f));
                    } catch (WindowManager.BadTokenException e2) {
                        if (vj1.a) {
                            Log.e("FavoriteGuideHelper", "Bad token when showing fav guide popup!");
                            e2.printStackTrace();
                        }
                    }
                }
            }
            if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && (swanAppActivity = this.c) != null && (X = swanAppActivity.X()) != null && findViewById != null) {
                t22 l = X.l();
                String t3 = l == null ? "" : l.t3();
                ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
                viewTreeObserver.addOnGlobalLayoutListener(new c(this, viewTreeObserver, X, l, t3, l33Var));
            }
            if (guideType == ShowFavoriteGuideApi.GuideType.TIPS || guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                Timer timer = this.b;
                if (timer != null) {
                    timer.cancel();
                }
                Timer timer2 = new Timer();
                this.b = timer2;
                timer2.schedule(new d(this, l33Var), 1000 * j2);
            }
            ShowFavoriteGuideApi.F(guideType, "", "show");
        }
    }
}
