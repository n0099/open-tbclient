package com.baidu.tieba.play.monitor;

import com.baidu.tbadk.core.data.bd;
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

    public void copyFromThreadInfo(bd bdVar) {
        if (bdVar != null) {
            VideoAggregationAuthorData videoAggregationAuthorData = new VideoAggregationAuthorData();
            if (bdVar.rQ() != null) {
                videoAggregationAuthorData.userId = bdVar.rQ().getUserId();
                videoAggregationAuthorData.userName = bdVar.rQ().getUserName();
                videoAggregationAuthorData.userNickname = bdVar.rQ().getName_show();
                videoAggregationAuthorData.isBigV = bdVar.rQ().isBigV();
                videoAggregationAuthorData.isGod = bdVar.rQ().isGod();
                videoAggregationAuthorData.portrait = bdVar.rQ().getPortrait();
                videoAggregationAuthorData.hasFocus = bdVar.rQ().getIsLike();
            }
            this.author = videoAggregationAuthorData;
            VideoAggregationVideoData videoAggregationVideoData = new VideoAggregationVideoData();
            if (bdVar.sh() != null) {
                videoAggregationVideoData.thumbnailWidth = String.valueOf(bdVar.sh().thumbnail_width);
                videoAggregationVideoData.thumbnailHeight = String.valueOf(bdVar.sh().thumbnail_height);
                videoAggregationVideoData.videoMd5 = bdVar.sh().video_md5;
                videoAggregationVideoData.videoUrl = bdVar.sh().video_url;
                videoAggregationVideoData.videoDuration = bdVar.sh().video_duration.intValue();
                videoAggregationVideoData.videoWidth = String.valueOf(bdVar.sh().video_width);
                videoAggregationVideoData.videoHeight = String.valueOf(bdVar.sh().video_height);
                videoAggregationVideoData.videoSize = bdVar.sh().video_length.intValue();
                videoAggregationVideoData.thumbnailUrl = bdVar.sh().thumbnail_url;
                videoAggregationVideoData.originVideoUrl = bdVar.sh().video_url;
                this.playCount = bdVar.sh().play_count.intValue();
            }
            this.video = videoAggregationVideoData;
            this.forumId = String.valueOf(bdVar.getFid());
            this.threadId = bdVar.getId();
            this.firstPostId = bdVar.rE();
            this.createTime = String.valueOf(bdVar.getCreateTime());
            this.postNum = bdVar.rI();
            this.agreeNum = bdVar.sZ();
            this.shareNum = bdVar.tb();
            this.hasAgree = bdVar.ta() == 1;
            this.source = bdVar.sX();
            this.title = bdVar.getTitle();
        }
    }

    public VideoAggregationAuthorData getAuthor() {
        return this.author;
    }

    public VideoAggregationVideoData getThreadVideoInfo() {
        return this.video;
    }
}
