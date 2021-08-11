package com.bytedance.sdk.openadsdk.component.splash;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.launch.stats.ActivitySpeedStats;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.NetResponse;
import com.bytedance.sdk.component.net.callback.NetCallback;
import com.bytedance.sdk.component.net.executor.DownloadExecutor;
import com.bytedance.sdk.component.net.executor.NetExecutor;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.q;
import com.bytedance.sdk.openadsdk.core.e.x;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.o;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(m mVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65545, null, mVar, i2) == null) {
            int c2 = n.c(o.a());
            int i3 = 6;
            if (c2 == 2) {
                i3 = 2;
            } else if (c2 == 3) {
                i3 = 3;
            } else if (c2 == 4) {
                i3 = 1;
            } else if (c2 == 5) {
                i3 = 4;
            } else if (c2 != 6) {
                i3 = 0;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("splash_show_type", Integer.valueOf(i2));
            hashMap.put(DpStatConstants.KEY_NETWORK_STATUS, Integer.valueOf(i3));
            com.bytedance.sdk.openadsdk.e.d.b(o.a(), mVar, "splash_ad", "network_type", hashMap);
        }
    }

    public static boolean b(q qVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, qVar)) == null) ? (qVar.a() == null || !qVar.a().aK() || qVar.b() == null || qVar.b().length == 0) ? false : true : invokeL.booleanValue;
    }

    public static int c(q qVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, qVar)) == null) {
            if (qVar != null) {
                int c2 = c(qVar.c());
                return c2 <= 0 ? a(qVar.a()) : c2;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int c(com.bytedance.sdk.openadsdk.core.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, aVar)) == null) {
            if (aVar != null) {
                return aVar.b();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static boolean b(com.bytedance.sdk.openadsdk.core.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, aVar)) == null) ? (aVar == null || aVar.c() == null || aVar.c().isEmpty() || aVar.c().get(0) == null) ? false : true : invokeL.booleanValue;
    }

    public static void a(AdSlot adSlot, boolean z, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{adSlot, Boolean.valueOf(z), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            int i2 = z ? 2 : 1;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("available_type", Integer.valueOf(i2));
                jSONObject.putOpt("creative_check_duration", Long.valueOf(j3));
                com.bytedance.sdk.openadsdk.j.a.a().m(com.bytedance.sdk.openadsdk.j.a.c.b().a(4).c(adSlot.getCodeId()).b((int) j2).b(jSONObject.toString()));
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.j.a.c cVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, cVar, str) == null) {
            com.bytedance.sdk.openadsdk.j.a.a().f(cVar.b(-7).g(g.a(-7)).i(str));
        }
    }

    public static void a(long j2, boolean z, boolean z2, m mVar, long j3, NetResponse netResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2), mVar, Long.valueOf(j3), netResponse}) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - j2;
            String str = z ? z2 ? "load_video_success" : "load_video_error" : z2 ? "download_video_image_success" : "download_video_image_fail";
            String str2 = null;
            if (!z2 && netResponse != null && netResponse.getMessage() != null) {
                str2 = netResponse.getMessage();
            }
            String str3 = str2;
            if (z) {
                Map<String, Object> a2 = com.bytedance.sdk.openadsdk.q.q.a(z2, mVar, elapsedRealtime, j3, str3);
                a2.put("splash_show_type", 1);
                com.bytedance.sdk.openadsdk.e.d.e(o.a(), mVar, "splash_ad", str, a2);
                return;
            }
            Map<String, Object> b2 = com.bytedance.sdk.openadsdk.q.q.b(z2, mVar, elapsedRealtime, j3, str3);
            b2.put("splash_show_type", 2);
            com.bytedance.sdk.openadsdk.e.d.d(o.a(), mVar, "splash_ad", str, b2);
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.core.e.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, aVar) == null) && b(aVar)) {
            m mVar = aVar.c().get(0);
            int d2 = com.bytedance.sdk.openadsdk.q.q.d(mVar.ao());
            x V = mVar.V();
            if (V != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                String i2 = V.i();
                if (TextUtils.isEmpty(i2)) {
                    a(elapsedRealtime, true, false, mVar, -1L, null);
                    return;
                }
                a(mVar, 1);
                String l = V.l();
                if (TextUtils.isEmpty(l)) {
                    l = com.bytedance.sdk.component.utils.e.a(i2);
                }
                boolean aN = mVar.aN();
                File a2 = a(l, d2, aN);
                if (o.h().e(String.valueOf(d2)) && !n.d(o.a())) {
                    if (l == null || !a2.exists()) {
                        return;
                    }
                    k.b("preLoadVideo", "非wifi环境，已缓存相同url的视频文件也是可以播放的");
                    a.a(o.a()).b(new q(aVar, mVar, null));
                    return;
                }
                DownloadExecutor downloadExecutor = com.bytedance.sdk.openadsdk.k.d.b().c().getDownloadExecutor();
                downloadExecutor.setUrl(i2);
                downloadExecutor.setFileInfo(a2.getParent(), a2.getName());
                downloadExecutor.enqueue(new NetCallback(aN, a2, aVar, mVar, elapsedRealtime) { // from class: com.bytedance.sdk.openadsdk.component.splash.c.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ boolean f65726a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ File f65727b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ com.bytedance.sdk.openadsdk.core.e.a f65728c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ m f65729d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ long f65730e;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {Boolean.valueOf(aN), a2, aVar, mVar, Long.valueOf(elapsedRealtime)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f65726a = aN;
                        this.f65727b = a2;
                        this.f65728c = aVar;
                        this.f65729d = mVar;
                        this.f65730e = elapsedRealtime;
                    }

                    @Override // com.bytedance.sdk.component.net.callback.NetCallback
                    public void onFailure(NetExecutor netExecutor, IOException iOException) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, netExecutor, iOException) == null) {
                            c.a(this.f65730e, true, false, this.f65729d, -2L, new NetResponse(false, -2, iOException.getMessage(), null, null, this.f65730e, SystemClock.elapsedRealtime()));
                        }
                    }

                    @Override // com.bytedance.sdk.component.net.callback.NetCallback
                    public void onResponse(NetExecutor netExecutor, NetResponse netResponse) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, netExecutor, netResponse) == null) {
                            if (netResponse.isSuccess() && netResponse.getFile() != null && netResponse.getFile().exists()) {
                                if (!this.f65726a) {
                                    c.a(this.f65727b);
                                    a.a(o.a()).a(this.f65727b);
                                }
                                a.a(o.a()).b(new q(this.f65728c, this.f65729d, null));
                                a.a(o.a()).a(new q(this.f65728c, this.f65729d, null));
                                c.a(this.f65730e, true, true, this.f65729d, 0L, netResponse);
                                return;
                            }
                            c.a(this.f65730e, true, false, this.f65729d, netResponse.getCode(), netResponse);
                        }
                    }
                });
            }
        }
    }

    public static File a(String str, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (z) {
                return com.bytedance.sdk.openadsdk.a.b.a(str);
            }
            return a(o.a(), a.a(o.a()).a(String.valueOf(i2), com.bytedance.sdk.openadsdk.multipro.b.b()), str);
        }
        return (File) invokeCommon.objValue;
    }

    public static boolean a(q qVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, qVar)) == null) ? (qVar == null || qVar.a() == null) ? false : true : invokeL.booleanValue;
    }

    public static void a(Context context, AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, adSlot) == null) {
            try {
                a.a(context).d(adSlot.getCodeId());
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context) == null) {
            try {
                a.a(context).a();
            } catch (Throwable unused) {
            }
        }
    }

    public static File a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, str, str2)) == null) {
            if (o.h().C() == 1) {
                k.f(ActivitySpeedStats.SPLASH_LOADAD_DURATION, "视频存储使用内部存储");
                return f.b(context, com.bytedance.sdk.openadsdk.multipro.b.b(), str, str2);
            }
            k.f(ActivitySpeedStats.SPLASH_LOADAD_DURATION, "视频存储使用外存储");
            return f.a(context, com.bytedance.sdk.openadsdk.multipro.b.b(), str, str2);
        }
        return (File) invokeLLL.objValue;
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            if (o.h().C() == 1) {
                return f.b(context, com.bytedance.sdk.openadsdk.multipro.b.b(), str).getAbsolutePath();
            }
            return f.a(context, com.bytedance.sdk.openadsdk.multipro.b.b(), str).getAbsolutePath();
        }
        return (String) invokeLL.objValue;
    }

    public static int a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, mVar)) == null) {
            if (mVar != null) {
                return com.bytedance.sdk.openadsdk.q.q.d(mVar.ao());
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void a(File file) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, file) == null) || file == null) {
            return;
        }
        try {
            f.b(file);
        } catch (Throwable unused) {
        }
    }
}
