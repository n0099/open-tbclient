package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a ghP;
    private final int ghQ = 10;
    private final int ghR = 3000;
    public String ghS = null;
    public boolean ain = false;

    public b(String str) {
        Z(str, false);
    }

    public void Z(String str, boolean z) {
        this.ghS = str;
        this.ain = z;
        this.ghP = new com.baidu.adp.lib.stats.a("dbg");
        c.k(str, getNetType(), z);
    }

    public void start() {
        this.ghP.fT();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e brP;
        if (this.ghP != null && (brP = brP()) != null) {
            if (z) {
                if (brP.ghX != null) {
                    brP.ghX.num++;
                    if (z2) {
                        brP.ghX.ghU += j2;
                        brP.ghX.size += j;
                    } else {
                        brP.ghX.ghV++;
                    }
                } else {
                    return;
                }
            } else if (brP.ghY != null) {
                brP.ghY.num++;
                if (z2) {
                    brP.ghY.ghU += j3;
                    brP.ghY.size += j;
                    j2 = j3;
                } else {
                    brP.ghY.ghV++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.ghP = null;
            if (z2) {
                c.a(brP, 10);
            }
            if (this.ghS == "frsStat") {
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
        e brP;
        if (this.ghP != null && (brP = brP()) != null && brP.ghZ != null) {
            long fU = this.ghP.fU();
            if (fU > 3000) {
                d dVar = brP.ghZ;
                dVar.ghU = fU + dVar.ghU;
                brP.ghZ.num++;
                c.a(brP, 10);
            }
        }
    }

    private e brP() {
        return c.l(this.ghS, getNetType(), this.ain);
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
