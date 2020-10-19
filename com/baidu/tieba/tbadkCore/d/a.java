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
        public String alS;
        public int hIz;
        public String mPid;
    }

    public static C0823a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0823a c0823a = new C0823a(str, str2, str3, str4, str5);
        c0823a.m(str6, str7, str8, str9, str10);
        return c0823a;
    }

    public static C0823a f(String str, String str2, String str3, String str4, String str5, String str6) {
        C0823a c0823a = new C0823a("ad_tpoint", "PT", str, str2, "tpoint");
        c0823a.m(null, null, str3, str4, str5);
        if (!at.isEmpty(str6)) {
            c0823a.gm("obj_ref", str6);
        }
        return c0823a;
    }

    @Deprecated
    public static void c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0823a c0823a = new C0823a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0823a.m(str2, str7, str3, str4, str5);
        c0823a.gm(TiebaInitialize.Params.OBJ_URL, str6);
        c0823a.save();
    }

    @Deprecated
    public static void gl(String str, String str2) {
        if (!at.isEmpty(str)) {
            aq aqVar = new aq(str);
            if (str2 != null) {
                aqVar = aqVar.dK("obj_type", str2);
            }
            TiebaStatic.log(aqVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0823a {
        private final boolean ena;
        private final String key;
        private final aq kkP;
        private final String mFE;
        private final String mFF;
        private final String mFG;
        private final String page;

        private C0823a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.mFE = str2;
            this.page = str3;
            this.mFF = str4;
            this.mFG = str5;
            this.ena = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.kkP = dEG();
        }

        private aq dEG() {
            aq aqVar = new aq(this.key);
            if (!StringUtils.isNull(this.mFE)) {
                aqVar = aqVar.dK("line", this.mFE);
            }
            if (!StringUtils.isNull(this.page)) {
                aqVar = aqVar.dK("page", this.page);
            }
            if (!StringUtils.isNull(this.mFF)) {
                aqVar = aqVar.dK("locate", this.mFF);
            }
            if (!StringUtils.isNull(this.mFG)) {
                return aqVar.dK("task", this.mFG);
            }
            return aqVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public aq m(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.kkP.dK(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.kkP.dK("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.kkP.dK("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.kkP.dK("fname", str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.kkP.dK("tid", str5);
            }
            this.kkP.aj("obj_cpid", 0).aj("obj_good_id", 0).dK("obj_throw_type", "BY_POST").dK("client_type", "MOBILE_APP").dK("user_timestamp", String.valueOf(System.currentTimeMillis())).dK("os", "android").dK("os_version", Build.VERSION.RELEASE).dK("log_ver", "1.1");
            return this.kkP;
        }

        public C0823a gm(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.kkP.dK(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.kkP);
            if (!this.ena) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.kkP.delete(str);
        }
    }
}
