package com.baidu.tieba.tbadkCore.e;

import com.baidu.adp.lib.util.i;
import com.baidu.location.LocationClientOption;
/* loaded from: classes.dex */
public class a {
    private com.baidu.adp.lib.stats.d dbu;
    private final int dbv = 10;
    private final int dbw = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
    public String dbx = null;
    public boolean acr = false;

    public a(String str) {
        I(str, false);
    }

    public void I(String str, boolean z) {
        this.dbx = str;
        this.acr = z;
        this.dbu = new com.baidu.adp.lib.stats.d("dbg");
        b.j(str, getNetType(), z);
    }

    public void start() {
        this.dbu.hz();
    }

    public void a(boolean z, boolean z2, int i, String str, long j) {
        long hA = this.dbu.hA();
        long j2 = 0;
        long j3 = 0;
        if (z) {
            j2 = hA;
        } else {
            j3 = hA;
        }
        a(z, z2, i, str, j, j2, j3);
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e axK;
        if (this.dbu != null && (axK = axK()) != null) {
            if (z) {
                if (axK.dbC != null) {
                    axK.dbC.num++;
                    if (z2) {
                        axK.dbC.dbz += j2;
                        axK.dbC.size += j;
                    } else {
                        axK.dbC.dbA++;
                    }
                } else {
                    return;
                }
            } else if (axK.dbD != null) {
                axK.dbD.num++;
                if (z2) {
                    axK.dbD.dbz += j3;
                    axK.dbD.size += j;
                    j2 = j3;
                } else {
                    axK.dbD.dbA++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.dbu = null;
            if (z2) {
                b.a(axK, 10);
            }
            if (this.dbx == "frsStat") {
                if (!z2 || j2 > 3000) {
                    com.baidu.adp.lib.stats.d dVar = new com.baidu.adp.lib.stats.d("dbg");
                    dVar.q("act", "frs");
                    dVar.q("result", z2 ? "0" : "1");
                    dVar.q("isHttp", z ? "1" : "0");
                    dVar.q("timeCost", String.valueOf(j2));
                    dVar.q("errCode", String.valueOf(i));
                    dVar.q("errMsg", str);
                    dVar.q("down", String.valueOf(j));
                    com.baidu.adp.lib.stats.a.hj().b("frs", dVar);
                }
            }
        }
    }

    public void destory() {
        e axK;
        if (this.dbu != null && (axK = axK()) != null && axK.dbE != null) {
            long hA = this.dbu.hA();
            if (hA > 3000) {
                d dVar = axK.dbE;
                dVar.dbz = hA + dVar.dbz;
                axK.dbE.num++;
                b.a(axK, 10);
            }
        }
    }

    private e axK() {
        return b.k(this.dbx, getNetType(), this.acr);
    }

    private String getNetType() {
        int iT = i.iT();
        if (iT == 0) {
            return "N";
        }
        if (iT == 1) {
            return "WIFI";
        }
        if (iT == 3) {
            return "3G";
        }
        if (iT != 2) {
            return "N";
        }
        return "2G";
    }
}
