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
            if (bbVar.zT() != null) {
                videoAggregationAuthorData.userId = bbVar.zT().getUserId();
                videoAggregationAuthorData.userName = bbVar.zT().getUserName();
                videoAggregationAuthorData.userNickname = bbVar.zT().getName_show();
                videoAggregationAuthorData.isBigV = bbVar.zT().isBigV();
                videoAggregationAuthorData.isGod = bbVar.zT().isGod();
                videoAggregationAuthorData.portrait = bbVar.zT().getPortrait();
                videoAggregationAuthorData.hasFocus = bbVar.zT().getIsLike();
            }
            this.author = videoAggregationAuthorData;
            VideoAggregationVideoData videoAggregationVideoData = new VideoAggregationVideoData();
            if (bbVar.Al() != null) {
                videoAggregationVideoData.thumbnailWidth = String.valueOf(bbVar.Al().thumbnail_width);
                videoAggregationVideoData.thumbnailHeight = String.valueOf(bbVar.Al().thumbnail_height);
                videoAggregationVideoData.videoMd5 = bbVar.Al().video_md5;
                videoAggregationVideoData.videoUrl = bbVar.Al().video_url;
                videoAggregationVideoData.videoDuration = bbVar.Al().video_duration.intValue();
                videoAggregationVideoData.videoWidth = String.valueOf(bbVar.Al().video_width);
                videoAggregationVideoData.videoHeight = String.valueOf(bbVar.Al().video_height);
                videoAggregationVideoData.videoSize = bbVar.Al().video_length.intValue();
                videoAggregationVideoData.thumbnailUrl = bbVar.Al().thumbnail_url;
                videoAggregationVideoData.originVideoUrl = bbVar.Al().video_url;
                videoAggregationVideoData.mcnLeadPage = bbVar.Al().mcn_lead_page;
                this.playCount = bbVar.Al().play_count.intValue();
            }
            this.video = videoAggregationVideoData;
            this.forumId = String.valueOf(bbVar.getFid());
            this.threadId = bbVar.getId();
            if (bbVar.awf != null) {
                this.forumId = bbVar.awf.id;
            }
            this.firstPostId = bbVar.zF();
            this.createTime = String.valueOf(bbVar.getCreateTime());
            this.postNum = bbVar.zK();
            this.agreeNum = bbVar.Bf();
            this.disAgreeNum = bbVar.Bg();
            this.agreeType = bbVar.Bi();
            this.shareNum = bbVar.Bj();
            this.hasAgree = bbVar.Bh() == 1;
            this.source = bbVar.Bd();
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
