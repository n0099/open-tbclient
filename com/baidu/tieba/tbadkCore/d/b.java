package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a kgQ;
    private final int kgR = 10;
    private final int kgS = 3000;
    public String mLogType = null;
    public boolean mIsJson = false;

    public b(String str) {
        aB(str, false);
    }

    public void aB(String str, boolean z) {
        this.mLogType = str;
        this.mIsJson = z;
        this.kgQ = new com.baidu.adp.lib.stats.a("dbg");
        c.A(str, getNetType(), z);
    }

    public void start() {
        this.kgQ.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e cJT;
        if (this.kgQ != null && (cJT = cJT()) != null) {
            if (z) {
                if (cJT.kgX != null) {
                    cJT.kgX.num++;
                    if (z2) {
                        cJT.kgX.kgU += j2;
                        cJT.kgX.size += j;
                    } else {
                        cJT.kgX.kgV++;
                    }
                } else {
                    return;
                }
            } else if (cJT.kgY != null) {
                cJT.kgY.num++;
                if (z2) {
                    cJT.kgY.kgU += j3;
                    cJT.kgY.size += j;
                    j2 = j3;
                } else {
                    cJT.kgY.kgV++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.kgQ = null;
            if (z2) {
                c.a(cJT, 10);
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
        e cJT;
        if (this.kgQ != null && (cJT = cJT()) != null && cJT.kgZ != null) {
            long timeCost = this.kgQ.getTimeCost();
            if (timeCost > 3000) {
                d dVar = cJT.kgZ;
                dVar.kgU = timeCost + dVar.kgU;
                cJT.kgZ.num++;
                c.a(cJT, 10);
            }
        }
    }

    private e cJT() {
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
