package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public static class b {
        public String aWq;
        public int cBI;
        public String mPid;
    }

    public static C0236a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0236a c0236a = new C0236a(str, str2, str3, str4, str5);
        c0236a.e(str6, str7, str8, str9, str10);
        return c0236a;
    }

    public static C0236a d(String str, String str2, String str3, String str4, String str5, String str6) {
        C0236a c0236a = new C0236a("ad_tpoint", "PT", str, str2, "tpoint");
        c0236a.e(null, null, str3, str4, str5);
        if (!ap.isEmpty(str6)) {
            c0236a.cm("obj_ref", str6);
        }
        return c0236a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0236a c0236a = new C0236a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0236a.e(str2, str7, str3, str4, str5);
        c0236a.cm("obj_url", str6);
        c0236a.save();
    }

    @Deprecated
    public static void cl(String str, String str2) {
        if (!ap.isEmpty(str)) {
            an anVar = new an(str);
            if (str2 != null) {
                anVar = anVar.ae("obj_type", str2);
            }
            TiebaStatic.log(anVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0236a {
        private final boolean agc;
        private final an eNU;
        private final String gPd;
        private final String gPe;
        private final String key;
        private final String line;
        private final String page;

        private C0236a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.line = str2;
            this.page = str3;
            this.gPd = str4;
            this.gPe = str5;
            this.agc = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.eNU = bwz();
        }

        private an bwz() {
            an anVar = new an(this.key);
            if (!StringUtils.isNull(this.line)) {
                anVar = anVar.ae("line", this.line);
            }
            if (!StringUtils.isNull(this.page)) {
                anVar = anVar.ae("page", this.page);
            }
            if (!StringUtils.isNull(this.gPd)) {
                anVar = anVar.ae("locate", this.gPd);
            }
            if (!StringUtils.isNull(this.gPe)) {
                return anVar.ae("task", this.gPe);
            }
            return anVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public an e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.eNU.ae(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.eNU.ae(VideoPlayActivityConfig.OBJ_ID, str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.eNU.ae(ImageViewerConfig.FORUM_ID, str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.eNU.ae(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.eNU.ae("tid", str5);
            }
            this.eNU.r("obj_cpid", 0).r("obj_good_id", 0).ae("obj_throw_type", "BY_POST").ae("client_type", "MOBILE_APP").ae("user_timestamp", String.valueOf(System.currentTimeMillis())).ae("os", HttpConstants.OS_TYPE_VALUE).ae(StatisticConstants.OS_VERSION, Build.VERSION.RELEASE).ae("log_ver", "1.1");
            return this.eNU;
        }

        public C0236a cm(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.eNU.ae(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.eNU);
            if (!this.agc) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.eNU.delete(str);
        }
    }
}
