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
        bVar.yp(i);
        bVar.CR(advertAppInfo.price);
        bVar.CP(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.yq(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.yq(advertAppInfo.bXp);
            bVar.setPageNumber(i2);
        } else {
            bVar.yq(com.baidu.adp.lib.g.b.toInt(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.CU(advertAppInfo.bXx);
        bVar.CV(advertAppInfo.bXy);
        bVar.CW(advertAppInfo.bXz);
        bVar.CX(advertAppInfo.page);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.yp(i);
        bVar.CP(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.yq(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.yq(advertAppInfo.bXp);
            bVar.setPageNumber(i2);
        } else {
            bVar.yq(com.baidu.adp.lib.g.b.toInt(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.CY(str);
        bVar.CX(advertAppInfo.page);
        return bVar;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2) {
        if (dVar == null) {
            return null;
        }
        return c(dVar.kd(), i, i2);
    }

    public static b d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.yp(i);
        bVar.CR(advertAppInfo.price);
        bVar.CP(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.yq(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.yq(advertAppInfo.bXp);
            bVar.setPageNumber(i2);
        }
        bVar.CU(advertAppInfo.bXx);
        bVar.CV(advertAppInfo.bXy);
        bVar.CW(advertAppInfo.bXz);
        bVar.CX(advertAppInfo.page);
        return bVar;
    }

    public static b a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        b bVar = new b();
        bVar.setDownloadStaticsData(downloadStaticsData);
        bVar.yp(i);
        bVar.setPageNumber(i2);
        return bVar;
    }

    public static b X(int i, int i2, int i3) {
        b bVar = new b();
        bVar.yp(i);
        bVar.yq(i2);
        bVar.setPageNumber(i3);
        return bVar;
    }

    public static b c(m mVar, int i) {
        if (mVar == null || mVar.cod() == null) {
            return null;
        }
        AppData cod = mVar.cod();
        b bVar = new b();
        bVar.CP(cod.ext_info);
        if (mVar.jil) {
            bVar.yq(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.yq(com.baidu.adp.lib.g.b.toInt(cod.pos_name, 0));
            bVar.setPageNumber(mVar.pageNumber);
        }
        bVar.yp(i);
        bVar.CR(cod.price);
        bVar.CU(mVar.bXx);
        bVar.CV(mVar.bXy);
        bVar.CW(mVar.forumId);
        bVar.CX(mVar.cog());
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        b c = c(advertAppInfo, i, i2);
        c.yr(i3);
        c.ys(i5);
        c.yt(i4);
        if (i6 != -1 && i == 32) {
            c.yv(i6);
        }
        c.CX(advertAppInfo.page);
        if (i == 2) {
            c.CT("video");
        }
        return c;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        b a = a(dVar, i, i2);
        a.yr(i3);
        a.ys(i5);
        a.yt(i4);
        if (i6 != -1 && i == 32) {
            a.yv(i6);
        }
        if (dVar != null) {
            a.CX(dVar.kd().page);
        }
        if (i == 2) {
            a.CT("video");
        }
        return a;
    }

    public static b q(String str, int i, String str2) {
        return b(str, i, str2, "");
    }

    public static b b(String str, int i, String str2, String str3) {
        b bVar = new b();
        bVar.yp(i);
        bVar.CQ(str2);
        bVar.CX("HOMEPAGE");
        bVar.CP(str);
        bVar.CY(str3);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b c = c(advertAppInfo, i, i2);
        c.yr(i3);
        return c;
    }

    public static b b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b d = d(advertAppInfo, i, i2);
        d.yr(i3);
        return d;
    }

    public static b a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        b a = a(dVar, 5, dVar.getPageNum());
        a.yr(parseError.errorCode);
        return a;
    }

    public static b o(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.yp(aVar.BM);
        bVar.yq(aVar.BO);
        bVar.CX(aVar.BN);
        bVar.CP(aVar.extraParam);
        return bVar;
    }

    public static b p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.yp(aVar.BM);
        bVar.yq(aVar.BO);
        bVar.CX(aVar.BN);
        bVar.CP(aVar.extraParam);
        bVar.yr(aVar.BB);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            bVar.CS(aVar.tplName);
        }
        bVar.yt(aVar.BC);
        return bVar;
    }

    public static b q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.yp(aVar.BM);
        bVar.yq(aVar.BO);
        bVar.CX(aVar.BN);
        bVar.CP(aVar.extraParam);
        bVar.yr(0);
        bVar.ys(aVar.BQ);
        bVar.yt(aVar.BP);
        bVar.yu(aVar.BR);
        return bVar;
    }

    public static b r(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.yp(aVar.BM);
        bVar.yq(aVar.BO);
        bVar.CX(aVar.BN);
        bVar.CP(aVar.extraParam);
        return bVar;
    }
}
