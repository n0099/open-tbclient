package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a ghA;
    private final int ghB = 10;
    private final int ghC = 3000;
    public String ghD = null;
    public boolean aib = false;

    public b(String str) {
        Z(str, false);
    }

    public void Z(String str, boolean z) {
        this.ghD = str;
        this.aib = z;
        this.ghA = new com.baidu.adp.lib.stats.a("dbg");
        c.k(str, getNetType(), z);
    }

    public void start() {
        this.ghA.fT();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e brH;
        if (this.ghA != null && (brH = brH()) != null) {
            if (z) {
                if (brH.ghI != null) {
                    brH.ghI.num++;
                    if (z2) {
                        brH.ghI.ghF += j2;
                        brH.ghI.size += j;
                    } else {
                        brH.ghI.ghG++;
                    }
                } else {
                    return;
                }
            } else if (brH.ghJ != null) {
                brH.ghJ.num++;
                if (z2) {
                    brH.ghJ.ghF += j3;
                    brH.ghJ.size += j;
                    j2 = j3;
                } else {
                    brH.ghJ.ghG++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.ghA = null;
            if (z2) {
                c.a(brH, 10);
            }
            if (this.ghD == "frsStat") {
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
        e brH;
        if (this.ghA != null && (brH = brH()) != null && brH.ghK != null) {
            long fU = this.ghA.fU();
            if (fU > 3000) {
                d dVar = brH.ghK;
                dVar.ghF = fU + dVar.ghF;
                brH.ghK.num++;
                c.a(brH, 10);
            }
        }
    }

    private e brH() {
        return c.l(this.ghD, getNetType(), this.aib);
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
