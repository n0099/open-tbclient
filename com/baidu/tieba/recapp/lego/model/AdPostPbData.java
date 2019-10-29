package com.baidu.tieba.recapp.lego.model;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AdPostPbData extends PostAdBaseData implements AdvertAppInfo.ILegoAdvert, b {
    public PostAdBaseData.a.b buttonClick;
    public String buttonText;
    public String desc;
    public String extInfo;
    public PostAdBaseData.a.c extraData;
    public long fid;
    public String id;
    public String name;
    public b.a parallelChargeInfo;
    public String portrait;
    public String price;
    public String recommend;
    public String scheme;
    public String style;
    public String tagName;
    public String title;

    public AdPostPbData(JSONObject jSONObject) {
        super(jSONObject);
        this.parallelChargeInfo = new b.a();
        this.parallelChargeInfo.parseFromJson(jSONObject);
        this.id = jSONObject.optString("id");
        this.fid = jSONObject.optLong("fid", 0L);
        this.name = jSONObject.optString("name");
        this.style = jSONObject.optString("style");
        this.scheme = jSONObject.optString("scheme");
        this.buttonText = jSONObject.optString("button_text");
        this.tagName = jSONObject.optString("tag_name");
        this.title = jSONObject.optString("title");
        this.desc = jSONObject.optString("desc");
        this.recommend = jSONObject.optString("recommend");
        this.extInfo = jSONObject.optString("ext_info");
        this.portrait = jSONObject.optString("portrait");
        this.price = jSONObject.optString("price");
        JSONObject optJSONObject = jSONObject.optJSONObject("button_click");
        if (optJSONObject != null) {
            this.buttonClick = new PostAdBaseData.a.b();
            this.buttonClick.scheme = optJSONObject.optString("scheme");
            this.buttonClick.LE = optJSONObject.optString("als_stat");
            this.buttonClick.LG = optJSONObject.optString("url_stat");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("ext_data");
        if (optJSONObject2 != null) {
            this.extraData = new PostAdBaseData.a.c();
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("ad_download");
            if (optJSONObject3 != null) {
                this.extraData.iJC = new PostAdBaseData.a.C0508a();
                this.extraData.iJC.packageName = optJSONObject3.optString("pkgname");
                this.extraData.iJC.downloadUrl = optJSONObject3.optString("download_url");
            }
        }
    }

    public boolean isDownload() {
        return (!"apk_download".equals(this.style) || this.extraData == null || this.extraData.iJC == null) ? false : true;
    }

    public String apkDownloadUrl() {
        if (this.extraData == null || this.extraData.iJC == null) {
            return null;
        }
        return this.extraData.iJC.downloadUrl;
    }

    public String apkDownloadPackage() {
        if (this.extraData == null || this.extraData.iJC == null) {
            return null;
        }
        return this.extraData.iJC.packageName;
    }

    public AdvertAppInfo toAppData() {
        if (this.extraData == null || this.extraData.iJC == null) {
            return null;
        }
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        h(advertAppInfo);
        return advertAppInfo;
    }

    private void h(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null) {
            if ("apk_download".equals(this.style)) {
                advertAppInfo.BV = 3;
            }
            if (TextUtils.isEmpty(advertAppInfo.bXk)) {
                advertAppInfo.bXk = this.id;
            }
            if (advertAppInfo.getFid() == 0) {
                advertAppInfo.setFid(this.fid);
            }
            advertAppInfo.bXn = apkDownloadUrl();
            advertAppInfo.extensionInfo = this.extInfo;
            advertAppInfo.bXo = apkDownloadPackage();
            advertAppInfo.bXl = !TextUtils.isEmpty(this.name) ? this.name : apkDownloadPackage();
            if (advertAppInfo.bXu == null) {
                advertAppInfo.bXu = new AdvertAppInfo.a();
            }
            advertAppInfo.bXu.userPortrait = this.portrait;
            advertAppInfo.bXu.userName = this.title;
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
        if (advertAppInfo != null) {
            this.appInfo = advertAppInfo;
            h(this.appInfo);
            return;
        }
        this.appInfo = toAppData();
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public int getGoodsStyle() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean isNoPicAd() {
        return true;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public int checkLegal(int i) {
        return 0;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public String getExtInfo() {
        return this.extInfo;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean forFree() {
        return true;
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        return this.parallelChargeInfo;
    }
}
