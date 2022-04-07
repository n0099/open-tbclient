package com.baidu.tieba.recapp.lego.model;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.JsonTransHelper;
import com.baidu.tbadk.core.util.TiebaMainDatabaseHelper;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ac8;
import com.repackage.ad7;
import com.repackage.bc8;
import com.repackage.cc8;
import com.repackage.dc8;
import com.repackage.ec8;
import com.repackage.fc8;
import com.repackage.ga8;
import com.repackage.gc8;
import com.repackage.gd7;
import com.repackage.sn4;
import com.repackage.xb8;
import com.repackage.zb8;
import org.json.JSONObject;
import tbclient.AdCloseInfo;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class AdCard extends BaseLegoCardInfo implements AdvertAppInfo.ILegoAdvert, xb8, ad7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String adId;
    public AdvertAppInfo appInfo;
    public sn4 appInfoModel;
    public int cardType;
    public AdCloseInfo closeInfo;
    public String cmdScheme;
    public ac8 downloadInfo;
    public bc8 enhanceModel;
    public String ext;
    public String floor;
    public cc8 gameModel;
    public int goodsStyle;
    public boolean isPBBanner;
    public int maxTitleLine;
    public zb8 operate;
    public ad7.a parallelChargeInfo;
    public dc8 picInfo;
    public String playCmdScheme;
    public String recommendReason;
    public gc8 tailFrame;
    public ec8 threadInfo;
    public String threadTitle;
    public int urlType;
    public String userImage;
    public String userName;
    public fc8 verticalVideoStyle;
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
            this.userImage = optJSONObject.optString("user_portrait");
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
            this.operate = zb8.a(optJSONObject3);
        }
        gc8 gc8Var = new gc8();
        this.tailFrame = gc8Var;
        gc8Var.b(jSONObject.optJSONObject(AdWebVideoActivityConfig.KEY_TAIL_FRAME));
        JSONObject optJSONObject4 = jSONObject.optJSONObject("app_info");
        if (optJSONObject4 != null) {
            this.appInfoModel = sn4.b(optJSONObject4);
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("pic_info");
        if (optJSONObject5 != null) {
            this.picInfo = dc8.a(optJSONObject5);
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO);
        if (optJSONObject6 != null) {
            this.videoInfo = JsonTransHelper.parseVideoInfoFromJson(optJSONObject6);
        }
        JSONObject optJSONObject7 = jSONObject.optJSONObject("thread_info");
        if (optJSONObject7 != null) {
            this.threadInfo = ec8.a(optJSONObject7);
        }
        JSONObject optJSONObject8 = jSONObject.optJSONObject(TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO);
        if (optJSONObject8 != null) {
            this.downloadInfo = ac8.a(optJSONObject8);
        }
        JSONObject optJSONObject9 = jSONObject.optJSONObject("vertical_video_style");
        if (optJSONObject9 != null) {
            this.verticalVideoStyle = fc8.b(optJSONObject9);
        }
        ad7.a aVar = new ad7.a();
        this.parallelChargeInfo = aVar;
        aVar.a(jSONObject);
        JSONObject optJSONObject10 = jSONObject.optJSONObject("enhancement");
        if (optJSONObject10 != null) {
            this.enhanceModel = bc8.a(optJSONObject10);
        }
        JSONObject optJSONObject11 = jSONObject.optJSONObject("play_button");
        if (optJSONObject11 != null) {
            this.gameModel = cc8.a(optJSONObject11);
        }
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean checkIsAppAdvert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ac8 ac8Var = this.downloadInfo;
            return (ac8Var == null || TextUtils.isEmpty(ac8Var.a) || TextUtils.isEmpty(this.downloadInfo.b)) ? false : true;
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
            ec8 ec8Var = this.threadInfo;
            if (ec8Var == null) {
                return -1L;
            }
            return ec8Var.a;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public sn4 getAppInfoModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.appInfoModel : (sn4) invokeV.objValue;
    }

    public String getButtonCmdScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            zb8 zb8Var = this.operate;
            if (zb8Var == null) {
                return this.scheme;
            }
            return zb8Var.d;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String getButtonScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            zb8 zb8Var = this.operate;
            if (zb8Var == null) {
                return this.scheme;
            }
            return zb8Var.c;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public String getButtonText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            zb8 zb8Var = this.operate;
            if (zb8Var == null) {
                return null;
            }
            return zb8Var.b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    @NonNull
    public String getDownloadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ac8 ac8Var = this.downloadInfo;
            if (ac8Var == null) {
                return "";
            }
            if (!TextUtils.isEmpty(ac8Var.c)) {
                return this.downloadInfo.c;
            }
            if (!TextUtils.isEmpty(this.downloadInfo.a)) {
                return this.downloadInfo.a;
            }
            return this.adId;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public String getDownloadKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ac8 ac8Var = this.downloadInfo;
            if (ac8Var == null) {
                return null;
            }
            return ac8Var.c;
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
            return advertAppInfo.h;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public int getGoodsStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.goodsStyle : invokeV.intValue;
    }

    @Override // com.repackage.xb8
    public String getImageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.userImage : (String) invokeV.objValue;
    }

    @Override // com.repackage.ad7
    public ad7.a getParallelCharge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.parallelChargeInfo : (ad7.a) invokeV.objValue;
    }

    public double getPicScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            dc8 dc8Var = this.picInfo;
            if (dc8Var == null) {
                return 1.0d;
            }
            return dc8Var.b;
        }
        return invokeV.doubleValue;
    }

    @Nullable
    public String getPicUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            dc8 dc8Var = this.picInfo;
            if (dc8Var == null || gd7.e(dc8Var.c)) {
                return null;
            }
            return (String) gd7.d(this.picInfo.c, 0);
        }
        return (String) invokeV.objValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.appInfo.position : invokeV.intValue;
    }

    public int getReplyNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            ec8 ec8Var = this.threadInfo;
            if (ec8Var == null) {
                return -1;
            }
            return ec8Var.c;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.xb8
    public String getShareLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (ga8.p(this.scheme)) {
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
            ec8 ec8Var = this.threadInfo;
            if (ec8Var == null) {
                return -1;
            }
            return ec8Var.b;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.xb8
    public AdvertAppInfo getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? getAdvertAppInfo() : (AdvertAppInfo) invokeV.objValue;
    }

    public long getTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            ec8 ec8Var = this.threadInfo;
            if (ec8Var == null) {
                return System.currentTimeMillis();
            }
            return ec8Var.d;
        }
        return invokeV.longValue;
    }

    @Override // com.repackage.xb8
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.threadTitle : (String) invokeV.objValue;
    }

    public boolean isNeedResize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            dc8 dc8Var = this.picInfo;
            if (dc8Var == null) {
                return false;
            }
            return dc8Var.a;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean isNoPicAd() {
        InterceptResult invokeV;
        dc8 dc8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            int i = this.goodsStyle;
            return ((i != 2 && i != 6 && i != 8) || (dc8Var = this.picInfo) == null || gd7.e(dc8Var.c)) ? false : true;
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
            gc8 gc8Var = this.tailFrame;
            if (gc8Var.k) {
                return;
            }
            gc8Var.a(this.appInfo, this);
        }
    }

    public void updataThreadData(ThreadData threadData) {
        ec8 ec8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, threadData) == null) || threadData == null || (ec8Var = this.threadInfo) == null) {
            return;
        }
        threadData.setLast_time_int(ec8Var.d / 1000);
        threadData.setReply_num(this.threadInfo.c);
        threadData.setAgreeNum(this.threadInfo.a);
        threadData.setShareNum(this.threadInfo.b);
        threadData.setTitle(this.threadTitle);
        threadData.getAuthor().setName_show(this.userName);
        threadData.getAuthor().setPortrait(this.userImage);
    }
}
