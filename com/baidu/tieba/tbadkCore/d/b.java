package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a gkK;
    private final int gkL = 10;
    private final int gkM = 3000;
    public String gkN = null;
    public boolean ajs = false;

    public b(String str) {
        ab(str, false);
    }

    public void ab(String str, boolean z) {
        this.gkN = str;
        this.ajs = z;
        this.gkK = new com.baidu.adp.lib.stats.a("dbg");
        c.j(str, getNetType(), z);
    }

    public void start() {
        this.gkK.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e btq;
        if (this.gkK != null && (btq = btq()) != null) {
            if (z) {
                if (btq.gkS != null) {
                    btq.gkS.num++;
                    if (z2) {
                        btq.gkS.gkP += j2;
                        btq.gkS.size += j;
                    } else {
                        btq.gkS.gkQ++;
                    }
                } else {
                    return;
                }
            } else if (btq.gkT != null) {
                btq.gkT.num++;
                if (z2) {
                    btq.gkT.gkP += j3;
                    btq.gkT.size += j;
                    j2 = j3;
                } else {
                    btq.gkT.gkQ++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.gkK = null;
            if (z2) {
                c.a(btq, 10);
            }
            if (this.gkN == "frsStat") {
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
        e btq;
        if (this.gkK != null && (btq = btq()) != null && btq.gkU != null) {
            long gf = this.gkK.gf();
            if (gf > 3000) {
                d dVar = btq.gkU;
                dVar.gkP = gf + dVar.gkP;
                btq.gkU.num++;
                c.a(btq, 10);
            }
        }
    }

    private e btq() {
        return c.k(this.gkN, getNetType(), this.ajs);
    }

    private String getNetType() {
        int hx = i.hx();
        if (hx == 0) {
            return "N";
        }
        if (hx == 1) {
            return "WIFI";
        }
        if (hx == 3) {
            return "3G";
        }
        if (hx != 2) {
            return "N";
        }
        return "2G";
    }
}
