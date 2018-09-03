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
            if (bbVar.vj() != null) {
                videoAggregationAuthorData.userId = bbVar.vj().getUserId();
                videoAggregationAuthorData.userName = bbVar.vj().getUserName();
                videoAggregationAuthorData.userNickname = bbVar.vj().getName_show();
                videoAggregationAuthorData.isBigV = bbVar.vj().isBigV();
                videoAggregationAuthorData.isGod = bbVar.vj().isGod();
                videoAggregationAuthorData.portrait = bbVar.vj().getPortrait();
                videoAggregationAuthorData.hasFocus = bbVar.vj().getIsLike();
            }
            this.author = videoAggregationAuthorData;
            VideoAggregationVideoData videoAggregationVideoData = new VideoAggregationVideoData();
            if (bbVar.vB() != null) {
                videoAggregationVideoData.thumbnailWidth = String.valueOf(bbVar.vB().thumbnail_width);
                videoAggregationVideoData.thumbnailHeight = String.valueOf(bbVar.vB().thumbnail_height);
                videoAggregationVideoData.videoMd5 = bbVar.vB().video_md5;
                videoAggregationVideoData.videoUrl = bbVar.vB().video_url;
                videoAggregationVideoData.videoDuration = bbVar.vB().video_duration.intValue();
                videoAggregationVideoData.videoWidth = String.valueOf(bbVar.vB().video_width);
                videoAggregationVideoData.videoHeight = String.valueOf(bbVar.vB().video_height);
                videoAggregationVideoData.videoSize = bbVar.vB().video_length.intValue();
                videoAggregationVideoData.thumbnailUrl = bbVar.vB().thumbnail_url;
                videoAggregationVideoData.originVideoUrl = bbVar.vB().video_url;
                this.playCount = bbVar.vB().play_count.intValue();
            }
            this.video = videoAggregationVideoData;
            this.forumId = String.valueOf(bbVar.getFid());
            this.threadId = bbVar.getId();
            if (bbVar.ajQ != null) {
                this.forumId = bbVar.ajQ.id;
            }
            this.firstPostId = bbVar.uV();
            this.createTime = String.valueOf(bbVar.getCreateTime());
            this.postNum = bbVar.va();
            this.agreeNum = bbVar.wt();
            this.shareNum = bbVar.wv();
            this.hasAgree = bbVar.wu() == 1;
            this.source = bbVar.wr();
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
