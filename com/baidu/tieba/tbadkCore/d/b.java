package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a hjO;
    private final int hjP = 10;
    private final int hjQ = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
    public String hjR = null;
    public boolean aXb = false;

    public b(String str) {
        ab(str, false);
    }

    public void ab(String str, boolean z) {
        this.hjR = str;
        this.aXb = z;
        this.hjO = new com.baidu.adp.lib.stats.a("dbg");
        c.k(str, getNetType(), z);
    }

    public void start() {
        this.hjO.nv();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e bCF;
        if (this.hjO != null && (bCF = bCF()) != null) {
            if (z) {
                if (bCF.hjW != null) {
                    bCF.hjW.num++;
                    if (z2) {
                        bCF.hjW.hjT += j2;
                        bCF.hjW.size += j;
                    } else {
                        bCF.hjW.hjU++;
                    }
                } else {
                    return;
                }
            } else if (bCF.hjX != null) {
                bCF.hjX.num++;
                if (z2) {
                    bCF.hjX.hjT += j3;
                    bCF.hjX.size += j;
                    j2 = j3;
                } else {
                    bCF.hjX.hjU++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.hjO = null;
            if (z2) {
                c.a(bCF, 10);
            }
            if (this.hjR == "frsStat") {
                if (!z2 || j2 > 3000) {
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
        e bCF;
        if (this.hjO != null && (bCF = bCF()) != null && bCF.hjY != null) {
            long nw = this.hjO.nw();
            if (nw > 3000) {
                d dVar = bCF.hjY;
                dVar.hjT = nw + dVar.hjT;
                bCF.hjY.num++;
                c.a(bCF, 10);
            }
        }
    }

    private e bCF() {
        return c.l(this.hjR, getNetType(), this.aXb);
    }

    private String getNetType() {
        int oO = j.oO();
        if (oO == 0) {
            return "N";
        }
        if (oO == 1) {
            return "WIFI";
        }
        if (oO == 3) {
            return "3G";
        }
        if (oO != 2) {
            return "N";
        }
        return "2G";
    }
}
