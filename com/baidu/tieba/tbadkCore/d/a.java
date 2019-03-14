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
        public String ctu;
        public int ekT;
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
            c0390a.dX("obj_ref", str6);
        }
        return c0390a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0390a c0390a = new C0390a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0390a.e(str2, str7, str3, str4, str5);
        c0390a.dX("obj_url", str6);
        c0390a.save();
    }

    @Deprecated
    public static void dW(String str, String str2) {
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
        private final boolean bzf;
        private final am gFb;
        private final String iHq;
        private final String iHr;
        private final String key;
        private final String line;
        private final String page;

        private C0390a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.line = str2;
            this.page = str3;
            this.iHq = str4;
            this.iHr = str5;
            this.bzf = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.gFb = ceL();
        }

        private am ceL() {
            am amVar = new am(this.key);
            if (!StringUtils.isNull(this.line)) {
                amVar = amVar.bJ("line", this.line);
            }
            if (!StringUtils.isNull(this.page)) {
                amVar = amVar.bJ("page", this.page);
            }
            if (!StringUtils.isNull(this.iHq)) {
                amVar = amVar.bJ("locate", this.iHq);
            }
            if (!StringUtils.isNull(this.iHr)) {
                return amVar.bJ("task", this.iHr);
            }
            return amVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public am e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.gFb.bJ("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.gFb.bJ(VideoPlayActivityConfig.OBJ_ID, str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.gFb.bJ(ImageViewerConfig.FORUM_ID, str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.gFb.bJ(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.gFb.bJ("tid", str5);
            }
            this.gFb.T("obj_cpid", 0).T("obj_good_id", 0).bJ("obj_throw_type", "BY_POST").bJ("client_type", "MOBILE_APP").bJ("user_timestamp", String.valueOf(System.currentTimeMillis())).bJ("os", "android").bJ("os_version", Build.VERSION.RELEASE).bJ("log_ver", "1.1");
            return this.gFb;
        }

        public C0390a dX(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.gFb.bJ(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.gFb);
            if (!this.bzf) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.gFb.delete(str);
        }
    }
}
