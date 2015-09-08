package com.baidu.tieba.tbadkCore.e;

import com.baidu.adp.lib.util.i;
import com.baidu.location.LocationClientOption;
/* loaded from: classes.dex */
public class a {
    private com.baidu.adp.lib.stats.d cRG;
    private final int cRH = 10;
    private final int cRI = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
    public String cRJ = null;
    public boolean acm = false;

    public a(String str) {
        H(str, false);
    }

    public void H(String str, boolean z) {
        this.cRJ = str;
        this.acm = z;
        this.cRG = new com.baidu.adp.lib.stats.d("dbg");
        b.g(str, getNetType(), z);
    }

    public void start() {
        this.cRG.hx();
    }

    public void a(boolean z, boolean z2, int i, String str, long j) {
        long hy = this.cRG.hy();
        long j2 = 0;
        long j3 = 0;
        if (z) {
            j2 = hy;
        } else {
            j3 = hy;
        }
        a(z, z2, i, str, j, j2, j3);
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e auz;
        if (this.cRG != null && (auz = auz()) != null) {
            if (z) {
                if (auz.cRO != null) {
                    auz.cRO.num++;
                    if (z2) {
                        auz.cRO.cRL += j2;
                        auz.cRO.size += j;
                    } else {
                        auz.cRO.cRM++;
                    }
                } else {
                    return;
                }
            } else if (auz.cRP != null) {
                auz.cRP.num++;
                if (z2) {
                    auz.cRP.cRL += j3;
                    auz.cRP.size += j;
                    j2 = j3;
                } else {
                    auz.cRP.cRM++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.cRG = null;
            if (z2) {
                b.a(auz, 10);
            }
            if (this.cRJ == "frsStat") {
                if (!z2 || j2 > 3000) {
                    com.baidu.adp.lib.stats.d dVar = new com.baidu.adp.lib.stats.d("dbg");
                    dVar.q("act", "frs");
                    dVar.q("result", z2 ? "0" : "1");
                    dVar.q("isHttp", z ? "1" : "0");
                    dVar.q("timeCost", String.valueOf(j2));
                    dVar.q("errCode", String.valueOf(i));
                    dVar.q("errMsg", str);
                    dVar.q("down", String.valueOf(j));
                    com.baidu.adp.lib.stats.a.hh().b("frs", dVar);
                }
            }
        }
    }

    public void destory() {
        e auz;
        if (this.cRG != null && (auz = auz()) != null && auz.cRQ != null) {
            long hy = this.cRG.hy();
            if (hy > 3000) {
                d dVar = auz.cRQ;
                dVar.cRL = hy + dVar.cRL;
                auz.cRQ.num++;
                b.a(auz, 10);
            }
        }
    }

    private e auz() {
        return b.h(this.cRJ, getNetType(), this.acm);
    }

    private String getNetType() {
        int iR = i.iR();
        if (iR == 0) {
            return "N";
        }
        if (iR == 1) {
            return "WIFI";
        }
        if (iR == 3) {
            return "3G";
        }
        if (iR != 2) {
            return "N";
        }
        return "2G";
    }
}
