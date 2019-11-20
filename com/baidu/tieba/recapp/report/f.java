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
        bVar.yo(i);
        bVar.CR(advertAppInfo.price);
        bVar.CP(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.yp(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.yp(advertAppInfo.bWy);
            bVar.setPageNumber(i2);
        } else {
            bVar.yp(com.baidu.adp.lib.g.b.toInt(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.CU(advertAppInfo.bWG);
        bVar.CV(advertAppInfo.bWH);
        bVar.CW(advertAppInfo.bWI);
        bVar.CX(advertAppInfo.page);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.yo(i);
        bVar.CP(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.yp(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.yp(advertAppInfo.bWy);
            bVar.setPageNumber(i2);
        } else {
            bVar.yp(com.baidu.adp.lib.g.b.toInt(advertAppInfo.adPosition, 0));
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
        bVar.yo(i);
        bVar.CR(advertAppInfo.price);
        bVar.CP(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.yp(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.yp(advertAppInfo.bWy);
            bVar.setPageNumber(i2);
        }
        bVar.CU(advertAppInfo.bWG);
        bVar.CV(advertAppInfo.bWH);
        bVar.CW(advertAppInfo.bWI);
        bVar.CX(advertAppInfo.page);
        return bVar;
    }

    public static b a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        b bVar = new b();
        bVar.setDownloadStaticsData(downloadStaticsData);
        bVar.yo(i);
        bVar.setPageNumber(i2);
        return bVar;
    }

    public static b X(int i, int i2, int i3) {
        b bVar = new b();
        bVar.yo(i);
        bVar.yp(i2);
        bVar.setPageNumber(i3);
        return bVar;
    }

    public static b c(m mVar, int i) {
        if (mVar == null || mVar.cob() == null) {
            return null;
        }
        AppData cob = mVar.cob();
        b bVar = new b();
        bVar.CP(cob.ext_info);
        if (mVar.jht) {
            bVar.yp(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.yp(com.baidu.adp.lib.g.b.toInt(cob.pos_name, 0));
            bVar.setPageNumber(mVar.pageNumber);
        }
        bVar.yo(i);
        bVar.CR(cob.price);
        bVar.CU(mVar.bWG);
        bVar.CV(mVar.bWH);
        bVar.CW(mVar.forumId);
        bVar.CX(mVar.coe());
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        b c = c(advertAppInfo, i, i2);
        c.yq(i3);
        c.yr(i5);
        c.ys(i4);
        if (i6 != -1 && i == 32) {
            c.yu(i6);
        }
        c.CX(advertAppInfo.page);
        if (i == 2) {
            c.CT("video");
        }
        return c;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        b a = a(dVar, i, i2);
        a.yq(i3);
        a.yr(i5);
        a.ys(i4);
        if (i6 != -1 && i == 32) {
            a.yu(i6);
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
        bVar.yo(i);
        bVar.CQ(str2);
        bVar.CX("HOMEPAGE");
        bVar.CP(str);
        bVar.CY(str3);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b c = c(advertAppInfo, i, i2);
        c.yq(i3);
        return c;
    }

    public static b b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b d = d(advertAppInfo, i, i2);
        d.yq(i3);
        return d;
    }

    public static b a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        b a = a(dVar, 5, dVar.getPageNum());
        a.yq(parseError.errorCode);
        return a;
    }

    public static b o(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.yo(aVar.Bm);
        bVar.yp(aVar.Bo);
        bVar.CX(aVar.Bn);
        bVar.CP(aVar.extraParam);
        return bVar;
    }

    public static b p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.yo(aVar.Bm);
        bVar.yp(aVar.Bo);
        bVar.CX(aVar.Bn);
        bVar.CP(aVar.extraParam);
        bVar.yq(aVar.Bb);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            bVar.CS(aVar.tplName);
        }
        bVar.ys(aVar.Bc);
        return bVar;
    }

    public static b q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.yo(aVar.Bm);
        bVar.yp(aVar.Bo);
        bVar.CX(aVar.Bn);
        bVar.CP(aVar.extraParam);
        bVar.yq(0);
        bVar.yr(aVar.Bq);
        bVar.ys(aVar.Bp);
        bVar.yt(aVar.Br);
        return bVar;
    }

    public static b r(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.yo(aVar.Bm);
        bVar.yp(aVar.Bo);
        bVar.CX(aVar.Bn);
        bVar.CP(aVar.extraParam);
        return bVar;
    }
}
