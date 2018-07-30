package com.baidu.tieba.play.monitor;

import com.baidu.tbadk.core.data.bb;
import java.io.Serializable;
/* loaded from: classes.dex */
public class VideoSerializeVideoThreadInfo implements Serializable {
    private static final long serialVersionUID = -7659795764367587672L;
    public long agreeNum;
    public VideoAggregationAuthorData author;
    public boolean autoPlay;
    public String createTime;
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
            if (bbVar.vk() != null) {
                videoAggregationAuthorData.userId = bbVar.vk().getUserId();
                videoAggregationAuthorData.userName = bbVar.vk().getUserName();
                videoAggregationAuthorData.userNickname = bbVar.vk().getName_show();
                videoAggregationAuthorData.isBigV = bbVar.vk().isBigV();
                videoAggregationAuthorData.isGod = bbVar.vk().isGod();
                videoAggregationAuthorData.portrait = bbVar.vk().getPortrait();
                videoAggregationAuthorData.hasFocus = bbVar.vk().getIsLike();
            }
            this.author = videoAggregationAuthorData;
            VideoAggregationVideoData videoAggregationVideoData = new VideoAggregationVideoData();
            if (bbVar.vC() != null) {
                videoAggregationVideoData.thumbnailWidth = String.valueOf(bbVar.vC().thumbnail_width);
                videoAggregationVideoData.thumbnailHeight = String.valueOf(bbVar.vC().thumbnail_height);
                videoAggregationVideoData.videoMd5 = bbVar.vC().video_md5;
                videoAggregationVideoData.videoUrl = bbVar.vC().video_url;
                videoAggregationVideoData.videoDuration = bbVar.vC().video_duration.intValue();
                videoAggregationVideoData.videoWidth = String.valueOf(bbVar.vC().video_width);
                videoAggregationVideoData.videoHeight = String.valueOf(bbVar.vC().video_height);
                videoAggregationVideoData.videoSize = bbVar.vC().video_length.intValue();
                videoAggregationVideoData.thumbnailUrl = bbVar.vC().thumbnail_url;
                videoAggregationVideoData.originVideoUrl = bbVar.vC().video_url;
                this.playCount = bbVar.vC().play_count.intValue();
            }
            this.video = videoAggregationVideoData;
            this.forumId = String.valueOf(bbVar.getFid());
            this.threadId = bbVar.getId();
            if (bbVar.ajQ != null) {
                this.forumId = bbVar.ajQ.id;
            }
            this.firstPostId = bbVar.uW();
            this.createTime = String.valueOf(bbVar.getCreateTime());
            this.postNum = bbVar.vb();
            this.agreeNum = bbVar.wu();
            this.shareNum = bbVar.ww();
            this.hasAgree = bbVar.wv() == 1;
            this.source = bbVar.ws();
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
