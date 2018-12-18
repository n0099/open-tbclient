package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.baidu.searchbox.ng.ai.apps.media.recorder.RecordStatusCallback;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a hmx;
    private final int hmy = 10;
    private final int hmz = 3000;
    public String mLogType = null;
    public boolean aDS = false;

    public b(String str) {
        ae(str, false);
    }

    public void ae(String str, boolean z) {
        this.mLogType = str;
        this.aDS = z;
        this.hmx = new com.baidu.adp.lib.stats.a("dbg");
        c.k(str, getNetType(), z);
    }

    public void start() {
        this.hmx.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e bDJ;
        if (this.hmx != null && (bDJ = bDJ()) != null) {
            if (z) {
                if (bDJ.hmE != null) {
                    bDJ.hmE.num++;
                    if (z2) {
                        bDJ.hmE.hmB += j2;
                        bDJ.hmE.size += j;
                    } else {
                        bDJ.hmE.hmC++;
                    }
                } else {
                    return;
                }
            } else if (bDJ.hmF != null) {
                bDJ.hmF.num++;
                if (z2) {
                    bDJ.hmF.hmB += j3;
                    bDJ.hmF.size += j;
                    j2 = j3;
                } else {
                    bDJ.hmF.hmC++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.hmx = null;
            if (z2) {
                c.a(bDJ, 10);
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
        e bDJ;
        if (this.hmx != null && (bDJ = bDJ()) != null && bDJ.hmG != null) {
            long jK = this.hmx.jK();
            if (jK > 3000) {
                d dVar = bDJ.hmG;
                dVar.hmB = jK + dVar.hmB;
                bDJ.hmG.num++;
                c.a(bDJ, 10);
            }
        }
    }

    private e bDJ() {
        return c.l(this.mLogType, getNetType(), this.aDS);
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
