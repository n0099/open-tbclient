package com.baidu.tieba.recapp.report;

import com.baidu.afd.ParseError;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.l;
/* loaded from: classes.dex */
public class f {
    public static b c(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.uj(i);
        bVar.vh(advertAppInfo.price);
        bVar.vf(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.uk(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.uk(advertAppInfo.apY);
            bVar.setPageNumber(i2);
        } else {
            bVar.uk(com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.vj(advertAppInfo.aqg);
        bVar.vk(advertAppInfo.aqh);
        bVar.vl(advertAppInfo.aqi);
        bVar.vm(advertAppInfo.page);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.uj(i);
        bVar.vf(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.uk(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.uk(advertAppInfo.apY);
            bVar.setPageNumber(i2);
        } else {
            bVar.uk(com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.vn(str);
        bVar.vm(advertAppInfo.page);
        return bVar;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2) {
        if (dVar == null) {
            return null;
        }
        return c(dVar.py(), i, i2);
    }

    public static b d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.uj(i);
        bVar.vh(advertAppInfo.price);
        bVar.vf(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.uk(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.uk(advertAppInfo.apY);
            bVar.setPageNumber(i2);
        }
        bVar.vj(advertAppInfo.aqg);
        bVar.vk(advertAppInfo.aqh);
        bVar.vl(advertAppInfo.aqi);
        bVar.vm(advertAppInfo.page);
        return bVar;
    }

    public static b a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        b bVar = new b();
        bVar.setDownloadStaticsData(downloadStaticsData);
        bVar.uj(i);
        bVar.setPageNumber(i2);
        return bVar;
    }

    public static b aa(int i, int i2, int i3) {
        b bVar = new b();
        bVar.uj(i);
        bVar.uk(i2);
        bVar.setPageNumber(i3);
        return bVar;
    }

    public static b c(l lVar, int i) {
        if (lVar == null || lVar.bEG() == null) {
            return null;
        }
        AppData bEG = lVar.bEG();
        b bVar = new b();
        bVar.vf(bEG.ext_info);
        if (lVar.hpA) {
            bVar.uk(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.uk(com.baidu.adp.lib.g.b.l(bEG.pos_name, 0));
            bVar.setPageNumber(lVar.pageNumber);
        }
        bVar.uj(i);
        bVar.vh(bEG.price);
        bVar.vj(lVar.aqg);
        bVar.vk(lVar.aqh);
        bVar.vl(lVar.forumId);
        bVar.vm(lVar.bEJ());
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        b c = c(advertAppInfo, i, i2);
        c.ul(i3);
        c.um(i5);
        c.un(i4);
        if (i6 != -1 && i == 32) {
            c.uo(i6);
        }
        c.vm(advertAppInfo.page);
        if (i == 2) {
            c.vi("video");
        }
        return c;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        b a = a(dVar, i, i2);
        a.ul(i3);
        a.um(i5);
        a.un(i4);
        if (i6 != -1 && i == 32) {
            a.uo(i6);
        }
        if (dVar != null) {
            a.vm(dVar.py().page);
        }
        if (i == 2) {
            a.vi("video");
        }
        return a;
    }

    public static b l(String str, int i, String str2) {
        return b(str, i, str2, "");
    }

    public static b b(String str, int i, String str2, String str3) {
        b bVar = new b();
        bVar.uj(i);
        bVar.vg(str2);
        bVar.vm("HOMEPAGE");
        bVar.vf(str);
        bVar.vn(str3);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b c = c(advertAppInfo, i, i2);
        c.ul(i3);
        return c;
    }

    public static b b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b d = d(advertAppInfo, i, i2);
        d.ul(i3);
        return d;
    }

    public static b a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        b a = a(dVar, 5, dVar.getPageNum());
        a.ul(parseError.errorCode);
        return a;
    }
}
