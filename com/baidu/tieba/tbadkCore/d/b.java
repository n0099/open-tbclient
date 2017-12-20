package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a gCU;
    private final int gCV = 10;
    private final int gCW = 3000;
    public String gCX = null;
    public boolean aiP = false;

    public b(String str) {
        aa(str, false);
    }

    public void aa(String str, boolean z) {
        this.gCX = str;
        this.aiP = z;
        this.gCU = new com.baidu.adp.lib.stats.a("dbg");
        c.k(str, getNetType(), z);
    }

    public void start() {
        this.gCU.fT();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e bxn;
        if (this.gCU != null && (bxn = bxn()) != null) {
            if (z) {
                if (bxn.gDc != null) {
                    bxn.gDc.num++;
                    if (z2) {
                        bxn.gDc.gCZ += j2;
                        bxn.gDc.size += j;
                    } else {
                        bxn.gDc.gDa++;
                    }
                } else {
                    return;
                }
            } else if (bxn.gDd != null) {
                bxn.gDd.num++;
                if (z2) {
                    bxn.gDd.gCZ += j3;
                    bxn.gDd.size += j;
                    j2 = j3;
                } else {
                    bxn.gDd.gDa++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.gCU = null;
            if (z2) {
                c.a(bxn, 10);
            }
            if (this.gCX == "frsStat") {
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
        e bxn;
        if (this.gCU != null && (bxn = bxn()) != null && bxn.gDe != null) {
            long fU = this.gCU.fU();
            if (fU > 3000) {
                d dVar = bxn.gDe;
                dVar.gCZ = fU + dVar.gCZ;
                bxn.gDe.num++;
                c.a(bxn, 10);
            }
        }
    }

    private e bxn() {
        return c.l(this.gCX, getNetType(), this.aiP);
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
