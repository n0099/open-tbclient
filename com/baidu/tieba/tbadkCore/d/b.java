package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a nya;
    private final int nyb = 10;
    private final int nyc = 3000;
    public String mLogType = null;
    public boolean mIsJson = false;

    public b(String str) {
        be(str, false);
    }

    public void be(String str, boolean z) {
        this.mLogType = str;
        this.mIsJson = z;
        this.nya = new com.baidu.adp.lib.stats.a("dbg");
        c.H(str, getNetType(), z);
    }

    public void start() {
        this.nya.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e dNP;
        if (this.nya != null && (dNP = dNP()) != null) {
            if (z) {
                if (dNP.nyh != null) {
                    dNP.nyh.num++;
                    if (z2) {
                        dNP.nyh.nye += j2;
                        dNP.nyh.size += j;
                    } else {
                        dNP.nyh.nyf++;
                    }
                } else {
                    return;
                }
            } else if (dNP.nyi != null) {
                dNP.nyi.num++;
                if (z2) {
                    dNP.nyi.nye += j3;
                    dNP.nyi.size += j;
                    j2 = j3;
                } else {
                    dNP.nyi.nyf++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.nya = null;
            if (z2) {
                c.a(dNP, 10);
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
        e dNP;
        if (this.nya != null && (dNP = dNP()) != null && dNP.nyj != null) {
            long timeCost = this.nya.getTimeCost();
            if (timeCost > IMConnection.RETRY_DELAY_TIMES) {
                d dVar = dNP.nyj;
                dVar.nye = timeCost + dVar.nye;
                dNP.nyj.num++;
                c.a(dNP, 10);
            }
        }
    }

    private e dNP() {
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
