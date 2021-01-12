package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a noo;
    private final int nop = 10;
    private final int noq = 3000;
    public String mLogType = null;
    public boolean mIsJson = false;

    public b(String str) {
        be(str, false);
    }

    public void be(String str, boolean z) {
        this.mLogType = str;
        this.mIsJson = z;
        this.noo = new com.baidu.adp.lib.stats.a("dbg");
        c.H(str, getNetType(), z);
    }

    public void start() {
        this.noo.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e dLE;
        if (this.noo != null && (dLE = dLE()) != null) {
            if (z) {
                if (dLE.nox != null) {
                    dLE.nox.num++;
                    if (z2) {
                        dLE.nox.nos += j2;
                        dLE.nox.size += j;
                    } else {
                        dLE.nox.nou++;
                    }
                } else {
                    return;
                }
            } else if (dLE.noy != null) {
                dLE.noy.num++;
                if (z2) {
                    dLE.noy.nos += j3;
                    dLE.noy.size += j;
                    j2 = j3;
                } else {
                    dLE.noy.nou++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.noo = null;
            if (z2) {
                c.a(dLE, 10);
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
        e dLE;
        if (this.noo != null && (dLE = dLE()) != null && dLE.noz != null) {
            long timeCost = this.noo.getTimeCost();
            if (timeCost > IMConnection.RETRY_DELAY_TIMES) {
                d dVar = dLE.noz;
                dVar.nos = timeCost + dVar.nos;
                dLE.noz.num++;
                c.a(dLE, 10);
            }
        }
    }

    private e dLE() {
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
