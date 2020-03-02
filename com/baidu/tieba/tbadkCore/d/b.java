package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a khT;
    private final int khU = 10;
    private final int khV = 3000;
    public String mLogType = null;
    public boolean mIsJson = false;

    public b(String str) {
        aB(str, false);
    }

    public void aB(String str, boolean z) {
        this.mLogType = str;
        this.mIsJson = z;
        this.khT = new com.baidu.adp.lib.stats.a("dbg");
        c.B(str, getNetType(), z);
    }

    public void start() {
        this.khT.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e cLt;
        if (this.khT != null && (cLt = cLt()) != null) {
            if (z) {
                if (cLt.kia != null) {
                    cLt.kia.num++;
                    if (z2) {
                        cLt.kia.khX += j2;
                        cLt.kia.size += j;
                    } else {
                        cLt.kia.khY++;
                    }
                } else {
                    return;
                }
            } else if (cLt.kib != null) {
                cLt.kib.num++;
                if (z2) {
                    cLt.kib.khX += j3;
                    cLt.kib.size += j;
                    j2 = j3;
                } else {
                    cLt.kib.khY++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.khT = null;
            if (z2) {
                c.a(cLt, 10);
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
        e cLt;
        if (this.khT != null && (cLt = cLt()) != null && cLt.kic != null) {
            long timeCost = this.khT.getTimeCost();
            if (timeCost > 3000) {
                d dVar = cLt.kic;
                dVar.khX = timeCost + dVar.khX;
                cLt.kic.num++;
                c.a(cLt, 10);
            }
        }
    }

    private e cLt() {
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
