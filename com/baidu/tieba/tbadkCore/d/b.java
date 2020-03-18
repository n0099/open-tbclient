package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a kjI;
    private final int kjJ = 10;
    private final int kjK = 3000;
    public String mLogType = null;
    public boolean mIsJson = false;

    public b(String str) {
        aB(str, false);
    }

    public void aB(String str, boolean z) {
        this.mLogType = str;
        this.mIsJson = z;
        this.kjI = new com.baidu.adp.lib.stats.a("dbg");
        c.B(str, getNetType(), z);
    }

    public void start() {
        this.kjI.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e cLO;
        if (this.kjI != null && (cLO = cLO()) != null) {
            if (z) {
                if (cLO.kjP != null) {
                    cLO.kjP.num++;
                    if (z2) {
                        cLO.kjP.kjM += j2;
                        cLO.kjP.size += j;
                    } else {
                        cLO.kjP.kjN++;
                    }
                } else {
                    return;
                }
            } else if (cLO.kjQ != null) {
                cLO.kjQ.num++;
                if (z2) {
                    cLO.kjQ.kjM += j3;
                    cLO.kjQ.size += j;
                    j2 = j3;
                } else {
                    cLO.kjQ.kjN++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.kjI = null;
            if (z2) {
                c.a(cLO, 10);
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
        e cLO;
        if (this.kjI != null && (cLO = cLO()) != null && cLO.kjR != null) {
            long timeCost = this.kjI.getTimeCost();
            if (timeCost > 3000) {
                d dVar = cLO.kjR;
                dVar.kjM = timeCost + dVar.kjM;
                cLO.kjR.num++;
                c.a(cLO, 10);
            }
        }
    }

    private e cLO() {
        return c.C(this.mLogType, getNetType(), this.mIsJson);
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
