package com.bytedance.sdk.openadsdk.component.reward.b;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.o;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.t;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f65378a;

    /* renamed from: b  reason: collision with root package name */
    public View f65379b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> f65380c;

    /* renamed from: d  reason: collision with root package name */
    public Activity f65381d;

    /* renamed from: e  reason: collision with root package name */
    public m f65382e;

    /* renamed from: f  reason: collision with root package name */
    public String f65383f;

    /* renamed from: g  reason: collision with root package name */
    public long f65384g;

    /* renamed from: h  reason: collision with root package name */
    public long f65385h;

    /* renamed from: i  reason: collision with root package name */
    public long f65386i;

    /* renamed from: j  reason: collision with root package name */
    public long f65387j;
    public long k;
    public long l;
    public boolean m;

    /* renamed from: com.bytedance.sdk.openadsdk.component.reward.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1891a {
        void a(View view);

        void a(String str, JSONObject jSONObject);
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(boolean z);

        void a(boolean z, long j2, long j3, String str, String str2);

        void a(boolean z, long j2, String str, String str2);

        void a(boolean z, String str, String str2);

        void b(boolean z, long j2, long j3, String str, String str2);
    }

    public a(Activity activity) {
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
        this.f65379b = null;
        this.f65380c = Collections.synchronizedMap(new HashMap());
        this.f65384g = 0L;
        this.f65385h = 0L;
        this.f65386i = 0L;
        this.f65387j = 0L;
        this.k = 0L;
        this.l = 0L;
        this.m = false;
        this.f65381d = activity;
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                m mVar = this.f65382e;
                if (mVar == null || mVar.X() != 4) {
                    return;
                }
                this.f65378a = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f65381d, this.f65382e, this.f65383f);
                return;
            }
            this.f65378a = t.a().f();
        }
    }

    public void a(m mVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, mVar, str) == null) || this.m) {
            return;
        }
        this.m = true;
        this.f65382e = mVar;
        this.f65383f = str;
        g();
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f65378a : (com.bytedance.sdk.openadsdk.downloadnew.core.a) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f65378a != null : invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.f65378a;
            if (aVar != null) {
                aVar.a(this.f65381d);
                this.f65378a.b();
            }
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> entry : this.f65380c.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().b();
                }
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.f65378a;
            if (aVar != null) {
                aVar.c();
            }
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> entry : this.f65380c.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().c();
                }
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.f65378a;
            if (aVar != null) {
                aVar.d();
            }
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> entry : this.f65380c.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().d();
                }
            }
        }
    }

    public void a() {
        m mVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f65378a == null && (mVar = this.f65382e) != null && mVar.X() == 4) {
            this.f65378a = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f65381d, this.f65382e, this.f65383f);
        }
    }

    public void a(b bVar) {
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) || (aVar = this.f65378a) == null) {
            return;
        }
        aVar.a(new TTAppDownloadListener(this, bVar) { // from class: com.bytedance.sdk.openadsdk.component.reward.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f65388a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f65389b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, bVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f65389b = this;
                this.f65388a = bVar;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long j2, long j3, String str, String str2) {
                boolean z;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) {
                    k.b("RewardFullDownloadManager", "DownloadManager onDownloadActive");
                    if (System.currentTimeMillis() - this.f65389b.f65386i > NativeExpressView.q) {
                        this.f65389b.f65386i = System.currentTimeMillis();
                        z = true;
                    } else {
                        z = false;
                    }
                    b bVar2 = this.f65388a;
                    if (bVar2 != null) {
                        bVar2.a(z, j2, j3, str, str2);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long j2, long j3, String str, String str2) {
                boolean z;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) {
                    k.b("RewardFullDownloadManager", "DownloadManager onDownloadFailed");
                    if (System.currentTimeMillis() - this.f65389b.f65387j > NativeExpressView.q) {
                        this.f65389b.f65387j = System.currentTimeMillis();
                        z = true;
                    } else {
                        z = false;
                    }
                    b bVar2 = this.f65388a;
                    if (bVar2 != null) {
                        bVar2.b(z, j2, j3, str, str2);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long j2, String str, String str2) {
                boolean z;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
                    k.b("RewardFullDownloadManager", "DownloadManager onDownloadFinished");
                    if (System.currentTimeMillis() - this.f65389b.k > NativeExpressView.q) {
                        this.f65389b.k = System.currentTimeMillis();
                        z = true;
                    } else {
                        z = false;
                    }
                    b bVar2 = this.f65388a;
                    if (bVar2 != null) {
                        bVar2.a(z, j2, str, str2);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long j2, long j3, String str, String str2) {
                boolean z;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) {
                    k.b("RewardFullDownloadManager", "DownloadManager onDownloadPaused");
                    if (System.currentTimeMillis() - this.f65389b.f65385h > NativeExpressView.q) {
                        this.f65389b.f65385h = System.currentTimeMillis();
                        z = true;
                    } else {
                        z = false;
                    }
                    b bVar2 = this.f65388a;
                    if (bVar2 != null) {
                        bVar2.a(z, j2, j3, str, str2);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
                boolean z;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    k.b("RewardFullDownloadManager", "DownloadManager onIdle");
                    if (System.currentTimeMillis() - this.f65389b.f65384g > NativeExpressView.q) {
                        z = true;
                        this.f65389b.f65384g = System.currentTimeMillis();
                    } else {
                        z = false;
                    }
                    b bVar2 = this.f65388a;
                    if (bVar2 != null) {
                        bVar2.a(z);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String str, String str2) {
                boolean z;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048581, this, str, str2) == null) {
                    k.b("RewardFullDownloadManager", "DownloadManager onInstalled");
                    if (System.currentTimeMillis() - this.f65389b.l > NativeExpressView.q) {
                        z = true;
                        this.f65389b.l = System.currentTimeMillis();
                    } else {
                        z = false;
                    }
                    b bVar2 = this.f65388a;
                    if (bVar2 != null) {
                        bVar2.a(z, str, str2);
                    }
                }
            }
        });
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (this.f65380c.containsKey(str)) {
                com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.f65380c.get(str);
                if (aVar != null) {
                    aVar.e();
                    return;
                }
                return;
            }
            com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f65381d, str, this.f65382e, this.f65383f);
            this.f65380c.put(str, a2);
            a2.e();
        }
    }

    public void a(InterfaceC1891a interfaceC1891a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC1891a) == null) {
            this.f65378a.a(1, new a.InterfaceC1912a(this, interfaceC1891a) { // from class: com.bytedance.sdk.openadsdk.component.reward.b.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ InterfaceC1891a f65390a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f65391b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, interfaceC1891a};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f65391b = this;
                    this.f65390a = interfaceC1891a;
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a.InterfaceC1912a
                public boolean a(int i2, m mVar, String str, String str2, Object obj) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), mVar, str, str2, obj})) == null) {
                        if (i2 == 1 && mVar != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                            if (str.equals("rewarded_video") && str2.equals("click_start")) {
                                this.f65390a.a(this.f65391b.f65379b);
                                this.f65391b.f65379b = null;
                                return true;
                            } else if (str.equals("fullscreen_interstitial_ad") && str2.equals("click_start")) {
                                this.f65390a.a(this.f65391b.f65379b);
                                this.f65391b.f65379b = null;
                                return true;
                            } else {
                                if (!str.equals("fullscreen_interstitial_ad") && !str.equals("rewarded_video")) {
                                    if (str.equals("rewarded_video_landingpage") && "click_open".equals(str2) && o.j(this.f65391b.f65382e)) {
                                        com.bytedance.sdk.openadsdk.e.d.h(this.f65391b.f65381d, this.f65391b.f65382e, str, "click_play_open", null);
                                        return true;
                                    }
                                } else {
                                    char c2 = 65535;
                                    int hashCode = str2.hashCode();
                                    if (hashCode != -1297985154) {
                                        if (hashCode != -777040223) {
                                            if (hashCode == 1682049151 && str2.equals("click_pause")) {
                                                c2 = 0;
                                            }
                                        } else if (str2.equals("click_open")) {
                                            c2 = 2;
                                        }
                                    } else if (str2.equals("click_continue")) {
                                        c2 = 1;
                                    }
                                    if (c2 == 0) {
                                        com.bytedance.sdk.openadsdk.e.d.a(this.f65391b.f65381d, this.f65391b.f65382e, str, "click_play_pause", (Map<String, Object>) null);
                                    } else if (c2 == 1) {
                                        com.bytedance.sdk.openadsdk.e.d.a(this.f65391b.f65381d, this.f65391b.f65382e, str, "click_play_continue", (Map<String, Object>) null);
                                        return true;
                                    } else if (c2 == 2) {
                                        com.bytedance.sdk.openadsdk.e.d.h(this.f65391b.f65381d, this.f65391b.f65382e, str, "click_play_open", null);
                                        return true;
                                    }
                                }
                                return true;
                            }
                        }
                        return true;
                    }
                    return invokeCommon.booleanValue;
                }
            });
        }
    }

    public void a(View view, InterfaceC1891a interfaceC1891a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, interfaceC1891a) == null) {
            if (this.f65378a != null) {
                if (view.getId() == com.bytedance.sdk.component.utils.t.e(this.f65381d, "tt_rb_score")) {
                    interfaceC1891a.a("click_play_star_level", null);
                    return;
                } else if (view.getId() == com.bytedance.sdk.component.utils.t.e(this.f65381d, "tt_comment_vertical")) {
                    interfaceC1891a.a("click_play_star_nums", null);
                    return;
                } else if (view.getId() == com.bytedance.sdk.component.utils.t.e(this.f65381d, "tt_reward_ad_appname")) {
                    interfaceC1891a.a("click_play_source", null);
                    return;
                } else if (view.getId() == com.bytedance.sdk.component.utils.t.e(this.f65381d, "tt_reward_ad_icon")) {
                    interfaceC1891a.a("click_play_logo", null);
                    return;
                } else {
                    return;
                }
            }
            interfaceC1891a.a(view);
        }
    }
}
