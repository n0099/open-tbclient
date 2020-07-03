package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public static class b {
        public String ajO;
        public int gUb;
        public String mPid;
    }

    public static C0745a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0745a c0745a = new C0745a(str, str2, str3, str4, str5);
        c0745a.k(str6, str7, str8, str9, str10);
        return c0745a;
    }

    public static C0745a d(String str, String str2, String str3, String str4, String str5, String str6) {
        C0745a c0745a = new C0745a("ad_tpoint", "PT", str, str2, "tpoint");
        c0745a.k(null, null, str3, str4, str5);
        if (!ar.isEmpty(str6)) {
            c0745a.fz("obj_ref", str6);
        }
        return c0745a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0745a c0745a = new C0745a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0745a.k(str2, str7, str3, str4, str5);
        c0745a.fz(TiebaInitialize.Params.OBJ_URL, str6);
        c0745a.save();
    }

    @Deprecated
    public static void fy(String str, String str2) {
        if (!ar.isEmpty(str)) {
            ao aoVar = new ao(str);
            if (str2 != null) {
                aoVar = aoVar.dk("obj_type", str2);
            }
            TiebaStatic.log(aoVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0745a {
        private final boolean dJg;
        private final ao joP;
        private final String key;
        private final String lHi;
        private final String lHj;
        private final String lHk;
        private final String page;

        private C0745a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.lHi = str2;
            this.page = str3;
            this.lHj = str4;
            this.lHk = str5;
            this.dJg = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.joP = dip();
        }

        private ao dip() {
            ao aoVar = new ao(this.key);
            if (!StringUtils.isNull(this.lHi)) {
                aoVar = aoVar.dk("line", this.lHi);
            }
            if (!StringUtils.isNull(this.page)) {
                aoVar = aoVar.dk("page", this.page);
            }
            if (!StringUtils.isNull(this.lHj)) {
                aoVar = aoVar.dk("locate", this.lHj);
            }
            if (!StringUtils.isNull(this.lHk)) {
                return aoVar.dk("task", this.lHk);
            }
            return aoVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ao k(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.joP.dk(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.joP.dk("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.joP.dk("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.joP.dk("fname", str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.joP.dk("tid", str5);
            }
            this.joP.ag("obj_cpid", 0).ag("obj_good_id", 0).dk("obj_throw_type", "BY_POST").dk("client_type", "MOBILE_APP").dk("user_timestamp", String.valueOf(System.currentTimeMillis())).dk("os", "android").dk("os_version", Build.VERSION.RELEASE).dk("log_ver", "1.1");
            return this.joP;
        }

        public C0745a fz(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.joP.dk(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.joP);
            if (!this.dJg) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.joP.delete(str);
        }
    }
}
