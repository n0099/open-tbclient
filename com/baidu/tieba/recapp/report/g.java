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
        cVar.Iz(i);
        cVar.Re(advertAppInfo.price);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.IA(-1);
            cVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            cVar.IA(advertAppInfo.exg);
            cVar.setPageNumber(i2);
        } else {
            cVar.IA(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            cVar.setPageNumber(i2);
        }
        cVar.Rh(advertAppInfo.exo);
        cVar.Ri(advertAppInfo.exp);
        cVar.Rj(advertAppInfo.exq);
        cVar.Rk(advertAppInfo.page);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        cVar.Iz(i);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.IA(-1);
            cVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            cVar.IA(advertAppInfo.exg);
            cVar.setPageNumber(i2);
        } else {
            cVar.IA(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            cVar.setPageNumber(i2);
        }
        cVar.Rl(str);
        cVar.Rk(advertAppInfo.page);
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
        cVar.Iz(i);
        cVar.Re(advertAppInfo.price);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.IA(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.IA(advertAppInfo.exg);
            cVar.setPageNumber(i2);
        }
        cVar.Rh(advertAppInfo.exo);
        cVar.Ri(advertAppInfo.exp);
        cVar.Rj(advertAppInfo.exq);
        cVar.Rk(advertAppInfo.page);
        return cVar;
    }

    public static c a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        c cVar = new c();
        cVar.setDownloadStaticsData(downloadStaticsData);
        cVar.Iz(i);
        cVar.setPageNumber(i2);
        return cVar;
    }

    public static c ac(int i, int i2, int i3) {
        c cVar = new c();
        cVar.Iz(i);
        cVar.IA(i2);
        cVar.setPageNumber(i3);
        return cVar;
    }

    public static c c(n nVar, int i) {
        if (nVar == null || nVar.dJE() == null) {
            return null;
        }
        AppData dJE = nVar.dJE();
        c cVar = new c();
        cVar.setExtInfo(dJE.ext_info);
        if (nVar.mXG) {
            cVar.IA(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.IA(com.baidu.adp.lib.f.b.toInt(dJE.pos_name, 0));
            cVar.setPageNumber(nVar.pageNumber);
        }
        cVar.Iz(i);
        cVar.Re(dJE.price);
        cVar.Rh(nVar.exo);
        cVar.Ri(nVar.exp);
        cVar.Rj(nVar.forumId);
        cVar.Rk(nVar.dJH());
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        c c = c(advertAppInfo, i, i2);
        c.IB(i3);
        c.IC(i5);
        c.ID(i4);
        if (i6 != -1 && i == 32) {
            c.IF(i6);
        }
        c.Rk(advertAppInfo.page);
        if (i == 2) {
            c.Rg("video");
        }
        return c;
    }

    public static c a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        c a2 = a(dVar, i, i2);
        a2.IB(i3);
        a2.IC(i5);
        a2.ID(i4);
        if (i6 != -1 && i == 32) {
            a2.IF(i6);
        }
        if (dVar != null) {
            a2.Rk(dVar.rq().page);
        }
        if (i == 2) {
            a2.Rg("video");
        }
        return a2;
    }

    public static c u(String str, int i, String str2) {
        return d(str, i, str2, "");
    }

    public static c d(String str, int i, String str2, String str3) {
        c cVar = new c();
        cVar.Iz(i);
        cVar.Rd(str2);
        cVar.Rk("HOMEPAGE");
        cVar.setExtInfo(str);
        cVar.Rl(str3);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c c = c(advertAppInfo, i, i2);
        c.IB(i3);
        return c;
    }

    public static c b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c d = d(advertAppInfo, i, i2);
        d.IB(i3);
        return d;
    }

    public static c a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        c a2 = a(dVar, 5, dVar.getPageNum());
        a2.IB(parseError.errorCode);
        return a2;
    }

    public static c o(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Iz(aVar.ZR);
        cVar.IA(aVar.ZT);
        cVar.Rk(aVar.ZS);
        cVar.setExtInfo(aVar.extraParam);
        return cVar;
    }

    public static c p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Iz(aVar.ZR);
        cVar.IA(aVar.ZT);
        cVar.Rk(aVar.ZS);
        cVar.setExtInfo(aVar.extraParam);
        cVar.IB(aVar.ZG);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            cVar.Rf(aVar.tplName);
        }
        cVar.ID(aVar.ZH);
        return cVar;
    }

    public static c q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Iz(aVar.ZR);
        cVar.IA(aVar.ZT);
        cVar.Rk(aVar.ZS);
        cVar.setExtInfo(aVar.extraParam);
        cVar.IB(0);
        cVar.IC(aVar.ZV);
        cVar.ID(aVar.ZU);
        cVar.IE(aVar.startPosition);
        return cVar;
    }

    public static c r(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Iz(aVar.ZR);
        cVar.IA(aVar.ZT);
        cVar.Rk(aVar.ZS);
        cVar.setExtInfo(aVar.extraParam);
        return cVar;
    }
}
