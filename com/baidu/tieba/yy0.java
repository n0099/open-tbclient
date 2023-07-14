package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.StatisticsEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Singleton
@Service
/* loaded from: classes8.dex */
public class yy0 implements hy0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;

    public yy0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = 0;
    }

    @Override // com.baidu.tieba.hy0
    public void a(a11 a11Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, a11Var) == null) && a11Var != null && !TextUtils.isEmpty(a11Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (!TextUtils.isEmpty(a11Var.f)) {
                clogBuilder.v(a11Var.f);
            }
            clogBuilder.p(a11Var.g);
            String c = a11Var.a.c();
            char c2 = 65535;
            switch (c.hashCode()) {
                case -1530009462:
                    if (c.equals(ControlEvent.ACTION_SYNC_PROGRESS)) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 154871702:
                    if (c.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 720027695:
                    if (c.equals(ControlEvent.ACTION_PAUSE)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 723345051:
                    if (c.equals(ControlEvent.ACTION_START)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 906917140:
                    if (c.equals(ControlEvent.ACTION_RESUME)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 2145795460:
                    if (c.equals(StatisticsEvent.ACTION_PLAYER_STOP)) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3 && c2 != 4) {
                            if (c2 == 5) {
                                int g = a11Var.a.g(1);
                                int g2 = a11Var.a.g(2);
                                if (g == 0 && g2 != 0 && (i = this.b) != 0 && i >= g2 - 2) {
                                    clogBuilder.y(ClogBuilder.LogType.VIDEO_COMPLETED).l(String.valueOf(g2)).m(String.valueOf(g2)).n(a11Var.e);
                                    n41.e(clogBuilder);
                                    ClogBuilder p = new ClogBuilder().y(ClogBuilder.LogType.VIDEO_START).k(a11Var.b).m(a11Var.d).p(a11Var.g);
                                    if (!TextUtils.isEmpty(a11Var.f)) {
                                        p.v(a11Var.f);
                                    }
                                    n41.e(p);
                                }
                                this.b = g;
                                return;
                            }
                            return;
                        } else if (this.a < 1) {
                            return;
                        } else {
                            try {
                                if (this.b > Integer.parseInt(a11Var.c)) {
                                    clogBuilder.l(a11Var.d);
                                } else {
                                    clogBuilder.l(a11Var.c);
                                }
                            } catch (NumberFormatException unused) {
                                clogBuilder.l(a11Var.c);
                            }
                            clogBuilder.y(ClogBuilder.LogType.VIDEO_COMPLETED).m(a11Var.d).n(a11Var.e).o("0");
                            this.a--;
                            n41.e(clogBuilder);
                            return;
                        }
                    }
                    clogBuilder.y(ClogBuilder.LogType.VIDEO_RESUME).k(a11Var.b).m(a11Var.d);
                    n41.e(clogBuilder);
                    return;
                }
                boolean d = a11Var.a.d(7);
                clogBuilder.l(a11Var.c).m(a11Var.d).n(a11Var.e);
                if (d) {
                    clogBuilder.y(ClogBuilder.LogType.VIDEO_PAUSE);
                } else {
                    clogBuilder.y(ClogBuilder.LogType.VIDEO_COMPLETED).o("1");
                }
                n41.e(clogBuilder);
                return;
            }
            clogBuilder.y(ClogBuilder.LogType.VIDEO_START).k(a11Var.b).m(a11Var.d);
            this.b = 0;
            this.a++;
            n41.e(clogBuilder);
        }
    }

    @Override // com.baidu.tieba.hy0
    public void b(a11 a11Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a11Var) == null) && a11Var != null && a11Var.a != null && !TextUtils.isEmpty(a11Var.g)) {
            String c = a11Var.a.c();
            char c2 = 65535;
            int hashCode = c.hashCode();
            if (hashCode != 154871702) {
                if (hashCode != 1370689931) {
                    if (hashCode == 2145795460 && c.equals(StatisticsEvent.ACTION_PLAYER_STOP)) {
                        c2 = 1;
                    }
                } else if (c.equals(PlayerEvent.ACTION_ON_INFO)) {
                    c2 = 0;
                }
            } else if (c.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                c2 = 2;
            }
            if (c2 != 0) {
                if (c2 == 1 || c2 == 2) {
                    b11.b.b();
                    return;
                }
                return;
            }
            g11 a = b11.b.a();
            if (a != null) {
                a.c(a11Var.g);
                a.e(a11Var.b);
                a.d(a11Var.h);
                a.b(a11Var.d);
                b11.b.c(a);
            }
        }
    }
}
