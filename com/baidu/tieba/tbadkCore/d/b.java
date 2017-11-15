package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a grp;
    private final int grq = 10;
    private final int grr = 3000;
    public String grs = null;
    public boolean aiy = false;

    public b(String str) {
        X(str, false);
    }

    public void X(String str, boolean z) {
        this.grs = str;
        this.aiy = z;
        this.grp = new com.baidu.adp.lib.stats.a("dbg");
        c.l(str, getNetType(), z);
    }

    public void start() {
        this.grp.fT();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e buX;
        if (this.grp != null && (buX = buX()) != null) {
            if (z) {
                if (buX.grx != null) {
                    buX.grx.num++;
                    if (z2) {
                        buX.grx.gru += j2;
                        buX.grx.size += j;
                    } else {
                        buX.grx.grv++;
                    }
                } else {
                    return;
                }
            } else if (buX.gry != null) {
                buX.gry.num++;
                if (z2) {
                    buX.gry.gru += j3;
                    buX.gry.size += j;
                    j2 = j3;
                } else {
                    buX.gry.grv++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.grp = null;
            if (z2) {
                c.a(buX, 10);
            }
            if (this.grs == "frsStat") {
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
        e buX;
        if (this.grp != null && (buX = buX()) != null && buX.grz != null) {
            long fU = this.grp.fU();
            if (fU > 3000) {
                d dVar = buX.grz;
                dVar.gru = fU + dVar.gru;
                buX.grz.num++;
                c.a(buX, 10);
            }
        }
    }

    private e buX() {
        return c.m(this.grs, getNetType(), this.aiy);
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
