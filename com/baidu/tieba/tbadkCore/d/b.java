package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a nsW;
    private final int nsX = 10;
    private final int nsY = 3000;
    public String mLogType = null;
    public boolean mIsJson = false;

    public b(String str) {
        be(str, false);
    }

    public void be(String str, boolean z) {
        this.mLogType = str;
        this.mIsJson = z;
        this.nsW = new com.baidu.adp.lib.stats.a("dbg");
        c.H(str, getNetType(), z);
    }

    public void start() {
        this.nsW.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e dPv;
        if (this.nsW != null && (dPv = dPv()) != null) {
            if (z) {
                if (dPv.ntd != null) {
                    dPv.ntd.num++;
                    if (z2) {
                        dPv.ntd.nta += j2;
                        dPv.ntd.size += j;
                    } else {
                        dPv.ntd.ntb++;
                    }
                } else {
                    return;
                }
            } else if (dPv.nte != null) {
                dPv.nte.num++;
                if (z2) {
                    dPv.nte.nta += j3;
                    dPv.nte.size += j;
                    j2 = j3;
                } else {
                    dPv.nte.ntb++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.nsW = null;
            if (z2) {
                c.a(dPv, 10);
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
        e dPv;
        if (this.nsW != null && (dPv = dPv()) != null && dPv.ntf != null) {
            long timeCost = this.nsW.getTimeCost();
            if (timeCost > IMConnection.RETRY_DELAY_TIMES) {
                d dVar = dPv.ntf;
                dVar.nta = timeCost + dVar.nta;
                dPv.ntf.num++;
                c.a(dPv, 10);
            }
        }
    }

    private e dPv() {
        return c.I(this.mLogType, getNetType(), this.mIsJson);
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
