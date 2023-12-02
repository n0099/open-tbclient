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
import com.baidu.tieba.aw2;
import com.baidu.tieba.q52;
import com.baidu.tieba.wu1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes9.dex */
public class yu1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yu1 i;
    public transient /* synthetic */ FieldHolder $fh;
    public PopupWindow a;
    public Timer b;
    public SwanAppActivity c;
    public q52 d;
    public ContentObserver e;
    public hj2 f;
    public wu1 g;
    public j h;

    /* loaded from: classes9.dex */
    public interface j {
        void e(boolean z);
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ yu1 c;

        /* loaded from: classes9.dex */
        public class a implements aw2.h {
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

            @Override // com.baidu.tieba.aw2.h
            public void onFail() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a.c.h != null) {
                        this.a.c.h.e(false);
                    }
                    k32.i("FavoriteGuideHelper", "add favorite result=false");
                }
            }

            @Override // com.baidu.tieba.aw2.h
            public void onSuccess() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    if (this.a.c.h != null) {
                        this.a.c.h.e(true);
                    }
                    k32.i("FavoriteGuideHelper", "add favorite result=true");
                }
            }
        }

        public b(yu1 yu1Var, ShowFavoriteGuideApi.GuideType guideType, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yu1Var, guideType, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = yu1Var;
            this.a = guideType;
            this.b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                aw2.h(this.b, new a(this));
                this.c.k();
                if (this.c.b != null) {
                    this.c.b.cancel();
                }
                ShowFavoriteGuideApi.GuideType guideType = this.a;
                if (guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                    str = "flow_add";
                } else {
                    str = "flow_close_add";
                }
                ShowFavoriteGuideApi.G(guideType, str, "click");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k63 a;
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType b;
        public final /* synthetic */ yu1 c;

        /* loaded from: classes9.dex */
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && id2.n(this.a.a.b)) {
                    f fVar = this.a;
                    if (fVar.b == ShowFavoriteGuideApi.GuideType.NORMAL && fVar.c.h != null) {
                        this.a.c.h.e(true);
                    }
                    this.a.c.k();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(yu1 yu1Var, Handler handler, k63 k63Var, ShowFavoriteGuideApi.GuideType guideType) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yu1Var, handler, k63Var, guideType};
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
            this.c = yu1Var;
            this.a = k63Var;
            this.b = guideType;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.onChange(z);
                ej3.h().execute(new a(this));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType a;
        public final /* synthetic */ yu1 b;

        public a(yu1 yu1Var, ShowFavoriteGuideApi.GuideType guideType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yu1Var, guideType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yu1Var;
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
                ShowFavoriteGuideApi.G(this.a, "flow_close_close", "click");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewTreeObserver a;
        public final /* synthetic */ t52 b;
        public final /* synthetic */ s52 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ k63 e;
        public final /* synthetic */ yu1 f;

        public c(yu1 yu1Var, ViewTreeObserver viewTreeObserver, t52 t52Var, s52 s52Var, String str, k63 k63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yu1Var, viewTreeObserver, t52Var, s52Var, str, k63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = yu1Var;
            this.a = viewTreeObserver;
            this.b = t52Var;
            this.c = s52Var;
            this.d = str;
            this.e = k63Var;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            s52 s52Var;
            ViewTreeObserver viewTreeObserver;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f.a == null && (viewTreeObserver = this.a) != null && viewTreeObserver.isAlive()) {
                    this.a.removeOnGlobalLayoutListener(this);
                } else if (this.f.d != this.b.m() || (((s52Var = this.c) != null && !TextUtils.equals(this.d, s52Var.A3())) || (!this.e.x0() && bk3.J()))) {
                    this.f.k();
                    ViewTreeObserver viewTreeObserver2 = this.a;
                    if (viewTreeObserver2 != null && viewTreeObserver2.isAlive()) {
                        this.a.removeOnGlobalLayoutListener(this);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k63 a;
        public final /* synthetic */ yu1 b;

        public d(yu1 yu1Var, k63 k63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yu1Var, k63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yu1Var;
            this.a = k63Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.k();
                if (this.b.h != null) {
                    this.b.h.e(id2.n(this.a.b));
                }
                if (this.b.b != null) {
                    this.b.b.cancel();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements wu1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yu1 a;

        public e(yu1 yu1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yu1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yu1Var;
        }

        @Override // com.baidu.tieba.wu1.a
        public void b(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) || i != 1) {
                return;
            }
            this.a.k();
        }

        @Override // com.baidu.tieba.wu1.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g extends hj2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k63 a;
        public final /* synthetic */ yu1 b;

        public g(yu1 yu1Var, k63 k63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yu1Var, k63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yu1Var;
            this.a = k63Var;
        }

        @Override // com.baidu.tieba.hj2, com.baidu.tieba.ij2
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a != null && this.b.a.z()) {
                this.b.k();
            }
        }

        @Override // com.baidu.tieba.hj2, com.baidu.tieba.ij2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                k32.i("FavoriteGuideHelper", "call onActivityDestroyed");
                this.b.k();
                if (this.b.c != null && this.b.f != null) {
                    this.b.c.G0(this.b.f);
                }
            }
        }

        @Override // com.baidu.tieba.hj2, com.baidu.tieba.ij2
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.e();
                k32.i("FavoriteGuideHelper", "swanId=" + this.a.b + ", nowId=" + k63.h0());
                if (!TextUtils.equals(this.a.b, k63.h0())) {
                    this.b.k();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements q52.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yu1 a;

        public h(yu1 yu1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yu1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yu1Var;
        }

        @Override // com.baidu.tieba.q52.p
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yu1 a;

        public i(yu1 yu1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yu1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yu1Var;
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
                    this.a.c.G0(this.a.f);
                }
                if (this.a.d != null) {
                    this.a.d.M2(null);
                }
            }
        }
    }

    public yu1() {
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

    public static yu1 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (i == null) {
                synchronized (yu1.class) {
                    if (i == null) {
                        i = new yu1();
                    }
                }
            }
            return i;
        }
        return (yu1) invokeV.objValue;
    }

    @AnyThread
    public final synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                ek3.e0(new i(this));
            }
        }
    }

    public final void m() {
        xn1 k;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.g != null || (k = sp2.k()) == null) {
            return;
        }
        wu1 xn1Var = k.getInstance();
        this.g = xn1Var;
        if (xn1Var != null) {
            xn1Var.a(new e(this));
        }
    }

    public boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && ShowFavoriteGuideApi.GuideType.parse(str) != ShowFavoriteGuideApi.GuideType.NORMAL) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final synchronized void o(@NonNull Activity activity, @NonNull k63 k63Var, ShowFavoriteGuideApi.GuideType guideType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, k63Var, guideType) == null) {
            synchronized (this) {
                this.e = new f(this, null, k63Var, guideType);
                AppRuntime.getAppContext().getContentResolver().registerContentObserver(id2.d(), false, this.e);
                if (activity instanceof SwanAppActivity) {
                    SwanAppActivity swanAppActivity = (SwanAppActivity) activity;
                    this.c = swanAppActivity;
                    if (this.f != null) {
                        swanAppActivity.G0(this.f);
                    }
                    g gVar = new g(this, k63Var);
                    this.f = gVar;
                    this.c.u0(gVar);
                }
                t52 Y = this.c.Y();
                if (Y == null) {
                    return;
                }
                q52 m = Y.m();
                this.d = m;
                if (m == null) {
                    return;
                }
                m.M2(new h(this));
            }
        }
    }

    @UiThread
    public void p(@Nullable j jVar, @NonNull Activity activity, @NonNull k63 k63Var, @NonNull ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable String str2, long j2) {
        int i2;
        SwanAppActivity swanAppActivity;
        t52 Y;
        String A3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{jVar, activity, k63Var, guideType, str, str2, Long.valueOf(j2)}) == null) {
            String str3 = str;
            this.h = jVar;
            k();
            if (k63Var.x0()) {
                m();
                wu1 wu1Var = this.g;
                if (wu1Var != null) {
                    wu1Var.b(0);
                }
            }
            o(activity, k63Var, guideType);
            if (guideType == ShowFavoriteGuideApi.GuideType.TIPS) {
                i2 = R.layout.obfuscated_res_0x7f0d00ae;
            } else {
                i2 = R.layout.obfuscated_res_0x7f0d00ad;
            }
            View inflate = LayoutInflater.from(activity).inflate(i2, (ViewGroup) null, false);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090b48);
            if (textView != null && str3 != null) {
                if (guideType.limit != -1 && str.length() > guideType.limit) {
                    str3 = str3.substring(0, guideType.limit - 1) + "...";
                }
                textView.setText(str3);
            }
            View findViewById = activity.findViewById(R.id.obfuscated_res_0x7f0926ce);
            if (guideType == ShowFavoriteGuideApi.GuideType.TIPS) {
                if (findViewById != null) {
                    int[] iArr = new int[2];
                    findViewById.getLocationOnScreen(iArr);
                    inflate.findViewById(R.id.obfuscated_res_0x7f090b45).setPadding(0, 0, ((bk3.o(null) - iArr[0]) - (findViewById.getWidth() / 2)) - bk3.g(7.0f), 0);
                    this.a = new PopupWindow(inflate, -2, -2);
                    SwanAppActivity swanAppActivity2 = this.c;
                    if (swanAppActivity2 != null && !swanAppActivity2.isFinishing() && !this.c.isDestroyed() && findViewById.isAttachedToWindow()) {
                        try {
                            this.a.O(findViewById, 0, -bk3.g(3.0f));
                        } catch (WindowManager.BadTokenException e2) {
                            if (vm1.a) {
                                Log.e("FavoriteGuideHelper", "Bad token when showing fav guide popup!");
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            } else {
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090b47);
                ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
                int i3 = guideType.showWidth4px;
                int g2 = bk3.g(7.0f);
                int o = bk3.o(null);
                int i4 = g2 * 2;
                if (o - i3 < i4) {
                    i3 = o - i4;
                }
                layoutParams.width = i3;
                relativeLayout.setLayoutParams(layoutParams);
                ek3.X((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090b49), str2, R.drawable.obfuscated_res_0x7f08015f);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090b46);
                if (guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setOnClickListener(new a(this, guideType));
                }
                ((Button) inflate.findViewById(R.id.obfuscated_res_0x7f090b44)).setOnClickListener(new b(this, guideType, activity));
                PopupWindow popupWindow = new PopupWindow(inflate, -1, -2);
                this.a = popupWindow;
                popupWindow.M(16);
                this.a.P(activity.getWindow().getDecorView(), 81, 0, (int) bk3.h(50.0f));
            }
            if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && (swanAppActivity = this.c) != null && (Y = swanAppActivity.Y()) != null && findViewById != null) {
                s52 l = Y.l();
                if (l == null) {
                    A3 = "";
                } else {
                    A3 = l.A3();
                }
                ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
                viewTreeObserver.addOnGlobalLayoutListener(new c(this, viewTreeObserver, Y, l, A3, k63Var));
            }
            if (guideType == ShowFavoriteGuideApi.GuideType.TIPS || guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                Timer timer = this.b;
                if (timer != null) {
                    timer.cancel();
                }
                Timer timer2 = new Timer();
                this.b = timer2;
                timer2.schedule(new d(this, k63Var), 1000 * j2);
            }
            ShowFavoriteGuideApi.G(guideType, "", "show");
        }
    }
}
