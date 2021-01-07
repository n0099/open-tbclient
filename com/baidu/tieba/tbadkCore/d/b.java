package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a nsV;
    private final int nsW = 10;
    private final int nsX = 3000;
    public String mLogType = null;
    public boolean mIsJson = false;

    public b(String str) {
        be(str, false);
    }

    public void be(String str, boolean z) {
        this.mLogType = str;
        this.mIsJson = z;
        this.nsV = new com.baidu.adp.lib.stats.a("dbg");
        c.H(str, getNetType(), z);
    }

    public void start() {
        this.nsV.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e dPw;
        if (this.nsV != null && (dPw = dPw()) != null) {
            if (z) {
                if (dPw.ntc != null) {
                    dPw.ntc.num++;
                    if (z2) {
                        dPw.ntc.nsZ += j2;
                        dPw.ntc.size += j;
                    } else {
                        dPw.ntc.nta++;
                    }
                } else {
                    return;
                }
            } else if (dPw.ntd != null) {
                dPw.ntd.num++;
                if (z2) {
                    dPw.ntd.nsZ += j3;
                    dPw.ntd.size += j;
                    j2 = j3;
                } else {
                    dPw.ntd.nta++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.nsV = null;
            if (z2) {
                c.a(dPw, 10);
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
        e dPw;
        if (this.nsV != null && (dPw = dPw()) != null && dPw.nte != null) {
            long timeCost = this.nsV.getTimeCost();
            if (timeCost > IMConnection.RETRY_DELAY_TIMES) {
                d dVar = dPw.nte;
                dVar.nsZ = timeCost + dVar.nsZ;
                dPw.nte.num++;
                c.a(dPw, 10);
            }
        }
    }

    private e dPw() {
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
