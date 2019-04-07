package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public static class b {
        public String ctw;
        public int ekF;
        public String mPid;
    }

    public static C0390a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0390a c0390a = new C0390a(str, str2, str3, str4, str5);
        c0390a.e(str6, str7, str8, str9, str10);
        return c0390a;
    }

    public static C0390a f(String str, String str2, String str3, String str4, String str5, String str6) {
        C0390a c0390a = new C0390a("ad_tpoint", "PT", str, str2, "tpoint");
        c0390a.e(null, null, str3, str4, str5);
        if (!ap.isEmpty(str6)) {
            c0390a.dY("obj_ref", str6);
        }
        return c0390a;
    }

    @Deprecated
    public static void b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0390a c0390a = new C0390a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0390a.e(str2, str7, str3, str4, str5);
        c0390a.dY("obj_url", str6);
        c0390a.save();
    }

    @Deprecated
    public static void dX(String str, String str2) {
        if (!ap.isEmpty(str)) {
            am amVar = new am(str);
            if (str2 != null) {
                amVar = amVar.bJ("obj_type", str2);
            }
            TiebaStatic.log(amVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0390a {
        private final boolean bzi;
        private final am gEP;
        private final String iHa;
        private final String iHb;
        private final String iHc;
        private final String key;
        private final String page;

        private C0390a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.iHa = str2;
            this.page = str3;
            this.iHb = str4;
            this.iHc = str5;
            this.bzi = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.gEP = ceH();
        }

        private am ceH() {
            am amVar = new am(this.key);
            if (!StringUtils.isNull(this.iHa)) {
                amVar = amVar.bJ("line", this.iHa);
            }
            if (!StringUtils.isNull(this.page)) {
                amVar = amVar.bJ("page", this.page);
            }
            if (!StringUtils.isNull(this.iHb)) {
                amVar = amVar.bJ("locate", this.iHb);
            }
            if (!StringUtils.isNull(this.iHc)) {
                return amVar.bJ("task", this.iHc);
            }
            return amVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public am e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.gEP.bJ("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.gEP.bJ(VideoPlayActivityConfig.OBJ_ID, str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.gEP.bJ(ImageViewerConfig.FORUM_ID, str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.gEP.bJ(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.gEP.bJ("tid", str5);
            }
            this.gEP.T("obj_cpid", 0).T("obj_good_id", 0).bJ("obj_throw_type", "BY_POST").bJ("client_type", "MOBILE_APP").bJ("user_timestamp", String.valueOf(System.currentTimeMillis())).bJ("os", "android").bJ("os_version", Build.VERSION.RELEASE).bJ("log_ver", "1.1");
            return this.gEP;
        }

        public C0390a dY(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.gEP.bJ(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.gEP);
            if (!this.bzi) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.gEP.delete(str);
        }
    }
}
