package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.d etO;
    private final int etP = 10;
    private final int etQ = 3000;
    public String etR = null;
    public boolean Zc = false;

    public b(String str) {
        M(str, false);
    }

    public void M(String str, boolean z) {
        this.etR = str;
        this.Zc = z;
        this.etO = new com.baidu.adp.lib.stats.d("dbg");
        c.h(str, getNetType(), z);
    }

    public void start() {
        this.etO.ed();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        f aUo;
        if (this.etO != null && (aUo = aUo()) != null) {
            if (z) {
                if (aUo.etW != null) {
                    aUo.etW.num++;
                    if (z2) {
                        aUo.etW.etT += j2;
                        aUo.etW.size += j;
                    } else {
                        aUo.etW.etU++;
                    }
                } else {
                    return;
                }
            } else if (aUo.etX != null) {
                aUo.etX.num++;
                if (z2) {
                    aUo.etX.etT += j3;
                    aUo.etX.size += j;
                    j2 = j3;
                } else {
                    aUo.etX.etU++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.etO = null;
            if (z2) {
                c.a(aUo, 10);
            }
            if (this.etR == "frsStat") {
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
        f aUo;
        if (this.etO != null && (aUo = aUo()) != null && aUo.etY != null) {
            long ee = this.etO.ee();
            if (ee > 3000) {
                e eVar = aUo.etY;
                eVar.etT = ee + eVar.etT;
                aUo.etY.num++;
                c.a(aUo, 10);
            }
        }
    }

    private f aUo() {
        return c.i(this.etR, getNetType(), this.Zc);
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
