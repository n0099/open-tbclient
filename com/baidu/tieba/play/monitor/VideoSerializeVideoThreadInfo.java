package com.baidu.tieba.play.monitor;

import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.dh;
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
/* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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

        /* loaded from: classes5.dex */
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                int e = dh.e((String) ((Map) map2.get("god_data")).get("type"), 0);
                this.author.isBigV = e == 2 || e == 1;
                this.author.isGod = e == 2;
            }
            if (map2.get("baijiahao_info") instanceof Map) {
                Map map3 = (Map) map2.get("baijiahao_info");
                this.author.baijiahaoData = new VideoAggregationAuthorData.BaijiahaoAuthorData();
                this.author.baijiahaoData.name = (String) map3.get("name");
                this.author.baijiahaoData.avatar = (String) map3.get("avatar");
                this.author.baijiahaoData.auth_id = Integer.valueOf(dh.e((String) map3.get("auth_id"), 0));
                this.author.baijiahaoData.auth_desc = (String) map3.get("auth_desc");
                this.author.baijiahaoData.brief = (String) map3.get(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF);
            }
        }
        if (map.get(Constants.PAGE_BAIJIAHAO_NAME) instanceof Map) {
            Map map4 = (Map) map.get(Constants.PAGE_BAIJIAHAO_NAME);
            BaijiahaoData baijiahaoData = new BaijiahaoData();
            baijiahaoData.oriUgcNid = (String) map4.get("ori_ugc_nid");
            baijiahaoData.oriUgcTid = (String) map4.get("ori_ugc_tid");
            baijiahaoData.oriUgcType = dh.e((String) map4.get(TiebaStatic.Params.UGC_TYPE), 0);
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
            videoAggregationVideoData.videoDuration = dh.e((String) map5.get(AdWebVideoActivityConfig.KEY_VIDEO_DURATION), 0);
            videoAggregationVideoData.videoWidth = String.valueOf(map5.get("video_width"));
            videoAggregationVideoData.videoHeight = String.valueOf(map5.get("video_height"));
            videoAggregationVideoData.videoSize = dh.e((String) map5.get("video_length"), 0);
            videoAggregationVideoData.thumbnailUrl = (String) map5.get("thumbnail_url");
            this.playCount = dh.e((String) map5.get("play_count"), 0);
        }
        this.video = videoAggregationVideoData;
        this.forumId = String.valueOf(map.get("fid"));
        this.threadId = (String) map.get("tid");
        this.firstPostId = (String) map.get("first_post_id");
        this.createTime = (String) map.get("create_time");
        this.postNum = dh.g((String) map.get("reply_num"), 0L);
        this.shareNum = dh.g((String) map.get("share_num"), 0L);
        this.title = (String) map.get("title");
        if (map.get("agree") instanceof Map) {
            Map map6 = (Map) map.get("agree");
            this.agreeNum = dh.g((String) map6.get("agree_num"), 0L);
            this.disAgreeNum = dh.g((String) map6.get("disagree_num"), 0L);
            this.agreeType = dh.e((String) map6.get("agree_type"), 0);
            this.hasAgree = "1".equals(map6.get("has_agree"));
            AgreeData agreeData = new AgreeData();
            this.mAgreeData = agreeData;
            agreeData.threadId = this.threadId;
            agreeData.agreeNum = this.agreeNum;
            agreeData.diffAgreeNum = dh.g((String) map6.get("diff_agree_num"), 0L);
            AgreeData agreeData2 = this.mAgreeData;
            agreeData2.disAgreeNum = this.disAgreeNum;
            agreeData2.agreeType = this.agreeType;
            agreeData2.hasAgree = this.hasAgree;
        }
    }

    public void copyFromThreadInfo(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) || threadData == null) {
            return;
        }
        VideoAggregationAuthorData videoAggregationAuthorData = new VideoAggregationAuthorData();
        if (threadData.getAuthor() != null) {
            videoAggregationAuthorData.userId = threadData.getAuthor().getUserId();
            videoAggregationAuthorData.userName = threadData.getAuthor().getUserName();
            videoAggregationAuthorData.userNickname = threadData.getAuthor().getName_show();
            videoAggregationAuthorData.isBigV = threadData.getAuthor().isBigV();
            videoAggregationAuthorData.isGod = threadData.getAuthor().isGod();
            videoAggregationAuthorData.portrait = threadData.getAuthor().getPortrait();
            videoAggregationAuthorData.hasFocus = threadData.getAuthor().getIsLike();
            if (threadData.getAuthor().getBaijiahaoInfo() != null) {
                VideoAggregationAuthorData.BaijiahaoAuthorData baijiahaoAuthorData = new VideoAggregationAuthorData.BaijiahaoAuthorData();
                videoAggregationAuthorData.baijiahaoData = baijiahaoAuthorData;
                baijiahaoAuthorData.name = threadData.getAuthor().getBaijiahaoInfo().name;
                videoAggregationAuthorData.baijiahaoData.avatar = threadData.getAuthor().getBaijiahaoInfo().avatar;
                videoAggregationAuthorData.baijiahaoData.avatar_h = threadData.getAuthor().getBaijiahaoInfo().avatar_h;
                videoAggregationAuthorData.baijiahaoData.auth_id = threadData.getAuthor().getBaijiahaoInfo().auth_id;
                videoAggregationAuthorData.baijiahaoData.auth_desc = threadData.getAuthor().getBaijiahaoInfo().auth_desc;
                videoAggregationAuthorData.baijiahaoData.brief = threadData.getAuthor().getBaijiahaoInfo().brief;
            }
        }
        this.author = videoAggregationAuthorData;
        if (threadData.getBaijiahaoData() != null) {
            BaijiahaoData baijiahaoData = new BaijiahaoData();
            baijiahaoData.oriUgcNid = threadData.getBaijiahaoData().oriUgcNid;
            baijiahaoData.oriUgcTid = threadData.getBaijiahaoData().oriUgcTid;
            baijiahaoData.oriUgcType = threadData.getBaijiahaoData().oriUgcType;
            baijiahaoData.oriUgcVid = threadData.getBaijiahaoData().oriUgcVid;
            baijiahaoData.forwardUrl = threadData.getBaijiahaoData().forwardUrl;
            this.mBaijiahaoData = baijiahaoData;
        }
        VideoAggregationVideoData videoAggregationVideoData = new VideoAggregationVideoData();
        if (threadData.getThreadVideoInfo() != null) {
            videoAggregationVideoData.thumbnailWidth = String.valueOf(threadData.getThreadVideoInfo().thumbnail_width);
            videoAggregationVideoData.thumbnailHeight = String.valueOf(threadData.getThreadVideoInfo().thumbnail_height);
            videoAggregationVideoData.videoMd5 = threadData.getThreadVideoInfo().video_md5;
            videoAggregationVideoData.videoUrl = threadData.getThreadVideoInfo().video_url;
            videoAggregationVideoData.videoDuration = threadData.getThreadVideoInfo().video_duration.intValue();
            videoAggregationVideoData.videoWidth = String.valueOf(threadData.getThreadVideoInfo().video_width);
            videoAggregationVideoData.videoHeight = String.valueOf(threadData.getThreadVideoInfo().video_height);
            videoAggregationVideoData.videoSize = threadData.getThreadVideoInfo().video_length.intValue();
            videoAggregationVideoData.thumbnailUrl = threadData.getThreadVideoInfo().thumbnail_url;
            videoAggregationVideoData.originVideoUrl = threadData.getThreadVideoInfo().video_url;
            videoAggregationVideoData.mcnLeadPage = threadData.getThreadVideoInfo().mcn_lead_page;
            this.playCount = threadData.getThreadVideoInfo().play_count.intValue();
        }
        this.video = videoAggregationVideoData;
        this.forumId = String.valueOf(threadData.getFid());
        this.threadId = threadData.getId();
        OriginalForumInfo originalForumInfo = threadData.mOriginalForumInfo;
        if (originalForumInfo != null) {
            this.forumId = originalForumInfo.id;
        }
        this.firstPostId = threadData.getFirst_post_id();
        this.createTime = String.valueOf(threadData.getCreateTime());
        this.postNum = threadData.getReply_num();
        this.agreeNum = threadData.getAgreeNum();
        this.disAgreeNum = threadData.getDisAgreeNum();
        this.agreeType = threadData.getAgreeType();
        this.shareNum = threadData.getShareNum();
        this.hasAgree = threadData.getHasAgree() == 1;
        this.source = threadData.getRecomSource();
        this.title = threadData.getTitle();
        if (threadData.getAgreeData() != null) {
            AgreeData agreeData = new AgreeData();
            this.mAgreeData = agreeData;
            agreeData.threadId = threadData.getAgreeData().threadId;
            this.mAgreeData.agreeNum = threadData.getAgreeData().agreeNum;
            this.mAgreeData.diffAgreeNum = threadData.getAgreeData().diffAgreeNum;
            this.mAgreeData.disAgreeNum = threadData.getAgreeData().disAgreeNum;
            this.mAgreeData.agreeType = threadData.getAgreeData().agreeType;
            this.mAgreeData.hasAgree = threadData.getAgreeData().hasAgree;
        }
        this.mWorksInfoData = threadData.worksInfoData;
    }

    public void copyFromTransmitThreadData(ThreadData threadData) {
        Agree agree;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) || threadData == null) {
            return;
        }
        OriginalThreadInfo originalThreadInfo = threadData.originalThreadData;
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
        OriginalForumInfo originalForumInfo = threadData.mOriginalForumInfo;
        if (originalForumInfo != null) {
            this.forumId = originalForumInfo.id;
        }
        if (originalThreadInfo != null) {
            this.threadId = originalThreadInfo.f;
            this.title = originalThreadInfo.b;
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
