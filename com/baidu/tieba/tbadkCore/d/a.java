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
        public String ctx;
        public int ekG;
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
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
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
        private final boolean bzj;
        private final am gEQ;
        private final String iHb;
        private final String iHc;
        private final String iHd;
        private final String key;
        private final String page;

        private C0390a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.iHb = str2;
            this.page = str3;
            this.iHc = str4;
            this.iHd = str5;
            this.bzj = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.gEQ = ceH();
        }

        private am ceH() {
            am amVar = new am(this.key);
            if (!StringUtils.isNull(this.iHb)) {
                amVar = amVar.bJ("line", this.iHb);
            }
            if (!StringUtils.isNull(this.page)) {
                amVar = amVar.bJ("page", this.page);
            }
            if (!StringUtils.isNull(this.iHc)) {
                amVar = amVar.bJ("locate", this.iHc);
            }
            if (!StringUtils.isNull(this.iHd)) {
                return amVar.bJ("task", this.iHd);
            }
            return amVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public am e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.gEQ.bJ("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.gEQ.bJ(VideoPlayActivityConfig.OBJ_ID, str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.gEQ.bJ(ImageViewerConfig.FORUM_ID, str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.gEQ.bJ(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.gEQ.bJ("tid", str5);
            }
            this.gEQ.T("obj_cpid", 0).T("obj_good_id", 0).bJ("obj_throw_type", "BY_POST").bJ("client_type", "MOBILE_APP").bJ("user_timestamp", String.valueOf(System.currentTimeMillis())).bJ("os", "android").bJ("os_version", Build.VERSION.RELEASE).bJ("log_ver", "1.1");
            return this.gEQ;
        }

        public C0390a dY(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.gEQ.bJ(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.gEQ);
            if (!this.bzj) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.gEQ.delete(str);
        }
    }
}
