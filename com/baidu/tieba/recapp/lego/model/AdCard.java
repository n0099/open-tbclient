package com.baidu.tieba.recapp.lego.model;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.JsonTransHelper;
import com.baidu.tbadk.core.util.TiebaMainDatabaseHelper;
import com.baidu.tieba.cr4;
import com.baidu.tieba.ff8;
import com.baidu.tieba.fh7;
import com.baidu.tieba.hf8;
import com.baidu.tieba.if8;
import com.baidu.tieba.jf8;
import com.baidu.tieba.kf8;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lf8;
import com.baidu.tieba.lh7;
import com.baidu.tieba.me8;
import com.baidu.tieba.mf8;
import com.baidu.tieba.nf8;
import com.baidu.tieba.of8;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.AdCloseInfo;
import tbclient.VideoInfo;
/* loaded from: classes5.dex */
public class AdCard extends BaseLegoCardInfo implements AdvertAppInfo.ILegoAdvert, ff8, fh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String adId;
    public AdvertAppInfo appInfo;
    public cr4 appInfoModel;
    public int cardType;
    public AdCloseInfo closeInfo;
    public String cmdScheme;
    public if8 downloadInfo;
    public jf8 enhanceModel;
    public String ext;
    public String floor;
    public kf8 gameModel;
    public int goodsStyle;
    public boolean isPBBanner;
    public int maxTitleLine;
    public hf8 operate;
    public fh7.a parallelChargeInfo;
    public lf8 picInfo;
    public String playCmdScheme;
    public String recommendReason;
    public of8 tailFrame;
    public mf8 threadInfo;
    public String threadTitle;
    public int urlType;
    public String userImage;
    public String userName;
    public nf8 verticalVideoStyle;
    public VideoInfo videoInfo;

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean forFree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdCard(JSONObject jSONObject) {
        super(jSONObject);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            this.floor = optJSONObject.optString("pos");
            this.ext = optJSONObject.optString("ext_info");
            this.userName = optJSONObject.optString("user_name");
            this.userImage = optJSONObject.optString(RecommendDetailActivityConfig.USER_PORTRAIT);
            this.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
            this.goodsStyle = optJSONObject.optInt("goods_style");
            this.cardType = optJSONObject.optInt("card_type");
            this.maxTitleLine = optJSONObject.optInt("title_lines");
            this.recommendReason = optJSONObject.optString("recommend_reason");
            this.cmdScheme = optJSONObject.optString("cmd_scheme");
            this.playCmdScheme = optJSONObject.optString("play_cmd_scheme");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject(GameGuideConfigInfo.KEY_CLOSE_INFO);
        if (optJSONObject2 != null) {
            this.closeInfo = JsonTransHelper.parseAdCloseInfoFromJson(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("operate");
        if (optJSONObject3 != null) {
            this.operate = hf8.a(optJSONObject3);
        }
        of8 of8Var = new of8();
        this.tailFrame = of8Var;
        of8Var.b(jSONObject.optJSONObject(AdWebVideoActivityConfig.KEY_TAIL_FRAME));
        JSONObject optJSONObject4 = jSONObject.optJSONObject("app_info");
        if (optJSONObject4 != null) {
            this.appInfoModel = cr4.b(optJSONObject4);
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("pic_info");
        if (optJSONObject5 != null) {
            this.picInfo = lf8.a(optJSONObject5);
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO);
        if (optJSONObject6 != null) {
            this.videoInfo = JsonTransHelper.parseVideoInfoFromJson(optJSONObject6);
        }
        JSONObject optJSONObject7 = jSONObject.optJSONObject("thread_info");
        if (optJSONObject7 != null) {
            this.threadInfo = mf8.a(optJSONObject7);
        }
        JSONObject optJSONObject8 = jSONObject.optJSONObject(TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO);
        if (optJSONObject8 != null) {
            this.downloadInfo = if8.a(optJSONObject8);
        }
        JSONObject optJSONObject9 = jSONObject.optJSONObject("vertical_video_style");
        if (optJSONObject9 != null) {
            this.verticalVideoStyle = nf8.b(optJSONObject9);
        }
        fh7.a aVar = new fh7.a();
        this.parallelChargeInfo = aVar;
        aVar.a(jSONObject);
        JSONObject optJSONObject10 = jSONObject.optJSONObject("enhancement");
        if (optJSONObject10 != null) {
            this.enhanceModel = jf8.a(optJSONObject10);
        }
        JSONObject optJSONObject11 = jSONObject.optJSONObject("play_button");
        if (optJSONObject11 != null) {
            this.gameModel = kf8.a(optJSONObject11);
        }
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean checkIsAppAdvert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if8 if8Var = this.downloadInfo;
            if (if8Var == null || TextUtils.isEmpty(if8Var.a) || TextUtils.isEmpty(this.downloadInfo.b)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public AdvertAppInfo getAdvertAppInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.appInfo;
        }
        return (AdvertAppInfo) invokeV.objValue;
    }

    public long getAgreeNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            mf8 mf8Var = this.threadInfo;
            if (mf8Var == null) {
                return -1L;
            }
            return mf8Var.a;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public cr4 getAppInfoModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.appInfoModel;
        }
        return (cr4) invokeV.objValue;
    }

    public String getButtonCmdScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            hf8 hf8Var = this.operate;
            if (hf8Var == null) {
                return this.scheme;
            }
            return hf8Var.c;
        }
        return (String) invokeV.objValue;
    }

    public String getButtonScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            hf8 hf8Var = this.operate;
            if (hf8Var == null) {
                return this.scheme;
            }
            return hf8Var.b;
        }
        return (String) invokeV.objValue;
    }

    public String getButtonText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            hf8 hf8Var = this.operate;
            if (hf8Var == null) {
                return null;
            }
            return hf8Var.a;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public String getDownloadKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if8 if8Var = this.downloadInfo;
            if (if8Var == null) {
                return null;
            }
            return if8Var.c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public String getExtInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            AdvertAppInfo advertAppInfo = this.appInfo;
            if (advertAppInfo == null) {
                return null;
            }
            return advertAppInfo.g;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public int getGoodsStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.goodsStyle;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ff8
    public String getImageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.userImage;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fh7
    public fh7.a getParallelCharge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.parallelChargeInfo;
        }
        return (fh7.a) invokeV.objValue;
    }

    public double getPicScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            lf8 lf8Var = this.picInfo;
            if (lf8Var == null) {
                return 1.0d;
            }
            return lf8Var.b;
        }
        return invokeV.doubleValue;
    }

    public String getPicUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            lf8 lf8Var = this.picInfo;
            if (lf8Var != null && !lh7.e(lf8Var.c)) {
                return (String) lh7.d(this.picInfo.c, 0);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.appInfo.position;
        }
        return invokeV.intValue;
    }

    public int getReplyNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            mf8 mf8Var = this.threadInfo;
            if (mf8Var == null) {
                return -1;
            }
            return mf8Var.c;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ff8
    public String getShareLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (me8.g(this.scheme)) {
                return Uri.parse(this.scheme).getQueryParameter("wap");
            }
            return this.scheme;
        }
        return (String) invokeV.objValue;
    }

    public int getShareNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            mf8 mf8Var = this.threadInfo;
            if (mf8Var == null) {
                return -1;
            }
            return mf8Var.b;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ff8
    public AdvertAppInfo getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return getAdvertAppInfo();
        }
        return (AdvertAppInfo) invokeV.objValue;
    }

    public long getTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            mf8 mf8Var = this.threadInfo;
            if (mf8Var == null) {
                return System.currentTimeMillis();
            }
            return mf8Var.d;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.ff8
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.threadTitle;
        }
        return (String) invokeV.objValue;
    }

    public boolean isNeedResize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            lf8 lf8Var = this.picInfo;
            if (lf8Var == null) {
                return false;
            }
            return lf8Var.a;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean isNoPicAd() {
        InterceptResult invokeV;
        lf8 lf8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            int i = this.goodsStyle;
            if ((i != 2 && i != 6 && i != 8) || (lf8Var = this.picInfo) == null || lh7.e(lf8Var.c)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public String getDownloadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if8 if8Var = this.downloadInfo;
            if (if8Var == null) {
                return "";
            }
            if (!TextUtils.isEmpty(if8Var.c)) {
                return this.downloadInfo.c;
            }
            if (!TextUtils.isEmpty(this.downloadInfo.a)) {
                return this.downloadInfo.a;
            }
            return this.adId;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            int i = this.goodsStyle;
            if (i != 7) {
                if (i == 8) {
                    return false;
                }
                if (i != 14) {
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
    public boolean isReusable(ICardInfo iCardInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, iCardInfo)) == null) {
            if (!(iCardInfo instanceof AdCard)) {
                return false;
            }
            AdCard adCard = (AdCard) iCardInfo;
            if (getCardType() != adCard.getCardType() || getGoodsStyle() != adCard.getGoodsStyle()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, advertAppInfo) == null) {
            this.appInfo = advertAppInfo;
            updataThreadData(advertAppInfo);
            of8 of8Var = this.tailFrame;
            if (!of8Var.k) {
                of8Var.a(this.appInfo, this);
            }
        }
    }

    public void updataThreadData(ThreadData threadData) {
        mf8 mf8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, threadData) == null) && threadData != null && (mf8Var = this.threadInfo) != null) {
            threadData.setLast_time_int(mf8Var.d / 1000);
            threadData.setReply_num(this.threadInfo.c);
            threadData.setAgreeNum(this.threadInfo.a);
            threadData.setShareNum(this.threadInfo.b);
            threadData.setTitle(this.threadTitle);
            threadData.getAuthor().setName_show(this.userName);
            threadData.getAuthor().setPortrait(this.userImage);
        }
    }
}
