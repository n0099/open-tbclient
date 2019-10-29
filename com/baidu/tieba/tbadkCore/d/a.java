package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public static class b {
        public String cmS;
        public int ePN;
        public String mPid;
    }

    public static C0520a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0520a c0520a = new C0520a(str, str2, str3, str4, str5);
        c0520a.l(str6, str7, str8, str9, str10);
        return c0520a;
    }

    public static C0520a d(String str, String str2, String str3, String str4, String str5, String str6) {
        C0520a c0520a = new C0520a("ad_tpoint", "PT", str, str2, "tpoint");
        c0520a.l(null, null, str3, str4, str5);
        if (!aq.isEmpty(str6)) {
            c0520a.ea("obj_ref", str6);
        }
        return c0520a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0520a c0520a = new C0520a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0520a.l(str2, str7, str3, str4, str5);
        c0520a.ea(TiebaInitialize.Params.OBJ_URL, str6);
        c0520a.save();
    }

    @Deprecated
    public static void dZ(String str, String str2) {
        if (!aq.isEmpty(str)) {
            an anVar = new an(str);
            if (str2 != null) {
                anVar = anVar.bS("obj_type", str2);
            }
            TiebaStatic.log(anVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0520a {
        private final boolean bZF;
        private final an hdp;
        private final String jjJ;
        private final String jjK;
        private final String jjL;
        private final String key;
        private final String page;

        private C0520a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.jjJ = str2;
            this.page = str3;
            this.jjK = str4;
            this.jjL = str5;
            this.bZF = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.hdp = coI();
        }

        private an coI() {
            an anVar = new an(this.key);
            if (!StringUtils.isNull(this.jjJ)) {
                anVar = anVar.bS("line", this.jjJ);
            }
            if (!StringUtils.isNull(this.page)) {
                anVar = anVar.bS("page", this.page);
            }
            if (!StringUtils.isNull(this.jjK)) {
                anVar = anVar.bS("locate", this.jjK);
            }
            if (!StringUtils.isNull(this.jjL)) {
                return anVar.bS("task", this.jjL);
            }
            return anVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public an l(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.hdp.bS("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.hdp.bS("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.hdp.bS("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.hdp.bS("fname", str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.hdp.bS("tid", str5);
            }
            this.hdp.O("obj_cpid", 0).O("obj_good_id", 0).bS("obj_throw_type", "BY_POST").bS("client_type", "MOBILE_APP").bS("user_timestamp", String.valueOf(System.currentTimeMillis())).bS("os", "android").bS(BdStatsConstant.StatsKey.OS_VERSION, Build.VERSION.RELEASE).bS("log_ver", "1.1");
            return this.hdp;
        }

        public C0520a ea(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.hdp.bS(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.hdp);
            if (!this.bZF) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.hdp.delete(str);
        }
    }
}
