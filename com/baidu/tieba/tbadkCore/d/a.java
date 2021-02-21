package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public static class b {
        public String amC;
        public int iAs;
        public String mPid;
    }

    public static C0874a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0874a c0874a = new C0874a(str, str2, str3, str4, str5);
        c0874a.m(str6, str7, str8, str9, str10);
        return c0874a;
    }

    public static C0874a i(String str, String str2, String str3, String str4, String str5, String str6) {
        C0874a c0874a = new C0874a("ad_tpoint", "PT", str, str2, "tpoint");
        c0874a.m(null, null, str3, str4, str5);
        if (!au.isEmpty(str6)) {
            c0874a.gA("obj_ref", str6);
        }
        return c0874a;
    }

    @Deprecated
    public static void c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0874a c0874a = new C0874a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0874a.m(str2, str7, str3, str4, str5);
        c0874a.gA(TiebaInitialize.Params.OBJ_URL, str6);
        c0874a.save();
    }

    @Deprecated
    public static void gz(String str, String str2) {
        if (!au.isEmpty(str)) {
            ar arVar = new ar(str);
            if (str2 != null) {
                arVar = arVar.dR("obj_type", str2);
            }
            TiebaStatic.log(arVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0874a {
        private final String eOj;
        private final boolean isValid;
        private final String key;
        private final ar lag;
        private final String nyy;
        private final String nyz;
        private final String page;

        private C0874a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.nyy = str2;
            this.page = str3;
            this.eOj = str4;
            this.nyz = str5;
            this.isValid = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.lag = dNW();
        }

        private ar dNW() {
            ar arVar = new ar(this.key);
            if (!StringUtils.isNull(this.nyy)) {
                arVar = arVar.dR("line", this.nyy);
            }
            if (!StringUtils.isNull(this.page)) {
                arVar = arVar.dR("page", this.page);
            }
            if (!StringUtils.isNull(this.eOj)) {
                arVar = arVar.dR("locate", this.eOj);
            }
            if (!StringUtils.isNull(this.nyz)) {
                return arVar.dR("task", this.nyz);
            }
            return arVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ar m(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.lag.dR(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.lag.dR("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.lag.dR("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.lag.dR("fname", str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.lag.dR("tid", str5);
            }
            this.lag.ap("obj_cpid", 0).ap("obj_good_id", 0).dR("obj_throw_type", "BY_POST").dR("client_type", "MOBILE_APP").dR("user_timestamp", String.valueOf(System.currentTimeMillis())).dR("os", HttpConstants.OS_TYPE_VALUE).dR("os_version", Build.VERSION.RELEASE).dR("log_ver", "1.1");
            return this.lag;
        }

        public C0874a gA(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.lag.dR(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.lag);
            if (!this.isValid) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.lag.delete(str);
        }
    }
}
