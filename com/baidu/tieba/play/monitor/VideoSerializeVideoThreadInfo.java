package com.baidu.tieba.play.monitor;

import com.baidu.tbadk.core.data.bb;
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

    public void copyFromThreadInfo(bb bbVar) {
        if (bbVar != null) {
            VideoAggregationAuthorData videoAggregationAuthorData = new VideoAggregationAuthorData();
            if (bbVar.yC() != null) {
                videoAggregationAuthorData.userId = bbVar.yC().getUserId();
                videoAggregationAuthorData.userName = bbVar.yC().getUserName();
                videoAggregationAuthorData.userNickname = bbVar.yC().getName_show();
                videoAggregationAuthorData.isBigV = bbVar.yC().isBigV();
                videoAggregationAuthorData.isGod = bbVar.yC().isGod();
                videoAggregationAuthorData.portrait = bbVar.yC().getPortrait();
                videoAggregationAuthorData.hasFocus = bbVar.yC().getIsLike();
            }
            this.author = videoAggregationAuthorData;
            VideoAggregationVideoData videoAggregationVideoData = new VideoAggregationVideoData();
            if (bbVar.yU() != null) {
                videoAggregationVideoData.thumbnailWidth = String.valueOf(bbVar.yU().thumbnail_width);
                videoAggregationVideoData.thumbnailHeight = String.valueOf(bbVar.yU().thumbnail_height);
                videoAggregationVideoData.videoMd5 = bbVar.yU().video_md5;
                videoAggregationVideoData.videoUrl = bbVar.yU().video_url;
                videoAggregationVideoData.videoDuration = bbVar.yU().video_duration.intValue();
                videoAggregationVideoData.videoWidth = String.valueOf(bbVar.yU().video_width);
                videoAggregationVideoData.videoHeight = String.valueOf(bbVar.yU().video_height);
                videoAggregationVideoData.videoSize = bbVar.yU().video_length.intValue();
                videoAggregationVideoData.thumbnailUrl = bbVar.yU().thumbnail_url;
                videoAggregationVideoData.originVideoUrl = bbVar.yU().video_url;
                videoAggregationVideoData.mcnLeadPage = bbVar.yU().mcn_lead_page;
                this.playCount = bbVar.yU().play_count.intValue();
            }
            this.video = videoAggregationVideoData;
            this.forumId = String.valueOf(bbVar.getFid());
            this.threadId = bbVar.getId();
            if (bbVar.asc != null) {
                this.forumId = bbVar.asc.id;
            }
            this.firstPostId = bbVar.yo();
            this.createTime = String.valueOf(bbVar.getCreateTime());
            this.postNum = bbVar.yt();
            this.agreeNum = bbVar.zO();
            this.disAgreeNum = bbVar.zP();
            this.agreeType = bbVar.zR();
            this.shareNum = bbVar.zS();
            this.hasAgree = bbVar.zQ() == 1;
            this.source = bbVar.zM();
            this.title = bbVar.getTitle();
        }
    }

    public VideoAggregationAuthorData getAuthor() {
        return this.author;
    }

    public VideoAggregationVideoData getThreadVideoInfo() {
        return this.video;
    }
}
