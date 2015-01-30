package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.stats.q;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
/* loaded from: classes.dex */
public class a {
    private q bZj;
    private final int bZk = 10;
    private final int bZl = 3000;
    public String bZm = null;
    public boolean KR = false;

    public a(String str) {
        C(str, false);
    }

    public void C(String str, boolean z) {
        this.bZm = str;
        this.KR = z;
        this.bZj = new q("dbg");
        b.g(str, getNetType(), z);
    }

    public void start() {
        this.bZj.eK();
    }

    public void a(boolean z, boolean z2, int i, String str, long j) {
        long eL = this.bZj.eL();
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
        e ahP;
        if (this.bZj != null && (ahP = ahP()) != null) {
            if (z) {
                if (ahP.bZr != null) {
                    ahP.bZr.num++;
                    if (z2) {
                        ahP.bZr.bZo += j2;
                        ahP.bZr.size += j;
                    } else {
                        ahP.bZr.bZp++;
                    }
                } else {
                    return;
                }
            } else if (ahP.bZs != null) {
                ahP.bZs.num++;
                if (z2) {
                    ahP.bZs.bZo += j3;
                    ahP.bZs.size += j;
                    j2 = j3;
                } else {
                    ahP.bZs.bZp++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.bZj = null;
            if (z2) {
                b.a(ahP, 10);
            }
            if (this.bZm == "frsStat") {
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
        e ahP;
        if (this.bZj != null && (ahP = ahP()) != null && ahP.bZt != null) {
            long eL = this.bZj.eL();
            if (eL > 3000) {
                d dVar = ahP.bZt;
                dVar.bZo = eL + dVar.bZo;
                ahP.bZt.num++;
                b.a(ahP, 10);
            }
        }
    }

    private e ahP() {
        return b.h(this.bZm, getNetType(), this.KR);
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
