package com.bytedance.sdk.openadsdk.component.reward.b;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.HomeWatcherReceiver;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.o;
import com.bytedance.sdk.openadsdk.i.f;
import com.bytedance.sdk.openadsdk.i.g;
import com.bytedance.sdk.openadsdk.q.q;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class b implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public g f66083a;

    /* renamed from: b  reason: collision with root package name */
    public int f66084b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f66085c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66086d;

    /* renamed from: e  reason: collision with root package name */
    public Activity f66087e;

    /* renamed from: f  reason: collision with root package name */
    public m f66088f;

    /* renamed from: g  reason: collision with root package name */
    public e f66089g;

    /* renamed from: h  reason: collision with root package name */
    public String f66090h;

    /* renamed from: i  reason: collision with root package name */
    public HomeWatcherReceiver f66091i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f66092j;
    public boolean k;
    public c l;
    public boolean m;
    public boolean n;

    public b(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66092j = false;
        this.f66084b = -1;
        this.f66086d = false;
        this.k = false;
        this.n = false;
        this.f66087e = activity;
    }

    private void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && o.a(this.f66088f)) {
            try {
                HomeWatcherReceiver homeWatcherReceiver = new HomeWatcherReceiver();
                this.f66091i = homeWatcherReceiver;
                homeWatcherReceiver.a(new HomeWatcherReceiver.a(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.b.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ b f66093a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f66093a = this;
                    }

                    @Override // com.bytedance.sdk.component.utils.HomeWatcherReceiver.a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f66093a.f66086d = true;
                        }
                    }

                    @Override // com.bytedance.sdk.component.utils.HomeWatcherReceiver.a
                    public void b() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.f66093a.f66086d = true;
                        }
                    }
                });
                this.f66087e.getApplicationContext().registerReceiver(this.f66091i, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
            } catch (Throwable unused) {
            }
        }
    }

    private void r() {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && o.a(this.f66088f) && (gVar = this.f66083a) != null) {
            gVar.a(this);
            this.f66083a.b();
        }
    }

    private void s() {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && o.a(this.f66088f) && (gVar = this.f66083a) != null) {
            gVar.c();
            this.f66083a.a((f) null);
        }
    }

    public void a(e eVar, m mVar, String str, c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, eVar, mVar, str, cVar) == null) || this.n) {
            return;
        }
        this.n = true;
        this.f66089g = eVar;
        this.f66088f = mVar;
        this.f66090h = str;
        this.l = cVar;
        f();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && o.a(this.f66088f)) {
            this.m = true;
        }
    }

    public void c() {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && o.a(this.f66088f)) {
            this.f66092j = true;
            r();
            if ((this.m || p()) && !this.f66085c && (gVar = this.f66083a) != null && gVar.d() == 0) {
                this.f66085c = true;
                this.l.b(true);
                this.f66089g.a(true);
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && o.a(this.f66088f)) {
            this.f66092j = false;
            if (o.j(this.f66088f)) {
                j();
                a("go_background");
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && o.a(this.f66088f)) {
            a(this.f66087e);
            s();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && o.a(this.f66088f)) {
            if (o.j(this.f66088f)) {
                q();
            }
            g gVar = new g(this.f66087e.getApplicationContext());
            this.f66083a = gVar;
            gVar.a(this);
            this.f66084b = this.f66083a.d();
            k.b("onVolumeChanged", "onCreate >>>>>> mVolume = " + this.f66084b);
            if (this.f66084b == 0) {
                this.f66085c = true;
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && o.a(this.f66088f)) {
            this.f66089g.v();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && o.a(this.f66088f)) {
            this.f66089g.u();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && o.a(this.f66088f)) {
            this.k = true;
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && o.a(this.f66088f)) {
            this.f66089g.z();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && o.a(this.f66088f)) {
            this.f66089g.A();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && o.a(this.f66088f)) {
            HashMap hashMap = new HashMap();
            if (this.f66088f.V() != null) {
                hashMap.put("playable_url", this.f66088f.V().j());
            }
            com.bytedance.sdk.openadsdk.e.d.j(this.f66087e, this.f66088f, this.f66090h, "click_playable_download_button_loading", hashMap);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && o.a(this.f66088f)) {
            if (this.m || p()) {
                boolean z = !this.f66085c;
                this.f66085c = z;
                this.f66089g.a(z);
            }
        }
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? o.j(this.f66088f) ? "playable" : o.k(this.f66088f) ? this.m ? "playable" : "video_player" : "endcard" : (String) invokeV.objValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (p()) {
                k.b("RewardFullPlayableManager", "exitPrePosePlayable");
                this.f66089g.D();
                this.l.e(false);
                this.l.c(false);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f66089g.G() : invokeV.booleanValue;
    }

    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            if (o.a(this.f66088f) && !this.k) {
                int d2 = q.d(this.f66088f.ao());
                boolean a2 = this.f66089g.a(i2);
                int l = com.bytedance.sdk.openadsdk.core.o.h().l(String.valueOf(d2));
                if (l == 0) {
                    return a2 && this.f66089g.t();
                } else if (l == 1) {
                    return a2;
                } else {
                    return false;
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && o.a(this.f66088f)) {
            this.f66089g.w();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            k.b("RewardFullPlayableManager", "startPrePosePlayable");
            this.f66089g.C();
            this.l.e(true);
            this.l.c(true);
            a(z);
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, this, context) == null) && o.a(this.f66088f)) {
            try {
                this.f66091i.a(null);
                context.unregisterReceiver(this.f66091i);
            } catch (Throwable unused) {
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && o.a(this.f66088f) && this.f66086d) {
            HashMap hashMap = new HashMap();
            hashMap.put("duration", Long.valueOf(this.f66089g.y()));
            com.bytedance.sdk.openadsdk.e.d.g(this.f66087e, this.f66088f, this.f66090h, str, hashMap);
            if ("return_foreground".equals(str)) {
                this.f66086d = false;
            }
        }
    }

    public void a(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, map) == null) && o.a(this.f66088f) && map != null) {
            map.put("duration", Long.valueOf(this.f66089g.y()));
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.b.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) && o.a(this.f66088f)) {
            this.f66089g.a(eVar);
        }
    }

    public void a(int i2, com.bytedance.sdk.openadsdk.core.widget.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, dVar) == null) && o.a(this.f66088f)) {
            String str = "试玩时长达标才能领取奖励";
            if (com.bytedance.sdk.openadsdk.core.o.h().l(String.valueOf(i2)) != 1 && this.f66089g.t()) {
                str = "试玩后才能领取奖励";
            }
            dVar.a(str).b("继续试玩").c("放弃奖励");
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && this.f66089g.E()) {
            boolean z2 = z || this.f66083a.d() == 0;
            this.f66085c = z2;
            this.l.b(z2);
            this.f66089g.a(z2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.f
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f66084b = i2;
            if ((this.m || p()) && this.f66092j) {
                boolean z = i2 == 0;
                this.f66085c = z;
                this.l.b(z);
                this.f66089g.a(this.f66085c);
            }
        }
    }
}
