package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public static class b {
        public String aZG;
        public int cHA;
        public String mPid;
    }

    public static C0242a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0242a c0242a = new C0242a(str, str2, str3, str4, str5);
        c0242a.e(str6, str7, str8, str9, str10);
        return c0242a;
    }

    public static C0242a f(String str, String str2, String str3, String str4, String str5, String str6) {
        C0242a c0242a = new C0242a("ad_tpoint", "PT", str, str2, "tpoint");
        c0242a.e(null, null, str3, str4, str5);
        if (!ao.isEmpty(str6)) {
            c0242a.cw("obj_ref", str6);
        }
        return c0242a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0242a c0242a = new C0242a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0242a.e(str2, str7, str3, str4, str5);
        c0242a.cw("obj_url", str6);
        c0242a.save();
    }

    @Deprecated
    public static void cv(String str, String str2) {
        if (!ao.isEmpty(str)) {
            am amVar = new am(str);
            if (str2 != null) {
                amVar = amVar.al("obj_type", str2);
            }
            TiebaStatic.log(amVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0242a {
        private final boolean aiD;
        private final am eVp;
        private final String gWI;
        private final String gWJ;
        private final String key;
        private final String line;
        private final String page;

        private C0242a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.line = str2;
            this.page = str3;
            this.gWI = str4;
            this.gWJ = str5;
            this.aiD = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.eVp = bzd();
        }

        private am bzd() {
            am amVar = new am(this.key);
            if (!StringUtils.isNull(this.line)) {
                amVar = amVar.al("line", this.line);
            }
            if (!StringUtils.isNull(this.page)) {
                amVar = amVar.al("page", this.page);
            }
            if (!StringUtils.isNull(this.gWI)) {
                amVar = amVar.al("locate", this.gWI);
            }
            if (!StringUtils.isNull(this.gWJ)) {
                return amVar.al("task", this.gWJ);
            }
            return amVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public am e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.eVp.al(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.eVp.al(VideoPlayActivityConfig.OBJ_ID, str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.eVp.al(ImageViewerConfig.FORUM_ID, str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.eVp.al(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.eVp.al("tid", str5);
            }
            this.eVp.w("obj_cpid", 0).w("obj_good_id", 0).al("obj_throw_type", "BY_POST").al("client_type", "MOBILE_APP").al("user_timestamp", String.valueOf(System.currentTimeMillis())).al("os", HttpConstants.OS_TYPE_VALUE).al(StatisticConstants.OS_VERSION, Build.VERSION.RELEASE).al("log_ver", "1.1");
            return this.eVp;
        }

        public C0242a cw(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.eVp.al(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.eVp);
            if (!this.aiD) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.eVp.delete(str);
        }
    }
}
