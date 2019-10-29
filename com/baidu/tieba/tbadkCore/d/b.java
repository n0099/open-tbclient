package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a jjM;
    private final int jjN = 10;
    private final int jjO = 3000;
    public String jjP = null;
    public boolean mIsJson = false;

    public b(String str) {
        aw(str, false);
    }

    public void aw(String str, boolean z) {
        this.jjP = str;
        this.mIsJson = z;
        this.jjM = new com.baidu.adp.lib.stats.a("dbg");
        c.A(str, getNetType(), z);
    }

    public void start() {
        this.jjM.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e coJ;
        if (this.jjM != null && (coJ = coJ()) != null) {
            if (z) {
                if (coJ.jjU != null) {
                    coJ.jjU.num++;
                    if (z2) {
                        coJ.jjU.jjR += j2;
                        coJ.jjU.size += j;
                    } else {
                        coJ.jjU.jjS++;
                    }
                } else {
                    return;
                }
            } else if (coJ.jjV != null) {
                coJ.jjV.num++;
                if (z2) {
                    coJ.jjV.jjR += j3;
                    coJ.jjV.size += j;
                    j2 = j3;
                } else {
                    coJ.jjV.jjS++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.jjM = null;
            if (z2) {
                c.a(coJ, 10);
            }
            if (this.jjP == "frsStat") {
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
        e coJ;
        if (this.jjM != null && (coJ = coJ()) != null && coJ.jjW != null) {
            long timeCost = this.jjM.getTimeCost();
            if (timeCost > 3000) {
                d dVar = coJ.jjW;
                dVar.jjR = timeCost + dVar.jjR;
                coJ.jjW.num++;
                c.a(coJ, 10);
            }
        }
    }

    private e coJ() {
        return c.B(this.jjP, getNetType(), this.mIsJson);
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
