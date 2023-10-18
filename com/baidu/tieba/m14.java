package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.messages.gfh.GfhKeyValue;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.payment.PaymentManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.j94;
import com.baidu.tieba.w43;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class m14 extends v42 implements a64, w43.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j1;
    public transient /* synthetic */ FieldHolder $fh;
    public DuMixGameSurfaceView G0;
    public View H0;
    public ImageView I0;
    public View J0;
    public ImageView K0;
    public FrameLayout L0;
    public View M0;
    public k84 N0;
    public k84 O0;
    public z54 P0;
    public w43 Q0;
    public i84 R0;
    public TextView S0;
    public boolean T0;
    public m U0;
    public volatile boolean V0;
    public AudioManager W0;
    public boolean X0;
    public l Y0;
    public OrientationEventListener Z0;
    public String a1;
    public GameCloseGuidePopView b1;
    public j94 c1;
    public boolean d1;
    public View e1;
    public boolean f1;
    public long g1;
    public long h1;
    public boolean i1;

    @Override // com.baidu.tieba.v42
    public boolean j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.v42
    public boolean l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class b extends OrientationEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xc2 a;
        public final /* synthetic */ m14 b;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
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

            @Override // java.lang.Runnable
            public void run() {
                int b;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && yi3.q(this.a.b.m(), this.a.b.H0) && (b = yi3.b(this.a.b.m())) > 0) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.b.H0.getLayoutParams();
                    layoutParams.rightMargin += b;
                    this.a.b.H0.setLayoutParams(layoutParams);
                    g24.e().b(b);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(m14 m14Var, Context context, int i, xc2 xc2Var) {
            super(context, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m14Var, context, Integer.valueOf(i), xc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m14Var;
            this.a = xc2Var;
        }

        @Override // android.view.OrientationEventListener
        @SuppressLint({"SourceLockedOrientationActivity"})
        public void onOrientationChanged(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || this.b.N0.h()) {
                return;
            }
            if (260 < i && i < 280 && !this.b.a1.equals("landscape")) {
                this.b.c0.setRequestedOrientation(0);
                this.b.a1 = "landscape";
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.H0.getLayoutParams();
                layoutParams.rightMargin = this.b.J().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070175);
                this.b.H0.setLayoutParams(layoutParams);
                g24.e().b(0);
                h74.a(this.a, this.b.a1);
                if (m14.j1) {
                    Log.d("SwanGameFragment", "onOrientationChanged: " + this.b.a1);
                }
            } else if (80 < i && i < 100 && !this.b.a1.endsWith("landscapeReverse")) {
                this.b.c0.setRequestedOrientation(8);
                this.b.a1 = "landscapeReverse";
                h74.a(this.a, this.b.a1);
                if (m14.j1) {
                    Log.d("SwanGameFragment", "onOrientationChanged: " + this.b.a1);
                }
                this.b.H0.postDelayed(new a(this), 100L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements AudioManager.OnAudioFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m14 a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ l b;

            public a(l lVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = lVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.b.a.M3()) {
                    return;
                }
                int i = this.a;
                if (i != -2) {
                    if (i == -1) {
                        if (m14.j1) {
                            Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS");
                        }
                        this.b.a.b3();
                        return;
                    }
                    return;
                }
                if (m14.j1) {
                    Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                }
                this.b.a.b3();
            }
        }

        public l(m14 m14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m14Var;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                jj3.e0(new a(this, i));
            }
        }

        public /* synthetic */ l(m14 m14Var, c cVar) {
            this(m14Var);
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m14 a;

        public a(m14 m14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m14Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.L0.removeView(this.a.M0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m14 a;

        public c(m14 m14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m14Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g24.j().a(this.a.d0, this.a.s());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnSystemUiVisibilityChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m14 a;

        public d(m14 m14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m14Var;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (m14.j1) {
                    Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + this.a.V0);
                }
                if (this.a.V0 || this.a.L3()) {
                    yh3.e(this.a.c0);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m14 a;

        public e(m14 m14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m14Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int e = yi3.e(this.a.s());
                if (yi3.q(this.a.m(), this.a.H0) && !((SwanAppActivity) this.a.m()).j0()) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.H0.getLayoutParams();
                    layoutParams.topMargin = this.a.H0.getTop() + e;
                    this.a.H0.setLayoutParams(layoutParams);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m14 a;

        public f(m14 m14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m14Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.q2();
                sc3 sc3Var = new sc3();
                sc3Var.e = "menu";
                this.a.G1(sc3Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m14 a;

        public g(m14 m14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m14Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (m14.j1 && o13.e()) {
                    return;
                }
                p53 M = p53.M();
                if (M != null && TextUtils.equals(p53.h0(), "7TxyeScrKPj02EATE68RBG5Z8f46a8So")) {
                    this.a.S3();
                } else if (M != null && xi2.a().b()) {
                    this.a.R3("exitButton");
                } else {
                    c24 c24Var = new c24();
                    c24Var.e();
                    if (c24Var.f()) {
                        g24.h().a(this.a.c0, c24Var, this.a.z3());
                    } else {
                        this.a.R3("exitButton");
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements j94.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m14 a;

        public h(m14 m14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m14Var;
        }

        @Override // com.baidu.tieba.j94.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.O3("pandacontinue");
            this.a.c1.dismiss();
        }

        @Override // com.baidu.tieba.j94.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.O3("pandaclose");
            this.a.c1.dismiss();
        }

        @Override // com.baidu.tieba.j94.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
                return;
            }
            this.a.O3("pandaexit");
            this.a.c1.dismiss();
            this.a.y3();
        }
    }

    /* loaded from: classes7.dex */
    public class i implements GameCloseGuidePopView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m14 a;

        public i(m14 m14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m14Var;
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.y3();
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.y3();
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void c() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.b1 != null) {
                this.a.L0.removeView(this.a.b1);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements g34 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m14 a;

        public j(m14 m14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m14Var;
        }

        @Override // com.baidu.tieba.g34
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.y3();
        }
    }

    /* loaded from: classes7.dex */
    public class k implements GameCloseGuidePopView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m14 a;

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        public k(m14 m14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m14Var;
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.e1 != null) {
                    this.a.L0.removeView(this.a.e1);
                    this.a.e1 = null;
                }
                this.a.y3();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class m extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<TextView> a;
        public WeakReference<DuMixGameSurfaceView> b;

        public m(TextView textView, DuMixGameSurfaceView duMixGameSurfaceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textView, duMixGameSurfaceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(textView);
            this.b = new WeakReference<>(duMixGameSurfaceView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int fps;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                TextView textView = this.a.get();
                DuMixGameSurfaceView duMixGameSurfaceView = this.b.get();
                if (textView != null) {
                    if (duMixGameSurfaceView == null) {
                        fps = 0;
                    } else {
                        fps = duMixGameSurfaceView.getFPS();
                    }
                    String valueOf = String.valueOf(fps);
                    textView.setText(valueOf);
                    if (m14.j1) {
                        Log.d("SwanGameFragment", "gameFps:" + valueOf);
                    }
                }
                sendEmptyMessageDelayed(0, 500L);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947919801, "Lcom/baidu/tieba/m14;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947919801, "Lcom/baidu/tieba/m14;");
                return;
            }
        }
        j1 = am1.a;
    }

    public static m14 N3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new m14();
        }
        return (m14) invokeV.objValue;
    }

    public final GameCloseGuidePopView.e A3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new k(this);
        }
        return (GameCloseGuidePopView.e) invokeV.objValue;
    }

    @NonNull
    public i84 B3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.R0;
        }
        return (i84) invokeV.objValue;
    }

    public View C3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.H0;
        }
        return (View) invokeV.objValue;
    }

    public k84 D3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.N0;
        }
        return (k84) invokeV.objValue;
    }

    public wb4 E3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.g0;
        }
        return (wb4) invokeV.objValue;
    }

    public k84 F3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.O0;
        }
        return (k84) invokeV.objValue;
    }

    public final void G3() {
        DuMixGameSurfaceView duMixGameSurfaceView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || (duMixGameSurfaceView = this.G0) == null) {
            return;
        }
        duMixGameSurfaceView.setOnSystemUiVisibilityChangeListener(new d(this));
    }

    public boolean K3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return !this.V0;
        }
        return invokeV.booleanValue;
    }

    public final boolean L3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            y42 S1 = S1();
            if (S1 != null && (S1.m() instanceof m14)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.v42
    public void T2() {
        DuMixGameSurfaceView duMixGameSurfaceView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (duMixGameSurfaceView = this.G0) != null && duMixGameSurfaceView.getV8Engine() != null) {
            this.G0.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    public final void V3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && gj3.F(this.c0)) {
            h53.f(wo2.c(), R.string.obfuscated_res_0x7f0f01af).G();
            this.c0.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.tieba.a64
    @NonNull
    public z54 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.P0;
        }
        return (z54) invokeV.objValue;
    }

    @Override // com.baidu.tieba.w43.a
    public w43 getFloatLayer() {
        InterceptResult invokeV;
        k84 k84Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (this.Q0 == null && (k84Var = this.O0) != null && k84Var.getRootView() != null) {
                this.Q0 = new w43(this, this.O0.getRootView(), 0);
            }
            return this.Q0;
        }
        return (w43) invokeV.objValue;
    }

    public final g34 z3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return new j(this);
        }
        return (g34) invokeV.objValue;
    }

    public m14() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.P0 = new z54();
        this.R0 = new i84();
        this.V0 = true;
        this.a1 = "landscape";
        this.d1 = false;
        this.i1 = false;
    }

    public final boolean M3() {
        InterceptResult invokeV;
        boolean booleanValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            p53 M = p53.M();
            if (M == null) {
                booleanValue = false;
            } else {
                booleanValue = M.V().c("key_audio_is_mix_with_other", Boolean.FALSE).booleanValue();
            }
            if (j1) {
                Log.d("SwanGameFragment", "   isMixWithOther -> " + booleanValue);
            }
            return booleanValue;
        }
        return invokeV.booleanValue;
    }

    public boolean S3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.c1 == null) {
                j94 j94Var = new j94(s());
                this.c1 = j94Var;
                j94Var.e(new h(this));
            }
            O3("pandadialog");
            this.c1.show();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void T3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (this.T0) {
                if (j1) {
                    Log.d("SwanGameFragment", "Fps monitor already started");
                    return;
                }
                return;
            }
            this.T0 = true;
            m mVar = new m(this.S0, this.G0);
            this.U0 = mVar;
            mVar.sendEmptyMessage(0);
            if (j1) {
                Log.d("SwanGameFragment", "Start fps monitor");
            }
        }
    }

    public final void U3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (!this.T0) {
                if (j1) {
                    Log.d("SwanGameFragment", "fps monitor not started yet");
                    return;
                }
                return;
            }
            this.T0 = false;
            m mVar = this.U0;
            if (mVar != null) {
                mVar.removeMessages(0);
                this.U0 = null;
            }
            if (j1) {
                Log.d("SwanGameFragment", "Stop fps monitor");
            }
        }
    }

    public void b3() {
        l lVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048602, this) != null) || !this.X0) {
            return;
        }
        AudioManager audioManager = this.W0;
        if (audioManager != null && (lVar = this.Y0) != null) {
            audioManager.abandonAudioFocus(lVar);
            this.W0 = null;
            this.Y0 = null;
        }
        this.X0 = false;
        if (j1) {
            Log.d("SwanGameFragment", "   abandonAudioFocus");
        }
    }

    @Override // com.baidu.tieba.v42, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (j1) {
                Log.d("SwanGameFragment", "onPause() obj: " + this);
            }
            super.onPause();
            if (h0()) {
                pause();
            }
        }
    }

    @Override // com.baidu.tieba.v42, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            if (j1) {
                Log.d("SwanGameFragment", "onResume() obj: " + this);
            }
            super.onResume();
            if (h0()) {
                resume();
            }
        }
    }

    public final void y3() {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && (activity = this.c0) != null && (activity instanceof SwanAppActivity)) {
            activity.moveTaskToBack(true);
            sc3 sc3Var = new sc3();
            sc3Var.e = "close";
            G1(sc3Var);
            ((SwanAppActivity) this.c0).Z(1);
            rj3.b().e(2);
            dz3.g("0");
        }
    }

    public final void O3(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && !TextUtils.isEmpty(str)) {
            sc3 sc3Var = new sc3();
            sc3Var.e = str;
            G1(sc3Var);
        }
    }

    public void Q3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.d1 = z;
        }
    }

    @Override // com.baidu.tieba.v42, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            V3();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void y0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, bundle) == null) {
            super.y0(bundle);
            ji3.j(new c(this), "SwanGamePageHistory");
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutInflater, viewGroup, bundle)) == null) {
            if (j1) {
                Log.d("SwanGameFragment", "onCreateView obj: " + this);
            }
            if (yi3.p(m())) {
                yi3.s(m());
            }
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0090, viewGroup, false);
            J3(inflate);
            G3();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (j1) {
                Log.d("SwanGameFragment", "onDestroy() obj: " + this);
                U3();
            }
            DuMixGameSurfaceView duMixGameSurfaceView = this.G0;
            if (duMixGameSurfaceView != null) {
                duMixGameSurfaceView.setOnSystemUiVisibilityChangeListener(null);
                this.G0.q();
            }
            if (this.f1) {
                this.e1 = null;
                g24.e().release();
            }
            k84 k84Var = this.N0;
            if (k84Var != null) {
                k84Var.l();
            }
            k84 k84Var2 = this.O0;
            if (k84Var2 != null) {
                k84Var2.l();
            }
            this.R0.d();
            os2.c();
            z14.g(false);
            z14.k();
            super.C0();
        }
    }

    @Override // com.baidu.tieba.v42
    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (PaymentManager.k()) {
                return PaymentManager.k();
            }
            p53 M = p53.M();
            if (M != null && TextUtils.equals(p53.h0(), "7TxyeScrKPj02EATE68RBG5Z8f46a8So")) {
                return S3();
            }
            if (M != null && xi2.a().b()) {
                return R3("backButton");
            }
            c24 c24Var = new c24();
            c24Var.e();
            if (c24Var.f()) {
                g24.h().a(this.c0, c24Var, z3());
                return true;
            }
            return R3("backButton");
        }
        return invokeV.booleanValue;
    }

    public void I3() {
        FragmentActivity m2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || (m2 = m()) == null) {
            return;
        }
        if (this.d1) {
            wb4 wb4Var = this.g0;
            if (wb4Var != null && wb4Var.i()) {
                this.g0.g(false);
            }
            this.g0 = null;
            this.d1 = false;
        }
        if (this.h0 == null) {
            this.h0 = new SwanAppMenuHeaderView(s());
        }
        if (this.g0 == null) {
            wb4 wb4Var2 = new wb4(m2, this.H0, 0, wo2.K(), new yk3());
            this.g0 = wb4Var2;
            wb4Var2.m(yh3.c());
            this.P0.b(this.g0);
            en1 H = cr2.V().H();
            if (H != null) {
                H.b(this.g0);
            }
            new fv2(this.g0, this, this.h0).z();
        }
    }

    @Override // com.baidu.tieba.v42
    public void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            Context s = s();
            if (s instanceof Activity) {
                qi3.a(s, ((Activity) s).getWindow().getDecorView().getWindowToken());
            }
            I3();
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.h0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(nc2.n(o53.K().getAppId()));
            }
            if (p53.c0() != null) {
                this.g0.o(p53.c0().X().e0());
            }
            this.g0.t(wo2.M().a(), N1(), this.h0, false);
        }
    }

    public final void H3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
            View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f0925ee);
            this.H0 = findViewById;
            findViewById.post(new e(this));
            this.I0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0925f0);
            this.J0 = view2.findViewById(R.id.obfuscated_res_0x7f0925f1);
            this.K0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0925ef);
            this.I0.setImageDrawable(J().getDrawable(R.drawable.obfuscated_res_0x7f08013f));
            this.K0.setImageDrawable(J().getDrawable(R.drawable.obfuscated_res_0x7f08012a));
            this.J0.setBackgroundResource(R.color.obfuscated_res_0x7f060402);
            this.H0.setBackgroundResource(R.drawable.obfuscated_res_0x7f08013b);
            this.I0.setOnClickListener(new f(this));
            this.K0.setOnClickListener(new g(this));
        }
    }

    public void J3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090195);
            this.L0 = frameLayout;
            DuMixGameSurfaceView r = p14.m().r();
            this.G0 = r;
            if (r != null && r.getParent() == null) {
                frameLayout.addView(this.G0, 0, new FrameLayout.LayoutParams(-1, -1));
                if (j1) {
                    Log.d("SwanGameFragment", "SwanGameCoreRuntime GameSurfaceView is added");
                }
            }
            if (j1 && !o13.n()) {
                View inflate = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f090193)).inflate();
                if (inflate != null) {
                    this.S0 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090192);
                }
                T3();
            }
            H3(view2);
            this.O0 = new k84((FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090196));
            this.N0 = new k84(this.L0);
        }
    }

    public boolean R3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            String a2 = i94.a();
            if (TextUtils.equals(a2, i94.b(GfhKeyValue.TYPE_DATE))) {
                if (TextUtils.equals(str, "exitButton")) {
                    y3();
                    return false;
                }
                return false;
            }
            View a3 = g24.e().a(this.c0, A3());
            this.e1 = a3;
            if (a3 != null) {
                this.L0.addView(a3);
                this.f1 = true;
                i94.c(GfhKeyValue.TYPE_DATE, a2);
                return true;
            }
            if (this.b1 == null) {
                GameCloseGuidePopView gameCloseGuidePopView = new GameCloseGuidePopView(s());
                this.b1 = gameCloseGuidePopView;
                gameCloseGuidePopView.setOnClickListener(new i(this));
            }
            this.L0.addView(this.b1);
            i94.c(GfhKeyValue.TYPE_DATE, a2);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void P3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || M3() || this.X0) {
            return;
        }
        if (this.W0 == null) {
            AudioManager audioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
            this.W0 = audioManager;
            if (audioManager == null) {
                return;
            }
        }
        if (this.Y0 == null) {
            this.Y0 = new l(this, null);
        }
        boolean z = true;
        if (this.W0.requestAudioFocus(this.Y0, 3, 1) != 1) {
            z = false;
        }
        this.X0 = z;
        if (j1) {
            Log.d("SwanGameFragment", "   requestAudioFocus");
        }
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.V0 = false;
            b3();
            if (this.M0 == null) {
                this.M0 = new View(this.c0);
            }
            this.L0.removeView(this.M0);
            this.L0.addView(this.M0, new FrameLayout.LayoutParams(-1, -1));
            GameCloseGuidePopView gameCloseGuidePopView = this.b1;
            if (gameCloseGuidePopView != null) {
                this.L0.removeView(gameCloseGuidePopView);
                this.b1 = null;
            }
            k84 k84Var = this.N0;
            if (k84Var != null) {
                k84Var.k();
            }
            k84 k84Var2 = this.O0;
            if (k84Var2 != null) {
                k84Var2.k();
            }
            DuMixGameSurfaceView duMixGameSurfaceView = this.G0;
            if (duMixGameSurfaceView != null && duMixGameSurfaceView.getV8Engine() != null) {
                xc2 v8Engine = this.G0.getV8Engine();
                if (j1) {
                    Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
                }
                if (!v8Engine.q0()) {
                    v8Engine.onPause();
                    v8Engine.dispatchEvent(new JSEvent("apphide"));
                    i74.a(v8Engine);
                    EventTarget m2 = v8Engine.m();
                    if (m2 instanceof wz3) {
                        ((wz3) m2).hideKeyboard();
                    }
                }
                sz3.h().l();
                if (this.i1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.h1 = currentTimeMillis;
                    w04.d(this.g1, currentTimeMillis);
                }
                cz3.p().n();
                os2.j(false);
                this.G0.s();
                OrientationEventListener orientationEventListener = this.Z0;
                if (orientationEventListener != null) {
                    orientationEventListener.disable();
                }
                wb4 wb4Var = this.g0;
                if (wb4Var != null && wb4Var.i()) {
                    this.g0.g(false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.v42, com.baidu.swan.support.v4.app.Fragment
    public void q1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            super.q1(z);
            if (j1) {
                Log.d("SwanGameFragment", "setUserVisibleHint isVisibleToUser: " + z);
            }
            if (!n0()) {
                return;
            }
            if (z) {
                resume();
            } else {
                pause();
            }
        }
    }

    public void resume() {
        Activity activity;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            P3();
            DuMixGameSurfaceView duMixGameSurfaceView = this.G0;
            if (duMixGameSurfaceView != null && duMixGameSurfaceView.getV8Engine() != null) {
                xc2 v8Engine = this.G0.getV8Engine();
                if (j1) {
                    Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
                }
                this.V0 = true;
                this.G0.t();
                sz3.h().k();
                i74.b(v8Engine);
                Activity activity2 = this.c0;
                if (activity2 != null && (activity2 instanceof SwanAppActivity)) {
                    v8Engine.dispatchEvent(new s34(((SwanAppActivity) activity2).S()));
                }
                v8Engine.onResume();
                if (this.L0 != null && this.M0 != null) {
                    jj3.b0(new a(this), 500L);
                }
                Activity activity3 = this.c0;
                if (activity3 != null && (activity3 instanceof SwanAppActivity)) {
                    boolean j0 = ((SwanAppActivity) activity3).j0();
                    if (!this.N0.h()) {
                        Activity activity4 = this.c0;
                        if (j0) {
                            if (this.a1.equals("landscape")) {
                                i2 = 0;
                            } else {
                                i2 = 8;
                            }
                        } else {
                            i2 = 1;
                        }
                        activity4.setRequestedOrientation(i2);
                        this.N0.n(j0);
                        this.O0.n(j0);
                    }
                    yh3.e(this.c0);
                }
                if (this.Z0 == null) {
                    this.Z0 = new b(this, this.c0, 3, v8Engine);
                }
                if (this.Z0.canDetectOrientation() && (activity = this.c0) != null && ((SwanAppActivity) activity).j0()) {
                    this.Z0.enable();
                } else {
                    this.Z0.disable();
                }
                this.i1 = false;
                if (p53.M() != null && p53.M().Z() != null) {
                    try {
                        this.i1 = new JSONObject(p53.M().Z().Q().getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA)).optBoolean("needDuration");
                        this.g1 = System.currentTimeMillis();
                    } catch (Exception e2) {
                        if (j1) {
                            e2.printStackTrace();
                        }
                    }
                }
                if (this.e1 != null) {
                    g24.e().c();
                }
                cz3.p().y();
                os2.j(true);
                k84 k84Var = this.N0;
                if (k84Var != null) {
                    k84Var.m();
                }
                k84 k84Var2 = this.O0;
                if (k84Var2 != null) {
                    k84Var2.m();
                }
                V3();
            }
        }
    }
}
