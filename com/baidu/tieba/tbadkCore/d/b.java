package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a giS;
    private final int giT = 10;
    private final int giU = 3000;
    public String giV = null;
    public boolean ajq = false;

    public b(String str) {
        aa(str, false);
    }

    public void aa(String str, boolean z) {
        this.giV = str;
        this.ajq = z;
        this.giS = new com.baidu.adp.lib.stats.a("dbg");
        c.j(str, getNetType(), z);
    }

    public void start() {
        this.giS.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e bsP;
        if (this.giS != null && (bsP = bsP()) != null) {
            if (z) {
                if (bsP.gja != null) {
                    bsP.gja.num++;
                    if (z2) {
                        bsP.gja.giX += j2;
                        bsP.gja.size += j;
                    } else {
                        bsP.gja.giY++;
                    }
                } else {
                    return;
                }
            } else if (bsP.gjb != null) {
                bsP.gjb.num++;
                if (z2) {
                    bsP.gjb.giX += j3;
                    bsP.gjb.size += j;
                    j2 = j3;
                } else {
                    bsP.gjb.giY++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.giS = null;
            if (z2) {
                c.a(bsP, 10);
            }
            if (this.giV == "frsStat") {
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
        e bsP;
        if (this.giS != null && (bsP = bsP()) != null && bsP.gjc != null) {
            long gf = this.giS.gf();
            if (gf > 3000) {
                d dVar = bsP.gjc;
                dVar.giX = gf + dVar.giX;
                bsP.gjc.num++;
                c.a(bsP, 10);
            }
        }
    }

    private e bsP() {
        return c.k(this.giV, getNetType(), this.ajq);
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
