package com.baidu.tieba.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VideoItemData implements Parcelable, Serializable {
    public static final Parcelable.Creator<VideoItemData> CREATOR = new Parcelable.Creator<VideoItemData>() { // from class: com.baidu.tieba.video.VideoItemData.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: w */
        public VideoItemData createFromParcel(Parcel parcel) {
            return new VideoItemData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: uB */
        public VideoItemData[] newArray(int i) {
            return new VideoItemData[i];
        }
    };
    public static final int TYPE_MORE = 1;
    public static final int TYPE_NOMAL = 0;
    public ActivityItemData act_info;
    public String agree_num;
    public UserItemData author_info;
    public String comment_num;
    public int discoverType;
    public String forum_id;
    public String forum_name;
    public String is_agreed;
    public String is_deleted;
    public String is_private;
    public String mMd5;
    public String mRecomAbTag;
    public String mRecomExtra;
    public String mRecomSource;
    public String mRecomWeight;
    public String mark_id;
    public String play_count;
    public String post_id;
    public String share_num;
    public String tags;
    public String thread_id;
    public String thumbnail_height;
    public String thumbnail_url;
    public String thumbnail_width;
    public String title;
    public String video_duration;
    public String video_height;
    public String video_length;
    public String video_log_id;
    public String video_url;
    public String video_width;

    public VideoItemData() {
        this.discoverType = 0;
    }

    public VideoItemData buildWithThreadData(bc bcVar) {
        if (bcVar != null) {
            this.thread_id = bcVar.getTid();
            this.post_id = bcVar.vi();
            if (bcVar.vN() != null) {
                this.thumbnail_url = bcVar.vN().thumbnail_url;
                this.video_url = bcVar.vN().video_url;
                this.video_height = String.valueOf(bcVar.vN().video_height);
                this.video_width = String.valueOf(bcVar.vN().video_width);
                this.mMd5 = bcVar.vN().video_md5;
            }
            this.comment_num = String.valueOf(bcVar.vn());
            this.agree_num = String.valueOf(bcVar.wF());
            this.share_num = String.valueOf(bcVar.wH());
            this.title = bcVar.getTitle();
            this.forum_id = String.valueOf(bcVar.getFid());
            this.forum_name = bcVar.vB();
            this.is_agreed = String.valueOf(bcVar.wG());
            if (bcVar.vw() != null) {
                UserItemData userItemData = new UserItemData();
                userItemData.user_name = bcVar.vw().getUserName();
                userItemData.name_show = bcVar.vw().getName_show();
                userItemData.portrait = bcVar.vw().getPortrait();
                userItemData.user_id = bcVar.vw().getUserId();
                userItemData.is_follow = bcVar.vw().hadConcerned() ? "1" : "0";
                this.author_info = userItemData;
            }
            this.act_info = bcVar.wc();
            this.mRecomAbTag = bcVar.mRecomAbTag;
            this.mRecomSource = bcVar.mRecomSource;
            this.mRecomWeight = bcVar.mRecomWeight;
            this.mRecomExtra = bcVar.mRecomExtra;
        }
        return this;
    }

    public void parseJson(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.thread_id = jSONObject.optString("thread_id");
                this.post_id = jSONObject.optString("first_post_id");
                JSONObject optJSONObject = jSONObject.optJSONObject("video");
                if (optJSONObject != null) {
                    this.thumbnail_url = optJSONObject.optString("thumbnail_url");
                    this.video_url = optJSONObject.optString(WebVideoActivityConfig.KEY_VIDEO_URL);
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
                    userItemData.portrait = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    userItemData.user_id = optJSONObject2.optString("user_id");
                    userItemData.is_follow = optJSONObject2.optString(AddFriendActivityConfig.TYPE_FOCUS);
                    this.author_info = userItemData;
                }
                this.mRecomAbTag = jSONObject.optString("abtest_tag");
                this.mRecomSource = jSONObject.optString("source");
                this.mRecomWeight = jSONObject.optString("weight");
                this.mRecomExtra = jSONObject.optString("extra");
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
        parcel.writeString(this.forum_name);
        parcel.writeString(this.mark_id);
        parcel.writeString(this.thread_id);
        parcel.writeString(this.post_id);
        parcel.writeString(this.video_log_id);
        parcel.writeString(this.video_url);
        parcel.writeString(this.video_width);
        parcel.writeString(this.video_height);
        parcel.writeString(this.video_length);
        parcel.writeString(this.video_duration);
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
        parcel.writeString(this.play_count);
        parcel.writeParcelable(this.author_info, i);
        parcel.writeParcelable(this.act_info, i);
        parcel.writeInt(this.discoverType);
        parcel.writeString(this.mRecomSource);
        parcel.writeString(this.mRecomAbTag);
        parcel.writeString(this.mRecomWeight);
        parcel.writeString(this.mMd5);
        parcel.writeString(this.mRecomExtra);
    }

    protected VideoItemData(Parcel parcel) {
        this.discoverType = 0;
        this.forum_id = parcel.readString();
        this.forum_name = parcel.readString();
        this.mark_id = parcel.readString();
        this.thread_id = parcel.readString();
        this.post_id = parcel.readString();
        this.video_log_id = parcel.readString();
        this.video_url = parcel.readString();
        this.video_width = parcel.readString();
        this.video_height = parcel.readString();
        this.video_length = parcel.readString();
        this.video_duration = parcel.readString();
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
        this.play_count = parcel.readString();
        this.author_info = (UserItemData) parcel.readParcelable(UserItemData.class.getClassLoader());
        this.act_info = (ActivityItemData) parcel.readParcelable(ActivityItemData.class.getClassLoader());
        this.discoverType = parcel.readInt();
        this.mRecomSource = parcel.readString();
        this.mRecomAbTag = parcel.readString();
        this.mRecomWeight = parcel.readString();
        this.mMd5 = parcel.readString();
        this.mRecomExtra = parcel.readString();
    }
}
