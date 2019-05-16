package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a iZX;
    private final int iZY = 10;
    private final int iZZ = 3000;
    public String jaa = null;
    public boolean bUf = false;

    public b(String str) {
        ax(str, false);
    }

    public void ax(String str, boolean z) {
        this.jaa = str;
        this.bUf = z;
        this.iZX = new com.baidu.adp.lib.stats.a("dbg");
        c.y(str, getNetType(), z);
    }

    public void start() {
        this.iZX.iF();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e cmN;
        if (this.iZX != null && (cmN = cmN()) != null) {
            if (z) {
                if (cmN.jaf != null) {
                    cmN.jaf.num++;
                    if (z2) {
                        cmN.jaf.jac += j2;
                        cmN.jaf.size += j;
                    } else {
                        cmN.jaf.jad++;
                    }
                } else {
                    return;
                }
            } else if (cmN.jag != null) {
                cmN.jag.num++;
                if (z2) {
                    cmN.jag.jac += j3;
                    cmN.jag.size += j;
                    j2 = j3;
                } else {
                    cmN.jag.jad++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.iZX = null;
            if (z2) {
                c.a(cmN, 10);
            }
            if (this.jaa == "frsStat") {
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
        e cmN;
        if (this.iZX != null && (cmN = cmN()) != null && cmN.jah != null) {
            long iG = this.iZX.iG();
            if (iG > 3000) {
                d dVar = cmN.jah;
                dVar.jac = iG + dVar.jac;
                cmN.jah.num++;
                c.a(cmN, 10);
            }
        }
    }

    private e cmN() {
        return c.z(this.jaa, getNetType(), this.bUf);
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
