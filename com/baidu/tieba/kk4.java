package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.videoplayer.SwanVideoView;
import com.baidu.swan.videoplayer.media.video.VideoContainerManager;
import com.baidu.swan.videoplayer.widget.MediaTipStateLayer;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.en2;
import com.baidu.tieba.nk4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes4.dex */
public class kk4 implements en2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanVideoView a;
    public Context b;
    public VideoContainerManager c;
    public boolean d;
    public int e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public sr2 j;
    public FrameLayout k;
    public en2.d l;
    public en2.b m;
    public en2.a n;
    public en2.e o;
    public en2.f p;
    public en2.c q;
    public boolean r;
    public int s;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ kk4 b;

        public a(kk4 kk4Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kk4Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kk4Var;
            this.a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.setRequestedOrientation(0);
                this.a.getWindow().addFlags(1024);
                this.b.Q(this.a);
                SwanAppComponentContainerView G = this.b.R().G();
                G.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                xj4.b(G);
                xj4.a(this.a, G);
                jk4.c(this.b.j.j, this.b.j.c, true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kk4 a;

        public b(kk4 kk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kk4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                xj4.b(this.a.R().G());
                this.a.R().insert();
                jk4.c(this.a.j.j, this.a.j.c, false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kk4 a;

        public c(kk4 kk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kk4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.f0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kk4 a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ d b;

            public a(d dVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = dVar;
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    jk4.b(this.b.a.j.j, this.b.a.j.c, this.a, this.b.a.S().getWidth(), this.b.a.S().getHeight());
                }
            }
        }

        public d(kk4 kk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kk4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever.setDataSource(this.a.j.y, new HashMap());
                    String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                    mediaMetadataRetriever.release();
                    this.a.S().post(new a(this, extractMetadata));
                } catch (RuntimeException e) {
                    if (kk4.t) {
                        Log.e("SwanAppVideoPlayer", "preloadVideoMetadata: ", e);
                    }
                    mediaMetadataRetriever.release();
                    jk4.a(this.a.j.j, this.a.j.c, "error", hk4.c(0));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public final class e implements AudioManager.OnAudioFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kk4 a;

        public e(kk4 kk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kk4Var;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != -1) {
                    if (i != 1) {
                        return;
                    }
                    this.a.S().X();
                    return;
                }
                this.a.stop();
                this.a.e0();
                this.a.R().N(this.a.j.l, this.a.j.q);
            }
        }

        public /* synthetic */ e(kk4 kk4Var, a aVar) {
            this(kk4Var);
        }
    }

    /* loaded from: classes4.dex */
    public class f extends zj4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kk4 a;

        public f(kk4 kk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kk4Var;
        }

        @Override // com.baidu.tieba.yj4
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d = false;
                jk4.a(this.a.j.j, this.a.j.c, "ended", new JSONObject());
                if (this.a.n != null) {
                    this.a.n.b(this.a);
                }
                this.a.i = true;
                this.a.S().c0(MediaTipStateLayer.TipState.END);
                yz1.b("video", "onEnded call back");
            }
        }

        @Override // com.baidu.tieba.yj4
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.a.j.k = z;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("muted", Boolean.valueOf(z));
                } catch (JSONException e) {
                    if (kk4.t) {
                        e.printStackTrace();
                    }
                }
                jk4.a(this.a.j.j, this.a.j.c, "muted", jSONObject);
            }
        }

        @Override // com.baidu.tieba.yj4
        public void c(SwanVideoView swanVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, swanVideoView) == null) {
                int currentPosition = swanVideoView.getCurrentPosition() / 1000;
                int duration = swanVideoView.getDuration() / 1000;
                int bufferPercentage = (swanVideoView.getBufferPercentage() * duration) / 100;
                if (currentPosition >= bufferPercentage && currentPosition != 0 && (currentPosition <= 0 || bufferPercentage != 0)) {
                    yz1.b("SwanAppVideoPlayer", String.format("onInfo wait progress : %s, buffer : %s, duration : %s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                    jk4.a(this.a.j.j, this.a.j.c, "waiting", new JSONObject());
                    return;
                }
                yz1.b("SwanAppVideoPlayer", String.format("onInfo update progress : %s, buffer : %s, duration :%s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                e(currentPosition, duration);
            }
        }

        @Override // com.baidu.tieba.yj4
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.a.j.Q = z;
                if (z) {
                    this.a.X();
                } else {
                    this.a.Y();
                }
            }
        }

        public final void e(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("duration", Integer.valueOf(i2));
                    jSONObject.putOpt("currentTime", Integer.valueOf(i));
                } catch (JSONException e) {
                    if (kk4.t) {
                        e.printStackTrace();
                    }
                }
                jk4.a(this.a.j.j, this.a.j.c, "timeupdate", jSONObject);
            }
        }

        @Override // com.baidu.tieba.yj4
        public void onError(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, str) == null) {
                this.a.d = false;
                yz1.c("video", "errorCode :" + i);
                this.a.R().J();
                this.a.R().K();
                jk4.a(this.a.j.j, this.a.j.c, "error", hk4.c(i2));
                if (this.a.m != null) {
                    this.a.m.f(this.a, i, i2);
                }
                this.a.i = false;
                int currentPosition = this.a.S().getCurrentPosition();
                kk4 kk4Var = this.a;
                if (currentPosition <= 0) {
                    currentPosition = kk4Var.s;
                }
                kk4Var.s = currentPosition;
                this.a.S().c0(MediaTipStateLayer.TipState.ERROR);
                yz1.c("video", "onError what " + i + " ,extra " + i2);
            }
        }

        @Override // com.baidu.tieba.yj4
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                jk4.a(this.a.j.j, this.a.j.c, "pause", new JSONObject());
                yz1.b("video", "onPaused call back");
                this.a.d = true;
                if (this.a.q != null) {
                    this.a.q.c(this.a);
                }
            }
        }

        @Override // com.baidu.tieba.yj4
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                yz1.b("video", "onPrepared call back");
                this.a.a0();
                this.a.P();
                if (this.a.l != null) {
                    this.a.l.e(this.a);
                }
            }
        }

        @Override // com.baidu.tieba.zj4, com.baidu.tieba.yj4
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                super.onResume();
                jk4.a(this.a.j.j, this.a.j.c, "play", new JSONObject());
                this.a.i = false;
                this.a.d = false;
                this.a.R().K();
                if (this.a.o != null) {
                    this.a.o.a(this.a);
                }
            }
        }

        @Override // com.baidu.tieba.yj4
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                jk4.a(this.a.j.j, this.a.j.c, "play", new JSONObject());
                this.a.i = false;
                this.a.d = false;
                this.a.R().K();
                if (this.a.p != null) {
                    this.a.p.d(this.a);
                }
            }
        }

        public /* synthetic */ f(kk4 kk4Var, a aVar) {
            this(kk4Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947915957, "Lcom/baidu/tieba/kk4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947915957, "Lcom/baidu/tieba/kk4;");
                return;
            }
        }
        t = ij1.a;
    }

    public kk4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = true;
        this.s = 0;
    }

    public final void M(sr2 sr2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sr2Var) == null) {
            sr2 sr2Var2 = this.j;
            if (sr2Var2 != null && sr2Var != null && !TextUtils.isEmpty(sr2Var2.y) && !TextUtils.isEmpty(sr2Var.y) && !TextUtils.equals(this.j.y, sr2Var.y)) {
                this.f = true;
            } else {
                this.f = false;
            }
        }
    }

    public final boolean N(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            if (!SwanAppNetworkUtils.h()) {
                R().J();
                R().K();
                S().c0(MediaTipStateLayer.TipState.NO_NETWORK);
                return false;
            } else if (z) {
                if (SwanAppNetworkUtils.f() == SwanAppNetworkUtils.NetType._2G || SwanAppNetworkUtils.f() == SwanAppNetworkUtils.NetType._3G || SwanAppNetworkUtils.f() == SwanAppNetworkUtils.NetType._4G || SwanAppNetworkUtils.f() == SwanAppNetworkUtils.NetType._5G) {
                    R().J();
                    R().K();
                    S().c0(MediaTipStateLayer.TipState.NO_WIFI);
                    return false;
                }
                return true;
            } else {
                return true;
            }
        }
        return invokeZ.booleanValue;
    }

    public kk4 O(Context context, @NonNull sr2 sr2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, sr2Var)) == null) {
            this.b = context;
            this.j = sr2Var;
            R();
            return this;
        }
        return (kk4) invokeLL.objValue;
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.g) {
            return;
        }
        pause();
    }

    public final void Q(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
            activity.getWindow().getDecorView().setSystemUiVisibility(5894);
        }
    }

    public final VideoContainerManager R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.j == null) {
                rz1.a("SwanAppVideoPlayer", "getContainerManager with a null mParams");
            }
            if (this.c == null) {
                this.c = new VideoContainerManager(this.b, this.j);
            }
            return this.c;
        }
        return (VideoContainerManager) invokeV.objValue;
    }

    public final SwanVideoView S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            U();
            return this.a;
        }
        return (SwanVideoView) invokeV.objValue;
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            S().setVideoPlayerCallback(new f(this, null));
            S().setAudioFocusListener(new e(this, null));
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.a == null) {
            yz1.i("video", "create player");
            this.a = new SwanVideoView(this.b);
            T();
        }
    }

    public final boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (!SwanAppNetworkUtils.h()) {
                sr2 sr2Var = this.j;
                jk4.a(sr2Var.j, sr2Var.c, "error", hk4.c(0));
                return;
            }
            if (!this.j.i() || !this.j.o()) {
                U();
                i0(this.j);
            }
            sf3.k(new d(this), "preloadVideoMetadata");
        }
    }

    public final boolean X() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            y23 M = y23.M();
            if (M == null || (activity = M.getActivity()) == null || activity.isFinishing()) {
                return false;
            }
            activity.runOnUiThread(new a(this, activity));
            this.r = true;
            this.a.setIsLandscape(true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean Y() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            y23 M = y23.M();
            if (M == null || (activity = M.getActivity()) == null || activity.isFinishing()) {
                return false;
            }
            activity.setRequestedOrientation(1);
            activity.getWindow().clearFlags(1024);
            activity.runOnUiThread(new b(this));
            this.r = false;
            this.a.setIsLandscape(false);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void Z() {
        SwanVideoView swanVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (swanVideoView = this.a) == null) {
            return;
        }
        swanVideoView.Z();
        xj4.b(this.a);
        this.a = null;
    }

    @Override // com.baidu.tieba.en2
    public void a(FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, frameLayout) == null) {
            this.k = frameLayout;
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && k0()) {
            if (this.e != 0) {
                S().H(this.e);
                this.e = 0;
                return;
            }
            int i = this.j.m;
            if (i != 0) {
                this.a.H(i * 1000);
                this.j.m = 0;
                return;
            }
            int i2 = this.s;
            if (i2 != 0) {
                this.a.H(i2);
                this.s = 0;
            }
        }
    }

    @Override // com.baidu.tieba.en2
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    public final void b0(sr2 sr2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, sr2Var) == null) {
            if (sr2Var == null) {
                yz1.c("SwanAppVideoPlayer", "setDataSource params is null!");
                return;
            }
            S().setVideoPath(this.j.y);
            yz1.b("video", "setDataSource url " + sr2Var.y);
        }
    }

    @Override // com.baidu.tieba.en2
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    public final void c0(sr2 sr2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, sr2Var) == null) {
            if (sr2Var.S) {
                S().W(true);
                S().V(sr2Var.U);
                S().setSilentTips(sr2Var.V);
                mute(true);
            } else {
                S().W(false);
                mute(sr2Var.k);
            }
            nk4.b bVar = new nk4.b();
            bVar.k(sr2Var.S);
            bVar.i(sr2Var.L);
            bVar.h(sr2Var.D);
            bVar.g(sr2Var.M);
            bVar.j(sr2Var.H);
            S().setMediaGesture(bVar.f());
            S().setMediaControllerEnabled(sr2Var.x);
            S().setLooping(sr2Var.p);
            S().M(sr2Var.G);
            S().N(sr2Var.m());
            S().K(sr2Var.k());
            S().O(sr2Var.n());
            S().P(sr2Var.P);
            S().L(sr2Var.w);
            S().S(sr2Var.E);
            S().T(sr2Var.R);
            S().setTitle(sr2Var.K);
            if (TextUtils.equals(sr2Var.q, AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY)) {
                S().setVideoScalingMode(2);
            } else if (TextUtils.equals(sr2Var.q, "fill")) {
                S().setVideoScalingMode(3);
            } else {
                S().setVideoScalingMode(1);
            }
            l(sr2Var.Q, sr2Var.F);
        }
    }

    @Override // com.baidu.tieba.en2
    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
        }
    }

    public final boolean d0(sr2 sr2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, sr2Var)) == null) {
            sr2 sr2Var2 = this.j;
            if (sr2Var2 == null) {
                return false;
            }
            if (sr2Var2.k == sr2Var.k && sr2Var2.x == sr2Var.x && TextUtils.equals(sr2Var2.q, sr2Var.q)) {
                sr2 sr2Var3 = this.j;
                if (sr2Var3.H == sr2Var.H && sr2Var3.D == sr2Var.D && sr2Var3.E == sr2Var.E && sr2Var3.G == sr2Var.G && sr2Var3.L == sr2Var.L && sr2Var3.S == sr2Var.S && sr2Var3.F == sr2Var.F && sr2Var3.P == sr2Var.P && sr2Var3.n() == sr2Var.n() && this.j.k() == sr2Var.k() && this.j.m() == sr2Var.m() && this.j.l() == sr2Var.l() && TextUtils.equals(this.j.K, sr2Var.K)) {
                    sr2 sr2Var4 = this.j;
                    if (sr2Var4.R == sr2Var.R && sr2Var4.Q == sr2Var.Q && sr2Var4.M == sr2Var.M && sr2Var4.p == sr2Var.p) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.en2
    public /* bridge */ /* synthetic */ en2 e(Context context, @NonNull sr2 sr2Var) {
        O(context, sr2Var);
        return this;
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            R().M(new c(this));
        }
    }

    @Override // com.baidu.tieba.en2
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && k0()) {
            R().J();
            Z();
            S().B();
            c0(this.j);
            h(this.j, false);
            b0(this.j);
            if (N(this.j.J)) {
                S().Y();
            }
            this.f = false;
        }
    }

    @Override // com.baidu.tieba.en2
    public void g(en2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, aVar) == null) {
            this.n = aVar;
        }
    }

    public final void g0() {
        SwanVideoView swanVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (swanVideoView = this.a) == null) {
            return;
        }
        swanVideoView.Z();
    }

    @Override // com.baidu.tieba.en2
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? S().getCurrentPosition() : invokeV.intValue;
    }

    @Override // com.baidu.tieba.en2
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? S().getDuration() : invokeV.intValue;
    }

    @Override // com.baidu.tieba.en2
    public void h(sr2 sr2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048606, this, sr2Var, z) == null) {
            if (t) {
                Log.e("SwanAppVideoPlayer", "fromUpdateAction=" + z + " params:" + sr2Var.toString());
            }
            yz1.b("video", "updatePlayerConfigInternal params: " + sr2Var.toString());
            if (d0(sr2Var)) {
                c0(sr2Var);
            }
            this.j = sr2Var;
            if (z) {
                h0(sr2Var.o());
            }
            i0(sr2Var);
        }
    }

    public final void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            if (t) {
                Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
            }
            if (this.a == null || z || !isPlaying()) {
                return;
            }
            this.a.C();
        }
    }

    @Override // com.baidu.tieba.en2
    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
        }
    }

    public void i0(sr2 sr2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, sr2Var) == null) {
            R().O(sr2Var);
            j0();
        }
    }

    @Override // com.baidu.tieba.en2
    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.i : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.en2
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            SwanVideoView swanVideoView = this.a;
            if (swanVideoView == null) {
                return false;
            }
            return swanVideoView.z();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.en2
    public void j(en2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, eVar) == null) {
            this.o = eVar;
        }
    }

    public final void j0() {
        SwanVideoView swanVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (swanVideoView = this.a) == null) {
            return;
        }
        xj4.b(swanVideoView);
        FrameLayout frameLayout = this.k;
        if (frameLayout != null) {
            frameLayout.addView(this.a);
        } else {
            R().H().addView(this.a);
        }
    }

    @Override // com.baidu.tieba.en2
    public void k(en2.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, fVar) == null) {
            this.p = fVar;
        }
    }

    public final boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            sr2 sr2Var = this.j;
            return (sr2Var == null || TextUtils.isEmpty(sr2Var.y) || TextUtils.isEmpty(this.j.j) || TextUtils.isEmpty(this.j.b)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.en2
    public void l(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || ok4.a() == z) {
            return;
        }
        if (z) {
            X();
        } else {
            Y();
        }
    }

    @Override // com.baidu.tieba.en2
    public void m(en2.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, dVar) == null) {
            this.l = dVar;
        }
    }

    @Override // com.baidu.tieba.en2
    public void mute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            S().setMuted(z);
        }
    }

    @Override // com.baidu.tieba.en2
    public void n(sr2 sr2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, sr2Var) == null) {
        }
    }

    @Override // com.baidu.tieba.en2
    public void o(sr2 sr2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, sr2Var) == null) {
            yz1.b("video", "Open Player " + sr2Var.j);
            M(sr2Var);
            this.j = sr2Var;
            i0(sr2Var);
            boolean j = sr2Var.j();
            this.h = j;
            if (j) {
                W();
            }
            if (sr2Var.i() && sr2Var.o()) {
                f0();
                return;
            }
            g0();
            e0();
            R().N(sr2Var.l, sr2Var.q);
        }
    }

    @Override // com.baidu.tieba.en2
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? V() && Y() : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.en2
    public void p(en2.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, bVar) == null) {
            this.m = bVar;
        }
    }

    @Override // com.baidu.tieba.en2
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            S().C();
            this.d = true;
        }
    }

    @Override // com.baidu.tieba.en2
    public int q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, str)) == null) ? S().I(str) : invokeL.intValue;
    }

    @Override // com.baidu.tieba.en2
    public void r(en2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, cVar) == null) {
            this.q = cVar;
        }
    }

    @Override // com.baidu.tieba.en2
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            if (this.d && !this.f) {
                S().X();
            } else {
                f0();
            }
        }
    }

    @Override // com.baidu.tieba.en2
    public void seekTo(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048627, this, i) == null) && k0()) {
            if (!this.f) {
                S().H(i);
            } else {
                this.e = i;
            }
        }
    }

    @Override // com.baidu.tieba.en2
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            yz1.b("video", IntentConfig.STOP);
            Z();
            S().D();
        }
    }
}
