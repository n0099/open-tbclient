package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import com.bytedance.sdk.component.utils.b;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.bytedance.sdk.openadsdk.activity.base.TTMiddlePageActivity;
import com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity;
import com.bytedance.sdk.openadsdk.activity.base.TTVideoScrollWebPageActivity;
import com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity;
import com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import com.bytedance.sdk.openadsdk.q.a;
import com.bytedance.sdk.openadsdk.q.c;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class z {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f31165a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(210335292, "Lcom/bytedance/sdk/openadsdk/core/z;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(210335292, "Lcom/bytedance/sdk/openadsdk/core/z;");
        }
    }

    public static void b(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, Intent intent, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65546, null, context, mVar, intent, str) == null) || mVar == null || context == null || intent == null) {
            return;
        }
        String c2 = mVar.al() != null ? mVar.al().c() : "";
        if (TextUtils.isEmpty(c2)) {
            str2 = "是否立即打开应用";
        } else {
            str2 = "是否立即打开" + c2;
        }
        com.bytedance.sdk.openadsdk.q.c.a(context, mVar.ak(), c2, str2, "立即打开", "退出", new c.a(context, mVar, str, intent) { // from class: com.bytedance.sdk.openadsdk.core.z.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f31178a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ com.bytedance.sdk.openadsdk.core.e.m f31179b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f31180c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Intent f31181d;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {context, mVar, str, intent};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f31178a = context;
                this.f31179b = mVar;
                this.f31180c = str;
                this.f31181d = intent;
            }

            @Override // com.bytedance.sdk.openadsdk.q.c.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    com.bytedance.sdk.openadsdk.e.d.h(this.f31178a, this.f31179b, this.f31180c, "open_url_app", null);
                    com.bytedance.sdk.component.utils.b.a(this.f31178a, this.f31181d, new b.a(this) { // from class: com.bytedance.sdk.openadsdk.core.z.3.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass3 f31182a;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f31182a = this;
                        }

                        @Override // com.bytedance.sdk.component.utils.b.a
                        public void a() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                com.bytedance.sdk.openadsdk.e.k a2 = com.bytedance.sdk.openadsdk.e.k.a();
                                AnonymousClass3 anonymousClass3 = this.f31182a;
                                a2.a(anonymousClass3.f31179b, anonymousClass3.f31180c, false);
                                Context a3 = o.a();
                                AnonymousClass3 anonymousClass32 = this.f31182a;
                                com.bytedance.sdk.openadsdk.e.d.b(a3, anonymousClass32.f31179b, anonymousClass32.f31180c, "deeplink_success_realtime");
                            }
                        }

                        @Override // com.bytedance.sdk.component.utils.b.a
                        public void a(Throwable th) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                                Context a2 = o.a();
                                AnonymousClass3 anonymousClass3 = this.f31182a;
                                com.bytedance.sdk.openadsdk.e.d.b(a2, anonymousClass3.f31179b, anonymousClass3.f31180c, "deeplink_fail_realtime");
                            }
                        }
                    });
                }
            }

            @Override // com.bytedance.sdk.openadsdk.q.c.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.q.c.a
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }
        });
    }

    public static void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
            f31165a = z;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0171  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, int i2, @Nullable TTNativeAd tTNativeAd, @Nullable TTNativeExpressAd tTNativeExpressAd, @Nullable TTSplashAd tTSplashAd, String str, @Nullable com.bytedance.sdk.openadsdk.downloadnew.core.a aVar, boolean z, Map<String, Object> map, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        boolean z4;
        String Z;
        String str2;
        boolean z5;
        Map map2;
        Map map3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{context, mVar, Integer.valueOf(i2), tTNativeAd, tTNativeExpressAd, tTSplashAd, str, aVar, Boolean.valueOf(z), map, Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (context == null || mVar == null || i2 == -1) {
                return false;
            }
            com.bytedance.sdk.openadsdk.core.e.g an = mVar.an();
            if (a(str) && !z3 && !z && an == null && TTMiddlePageActivity.a(context, mVar)) {
                return false;
            }
            if (an != null) {
                com.bytedance.sdk.component.utils.k.b("deepLink", "WebHelper 含有deeplink链接尝试deeplink调起 deepLink != null ");
                String a2 = an.a();
                if (TextUtils.isEmpty(a2)) {
                    z4 = true;
                } else {
                    Uri parse = Uri.parse(an.a());
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(parse);
                    if (com.bytedance.sdk.openadsdk.q.q.k(context)) {
                        if (com.bytedance.sdk.openadsdk.q.q.a(context, intent)) {
                            if (mVar.az()) {
                                com.bytedance.sdk.openadsdk.q.q.a(mVar, str);
                            }
                            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                            a(context, mVar, intent, System.currentTimeMillis(), str);
                            com.bytedance.sdk.component.utils.b.a(context, intent, new b.a(mVar, str, context, i2, z, map) { // from class: com.bytedance.sdk.openadsdk.core.z.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.e.m f31166a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ String f31167b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ Context f31168c;

                                /* renamed from: d  reason: collision with root package name */
                                public final /* synthetic */ int f31169d;

                                /* renamed from: e  reason: collision with root package name */
                                public final /* synthetic */ boolean f31170e;

                                /* renamed from: f  reason: collision with root package name */
                                public final /* synthetic */ Map f31171f;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {mVar, str, context, Integer.valueOf(i2), Boolean.valueOf(z), map};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f31166a = mVar;
                                    this.f31167b = str;
                                    this.f31168c = context;
                                    this.f31169d = i2;
                                    this.f31170e = z;
                                    this.f31171f = map;
                                }

                                @Override // com.bytedance.sdk.component.utils.b.a
                                public void a() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        com.bytedance.sdk.openadsdk.e.d.b(o.a(), this.f31166a, this.f31167b, "deeplink_success_realtime");
                                    }
                                }

                                @Override // com.bytedance.sdk.component.utils.b.a
                                public void a(Throwable th) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                                        com.bytedance.sdk.openadsdk.core.e.m mVar2 = this.f31166a;
                                        if (mVar2 != null && !mVar2.az()) {
                                            z.a(this.f31168c, this.f31166a.Z(), this.f31166a, this.f31169d, this.f31167b, this.f31170e, this.f31171f);
                                            com.bytedance.sdk.component.utils.k.c("WebHelper", "openDetailPage() -> context.startActivity(intent) fail :", th);
                                        }
                                        com.bytedance.sdk.openadsdk.e.d.b(o.a(), this.f31166a, this.f31167b, "deeplink_fail_realtime");
                                    }
                                }
                            });
                            com.bytedance.sdk.openadsdk.e.d.h(context, mVar, str, "open_url_app", null);
                            com.bytedance.sdk.openadsdk.e.k.a().a(mVar, str, false);
                            return true;
                        }
                        com.bytedance.sdk.openadsdk.e.d.b(o.a(), mVar, str, "deeplink_fail_realtime");
                        z4 = true;
                    } else {
                        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            if (!(context instanceof Activity)) {
                                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                            }
                            com.bytedance.sdk.openadsdk.e.d.h(context, mVar, str, "open_url_app", null);
                            z5 = mVar.az() ? com.bytedance.sdk.openadsdk.q.q.a(mVar, str) : false;
                            try {
                                context.startActivity(intent);
                                str2 = "deeplink_fail_realtime";
                                z4 = true;
                                try {
                                    a(context, mVar, intent, currentTimeMillis, str);
                                    com.bytedance.sdk.openadsdk.e.d.b(context, mVar, str, "deeplink_success_realtime");
                                    com.bytedance.sdk.openadsdk.e.k.a().a(mVar, str, false);
                                    return true;
                                } catch (Throwable unused) {
                                    com.bytedance.sdk.openadsdk.e.d.b(o.a(), mVar, str, str2);
                                    if (z5) {
                                        return false;
                                    }
                                    if (an.c() == 2) {
                                    }
                                    map2 = null;
                                    if (an.c() != z4) {
                                    }
                                    com.bytedance.sdk.openadsdk.e.d.h(context, mVar, str, "open_fallback_url", map2);
                                    Z = a2;
                                    if (TextUtils.isEmpty(Z)) {
                                    }
                                    if (mVar.X() != 2) {
                                    }
                                    return z4;
                                }
                            } catch (Throwable unused2) {
                                str2 = "deeplink_fail_realtime";
                                z4 = true;
                            }
                        } catch (Throwable unused3) {
                            str2 = "deeplink_fail_realtime";
                            z4 = true;
                            z5 = false;
                        }
                    }
                    if (an.c() == 2 || com.bytedance.sdk.openadsdk.core.e.m.b(mVar)) {
                        map2 = null;
                        if (an.c() != z4) {
                            a2 = an.b();
                        } else {
                            a2 = mVar.Z();
                        }
                    } else if (aVar != null) {
                        boolean j = aVar.j();
                        boolean z6 = (!j && aVar.h() && aVar.a(z)) ? true : j;
                        if (!z6 && aVar.b(z)) {
                            z6 = true;
                        }
                        if (z6 || !aVar.i()) {
                            map3 = null;
                        } else {
                            map3 = null;
                            z6 = true;
                        }
                        com.bytedance.sdk.openadsdk.e.d.h(context, mVar, str, "open_fallback_url", map3);
                        return z6;
                    } else {
                        map2 = null;
                    }
                    com.bytedance.sdk.openadsdk.e.d.h(context, mVar, str, "open_fallback_url", map2);
                }
                Z = a2;
            } else {
                z4 = true;
                Z = mVar.Z();
            }
            if (TextUtils.isEmpty(Z) || com.bytedance.sdk.openadsdk.core.e.o.b(mVar)) {
                if (mVar.X() != 2) {
                    if (!com.bytedance.sdk.component.utils.n.a(Z)) {
                        return false;
                    }
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    try {
                        intent2.setData(Uri.parse(Z));
                        if (!(context instanceof Activity)) {
                            intent2.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                        }
                        com.bytedance.sdk.component.utils.b.a(context, intent2, null);
                    } catch (Exception unused4) {
                        return false;
                    }
                } else {
                    com.bytedance.sdk.component.utils.b.a(context, a(context, Z, mVar, i2, tTNativeAd, tTNativeExpressAd, tTSplashAd, str, z, map, z2, false), null);
                    f31165a = false;
                }
                return z4;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean a(Context context, String str, com.bytedance.sdk.openadsdk.core.e.m mVar, int i2, String str2, boolean z, Map<String, Object> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{context, str, mVar, Integer.valueOf(i2), str2, Boolean.valueOf(z), map})) == null) {
            try {
                return com.bytedance.sdk.component.utils.b.a(context, a(context, str, mVar, i2, (TTNativeAd) null, (TTNativeExpressAd) null, (TTSplashAd) null, str2, z, map, false, false), null);
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.equals("embeded_ad") || str.equals("embeded_ad_landingpage");
        }
        return invokeL.booleanValue;
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, Intent intent, long j, String str) {
        com.bytedance.sdk.openadsdk.q.a c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, mVar, intent, Long.valueOf(j), str}) == null) || mVar == null || intent == null || context == null || !mVar.aA() || (c2 = h.d().c()) == null) {
            return;
        }
        c2.a(new a.InterfaceC0369a(j, context, mVar, intent, str, c2) { // from class: com.bytedance.sdk.openadsdk.core.z.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f31172a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f31173b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ com.bytedance.sdk.openadsdk.core.e.m f31174c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Intent f31175d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f31176e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ com.bytedance.sdk.openadsdk.q.a f31177f;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Long.valueOf(j), context, mVar, intent, str, c2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f31172a = j;
                this.f31173b = context;
                this.f31174c = mVar;
                this.f31175d = intent;
                this.f31176e = str;
                this.f31177f = c2;
            }

            @Override // com.bytedance.sdk.openadsdk.q.a.InterfaceC0369a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    com.bytedance.sdk.component.utils.k.b("WebHelper", "间隔时间 onActivityResumed intervalTime " + (currentTimeMillis - this.f31172a));
                    if (currentTimeMillis - this.f31172a <= 3000) {
                        z.b(this.f31173b, this.f31174c, this.f31175d, this.f31176e);
                    }
                    com.bytedance.sdk.openadsdk.q.a aVar = this.f31177f;
                    if (aVar != null) {
                        aVar.b();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.q.a.InterfaceC0369a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.q.a.InterfaceC0369a
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.q.a.InterfaceC0369a
            public void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.q.a.InterfaceC0369a
            public void e() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.q.a.InterfaceC0369a
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                }
            }
        });
    }

    public static boolean a(TTNativeAd tTNativeAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, tTNativeAd)) == null) {
            if (tTNativeAd != null && (tTNativeAd instanceof a.InterfaceC0357a)) {
                try {
                    return ((a.InterfaceC0357a) tTNativeAd).g();
                } catch (Throwable unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static Intent a(Context context, String str, com.bytedance.sdk.openadsdk.core.e.m mVar, int i2, @Nullable TTNativeAd tTNativeAd, TTNativeExpressAd tTNativeExpressAd, TTSplashAd tTSplashAd, String str2, boolean z, Map<String, Object> map, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Intent intent;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, str, mVar, Integer.valueOf(i2), tTNativeAd, tTNativeExpressAd, tTSplashAd, str2, Boolean.valueOf(z), map, Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (com.bytedance.sdk.openadsdk.core.e.o.b(mVar) && (tTNativeAd != null || tTNativeExpressAd != null || tTSplashAd != null)) {
                intent = new Intent(context, TTPlayableWebPageActivity.class);
                intent.putExtra("ad_pending_download", a(mVar, z));
                String d2 = com.bytedance.sdk.openadsdk.core.e.o.d(mVar);
                if (!TextUtils.isEmpty(d2)) {
                    if (d2.contains("?")) {
                        str = d2 + "&orientation=portrait";
                    } else {
                        str = d2 + "?orientation=portrait";
                    }
                }
            } else {
                intent = tTNativeAd instanceof TTDrawFeedAd ? new Intent(context, TTWebPageActivity.class) : (!com.bytedance.sdk.openadsdk.core.e.m.b(mVar) || f31165a || a(tTNativeAd) || !com.bytedance.sdk.openadsdk.q.q.c(mVar)) ? new Intent(context, TTWebPageActivity.class) : new Intent(context, TTVideoWebPageActivity.class);
            }
            intent.putExtra("url", str);
            intent.putExtra("gecko_id", mVar.ab());
            intent.putExtra("web_title", mVar.ah());
            intent.putExtra(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, 3703);
            intent.putExtra(XAdRemoteAPKDownloadExtraInfo.ADID, mVar.ak());
            intent.putExtra("log_extra", mVar.ao());
            intent.putExtra("icon_url", mVar.Y() == null ? null : mVar.Y().a());
            intent.putExtra("event_tag", str2);
            intent.putExtra("source", i2);
            if (!(context instanceof Activity)) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            com.bytedance.sdk.openadsdk.q.e.e(mVar.aP().toString());
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, mVar.aP().toString());
            } else {
                t.a().g();
                t.a().a(mVar);
            }
            if (com.bytedance.sdk.openadsdk.core.e.m.b(mVar)) {
                if (tTNativeAd != null) {
                    r12 = tTNativeAd instanceof a.InterfaceC0357a ? ((a.InterfaceC0357a) tTNativeAd).e() : null;
                    if (r12 != null) {
                        intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, r12.a().toString());
                    }
                }
                if (tTNativeExpressAd != null && (r12 = tTNativeExpressAd.getVideoModel()) != null) {
                    intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, r12.a().toString());
                }
                if (r12 != null) {
                    intent.putExtra("video_is_auto_play", r12.f31791d);
                    com.bytedance.sdk.component.utils.k.c("videoDataModel", "videoDataModel=" + r12.a().toString());
                }
                if (TTVideoWebPageActivity.a(intent) && (r12 != null || z2)) {
                    try {
                        if (r12 != null) {
                            i3 = (int) ((((float) r12.f31794g) / ((float) r12.f31792e)) * 100.0f);
                        } else {
                            com.bytedance.sdk.openadsdk.multipro.b.a aVar = new com.bytedance.sdk.openadsdk.multipro.b.a();
                            aVar.f31794g = 100L;
                            aVar.f31788a = true;
                            aVar.f31791d = com.bytedance.sdk.openadsdk.q.q.j(mVar);
                            intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, aVar.a().toString());
                            i3 = 100;
                        }
                        if (map == null) {
                            map = new HashMap<>();
                        }
                        map.put("play_percent", Integer.valueOf(i3));
                        if (mVar.aa() == 0) {
                            intent.setComponent(new ComponentName(context, TTVideoScrollWebPageActivity.class));
                        } else if (mVar.aa() > 0 && i3 > mVar.aa() && com.bytedance.sdk.openadsdk.q.q.j(mVar)) {
                            intent.setComponent(new ComponentName(context, TTVideoScrollWebPageActivity.class));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            return intent;
        }
        return (Intent) invokeCommon.objValue;
    }

    public static boolean a(com.bytedance.sdk.openadsdk.core.e.m mVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65544, null, mVar, z)) == null) ? z && mVar != null && mVar.X() == 4 && com.bytedance.sdk.openadsdk.core.e.o.b(mVar) : invokeLZ.booleanValue;
    }
}
