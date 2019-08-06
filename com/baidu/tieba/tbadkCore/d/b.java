package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a jhB;
    private final int jhC = 10;
    private final int jhD = 3000;
    public String jhE = null;
    public boolean bVn = false;

    public b(String str) {
        aB(str, false);
    }

    public void aB(String str, boolean z) {
        this.jhE = str;
        this.bVn = z;
        this.jhB = new com.baidu.adp.lib.stats.a("dbg");
        c.y(str, getNetType(), z);
    }

    public void start() {
        this.jhB.iO();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e cqe;
        if (this.jhB != null && (cqe = cqe()) != null) {
            if (z) {
                if (cqe.jhJ != null) {
                    cqe.jhJ.num++;
                    if (z2) {
                        cqe.jhJ.jhG += j2;
                        cqe.jhJ.size += j;
                    } else {
                        cqe.jhJ.jhH++;
                    }
                } else {
                    return;
                }
            } else if (cqe.jhK != null) {
                cqe.jhK.num++;
                if (z2) {
                    cqe.jhK.jhG += j3;
                    cqe.jhK.size += j;
                    j2 = j3;
                } else {
                    cqe.jhK.jhH++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.jhB = null;
            if (z2) {
                c.a(cqe, 10);
            }
            if (this.jhE == "frsStat") {
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
        e cqe;
        if (this.jhB != null && (cqe = cqe()) != null && cqe.jhL != null) {
            long iP = this.jhB.iP();
            if (iP > 3000) {
                d dVar = cqe.jhL;
                dVar.jhG = iP + dVar.jhG;
                cqe.jhL.num++;
                c.a(cqe, 10);
            }
        }
    }

    private e cqe() {
        return c.z(this.jhE, getNetType(), this.bVn);
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
