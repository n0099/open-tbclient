package com.baidu.tieba.recapp.lego.model;

import com.baidu.b.a.c.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import com.baidu.tieba.recapp.lego.model.AdCard;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CriusAdCard extends BaseLegoCardInfo implements AdvertAppInfo.ILegoAdvert {
    public static final String CHARGE_STYLE_CPC = "cpc";
    public static final String CHARGE_STYLE_CPV = "cpv";
    private AdvertAppInfo appInfo;
    private final a.InterfaceC0053a businessConverter;
    public AdCard.a chargeInfo;
    a criusData;
    public AdCard.e tailFrame;

    public CriusAdCard(JSONObject jSONObject) {
        super(jSONObject);
        this.businessConverter = new a.InterfaceC0053a() { // from class: com.baidu.tieba.recapp.lego.model.CriusAdCard.1
            @Override // com.baidu.b.a.c.a.InterfaceC0053a
            public String bW(String str) {
                return am.z(Long.valueOf(str).longValue());
            }
        };
        JSONObject optJSONObject = jSONObject.optJSONObject("crius");
        if (optJSONObject != null) {
            System.currentTimeMillis();
            this.criusData = new a(TbadkCoreApplication.getInst(), optJSONObject, this.businessConverter, true);
            this.chargeInfo = new AdCard.a();
            this.chargeInfo.gDj = jSONObject.optString(WebVideoActivityConfig.KEY_CHARGE_STYLE, "cpc");
            this.chargeInfo.gDk = jSONObject.optString(WebVideoActivityConfig.KEY_CHARGE_URL);
            this.tailFrame = new AdCard.e();
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
        if ((this.appInfo == null || this.appInfo.aKR == null || this.appInfo.aKR.aLm == null || advertAppInfo.aKR.aLm.support_close.intValue() <= 0) && this.criusData != null) {
            this.criusData.bV("closead");
        }
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public int getGoodsStyle() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean isNoPicAd() {
        return false;
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
