package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a gxz;
    private final int gxA = 10;
    private final int gxB = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
    public String gxC = null;
    public boolean akf = false;

    public b(String str) {
        U(str, false);
    }

    public void U(String str, boolean z) {
        this.gxC = str;
        this.akf = z;
        this.gxz = new com.baidu.adp.lib.stats.a("dbg");
        c.k(str, getNetType(), z);
    }

    public void start() {
        this.gxz.fA();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e bsq;
        if (this.gxz != null && (bsq = bsq()) != null) {
            if (z) {
                if (bsq.gxH != null) {
                    bsq.gxH.num++;
                    if (z2) {
                        bsq.gxH.gxE += j2;
                        bsq.gxH.size += j;
                    } else {
                        bsq.gxH.gxF++;
                    }
                } else {
                    return;
                }
            } else if (bsq.gxI != null) {
                bsq.gxI.num++;
                if (z2) {
                    bsq.gxI.gxE += j3;
                    bsq.gxI.size += j;
                    j2 = j3;
                } else {
                    bsq.gxI.gxF++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.gxz = null;
            if (z2) {
                c.a(bsq, 10);
            }
            if (this.gxC == "frsStat") {
                if (!z2 || j2 > 3000) {
                    com.baidu.adp.lib.stats.a aVar = new com.baidu.adp.lib.stats.a("dbg");
                    aVar.append(SocialConstants.PARAM_ACT, "frs");
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
        e bsq;
        if (this.gxz != null && (bsq = bsq()) != null && bsq.gxJ != null) {
            long fB = this.gxz.fB();
            if (fB > 3000) {
                d dVar = bsq.gxJ;
                dVar.gxE = fB + dVar.gxE;
                bsq.gxJ.num++;
                c.a(bsq, 10);
            }
        }
    }

    private e bsq() {
        return c.l(this.gxC, getNetType(), this.akf);
    }

    private String getNetType() {
        int gV = j.gV();
        if (gV == 0) {
            return "N";
        }
        if (gV == 1) {
            return "WIFI";
        }
        if (gV == 3) {
            return "3G";
        }
        if (gV != 2) {
            return "N";
        }
        return "2G";
    }
}
