package com.baidu.tieba.recapp.report;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.afd.ParseError;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.m;
/* loaded from: classes.dex */
public class f {
    public static b c(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.xS(i);
        bVar.BK(advertAppInfo.price);
        bVar.BI(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.xT(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.xT(advertAppInfo.bwL);
            bVar.setPageNumber(i2);
        } else {
            bVar.xT(com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.BN(advertAppInfo.bwT);
        bVar.BO(advertAppInfo.bwU);
        bVar.BP(advertAppInfo.bwV);
        bVar.BQ(advertAppInfo.page);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.xS(i);
        bVar.BI(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.xT(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.xT(advertAppInfo.bwL);
            bVar.setPageNumber(i2);
        } else {
            bVar.xT(com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.BR(str);
        bVar.BQ(advertAppInfo.page);
        return bVar;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2) {
        if (dVar == null) {
            return null;
        }
        return c(dVar.pR(), i, i2);
    }

    public static b d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.xS(i);
        bVar.BK(advertAppInfo.price);
        bVar.BI(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.xT(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.xT(advertAppInfo.bwL);
            bVar.setPageNumber(i2);
        }
        bVar.BN(advertAppInfo.bwT);
        bVar.BO(advertAppInfo.bwU);
        bVar.BP(advertAppInfo.bwV);
        bVar.BQ(advertAppInfo.page);
        return bVar;
    }

    public static b a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        b bVar = new b();
        bVar.setDownloadStaticsData(downloadStaticsData);
        bVar.xS(i);
        bVar.setPageNumber(i2);
        return bVar;
    }

    public static b ad(int i, int i2, int i3) {
        b bVar = new b();
        bVar.xS(i);
        bVar.xT(i2);
        bVar.setPageNumber(i3);
        return bVar;
    }

    public static b c(m mVar, int i) {
        if (mVar == null || mVar.ced() == null) {
            return null;
        }
        AppData ced = mVar.ced();
        b bVar = new b();
        bVar.BI(ced.ext_info);
        if (mVar.iFJ) {
            bVar.xT(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.xT(com.baidu.adp.lib.g.b.l(ced.pos_name, 0));
            bVar.setPageNumber(mVar.pageNumber);
        }
        bVar.xS(i);
        bVar.BK(ced.price);
        bVar.BN(mVar.bwT);
        bVar.BO(mVar.bwU);
        bVar.BP(mVar.forumId);
        bVar.BQ(mVar.ceg());
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        b c = c(advertAppInfo, i, i2);
        c.xU(i3);
        c.xV(i5);
        c.xW(i4);
        if (i6 != -1 && i == 32) {
            c.xY(i6);
        }
        c.BQ(advertAppInfo.page);
        if (i == 2) {
            c.BM("video");
        }
        return c;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        b a = a(dVar, i, i2);
        a.xU(i3);
        a.xV(i5);
        a.xW(i4);
        if (i6 != -1 && i == 32) {
            a.xY(i6);
        }
        if (dVar != null) {
            a.BQ(dVar.pR().page);
        }
        if (i == 2) {
            a.BM("video");
        }
        return a;
    }

    public static b o(String str, int i, String str2) {
        return b(str, i, str2, "");
    }

    public static b b(String str, int i, String str2, String str3) {
        b bVar = new b();
        bVar.xS(i);
        bVar.BJ(str2);
        bVar.BQ("HOMEPAGE");
        bVar.BI(str);
        bVar.BR(str3);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b c = c(advertAppInfo, i, i2);
        c.xU(i3);
        return c;
    }

    public static b b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b d = d(advertAppInfo, i, i2);
        d.xU(i3);
        return d;
    }

    public static b a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        b a = a(dVar, 5, dVar.getPageNum());
        a.xU(parseError.errorCode);
        return a;
    }

    public static b o(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.xS(aVar.Uo);
        bVar.xT(aVar.Uq);
        bVar.BQ(aVar.Up);
        bVar.BI(aVar.extraParam);
        return bVar;
    }

    public static b p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.xS(aVar.Uo);
        bVar.xT(aVar.Uq);
        bVar.BQ(aVar.Up);
        bVar.BI(aVar.extraParam);
        bVar.xU(aVar.Ud);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            bVar.BL(aVar.tplName);
        }
        bVar.xW(aVar.Ue);
        return bVar;
    }

    public static b q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.xS(aVar.Uo);
        bVar.xT(aVar.Uq);
        bVar.BQ(aVar.Up);
        bVar.BI(aVar.extraParam);
        bVar.xU(0);
        bVar.xV(aVar.Us);
        bVar.xW(aVar.Ur);
        bVar.xX(aVar.Ut);
        return bVar;
    }

    public static b r(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.xS(aVar.Uo);
        bVar.xT(aVar.Uq);
        bVar.BQ(aVar.Up);
        bVar.BI(aVar.extraParam);
        return bVar;
    }
}
