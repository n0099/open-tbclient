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
        public String amM;
        public int iuu;
        public String mPid;
    }

    public static C0869a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0869a c0869a = new C0869a(str, str2, str3, str4, str5);
        c0869a.m(str6, str7, str8, str9, str10);
        return c0869a;
    }

    public static C0869a i(String str, String str2, String str3, String str4, String str5, String str6) {
        C0869a c0869a = new C0869a("ad_tpoint", "PT", str, str2, "tpoint");
        c0869a.m(null, null, str3, str4, str5);
        if (!at.isEmpty(str6)) {
            c0869a.gs("obj_ref", str6);
        }
        return c0869a;
    }

    @Deprecated
    public static void c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0869a c0869a = new C0869a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0869a.m(str2, str7, str3, str4, str5);
        c0869a.gs(TiebaInitialize.Params.OBJ_URL, str6);
        c0869a.save();
    }

    @Deprecated
    public static void gr(String str, String str2) {
        if (!at.isEmpty(str)) {
            aq aqVar = new aq(str);
            if (str2 != null) {
                aqVar = aqVar.dW("obj_type", str2);
            }
            TiebaStatic.log(aqVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0869a {
        private final boolean eLO;
        private final aq kRQ;
        private final String key;
        private final String nom;
        private final String non;
        private final String noo;
        private final String page;

        private C0869a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.nom = str2;
            this.page = str3;
            this.non = str4;
            this.noo = str5;
            this.eLO = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.kRQ = dLD();
        }

        private aq dLD() {
            aq aqVar = new aq(this.key);
            if (!StringUtils.isNull(this.nom)) {
                aqVar = aqVar.dW("line", this.nom);
            }
            if (!StringUtils.isNull(this.page)) {
                aqVar = aqVar.dW("page", this.page);
            }
            if (!StringUtils.isNull(this.non)) {
                aqVar = aqVar.dW("locate", this.non);
            }
            if (!StringUtils.isNull(this.noo)) {
                return aqVar.dW("task", this.noo);
            }
            return aqVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public aq m(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.kRQ.dW(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.kRQ.dW("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.kRQ.dW("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.kRQ.dW("fname", str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.kRQ.dW("tid", str5);
            }
            this.kRQ.an("obj_cpid", 0).an("obj_good_id", 0).dW("obj_throw_type", "BY_POST").dW("client_type", "MOBILE_APP").dW("user_timestamp", String.valueOf(System.currentTimeMillis())).dW("os", HttpConstants.OS_TYPE_VALUE).dW("os_version", Build.VERSION.RELEASE).dW("log_ver", "1.1");
            return this.kRQ;
        }

        public C0869a gs(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.kRQ.dW(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.kRQ);
            if (!this.eLO) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.kRQ.delete(str);
        }
    }
}
