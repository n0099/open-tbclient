package com.baidu.tieba.recapp.lego.model;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.components.downloader.OAdSqlLiteHelper;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.c;
import d.a.n0.k1.o.h.b;
import d.a.n0.t2.e0.a;
import d.a.n0.t2.f0.b.d;
import d.a.n0.t2.f0.b.e;
import d.a.n0.t2.f0.b.f;
import d.a.n0.t2.y;
import org.json.JSONObject;
import tbclient.AdCloseInfo;
import tbclient.VideoInfo;
/* loaded from: classes5.dex */
public class AdCard extends BaseLegoCardInfo implements AdvertAppInfo.ILegoAdvert, a, b {
    public String adId;
    public AdvertAppInfo appInfo;
    public c appInfoModel;
    public int cardType;
    public AdCloseInfo closeInfo;
    public d.a.n0.t2.f0.b.b downloadInfo;
    public String ext;
    public String floor;
    public int goodsStyle;
    public boolean isPBBanner;
    public int maxTitleLine;
    public d.a.n0.t2.f0.b.a operate;
    public b.a parallelChargeInfo;
    public d.a.n0.t2.f0.b.c picInfo;
    public String recommendReason;
    public f tailFrame;
    public d threadInfo;
    public String threadTitle;
    public int urlType;
    public String userImage;
    public String userName;
    public e verticalVideoStyle;
    public VideoInfo videoInfo;

