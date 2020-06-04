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
        cVar.Cs(i);
        cVar.Lx(advertAppInfo.price);
        cVar.Lv(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.Ct(-1);
            cVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            cVar.Ct(advertAppInfo.dAy);
            cVar.setPageNumber(i2);
        } else {
            cVar.Ct(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            cVar.setPageNumber(i2);
        }
        cVar.LA(advertAppInfo.dAG);
        cVar.LB(advertAppInfo.dAH);
        cVar.LC(advertAppInfo.dAI);
        cVar.LD(advertAppInfo.page);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        cVar.Cs(i);
        cVar.Lv(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.Ct(-1);
            cVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            cVar.Ct(advertAppInfo.dAy);
            cVar.setPageNumber(i2);
        } else {
            cVar.Ct(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            cVar.setPageNumber(i2);
        }
        cVar.LE(str);
        cVar.LD(advertAppInfo.page);
        return cVar;
    }

    public static c a(com.baidu.afd.d dVar, int i, int i2) {
        if (dVar == null) {
            return null;
        }
        return c(dVar.pu(), i, i2);
    }

    public static c d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        cVar.Cs(i);
        cVar.Lx(advertAppInfo.price);
        cVar.Lv(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.Ct(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.Ct(advertAppInfo.dAy);
            cVar.setPageNumber(i2);
        }
        cVar.LA(advertAppInfo.dAG);
        cVar.LB(advertAppInfo.dAH);
        cVar.LC(advertAppInfo.dAI);
        cVar.LD(advertAppInfo.page);
        return cVar;
    }

    public static c a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        c cVar = new c();
        cVar.setDownloadStaticsData(downloadStaticsData);
        cVar.Cs(i);
        cVar.setPageNumber(i2);
        return cVar;
    }

    public static c ab(int i, int i2, int i3) {
        c cVar = new c();
        cVar.Cs(i);
        cVar.Ct(i2);
        cVar.setPageNumber(i3);
        return cVar;
    }

    public static c c(n nVar, int i) {
        if (nVar == null || nVar.ddx() == null) {
            return null;
        }
        AppData ddx = nVar.ddx();
        c cVar = new c();
        cVar.Lv(ddx.ext_info);
        if (nVar.llP) {
            cVar.Ct(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.Ct(com.baidu.adp.lib.f.b.toInt(ddx.pos_name, 0));
            cVar.setPageNumber(nVar.pageNumber);
        }
        cVar.Cs(i);
        cVar.Lx(ddx.price);
        cVar.LA(nVar.dAG);
        cVar.LB(nVar.dAH);
        cVar.LC(nVar.forumId);
        cVar.LD(nVar.ddA());
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        c c = c(advertAppInfo, i, i2);
        c.Cu(i3);
        c.Cv(i5);
        c.Cw(i4);
        if (i6 != -1 && i == 32) {
            c.Cy(i6);
        }
        c.LD(advertAppInfo.page);
        if (i == 2) {
            c.Lz("video");
        }
        return c;
    }

    public static c a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        c a = a(dVar, i, i2);
        a.Cu(i3);
        a.Cv(i5);
        a.Cw(i4);
        if (i6 != -1 && i == 32) {
            a.Cy(i6);
        }
        if (dVar != null) {
            a.LD(dVar.pu().page);
        }
        if (i == 2) {
            a.Lz("video");
        }
        return a;
    }

    public static c s(String str, int i, String str2) {
        return c(str, i, str2, "");
    }

    public static c c(String str, int i, String str2, String str3) {
        c cVar = new c();
        cVar.Cs(i);
        cVar.Lw(str2);
        cVar.LD("HOMEPAGE");
        cVar.Lv(str);
        cVar.LE(str3);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c c = c(advertAppInfo, i, i2);
        c.Cu(i3);
        return c;
    }

    public static c b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c d = d(advertAppInfo, i, i2);
        d.Cu(i3);
        return d;
    }

    public static c a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        c a = a(dVar, 5, dVar.getPageNum());
        a.Cu(parseError.errorCode);
        return a;
    }

    public static c o(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Cs(aVar.Ya);
        cVar.Ct(aVar.Yc);
        cVar.LD(aVar.Yb);
        cVar.Lv(aVar.extraParam);
        return cVar;
    }

    public static c p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Cs(aVar.Ya);
        cVar.Ct(aVar.Yc);
        cVar.LD(aVar.Yb);
        cVar.Lv(aVar.extraParam);
        cVar.Cu(aVar.XP);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            cVar.Ly(aVar.tplName);
        }
        cVar.Cw(aVar.XQ);
        return cVar;
    }

    public static c q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Cs(aVar.Ya);
        cVar.Ct(aVar.Yc);
        cVar.LD(aVar.Yb);
        cVar.Lv(aVar.extraParam);
        cVar.Cu(0);
        cVar.Cv(aVar.Yf);
        cVar.Cw(aVar.Ye);
        cVar.Cx(aVar.startPosition);
        return cVar;
    }

    public static c r(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Cs(aVar.Ya);
        cVar.Ct(aVar.Yc);
        cVar.LD(aVar.Yb);
        cVar.Lv(aVar.extraParam);
        return cVar;
    }
}
