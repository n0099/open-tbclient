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
        bVar.yZ(i);
        bVar.Di(advertAppInfo.price);
        bVar.Dg(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.za(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.za(advertAppInfo.bDY);
            bVar.setPageNumber(i2);
        } else {
            bVar.za(com.baidu.adp.lib.g.b.f(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.Dl(advertAppInfo.bEg);
        bVar.Dm(advertAppInfo.bEh);
        bVar.Dn(advertAppInfo.bEi);
        bVar.Do(advertAppInfo.page);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.yZ(i);
        bVar.Dg(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.za(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.za(advertAppInfo.bDY);
            bVar.setPageNumber(i2);
        } else {
            bVar.za(com.baidu.adp.lib.g.b.f(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.Dp(str);
        bVar.Do(advertAppInfo.page);
        return bVar;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2) {
        if (dVar == null) {
            return null;
        }
        return c(dVar.oM(), i, i2);
    }

    public static b d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.yZ(i);
        bVar.Di(advertAppInfo.price);
        bVar.Dg(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.za(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.za(advertAppInfo.bDY);
            bVar.setPageNumber(i2);
        }
        bVar.Dl(advertAppInfo.bEg);
        bVar.Dm(advertAppInfo.bEh);
        bVar.Dn(advertAppInfo.bEi);
        bVar.Do(advertAppInfo.page);
        return bVar;
    }

    public static b a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        b bVar = new b();
        bVar.setDownloadStaticsData(downloadStaticsData);
        bVar.yZ(i);
        bVar.setPageNumber(i2);
        return bVar;
    }

    public static b ae(int i, int i2, int i3) {
        b bVar = new b();
        bVar.yZ(i);
        bVar.za(i2);
        bVar.setPageNumber(i3);
        return bVar;
    }

    public static b c(m mVar, int i) {
        if (mVar == null || mVar.cml() == null) {
            return null;
        }
        AppData cml = mVar.cml();
        b bVar = new b();
        bVar.Dg(cml.ext_info);
        if (mVar.iYD) {
            bVar.za(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.za(com.baidu.adp.lib.g.b.f(cml.pos_name, 0));
            bVar.setPageNumber(mVar.pageNumber);
        }
        bVar.yZ(i);
        bVar.Di(cml.price);
        bVar.Dl(mVar.bEg);
        bVar.Dm(mVar.bEh);
        bVar.Dn(mVar.forumId);
        bVar.Do(mVar.cmo());
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        b c = c(advertAppInfo, i, i2);
        c.zb(i3);
        c.zc(i5);
        c.zd(i4);
        if (i6 != -1 && i == 32) {
            c.zf(i6);
        }
        c.Do(advertAppInfo.page);
        if (i == 2) {
            c.Dk("video");
        }
        return c;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        b a = a(dVar, i, i2);
        a.zb(i3);
        a.zc(i5);
        a.zd(i4);
        if (i6 != -1 && i == 32) {
            a.zf(i6);
        }
        if (dVar != null) {
            a.Do(dVar.oM().page);
        }
        if (i == 2) {
            a.Dk("video");
        }
        return a;
    }

    public static b s(String str, int i, String str2) {
        return b(str, i, str2, "");
    }

    public static b b(String str, int i, String str2, String str3) {
        b bVar = new b();
        bVar.yZ(i);
        bVar.Dh(str2);
        bVar.Do("HOMEPAGE");
        bVar.Dg(str);
        bVar.Dp(str3);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b c = c(advertAppInfo, i, i2);
        c.zb(i3);
        return c;
    }

    public static b b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b d = d(advertAppInfo, i, i2);
        d.zb(i3);
        return d;
    }

    public static b a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        b a = a(dVar, 5, dVar.getPageNum());
        a.zb(parseError.errorCode);
        return a;
    }

    public static b o(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.yZ(aVar.Sa);
        bVar.za(aVar.Sc);
        bVar.Do(aVar.Sb);
        bVar.Dg(aVar.extraParam);
        return bVar;
    }

    public static b p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.yZ(aVar.Sa);
        bVar.za(aVar.Sc);
        bVar.Do(aVar.Sb);
        bVar.Dg(aVar.extraParam);
        bVar.zb(aVar.RO);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            bVar.Dj(aVar.tplName);
        }
        bVar.zd(aVar.RP);
        return bVar;
    }

    public static b q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.yZ(aVar.Sa);
        bVar.za(aVar.Sc);
        bVar.Do(aVar.Sb);
        bVar.Dg(aVar.extraParam);
        bVar.zb(0);
        bVar.zc(aVar.Se);
        bVar.zd(aVar.Sd);
        bVar.ze(aVar.Sf);
        return bVar;
    }

    public static b r(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.yZ(aVar.Sa);
        bVar.za(aVar.Sc);
        bVar.Do(aVar.Sb);
        bVar.Dg(aVar.extraParam);
        return bVar;
    }
}
