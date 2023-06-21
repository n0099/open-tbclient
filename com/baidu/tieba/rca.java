package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tieba.video.LiveConfig;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rca {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final VideoItemData a;
    @Nullable
    public final LiveConfig b;

    public rca(@Nullable VideoItemData videoItemData, @Nullable LiveConfig liveConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {videoItemData, liveConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = videoItemData;
        this.b = liveConfig;
    }

    public void a(int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) && this.a != null && this.b != null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.VIDEO_LIVE_PAGE_AUTO_JUMP);
            statisticItem.addParam("tid", this.a.thread_id);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.addParam("obj_locate", i);
            statisticItem.addParam("obj_source", this.a.mRecomSource);
            statisticItem.addParam("obj_type", str);
            statisticItem.addParam(TiebaStatic.Params.OBJ_TO, this.b.getCurrentRealHitStrategy());
            statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM3, this.b.getWaitSecond());
            statisticItem.addParam("obj_param1", YYLiveUtil.calculateLiveType(this.a.getLivePageData()));
            statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM2, this.b.getWaitSecond());
            if (this.a.getLivePageData() != null && this.a.getLivePageData().mYyExtData != null) {
                statisticItem.addParam(TiebaStatic.YYParams.YYSID, this.a.getLivePageData().mYyExtData.mSid);
                statisticItem.addParam(TiebaStatic.YYParams.YYSSID, this.a.getLivePageData().mYyExtData.mSsid);
                statisticItem.addParam("yyuid", this.a.getLivePageData().mYyExtData.mYyUid);
            }
            statisticItem.addParam(TiebaStatic.YYParams.YYLIVEID, 1);
            statisticItem.addParam("template_id", 1);
            TiebaStatic.log(statisticItem);
        }
    }

    public void c(int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) && this.a != null && this.b != null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.VIDEO_LIVE_PAGE_SHOW);
            statisticItem.addParam("tid", this.a.thread_id);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.addParam("obj_locate", i);
            statisticItem.addParam("obj_source", this.a.mRecomSource);
            statisticItem.addParam("obj_type", str);
            statisticItem.addParam(TiebaStatic.Params.OBJ_TO, this.b.getCurrentRealHitStrategy());
            statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM3, this.b.getWaitSecond());
            statisticItem.addParam("obj_param1", YYLiveUtil.calculateLiveType(this.a.getLivePageData()));
            statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM2, this.b.getWaitSecond());
            if (this.a.getLivePageData() != null && this.a.getLivePageData().mYyExtData != null) {
                statisticItem.addParam(TiebaStatic.YYParams.YYSID, this.a.getLivePageData().mYyExtData.mSid);
                statisticItem.addParam(TiebaStatic.YYParams.YYSSID, this.a.getLivePageData().mYyExtData.mSsid);
                statisticItem.addParam("yyuid", this.a.getLivePageData().mYyExtData.mYyUid);
            }
            statisticItem.addParam(TiebaStatic.YYParams.YYLIVEID, 1);
            statisticItem.addParam("template_id", 1);
            TiebaStatic.log(statisticItem);
        }
    }

    public void b(int i, String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) && this.a != null && this.b != null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.VIDEO_LIVE_PAGE_CLICK);
            statisticItem.addParam("tid", this.a.thread_id);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.addParam("obj_locate", i);
            statisticItem.addParam("obj_source", this.a.mRecomSource);
            statisticItem.addParam("obj_name", i2);
            statisticItem.addParam("obj_type", str);
            statisticItem.addParam(TiebaStatic.Params.OBJ_TO, this.b.getCurrentRealHitStrategy());
            statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM3, this.b.getWaitSecond());
            statisticItem.addParam("obj_param1", YYLiveUtil.calculateLiveType(this.a.getLivePageData()));
            statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM2, this.b.getWaitSecond());
            if (this.a.getLivePageData() != null && this.a.getLivePageData().mYyExtData != null) {
                statisticItem.addParam(TiebaStatic.YYParams.YYSID, this.a.getLivePageData().mYyExtData.mSid);
                statisticItem.addParam(TiebaStatic.YYParams.YYSSID, this.a.getLivePageData().mYyExtData.mSsid);
                statisticItem.addParam("yyuid", this.a.getLivePageData().mYyExtData.mYyUid);
            }
            statisticItem.addParam(TiebaStatic.YYParams.YYLIVEID, 1);
            statisticItem.addParam("template_id", 1);
            TiebaStatic.log(statisticItem);
        }
    }

    @Nullable
    public hk9 d(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, str)) == null) {
            if (this.a != null && this.b != null) {
                hk9 hk9Var = new hk9();
                hk9Var.e = TbadkCoreApplication.getCurrentAccount();
                hk9Var.c = this.a.thread_id;
                hk9Var.a = String.valueOf(i);
                hk9Var.f = this.a.mRecomSource;
                hk9Var.A = str;
                hk9Var.B = String.valueOf(this.b.getCurrentRealHitStrategy());
                hk9Var.g = String.valueOf(this.b.getWaitSecond());
                hk9Var.h = TiebaStatic.YYValues.YY_LIVE;
                hk9Var.i = String.valueOf(YYLiveUtil.calculateLiveType(this.a.getLivePageData()));
                if (this.a.getLivePageData() != null && this.a.getLivePageData().mYyExtData != null) {
                    hk9Var.C = this.a.getLivePageData().mYyExtData.mSid;
                    hk9Var.D = this.a.getLivePageData().mYyExtData.mSsid;
                    hk9Var.E = this.a.getLivePageData().mYyExtData.mYyUid;
                }
                hk9Var.F = "1";
                hk9Var.G = "1";
                return hk9Var;
            }
            return null;
        }
        return (hk9) invokeIL.objValue;
    }
}
