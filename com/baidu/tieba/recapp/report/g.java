package com.baidu.tieba.recapp.report;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.afd.ParseError;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.n;
/* loaded from: classes.dex */
public class g {
    public static c c(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        cVar.DQ(i);
        cVar.MG(advertAppInfo.price);
        cVar.ME(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.DR(-1);
            cVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            cVar.DR(advertAppInfo.dNa);
            cVar.setPageNumber(i2);
        } else {
            cVar.DR(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            cVar.setPageNumber(i2);
        }
        cVar.MJ(advertAppInfo.dNi);
        cVar.MK(advertAppInfo.dNj);
        cVar.ML(advertAppInfo.dNk);
        cVar.MM(advertAppInfo.page);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        cVar.DQ(i);
        cVar.ME(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.DR(-1);
            cVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            cVar.DR(advertAppInfo.dNa);
            cVar.setPageNumber(i2);
        } else {
            cVar.DR(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            cVar.setPageNumber(i2);
        }
        cVar.MN(str);
        cVar.MM(advertAppInfo.page);
        return cVar;
    }

    public static c a(com.baidu.afd.d dVar, int i, int i2) {
        if (dVar == null) {
            return null;
        }
        return c(dVar.pM(), i, i2);
    }

    public static c d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        cVar.DQ(i);
        cVar.MG(advertAppInfo.price);
        cVar.ME(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.DR(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.DR(advertAppInfo.dNa);
            cVar.setPageNumber(i2);
        }
        cVar.MJ(advertAppInfo.dNi);
        cVar.MK(advertAppInfo.dNj);
        cVar.ML(advertAppInfo.dNk);
        cVar.MM(advertAppInfo.page);
        return cVar;
    }

    public static c a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        c cVar = new c();
        cVar.setDownloadStaticsData(downloadStaticsData);
        cVar.DQ(i);
        cVar.setPageNumber(i2);
        return cVar;
    }

    public static c Y(int i, int i2, int i3) {
        c cVar = new c();
        cVar.DQ(i);
        cVar.DR(i2);
        cVar.setPageNumber(i3);
        return cVar;
    }

    public static c c(n nVar, int i) {
        if (nVar == null || nVar.dkW() == null) {
            return null;
        }
        AppData dkW = nVar.dkW();
        c cVar = new c();
        cVar.ME(dkW.ext_info);
        if (nVar.lNa) {
            cVar.DR(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.DR(com.baidu.adp.lib.f.b.toInt(dkW.pos_name, 0));
            cVar.setPageNumber(nVar.pageNumber);
        }
        cVar.DQ(i);
        cVar.MG(dkW.price);
        cVar.MJ(nVar.dNi);
        cVar.MK(nVar.dNj);
        cVar.ML(nVar.forumId);
        cVar.MM(nVar.dkZ());
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        c c = c(advertAppInfo, i, i2);
        c.DS(i3);
        c.DT(i5);
        c.DU(i4);
        if (i6 != -1 && i == 32) {
            c.DW(i6);
        }
        c.MM(advertAppInfo.page);
        if (i == 2) {
            c.MI("video");
        }
        return c;
    }

    public static c a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        c a = a(dVar, i, i2);
        a.DS(i3);
        a.DT(i5);
        a.DU(i4);
        if (i6 != -1 && i == 32) {
            a.DW(i6);
        }
        if (dVar != null) {
            a.MM(dVar.pM().page);
        }
        if (i == 2) {
            a.MI("video");
        }
        return a;
    }

    public static c s(String str, int i, String str2) {
        return c(str, i, str2, "");
    }

    public static c c(String str, int i, String str2, String str3) {
        c cVar = new c();
        cVar.DQ(i);
        cVar.MF(str2);
        cVar.MM("HOMEPAGE");
        cVar.ME(str);
        cVar.MN(str3);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c c = c(advertAppInfo, i, i2);
        c.DS(i3);
        return c;
    }

    public static c b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c d = d(advertAppInfo, i, i2);
        d.DS(i3);
        return d;
    }

    public static c a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        c a = a(dVar, 5, dVar.getPageNum());
        a.DS(parseError.errorCode);
        return a;
    }

    public static c o(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.DQ(aVar.Yv);
        cVar.DR(aVar.Yx);
        cVar.MM(aVar.Yw);
        cVar.ME(aVar.extraParam);
        return cVar;
    }

    public static c p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.DQ(aVar.Yv);
        cVar.DR(aVar.Yx);
        cVar.MM(aVar.Yw);
        cVar.ME(aVar.extraParam);
        cVar.DS(aVar.Yk);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            cVar.MH(aVar.tplName);
        }
        cVar.DU(aVar.Yl);
        return cVar;
    }

    public static c q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.DQ(aVar.Yv);
        cVar.DR(aVar.Yx);
        cVar.MM(aVar.Yw);
        cVar.ME(aVar.extraParam);
        cVar.DS(0);
        cVar.DT(aVar.Yz);
        cVar.DU(aVar.Yy);
        cVar.DV(aVar.startPosition);
        return cVar;
    }

    public static c r(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.DQ(aVar.Yv);
        cVar.DR(aVar.Yx);
        cVar.MM(aVar.Yw);
        cVar.ME(aVar.extraParam);
        return cVar;
    }
}
