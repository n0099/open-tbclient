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
        cVar.HL(i);
        cVar.Rp(advertAppInfo.price);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.HM(-1);
            cVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            cVar.HM(advertAppInfo.esY);
            cVar.setPageNumber(i2);
        } else {
            cVar.HM(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            cVar.setPageNumber(i2);
        }
        cVar.Rs(advertAppInfo.eth);
        cVar.Rt(advertAppInfo.eti);
        cVar.Ru(advertAppInfo.etj);
        cVar.Rv(advertAppInfo.page);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        cVar.HL(i);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.HM(-1);
            cVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            cVar.HM(advertAppInfo.esY);
            cVar.setPageNumber(i2);
        } else {
            cVar.HM(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            cVar.setPageNumber(i2);
        }
        cVar.Rw(str);
        cVar.Rv(advertAppInfo.page);
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
        cVar.HL(i);
        cVar.Rp(advertAppInfo.price);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.HM(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.HM(advertAppInfo.esY);
            cVar.setPageNumber(i2);
        }
        cVar.Rs(advertAppInfo.eth);
        cVar.Rt(advertAppInfo.eti);
        cVar.Ru(advertAppInfo.etj);
        cVar.Rv(advertAppInfo.page);
        return cVar;
    }

    public static c a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        c cVar = new c();
        cVar.setDownloadStaticsData(downloadStaticsData);
        cVar.HL(i);
        cVar.setPageNumber(i2);
        return cVar;
    }

    public static c aa(int i, int i2, int i3) {
        c cVar = new c();
        cVar.HL(i);
        cVar.HM(i2);
        cVar.setPageNumber(i3);
        return cVar;
    }

    public static c c(n nVar, int i) {
        if (nVar == null || nVar.dHl() == null) {
            return null;
        }
        AppData dHl = nVar.dHl();
        c cVar = new c();
        cVar.setExtInfo(dHl.ext_info);
        if (nVar.mQK) {
            cVar.HM(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.HM(com.baidu.adp.lib.f.b.toInt(dHl.pos_name, 0));
            cVar.setPageNumber(nVar.pageNumber);
        }
        cVar.HL(i);
        cVar.Rp(dHl.price);
        cVar.Rs(nVar.eth);
        cVar.Rt(nVar.eti);
        cVar.Ru(nVar.forumId);
        cVar.Rv(nVar.dHo());
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        c c = c(advertAppInfo, i, i2);
        c.HN(i3);
        c.HO(i5);
        c.HP(i4);
        if (i6 != -1 && i == 32) {
            c.HR(i6);
        }
        c.Rv(advertAppInfo.page);
        if (i == 2) {
            c.Rr("video");
        }
        return c;
    }

    public static c a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        c a2 = a(dVar, i, i2);
        a2.HN(i3);
        a2.HO(i5);
        a2.HP(i4);
        if (i6 != -1 && i == 32) {
            a2.HR(i6);
        }
        if (dVar != null) {
            a2.Rv(dVar.rq().page);
        }
        if (i == 2) {
            a2.Rr("video");
        }
        return a2;
    }

    public static c t(String str, int i, String str2) {
        return d(str, i, str2, "");
    }

    public static c d(String str, int i, String str2, String str3) {
        c cVar = new c();
        cVar.HL(i);
        cVar.Ro(str2);
        cVar.Rv("HOMEPAGE");
        cVar.setExtInfo(str);
        cVar.Rw(str3);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c c = c(advertAppInfo, i, i2);
        c.HN(i3);
        return c;
    }

    public static c b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c d = d(advertAppInfo, i, i2);
        d.HN(i3);
        return d;
    }

    public static c a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        c a2 = a(dVar, 5, dVar.getPageNum());
        a2.HN(parseError.errorCode);
        return a2;
    }

    public static c o(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.HL(aVar.ZM);
        cVar.HM(aVar.ZO);
        cVar.Rv(aVar.ZN);
        cVar.setExtInfo(aVar.extraParam);
        return cVar;
    }

    public static c p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.HL(aVar.ZM);
        cVar.HM(aVar.ZO);
        cVar.Rv(aVar.ZN);
        cVar.setExtInfo(aVar.extraParam);
        cVar.HN(aVar.ZB);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            cVar.Rq(aVar.tplName);
        }
        cVar.HP(aVar.ZC);
        return cVar;
    }

    public static c q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.HL(aVar.ZM);
        cVar.HM(aVar.ZO);
        cVar.Rv(aVar.ZN);
        cVar.setExtInfo(aVar.extraParam);
        cVar.HN(0);
        cVar.HO(aVar.ZQ);
        cVar.HP(aVar.ZP);
        cVar.HQ(aVar.startPosition);
        return cVar;
    }

    public static c r(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.HL(aVar.ZM);
        cVar.HM(aVar.ZO);
        cVar.Rv(aVar.ZN);
        cVar.setExtInfo(aVar.extraParam);
        return cVar;
    }
}
