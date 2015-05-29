package com.baidu.tieba.tbadkCore.e;

import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.stats.q;
import com.baidu.adp.lib.util.k;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
import com.baidu.tbadk.game.GameInfoData;
/* loaded from: classes.dex */
public class a {
    private q csD;
    private final int csE = 10;
    private final int csF = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
    public String csG = null;
    public boolean Xe = false;

    public a(String str) {
        E(str, false);
    }

    public void E(String str, boolean z) {
        this.csG = str;
        this.Xe = z;
        this.csD = new q("dbg");
        b.g(str, getNetType(), z);
    }

    public void start() {
        this.csD.hU();
    }

    public void a(boolean z, boolean z2, int i, String str, long j) {
        long hV = this.csD.hV();
        long j2 = 0;
        long j3 = 0;
        if (z) {
            j2 = hV;
        } else {
            j3 = hV;
        }
        a(z, z2, i, str, j, j2, j3);
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e aoR;
        if (this.csD != null && (aoR = aoR()) != null) {
            if (z) {
                if (aoR.csL != null) {
                    aoR.csL.num++;
                    if (z2) {
                        aoR.csL.csI += j2;
                        aoR.csL.size += j;
                    } else {
                        aoR.csL.csJ++;
                    }
                } else {
                    return;
                }
            } else if (aoR.csM != null) {
                aoR.csM.num++;
                if (z2) {
                    aoR.csM.csI += j3;
                    aoR.csM.size += j;
                    j2 = j3;
                } else {
                    aoR.csM.csJ++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.csD = null;
            if (z2) {
                b.a(aoR, 10);
            }
            if (this.csG == "frsStat") {
                if (!z2 || j2 > 3000) {
                    q qVar = new q("dbg");
                    qVar.r("act", "frs");
                    qVar.r("result", z2 ? GameInfoData.NOT_FROM_DETAIL : "1");
                    qVar.r("isHttp", z ? "1" : GameInfoData.NOT_FROM_DETAIL);
                    qVar.r("timeCost", String.valueOf(j2));
                    qVar.r("errCode", String.valueOf(i));
                    qVar.r("errMsg", str);
                    qVar.r("down", String.valueOf(j));
                    f.hz().a("frs", qVar);
                }
            }
        }
    }

    public void destory() {
        e aoR;
        if (this.csD != null && (aoR = aoR()) != null && aoR.csN != null) {
            long hV = this.csD.hV();
            if (hV > 3000) {
                d dVar = aoR.csN;
                dVar.csI = hV + dVar.csI;
                aoR.csN.num++;
                b.a(aoR, 10);
            }
        }
    }

    private e aoR() {
        return b.h(this.csG, getNetType(), this.Xe);
    }

    private String getNetType() {
        int jc = k.jc();
        if (jc == 0) {
            return "N";
        }
        if (jc == 1) {
            return NetworkChangeReceiver.WIFI_STRING;
        }
        if (jc == 3) {
            return "3G";
        }
        if (jc != 2) {
            return "N";
        }
        return "2G";
    }
}
