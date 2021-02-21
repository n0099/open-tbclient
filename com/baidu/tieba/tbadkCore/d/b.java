package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a nyA;
    private final int nyB = 10;
    private final int nyC = 3000;
    public String mLogType = null;
    public boolean mIsJson = false;

    public b(String str) {
        be(str, false);
    }

    public void be(String str, boolean z) {
        this.mLogType = str;
        this.mIsJson = z;
        this.nyA = new com.baidu.adp.lib.stats.a("dbg");
        c.H(str, getNetType(), z);
    }

    public void start() {
        this.nyA.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e dNX;
        if (this.nyA != null && (dNX = dNX()) != null) {
            if (z) {
                if (dNX.nyH != null) {
                    dNX.nyH.num++;
                    if (z2) {
                        dNX.nyH.nyE += j2;
                        dNX.nyH.size += j;
                    } else {
                        dNX.nyH.nyF++;
                    }
                } else {
                    return;
                }
            } else if (dNX.nyI != null) {
                dNX.nyI.num++;
                if (z2) {
                    dNX.nyI.nyE += j3;
                    dNX.nyI.size += j;
                    j2 = j3;
                } else {
                    dNX.nyI.nyF++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.nyA = null;
            if (z2) {
                c.a(dNX, 10);
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
        e dNX;
        if (this.nyA != null && (dNX = dNX()) != null && dNX.nyJ != null) {
            long timeCost = this.nyA.getTimeCost();
            if (timeCost > IMConnection.RETRY_DELAY_TIMES) {
                d dVar = dNX.nyJ;
                dVar.nyE = timeCost + dVar.nyE;
                dNX.nyJ.num++;
                c.a(dNX, 10);
            }
        }
    }

    private e dNX() {
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
