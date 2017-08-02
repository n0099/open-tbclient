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
        public String bBT;
        public String bBU;
        public int bId;
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
            c0121a.ch("obj_ref", str6);
        }
        return c0121a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0121a c0121a = new C0121a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0121a.e(str2, str7, str3, str4, str5);
        c0121a.ch("obj_url", str6);
        c0121a.save();
    }

    @Deprecated
    public static void cg(String str, String str2) {
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
        private final String SO;
        private final boolean Wf;
        private final aj dKg;
        private final String ghE;
        private final String ghF;
        private final String key;
        private final String locate;

        private C0121a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.ghE = str2;
            this.SO = str3;
            this.locate = str4;
            this.ghF = str5;
            this.Wf = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.dKg = bsH();
        }

        private aj bsH() {
            aj ajVar = new aj(this.key);
            if (!StringUtils.isNull(this.ghE)) {
                ajVar = ajVar.aa("line", this.ghE);
            }
            if (!StringUtils.isNull(this.SO)) {
                ajVar = ajVar.aa("page", this.SO);
            }
            if (!StringUtils.isNull(this.locate)) {
                ajVar = ajVar.aa("locate", this.locate);
            }
            if (!StringUtils.isNull(this.ghF)) {
                return ajVar.aa("task", this.ghF);
            }
            return ajVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public aj e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.dKg.aa("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.dKg.aa("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.dKg.aa("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.dKg.aa(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.dKg.aa("tid", str5);
            }
            this.dKg.r("obj_cpid", 0).r("obj_good_id", 0).aa("obj_throw_type", "BY_POST").aa("client_type", "MOBILE_APP").aa("user_timestamp", String.valueOf(System.currentTimeMillis())).aa("os", "android").aa("os_version", Build.VERSION.RELEASE).aa("log_ver", "1.1");
            return this.dKg;
        }

        public C0121a ch(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.dKg.aa(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.dKg);
            if (!this.Wf) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.dKg.delete(str);
        }
    }
}
