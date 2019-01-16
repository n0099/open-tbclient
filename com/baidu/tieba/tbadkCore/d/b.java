package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.baidu.searchbox.ng.ai.apps.media.recorder.RecordStatusCallback;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a hqR;
    private final int hqS = 10;
    private final int hqT = 3000;
    public String mLogType = null;
    public boolean aEv = false;

    public b(String str) {
        ad(str, false);
    }

    public void ad(String str, boolean z) {
        this.mLogType = str;
        this.aEv = z;
        this.hqR = new com.baidu.adp.lib.stats.a("dbg");
        c.k(str, getNetType(), z);
    }

    public void start() {
        this.hqR.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e bFk;
        if (this.hqR != null && (bFk = bFk()) != null) {
            if (z) {
                if (bFk.hqY != null) {
                    bFk.hqY.num++;
                    if (z2) {
                        bFk.hqY.hqV += j2;
                        bFk.hqY.size += j;
                    } else {
                        bFk.hqY.hqW++;
                    }
                } else {
                    return;
                }
            } else if (bFk.hqZ != null) {
                bFk.hqZ.num++;
                if (z2) {
                    bFk.hqZ.hqV += j3;
                    bFk.hqZ.size += j;
                    j2 = j3;
                } else {
                    bFk.hqZ.hqW++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.hqR = null;
            if (z2) {
                c.a(bFk, 10);
            }
            if (this.mLogType == "frsStat") {
                if (!z2 || j2 > 3000) {
                    com.baidu.adp.lib.stats.a aVar = new com.baidu.adp.lib.stats.a("dbg");
                    aVar.append(SocialConstants.PARAM_ACT, "frs");
                    aVar.append("result", z2 ? "0" : "1");
                    aVar.append("isHttp", z ? "1" : "0");
                    aVar.append("timeCost", String.valueOf(j2));
                    aVar.append(RecordStatusCallback.KEY_ERROR_CODE, String.valueOf(i));
                    aVar.append("errMsg", str);
                    aVar.append("down", String.valueOf(j));
                    BdStatisticsManager.getInstance().debug("frs", aVar);
                }
            }
        }
    }

    public void destory() {
        e bFk;
        if (this.hqR != null && (bFk = bFk()) != null && bFk.hra != null) {
            long jK = this.hqR.jK();
            if (jK > 3000) {
                d dVar = bFk.hra;
                dVar.hqV = jK + dVar.hqV;
                bFk.hra.num++;
                c.a(bFk, 10);
            }
        }
    }

    private e bFk() {
        return c.l(this.mLogType, getNetType(), this.aEv);
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
