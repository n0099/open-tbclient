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
        public String bDd;
        public String bDe;
        public int bJn;
    }

    public static C0120a a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0120a c0120a = new C0120a(str, str2, str3, str4, str5);
        c0120a.e(str6, str7, str8, str9, str10);
        return c0120a;
    }

    public static C0120a d(String str, String str2, String str3, String str4, String str5, String str6) {
        C0120a c0120a = new C0120a("ad_tpoint", "PT", str, str2, "tpoint");
        c0120a.e(null, null, str3, str4, str5);
        if (!al.isEmpty(str6)) {
            c0120a.ch("obj_ref", str6);
        }
        return c0120a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0120a c0120a = new C0120a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0120a.e(str2, str7, str3, str4, str5);
        c0120a.ch("obj_url", str6);
        c0120a.save();
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
    public static class C0120a {
        private final String Um;
        private final boolean XB;
        private final aj dLx;
        private final String giQ;
        private final String giR;
        private final String key;
        private final String locate;

        private C0120a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.giQ = str2;
            this.Um = str3;
            this.locate = str4;
            this.giR = str5;
            this.XB = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.dLx = bsO();
        }

        private aj bsO() {
            aj ajVar = new aj(this.key);
            if (!StringUtils.isNull(this.giQ)) {
                ajVar = ajVar.aa("line", this.giQ);
            }
            if (!StringUtils.isNull(this.Um)) {
                ajVar = ajVar.aa("page", this.Um);
            }
            if (!StringUtils.isNull(this.locate)) {
                ajVar = ajVar.aa("locate", this.locate);
            }
            if (!StringUtils.isNull(this.giR)) {
                return ajVar.aa("task", this.giR);
            }
            return ajVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public aj e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.dLx.aa("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.dLx.aa("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.dLx.aa("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.dLx.aa(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.dLx.aa("tid", str5);
            }
            this.dLx.r("obj_cpid", 0).r("obj_good_id", 0).aa("obj_throw_type", "BY_POST").aa("client_type", "MOBILE_APP").aa("user_timestamp", String.valueOf(System.currentTimeMillis())).aa("os", "android").aa("os_version", Build.VERSION.RELEASE).aa("log_ver", "1.1");
            return this.dLx;
        }

        public C0120a ch(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.dLx.aa(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.dLx);
            if (!this.XB) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.dLx.delete(str);
        }
    }
}
