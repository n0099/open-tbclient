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
        bVar.zE(i);
        bVar.DV(advertAppInfo.price);
        bVar.DT(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.zF(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.zF(advertAppInfo.bEY);
            bVar.setPageNumber(i2);
        } else {
            bVar.zF(com.baidu.adp.lib.g.b.f(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.DY(advertAppInfo.bFg);
        bVar.DZ(advertAppInfo.bFh);
        bVar.Ea(advertAppInfo.bFi);
        bVar.Eb(advertAppInfo.page);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.zE(i);
        bVar.DT(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.zF(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.zF(advertAppInfo.bEY);
            bVar.setPageNumber(i2);
        } else {
            bVar.zF(com.baidu.adp.lib.g.b.f(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.Ec(str);
        bVar.Eb(advertAppInfo.page);
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
        bVar.zE(i);
        bVar.DV(advertAppInfo.price);
        bVar.DT(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.zF(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.zF(advertAppInfo.bEY);
            bVar.setPageNumber(i2);
        }
        bVar.DY(advertAppInfo.bFg);
        bVar.DZ(advertAppInfo.bFh);
        bVar.Ea(advertAppInfo.bFi);
        bVar.Eb(advertAppInfo.page);
        return bVar;
    }

    public static b a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        b bVar = new b();
        bVar.setDownloadStaticsData(downloadStaticsData);
        bVar.zE(i);
        bVar.setPageNumber(i2);
        return bVar;
    }

    public static b af(int i, int i2, int i3) {
        b bVar = new b();
        bVar.zE(i);
        bVar.zF(i2);
        bVar.setPageNumber(i3);
        return bVar;
    }

    public static b c(m mVar, int i) {
        if (mVar == null || mVar.cpd() == null) {
            return null;
        }
        AppData cpd = mVar.cpd();
        b bVar = new b();
        bVar.DT(cpd.ext_info);
        if (mVar.jeU) {
            bVar.zF(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.zF(com.baidu.adp.lib.g.b.f(cpd.pos_name, 0));
            bVar.setPageNumber(mVar.pageNumber);
        }
        bVar.zE(i);
        bVar.DV(cpd.price);
        bVar.DY(mVar.bFg);
        bVar.DZ(mVar.bFh);
        bVar.Ea(mVar.forumId);
        bVar.Eb(mVar.cpg());
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        b c = c(advertAppInfo, i, i2);
        c.zG(i3);
        c.zH(i5);
        c.zI(i4);
        if (i6 != -1 && i == 32) {
            c.zK(i6);
        }
        c.Eb(advertAppInfo.page);
        if (i == 2) {
            c.DX("video");
        }
        return c;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        b a = a(dVar, i, i2);
        a.zG(i3);
        a.zH(i5);
        a.zI(i4);
        if (i6 != -1 && i == 32) {
            a.zK(i6);
        }
        if (dVar != null) {
            a.Eb(dVar.ph().page);
        }
        if (i == 2) {
            a.DX("video");
        }
        return a;
    }

    public static b s(String str, int i, String str2) {
        return b(str, i, str2, "");
    }

    public static b b(String str, int i, String str2, String str3) {
        b bVar = new b();
        bVar.zE(i);
        bVar.DU(str2);
        bVar.Eb("HOMEPAGE");
        bVar.DT(str);
        bVar.Ec(str3);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b c = c(advertAppInfo, i, i2);
        c.zG(i3);
        return c;
    }

    public static b b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b d = d(advertAppInfo, i, i2);
        d.zG(i3);
        return d;
    }

    public static b a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        b a = a(dVar, 5, dVar.getPageNum());
        a.zG(parseError.errorCode);
        return a;
    }

    public static b o(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.zE(aVar.Ss);
        bVar.zF(aVar.Su);
        bVar.Eb(aVar.St);
        bVar.DT(aVar.extraParam);
        return bVar;
    }

    public static b p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.zE(aVar.Ss);
        bVar.zF(aVar.Su);
        bVar.Eb(aVar.St);
        bVar.DT(aVar.extraParam);
        bVar.zG(aVar.Sh);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            bVar.DW(aVar.tplName);
        }
        bVar.zI(aVar.Si);
        return bVar;
    }

    public static b q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.zE(aVar.Ss);
        bVar.zF(aVar.Su);
        bVar.Eb(aVar.St);
        bVar.DT(aVar.extraParam);
        bVar.zG(0);
        bVar.zH(aVar.Sw);
        bVar.zI(aVar.Sv);
        bVar.zJ(aVar.Sx);
        return bVar;
    }

    public static b r(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.zE(aVar.Ss);
        bVar.zF(aVar.Su);
        bVar.Eb(aVar.St);
        bVar.DT(aVar.extraParam);
        return bVar;
    }
}
