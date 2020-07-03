package com.baidu.tieba.play.monitor;

import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bu;
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

    public void copyFromTransmitThreadData(bu buVar) {
        if (buVar != null) {
            OriginalThreadInfo originalThreadInfo = buVar.dNX;
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
            if (buVar.dOi != null) {
                this.forumId = buVar.dOi.id;
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

    public void copyFromThreadInfo(bu buVar) {
        if (buVar != null) {
            VideoAggregationAuthorData videoAggregationAuthorData = new VideoAggregationAuthorData();
            if (buVar.aSp() != null) {
                videoAggregationAuthorData.userId = buVar.aSp().getUserId();
                videoAggregationAuthorData.userName = buVar.aSp().getUserName();
                videoAggregationAuthorData.userNickname = buVar.aSp().getName_show();
                videoAggregationAuthorData.isBigV = buVar.aSp().isBigV();
                videoAggregationAuthorData.isGod = buVar.aSp().isGod();
                videoAggregationAuthorData.portrait = buVar.aSp().getPortrait();
                videoAggregationAuthorData.hasFocus = buVar.aSp().getIsLike();
                if (buVar.aSp().getBaijiahaoInfo() != null) {
                    videoAggregationAuthorData.baijiahaoData = new VideoAggregationAuthorData.BaijiahaoAuthorData();
                    videoAggregationAuthorData.baijiahaoData.name = buVar.aSp().getBaijiahaoInfo().name;
                    videoAggregationAuthorData.baijiahaoData.avatar = buVar.aSp().getBaijiahaoInfo().avatar;
                    videoAggregationAuthorData.baijiahaoData.avatar_h = buVar.aSp().getBaijiahaoInfo().avatar_h;
                    videoAggregationAuthorData.baijiahaoData.auth_id = buVar.aSp().getBaijiahaoInfo().auth_id;
                    videoAggregationAuthorData.baijiahaoData.auth_desc = buVar.aSp().getBaijiahaoInfo().auth_desc;
                    videoAggregationAuthorData.baijiahaoData.brief = buVar.aSp().getBaijiahaoInfo().brief;
                }
            }
            this.author = videoAggregationAuthorData;
            if (buVar.getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                baijiahaoData.oriUgcNid = buVar.getBaijiahaoData().oriUgcNid;
                baijiahaoData.oriUgcTid = buVar.getBaijiahaoData().oriUgcTid;
                baijiahaoData.oriUgcType = buVar.getBaijiahaoData().oriUgcType;
                baijiahaoData.oriUgcVid = buVar.getBaijiahaoData().oriUgcVid;
                baijiahaoData.forwardUrl = buVar.getBaijiahaoData().forwardUrl;
                this.mBaijiahaoData = baijiahaoData;
            }
            VideoAggregationVideoData videoAggregationVideoData = new VideoAggregationVideoData();
            if (buVar.aSH() != null) {
                videoAggregationVideoData.thumbnailWidth = String.valueOf(buVar.aSH().thumbnail_width);
                videoAggregationVideoData.thumbnailHeight = String.valueOf(buVar.aSH().thumbnail_height);
                videoAggregationVideoData.videoMd5 = buVar.aSH().video_md5;
                videoAggregationVideoData.videoUrl = buVar.aSH().video_url;
                videoAggregationVideoData.videoDuration = buVar.aSH().video_duration.intValue();
                videoAggregationVideoData.videoWidth = String.valueOf(buVar.aSH().video_width);
                videoAggregationVideoData.videoHeight = String.valueOf(buVar.aSH().video_height);
                videoAggregationVideoData.videoSize = buVar.aSH().video_length.intValue();
                videoAggregationVideoData.thumbnailUrl = buVar.aSH().thumbnail_url;
                videoAggregationVideoData.originVideoUrl = buVar.aSH().video_url;
                videoAggregationVideoData.mcnLeadPage = buVar.aSH().mcn_lead_page;
                this.playCount = buVar.aSH().play_count.intValue();
            }
            this.video = videoAggregationVideoData;
            this.forumId = String.valueOf(buVar.getFid());
            this.threadId = buVar.getId();
            if (buVar.dOi != null) {
                this.forumId = buVar.dOi.id;
            }
            this.firstPostId = buVar.aRZ();
            this.createTime = String.valueOf(buVar.getCreateTime());
            this.postNum = buVar.aSg();
            this.agreeNum = buVar.aTN();
            this.disAgreeNum = buVar.aTO();
            this.agreeType = buVar.aTQ();
            this.shareNum = buVar.aTR();
            this.hasAgree = buVar.aTP() == 1;
            this.source = buVar.aTL();
            this.title = buVar.getTitle();
            if (buVar.aUg() != null) {
                this.mAgreeData = new AgreeData();
                this.mAgreeData.threadId = buVar.aUg().threadId;
                this.mAgreeData.agreeNum = buVar.aUg().agreeNum;
                this.mAgreeData.diffAgreeNum = buVar.aUg().diffAgreeNum;
                this.mAgreeData.disAgreeNum = buVar.aUg().disAgreeNum;
                this.mAgreeData.agreeType = buVar.aUg().agreeType;
                this.mAgreeData.hasAgree = buVar.aUg().hasAgree;
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
