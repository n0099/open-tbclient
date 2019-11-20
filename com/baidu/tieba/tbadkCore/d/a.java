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
        public String cma;
        public int eOW;
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
        private final boolean bYO;
        private final an hcy;
        private final String jiS;
        private final String jiT;
        private final String jiU;
        private final String key;
        private final String page;

        private C0520a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.jiS = str2;
            this.page = str3;
            this.jiT = str4;
            this.jiU = str5;
            this.bYO = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.hcy = coG();
        }

        private an coG() {
            an anVar = new an(this.key);
            if (!StringUtils.isNull(this.jiS)) {
                anVar = anVar.bS("line", this.jiS);
            }
            if (!StringUtils.isNull(this.page)) {
                anVar = anVar.bS("page", this.page);
            }
            if (!StringUtils.isNull(this.jiT)) {
                anVar = anVar.bS("locate", this.jiT);
            }
            if (!StringUtils.isNull(this.jiU)) {
                return anVar.bS("task", this.jiU);
            }
            return anVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public an l(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.hcy.bS("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.hcy.bS("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.hcy.bS("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.hcy.bS("fname", str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.hcy.bS("tid", str5);
            }
            this.hcy.O("obj_cpid", 0).O("obj_good_id", 0).bS("obj_throw_type", "BY_POST").bS("client_type", "MOBILE_APP").bS("user_timestamp", String.valueOf(System.currentTimeMillis())).bS("os", "android").bS(BdStatsConstant.StatsKey.OS_VERSION, Build.VERSION.RELEASE).bS("log_ver", "1.1");
            return this.hcy;
        }

        public C0520a ea(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.hcy.bS(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.hcy);
            if (!this.bYO) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.hcy.delete(str);
        }
    }
}
