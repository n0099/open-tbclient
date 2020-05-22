package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a lmm;
    private final int lmn = 10;
    private final int lmo = 3000;
    public String mLogType = null;
    public boolean mIsJson = false;

    public b(String str) {
        aU(str, false);
    }

    public void aU(String str, boolean z) {
        this.mLogType = str;
        this.mIsJson = z;
        this.lmm = new com.baidu.adp.lib.stats.a("dbg");
        c.C(str, getNetType(), z);
    }

    public void start() {
        this.lmm.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e ddP;
        if (this.lmm != null && (ddP = ddP()) != null) {
            if (z) {
                if (ddP.lmt != null) {
                    ddP.lmt.num++;
                    if (z2) {
                        ddP.lmt.lmq += j2;
                        ddP.lmt.size += j;
                    } else {
                        ddP.lmt.lmr++;
                    }
                } else {
                    return;
                }
            } else if (ddP.lmu != null) {
                ddP.lmu.num++;
                if (z2) {
                    ddP.lmu.lmq += j3;
                    ddP.lmu.size += j;
                    j2 = j3;
                } else {
                    ddP.lmu.lmr++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.lmm = null;
            if (z2) {
                c.a(ddP, 10);
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
        e ddP;
        if (this.lmm != null && (ddP = ddP()) != null && ddP.lmv != null) {
            long timeCost = this.lmm.getTimeCost();
            if (timeCost > 3000) {
                d dVar = ddP.lmv;
                dVar.lmq = timeCost + dVar.lmq;
                ddP.lmv.num++;
                c.a(ddP, 10);
            }
        }
    }

    private e ddP() {
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
