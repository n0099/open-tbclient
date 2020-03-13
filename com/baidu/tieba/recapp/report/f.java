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
        bVar.AY(i);
        bVar.Id(advertAppInfo.price);
        bVar.Ib(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.AZ(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.AZ(advertAppInfo.cNb);
            bVar.setPageNumber(i2);
        } else {
            bVar.AZ(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.Ig(advertAppInfo.cNj);
        bVar.Ih(advertAppInfo.cNk);
        bVar.Ii(advertAppInfo.cNl);
        bVar.Ij(advertAppInfo.page);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.AY(i);
        bVar.Ib(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.AZ(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.AZ(advertAppInfo.cNb);
            bVar.setPageNumber(i2);
        } else {
            bVar.AZ(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.Ik(str);
        bVar.Ij(advertAppInfo.page);
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
        bVar.AY(i);
        bVar.Id(advertAppInfo.price);
        bVar.Ib(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.AZ(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.AZ(advertAppInfo.cNb);
            bVar.setPageNumber(i2);
        }
        bVar.Ig(advertAppInfo.cNj);
        bVar.Ih(advertAppInfo.cNk);
        bVar.Ii(advertAppInfo.cNl);
        bVar.Ij(advertAppInfo.page);
        return bVar;
    }

    public static b a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        b bVar = new b();
        bVar.setDownloadStaticsData(downloadStaticsData);
        bVar.AY(i);
        bVar.setPageNumber(i2);
        return bVar;
    }

    public static b Y(int i, int i2, int i3) {
        b bVar = new b();
        bVar.AY(i);
        bVar.AZ(i2);
        bVar.setPageNumber(i3);
        return bVar;
    }

    public static b c(m mVar, int i) {
        if (mVar == null || mVar.cKP() == null) {
            return null;
        }
        AppData cKP = mVar.cKP();
        b bVar = new b();
        bVar.Ib(cKP.ext_info);
        if (mVar.kgC) {
            bVar.AZ(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.AZ(com.baidu.adp.lib.f.b.toInt(cKP.pos_name, 0));
            bVar.setPageNumber(mVar.pageNumber);
        }
        bVar.AY(i);
        bVar.Id(cKP.price);
        bVar.Ig(mVar.cNj);
        bVar.Ih(mVar.cNk);
        bVar.Ii(mVar.forumId);
        bVar.Ij(mVar.cKS());
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        b c = c(advertAppInfo, i, i2);
        c.Ba(i3);
        c.Bb(i5);
        c.Bc(i4);
        if (i6 != -1 && i == 32) {
            c.Be(i6);
        }
        c.Ij(advertAppInfo.page);
        if (i == 2) {
            c.If("video");
        }
        return c;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        b a = a(dVar, i, i2);
        a.Ba(i3);
        a.Bb(i5);
        a.Bc(i4);
        if (i6 != -1 && i == 32) {
            a.Be(i6);
        }
        if (dVar != null) {
            a.Ij(dVar.kK().page);
        }
        if (i == 2) {
            a.If("video");
        }
        return a;
    }

    public static b u(String str, int i, String str2) {
        return c(str, i, str2, "");
    }

    public static b c(String str, int i, String str2, String str3) {
        b bVar = new b();
        bVar.AY(i);
        bVar.Ic(str2);
        bVar.Ij("HOMEPAGE");
        bVar.Ib(str);
        bVar.Ik(str3);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b c = c(advertAppInfo, i, i2);
        c.Ba(i3);
        return c;
    }

    public static b b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b d = d(advertAppInfo, i, i2);
        d.Ba(i3);
        return d;
    }

    public static b a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        b a = a(dVar, 5, dVar.getPageNum());
        a.Ba(parseError.errorCode);
        return a;
    }

    public static b o(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.AY(aVar.Er);
        bVar.AZ(aVar.Et);
        bVar.Ij(aVar.Es);
        bVar.Ib(aVar.extraParam);
        return bVar;
    }

    public static b p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.AY(aVar.Er);
        bVar.AZ(aVar.Et);
        bVar.Ij(aVar.Es);
        bVar.Ib(aVar.extraParam);
        bVar.Ba(aVar.Eg);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            bVar.Ie(aVar.tplName);
        }
        bVar.Bc(aVar.Eh);
        return bVar;
    }

    public static b q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.AY(aVar.Er);
        bVar.AZ(aVar.Et);
        bVar.Ij(aVar.Es);
        bVar.Ib(aVar.extraParam);
        bVar.Ba(0);
        bVar.Bb(aVar.Ev);
        bVar.Bc(aVar.Eu);
        bVar.Bd(aVar.startPosition);
        return bVar;
    }

    public static b r(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.AY(aVar.Er);
        bVar.AZ(aVar.Et);
        bVar.Ij(aVar.Es);
        bVar.Ib(aVar.extraParam);
        return bVar;
    }
}
