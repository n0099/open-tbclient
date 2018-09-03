package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a gPf;
    private final int gPg = 10;
    private final int gPh = 3000;
    public String gPi = null;
    public boolean asu = false;

    public b(String str) {
        U(str, false);
    }

    public void U(String str, boolean z) {
        this.gPi = str;
        this.asu = z;
        this.gPf = new com.baidu.adp.lib.stats.a("dbg");
        c.j(str, getNetType(), z);
    }

    public void start() {
        this.gPf.ir();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e bwA;
        if (this.gPf != null && (bwA = bwA()) != null) {
            if (z) {
                if (bwA.gPn != null) {
                    bwA.gPn.num++;
                    if (z2) {
                        bwA.gPn.gPk += j2;
                        bwA.gPn.size += j;
                    } else {
                        bwA.gPn.gPl++;
                    }
                } else {
                    return;
                }
            } else if (bwA.gPo != null) {
                bwA.gPo.num++;
                if (z2) {
                    bwA.gPo.gPk += j3;
                    bwA.gPo.size += j;
                    j2 = j3;
                } else {
                    bwA.gPo.gPl++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.gPf = null;
            if (z2) {
                c.a(bwA, 10);
            }
            if (this.gPi == "frsStat") {
                if (!z2 || j2 > 3000) {
                    com.baidu.adp.lib.stats.a aVar = new com.baidu.adp.lib.stats.a("dbg");
                    aVar.append(SocialConstants.PARAM_ACT, "frs");
                    aVar.append("result", z2 ? "0" : "1");
                    aVar.append("isHttp", z ? "1" : "0");
                    aVar.append("timeCost", String.valueOf(j2));
                    aVar.append("errCode", String.valueOf(i));
                    aVar.append("errMsg", str);
                    aVar.append("down", String.valueOf(j));
                    BdStatisticsManager.getInstance().debug("frs", aVar);
                }
            }
        }
    }

    public void destory() {
        e bwA;
        if (this.gPf != null && (bwA = bwA()) != null && bwA.gPp != null) {
            long is = this.gPf.is();
            if (is > 3000) {
                d dVar = bwA.gPp;
                dVar.gPk = is + dVar.gPk;
                bwA.gPp.num++;
                c.a(bwA, 10);
            }
        }
    }

    private e bwA() {
        return c.k(this.gPi, getNetType(), this.asu);
    }

    private String getNetType() {
        int jK = j.jK();
        if (jK == 0) {
            return "N";
        }
        if (jK == 1) {
            return "WIFI";
        }
        if (jK == 3) {
            return "3G";
        }
        if (jK != 2) {
            return "N";
        }
        return "2G";
    }
}
