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
            if (bdVar.rP() != null) {
                videoAggregationAuthorData.userId = bdVar.rP().getUserId();
                videoAggregationAuthorData.userName = bdVar.rP().getUserName();
                videoAggregationAuthorData.userNickname = bdVar.rP().getName_show();
                videoAggregationAuthorData.isBigV = bdVar.rP().isBigV();
                videoAggregationAuthorData.isGod = bdVar.rP().isGod();
                videoAggregationAuthorData.portrait = bdVar.rP().getPortrait();
                videoAggregationAuthorData.hasFocus = bdVar.rP().getIsLike();
            }
            this.author = videoAggregationAuthorData;
            VideoAggregationVideoData videoAggregationVideoData = new VideoAggregationVideoData();
            if (bdVar.sg() != null) {
                videoAggregationVideoData.thumbnailWidth = String.valueOf(bdVar.sg().thumbnail_width);
                videoAggregationVideoData.thumbnailHeight = String.valueOf(bdVar.sg().thumbnail_height);
                videoAggregationVideoData.videoMd5 = bdVar.sg().video_md5;
                videoAggregationVideoData.videoUrl = bdVar.sg().video_url;
                videoAggregationVideoData.videoDuration = bdVar.sg().video_duration.intValue();
                videoAggregationVideoData.videoWidth = String.valueOf(bdVar.sg().video_width);
                videoAggregationVideoData.videoHeight = String.valueOf(bdVar.sg().video_height);
                videoAggregationVideoData.videoSize = bdVar.sg().video_length.intValue();
                videoAggregationVideoData.thumbnailUrl = bdVar.sg().thumbnail_url;
                videoAggregationVideoData.originVideoUrl = bdVar.sg().video_url;
                this.playCount = bdVar.sg().play_count.intValue();
            }
            this.video = videoAggregationVideoData;
            this.forumId = String.valueOf(bdVar.getFid());
            this.threadId = bdVar.getId();
            this.firstPostId = bdVar.rD();
            this.createTime = String.valueOf(bdVar.getCreateTime());
            this.postNum = bdVar.rH();
            this.agreeNum = bdVar.sY();
            this.shareNum = bdVar.ta();
            this.hasAgree = bdVar.sZ() == 1;
            this.source = bdVar.sW();
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
