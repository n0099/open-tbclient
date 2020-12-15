package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a nnj;
    private final int nnk = 10;
    private final int nnl = 3000;
    public String mLogType = null;
    public boolean mIsJson = false;

    public b(String str) {
        be(str, false);
    }

    public void be(String str, boolean z) {
        this.mLogType = str;
        this.mIsJson = z;
        this.nnj = new com.baidu.adp.lib.stats.a("dbg");
        c.F(str, getNetType(), z);
    }

    public void start() {
        this.nnj.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e dPz;
        if (this.nnj != null && (dPz = dPz()) != null) {
            if (z) {
                if (dPz.nnq != null) {
                    dPz.nnq.num++;
                    if (z2) {
                        dPz.nnq.nnn += j2;
                        dPz.nnq.size += j;
                    } else {
                        dPz.nnq.nno++;
                    }
                } else {
                    return;
                }
            } else if (dPz.nnr != null) {
                dPz.nnr.num++;
                if (z2) {
                    dPz.nnr.nnn += j3;
                    dPz.nnr.size += j;
                    j2 = j3;
                } else {
                    dPz.nnr.nno++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.nnj = null;
            if (z2) {
                c.a(dPz, 10);
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
        e dPz;
        if (this.nnj != null && (dPz = dPz()) != null && dPz.nns != null) {
            long timeCost = this.nnj.getTimeCost();
            if (timeCost > IMConnection.RETRY_DELAY_TIMES) {
                d dVar = dPz.nns;
                dVar.nnn = timeCost + dVar.nnn;
                dPz.nns.num++;
                c.a(dPz, 10);
            }
        }
    }

    private e dPz() {
        return c.G(this.mLogType, getNetType(), this.mIsJson);
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
