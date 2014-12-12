package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.stats.q;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
/* loaded from: classes.dex */
public class a {
    private q bXq;
    private final int bXr = 10;
    private final int bXs = 3000;
    public String bXt = null;
    public boolean Ky = false;

    public a(String str) {
        D(str, false);
    }

    public void D(String str, boolean z) {
        this.bXt = str;
        this.Ky = z;
        this.bXq = new q("dbg");
        b.g(str, getNetType(), z);
    }

    public void start() {
        this.bXq.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j) {
        long eM = this.bXq.eM();
        long j2 = 0;
        long j3 = 0;
        if (z) {
            j2 = eM;
        } else {
            j3 = eM;
        }
        a(z, z2, i, str, j, j2, j3);
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e ahk;
        if (this.bXq != null && (ahk = ahk()) != null) {
            if (z) {
                if (ahk.bXy != null) {
                    ahk.bXy.num++;
                    if (z2) {
                        ahk.bXy.bXv += j2;
                        ahk.bXy.size += j;
                    } else {
                        ahk.bXy.bXw++;
                    }
                } else {
                    return;
                }
            } else if (ahk.bXz != null) {
                ahk.bXz.num++;
                if (z2) {
                    ahk.bXz.bXv += j3;
                    ahk.bXz.size += j;
                    j2 = j3;
                } else {
                    ahk.bXz.bXw++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.bXq = null;
            if (z2) {
                b.a(ahk, 10);
            }
            if (this.bXt == "frsStat") {
                if (!z2 || j2 > 3000) {
                    q qVar = new q("dbg");
                    qVar.r("act", "frs");
                    qVar.r("result", z2 ? "0" : "1");
                    qVar.r("isHttp", z ? "1" : "0");
                    qVar.r("timeCost", String.valueOf(j2));
                    qVar.r("errCode", String.valueOf(i));
                    qVar.r("errMsg", str);
                    qVar.r("down", String.valueOf(j));
                    f.es().a("frs", qVar);
                }
            }
        }
    }

    public void destory() {
        e ahk;
        if (this.bXq != null && (ahk = ahk()) != null && ahk.bXA != null) {
            long eM = this.bXq.eM();
            if (eM > 3000) {
                d dVar = ahk.bXA;
                dVar.bXv = eM + dVar.bXv;
                ahk.bXA.num++;
                b.a(ahk, 10);
            }
        }
    }

    private e ahk() {
        return b.h(this.bXt, getNetType(), this.Ky);
    }

    private String getNetType() {
        int fl = i.fl();
        if (fl == 0) {
            return "N";
        }
        if (fl == 1) {
            return NetworkChangeReceiver.WIFI_STRING;
        }
        if (fl == 3) {
            return "3G";
        }
        if (fl != 2) {
            return "N";
        }
        return "2G";
    }
}
