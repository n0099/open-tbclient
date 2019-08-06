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
            if (bhVar.aey() != null) {
                videoAggregationAuthorData.userId = bhVar.aey().getUserId();
                videoAggregationAuthorData.userName = bhVar.aey().getUserName();
                videoAggregationAuthorData.userNickname = bhVar.aey().getName_show();
                videoAggregationAuthorData.isBigV = bhVar.aey().isBigV();
                videoAggregationAuthorData.isGod = bhVar.aey().isGod();
                videoAggregationAuthorData.portrait = bhVar.aey().getPortrait();
                videoAggregationAuthorData.hasFocus = bhVar.aey().getIsLike();
            }
            this.author = videoAggregationAuthorData;
            VideoAggregationVideoData videoAggregationVideoData = new VideoAggregationVideoData();
            if (bhVar.aeP() != null) {
                videoAggregationVideoData.thumbnailWidth = String.valueOf(bhVar.aeP().thumbnail_width);
                videoAggregationVideoData.thumbnailHeight = String.valueOf(bhVar.aeP().thumbnail_height);
                videoAggregationVideoData.videoMd5 = bhVar.aeP().video_md5;
                videoAggregationVideoData.videoUrl = bhVar.aeP().video_url;
                videoAggregationVideoData.videoDuration = bhVar.aeP().video_duration.intValue();
                videoAggregationVideoData.videoWidth = String.valueOf(bhVar.aeP().video_width);
                videoAggregationVideoData.videoHeight = String.valueOf(bhVar.aeP().video_height);
                videoAggregationVideoData.videoSize = bhVar.aeP().video_length.intValue();
                videoAggregationVideoData.thumbnailUrl = bhVar.aeP().thumbnail_url;
                videoAggregationVideoData.originVideoUrl = bhVar.aeP().video_url;
                videoAggregationVideoData.mcnLeadPage = bhVar.aeP().mcn_lead_page;
                this.playCount = bhVar.aeP().play_count.intValue();
            }
            this.video = videoAggregationVideoData;
            this.forumId = String.valueOf(bhVar.getFid());
            this.threadId = bhVar.getId();
            if (bhVar.bMf != null) {
                this.forumId = bhVar.bMf.id;
            }
            this.firstPostId = bhVar.aej();
            this.createTime = String.valueOf(bhVar.getCreateTime());
            this.postNum = bhVar.aep();
            this.agreeNum = bhVar.afR();
            this.disAgreeNum = bhVar.afS();
            this.agreeType = bhVar.afU();
            this.shareNum = bhVar.afV();
            this.hasAgree = bhVar.afT() == 1;
            this.source = bhVar.afP();
            this.title = bhVar.getTitle();
            if (bhVar.ago() != null) {
                this.diffAgreeNum = bhVar.ago().diffAgreeNum;
                this.agreeType = bhVar.ago().agreeType;
                this.hasAgree = bhVar.ago().hasAgree;
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
