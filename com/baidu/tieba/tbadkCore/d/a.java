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
        public String bsL;
        public String bsN;
        public int bxd;
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
            c0074a.cb("obj_ref", str6);
        }
        return c0074a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0074a c0074a = new C0074a("ad_tpoint", "PT", str, "c0122", "ad_plat", null);
        c0074a.e(str2, str7, str3, str4, str5);
        c0074a.cb("obj_url", str6);
        c0074a.save();
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
    public static class C0074a {
        private final String Ty;
        private final boolean WK;
        private final as dto;
        private final String fzb;
        private final String fzc;
        private final String key;
        private final String locate;

        private C0074a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.fzb = str2;
            this.Ty = str3;
            this.locate = str4;
            this.fzc = str5;
            this.WK = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.dto = bjF();
        }

        /* synthetic */ C0074a(String str, String str2, String str3, String str4, String str5, C0074a c0074a) {
            this(str, str2, str3, str4, str5);
        }

        private as bjF() {
            as asVar = new as(this.key);
            if (!StringUtils.isNull(this.fzb)) {
                asVar = asVar.aa("line", this.fzb);
            }
            if (!StringUtils.isNull(this.Ty)) {
                asVar = asVar.aa("page", this.Ty);
            }
            if (!StringUtils.isNull(this.locate)) {
                asVar = asVar.aa("locate", this.locate);
            }
            if (!StringUtils.isNull(this.fzc)) {
                return asVar.aa("task", this.fzc);
            }
            return asVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public as e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.dto.aa("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.dto.aa("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.dto.aa("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.dto.aa(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.dto.aa("tid", str5);
            }
            this.dto.s("obj_cpid", 0).s("obj_good_id", 0).aa("obj_throw_type", "BY_POST").aa("client_type", "MOBILE_APP").aa("user_timestamp", String.valueOf(System.currentTimeMillis())).aa("os", "android").aa("os_version", Build.VERSION.RELEASE).aa("log_ver", "1.1");
            return this.dto;
        }

        public C0074a cb(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.dto.aa(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.dto);
            if (!this.WK) {
                if (TbadkCoreApplication.m9getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.dto.delete(str);
        }
    }
}
