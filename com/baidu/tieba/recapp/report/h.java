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
        cVar.HD(i);
        cVar.QP(advertAppInfo.price);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.HE(-1);
            cVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            cVar.HE(advertAppInfo.eJm);
            cVar.setPageNumber(i2);
        } else {
            cVar.HE(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            cVar.setPageNumber(i2);
        }
        cVar.QS(advertAppInfo.eJu);
        cVar.QT(advertAppInfo.eJv);
        cVar.QU(advertAppInfo.eJw);
        cVar.QV(advertAppInfo.page);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        cVar.HD(i);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.HE(-1);
            cVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            cVar.HE(advertAppInfo.eJm);
            cVar.setPageNumber(i2);
        } else {
            cVar.HE(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            cVar.setPageNumber(i2);
        }
        cVar.QW(str);
        cVar.QV(advertAppInfo.page);
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
        cVar.HD(i);
        cVar.QP(advertAppInfo.price);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.HE(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.HE(advertAppInfo.eJm);
            cVar.setPageNumber(i2);
        }
        cVar.QS(advertAppInfo.eJu);
        cVar.QT(advertAppInfo.eJv);
        cVar.QU(advertAppInfo.eJw);
        cVar.QV(advertAppInfo.page);
        return cVar;
    }

    public static c a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        c cVar = new c();
        cVar.setDownloadStaticsData(downloadStaticsData);
        cVar.HD(i);
        cVar.setPageNumber(i2);
        return cVar;
    }

    public static c ad(int i, int i2, int i3) {
        c cVar = new c();
        cVar.HD(i);
        cVar.HE(i2);
        cVar.setPageNumber(i3);
        return cVar;
    }

    public static c b(o oVar, int i) {
        if (oVar == null || oVar.dLa() == null) {
            return null;
        }
        AppData dLa = oVar.dLa();
        c cVar = new c();
        cVar.setExtInfo(dLa.ext_info);
        if (oVar.nmK) {
            cVar.HE(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.HE(com.baidu.adp.lib.f.b.toInt(dLa.pos_name, 0));
            cVar.setPageNumber(oVar.pageNumber);
        }
        cVar.HD(i);
        cVar.QP(dLa.price);
        cVar.QS(oVar.eJu);
        cVar.QT(oVar.eJv);
        cVar.QU(oVar.forumId);
        cVar.QV(oVar.dLd());
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        c b2 = b(advertAppInfo, i, i2);
        b2.HF(i3);
        b2.HG(i5);
        b2.HH(i4);
        if (i6 != -1 && i == 32) {
            b2.HJ(i6);
        }
        b2.QV(advertAppInfo.page);
        if (i == 2) {
            b2.QR("video");
        }
        return b2;
    }

    public static c a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        c a2 = a(dVar, i, i2);
        a2.HF(i3);
        a2.HG(i5);
        a2.HH(i4);
        if (i6 != -1 && i == 32) {
            a2.HJ(i6);
        }
        if (dVar != null) {
            a2.QV(dVar.qU().page);
        }
        if (i == 2) {
            a2.QR("video");
        }
        return a2;
    }

    public static c t(String str, int i, String str2) {
        return d(str, i, str2, "");
    }

    public static c d(String str, int i, String str2, String str3) {
        c cVar = new c();
        cVar.HD(i);
        cVar.QO(str2);
        cVar.QV("HOMEPAGE");
        cVar.setExtInfo(str);
        cVar.QW(str3);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c b2 = b(advertAppInfo, i, i2);
        b2.HF(i3);
        return b2;
    }

    public static c b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c c = c(advertAppInfo, i, i2);
        c.HF(i3);
        return c;
    }

    public static c a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        c a2 = a(dVar, 5, dVar.getPageNum());
        a2.HF(parseError.errorCode);
        return a2;
    }

    public static c o(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.HD(aVar.abw);
        cVar.HE(aVar.aby);
        cVar.QV(aVar.abx);
        cVar.setExtInfo(aVar.extraParam);
        return cVar;
    }

    public static c p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.HD(aVar.abw);
        cVar.HE(aVar.aby);
        cVar.QV(aVar.abx);
        cVar.setExtInfo(aVar.extraParam);
        cVar.HF(aVar.abk);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            cVar.QQ(aVar.tplName);
        }
        cVar.HH(aVar.abl);
        return cVar;
    }

    public static c q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.HD(aVar.abw);
        cVar.HE(aVar.aby);
        cVar.QV(aVar.abx);
        cVar.setExtInfo(aVar.extraParam);
        cVar.HF(0);
        cVar.HG(aVar.abA);
        cVar.HH(aVar.abz);
        cVar.HI(aVar.startPosition);
        return cVar;
    }

    public static c r(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.HD(aVar.abw);
        cVar.HE(aVar.aby);
        cVar.QV(aVar.abx);
        cVar.setExtInfo(aVar.extraParam);
        return cVar;
    }
}
