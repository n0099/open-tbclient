package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a nop;
    private final int noq = 10;
    private final int nor = 3000;
    public String mLogType = null;
    public boolean mIsJson = false;

    public b(String str) {
        be(str, false);
    }

    public void be(String str, boolean z) {
        this.mLogType = str;
        this.mIsJson = z;
        this.nop = new com.baidu.adp.lib.stats.a("dbg");
        c.H(str, getNetType(), z);
    }

    public void start() {
        this.nop.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e dLE;
        if (this.nop != null && (dLE = dLE()) != null) {
            if (z) {
                if (dLE.noy != null) {
                    dLE.noy.num++;
                    if (z2) {
                        dLE.noy.nou += j2;
                        dLE.noy.size += j;
                    } else {
                        dLE.noy.nov++;
                    }
                } else {
                    return;
                }
            } else if (dLE.noz != null) {
                dLE.noz.num++;
                if (z2) {
                    dLE.noz.nou += j3;
                    dLE.noz.size += j;
                    j2 = j3;
                } else {
                    dLE.noz.nov++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.nop = null;
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
        if (this.nop != null && (dLE = dLE()) != null && dLE.noA != null) {
            long timeCost = this.nop.getTimeCost();
            if (timeCost > IMConnection.RETRY_DELAY_TIMES) {
                d dVar = dLE.noA;
                dVar.nou = timeCost + dVar.nou;
                dLE.noA.num++;
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
