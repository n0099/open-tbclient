package com.baidu.tieba.tbadkCore.e;

import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.stats.q;
import com.baidu.adp.lib.util.k;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
import com.baidu.tbadk.game.GameInfoData;
/* loaded from: classes.dex */
public class a {
    private q coC;
    private final int coD = 10;
    private final int coE = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
    public String coF = null;
    public boolean Ws = false;

    public a(String str) {
        E(str, false);
    }

    public void E(String str, boolean z) {
        this.coF = str;
        this.Ws = z;
        this.coC = new q("dbg");
        b.g(str, getNetType(), z);
    }

    public void start() {
        this.coC.il();
    }

    public void a(boolean z, boolean z2, int i, String str, long j) {
        long im = this.coC.im();
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
        e ana;
        if (this.coC != null && (ana = ana()) != null) {
            if (z) {
                if (ana.coK != null) {
                    ana.coK.num++;
                    if (z2) {
                        ana.coK.coH += j2;
                        ana.coK.size += j;
                    } else {
                        ana.coK.coI++;
                    }
                } else {
                    return;
                }
            } else if (ana.coL != null) {
                ana.coL.num++;
                if (z2) {
                    ana.coL.coH += j3;
                    ana.coL.size += j;
                    j2 = j3;
                } else {
                    ana.coL.coI++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.coC = null;
            if (z2) {
                b.a(ana, 10);
            }
            if (this.coF == "frsStat") {
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
        e ana;
        if (this.coC != null && (ana = ana()) != null && ana.coM != null) {
            long im = this.coC.im();
            if (im > 3000) {
                d dVar = ana.coM;
                dVar.coH = im + dVar.coH;
                ana.coM.num++;
                b.a(ana, 10);
            }
        }
    }

    private e ana() {
        return b.h(this.coF, getNetType(), this.Ws);
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
