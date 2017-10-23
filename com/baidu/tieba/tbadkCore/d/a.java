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
        public int bMY;
        public String chn;
        public String cyL;
    }

    public static C0126a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0126a c0126a = new C0126a(str, str2, str3, str4, str5);
        c0126a.e(str6, str7, str8, str9, str10);
        return c0126a;
    }

    public static C0126a d(String str, String str2, String str3, String str4, String str5, String str6) {
        C0126a c0126a = new C0126a("ad_tpoint", "PT", str, str2, "tpoint");
        c0126a.e(null, null, str3, str4, str5);
        if (!am.isEmpty(str6)) {
            c0126a.cd("obj_ref", str6);
        }
        return c0126a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0126a c0126a = new C0126a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0126a.e(str2, str7, str3, str4, str5);
        c0126a.cd("obj_url", str6);
        c0126a.save();
    }

    @Deprecated
    public static void cc(String str, String str2) {
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
    public static class C0126a {
        private final String Tt;
        private final boolean WC;
        private final ak dQU;
        private final String ghy;
        private final String ghz;
        private final String key;
        private final String locate;

        private C0126a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.ghy = str2;
            this.Tt = str3;
            this.locate = str4;
            this.ghz = str5;
            this.WC = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.dQU = brG();
        }

        private ak brG() {
            ak akVar = new ak(this.key);
            if (!StringUtils.isNull(this.ghy)) {
                akVar = akVar.ac("line", this.ghy);
            }
            if (!StringUtils.isNull(this.Tt)) {
                akVar = akVar.ac("page", this.Tt);
            }
            if (!StringUtils.isNull(this.locate)) {
                akVar = akVar.ac("locate", this.locate);
            }
            if (!StringUtils.isNull(this.ghz)) {
                return akVar.ac("task", this.ghz);
            }
            return akVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ak e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.dQU.ac("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.dQU.ac("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.dQU.ac("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.dQU.ac(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.dQU.ac("tid", str5);
            }
            this.dQU.r("obj_cpid", 0).r("obj_good_id", 0).ac("obj_throw_type", "BY_POST").ac("client_type", "MOBILE_APP").ac("user_timestamp", String.valueOf(System.currentTimeMillis())).ac("os", "android").ac("os_version", Build.VERSION.RELEASE).ac("log_ver", "1.1");
            return this.dQU;
        }

        public C0126a cd(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.dQU.ac(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.dQU);
            if (!this.WC) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void dG(String str) {
            this.dQU.dG(str);
        }
    }
}
