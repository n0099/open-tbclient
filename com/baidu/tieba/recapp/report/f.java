package com.baidu.tieba.recapp.report;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.afd.ParseError;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.m;
/* loaded from: classes.dex */
public class f {
    public static b c(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.zG(i);
        bVar.DW(advertAppInfo.price);
        bVar.DU(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.zH(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.zH(advertAppInfo.bEZ);
            bVar.setPageNumber(i2);
        } else {
            bVar.zH(com.baidu.adp.lib.g.b.f(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.DZ(advertAppInfo.bFh);
        bVar.Ea(advertAppInfo.bFi);
        bVar.Eb(advertAppInfo.bFj);
        bVar.Ec(advertAppInfo.page);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.zG(i);
        bVar.DU(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.zH(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.zH(advertAppInfo.bEZ);
            bVar.setPageNumber(i2);
        } else {
            bVar.zH(com.baidu.adp.lib.g.b.f(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.Ed(str);
        bVar.Ec(advertAppInfo.page);
        return bVar;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2) {
        if (dVar == null) {
            return null;
        }
        return c(dVar.ph(), i, i2);
    }

    public static b d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.zG(i);
        bVar.DW(advertAppInfo.price);
        bVar.DU(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.zH(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.zH(advertAppInfo.bEZ);
            bVar.setPageNumber(i2);
        }
        bVar.DZ(advertAppInfo.bFh);
        bVar.Ea(advertAppInfo.bFi);
        bVar.Eb(advertAppInfo.bFj);
        bVar.Ec(advertAppInfo.page);
        return bVar;
    }

    public static b a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        b bVar = new b();
        bVar.setDownloadStaticsData(downloadStaticsData);
        bVar.zG(i);
        bVar.setPageNumber(i2);
        return bVar;
    }

    public static b af(int i, int i2, int i3) {
        b bVar = new b();
        bVar.zG(i);
        bVar.zH(i2);
        bVar.setPageNumber(i3);
        return bVar;
    }

    public static b c(m mVar, int i) {
        if (mVar == null || mVar.cpz() == null) {
            return null;
        }
        AppData cpz = mVar.cpz();
        b bVar = new b();
        bVar.DU(cpz.ext_info);
        if (mVar.jgb) {
            bVar.zH(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.zH(com.baidu.adp.lib.g.b.f(cpz.pos_name, 0));
            bVar.setPageNumber(mVar.pageNumber);
        }
        bVar.zG(i);
        bVar.DW(cpz.price);
        bVar.DZ(mVar.bFh);
        bVar.Ea(mVar.bFi);
        bVar.Eb(mVar.forumId);
        bVar.Ec(mVar.cpC());
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        b c = c(advertAppInfo, i, i2);
        c.zI(i3);
        c.zJ(i5);
        c.zK(i4);
        if (i6 != -1 && i == 32) {
            c.zM(i6);
        }
        c.Ec(advertAppInfo.page);
        if (i == 2) {
            c.DY("video");
        }
        return c;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        b a = a(dVar, i, i2);
        a.zI(i3);
        a.zJ(i5);
        a.zK(i4);
        if (i6 != -1 && i == 32) {
            a.zM(i6);
        }
        if (dVar != null) {
            a.Ec(dVar.ph().page);
        }
        if (i == 2) {
            a.DY("video");
        }
        return a;
    }

    public static b s(String str, int i, String str2) {
        return b(str, i, str2, "");
    }

    public static b b(String str, int i, String str2, String str3) {
        b bVar = new b();
        bVar.zG(i);
        bVar.DV(str2);
        bVar.Ec("HOMEPAGE");
        bVar.DU(str);
        bVar.Ed(str3);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b c = c(advertAppInfo, i, i2);
        c.zI(i3);
        return c;
    }

    public static b b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b d = d(advertAppInfo, i, i2);
        d.zI(i3);
        return d;
    }

    public static b a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        b a = a(dVar, 5, dVar.getPageNum());
        a.zI(parseError.errorCode);
        return a;
    }

    public static b o(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.zG(aVar.Ss);
        bVar.zH(aVar.Su);
        bVar.Ec(aVar.St);
        bVar.DU(aVar.extraParam);
        return bVar;
    }

    public static b p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.zG(aVar.Ss);
        bVar.zH(aVar.Su);
        bVar.Ec(aVar.St);
        bVar.DU(aVar.extraParam);
        bVar.zI(aVar.Sh);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            bVar.DX(aVar.tplName);
        }
        bVar.zK(aVar.Si);
        return bVar;
    }

    public static b q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.zG(aVar.Ss);
        bVar.zH(aVar.Su);
        bVar.Ec(aVar.St);
        bVar.DU(aVar.extraParam);
        bVar.zI(0);
        bVar.zJ(aVar.Sw);
        bVar.zK(aVar.Sv);
        bVar.zL(aVar.Sx);
        return bVar;
    }

    public static b r(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.zG(aVar.Ss);
        bVar.zH(aVar.Su);
        bVar.Ec(aVar.St);
        bVar.DU(aVar.extraParam);
        return bVar;
    }
}
