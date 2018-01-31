package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a gZI;
    private final int gZJ = 10;
    private final int gZK = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
    public String gZL = null;
    public boolean aXd = false;

    public b(String str) {
        ab(str, false);
    }

    public void ab(String str, boolean z) {
        this.gZL = str;
        this.aXd = z;
        this.gZI = new com.baidu.adp.lib.stats.a("dbg");
        c.j(str, getNetType(), z);
    }

    public void start() {
        this.gZI.nw();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e bwd;
        if (this.gZI != null && (bwd = bwd()) != null) {
            if (z) {
                if (bwd.gZQ != null) {
                    bwd.gZQ.num++;
                    if (z2) {
                        bwd.gZQ.gZN += j2;
                        bwd.gZQ.size += j;
                    } else {
                        bwd.gZQ.gZO++;
                    }
                } else {
                    return;
                }
            } else if (bwd.gZR != null) {
                bwd.gZR.num++;
                if (z2) {
                    bwd.gZR.gZN += j3;
                    bwd.gZR.size += j;
                    j2 = j3;
                } else {
                    bwd.gZR.gZO++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.gZI = null;
            if (z2) {
                c.a(bwd, 10);
            }
            if (this.gZL == "frsStat") {
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
        e bwd;
        if (this.gZI != null && (bwd = bwd()) != null && bwd.gZS != null) {
            long nx = this.gZI.nx();
            if (nx > 3000) {
                d dVar = bwd.gZS;
                dVar.gZN = nx + dVar.gZN;
                bwd.gZS.num++;
                c.a(bwd, 10);
            }
        }
    }

    private e bwd() {
        return c.k(this.gZL, getNetType(), this.aXd);
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
