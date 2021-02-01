package com.baidu.tieba.recapp.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.afd.ParseError;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.o;
/* loaded from: classes.dex */
public class h {
    public static c b(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        cVar.HW(i);
        cVar.RJ(advertAppInfo.price);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.HX(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.HX(advertAppInfo.position + 1);
            cVar.setPageNumber(i2);
        }
        cVar.RN(advertAppInfo.eLG);
        cVar.RO(advertAppInfo.eLH);
        cVar.RP(advertAppInfo.eLI);
        cVar.RQ(advertAppInfo.page);
        return cVar;
    }

    public static c a(com.baidu.afd.d dVar, int i, int i2) {
        if (dVar == null) {
            return null;
        }
        return b(dVar.qS(), i, i2);
    }

    public static c c(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        cVar.HW(i);
        cVar.RJ(advertAppInfo.price);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.HX(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.HX(advertAppInfo.position + 1);
            cVar.setPageNumber(i2);
        }
        cVar.RN(advertAppInfo.eLG);
        cVar.RO(advertAppInfo.eLH);
        cVar.RP(advertAppInfo.eLI);
        cVar.RQ(advertAppInfo.page);
        return cVar;
    }

    public static c a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        c cVar = new c();
        cVar.setDownloadStaticsData(downloadStaticsData);
        cVar.HW(i);
        cVar.setPageNumber(i2);
        return cVar;
    }

    public static c ab(int i, int i2, int i3) {
        c cVar = new c();
        cVar.HW(i);
        cVar.HX(i2);
        cVar.setPageNumber(i3);
        return cVar;
    }

    public static c b(o oVar, int i) {
        if (oVar == null || oVar.dNl() == null) {
            return null;
        }
        AppData dNl = oVar.dNl();
        c cVar = new c();
        cVar.setExtInfo(dNl.ext_info);
        if (oVar.nwv) {
            cVar.HX(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.HX(oVar.position + 1);
            cVar.setPageNumber(oVar.pageNumber);
        }
        cVar.HW(i);
        cVar.RJ(dNl.price);
        cVar.RN(oVar.eLG);
        cVar.RO(oVar.eLH);
        cVar.RP(oVar.forumId);
        cVar.RQ(oVar.dNo());
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        c b2 = b(advertAppInfo, i, i2);
        b2.HY(i3);
        b2.HZ(i5);
        b2.Ia(i4);
        if (i6 != -1 && i == 32) {
            b2.Ic(i6);
        }
        b2.RQ(advertAppInfo.page);
        if (i == 2) {
            b2.RM("video");
        }
        return b2;
    }

    public static c a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        c a2 = a(dVar, i, i2);
        a2.HY(i3);
        a2.HZ(i5);
        a2.Ia(i4);
        if (i6 != -1 && i == 32) {
            a2.Ic(i6);
        }
        if (dVar != null) {
            a2.RQ(dVar.qS().page);
        }
        if (i == 2) {
            a2.RM("video");
        }
        return a2;
    }

    public static c t(String str, int i, String str2) {
        return d(str, i, str2, "");
    }

    public static c d(String str, int i, String str2, String str3) {
        c cVar = new c();
        cVar.HW(i);
        cVar.RI(str2);
        cVar.RQ("HOMEPAGE");
        cVar.setExtInfo(str);
        cVar.RR(str3);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c b2 = b(advertAppInfo, i, i2);
        b2.HY(i3);
        return b2;
    }

    public static c b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c c = c(advertAppInfo, i, i2);
        c.HY(i3);
        return c;
    }

    public static c a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        c a2 = a(dVar, 5, dVar.getPageNum());
        a2.HY(parseError.errorCode);
        return a2;
    }

    public static c o(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.HW(aVar.abr);
        cVar.HX(aVar.abu);
        cVar.RQ(aVar.abt);
        cVar.setExtInfo(aVar.extraParam);
        return cVar;
    }

    public static c p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.HW(aVar.abr);
        cVar.HX(aVar.abu);
        cVar.RQ(aVar.abt);
        cVar.setExtInfo(aVar.extraParam);
        cVar.HY(aVar.abg);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            cVar.RK(aVar.tplName);
        }
        cVar.Ia(aVar.abh);
        return cVar;
    }

    public static c q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.HW(aVar.abr);
        cVar.HX(aVar.abu);
        cVar.RQ(aVar.abt);
        cVar.setExtInfo(aVar.extraParam);
        cVar.HY(0);
        cVar.HZ(aVar.abv);
        cVar.Ia(aVar.totalDuration);
        cVar.Ib(aVar.startPosition);
        return cVar;
    }

    public static c r(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.HW(aVar.abr);
        cVar.HX(aVar.abu);
        cVar.RQ(aVar.abt);
        cVar.setExtInfo(aVar.extraParam);
        return cVar;
    }
}
