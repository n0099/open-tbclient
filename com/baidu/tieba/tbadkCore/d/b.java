package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a mYq;
    private final int mYr = 10;
    private final int mYs = 3000;
    public String mLogType = null;
    public boolean mIsJson = false;

    public b(String str) {
        bd(str, false);
    }

    public void bd(String str, boolean z) {
        this.mLogType = str;
        this.mIsJson = z;
        this.mYq = new com.baidu.adp.lib.stats.a("dbg");
        c.D(str, getNetType(), z);
    }

    public void start() {
        this.mYq.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e dKr;
        if (this.mYq != null && (dKr = dKr()) != null) {
            if (z) {
                if (dKr.mYx != null) {
                    dKr.mYx.num++;
                    if (z2) {
                        dKr.mYx.mYu += j2;
                        dKr.mYx.size += j;
                    } else {
                        dKr.mYx.mYv++;
                    }
                } else {
                    return;
                }
            } else if (dKr.mYy != null) {
                dKr.mYy.num++;
                if (z2) {
                    dKr.mYy.mYu += j3;
                    dKr.mYy.size += j;
                    j2 = j3;
                } else {
                    dKr.mYy.mYv++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.mYq = null;
            if (z2) {
                c.a(dKr, 10);
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
        e dKr;
        if (this.mYq != null && (dKr = dKr()) != null && dKr.mYz != null) {
            long timeCost = this.mYq.getTimeCost();
            if (timeCost > IMConnection.RETRY_DELAY_TIMES) {
                d dVar = dKr.mYz;
                dVar.mYu = timeCost + dVar.mYu;
                dKr.mYz.num++;
                c.a(dKr, 10);
            }
        }
    }

    private e dKr() {
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
