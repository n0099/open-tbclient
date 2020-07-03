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
        cVar.Du(i);
        cVar.LY(advertAppInfo.price);
        cVar.LW(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.Dv(-1);
            cVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            cVar.Dv(advertAppInfo.dGP);
            cVar.setPageNumber(i2);
        } else {
            cVar.Dv(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            cVar.setPageNumber(i2);
        }
        cVar.Mb(advertAppInfo.dGX);
        cVar.Mc(advertAppInfo.dGY);
        cVar.Md(advertAppInfo.dGZ);
        cVar.Me(advertAppInfo.page);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        cVar.Du(i);
        cVar.LW(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.Dv(-1);
            cVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            cVar.Dv(advertAppInfo.dGP);
            cVar.setPageNumber(i2);
        } else {
            cVar.Dv(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            cVar.setPageNumber(i2);
        }
        cVar.Mf(str);
        cVar.Me(advertAppInfo.page);
        return cVar;
    }

    public static c a(com.baidu.afd.d dVar, int i, int i2) {
        if (dVar == null) {
            return null;
        }
        return c(dVar.pL(), i, i2);
    }

    public static c d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        cVar.Du(i);
        cVar.LY(advertAppInfo.price);
        cVar.LW(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.Dv(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.Dv(advertAppInfo.dGP);
            cVar.setPageNumber(i2);
        }
        cVar.Mb(advertAppInfo.dGX);
        cVar.Mc(advertAppInfo.dGY);
        cVar.Md(advertAppInfo.dGZ);
        cVar.Me(advertAppInfo.page);
        return cVar;
    }

    public static c a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        c cVar = new c();
        cVar.setDownloadStaticsData(downloadStaticsData);
        cVar.Du(i);
        cVar.setPageNumber(i2);
        return cVar;
    }

    public static c ab(int i, int i2, int i3) {
        c cVar = new c();
        cVar.Du(i);
        cVar.Dv(i2);
        cVar.setPageNumber(i3);
        return cVar;
    }

    public static c c(n nVar, int i) {
        if (nVar == null || nVar.dhM() == null) {
            return null;
        }
        AppData dhM = nVar.dhM();
        c cVar = new c();
        cVar.LW(dhM.ext_info);
        if (nVar.lFJ) {
            cVar.Dv(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.Dv(com.baidu.adp.lib.f.b.toInt(dhM.pos_name, 0));
            cVar.setPageNumber(nVar.pageNumber);
        }
        cVar.Du(i);
        cVar.LY(dhM.price);
        cVar.Mb(nVar.dGX);
        cVar.Mc(nVar.dGY);
        cVar.Md(nVar.forumId);
        cVar.Me(nVar.dhP());
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        c c = c(advertAppInfo, i, i2);
        c.Dw(i3);
        c.Dx(i5);
        c.Dy(i4);
        if (i6 != -1 && i == 32) {
            c.DA(i6);
        }
        c.Me(advertAppInfo.page);
        if (i == 2) {
            c.Ma("video");
        }
        return c;
    }

    public static c a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        c a = a(dVar, i, i2);
        a.Dw(i3);
        a.Dx(i5);
        a.Dy(i4);
        if (i6 != -1 && i == 32) {
            a.DA(i6);
        }
        if (dVar != null) {
            a.Me(dVar.pL().page);
        }
        if (i == 2) {
            a.Ma("video");
        }
        return a;
    }

    public static c s(String str, int i, String str2) {
        return c(str, i, str2, "");
    }

    public static c c(String str, int i, String str2, String str3) {
        c cVar = new c();
        cVar.Du(i);
        cVar.LX(str2);
        cVar.Me("HOMEPAGE");
        cVar.LW(str);
        cVar.Mf(str3);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c c = c(advertAppInfo, i, i2);
        c.Dw(i3);
        return c;
    }

    public static c b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c d = d(advertAppInfo, i, i2);
        d.Dw(i3);
        return d;
    }

    public static c a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        c a = a(dVar, 5, dVar.getPageNum());
        a.Dw(parseError.errorCode);
        return a;
    }

    public static c o(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Du(aVar.YF);
        cVar.Dv(aVar.YH);
        cVar.Me(aVar.YG);
        cVar.LW(aVar.extraParam);
        return cVar;
    }

    public static c p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Du(aVar.YF);
        cVar.Dv(aVar.YH);
        cVar.Me(aVar.YG);
        cVar.LW(aVar.extraParam);
        cVar.Dw(aVar.Yu);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            cVar.LZ(aVar.tplName);
        }
        cVar.Dy(aVar.Yv);
        return cVar;
    }

    public static c q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Du(aVar.YF);
        cVar.Dv(aVar.YH);
        cVar.Me(aVar.YG);
        cVar.LW(aVar.extraParam);
        cVar.Dw(0);
        cVar.Dx(aVar.YJ);
        cVar.Dy(aVar.YI);
        cVar.Dz(aVar.startPosition);
        return cVar;
    }

    public static c r(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Du(aVar.YF);
        cVar.Dv(aVar.YH);
        cVar.Me(aVar.YG);
        cVar.LW(aVar.extraParam);
        return cVar;
    }
}
