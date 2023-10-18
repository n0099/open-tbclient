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
import com.baidu.tieba.ez8;
import com.baidu.tieba.fn0;
import com.baidu.tieba.jz5;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lv4;
import com.baidu.tieba.n0a;
import com.baidu.tieba.r0a;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.tieba.s0a;
import com.baidu.tieba.t0a;
import com.baidu.tieba.u0a;
import com.baidu.tieba.uz9;
import com.baidu.tieba.v0a;
import com.baidu.tieba.w0a;
import com.baidu.tieba.x0a;
import com.baidu.tieba.y0a;
import com.baidu.tieba.yy8;
import com.baidu.tieba.z0a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.AdCloseInfo;
import tbclient.VideoInfo;
/* loaded from: classes7.dex */
public class AdCard extends BaseLegoCardInfo implements AdvertAppInfo.ILegoAdvert, n0a, yy8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String adId;
    public a adRunTime;
    public AdvertAppInfo appInfo;
    public lv4 appInfoModel;
    public int cardType;
    public AdCloseInfo closeInfo;
    public String cmdScheme;
    public s0a downloadInfo;
    public t0a enhanceModel;
    public String ext;
    public String floor;
    public u0a gameModel;
    public int goodsStyle;
    public boolean isPBBanner;
    public int maxTitleLine;
    public v0a nadTagModel;
    public r0a operate;
    public yy8.a parallelChargeInfo;
    public w0a picInfo;
    public String playCmdScheme;
    public String recommendReason;
    public String recommendReasonColor;
    public String recommendReasonNew;
    public fn0 richTitleLinkModel;
    public z0a tailFrame;
    public x0a threadInfo;
    public String threadTitle;
    public Boolean titleBold;
    public int urlType;
    public String userImage;
    public String userName;
    public y0a verticalVideoStyle;
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

    /* loaded from: classes7.dex */
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
                this.richTitleLinkModel = fn0.a(optJSONObject2);
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
            this.operate = r0a.a(optJSONObject4);
        }
        z0a z0aVar = new z0a();
        this.tailFrame = z0aVar;
        z0aVar.b(jSONObject.optJSONObject(AdWebVideoActivityConfig.KEY_TAIL_FRAME));
        JSONObject optJSONObject5 = jSONObject.optJSONObject("app_info");
        if (optJSONObject5 != null) {
            this.appInfoModel = lv4.b(optJSONObject5);
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject("pic_info");
        if (optJSONObject6 != null) {
            this.picInfo = w0a.a(optJSONObject6);
        }
        JSONObject optJSONObject7 = jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO);
        if (optJSONObject7 != null) {
            this.videoInfo = JsonTransHelper.parseVideoInfoFromJson(optJSONObject7);
        }
        JSONObject optJSONObject8 = jSONObject.optJSONObject("thread_info");
        if (optJSONObject8 != null) {
            this.threadInfo = x0a.a(optJSONObject8);
        }
        JSONObject optJSONObject9 = jSONObject.optJSONObject(TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO);
        if (optJSONObject9 != null) {
            this.downloadInfo = s0a.a(optJSONObject9);
        }
        JSONObject optJSONObject10 = jSONObject.optJSONObject("vertical_video_style");
        if (optJSONObject10 != null) {
            this.verticalVideoStyle = y0a.b(optJSONObject10);
        }
        yy8.a aVar = new yy8.a();
        this.parallelChargeInfo = aVar;
        aVar.a(jSONObject);
        JSONObject optJSONObject11 = jSONObject.optJSONObject("enhancement");
        if (optJSONObject11 != null) {
            this.enhanceModel = t0a.a(optJSONObject11);
        }
        JSONObject optJSONObject12 = jSONObject.optJSONObject("play_button");
        if (optJSONObject12 != null) {
            this.gameModel = u0a.a(optJSONObject12);
        }
        JSONObject optJSONObject13 = jSONObject.optJSONObject("ad_tag");
        if (optJSONObject13 != null) {
            this.nadTagModel = v0a.a(optJSONObject13);
        }
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean checkIsAppAdvert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            s0a s0aVar = this.downloadInfo;
            if (s0aVar == null || TextUtils.isEmpty(s0aVar.a) || TextUtils.isEmpty(this.downloadInfo.b)) {
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
            x0a x0aVar = this.threadInfo;
            if (x0aVar == null) {
                return -1L;
            }
            return x0aVar.a;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public lv4 getAppInfoModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.appInfoModel;
        }
        return (lv4) invokeV.objValue;
    }

    public String getButtonCmdScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            r0a r0aVar = this.operate;
            if (r0aVar == null) {
                return this.scheme;
            }
            return r0aVar.c;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String getButtonScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            r0a r0aVar = this.operate;
            if (r0aVar == null) {
                return this.scheme;
            }
            return r0aVar.b;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public String getButtonText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            r0a r0aVar = this.operate;
            if (r0aVar == null) {
                return null;
            }
            return r0aVar.a;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public String getDownloadKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            s0a s0aVar = this.downloadInfo;
            if (s0aVar == null) {
                return null;
            }
            return s0aVar.c;
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

    @Override // com.baidu.tieba.n0a
    public String getImageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.userImage;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yy8
    public yy8.a getParallelCharge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.parallelChargeInfo;
        }
        return (yy8.a) invokeV.objValue;
    }

    public double getPicScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            w0a w0aVar = this.picInfo;
            if (w0aVar == null) {
                return 1.0d;
            }
            return w0aVar.b;
        }
        return invokeV.doubleValue;
    }

    @Nullable
    public String getPicUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            w0a w0aVar = this.picInfo;
            if (w0aVar != null && !ez8.e(w0aVar.c)) {
                return (String) ez8.d(this.picInfo.c, 0);
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
            x0a x0aVar = this.threadInfo;
            if (x0aVar == null) {
                return -1;
            }
            return x0aVar.c;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.n0a
    public String getShareLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (uz9.g(this.scheme)) {
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
            x0a x0aVar = this.threadInfo;
            if (x0aVar == null) {
                return -1;
            }
            return x0aVar.b;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.n0a
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
            x0a x0aVar = this.threadInfo;
            if (x0aVar == null) {
                return System.currentTimeMillis();
            }
            return x0aVar.d;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.n0a
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
            if (jz5.a().b("tieba_ad_tag_optimize_switch", 0) != 1 || this.nadTagModel == null) {
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
            r0a r0aVar = this.operate;
            if (r0aVar == null) {
                return false;
            }
            return !TextUtils.isEmpty(r0aVar.d);
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedExecuteOperateExpandAnim() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            r0a r0aVar = this.operate;
            if (r0aVar == null || r0aVar.e <= 0 || this.adRunTime.a.booleanValue()) {
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
            w0a w0aVar = this.picInfo;
            if (w0aVar == null) {
                return false;
            }
            return w0aVar.a;
        }
        return invokeV.booleanValue;
    }

    public boolean isNewLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            r0a r0aVar = this.operate;
            if (r0aVar == null || r0aVar.f != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean isNoPicAd() {
        InterceptResult invokeV;
        w0a w0aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            int i = this.goodsStyle;
            if ((i != 2 && i != 6 && i != 8) || (w0aVar = this.picInfo) == null || ez8.e(w0aVar.c)) {
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
        fn0.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            fn0 fn0Var = this.richTitleLinkModel;
            if (fn0Var == null || (bVar = fn0Var.a) == null || TextUtils.isEmpty(bVar.c)) {
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
            s0a s0aVar = this.downloadInfo;
            if (s0aVar == null) {
                return "";
            }
            if (!TextUtils.isEmpty(s0aVar.c)) {
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
            z0a z0aVar = this.tailFrame;
            if (!z0aVar.k) {
                z0aVar.a(this.appInfo, this);
            }
            lv4 lv4Var = this.appInfoModel;
            if (lv4Var != null) {
                lv4Var.e(this.appInfo);
            }
        }
    }

    public void updataThreadData(ThreadData threadData) {
        x0a x0aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048611, this, threadData) == null) && threadData != null && (x0aVar = this.threadInfo) != null) {
            threadData.setLast_time_int(x0aVar.d / 1000);
            threadData.setReply_num(this.threadInfo.c);
            threadData.setAgreeNum(this.threadInfo.a);
            threadData.setShareNum(this.threadInfo.b);
            threadData.setTitle(this.threadTitle);
            threadData.getAuthor().setName_show(this.userName);
            threadData.getAuthor().setPortrait(this.userImage);
        }
    }
}
