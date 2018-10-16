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
        public String beh;
        public int cPU;
        public String mPid;
    }

    public static C0277a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0277a c0277a = new C0277a(str, str2, str3, str4, str5);
        c0277a.e(str6, str7, str8, str9, str10);
        return c0277a;
    }

    public static C0277a f(String str, String str2, String str3, String str4, String str5, String str6) {
        C0277a c0277a = new C0277a("ad_tpoint", "PT", str, str2, "tpoint");
        c0277a.e(null, null, str3, str4, str5);
        if (!ao.isEmpty(str6)) {
            c0277a.cH("obj_ref", str6);
        }
        return c0277a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0277a c0277a = new C0277a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0277a.e(str2, str7, str3, str4, str5);
        c0277a.cH("obj_url", str6);
        c0277a.save();
    }

    @Deprecated
    public static void cG(String str, String str2) {
        if (!ao.isEmpty(str)) {
            am amVar = new am(str);
            if (str2 != null) {
                amVar = amVar.ax("obj_type", str2);
            }
            TiebaStatic.log(amVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0277a {
        private final boolean any;
        private final am fcX;
        private final String hed;
        private final String hee;
        private final String key;
        private final String line;
        private final String page;

        private C0277a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.line = str2;
            this.page = str3;
            this.hed = str4;
            this.hee = str5;
            this.any = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.fcX = bCs();
        }

        private am bCs() {
            am amVar = new am(this.key);
            if (!StringUtils.isNull(this.line)) {
                amVar = amVar.ax("line", this.line);
            }
            if (!StringUtils.isNull(this.page)) {
                amVar = amVar.ax(SystemScreenshotManager.PAGE, this.page);
            }
            if (!StringUtils.isNull(this.hed)) {
                amVar = amVar.ax("locate", this.hed);
            }
            if (!StringUtils.isNull(this.hee)) {
                return amVar.ax(WebSocketAction.PARAM_KEY_TASK, this.hee);
            }
            return amVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public am e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.fcX.ax(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.fcX.ax(VideoPlayActivityConfig.OBJ_ID, str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.fcX.ax(ImageViewerConfig.FORUM_ID, str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.fcX.ax(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.fcX.ax("tid", str5);
            }
            this.fcX.x("obj_cpid", 0).x("obj_good_id", 0).ax("obj_throw_type", "BY_POST").ax("client_type", "MOBILE_APP").ax("user_timestamp", String.valueOf(System.currentTimeMillis())).ax("os", HttpConstants.OS_TYPE_VALUE).ax(StatisticConstants.OS_VERSION, Build.VERSION.RELEASE).ax("log_ver", "1.1");
            return this.fcX;
        }

        public C0277a cH(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.fcX.ax(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.fcX);
            if (!this.any) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.fcX.delete(str);
        }
    }
}
