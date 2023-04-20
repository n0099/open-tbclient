package com.baidu.tieba;

import com.baidu.tieba.xla;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdConfig;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public final class wla implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ List a;
    public final /* synthetic */ FunAdConfig b;
    public final /* synthetic */ Map c;
    public final /* synthetic */ long d;
    public final /* synthetic */ xla.a e;

    public wla(List list, FunAdConfig funAdConfig, Map map, long j, xla.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, funAdConfig, map, Long.valueOf(j), aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = list;
        this.b = funAdConfig;
        this.c = map;
        this.d = j;
        this.e = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (Ssp ssp : this.a) {
                if (this.b.forbiddenPlatforms.contains(ssp.type)) {
                    LogPrinter.d("Ssp:%s is not initialized for type is forbidden", ssp.type);
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    LogPrinter.d("sdk for %s init start", ssp.type);
                    String str3 = ssp.type;
                    str3.hashCode();
                    char c = 65535;
                    switch (str3.hashCode()) {
                        case 3116:
                            if (str3.equals(FunAdSdk.PLATFORM_AM)) {
                                c = 0;
                                break;
                            }
                            break;
                        case 3127:
                            if (str3.equals(FunAdSdk.PLATFORM_AX)) {
                                c = 1;
                                break;
                            }
                            break;
                        case 3343:
                            if (str3.equals(FunAdSdk.PLATFORM_HW)) {
                                c = 2;
                                break;
                            }
                            break;
                        case 3407:
                            if (str3.equals(FunAdSdk.PLATFORM_JY)) {
                                c = 3;
                                break;
                            }
                            break;
                        case 3432:
                            if (str3.equals(FunAdSdk.PLATFORM_KS)) {
                                c = 4;
                                break;
                            }
                            break;
                        case 3477:
                            if (str3.equals(FunAdSdk.PLATFORM_MB)) {
                                c = 5;
                                break;
                            }
                            break;
                        case 3483:
                            if (str3.equals(FunAdSdk.PLATFORM_MH)) {
                                c = 6;
                                break;
                            }
                            break;
                        case 3488:
                            if (str3.equals(FunAdSdk.PLATFORM_MM)) {
                                c = 7;
                                break;
                            }
                            break;
                        case 3560:
                            if (str3.equals(FunAdSdk.PLATFORM_OW)) {
                                c = '\b';
                                break;
                            }
                            break;
                        case 3575:
                            if (str3.equals(FunAdSdk.PLATFORM_PG)) {
                                c = '\t';
                                break;
                            }
                            break;
                        case 3693:
                            if (str3.equals(FunAdSdk.PLATFORM_TA)) {
                                c = '\n';
                                break;
                            }
                            break;
                        case 102199:
                            if (str3.equals(FunAdSdk.PLATFORM_GDT)) {
                                c = 11;
                                break;
                            }
                            break;
                        case 106042:
                            if (str3.equals(FunAdSdk.PLATFORM_KDS)) {
                                c = '\f';
                                break;
                            }
                            break;
                        case 107876:
                            if (str3.equals(FunAdSdk.PLATFORM_MAX)) {
                                c = '\r';
                                break;
                            }
                            break;
                        case 113873:
                            if (str3.equals(FunAdSdk.PLATFORM_SIG)) {
                                c = 14;
                                break;
                            }
                            break;
                        case 3418016:
                            if (str3.equals("oppo")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 3620012:
                            if (str3.equals("vivo")) {
                                c = 16;
                                break;
                            }
                            break;
                        case 93498907:
                            if (str3.equals("baidu")) {
                                c = 17;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.am.AmModule";
                            xla.f(str, str2, this.b, this.c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        case 1:
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.AxModule";
                            xla.f(str, str2, this.b, this.c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        case 2:
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.HwModule";
                            xla.f(str, str2, this.b, this.c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        case 3:
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.JyModule";
                            xla.f(str, str2, this.b, this.c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        case 4:
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.KsModule";
                            xla.f(str, str2, this.b, this.c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        case 5:
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.MbModule";
                            xla.f(str, str2, this.b, this.c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        case 6:
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.MhModule";
                            xla.f(str, str2, this.b, this.c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        case 7:
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.MmModule";
                            xla.f(str, str2, this.b, this.c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        case '\b':
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.OwModule";
                            xla.f(str, str2, this.b, this.c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        case '\t':
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.pg.PgModule";
                            xla.f(str, str2, this.b, this.c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        case '\n':
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.TAModule";
                            xla.f(str, str2, this.b, this.c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        case 11:
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.GdtModule";
                            xla.f(str, str2, this.b, this.c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        case '\f':
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.KdsModule";
                            xla.f(str, str2, this.b, this.c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        case '\r':
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.max.MaxModule";
                            xla.f(str, str2, this.b, this.c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        case 14:
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.SigModule";
                            xla.f(str, str2, this.b, this.c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        case 15:
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.oppo.OppoModule";
                            xla.f(str, str2, this.b, this.c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        case 16:
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.VivoModule";
                            xla.f(str, str2, this.b, this.c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        case 17:
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.BaiduModule";
                            xla.f(str, str2, this.b, this.c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        default:
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                    }
                }
            }
            xla.e(this.d, this.e, this.b, this.c);
        }
    }
}
