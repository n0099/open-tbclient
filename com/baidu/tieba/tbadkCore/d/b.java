package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.d eYE;
    private final int eYF = 10;
    private final int eYG = 3000;
    public String eYH = null;
    public boolean Zt = false;

    public b(String str) {
        O(str, false);
    }

    public void O(String str, boolean z) {
        this.eYH = str;
        this.Zt = z;
        this.eYE = new com.baidu.adp.lib.stats.d("dbg");
        c.i(str, getNetType(), z);
    }

    public void start() {
        this.eYE.ee();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        f bcI;
        if (this.eYE != null && (bcI = bcI()) != null) {
            if (z) {
                if (bcI.eYM != null) {
                    bcI.eYM.num++;
                    if (z2) {
                        bcI.eYM.eYJ += j2;
                        bcI.eYM.size += j;
                    } else {
                        bcI.eYM.eYK++;
                    }
                } else {
                    return;
                }
            } else if (bcI.eYN != null) {
                bcI.eYN.num++;
                if (z2) {
                    bcI.eYN.eYJ += j3;
                    bcI.eYN.size += j;
                    j2 = j3;
                } else {
                    bcI.eYN.eYK++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.eYE = null;
            if (z2) {
                c.a(bcI, 10);
            }
            if (this.eYH == "frsStat") {
                if (!z2 || j2 > 3000) {
                    com.baidu.adp.lib.stats.d dVar = new com.baidu.adp.lib.stats.d("dbg");
                    dVar.q("act", "frs");
                    dVar.q("result", z2 ? "0" : "1");
                    dVar.q("isHttp", z ? "1" : "0");
                    dVar.q("timeCost", String.valueOf(j2));
                    dVar.q("errCode", String.valueOf(i));
                    dVar.q("errMsg", str);
                    dVar.q("down", String.valueOf(j));
                    com.baidu.adp.lib.stats.a.dO().b("frs", dVar);
                }
            }
        }
    }

    public void destory() {
        f bcI;
        if (this.eYE != null && (bcI = bcI()) != null && bcI.eYO != null) {
            long ef = this.eYE.ef();
            if (ef > 3000) {
                e eVar = bcI.eYO;
                eVar.eYJ = ef + eVar.eYJ;
                bcI.eYO.num++;
                c.a(bcI, 10);
            }
        }
    }

    private f bcI() {
        return c.j(this.eYH, getNetType(), this.Zt);
    }

    private String getNetType() {
        int fx = i.fx();
        if (fx == 0) {
            return "N";
        }
        if (fx == 1) {
            return "WIFI";
        }
        if (fx == 3) {
            return "3G";
        }
        if (fx != 2) {
            return "N";
        }
        return "2G";
    }
}
