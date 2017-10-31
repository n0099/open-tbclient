package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.l;
/* loaded from: classes.dex */
public class e {
    public static a c(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        a aVar = new a();
        aVar.su(com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, 0));
        aVar.st(i);
        aVar.rx(advertAppInfo.price);
        aVar.rv(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.rz(advertAppInfo.Uu);
        aVar.rA(advertAppInfo.Uv);
        aVar.rB(advertAppInfo.Uw);
        aVar.rC(advertAppInfo.TL);
        return aVar;
    }

    public static a d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        a aVar = new a();
        aVar.su(advertAppInfo.Um);
        aVar.st(i);
        aVar.rx(advertAppInfo.price);
        aVar.rv(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.rz(advertAppInfo.Uu);
        aVar.rA(advertAppInfo.Uv);
        aVar.rB(advertAppInfo.Uw);
        aVar.rC(advertAppInfo.TL);
        return aVar;
    }

    public static a a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        a aVar = new a();
        aVar.setDownloadStaticsData(downloadStaticsData);
        aVar.st(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a aa(int i, int i2, int i3) {
        a aVar = new a();
        aVar.st(i);
        aVar.su(i2);
        aVar.setPageNumber(i3);
        return aVar;
    }

    public static a c(l lVar, int i) {
        if (lVar == null || lVar.buj() == null) {
            return null;
        }
        AppData buj = lVar.buj();
        a aVar = new a();
        aVar.su(com.baidu.adp.lib.g.b.g(buj.pos_name, 0));
        aVar.rv(buj.ext_info);
        aVar.setPageNumber(lVar.pageNumber);
        aVar.st(i);
        aVar.rx(buj.price);
        aVar.rz(lVar.Uu);
        aVar.rA(lVar.Uv);
        aVar.rB(lVar.forumId);
        aVar.rC("PB");
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        a c = c(advertAppInfo, i, i2);
        c.sv(i3);
        c.sw(i5);
        c.sx(i4);
        if (i6 != -1 && i == 32) {
            c.sy(i6);
        }
        c.rC(advertAppInfo.TL);
        if (i == 2) {
            c.ry("video");
        }
        return c;
    }

    public static a i(String str, int i, String str2) {
        return c(str, i, str2, "");
    }

    public static a c(String str, int i, String str2, String str3) {
        a aVar = new a();
        aVar.st(i);
        aVar.rw(str2);
        aVar.rC("HOMEPAGE");
        aVar.rv(str);
        aVar.rD(str3);
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a c = c(advertAppInfo, i, i2);
        c.sv(i3);
        return c;
    }

    public static a b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a d = d(advertAppInfo, i, i2);
        d.sv(i3);
        return d;
    }
}
