package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.baidu.searchbox.ng.ai.apps.media.recorder.RecordStatusCallback;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a hef;
    private final int heg = 10;
    private final int heh = 3000;
    public String mLogType = null;
    public boolean azD = false;

    public b(String str) {
        ac(str, false);
    }

    public void ac(String str, boolean z) {
        this.mLogType = str;
        this.azD = z;
        this.hef = new com.baidu.adp.lib.stats.a("dbg");
        c.k(str, getNetType(), z);
    }

    public void start() {
        this.hef.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e bCt;
        if (this.hef != null && (bCt = bCt()) != null) {
            if (z) {
                if (bCt.hem != null) {
                    bCt.hem.num++;
                    if (z2) {
                        bCt.hem.hej += j2;
                        bCt.hem.size += j;
                    } else {
                        bCt.hem.hek++;
                    }
                } else {
                    return;
                }
            } else if (bCt.hen != null) {
                bCt.hen.num++;
                if (z2) {
                    bCt.hen.hej += j3;
                    bCt.hen.size += j;
                    j2 = j3;
                } else {
                    bCt.hen.hek++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.hef = null;
            if (z2) {
                c.a(bCt, 10);
            }
            if (this.mLogType == "frsStat") {
                if (!z2 || j2 > 3000) {
                    com.baidu.adp.lib.stats.a aVar = new com.baidu.adp.lib.stats.a("dbg");
                    aVar.append(SocialConstants.PARAM_ACT, "frs");
                    aVar.append("result", z2 ? "0" : "1");
                    aVar.append("isHttp", z ? "1" : "0");
                    aVar.append("timeCost", String.valueOf(j2));
                    aVar.append(RecordStatusCallback.KEY_ERROR_CODE, String.valueOf(i));
                    aVar.append("errMsg", str);
                    aVar.append("down", String.valueOf(j));
                    BdStatisticsManager.getInstance().debug("frs", aVar);
                }
            }
        }
    }

    public void destory() {
        e bCt;
        if (this.hef != null && (bCt = bCt()) != null && bCt.heo != null) {
            long jM = this.hef.jM();
            if (jM > 3000) {
                d dVar = bCt.heo;
                dVar.hej = jM + dVar.hej;
                bCt.heo.num++;
                c.a(bCt, 10);
            }
        }
    }

    private e bCt() {
        return c.l(this.mLogType, getNetType(), this.azD);
    }

    private String getNetType() {
        int ld = j.ld();
        if (ld == 0) {
            return "N";
        }
        if (ld == 1) {
            return "WIFI";
        }
        if (ld == 3) {
            return "3G";
        }
        if (ld != 2) {
            return "N";
        }
        return "2G";
    }
}
