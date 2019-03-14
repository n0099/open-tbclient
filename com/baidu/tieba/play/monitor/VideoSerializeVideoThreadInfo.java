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
            if (bgVar.YR() != null) {
                videoAggregationAuthorData.userId = bgVar.YR().getUserId();
                videoAggregationAuthorData.userName = bgVar.YR().getUserName();
                videoAggregationAuthorData.userNickname = bgVar.YR().getName_show();
                videoAggregationAuthorData.isBigV = bgVar.YR().isBigV();
                videoAggregationAuthorData.isGod = bgVar.YR().isGod();
                videoAggregationAuthorData.portrait = bgVar.YR().getPortrait();
                videoAggregationAuthorData.hasFocus = bgVar.YR().getIsLike();
            }
            this.author = videoAggregationAuthorData;
            VideoAggregationVideoData videoAggregationVideoData = new VideoAggregationVideoData();
            if (bgVar.Zi() != null) {
                videoAggregationVideoData.thumbnailWidth = String.valueOf(bgVar.Zi().thumbnail_width);
                videoAggregationVideoData.thumbnailHeight = String.valueOf(bgVar.Zi().thumbnail_height);
                videoAggregationVideoData.videoMd5 = bgVar.Zi().video_md5;
                videoAggregationVideoData.videoUrl = bgVar.Zi().video_url;
                videoAggregationVideoData.videoDuration = bgVar.Zi().video_duration.intValue();
                videoAggregationVideoData.videoWidth = String.valueOf(bgVar.Zi().video_width);
                videoAggregationVideoData.videoHeight = String.valueOf(bgVar.Zi().video_height);
                videoAggregationVideoData.videoSize = bgVar.Zi().video_length.intValue();
                videoAggregationVideoData.thumbnailUrl = bgVar.Zi().thumbnail_url;
                videoAggregationVideoData.originVideoUrl = bgVar.Zi().video_url;
                videoAggregationVideoData.mcnLeadPage = bgVar.Zi().mcn_lead_page;
                this.playCount = bgVar.Zi().play_count.intValue();
            }
            this.video = videoAggregationVideoData;
            this.forumId = String.valueOf(bgVar.getFid());
            this.threadId = bgVar.getId();
            if (bgVar.bDE != null) {
                this.forumId = bgVar.bDE.id;
            }
            this.firstPostId = bgVar.YC();
            this.createTime = String.valueOf(bgVar.getCreateTime());
            this.postNum = bgVar.YI();
            this.agreeNum = bgVar.aak();
            this.disAgreeNum = bgVar.aal();
            this.agreeType = bgVar.aan();
            this.shareNum = bgVar.aao();
            this.hasAgree = bgVar.aam() == 1;
            this.source = bgVar.aai();
            this.title = bgVar.getTitle();
            if (bgVar.aaH() != null) {
                this.diffAgreeNum = bgVar.aaH().diffAgreeNum;
                this.agreeType = bgVar.aaH().agreeType;
                this.hasAgree = bgVar.aaH().hasAgree;
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
