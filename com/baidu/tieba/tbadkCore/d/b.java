package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a kgL;
    private final int kgM = 10;
    private final int kgN = 3000;
    public String mLogType = null;
    public boolean mIsJson = false;

    public b(String str) {
        aB(str, false);
    }

    public void aB(String str, boolean z) {
        this.mLogType = str;
        this.mIsJson = z;
        this.kgL = new com.baidu.adp.lib.stats.a("dbg");
        c.A(str, getNetType(), z);
    }

    public void start() {
        this.kgL.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e cJR;
        if (this.kgL != null && (cJR = cJR()) != null) {
            if (z) {
                if (cJR.kgS != null) {
                    cJR.kgS.num++;
                    if (z2) {
                        cJR.kgS.kgP += j2;
                        cJR.kgS.size += j;
                    } else {
                        cJR.kgS.kgQ++;
                    }
                } else {
                    return;
                }
            } else if (cJR.kgT != null) {
                cJR.kgT.num++;
                if (z2) {
                    cJR.kgT.kgP += j3;
                    cJR.kgT.size += j;
                    j2 = j3;
                } else {
                    cJR.kgT.kgQ++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.kgL = null;
            if (z2) {
                c.a(cJR, 10);
            }
            if (this.mLogType == "frsStat") {
                if (!z2 || j2 > 3000) {
                    com.baidu.adp.lib.stats.a aVar = new com.baidu.adp.lib.stats.a("dbg");
                    aVar.append("act", "frs");
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
        e cJR;
        if (this.kgL != null && (cJR = cJR()) != null && cJR.kgU != null) {
            long timeCost = this.kgL.getTimeCost();
            if (timeCost > 3000) {
                d dVar = cJR.kgU;
                dVar.kgP = timeCost + dVar.kgP;
                cJR.kgU.num++;
                c.a(cJR, 10);
            }
        }
    }

    private e cJR() {
        return c.B(this.mLogType, getNetType(), this.mIsJson);
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
