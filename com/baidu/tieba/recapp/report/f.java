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
        bVar.AP(i);
        bVar.HO(advertAppInfo.price);
        bVar.HM(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.AQ(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.AQ(advertAppInfo.cIW);
            bVar.setPageNumber(i2);
        } else {
            bVar.AQ(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.HR(advertAppInfo.cJe);
        bVar.HS(advertAppInfo.cJf);
        bVar.HT(advertAppInfo.cJg);
        bVar.HU(advertAppInfo.page);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.AP(i);
        bVar.HM(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.AQ(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.AQ(advertAppInfo.cIW);
            bVar.setPageNumber(i2);
        } else {
            bVar.AQ(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.HV(str);
        bVar.HU(advertAppInfo.page);
        return bVar;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2) {
        if (dVar == null) {
            return null;
        }
        return c(dVar.kv(), i, i2);
    }

    public static b d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.AP(i);
        bVar.HO(advertAppInfo.price);
        bVar.HM(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.AQ(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.AQ(advertAppInfo.cIW);
            bVar.setPageNumber(i2);
        }
        bVar.HR(advertAppInfo.cJe);
        bVar.HS(advertAppInfo.cJf);
        bVar.HT(advertAppInfo.cJg);
        bVar.HU(advertAppInfo.page);
        return bVar;
    }

    public static b a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        b bVar = new b();
        bVar.setDownloadStaticsData(downloadStaticsData);
        bVar.AP(i);
        bVar.setPageNumber(i2);
        return bVar;
    }

    public static b X(int i, int i2, int i3) {
        b bVar = new b();
        bVar.AP(i);
        bVar.AQ(i2);
        bVar.setPageNumber(i3);
        return bVar;
    }

    public static b c(m mVar, int i) {
        if (mVar == null || mVar.cJn() == null) {
            return null;
        }
        AppData cJn = mVar.cJn();
        b bVar = new b();
        bVar.HM(cJn.ext_info);
        if (mVar.kfo) {
            bVar.AQ(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.AQ(com.baidu.adp.lib.f.b.toInt(cJn.pos_name, 0));
            bVar.setPageNumber(mVar.pageNumber);
        }
        bVar.AP(i);
        bVar.HO(cJn.price);
        bVar.HR(mVar.cJe);
        bVar.HS(mVar.cJf);
        bVar.HT(mVar.forumId);
        bVar.HU(mVar.cJq());
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        b c = c(advertAppInfo, i, i2);
        c.AR(i3);
        c.AS(i5);
        c.AT(i4);
        if (i6 != -1 && i == 32) {
            c.AV(i6);
        }
        c.HU(advertAppInfo.page);
        if (i == 2) {
            c.HQ("video");
        }
        return c;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        b a = a(dVar, i, i2);
        a.AR(i3);
        a.AS(i5);
        a.AT(i4);
        if (i6 != -1 && i == 32) {
            a.AV(i6);
        }
        if (dVar != null) {
            a.HU(dVar.kv().page);
        }
        if (i == 2) {
            a.HQ("video");
        }
        return a;
    }

    public static b t(String str, int i, String str2) {
        return c(str, i, str2, "");
    }

    public static b c(String str, int i, String str2, String str3) {
        b bVar = new b();
        bVar.AP(i);
        bVar.HN(str2);
        bVar.HU("HOMEPAGE");
        bVar.HM(str);
        bVar.HV(str3);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b c = c(advertAppInfo, i, i2);
        c.AR(i3);
        return c;
    }

    public static b b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b d = d(advertAppInfo, i, i2);
        d.AR(i3);
        return d;
    }

    public static b a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        b a = a(dVar, 5, dVar.getPageNum());
        a.AR(parseError.errorCode);
        return a;
    }

    public static b o(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.AP(aVar.DY);
        bVar.AQ(aVar.Ea);
        bVar.HU(aVar.DZ);
        bVar.HM(aVar.extraParam);
        return bVar;
    }

    public static b p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.AP(aVar.DY);
        bVar.AQ(aVar.Ea);
        bVar.HU(aVar.DZ);
        bVar.HM(aVar.extraParam);
        bVar.AR(aVar.DM);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            bVar.HP(aVar.tplName);
        }
        bVar.AT(aVar.DN);
        return bVar;
    }

    public static b q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.AP(aVar.DY);
        bVar.AQ(aVar.Ea);
        bVar.HU(aVar.DZ);
        bVar.HM(aVar.extraParam);
        bVar.AR(0);
        bVar.AS(aVar.Ec);
        bVar.AT(aVar.Eb);
        bVar.AU(aVar.startPosition);
        return bVar;
    }

    public static b r(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.AP(aVar.DY);
        bVar.AQ(aVar.Ea);
        bVar.HU(aVar.DZ);
        bVar.HM(aVar.extraParam);
        return bVar;
    }
}
