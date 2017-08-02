package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a ghG;
    private final int ghH = 10;
    private final int ghI = 3000;
    public String ghJ = null;
    public boolean ahX = false;

    public b(String str) {
        ab(str, false);
    }

    public void ab(String str, boolean z) {
        this.ghJ = str;
        this.ahX = z;
        this.ghG = new com.baidu.adp.lib.stats.a("dbg");
        c.j(str, getNetType(), z);
    }

    public void start() {
        this.ghG.fT();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e bsI;
        if (this.ghG != null && (bsI = bsI()) != null) {
            if (z) {
                if (bsI.ghO != null) {
                    bsI.ghO.num++;
                    if (z2) {
                        bsI.ghO.ghL += j2;
                        bsI.ghO.size += j;
                    } else {
                        bsI.ghO.ghM++;
                    }
                } else {
                    return;
                }
            } else if (bsI.ghP != null) {
                bsI.ghP.num++;
                if (z2) {
                    bsI.ghP.ghL += j3;
                    bsI.ghP.size += j;
                    j2 = j3;
                } else {
                    bsI.ghP.ghM++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.ghG = null;
            if (z2) {
                c.a(bsI, 10);
            }
            if (this.ghJ == "frsStat") {
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
        e bsI;
        if (this.ghG != null && (bsI = bsI()) != null && bsI.ghQ != null) {
            long fU = this.ghG.fU();
            if (fU > 3000) {
                d dVar = bsI.ghQ;
                dVar.ghL = fU + dVar.ghL;
                bsI.ghQ.num++;
                c.a(bsI, 10);
            }
        }
    }

    private e bsI() {
        return c.k(this.ghJ, getNetType(), this.ahX);
    }

    private String getNetType() {
        int hn = i.hn();
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
