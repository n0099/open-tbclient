package com.baidu.tieba.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class UserItemData implements Parcelable {
    public static final Parcelable.Creator<UserItemData> CREATOR = new Parcelable.Creator<UserItemData>() { // from class: com.baidu.tieba.video.UserItemData.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: aa */
        public UserItemData createFromParcel(Parcel parcel) {
            return new UserItemData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: Ed */
        public UserItemData[] newArray(int i) {
            return new UserItemData[i];
        }
    };
    public String agree_num;
    public String bjhAvatar;
    public String fans_num;
    public String favor_num;
    public String follow_num;
    public String gender;
    public String intro;
    public String is_fans;
    public String is_follow;
    public String name_show;
    public String portrait;
    public String user_id;
    public String user_name;
    public String video_num;

    public String dar() {
        return !TextUtils.isEmpty(this.name_show) ? this.name_show : this.user_name;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.user_id);
        parcel.writeString(this.user_name);
        parcel.writeString(this.name_show);
        parcel.writeString(this.portrait);
        parcel.writeString(this.gender);
        parcel.writeString(this.follow_num);
        parcel.writeString(this.fans_num);
        parcel.writeString(this.video_num);
        parcel.writeString(this.agree_num);
        parcel.writeString(this.intro);
        parcel.writeString(this.favor_num);
        parcel.writeString(this.is_fans);
        parcel.writeString(this.is_follow);
        parcel.writeString(this.bjhAvatar);
    }

    public UserItemData() {
    }

    protected UserItemData(Parcel parcel) {
        this.user_id = parcel.readString();
        this.user_name = parcel.readString();
        this.name_show = parcel.readString();
        this.portrait = parcel.readString();
        this.gender = parcel.readString();
        this.follow_num = parcel.readString();
        this.fans_num = parcel.readString();
        this.video_num = parcel.readString();
        this.agree_num = parcel.readString();
        this.intro = parcel.readString();
        this.favor_num = parcel.readString();
        this.is_fans = parcel.readString();
        this.is_follow = parcel.readString();
        this.bjhAvatar = parcel.readString();
    }
}
