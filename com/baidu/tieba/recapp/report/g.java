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
        cVar.GM(i);
        cVar.Qd(advertAppInfo.price);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.GN(-1);
            cVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            cVar.GN(advertAppInfo.dYx);
            cVar.setPageNumber(i2);
        } else {
            cVar.GN(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            cVar.setPageNumber(i2);
        }
        cVar.Qg(advertAppInfo.dYF);
        cVar.Qh(advertAppInfo.dYG);
        cVar.Qi(advertAppInfo.dYH);
        cVar.Qj(advertAppInfo.page);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        cVar.GM(i);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.GN(-1);
            cVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            cVar.GN(advertAppInfo.dYx);
            cVar.setPageNumber(i2);
        } else {
            cVar.GN(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            cVar.setPageNumber(i2);
        }
        cVar.Qk(str);
        cVar.Qj(advertAppInfo.page);
        return cVar;
    }

    public static c a(com.baidu.afd.d dVar, int i, int i2) {
        if (dVar == null) {
            return null;
        }
        return c(dVar.rq(), i, i2);
    }

    public static c d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        cVar.GM(i);
        cVar.Qd(advertAppInfo.price);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.GN(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.GN(advertAppInfo.dYx);
            cVar.setPageNumber(i2);
        }
        cVar.Qg(advertAppInfo.dYF);
        cVar.Qh(advertAppInfo.dYG);
        cVar.Qi(advertAppInfo.dYH);
        cVar.Qj(advertAppInfo.page);
        return cVar;
    }

    public static c a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        c cVar = new c();
        cVar.setDownloadStaticsData(downloadStaticsData);
        cVar.GM(i);
        cVar.setPageNumber(i2);
        return cVar;
    }

    public static c Z(int i, int i2, int i3) {
        c cVar = new c();
        cVar.GM(i);
        cVar.GN(i2);
        cVar.setPageNumber(i3);
        return cVar;
    }

    public static c c(n nVar, int i) {
        if (nVar == null || nVar.dAr() == null) {
            return null;
        }
        AppData dAr = nVar.dAr();
        c cVar = new c();
        cVar.setExtInfo(dAr.ext_info);
        if (nVar.moy) {
            cVar.GN(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.GN(com.baidu.adp.lib.f.b.toInt(dAr.pos_name, 0));
            cVar.setPageNumber(nVar.pageNumber);
        }
        cVar.GM(i);
        cVar.Qd(dAr.price);
        cVar.Qg(nVar.dYF);
        cVar.Qh(nVar.dYG);
        cVar.Qi(nVar.forumId);
        cVar.Qj(nVar.dAu());
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        c c = c(advertAppInfo, i, i2);
        c.GO(i3);
        c.GP(i5);
        c.GQ(i4);
        if (i6 != -1 && i == 32) {
            c.GS(i6);
        }
        c.Qj(advertAppInfo.page);
        if (i == 2) {
            c.Qf("video");
        }
        return c;
    }

    public static c a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        c a = a(dVar, i, i2);
        a.GO(i3);
        a.GP(i5);
        a.GQ(i4);
        if (i6 != -1 && i == 32) {
            a.GS(i6);
        }
        if (dVar != null) {
            a.Qj(dVar.rq().page);
        }
        if (i == 2) {
            a.Qf("video");
        }
        return a;
    }

    public static c r(String str, int i, String str2) {
        return d(str, i, str2, "");
    }

    public static c d(String str, int i, String str2, String str3) {
        c cVar = new c();
        cVar.GM(i);
        cVar.Qc(str2);
        cVar.Qj("HOMEPAGE");
        cVar.setExtInfo(str);
        cVar.Qk(str3);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c c = c(advertAppInfo, i, i2);
        c.GO(i3);
        return c;
    }

    public static c b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c d = d(advertAppInfo, i, i2);
        d.GO(i3);
        return d;
    }

    public static c a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        c a = a(dVar, 5, dVar.getPageNum());
        a.GO(parseError.errorCode);
        return a;
    }

    public static c o(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.GM(aVar.Zv);
        cVar.GN(aVar.Zx);
        cVar.Qj(aVar.Zw);
        cVar.setExtInfo(aVar.extraParam);
        return cVar;
    }

    public static c p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.GM(aVar.Zv);
        cVar.GN(aVar.Zx);
        cVar.Qj(aVar.Zw);
        cVar.setExtInfo(aVar.extraParam);
        cVar.GO(aVar.Zk);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            cVar.Qe(aVar.tplName);
        }
        cVar.GQ(aVar.Zl);
        return cVar;
    }

    public static c q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.GM(aVar.Zv);
        cVar.GN(aVar.Zx);
        cVar.Qj(aVar.Zw);
        cVar.setExtInfo(aVar.extraParam);
        cVar.GO(0);
        cVar.GP(aVar.Zz);
        cVar.GQ(aVar.Zy);
        cVar.GR(aVar.startPosition);
        return cVar;
    }

    public static c r(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.GM(aVar.Zv);
        cVar.GN(aVar.Zx);
        cVar.Qj(aVar.Zw);
        cVar.setExtInfo(aVar.extraParam);
        return cVar;
    }
}
