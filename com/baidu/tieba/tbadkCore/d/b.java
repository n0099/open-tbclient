package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a gkf;
    private final int gkg = 10;
    private final int gkh = 3000;
    public String gki = null;
    public boolean aiL = false;

    public b(String str) {
        ac(str, false);
    }

    public void ac(String str, boolean z) {
        this.gki = str;
        this.aiL = z;
        this.gkf = new com.baidu.adp.lib.stats.a("dbg");
        c.k(str, getNetType(), z);
    }

    public void start() {
        this.gkf.fU();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e bsQ;
        if (this.gkf != null && (bsQ = bsQ()) != null) {
            if (z) {
                if (bsQ.gkn != null) {
                    bsQ.gkn.num++;
                    if (z2) {
                        bsQ.gkn.gkk += j2;
                        bsQ.gkn.size += j;
                    } else {
                        bsQ.gkn.gkl++;
                    }
                } else {
                    return;
                }
            } else if (bsQ.gko != null) {
                bsQ.gko.num++;
                if (z2) {
                    bsQ.gko.gkk += j3;
                    bsQ.gko.size += j;
                    j2 = j3;
                } else {
                    bsQ.gko.gkl++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.gkf = null;
            if (z2) {
                c.a(bsQ, 10);
            }
            if (this.gki == "frsStat") {
                if (!z2 || j2 > 3000) {
                    com.baidu.adp.lib.stats.a aVar = new com.baidu.adp.lib.stats.a("dbg");
                    aVar.p("act", "frs");
                    aVar.p("result", z2 ? "0" : "1");
                    aVar.p("isHttp", z ? "1" : "0");
                    aVar.p("timeCost", String.valueOf(j2));
                    aVar.p("errCode", String.valueOf(i));
                    aVar.p("errMsg", str);
                    aVar.p("down", String.valueOf(j));
                    BdStatisticsManager.getInstance().debug("frs", aVar);
                }
            }
        }
    }

    public void destory() {
        e bsQ;
        if (this.gkf != null && (bsQ = bsQ()) != null && bsQ.gkp != null) {
            long fV = this.gkf.fV();
            if (fV > 3000) {
                d dVar = bsQ.gkp;
                dVar.gkk = fV + dVar.gkk;
                bsQ.gkp.num++;
                c.a(bsQ, 10);
            }
        }
    }

    private e bsQ() {
        return c.l(this.gki, getNetType(), this.aiL);
    }

    private String getNetType() {
        int ho = i.ho();
        if (ho == 0) {
            return "N";
        }
        if (ho == 1) {
            return "WIFI";
        }
        if (ho == 3) {
            return "3G";
        }
        if (ho != 2) {
            return "N";
        }
        return "2G";
    }
}
