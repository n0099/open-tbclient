package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.c fvl;
    private final int fvm = 10;
    private final int fvn = 3000;
    public String fvo = null;
    public boolean ahc = false;

    public b(String str) {
        W(str, false);
    }

    public void W(String str, boolean z) {
        this.fvo = str;
        this.ahc = z;
        this.fvl = new com.baidu.adp.lib.stats.c("dbg");
        c.j(str, getNetType(), z);
    }

    public void start() {
        this.fvl.fW();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        f bhd;
        if (this.fvl != null && (bhd = bhd()) != null) {
            if (z) {
                if (bhd.fvt != null) {
                    bhd.fvt.num++;
                    if (z2) {
                        bhd.fvt.fvq += j2;
                        bhd.fvt.size += j;
                    } else {
                        bhd.fvt.fvr++;
                    }
                } else {
                    return;
                }
            } else if (bhd.fvu != null) {
                bhd.fvu.num++;
                if (z2) {
                    bhd.fvu.fvq += j3;
                    bhd.fvu.size += j;
                    j2 = j3;
                } else {
                    bhd.fvu.fvr++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.fvl = null;
            if (z2) {
                c.a(bhd, 10);
            }
            if (this.fvo == "frsStat") {
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
        f bhd;
        if (this.fvl != null && (bhd = bhd()) != null && bhd.fvv != null) {
            long fX = this.fvl.fX();
            if (fX > 3000) {
                e eVar = bhd.fvv;
                eVar.fvq = fX + eVar.fvq;
                bhd.fvv.num++;
                c.a(bhd, 10);
            }
        }
    }

    private f bhd() {
        return c.k(this.fvo, getNetType(), this.ahc);
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
