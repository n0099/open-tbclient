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
        public int ekX;
        public String mPid;
    }

    public static C0309a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0309a c0309a = new C0309a(str, str2, str3, str4, str5);
        c0309a.e(str6, str7, str8, str9, str10);
        return c0309a;
    }

    public static C0309a f(String str, String str2, String str3, String str4, String str5, String str6) {
        C0309a c0309a = new C0309a("ad_tpoint", "PT", str, str2, "tpoint");
        c0309a.e(null, null, str3, str4, str5);
        if (!ap.isEmpty(str6)) {
            c0309a.dY("obj_ref", str6);
        }
        return c0309a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0309a c0309a = new C0309a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0309a.e(str2, str7, str3, str4, str5);
        c0309a.dY("obj_url", str6);
        c0309a.save();
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
    public static class C0309a {
        private final boolean bzd;
        private final am gFb;
        private final String iHx;
        private final String iHy;
        private final String key;
        private final String line;
        private final String page;

        private C0309a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.line = str2;
            this.page = str3;
            this.iHx = str4;
            this.iHy = str5;
            this.bzd = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.gFb = ceI();
        }

        private am ceI() {
            am amVar = new am(this.key);
            if (!StringUtils.isNull(this.line)) {
                amVar = amVar.bJ("line", this.line);
            }
            if (!StringUtils.isNull(this.page)) {
                amVar = amVar.bJ("page", this.page);
            }
            if (!StringUtils.isNull(this.iHx)) {
                amVar = amVar.bJ("locate", this.iHx);
            }
            if (!StringUtils.isNull(this.iHy)) {
                return amVar.bJ("task", this.iHy);
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

        public C0309a dY(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.gFb.bJ(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.gFb);
            if (!this.bzd) {
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
