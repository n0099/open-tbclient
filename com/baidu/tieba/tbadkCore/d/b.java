package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a gjl;
    private final int gjm = 10;
    private final int gjn = 3000;
    public String gjo = null;
    public boolean aiM = false;

    public b(String str) {
        ac(str, false);
    }

    public void ac(String str, boolean z) {
        this.gjo = str;
        this.aiM = z;
        this.gjl = new com.baidu.adp.lib.stats.a("dbg");
        c.k(str, getNetType(), z);
    }

    public void start() {
        this.gjl.fU();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e bsF;
        if (this.gjl != null && (bsF = bsF()) != null) {
            if (z) {
                if (bsF.gjt != null) {
                    bsF.gjt.num++;
                    if (z2) {
                        bsF.gjt.gjq += j2;
                        bsF.gjt.size += j;
                    } else {
                        bsF.gjt.gjr++;
                    }
                } else {
                    return;
                }
            } else if (bsF.gju != null) {
                bsF.gju.num++;
                if (z2) {
                    bsF.gju.gjq += j3;
                    bsF.gju.size += j;
                    j2 = j3;
                } else {
                    bsF.gju.gjr++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.gjl = null;
            if (z2) {
                c.a(bsF, 10);
            }
            if (this.gjo == "frsStat") {
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
        e bsF;
        if (this.gjl != null && (bsF = bsF()) != null && bsF.gjv != null) {
            long fV = this.gjl.fV();
            if (fV > 3000) {
                d dVar = bsF.gjv;
                dVar.gjq = fV + dVar.gjq;
                bsF.gjv.num++;
                c.a(bsF, 10);
            }
        }
    }

    private e bsF() {
        return c.l(this.gjo, getNetType(), this.aiM);
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
