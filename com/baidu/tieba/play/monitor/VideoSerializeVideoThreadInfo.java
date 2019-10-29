package com.baidu.tieba.play.monitor;

import com.baidu.tbadk.core.data.bh;
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
        public boolean hasFocus;
        public boolean isBigV;
        public boolean isGod;
        public String portrait;
        public String userId;
        public String userName;
        public String userNickname;
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

    public void copyFromThreadInfo(bh bhVar) {
        if (bhVar != null) {
            VideoAggregationAuthorData videoAggregationAuthorData = new VideoAggregationAuthorData();
            if (bhVar.aiG() != null) {
                videoAggregationAuthorData.userId = bhVar.aiG().getUserId();
                videoAggregationAuthorData.userName = bhVar.aiG().getUserName();
                videoAggregationAuthorData.userNickname = bhVar.aiG().getName_show();
                videoAggregationAuthorData.isBigV = bhVar.aiG().isBigV();
                videoAggregationAuthorData.isGod = bhVar.aiG().isGod();
                videoAggregationAuthorData.portrait = bhVar.aiG().getPortrait();
                videoAggregationAuthorData.hasFocus = bhVar.aiG().getIsLike();
            }
            this.author = videoAggregationAuthorData;
            VideoAggregationVideoData videoAggregationVideoData = new VideoAggregationVideoData();
            if (bhVar.aiX() != null) {
                videoAggregationVideoData.thumbnailWidth = String.valueOf(bhVar.aiX().thumbnail_width);
                videoAggregationVideoData.thumbnailHeight = String.valueOf(bhVar.aiX().thumbnail_height);
                videoAggregationVideoData.videoMd5 = bhVar.aiX().video_md5;
                videoAggregationVideoData.videoUrl = bhVar.aiX().video_url;
                videoAggregationVideoData.videoDuration = bhVar.aiX().video_duration.intValue();
                videoAggregationVideoData.videoWidth = String.valueOf(bhVar.aiX().video_width);
                videoAggregationVideoData.videoHeight = String.valueOf(bhVar.aiX().video_height);
                videoAggregationVideoData.videoSize = bhVar.aiX().video_length.intValue();
                videoAggregationVideoData.thumbnailUrl = bhVar.aiX().thumbnail_url;
                videoAggregationVideoData.originVideoUrl = bhVar.aiX().video_url;
                videoAggregationVideoData.mcnLeadPage = bhVar.aiX().mcn_lead_page;
                this.playCount = bhVar.aiX().play_count.intValue();
            }
            this.video = videoAggregationVideoData;
            this.forumId = String.valueOf(bhVar.getFid());
            this.threadId = bhVar.getId();
            if (bhVar.cem != null) {
                this.forumId = bhVar.cem.id;
            }
            this.firstPostId = bhVar.air();
            this.createTime = String.valueOf(bhVar.getCreateTime());
            this.postNum = bhVar.aix();
            this.agreeNum = bhVar.ajY();
            this.disAgreeNum = bhVar.ajZ();
            this.agreeType = bhVar.akb();
            this.shareNum = bhVar.akc();
            this.hasAgree = bhVar.aka() == 1;
            this.source = bhVar.ajW();
            this.title = bhVar.getTitle();
            if (bhVar.akv() != null) {
                this.diffAgreeNum = bhVar.akv().diffAgreeNum;
                this.agreeType = bhVar.akv().agreeType;
                this.hasAgree = bhVar.akv().hasAgree;
            }
        }
    }

    public VideoAggregationAuthorData getAuthor() {
        return this.author;
    }

    public VideoAggregationVideoData getThreadVideoInfo() {
        return this.video;
    }
}
