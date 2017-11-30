package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public static class b {
        public String aMR;
        public String aMS;
        public int cdj;
    }

    public static C0128a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0128a c0128a = new C0128a(str, str2, str3, str4, str5);
        c0128a.e(str6, str7, str8, str9, str10);
        return c0128a;
    }

    public static C0128a d(String str, String str2, String str3, String str4, String str5, String str6) {
        C0128a c0128a = new C0128a("ad_tpoint", "PT", str, str2, "tpoint");
        c0128a.e(null, null, str3, str4, str5);
        if (!am.isEmpty(str6)) {
            c0128a.cf("obj_ref", str6);
        }
        return c0128a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0128a c0128a = new C0128a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0128a.e(str2, str7, str3, str4, str5);
        c0128a.cf("obj_url", str6);
        c0128a.save();
    }

    @Deprecated
    public static void ce(String str, String str2) {
        if (!am.isEmpty(str)) {
            ak akVar = new ak(str);
            if (str2 != null) {
                akVar = akVar.ac("obj_type", str2);
            }
            TiebaStatic.log(akVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0128a {
        private final String Ut;
        private final boolean Xn;
        private final ak eeB;
        private final String gAj;
        private final String gAk;
        private final String key;
        private final String locate;

        private C0128a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.gAj = str2;
            this.Ut = str3;
            this.locate = str4;
            this.gAk = str5;
            this.Xn = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.eeB = bwG();
        }

        private ak bwG() {
            ak akVar = new ak(this.key);
            if (!StringUtils.isNull(this.gAj)) {
                akVar = akVar.ac("line", this.gAj);
            }
            if (!StringUtils.isNull(this.Ut)) {
                akVar = akVar.ac("page", this.Ut);
            }
            if (!StringUtils.isNull(this.locate)) {
                akVar = akVar.ac("locate", this.locate);
            }
            if (!StringUtils.isNull(this.gAk)) {
                return akVar.ac("task", this.gAk);
            }
            return akVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ak e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.eeB.ac("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.eeB.ac("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.eeB.ac(ImageViewerConfig.FORUM_ID, str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.eeB.ac(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.eeB.ac("tid", str5);
            }
            this.eeB.r("obj_cpid", 0).r("obj_good_id", 0).ac("obj_throw_type", "BY_POST").ac("client_type", "MOBILE_APP").ac("user_timestamp", String.valueOf(System.currentTimeMillis())).ac("os", "android").ac("os_version", Build.VERSION.RELEASE).ac("log_ver", "1.1");
            return this.eeB;
        }

        public C0128a cf(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.eeB.ac(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.eeB);
            if (!this.Xn) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void dO(String str) {
            this.eeB.dO(str);
        }
    }
}
