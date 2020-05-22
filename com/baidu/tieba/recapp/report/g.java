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
        cVar.Cq(i);
        cVar.Lw(advertAppInfo.price);
        cVar.Lu(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.Cr(-1);
            cVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            cVar.Cr(advertAppInfo.dAy);
            cVar.setPageNumber(i2);
        } else {
            cVar.Cr(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            cVar.setPageNumber(i2);
        }
        cVar.Lz(advertAppInfo.dAG);
        cVar.LA(advertAppInfo.dAH);
        cVar.LB(advertAppInfo.dAI);
        cVar.LC(advertAppInfo.page);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        cVar.Cq(i);
        cVar.Lu(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.Cr(-1);
            cVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            cVar.Cr(advertAppInfo.dAy);
            cVar.setPageNumber(i2);
        } else {
            cVar.Cr(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            cVar.setPageNumber(i2);
        }
        cVar.LD(str);
        cVar.LC(advertAppInfo.page);
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
        cVar.Cq(i);
        cVar.Lw(advertAppInfo.price);
        cVar.Lu(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.Cr(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.Cr(advertAppInfo.dAy);
            cVar.setPageNumber(i2);
        }
        cVar.Lz(advertAppInfo.dAG);
        cVar.LA(advertAppInfo.dAH);
        cVar.LB(advertAppInfo.dAI);
        cVar.LC(advertAppInfo.page);
        return cVar;
    }

    public static c a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        c cVar = new c();
        cVar.setDownloadStaticsData(downloadStaticsData);
        cVar.Cq(i);
        cVar.setPageNumber(i2);
        return cVar;
    }

    public static c ab(int i, int i2, int i3) {
        c cVar = new c();
        cVar.Cq(i);
        cVar.Cr(i2);
        cVar.setPageNumber(i3);
        return cVar;
    }

    public static c c(n nVar, int i) {
        if (nVar == null || nVar.ddi() == null) {
            return null;
        }
        AppData ddi = nVar.ddi();
        c cVar = new c();
        cVar.Lu(ddi.ext_info);
        if (nVar.lkG) {
            cVar.Cr(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.Cr(com.baidu.adp.lib.f.b.toInt(ddi.pos_name, 0));
            cVar.setPageNumber(nVar.pageNumber);
        }
        cVar.Cq(i);
        cVar.Lw(ddi.price);
        cVar.Lz(nVar.dAG);
        cVar.LA(nVar.dAH);
        cVar.LB(nVar.forumId);
        cVar.LC(nVar.ddl());
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        c c = c(advertAppInfo, i, i2);
        c.Cs(i3);
        c.Ct(i5);
        c.Cu(i4);
        if (i6 != -1 && i == 32) {
            c.Cw(i6);
        }
        c.LC(advertAppInfo.page);
        if (i == 2) {
            c.Ly("video");
        }
        return c;
    }

    public static c a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        c a = a(dVar, i, i2);
        a.Cs(i3);
        a.Ct(i5);
        a.Cu(i4);
        if (i6 != -1 && i == 32) {
            a.Cw(i6);
        }
        if (dVar != null) {
            a.LC(dVar.pu().page);
        }
        if (i == 2) {
            a.Ly("video");
        }
        return a;
    }

    public static c s(String str, int i, String str2) {
        return c(str, i, str2, "");
    }

    public static c c(String str, int i, String str2, String str3) {
        c cVar = new c();
        cVar.Cq(i);
        cVar.Lv(str2);
        cVar.LC("HOMEPAGE");
        cVar.Lu(str);
        cVar.LD(str3);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c c = c(advertAppInfo, i, i2);
        c.Cs(i3);
        return c;
    }

    public static c b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c d = d(advertAppInfo, i, i2);
        d.Cs(i3);
        return d;
    }

    public static c a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        c a = a(dVar, 5, dVar.getPageNum());
        a.Cs(parseError.errorCode);
        return a;
    }

    public static c o(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Cq(aVar.Ya);
        cVar.Cr(aVar.Yc);
        cVar.LC(aVar.Yb);
        cVar.Lu(aVar.extraParam);
        return cVar;
    }

    public static c p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Cq(aVar.Ya);
        cVar.Cr(aVar.Yc);
        cVar.LC(aVar.Yb);
        cVar.Lu(aVar.extraParam);
        cVar.Cs(aVar.XP);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            cVar.Lx(aVar.tplName);
        }
        cVar.Cu(aVar.XQ);
        return cVar;
    }

    public static c q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Cq(aVar.Ya);
        cVar.Cr(aVar.Yc);
        cVar.LC(aVar.Yb);
        cVar.Lu(aVar.extraParam);
        cVar.Cs(0);
        cVar.Ct(aVar.Yf);
        cVar.Cu(aVar.Ye);
        cVar.Cv(aVar.startPosition);
        return cVar;
    }

    public static c r(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Cq(aVar.Ya);
        cVar.Cr(aVar.Yc);
        cVar.LC(aVar.Yb);
        cVar.Lu(aVar.extraParam);
        return cVar;
    }
}
