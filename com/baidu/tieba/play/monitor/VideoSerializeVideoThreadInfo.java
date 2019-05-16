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
            if (bgVar.adv() != null) {
                videoAggregationAuthorData.userId = bgVar.adv().getUserId();
                videoAggregationAuthorData.userName = bgVar.adv().getUserName();
                videoAggregationAuthorData.userNickname = bgVar.adv().getName_show();
                videoAggregationAuthorData.isBigV = bgVar.adv().isBigV();
                videoAggregationAuthorData.isGod = bgVar.adv().isGod();
                videoAggregationAuthorData.portrait = bgVar.adv().getPortrait();
                videoAggregationAuthorData.hasFocus = bgVar.adv().getIsLike();
            }
            this.author = videoAggregationAuthorData;
            VideoAggregationVideoData videoAggregationVideoData = new VideoAggregationVideoData();
            if (bgVar.adM() != null) {
                videoAggregationVideoData.thumbnailWidth = String.valueOf(bgVar.adM().thumbnail_width);
                videoAggregationVideoData.thumbnailHeight = String.valueOf(bgVar.adM().thumbnail_height);
                videoAggregationVideoData.videoMd5 = bgVar.adM().video_md5;
                videoAggregationVideoData.videoUrl = bgVar.adM().video_url;
                videoAggregationVideoData.videoDuration = bgVar.adM().video_duration.intValue();
                videoAggregationVideoData.videoWidth = String.valueOf(bgVar.adM().video_width);
                videoAggregationVideoData.videoHeight = String.valueOf(bgVar.adM().video_height);
                videoAggregationVideoData.videoSize = bgVar.adM().video_length.intValue();
                videoAggregationVideoData.thumbnailUrl = bgVar.adM().thumbnail_url;
                videoAggregationVideoData.originVideoUrl = bgVar.adM().video_url;
                videoAggregationVideoData.mcnLeadPage = bgVar.adM().mcn_lead_page;
                this.playCount = bgVar.adM().play_count.intValue();
            }
            this.video = videoAggregationVideoData;
            this.forumId = String.valueOf(bgVar.getFid());
            this.threadId = bgVar.getId();
            if (bgVar.bKZ != null) {
                this.forumId = bgVar.bKZ.id;
            }
            this.firstPostId = bgVar.adg();
            this.createTime = String.valueOf(bgVar.getCreateTime());
            this.postNum = bgVar.adm();
            this.agreeNum = bgVar.aeO();
            this.disAgreeNum = bgVar.aeP();
            this.agreeType = bgVar.aeR();
            this.shareNum = bgVar.aeS();
            this.hasAgree = bgVar.aeQ() == 1;
            this.source = bgVar.aeM();
            this.title = bgVar.getTitle();
            if (bgVar.afl() != null) {
                this.diffAgreeNum = bgVar.afl().diffAgreeNum;
                this.agreeType = bgVar.afl().agreeType;
                this.hasAgree = bgVar.afl().hasAgree;
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
