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
/* loaded from: classes2.dex */
public class a {

    /* loaded from: classes2.dex */
    public static class b {
        public String akY;
        public int hmy;
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
            c0808a.fS("obj_ref", str6);
        }
        return c0808a;
    }

    @Deprecated
    public static void c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0808a c0808a = new C0808a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0808a.m(str2, str7, str3, str4, str5);
        c0808a.fS(TiebaInitialize.Params.OBJ_URL, str6);
        c0808a.save();
    }

    @Deprecated
    public static void fR(String str, String str2) {
        if (!at.isEmpty(str)) {
            aq aqVar = new aq(str);
            if (str2 != null) {
                aqVar = aqVar.dD("obj_type", str2);
            }
            TiebaStatic.log(aqVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0808a {
        private final boolean dYK;
        private final aq jMQ;
        private final String key;
        private final String mgi;
        private final String mgj;
        private final String mgk;
        private final String page;

        private C0808a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.mgi = str2;
            this.page = str3;
            this.mgj = str4;
            this.mgk = str5;
            this.dYK = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.jMQ = dwW();
        }

        private aq dwW() {
            aq aqVar = new aq(this.key);
            if (!StringUtils.isNull(this.mgi)) {
                aqVar = aqVar.dD("line", this.mgi);
            }
            if (!StringUtils.isNull(this.page)) {
                aqVar = aqVar.dD("page", this.page);
            }
            if (!StringUtils.isNull(this.mgj)) {
                aqVar = aqVar.dD("locate", this.mgj);
            }
            if (!StringUtils.isNull(this.mgk)) {
                return aqVar.dD("task", this.mgk);
            }
            return aqVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public aq m(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.jMQ.dD(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.jMQ.dD("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.jMQ.dD("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.jMQ.dD("fname", str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.jMQ.dD("tid", str5);
            }
            this.jMQ.ai("obj_cpid", 0).ai("obj_good_id", 0).dD("obj_throw_type", "BY_POST").dD("client_type", "MOBILE_APP").dD("user_timestamp", String.valueOf(System.currentTimeMillis())).dD("os", "android").dD("os_version", Build.VERSION.RELEASE).dD("log_ver", "1.1");
            return this.jMQ;
        }

        public C0808a fS(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.jMQ.dD(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.jMQ);
            if (!this.dYK) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.jMQ.delete(str);
        }
    }
}
