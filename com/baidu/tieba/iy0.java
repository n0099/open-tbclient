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
/* loaded from: classes6.dex */
public class iy0 implements rx0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;

    public iy0() {
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

    @Override // com.baidu.tieba.rx0
    public void a(k01 k01Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, k01Var) == null) && k01Var != null && !TextUtils.isEmpty(k01Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (!TextUtils.isEmpty(k01Var.f)) {
                clogBuilder.v(k01Var.f);
            }
            clogBuilder.p(k01Var.g);
            String c = k01Var.a.c();
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
                                int g = k01Var.a.g(1);
                                int g2 = k01Var.a.g(2);
                                if (g == 0 && g2 != 0 && (i = this.b) != 0 && i >= g2 - 2) {
                                    clogBuilder.y(ClogBuilder.LogType.VIDEO_COMPLETED).l(String.valueOf(g2)).m(String.valueOf(g2)).n(k01Var.e);
                                    x31.e(clogBuilder);
                                    ClogBuilder p = new ClogBuilder().y(ClogBuilder.LogType.VIDEO_START).k(k01Var.b).m(k01Var.d).p(k01Var.g);
                                    if (!TextUtils.isEmpty(k01Var.f)) {
                                        p.v(k01Var.f);
                                    }
                                    x31.e(p);
                                }
                                this.b = g;
                                return;
                            }
                            return;
                        } else if (this.a < 1) {
                            return;
                        } else {
                            try {
                                if (this.b > Integer.parseInt(k01Var.c)) {
                                    clogBuilder.l(k01Var.d);
                                } else {
                                    clogBuilder.l(k01Var.c);
                                }
                            } catch (NumberFormatException unused) {
                                clogBuilder.l(k01Var.c);
                            }
                            clogBuilder.y(ClogBuilder.LogType.VIDEO_COMPLETED).m(k01Var.d).n(k01Var.e).o("0");
                            this.a--;
                            x31.e(clogBuilder);
                            return;
                        }
                    }
                    clogBuilder.y(ClogBuilder.LogType.VIDEO_RESUME).k(k01Var.b).m(k01Var.d);
                    x31.e(clogBuilder);
                    return;
                }
                boolean d = k01Var.a.d(7);
                clogBuilder.l(k01Var.c).m(k01Var.d).n(k01Var.e);
                if (d) {
                    clogBuilder.y(ClogBuilder.LogType.VIDEO_PAUSE);
                } else {
                    clogBuilder.y(ClogBuilder.LogType.VIDEO_COMPLETED).o("1");
                }
                x31.e(clogBuilder);
                return;
            }
            clogBuilder.y(ClogBuilder.LogType.VIDEO_START).k(k01Var.b).m(k01Var.d);
            this.b = 0;
            this.a++;
            x31.e(clogBuilder);
        }
    }

    @Override // com.baidu.tieba.rx0
    public void b(k01 k01Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k01Var) == null) && k01Var != null && k01Var.a != null && !TextUtils.isEmpty(k01Var.g)) {
            String c = k01Var.a.c();
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
                    l01.b.b();
                    return;
                }
                return;
            }
            q01 a = l01.b.a();
            if (a != null) {
                a.c(k01Var.g);
                a.e(k01Var.b);
                a.d(k01Var.h);
                a.b(k01Var.d);
                l01.b.c(a);
            }
        }
    }
}
