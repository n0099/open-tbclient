package com.baidu.tieba.recapp.lego.model;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.JsonTransHelper;
import com.baidu.tbadk.core.util.TiebaMainDatabaseHelper;
import com.baidu.tieba.aja;
import com.baidu.tieba.bja;
import com.baidu.tieba.dg9;
import com.baidu.tieba.hw4;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.p16;
import com.baidu.tieba.pia;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.tieba.tia;
import com.baidu.tieba.uia;
import com.baidu.tieba.via;
import com.baidu.tieba.wha;
import com.baidu.tieba.wia;
import com.baidu.tieba.xf9;
import com.baidu.tieba.xia;
import com.baidu.tieba.yia;
import com.baidu.tieba.zia;
import com.baidu.tieba.zn0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.AdCloseInfo;
import tbclient.VideoInfo;
/* loaded from: classes8.dex */
public class AdCard extends BaseLegoCardInfo implements AdvertAppInfo.ILegoAdvert, pia, xf9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String adId;
    public a adRunTime;
    public AdvertAppInfo appInfo;
    public hw4 appInfoModel;
    public int cardType;
    public AdCloseInfo closeInfo;
    public String cmdScheme;
    public uia downloadInfo;
    public via enhanceModel;
    public String ext;
    public String floor;
    public wia gameModel;
    public int goodsStyle;
    public boolean isPBBanner;
    public int maxTitleLine;
    public xia nadTagModel;
    public tia operate;
    public xf9.a parallelChargeInfo;
    public yia picInfo;
    public String playCmdScheme;
    public String recommendReason;
    public String recommendReasonColor;
    public String recommendReasonNew;
    public zn0 richTitleLinkModel;
    public bja tailFrame;
    public zia threadInfo;
    public String threadTitle;
    public Boolean titleBold;
    public int urlType;
    public String userImage;
    public String userName;
    public aja verticalVideoStyle;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, obj)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Boolean a;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = Boolean.FALSE;
        }
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
        this.adRunTime = new a();
        JSONObject optJSONObject = jSONObject.optJSONObject("ad_common");
        if (optJSONObject != null) {
            this.adId = optJSONObject.optString("id");
            this.urlType = optJSONObject.optInt("url_type");
            this.scheme = optJSONObject.optString("scheme");
            this.floor = optJSONObject.optString("pos");
            this.ext = optJSONObject.optString(MigrateStatisticUtils.EXT_INFO);
            this.userName = optJSONObject.optString("user_name");
            this.userImage = optJSONObject.optString(RecommendDetailActivityConfig.USER_PORTRAIT);
            this.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
            this.goodsStyle = optJSONObject.optInt("goods_style");
            this.cardType = optJSONObject.optInt("card_type");
            this.maxTitleLine = optJSONObject.optInt("title_lines");
            this.recommendReason = optJSONObject.optString("recommend_reason");
            this.cmdScheme = optJSONObject.optString("cmd_scheme");
            this.playCmdScheme = optJSONObject.optString("play_cmd_scheme");
            this.titleBold = Boolean.valueOf(optJSONObject.optInt("title_bold", 0) == 1);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("title_link");
            if (optJSONObject2 != null) {
                this.richTitleLinkModel = zn0.a(optJSONObject2);
            }
            this.recommendReasonNew = optJSONObject.optString("new_recommend_reason");
            this.recommendReasonColor = optJSONObject.optString("recommend_reason_color");
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject(GameGuideConfigInfo.KEY_CLOSE_INFO);
        if (optJSONObject3 != null) {
            this.closeInfo = JsonTransHelper.parseAdCloseInfoFromJson(optJSONObject3);
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("operate");
        if (optJSONObject4 != null) {
            this.operate = tia.a(optJSONObject4);
        }
        bja bjaVar = new bja();
        this.tailFrame = bjaVar;
        bjaVar.b(jSONObject.optJSONObject(AdWebVideoActivityConfig.KEY_TAIL_FRAME));
        JSONObject optJSONObject5 = jSONObject.optJSONObject("app_info");
        if (optJSONObject5 != null) {
            this.appInfoModel = hw4.b(optJSONObject5);
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject("pic_info");
        if (optJSONObject6 != null) {
            this.picInfo = yia.a(optJSONObject6);
        }
        JSONObject optJSONObject7 = jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO);
        if (optJSONObject7 != null) {
            this.videoInfo = JsonTransHelper.parseVideoInfoFromJson(optJSONObject7);
        }
        JSONObject optJSONObject8 = jSONObject.optJSONObject("thread_info");
        if (optJSONObject8 != null) {
            this.threadInfo = zia.a(optJSONObject8);
        }
        JSONObject optJSONObject9 = jSONObject.optJSONObject(TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO);
        if (optJSONObject9 != null) {
            this.downloadInfo = uia.a(optJSONObject9);
        }
        JSONObject optJSONObject10 = jSONObject.optJSONObject("vertical_video_style");
        if (optJSONObject10 != null) {
            this.verticalVideoStyle = aja.b(optJSONObject10);
        }
        xf9.a aVar = new xf9.a();
        this.parallelChargeInfo = aVar;
        aVar.a(jSONObject);
        JSONObject optJSONObject11 = jSONObject.optJSONObject("enhancement");
        if (optJSONObject11 != null) {
            this.enhanceModel = via.a(optJSONObject11);
        }
        JSONObject optJSONObject12 = jSONObject.optJSONObject("play_button");
        if (optJSONObject12 != null) {
            this.gameModel = wia.a(optJSONObject12);
        }
        JSONObject optJSONObject13 = jSONObject.optJSONObject("ad_tag");
        if (optJSONObject13 != null) {
            this.nadTagModel = xia.a(optJSONObject13);
        }
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean checkIsAppAdvert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            uia uiaVar = this.downloadInfo;
            if (uiaVar == null || TextUtils.isEmpty(uiaVar.a) || TextUtils.isEmpty(this.downloadInfo.b)) {
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
            zia ziaVar = this.threadInfo;
            if (ziaVar == null) {
                return -1L;
            }
            return ziaVar.a;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public hw4 getAppInfoModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.appInfoModel;
        }
        return (hw4) invokeV.objValue;
    }

    public String getButtonCmdScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            tia tiaVar = this.operate;
            if (tiaVar == null) {
                return this.scheme;
            }
            return tiaVar.c;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String getButtonScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            tia tiaVar = this.operate;
            if (tiaVar == null) {
                return this.scheme;
            }
            return tiaVar.b;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public String getButtonText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            tia tiaVar = this.operate;
            if (tiaVar == null) {
                return null;
            }
            return tiaVar.a;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public String getDownloadKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            uia uiaVar = this.downloadInfo;
            if (uiaVar == null) {
                return null;
            }
            return uiaVar.c;
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

    @Override // com.baidu.tieba.pia
    public String getImageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.userImage;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xf9
    public xf9.a getParallelCharge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.parallelChargeInfo;
        }
        return (xf9.a) invokeV.objValue;
    }

    public double getPicScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            yia yiaVar = this.picInfo;
            if (yiaVar == null) {
                return 1.0d;
            }
            return yiaVar.b;
        }
        return invokeV.doubleValue;
    }

    @Nullable
    public String getPicUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            yia yiaVar = this.picInfo;
            if (yiaVar != null && !dg9.e(yiaVar.c)) {
                return (String) dg9.d(this.picInfo.c, 0);
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
            zia ziaVar = this.threadInfo;
            if (ziaVar == null) {
                return -1;
            }
            return ziaVar.c;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.pia
    public String getShareLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (wha.g(this.scheme)) {
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
            zia ziaVar = this.threadInfo;
            if (ziaVar == null) {
                return -1;
            }
            return ziaVar.b;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.pia
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
            zia ziaVar = this.threadInfo;
            if (ziaVar == null) {
                return System.currentTimeMillis();
            }
            return ziaVar.d;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.pia
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.threadTitle;
        }
        return (String) invokeV.objValue;
    }

    public boolean hitAdTagMove() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (p16.a().b("tieba_ad_tag_optimize_switch", 0) != 1 || this.nadTagModel == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isContainOperateRecommendReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            tia tiaVar = this.operate;
            if (tiaVar == null) {
                return false;
            }
            return !TextUtils.isEmpty(tiaVar.d);
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedExecuteOperateExpandAnim() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            tia tiaVar = this.operate;
            if (tiaVar == null || tiaVar.e <= 0 || this.adRunTime.a.booleanValue()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedResize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            yia yiaVar = this.picInfo;
            if (yiaVar == null) {
                return false;
            }
            return yiaVar.a;
        }
        return invokeV.booleanValue;
    }

    public boolean isNewLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            tia tiaVar = this.operate;
            if (tiaVar == null || tiaVar.f != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean isNoPicAd() {
        InterceptResult invokeV;
        yia yiaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            int i = this.goodsStyle;
            if ((i != 2 && i != 6 && i != 8) || (yiaVar = this.picInfo) == null || dg9.e(yiaVar.c)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowNewRecommendReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return !TextUtils.isEmpty(this.recommendReasonNew);
        }
        return invokeV.booleanValue;
    }

    public boolean isShowNewTitle() {
        InterceptResult invokeV;
        zn0.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            zn0 zn0Var = this.richTitleLinkModel;
            if (zn0Var == null || (bVar = zn0Var.a) == null || TextUtils.isEmpty(bVar.c)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    @NonNull
    public String getDownloadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            uia uiaVar = this.downloadInfo;
            if (uiaVar == null) {
                return "";
            }
            if (!TextUtils.isEmpty(uiaVar.c)) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, iCardInfo)) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048610, this, advertAppInfo) == null) {
            this.appInfo = advertAppInfo;
            updataThreadData(advertAppInfo);
            bja bjaVar = this.tailFrame;
            if (!bjaVar.k) {
                bjaVar.a(this.appInfo, this);
            }
            hw4 hw4Var = this.appInfoModel;
            if (hw4Var != null) {
                hw4Var.e(this.appInfo);
            }
        }
    }

    public void updataThreadData(ThreadData threadData) {
        zia ziaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048611, this, threadData) == null) && threadData != null && (ziaVar = this.threadInfo) != null) {
            threadData.setLast_time_int(ziaVar.d / 1000);
            threadData.setReply_num(this.threadInfo.c);
            threadData.setAgreeNum(this.threadInfo.a);
            threadData.setShareNum(this.threadInfo.b);
            threadData.setTitle(this.threadTitle);
            threadData.getAuthor().setName_show(this.userName);
            threadData.getAuthor().setPortrait(this.userImage);
        }
    }
}
