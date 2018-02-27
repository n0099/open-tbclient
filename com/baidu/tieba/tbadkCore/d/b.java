package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a hbH;
    private final int hbI = 10;
    private final int hbJ = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
    public String hbK = null;
    public boolean aYA = false;

    public b(String str) {
        Z(str, false);
    }

    public void Z(String str, boolean z) {
        this.hbK = str;
        this.aYA = z;
        this.hbH = new com.baidu.adp.lib.stats.a("dbg");
        c.j(str, getNetType(), z);
    }

    public void start() {
        this.hbH.nw();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e bxl;
        if (this.hbH != null && (bxl = bxl()) != null) {
            if (z) {
                if (bxl.hbP != null) {
                    bxl.hbP.num++;
                    if (z2) {
                        bxl.hbP.hbM += j2;
                        bxl.hbP.size += j;
                    } else {
                        bxl.hbP.hbN++;
                    }
                } else {
                    return;
                }
            } else if (bxl.hbQ != null) {
                bxl.hbQ.num++;
                if (z2) {
                    bxl.hbQ.hbM += j3;
                    bxl.hbQ.size += j;
                    j2 = j3;
                } else {
                    bxl.hbQ.hbN++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.hbH = null;
            if (z2) {
                c.a(bxl, 10);
            }
            if (this.hbK == "frsStat") {
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
        e bxl;
        if (this.hbH != null && (bxl = bxl()) != null && bxl.hbR != null) {
            long nx = this.hbH.nx();
            if (nx > 3000) {
                d dVar = bxl.hbR;
                dVar.hbM = nx + dVar.hbM;
                bxl.hbR.num++;
                c.a(bxl, 10);
            }
        }
    }

    private e bxl() {
        return c.k(this.hbK, getNetType(), this.aYA);
    }

    private String getNetType() {
        int oP = j.oP();
        if (oP == 0) {
            return "N";
        }
        if (oP == 1) {
            return "WIFI";
        }
        if (oP == 3) {
            return "3G";
        }
        if (oP != 2) {
            return "N";
        }
        return "2G";
    }
}
