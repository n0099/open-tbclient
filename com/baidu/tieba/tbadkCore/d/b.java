package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a gxC;
    private final int gxD = 10;
    private final int gxE = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
    public String gxF = null;
    public boolean akf = false;

    public b(String str) {
        U(str, false);
    }

    public void U(String str, boolean z) {
        this.gxF = str;
        this.akf = z;
        this.gxC = new com.baidu.adp.lib.stats.a("dbg");
        c.k(str, getNetType(), z);
    }

    public void start() {
        this.gxC.fA();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e bsq;
        if (this.gxC != null && (bsq = bsq()) != null) {
            if (z) {
                if (bsq.gxK != null) {
                    bsq.gxK.num++;
                    if (z2) {
                        bsq.gxK.gxH += j2;
                        bsq.gxK.size += j;
                    } else {
                        bsq.gxK.gxI++;
                    }
                } else {
                    return;
                }
            } else if (bsq.gxL != null) {
                bsq.gxL.num++;
                if (z2) {
                    bsq.gxL.gxH += j3;
                    bsq.gxL.size += j;
                    j2 = j3;
                } else {
                    bsq.gxL.gxI++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.gxC = null;
            if (z2) {
                c.a(bsq, 10);
            }
            if (this.gxF == "frsStat") {
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
        if (this.gxC != null && (bsq = bsq()) != null && bsq.gxM != null) {
            long fB = this.gxC.fB();
            if (fB > 3000) {
                d dVar = bsq.gxM;
                dVar.gxH = fB + dVar.gxH;
                bsq.gxM.num++;
                c.a(bsq, 10);
            }
        }
    }

    private e bsq() {
        return c.l(this.gxF, getNetType(), this.akf);
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
