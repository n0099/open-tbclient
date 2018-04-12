package com.baidu.tieba.recapp.report;

import com.baidu.afd.ParseError;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.l;
/* loaded from: classes.dex */
public class e {
    public static a c(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        a aVar = new a();
        aVar.rU(com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, 0));
        aVar.rT(i);
        aVar.sf(advertAppInfo.price);
        aVar.sd(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.sh(advertAppInfo.Wd);
        aVar.si(advertAppInfo.We);
        aVar.sj(advertAppInfo.Wf);
        aVar.sk(advertAppInfo.Vt);
        return aVar;
    }

    public static a a(com.baidu.afd.d dVar, int i, int i2) {
        if (dVar == null) {
            return null;
        }
        return c(dVar.lv(), i, i2);
    }

    public static a d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        a aVar = new a();
        aVar.rU(advertAppInfo.VV);
        aVar.rT(i);
        aVar.sf(advertAppInfo.price);
        aVar.sd(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.sh(advertAppInfo.Wd);
        aVar.si(advertAppInfo.We);
        aVar.sj(advertAppInfo.Wf);
        aVar.sk(advertAppInfo.Vt);
        return aVar;
    }

    public static a a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        a aVar = new a();
        aVar.setDownloadStaticsData(downloadStaticsData);
        aVar.rT(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a W(int i, int i2, int i3) {
        a aVar = new a();
        aVar.rT(i);
        aVar.rU(i2);
        aVar.setPageNumber(i3);
        return aVar;
    }

    public static a c(l lVar, int i) {
        if (lVar == null || lVar.brP() == null) {
            return null;
        }
        AppData brP = lVar.brP();
        a aVar = new a();
        aVar.rU(com.baidu.adp.lib.g.b.g(brP.pos_name, 0));
        aVar.sd(brP.ext_info);
        aVar.setPageNumber(lVar.pageNumber);
        aVar.rT(i);
        aVar.sf(brP.price);
        aVar.sh(lVar.Wd);
        aVar.si(lVar.We);
        aVar.sj(lVar.forumId);
        aVar.sk("PB");
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        a c = c(advertAppInfo, i, i2);
        c.rV(i3);
        c.rW(i5);
        c.rX(i4);
        if (i6 != -1 && i == 32) {
            c.rY(i6);
        }
        c.sk(advertAppInfo.Vt);
        if (i == 2) {
            c.sg("video");
        }
        return c;
    }

    public static a a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        a a = a(dVar, i, i2);
        a.rV(i3);
        a.rW(i5);
        a.rX(i4);
        if (i6 != -1 && i == 32) {
            a.rY(i6);
        }
        if (dVar != null) {
            a.sk(dVar.lv().Vt);
        }
        if (i == 2) {
            a.sg("video");
        }
        return a;
    }

    public static a n(String str, int i, String str2) {
        return b(str, i, str2, "");
    }

    public static a b(String str, int i, String str2, String str3) {
        a aVar = new a();
        aVar.rT(i);
        aVar.se(str2);
        aVar.sk("HOMEPAGE");
        aVar.sd(str);
        aVar.sl(str3);
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a c = c(advertAppInfo, i, i2);
        c.rV(i3);
        return c;
    }

    public static a b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a d = d(advertAppInfo, i, i2);
        d.rV(i3);
        return d;
    }

    public static a a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        a a = a(dVar, 5, dVar.getPageNum());
        a.rV(parseError.errorCode);
        return a;
    }
}
