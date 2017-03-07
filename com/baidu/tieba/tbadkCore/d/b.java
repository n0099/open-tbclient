package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.c fvd;
    private final int fve = 10;
    private final int fvf = 3000;
    public String fvg = null;
    public boolean ahv = false;

    public b(String str) {
        W(str, false);
    }

    public void W(String str, boolean z) {
        this.fvg = str;
        this.ahv = z;
        this.fvd = new com.baidu.adp.lib.stats.c("dbg");
        c.j(str, getNetType(), z);
    }

    public void start() {
        this.fvd.fQ();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        f bhU;
        if (this.fvd != null && (bhU = bhU()) != null) {
            if (z) {
                if (bhU.fvl != null) {
                    bhU.fvl.num++;
                    if (z2) {
                        bhU.fvl.fvi += j2;
                        bhU.fvl.size += j;
                    } else {
                        bhU.fvl.fvj++;
                    }
                } else {
                    return;
                }
            } else if (bhU.fvm != null) {
                bhU.fvm.num++;
                if (z2) {
                    bhU.fvm.fvi += j3;
                    bhU.fvm.size += j;
                    j2 = j3;
                } else {
                    bhU.fvm.fvj++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.fvd = null;
            if (z2) {
                c.a(bhU, 10);
            }
            if (this.fvg == "frsStat") {
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
        f bhU;
        if (this.fvd != null && (bhU = bhU()) != null && bhU.fvn != null) {
            long fR = this.fvd.fR();
            if (fR > 3000) {
                e eVar = bhU.fvn;
                eVar.fvi = fR + eVar.fvi;
                bhU.fvn.num++;
                c.a(bhU, 10);
            }
        }
    }

    private f bhU() {
        return c.k(this.fvg, getNetType(), this.ahv);
    }

    private String getNetType() {
        int hk = i.hk();
        if (hk == 0) {
            return "N";
        }
        if (hk == 1) {
            return "WIFI";
        }
        if (hk == 3) {
            return "3G";
        }
        if (hk != 2) {
            return "N";
        }
        return "2G";
    }
}
