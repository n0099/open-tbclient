package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a gqm;
    private final int gqn = 10;
    private final int gqo = 3000;
    public String gqp = null;
    public boolean aiy = false;

    public b(String str) {
        X(str, false);
    }

    public void X(String str, boolean z) {
        this.gqp = str;
        this.aiy = z;
        this.gqm = new com.baidu.adp.lib.stats.a("dbg");
        c.k(str, getNetType(), z);
    }

    public void start() {
        this.gqm.fT();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e buL;
        if (this.gqm != null && (buL = buL()) != null) {
            if (z) {
                if (buL.gqu != null) {
                    buL.gqu.num++;
                    if (z2) {
                        buL.gqu.gqr += j2;
                        buL.gqu.size += j;
                    } else {
                        buL.gqu.gqs++;
                    }
                } else {
                    return;
                }
            } else if (buL.gqv != null) {
                buL.gqv.num++;
                if (z2) {
                    buL.gqv.gqr += j3;
                    buL.gqv.size += j;
                    j2 = j3;
                } else {
                    buL.gqv.gqs++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.gqm = null;
            if (z2) {
                c.a(buL, 10);
            }
            if (this.gqp == "frsStat") {
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
        e buL;
        if (this.gqm != null && (buL = buL()) != null && buL.gqw != null) {
            long fU = this.gqm.fU();
            if (fU > 3000) {
                d dVar = buL.gqw;
                dVar.gqr = fU + dVar.gqr;
                buL.gqw.num++;
                c.a(buL, 10);
            }
        }
    }

    private e buL() {
        return c.l(this.gqp, getNetType(), this.aiy);
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
