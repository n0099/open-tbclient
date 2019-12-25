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
        bVar.AK(i);
        bVar.HE(advertAppInfo.price);
        bVar.HC(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.AL(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.AL(advertAppInfo.cIL);
            bVar.setPageNumber(i2);
        } else {
            bVar.AL(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.HH(advertAppInfo.cIT);
        bVar.HI(advertAppInfo.cIU);
        bVar.HJ(advertAppInfo.cIV);
        bVar.HK(advertAppInfo.page);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.AK(i);
        bVar.HC(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.AL(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.AL(advertAppInfo.cIL);
            bVar.setPageNumber(i2);
        } else {
            bVar.AL(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.HL(str);
        bVar.HK(advertAppInfo.page);
        return bVar;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2) {
        if (dVar == null) {
            return null;
        }
        return c(dVar.ku(), i, i2);
    }

    public static b d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.AK(i);
        bVar.HE(advertAppInfo.price);
        bVar.HC(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.AL(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.AL(advertAppInfo.cIL);
            bVar.setPageNumber(i2);
        }
        bVar.HH(advertAppInfo.cIT);
        bVar.HI(advertAppInfo.cIU);
        bVar.HJ(advertAppInfo.cIV);
        bVar.HK(advertAppInfo.page);
        return bVar;
    }

    public static b a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        b bVar = new b();
        bVar.setDownloadStaticsData(downloadStaticsData);
        bVar.AK(i);
        bVar.setPageNumber(i2);
        return bVar;
    }

    public static b X(int i, int i2, int i3) {
        b bVar = new b();
        bVar.AK(i);
        bVar.AL(i2);
        bVar.setPageNumber(i3);
        return bVar;
    }

    public static b c(m mVar, int i) {
        if (mVar == null || mVar.cIh() == null) {
            return null;
        }
        AppData cIh = mVar.cIh();
        b bVar = new b();
        bVar.HC(cIh.ext_info);
        if (mVar.kbG) {
            bVar.AL(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.AL(com.baidu.adp.lib.f.b.toInt(cIh.pos_name, 0));
            bVar.setPageNumber(mVar.pageNumber);
        }
        bVar.AK(i);
        bVar.HE(cIh.price);
        bVar.HH(mVar.cIT);
        bVar.HI(mVar.cIU);
        bVar.HJ(mVar.forumId);
        bVar.HK(mVar.cIk());
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        b c = c(advertAppInfo, i, i2);
        c.AM(i3);
        c.AN(i5);
        c.AO(i4);
        if (i6 != -1 && i == 32) {
            c.AQ(i6);
        }
        c.HK(advertAppInfo.page);
        if (i == 2) {
            c.HG("video");
        }
        return c;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        b a = a(dVar, i, i2);
        a.AM(i3);
        a.AN(i5);
        a.AO(i4);
        if (i6 != -1 && i == 32) {
            a.AQ(i6);
        }
        if (dVar != null) {
            a.HK(dVar.ku().page);
        }
        if (i == 2) {
            a.HG("video");
        }
        return a;
    }

    public static b t(String str, int i, String str2) {
        return c(str, i, str2, "");
    }

    public static b c(String str, int i, String str2, String str3) {
        b bVar = new b();
        bVar.AK(i);
        bVar.HD(str2);
        bVar.HK("HOMEPAGE");
        bVar.HC(str);
        bVar.HL(str3);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b c = c(advertAppInfo, i, i2);
        c.AM(i3);
        return c;
    }

    public static b b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b d = d(advertAppInfo, i, i2);
        d.AM(i3);
        return d;
    }

    public static b a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        b a = a(dVar, 5, dVar.getPageNum());
        a.AM(parseError.errorCode);
        return a;
    }

    public static b o(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.AK(aVar.DT);
        bVar.AL(aVar.DV);
        bVar.HK(aVar.DU);
        bVar.HC(aVar.extraParam);
        return bVar;
    }

    public static b p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.AK(aVar.DT);
        bVar.AL(aVar.DV);
        bVar.HK(aVar.DU);
        bVar.HC(aVar.extraParam);
        bVar.AM(aVar.DG);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            bVar.HF(aVar.tplName);
        }
        bVar.AO(aVar.DH);
        return bVar;
    }

    public static b q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.AK(aVar.DT);
        bVar.AL(aVar.DV);
        bVar.HK(aVar.DU);
        bVar.HC(aVar.extraParam);
        bVar.AM(0);
        bVar.AN(aVar.DX);
        bVar.AO(aVar.DW);
        bVar.AP(aVar.startPosition);
        return bVar;
    }

    public static b r(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.AK(aVar.DT);
        bVar.AL(aVar.DV);
        bVar.HK(aVar.DU);
        bVar.HC(aVar.extraParam);
        return bVar;
    }
}
