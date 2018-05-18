package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a gyD;
    private final int gyE = 10;
    private final int gyF = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
    public String gyG = null;
    public boolean akf = false;

    public b(String str) {
        U(str, false);
    }

    public void U(String str, boolean z) {
        this.gyG = str;
        this.akf = z;
        this.gyD = new com.baidu.adp.lib.stats.a("dbg");
        c.k(str, getNetType(), z);
    }

    public void start() {
        this.gyD.fA();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e bso;
        if (this.gyD != null && (bso = bso()) != null) {
            if (z) {
                if (bso.gyL != null) {
                    bso.gyL.num++;
                    if (z2) {
                        bso.gyL.gyI += j2;
                        bso.gyL.size += j;
                    } else {
                        bso.gyL.gyJ++;
                    }
                } else {
                    return;
                }
            } else if (bso.gyM != null) {
                bso.gyM.num++;
                if (z2) {
                    bso.gyM.gyI += j3;
                    bso.gyM.size += j;
                    j2 = j3;
                } else {
                    bso.gyM.gyJ++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.gyD = null;
            if (z2) {
                c.a(bso, 10);
            }
            if (this.gyG == "frsStat") {
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
        e bso;
        if (this.gyD != null && (bso = bso()) != null && bso.gyN != null) {
            long fB = this.gyD.fB();
            if (fB > 3000) {
                d dVar = bso.gyN;
                dVar.gyI = fB + dVar.gyI;
                bso.gyN.num++;
                c.a(bso, 10);
            }
        }
    }

    private e bso() {
        return c.l(this.gyG, getNetType(), this.akf);
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
