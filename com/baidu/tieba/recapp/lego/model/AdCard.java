package com.baidu.tieba.recapp.lego.model;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.c;
import c.a.q0.s.q.d2;
import c.a.r0.p1.o.h.b;
import c.a.r0.y2.h0.a;
import c.a.r0.y2.i0.b.d;
import c.a.r0.y2.i0.b.e;
import c.a.r0.y2.i0.b.f;
import c.a.r0.y2.i0.b.g;
import c.a.r0.y2.z;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.AdCloseInfo;
import tbclient.VideoInfo;
/* loaded from: classes7.dex */
public class AdCard extends BaseLegoCardInfo implements AdvertAppInfo.ILegoAdvert, a, b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String adId;
    public AdvertAppInfo appInfo;
    public c appInfoModel;
    public int cardType;
    public AdCloseInfo closeInfo;
    public c.a.r0.y2.i0.b.b downloadInfo;
    public c.a.r0.y2.i0.b.c enhanceModel;
    public String ext;
    public String floor;
    public int goodsStyle;
    public boolean isPBBanner;
    public int maxTitleLine;
    public c.a.r0.y2.i0.b.a operate;
    public b.a parallelChargeInfo;
    public d picInfo;
    public String recommendReason;
    public g tailFrame;
    public e threadInfo;
    public String threadTitle;
    public int urlType;
    public String userImage;
    public String userName;
    public f verticalVideoStyle;
    public VideoInfo videoInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdCard(JSONObject jSONObject) {
        super(jSONObject);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((JSONObject) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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
            this.operate = c.a.r0.y2.i0.b.a.a(optJSONObject3);
        }
        g gVar = new g();
        this.tailFrame = gVar;
        gVar.b(jSONObject.optJSONObject(AdWebVideoActivityConfig.KEY_TAIL_FRAME));
        JSONObject optJSONObject4 = jSONObject.optJSONObject("app_info");
        if (optJSONObject4 != null) {
            this.appInfoModel = c.b(optJSONObject4);
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("pic_info");
        if (optJSONObject5 != null) {
            this.picInfo = d.a(optJSONObject5);
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO);
        if (optJSONObject6 != null) {
            this.videoInfo = VideoInfo.parseFromJson(optJSONObject6);
        }
        JSONObject optJSONObject7 = jSONObject.optJSONObject("thread_info");
        if (optJSONObject7 != null) {
            this.threadInfo = e.a(optJSONObject7);
        }
        JSONObject optJSONObject8 = jSONObject.optJSONObject("download_info");
        if (optJSONObject8 != null) {
            this.downloadInfo = c.a.r0.y2.i0.b.b.a(optJSONObject8);
        }
        JSONObject optJSONObject9 = jSONObject.optJSONObject("vertical_video_style");
        if (optJSONObject9 != null) {
            this.verticalVideoStyle = f.b(optJSONObject9);
        }
        b.a aVar = new b.a();
        this.parallelChargeInfo = aVar;
        aVar.a(jSONObject);
        JSONObject optJSONObject10 = jSONObject.optJSONObject("enhancement");
        if (optJSONObject10 != null) {
            this.enhanceModel = c.a.r0.y2.i0.b.c.a(optJSONObject10);
        }
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean checkIsAppAdvert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.r0.y2.i0.b.b bVar = this.downloadInfo;
            return (bVar == null || TextUtils.isEmpty(bVar.f29507a) || TextUtils.isEmpty(this.downloadInfo.f29508b)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean forFree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public AdvertAppInfo getAdvertAppInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.appInfo : (AdvertAppInfo) invokeV.objValue;
    }

    public long getAgreeNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            e eVar = this.threadInfo;
            if (eVar == null) {
                return -1L;
            }
            return eVar.f29521a;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public c getAppInfoModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.appInfoModel : (c) invokeV.objValue;
    }

    @NonNull
    public String getButtonScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.r0.y2.i0.b.a aVar = this.operate;
            if (aVar == null) {
                return this.scheme;
            }
            return aVar.f29506c;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public String getButtonText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.r0.y2.i0.b.a aVar = this.operate;
            if (aVar == null) {
                return null;
            }
            return aVar.f29505b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    @NonNull
    public String getDownloadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.a.r0.y2.i0.b.b bVar = this.downloadInfo;
            if (bVar == null) {
                return "";
            }
            if (!TextUtils.isEmpty(bVar.f29509c)) {
                return this.downloadInfo.f29509c;
            }
            if (!TextUtils.isEmpty(this.downloadInfo.f29507a)) {
                return this.downloadInfo.f29507a;
            }
            return this.adId;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public String getDownloadKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            c.a.r0.y2.i0.b.b bVar = this.downloadInfo;
            if (bVar == null) {
                return null;
            }
            return bVar.f29509c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public String getExtInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            AdvertAppInfo advertAppInfo = this.appInfo;
            if (advertAppInfo == null) {
                return null;
            }
            return advertAppInfo.e4;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public int getGoodsStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.goodsStyle : invokeV.intValue;
    }

    @Override // c.a.r0.y2.h0.a
    public String getImageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.userImage : (String) invokeV.objValue;
    }

    @Override // c.a.r0.p1.o.h.b
    public b.a getParallelCharge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.parallelChargeInfo : (b.a) invokeV.objValue;
    }

    public double getPicScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            d dVar = this.picInfo;
            if (dVar == null) {
                return 1.0d;
            }
            return dVar.f29517b;
        }
        return invokeV.doubleValue;
    }

    @Nullable
    public String getPicUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            d dVar = this.picInfo;
            if (dVar == null || c.a.r0.p1.o.k.a.e(dVar.f29518c)) {
                return null;
            }
            return (String) c.a.r0.p1.o.k.a.d(this.picInfo.f29518c, 0);
        }
        return (String) invokeV.objValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.appInfo.position : invokeV.intValue;
    }

    public int getReplyNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            e eVar = this.threadInfo;
            if (eVar == null) {
                return -1;
            }
            return eVar.f29523c;
        }
        return invokeV.intValue;
    }

    @Override // c.a.r0.y2.h0.a
    public String getShareLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (z.o(this.scheme)) {
                return Uri.parse(this.scheme).getQueryParameter("wap");
            }
            return this.scheme;
        }
        return (String) invokeV.objValue;
    }

    public int getShareNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            e eVar = this.threadInfo;
            if (eVar == null) {
                return -1;
            }
            return eVar.f29522b;
        }
        return invokeV.intValue;
    }

    @Override // c.a.r0.y2.h0.a
    public AdvertAppInfo getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? getAdvertAppInfo() : (AdvertAppInfo) invokeV.objValue;
    }

    public long getTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            e eVar = this.threadInfo;
            if (eVar == null) {
                return System.currentTimeMillis();
            }
            return eVar.f29524d;
        }
        return invokeV.longValue;
    }

    @Override // c.a.r0.y2.h0.a
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.threadTitle : (String) invokeV.objValue;
    }

    public boolean isDirectDownload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            c.a.r0.y2.i0.b.b bVar = this.downloadInfo;
            if (bVar == null) {
                return true;
            }
            return bVar.f29510d;
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedResize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            d dVar = this.picInfo;
            if (dVar == null) {
                return false;
            }
            return dVar.f29516a;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean isNoPicAd() {
        InterceptResult invokeV;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            int i2 = this.goodsStyle;
            return ((i2 != 2 && i2 != 6 && i2 != 8) || (dVar = this.picInfo) == null || c.a.r0.p1.o.k.a.e(dVar.f29518c)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean isReusable(ICardInfo iCardInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, iCardInfo)) == null) {
            if (iCardInfo instanceof AdCard) {
                AdCard adCard = (AdCard) iCardInfo;
                return getCardType() == adCard.getCardType() && getGoodsStyle() == adCard.getGoodsStyle();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
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
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean responseAttention(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, obj)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, advertAppInfo) == null) {
            this.appInfo = advertAppInfo;
            updataThreadData(advertAppInfo);
            g gVar = this.tailFrame;
            if (gVar.f29537j) {
                return;
            }
            gVar.a(this.appInfo, this);
        }
    }

    public void updataThreadData(d2 d2Var) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, d2Var) == null) || d2Var == null || (eVar = this.threadInfo) == null) {
            return;
        }
        d2Var.b4(eVar.f29524d / 1000);
        d2Var.m4(this.threadInfo.f29523c);
        d2Var.s3(this.threadInfo.f29521a);
        d2Var.r4(this.threadInfo.f29522b);
        d2Var.A4(this.threadTitle);
        d2Var.J().setName_show(this.userName);
        d2Var.J().setPortrait(this.userImage);
    }
}
