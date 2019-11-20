package com.baidu.tieba.j;

import android.os.SystemClock;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.util.ac;
/* loaded from: classes.dex */
public class k {
    private static final String TAG = k.class.getName();
    private long hwP;
    private long hwQ;
    private long hwR;
    private boolean hwS;
    private String hwT = "";

    public void bMT() {
        this.hwS = true;
        this.hwP = SystemClock.elapsedRealtime();
    }

    public void bMU() {
        this.hwQ = SystemClock.elapsedRealtime();
    }

    public void bMV() {
        this.hwR = SystemClock.elapsedRealtime();
    }

    public void a(String str, long j, long j2, com.baidu.tieba.play.a.a aVar) {
        a(str, j, j2, this.hwT, aVar);
    }

    public void a(String str, long j, long j2, String str2, com.baidu.tieba.play.a.a aVar) {
        if (this.hwS) {
            this.hwS = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j3 = this.hwQ - this.hwP;
            long j4 = elapsedRealtime - this.hwR;
            long j5 = j4 + j3;
            if (com.baidu.adp.lib.util.j.netType() == 2 || j3 <= 17500) {
                an anVar = new an("c13171");
                anVar.bS("obj_source", str2);
                anVar.p("obj_param1", j3);
                anVar.p(TiebaInitialize.Params.OBJ_PARAM2, j4);
                anVar.p(TiebaInitialize.Params.OBJ_PARAM3, j5);
                anVar.p("obj_duration", j2);
                anVar.p("resource_id", j);
                anVar.O("ptype", com.baidu.adp.lib.util.j.netType());
                anVar.bS("tid", str);
                anVar.bS("cuid", TbadkCoreApplication.getInst().getCuid());
                anVar.O("obj_id", ac.kn(Aa(str2)) ? 1 : 0);
                anVar.p("time_stamp", System.currentTimeMillis());
                TiebaStatic.log(anVar);
                if (aVar != null) {
                    aVar.a(str2, j3, j4, j5, j2, j, str, ac.kn(Aa(str2)) ? 1 : 0);
                }
            }
        }
    }

    private int Aa(String str) {
        if ("frs".equals(str)) {
            return 2;
        }
        if ("homepage".equals(str)) {
            return 1;
        }
        if ("middle".equals(str)) {
            return 4;
        }
        if ("pb".equals(str)) {
            return 3;
        }
        return 0;
    }

    public void setPageTypeForPerfStat(String str) {
        this.hwT = str;
    }
}
