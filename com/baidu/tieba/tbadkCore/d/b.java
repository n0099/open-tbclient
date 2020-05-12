package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a kTS;
    private final int kTT = 10;
    private final int kTU = 3000;
    public String mLogType = null;
    public boolean mIsJson = false;

    public b(String str) {
        aH(str, false);
    }

    public void aH(String str, boolean z) {
        this.mLogType = str;
        this.mIsJson = z;
        this.kTS = new com.baidu.adp.lib.stats.a("dbg");
        c.A(str, getNetType(), z);
    }

    public void start() {
        this.kTS.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e cWI;
        if (this.kTS != null && (cWI = cWI()) != null) {
            if (z) {
                if (cWI.kTZ != null) {
                    cWI.kTZ.num++;
                    if (z2) {
                        cWI.kTZ.kTW += j2;
                        cWI.kTZ.size += j;
                    } else {
                        cWI.kTZ.kTX++;
                    }
                } else {
                    return;
                }
            } else if (cWI.kUa != null) {
                cWI.kUa.num++;
                if (z2) {
                    cWI.kUa.kTW += j3;
                    cWI.kUa.size += j;
                    j2 = j3;
                } else {
                    cWI.kUa.kTX++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.kTS = null;
            if (z2) {
                c.a(cWI, 10);
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
        e cWI;
        if (this.kTS != null && (cWI = cWI()) != null && cWI.kUb != null) {
            long timeCost = this.kTS.getTimeCost();
            if (timeCost > 3000) {
                d dVar = cWI.kUb;
                dVar.kTW = timeCost + dVar.kTW;
                cWI.kUb.num++;
                c.a(cWI, 10);
            }
        }
    }

    private e cWI() {
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
