package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
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
public class n9b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final VideoItemData a;
    @Nullable
    public final LiveConfig b;

    public n9b(@Nullable VideoItemData videoItemData, @Nullable LiveConfig liveConfig) {
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

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if ("index".equals(str)) {
                return "index";
            }
            if ("concern_tab".equals(str)) {
                return "concern_tab";
            }
            if ("frs".equals(str)) {
                return "FRS";
            }
            return AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
        }
        return (String) invokeL.objValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            VideoItemData videoItemData = this.a;
            if (videoItemData != null && videoItemData.getLivePageData() != null && this.a.getLivePageData().mYyExtData != null && !StringUtils.isNull(this.a.getLivePageData().mYyExtData.mSid)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void c(int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) && this.a != null && this.b != null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.VIDEO_LIVE_PAGE_AUTO_JUMP);
            statisticItem.addParam("tid", this.a.thread_id);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.addParam("cuid", TbadkCoreApplication.getInst().getCuid());
            statisticItem.addParam("obj_locate", i);
            statisticItem.addParam("obj_source", this.a.mRecomSource);
            statisticItem.addParam("obj_type", str);
            statisticItem.addParam(TiebaStatic.Params.OBJ_TO, this.b.getCurrentRealHitStrategy());
            statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM3, this.b.getWaitSecond());
            statisticItem.addParam("obj_param1", YYLiveUtil.calculateLiveType(this.a.getLivePageData()));
            statisticItem.addParam("hdid", TbadkCoreApplication.getInst().getHdid());
            if (this.a.getLivePageData() != null && this.a.getLivePageData().mYyExtData != null) {
                statisticItem.addParam(TiebaStatic.YYParams.YYSID, this.a.getLivePageData().mYyExtData.mSid);
                statisticItem.addParam(TiebaStatic.YYParams.YYSSID, this.a.getLivePageData().mYyExtData.mSsid);
                statisticItem.addParam("yyuid", this.a.getLivePageData().mYyExtData.mYyUid);
                statisticItem.addParam("template_id", this.a.getLivePageData().mYyExtData.mTemplateId);
            }
            if (b()) {
                statisticItem.addParam(TiebaStatic.YYParams.YYLIVEID, "1");
                statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM2, TiebaStatic.YYValues.YY_LIVE);
            } else {
                statisticItem.addParam(TiebaStatic.YYParams.YYLIVEID, "");
                if (this.a.getLivePageData() != null && !StringUtils.isNull(this.a.getLivePageData().appId)) {
                    statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM2, this.a.getLivePageData().appId);
                } else {
                    statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM2, "");
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public void e(int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) && this.a != null && this.b != null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.VIDEO_LIVE_PAGE_SHOW);
            statisticItem.addParam("tid", this.a.thread_id);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.addParam("cuid", TbadkCoreApplication.getInst().getCuid());
            statisticItem.addParam("obj_locate", i);
            statisticItem.addParam("obj_source", this.a.mRecomSource);
            statisticItem.addParam("obj_type", str);
            statisticItem.addParam(TiebaStatic.Params.OBJ_TO, this.b.getCurrentRealHitStrategy());
            statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM3, this.b.getWaitSecond());
            statisticItem.addParam("obj_param1", YYLiveUtil.calculateLiveType(this.a.getLivePageData()));
            statisticItem.addParam("hdid", TbadkCoreApplication.getInst().getHdid());
            if (this.a.getLivePageData() != null && this.a.getLivePageData().mYyExtData != null) {
                statisticItem.addParam(TiebaStatic.YYParams.YYSID, this.a.getLivePageData().mYyExtData.mSid);
                statisticItem.addParam(TiebaStatic.YYParams.YYSSID, this.a.getLivePageData().mYyExtData.mSsid);
                statisticItem.addParam("yyuid", this.a.getLivePageData().mYyExtData.mYyUid);
                statisticItem.addParam("template_id", this.a.getLivePageData().mYyExtData.mTemplateId);
            }
            if (b()) {
                statisticItem.addParam(TiebaStatic.YYParams.YYLIVEID, "1");
                statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM2, TiebaStatic.YYValues.YY_LIVE);
            } else {
                statisticItem.addParam(TiebaStatic.YYParams.YYLIVEID, "");
                if (this.a.getLivePageData() != null && !StringUtils.isNull(this.a.getLivePageData().appId)) {
                    statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM2, this.a.getLivePageData().appId);
                } else {
                    statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM2, "");
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public void d(int i, String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) && this.a != null && this.b != null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.VIDEO_LIVE_PAGE_CLICK);
            statisticItem.addParam("tid", this.a.thread_id);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.addParam("cuid", TbadkCoreApplication.getInst().getCuid());
            statisticItem.addParam("obj_locate", i);
            statisticItem.addParam("obj_source", this.a.mRecomSource);
            statisticItem.addParam("obj_name", i2);
            statisticItem.addParam("obj_type", str);
            statisticItem.addParam(TiebaStatic.Params.OBJ_TO, this.b.getCurrentRealHitStrategy());
            statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM3, this.b.getWaitSecond());
            statisticItem.addParam("obj_param1", YYLiveUtil.calculateLiveType(this.a.getLivePageData()));
            statisticItem.addParam("hdid", TbadkCoreApplication.getInst().getHdid());
            if (this.a.getLivePageData() != null && this.a.getLivePageData().mYyExtData != null) {
                statisticItem.addParam(TiebaStatic.YYParams.YYSID, this.a.getLivePageData().mYyExtData.mSid);
                statisticItem.addParam(TiebaStatic.YYParams.YYSSID, this.a.getLivePageData().mYyExtData.mSsid);
                statisticItem.addParam("yyuid", this.a.getLivePageData().mYyExtData.mYyUid);
                statisticItem.addParam("template_id", this.a.getLivePageData().mYyExtData.mTemplateId);
            }
            if (b()) {
                statisticItem.addParam(TiebaStatic.YYParams.YYLIVEID, "1");
                statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM2, TiebaStatic.YYValues.YY_LIVE);
            } else {
                statisticItem.addParam(TiebaStatic.YYParams.YYLIVEID, "");
                if (this.a.getLivePageData() != null && !StringUtils.isNull(this.a.getLivePageData().appId)) {
                    statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM2, this.a.getLivePageData().appId);
                } else {
                    statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM2, "");
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    @Nullable
    public gea f(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i, str)) == null) {
            if (this.a != null && this.b != null) {
                gea geaVar = new gea();
                geaVar.e = TbadkCoreApplication.getCurrentAccount();
                geaVar.c = this.a.thread_id;
                geaVar.a = String.valueOf(i);
                geaVar.f = this.a.mRecomSource;
                geaVar.A = str;
                geaVar.B = String.valueOf(this.b.getCurrentRealHitStrategy());
                geaVar.i = String.valueOf(this.b.getWaitSecond());
                geaVar.H = TbadkCoreApplication.getInst().getHdid();
                geaVar.g = String.valueOf(YYLiveUtil.calculateLiveType(this.a.getLivePageData()));
                if (this.a.getLivePageData() != null && this.a.getLivePageData().mYyExtData != null) {
                    geaVar.C = this.a.getLivePageData().mYyExtData.mSid;
                    geaVar.D = this.a.getLivePageData().mYyExtData.mSsid;
                    geaVar.E = this.a.getLivePageData().mYyExtData.mYyUid;
                    geaVar.G = this.a.getLivePageData().mYyExtData.mTemplateId;
                }
                if (b()) {
                    geaVar.h = TiebaStatic.YYValues.YY_LIVE;
                    geaVar.F = "1";
                } else {
                    geaVar.h = "";
                    geaVar.F = "";
                    if (this.a.getLivePageData() != null && !StringUtils.isNull(this.a.getLivePageData().appId)) {
                        geaVar.h = this.a.getLivePageData().appId;
                    } else {
                        geaVar.h = "";
                    }
                }
                return geaVar;
            }
            return null;
        }
        return (gea) invokeIL.objValue;
    }
}
