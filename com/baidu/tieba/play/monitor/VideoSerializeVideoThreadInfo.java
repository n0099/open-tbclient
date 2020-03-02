package com.baidu.tieba.play.monitor;

import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
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

    public void copyFromTransmitThreadData(bj bjVar) {
        if (bjVar != null) {
            OriginalThreadInfo originalThreadInfo = bjVar.cTQ;
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
            if (bjVar.cUa != null) {
                this.forumId = bjVar.cUa.id;
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

    public void copyFromThreadInfo(bj bjVar) {
        if (bjVar != null) {
            VideoAggregationAuthorData videoAggregationAuthorData = new VideoAggregationAuthorData();
            if (bjVar.aCo() != null) {
                videoAggregationAuthorData.userId = bjVar.aCo().getUserId();
                videoAggregationAuthorData.userName = bjVar.aCo().getUserName();
                videoAggregationAuthorData.userNickname = bjVar.aCo().getName_show();
                videoAggregationAuthorData.isBigV = bjVar.aCo().isBigV();
                videoAggregationAuthorData.isGod = bjVar.aCo().isGod();
                videoAggregationAuthorData.portrait = bjVar.aCo().getPortrait();
                videoAggregationAuthorData.hasFocus = bjVar.aCo().getIsLike();
                if (bjVar.aCo().getBaijiahaoInfo() != null) {
                    videoAggregationAuthorData.baijiahaoData = new VideoAggregationAuthorData.BaijiahaoAuthorData();
                    videoAggregationAuthorData.baijiahaoData.name = bjVar.aCo().getBaijiahaoInfo().name;
                    videoAggregationAuthorData.baijiahaoData.avatar = bjVar.aCo().getBaijiahaoInfo().avatar;
                    videoAggregationAuthorData.baijiahaoData.avatar_h = bjVar.aCo().getBaijiahaoInfo().avatar_h;
                    videoAggregationAuthorData.baijiahaoData.auth_id = bjVar.aCo().getBaijiahaoInfo().auth_id;
                    videoAggregationAuthorData.baijiahaoData.auth_desc = bjVar.aCo().getBaijiahaoInfo().auth_desc;
                    videoAggregationAuthorData.baijiahaoData.brief = bjVar.aCo().getBaijiahaoInfo().brief;
                }
            }
            this.author = videoAggregationAuthorData;
            if (bjVar.getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                baijiahaoData.oriUgcNid = bjVar.getBaijiahaoData().oriUgcNid;
                baijiahaoData.oriUgcTid = bjVar.getBaijiahaoData().oriUgcTid;
                baijiahaoData.oriUgcType = bjVar.getBaijiahaoData().oriUgcType;
                baijiahaoData.oriUgcVid = bjVar.getBaijiahaoData().oriUgcVid;
                baijiahaoData.forwardUrl = bjVar.getBaijiahaoData().forwardUrl;
                this.mBaijiahaoData = baijiahaoData;
            }
            VideoAggregationVideoData videoAggregationVideoData = new VideoAggregationVideoData();
            if (bjVar.aCF() != null) {
                videoAggregationVideoData.thumbnailWidth = String.valueOf(bjVar.aCF().thumbnail_width);
                videoAggregationVideoData.thumbnailHeight = String.valueOf(bjVar.aCF().thumbnail_height);
                videoAggregationVideoData.videoMd5 = bjVar.aCF().video_md5;
                videoAggregationVideoData.videoUrl = bjVar.aCF().video_url;
                videoAggregationVideoData.videoDuration = bjVar.aCF().video_duration.intValue();
                videoAggregationVideoData.videoWidth = String.valueOf(bjVar.aCF().video_width);
                videoAggregationVideoData.videoHeight = String.valueOf(bjVar.aCF().video_height);
                videoAggregationVideoData.videoSize = bjVar.aCF().video_length.intValue();
                videoAggregationVideoData.thumbnailUrl = bjVar.aCF().thumbnail_url;
                videoAggregationVideoData.originVideoUrl = bjVar.aCF().video_url;
                videoAggregationVideoData.mcnLeadPage = bjVar.aCF().mcn_lead_page;
                this.playCount = bjVar.aCF().play_count.intValue();
            }
            this.video = videoAggregationVideoData;
            this.forumId = String.valueOf(bjVar.getFid());
            this.threadId = bjVar.getId();
            if (bjVar.cUa != null) {
                this.forumId = bjVar.cUa.id;
            }
            this.firstPostId = bjVar.aBY();
            this.createTime = String.valueOf(bjVar.getCreateTime());
            this.postNum = bjVar.aCf();
            this.agreeNum = bjVar.aDH();
            this.disAgreeNum = bjVar.aDI();
            this.agreeType = bjVar.aDK();
            this.shareNum = bjVar.aDL();
            this.hasAgree = bjVar.aDJ() == 1;
            this.source = bjVar.aDF();
            this.title = bjVar.getTitle();
            if (bjVar.aEa() != null) {
                this.mAgreeData = new AgreeData();
                this.mAgreeData.threadId = bjVar.aEa().threadId;
                this.mAgreeData.agreeNum = bjVar.aEa().agreeNum;
                this.mAgreeData.diffAgreeNum = bjVar.aEa().diffAgreeNum;
                this.mAgreeData.disAgreeNum = bjVar.aEa().disAgreeNum;
                this.mAgreeData.agreeType = bjVar.aEa().agreeType;
                this.mAgreeData.hasAgree = bjVar.aEa().hasAgree;
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
