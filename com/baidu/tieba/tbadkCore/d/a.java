package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public static class b {
        public String bDM;
        public String bDN;
        public int bJW;
    }

    public static C0121a a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0121a c0121a = new C0121a(str, str2, str3, str4, str5);
        c0121a.e(str6, str7, str8, str9, str10);
        return c0121a;
    }

    public static C0121a d(String str, String str2, String str3, String str4, String str5, String str6) {
        C0121a c0121a = new C0121a("ad_tpoint", "PT", str, str2, "tpoint");
        c0121a.e(null, null, str3, str4, str5);
        if (!al.isEmpty(str6)) {
            c0121a.ci("obj_ref", str6);
        }
        return c0121a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0121a c0121a = new C0121a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0121a.e(str2, str7, str3, str4, str5);
        c0121a.ci("obj_url", str6);
        c0121a.save();
    }

    @Deprecated
    public static void ch(String str, String str2) {
        if (!al.isEmpty(str)) {
            aj ajVar = new aj(str);
            if (str2 != null) {
                ajVar = ajVar.aa("obj_type", str2);
            }
            TiebaStatic.log(ajVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0121a {
        private final String Uo;
        private final boolean XD;
        private final aj dNt;
        private final String gkI;
        private final String gkJ;
        private final String key;
        private final String locate;

        private C0121a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.gkI = str2;
            this.Uo = str3;
            this.locate = str4;
            this.gkJ = str5;
            this.XD = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.dNt = btw();
        }

        private aj btw() {
            aj ajVar = new aj(this.key);
            if (!StringUtils.isNull(this.gkI)) {
                ajVar = ajVar.aa("line", this.gkI);
            }
            if (!StringUtils.isNull(this.Uo)) {
                ajVar = ajVar.aa("page", this.Uo);
            }
            if (!StringUtils.isNull(this.locate)) {
                ajVar = ajVar.aa("locate", this.locate);
            }
            if (!StringUtils.isNull(this.gkJ)) {
                return ajVar.aa("task", this.gkJ);
            }
            return ajVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public aj e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.dNt.aa("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.dNt.aa("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.dNt.aa("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.dNt.aa(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.dNt.aa("tid", str5);
            }
            this.dNt.r("obj_cpid", 0).r("obj_good_id", 0).aa("obj_throw_type", "BY_POST").aa("client_type", "MOBILE_APP").aa("user_timestamp", String.valueOf(System.currentTimeMillis())).aa("os", "android").aa("os_version", Build.VERSION.RELEASE).aa("log_ver", "1.1");
            return this.dNt;
        }

        public C0121a ci(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.dNt.aa(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.dNt);
            if (!this.XD) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.dNt.delete(str);
        }
    }
}
