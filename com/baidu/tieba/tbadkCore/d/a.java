package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.stats.q;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
/* loaded from: classes.dex */
public class a {
    private q bZi;
    private final int bZj = 10;
    private final int bZk = 3000;
    public String bZl = null;
    public boolean KO = false;

    public a(String str) {
        C(str, false);
    }

    public void C(String str, boolean z) {
        this.bZl = str;
        this.KO = z;
        this.bZi = new q("dbg");
        b.g(str, getNetType(), z);
    }

    public void start() {
        this.bZi.eK();
    }

    public void a(boolean z, boolean z2, int i, String str, long j) {
        long eL = this.bZi.eL();
        long j2 = 0;
        long j3 = 0;
        if (z) {
            j2 = eL;
        } else {
            j3 = eL;
        }
        a(z, z2, i, str, j, j2, j3);
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e ahK;
        if (this.bZi != null && (ahK = ahK()) != null) {
            if (z) {
                if (ahK.bZq != null) {
                    ahK.bZq.num++;
                    if (z2) {
                        ahK.bZq.bZn += j2;
                        ahK.bZq.size += j;
                    } else {
                        ahK.bZq.bZo++;
                    }
                } else {
                    return;
                }
            } else if (ahK.bZr != null) {
                ahK.bZr.num++;
                if (z2) {
                    ahK.bZr.bZn += j3;
                    ahK.bZr.size += j;
                    j2 = j3;
                } else {
                    ahK.bZr.bZo++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.bZi = null;
            if (z2) {
                b.a(ahK, 10);
            }
            if (this.bZl == "frsStat") {
                if (!z2 || j2 > 3000) {
                    q qVar = new q("dbg");
                    qVar.r("act", "frs");
                    qVar.r("result", z2 ? "0" : "1");
                    qVar.r("isHttp", z ? "1" : "0");
                    qVar.r("timeCost", String.valueOf(j2));
                    qVar.r("errCode", String.valueOf(i));
                    qVar.r("errMsg", str);
                    qVar.r("down", String.valueOf(j));
                    f.eq().a("frs", qVar);
                }
            }
        }
    }

    public void destory() {
        e ahK;
        if (this.bZi != null && (ahK = ahK()) != null && ahK.bZs != null) {
            long eL = this.bZi.eL();
            if (eL > 3000) {
                d dVar = ahK.bZs;
                dVar.bZn = eL + dVar.bZn;
                ahK.bZs.num++;
                b.a(ahK, 10);
            }
        }
    }

    private e ahK() {
        return b.h(this.bZl, getNetType(), this.KO);
    }

    private String getNetType() {
        int fk = i.fk();
        if (fk == 0) {
            return "N";
        }
        if (fk == 1) {
            return NetworkChangeReceiver.WIFI_STRING;
        }
        if (fk == 3) {
            return "3G";
        }
        if (fk != 2) {
            return "N";
        }
        return "2G";
    }
}
