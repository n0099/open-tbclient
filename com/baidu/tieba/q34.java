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
import com.baidu.tieba.a73;
import com.baidu.tieba.nb4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class q34 extends z62 implements e84, a73.a {
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
    public oa4 N0;
    public oa4 O0;
    public d84 P0;
    public a73 Q0;
    public ma4 R0;
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
    public nb4 c1;
    public boolean d1;
    public View e1;
    public boolean f1;
    public long g1;
    public long h1;
    public boolean i1;

    @Override // com.baidu.tieba.z62
    public boolean f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.z62
    public boolean h2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class b extends OrientationEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bf2 a;
        public final /* synthetic */ q34 b;

        /* loaded from: classes5.dex */
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && cl3.q(this.a.b.getActivity(), this.a.b.H0) && (b = cl3.b(this.a.b.getActivity())) > 0) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.b.H0.getLayoutParams();
                    layoutParams.rightMargin += b;
                    this.a.b.H0.setLayoutParams(layoutParams);
                    k44.e().b(b);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(q34 q34Var, Context context, int i, bf2 bf2Var) {
            super(context, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q34Var, context, Integer.valueOf(i), bf2Var};
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
            this.b = q34Var;
            this.a = bf2Var;
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
                layoutParams.rightMargin = this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07016e);
                this.b.H0.setLayoutParams(layoutParams);
                k44.e().b(0);
                l94.a(this.a, this.b.a1);
                if (q34.j1) {
                    Log.d("SwanGameFragment", "onOrientationChanged: " + this.b.a1);
                }
            } else if (80 < i && i < 100 && !this.b.a1.endsWith("landscapeReverse")) {
                this.b.c0.setRequestedOrientation(8);
                this.b.a1 = "landscapeReverse";
                l94.a(this.a, this.b.a1);
                if (q34.j1) {
                    Log.d("SwanGameFragment", "onOrientationChanged: " + this.b.a1);
                }
                this.b.H0.postDelayed(new a(this), 100L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements AudioManager.OnAudioFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q34 a;

        /* loaded from: classes5.dex */
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
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.b.a.I3()) {
                    return;
                }
                int i = this.a;
                if (i != -2) {
                    if (i == -1) {
                        if (q34.j1) {
                            Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS");
                        }
                        this.b.a.X2();
                        return;
                    }
                    return;
                }
                if (q34.j1) {
                    Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                }
                this.b.a.X2();
            }
        }

        public l(q34 q34Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q34Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q34Var;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                nl3.e0(new a(this, i));
            }
        }

        public /* synthetic */ l(q34 q34Var, c cVar) {
            this(q34Var);
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q34 a;

        public a(q34 q34Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q34Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q34Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.L0.removeView(this.a.M0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q34 a;

        public c(q34 q34Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q34Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q34Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                k44.j().a(this.a.d0, this.a.getContext());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnSystemUiVisibilityChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q34 a;

        public d(q34 q34Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q34Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q34Var;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (q34.j1) {
                    Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + this.a.V0);
                }
                if (this.a.V0 || this.a.H3()) {
                    ck3.e(this.a.c0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q34 a;

        public e(q34 q34Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q34Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q34Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int e = cl3.e(this.a.getContext());
                if (cl3.q(this.a.getActivity(), this.a.H0) && !((SwanAppActivity) this.a.getActivity()).k0()) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.H0.getLayoutParams();
                    layoutParams.topMargin = this.a.H0.getTop() + e;
                    this.a.H0.setLayoutParams(layoutParams);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q34 a;

        public f(q34 q34Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q34Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q34Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.m2();
                we3 we3Var = new we3();
                we3Var.e = "menu";
                this.a.D1(we3Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q34 a;

        public g(q34 q34Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q34Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q34Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (q34.j1 && s33.e()) {
                    return;
                }
                t73 M = t73.M();
                if (M != null && TextUtils.equals(t73.g0(), "7TxyeScrKPj02EATE68RBG5Z8f46a8So")) {
                    this.a.O3();
                } else if (M != null && bl2.a().b()) {
                    this.a.N3("exitButton");
                } else {
                    g44 g44Var = new g44();
                    g44Var.e();
                    if (g44Var.f()) {
                        k44.h().a(this.a.c0, g44Var, this.a.v3());
                    } else {
                        this.a.N3("exitButton");
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements nb4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q34 a;

        public h(q34 q34Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q34Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q34Var;
        }

        @Override // com.baidu.tieba.nb4.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.K3("pandacontinue");
            this.a.c1.dismiss();
        }

        @Override // com.baidu.tieba.nb4.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.K3("pandaclose");
            this.a.c1.dismiss();
        }

        @Override // com.baidu.tieba.nb4.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
                return;
            }
            this.a.K3("pandaexit");
            this.a.c1.dismiss();
            this.a.u3();
        }
    }

    /* loaded from: classes5.dex */
    public class i implements GameCloseGuidePopView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q34 a;

        public i(q34 q34Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q34Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q34Var;
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.u3();
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.u3();
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void c() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.b1 != null) {
                this.a.L0.removeView(this.a.b1);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements k54 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q34 a;

        public j(q34 q34Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q34Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q34Var;
        }

        @Override // com.baidu.tieba.k54
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.u3();
        }
    }

    /* loaded from: classes5.dex */
    public class k implements GameCloseGuidePopView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q34 a;

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

        public k(q34 q34Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q34Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q34Var;
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.e1 != null) {
                    this.a.L0.removeView(this.a.e1);
                    this.a.e1 = null;
                }
                this.a.u3();
            }
        }
    }

    /* loaded from: classes5.dex */
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
                    if (q34.j1) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948040887, "Lcom/baidu/tieba/q34;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948040887, "Lcom/baidu/tieba/q34;");
                return;
            }
        }
        j1 = do1.a;
    }

    public static q34 J3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new q34();
        }
        return (q34) invokeV.objValue;
    }

    public ae4 A3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g0;
        }
        return (ae4) invokeV.objValue;
    }

    public oa4 B3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.O0;
        }
        return (oa4) invokeV.objValue;
    }

    public final void C3() {
        DuMixGameSurfaceView duMixGameSurfaceView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (duMixGameSurfaceView = this.G0) == null) {
            return;
        }
        duMixGameSurfaceView.setOnSystemUiVisibilityChangeListener(new d(this));
    }

    public boolean G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return !this.V0;
        }
        return invokeV.booleanValue;
    }

    public final boolean H3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            c72 P1 = P1();
            if (P1 != null && (P1.m() instanceof q34)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.z62
    public void P2() {
        DuMixGameSurfaceView duMixGameSurfaceView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (duMixGameSurfaceView = this.G0) != null && duMixGameSurfaceView.getV8Engine() != null) {
            this.G0.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    public final void R3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && kl3.F(this.c0)) {
            l73.f(ar2.c(), R.string.obfuscated_res_0x7f0f0182).G();
            this.c0.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.tieba.e84
    @NonNull
    public d84 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.P0;
        }
        return (d84) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a73.a
    public a73 d() {
        InterceptResult invokeV;
        oa4 oa4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.Q0 == null && (oa4Var = this.O0) != null && oa4Var.getRootView() != null) {
                this.Q0 = new a73(this, this.O0.getRootView(), 0);
            }
            return this.Q0;
        }
        return (a73) invokeV.objValue;
    }

    public final k54 v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return new j(this);
        }
        return (k54) invokeV.objValue;
    }

    public final GameCloseGuidePopView.e w3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return new k(this);
        }
        return (GameCloseGuidePopView.e) invokeV.objValue;
    }

    @NonNull
    public ma4 x3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.R0;
        }
        return (ma4) invokeV.objValue;
    }

    public View y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.H0;
        }
        return (View) invokeV.objValue;
    }

    public oa4 z3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.N0;
        }
        return (oa4) invokeV.objValue;
    }

    public q34() {
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
        this.P0 = new d84();
        this.R0 = new ma4();
        this.V0 = true;
        this.a1 = "landscape";
        this.d1 = false;
        this.i1 = false;
    }

    public final boolean I3() {
        InterceptResult invokeV;
        boolean booleanValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            t73 M = t73.M();
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

    public boolean O3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.c1 == null) {
                nb4 nb4Var = new nb4(getContext());
                this.c1 = nb4Var;
                nb4Var.e(new h(this));
            }
            K3("pandadialog");
            this.c1.show();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void P3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
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

    public final void Q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
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

    public void X2() {
        l lVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || !this.X0) {
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

    @Override // com.baidu.tieba.z62, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (j1) {
                Log.d("SwanGameFragment", "onPause() obj: " + this);
            }
            super.onPause();
            if (a0()) {
                pause();
            }
        }
    }

    @Override // com.baidu.tieba.z62, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (j1) {
                Log.d("SwanGameFragment", "onResume() obj: " + this);
            }
            super.onResume();
            if (a0()) {
                resume();
            }
        }
    }

    public final void u3() {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && (activity = this.c0) != null && (activity instanceof SwanAppActivity)) {
            activity.moveTaskToBack(true);
            we3 we3Var = new we3();
            we3Var.e = "close";
            D1(we3Var);
            ((SwanAppActivity) this.c0).a0(1);
            vl3.b().e(2);
            h14.g("0");
        }
    }

    public final void K3(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, str) == null) && !TextUtils.isEmpty(str)) {
            we3 we3Var = new we3();
            we3Var.e = str;
            D1(we3Var);
        }
    }

    public void M3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.d1 = z;
        }
    }

    @Override // com.baidu.tieba.z62, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            R3();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void w0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bundle) == null) {
            super.w0(bundle);
            nk3.j(new c(this), "SwanGamePageHistory");
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (j1) {
                Log.d("SwanGameFragment", "onDestroy() obj: " + this);
                Q3();
            }
            DuMixGameSurfaceView duMixGameSurfaceView = this.G0;
            if (duMixGameSurfaceView != null) {
                duMixGameSurfaceView.setOnSystemUiVisibilityChangeListener(null);
                this.G0.q();
            }
            if (this.f1) {
                this.e1 = null;
                k44.e().release();
            }
            oa4 oa4Var = this.N0;
            if (oa4Var != null) {
                oa4Var.l();
            }
            oa4 oa4Var2 = this.O0;
            if (oa4Var2 != null) {
                oa4Var2.l();
            }
            this.R0.d();
            su2.c();
            d44.g(false);
            d44.k();
            super.A0();
        }
    }

    public void E3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || (activity = getActivity()) == null) {
            return;
        }
        if (this.d1) {
            ae4 ae4Var = this.g0;
            if (ae4Var != null && ae4Var.i()) {
                this.g0.g(false);
            }
            this.g0 = null;
            this.d1 = false;
        }
        if (this.h0 == null) {
            this.h0 = new SwanAppMenuHeaderView(getContext());
        }
        if (this.g0 == null) {
            ae4 ae4Var2 = new ae4(activity, this.H0, 0, ar2.K(), new cn3());
            this.g0 = ae4Var2;
            ae4Var2.m(ck3.c());
            this.P0.b(this.g0);
            hp1 F = gt2.U().F();
            if (F != null) {
                F.b(this.g0);
            }
            new jx2(this.g0, this, this.h0).z();
        }
    }

    @Override // com.baidu.tieba.z62
    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (PaymentManager.k()) {
                return PaymentManager.k();
            }
            t73 M = t73.M();
            if (M != null && TextUtils.equals(t73.g0(), "7TxyeScrKPj02EATE68RBG5Z8f46a8So")) {
                return O3();
            }
            if (M != null && bl2.a().b()) {
                return N3("backButton");
            }
            g44 g44Var = new g44();
            g44Var.e();
            if (g44Var.f()) {
                k44.h().a(this.c0, g44Var, v3());
                return true;
            }
            return N3("backButton");
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.z62
    public void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            Context context = getContext();
            if (context instanceof Activity) {
                uk3.a(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
            }
            E3();
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.h0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(re2.n(s73.K().getAppId()));
            }
            if (t73.b0() != null) {
                this.g0.o(t73.b0().W().d0());
            }
            this.g0.u(ar2.M().a(), K1(), this.h0, false);
        }
    }

    public final void D3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f092443);
            this.H0 = findViewById;
            findViewById.post(new e(this));
            this.I0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092445);
            this.J0 = view2.findViewById(R.id.obfuscated_res_0x7f092446);
            this.K0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092444);
            this.I0.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080125));
            this.K0.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080110));
            this.J0.setBackgroundResource(R.color.obfuscated_res_0x7f0602de);
            this.H0.setBackgroundResource(R.drawable.obfuscated_res_0x7f080121);
            this.I0.setOnClickListener(new f(this));
            this.K0.setOnClickListener(new g(this));
        }
    }

    public void F3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09018b);
            this.L0 = frameLayout;
            DuMixGameSurfaceView r = t34.m().r();
            this.G0 = r;
            if (r != null && r.getParent() == null) {
                frameLayout.addView(this.G0, 0, new FrameLayout.LayoutParams(-1, -1));
                if (j1) {
                    Log.d("SwanGameFragment", "SwanGameCoreRuntime GameSurfaceView is added");
                }
            }
            if (j1 && !s33.n()) {
                View inflate = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f090189)).inflate();
                if (inflate != null) {
                    this.S0 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090188);
                }
                P3();
            }
            D3(view2);
            this.O0 = new oa4((FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09018c));
            this.N0 = new oa4(this.L0);
        }
    }

    public boolean N3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            String a2 = mb4.a();
            if (TextUtils.equals(a2, mb4.b(GfhKeyValue.TYPE_DATE))) {
                if (TextUtils.equals(str, "exitButton")) {
                    u3();
                    return false;
                }
                return false;
            }
            View a3 = k44.e().a(this.c0, w3());
            this.e1 = a3;
            if (a3 != null) {
                this.L0.addView(a3);
                this.f1 = true;
                mb4.c(GfhKeyValue.TYPE_DATE, a2);
                return true;
            }
            if (this.b1 == null) {
                GameCloseGuidePopView gameCloseGuidePopView = new GameCloseGuidePopView(getContext());
                this.b1 = gameCloseGuidePopView;
                gameCloseGuidePopView.setOnClickListener(new i(this));
            }
            this.L0.addView(this.b1);
            mb4.c(GfhKeyValue.TYPE_DATE, a2);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void L3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || I3() || this.X0) {
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

    @Override // com.baidu.tieba.z62, com.baidu.swan.support.v4.app.Fragment
    public void o1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            super.o1(z);
            if (j1) {
                Log.d("SwanGameFragment", "setUserVisibleHint isVisibleToUser: " + z);
            }
            if (!m0()) {
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
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.V0 = false;
            X2();
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
            oa4 oa4Var = this.N0;
            if (oa4Var != null) {
                oa4Var.k();
            }
            oa4 oa4Var2 = this.O0;
            if (oa4Var2 != null) {
                oa4Var2.k();
            }
            DuMixGameSurfaceView duMixGameSurfaceView = this.G0;
            if (duMixGameSurfaceView != null && duMixGameSurfaceView.getV8Engine() != null) {
                bf2 v8Engine = this.G0.getV8Engine();
                if (j1) {
                    Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
                }
                if (!v8Engine.s0()) {
                    v8Engine.onPause();
                    v8Engine.dispatchEvent(new JSEvent("apphide"));
                    m94.a(v8Engine);
                    EventTarget n = v8Engine.n();
                    if (n instanceof a24) {
                        ((a24) n).hideKeyboard();
                    }
                }
                w14.h().l();
                if (this.i1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.h1 = currentTimeMillis;
                    a34.d(this.g1, currentTimeMillis);
                }
                g14.o().n();
                su2.j(false);
                this.G0.s();
                OrientationEventListener orientationEventListener = this.Z0;
                if (orientationEventListener != null) {
                    orientationEventListener.disable();
                }
                ae4 ae4Var = this.g0;
                if (ae4Var != null && ae4Var.i()) {
                    this.g0.g(false);
                }
            }
        }
    }

    public void resume() {
        Activity activity;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            L3();
            DuMixGameSurfaceView duMixGameSurfaceView = this.G0;
            if (duMixGameSurfaceView != null && duMixGameSurfaceView.getV8Engine() != null) {
                bf2 v8Engine = this.G0.getV8Engine();
                if (j1) {
                    Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
                }
                this.V0 = true;
                this.G0.t();
                w14.h().k();
                m94.b(v8Engine);
                Activity activity2 = this.c0;
                if (activity2 != null && (activity2 instanceof SwanAppActivity)) {
                    v8Engine.dispatchEvent(new w54(((SwanAppActivity) activity2).U()));
                }
                v8Engine.onResume();
                if (this.L0 != null && this.M0 != null) {
                    nl3.b0(new a(this), 500L);
                }
                Activity activity3 = this.c0;
                if (activity3 != null && (activity3 instanceof SwanAppActivity)) {
                    boolean k0 = ((SwanAppActivity) activity3).k0();
                    if (!this.N0.h()) {
                        Activity activity4 = this.c0;
                        if (k0) {
                            if (this.a1.equals("landscape")) {
                                i2 = 0;
                            } else {
                                i2 = 8;
                            }
                        } else {
                            i2 = 1;
                        }
                        activity4.setRequestedOrientation(i2);
                        this.N0.n(k0);
                        this.O0.n(k0);
                    }
                    ck3.e(this.c0);
                }
                if (this.Z0 == null) {
                    this.Z0 = new b(this, this.c0, 3, v8Engine);
                }
                if (this.Z0.canDetectOrientation() && (activity = this.c0) != null && ((SwanAppActivity) activity).k0()) {
                    this.Z0.enable();
                } else {
                    this.Z0.disable();
                }
                this.i1 = false;
                if (t73.M() != null && t73.M().Y() != null) {
                    try {
                        this.i1 = new JSONObject(t73.M().Y().P().getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA)).optBoolean("needDuration");
                        this.g1 = System.currentTimeMillis();
                    } catch (Exception e2) {
                        if (j1) {
                            e2.printStackTrace();
                        }
                    }
                }
                if (this.e1 != null) {
                    k44.e().c();
                }
                g14.o().x();
                su2.j(true);
                oa4 oa4Var = this.N0;
                if (oa4Var != null) {
                    oa4Var.m();
                }
                oa4 oa4Var2 = this.O0;
                if (oa4Var2 != null) {
                    oa4Var2.m();
                }
                R3();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048614, this, layoutInflater, viewGroup, bundle)) == null) {
            if (j1) {
                Log.d("SwanGameFragment", "onCreateView obj: " + this);
            }
            if (cl3.p(getActivity())) {
                cl3.s(getActivity());
            }
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d008d, viewGroup, false);
            F3(inflate);
            C3();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
