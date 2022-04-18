package com.baidu.tieba.pb;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mg;
import com.repackage.rc5;
import com.repackage.tc8;
import com.repackage.xb5;
import com.repackage.yc8;
import com.squareup.wire.Wire;
import tbclient.PbPage.AdParam;
import tbclient.PbPage.DataReq;
import tbclient.PbPage.PbPageReqIdl;
/* loaded from: classes3.dex */
public class PbPageRequestMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public static final Wire WIRE;
    public transient /* synthetic */ FieldHolder $fh;
    public Integer arround;
    public Integer back;
    public Integer banner;
    public String cacheKey;
    public int floor_rn;
    public Long forumId;
    public Integer fromSmartFrs;
    public int from_push;
    public int immersionVideoCommentSource;
    public boolean isFromMark;
    public boolean isFromPbOptimize;
    public boolean isJumpFloor;
    public Integer isReqAd;
    public boolean isReqFoldComment;
    public boolean isSubPostDataReverse;
    public int jumpFloorNum;
    public long kz;
    public Integer last;
    public String lastids;
    public int loadCount;
    public Integer lz;
    public int mAfterAdThreadCount;
    public int mFloorSortType;
    public String mLocate;
    public String mObjLocate;
    public String mSchemeUrl;
    public Integer mark;
    public String message_click;
    public Integer message_id;
    public Integer needRepostRecommendForum;
    public String objParam1;
    public String obj_source;
    public long officialBarMsgId;
    public long opMessageID;
    public int opStat;
    public String opType;
    public String opUrl;
    public String oriUgcNid;
    public String oriUgcTid;
    public int oriUgcType;
    public String oriUgcVid;
    public long pid;
    public Integer pn;
    public Integer q_type;
    public Integer r;
    public int refreshCount;
    public Integer rn;
    public double scr_dip;
    public Integer scr_h;
    public Integer scr_w;
    public int sourceType;
    public String st_type;
    public Integer thread_type;
    public int updateType;
    public Integer with_floor;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(57247283, "Lcom/baidu/tieba/pb/PbPageRequestMessage;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(57247283, "Lcom/baidu/tieba/pb/PbPageRequestMessage;");
                return;
            }
        }
        WIRE = new Wire(new Class[0]);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbPageRequestMessage() {
        super(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isFromPbOptimize = false;
        this.isSubPostDataReverse = false;
        this.isJumpFloor = false;
        this.jumpFloorNum = 0;
        this.opType = null;
        this.opUrl = null;
        this.objParam1 = "";
        this.obj_source = "";
        this.fromSmartFrs = 0;
        this.isReqAd = 0;
        this.mSchemeUrl = "";
        this.mObjLocate = "";
        this.sourceType = 2;
        this.immersionVideoCommentSource = 0;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            try {
                DataReq.Builder builder = new DataReq.Builder();
                builder.pb_rn = 0;
                builder.mark = this.mark;
                builder.back = this.back;
                builder.kz = Long.valueOf(this.kz);
                builder.lz = this.lz;
                builder.r = this.r;
                builder.pid = Long.valueOf(this.pid);
                builder.with_floor = this.with_floor;
                builder.floor_rn = Integer.valueOf(this.floor_rn);
                builder.weipost = 0;
                builder.message_id = this.message_id;
                builder.s_model = 0;
                builder.rn = this.rn;
                builder.scr_w = this.scr_w;
                builder.scr_h = this.scr_h;
                builder.scr_dip = Double.valueOf(this.scr_dip);
                builder.q_type = this.q_type;
                builder.pn = this.pn;
                builder.st_type = this.st_type;
                builder.yuelaou_locate = this.mLocate;
                builder.thread_type = this.thread_type;
                builder.banner = this.banner;
                builder.arround = this.arround;
                builder.msg_click = this.message_click;
                builder.last = this.last;
                builder.lastids = this.lastids;
                int i = 1;
                builder.is_comm_reverse = Integer.valueOf(this.isSubPostDataReverse ? 1 : 0);
                builder.is_jumpfloor = Integer.valueOf(this.isJumpFloor ? 1 : 0);
                builder.jumpfloor_num = Integer.valueOf(this.jumpFloorNum);
                builder.broadcast_id = Long.valueOf(this.officialBarMsgId);
                builder.floor_sort_type = Integer.valueOf(this.mFloorSortType);
                if (this.opType != null) {
                    builder.st_from = this.opType;
                    builder.st_link = this.opUrl;
                    builder.st_stat = Integer.valueOf(this.opStat);
                    builder.st_task = Long.valueOf(this.opMessageID);
                }
                builder.obj_param1 = this.objParam1;
                builder.obj_source = this.obj_source;
                builder.obj_locate = this.mObjLocate;
                builder.from_smart_frs = this.fromSmartFrs;
                builder.app_pos = tc8.e().a();
                builder.forum_id = this.forumId;
                builder.need_repost_recommend_forum = this.needRepostRecommendForum;
                AdParam.Builder builder2 = new AdParam.Builder();
                builder2.refresh_count = Integer.valueOf(this.refreshCount);
                builder2.load_count = Integer.valueOf(this.loadCount);
                builder2.is_req_ad = this.isReqAd;
                builder.ad_param = builder2.build(false);
                builder.ori_ugc_nid = this.oriUgcNid;
                builder.ori_ugc_tid = this.oriUgcTid;
                builder.ori_ugc_type = Integer.valueOf(this.oriUgcType);
                builder.ori_ugc_vid = this.oriUgcVid;
                builder.ad_context_list = yc8.f().d("PB");
                builder.up_schema = this.mSchemeUrl;
                builder.from_push = Integer.valueOf(this.from_push);
                AdExtParam.a b = AdExtParam.a.b();
                b.h(this.updateType);
                builder.ad_ext_params = b.a();
                builder.source_type = Integer.valueOf(this.sourceType);
                rc5.c(builder, true, false, true);
                builder.immersion_video_comment_source = Integer.valueOf(this.immersionVideoCommentSource);
                builder.app_transmit_data = xb5.b();
                if (!this.isReqFoldComment) {
                    i = 0;
                }
                builder.is_fold_comment_req = Integer.valueOf(i);
                PbPageReqIdl.Builder builder3 = new PbPageReqIdl.Builder();
                builder3.data = builder.build(false);
                return builder3.build(false);
            } catch (Exception unused) {
                return null;
            }
        }
        return invokeZ.objValue;
    }

    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.cacheKey : (String) invokeV.objValue;
    }

    public boolean getIsFromMark() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.isFromMark : invokeV.booleanValue;
    }

    public Integer getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.pn : (Integer) invokeV.objValue;
    }

    public Integer getR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.r : (Integer) invokeV.objValue;
    }

    public String getSchemeUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mSchemeUrl : (String) invokeV.objValue;
    }

    public int getUpdateType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.updateType : invokeV.intValue;
    }

    public long get_kz() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.kz : invokeV.longValue;
    }

    public boolean isFromPbOptimize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.isFromPbOptimize : invokeV.booleanValue;
    }

    public void setAfterAdThreadCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.mAfterAdThreadCount = i;
        }
    }

    public void setCacheKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.cacheKey = str;
        }
    }

    public void setFloorSortType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.mFloorSortType = i;
        }
    }

    public void setFloor_rn(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.floor_rn = i;
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.forumId = Long.valueOf(mg.g(str, 0L));
        }
    }

    public void setFromPbOptimize(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.isFromPbOptimize = z;
        }
    }

    public void setFromSmartFrs(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.fromSmartFrs = Integer.valueOf(i);
        }
    }

    public void setFrom_push(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.from_push = i;
        }
    }

    public void setImmersionVideoCommentSource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.immersionVideoCommentSource = i;
        }
    }

    public void setIsFromMark(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bool) == null) {
            this.isFromMark = bool.booleanValue();
        }
    }

    public void setIsJumpFloor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.isJumpFloor = z;
        }
    }

    public void setIsReqAd(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.isReqAd = Integer.valueOf(i);
        }
    }

    public void setIsSubPostDataReverse(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.isSubPostDataReverse = z;
        }
    }

    public void setJumpFloorNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.jumpFloorNum = i;
        }
    }

    public void setLastids(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.lastids = str;
        }
    }

    public void setLoadCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.loadCount = i;
        }
    }

    public void setLocate(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.mLocate = str;
        }
    }

    public void setNeedRepostRecommendForum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.needRepostRecommendForum = Integer.valueOf(z ? 1 : 0);
        }
    }

    public void setObjLocate(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.mObjLocate = str;
        }
    }

    public void setObjParam1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.objParam1 = str;
        }
    }

    public void setOfficialBarMsgId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048605, this, j) == null) {
            this.officialBarMsgId = j;
        }
    }

    public void setOpMessageID(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048606, this, j) == null) {
            this.opMessageID = j;
        }
    }

    public void setOpStat(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.opStat = i;
        }
    }

    public void setOpType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            this.opType = str;
        }
    }

    public void setOpUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.opUrl = str;
        }
    }

    public void setOriUgcNid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.oriUgcNid = str;
        }
    }

    public void setOriUgcTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.oriUgcTid = str;
        }
    }

    public void setOriUgcType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            this.oriUgcType = i;
        }
    }

    public void setOriUgcVid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.oriUgcVid = str;
        }
    }

    public void setRefreshCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            this.refreshCount = i;
        }
    }

    public void setReqFoldComment(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.isReqFoldComment = z;
        }
    }

    public void setSchemeUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            this.mSchemeUrl = str;
        }
    }

    public void setSourceType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            this.sourceType = i;
        }
    }

    public void setUpdateType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            this.updateType = i;
        }
    }

    public void set_arround(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, num) == null) {
            this.arround = num;
        }
    }

    public void set_back(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, num) == null) {
            this.back = num;
        }
    }

    public void set_banner(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, num) == null) {
            this.banner = num;
        }
    }

    public void set_kz(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048622, this, j) == null) {
            this.kz = j;
        }
    }

    public void set_last(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, num) == null) {
            this.last = num;
        }
    }

    public void set_lz(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, num) == null) {
            this.lz = num;
        }
    }

    public void set_mark(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, num) == null) {
            this.mark = num;
        }
    }

    public void set_message_click(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            this.message_click = str;
        }
    }

    public void set_message_id(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, num) == null) {
            this.message_id = num;
        }
    }

    public void set_pid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048628, this, j) == null) {
            this.pid = j;
        }
    }

    public void set_pn(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, num) == null) {
            this.pn = num;
        }
    }

    public void set_q_type(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, num) == null) {
            this.q_type = num;
        }
    }

    public void set_r(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, num) == null) {
            this.r = num;
        }
    }

    public void set_rn(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, num) == null) {
            this.rn = num;
        }
    }

    public void set_scr_dip(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048633, this, new Object[]{Double.valueOf(d)}) == null) {
            this.scr_dip = d;
        }
    }

    public void set_scr_h(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, num) == null) {
            this.scr_h = num;
        }
    }

    public void set_scr_w(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, num) == null) {
            this.scr_w = num;
        }
    }

    public void set_st_type(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, str) == null) {
            this.st_type = str;
        }
    }

    public void set_thread_type(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, num) == null) {
            this.thread_type = num;
        }
    }

    public void set_with_floor(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, num) == null) {
            this.with_floor = num;
        }
    }
}
