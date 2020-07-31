package com.baidu.tieba.play.monitor;

import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bv;
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

    public void copyFromTransmitThreadData(bv bvVar) {
        if (bvVar != null) {
            OriginalThreadInfo originalThreadInfo = bvVar.dUi;
            VideoAggregationAuthorData videoAggregationAuthorData = new VideoAggregationAuthorData();
            if (originalThreadInfo.author != null) {
                videoAggregationAuthorData.userId = String.valueOf(originalThreadInfo.author.id);
                videoAggregationAuthorData.userName = originalThreadInfo.author.name;
                videoAggregationAuthorData.userNickname = originalThreadInfo.author.name_show;
                videoAggregationAuthorData.isBigV = originalThreadInfo.author.tb_vip != null;
                videoAggregationAuthorData.isGod = originalThreadInfo.author.god_data != null;
                videoAggregationAuthorData.portrait = originalThreadInfo.author.portrait;
                videoAggregationAuthorData.hasFocus = originalThreadInfo.author.has_concerned.intValue() != 0;
                if (originalThreadInfo.author.baijiahao_info != null) {
                    videoAggregationAuthorData.baijiahaoData = new VideoAggregationAuthorData.BaijiahaoAuthorData();
                    videoAggregationAuthorData.baijiahaoData.name = originalThreadInfo.author.baijiahao_info.name;
                    videoAggregationAuthorData.baijiahaoData.avatar = originalThreadInfo.author.baijiahao_info.avatar;
                    videoAggregationAuthorData.baijiahaoData.avatar_h = originalThreadInfo.author.baijiahao_info.avatar_h;
                    videoAggregationAuthorData.baijiahaoData.auth_id = originalThreadInfo.author.baijiahao_info.auth_id;
                    videoAggregationAuthorData.baijiahaoData.auth_desc = originalThreadInfo.author.baijiahao_info.auth_desc;
                    videoAggregationAuthorData.baijiahaoData.brief = originalThreadInfo.author.baijiahao_info.brief;
                }
            }
            this.author = videoAggregationAuthorData;
            if (originalThreadInfo.oriUgcInfo != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                baijiahaoData.oriUgcNid = originalThreadInfo.oriUgcInfo.oriUgcNid;
                baijiahaoData.oriUgcTid = originalThreadInfo.oriUgcInfo.oriUgcTid;
                baijiahaoData.oriUgcType = originalThreadInfo.oriUgcInfo.oriUgcType;
                baijiahaoData.oriUgcVid = originalThreadInfo.oriUgcInfo.oriUgcVid;
                baijiahaoData.forwardUrl = originalThreadInfo.oriUgcInfo.forwardUrl;
                this.mBaijiahaoData = baijiahaoData;
            }
            VideoAggregationVideoData videoAggregationVideoData = new VideoAggregationVideoData();
            if (originalThreadInfo != null) {
                videoAggregationVideoData.thumbnailWidth = String.valueOf(originalThreadInfo.videoInfo.thumbnail_width);
                videoAggregationVideoData.thumbnailHeight = String.valueOf(originalThreadInfo.videoInfo.thumbnail_height);
                videoAggregationVideoData.videoMd5 = originalThreadInfo.videoInfo.video_md5;
                videoAggregationVideoData.videoUrl = originalThreadInfo.videoInfo.video_url;
                videoAggregationVideoData.videoDuration = originalThreadInfo.videoInfo.video_duration.intValue();
                videoAggregationVideoData.videoWidth = String.valueOf(originalThreadInfo.videoInfo.video_width);
                videoAggregationVideoData.videoHeight = String.valueOf(originalThreadInfo.videoInfo.video_height);
                videoAggregationVideoData.videoSize = originalThreadInfo.videoInfo.video_length.intValue();
                videoAggregationVideoData.thumbnailUrl = originalThreadInfo.videoInfo.thumbnail_url;
                videoAggregationVideoData.originVideoUrl = originalThreadInfo.videoInfo.video_url;
                videoAggregationVideoData.mcnLeadPage = originalThreadInfo.videoInfo.mcn_lead_page;
                this.playCount = originalThreadInfo.videoInfo.play_count.intValue();
            }
            this.video = videoAggregationVideoData;
            if (bvVar.dUt != null) {
                this.forumId = bvVar.dUt.id;
            }
            if (originalThreadInfo != null) {
                this.threadId = originalThreadInfo.threadId;
                this.title = originalThreadInfo.showText;
                this.postNum = originalThreadInfo.reply_num.intValue();
            }
            if (originalThreadInfo != null && originalThreadInfo.agree != null) {
                this.agreeNum = originalThreadInfo.agree.agree_num.longValue();
                this.disAgreeNum = originalThreadInfo.agree.disagree_num.longValue();
                this.agreeType = originalThreadInfo.agree.agree_type.intValue();
                this.shareNum = originalThreadInfo.shared_num.intValue();
                this.hasAgree = originalThreadInfo.agree.has_agree.intValue() == 1;
            }
            if (originalThreadInfo != null && originalThreadInfo.agree != null) {
                this.mAgreeData = new AgreeData();
                this.mAgreeData.threadId = this.threadId;
                this.mAgreeData.agreeNum = originalThreadInfo.agree.agree_num.longValue();
                this.mAgreeData.diffAgreeNum = originalThreadInfo.agree.diff_agree_num.longValue();
                this.mAgreeData.disAgreeNum = originalThreadInfo.agree.disagree_num.longValue();
                this.mAgreeData.agreeType = originalThreadInfo.agree.agree_type.intValue();
                this.mAgreeData.hasAgree = originalThreadInfo.agree.has_agree.intValue() == 1;
            }
        }
    }

    public void copyFromThreadInfo(bv bvVar) {
        if (bvVar != null) {
            VideoAggregationAuthorData videoAggregationAuthorData = new VideoAggregationAuthorData();
            if (bvVar.aWl() != null) {
                videoAggregationAuthorData.userId = bvVar.aWl().getUserId();
                videoAggregationAuthorData.userName = bvVar.aWl().getUserName();
                videoAggregationAuthorData.userNickname = bvVar.aWl().getName_show();
                videoAggregationAuthorData.isBigV = bvVar.aWl().isBigV();
                videoAggregationAuthorData.isGod = bvVar.aWl().isGod();
                videoAggregationAuthorData.portrait = bvVar.aWl().getPortrait();
                videoAggregationAuthorData.hasFocus = bvVar.aWl().getIsLike();
                if (bvVar.aWl().getBaijiahaoInfo() != null) {
                    videoAggregationAuthorData.baijiahaoData = new VideoAggregationAuthorData.BaijiahaoAuthorData();
                    videoAggregationAuthorData.baijiahaoData.name = bvVar.aWl().getBaijiahaoInfo().name;
                    videoAggregationAuthorData.baijiahaoData.avatar = bvVar.aWl().getBaijiahaoInfo().avatar;
                    videoAggregationAuthorData.baijiahaoData.avatar_h = bvVar.aWl().getBaijiahaoInfo().avatar_h;
                    videoAggregationAuthorData.baijiahaoData.auth_id = bvVar.aWl().getBaijiahaoInfo().auth_id;
                    videoAggregationAuthorData.baijiahaoData.auth_desc = bvVar.aWl().getBaijiahaoInfo().auth_desc;
                    videoAggregationAuthorData.baijiahaoData.brief = bvVar.aWl().getBaijiahaoInfo().brief;
                }
            }
            this.author = videoAggregationAuthorData;
            if (bvVar.getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                baijiahaoData.oriUgcNid = bvVar.getBaijiahaoData().oriUgcNid;
                baijiahaoData.oriUgcTid = bvVar.getBaijiahaoData().oriUgcTid;
                baijiahaoData.oriUgcType = bvVar.getBaijiahaoData().oriUgcType;
                baijiahaoData.oriUgcVid = bvVar.getBaijiahaoData().oriUgcVid;
                baijiahaoData.forwardUrl = bvVar.getBaijiahaoData().forwardUrl;
                this.mBaijiahaoData = baijiahaoData;
            }
            VideoAggregationVideoData videoAggregationVideoData = new VideoAggregationVideoData();
            if (bvVar.aWD() != null) {
                videoAggregationVideoData.thumbnailWidth = String.valueOf(bvVar.aWD().thumbnail_width);
                videoAggregationVideoData.thumbnailHeight = String.valueOf(bvVar.aWD().thumbnail_height);
                videoAggregationVideoData.videoMd5 = bvVar.aWD().video_md5;
                videoAggregationVideoData.videoUrl = bvVar.aWD().video_url;
                videoAggregationVideoData.videoDuration = bvVar.aWD().video_duration.intValue();
                videoAggregationVideoData.videoWidth = String.valueOf(bvVar.aWD().video_width);
                videoAggregationVideoData.videoHeight = String.valueOf(bvVar.aWD().video_height);
                videoAggregationVideoData.videoSize = bvVar.aWD().video_length.intValue();
                videoAggregationVideoData.thumbnailUrl = bvVar.aWD().thumbnail_url;
                videoAggregationVideoData.originVideoUrl = bvVar.aWD().video_url;
                videoAggregationVideoData.mcnLeadPage = bvVar.aWD().mcn_lead_page;
                this.playCount = bvVar.aWD().play_count.intValue();
            }
            this.video = videoAggregationVideoData;
            this.forumId = String.valueOf(bvVar.getFid());
            this.threadId = bvVar.getId();
            if (bvVar.dUt != null) {
                this.forumId = bvVar.dUt.id;
            }
            this.firstPostId = bvVar.aVV();
            this.createTime = String.valueOf(bvVar.getCreateTime());
            this.postNum = bvVar.aWc();
            this.agreeNum = bvVar.aXJ();
            this.disAgreeNum = bvVar.aXK();
            this.agreeType = bvVar.aXM();
            this.shareNum = bvVar.aXN();
            this.hasAgree = bvVar.aXL() == 1;
            this.source = bvVar.aXH();
            this.title = bvVar.getTitle();
            if (bvVar.aYc() != null) {
                this.mAgreeData = new AgreeData();
                this.mAgreeData.threadId = bvVar.aYc().threadId;
                this.mAgreeData.agreeNum = bvVar.aYc().agreeNum;
                this.mAgreeData.diffAgreeNum = bvVar.aYc().diffAgreeNum;
                this.mAgreeData.disAgreeNum = bvVar.aYc().disAgreeNum;
                this.mAgreeData.agreeType = bvVar.aYc().agreeType;
                this.mAgreeData.hasAgree = bvVar.aYc().hasAgree;
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
