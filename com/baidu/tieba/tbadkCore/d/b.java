package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.c fNi;
    private final int fNj = 10;
    private final int fNk = 3000;
    public String fNl = null;
    public boolean ahB = false;

    public b(String str) {
        Y(str, false);
    }

    public void Y(String str, boolean z) {
        this.fNl = str;
        this.ahB = z;
        this.fNi = new com.baidu.adp.lib.stats.c("dbg");
        c.k(str, getNetType(), z);
    }

    public void start() {
        this.fNi.fV();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        f bmL;
        if (this.fNi != null && (bmL = bmL()) != null) {
            if (z) {
                if (bmL.fNq != null) {
                    bmL.fNq.num++;
                    if (z2) {
                        bmL.fNq.fNn += j2;
                        bmL.fNq.size += j;
                    } else {
                        bmL.fNq.fNo++;
                    }
                } else {
                    return;
                }
            } else if (bmL.fNr != null) {
                bmL.fNr.num++;
                if (z2) {
                    bmL.fNr.fNn += j3;
                    bmL.fNr.size += j;
                    j2 = j3;
                } else {
                    bmL.fNr.fNo++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.fNi = null;
            if (z2) {
                c.a(bmL, 10);
            }
            if (this.fNl == "frsStat") {
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
        f bmL;
        if (this.fNi != null && (bmL = bmL()) != null && bmL.fNs != null) {
            long fW = this.fNi.fW();
            if (fW > 3000) {
                e eVar = bmL.fNs;
                eVar.fNn = fW + eVar.fNn;
                bmL.fNs.num++;
                c.a(bmL, 10);
            }
        }
    }

    private f bmL() {
        return c.l(this.fNl, getNetType(), this.ahB);
    }

    private String getNetType() {
        int hp = i.hp();
        if (hp == 0) {
            return "N";
        }
        if (hp == 1) {
            return "WIFI";
        }
        if (hp == 3) {
            return "3G";
        }
        if (hp != 2) {
            return "N";
        }
        return "2G";
    }
}
