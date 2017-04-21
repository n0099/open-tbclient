package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.c fzd;
    private final int fze = 10;
    private final int fzf = 3000;
    public String fzg = null;
    public boolean ahK = false;

    public b(String str) {
        W(str, false);
    }

    public void W(String str, boolean z) {
        this.fzg = str;
        this.ahK = z;
        this.fzd = new com.baidu.adp.lib.stats.c("dbg");
        c.k(str, getNetType(), z);
    }

    public void start() {
        this.fzd.fW();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        f bjG;
        if (this.fzd != null && (bjG = bjG()) != null) {
            if (z) {
                if (bjG.fzl != null) {
                    bjG.fzl.num++;
                    if (z2) {
                        bjG.fzl.fzi += j2;
                        bjG.fzl.size += j;
                    } else {
                        bjG.fzl.fzj++;
                    }
                } else {
                    return;
                }
            } else if (bjG.fzm != null) {
                bjG.fzm.num++;
                if (z2) {
                    bjG.fzm.fzi += j3;
                    bjG.fzm.size += j;
                    j2 = j3;
                } else {
                    bjG.fzm.fzj++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.fzd = null;
            if (z2) {
                c.a(bjG, 10);
            }
            if (this.fzg == "frsStat") {
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
        f bjG;
        if (this.fzd != null && (bjG = bjG()) != null && bjG.fzn != null) {
            long fX = this.fzd.fX();
            if (fX > 3000) {
                e eVar = bjG.fzn;
                eVar.fzi = fX + eVar.fzi;
                bjG.fzn.num++;
                c.a(bjG, 10);
            }
        }
    }

    private f bjG() {
        return c.l(this.fzg, getNetType(), this.ahK);
    }

    private String getNetType() {
        int hq = i.hq();
        if (hq == 0) {
            return "N";
        }
        if (hq == 1) {
            return "WIFI";
        }
        if (hq == 3) {
            return "3G";
        }
        if (hq != 2) {
            return "N";
        }
        return "2G";
    }
}
