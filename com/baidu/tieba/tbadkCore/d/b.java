package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a lnw;
    private final int lnx = 10;
    private final int lny = 3000;
    public String mLogType = null;
    public boolean mIsJson = false;

    public b(String str) {
        aU(str, false);
    }

    public void aU(String str, boolean z) {
        this.mLogType = str;
        this.mIsJson = z;
        this.lnw = new com.baidu.adp.lib.stats.a("dbg");
        c.C(str, getNetType(), z);
    }

    public void start() {
        this.lnw.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e dee;
        if (this.lnw != null && (dee = dee()) != null) {
            if (z) {
                if (dee.lnD != null) {
                    dee.lnD.num++;
                    if (z2) {
                        dee.lnD.lnA += j2;
                        dee.lnD.size += j;
                    } else {
                        dee.lnD.lnB++;
                    }
                } else {
                    return;
                }
            } else if (dee.lnE != null) {
                dee.lnE.num++;
                if (z2) {
                    dee.lnE.lnA += j3;
                    dee.lnE.size += j;
                    j2 = j3;
                } else {
                    dee.lnE.lnB++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.lnw = null;
            if (z2) {
                c.a(dee, 10);
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
        e dee;
        if (this.lnw != null && (dee = dee()) != null && dee.lnF != null) {
            long timeCost = this.lnw.getTimeCost();
            if (timeCost > 3000) {
                d dVar = dee.lnF;
                dVar.lnA = timeCost + dVar.lnA;
                dee.lnF.num++;
                c.a(dee, 10);
            }
        }
    }

    private e dee() {
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
