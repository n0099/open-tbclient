package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public static class b {
        public int bCY;
        public String buq;
        public String mPid;
    }

    public static C0082a a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0082a c0082a = new C0082a(str, str2, str3, str4, str5, null);
        c0082a.e(str6, str7, str8, str9, str10);
        return c0082a;
    }

    public static C0082a d(String str, String str2, String str3, String str4, String str5, String str6) {
        C0082a c0082a = new C0082a("ad_tpoint", "PT", str, str2, "tpoint", null);
        c0082a.e(null, null, str3, str4, str5);
        if (!au.isEmpty(str6)) {
            c0082a.cb("obj_ref", str6);
        }
        return c0082a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0082a c0082a = new C0082a("ad_tpoint", "PT", str, "c0122", "ad_plat", null);
        c0082a.e(str2, str7, str3, str4, str5);
        c0082a.cb("obj_url", str6);
        c0082a.save();
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
    public static class C0082a {
        private final String SE;
        private final boolean VP;
        private final as dsQ;
        private final String fDb;
        private final String fDc;
        private final String key;
        private final String locate;

        private C0082a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.fDb = str2;
            this.SE = str3;
            this.locate = str4;
            this.fDc = str5;
            this.VP = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.dsQ = biw();
        }

        /* synthetic */ C0082a(String str, String str2, String str3, String str4, String str5, C0082a c0082a) {
            this(str, str2, str3, str4, str5);
        }

        private as biw() {
            as asVar = new as(this.key);
            if (!StringUtils.isNull(this.fDb)) {
                asVar = asVar.Z("line", this.fDb);
            }
            if (!StringUtils.isNull(this.SE)) {
                asVar = asVar.Z("page", this.SE);
            }
            if (!StringUtils.isNull(this.locate)) {
                asVar = asVar.Z("locate", this.locate);
            }
            if (!StringUtils.isNull(this.fDc)) {
                return asVar.Z("task", this.fDc);
            }
            return asVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public as e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.dsQ.Z("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.dsQ.Z("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.dsQ.Z("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.dsQ.Z(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.dsQ.Z("tid", str5);
            }
            this.dsQ.r("obj_cpid", 0).r("obj_good_id", 0).Z("obj_throw_type", "BY_POST").Z("client_type", "MOBILE_APP").Z("user_timestamp", String.valueOf(System.currentTimeMillis())).Z("os", "android").Z("os_version", Build.VERSION.RELEASE).Z("log_ver", "1.1");
            return this.dsQ;
        }

        public C0082a cb(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.dsQ.Z(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.dsQ);
            if (!this.VP) {
                if (TbadkCoreApplication.m9getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.dsQ.delete(str);
        }
    }
}
