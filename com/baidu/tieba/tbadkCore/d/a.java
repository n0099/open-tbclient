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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.sina.weibo.sdk.constant.WBPageConstants;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public static class b {
        public String aVt;
        public int cBm;
        public String mPid;
    }

    public static C0234a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0234a c0234a = new C0234a(str, str2, str3, str4, str5);
        c0234a.e(str6, str7, str8, str9, str10);
        return c0234a;
    }

    public static C0234a d(String str, String str2, String str3, String str4, String str5, String str6) {
        C0234a c0234a = new C0234a("ad_tpoint", "PT", str, str2, "tpoint");
        c0234a.e(null, null, str3, str4, str5);
        if (!ao.isEmpty(str6)) {
            c0234a.cl("obj_ref", str6);
        }
        return c0234a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0234a c0234a = new C0234a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0234a.e(str2, str7, str3, str4, str5);
        c0234a.cl("obj_url", str6);
        c0234a.save();
    }

    @Deprecated
    public static void ck(String str, String str2) {
        if (!ao.isEmpty(str)) {
            am amVar = new am(str);
            if (str2 != null) {
                amVar = amVar.ah("obj_type", str2);
            }
            TiebaStatic.log(amVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0234a {
        private final String adp;
        private final boolean agu;
        private final am eGp;
        private final String gKc;
        private final String gKd;
        private final String gKe;
        private final String key;

        private C0234a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.gKc = str2;
            this.adp = str3;
            this.gKd = str4;
            this.gKe = str5;
            this.agu = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.eGp = bxs();
        }

        private am bxs() {
            am amVar = new am(this.key);
            if (!StringUtils.isNull(this.gKc)) {
                amVar = amVar.ah("line", this.gKc);
            }
            if (!StringUtils.isNull(this.adp)) {
                amVar = amVar.ah(WBPageConstants.ParamKey.PAGE, this.adp);
            }
            if (!StringUtils.isNull(this.gKd)) {
                amVar = amVar.ah("locate", this.gKd);
            }
            if (!StringUtils.isNull(this.gKe)) {
                return amVar.ah("task", this.gKe);
            }
            return amVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public am e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.eGp.ah(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.eGp.ah(VideoPlayActivityConfig.OBJ_ID, str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.eGp.ah(ImageViewerConfig.FORUM_ID, str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.eGp.ah(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.eGp.ah("tid", str5);
            }
            this.eGp.r("obj_cpid", 0).r("obj_good_id", 0).ah("obj_throw_type", "BY_POST").ah("client_type", "MOBILE_APP").ah("user_timestamp", String.valueOf(System.currentTimeMillis())).ah("os", HttpConstants.OS_TYPE_VALUE).ah(StatisticConstants.OS_VERSION, Build.VERSION.RELEASE).ah("log_ver", "1.1");
            return this.eGp;
        }

        public C0234a cl(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.eGp.ah(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.eGp);
            if (!this.agu) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.eGp.delete(str);
        }
    }
}
