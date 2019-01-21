package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.baidu.searchbox.ng.ai.apps.media.recorder.RecordStatusCallback;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a hqS;
    private final int hqT = 10;
    private final int hqU = 3000;
    public String mLogType = null;
    public boolean aEw = false;

    public b(String str) {
        ad(str, false);
    }

    public void ad(String str, boolean z) {
        this.mLogType = str;
        this.aEw = z;
        this.hqS = new com.baidu.adp.lib.stats.a("dbg");
        c.k(str, getNetType(), z);
    }

    public void start() {
        this.hqS.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e bFk;
        if (this.hqS != null && (bFk = bFk()) != null) {
            if (z) {
                if (bFk.hqZ != null) {
                    bFk.hqZ.num++;
                    if (z2) {
                        bFk.hqZ.hqW += j2;
                        bFk.hqZ.size += j;
                    } else {
                        bFk.hqZ.hqX++;
                    }
                } else {
                    return;
                }
            } else if (bFk.hra != null) {
                bFk.hra.num++;
                if (z2) {
                    bFk.hra.hqW += j3;
                    bFk.hra.size += j;
                    j2 = j3;
                } else {
                    bFk.hra.hqX++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.hqS = null;
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
        if (this.hqS != null && (bFk = bFk()) != null && bFk.hrb != null) {
            long jK = this.hqS.jK();
            if (jK > 3000) {
                d dVar = bFk.hrb;
                dVar.hqW = jK + dVar.hqW;
                bFk.hrb.num++;
                c.a(bFk, 10);
            }
        }
    }

    private e bFk() {
        return c.l(this.mLogType, getNetType(), this.aEw);
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
