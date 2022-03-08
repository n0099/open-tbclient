package com.baidu.tieba.play.monitor;

import androidx.core.app.NotificationCompat;
import c.a.d.f.m.b;
import c.a.q0.r.r.e2;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.Map;
import tbclient.Agree;
import tbclient.BaijiahaoInfo;
import tbclient.User;
import tbclient.VideoInfo;
/* loaded from: classes6.dex */
public class VideoSerializeVideoThreadInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -7659795764367587672L;
    public transient /* synthetic */ FieldHolder $fh;
    public String ab_tag;
    public long agreeNum;
    public int agreeType;
    public VideoAggregationAuthorData author;
    public boolean autoPlay;
    public String createTime;
    public long diffAgreeNum;
    public long disAgreeNum;
    public String extra;
    public String firstPostId;
    public String forumId;
    public boolean hasAgree;
    public AgreeData mAgreeData;
    public BaijiahaoData mBaijiahaoData;
    public VideoCardViewInfo mVideoCardViewInfo;
    public WorksInfoData mWorksInfoData;
    public long playCount;
    public long postNum;
    public long shareNum;
    public String source;
    public String threadId;
    public String title;
    public VideoAggregationVideoData video;
    public boolean waitConfirm;
    public String weight;

    /* loaded from: classes6.dex */
    public static class VideoAggregationAuthorData implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 937744153926100702L;
        public transient /* synthetic */ FieldHolder $fh;
        public BaijiahaoAuthorData baijiahaoData;
        public boolean hasFocus;
        public boolean isBigV;
        public boolean isGod;
        public String portrait;
        public String userId;
        public String userName;
        public String userNickname;

        /* loaded from: classes6.dex */
        public static class BaijiahaoAuthorData implements Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 7277512143348542714L;
            public transient /* synthetic */ FieldHolder $fh;
            public String auth_desc;
            public Integer auth_id;
            public String avatar;
            public String avatar_h;
            public String brief;
            public String name;

            public BaijiahaoAuthorData() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public VideoAggregationAuthorData() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class VideoAggregationVideoData implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 7265311334325180130L;
        public transient /* synthetic */ FieldHolder $fh;
        public String mcnLeadPage;
        public String originVideoUrl;
        public String thumbnailHeight;
        public String thumbnailPicid;
        public String thumbnailUrl;
        public String thumbnailWidth;
        public int videoDuration;
        public String videoFormat;
        public String videoHeight;
        public String videoMd5;
        public long videoSize;
        public String videoType;
        public String videoUrl;
        public String videoWidth;

        public VideoAggregationVideoData() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class VideoCardViewInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 5722373220077065607L;
        public transient /* synthetic */ FieldHolder $fh;
        public int cardViewHeight;
        public int cardViewWidth;
        public int cardViewX;
        public int cardViewY;

        public VideoCardViewInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public VideoSerializeVideoThreadInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.waitConfirm = false;
    }

    public void copyFromFlutterDataMap(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, map) == null) || map == null || map.isEmpty()) {
            return;
        }
        if (map.get(NotificationCompat.CarExtender.KEY_AUTHOR) instanceof Map) {
            Map map2 = (Map) map.get(NotificationCompat.CarExtender.KEY_AUTHOR);
            VideoAggregationAuthorData videoAggregationAuthorData = new VideoAggregationAuthorData();
            this.author = videoAggregationAuthorData;
            videoAggregationAuthorData.userId = (String) map2.get("id");
            this.author.userName = (String) map2.get("name");
            this.author.userNickname = (String) map2.get("name_show");
            this.author.portrait = (String) map2.get("portrait");
            this.author.hasFocus = "1".equals(map2.get("has_concerned"));
            if (map2.get("god_data") instanceof Map) {
                int e2 = b.e((String) ((Map) map2.get("god_data")).get("type"), 0);
                this.author.isBigV = e2 == 2 || e2 == 1;
                this.author.isGod = e2 == 2;
            }
            if (map2.get("baijiahao_info") instanceof Map) {
                Map map3 = (Map) map2.get("baijiahao_info");
                this.author.baijiahaoData = new VideoAggregationAuthorData.BaijiahaoAuthorData();
                this.author.baijiahaoData.name = (String) map3.get("name");
                this.author.baijiahaoData.avatar = (String) map3.get("avatar");
                this.author.baijiahaoData.auth_id = Integer.valueOf(b.e((String) map3.get("auth_id"), 0));
                this.author.baijiahaoData.auth_desc = (String) map3.get("auth_desc");
                this.author.baijiahaoData.brief = (String) map3.get(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF);
            }
        }
        if (map.get(Constants.PAGE_BAIJIAHAO_NAME) instanceof Map) {
            Map map4 = (Map) map.get(Constants.PAGE_BAIJIAHAO_NAME);
            BaijiahaoData baijiahaoData = new BaijiahaoData();
            baijiahaoData.oriUgcNid = (String) map4.get("ori_ugc_nid");
            baijiahaoData.oriUgcTid = (String) map4.get("ori_ugc_tid");
            baijiahaoData.oriUgcType = b.e((String) map4.get(TiebaStatic.Params.UGC_TYPE), 0);
            baijiahaoData.oriUgcVid = (String) map4.get("ori_ugc_vid");
            baijiahaoData.forwardUrl = (String) map4.get("forward_url");
            this.mBaijiahaoData = baijiahaoData;
        }
        VideoAggregationVideoData videoAggregationVideoData = new VideoAggregationVideoData();
        if (map.get(WriteActivityConfig.VIDEO_INFO) instanceof Map) {
            Map map5 = (Map) map.get(WriteActivityConfig.VIDEO_INFO);
            videoAggregationVideoData.thumbnailWidth = String.valueOf(map5.get("thumbnail_width"));
            videoAggregationVideoData.thumbnailHeight = String.valueOf(map5.get("thumbnail_height"));
            videoAggregationVideoData.videoMd5 = (String) map5.get(VideoFinishResult.KEY_VIDEO_MD5);
            videoAggregationVideoData.videoUrl = (String) map5.get("video_url");
            videoAggregationVideoData.videoDuration = b.e((String) map5.get(AdWebVideoActivityConfig.KEY_VIDEO_DURATION), 0);
            videoAggregationVideoData.videoWidth = String.valueOf(map5.get("video_width"));
            videoAggregationVideoData.videoHeight = String.valueOf(map5.get("video_height"));
            videoAggregationVideoData.videoSize = b.e((String) map5.get("video_length"), 0);
            videoAggregationVideoData.thumbnailUrl = (String) map5.get("thumbnail_url");
            this.playCount = b.e((String) map5.get("play_count"), 0);
        }
        this.video = videoAggregationVideoData;
        this.forumId = String.valueOf(map.get("fid"));
        this.threadId = (String) map.get("tid");
        this.firstPostId = (String) map.get("first_post_id");
        this.createTime = (String) map.get("create_time");
        this.postNum = b.g((String) map.get("reply_num"), 0L);
        this.shareNum = b.g((String) map.get("share_num"), 0L);
        this.title = (String) map.get("title");
        if (map.get("agree") instanceof Map) {
            Map map6 = (Map) map.get("agree");
            this.agreeNum = b.g((String) map6.get("agree_num"), 0L);
            this.disAgreeNum = b.g((String) map6.get("disagree_num"), 0L);
            this.agreeType = b.e((String) map6.get("agree_type"), 0);
            this.hasAgree = "1".equals(map6.get("has_agree"));
            AgreeData agreeData = new AgreeData();
            this.mAgreeData = agreeData;
            agreeData.threadId = this.threadId;
            agreeData.agreeNum = this.agreeNum;
            agreeData.diffAgreeNum = b.g((String) map6.get("diff_agree_num"), 0L);
            AgreeData agreeData2 = this.mAgreeData;
            agreeData2.disAgreeNum = this.disAgreeNum;
            agreeData2.agreeType = this.agreeType;
            agreeData2.hasAgree = this.hasAgree;
        }
    }

    public void copyFromThreadInfo(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2Var) == null) || e2Var == null) {
            return;
        }
        VideoAggregationAuthorData videoAggregationAuthorData = new VideoAggregationAuthorData();
        if (e2Var.J() != null) {
            videoAggregationAuthorData.userId = e2Var.J().getUserId();
            videoAggregationAuthorData.userName = e2Var.J().getUserName();
            videoAggregationAuthorData.userNickname = e2Var.J().getName_show();
            videoAggregationAuthorData.isBigV = e2Var.J().isBigV();
            videoAggregationAuthorData.isGod = e2Var.J().isGod();
            videoAggregationAuthorData.portrait = e2Var.J().getPortrait();
            videoAggregationAuthorData.hasFocus = e2Var.J().getIsLike();
            if (e2Var.J().getBaijiahaoInfo() != null) {
                VideoAggregationAuthorData.BaijiahaoAuthorData baijiahaoAuthorData = new VideoAggregationAuthorData.BaijiahaoAuthorData();
                videoAggregationAuthorData.baijiahaoData = baijiahaoAuthorData;
                baijiahaoAuthorData.name = e2Var.J().getBaijiahaoInfo().name;
                videoAggregationAuthorData.baijiahaoData.avatar = e2Var.J().getBaijiahaoInfo().avatar;
                videoAggregationAuthorData.baijiahaoData.avatar_h = e2Var.J().getBaijiahaoInfo().avatar_h;
                videoAggregationAuthorData.baijiahaoData.auth_id = e2Var.J().getBaijiahaoInfo().auth_id;
                videoAggregationAuthorData.baijiahaoData.auth_desc = e2Var.J().getBaijiahaoInfo().auth_desc;
                videoAggregationAuthorData.baijiahaoData.brief = e2Var.J().getBaijiahaoInfo().brief;
            }
        }
        this.author = videoAggregationAuthorData;
        if (e2Var.L() != null) {
            BaijiahaoData baijiahaoData = new BaijiahaoData();
            baijiahaoData.oriUgcNid = e2Var.L().oriUgcNid;
            baijiahaoData.oriUgcTid = e2Var.L().oriUgcTid;
            baijiahaoData.oriUgcType = e2Var.L().oriUgcType;
            baijiahaoData.oriUgcVid = e2Var.L().oriUgcVid;
            baijiahaoData.forwardUrl = e2Var.L().forwardUrl;
            this.mBaijiahaoData = baijiahaoData;
        }
        VideoAggregationVideoData videoAggregationVideoData = new VideoAggregationVideoData();
        if (e2Var.u1() != null) {
            videoAggregationVideoData.thumbnailWidth = String.valueOf(e2Var.u1().thumbnail_width);
            videoAggregationVideoData.thumbnailHeight = String.valueOf(e2Var.u1().thumbnail_height);
            videoAggregationVideoData.videoMd5 = e2Var.u1().video_md5;
            videoAggregationVideoData.videoUrl = e2Var.u1().video_url;
            videoAggregationVideoData.videoDuration = e2Var.u1().video_duration.intValue();
            videoAggregationVideoData.videoWidth = String.valueOf(e2Var.u1().video_width);
            videoAggregationVideoData.videoHeight = String.valueOf(e2Var.u1().video_height);
            videoAggregationVideoData.videoSize = e2Var.u1().video_length.intValue();
            videoAggregationVideoData.thumbnailUrl = e2Var.u1().thumbnail_url;
            videoAggregationVideoData.originVideoUrl = e2Var.u1().video_url;
            videoAggregationVideoData.mcnLeadPage = e2Var.u1().mcn_lead_page;
            this.playCount = e2Var.u1().play_count.intValue();
        }
        this.video = videoAggregationVideoData;
        this.forumId = String.valueOf(e2Var.U());
        this.threadId = e2Var.h0();
        OriginalForumInfo originalForumInfo = e2Var.J1;
        if (originalForumInfo != null) {
            this.forumId = originalForumInfo.id;
        }
        this.firstPostId = e2Var.Y();
        this.createTime = String.valueOf(e2Var.P());
        this.postNum = e2Var.W0();
        this.agreeNum = e2Var.C();
        this.disAgreeNum = e2Var.Q();
        this.agreeType = e2Var.D();
        this.shareNum = e2Var.e1();
        this.hasAgree = e2Var.f0() == 1;
        this.source = e2Var.T0();
        this.title = e2Var.getTitle();
        if (e2Var.B() != null) {
            AgreeData agreeData = new AgreeData();
            this.mAgreeData = agreeData;
            agreeData.threadId = e2Var.B().threadId;
            this.mAgreeData.agreeNum = e2Var.B().agreeNum;
            this.mAgreeData.diffAgreeNum = e2Var.B().diffAgreeNum;
            this.mAgreeData.disAgreeNum = e2Var.B().disAgreeNum;
            this.mAgreeData.agreeType = e2Var.B().agreeType;
            this.mAgreeData.hasAgree = e2Var.B().hasAgree;
        }
        this.mWorksInfoData = e2Var.O2;
    }

    public void copyFromTransmitThreadData(e2 e2Var) {
        Agree agree;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e2Var) == null) || e2Var == null) {
            return;
        }
        OriginalThreadInfo originalThreadInfo = e2Var.z1;
        VideoAggregationAuthorData videoAggregationAuthorData = new VideoAggregationAuthorData();
        User user = originalThreadInfo.y;
        if (user != null) {
            videoAggregationAuthorData.userId = String.valueOf(user.id);
            User user2 = originalThreadInfo.y;
            videoAggregationAuthorData.userName = user2.name;
            videoAggregationAuthorData.userNickname = user2.name_show;
            videoAggregationAuthorData.isBigV = user2.tb_vip != null;
            videoAggregationAuthorData.isGod = originalThreadInfo.y.god_data != null;
            User user3 = originalThreadInfo.y;
            videoAggregationAuthorData.portrait = user3.portrait;
            videoAggregationAuthorData.hasFocus = user3.has_concerned.intValue() != 0;
            if (originalThreadInfo.y.baijiahao_info != null) {
                VideoAggregationAuthorData.BaijiahaoAuthorData baijiahaoAuthorData = new VideoAggregationAuthorData.BaijiahaoAuthorData();
                videoAggregationAuthorData.baijiahaoData = baijiahaoAuthorData;
                BaijiahaoInfo baijiahaoInfo = originalThreadInfo.y.baijiahao_info;
                baijiahaoAuthorData.name = baijiahaoInfo.name;
                baijiahaoAuthorData.avatar = baijiahaoInfo.avatar;
                baijiahaoAuthorData.avatar_h = baijiahaoInfo.avatar_h;
                baijiahaoAuthorData.auth_id = baijiahaoInfo.auth_id;
                baijiahaoAuthorData.auth_desc = baijiahaoInfo.auth_desc;
                baijiahaoAuthorData.brief = baijiahaoInfo.brief;
            }
        }
        this.author = videoAggregationAuthorData;
        if (originalThreadInfo.p != null) {
            BaijiahaoData baijiahaoData = new BaijiahaoData();
            BaijiahaoData baijiahaoData2 = originalThreadInfo.p;
            baijiahaoData.oriUgcNid = baijiahaoData2.oriUgcNid;
            baijiahaoData.oriUgcTid = baijiahaoData2.oriUgcTid;
            baijiahaoData.oriUgcType = baijiahaoData2.oriUgcType;
            baijiahaoData.oriUgcVid = baijiahaoData2.oriUgcVid;
            baijiahaoData.forwardUrl = baijiahaoData2.forwardUrl;
            this.mBaijiahaoData = baijiahaoData;
        }
        VideoAggregationVideoData videoAggregationVideoData = new VideoAggregationVideoData();
        if (originalThreadInfo != null) {
            videoAggregationVideoData.thumbnailWidth = String.valueOf(originalThreadInfo.r.thumbnail_width);
            videoAggregationVideoData.thumbnailHeight = String.valueOf(originalThreadInfo.r.thumbnail_height);
            VideoInfo videoInfo = originalThreadInfo.r;
            videoAggregationVideoData.videoMd5 = videoInfo.video_md5;
            videoAggregationVideoData.videoUrl = videoInfo.video_url;
            videoAggregationVideoData.videoDuration = videoInfo.video_duration.intValue();
            videoAggregationVideoData.videoWidth = String.valueOf(originalThreadInfo.r.video_width);
            videoAggregationVideoData.videoHeight = String.valueOf(originalThreadInfo.r.video_height);
            videoAggregationVideoData.videoSize = originalThreadInfo.r.video_length.intValue();
            VideoInfo videoInfo2 = originalThreadInfo.r;
            videoAggregationVideoData.thumbnailUrl = videoInfo2.thumbnail_url;
            videoAggregationVideoData.originVideoUrl = videoInfo2.video_url;
            videoAggregationVideoData.mcnLeadPage = videoInfo2.mcn_lead_page;
            this.playCount = videoInfo2.play_count.intValue();
        }
        this.video = videoAggregationVideoData;
        OriginalForumInfo originalForumInfo = e2Var.J1;
        if (originalForumInfo != null) {
            this.forumId = originalForumInfo.id;
        }
        if (originalThreadInfo != null) {
            this.threadId = originalThreadInfo.f38793f;
            this.title = originalThreadInfo.f38789b;
            this.postNum = originalThreadInfo.A.intValue();
        }
        if (originalThreadInfo != null && (agree = originalThreadInfo.z) != null) {
            this.agreeNum = agree.agree_num.longValue();
            this.disAgreeNum = originalThreadInfo.z.disagree_num.longValue();
            this.agreeType = originalThreadInfo.z.agree_type.intValue();
            this.shareNum = originalThreadInfo.B.intValue();
            this.hasAgree = originalThreadInfo.z.has_agree.intValue() == 1;
        }
        if (originalThreadInfo == null || originalThreadInfo.z == null) {
            return;
        }
        AgreeData agreeData = new AgreeData();
        this.mAgreeData = agreeData;
        agreeData.threadId = this.threadId;
        agreeData.agreeNum = originalThreadInfo.z.agree_num.longValue();
        this.mAgreeData.diffAgreeNum = originalThreadInfo.z.diff_agree_num.longValue();
        this.mAgreeData.disAgreeNum = originalThreadInfo.z.disagree_num.longValue();
        this.mAgreeData.agreeType = originalThreadInfo.z.agree_type.intValue();
        this.mAgreeData.hasAgree = originalThreadInfo.z.has_agree.intValue() == 1;
    }

    public VideoAggregationAuthorData getAuthor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.author : (VideoAggregationAuthorData) invokeV.objValue;
    }

    public BaijiahaoData getBaijiahaoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mBaijiahaoData : (BaijiahaoData) invokeV.objValue;
    }

    public VideoAggregationVideoData getThreadVideoInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.video : (VideoAggregationVideoData) invokeV.objValue;
    }
}
