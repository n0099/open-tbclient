package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a mZi;
    private final int mZj = 10;
    private final int mZk = 3000;
    public String mLogType = null;
    public boolean mIsJson = false;

    public b(String str) {
        bd(str, false);
    }

    public void bd(String str, boolean z) {
        this.mLogType = str;
        this.mIsJson = z;
        this.mZi = new com.baidu.adp.lib.stats.a("dbg");
        c.E(str, getNetType(), z);
    }

    public void start() {
        this.mZi.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e dKi;
        if (this.mZi != null && (dKi = dKi()) != null) {
            if (z) {
                if (dKi.mZp != null) {
                    dKi.mZp.num++;
                    if (z2) {
                        dKi.mZp.mZm += j2;
                        dKi.mZp.size += j;
                    } else {
                        dKi.mZp.mZn++;
                    }
                } else {
                    return;
                }
            } else if (dKi.mZq != null) {
                dKi.mZq.num++;
                if (z2) {
                    dKi.mZq.mZm += j3;
                    dKi.mZq.size += j;
                    j2 = j3;
                } else {
                    dKi.mZq.mZn++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.mZi = null;
            if (z2) {
                c.a(dKi, 10);
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
        e dKi;
        if (this.mZi != null && (dKi = dKi()) != null && dKi.mZr != null) {
            long timeCost = this.mZi.getTimeCost();
            if (timeCost > IMConnection.RETRY_DELAY_TIMES) {
                d dVar = dKi.mZr;
                dVar.mZm = timeCost + dVar.mZm;
                dKi.mZr.num++;
                c.a(dKi, 10);
            }
        }
    }

    private e dKi() {
        return c.F(this.mLogType, getNetType(), this.mIsJson);
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
