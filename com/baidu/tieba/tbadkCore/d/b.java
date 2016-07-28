package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.d flH;
    private final int flI = 10;
    private final int flJ = 3000;
    public String flK = null;
    public boolean aac = false;

    public b(String str) {
        O(str, false);
    }

    public void O(String str, boolean z) {
        this.flK = str;
        this.aac = z;
        this.flH = new com.baidu.adp.lib.stats.d("dbg");
        c.i(str, getNetType(), z);
    }

    public void start() {
        this.flH.ed();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        f bfX;
        if (this.flH != null && (bfX = bfX()) != null) {
            if (z) {
                if (bfX.flP != null) {
                    bfX.flP.num++;
                    if (z2) {
                        bfX.flP.flM += j2;
                        bfX.flP.size += j;
                    } else {
                        bfX.flP.flN++;
                    }
                } else {
                    return;
                }
            } else if (bfX.flQ != null) {
                bfX.flQ.num++;
                if (z2) {
                    bfX.flQ.flM += j3;
                    bfX.flQ.size += j;
                    j2 = j3;
                } else {
                    bfX.flQ.flN++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.flH = null;
            if (z2) {
                c.a(bfX, 10);
            }
            if (this.flK == "frsStat") {
                if (!z2 || j2 > 3000) {
                    com.baidu.adp.lib.stats.d dVar = new com.baidu.adp.lib.stats.d("dbg");
                    dVar.q("act", "frs");
                    dVar.q("result", z2 ? "0" : "1");
                    dVar.q("isHttp", z ? "1" : "0");
                    dVar.q("timeCost", String.valueOf(j2));
                    dVar.q("errCode", String.valueOf(i));
                    dVar.q("errMsg", str);
                    dVar.q("down", String.valueOf(j));
                    com.baidu.adp.lib.stats.a.dN().b("frs", dVar);
                }
            }
        }
    }

    public void destory() {
        f bfX;
        if (this.flH != null && (bfX = bfX()) != null && bfX.flR != null) {
            long ee = this.flH.ee();
            if (ee > 3000) {
                e eVar = bfX.flR;
                eVar.flM = ee + eVar.flM;
                bfX.flR.num++;
                c.a(bfX, 10);
            }
        }
    }

    private f bfX() {
        return c.j(this.flK, getNetType(), this.aac);
    }

    private String getNetType() {
        int fw = i.fw();
        if (fw == 0) {
            return "N";
        }
        if (fw == 1) {
            return "WIFI";
        }
        if (fw == 3) {
            return "3G";
        }
        if (fw != 2) {
            return "N";
        }
        return "2G";
    }
}
