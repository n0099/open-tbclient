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
        if (advertAppInfo.eLL) {
            if (i == 3) {
                i = 103;
            } else if (i == 2) {
                i = 102;
            }
            str = "RETARGET";
        }
        cVar.Sc(str);
        cVar.HW(i);
        cVar.RV(advertAppInfo.price);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.HX(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.HX(advertAppInfo.position + 1);
            cVar.setPageNumber(i2);
        }
        cVar.RZ(advertAppInfo.eLF);
        cVar.Sa(advertAppInfo.eLG);
        cVar.Sb(advertAppInfo.eLH);
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
        if (advertAppInfo.eLL) {
            if (i == 3) {
                i = 103;
            } else if (i == 2) {
                i = 102;
            }
            str = "RETARGET";
        }
        cVar.Sc(str);
        cVar.HW(i);
        cVar.RV(advertAppInfo.price);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.HX(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.HX(advertAppInfo.position + 1);
            cVar.setPageNumber(i2);
        }
        cVar.RZ(advertAppInfo.eLF);
        cVar.Sa(advertAppInfo.eLG);
        cVar.Sb(advertAppInfo.eLH);
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
        if (oVar == null || oVar.dNt() == null) {
            return null;
        }
        AppData dNt = oVar.dNt();
        String dNw = oVar.dNw();
        if (oVar.eLL) {
            if (i == 3) {
                i = 103;
            } else if (i == 2) {
                i = 102;
            }
            dNw = "RETARGET";
        }
        c cVar = new c();
        cVar.setExtInfo(dNt.ext_info);
        if (oVar.nwV) {
            cVar.HX(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.HX(oVar.position + 1);
            cVar.setPageNumber(oVar.pageNumber);
        }
        cVar.HW(i);
        cVar.RV(dNt.price);
        cVar.RZ(oVar.eLF);
        cVar.Sa(oVar.eLG);
        cVar.Sb(oVar.forumId);
        cVar.Sc(dNw);
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
        b2.Sc(advertAppInfo.page);
        if (i == 2) {
            b2.RY("video");
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
            a2.Sc(dVar.qS().page);
        }
        if (i == 2) {
            a2.RY("video");
        }
        return a2;
    }

    public static c t(String str, int i, String str2) {
        return d(str, i, str2, "");
    }

    public static c d(String str, int i, String str2, String str3) {
        c cVar = new c();
        cVar.HW(i);
        cVar.RU(str2);
        cVar.Sc("HOMEPAGE");
        cVar.setExtInfo(str);
        cVar.Sd(str3);
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
        cVar.Sc(aVar.abt);
        cVar.setExtInfo(aVar.extraParam);
        return cVar;
    }

    public static c p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.HW(aVar.abr);
        cVar.HX(aVar.abu);
        cVar.Sc(aVar.abt);
        cVar.setExtInfo(aVar.extraParam);
        cVar.HY(aVar.abg);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            cVar.RW(aVar.tplName);
        }
        cVar.Ia(aVar.abh);
        return cVar;
    }

    public static c q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.HW(aVar.abr);
        cVar.HX(aVar.abu);
        cVar.Sc(aVar.abt);
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
        cVar.Sc(aVar.abt);
        cVar.setExtInfo(aVar.extraParam);
        return cVar;
    }
}
