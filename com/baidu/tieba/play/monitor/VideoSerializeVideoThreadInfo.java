package com.baidu.tieba.play.monitor;

import com.baidu.tbadk.core.data.bg;
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

    public void copyFromThreadInfo(bg bgVar) {
        if (bgVar != null) {
            VideoAggregationAuthorData videoAggregationAuthorData = new VideoAggregationAuthorData();
            if (bgVar.aex() != null) {
                videoAggregationAuthorData.userId = bgVar.aex().getUserId();
                videoAggregationAuthorData.userName = bgVar.aex().getUserName();
                videoAggregationAuthorData.userNickname = bgVar.aex().getName_show();
                videoAggregationAuthorData.isBigV = bgVar.aex().isBigV();
                videoAggregationAuthorData.isGod = bgVar.aex().isGod();
                videoAggregationAuthorData.portrait = bgVar.aex().getPortrait();
                videoAggregationAuthorData.hasFocus = bgVar.aex().getIsLike();
            }
            this.author = videoAggregationAuthorData;
            VideoAggregationVideoData videoAggregationVideoData = new VideoAggregationVideoData();
            if (bgVar.aeO() != null) {
                videoAggregationVideoData.thumbnailWidth = String.valueOf(bgVar.aeO().thumbnail_width);
                videoAggregationVideoData.thumbnailHeight = String.valueOf(bgVar.aeO().thumbnail_height);
                videoAggregationVideoData.videoMd5 = bgVar.aeO().video_md5;
                videoAggregationVideoData.videoUrl = bgVar.aeO().video_url;
                videoAggregationVideoData.videoDuration = bgVar.aeO().video_duration.intValue();
                videoAggregationVideoData.videoWidth = String.valueOf(bgVar.aeO().video_width);
                videoAggregationVideoData.videoHeight = String.valueOf(bgVar.aeO().video_height);
                videoAggregationVideoData.videoSize = bgVar.aeO().video_length.intValue();
                videoAggregationVideoData.thumbnailUrl = bgVar.aeO().thumbnail_url;
                videoAggregationVideoData.originVideoUrl = bgVar.aeO().video_url;
                videoAggregationVideoData.mcnLeadPage = bgVar.aeO().mcn_lead_page;
                this.playCount = bgVar.aeO().play_count.intValue();
            }
            this.video = videoAggregationVideoData;
            this.forumId = String.valueOf(bgVar.getFid());
            this.threadId = bgVar.getId();
            if (bgVar.bMa != null) {
                this.forumId = bgVar.bMa.id;
            }
            this.firstPostId = bgVar.aei();
            this.createTime = String.valueOf(bgVar.getCreateTime());
            this.postNum = bgVar.aeo();
            this.agreeNum = bgVar.afQ();
            this.disAgreeNum = bgVar.afR();
            this.agreeType = bgVar.afT();
            this.shareNum = bgVar.afU();
            this.hasAgree = bgVar.afS() == 1;
            this.source = bgVar.afO();
            this.title = bgVar.getTitle();
            if (bgVar.agn() != null) {
                this.diffAgreeNum = bgVar.agn().diffAgreeNum;
                this.agreeType = bgVar.agn().agreeType;
                this.hasAgree = bgVar.agn().hasAgree;
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
