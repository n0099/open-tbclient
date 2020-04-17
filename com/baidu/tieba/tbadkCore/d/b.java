package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a kTO;
    private final int kTP = 10;
    private final int kTQ = 3000;
    public String mLogType = null;
    public boolean mIsJson = false;

    public b(String str) {
        aH(str, false);
    }

    public void aH(String str, boolean z) {
        this.mLogType = str;
        this.mIsJson = z;
        this.kTO = new com.baidu.adp.lib.stats.a("dbg");
        c.A(str, getNetType(), z);
    }

    public void start() {
        this.kTO.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e cWK;
        if (this.kTO != null && (cWK = cWK()) != null) {
            if (z) {
                if (cWK.kTV != null) {
                    cWK.kTV.num++;
                    if (z2) {
                        cWK.kTV.kTS += j2;
                        cWK.kTV.size += j;
                    } else {
                        cWK.kTV.kTT++;
                    }
                } else {
                    return;
                }
            } else if (cWK.kTW != null) {
                cWK.kTW.num++;
                if (z2) {
                    cWK.kTW.kTS += j3;
                    cWK.kTW.size += j;
                    j2 = j3;
                } else {
                    cWK.kTW.kTT++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.kTO = null;
            if (z2) {
                c.a(cWK, 10);
            }
            if (this.mLogType == "frsStat") {
                if (!z2 || j2 > 3000) {
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
        e cWK;
        if (this.kTO != null && (cWK = cWK()) != null && cWK.kTX != null) {
            long timeCost = this.kTO.getTimeCost();
            if (timeCost > 3000) {
                d dVar = cWK.kTX;
                dVar.kTS = timeCost + dVar.kTS;
                cWK.kTX.num++;
                c.a(cWK, 10);
            }
        }
    }

    private e cWK() {
        return c.B(this.mLogType, getNetType(), this.mIsJson);
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
