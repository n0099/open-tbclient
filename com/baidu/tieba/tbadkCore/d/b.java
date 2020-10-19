package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a mFH;
    private final int mFI = 10;
    private final int mFJ = 3000;
    public String mLogType = null;
    public boolean mIsJson = false;

    public b(String str) {
        bb(str, false);
    }

    public void bb(String str, boolean z) {
        this.mLogType = str;
        this.mIsJson = z;
        this.mFH = new com.baidu.adp.lib.stats.a("dbg");
        c.C(str, getNetType(), z);
    }

    public void start() {
        this.mFH.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e dEH;
        if (this.mFH != null && (dEH = dEH()) != null) {
            if (z) {
                if (dEH.mFO != null) {
                    dEH.mFO.num++;
                    if (z2) {
                        dEH.mFO.mFL += j2;
                        dEH.mFO.size += j;
                    } else {
                        dEH.mFO.mFM++;
                    }
                } else {
                    return;
                }
            } else if (dEH.mFP != null) {
                dEH.mFP.num++;
                if (z2) {
                    dEH.mFP.mFL += j3;
                    dEH.mFP.size += j;
                    j2 = j3;
                } else {
                    dEH.mFP.mFM++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.mFH = null;
            if (z2) {
                c.a(dEH, 10);
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
        e dEH;
        if (this.mFH != null && (dEH = dEH()) != null && dEH.mFQ != null) {
            long timeCost = this.mFH.getTimeCost();
            if (timeCost > IMConnection.RETRY_DELAY_TIMES) {
                d dVar = dEH.mFQ;
                dVar.mFL = timeCost + dVar.mFL;
                dEH.mFQ.num++;
                c.a(dEH, 10);
            }
        }
    }

    private e dEH() {
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
