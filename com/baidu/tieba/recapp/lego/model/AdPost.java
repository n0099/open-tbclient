package com.baidu.tieba.recapp.lego.model;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.g.b;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.c.a;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AdPost extends PostAdBaseData implements AdvertAppInfo.ILegoAdvert, a {
    public PostAdBaseData.a adData;
    public PostAdBaseData.b feedData;
    private int goodsStyle;
    public String preloadLegoCardStr;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdPost(JSONObject jSONObject) {
        super(jSONObject);
        JSONObject jSONObject2;
        JSONObject jSONObject3 = null;
        this.goodsStyle = b.g(jSONObject.optString("goods_style"), -1);
        try {
            jSONObject2 = jSONObject.getJSONObject("feed_content");
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject2 = null;
        }
        this.feedData = PostAdBaseData.b.Z(jSONObject2);
        try {
            jSONObject3 = jSONObject.getJSONObject("ad_content");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.adData = PostAdBaseData.a.Y(jSONObject3);
        try {
            this.preloadLegoCardStr = jSONObject.getString(LegoListActivityConfig.PRE_LOAD);
        } catch (JSONException e3) {
            e3.printStackTrace();
            this.preloadLegoCardStr = "";
        }
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
        this.feedData.updataThreadData(this.appInfo);
        this.adData.i(this.appInfo);
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public int getGoodsStyle() {
        return this.goodsStyle;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean isNoPicAd() {
        return true;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public int checkLegal(int i) {
        if (i != 3 && i != 1) {
            return 21;
        }
        if (this.adData.type == 2) {
            return this.adData.sj(i);
        }
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

    @Override // com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean isReusable(ICardInfo iCardInfo) {
        return (iCardInfo instanceof AdPost) && getCardType() == ((AdPost) iCardInfo).getCardType();
    }

    @Override // com.baidu.tieba.recapp.c.a
    public String getTitle() {
        return this.feedData.title;
    }

    @Override // com.baidu.tieba.recapp.c.a
    public String getAbstract() {
        return this.feedData.content;
    }

    @Override // com.baidu.tieba.recapp.c.a
    public String getImageUrl() {
        return this.feedData.portrait;
    }

    @Override // com.baidu.tieba.recapp.c.a
    public AdvertAppInfo getThreadData() {
        return getAdvertAppInfo();
    }

    @Override // com.baidu.tieba.recapp.c.a
    public String getShareLink() {
        Uri parse = Uri.parse(this.feedData.scheme);
        if ("pb".equalsIgnoreCase(parse.getAuthority())) {
            String queryParameter = parse.getQueryParameter("tId");
            String queryParameter2 = parse.getQueryParameter("tid");
            if (!TextUtils.isEmpty(queryParameter)) {
                queryParameter2 = queryParameter;
            }
            return "http://tieba.baidu.com/p/" + queryParameter2;
        }
        return this.feedData.scheme;
    }
}
