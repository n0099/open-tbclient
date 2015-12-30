package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.util.i;
import com.baidu.location.LocationClientOption;
/* loaded from: classes.dex */
public class a {
    private com.baidu.adp.lib.stats.d dHN;
    private final int dHO = 10;
    private final int dHP = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
    public String dHQ = null;
    public boolean adO = false;

    public a(String str) {
        J(str, false);
    }

    public void J(String str, boolean z) {
        this.dHQ = str;
        this.adO = z;
        this.dHN = new com.baidu.adp.lib.stats.d("dbg");
        b.h(str, getNetType(), z);
    }

    public void start() {
        this.dHN.hB();
    }

    public void a(boolean z, boolean z2, int i, String str, long j) {
        long hC = this.dHN.hC();
        long j2 = 0;
        long j3 = 0;
        if (z) {
            j2 = hC;
        } else {
            j3 = hC;
        }
        a(z, z2, i, str, j, j2, j3);
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e aFI;
        if (this.dHN != null && (aFI = aFI()) != null) {
            if (z) {
                if (aFI.dHV != null) {
                    aFI.dHV.num++;
                    if (z2) {
                        aFI.dHV.dHS += j2;
                        aFI.dHV.size += j;
                    } else {
                        aFI.dHV.dHT++;
                    }
                } else {
                    return;
                }
            } else if (aFI.dHW != null) {
                aFI.dHW.num++;
                if (z2) {
                    aFI.dHW.dHS += j3;
                    aFI.dHW.size += j;
                    j2 = j3;
                } else {
                    aFI.dHW.dHT++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.dHN = null;
            if (z2) {
                b.a(aFI, 10);
            }
            if (this.dHQ == "frsStat") {
                if (!z2 || j2 > 3000) {
                    com.baidu.adp.lib.stats.d dVar = new com.baidu.adp.lib.stats.d("dbg");
                    dVar.q("act", "frs");
                    dVar.q("result", z2 ? "0" : "1");
                    dVar.q("isHttp", z ? "1" : "0");
                    dVar.q("timeCost", String.valueOf(j2));
                    dVar.q("errCode", String.valueOf(i));
                    dVar.q("errMsg", str);
                    dVar.q("down", String.valueOf(j));
                    com.baidu.adp.lib.stats.a.hl().b("frs", dVar);
                }
            }
        }
    }

    public void destory() {
        e aFI;
        if (this.dHN != null && (aFI = aFI()) != null && aFI.dHX != null) {
            long hC = this.dHN.hC();
            if (hC > 3000) {
                d dVar = aFI.dHX;
                dVar.dHS = hC + dVar.dHS;
                aFI.dHX.num++;
                b.a(aFI, 10);
            }
        }
    }

    private e aFI() {
        return b.i(this.dHQ, getNetType(), this.adO);
    }

    private String getNetType() {
        int iW = i.iW();
        if (iW == 0) {
            return "N";
        }
        if (iW == 1) {
            return "WIFI";
        }
        if (iW == 3) {
            return "3G";
        }
        if (iW != 2) {
            return "N";
        }
        return "2G";
    }
}
