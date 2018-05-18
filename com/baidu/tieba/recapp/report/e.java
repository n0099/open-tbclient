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
        aVar.rS(com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, 0));
        aVar.rR(i);
        aVar.si(advertAppInfo.price);
        aVar.sg(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.sk(advertAppInfo.VZ);
        aVar.sl(advertAppInfo.Wa);
        aVar.sm(advertAppInfo.Wb);
        aVar.sn(advertAppInfo.Vp);
        return aVar;
    }

    public static a a(com.baidu.afd.d dVar, int i, int i2) {
        if (dVar == null) {
            return null;
        }
        return c(dVar.lu(), i, i2);
    }

    public static a d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        a aVar = new a();
        aVar.rS(advertAppInfo.VR);
        aVar.rR(i);
        aVar.si(advertAppInfo.price);
        aVar.sg(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.sk(advertAppInfo.VZ);
        aVar.sl(advertAppInfo.Wa);
        aVar.sm(advertAppInfo.Wb);
        aVar.sn(advertAppInfo.Vp);
        return aVar;
    }

    public static a a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        a aVar = new a();
        aVar.setDownloadStaticsData(downloadStaticsData);
        aVar.rR(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a W(int i, int i2, int i3) {
        a aVar = new a();
        aVar.rR(i);
        aVar.rS(i2);
        aVar.setPageNumber(i3);
        return aVar;
    }

    public static a c(l lVar, int i) {
        if (lVar == null || lVar.brN() == null) {
            return null;
        }
        AppData brN = lVar.brN();
        a aVar = new a();
        aVar.rS(com.baidu.adp.lib.g.b.g(brN.pos_name, 0));
        aVar.sg(brN.ext_info);
        aVar.setPageNumber(lVar.pageNumber);
        aVar.rR(i);
        aVar.si(brN.price);
        aVar.sk(lVar.VZ);
        aVar.sl(lVar.Wa);
        aVar.sm(lVar.forumId);
        aVar.sn("PB");
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        a c = c(advertAppInfo, i, i2);
        c.rT(i3);
        c.rU(i5);
        c.rV(i4);
        if (i6 != -1 && i == 32) {
            c.rW(i6);
        }
        c.sn(advertAppInfo.Vp);
        if (i == 2) {
            c.sj("video");
        }
        return c;
    }

    public static a a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        a a = a(dVar, i, i2);
        a.rT(i3);
        a.rU(i5);
        a.rV(i4);
        if (i6 != -1 && i == 32) {
            a.rW(i6);
        }
        if (dVar != null) {
            a.sn(dVar.lu().Vp);
        }
        if (i == 2) {
            a.sj("video");
        }
        return a;
    }

    public static a n(String str, int i, String str2) {
        return b(str, i, str2, "");
    }

    public static a b(String str, int i, String str2, String str3) {
        a aVar = new a();
        aVar.rR(i);
        aVar.sh(str2);
        aVar.sn("HOMEPAGE");
        aVar.sg(str);
        aVar.so(str3);
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a c = c(advertAppInfo, i, i2);
        c.rT(i3);
        return c;
    }

    public static a b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a d = d(advertAppInfo, i, i2);
        d.rT(i3);
        return d;
    }

    public static a a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        a a = a(dVar, 5, dVar.getPageNum());
        a.rT(parseError.errorCode);
        return a;
    }
}
