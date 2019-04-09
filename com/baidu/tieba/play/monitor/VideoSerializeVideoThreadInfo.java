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
            if (bgVar.YO() != null) {
                videoAggregationAuthorData.userId = bgVar.YO().getUserId();
                videoAggregationAuthorData.userName = bgVar.YO().getUserName();
                videoAggregationAuthorData.userNickname = bgVar.YO().getName_show();
                videoAggregationAuthorData.isBigV = bgVar.YO().isBigV();
                videoAggregationAuthorData.isGod = bgVar.YO().isGod();
                videoAggregationAuthorData.portrait = bgVar.YO().getPortrait();
                videoAggregationAuthorData.hasFocus = bgVar.YO().getIsLike();
            }
            this.author = videoAggregationAuthorData;
            VideoAggregationVideoData videoAggregationVideoData = new VideoAggregationVideoData();
            if (bgVar.Zf() != null) {
                videoAggregationVideoData.thumbnailWidth = String.valueOf(bgVar.Zf().thumbnail_width);
                videoAggregationVideoData.thumbnailHeight = String.valueOf(bgVar.Zf().thumbnail_height);
                videoAggregationVideoData.videoMd5 = bgVar.Zf().video_md5;
                videoAggregationVideoData.videoUrl = bgVar.Zf().video_url;
                videoAggregationVideoData.videoDuration = bgVar.Zf().video_duration.intValue();
                videoAggregationVideoData.videoWidth = String.valueOf(bgVar.Zf().video_width);
                videoAggregationVideoData.videoHeight = String.valueOf(bgVar.Zf().video_height);
                videoAggregationVideoData.videoSize = bgVar.Zf().video_length.intValue();
                videoAggregationVideoData.thumbnailUrl = bgVar.Zf().thumbnail_url;
                videoAggregationVideoData.originVideoUrl = bgVar.Zf().video_url;
                videoAggregationVideoData.mcnLeadPage = bgVar.Zf().mcn_lead_page;
                this.playCount = bgVar.Zf().play_count.intValue();
            }
            this.video = videoAggregationVideoData;
            this.forumId = String.valueOf(bgVar.getFid());
            this.threadId = bgVar.getId();
            if (bgVar.bDI != null) {
                this.forumId = bgVar.bDI.id;
            }
            this.firstPostId = bgVar.Yz();
            this.createTime = String.valueOf(bgVar.getCreateTime());
            this.postNum = bgVar.YF();
            this.agreeNum = bgVar.aah();
            this.disAgreeNum = bgVar.aai();
            this.agreeType = bgVar.aak();
            this.shareNum = bgVar.aal();
            this.hasAgree = bgVar.aaj() == 1;
            this.source = bgVar.aaf();
            this.title = bgVar.getTitle();
            if (bgVar.aaE() != null) {
                this.diffAgreeNum = bgVar.aaE().diffAgreeNum;
                this.agreeType = bgVar.aaE().agreeType;
                this.hasAgree = bgVar.aaE().hasAgree;
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
