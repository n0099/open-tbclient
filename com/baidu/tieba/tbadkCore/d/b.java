package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a gCZ;
    private final int gDa = 10;
    private final int gDb = 3000;
    public String gDc = null;
    public boolean aiS = false;

    public b(String str) {
        aa(str, false);
    }

    public void aa(String str, boolean z) {
        this.gDc = str;
        this.aiS = z;
        this.gCZ = new com.baidu.adp.lib.stats.a("dbg");
        c.k(str, getNetType(), z);
    }

    public void start() {
        this.gCZ.fT();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e bxo;
        if (this.gCZ != null && (bxo = bxo()) != null) {
            if (z) {
                if (bxo.gDh != null) {
                    bxo.gDh.num++;
                    if (z2) {
                        bxo.gDh.gDe += j2;
                        bxo.gDh.size += j;
                    } else {
                        bxo.gDh.gDf++;
                    }
                } else {
                    return;
                }
            } else if (bxo.gDi != null) {
                bxo.gDi.num++;
                if (z2) {
                    bxo.gDi.gDe += j3;
                    bxo.gDi.size += j;
                    j2 = j3;
                } else {
                    bxo.gDi.gDf++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.gCZ = null;
            if (z2) {
                c.a(bxo, 10);
            }
            if (this.gDc == "frsStat") {
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
        e bxo;
        if (this.gCZ != null && (bxo = bxo()) != null && bxo.gDj != null) {
            long fU = this.gCZ.fU();
            if (fU > 3000) {
                d dVar = bxo.gDj;
                dVar.gDe = fU + dVar.gDe;
                bxo.gDj.num++;
                c.a(bxo, 10);
            }
        }
    }

    private e bxo() {
        return c.l(this.gDc, getNetType(), this.aiS);
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
