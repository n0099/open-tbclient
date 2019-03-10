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
        bVar.xW(i);
        bVar.BN(advertAppInfo.price);
        bVar.BL(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.xX(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.xX(advertAppInfo.bwG);
            bVar.setPageNumber(i2);
        } else {
            bVar.xX(com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.BQ(advertAppInfo.bwO);
        bVar.BR(advertAppInfo.bwP);
        bVar.BS(advertAppInfo.bwQ);
        bVar.BT(advertAppInfo.page);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.xW(i);
        bVar.BL(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.xX(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.xX(advertAppInfo.bwG);
            bVar.setPageNumber(i2);
        } else {
            bVar.xX(com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.BU(str);
        bVar.BT(advertAppInfo.page);
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
        bVar.xW(i);
        bVar.BN(advertAppInfo.price);
        bVar.BL(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.xX(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.xX(advertAppInfo.bwG);
            bVar.setPageNumber(i2);
        }
        bVar.BQ(advertAppInfo.bwO);
        bVar.BR(advertAppInfo.bwP);
        bVar.BS(advertAppInfo.bwQ);
        bVar.BT(advertAppInfo.page);
        return bVar;
    }

    public static b a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        b bVar = new b();
        bVar.setDownloadStaticsData(downloadStaticsData);
        bVar.xW(i);
        bVar.setPageNumber(i2);
        return bVar;
    }

    public static b ad(int i, int i2, int i3) {
        b bVar = new b();
        bVar.xW(i);
        bVar.xX(i2);
        bVar.setPageNumber(i3);
        return bVar;
    }

    public static b c(m mVar, int i) {
        if (mVar == null || mVar.cef() == null) {
            return null;
        }
        AppData cef = mVar.cef();
        b bVar = new b();
        bVar.BL(cef.ext_info);
        if (mVar.iGh) {
            bVar.xX(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.xX(com.baidu.adp.lib.g.b.l(cef.pos_name, 0));
            bVar.setPageNumber(mVar.pageNumber);
        }
        bVar.xW(i);
        bVar.BN(cef.price);
        bVar.BQ(mVar.bwO);
        bVar.BR(mVar.bwP);
        bVar.BS(mVar.forumId);
        bVar.BT(mVar.cei());
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        b c = c(advertAppInfo, i, i2);
        c.xY(i3);
        c.xZ(i5);
        c.ya(i4);
        if (i6 != -1 && i == 32) {
            c.yc(i6);
        }
        c.BT(advertAppInfo.page);
        if (i == 2) {
            c.BP("video");
        }
        return c;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        b a = a(dVar, i, i2);
        a.xY(i3);
        a.xZ(i5);
        a.ya(i4);
        if (i6 != -1 && i == 32) {
            a.yc(i6);
        }
        if (dVar != null) {
            a.BT(dVar.pR().page);
        }
        if (i == 2) {
            a.BP("video");
        }
        return a;
    }

    public static b o(String str, int i, String str2) {
        return b(str, i, str2, "");
    }

    public static b b(String str, int i, String str2, String str3) {
        b bVar = new b();
        bVar.xW(i);
        bVar.BM(str2);
        bVar.BT("HOMEPAGE");
        bVar.BL(str);
        bVar.BU(str3);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b c = c(advertAppInfo, i, i2);
        c.xY(i3);
        return c;
    }

    public static b b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b d = d(advertAppInfo, i, i2);
        d.xY(i3);
        return d;
    }

    public static b a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        b a = a(dVar, 5, dVar.getPageNum());
        a.xY(parseError.errorCode);
        return a;
    }

    public static b o(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.xW(aVar.Un);
        bVar.xX(aVar.Up);
        bVar.BT(aVar.Uo);
        bVar.BL(aVar.extraParam);
        return bVar;
    }

    public static b p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.xW(aVar.Un);
        bVar.xX(aVar.Up);
        bVar.BT(aVar.Uo);
        bVar.BL(aVar.extraParam);
        bVar.xY(aVar.Uc);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            bVar.BO(aVar.tplName);
        }
        bVar.ya(aVar.Ud);
        return bVar;
    }

    public static b q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.xW(aVar.Un);
        bVar.xX(aVar.Up);
        bVar.BT(aVar.Uo);
        bVar.BL(aVar.extraParam);
        bVar.xY(0);
        bVar.xZ(aVar.Ur);
        bVar.ya(aVar.Uq);
        bVar.yb(aVar.Us);
        return bVar;
    }

    public static b r(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.xW(aVar.Un);
        bVar.xX(aVar.Up);
        bVar.BT(aVar.Uo);
        bVar.BL(aVar.extraParam);
        return bVar;
    }
}
