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
            if (bhVar.aiE() != null) {
                videoAggregationAuthorData.userId = bhVar.aiE().getUserId();
                videoAggregationAuthorData.userName = bhVar.aiE().getUserName();
                videoAggregationAuthorData.userNickname = bhVar.aiE().getName_show();
                videoAggregationAuthorData.isBigV = bhVar.aiE().isBigV();
                videoAggregationAuthorData.isGod = bhVar.aiE().isGod();
                videoAggregationAuthorData.portrait = bhVar.aiE().getPortrait();
                videoAggregationAuthorData.hasFocus = bhVar.aiE().getIsLike();
            }
            this.author = videoAggregationAuthorData;
            VideoAggregationVideoData videoAggregationVideoData = new VideoAggregationVideoData();
            if (bhVar.aiV() != null) {
                videoAggregationVideoData.thumbnailWidth = String.valueOf(bhVar.aiV().thumbnail_width);
                videoAggregationVideoData.thumbnailHeight = String.valueOf(bhVar.aiV().thumbnail_height);
                videoAggregationVideoData.videoMd5 = bhVar.aiV().video_md5;
                videoAggregationVideoData.videoUrl = bhVar.aiV().video_url;
                videoAggregationVideoData.videoDuration = bhVar.aiV().video_duration.intValue();
                videoAggregationVideoData.videoWidth = String.valueOf(bhVar.aiV().video_width);
                videoAggregationVideoData.videoHeight = String.valueOf(bhVar.aiV().video_height);
                videoAggregationVideoData.videoSize = bhVar.aiV().video_length.intValue();
                videoAggregationVideoData.thumbnailUrl = bhVar.aiV().thumbnail_url;
                videoAggregationVideoData.originVideoUrl = bhVar.aiV().video_url;
                videoAggregationVideoData.mcnLeadPage = bhVar.aiV().mcn_lead_page;
                this.playCount = bhVar.aiV().play_count.intValue();
            }
            this.video = videoAggregationVideoData;
            this.forumId = String.valueOf(bhVar.getFid());
            this.threadId = bhVar.getId();
            if (bhVar.cdv != null) {
                this.forumId = bhVar.cdv.id;
            }
            this.firstPostId = bhVar.aip();
            this.createTime = String.valueOf(bhVar.getCreateTime());
            this.postNum = bhVar.aiv();
            this.agreeNum = bhVar.ajW();
            this.disAgreeNum = bhVar.ajX();
            this.agreeType = bhVar.ajZ();
            this.shareNum = bhVar.aka();
            this.hasAgree = bhVar.ajY() == 1;
            this.source = bhVar.ajU();
            this.title = bhVar.getTitle();
            if (bhVar.akt() != null) {
                this.diffAgreeNum = bhVar.akt().diffAgreeNum;
                this.agreeType = bhVar.akt().agreeType;
                this.hasAgree = bhVar.akt().hasAgree;
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
