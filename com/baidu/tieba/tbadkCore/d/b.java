package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a mqa;
    private final int mqb = 10;
    private final int mqc = 3000;
    public String mLogType = null;
    public boolean mIsJson = false;

    public b(String str) {
        aX(str, false);
    }

    public void aX(String str, boolean z) {
        this.mLogType = str;
        this.mIsJson = z;
        this.mqa = new com.baidu.adp.lib.stats.a("dbg");
        c.C(str, getNetType(), z);
    }

    public void start() {
        this.mqa.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e dAV;
        if (this.mqa != null && (dAV = dAV()) != null) {
            if (z) {
                if (dAV.mqh != null) {
                    dAV.mqh.num++;
                    if (z2) {
                        dAV.mqh.mqe += j2;
                        dAV.mqh.size += j;
                    } else {
                        dAV.mqh.mqf++;
                    }
                } else {
                    return;
                }
            } else if (dAV.mqi != null) {
                dAV.mqi.num++;
                if (z2) {
                    dAV.mqi.mqe += j3;
                    dAV.mqi.size += j;
                    j2 = j3;
                } else {
                    dAV.mqi.mqf++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.mqa = null;
            if (z2) {
                c.a(dAV, 10);
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
        e dAV;
        if (this.mqa != null && (dAV = dAV()) != null && dAV.mqj != null) {
            long timeCost = this.mqa.getTimeCost();
            if (timeCost > IMConnection.RETRY_DELAY_TIMES) {
                d dVar = dAV.mqj;
                dVar.mqe = timeCost + dVar.mqe;
                dAV.mqj.num++;
                c.a(dAV, 10);
            }
        }
    }

    private e dAV() {
        return c.D(this.mLogType, getNetType(), this.mIsJson);
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
