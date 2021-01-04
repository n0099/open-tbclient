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
        cVar.RY(advertAppInfo.price);
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
        cVar.Sb(advertAppInfo.eOf);
        cVar.Sc(advertAppInfo.eOg);
        cVar.Sd(advertAppInfo.eOh);
        cVar.Se(advertAppInfo.page);
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
        cVar.Sf(str);
        cVar.Se(advertAppInfo.page);
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
        cVar.RY(advertAppInfo.price);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.Jl(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.Jl(advertAppInfo.eNX);
            cVar.setPageNumber(i2);
        }
        cVar.Sb(advertAppInfo.eOf);
        cVar.Sc(advertAppInfo.eOg);
        cVar.Sd(advertAppInfo.eOh);
        cVar.Se(advertAppInfo.page);
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
        if (oVar == null || oVar.dOR() == null) {
            return null;
        }
        AppData dOR = oVar.dOR();
        c cVar = new c();
        cVar.setExtInfo(dOR.ext_info);
        if (oVar.nrs) {
            cVar.Jl(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.Jl(com.baidu.adp.lib.f.b.toInt(dOR.pos_name, 0));
            cVar.setPageNumber(oVar.pageNumber);
        }
        cVar.Jk(i);
        cVar.RY(dOR.price);
        cVar.Sb(oVar.eOf);
        cVar.Sc(oVar.eOg);
        cVar.Sd(oVar.forumId);
        cVar.Se(oVar.dOU());
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
        b2.Se(advertAppInfo.page);
        if (i == 2) {
            b2.Sa("video");
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
            a2.Se(dVar.qU().page);
        }
        if (i == 2) {
            a2.Sa("video");
        }
        return a2;
    }

    public static c t(String str, int i, String str2) {
        return d(str, i, str2, "");
    }

    public static c d(String str, int i, String str2, String str3) {
        c cVar = new c();
        cVar.Jk(i);
        cVar.RX(str2);
        cVar.Se("HOMEPAGE");
        cVar.setExtInfo(str);
        cVar.Sf(str3);
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
        cVar.Se(aVar.abz);
        cVar.setExtInfo(aVar.extraParam);
        return cVar;
    }

    public static c p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Jk(aVar.aby);
        cVar.Jl(aVar.abA);
        cVar.Se(aVar.abz);
        cVar.setExtInfo(aVar.extraParam);
        cVar.Jm(aVar.abm);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            cVar.RZ(aVar.tplName);
        }
        cVar.Jo(aVar.abn);
        return cVar;
    }

    public static c q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Jk(aVar.aby);
        cVar.Jl(aVar.abA);
        cVar.Se(aVar.abz);
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
        cVar.Se(aVar.abz);
        cVar.setExtInfo(aVar.extraParam);
        return cVar;
    }
}
