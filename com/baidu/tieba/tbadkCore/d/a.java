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
        public String biw;
        public int cXH;
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
            c0316a.cM("obj_ref", str6);
        }
        return c0316a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0316a c0316a = new C0316a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0316a.e(str2, str7, str3, str4, str5);
        c0316a.cM("obj_url", str6);
        c0316a.save();
    }

    @Deprecated
    public static void cL(String str, String str2) {
        if (!ao.isEmpty(str)) {
            am amVar = new am(str);
            if (str2 != null) {
                amVar = amVar.aA("obj_type", str2);
            }
            TiebaStatic.log(amVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0316a {
        private final boolean arM;
        private final am flk;
        private final String hmv;
        private final String hmw;
        private final String key;
        private final String line;
        private final String page;

        private C0316a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.line = str2;
            this.page = str3;
            this.hmv = str4;
            this.hmw = str5;
            this.arM = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.flk = bDJ();
        }

        private am bDJ() {
            am amVar = new am(this.key);
            if (!StringUtils.isNull(this.line)) {
                amVar = amVar.aA("line", this.line);
            }
            if (!StringUtils.isNull(this.page)) {
                amVar = amVar.aA(SystemScreenshotManager.PAGE, this.page);
            }
            if (!StringUtils.isNull(this.hmv)) {
                amVar = amVar.aA("locate", this.hmv);
            }
            if (!StringUtils.isNull(this.hmw)) {
                return amVar.aA(WebSocketAction.PARAM_KEY_TASK, this.hmw);
            }
            return amVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public am e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.flk.aA(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.flk.aA(VideoPlayActivityConfig.OBJ_ID, str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.flk.aA(ImageViewerConfig.FORUM_ID, str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.flk.aA(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.flk.aA("tid", str5);
            }
            this.flk.x("obj_cpid", 0).x("obj_good_id", 0).aA("obj_throw_type", "BY_POST").aA("client_type", "MOBILE_APP").aA("user_timestamp", String.valueOf(System.currentTimeMillis())).aA("os", HttpConstants.OS_TYPE_VALUE).aA(StatisticConstants.OS_VERSION, Build.VERSION.RELEASE).aA("log_ver", "1.1");
            return this.flk;
        }

        public C0316a cM(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.flk.aA(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.flk);
            if (!this.arM) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.flk.delete(str);
        }
    }
}
