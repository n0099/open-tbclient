package com.baidu.tieba.tbadkCore.e;

import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.stats.q;
import com.baidu.adp.lib.util.k;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
import com.baidu.tbadk.game.GameInfoData;
/* loaded from: classes.dex */
public class a {

    /* renamed from: com  reason: collision with root package name */
    private q f127com;
    private final int con = 10;
    private final int coo = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
    public String cop = null;
    public boolean Wq = false;

    public a(String str) {
        E(str, false);
    }

    public void E(String str, boolean z) {
        this.cop = str;
        this.Wq = z;
        this.f127com = new q("dbg");
        b.g(str, getNetType(), z);
    }

    public void start() {
        this.f127com.il();
    }

    public void a(boolean z, boolean z2, int i, String str, long j) {
        long im = this.f127com.im();
        long j2 = 0;
        long j3 = 0;
        if (z) {
            j2 = im;
        } else {
            j3 = im;
        }
        a(z, z2, i, str, j, j2, j3);
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e amL;
        if (this.f127com != null && (amL = amL()) != null) {
            if (z) {
                if (amL.cou != null) {
                    amL.cou.num++;
                    if (z2) {
                        amL.cou.cor += j2;
                        amL.cou.size += j;
                    } else {
                        amL.cou.cos++;
                    }
                } else {
                    return;
                }
            } else if (amL.cov != null) {
                amL.cov.num++;
                if (z2) {
                    amL.cov.cor += j3;
                    amL.cov.size += j;
                    j2 = j3;
                } else {
                    amL.cov.cos++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.f127com = null;
            if (z2) {
                b.a(amL, 10);
            }
            if (this.cop == "frsStat") {
                if (!z2 || j2 > 3000) {
                    q qVar = new q("dbg");
                    qVar.r("act", "frs");
                    qVar.r("result", z2 ? GameInfoData.NOT_FROM_DETAIL : "1");
                    qVar.r("isHttp", z ? "1" : GameInfoData.NOT_FROM_DETAIL);
                    qVar.r("timeCost", String.valueOf(j2));
                    qVar.r("errCode", String.valueOf(i));
                    qVar.r("errMsg", str);
                    qVar.r("down", String.valueOf(j));
                    f.hP().a("frs", qVar);
                }
            }
        }
    }

    public void destory() {
        e amL;
        if (this.f127com != null && (amL = amL()) != null && amL.cow != null) {
            long im = this.f127com.im();
            if (im > 3000) {
                d dVar = amL.cow;
                dVar.cor = im + dVar.cor;
                amL.cow.num++;
                b.a(amL, 10);
            }
        }
    }

    private e amL() {
        return b.h(this.cop, getNetType(), this.Wq);
    }

    private String getNetType() {
        int iM = k.iM();
        if (iM == 0) {
            return "N";
        }
        if (iM == 1) {
            return NetworkChangeReceiver.WIFI_STRING;
        }
        if (iM == 3) {
            return "3G";
        }
        if (iM != 2) {
            return "N";
        }
        return "2G";
    }
}