    public AdCard(JSONObject jSONObject) {
        super(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("ad_common");
        if (optJSONObject != null) {
            this.adId = optJSONObject.optString("id");
            this.urlType = optJSONObject.optInt("url_type");
            this.scheme = optJSONObject.optString("scheme");
            this.floor = optJSONObject.optString(IAdRequestParam.POS);
            this.ext = optJSONObject.optString("ext_info");
            this.userName = optJSONObject.optString("user_name");
            this.userImage = optJSONObject.optString("user_portrait");
            this.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
            this.goodsStyle = optJSONObject.optInt("goods_style");
            this.cardType = optJSONObject.optInt("card_type");
            this.maxTitleLine = optJSONObject.optInt("title_lines");
            this.recommendReason = optJSONObject.optString("recommend_reason");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject(GameGuideConfigInfo.KEY_CLOSE_INFO);
        if (optJSONObject2 != null) {
            this.closeInfo = AdCloseInfo.parseFromJson(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("operate");
        if (optJSONObject3 != null) {
            this.operate = d.a.n0.t2.f0.b.a.a(optJSONObject3);
        }
        f fVar = new f();
        this.tailFrame = fVar;
        fVar.b(jSONObject.optJSONObject(AdWebVideoActivityConfig.KEY_TAIL_FRAME));
        JSONObject optJSONObject4 = jSONObject.optJSONObject("app_info");
        if (optJSONObject4 != null) {
            this.appInfoModel = c.b(optJSONObject4);
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("pic_info");
        if (optJSONObject5 != null) {
            this.picInfo = d.a.n0.t2.f0.b.c.a(optJSONObject5);
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO);
        if (optJSONObject6 != null) {
            this.videoInfo = VideoInfo.parseFromJson(optJSONObject6);
        }
        JSONObject optJSONObject7 = jSONObject.optJSONObject("thread_info");
        if (optJSONObject7 != null) {
            this.threadInfo = d.a(optJSONObject7);
        }
        JSONObject optJSONObject8 = jSONObject.optJSONObject(OAdSqlLiteHelper.TABLE_NAME);
        if (optJSONObject8 != null) {
            this.downloadInfo = d.a.n0.t2.f0.b.b.a(optJSONObject8);
        }
        JSONObject optJSONObject9 = jSONObject.optJSONObject("vertical_video_style");
        if (optJSONObject9 != null) {
            this.verticalVideoStyle = e.b(optJSONObject9);
        }
        b.a aVar = new b.a();
        this.parallelChargeInfo = aVar;
        aVar.a(jSONObject);
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean checkIsAppAdvert() {
        d.a.n0.t2.f0.b.b bVar = this.downloadInfo;
        return (bVar == null || TextUtils.isEmpty(bVar.f61061a) || TextUtils.isEmpty(this.downloadInfo.f61062b)) ? false : true;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public int checkLegal(int i2) {
        return 0;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean forFree() {
        return false;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public AdvertAppInfo getAdvertAppInfo() {
        return this.appInfo;
    }

    public long getAgreeNum() {
        d dVar = this.threadInfo;
        if (dVar == null) {
            return -1L;
        }
        return dVar.f61070a;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public c getAppInfoModel() {
        return this.appInfoModel;
    }

    @NonNull
    public String getButtonScheme() {
        d.a.n0.t2.f0.b.a aVar = this.operate;
        if (aVar == null) {
            return this.scheme;
        }
        return aVar.f61060c;
    }

    @Nullable
    public String getButtonText() {
        d.a.n0.t2.f0.b.a aVar = this.operate;
        if (aVar == null) {
            return null;
        }
        return aVar.f61059b;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    @NonNull
    public String getDownloadId() {
        d.a.n0.t2.f0.b.b bVar = this.downloadInfo;
        if (bVar == null) {
            return "";
        }
        if (!TextUtils.isEmpty(bVar.f61063c)) {
            return this.downloadInfo.f61063c;
        }
        if (!TextUtils.isEmpty(this.downloadInfo.f61061a)) {
            return this.downloadInfo.f61061a;
        }
        return this.adId;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public String getDownloadKey() {
        d.a.n0.t2.f0.b.b bVar = this.downloadInfo;
        if (bVar == null) {
            return null;
        }
        return bVar.f61063c;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public String getExtInfo() {
        AdvertAppInfo advertAppInfo = this.appInfo;
        if (advertAppInfo == null) {
            return null;
        }
        return advertAppInfo.N3;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public int getGoodsStyle() {
        return this.goodsStyle;
    }

    @Override // d.a.n0.t2.e0.a
    public String getImageUrl() {
        return this.userImage;
    }

    @Override // d.a.n0.k1.o.h.b
    public b.a getParallelCharge() {
        return this.parallelChargeInfo;
    }

    public double getPicScale() {
        d.a.n0.t2.f0.b.c cVar = this.picInfo;
        if (cVar == null) {
            return 1.0d;
        }
        return cVar.f61066b;
    }

    @Nullable
    public String getPicUrl() {
        d.a.n0.t2.f0.b.c cVar = this.picInfo;
        if (cVar == null || d.a.n0.k1.o.k.a.e(cVar.f61067c)) {
            return null;
        }
        return (String) d.a.n0.k1.o.k.a.d(this.picInfo.f61067c, 0);
    }

    public int getPosition() {
        return this.appInfo.position;
    }

    public int getReplyNum() {
        d dVar = this.threadInfo;
        if (dVar == null) {
            return -1;
        }
        return dVar.f61072c;
    }

    @Override // d.a.n0.t2.e0.a
    public String getShareLink() {
        if (y.o(this.scheme)) {
            return Uri.parse(this.scheme).getQueryParameter("wap");
        }
        return this.scheme;
    }

    public int getShareNum() {
        d dVar = this.threadInfo;
        if (dVar == null) {
            return -1;
        }
        return dVar.f61071b;
    }

    @Override // d.a.n0.t2.e0.a
    public AdvertAppInfo getThreadData() {
        return getAdvertAppInfo();
    }

    public long getTime() {
        d dVar = this.threadInfo;
        if (dVar == null) {
            return System.currentTimeMillis();
        }
        return dVar.f61073d;
    }

    @Override // d.a.n0.t2.e0.a
    public String getTitle() {
        return this.threadTitle;
    }

    public boolean isDirectDownload() {
        d.a.n0.t2.f0.b.b bVar = this.downloadInfo;
        if (bVar == null) {
            return true;
        }
        return bVar.f61064d;
    }

    public boolean isNeedResize() {
        d.a.n0.t2.f0.b.c cVar = this.picInfo;
        if (cVar == null) {
            return false;
        }
        return cVar.f61065a;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean isNoPicAd() {
        d.a.n0.t2.f0.b.c cVar;
        int i2 = this.goodsStyle;
        return ((i2 != 2 && i2 != 6 && i2 != 8) || (cVar = this.picInfo) == null || d.a.n0.k1.o.k.a.e(cVar.f61067c)) ? false : true;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean isReusable(ICardInfo iCardInfo) {
        if (iCardInfo instanceof AdCard) {
            AdCard adCard = (AdCard) iCardInfo;
            return getCardType() == adCard.getCardType() && getGoodsStyle() == adCard.getGoodsStyle();
        }
        return false;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean isValid() {
        int i2 = this.goodsStyle;
        if (i2 != 7) {
            if (i2 == 8) {
                return false;
            }
            if (i2 != 14) {
                return super.isValid();
            }
        }
        VideoInfo videoInfo = this.videoInfo;
        if (videoInfo == null) {
            return false;
        }
        return !StringUtils.isNull(videoInfo.video_url);
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean responseAttention(Object obj) {
        return false;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.appInfo = advertAppInfo;
        updataThreadData(advertAppInfo);
        f fVar = this.tailFrame;
        if (fVar.f61085i) {
            return;
        }
        fVar.a(this.appInfo, this);
    }

    public void updataThreadData(a2 a2Var) {
        d dVar;
        if (a2Var == null || (dVar = this.threadInfo) == null) {
            return;
        }
        a2Var.T3(dVar.f61073d / 1000);
        a2Var.c4(this.threadInfo.f61072c);
        a2Var.o3(this.threadInfo.f61070a);
        a2Var.h4(this.threadInfo.f61071b);
        a2Var.q4(this.threadTitle);
        a2Var.T().setName_show(this.userName);
        a2Var.T().setPortrait(this.userImage);
    }
}
