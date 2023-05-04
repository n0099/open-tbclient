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
import com.baidu.tieba.ds2;
import com.baidu.tieba.mp4;
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
/* loaded from: classes5.dex */
public class jp4 implements ds2 {
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
    public rw2 j;
    public FrameLayout k;
    public ds2.d l;
    public ds2.b m;
    public ds2.a n;
    public ds2.e o;
    public ds2.f p;
    public ds2.c q;
    public boolean r;
    public int s;

    @Override // com.baidu.tieba.ds2
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    @Override // com.baidu.tieba.ds2
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    @Override // com.baidu.tieba.ds2
    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
        }
    }

    @Override // com.baidu.tieba.ds2
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
        }
    }

    @Override // com.baidu.tieba.ds2
    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.ds2
    public void n(rw2 rw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, rw2Var) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jp4 a;

        /* loaded from: classes5.dex */
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
                    ip4.b(this.b.a.j.j, this.b.a.j.c, this.a, this.b.a.S().getWidth(), this.b.a.S().getHeight());
                }
            }
        }

        public d(jp4 jp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jp4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jp4Var;
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
                    if (jp4.t) {
                        Log.e("SwanAppVideoPlayer", "preloadVideoMetadata: ", e);
                    }
                    mediaMetadataRetriever.release();
                    ip4.a(this.a.j.j, this.a.j.c, "error", gp4.c(0));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ jp4 b;

        public a(jp4 jp4Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jp4Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jp4Var;
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
                wo4.b(G);
                wo4.a(this.a, G);
                ip4.c(this.b.j.j, this.b.j.c, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jp4 a;

        public b(jp4 jp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jp4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jp4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                wo4.b(this.a.R().G());
                this.a.R().insert();
                ip4.c(this.a.j.j, this.a.j.c, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jp4 a;

        public c(jp4 jp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jp4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jp4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.f0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class e implements AudioManager.OnAudioFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jp4 a;

        public e(jp4 jp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jp4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jp4Var;
        }

        public /* synthetic */ e(jp4 jp4Var, a aVar) {
            this(jp4Var);
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != -1) {
                    if (i == 1) {
                        this.a.S().X();
                        return;
                    }
                    return;
                }
                this.a.stop();
                this.a.e0();
                this.a.R().N(this.a.j.l, this.a.j.q);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends yo4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jp4 a;

        public f(jp4 jp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jp4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jp4Var;
        }

        @Override // com.baidu.tieba.xo4
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

        public /* synthetic */ f(jp4 jp4Var, a aVar) {
            this(jp4Var);
        }

        @Override // com.baidu.tieba.xo4
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d = false;
                ip4.a(this.a.j.j, this.a.j.c, "ended", new JSONObject());
                if (this.a.n != null) {
                    this.a.n.b(this.a);
                }
                this.a.i = true;
                this.a.S().c0(MediaTipStateLayer.TipState.END);
                x42.b("video", "onEnded call back");
            }
        }

        @Override // com.baidu.tieba.xo4
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                ip4.a(this.a.j.j, this.a.j.c, "pause", new JSONObject());
                x42.b("video", "onPaused call back");
                this.a.d = true;
                if (this.a.q != null) {
                    this.a.q.c(this.a);
                }
            }
        }

        @Override // com.baidu.tieba.yo4, com.baidu.tieba.xo4
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                super.onResume();
                ip4.a(this.a.j.j, this.a.j.c, "play", new JSONObject());
                this.a.i = false;
                this.a.d = false;
                this.a.R().K();
                if (this.a.o != null) {
                    this.a.o.a(this.a);
                }
            }
        }

        @Override // com.baidu.tieba.xo4
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                ip4.a(this.a.j.j, this.a.j.c, "play", new JSONObject());
                this.a.i = false;
                this.a.d = false;
                this.a.R().K();
                if (this.a.p != null) {
                    this.a.p.d(this.a);
                }
            }
        }

        @Override // com.baidu.tieba.xo4
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.a.j.k = z;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("muted", Boolean.valueOf(z));
                } catch (JSONException e) {
                    if (jp4.t) {
                        e.printStackTrace();
                    }
                }
                ip4.a(this.a.j.j, this.a.j.c, "muted", jSONObject);
            }
        }

        @Override // com.baidu.tieba.xo4
        public void c(SwanVideoView swanVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, swanVideoView) == null) {
                int currentPosition = swanVideoView.getCurrentPosition() / 1000;
                int duration = swanVideoView.getDuration() / 1000;
                int bufferPercentage = (swanVideoView.getBufferPercentage() * duration) / 100;
                if (currentPosition >= bufferPercentage && currentPosition != 0 && (currentPosition <= 0 || bufferPercentage != 0)) {
                    x42.b("SwanAppVideoPlayer", String.format("onInfo wait progress : %s, buffer : %s, duration : %s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                    ip4.a(this.a.j.j, this.a.j.c, "waiting", new JSONObject());
                    return;
                }
                x42.b("SwanAppVideoPlayer", String.format("onInfo update progress : %s, buffer : %s, duration :%s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                e(currentPosition, duration);
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
                    if (jp4.t) {
                        e.printStackTrace();
                    }
                }
                ip4.a(this.a.j.j, this.a.j.c, "timeupdate", jSONObject);
            }
        }

        @Override // com.baidu.tieba.xo4
        public void onError(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, str) == null) {
                this.a.d = false;
                x42.c("video", "errorCode :" + i);
                this.a.R().J();
                this.a.R().K();
                ip4.a(this.a.j.j, this.a.j.c, "error", gp4.c(i2));
                if (this.a.m != null) {
                    this.a.m.f(this.a, i, i2);
                }
                this.a.i = false;
                int currentPosition = this.a.S().getCurrentPosition();
                jp4 jp4Var = this.a;
                if (currentPosition <= 0) {
                    currentPosition = jp4Var.s;
                }
                jp4Var.s = currentPosition;
                this.a.S().c0(MediaTipStateLayer.TipState.ERROR);
                x42.c("video", "onError what " + i + " ,extra " + i2);
            }
        }

        @Override // com.baidu.tieba.xo4
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                x42.b("video", "onPrepared call back");
                this.a.a0();
                this.a.P();
                if (this.a.l != null) {
                    this.a.l.e(this.a);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947890971, "Lcom/baidu/tieba/jp4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947890971, "Lcom/baidu/tieba/jp4;");
                return;
            }
        }
        t = ho1.a;
    }

    public jp4() {
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

    public final void P() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && !this.g) {
            pause();
        }
    }

    public final VideoContainerManager R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.j == null) {
                q42.a("SwanAppVideoPlayer", "getContainerManager with a null mParams");
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
            x42.i("video", "create player");
            this.a = new SwanVideoView(this.b);
            T();
        }
    }

    public final boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.r;
        }
        return invokeV.booleanValue;
    }

    public void Z() {
        SwanVideoView swanVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (swanVideoView = this.a) != null) {
            swanVideoView.Z();
            wo4.b(this.a);
            this.a = null;
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            R().M(new c(this));
        }
    }

    public final void g0() {
        SwanVideoView swanVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (swanVideoView = this.a) != null) {
            swanVideoView.Z();
        }
    }

    @Override // com.baidu.tieba.ds2
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return S().getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ds2
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return S().getDuration();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ds2
    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ds2
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

    public final void j0() {
        SwanVideoView swanVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048613, this) != null) || (swanVideoView = this.a) == null) {
            return;
        }
        wo4.b(swanVideoView);
        FrameLayout frameLayout = this.k;
        if (frameLayout != null) {
            frameLayout.addView(this.a);
        } else {
            R().H().addView(this.a);
        }
    }

    @Override // com.baidu.tieba.ds2
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (V() && Y()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ds2
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            S().C();
            this.d = true;
        }
    }

    @Override // com.baidu.tieba.ds2
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

    @Override // com.baidu.tieba.ds2
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            x42.b("video", "stop");
            Z();
            S().D();
        }
    }

    public final void Q(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
            activity.getWindow().getDecorView().setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.ds2
    public void a(FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, frameLayout) == null) {
            this.k = frameLayout;
        }
    }

    @Override // com.baidu.tieba.ds2
    public void g(ds2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, aVar) == null) {
            this.n = aVar;
        }
    }

    public void i0(rw2 rw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, rw2Var) == null) {
            R().O(rw2Var);
            j0();
        }
    }

    @Override // com.baidu.tieba.ds2
    public void j(ds2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, eVar) == null) {
            this.o = eVar;
        }
    }

    @Override // com.baidu.tieba.ds2
    public void k(ds2.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, fVar) == null) {
            this.p = fVar;
        }
    }

    @Override // com.baidu.tieba.ds2
    public void m(ds2.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, dVar) == null) {
            this.l = dVar;
        }
    }

    @Override // com.baidu.tieba.ds2
    public void mute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            S().setMuted(z);
        }
    }

    @Override // com.baidu.tieba.ds2
    public void p(ds2.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, bVar) == null) {
            this.m = bVar;
        }
    }

    @Override // com.baidu.tieba.ds2
    public int q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, str)) == null) {
            return S().I(str);
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.ds2
    public void r(ds2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, cVar) == null) {
            this.q = cVar;
        }
    }

    @Override // com.baidu.tieba.ds2
    public void seekTo(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048627, this, i) != null) || !k0()) {
            return;
        }
        if (!this.f) {
            S().H(i);
        } else {
            this.e = i;
        }
    }

    public jp4 O(Context context, @NonNull rw2 rw2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, rw2Var)) == null) {
            this.b = context;
            this.j = rw2Var;
            R();
            return this;
        }
        return (jp4) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ds2
    public /* bridge */ /* synthetic */ ds2 e(Context context, @NonNull rw2 rw2Var) {
        O(context, rw2Var);
        return this;
    }

    public final void M(rw2 rw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, rw2Var) == null) {
            rw2 rw2Var2 = this.j;
            if (rw2Var2 != null && rw2Var != null && !TextUtils.isEmpty(rw2Var2.y) && !TextUtils.isEmpty(rw2Var.y) && !TextUtils.equals(this.j.y, rw2Var.y)) {
                this.f = true;
            } else {
                this.f = false;
            }
        }
    }

    public final void b0(rw2 rw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, rw2Var) == null) {
            if (rw2Var == null) {
                x42.c("SwanAppVideoPlayer", "setDataSource params is null!");
                return;
            }
            S().setVideoPath(this.j.y);
            x42.b("video", "setDataSource url " + rw2Var.y);
        }
    }

    public final void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            if (t) {
                Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
            }
            if (this.a != null && !z && isPlaying()) {
                this.a.C();
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

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (!SwanAppNetworkUtils.h()) {
                rw2 rw2Var = this.j;
                ip4.a(rw2Var.j, rw2Var.c, "error", gp4.c(0));
                return;
            }
            if (!this.j.i() || !this.j.o()) {
                U();
                i0(this.j);
            }
            rk3.k(new d(this), "preloadVideoMetadata");
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || !k0()) {
            return;
        }
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

    public final boolean X() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            x73 M = x73.M();
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
            x73 M = x73.M();
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

    public final void a0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || !k0()) {
            return;
        }
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

    public final boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            rw2 rw2Var = this.j;
            if (rw2Var != null && !TextUtils.isEmpty(rw2Var.y) && !TextUtils.isEmpty(this.j.j) && !TextUtils.isEmpty(this.j.b)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void c0(rw2 rw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, rw2Var) == null) {
            if (rw2Var.S) {
                S().W(true);
                S().V(rw2Var.U);
                S().setSilentTips(rw2Var.V);
                mute(true);
            } else {
                S().W(false);
                mute(rw2Var.k);
            }
            mp4.b bVar = new mp4.b();
            bVar.k(rw2Var.S);
            bVar.i(rw2Var.L);
            bVar.h(rw2Var.D);
            bVar.g(rw2Var.M);
            bVar.j(rw2Var.H);
            S().setMediaGesture(bVar.f());
            S().setMediaControllerEnabled(rw2Var.x);
            S().setLooping(rw2Var.p);
            S().M(rw2Var.G);
            S().N(rw2Var.m());
            S().K(rw2Var.k());
            S().O(rw2Var.n());
            S().P(rw2Var.P);
            S().L(rw2Var.w);
            S().S(rw2Var.E);
            S().T(rw2Var.R);
            S().setTitle(rw2Var.K);
            if (TextUtils.equals(rw2Var.q, AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY)) {
                S().setVideoScalingMode(2);
            } else if (TextUtils.equals(rw2Var.q, "fill")) {
                S().setVideoScalingMode(3);
            } else {
                S().setVideoScalingMode(1);
            }
            l(rw2Var.Q, rw2Var.F);
        }
    }

    public final boolean d0(rw2 rw2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, rw2Var)) == null) {
            rw2 rw2Var2 = this.j;
            if (rw2Var2 == null) {
                return false;
            }
            if (rw2Var2.k == rw2Var.k && rw2Var2.x == rw2Var.x && TextUtils.equals(rw2Var2.q, rw2Var.q)) {
                rw2 rw2Var3 = this.j;
                if (rw2Var3.H == rw2Var.H && rw2Var3.D == rw2Var.D && rw2Var3.E == rw2Var.E && rw2Var3.G == rw2Var.G && rw2Var3.L == rw2Var.L && rw2Var3.S == rw2Var.S && rw2Var3.F == rw2Var.F && rw2Var3.P == rw2Var.P && rw2Var3.n() == rw2Var.n() && this.j.k() == rw2Var.k() && this.j.m() == rw2Var.m() && this.j.l() == rw2Var.l() && TextUtils.equals(this.j.K, rw2Var.K)) {
                    rw2 rw2Var4 = this.j;
                    if (rw2Var4.R == rw2Var.R && rw2Var4.Q == rw2Var.Q && rw2Var4.M == rw2Var.M && rw2Var4.p == rw2Var.p) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ds2
    public void h(rw2 rw2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048606, this, rw2Var, z) == null) {
            if (t) {
                Log.e("SwanAppVideoPlayer", "fromUpdateAction=" + z + " params:" + rw2Var.toString());
            }
            x42.b("video", "updatePlayerConfigInternal params: " + rw2Var.toString());
            if (d0(rw2Var)) {
                c0(rw2Var);
            }
            this.j = rw2Var;
            if (z) {
                h0(rw2Var.o());
            }
            i0(rw2Var);
        }
    }

    @Override // com.baidu.tieba.ds2
    public void l(boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048616, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) != null) || np4.a() == z) {
            return;
        }
        if (z) {
            X();
        } else {
            Y();
        }
    }

    @Override // com.baidu.tieba.ds2
    public void o(rw2 rw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, rw2Var) == null) {
            x42.b("video", "Open Player " + rw2Var.j);
            M(rw2Var);
            this.j = rw2Var;
            i0(rw2Var);
            boolean j = rw2Var.j();
            this.h = j;
            if (j) {
                W();
            }
            if (rw2Var.i() && rw2Var.o()) {
                f0();
                return;
            }
            g0();
            e0();
            R().N(rw2Var.l, rw2Var.q);
        }
    }
}
