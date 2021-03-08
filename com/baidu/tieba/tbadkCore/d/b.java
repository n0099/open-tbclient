package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a nAF;
    private final int nAG = 10;
    private final int nAH = 3000;
    public String mLogType = null;
    public boolean mIsJson = false;

    public b(String str) {
        be(str, false);
    }

    public void be(String str, boolean z) {
        this.mLogType = str;
        this.mIsJson = z;
        this.nAF = new com.baidu.adp.lib.stats.a("dbg");
        c.H(str, getNetType(), z);
    }

    public void start() {
        this.nAF.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e dOg;
        if (this.nAF != null && (dOg = dOg()) != null) {
            if (z) {
                if (dOg.nAM != null) {
                    dOg.nAM.num++;
                    if (z2) {
                        dOg.nAM.nAJ += j2;
                        dOg.nAM.size += j;
                    } else {
                        dOg.nAM.nAK++;
                    }
                } else {
                    return;
                }
            } else if (dOg.nAN != null) {
                dOg.nAN.num++;
                if (z2) {
                    dOg.nAN.nAJ += j3;
                    dOg.nAN.size += j;
                    j2 = j3;
                } else {
                    dOg.nAN.nAK++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.nAF = null;
            if (z2) {
                c.a(dOg, 10);
            }
            if (this.mLogType == "frsStat") {
                if (!z2 || j2 > IMConnection.RETRY_DELAY_TIMES) {
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
        e dOg;
        if (this.nAF != null && (dOg = dOg()) != null && dOg.nAO != null) {
            long timeCost = this.nAF.getTimeCost();
            if (timeCost > IMConnection.RETRY_DELAY_TIMES) {
                d dVar = dOg.nAO;
                dVar.nAJ = timeCost + dVar.nAJ;
                dOg.nAO.num++;
                c.a(dOg, 10);
            }
        }
    }

    private e dOg() {
        return c.I(this.mLogType, getNetType(), this.mIsJson);
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
