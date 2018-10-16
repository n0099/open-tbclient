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
            if (bbVar.yv() != null) {
                videoAggregationAuthorData.userId = bbVar.yv().getUserId();
                videoAggregationAuthorData.userName = bbVar.yv().getUserName();
                videoAggregationAuthorData.userNickname = bbVar.yv().getName_show();
                videoAggregationAuthorData.isBigV = bbVar.yv().isBigV();
                videoAggregationAuthorData.isGod = bbVar.yv().isGod();
                videoAggregationAuthorData.portrait = bbVar.yv().getPortrait();
                videoAggregationAuthorData.hasFocus = bbVar.yv().getIsLike();
            }
            this.author = videoAggregationAuthorData;
            VideoAggregationVideoData videoAggregationVideoData = new VideoAggregationVideoData();
            if (bbVar.yN() != null) {
                videoAggregationVideoData.thumbnailWidth = String.valueOf(bbVar.yN().thumbnail_width);
                videoAggregationVideoData.thumbnailHeight = String.valueOf(bbVar.yN().thumbnail_height);
                videoAggregationVideoData.videoMd5 = bbVar.yN().video_md5;
                videoAggregationVideoData.videoUrl = bbVar.yN().video_url;
                videoAggregationVideoData.videoDuration = bbVar.yN().video_duration.intValue();
                videoAggregationVideoData.videoWidth = String.valueOf(bbVar.yN().video_width);
                videoAggregationVideoData.videoHeight = String.valueOf(bbVar.yN().video_height);
                videoAggregationVideoData.videoSize = bbVar.yN().video_length.intValue();
                videoAggregationVideoData.thumbnailUrl = bbVar.yN().thumbnail_url;
                videoAggregationVideoData.originVideoUrl = bbVar.yN().video_url;
                this.playCount = bbVar.yN().play_count.intValue();
            }
            this.video = videoAggregationVideoData;
            this.forumId = String.valueOf(bbVar.getFid());
            this.threadId = bbVar.getId();
            if (bbVar.arp != null) {
                this.forumId = bbVar.arp.id;
            }
            this.firstPostId = bbVar.yh();
            this.createTime = String.valueOf(bbVar.getCreateTime());
            this.postNum = bbVar.ym();
            this.agreeNum = bbVar.zH();
            this.disAgreeNum = bbVar.zI();
            this.agreeType = bbVar.zK();
            this.shareNum = bbVar.zL();
            this.hasAgree = bbVar.zJ() == 1;
            this.source = bbVar.zF();
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
