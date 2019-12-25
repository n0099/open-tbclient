package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a kdi;
    private final int kdj = 10;
    private final int kdk = 3000;
    public String mLogType = null;
    public boolean mIsJson = false;

    public b(String str) {
        aB(str, false);
    }

    public void aB(String str, boolean z) {
        this.mLogType = str;
        this.mIsJson = z;
        this.kdi = new com.baidu.adp.lib.stats.a("dbg");
        c.A(str, getNetType(), z);
    }

    public void start() {
        this.kdi.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e cIN;
        if (this.kdi != null && (cIN = cIN()) != null) {
            if (z) {
                if (cIN.kdp != null) {
                    cIN.kdp.num++;
                    if (z2) {
                        cIN.kdp.kdm += j2;
                        cIN.kdp.size += j;
                    } else {
                        cIN.kdp.kdn++;
                    }
                } else {
                    return;
                }
            } else if (cIN.kdq != null) {
                cIN.kdq.num++;
                if (z2) {
                    cIN.kdq.kdm += j3;
                    cIN.kdq.size += j;
                    j2 = j3;
                } else {
                    cIN.kdq.kdn++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.kdi = null;
            if (z2) {
                c.a(cIN, 10);
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
        e cIN;
        if (this.kdi != null && (cIN = cIN()) != null && cIN.kdr != null) {
            long timeCost = this.kdi.getTimeCost();
            if (timeCost > 3000) {
                d dVar = cIN.kdr;
                dVar.kdm = timeCost + dVar.kdm;
                cIN.kdr.num++;
                c.a(cIN, 10);
            }
        }
    }

    private e cIN() {
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
