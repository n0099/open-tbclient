package com.baidu.tieba.tbadkCore.e;

import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.stats.q;
import com.baidu.adp.lib.util.k;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
import com.baidu.tbadk.game.GameInfoData;
/* loaded from: classes.dex */
public class a {
    private q csE;
    private final int csF = 10;
    private final int csG = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
    public String csH = null;
    public boolean Xe = false;

    public a(String str) {
        E(str, false);
    }

    public void E(String str, boolean z) {
        this.csH = str;
        this.Xe = z;
        this.csE = new q("dbg");
        b.g(str, getNetType(), z);
    }

    public void start() {
        this.csE.hU();
    }

    public void a(boolean z, boolean z2, int i, String str, long j) {
        long hV = this.csE.hV();
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
        e aoS;
        if (this.csE != null && (aoS = aoS()) != null) {
            if (z) {
                if (aoS.csM != null) {
                    aoS.csM.num++;
                    if (z2) {
                        aoS.csM.csJ += j2;
                        aoS.csM.size += j;
                    } else {
                        aoS.csM.csK++;
                    }
                } else {
                    return;
                }
            } else if (aoS.csN != null) {
                aoS.csN.num++;
                if (z2) {
                    aoS.csN.csJ += j3;
                    aoS.csN.size += j;
                    j2 = j3;
                } else {
                    aoS.csN.csK++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.csE = null;
            if (z2) {
                b.a(aoS, 10);
            }
            if (this.csH == "frsStat") {
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
        e aoS;
        if (this.csE != null && (aoS = aoS()) != null && aoS.csO != null) {
            long hV = this.csE.hV();
            if (hV > 3000) {
                d dVar = aoS.csO;
                dVar.csJ = hV + dVar.csJ;
                aoS.csO.num++;
                b.a(aoS, 10);
            }
        }
    }

    private e aoS() {
        return b.h(this.csH, getNetType(), this.Xe);
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
