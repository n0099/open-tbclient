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
        cVar.Jq(i);
        cVar.Sq(advertAppInfo.price);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.Jr(-1);
            cVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            cVar.Jr(advertAppInfo.eEh);
            cVar.setPageNumber(i2);
        } else {
            cVar.Jr(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            cVar.setPageNumber(i2);
        }
        cVar.St(advertAppInfo.eEp);
        cVar.Su(advertAppInfo.eEq);
        cVar.Sv(advertAppInfo.eEr);
        cVar.Sw(advertAppInfo.page);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        cVar.Jq(i);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.Jr(-1);
            cVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            cVar.Jr(advertAppInfo.eEh);
            cVar.setPageNumber(i2);
        } else {
            cVar.Jr(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            cVar.setPageNumber(i2);
        }
        cVar.Sx(str);
        cVar.Sw(advertAppInfo.page);
        return cVar;
    }

    public static c a(com.baidu.afd.d dVar, int i, int i2) {
        if (dVar == null) {
            return null;
        }
        return c(dVar.rs(), i, i2);
    }

    public static c d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        cVar.Jq(i);
        cVar.Sq(advertAppInfo.price);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.Jr(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.Jr(advertAppInfo.eEh);
            cVar.setPageNumber(i2);
        }
        cVar.St(advertAppInfo.eEp);
        cVar.Su(advertAppInfo.eEq);
        cVar.Sv(advertAppInfo.eEr);
        cVar.Sw(advertAppInfo.page);
        return cVar;
    }

    public static c a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        c cVar = new c();
        cVar.setDownloadStaticsData(downloadStaticsData);
        cVar.Jq(i);
        cVar.setPageNumber(i2);
        return cVar;
    }

    public static c ab(int i, int i2, int i3) {
        c cVar = new c();
        cVar.Jq(i);
        cVar.Jr(i2);
        cVar.setPageNumber(i3);
        return cVar;
    }

    public static c c(n nVar, int i) {
        if (nVar == null || nVar.dOV() == null) {
            return null;
        }
        AppData dOV = nVar.dOV();
        c cVar = new c();
        cVar.setExtInfo(dOV.ext_info);
        if (nVar.nlG) {
            cVar.Jr(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.Jr(com.baidu.adp.lib.f.b.toInt(dOV.pos_name, 0));
            cVar.setPageNumber(nVar.pageNumber);
        }
        cVar.Jq(i);
        cVar.Sq(dOV.price);
        cVar.St(nVar.eEp);
        cVar.Su(nVar.eEq);
        cVar.Sv(nVar.forumId);
        cVar.Sw(nVar.dOY());
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        c c = c(advertAppInfo, i, i2);
        c.Js(i3);
        c.Jt(i5);
        c.Ju(i4);
        if (i6 != -1 && i == 32) {
            c.Jw(i6);
        }
        c.Sw(advertAppInfo.page);
        if (i == 2) {
            c.Ss("video");
        }
        return c;
    }

    public static c a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        c a2 = a(dVar, i, i2);
        a2.Js(i3);
        a2.Jt(i5);
        a2.Ju(i4);
        if (i6 != -1 && i == 32) {
            a2.Jw(i6);
        }
        if (dVar != null) {
            a2.Sw(dVar.rs().page);
        }
        if (i == 2) {
            a2.Ss("video");
        }
        return a2;
    }

    public static c u(String str, int i, String str2) {
        return d(str, i, str2, "");
    }

    public static c d(String str, int i, String str2, String str3) {
        c cVar = new c();
        cVar.Jq(i);
        cVar.Sp(str2);
        cVar.Sw("HOMEPAGE");
        cVar.setExtInfo(str);
        cVar.Sx(str3);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c c = c(advertAppInfo, i, i2);
        c.Js(i3);
        return c;
    }

    public static c b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c d = d(advertAppInfo, i, i2);
        d.Js(i3);
        return d;
    }

    public static c a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        c a2 = a(dVar, 5, dVar.getPageNum());
        a2.Js(parseError.errorCode);
        return a2;
    }

    public static c o(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Jq(aVar.aaN);
        cVar.Jr(aVar.aaP);
        cVar.Sw(aVar.aaO);
        cVar.setExtInfo(aVar.extraParam);
        return cVar;
    }

    public static c p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Jq(aVar.aaN);
        cVar.Jr(aVar.aaP);
        cVar.Sw(aVar.aaO);
        cVar.setExtInfo(aVar.extraParam);
        cVar.Js(aVar.aaC);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            cVar.Sr(aVar.tplName);
        }
        cVar.Ju(aVar.aaD);
        return cVar;
    }

    public static c q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Jq(aVar.aaN);
        cVar.Jr(aVar.aaP);
        cVar.Sw(aVar.aaO);
        cVar.setExtInfo(aVar.extraParam);
        cVar.Js(0);
        cVar.Jt(aVar.aaR);
        cVar.Ju(aVar.aaQ);
        cVar.Jv(aVar.startPosition);
        return cVar;
    }

    public static c r(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Jq(aVar.aaN);
        cVar.Jr(aVar.aaP);
        cVar.Sw(aVar.aaO);
        cVar.setExtInfo(aVar.extraParam);
        return cVar;
    }
}
