package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.c fwM;
    private final int fwN = 10;
    private final int fwO = 3000;
    public String fwP = null;
    public boolean ahJ = false;

    public b(String str) {
        W(str, false);
    }

    public void W(String str, boolean z) {
        this.fwP = str;
        this.ahJ = z;
        this.fwM = new com.baidu.adp.lib.stats.c("dbg");
        c.k(str, getNetType(), z);
    }

    public void start() {
        this.fwM.fV();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        f biF;
        if (this.fwM != null && (biF = biF()) != null) {
            if (z) {
                if (biF.fwU != null) {
                    biF.fwU.num++;
                    if (z2) {
                        biF.fwU.fwR += j2;
                        biF.fwU.size += j;
                    } else {
                        biF.fwU.fwS++;
                    }
                } else {
                    return;
                }
            } else if (biF.fwV != null) {
                biF.fwV.num++;
                if (z2) {
                    biF.fwV.fwR += j3;
                    biF.fwV.size += j;
                    j2 = j3;
                } else {
                    biF.fwV.fwS++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.fwM = null;
            if (z2) {
                c.a(biF, 10);
            }
            if (this.fwP == "frsStat") {
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
        f biF;
        if (this.fwM != null && (biF = biF()) != null && biF.fwW != null) {
            long fW = this.fwM.fW();
            if (fW > 3000) {
                e eVar = biF.fwW;
                eVar.fwR = fW + eVar.fwR;
                biF.fwW.num++;
                c.a(biF, 10);
            }
        }
    }

    private f biF() {
        return c.l(this.fwP, getNetType(), this.ahJ);
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
