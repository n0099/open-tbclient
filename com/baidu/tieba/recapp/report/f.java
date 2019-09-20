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
        bVar.zJ(i);
        bVar.Ew(advertAppInfo.price);
        bVar.Eu(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.zK(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.zK(advertAppInfo.bFx);
            bVar.setPageNumber(i2);
        } else {
            bVar.zK(com.baidu.adp.lib.g.b.f(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.Ez(advertAppInfo.bFF);
        bVar.EA(advertAppInfo.bFG);
        bVar.EB(advertAppInfo.bFH);
        bVar.EC(advertAppInfo.page);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.zJ(i);
        bVar.Eu(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.zK(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.zK(advertAppInfo.bFx);
            bVar.setPageNumber(i2);
        } else {
            bVar.zK(com.baidu.adp.lib.g.b.f(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.ED(str);
        bVar.EC(advertAppInfo.page);
        return bVar;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2) {
        if (dVar == null) {
            return null;
        }
        return c(dVar.pi(), i, i2);
    }

    public static b d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.zJ(i);
        bVar.Ew(advertAppInfo.price);
        bVar.Eu(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.zK(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.zK(advertAppInfo.bFx);
            bVar.setPageNumber(i2);
        }
        bVar.Ez(advertAppInfo.bFF);
        bVar.EA(advertAppInfo.bFG);
        bVar.EB(advertAppInfo.bFH);
        bVar.EC(advertAppInfo.page);
        return bVar;
    }

    public static b a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        b bVar = new b();
        bVar.setDownloadStaticsData(downloadStaticsData);
        bVar.zJ(i);
        bVar.setPageNumber(i2);
        return bVar;
    }

    public static b ag(int i, int i2, int i3) {
        b bVar = new b();
        bVar.zJ(i);
        bVar.zK(i2);
        bVar.setPageNumber(i3);
        return bVar;
    }

    public static b c(m mVar, int i) {
        if (mVar == null || mVar.cqn() == null) {
            return null;
        }
        AppData cqn = mVar.cqn();
        b bVar = new b();
        bVar.Eu(cqn.ext_info);
        if (mVar.jix) {
            bVar.zK(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.zK(com.baidu.adp.lib.g.b.f(cqn.pos_name, 0));
            bVar.setPageNumber(mVar.pageNumber);
        }
        bVar.zJ(i);
        bVar.Ew(cqn.price);
        bVar.Ez(mVar.bFF);
        bVar.EA(mVar.bFG);
        bVar.EB(mVar.forumId);
        bVar.EC(mVar.cqq());
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        b c = c(advertAppInfo, i, i2);
        c.zL(i3);
        c.zM(i5);
        c.zN(i4);
        if (i6 != -1 && i == 32) {
            c.zP(i6);
        }
        c.EC(advertAppInfo.page);
        if (i == 2) {
            c.Ey("video");
        }
        return c;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        b a = a(dVar, i, i2);
        a.zL(i3);
        a.zM(i5);
        a.zN(i4);
        if (i6 != -1 && i == 32) {
            a.zP(i6);
        }
        if (dVar != null) {
            a.EC(dVar.pi().page);
        }
        if (i == 2) {
            a.Ey("video");
        }
        return a;
    }

    public static b s(String str, int i, String str2) {
        return b(str, i, str2, "");
    }

    public static b b(String str, int i, String str2, String str3) {
        b bVar = new b();
        bVar.zJ(i);
        bVar.Ev(str2);
        bVar.EC("HOMEPAGE");
        bVar.Eu(str);
        bVar.ED(str3);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b c = c(advertAppInfo, i, i2);
        c.zL(i3);
        return c;
    }

    public static b b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b d = d(advertAppInfo, i, i2);
        d.zL(i3);
        return d;
    }

    public static b a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        b a = a(dVar, 5, dVar.getPageNum());
        a.zL(parseError.errorCode);
        return a;
    }

    public static b o(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.zJ(aVar.Sr);
        bVar.zK(aVar.St);
        bVar.EC(aVar.Ss);
        bVar.Eu(aVar.extraParam);
        return bVar;
    }

    public static b p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.zJ(aVar.Sr);
        bVar.zK(aVar.St);
        bVar.EC(aVar.Ss);
        bVar.Eu(aVar.extraParam);
        bVar.zL(aVar.Sg);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            bVar.Ex(aVar.tplName);
        }
        bVar.zN(aVar.Sh);
        return bVar;
    }

    public static b q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.zJ(aVar.Sr);
        bVar.zK(aVar.St);
        bVar.EC(aVar.Ss);
        bVar.Eu(aVar.extraParam);
        bVar.zL(0);
        bVar.zM(aVar.Sv);
        bVar.zN(aVar.Su);
        bVar.zO(aVar.Sw);
        return bVar;
    }

    public static b r(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        b bVar = new b();
        bVar.zJ(aVar.Sr);
        bVar.zK(aVar.St);
        bVar.EC(aVar.Ss);
        bVar.Eu(aVar.extraParam);
        return bVar;
    }
}
