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
        String str = advertAppInfo.page;
        if (advertAppInfo.eNm) {
            if (i == 3) {
                i = 103;
            } else if (i == 2) {
                i = 102;
            }
            str = "RETARGET";
        }
        cVar.Si(str);
        cVar.Ia(i);
        cVar.Sb(advertAppInfo.price);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.Ib(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.Ib(advertAppInfo.position + 1);
            cVar.setPageNumber(i2);
        }
        cVar.Sf(advertAppInfo.eNg);
        cVar.Sg(advertAppInfo.eNh);
        cVar.Sh(advertAppInfo.eNi);
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
        String str = advertAppInfo.page;
        if (advertAppInfo.eNm) {
            if (i == 3) {
                i = 103;
            } else if (i == 2) {
                i = 102;
            }
            str = "RETARGET";
        }
        cVar.Si(str);
        cVar.Ia(i);
        cVar.Sb(advertAppInfo.price);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.Ib(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.Ib(advertAppInfo.position + 1);
            cVar.setPageNumber(i2);
        }
        cVar.Sf(advertAppInfo.eNg);
        cVar.Sg(advertAppInfo.eNh);
        cVar.Sh(advertAppInfo.eNi);
        return cVar;
    }

    public static c a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        c cVar = new c();
        cVar.setDownloadStaticsData(downloadStaticsData);
        cVar.Ia(i);
        cVar.setPageNumber(i2);
        return cVar;
    }

    public static c ab(int i, int i2, int i3) {
        c cVar = new c();
        cVar.Ia(i);
        cVar.Ib(i2);
        cVar.setPageNumber(i3);
        return cVar;
    }

    public static c b(o oVar, int i) {
        if (oVar == null || oVar.dNC() == null) {
            return null;
        }
        AppData dNC = oVar.dNC();
        String dNF = oVar.dNF();
        if (oVar.eNm) {
            if (i == 3) {
                i = 103;
            } else if (i == 2) {
                i = 102;
            }
            dNF = "RETARGET";
        }
        c cVar = new c();
        cVar.setExtInfo(dNC.ext_info);
        if (oVar.nza) {
            cVar.Ib(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.Ib(oVar.position + 1);
            cVar.setPageNumber(oVar.pageNumber);
        }
        cVar.Ia(i);
        cVar.Sb(dNC.price);
        cVar.Sf(oVar.eNg);
        cVar.Sg(oVar.eNh);
        cVar.Sh(oVar.forumId);
        cVar.Si(dNF);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        c b = b(advertAppInfo, i, i2);
        b.Ic(i3);
        b.Id(i5);
        b.Ie(i4);
        if (i6 != -1 && i == 32) {
            b.Ig(i6);
        }
        b.Si(advertAppInfo.page);
        if (i == 2) {
            b.Se("video");
        }
        return b;
    }

    public static c a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        c a2 = a(dVar, i, i2);
        a2.Ic(i3);
        a2.Id(i5);
        a2.Ie(i4);
        if (i6 != -1 && i == 32) {
            a2.Ig(i6);
        }
        if (dVar != null) {
            a2.Si(dVar.qS().page);
        }
        if (i == 2) {
            a2.Se("video");
        }
        return a2;
    }

    public static c u(String str, int i, String str2) {
        return d(str, i, str2, "");
    }

    public static c d(String str, int i, String str2, String str3) {
        c cVar = new c();
        cVar.Ia(i);
        cVar.Sa(str2);
        cVar.Si("HOMEPAGE");
        cVar.setExtInfo(str);
        cVar.Sj(str3);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c b = b(advertAppInfo, i, i2);
        b.Ic(i3);
        return b;
    }

    public static c b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c c = c(advertAppInfo, i, i2);
        c.Ic(i3);
        return c;
    }

    public static c a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        c a2 = a(dVar, 5, dVar.getPageNum());
        a2.Ic(parseError.errorCode);
        return a2;
    }

    public static c o(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Ia(aVar.acO);
        cVar.Ib(aVar.acQ);
        cVar.Si(aVar.acP);
        cVar.setExtInfo(aVar.extraParam);
        return cVar;
    }

    public static c p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Ia(aVar.acO);
        cVar.Ib(aVar.acQ);
        cVar.Si(aVar.acP);
        cVar.setExtInfo(aVar.extraParam);
        cVar.Ic(aVar.acD);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            cVar.Sc(aVar.tplName);
        }
        cVar.Ie(aVar.acE);
        return cVar;
    }

    public static c q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Ia(aVar.acO);
        cVar.Ib(aVar.acQ);
        cVar.Si(aVar.acP);
        cVar.setExtInfo(aVar.extraParam);
        cVar.Ic(0);
        cVar.Id(aVar.acR);
        cVar.Ie(aVar.totalDuration);
        cVar.If(aVar.startPosition);
        return cVar;
    }

    public static c r(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Ia(aVar.acO);
        cVar.Ib(aVar.acQ);
        cVar.Si(aVar.acP);
        cVar.setExtInfo(aVar.extraParam);
        return cVar;
    }
}
