package com.baidu.tieba.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bk;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VideoItemData implements Parcelable, b, Serializable {
    public static final Parcelable.Creator<VideoItemData> CREATOR = new Parcelable.Creator<VideoItemData>() { // from class: com.baidu.tieba.video.VideoItemData.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: ab */
        public VideoItemData createFromParcel(Parcel parcel) {
            return new VideoItemData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: ER */
        public VideoItemData[] newArray(int i) {
            return new VideoItemData[i];
        }
    };
    public static final int TYPE_MORE = 1;
    public static final int TYPE_NOMAL = 0;
    public static final int VIDEO_TYPE_BJH = 3;
    public static final int VIDEO_TYPE_DYNAMIC = 2;
    public static final int VIDEO_TYPE_NORMAL = 1;
    public ActivityItemData act_info;
    public String agree_num;
    public UserItemData author_info;
    public BaijiahaoData baijiahaoData;
    public String comment_num;
    public int discoverType;
    public boolean forbidComment;
    public String forum_id;
    public String forum_name;
    public boolean isBjhVideo;
    public boolean isTitleExpanded;
    public int isVerticalVideo;
    public String is_agreed;
    public String is_deleted;
    public String is_private;
    public String mMd5;
    public String mRecomAbTag;
    public String mRecomExtra;
    public String mRecomSource;
    public String mRecomWeight;
    private long mVideoWatchDuration;
    public String mark_id;
    public String nid;
    public String noCommetStr;
    public int play_count;
    public String post_id;
    public String share_num;
    public String tags;
    public String thread_id;
    public String thumbnail_height;
    public String thumbnail_url;
    public String thumbnail_width;
    public String title;
    public int video_duration;
    public String video_height;
    public String video_length;
    public String video_log_id;
    public String video_url;
    public String video_width;

    public VideoItemData() {
        this.isBjhVideo = false;
        this.forbidComment = false;
        this.discoverType = 0;
        this.isTitleExpanded = false;
    }

    @Override // com.baidu.tieba.video.b
    public long getVideoWatchDuration() {
        return this.mVideoWatchDuration;
    }

    @Override // com.baidu.tieba.video.b
    public void setVideoWatchDuration(long j) {
        this.mVideoWatchDuration = j;
    }

    @Override // com.baidu.tieba.video.b
    public String getThreadId() {
        return this.thread_id;
    }

    public VideoItemData buildWithThreadData(bk bkVar) {
        if (bkVar != null) {
            this.thread_id = bkVar.getTid();
            this.nid = bkVar.getNid();
            this.post_id = bkVar.aQh();
            if (bkVar.aQQ() != null) {
                this.thumbnail_url = bkVar.aQQ().thumbnail_url;
                this.video_url = bkVar.aQQ().video_url;
                this.video_height = String.valueOf(bkVar.aQQ().video_height);
                this.video_width = String.valueOf(bkVar.aQQ().video_width);
                this.mMd5 = bkVar.aQQ().video_md5;
                this.video_duration = bkVar.aQQ().video_duration.intValue();
                this.play_count = bkVar.aQQ().play_count.intValue();
                this.isVerticalVideo = bkVar.aQQ().is_vertical.intValue();
            }
            this.comment_num = String.valueOf(bkVar.aQo());
            this.agree_num = String.valueOf(bkVar.aRW());
            this.share_num = String.valueOf(bkVar.aSa());
            this.title = bkVar.getTitle();
            this.forum_id = String.valueOf(bkVar.getFid());
            this.baijiahaoData = bkVar.getBaijiahaoData();
            this.forum_name = bkVar.aQC();
            this.is_agreed = String.valueOf(bkVar.aRY());
            if (bkVar.aQx() != null) {
                UserItemData userItemData = new UserItemData();
                userItemData.user_name = bkVar.aQx().getUserName();
                userItemData.name_show = bkVar.aQx().getName_show();
                userItemData.portrait = bkVar.aQx().getPortrait();
                userItemData.user_id = bkVar.aQx().getUserId();
                userItemData.is_follow = bkVar.aQx().hadConcerned() ? "1" : "0";
                if (bkVar.aQx().getBaijiahaoInfo() != null) {
                    userItemData.bjhAvatar = bkVar.aQx().getBaijiahaoInfo().avatar;
                }
                this.author_info = userItemData;
            }
            this.act_info = bkVar.aPj();
            this.mRecomAbTag = bkVar.mRecomAbTag;
            this.mRecomSource = bkVar.mRecomSource;
            this.mRecomWeight = bkVar.mRecomWeight;
            this.mRecomExtra = bkVar.mRecomExtra;
            this.isBjhVideo = bkVar.aSx();
            this.forbidComment = bkVar.forbidComment;
            this.noCommetStr = bkVar.noCommetStr;
        }
        return this;
    }

    public int getVideoType() {
        if (this.baijiahaoData == null) {
            return 1;
        }
        if (this.baijiahaoData.oriUgcType == 2) {
            return 3;
        }
        return this.baijiahaoData.oriUgcType == 4 ? 2 : 1;
    }

    public VideoItemData buildWithOriginThreadData(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            this.thread_id = originalThreadInfo.threadId;
            this.post_id = originalThreadInfo.postId;
            if (originalThreadInfo.videoInfo != null) {
                this.thumbnail_url = originalThreadInfo.videoInfo.thumbnail_url;
                this.video_url = originalThreadInfo.videoInfo.video_url;
                this.video_height = String.valueOf(originalThreadInfo.videoInfo.video_height);
                this.video_width = String.valueOf(originalThreadInfo.videoInfo.video_width);
                this.mMd5 = originalThreadInfo.videoInfo.video_md5;
                this.video_duration = originalThreadInfo.videoInfo.video_duration.intValue();
                this.play_count = originalThreadInfo.videoInfo.play_count.intValue();
                this.isVerticalVideo = originalThreadInfo.videoInfo.is_vertical.intValue();
            }
            this.comment_num = String.valueOf(originalThreadInfo.reply_num);
            this.agree_num = String.valueOf(originalThreadInfo.agree.agree_num);
            this.share_num = String.valueOf(originalThreadInfo.shared_num);
            this.title = originalThreadInfo.title;
            if (TextUtils.isEmpty(this.title)) {
                this.title = originalThreadInfo.showText;
            }
            this.forum_id = String.valueOf(originalThreadInfo.forumId);
            this.baijiahaoData = originalThreadInfo.oriUgcInfo;
            this.forum_name = originalThreadInfo.forumName;
            this.is_agreed = String.valueOf(originalThreadInfo.agree.has_agree);
            if (originalThreadInfo.author != null) {
                UserItemData userItemData = new UserItemData();
                userItemData.user_name = originalThreadInfo.author.name;
                userItemData.name_show = originalThreadInfo.author.name_show;
                userItemData.portrait = originalThreadInfo.author.portrait;
                userItemData.user_id = String.valueOf(originalThreadInfo.author.id);
                userItemData.is_follow = String.valueOf(originalThreadInfo.author.has_concerned);
                if (originalThreadInfo.author.baijiahao_info != null) {
                    userItemData.bjhAvatar = originalThreadInfo.author.baijiahao_info.avatar;
                }
                this.author_info = userItemData;
            }
            this.act_info = originalThreadInfo.aPj();
            this.isBjhVideo = originalThreadInfo.aPn();
        }
        return this;
    }

    public void parseJson(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.thread_id = jSONObject.optString("thread_id");
                this.nid = jSONObject.optString("nid");
                this.post_id = jSONObject.optString("first_post_id");
                JSONObject optJSONObject = jSONObject.optJSONObject("video");
                if (optJSONObject != null) {
                    this.thumbnail_url = optJSONObject.optString("thumbnail_url");
                    this.video_url = optJSONObject.optString("video_url");
                    this.video_height = optJSONObject.optString("video_height");
                    this.video_width = optJSONObject.optString("video_width");
                    this.mMd5 = optJSONObject.optString("video_md5");
                }
                this.comment_num = jSONObject.optString("post_num");
                this.agree_num = jSONObject.optString("agree_num");
                this.share_num = jSONObject.optString("share_num");
                this.title = jSONObject.optString("title");
                this.forum_id = jSONObject.optString("forum_id");
                this.is_agreed = jSONObject.optString("has_agree");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("author");
                if (optJSONObject2 != null) {
                    UserItemData userItemData = new UserItemData();
                    userItemData.user_name = optJSONObject2.optString("user_name");
                    userItemData.name_show = optJSONObject2.optString("user_nickname");
                    userItemData.portrait = optJSONObject2.optString("portrait");
                    userItemData.user_id = optJSONObject2.optString("user_id");
                    userItemData.is_follow = optJSONObject2.optString(AddFriendActivityConfig.TYPE_FOCUS);
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("baijiahao_info");
                    if (optJSONObject3 != null) {
                        userItemData.bjhAvatar = optJSONObject3.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
                    }
                    this.author_info = userItemData;
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
                if (optJSONObject4 != null) {
                    this.baijiahaoData = new BaijiahaoData();
                    this.baijiahaoData.parseJson(optJSONObject4);
                }
                this.mRecomAbTag = jSONObject.optString("abtest_tag");
                this.mRecomSource = jSONObject.optString("source");
                this.mRecomWeight = jSONObject.optString("weight");
                this.mRecomExtra = jSONObject.optString("extra");
                this.forbidComment = jSONObject.optInt("if_comment", 0) == 1;
                this.noCommetStr = jSONObject.optString("if_comment_info");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.forum_id);
        parcel.writeSerializable(this.baijiahaoData);
        parcel.writeString(this.forum_name);
        parcel.writeString(this.mark_id);
        parcel.writeString(this.thread_id);
        parcel.writeString(this.nid);
        parcel.writeString(this.post_id);
        parcel.writeString(this.video_log_id);
        parcel.writeString(this.video_url);
        parcel.writeString(this.video_width);
        parcel.writeString(this.video_height);
        parcel.writeString(this.video_length);
        parcel.writeInt(this.video_duration);
        parcel.writeString(this.thumbnail_url);
        parcel.writeString(this.thumbnail_width);
        parcel.writeString(this.thumbnail_height);
        parcel.writeString(this.tags);
        parcel.writeString(this.title);
        parcel.writeString(this.is_deleted);
        parcel.writeString(this.is_private);
        parcel.writeString(this.is_agreed);
        parcel.writeString(this.agree_num);
        parcel.writeString(this.share_num);
        parcel.writeString(this.comment_num);
        parcel.writeInt(this.play_count);
        parcel.writeInt(this.isVerticalVideo);
        parcel.writeParcelable(this.author_info, i);
        parcel.writeParcelable(this.act_info, i);
        parcel.writeInt(this.discoverType);
        parcel.writeString(this.mRecomSource);
        parcel.writeString(this.mRecomAbTag);
        parcel.writeString(this.mRecomWeight);
        parcel.writeString(this.mMd5);
        parcel.writeString(this.mRecomExtra);
        parcel.writeInt(this.isBjhVideo ? 1 : 0);
        parcel.writeInt(this.isTitleExpanded ? 1 : 0);
    }

    protected VideoItemData(Parcel parcel) {
        this.isBjhVideo = false;
        this.forbidComment = false;
        this.discoverType = 0;
        this.isTitleExpanded = false;
        this.forum_id = parcel.readString();
        this.baijiahaoData = (BaijiahaoData) parcel.readSerializable();
        this.forum_name = parcel.readString();
        this.mark_id = parcel.readString();
        this.thread_id = parcel.readString();
        this.nid = parcel.readString();
        this.post_id = parcel.readString();
        this.video_log_id = parcel.readString();
        this.video_url = parcel.readString();
        this.video_width = parcel.readString();
        this.video_height = parcel.readString();
        this.video_length = parcel.readString();
        this.video_duration = parcel.readInt();
        this.thumbnail_url = parcel.readString();
        this.thumbnail_width = parcel.readString();
        this.thumbnail_height = parcel.readString();
        this.tags = parcel.readString();
        this.title = parcel.readString();
        this.is_deleted = parcel.readString();
        this.is_private = parcel.readString();
        this.is_agreed = parcel.readString();
        this.agree_num = parcel.readString();
        this.share_num = parcel.readString();
        this.comment_num = parcel.readString();
        this.play_count = parcel.readInt();
        this.isVerticalVideo = parcel.readInt();
        this.author_info = (UserItemData) parcel.readParcelable(UserItemData.class.getClassLoader());
        this.act_info = (ActivityItemData) parcel.readParcelable(ActivityItemData.class.getClassLoader());
        this.discoverType = parcel.readInt();
        this.mRecomSource = parcel.readString();
        this.mRecomAbTag = parcel.readString();
        this.mRecomWeight = parcel.readString();
        this.mMd5 = parcel.readString();
        this.mRecomExtra = parcel.readString();
        this.isBjhVideo = parcel.readInt() == 1;
        this.isTitleExpanded = parcel.readInt() == 1;
    }
}
