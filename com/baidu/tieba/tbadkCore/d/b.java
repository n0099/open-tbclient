package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a kig;
    private final int kih = 10;
    private final int kii = 3000;
    public String mLogType = null;
    public boolean mIsJson = false;

    public b(String str) {
        aB(str, false);
    }

    public void aB(String str, boolean z) {
        this.mLogType = str;
        this.mIsJson = z;
        this.kig = new com.baidu.adp.lib.stats.a("dbg");
        c.B(str, getNetType(), z);
    }

    public void start() {
        this.kig.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e cLu;
        if (this.kig != null && (cLu = cLu()) != null) {
            if (z) {
                if (cLu.kin != null) {
                    cLu.kin.num++;
                    if (z2) {
                        cLu.kin.kik += j2;
                        cLu.kin.size += j;
                    } else {
                        cLu.kin.kil++;
                    }
                } else {
                    return;
                }
            } else if (cLu.kio != null) {
                cLu.kio.num++;
                if (z2) {
                    cLu.kio.kik += j3;
                    cLu.kio.size += j;
                    j2 = j3;
                } else {
                    cLu.kio.kil++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.kig = null;
            if (z2) {
                c.a(cLu, 10);
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
        e cLu;
        if (this.kig != null && (cLu = cLu()) != null && cLu.kip != null) {
            long timeCost = this.kig.getTimeCost();
            if (timeCost > 3000) {
                d dVar = cLu.kip;
                dVar.kik = timeCost + dVar.kik;
                cLu.kip.num++;
                c.a(cLu, 10);
            }
        }
    }

    private e cLu() {
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
