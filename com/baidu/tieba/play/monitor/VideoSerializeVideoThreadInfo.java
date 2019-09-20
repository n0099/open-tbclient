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
            if (bhVar.aeC() != null) {
                videoAggregationAuthorData.userId = bhVar.aeC().getUserId();
                videoAggregationAuthorData.userName = bhVar.aeC().getUserName();
                videoAggregationAuthorData.userNickname = bhVar.aeC().getName_show();
                videoAggregationAuthorData.isBigV = bhVar.aeC().isBigV();
                videoAggregationAuthorData.isGod = bhVar.aeC().isGod();
                videoAggregationAuthorData.portrait = bhVar.aeC().getPortrait();
                videoAggregationAuthorData.hasFocus = bhVar.aeC().getIsLike();
            }
            this.author = videoAggregationAuthorData;
            VideoAggregationVideoData videoAggregationVideoData = new VideoAggregationVideoData();
            if (bhVar.aeT() != null) {
                videoAggregationVideoData.thumbnailWidth = String.valueOf(bhVar.aeT().thumbnail_width);
                videoAggregationVideoData.thumbnailHeight = String.valueOf(bhVar.aeT().thumbnail_height);
                videoAggregationVideoData.videoMd5 = bhVar.aeT().video_md5;
                videoAggregationVideoData.videoUrl = bhVar.aeT().video_url;
                videoAggregationVideoData.videoDuration = bhVar.aeT().video_duration.intValue();
                videoAggregationVideoData.videoWidth = String.valueOf(bhVar.aeT().video_width);
                videoAggregationVideoData.videoHeight = String.valueOf(bhVar.aeT().video_height);
                videoAggregationVideoData.videoSize = bhVar.aeT().video_length.intValue();
                videoAggregationVideoData.thumbnailUrl = bhVar.aeT().thumbnail_url;
                videoAggregationVideoData.originVideoUrl = bhVar.aeT().video_url;
                videoAggregationVideoData.mcnLeadPage = bhVar.aeT().mcn_lead_page;
                this.playCount = bhVar.aeT().play_count.intValue();
            }
            this.video = videoAggregationVideoData;
            this.forumId = String.valueOf(bhVar.getFid());
            this.threadId = bhVar.getId();
            if (bhVar.bMD != null) {
                this.forumId = bhVar.bMD.id;
            }
            this.firstPostId = bhVar.aen();
            this.createTime = String.valueOf(bhVar.getCreateTime());
            this.postNum = bhVar.aet();
            this.agreeNum = bhVar.afV();
            this.disAgreeNum = bhVar.afW();
            this.agreeType = bhVar.afY();
            this.shareNum = bhVar.afZ();
            this.hasAgree = bhVar.afX() == 1;
            this.source = bhVar.afT();
            this.title = bhVar.getTitle();
            if (bhVar.ags() != null) {
                this.diffAgreeNum = bhVar.ags().diffAgreeNum;
                this.agreeType = bhVar.ags().agreeType;
                this.hasAgree = bhVar.ags().hasAgree;
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
