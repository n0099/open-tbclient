package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.baidu.searchbox.ng.ai.apps.media.recorder.RecordStatusCallback;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a hpJ;
    private final int hpK = 10;
    private final int hpL = 3000;
    public String mLogType = null;
    public boolean aDT = false;

    public b(String str) {
        ae(str, false);
    }

    public void ae(String str, boolean z) {
        this.mLogType = str;
        this.aDT = z;
        this.hpJ = new com.baidu.adp.lib.stats.a("dbg");
        c.k(str, getNetType(), z);
    }

    public void start() {
        this.hpJ.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e bEB;
        if (this.hpJ != null && (bEB = bEB()) != null) {
            if (z) {
                if (bEB.hpQ != null) {
                    bEB.hpQ.num++;
                    if (z2) {
                        bEB.hpQ.hpN += j2;
                        bEB.hpQ.size += j;
                    } else {
                        bEB.hpQ.hpO++;
                    }
                } else {
                    return;
                }
            } else if (bEB.hpR != null) {
                bEB.hpR.num++;
                if (z2) {
                    bEB.hpR.hpN += j3;
                    bEB.hpR.size += j;
                    j2 = j3;
                } else {
                    bEB.hpR.hpO++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.hpJ = null;
            if (z2) {
                c.a(bEB, 10);
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
        e bEB;
        if (this.hpJ != null && (bEB = bEB()) != null && bEB.hpS != null) {
            long jK = this.hpJ.jK();
            if (jK > 3000) {
                d dVar = bEB.hpS;
                dVar.hpN = jK + dVar.hpN;
                bEB.hpS.num++;
                c.a(bEB, 10);
            }
        }
    }

    private e bEB() {
        return c.l(this.mLogType, getNetType(), this.aDT);
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
