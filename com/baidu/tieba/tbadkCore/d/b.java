package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a gZo;
    private final int gZp = 10;
    private final int gZq = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
    public String gZr = null;
    public boolean aXa = false;

    public b(String str) {
        ab(str, false);
    }

    public void ab(String str, boolean z) {
        this.gZr = str;
        this.aXa = z;
        this.gZo = new com.baidu.adp.lib.stats.a("dbg");
        c.j(str, getNetType(), z);
    }

    public void start() {
        this.gZo.nv();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e bwb;
        if (this.gZo != null && (bwb = bwb()) != null) {
            if (z) {
                if (bwb.gZw != null) {
                    bwb.gZw.num++;
                    if (z2) {
                        bwb.gZw.gZt += j2;
                        bwb.gZw.size += j;
                    } else {
                        bwb.gZw.gZu++;
                    }
                } else {
                    return;
                }
            } else if (bwb.gZx != null) {
                bwb.gZx.num++;
                if (z2) {
                    bwb.gZx.gZt += j3;
                    bwb.gZx.size += j;
                    j2 = j3;
                } else {
                    bwb.gZx.gZu++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.gZo = null;
            if (z2) {
                c.a(bwb, 10);
            }
            if (this.gZr == "frsStat") {
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
        e bwb;
        if (this.gZo != null && (bwb = bwb()) != null && bwb.gZy != null) {
            long nw = this.gZo.nw();
            if (nw > 3000) {
                d dVar = bwb.gZy;
                dVar.gZt = nw + dVar.gZt;
                bwb.gZy.num++;
                c.a(bwb, 10);
            }
        }
    }

    private e bwb() {
        return c.k(this.gZr, getNetType(), this.aXa);
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
