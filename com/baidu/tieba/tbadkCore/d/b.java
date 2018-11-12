package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.baidu.searchbox.ng.ai.apps.media.recorder.RecordStatusCallback;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a hfD;
    private final int hfE = 10;
    private final int hfF = 3000;
    public String mLogType = null;
    public boolean aAs = false;

    public b(String str) {
        ac(str, false);
    }

    public void ac(String str, boolean z) {
        this.mLogType = str;
        this.aAs = z;
        this.hfD = new com.baidu.adp.lib.stats.a("dbg");
        c.k(str, getNetType(), z);
    }

    public void start() {
        this.hfD.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e bBP;
        if (this.hfD != null && (bBP = bBP()) != null) {
            if (z) {
                if (bBP.hfK != null) {
                    bBP.hfK.num++;
                    if (z2) {
                        bBP.hfK.hfH += j2;
                        bBP.hfK.size += j;
                    } else {
                        bBP.hfK.hfI++;
                    }
                } else {
                    return;
                }
            } else if (bBP.hfL != null) {
                bBP.hfL.num++;
                if (z2) {
                    bBP.hfL.hfH += j3;
                    bBP.hfL.size += j;
                    j2 = j3;
                } else {
                    bBP.hfL.hfI++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.hfD = null;
            if (z2) {
                c.a(bBP, 10);
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
        e bBP;
        if (this.hfD != null && (bBP = bBP()) != null && bBP.hfM != null) {
            long jK = this.hfD.jK();
            if (jK > 3000) {
                d dVar = bBP.hfM;
                dVar.hfH = jK + dVar.hfH;
                bBP.hfM.num++;
                c.a(bBP, 10);
            }
        }
    }

    private e bBP() {
        return c.l(this.mLogType, getNetType(), this.aAs);
    }

    private String getNetType() {
        int lb = j.lb();
        if (lb == 0) {
            return "N";
        }
        if (lb == 1) {
            return "WIFI";
        }
        if (lb == 3) {
            return "3G";
        }
        if (lb != 2) {
            return "N";
        }
        return "2G";
    }
}
