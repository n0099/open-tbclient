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
        public String bqu;
        public String bqw;
        public int buM;
    }

    public static C0074a a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0074a c0074a = new C0074a(str, str2, str3, str4, str5, null);
        c0074a.e(str6, str7, str8, str9, str10);
        return c0074a;
    }

    public static C0074a d(String str, String str2, String str3, String str4, String str5, String str6) {
        C0074a c0074a = new C0074a("ad_tpoint", "PT", str, str2, "tpoint", null);
        c0074a.e(null, null, str3, str4, str5);
        if (!au.isEmpty(str6)) {
            c0074a.cc("obj_ref", str6);
        }
        return c0074a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0074a c0074a = new C0074a("ad_tpoint", "PT", str, "c0122", "ad_plat", null);
        c0074a.e(str2, str7, str3, str4, str5);
        c0074a.cc("obj_url", str6);
        c0074a.save();
    }

    @Deprecated
    public static void cb(String str, String str2) {
        if (!au.isEmpty(str)) {
            as asVar = new as(str);
            if (str2 != null) {
                asVar = asVar.aa("obj_type", str2);
            }
            TiebaStatic.log(asVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0074a {
        private final String Tw;
        private final boolean WJ;
        private final as dqX;
        private final String fwK;
        private final String fwL;
        private final String key;
        private final String locate;

        private C0074a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.fwK = str2;
            this.Tw = str3;
            this.locate = str4;
            this.fwL = str5;
            this.WJ = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.dqX = biE();
        }

        /* synthetic */ C0074a(String str, String str2, String str3, String str4, String str5, C0074a c0074a) {
            this(str, str2, str3, str4, str5);
        }

        private as biE() {
            as asVar = new as(this.key);
            if (!StringUtils.isNull(this.fwK)) {
                asVar = asVar.aa("line", this.fwK);
            }
            if (!StringUtils.isNull(this.Tw)) {
                asVar = asVar.aa("page", this.Tw);
            }
            if (!StringUtils.isNull(this.locate)) {
                asVar = asVar.aa("locate", this.locate);
            }
            if (!StringUtils.isNull(this.fwL)) {
                return asVar.aa("task", this.fwL);
            }
            return asVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public as e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.dqX.aa("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.dqX.aa("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.dqX.aa("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.dqX.aa(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.dqX.aa("tid", str5);
            }
            this.dqX.s("obj_cpid", 0).s("obj_good_id", 0).aa("obj_throw_type", "BY_POST").aa("client_type", "MOBILE_APP").aa("user_timestamp", String.valueOf(System.currentTimeMillis())).aa("os", "android").aa("os_version", Build.VERSION.RELEASE).aa("log_ver", "1.1");
            return this.dqX;
        }

        public C0074a cc(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.dqX.aa(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.dqX);
            if (!this.WJ) {
                if (TbadkCoreApplication.m9getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.dqX.delete(str);
        }
    }
}
