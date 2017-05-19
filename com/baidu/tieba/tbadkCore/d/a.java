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
        public String bti;
        public String btk;
        public int bxb;
    }

    public static C0080a a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0080a c0080a = new C0080a(str, str2, str3, str4, str5, null);
        c0080a.e(str6, str7, str8, str9, str10);
        return c0080a;
    }

    public static C0080a d(String str, String str2, String str3, String str4, String str5, String str6) {
        C0080a c0080a = new C0080a("ad_tpoint", "PT", str, str2, "tpoint", null);
        c0080a.e(null, null, str3, str4, str5);
        if (!au.isEmpty(str6)) {
            c0080a.cb("obj_ref", str6);
        }
        return c0080a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0080a c0080a = new C0080a("ad_tpoint", "PT", str, "c0122", "ad_plat", null);
        c0080a.e(str2, str7, str3, str4, str5);
        c0080a.cb("obj_url", str6);
        c0080a.save();
    }

    @Deprecated
    public static void ca(String str, String str2) {
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
    public static class C0080a {
        private final String SR;
        private final boolean Wb;
        private final as dnw;
        private final String fvj;
        private final String fvk;
        private final String key;
        private final String locate;

        private C0080a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.fvj = str2;
            this.SR = str3;
            this.locate = str4;
            this.fvk = str5;
            this.Wb = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.dnw = bhc();
        }

        /* synthetic */ C0080a(String str, String str2, String str3, String str4, String str5, C0080a c0080a) {
            this(str, str2, str3, str4, str5);
        }

        private as bhc() {
            as asVar = new as(this.key);
            if (!StringUtils.isNull(this.fvj)) {
                asVar = asVar.aa("line", this.fvj);
            }
            if (!StringUtils.isNull(this.SR)) {
                asVar = asVar.aa("page", this.SR);
            }
            if (!StringUtils.isNull(this.locate)) {
                asVar = asVar.aa("locate", this.locate);
            }
            if (!StringUtils.isNull(this.fvk)) {
                return asVar.aa("task", this.fvk);
            }
            return asVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public as e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.dnw.aa("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.dnw.aa("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.dnw.aa("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.dnw.aa(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.dnw.aa("tid", str5);
            }
            this.dnw.s("obj_cpid", 0).s("obj_good_id", 0).aa("obj_throw_type", "BY_POST").aa("client_type", "MOBILE_APP").aa("user_timestamp", String.valueOf(System.currentTimeMillis())).aa("os", "android").aa("os_version", Build.VERSION.RELEASE).aa("log_ver", "1.1");
            return this.dnw;
        }

        public C0080a cb(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.dnw.aa(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.dnw);
            if (!this.Wb) {
                if (TbadkCoreApplication.m9getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.dnw.delete(str);
        }
    }
}
