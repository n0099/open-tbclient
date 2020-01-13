package com.baidu.tieba.play.monitor;

import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import java.io.Serializable;
/* loaded from: classes.dex */
public class VideoSerializeVideoThreadInfo implements Serializable {
    private static final long serialVersionUID = -7659795764367587672L;
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
    public long playCount;
    public long postNum;
    public long shareNum;
    public String source;
    public String threadId;
    public String title;
    public VideoAggregationVideoData video;
    public boolean waitConfirm = false;
    public String weight;

    /* loaded from: classes.dex */
    public static class VideoAggregationAuthorData implements Serializable {
        private static final long serialVersionUID = 937744153926100702L;
        public BaijiahaoAuthorData baijiahaoData;
        public boolean hasFocus;
        public boolean isBigV;
        public boolean isGod;
        public String portrait;
        public String userId;
        public String userName;
        public String userNickname;

        /* loaded from: classes.dex */
        public static class BaijiahaoAuthorData implements Serializable {
            private static final long serialVersionUID = 7277512143348542714L;
            public String auth_desc;
            public Integer auth_id;
            public String avatar;
            public String avatar_h;
            public String brief;
            public String name;
        }
    }

    /* loaded from: classes.dex */
    public static class VideoAggregationVideoData implements Serializable {
        private static final long serialVersionUID = 7265311334325180130L;
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
    }

    /* loaded from: classes.dex */
    public static class VideoCardViewInfo implements Serializable {
        private static final long serialVersionUID = 5722373220077065607L;
        public int cardViewHeight;
        public int cardViewWidth;
        public int cardViewX;
        public int cardViewY;
    }

    public void copyFromThreadInfo(bj bjVar) {
        if (bjVar != null) {
            VideoAggregationAuthorData videoAggregationAuthorData = new VideoAggregationAuthorData();
            if (bjVar.azX() != null) {
                videoAggregationAuthorData.userId = bjVar.azX().getUserId();
                videoAggregationAuthorData.userName = bjVar.azX().getUserName();
                videoAggregationAuthorData.userNickname = bjVar.azX().getName_show();
                videoAggregationAuthorData.isBigV = bjVar.azX().isBigV();
                videoAggregationAuthorData.isGod = bjVar.azX().isGod();
                videoAggregationAuthorData.portrait = bjVar.azX().getPortrait();
                videoAggregationAuthorData.hasFocus = bjVar.azX().getIsLike();
                if (bjVar.azX().getBaijiahaoInfo() != null) {
                    videoAggregationAuthorData.baijiahaoData = new VideoAggregationAuthorData.BaijiahaoAuthorData();
                    videoAggregationAuthorData.baijiahaoData.name = bjVar.azX().getBaijiahaoInfo().name;
                    videoAggregationAuthorData.baijiahaoData.avatar = bjVar.azX().getBaijiahaoInfo().avatar;
                    videoAggregationAuthorData.baijiahaoData.avatar_h = bjVar.azX().getBaijiahaoInfo().avatar_h;
                    videoAggregationAuthorData.baijiahaoData.auth_id = bjVar.azX().getBaijiahaoInfo().auth_id;
                    videoAggregationAuthorData.baijiahaoData.auth_desc = bjVar.azX().getBaijiahaoInfo().auth_desc;
                    videoAggregationAuthorData.baijiahaoData.brief = bjVar.azX().getBaijiahaoInfo().brief;
                }
            }
            this.author = videoAggregationAuthorData;
            if (bjVar.getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                baijiahaoData.oriUgcNid = bjVar.getBaijiahaoData().oriUgcNid;
                baijiahaoData.oriUgcTid = bjVar.getBaijiahaoData().oriUgcTid;
                baijiahaoData.oriUgcType = bjVar.getBaijiahaoData().oriUgcType;
                baijiahaoData.oriUgcVid = bjVar.getBaijiahaoData().oriUgcVid;
                this.mBaijiahaoData = baijiahaoData;
            }
            VideoAggregationVideoData videoAggregationVideoData = new VideoAggregationVideoData();
            if (bjVar.aAo() != null) {
                videoAggregationVideoData.thumbnailWidth = String.valueOf(bjVar.aAo().thumbnail_width);
                videoAggregationVideoData.thumbnailHeight = String.valueOf(bjVar.aAo().thumbnail_height);
                videoAggregationVideoData.videoMd5 = bjVar.aAo().video_md5;
                videoAggregationVideoData.videoUrl = bjVar.aAo().video_url;
                videoAggregationVideoData.videoDuration = bjVar.aAo().video_duration.intValue();
                videoAggregationVideoData.videoWidth = String.valueOf(bjVar.aAo().video_width);
                videoAggregationVideoData.videoHeight = String.valueOf(bjVar.aAo().video_height);
                videoAggregationVideoData.videoSize = bjVar.aAo().video_length.intValue();
                videoAggregationVideoData.thumbnailUrl = bjVar.aAo().thumbnail_url;
                videoAggregationVideoData.originVideoUrl = bjVar.aAo().video_url;
                videoAggregationVideoData.mcnLeadPage = bjVar.aAo().mcn_lead_page;
                this.playCount = bjVar.aAo().play_count.intValue();
            }
            this.video = videoAggregationVideoData;
            this.forumId = String.valueOf(bjVar.getFid());
            this.threadId = bjVar.getId();
            if (bjVar.cPX != null) {
                this.forumId = bjVar.cPX.id;
            }
            this.firstPostId = bjVar.azH();
            this.createTime = String.valueOf(bjVar.getCreateTime());
            this.postNum = bjVar.azO();
            this.agreeNum = bjVar.aBs();
            this.disAgreeNum = bjVar.aBt();
            this.agreeType = bjVar.aBv();
            this.shareNum = bjVar.aBw();
            this.hasAgree = bjVar.aBu() == 1;
            this.source = bjVar.aBq();
            this.title = bjVar.getTitle();
            if (bjVar.aBM() != null) {
                this.mAgreeData = new AgreeData();
                this.mAgreeData.threadId = bjVar.aBM().threadId;
                this.mAgreeData.agreeNum = bjVar.aBM().agreeNum;
                this.mAgreeData.diffAgreeNum = bjVar.aBM().diffAgreeNum;
                this.mAgreeData.disAgreeNum = bjVar.aBM().disAgreeNum;
                this.mAgreeData.agreeType = bjVar.aBM().agreeType;
                this.mAgreeData.hasAgree = bjVar.aBM().hasAgree;
            }
        }
    }

    public VideoAggregationAuthorData getAuthor() {
        return this.author;
    }

    public VideoAggregationVideoData getThreadVideoInfo() {
        return this.video;
    }

    public BaijiahaoData getBaijiahaoData() {
        return this.mBaijiahaoData;
    }
}
