package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a lOB;
    private final int lOC = 10;
    private final int lOD = 3000;
    public String mLogType = null;
    public boolean mIsJson = false;

    public b(String str) {
        aT(str, false);
    }

    public void aT(String str, boolean z) {
        this.mLogType = str;
        this.mIsJson = z;
        this.lOB = new com.baidu.adp.lib.stats.a("dbg");
        c.D(str, getNetType(), z);
    }

    public void start() {
        this.lOB.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e dlA;
        if (this.lOB != null && (dlA = dlA()) != null) {
            if (z) {
                if (dlA.lOI != null) {
                    dlA.lOI.num++;
                    if (z2) {
                        dlA.lOI.lOF += j2;
                        dlA.lOI.size += j;
                    } else {
                        dlA.lOI.lOG++;
                    }
                } else {
                    return;
                }
            } else if (dlA.lOJ != null) {
                dlA.lOJ.num++;
                if (z2) {
                    dlA.lOJ.lOF += j3;
                    dlA.lOJ.size += j;
                    j2 = j3;
                } else {
                    dlA.lOJ.lOG++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.lOB = null;
            if (z2) {
                c.a(dlA, 10);
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
        e dlA;
        if (this.lOB != null && (dlA = dlA()) != null && dlA.lOK != null) {
            long timeCost = this.lOB.getTimeCost();
            if (timeCost > 3000) {
                d dVar = dlA.lOK;
                dVar.lOF = timeCost + dVar.lOF;
                dlA.lOK.num++;
                c.a(dlA, 10);
            }
        }
    }

    private e dlA() {
        return c.E(this.mLogType, getNetType(), this.mIsJson);
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
