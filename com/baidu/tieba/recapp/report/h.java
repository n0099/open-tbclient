package com.baidu.tieba.recapp.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.afd.ParseError;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.o;
/* loaded from: classes.dex */
public class h {
    public static c b(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        cVar.Jk(i);
        cVar.RX(advertAppInfo.price);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.Jl(-1);
            cVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            cVar.Jl(advertAppInfo.eNX);
            cVar.setPageNumber(i2);
        } else {
            cVar.Jl(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            cVar.setPageNumber(i2);
        }
        cVar.Sa(advertAppInfo.eOf);
        cVar.Sb(advertAppInfo.eOg);
        cVar.Sc(advertAppInfo.eOh);
        cVar.Sd(advertAppInfo.page);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        cVar.Jk(i);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.Jl(-1);
            cVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            cVar.Jl(advertAppInfo.eNX);
            cVar.setPageNumber(i2);
        } else {
            cVar.Jl(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            cVar.setPageNumber(i2);
        }
        cVar.Se(str);
        cVar.Sd(advertAppInfo.page);
        return cVar;
    }

    public static c a(com.baidu.afd.d dVar, int i, int i2) {
        if (dVar == null) {
            return null;
        }
        return b(dVar.qU(), i, i2);
    }

    public static c c(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        cVar.Jk(i);
        cVar.RX(advertAppInfo.price);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.Jl(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.Jl(advertAppInfo.eNX);
            cVar.setPageNumber(i2);
        }
        cVar.Sa(advertAppInfo.eOf);
        cVar.Sb(advertAppInfo.eOg);
        cVar.Sc(advertAppInfo.eOh);
        cVar.Sd(advertAppInfo.page);
        return cVar;
    }

    public static c a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        c cVar = new c();
        cVar.setDownloadStaticsData(downloadStaticsData);
        cVar.Jk(i);
        cVar.setPageNumber(i2);
        return cVar;
    }

    public static c ad(int i, int i2, int i3) {
        c cVar = new c();
        cVar.Jk(i);
        cVar.Jl(i2);
        cVar.setPageNumber(i3);
        return cVar;
    }

    public static c b(o oVar, int i) {
        if (oVar == null || oVar.dOS() == null) {
            return null;
        }
        AppData dOS = oVar.dOS();
        c cVar = new c();
        cVar.setExtInfo(dOS.ext_info);
        if (oVar.nrr) {
            cVar.Jl(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.Jl(com.baidu.adp.lib.f.b.toInt(dOS.pos_name, 0));
            cVar.setPageNumber(oVar.pageNumber);
        }
        cVar.Jk(i);
        cVar.RX(dOS.price);
        cVar.Sa(oVar.eOf);
        cVar.Sb(oVar.eOg);
        cVar.Sc(oVar.forumId);
        cVar.Sd(oVar.dOV());
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        c b2 = b(advertAppInfo, i, i2);
        b2.Jm(i3);
        b2.Jn(i5);
        b2.Jo(i4);
        if (i6 != -1 && i == 32) {
            b2.Jq(i6);
        }
        b2.Sd(advertAppInfo.page);
        if (i == 2) {
            b2.RZ("video");
        }
        return b2;
    }

    public static c a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        c a2 = a(dVar, i, i2);
        a2.Jm(i3);
        a2.Jn(i5);
        a2.Jo(i4);
        if (i6 != -1 && i == 32) {
            a2.Jq(i6);
        }
        if (dVar != null) {
            a2.Sd(dVar.qU().page);
        }
        if (i == 2) {
            a2.RZ("video");
        }
        return a2;
    }

    public static c t(String str, int i, String str2) {
        return d(str, i, str2, "");
    }

    public static c d(String str, int i, String str2, String str3) {
        c cVar = new c();
        cVar.Jk(i);
        cVar.RW(str2);
        cVar.Sd("HOMEPAGE");
        cVar.setExtInfo(str);
        cVar.Se(str3);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c b2 = b(advertAppInfo, i, i2);
        b2.Jm(i3);
        return b2;
    }

    public static c b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c c = c(advertAppInfo, i, i2);
        c.Jm(i3);
        return c;
    }

    public static c a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        c a2 = a(dVar, 5, dVar.getPageNum());
        a2.Jm(parseError.errorCode);
        return a2;
    }

    public static c o(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Jk(aVar.aby);
        cVar.Jl(aVar.abA);
        cVar.Sd(aVar.abz);
        cVar.setExtInfo(aVar.extraParam);
        return cVar;
    }

    public static c p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Jk(aVar.aby);
        cVar.Jl(aVar.abA);
        cVar.Sd(aVar.abz);
        cVar.setExtInfo(aVar.extraParam);
        cVar.Jm(aVar.abm);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            cVar.RY(aVar.tplName);
        }
        cVar.Jo(aVar.abn);
        return cVar;
    }

    public static c q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Jk(aVar.aby);
        cVar.Jl(aVar.abA);
        cVar.Sd(aVar.abz);
        cVar.setExtInfo(aVar.extraParam);
        cVar.Jm(0);
        cVar.Jn(aVar.abC);
        cVar.Jo(aVar.abB);
        cVar.Jp(aVar.startPosition);
        return cVar;
    }

    public static c r(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Jk(aVar.aby);
        cVar.Jl(aVar.abA);
        cVar.Sd(aVar.abz);
        cVar.setExtInfo(aVar.extraParam);
        return cVar;
    }
}
