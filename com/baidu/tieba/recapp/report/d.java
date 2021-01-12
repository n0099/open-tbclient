package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.tbadkCore.data.o;
/* loaded from: classes.dex */
public class d {
    public static void a(o oVar, int i) {
        a(oVar, i, AdCard.INVALID_NUM, AdCard.INVALID_NUM);
    }

    public static void a(o oVar, int i, int i2, int i3) {
        if (oVar != null && oVar.dLa() != null && oVar.dLa().goods != null && oVar.dLa().goods.goods_style != 1001 && oVar.dLa().goods.goods_style != -1001) {
            c b2 = h.b(oVar, 5);
            b2.HF(i);
            if (i2 != -999) {
                b2.HG(i2);
            }
            if (i3 != -999) {
                b2.HH(i3);
            }
            e.dCe().a(b2);
            if (oVar != null && oVar.dLa() != null) {
                oVar.dLa().mDiscardReason = i;
            }
        }
    }

    public static void a(AdvertAppInfo advertAppInfo, int i, int i2) {
        a(advertAppInfo, i, i2, AdCard.INVALID_NUM, AdCard.INVALID_NUM);
    }

    public static void a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4) {
        if (advertAppInfo != null && advertAppInfo.eJr != null && advertAppInfo.eJr.eJF != 1001 && advertAppInfo.eJr.eJF != -1001) {
            c a2 = h.a(advertAppInfo, 5, i, i2);
            if (i3 != -999) {
                a2.HG(i3);
            }
            if (i4 != -999) {
                a2.HH(i4);
            }
            e.dCe().a(a2);
            if (advertAppInfo.eJy != null) {
                advertAppInfo.eJy.mDiscardReason = 2;
            }
        }
    }
}
