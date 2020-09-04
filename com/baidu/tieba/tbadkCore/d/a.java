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
        public String ala;
        public int hmC;
        public String mPid;
    }

    public static C0808a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0808a c0808a = new C0808a(str, str2, str3, str4, str5);
        c0808a.m(str6, str7, str8, str9, str10);
        return c0808a;
    }

    public static C0808a f(String str, String str2, String str3, String str4, String str5, String str6) {
        C0808a c0808a = new C0808a("ad_tpoint", "PT", str, str2, "tpoint");
        c0808a.m(null, null, str3, str4, str5);
        if (!at.isEmpty(str6)) {
            c0808a.fT("obj_ref", str6);
        }
        return c0808a;
    }

    @Deprecated
    public static void c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0808a c0808a = new C0808a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0808a.m(str2, str7, str3, str4, str5);
        c0808a.fT(TiebaInitialize.Params.OBJ_URL, str6);
        c0808a.save();
    }

    @Deprecated
    public static void fS(String str, String str2) {
        if (!at.isEmpty(str)) {
            aq aqVar = new aq(str);
            if (str2 != null) {
                aqVar = aqVar.dD("obj_type", str2);
            }
            TiebaStatic.log(aqVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0808a {
        private final boolean dYO;
        private final aq jMW;
        private final String key;
        private final String mgx;
        private final String mgy;
        private final String mgz;
        private final String page;

        private C0808a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.mgx = str2;
            this.page = str3;
            this.mgy = str4;
            this.mgz = str5;
            this.dYO = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.jMW = dxb();
        }

        private aq dxb() {
            aq aqVar = new aq(this.key);
            if (!StringUtils.isNull(this.mgx)) {
                aqVar = aqVar.dD("line", this.mgx);
            }
            if (!StringUtils.isNull(this.page)) {
                aqVar = aqVar.dD("page", this.page);
            }
            if (!StringUtils.isNull(this.mgy)) {
                aqVar = aqVar.dD("locate", this.mgy);
            }
            if (!StringUtils.isNull(this.mgz)) {
                return aqVar.dD("task", this.mgz);
            }
            return aqVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public aq m(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.jMW.dD(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.jMW.dD("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.jMW.dD("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.jMW.dD("fname", str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.jMW.dD("tid", str5);
            }
            this.jMW.ai("obj_cpid", 0).ai("obj_good_id", 0).dD("obj_throw_type", "BY_POST").dD("client_type", "MOBILE_APP").dD("user_timestamp", String.valueOf(System.currentTimeMillis())).dD("os", "android").dD("os_version", Build.VERSION.RELEASE).dD("log_ver", "1.1");
            return this.jMW;
        }

        public C0808a fT(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.jMW.dD(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.jMW);
            if (!this.dYO) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.jMW.delete(str);
        }
    }
}
