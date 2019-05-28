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
        bVar.yZ(i);
        bVar.Dg(advertAppInfo.price);
        bVar.De(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.za(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.za(advertAppInfo.bDX);
            bVar.setPageNumber(i2);
        } else {
            bVar.za(com.baidu.adp.lib.g.b.f(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.Dj(advertAppInfo.bEf);
        bVar.Dk(advertAppInfo.bEg);
        bVar.Dl(advertAppInfo.bEh);
        bVar.Dm(advertAppInfo.page);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.yZ(i);
        bVar.De(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.za(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.za(advertAppInfo.bDX);
            bVar.setPageNumber(i2);
        } else {
            bVar.za(com.baidu.adp.lib.g.b.f(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.Dn(str);
        bVar.Dm(advertAppInfo.page);
        return bVar;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2) {
        if (dVar == null) {
            return null;
        }
        return c(dVar.oM(), i, i2);
    }

    public static b d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.yZ(i);
        bVar.Dg(advertAppInfo.price);
        bVar.De(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.za(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.za(advertAppInfo.bDX);
            bVar.setPageNumber(i2);
        }
        bVar.Dj(advertAppInfo.bEf);
        bVar.Dk(advertAppInfo.bEg);
        bVar.Dl(advertAppInfo.bEh);
        bVar.Dm(advertAppInfo.page);
        return bVar;
    }

    public static b a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        b bVar = new b();
        bVar.setDownloadStaticsData(downloadStaticsData);
        bVar.yZ(i);
        bVar.setPageNumber(i2);
        return bVar;
    }

    public static b ae(int i, int i2, int i3) {
        b bVar = new b();
        bVar.yZ(i);
        bVar.za(i2);
        bVar.setPageNumber(i3);
        return bVar;
    }

    public static b c(m mVar, int i) {
        if (mVar == null || mVar.cmk() == null) {
            return null;
        }
        AppData cmk = mVar.cmk();
        b bVar = new b();
        bVar.De(cmk.ext_info);
        if (mVar.iYz) {
            bVar.za(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.za(com.baidu.adp.lib.g.b.f(cmk.pos_name, 0));
            bVar.setPageNumber(mVar.pageNumber);
        }
        bVar.yZ(i);
        bVar.Dg(cmk.price);
        bVar.Dj(mVar.bEf);
        bVar.Dk(mVar.bEg);
        bVar.Dl(mVar.forumId);
        bVar.Dm(mVar.cmn());
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        b c = c(advertAppInfo, i, i2);
        c.zb(i3);
        c.zc(i5);
        c.zd(i4);
        if (i6 != -1 && i == 32) {
            c.zf(i6);
        }
        c.Dm(advertAppInfo.page);
        if (i == 2) {
            c.Di("video");
        }
        return c;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        b a = a(dVar, i, i2);
        a.zb(i3);
        a.zc(i5);
        a.zd(i4);
        if (i6 != -1 && i == 32) {
            a.zf(i6);
        }
        if (dVar != null) {
            a.Dm(dVar.oM().page);
        }
        if (i == 2) {
            a.Di("video");
        }
        return a;
    }

    public static b s(String str, int i, String str2) {
        return b(str, i, str2, "");
    }

    public static b b(String str, int i, String str2, String str3) {
        b bVar = new b();
        bVar.yZ(i);
        bVar.Df(str2);
        bVar.Dm("HOMEPAGE");
        bVar.De(str);
        bVar.Dn(str3);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b c = c(advertAppInfo, i, i2);
        c.zb(i3);
        return c;
    }

    public static b b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b d = d(advertAppInfo, i, i2);
        d.zb(i3);
        return d;
    }

    public static b a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        b a = a(dVar, 5, dVar.getPageNum());
        a.zb(parseError.errorCode);
        return a;
    }

    public static b o(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.yZ(aVar.Sb);
        bVar.za(aVar.Sd);
        bVar.Dm(aVar.Sc);
        bVar.De(aVar.extraParam);
        return bVar;
    }

    public static b p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.yZ(aVar.Sb);
        bVar.za(aVar.Sd);
        bVar.Dm(aVar.Sc);
        bVar.De(aVar.extraParam);
        bVar.zb(aVar.RP);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            bVar.Dh(aVar.tplName);
        }
        bVar.zd(aVar.RQ);
        return bVar;
    }

    public static b q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.yZ(aVar.Sb);
        bVar.za(aVar.Sd);
        bVar.Dm(aVar.Sc);
        bVar.De(aVar.extraParam);
        bVar.zb(0);
        bVar.zc(aVar.Sf);
        bVar.zd(aVar.Se);
        bVar.ze(aVar.Sg);
        return bVar;
    }

    public static b r(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.yZ(aVar.Sb);
        bVar.za(aVar.Sd);
        bVar.Dm(aVar.Sc);
        bVar.De(aVar.extraParam);
        return bVar;
    }
}
