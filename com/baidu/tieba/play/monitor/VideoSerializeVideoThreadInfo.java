package com.baidu.tieba.play.monitor;

import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bk;
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

    public void copyFromTransmitThreadData(bk bkVar) {
        if (bkVar != null) {
            OriginalThreadInfo originalThreadInfo = bkVar.dHm;
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
            if (bkVar.dHw != null) {
                this.forumId = bkVar.dHw.id;
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

    public void copyFromThreadInfo(bk bkVar) {
        if (bkVar != null) {
            VideoAggregationAuthorData videoAggregationAuthorData = new VideoAggregationAuthorData();
            if (bkVar.aQx() != null) {
                videoAggregationAuthorData.userId = bkVar.aQx().getUserId();
                videoAggregationAuthorData.userName = bkVar.aQx().getUserName();
                videoAggregationAuthorData.userNickname = bkVar.aQx().getName_show();
                videoAggregationAuthorData.isBigV = bkVar.aQx().isBigV();
                videoAggregationAuthorData.isGod = bkVar.aQx().isGod();
                videoAggregationAuthorData.portrait = bkVar.aQx().getPortrait();
                videoAggregationAuthorData.hasFocus = bkVar.aQx().getIsLike();
                if (bkVar.aQx().getBaijiahaoInfo() != null) {
                    videoAggregationAuthorData.baijiahaoData = new VideoAggregationAuthorData.BaijiahaoAuthorData();
                    videoAggregationAuthorData.baijiahaoData.name = bkVar.aQx().getBaijiahaoInfo().name;
                    videoAggregationAuthorData.baijiahaoData.avatar = bkVar.aQx().getBaijiahaoInfo().avatar;
                    videoAggregationAuthorData.baijiahaoData.avatar_h = bkVar.aQx().getBaijiahaoInfo().avatar_h;
                    videoAggregationAuthorData.baijiahaoData.auth_id = bkVar.aQx().getBaijiahaoInfo().auth_id;
                    videoAggregationAuthorData.baijiahaoData.auth_desc = bkVar.aQx().getBaijiahaoInfo().auth_desc;
                    videoAggregationAuthorData.baijiahaoData.brief = bkVar.aQx().getBaijiahaoInfo().brief;
                }
            }
            this.author = videoAggregationAuthorData;
            if (bkVar.getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                baijiahaoData.oriUgcNid = bkVar.getBaijiahaoData().oriUgcNid;
                baijiahaoData.oriUgcTid = bkVar.getBaijiahaoData().oriUgcTid;
                baijiahaoData.oriUgcType = bkVar.getBaijiahaoData().oriUgcType;
                baijiahaoData.oriUgcVid = bkVar.getBaijiahaoData().oriUgcVid;
                baijiahaoData.forwardUrl = bkVar.getBaijiahaoData().forwardUrl;
                this.mBaijiahaoData = baijiahaoData;
            }
            VideoAggregationVideoData videoAggregationVideoData = new VideoAggregationVideoData();
            if (bkVar.aQQ() != null) {
                videoAggregationVideoData.thumbnailWidth = String.valueOf(bkVar.aQQ().thumbnail_width);
                videoAggregationVideoData.thumbnailHeight = String.valueOf(bkVar.aQQ().thumbnail_height);
                videoAggregationVideoData.videoMd5 = bkVar.aQQ().video_md5;
                videoAggregationVideoData.videoUrl = bkVar.aQQ().video_url;
                videoAggregationVideoData.videoDuration = bkVar.aQQ().video_duration.intValue();
                videoAggregationVideoData.videoWidth = String.valueOf(bkVar.aQQ().video_width);
                videoAggregationVideoData.videoHeight = String.valueOf(bkVar.aQQ().video_height);
                videoAggregationVideoData.videoSize = bkVar.aQQ().video_length.intValue();
                videoAggregationVideoData.thumbnailUrl = bkVar.aQQ().thumbnail_url;
                videoAggregationVideoData.originVideoUrl = bkVar.aQQ().video_url;
                videoAggregationVideoData.mcnLeadPage = bkVar.aQQ().mcn_lead_page;
                this.playCount = bkVar.aQQ().play_count.intValue();
            }
            this.video = videoAggregationVideoData;
            this.forumId = String.valueOf(bkVar.getFid());
            this.threadId = bkVar.getId();
            if (bkVar.dHw != null) {
                this.forumId = bkVar.dHw.id;
            }
            this.firstPostId = bkVar.aQh();
            this.createTime = String.valueOf(bkVar.getCreateTime());
            this.postNum = bkVar.aQo();
            this.agreeNum = bkVar.aRW();
            this.disAgreeNum = bkVar.aRX();
            this.agreeType = bkVar.aRZ();
            this.shareNum = bkVar.aSa();
            this.hasAgree = bkVar.aRY() == 1;
            this.source = bkVar.aRU();
            this.title = bkVar.getTitle();
            if (bkVar.aSp() != null) {
                this.mAgreeData = new AgreeData();
                this.mAgreeData.threadId = bkVar.aSp().threadId;
                this.mAgreeData.agreeNum = bkVar.aSp().agreeNum;
                this.mAgreeData.diffAgreeNum = bkVar.aSp().diffAgreeNum;
                this.mAgreeData.disAgreeNum = bkVar.aSp().disAgreeNum;
                this.mAgreeData.agreeType = bkVar.aSp().agreeType;
                this.mAgreeData.hasAgree = bkVar.aSp().hasAgree;
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
