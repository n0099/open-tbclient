package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public static class b {
        public String bqB;
        public String bqD;
        public int buU;
    }

    public static C0075a a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0075a c0075a = new C0075a(str, str2, str3, str4, str5, null);
        c0075a.d(str6, str7, str8, str9, str10);
        return c0075a;
    }

    public static C0075a d(String str, String str2, String str3, String str4, String str5, String str6) {
        C0075a c0075a = new C0075a("ad_tpoint", "PT", str, str2, "tpoint", null);
        c0075a.d(null, null, str3, str4, str5);
        if (!au.isEmpty(str6)) {
            c0075a.cb("obj_ref", str6);
        }
        return c0075a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0075a c0075a = new C0075a("ad_tpoint", "PT", str, "c0122", "ad_plat", null);
        c0075a.d(str2, str7, str3, str4, str5);
        c0075a.cb("obj_url", str6);
        c0075a.save();
    }

    @Deprecated
    public static void ca(String str, String str2) {
        if (!au.isEmpty(str)) {
            as asVar = new as(str);
            if (str2 != null) {
                asVar = asVar.Z("obj_type", str2);
            }
            TiebaStatic.log(asVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0075a {
        private final String Te;
        private final boolean Wu;
        private final as dtj;
        private final String fvb;
        private final String fvc;
        private final String key;
        private final String locate;

        private C0075a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.fvb = str2;
            this.Te = str3;
            this.locate = str4;
            this.fvc = str5;
            this.Wu = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.dtj = bhT();
        }

        /* synthetic */ C0075a(String str, String str2, String str3, String str4, String str5, C0075a c0075a) {
            this(str, str2, str3, str4, str5);
        }

        private as bhT() {
            as asVar = new as(this.key);
            if (!StringUtils.isNull(this.fvb)) {
                asVar = asVar.Z("line", this.fvb);
            }
            if (!StringUtils.isNull(this.Te)) {
                asVar = asVar.Z("page", this.Te);
            }
            if (!StringUtils.isNull(this.locate)) {
                asVar = asVar.Z("locate", this.locate);
            }
            if (!StringUtils.isNull(this.fvc)) {
                return asVar.Z("task", this.fvc);
            }
            return asVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public as d(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.dtj.Z("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.dtj.Z("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.dtj.Z("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.dtj.Z(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.dtj.Z("tid", str5);
            }
            this.dtj.s("obj_cpid", 0).s("obj_good_id", 0).Z("obj_throw_type", "BY_POST").Z(SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP").Z("user_timestamp", String.valueOf(System.currentTimeMillis())).Z("os", SocialConstants.ANDROID_CLIENT_TYPE).Z("os_version", Build.VERSION.RELEASE).Z("log_ver", "1.1");
            return this.dtj;
        }

        public C0075a cb(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.dtj.Z(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.dtj);
            if (!this.Wu) {
                if (TbadkCoreApplication.m9getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        /* renamed from: do  reason: not valid java name */
        public void m19do(String str) {
            this.dtj.m11do(str);
        }
    }
}
