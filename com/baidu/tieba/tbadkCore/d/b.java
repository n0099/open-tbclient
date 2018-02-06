package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a hbW;
    private final int hbX = 10;
    private final int hbY = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
    public String hbZ = null;
    public boolean aYM = false;

    public b(String str) {
        aa(str, false);
    }

    public void aa(String str, boolean z) {
        this.hbZ = str;
        this.aYM = z;
        this.hbW = new com.baidu.adp.lib.stats.a("dbg");
        c.j(str, getNetType(), z);
    }

    public void start() {
        this.hbW.nw();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e bxm;
        if (this.hbW != null && (bxm = bxm()) != null) {
            if (z) {
                if (bxm.hce != null) {
                    bxm.hce.num++;
                    if (z2) {
                        bxm.hce.hcb += j2;
                        bxm.hce.size += j;
                    } else {
                        bxm.hce.hcc++;
                    }
                } else {
                    return;
                }
            } else if (bxm.hcf != null) {
                bxm.hcf.num++;
                if (z2) {
                    bxm.hcf.hcb += j3;
                    bxm.hcf.size += j;
                    j2 = j3;
                } else {
                    bxm.hcf.hcc++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.hbW = null;
            if (z2) {
                c.a(bxm, 10);
            }
            if (this.hbZ == "frsStat") {
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
        e bxm;
        if (this.hbW != null && (bxm = bxm()) != null && bxm.hcg != null) {
            long nx = this.hbW.nx();
            if (nx > 3000) {
                d dVar = bxm.hcg;
                dVar.hcb = nx + dVar.hcb;
                bxm.hcg.num++;
                c.a(bxm, 10);
            }
        }
    }

    private e bxm() {
        return c.k(this.hbZ, getNetType(), this.aYM);
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
