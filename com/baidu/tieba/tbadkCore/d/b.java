package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a gAl;
    private final int gAm = 10;
    private final int gAn = 3000;
    public String gAo = null;
    public boolean aiV = false;

    public b(String str) {
        Z(str, false);
    }

    public void Z(String str, boolean z) {
        this.gAo = str;
        this.aiV = z;
        this.gAl = new com.baidu.adp.lib.stats.a("dbg");
        c.k(str, getNetType(), z);
    }

    public void start() {
        this.gAl.fT();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e bwH;
        if (this.gAl != null && (bwH = bwH()) != null) {
            if (z) {
                if (bwH.gAt != null) {
                    bwH.gAt.num++;
                    if (z2) {
                        bwH.gAt.gAq += j2;
                        bwH.gAt.size += j;
                    } else {
                        bwH.gAt.gAr++;
                    }
                } else {
                    return;
                }
            } else if (bwH.gAu != null) {
                bwH.gAu.num++;
                if (z2) {
                    bwH.gAu.gAq += j3;
                    bwH.gAu.size += j;
                    j2 = j3;
                } else {
                    bwH.gAu.gAr++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.gAl = null;
            if (z2) {
                c.a(bwH, 10);
            }
            if (this.gAo == "frsStat") {
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
        e bwH;
        if (this.gAl != null && (bwH = bwH()) != null && bwH.gAv != null) {
            long fU = this.gAl.fU();
            if (fU > 3000) {
                d dVar = bwH.gAv;
                dVar.gAq = fU + dVar.gAq;
                bwH.gAv.num++;
                c.a(bwH, 10);
            }
        }
    }

    private e bwH() {
        return c.l(this.gAo, getNetType(), this.aiV);
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
