package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a jgu;
    private final int jgv = 10;
    private final int jgw = 3000;
    public String jgx = null;
    public boolean bVh = false;

    public b(String str) {
        aB(str, false);
    }

    public void aB(String str, boolean z) {
        this.jgx = str;
        this.bVh = z;
        this.jgu = new com.baidu.adp.lib.stats.a("dbg");
        c.y(str, getNetType(), z);
    }

    public void start() {
        this.jgu.iO();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e cpI;
        if (this.jgu != null && (cpI = cpI()) != null) {
            if (z) {
                if (cpI.jgC != null) {
                    cpI.jgC.num++;
                    if (z2) {
                        cpI.jgC.jgz += j2;
                        cpI.jgC.size += j;
                    } else {
                        cpI.jgC.jgA++;
                    }
                } else {
                    return;
                }
            } else if (cpI.jgD != null) {
                cpI.jgD.num++;
                if (z2) {
                    cpI.jgD.jgz += j3;
                    cpI.jgD.size += j;
                    j2 = j3;
                } else {
                    cpI.jgD.jgA++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.jgu = null;
            if (z2) {
                c.a(cpI, 10);
            }
            if (this.jgx == "frsStat") {
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
        e cpI;
        if (this.jgu != null && (cpI = cpI()) != null && cpI.jgE != null) {
            long iP = this.jgu.iP();
            if (iP > 3000) {
                d dVar = cpI.jgE;
                dVar.jgz = iP + dVar.jgz;
                cpI.jgE.num++;
                c.a(cpI, 10);
            }
        }
    }

    private e cpI() {
        return c.z(this.jgx, getNetType(), this.bVh);
    }

    private String getNetType() {
        int netType = j.netType();
        if (netType == 0) {
            return "N";
        }
        if (netType == 1) {
            return "WIFI";
        }
        if (netType == 3) {
            return "3G";
        }
        if (netType != 2) {
            return "N";
        }
        return "2G";
    }
}
