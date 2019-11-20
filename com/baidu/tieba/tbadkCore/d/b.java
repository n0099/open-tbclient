package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a jiV;
    private final int jiW = 10;
    private final int jiX = 3000;
    public String jiY = null;
    public boolean mIsJson = false;

    public b(String str) {
        aw(str, false);
    }

    public void aw(String str, boolean z) {
        this.jiY = str;
        this.mIsJson = z;
        this.jiV = new com.baidu.adp.lib.stats.a("dbg");
        c.A(str, getNetType(), z);
    }

    public void start() {
        this.jiV.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e coH;
        if (this.jiV != null && (coH = coH()) != null) {
            if (z) {
                if (coH.jjd != null) {
                    coH.jjd.num++;
                    if (z2) {
                        coH.jjd.jja += j2;
                        coH.jjd.size += j;
                    } else {
                        coH.jjd.jjb++;
                    }
                } else {
                    return;
                }
            } else if (coH.jje != null) {
                coH.jje.num++;
                if (z2) {
                    coH.jje.jja += j3;
                    coH.jje.size += j;
                    j2 = j3;
                } else {
                    coH.jje.jjb++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.jiV = null;
            if (z2) {
                c.a(coH, 10);
            }
            if (this.jiY == "frsStat") {
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
        e coH;
        if (this.jiV != null && (coH = coH()) != null && coH.jjf != null) {
            long timeCost = this.jiV.getTimeCost();
            if (timeCost > 3000) {
                d dVar = coH.jjf;
                dVar.jja = timeCost + dVar.jja;
                coH.jjf.num++;
                c.a(coH, 10);
            }
        }
    }

    private e coH() {
        return c.B(this.jiY, getNetType(), this.mIsJson);
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
