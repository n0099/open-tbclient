package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.constants.HttpConstants;
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
        public String anD;
        public int izb;
        public String mPid;
    }

    public static C0886a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0886a c0886a = new C0886a(str, str2, str3, str4, str5);
        c0886a.m(str6, str7, str8, str9, str10);
        return c0886a;
    }

    public static C0886a i(String str, String str2, String str3, String str4, String str5, String str6) {
        C0886a c0886a = new C0886a("ad_tpoint", "PT", str, str2, "tpoint");
        c0886a.m(null, null, str3, str4, str5);
        if (!at.isEmpty(str6)) {
            c0886a.gt("obj_ref", str6);
        }
        return c0886a;
    }

    @Deprecated
    public static void c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0886a c0886a = new C0886a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0886a.m(str2, str7, str3, str4, str5);
        c0886a.gt(TiebaInitialize.Params.OBJ_URL, str6);
        c0886a.save();
    }

    @Deprecated
    public static void gs(String str, String str2) {
        if (!at.isEmpty(str)) {
            aq aqVar = new aq(str);
            if (str2 != null) {
                aqVar = aqVar.dX("obj_type", str2);
            }
            TiebaStatic.log(aqVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0886a {
        private final boolean eQz;
        private final aq kWv;
        private final String key;
        private final String nsS;
        private final String nsT;
        private final String nsU;
        private final String page;

        private C0886a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.nsS = str2;
            this.page = str3;
            this.nsT = str4;
            this.nsU = str5;
            this.eQz = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.kWv = dPv();
        }

        private aq dPv() {
            aq aqVar = new aq(this.key);
            if (!StringUtils.isNull(this.nsS)) {
                aqVar = aqVar.dX("line", this.nsS);
            }
            if (!StringUtils.isNull(this.page)) {
                aqVar = aqVar.dX("page", this.page);
            }
            if (!StringUtils.isNull(this.nsT)) {
                aqVar = aqVar.dX("locate", this.nsT);
            }
            if (!StringUtils.isNull(this.nsU)) {
                return aqVar.dX("task", this.nsU);
            }
            return aqVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public aq m(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.kWv.dX(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.kWv.dX("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.kWv.dX("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.kWv.dX("fname", str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.kWv.dX("tid", str5);
            }
            this.kWv.an("obj_cpid", 0).an("obj_good_id", 0).dX("obj_throw_type", "BY_POST").dX("client_type", "MOBILE_APP").dX("user_timestamp", String.valueOf(System.currentTimeMillis())).dX("os", HttpConstants.OS_TYPE_VALUE).dX("os_version", Build.VERSION.RELEASE).dX("log_ver", "1.1");
            return this.kWv;
        }

        public C0886a gt(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.kWv.dX(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.kWv);
            if (!this.eQz) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.kWv.delete(str);
        }
    }
}
