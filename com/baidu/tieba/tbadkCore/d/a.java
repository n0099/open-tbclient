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
        public String bWU;
        public int eFy;
        public String mPid;
    }

    public static C0414a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0414a c0414a = new C0414a(str, str2, str3, str4, str5);
        c0414a.j(str6, str7, str8, str9, str10);
        return c0414a;
    }

    public static C0414a f(String str, String str2, String str3, String str4, String str5, String str6) {
        C0414a c0414a = new C0414a("ad_tpoint", "PT", str, str2, "tpoint");
        c0414a.j(null, null, str3, str4, str5);
        if (!aq.isEmpty(str6)) {
            c0414a.en("obj_ref", str6);
        }
        return c0414a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0414a c0414a = new C0414a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0414a.j(str2, str7, str3, str4, str5);
        c0414a.en("obj_url", str6);
        c0414a.save();
    }

    @Deprecated
    public static void em(String str, String str2) {
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
    public static class C0414a {
        private final boolean bHw;
        private final an hdr;
        private final String jhA;
        private final String jhy;
        private final String jhz;
        private final String key;
        private final String page;

        private C0414a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.jhy = str2;
            this.page = str3;
            this.jhz = str4;
            this.jhA = str5;
            this.bHw = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.hdr = cqd();
        }

        private an cqd() {
            an anVar = new an(this.key);
            if (!StringUtils.isNull(this.jhy)) {
                anVar = anVar.bT("line", this.jhy);
            }
            if (!StringUtils.isNull(this.page)) {
                anVar = anVar.bT("page", this.page);
            }
            if (!StringUtils.isNull(this.jhz)) {
                anVar = anVar.bT("locate", this.jhz);
            }
            if (!StringUtils.isNull(this.jhA)) {
                return anVar.bT("task", this.jhA);
            }
            return anVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public an j(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.hdr.bT("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.hdr.bT(VideoPlayActivityConfig.OBJ_ID, str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.hdr.bT("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.hdr.bT(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.hdr.bT("tid", str5);
            }
            this.hdr.P("obj_cpid", 0).P("obj_good_id", 0).bT("obj_throw_type", "BY_POST").bT("client_type", "MOBILE_APP").bT("user_timestamp", String.valueOf(System.currentTimeMillis())).bT(IXAdRequestInfo.OS, "android").bT("os_version", Build.VERSION.RELEASE).bT("log_ver", "1.1");
            return this.hdr;
        }

        public C0414a en(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.hdr.bT(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.hdr);
            if (!this.bHw) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void nV(String str) {
            this.hdr.nV(str);
        }
    }
}
