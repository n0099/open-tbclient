package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public static class b {
        public String bXN;
        public int eHh;
        public String mPid;
    }

    public static C0425a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0425a c0425a = new C0425a(str, str2, str3, str4, str5);
        c0425a.j(str6, str7, str8, str9, str10);
        return c0425a;
    }

    public static C0425a f(String str, String str2, String str3, String str4, String str5, String str6) {
        C0425a c0425a = new C0425a("ad_tpoint", "PT", str, str2, "tpoint");
        c0425a.j(null, null, str3, str4, str5);
        if (!aq.isEmpty(str6)) {
            c0425a.eo("obj_ref", str6);
        }
        return c0425a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0425a c0425a = new C0425a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0425a.j(str2, str7, str3, str4, str5);
        c0425a.eo("obj_url", str6);
        c0425a.save();
    }

    @Deprecated
    public static void en(String str, String str2) {
        if (!aq.isEmpty(str)) {
            an anVar = new an(str);
            if (str2 != null) {
                anVar = anVar.bT("obj_type", str2);
            }
            TiebaStatic.log(anVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0425a {
        private final boolean bHU;
        private final an hfl;
        private final String jjU;
        private final String jjV;
        private final String jjW;
        private final String key;
        private final String page;

        private C0425a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.jjU = str2;
            this.page = str3;
            this.jjV = str4;
            this.jjW = str5;
            this.bHU = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.hfl = cqR();
        }

        private an cqR() {
            an anVar = new an(this.key);
            if (!StringUtils.isNull(this.jjU)) {
                anVar = anVar.bT("line", this.jjU);
            }
            if (!StringUtils.isNull(this.page)) {
                anVar = anVar.bT("page", this.page);
            }
            if (!StringUtils.isNull(this.jjV)) {
                anVar = anVar.bT("locate", this.jjV);
            }
            if (!StringUtils.isNull(this.jjW)) {
                return anVar.bT("task", this.jjW);
            }
            return anVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public an j(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.hfl.bT("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.hfl.bT(VideoPlayActivityConfig.OBJ_ID, str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.hfl.bT("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.hfl.bT(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.hfl.bT("tid", str5);
            }
            this.hfl.P("obj_cpid", 0).P("obj_good_id", 0).bT("obj_throw_type", "BY_POST").bT("client_type", "MOBILE_APP").bT("user_timestamp", String.valueOf(System.currentTimeMillis())).bT(IXAdRequestInfo.OS, "android").bT("os_version", Build.VERSION.RELEASE).bT("log_ver", "1.1");
            return this.hfl;
        }

        public C0425a eo(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.hfl.bT(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.hfl);
            if (!this.bHU) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void nX(String str) {
            this.hfl.nX(str);
        }
    }
}
