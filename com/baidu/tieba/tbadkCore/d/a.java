package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.searchbox.ng.ai.apps.network.WebSocketAction;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
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
        public String bjn;
        public int dbl;
        public String mPid;
    }

    public static C0316a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0316a c0316a = new C0316a(str, str2, str3, str4, str5);
        c0316a.e(str6, str7, str8, str9, str10);
        return c0316a;
    }

    public static C0316a f(String str, String str2, String str3, String str4, String str5, String str6) {
        C0316a c0316a = new C0316a("ad_tpoint", "PT", str, str2, "tpoint");
        c0316a.e(null, null, str3, str4, str5);
        if (!ao.isEmpty(str6)) {
            c0316a.cO("obj_ref", str6);
        }
        return c0316a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0316a c0316a = new C0316a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0316a.e(str2, str7, str3, str4, str5);
        c0316a.cO("obj_url", str6);
        c0316a.save();
    }

    @Deprecated
    public static void cN(String str, String str2) {
        if (!ao.isEmpty(str)) {
            am amVar = new am(str);
            if (str2 != null) {
                amVar = amVar.aB("obj_type", str2);
            }
            TiebaStatic.log(amVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0316a {
        private final boolean asp;
        private final am foW;
        private final String hqP;
        private final String hqQ;
        private final String hqR;
        private final String key;
        private final String page;

        private C0316a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.hqP = str2;
            this.page = str3;
            this.hqQ = str4;
            this.hqR = str5;
            this.asp = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.foW = bFj();
        }

        private am bFj() {
            am amVar = new am(this.key);
            if (!StringUtils.isNull(this.hqP)) {
                amVar = amVar.aB("line", this.hqP);
            }
            if (!StringUtils.isNull(this.page)) {
                amVar = amVar.aB(SystemScreenshotManager.PAGE, this.page);
            }
            if (!StringUtils.isNull(this.hqQ)) {
                amVar = amVar.aB("locate", this.hqQ);
            }
            if (!StringUtils.isNull(this.hqR)) {
                return amVar.aB(WebSocketAction.PARAM_KEY_TASK, this.hqR);
            }
            return amVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public am e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.foW.aB(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.foW.aB(VideoPlayActivityConfig.OBJ_ID, str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.foW.aB(ImageViewerConfig.FORUM_ID, str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.foW.aB(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.foW.aB("tid", str5);
            }
            this.foW.y("obj_cpid", 0).y("obj_good_id", 0).aB("obj_throw_type", "BY_POST").aB("client_type", "MOBILE_APP").aB("user_timestamp", String.valueOf(System.currentTimeMillis())).aB("os", HttpConstants.OS_TYPE_VALUE).aB(StatisticConstants.OS_VERSION, Build.VERSION.RELEASE).aB("log_ver", "1.1");
            return this.foW;
        }

        public C0316a cO(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.foW.aB(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.foW);
            if (!this.asp) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.foW.delete(str);
        }
    }
}
