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
        public int hUW;
        public String mPid;
    }

    public static C0838a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0838a c0838a = new C0838a(str, str2, str3, str4, str5);
        c0838a.m(str6, str7, str8, str9, str10);
        return c0838a;
    }

    public static C0838a g(String str, String str2, String str3, String str4, String str5, String str6) {
        C0838a c0838a = new C0838a("ad_tpoint", "PT", str, str2, "tpoint");
        c0838a.m(null, null, str3, str4, str5);
        if (!at.isEmpty(str6)) {
            c0838a.gr("obj_ref", str6);
        }
        return c0838a;
    }

    @Deprecated
    public static void c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0838a c0838a = new C0838a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0838a.m(str2, str7, str3, str4, str5);
        c0838a.gr(TiebaInitialize.Params.OBJ_URL, str6);
        c0838a.save();
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
    public static class C0838a {
        private final boolean evA;
        private final String key;
        private final aq kxm;
        private final String mSk;
        private final String mSl;
        private final String mSm;
        private final String page;

        private C0838a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.mSk = str2;
            this.page = str3;
            this.mSl = str4;
            this.mSm = str5;
            this.evA = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.kxm = dHO();
        }

        private aq dHO() {
            aq aqVar = new aq(this.key);
            if (!StringUtils.isNull(this.mSk)) {
                aqVar = aqVar.dR("line", this.mSk);
            }
            if (!StringUtils.isNull(this.page)) {
                aqVar = aqVar.dR("page", this.page);
            }
            if (!StringUtils.isNull(this.mSl)) {
                aqVar = aqVar.dR("locate", this.mSl);
            }
            if (!StringUtils.isNull(this.mSm)) {
                return aqVar.dR("task", this.mSm);
            }
            return aqVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public aq m(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.kxm.dR(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.kxm.dR("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.kxm.dR("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.kxm.dR("fname", str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.kxm.dR("tid", str5);
            }
            this.kxm.aj("obj_cpid", 0).aj("obj_good_id", 0).dR("obj_throw_type", "BY_POST").dR("client_type", "MOBILE_APP").dR("user_timestamp", String.valueOf(System.currentTimeMillis())).dR("os", "android").dR("os_version", Build.VERSION.RELEASE).dR("log_ver", "1.1");
            return this.kxm;
        }

        public C0838a gr(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.kxm.dR(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.kxm);
            if (!this.evA) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.kxm.delete(str);
        }
    }
}
