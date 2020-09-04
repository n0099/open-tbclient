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
        cVar.Gl(i);
        cVar.PD(advertAppInfo.price);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.Gm(-1);
            cVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            cVar.Gm(advertAppInfo.dWn);
            cVar.setPageNumber(i2);
        } else {
            cVar.Gm(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            cVar.setPageNumber(i2);
        }
        cVar.PG(advertAppInfo.dWv);
        cVar.PH(advertAppInfo.dWw);
        cVar.PI(advertAppInfo.dWx);
        cVar.PJ(advertAppInfo.page);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        cVar.Gl(i);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.Gm(-1);
            cVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            cVar.Gm(advertAppInfo.dWn);
            cVar.setPageNumber(i2);
        } else {
            cVar.Gm(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            cVar.setPageNumber(i2);
        }
        cVar.PK(str);
        cVar.PJ(advertAppInfo.page);
        return cVar;
    }

    public static c a(com.baidu.afd.d dVar, int i, int i2) {
        if (dVar == null) {
            return null;
        }
        return c(dVar.rl(), i, i2);
    }

    public static c d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        cVar.Gl(i);
        cVar.PD(advertAppInfo.price);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.Gm(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.Gm(advertAppInfo.dWn);
            cVar.setPageNumber(i2);
        }
        cVar.PG(advertAppInfo.dWv);
        cVar.PH(advertAppInfo.dWw);
        cVar.PI(advertAppInfo.dWx);
        cVar.PJ(advertAppInfo.page);
        return cVar;
    }

    public static c a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        c cVar = new c();
        cVar.setDownloadStaticsData(downloadStaticsData);
        cVar.Gl(i);
        cVar.setPageNumber(i2);
        return cVar;
    }

    public static c X(int i, int i2, int i3) {
        c cVar = new c();
        cVar.Gl(i);
        cVar.Gm(i2);
        cVar.setPageNumber(i3);
        return cVar;
    }

    public static c c(n nVar, int i) {
        if (nVar == null || nVar.dwy() == null) {
            return null;
        }
        AppData dwy = nVar.dwy();
        c cVar = new c();
        cVar.setExtInfo(dwy.ext_info);
        if (nVar.meZ) {
            cVar.Gm(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.Gm(com.baidu.adp.lib.f.b.toInt(dwy.pos_name, 0));
            cVar.setPageNumber(nVar.pageNumber);
        }
        cVar.Gl(i);
        cVar.PD(dwy.price);
        cVar.PG(nVar.dWv);
        cVar.PH(nVar.dWw);
        cVar.PI(nVar.forumId);
        cVar.PJ(nVar.dwB());
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        c c = c(advertAppInfo, i, i2);
        c.Gn(i3);
        c.Go(i5);
        c.Gp(i4);
        if (i6 != -1 && i == 32) {
            c.Gr(i6);
        }
        c.PJ(advertAppInfo.page);
        if (i == 2) {
            c.PF("video");
        }
        return c;
    }

    public static c a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        c a = a(dVar, i, i2);
        a.Gn(i3);
        a.Go(i5);
        a.Gp(i4);
        if (i6 != -1 && i == 32) {
            a.Gr(i6);
        }
        if (dVar != null) {
            a.PJ(dVar.rl().page);
        }
        if (i == 2) {
            a.PF("video");
        }
        return a;
    }

    public static c r(String str, int i, String str2) {
        return d(str, i, str2, "");
    }

    public static c d(String str, int i, String str2, String str3) {
        c cVar = new c();
        cVar.Gl(i);
        cVar.PC(str2);
        cVar.PJ("HOMEPAGE");
        cVar.setExtInfo(str);
        cVar.PK(str3);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c c = c(advertAppInfo, i, i2);
        c.Gn(i3);
        return c;
    }

    public static c b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c d = d(advertAppInfo, i, i2);
        d.Gn(i3);
        return d;
    }

    public static c a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        c a = a(dVar, 5, dVar.getPageNum());
        a.Gn(parseError.errorCode);
        return a;
    }

    public static c o(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Gl(aVar.Zc);
        cVar.Gm(aVar.Zf);
        cVar.PJ(aVar.Ze);
        cVar.setExtInfo(aVar.extraParam);
        return cVar;
    }

    public static c p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Gl(aVar.Zc);
        cVar.Gm(aVar.Zf);
        cVar.PJ(aVar.Ze);
        cVar.setExtInfo(aVar.extraParam);
        cVar.Gn(aVar.YR);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            cVar.PE(aVar.tplName);
        }
        cVar.Gp(aVar.YS);
        return cVar;
    }

    public static c q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Gl(aVar.Zc);
        cVar.Gm(aVar.Zf);
        cVar.PJ(aVar.Ze);
        cVar.setExtInfo(aVar.extraParam);
        cVar.Gn(0);
        cVar.Go(aVar.Zh);
        cVar.Gp(aVar.Zg);
        cVar.Gq(aVar.startPosition);
        return cVar;
    }

    public static c r(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Gl(aVar.Zc);
        cVar.Gm(aVar.Zf);
        cVar.PJ(aVar.Ze);
        cVar.setExtInfo(aVar.extraParam);
        return cVar;
    }
}
