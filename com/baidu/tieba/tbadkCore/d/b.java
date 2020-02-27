package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a khR;
    private final int khS = 10;
    private final int khT = 3000;
    public String mLogType = null;
    public boolean mIsJson = false;

    public b(String str) {
        aB(str, false);
    }

    public void aB(String str, boolean z) {
        this.mLogType = str;
        this.mIsJson = z;
        this.khR = new com.baidu.adp.lib.stats.a("dbg");
        c.B(str, getNetType(), z);
    }

    public void start() {
        this.khR.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e cLr;
        if (this.khR != null && (cLr = cLr()) != null) {
            if (z) {
                if (cLr.khY != null) {
                    cLr.khY.num++;
                    if (z2) {
                        cLr.khY.khV += j2;
                        cLr.khY.size += j;
                    } else {
                        cLr.khY.khW++;
                    }
                } else {
                    return;
                }
            } else if (cLr.khZ != null) {
                cLr.khZ.num++;
                if (z2) {
                    cLr.khZ.khV += j3;
                    cLr.khZ.size += j;
                    j2 = j3;
                } else {
                    cLr.khZ.khW++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.khR = null;
            if (z2) {
                c.a(cLr, 10);
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
        e cLr;
        if (this.khR != null && (cLr = cLr()) != null && cLr.kia != null) {
            long timeCost = this.khR.getTimeCost();
            if (timeCost > 3000) {
                d dVar = cLr.kia;
                dVar.khV = timeCost + dVar.khV;
                cLr.kia.num++;
                c.a(cLr, 10);
            }
        }
    }

    private e cLr() {
        return c.C(this.mLogType, getNetType(), this.mIsJson);
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
