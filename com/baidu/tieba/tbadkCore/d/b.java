package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes2.dex */
public class b {
    private com.baidu.adp.lib.stats.a mgl;
    private final int mgm = 10;
    private final int mgn = 3000;
    public String mLogType = null;
    public boolean mIsJson = false;

    public b(String str) {
        aX(str, false);
    }

    public void aX(String str, boolean z) {
        this.mLogType = str;
        this.mIsJson = z;
        this.mgl = new com.baidu.adp.lib.stats.a("dbg");
        c.C(str, getNetType(), z);
    }

    public void start() {
        this.mgl.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e dwX;
        if (this.mgl != null && (dwX = dwX()) != null) {
            if (z) {
                if (dwX.mgs != null) {
                    dwX.mgs.num++;
                    if (z2) {
                        dwX.mgs.mgp += j2;
                        dwX.mgs.size += j;
                    } else {
                        dwX.mgs.mgq++;
                    }
                } else {
                    return;
                }
            } else if (dwX.mgt != null) {
                dwX.mgt.num++;
                if (z2) {
                    dwX.mgt.mgp += j3;
                    dwX.mgt.size += j;
                    j2 = j3;
                } else {
                    dwX.mgt.mgq++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.mgl = null;
            if (z2) {
                c.a(dwX, 10);
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
        e dwX;
        if (this.mgl != null && (dwX = dwX()) != null && dwX.mgu != null) {
            long timeCost = this.mgl.getTimeCost();
            if (timeCost > IMConnection.RETRY_DELAY_TIMES) {
                d dVar = dwX.mgu;
                dVar.mgp = timeCost + dVar.mgp;
                dwX.mgu.num++;
                c.a(dwX, 10);
            }
        }
    }

    private e dwX() {
        return c.D(this.mLogType, getNetType(), this.mIsJson);
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
