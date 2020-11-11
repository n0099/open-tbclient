package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public static class b {
        public String alT;
        public int iaT;
        public String mPid;
    }

    public static C0853a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0853a c0853a = new C0853a(str, str2, str3, str4, str5);
        c0853a.m(str6, str7, str8, str9, str10);
        return c0853a;
    }

    public static C0853a g(String str, String str2, String str3, String str4, String str5, String str6) {
        C0853a c0853a = new C0853a("ad_tpoint", "PT", str, str2, "tpoint");
        c0853a.m(null, null, str3, str4, str5);
        if (!at.isEmpty(str6)) {
            c0853a.gr("obj_ref", str6);
        }
        return c0853a;
    }

    @Deprecated
    public static void c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0853a c0853a = new C0853a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0853a.m(str2, str7, str3, str4, str5);
        c0853a.gr(TiebaInitialize.Params.OBJ_URL, str6);
        c0853a.save();
    }

    @Deprecated
    public static void gq(String str, String str2) {
        if (!at.isEmpty(str)) {
            aq aqVar = new aq(str);
            if (str2 != null) {
                aqVar = aqVar.dR("obj_type", str2);
            }
            TiebaStatic.log(aqVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0853a {
        private final boolean eBt;
        private final aq kDh;
        private final String key;
        private final String mYn;
        private final String mYo;
        private final String mYp;
        private final String page;

        private C0853a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.mYn = str2;
            this.page = str3;
            this.mYo = str4;
            this.mYp = str5;
            this.eBt = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.kDh = dKq();
        }

        private aq dKq() {
            aq aqVar = new aq(this.key);
            if (!StringUtils.isNull(this.mYn)) {
                aqVar = aqVar.dR("line", this.mYn);
            }
            if (!StringUtils.isNull(this.page)) {
                aqVar = aqVar.dR("page", this.page);
            }
            if (!StringUtils.isNull(this.mYo)) {
                aqVar = aqVar.dR("locate", this.mYo);
            }
            if (!StringUtils.isNull(this.mYp)) {
                return aqVar.dR("task", this.mYp);
            }
            return aqVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public aq m(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.kDh.dR(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.kDh.dR("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.kDh.dR("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.kDh.dR("fname", str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.kDh.dR("tid", str5);
            }
            this.kDh.al("obj_cpid", 0).al("obj_good_id", 0).dR("obj_throw_type", "BY_POST").dR("client_type", "MOBILE_APP").dR("user_timestamp", String.valueOf(System.currentTimeMillis())).dR("os", "android").dR("os_version", Build.VERSION.RELEASE).dR("log_ver", "1.1");
            return this.kDh;
        }

        public C0853a gr(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.kDh.dR(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.kDh);
            if (!this.eBt) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.kDh.delete(str);
        }
    }
}
