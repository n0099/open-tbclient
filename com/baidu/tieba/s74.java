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
import com.baidu.tieba.cb3;
import com.baidu.tieba.pf4;
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
public class s74 extends bb2 implements gc4, cb3.a {
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
    public qe4 N0;
    public qe4 O0;
    public fc4 P0;
    public cb3 Q0;
    public oe4 R0;
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
    public pf4 c1;
    public boolean d1;
    public View e1;
    public boolean f1;
    public long g1;
    public long h1;
    public boolean i1;

    @Override // com.baidu.tieba.bb2
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.bb2
    public boolean g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class b extends OrientationEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dj2 a;
        public final /* synthetic */ s74 b;

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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && ep3.q(this.a.b.getActivity(), this.a.b.H0) && (b = ep3.b(this.a.b.getActivity())) > 0) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.b.H0.getLayoutParams();
                    layoutParams.rightMargin += b;
                    this.a.b.H0.setLayoutParams(layoutParams);
                    m84.e().b(b);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(s74 s74Var, Context context, int i, dj2 dj2Var) {
            super(context, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s74Var, context, Integer.valueOf(i), dj2Var};
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
            this.b = s74Var;
            this.a = dj2Var;
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
                layoutParams.rightMargin = this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070175);
                this.b.H0.setLayoutParams(layoutParams);
                m84.e().b(0);
                nd4.a(this.a, this.b.a1);
                if (s74.j1) {
                    Log.d("SwanGameFragment", "onOrientationChanged: " + this.b.a1);
                }
            } else if (80 < i && i < 100 && !this.b.a1.endsWith("landscapeReverse")) {
                this.b.c0.setRequestedOrientation(8);
                this.b.a1 = "landscapeReverse";
                nd4.a(this.a, this.b.a1);
                if (s74.j1) {
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
        public final /* synthetic */ s74 a;

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
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.b.a.H3()) {
                    return;
                }
                int i = this.a;
                if (i != -2) {
                    if (i == -1) {
                        if (s74.j1) {
                            Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS");
                        }
                        this.b.a.W2();
                        return;
                    }
                    return;
                }
                if (s74.j1) {
                    Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                }
                this.b.a.W2();
            }
        }

        public l(s74 s74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s74Var;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                pp3.e0(new a(this, i));
            }
        }

        public /* synthetic */ l(s74 s74Var, c cVar) {
            this(s74Var);
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s74 a;

        public a(s74 s74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s74Var;
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
        public final /* synthetic */ s74 a;

        public c(s74 s74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s74Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m84.j().a(this.a.d0, this.a.getContext());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnSystemUiVisibilityChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s74 a;

        public d(s74 s74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s74Var;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (s74.j1) {
                    Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + this.a.V0);
                }
                if (this.a.V0 || this.a.G3()) {
                    eo3.e(this.a.c0);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s74 a;

        public e(s74 s74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s74Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int e = ep3.e(this.a.getContext());
                if (ep3.q(this.a.getActivity(), this.a.H0) && !((SwanAppActivity) this.a.getActivity()).j0()) {
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
        public final /* synthetic */ s74 a;

        public f(s74 s74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s74Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.l2();
                yi3 yi3Var = new yi3();
                yi3Var.e = "menu";
                this.a.C1(yi3Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s74 a;

        public g(s74 s74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s74Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (s74.j1 && u73.e()) {
                    return;
                }
                vb3 M = vb3.M();
                if (M != null && TextUtils.equals(vb3.g0(), "7TxyeScrKPj02EATE68RBG5Z8f46a8So")) {
                    this.a.N3();
                } else if (M != null && dp2.a().b()) {
                    this.a.M3("exitButton");
                } else {
                    i84 i84Var = new i84();
                    i84Var.e();
                    if (i84Var.f()) {
                        m84.h().a(this.a.c0, i84Var, this.a.u3());
                    } else {
                        this.a.M3("exitButton");
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements pf4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s74 a;

        public h(s74 s74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s74Var;
        }

        @Override // com.baidu.tieba.pf4.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.J3("pandacontinue");
            this.a.c1.dismiss();
        }

        @Override // com.baidu.tieba.pf4.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.J3("pandaclose");
            this.a.c1.dismiss();
        }

        @Override // com.baidu.tieba.pf4.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
                return;
            }
            this.a.J3("pandaexit");
            this.a.c1.dismiss();
            this.a.t3();
        }
    }

    /* loaded from: classes7.dex */
    public class i implements GameCloseGuidePopView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s74 a;

        public i(s74 s74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s74Var;
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.t3();
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.t3();
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
    public class j implements m94 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s74 a;

        public j(s74 s74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s74Var;
        }

        @Override // com.baidu.tieba.m94
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.t3();
        }
    }

    /* loaded from: classes7.dex */
    public class k implements GameCloseGuidePopView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s74 a;

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

        public k(s74 s74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s74Var;
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.e1 != null) {
                    this.a.L0.removeView(this.a.e1);
                    this.a.e1 = null;
                }
                this.a.t3();
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
                    if (s74.j1) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948104313, "Lcom/baidu/tieba/s74;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948104313, "Lcom/baidu/tieba/s74;");
                return;
            }
        }
        j1 = fs1.a;
    }

    public static s74 I3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new s74();
        }
        return (s74) invokeV.objValue;
    }

    public qe4 A3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.O0;
        }
        return (qe4) invokeV.objValue;
    }

    public final void B3() {
        DuMixGameSurfaceView duMixGameSurfaceView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (duMixGameSurfaceView = this.G0) == null) {
            return;
        }
        duMixGameSurfaceView.setOnSystemUiVisibilityChangeListener(new d(this));
    }

    public boolean F3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return !this.V0;
        }
        return invokeV.booleanValue;
    }

    public final boolean G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            eb2 O1 = O1();
            if (O1 != null && (O1.m() instanceof s74)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.bb2
    public void O2() {
        DuMixGameSurfaceView duMixGameSurfaceView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (duMixGameSurfaceView = this.G0) != null && duMixGameSurfaceView.getV8Engine() != null) {
            this.G0.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    public final void Q3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && mp3.F(this.c0)) {
            nb3.f(cv2.c(), R.string.obfuscated_res_0x7f0f01ac).G();
            this.c0.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.tieba.gc4
    @NonNull
    public fc4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.P0;
        }
        return (fc4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cb3.a
    public cb3 getFloatLayer() {
        InterceptResult invokeV;
        qe4 qe4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.Q0 == null && (qe4Var = this.O0) != null && qe4Var.getRootView() != null) {
                this.Q0 = new cb3(this, this.O0.getRootView(), 0);
            }
            return this.Q0;
        }
        return (cb3) invokeV.objValue;
    }

    public final m94 u3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return new j(this);
        }
        return (m94) invokeV.objValue;
    }

    public final GameCloseGuidePopView.e v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return new k(this);
        }
        return (GameCloseGuidePopView.e) invokeV.objValue;
    }

    @NonNull
    public oe4 w3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.R0;
        }
        return (oe4) invokeV.objValue;
    }

    public View x3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.H0;
        }
        return (View) invokeV.objValue;
    }

    public qe4 y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.N0;
        }
        return (qe4) invokeV.objValue;
    }

    public ci4 z3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.g0;
        }
        return (ci4) invokeV.objValue;
    }

    public s74() {
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
        this.P0 = new fc4();
        this.R0 = new oe4();
        this.V0 = true;
        this.a1 = "landscape";
        this.d1 = false;
        this.i1 = false;
    }

    public final boolean H3() {
        InterceptResult invokeV;
        boolean booleanValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            vb3 M = vb3.M();
            if (M == null) {
                booleanValue = false;
            } else {
                booleanValue = M.U().c("key_audio_is_mix_with_other", Boolean.FALSE).booleanValue();
            }
            if (j1) {
                Log.d("SwanGameFragment", "   isMixWithOther -> " + booleanValue);
            }
            return booleanValue;
        }
        return invokeV.booleanValue;
    }

    public boolean N3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.c1 == null) {
                pf4 pf4Var = new pf4(getContext());
                this.c1 = pf4Var;
                pf4Var.e(new h(this));
            }
            J3("pandadialog");
            this.c1.show();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void O3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
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

    public final void P3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
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

    public void W2() {
        l lVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || !this.X0) {
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

    @Override // com.baidu.tieba.bb2, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (j1) {
                Log.d("SwanGameFragment", "onPause() obj: " + this);
            }
            super.onPause();
            if (Z()) {
                pause();
            }
        }
    }

    @Override // com.baidu.tieba.bb2, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (j1) {
                Log.d("SwanGameFragment", "onResume() obj: " + this);
            }
            super.onResume();
            if (Z()) {
                resume();
            }
        }
    }

    public final void t3() {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && (activity = this.c0) != null && (activity instanceof SwanAppActivity)) {
            activity.moveTaskToBack(true);
            yi3 yi3Var = new yi3();
            yi3Var.e = "close";
            C1(yi3Var);
            ((SwanAppActivity) this.c0).Z(1);
            xp3.b().e(2);
            j54.g("0");
        }
    }

    public final void J3(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && !TextUtils.isEmpty(str)) {
            yi3 yi3Var = new yi3();
            yi3Var.e = str;
            C1(yi3Var);
        }
    }

    public void L3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.d1 = z;
        }
    }

    @Override // com.baidu.tieba.bb2, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            Q3();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void v0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bundle) == null) {
            super.v0(bundle);
            po3.j(new c(this), "SwanGamePageHistory");
        }
    }

    public final void C3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f092589);
            this.H0 = findViewById;
            findViewById.post(new e(this));
            this.I0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09258b);
            this.J0 = view2.findViewById(R.id.obfuscated_res_0x7f09258c);
            this.K0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09258a);
            this.I0.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f08013e));
            this.K0.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080129));
            this.J0.setBackgroundResource(R.color.obfuscated_res_0x7f0603fa);
            this.H0.setBackgroundResource(R.drawable.obfuscated_res_0x7f08013a);
            this.I0.setOnClickListener(new f(this));
            this.K0.setOnClickListener(new g(this));
        }
    }

    public void E3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090195);
            this.L0 = frameLayout;
            DuMixGameSurfaceView r = v74.m().r();
            this.G0 = r;
            if (r != null && r.getParent() == null) {
                frameLayout.addView(this.G0, 0, new FrameLayout.LayoutParams(-1, -1));
                if (j1) {
                    Log.d("SwanGameFragment", "SwanGameCoreRuntime GameSurfaceView is added");
                }
            }
            if (j1 && !u73.n()) {
                View inflate = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f090193)).inflate();
                if (inflate != null) {
                    this.S0 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090192);
                }
                O3();
            }
            C3(view2);
            this.O0 = new qe4((FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090196));
            this.N0 = new qe4(this.L0);
        }
    }

    public boolean M3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            String a2 = of4.a();
            if (TextUtils.equals(a2, of4.b(GfhKeyValue.TYPE_DATE))) {
                if (TextUtils.equals(str, "exitButton")) {
                    t3();
                    return false;
                }
                return false;
            }
            View a3 = m84.e().a(this.c0, v3());
            this.e1 = a3;
            if (a3 != null) {
                this.L0.addView(a3);
                this.f1 = true;
                of4.c(GfhKeyValue.TYPE_DATE, a2);
                return true;
            }
            if (this.b1 == null) {
                GameCloseGuidePopView gameCloseGuidePopView = new GameCloseGuidePopView(getContext());
                this.b1 = gameCloseGuidePopView;
                gameCloseGuidePopView.setOnClickListener(new i(this));
            }
            this.L0.addView(this.b1);
            of4.c(GfhKeyValue.TYPE_DATE, a2);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void D3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (activity = getActivity()) == null) {
            return;
        }
        if (this.d1) {
            ci4 ci4Var = this.g0;
            if (ci4Var != null && ci4Var.i()) {
                this.g0.g(false);
            }
            this.g0 = null;
            this.d1 = false;
        }
        if (this.h0 == null) {
            this.h0 = new SwanAppMenuHeaderView(getContext());
        }
        if (this.g0 == null) {
            ci4 ci4Var2 = new ci4(activity, this.H0, 0, cv2.K(), new er3());
            this.g0 = ci4Var2;
            ci4Var2.m(eo3.c());
            this.P0.b(this.g0);
            jt1 F = ix2.T().F();
            if (F != null) {
                F.b(this.g0);
            }
            new l13(this.g0, this, this.h0).z();
        }
    }

    @Override // com.baidu.tieba.bb2
    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (PaymentManager.k()) {
                return PaymentManager.k();
            }
            vb3 M = vb3.M();
            if (M != null && TextUtils.equals(vb3.g0(), "7TxyeScrKPj02EATE68RBG5Z8f46a8So")) {
                return N3();
            }
            if (M != null && dp2.a().b()) {
                return M3("backButton");
            }
            i84 i84Var = new i84();
            i84Var.e();
            if (i84Var.f()) {
                m84.h().a(this.c0, i84Var, u3());
                return true;
            }
            return M3("backButton");
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.bb2
    public void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            Context context = getContext();
            if (context instanceof Activity) {
                wo3.a(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
            }
            D3();
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.h0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(ti2.n(ub3.K().getAppId()));
            }
            if (vb3.b0() != null) {
                this.g0.o(vb3.b0().W().d0());
            }
            this.g0.u(cv2.M().a(), J1(), this.h0, false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            if (j1) {
                Log.d("SwanGameFragment", "onDestroy() obj: " + this);
                P3();
            }
            DuMixGameSurfaceView duMixGameSurfaceView = this.G0;
            if (duMixGameSurfaceView != null) {
                duMixGameSurfaceView.setOnSystemUiVisibilityChangeListener(null);
                this.G0.q();
            }
            if (this.f1) {
                this.e1 = null;
                m84.e().release();
            }
            qe4 qe4Var = this.N0;
            if (qe4Var != null) {
                qe4Var.l();
            }
            qe4 qe4Var2 = this.O0;
            if (qe4Var2 != null) {
                qe4Var2.l();
            }
            this.R0.d();
            uy2.c();
            f84.g(false);
            f84.k();
            super.z0();
        }
    }

    public final void K3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || H3() || this.X0) {
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

    @Override // com.baidu.tieba.bb2, com.baidu.swan.support.v4.app.Fragment
    public void n1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            super.n1(z);
            if (j1) {
                Log.d("SwanGameFragment", "setUserVisibleHint isVisibleToUser: " + z);
            }
            if (!l0()) {
                return;
            }
            if (z) {
                resume();
            } else {
                pause();
            }
        }
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.V0 = false;
            W2();
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
            qe4 qe4Var = this.N0;
            if (qe4Var != null) {
                qe4Var.k();
            }
            qe4 qe4Var2 = this.O0;
            if (qe4Var2 != null) {
                qe4Var2.k();
            }
            DuMixGameSurfaceView duMixGameSurfaceView = this.G0;
            if (duMixGameSurfaceView != null && duMixGameSurfaceView.getV8Engine() != null) {
                dj2 v8Engine = this.G0.getV8Engine();
                if (j1) {
                    Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
                }
                if (!v8Engine.r0()) {
                    v8Engine.onPause();
                    v8Engine.dispatchEvent(new JSEvent("apphide"));
                    od4.a(v8Engine);
                    EventTarget m2 = v8Engine.m();
                    if (m2 instanceof c64) {
                        ((c64) m2).hideKeyboard();
                    }
                }
                y54.h().l();
                if (this.i1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.h1 = currentTimeMillis;
                    c74.d(this.g1, currentTimeMillis);
                }
                i54.o().n();
                uy2.j(false);
                this.G0.s();
                OrientationEventListener orientationEventListener = this.Z0;
                if (orientationEventListener != null) {
                    orientationEventListener.disable();
                }
                ci4 ci4Var = this.g0;
                if (ci4Var != null && ci4Var.i()) {
                    this.g0.g(false);
                }
            }
        }
    }

    public void resume() {
        Activity activity;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            K3();
            DuMixGameSurfaceView duMixGameSurfaceView = this.G0;
            if (duMixGameSurfaceView != null && duMixGameSurfaceView.getV8Engine() != null) {
                dj2 v8Engine = this.G0.getV8Engine();
                if (j1) {
                    Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
                }
                this.V0 = true;
                this.G0.t();
                y54.h().k();
                od4.b(v8Engine);
                Activity activity2 = this.c0;
                if (activity2 != null && (activity2 instanceof SwanAppActivity)) {
                    v8Engine.dispatchEvent(new y94(((SwanAppActivity) activity2).T()));
                }
                v8Engine.onResume();
                if (this.L0 != null && this.M0 != null) {
                    pp3.b0(new a(this), 500L);
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
                    eo3.e(this.c0);
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
                if (vb3.M() != null && vb3.M().Y() != null) {
                    try {
                        this.i1 = new JSONObject(vb3.M().Y().P().getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA)).optBoolean("needDuration");
                        this.g1 = System.currentTimeMillis();
                    } catch (Exception e2) {
                        if (j1) {
                            e2.printStackTrace();
                        }
                    }
                }
                if (this.e1 != null) {
                    m84.e().c();
                }
                i54.o().x();
                uy2.j(true);
                qe4 qe4Var = this.N0;
                if (qe4Var != null) {
                    qe4Var.m();
                }
                qe4 qe4Var2 = this.O0;
                if (qe4Var2 != null) {
                    qe4Var2.m();
                }
                Q3();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048612, this, layoutInflater, viewGroup, bundle)) == null) {
            if (j1) {
                Log.d("SwanGameFragment", "onCreateView obj: " + this);
            }
            if (ep3.p(getActivity())) {
                ep3.s(getActivity());
            }
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d008e, viewGroup, false);
            E3(inflate);
            B3();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
