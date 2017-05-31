package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.c fDd;
    private final int fDe = 10;
    private final int fDf = 3000;
    public String fDg = null;
    public boolean agT = false;

    public b(String str) {
        T(str, false);
    }

    public void T(String str, boolean z) {
        this.fDg = str;
        this.agT = z;
        this.fDd = new com.baidu.adp.lib.stats.c("dbg");
        c.k(str, getNetType(), z);
    }

    public void start() {
        this.fDd.fW();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        f bix;
        if (this.fDd != null && (bix = bix()) != null) {
            if (z) {
                if (bix.fDl != null) {
                    bix.fDl.num++;
                    if (z2) {
                        bix.fDl.fDi += j2;
                        bix.fDl.size += j;
                    } else {
                        bix.fDl.fDj++;
                    }
                } else {
                    return;
                }
            } else if (bix.fDm != null) {
                bix.fDm.num++;
                if (z2) {
                    bix.fDm.fDi += j3;
                    bix.fDm.size += j;
                    j2 = j3;
                } else {
                    bix.fDm.fDj++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.fDd = null;
            if (z2) {
                c.a(bix, 10);
            }
            if (this.fDg == "frsStat") {
                if (!z2 || j2 > 3000) {
                    com.baidu.adp.lib.stats.c cVar = new com.baidu.adp.lib.stats.c("dbg");
                    cVar.p("act", "frs");
                    cVar.p("result", z2 ? "0" : "1");
                    cVar.p("isHttp", z ? "1" : "0");
                    cVar.p("timeCost", String.valueOf(j2));
                    cVar.p("errCode", String.valueOf(i));
                    cVar.p("errMsg", str);
                    cVar.p("down", String.valueOf(j));
                    BdStatisticsManager.getInstance().debug("frs", cVar);
                }
            }
        }
    }

    public void destory() {
        f bix;
        if (this.fDd != null && (bix = bix()) != null && bix.fDn != null) {
            long fX = this.fDd.fX();
            if (fX > 3000) {
                e eVar = bix.fDn;
                eVar.fDi = fX + eVar.fDi;
                bix.fDn.num++;
                c.a(bix, 10);
            }
        }
    }

    private f bix() {
        return c.l(this.fDg, getNetType(), this.agT);
    }

    private String getNetType() {
        int hq = i.hq();
        if (hq == 0) {
            return "N";
        }
        if (hq == 1) {
            return "WIFI";
        }
        if (hq == 3) {
            return "3G";
        }
        if (hq != 2) {
            return "N";
        }
        return "2G";
    }
}
