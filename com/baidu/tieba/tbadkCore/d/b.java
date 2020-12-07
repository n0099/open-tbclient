package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a nnh;
    private final int nni = 10;
    private final int nnj = 3000;
    public String mLogType = null;
    public boolean mIsJson = false;

    public b(String str) {
        be(str, false);
    }

    public void be(String str, boolean z) {
        this.mLogType = str;
        this.mIsJson = z;
        this.nnh = new com.baidu.adp.lib.stats.a("dbg");
        c.F(str, getNetType(), z);
    }

    public void start() {
        this.nnh.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e dPy;
        if (this.nnh != null && (dPy = dPy()) != null) {
            if (z) {
                if (dPy.nno != null) {
                    dPy.nno.num++;
                    if (z2) {
                        dPy.nno.nnl += j2;
                        dPy.nno.size += j;
                    } else {
                        dPy.nno.nnm++;
                    }
                } else {
                    return;
                }
            } else if (dPy.nnp != null) {
                dPy.nnp.num++;
                if (z2) {
                    dPy.nnp.nnl += j3;
                    dPy.nnp.size += j;
                    j2 = j3;
                } else {
                    dPy.nnp.nnm++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.nnh = null;
            if (z2) {
                c.a(dPy, 10);
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
        e dPy;
        if (this.nnh != null && (dPy = dPy()) != null && dPy.nnq != null) {
            long timeCost = this.nnh.getTimeCost();
            if (timeCost > IMConnection.RETRY_DELAY_TIMES) {
                d dVar = dPy.nnq;
                dVar.nnl = timeCost + dVar.nnl;
                dPy.nnq.num++;
                c.a(dPy, 10);
            }
        }
    }

    private e dPy() {
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
