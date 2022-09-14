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
public class tu0 implements cu0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;

    public tu0() {
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

    @Override // com.baidu.tieba.cu0
    public void a(vw0 vw0Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, vw0Var) == null) || vw0Var == null || TextUtils.isEmpty(vw0Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        if (!TextUtils.isEmpty(vw0Var.f)) {
            clogBuilder.v(vw0Var.f);
        }
        clogBuilder.p(vw0Var.g);
        String c = vw0Var.a.c();
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
        if (c2 == 0) {
            clogBuilder.y(ClogBuilder.LogType.VIDEO_START).k(vw0Var.b).m(vw0Var.d);
            this.b = 0;
            this.a++;
            uz0.b(clogBuilder);
        } else if (c2 == 1) {
            boolean d = vw0Var.a.d(7);
            clogBuilder.l(vw0Var.c).m(vw0Var.d).n(vw0Var.e);
            if (d) {
                clogBuilder.y(ClogBuilder.LogType.VIDEO_PAUSE);
            } else {
                clogBuilder.y(ClogBuilder.LogType.VIDEO_COMPLETED).o("1");
            }
            uz0.b(clogBuilder);
        } else if (c2 == 2) {
            clogBuilder.y(ClogBuilder.LogType.VIDEO_RESUME).k(vw0Var.b).m(vw0Var.d);
            uz0.b(clogBuilder);
        } else if (c2 == 3 || c2 == 4) {
            if (this.a < 1) {
                return;
            }
            try {
                if (this.b > Integer.parseInt(vw0Var.c)) {
                    clogBuilder.l(vw0Var.d);
                } else {
                    clogBuilder.l(vw0Var.c);
                }
            } catch (NumberFormatException unused) {
                clogBuilder.l(vw0Var.c);
            }
            clogBuilder.y(ClogBuilder.LogType.VIDEO_COMPLETED).m(vw0Var.d).n(vw0Var.e).o("0");
            this.a--;
            uz0.b(clogBuilder);
        } else if (c2 != 5) {
        } else {
            int g = vw0Var.a.g(1);
            int g2 = vw0Var.a.g(2);
            if (g == 0 && g2 != 0 && (i = this.b) != 0 && i >= g2 - 2) {
                clogBuilder.y(ClogBuilder.LogType.VIDEO_COMPLETED).l(String.valueOf(g2)).m(String.valueOf(g2)).n(vw0Var.e);
                uz0.b(clogBuilder);
                ClogBuilder p = new ClogBuilder().y(ClogBuilder.LogType.VIDEO_START).k(vw0Var.b).m(vw0Var.d).p(vw0Var.g);
                if (!TextUtils.isEmpty(vw0Var.f)) {
                    p.v(vw0Var.f);
                }
                uz0.b(p);
            }
            this.b = g;
        }
    }

    @Override // com.baidu.tieba.cu0
    public void b(vw0 vw0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vw0Var) == null) || vw0Var == null || vw0Var.a == null || TextUtils.isEmpty(vw0Var.g)) {
            return;
        }
        String c = vw0Var.a.c();
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
                ww0.b.b();
                return;
            }
            return;
        }
        bx0 a = ww0.b.a();
        if (a != null) {
            a.c(vw0Var.g);
            a.e(vw0Var.b);
            a.d(vw0Var.h);
            a.b(vw0Var.d);
            ww0.b.c(a);
        }
    }
}
