package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.player.layer.LayerContainer;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public abstract class yo0 implements zt0 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean z;
    public transient /* synthetic */ FieldHolder $fh;
    public jv0 a;
    @Nullable
    public lu0 b;
    public LayerContainer c;
    public yu0 d;
    public ViewGroup e;
    public yv0 f;
    public AudioManager g;
    public b h;
    public boolean i;
    @Nullable
    public String j;
    public boolean k;
    public ViewGroup.LayoutParams l;
    public kq0 m;
    public final pr0 n;
    public final kr0 o;
    public final fr0 p;
    public final hr0 q;
    @NonNull
    public String r;
    public boolean s;
    public float t;
    public int u;
    public rs0 v;
    public boolean w;
    public int x;
    public final qs0 y;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948336751, "Lcom/baidu/tieba/yo0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948336751, "Lcom/baidu/tieba/yo0;");
        }
    }

    public abstract int C();

    public abstract void E0(@NonNull Context context);

    @NonNull
    public abstract rs0 F();

    public void G0(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, context) == null) {
        }
    }

    @NonNull
    public abstract pr0 I();

    public abstract void I0();

    public abstract void M();

    public abstract void O();

    @NonNull
    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? "CyberNetPlayer" : (String) invokeV.objValue;
    }

    @NonNull
    public abstract kq0 z();

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ yo0 b;

        public a(yo0 yo0Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yo0Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yo0Var;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = this.a;
                if ((i == -2 || i == -1) && this.b.W()) {
                    this.b.d0(2);
                    this.b.a();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements AudioManager.OnAudioFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yo0 a;

        public b(yo0 yo0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yo0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yo0Var;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.b0(i);
            }
        }

        public /* synthetic */ b(yo0 yo0Var, a aVar) {
            this(yo0Var);
        }
    }

    /* loaded from: classes9.dex */
    public class c implements vs0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yo0 a;

        @Override // com.baidu.tieba.vs0
        public int getExpectOrder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        public c(yo0 yo0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yo0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yo0Var;
        }

        @Override // com.baidu.tieba.vs0
        public void a(sr0 sr0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sr0Var) == null) {
                this.a.z().b(sr0Var);
            }
        }

        public /* synthetic */ c(yo0 yo0Var, a aVar) {
            this(yo0Var);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public yo0(@NonNull qs0 qs0Var, @Nullable Context context) {
        this(qs0Var, context, new lu0(xo0.a()));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qs0Var, context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((qs0) objArr2[0], (Context) objArr2[1], (lu0) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void g(@NonNull ViewGroup viewGroup, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048623, this, viewGroup, z2) == null) {
            j(z2);
            rw0.g(J0("attachToContainer(" + System.identityHashCode(viewGroup) + StringUtil.ARRAY_ELEMENT_SEPARATOR + z2 + SmallTailInfo.EMOTION_SUFFIX));
            this.e = viewGroup;
            viewGroup.addView(this.c, this.l);
            A().k();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public yo0(@NonNull qs0 qs0Var, @Nullable Context context, @Nullable lu0 lu0Var) {
        this(qs0Var, context, lu0Var, "", "");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qs0Var, context, lu0Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((qs0) objArr2[0], (Context) objArr2[1], (lu0) objArr2[2], (String) objArr2[3], (String) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public yo0(@NonNull qs0 qs0Var, @Nullable Context context, @Nullable lu0 lu0Var, @NonNull String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qs0Var, context, lu0Var, str, str2};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.k = false;
        this.n = new pr0();
        this.o = new kr0();
        this.p = new fr0();
        this.q = new hr0();
        this.s = false;
        this.t = 1.0f;
        this.u = 0;
        this.w = false;
        this.x = 2;
        this.y = qs0Var;
        this.r = str;
        this.j = str2;
        rw0.g(J0("BDVideoPlayer(" + context + ",  kernelLayer@" + System.identityHashCode(lu0Var) + ", key@" + this.r + SmallTailInfo.EMOTION_SUFFIX));
        context = context == null ? n() : context;
        h(context);
        O();
        F0(context, lu0Var);
    }

    public static boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return z;
        }
        return invokeV.booleanValue;
    }

    public kr0 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.o;
        }
        return (kr0) invokeV.objValue;
    }

    @Nullable
    public lu0 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (lu0) invokeV.objValue;
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            lu0 lu0Var = this.b;
            if (lu0Var == null) {
                return 0;
            }
            return lu0Var.R();
        }
        return invokeV.intValue;
    }

    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            lu0 lu0Var = this.b;
            if (lu0Var == null) {
                return 0;
            }
            return lu0Var.S();
        }
        return invokeV.intValue;
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.x;
        }
        return invokeV.intValue;
    }

    public float H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.t;
        }
        return invokeV.floatValue;
    }

    @NonNull
    public PlayerStatus J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            lu0 lu0Var = this.b;
            if (lu0Var == null) {
                return PlayerStatus.IDLE;
            }
            return lu0Var.T();
        }
        return (PlayerStatus) invokeV.objValue;
    }

    public jv0 K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.a;
        }
        return (jv0) invokeV.objValue;
    }

    public String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            lu0 lu0Var = this.b;
            if (lu0Var == null) {
                return "";
            }
            return lu0Var.W();
        }
        return (String) invokeV.objValue;
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            yu0 createMessenger = xo0.d().createMessenger();
            this.d = createMessenger;
            createMessenger.b(new c(this, null));
            hw0.c().a(this);
        }
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (J() == PlayerStatus.COMPLETE) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (J() == PlayerStatus.ERROR) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.s;
        }
        return invokeV.booleanValue;
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (J() == PlayerStatus.PAUSE) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return S();
        }
        return invokeV.booleanValue;
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (J() == PlayerStatus.PLAYING) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (J() == PlayerStatus.PREPARED) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (J() == PlayerStatus.STOP) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.w;
        }
        return invokeV.booleanValue;
    }

    public void a() {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            AudioManager audioManager = this.g;
            if (audioManager != null && (bVar = this.h) != null) {
                audioManager.abandonAudioFocus(bVar);
                rw0.g(J0("abandonAudioFocus()"));
                this.g = null;
                this.h = null;
            }
            this.i = false;
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            d0(0);
        }
    }

    public void f0() {
        lu0 lu0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && (lu0Var = this.b) != null) {
            lu0Var.Z();
            this.b.u0();
            this.b.b0();
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            hw0.c().g(this);
            this.d.release();
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            I().a();
            A().a();
            r().a();
            u().a();
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            rw0.g(J0("resumeFromError()"));
            lu0 lu0Var = this.b;
            if (lu0Var != null) {
                lu0Var.v0();
            }
            z0(G());
            B0(this.a.b);
            l0(false);
        }
    }

    @Nullable
    public Activity m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            ViewGroup viewGroup = this.e;
            if (viewGroup != null && (viewGroup.getContext() instanceof Activity)) {
                return (Activity) this.e.getContext();
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    @NonNull
    public Context n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return xo0.b();
        }
        return (Context) invokeV.objValue;
    }

    @Nullable
    public ViewGroup o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.e;
        }
        return (ViewGroup) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zt0
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            a();
            A().g();
            I().f(x());
        }
    }

    @Override // com.baidu.tieba.zt0
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            A().m();
        }
    }

    @Override // com.baidu.tieba.zt0
    public void onSeekComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            A().n();
        }
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            lu0 lu0Var = this.b;
            if (lu0Var == null) {
                return 0;
            }
            return lu0Var.N();
        }
        return invokeV.intValue;
    }

    @NonNull
    public fr0 r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            return this.p;
        }
        return (fr0) invokeV.objValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            lu0 lu0Var = this.b;
            if (lu0Var == null) {
                return this.a.e;
            }
            return lu0Var.O();
        }
        return invokeV.intValue;
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            lu0 lu0Var = this.b;
            if (lu0Var == null) {
                return this.a.e * 1000;
            }
            return lu0Var.P();
        }
        return invokeV.intValue;
    }

    @NonNull
    public final hr0 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            return this.q;
        }
        return (hr0) invokeV.objValue;
    }

    @Nullable
    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public LayerContainer w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            return this.c;
        }
        return (LayerContainer) invokeV.objValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            return this.u;
        }
        return invokeV.intValue;
    }

    public yu0 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            return this.d;
        }
        return (yu0) invokeV.objValue;
    }

    public void A0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.r = str;
        }
    }

    public void B0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            C0(str, true);
        }
    }

    public void D0(@Nullable lu0 lu0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, lu0Var) == null) && lu0Var != null) {
            e(lu0Var);
        }
    }

    public void b(@NonNull eu0 eu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, eu0Var) == null) {
            this.c.a(eu0Var);
        }
    }

    public void b0(int i) {
        Activity m;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048614, this, i) == null) && (m = m()) != null && !V()) {
            m.runOnUiThread(new a(this, i));
        }
    }

    public void d(@NonNull uv0 uv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, uv0Var) == null) {
            this.f.a(uv0Var);
        }
    }

    public void f(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, viewGroup) == null) {
            g(viewGroup, true);
        }
    }

    public LayerContainer i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, context)) == null) {
            return new LayerContainer(context);
        }
        return (LayerContainer) invokeL.objValue;
    }

    public void m0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i) == null) {
            r().f(i * 1000, 3);
        }
    }

    public void n0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i) == null) {
            r().f(i, 3);
        }
    }

    public void o0(@NonNull sr0 sr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, sr0Var) == null) {
            this.d.d(sr0Var);
        }
    }

    @Override // com.baidu.tieba.zt0
    public void onBufferingUpdate(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i) == null) {
            A().f(i);
        }
    }

    public void p0(@Nullable String str) {
        lu0 lu0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048650, this, str) == null) && (lu0Var = this.b) != null) {
            lu0Var.h0(str);
        }
    }

    public void q0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048652, this, z2) == null) {
            z = z2;
            u0(z2);
        }
    }

    public void s0(@Nullable ts0 ts0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, ts0Var) == null) {
            this.d.a(ts0Var);
        }
    }

    public void t0(boolean z2) {
        lu0 lu0Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048658, this, z2) != null) || (lu0Var = this.b) == null) {
            return;
        }
        lu0Var.l0(z2);
    }

    public void v0(@Nullable String str) {
        lu0 lu0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048662, this, str) == null) && (lu0Var = this.b) != null) {
            lu0Var.n0(str);
        }
    }

    public void w0(eq0 eq0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, eq0Var) == null) {
            z().s(eq0Var);
        }
    }

    public void y0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048668, this, z2) == null) {
            this.w = z2;
        }
    }

    public void C0(@NonNull String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, str, z2) == null) {
            rw0.g(J0("setVideoUrl = " + str));
            this.a.b = str;
            A().p(this.a.b, z2, C());
        }
    }

    public void F0(Context context, @Nullable lu0 lu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, context, lu0Var) == null) {
            H0();
            D0(lu0Var);
            E0(context);
            G0(context);
        }
    }

    public void c(@NonNull eu0 eu0Var, FrameLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048615, this, eu0Var, layoutParams) == null) {
            this.c.b(eu0Var, layoutParams);
        }
    }

    public void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            I().b(this.d);
            A().b(this.d);
            r().b(this.d);
            u().b(this.d);
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            rw0.g(J0("resume()"));
            if (this.b != null && U()) {
                if (!V()) {
                    i0();
                }
                r().e();
                u().e();
                I().h();
            }
        }
    }

    @Nullable
    public lu0 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            if (this.b == null) {
                return null;
            }
            rw0.g(J0("detachKernelLayer = " + System.identityHashCode(this.b)));
            lu0 lu0Var = this.b;
            this.c.f(lu0Var, true);
            lu0Var.k0(null);
            this.b = null;
            return lu0Var;
        }
        return (lu0) invokeV.objValue;
    }

    public String J0(@NonNull String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(this.r)) {
                str2 = "Player@" + System.identityHashCode(this);
            } else {
                str2 = this.r;
            }
            sb.append(str2);
            sb.append("=>");
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void d0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            rw0.g(J0("pause(" + i + SmallTailInfo.EMOTION_SUFFIX));
            if (this.b == null) {
                return;
            }
            a();
            r().d(i);
            u().d();
            I().g();
        }
    }

    public void e(@NonNull lu0 lu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, lu0Var) == null) {
            k();
            rw0.g(J0("attachKernelLayer(" + System.identityHashCode(lu0Var) + "), kernel = " + System.identityHashCode(lu0Var.U())));
            this.b = lu0Var;
            lu0Var.k0(this);
            this.c.c(lu0Var);
        }
    }

    public void j(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048629, this, z2) == null) && (this.c.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.c.getParent();
            viewGroup.removeView(this.c);
            rw0.g(J0("detachFromContainer(" + z2 + "), parent = " + System.identityHashCode(viewGroup)));
            if (z2) {
                this.c.h();
                A().l();
            }
            this.e = null;
        }
    }

    public void a0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z2) == null) {
            rw0.g(J0("mute(" + z2 + SmallTailInfo.EMOTION_SUFFIX));
            lu0 lu0Var = this.b;
            if (lu0Var == null) {
                return;
            }
            lu0Var.Y(z2);
        }
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, context) == null) {
            this.l = new ViewGroup.LayoutParams(-1, -1);
            this.a = new jv0();
            N();
            this.f = new yv0(this);
            LayerContainer i = i(context);
            this.c = i;
            i.d(this);
            this.c.setClickable(true);
            M();
        }
    }

    public void r0(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048654, this, z2) == null) && z2 && this.b != null) {
            rw0.g(J0("setHasReplaceUrl(" + z2 + SmallTailInfo.EMOTION_SUFFIX));
            this.b.w0(null);
        }
    }

    public void u0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048660, this, z2) == null) {
            rw0.g(J0("setMuteMode(" + z2 + SmallTailInfo.EMOTION_SUFFIX));
            this.s = z2;
            lu0 lu0Var = this.b;
            if (lu0Var != null) {
                lu0Var.Y(z2);
            }
            if (z2) {
                a();
            } else if (W()) {
                i0();
            }
        }
    }

    public void x0(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048666, this, f) == null) {
            this.t = f;
            lu0 lu0Var = this.b;
            if (lu0Var != null) {
                lu0Var.p0(f);
                rw0.g(J0("setSpeed(" + f + SmallTailInfo.EMOTION_SUFFIX));
            }
        }
    }

    public void z0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048670, this, i) == null) {
            rw0.g(J0("setVideoScalingMode(" + i + SmallTailInfo.EMOTION_SUFFIX));
            lu0 lu0Var = this.b;
            if (lu0Var == null) {
                return;
            }
            this.x = i;
            lu0Var.r0(i);
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            rw0.g(J0("release()"));
            I().j(x());
            k();
            f0();
            gs0.a(m(), false);
            z().r();
            a();
            h0();
            this.f.c();
            this.c.i();
            j(false);
            g0();
            this.e = null;
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048628, this) != null) || this.i) {
            return;
        }
        if (this.g == null) {
            this.g = (AudioManager) n().getSystemService("audio");
        }
        if (this.g != null) {
            if (this.h == null) {
                this.h = new b(this, null);
            }
            boolean z2 = true;
            if (this.g.requestAudioFocus(this.h, 3, 2) != 1) {
                z2 = false;
            }
            this.i = z2;
            rw0.g(J0("requestAudioFocus()"));
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            rw0.g(J0("doPlay(), status = " + J()));
            if (this.b != null && !U()) {
                if (!V()) {
                    i0();
                }
                gs0.a(m(), true);
                r().h();
                u().f();
                rw0.g(J0("doPlay, url = " + L()));
                I().i();
            }
        }
    }

    public void l0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z2) == null) {
            rw0.g(J0("resumePlayer(" + z2 + SmallTailInfo.EMOTION_SUFFIX));
            lu0 lu0Var = this.b;
            if (lu0Var == null) {
                return;
            }
            if (z2) {
                jv0 jv0Var = this.a;
                jv0Var.d = 0;
                jv0Var.e = 0;
                jv0Var.f = 0;
            } else {
                this.a.d = lu0Var.R();
                this.a.e = this.b.O();
                this.a.f = this.b.S();
            }
            if (U()) {
                j0();
            } else {
                I0();
            }
        }
    }

    @Override // com.baidu.tieba.zt0
    public boolean onError(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048643, this, i, i2, obj)) == null) {
            A().h(i, i2, obj);
            I().d(i, i2, obj);
            gs0.a(m(), false);
            return true;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.tieba.zt0
    public boolean onInfo(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048644, this, i, i2, obj)) == null) {
            A().i(i, i2, obj);
            I().e(i, i2, obj);
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.tieba.zt0
    public boolean onMediaSourceChanged(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048645, this, i, i2, obj)) == null) {
            A().j(i, i2, obj);
            return true;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.tieba.zt0
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048648, this, i, i2, i3, i4) == null) {
            A().o(i, i2, i3, i4);
        }
    }
}
