package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a hcf;
    private final int hcg = 10;
    private final int hch = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
    public String hci = null;
    public boolean aYC = false;

    public b(String str) {
        Z(str, false);
    }

    public void Z(String str, boolean z) {
        this.hci = str;
        this.aYC = z;
        this.hcf = new com.baidu.adp.lib.stats.a("dbg");
        c.j(str, getNetType(), z);
    }

    public void start() {
        this.hcf.nw();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e bxq;
        if (this.hcf != null && (bxq = bxq()) != null) {
            if (z) {
                if (bxq.hcn != null) {
                    bxq.hcn.num++;
                    if (z2) {
                        bxq.hcn.hck += j2;
                        bxq.hcn.size += j;
                    } else {
                        bxq.hcn.hcl++;
                    }
                } else {
                    return;
                }
            } else if (bxq.hco != null) {
                bxq.hco.num++;
                if (z2) {
                    bxq.hco.hck += j3;
                    bxq.hco.size += j;
                    j2 = j3;
                } else {
                    bxq.hco.hcl++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.hcf = null;
            if (z2) {
                c.a(bxq, 10);
            }
            if (this.hci == "frsStat") {
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
        e bxq;
        if (this.hcf != null && (bxq = bxq()) != null && bxq.hcp != null) {
            long nx = this.hcf.nx();
            if (nx > 3000) {
                d dVar = bxq.hcp;
                dVar.hck = nx + dVar.hck;
                bxq.hcp.num++;
                c.a(bxq, 10);
            }
        }
    }

    private e bxq() {
        return c.k(this.hci, getNetType(), this.aYC);
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
