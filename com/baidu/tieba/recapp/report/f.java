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
        bVar.Bg(i);
        bVar.Ic(advertAppInfo.price);
        bVar.Ia(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.Bh(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.Bh(advertAppInfo.cNo);
            bVar.setPageNumber(i2);
        } else {
            bVar.Bh(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.If(advertAppInfo.cNw);
        bVar.Ig(advertAppInfo.cNx);
        bVar.Ih(advertAppInfo.cNy);
        bVar.Ii(advertAppInfo.page);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.Bg(i);
        bVar.Ia(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.Bh(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.Bh(advertAppInfo.cNo);
            bVar.setPageNumber(i2);
        } else {
            bVar.Bh(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.Ij(str);
        bVar.Ii(advertAppInfo.page);
        return bVar;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2) {
        if (dVar == null) {
            return null;
        }
        return c(dVar.kK(), i, i2);
    }

    public static b d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.Bg(i);
        bVar.Ic(advertAppInfo.price);
        bVar.Ia(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.Bh(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.Bh(advertAppInfo.cNo);
            bVar.setPageNumber(i2);
        }
        bVar.If(advertAppInfo.cNw);
        bVar.Ig(advertAppInfo.cNx);
        bVar.Ih(advertAppInfo.cNy);
        bVar.Ii(advertAppInfo.page);
        return bVar;
    }

    public static b a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        b bVar = new b();
        bVar.setDownloadStaticsData(downloadStaticsData);
        bVar.Bg(i);
        bVar.setPageNumber(i2);
        return bVar;
    }

    public static b Y(int i, int i2, int i3) {
        b bVar = new b();
        bVar.Bg(i);
        bVar.Bh(i2);
        bVar.setPageNumber(i3);
        return bVar;
    }

    public static b c(m mVar, int i) {
        if (mVar == null || mVar.cLj() == null) {
            return null;
        }
        AppData cLj = mVar.cLj();
        b bVar = new b();
        bVar.Ia(cLj.ext_info);
        if (mVar.kif) {
            bVar.Bh(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.Bh(com.baidu.adp.lib.f.b.toInt(cLj.pos_name, 0));
            bVar.setPageNumber(mVar.pageNumber);
        }
        bVar.Bg(i);
        bVar.Ic(cLj.price);
        bVar.If(mVar.cNw);
        bVar.Ig(mVar.cNx);
        bVar.Ih(mVar.forumId);
        bVar.Ii(mVar.cLm());
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        b c = c(advertAppInfo, i, i2);
        c.Bi(i3);
        c.Bj(i5);
        c.Bk(i4);
        if (i6 != -1 && i == 32) {
            c.Bm(i6);
        }
        c.Ii(advertAppInfo.page);
        if (i == 2) {
            c.Ie("video");
        }
        return c;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        b a = a(dVar, i, i2);
        a.Bi(i3);
        a.Bj(i5);
        a.Bk(i4);
        if (i6 != -1 && i == 32) {
            a.Bm(i6);
        }
        if (dVar != null) {
            a.Ii(dVar.kK().page);
        }
        if (i == 2) {
            a.Ie("video");
        }
        return a;
    }

    public static b u(String str, int i, String str2) {
        return c(str, i, str2, "");
    }

    public static b c(String str, int i, String str2, String str3) {
        b bVar = new b();
        bVar.Bg(i);
        bVar.Ib(str2);
        bVar.Ii("HOMEPAGE");
        bVar.Ia(str);
        bVar.Ij(str3);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b c = c(advertAppInfo, i, i2);
        c.Bi(i3);
        return c;
    }

    public static b b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b d = d(advertAppInfo, i, i2);
        d.Bi(i3);
        return d;
    }

    public static b a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        b a = a(dVar, 5, dVar.getPageNum());
        a.Bi(parseError.errorCode);
        return a;
    }

    public static b o(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.Bg(aVar.Er);
        bVar.Bh(aVar.Et);
        bVar.Ii(aVar.Es);
        bVar.Ia(aVar.extraParam);
        return bVar;
    }

    public static b p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.Bg(aVar.Er);
        bVar.Bh(aVar.Et);
        bVar.Ii(aVar.Es);
        bVar.Ia(aVar.extraParam);
        bVar.Bi(aVar.Eg);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            bVar.Id(aVar.tplName);
        }
        bVar.Bk(aVar.Eh);
        return bVar;
    }

    public static b q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.Bg(aVar.Er);
        bVar.Bh(aVar.Et);
        bVar.Ii(aVar.Es);
        bVar.Ia(aVar.extraParam);
        bVar.Bi(0);
        bVar.Bj(aVar.Ev);
        bVar.Bk(aVar.Eu);
        bVar.Bl(aVar.startPosition);
        return bVar;
    }

    public static b r(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.Bg(aVar.Er);
        bVar.Bh(aVar.Et);
        bVar.Ii(aVar.Es);
        bVar.Ia(aVar.extraParam);
        return bVar;
    }
}
