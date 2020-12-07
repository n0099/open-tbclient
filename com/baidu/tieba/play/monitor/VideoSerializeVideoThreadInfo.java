package com.baidu.tieba.play.monitor;

import com.baidu.adp.lib.f.b;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import java.io.Serializable;
import java.util.Map;
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
    public AgreeData mAgreeData;
    public BaijiahaoData mBaijiahaoData;
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
        public BaijiahaoAuthorData baijiahaoData;
        public boolean hasFocus;
        public boolean isBigV;
        public boolean isGod;
        public String portrait;
        public String userId;
        public String userName;
        public String userNickname;

        /* loaded from: classes.dex */
        public static class BaijiahaoAuthorData implements Serializable {
            private static final long serialVersionUID = 7277512143348542714L;
            public String auth_desc;
            public Integer auth_id;
            public String avatar;
            public String avatar_h;
            public String brief;
            public String name;
        }
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

    public void copyFromTransmitThreadData(by byVar) {
        if (byVar != null) {
            OriginalThreadInfo originalThreadInfo = byVar.eLH;
            VideoAggregationAuthorData videoAggregationAuthorData = new VideoAggregationAuthorData();
            if (originalThreadInfo.author != null) {
                videoAggregationAuthorData.userId = String.valueOf(originalThreadInfo.author.id);
                videoAggregationAuthorData.userName = originalThreadInfo.author.name;
                videoAggregationAuthorData.userNickname = originalThreadInfo.author.name_show;
                videoAggregationAuthorData.isBigV = originalThreadInfo.author.tb_vip != null;
                videoAggregationAuthorData.isGod = originalThreadInfo.author.god_data != null;
                videoAggregationAuthorData.portrait = originalThreadInfo.author.portrait;
                videoAggregationAuthorData.hasFocus = originalThreadInfo.author.has_concerned.intValue() != 0;
                if (originalThreadInfo.author.baijiahao_info != null) {
                    videoAggregationAuthorData.baijiahaoData = new VideoAggregationAuthorData.BaijiahaoAuthorData();
                    videoAggregationAuthorData.baijiahaoData.name = originalThreadInfo.author.baijiahao_info.name;
                    videoAggregationAuthorData.baijiahaoData.avatar = originalThreadInfo.author.baijiahao_info.avatar;
                    videoAggregationAuthorData.baijiahaoData.avatar_h = originalThreadInfo.author.baijiahao_info.avatar_h;
                    videoAggregationAuthorData.baijiahaoData.auth_id = originalThreadInfo.author.baijiahao_info.auth_id;
                    videoAggregationAuthorData.baijiahaoData.auth_desc = originalThreadInfo.author.baijiahao_info.auth_desc;
                    videoAggregationAuthorData.baijiahaoData.brief = originalThreadInfo.author.baijiahao_info.brief;
                }
            }
            this.author = videoAggregationAuthorData;
            if (originalThreadInfo.oriUgcInfo != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                baijiahaoData.oriUgcNid = originalThreadInfo.oriUgcInfo.oriUgcNid;
                baijiahaoData.oriUgcTid = originalThreadInfo.oriUgcInfo.oriUgcTid;
                baijiahaoData.oriUgcType = originalThreadInfo.oriUgcInfo.oriUgcType;
                baijiahaoData.oriUgcVid = originalThreadInfo.oriUgcInfo.oriUgcVid;
                baijiahaoData.forwardUrl = originalThreadInfo.oriUgcInfo.forwardUrl;
                this.mBaijiahaoData = baijiahaoData;
            }
            VideoAggregationVideoData videoAggregationVideoData = new VideoAggregationVideoData();
            if (originalThreadInfo != null) {
                videoAggregationVideoData.thumbnailWidth = String.valueOf(originalThreadInfo.videoInfo.thumbnail_width);
                videoAggregationVideoData.thumbnailHeight = String.valueOf(originalThreadInfo.videoInfo.thumbnail_height);
                videoAggregationVideoData.videoMd5 = originalThreadInfo.videoInfo.video_md5;
                videoAggregationVideoData.videoUrl = originalThreadInfo.videoInfo.video_url;
                videoAggregationVideoData.videoDuration = originalThreadInfo.videoInfo.video_duration.intValue();
                videoAggregationVideoData.videoWidth = String.valueOf(originalThreadInfo.videoInfo.video_width);
                videoAggregationVideoData.videoHeight = String.valueOf(originalThreadInfo.videoInfo.video_height);
                videoAggregationVideoData.videoSize = originalThreadInfo.videoInfo.video_length.intValue();
                videoAggregationVideoData.thumbnailUrl = originalThreadInfo.videoInfo.thumbnail_url;
                videoAggregationVideoData.originVideoUrl = originalThreadInfo.videoInfo.video_url;
                videoAggregationVideoData.mcnLeadPage = originalThreadInfo.videoInfo.mcn_lead_page;
                this.playCount = originalThreadInfo.videoInfo.play_count.intValue();
            }
            this.video = videoAggregationVideoData;
            if (byVar.eLS != null) {
                this.forumId = byVar.eLS.id;
            }
            if (originalThreadInfo != null) {
                this.threadId = originalThreadInfo.threadId;
                this.title = originalThreadInfo.showText;
                this.postNum = originalThreadInfo.reply_num.intValue();
            }
            if (originalThreadInfo != null && originalThreadInfo.agree != null) {
                this.agreeNum = originalThreadInfo.agree.agree_num.longValue();
                this.disAgreeNum = originalThreadInfo.agree.disagree_num.longValue();
                this.agreeType = originalThreadInfo.agree.agree_type.intValue();
                this.shareNum = originalThreadInfo.shared_num.intValue();
                this.hasAgree = originalThreadInfo.agree.has_agree.intValue() == 1;
            }
            if (originalThreadInfo != null && originalThreadInfo.agree != null) {
                this.mAgreeData = new AgreeData();
                this.mAgreeData.threadId = this.threadId;
                this.mAgreeData.agreeNum = originalThreadInfo.agree.agree_num.longValue();
                this.mAgreeData.diffAgreeNum = originalThreadInfo.agree.diff_agree_num.longValue();
                this.mAgreeData.disAgreeNum = originalThreadInfo.agree.disagree_num.longValue();
                this.mAgreeData.agreeType = originalThreadInfo.agree.agree_type.intValue();
                this.mAgreeData.hasAgree = originalThreadInfo.agree.has_agree.intValue() == 1;
            }
        }
    }

    public void copyFromFlutterDataMap(Map<String, Object> map) {
        if (map != null && !map.isEmpty()) {
            if (map.get("author") instanceof Map) {
                Map map2 = (Map) map.get("author");
                this.author = new VideoAggregationAuthorData();
                this.author.userId = (String) map2.get("id");
                this.author.userName = (String) map2.get("name");
                this.author.userNickname = (String) map2.get("name_show");
                this.author.portrait = (String) map2.get("portrait");
                this.author.hasFocus = "1".equals(map2.get("has_concerned"));
                if (map2.get("god_data") instanceof Map) {
                    int i = b.toInt((String) ((Map) map2.get("god_data")).get("type"), 0);
                    this.author.isBigV = i == 2 || i == 1;
                    this.author.isGod = i == 2;
                }
                if (map2.get("baijiahao_info") instanceof Map) {
                    Map map3 = (Map) map2.get("baijiahao_info");
                    this.author.baijiahaoData = new VideoAggregationAuthorData.BaijiahaoAuthorData();
                    this.author.baijiahaoData.name = (String) map3.get("name");
                    this.author.baijiahaoData.avatar = (String) map3.get(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
                    this.author.baijiahaoData.auth_id = Integer.valueOf(b.toInt((String) map3.get("auth_id"), 0));
                    this.author.baijiahaoData.auth_desc = (String) map3.get("auth_desc");
                    this.author.baijiahaoData.brief = (String) map3.get(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF);
                }
            }
            if (map.get(Constants.PAGE_BAIJIAHAO_NAME) instanceof Map) {
                Map map4 = (Map) map.get(Constants.PAGE_BAIJIAHAO_NAME);
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                baijiahaoData.oriUgcNid = (String) map4.get("ori_ugc_nid");
                baijiahaoData.oriUgcTid = (String) map4.get("ori_ugc_tid");
                baijiahaoData.oriUgcType = b.toInt((String) map4.get("ori_ugc_type"), 0);
                baijiahaoData.oriUgcVid = (String) map4.get("ori_ugc_vid");
                baijiahaoData.forwardUrl = (String) map4.get("forward_url");
                this.mBaijiahaoData = baijiahaoData;
            }
            VideoAggregationVideoData videoAggregationVideoData = new VideoAggregationVideoData();
            if (map.get(WriteVideoActivityConfig.VIDEO_INFO) instanceof Map) {
                Map map5 = (Map) map.get(WriteVideoActivityConfig.VIDEO_INFO);
                videoAggregationVideoData.thumbnailWidth = String.valueOf(map5.get("thumbnail_width"));
                videoAggregationVideoData.thumbnailHeight = String.valueOf(map5.get("thumbnail_height"));
                videoAggregationVideoData.videoMd5 = (String) map5.get("video_md5");
                videoAggregationVideoData.videoUrl = (String) map5.get("video_url");
                videoAggregationVideoData.videoDuration = b.toInt((String) map5.get("video_duration"), 0);
                videoAggregationVideoData.videoWidth = String.valueOf(map5.get("video_width"));
                videoAggregationVideoData.videoHeight = String.valueOf(map5.get("video_height"));
                videoAggregationVideoData.videoSize = b.toInt((String) map5.get("video_length"), 0);
                videoAggregationVideoData.thumbnailUrl = (String) map5.get("thumbnail_url");
                this.playCount = b.toInt((String) map5.get("play_count"), 0);
            }
            this.video = videoAggregationVideoData;
            this.forumId = String.valueOf(map.get("fid"));
            this.threadId = (String) map.get("tid");
            this.firstPostId = (String) map.get("first_post_id");
            this.createTime = (String) map.get("create_time");
            this.postNum = b.toLong((String) map.get("reply_num"), 0L);
            this.shareNum = b.toLong((String) map.get("share_num"), 0L);
            this.title = (String) map.get("title");
            if (map.get("agree") instanceof Map) {
                Map map6 = (Map) map.get("agree");
                this.agreeNum = b.toLong((String) map6.get("agree_num"), 0L);
                this.disAgreeNum = b.toLong((String) map6.get("disagree_num"), 0L);
                this.agreeType = b.toInt((String) map6.get("agree_type"), 0);
                this.hasAgree = "1".equals(map6.get("has_agree"));
                this.mAgreeData = new AgreeData();
                this.mAgreeData.threadId = this.threadId;
                this.mAgreeData.agreeNum = this.agreeNum;
                this.mAgreeData.diffAgreeNum = b.toLong((String) map6.get("diff_agree_num"), 0L);
                this.mAgreeData.disAgreeNum = this.disAgreeNum;
                this.mAgreeData.agreeType = this.agreeType;
                this.mAgreeData.hasAgree = this.hasAgree;
            }
        }
    }

    public void copyFromThreadInfo(by byVar) {
        if (byVar != null) {
            VideoAggregationAuthorData videoAggregationAuthorData = new VideoAggregationAuthorData();
            if (byVar.boP() != null) {
                videoAggregationAuthorData.userId = byVar.boP().getUserId();
                videoAggregationAuthorData.userName = byVar.boP().getUserName();
                videoAggregationAuthorData.userNickname = byVar.boP().getName_show();
                videoAggregationAuthorData.isBigV = byVar.boP().isBigV();
                videoAggregationAuthorData.isGod = byVar.boP().isGod();
                videoAggregationAuthorData.portrait = byVar.boP().getPortrait();
                videoAggregationAuthorData.hasFocus = byVar.boP().getIsLike();
                if (byVar.boP().getBaijiahaoInfo() != null) {
                    videoAggregationAuthorData.baijiahaoData = new VideoAggregationAuthorData.BaijiahaoAuthorData();
                    videoAggregationAuthorData.baijiahaoData.name = byVar.boP().getBaijiahaoInfo().name;
                    videoAggregationAuthorData.baijiahaoData.avatar = byVar.boP().getBaijiahaoInfo().avatar;
                    videoAggregationAuthorData.baijiahaoData.avatar_h = byVar.boP().getBaijiahaoInfo().avatar_h;
                    videoAggregationAuthorData.baijiahaoData.auth_id = byVar.boP().getBaijiahaoInfo().auth_id;
                    videoAggregationAuthorData.baijiahaoData.auth_desc = byVar.boP().getBaijiahaoInfo().auth_desc;
                    videoAggregationAuthorData.baijiahaoData.brief = byVar.boP().getBaijiahaoInfo().brief;
                }
            }
            this.author = videoAggregationAuthorData;
            if (byVar.getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                baijiahaoData.oriUgcNid = byVar.getBaijiahaoData().oriUgcNid;
                baijiahaoData.oriUgcTid = byVar.getBaijiahaoData().oriUgcTid;
                baijiahaoData.oriUgcType = byVar.getBaijiahaoData().oriUgcType;
                baijiahaoData.oriUgcVid = byVar.getBaijiahaoData().oriUgcVid;
                baijiahaoData.forwardUrl = byVar.getBaijiahaoData().forwardUrl;
                this.mBaijiahaoData = baijiahaoData;
            }
            VideoAggregationVideoData videoAggregationVideoData = new VideoAggregationVideoData();
            if (byVar.bph() != null) {
                videoAggregationVideoData.thumbnailWidth = String.valueOf(byVar.bph().thumbnail_width);
                videoAggregationVideoData.thumbnailHeight = String.valueOf(byVar.bph().thumbnail_height);
                videoAggregationVideoData.videoMd5 = byVar.bph().video_md5;
                videoAggregationVideoData.videoUrl = byVar.bph().video_url;
                videoAggregationVideoData.videoDuration = byVar.bph().video_duration.intValue();
                videoAggregationVideoData.videoWidth = String.valueOf(byVar.bph().video_width);
                videoAggregationVideoData.videoHeight = String.valueOf(byVar.bph().video_height);
                videoAggregationVideoData.videoSize = byVar.bph().video_length.intValue();
                videoAggregationVideoData.thumbnailUrl = byVar.bph().thumbnail_url;
                videoAggregationVideoData.originVideoUrl = byVar.bph().video_url;
                videoAggregationVideoData.mcnLeadPage = byVar.bph().mcn_lead_page;
                this.playCount = byVar.bph().play_count.intValue();
            }
            this.video = videoAggregationVideoData;
            this.forumId = String.valueOf(byVar.getFid());
            this.threadId = byVar.getId();
            if (byVar.eLS != null) {
                this.forumId = byVar.eLS.id;
            }
            this.firstPostId = byVar.boz();
            this.createTime = String.valueOf(byVar.getCreateTime());
            this.postNum = byVar.boG();
            this.agreeNum = byVar.bqp();
            this.disAgreeNum = byVar.bqq();
            this.agreeType = byVar.bqs();
            this.shareNum = byVar.bqt();
            this.hasAgree = byVar.bqr() == 1;
            this.source = byVar.bqn();
            this.title = byVar.getTitle();
            if (byVar.bqI() != null) {
                this.mAgreeData = new AgreeData();
                this.mAgreeData.threadId = byVar.bqI().threadId;
                this.mAgreeData.agreeNum = byVar.bqI().agreeNum;
                this.mAgreeData.diffAgreeNum = byVar.bqI().diffAgreeNum;
                this.mAgreeData.disAgreeNum = byVar.bqI().disAgreeNum;
                this.mAgreeData.agreeType = byVar.bqI().agreeType;
                this.mAgreeData.hasAgree = byVar.bqI().hasAgree;
            }
        }
    }

    public VideoAggregationAuthorData getAuthor() {
        return this.author;
    }

    public VideoAggregationVideoData getThreadVideoInfo() {
        return this.video;
    }

    public BaijiahaoData getBaijiahaoData() {
        return this.mBaijiahaoData;
    }
}
