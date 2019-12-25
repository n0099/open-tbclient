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
            if (bjVar.azE() != null) {
                videoAggregationAuthorData.userId = bjVar.azE().getUserId();
                videoAggregationAuthorData.userName = bjVar.azE().getUserName();
                videoAggregationAuthorData.userNickname = bjVar.azE().getName_show();
                videoAggregationAuthorData.isBigV = bjVar.azE().isBigV();
                videoAggregationAuthorData.isGod = bjVar.azE().isGod();
                videoAggregationAuthorData.portrait = bjVar.azE().getPortrait();
                videoAggregationAuthorData.hasFocus = bjVar.azE().getIsLike();
                if (bjVar.azE().getBaijiahaoInfo() != null) {
                    videoAggregationAuthorData.baijiahaoData = new VideoAggregationAuthorData.BaijiahaoAuthorData();
                    videoAggregationAuthorData.baijiahaoData.name = bjVar.azE().getBaijiahaoInfo().name;
                    videoAggregationAuthorData.baijiahaoData.avatar = bjVar.azE().getBaijiahaoInfo().avatar;
                    videoAggregationAuthorData.baijiahaoData.avatar_h = bjVar.azE().getBaijiahaoInfo().avatar_h;
                    videoAggregationAuthorData.baijiahaoData.auth_id = bjVar.azE().getBaijiahaoInfo().auth_id;
                    videoAggregationAuthorData.baijiahaoData.auth_desc = bjVar.azE().getBaijiahaoInfo().auth_desc;
                    videoAggregationAuthorData.baijiahaoData.brief = bjVar.azE().getBaijiahaoInfo().brief;
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
            if (bjVar.azV() != null) {
                videoAggregationVideoData.thumbnailWidth = String.valueOf(bjVar.azV().thumbnail_width);
                videoAggregationVideoData.thumbnailHeight = String.valueOf(bjVar.azV().thumbnail_height);
                videoAggregationVideoData.videoMd5 = bjVar.azV().video_md5;
                videoAggregationVideoData.videoUrl = bjVar.azV().video_url;
                videoAggregationVideoData.videoDuration = bjVar.azV().video_duration.intValue();
                videoAggregationVideoData.videoWidth = String.valueOf(bjVar.azV().video_width);
                videoAggregationVideoData.videoHeight = String.valueOf(bjVar.azV().video_height);
                videoAggregationVideoData.videoSize = bjVar.azV().video_length.intValue();
                videoAggregationVideoData.thumbnailUrl = bjVar.azV().thumbnail_url;
                videoAggregationVideoData.originVideoUrl = bjVar.azV().video_url;
                videoAggregationVideoData.mcnLeadPage = bjVar.azV().mcn_lead_page;
                this.playCount = bjVar.azV().play_count.intValue();
            }
            this.video = videoAggregationVideoData;
            this.forumId = String.valueOf(bjVar.getFid());
            this.threadId = bjVar.getId();
            if (bjVar.cPN != null) {
                this.forumId = bjVar.cPN.id;
            }
            this.firstPostId = bjVar.azo();
            this.createTime = String.valueOf(bjVar.getCreateTime());
            this.postNum = bjVar.azv();
            this.agreeNum = bjVar.aAZ();
            this.disAgreeNum = bjVar.aBa();
            this.agreeType = bjVar.aBc();
            this.shareNum = bjVar.aBd();
            this.hasAgree = bjVar.aBb() == 1;
            this.source = bjVar.aAX();
            this.title = bjVar.getTitle();
            if (bjVar.aBt() != null) {
                this.mAgreeData = new AgreeData();
                this.mAgreeData.threadId = bjVar.aBt().threadId;
                this.mAgreeData.agreeNum = bjVar.aBt().agreeNum;
                this.mAgreeData.diffAgreeNum = bjVar.aBt().diffAgreeNum;
                this.mAgreeData.disAgreeNum = bjVar.aBt().disAgreeNum;
                this.mAgreeData.agreeType = bjVar.aBt().agreeType;
                this.mAgreeData.hasAgree = bjVar.aBt().hasAgree;
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
