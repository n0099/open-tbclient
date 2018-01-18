package com.baidu.tieba.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.tbadk.core.data.bd;
import java.io.Serializable;
/* loaded from: classes.dex */
public class VideoItemData implements Parcelable, Serializable {
    public static final Parcelable.Creator<VideoItemData> CREATOR = new Parcelable.Creator<VideoItemData>() { // from class: com.baidu.tieba.video.VideoItemData.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: I */
        public VideoItemData createFromParcel(Parcel parcel) {
            return new VideoItemData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: wF */
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
    }

    public VideoItemData buildWithThreadData(bd bdVar) {
        if (bdVar != null) {
            this.thread_id = bdVar.getTid();
            this.post_id = bdVar.yG();
            if (bdVar.zk() != null) {
                this.thumbnail_url = bdVar.zk().thumbnail_url;
                this.video_url = bdVar.zk().video_url;
                this.video_height = String.valueOf(bdVar.zk().video_height);
                this.video_width = String.valueOf(bdVar.zk().video_width);
                this.mMd5 = bdVar.zk().video_md5;
            }
            this.comment_num = String.valueOf(bdVar.yK());
            this.agree_num = String.valueOf(bdVar.Ad());
            this.share_num = String.valueOf(bdVar.Af());
            this.title = bdVar.getTitle();
            this.forum_id = String.valueOf(bdVar.getFid());
            this.forum_name = bdVar.yY();
            this.is_agreed = String.valueOf(bdVar.Ae());
            if (bdVar.yS() != null) {
                UserItemData userItemData = new UserItemData();
                userItemData.user_name = bdVar.yS().getUserName();
                userItemData.name_show = bdVar.yS().getName_show();
                userItemData.portrait = bdVar.yS().getPortrait();
                userItemData.user_id = bdVar.yS().getUserId();
                userItemData.is_follow = bdVar.yS().hadConcerned() ? "1" : "0";
                this.author_info = userItemData;
            }
            this.act_info = bdVar.zA();
            this.mRecomAbTag = bdVar.mRecomAbTag;
            this.mRecomSource = bdVar.mRecomSource;
            this.mRecomWeight = bdVar.mRecomWeight;
        }
        return this;
    }
}
