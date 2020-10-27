package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a mSn;
    private final int mSo = 10;
    private final int mSq = 3000;
    public String mLogType = null;
    public boolean mIsJson = false;

    public b(String str) {
        bd(str, false);
    }

    public void bd(String str, boolean z) {
        this.mLogType = str;
        this.mIsJson = z;
        this.mSn = new com.baidu.adp.lib.stats.a("dbg");
        c.C(str, getNetType(), z);
    }

    public void start() {
        this.mSn.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e dHP;
        if (this.mSn != null && (dHP = dHP()) != null) {
            if (z) {
                if (dHP.mSv != null) {
                    dHP.mSv.num++;
                    if (z2) {
                        dHP.mSv.mSs += j2;
                        dHP.mSv.size += j;
                    } else {
                        dHP.mSv.mSt++;
                    }
                } else {
                    return;
                }
            } else if (dHP.mSw != null) {
                dHP.mSw.num++;
                if (z2) {
                    dHP.mSw.mSs += j3;
                    dHP.mSw.size += j;
                    j2 = j3;
                } else {
                    dHP.mSw.mSt++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.mSn = null;
            if (z2) {
                c.a(dHP, 10);
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
        e dHP;
        if (this.mSn != null && (dHP = dHP()) != null && dHP.mSx != null) {
            long timeCost = this.mSn.getTimeCost();
            if (timeCost > IMConnection.RETRY_DELAY_TIMES) {
                d dVar = dHP.mSx;
                dVar.mSs = timeCost + dVar.mSs;
                dHP.mSx.num++;
                c.a(dHP, 10);
            }
        }
    }

    private e dHP() {
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
