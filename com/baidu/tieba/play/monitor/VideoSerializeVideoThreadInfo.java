package com.baidu.tieba.play.monitor;

import com.baidu.tbadk.core.data.bc;
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

    public void copyFromThreadInfo(bc bcVar) {
        if (bcVar != null) {
            VideoAggregationAuthorData videoAggregationAuthorData = new VideoAggregationAuthorData();
            if (bcVar.vw() != null) {
                videoAggregationAuthorData.userId = bcVar.vw().getUserId();
                videoAggregationAuthorData.userName = bcVar.vw().getUserName();
                videoAggregationAuthorData.userNickname = bcVar.vw().getName_show();
                videoAggregationAuthorData.isBigV = bcVar.vw().isBigV();
                videoAggregationAuthorData.isGod = bcVar.vw().isGod();
                videoAggregationAuthorData.portrait = bcVar.vw().getPortrait();
                videoAggregationAuthorData.hasFocus = bcVar.vw().getIsLike();
            }
            this.author = videoAggregationAuthorData;
            VideoAggregationVideoData videoAggregationVideoData = new VideoAggregationVideoData();
            if (bcVar.vN() != null) {
                videoAggregationVideoData.thumbnailWidth = String.valueOf(bcVar.vN().thumbnail_width);
                videoAggregationVideoData.thumbnailHeight = String.valueOf(bcVar.vN().thumbnail_height);
                videoAggregationVideoData.videoMd5 = bcVar.vN().video_md5;
                videoAggregationVideoData.videoUrl = bcVar.vN().video_url;
                videoAggregationVideoData.videoDuration = bcVar.vN().video_duration.intValue();
                videoAggregationVideoData.videoWidth = String.valueOf(bcVar.vN().video_width);
                videoAggregationVideoData.videoHeight = String.valueOf(bcVar.vN().video_height);
                videoAggregationVideoData.videoSize = bcVar.vN().video_length.intValue();
                videoAggregationVideoData.thumbnailUrl = bcVar.vN().thumbnail_url;
                videoAggregationVideoData.originVideoUrl = bcVar.vN().video_url;
                this.playCount = bcVar.vN().play_count.intValue();
            }
            this.video = videoAggregationVideoData;
            this.forumId = String.valueOf(bcVar.getFid());
            this.threadId = bcVar.getId();
            if (bcVar.akt != null) {
                this.forumId = bcVar.akt.id;
            }
            this.firstPostId = bcVar.vi();
            this.createTime = String.valueOf(bcVar.getCreateTime());
            this.postNum = bcVar.vn();
            this.agreeNum = bcVar.wF();
            this.shareNum = bcVar.wH();
            this.hasAgree = bcVar.wG() == 1;
            this.source = bcVar.wD();
            this.title = bcVar.getTitle();
        }
    }

    public VideoAggregationAuthorData getAuthor() {
        return this.author;
    }

    public VideoAggregationVideoData getThreadVideoInfo() {
        return this.video;
    }
}
