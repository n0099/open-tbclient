package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a ghO;
    private final int ghP = 10;
    private final int ghQ = 3000;
    public String ghR = null;
    public boolean ain = false;

    public b(String str) {
        Z(str, false);
    }

    public void Z(String str, boolean z) {
        this.ghR = str;
        this.ain = z;
        this.ghO = new com.baidu.adp.lib.stats.a("dbg");
        c.k(str, getNetType(), z);
    }

    public void start() {
        this.ghO.fT();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e brO;
        if (this.ghO != null && (brO = brO()) != null) {
            if (z) {
                if (brO.ghW != null) {
                    brO.ghW.num++;
                    if (z2) {
                        brO.ghW.ghT += j2;
                        brO.ghW.size += j;
                    } else {
                        brO.ghW.ghU++;
                    }
                } else {
                    return;
                }
            } else if (brO.ghX != null) {
                brO.ghX.num++;
                if (z2) {
                    brO.ghX.ghT += j3;
                    brO.ghX.size += j;
                    j2 = j3;
                } else {
                    brO.ghX.ghU++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.ghO = null;
            if (z2) {
                c.a(brO, 10);
            }
            if (this.ghR == "frsStat") {
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
        e brO;
        if (this.ghO != null && (brO = brO()) != null && brO.ghY != null) {
            long fU = this.ghO.fU();
            if (fU > 3000) {
                d dVar = brO.ghY;
                dVar.ghT = fU + dVar.ghT;
                brO.ghY.num++;
                c.a(brO, 10);
            }
        }
    }

    private e brO() {
        return c.l(this.ghR, getNetType(), this.ain);
    }

    private String getNetType() {
        int hn = j.hn();
        if (hn == 0) {
            return "N";
        }
        if (hn == 1) {
            return "WIFI";
        }
        if (hn == 3) {
            return "3G";
        }
        if (hn != 2) {
            return "N";
        }
        return "2G";
    }
}
