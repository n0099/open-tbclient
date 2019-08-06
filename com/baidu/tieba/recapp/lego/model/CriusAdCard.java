package com.baidu.tieba.recapp.lego.model;

import com.baidu.c.a.c.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import com.baidu.tieba.recapp.lego.model.AdCard;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CriusAdCard extends BaseLegoCardInfo implements AdvertAppInfo.ILegoAdvert, b {
    public static final String CHARGE_STYLE_CPC = "cpc";
    public static final String CHARGE_STYLE_CPV = "cpv";
    private AdvertAppInfo appInfo;
    private final a.InterfaceC0036a businessConverter;
    public AdCard.a chargeInfo;
    a criusData;
    public b.a parallelChargeInfo;
    public AdCard.f tailFrame;

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        return this.parallelChargeInfo;
    }

    public CriusAdCard(JSONObject jSONObject) {
        super(jSONObject);
        this.businessConverter = new a.InterfaceC0036a() { // from class: com.baidu.tieba.recapp.lego.model.CriusAdCard.1
            @Override // com.baidu.c.a.c.a.InterfaceC0036a
            public String cB(String str) {
                return aq.aD(Long.valueOf(str).longValue());
            }
        };
        this.parallelChargeInfo = new b.a();
        this.parallelChargeInfo.parseFromJson(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("crius");
        if (optJSONObject != null) {
            this.criusData = new a(TbadkCoreApplication.getInst(), optJSONObject, this.businessConverter, true);
            this.chargeInfo = new AdCard.a();
            this.chargeInfo.iHZ = jSONObject.optString(WebVideoActivityConfig.KEY_CHARGE_STYLE, "cpc");
            this.chargeInfo.iIa = jSONObject.optString(WebVideoActivityConfig.KEY_CHARGE_URL);
            this.tailFrame = new AdCard.f();
            this.tailFrame.parseFromJson(jSONObject.optJSONObject(WebVideoActivityConfig.KEY_TAIL_FRAME));
        }
    }

    public a getCriusData() {
        return this.criusData;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean responseAttention(Object obj) {
        return false;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public void refreshReservation(Object obj) {
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public AdvertAppInfo getAdvertAppInfo() {
        return this.appInfo;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.appInfo = advertAppInfo;
        if ((this.appInfo == null || this.appInfo.bFe == null || this.appInfo.bFe.adCloseInfo == null || advertAppInfo.bFe.adCloseInfo.support_close.intValue() <= 0) && this.criusData != null) {
            this.criusData.cA("closead");
        }
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public int getGoodsStyle() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean isNoPicAd() {
        return this.appInfo == null || this.appInfo.bFe == null || v.aa(this.appInfo.bFe.bFv);
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public int checkLegal(int i) {
        return 0;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public String getExtInfo() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean forFree() {
        return false;
    }
}
