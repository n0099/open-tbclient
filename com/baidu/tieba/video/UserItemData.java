package com.baidu.tieba.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class UserItemData implements Parcelable {
    public static final Parcelable.Creator<UserItemData> CREATOR = new Parcelable.Creator<UserItemData>() { // from class: com.baidu.tieba.video.UserItemData.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: W */
        public UserItemData createFromParcel(Parcel parcel) {
            return new UserItemData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: AK */
        public UserItemData[] newArray(int i) {
            return new UserItemData[i];
        }
    };
    public String agree_num;
    public String fans_num;
    public String intro;
    public String is_follow;
    public String jwr;
    public String jws;
    public String jwt;
    public String jwu;
    public String name_show;
    public String portrait;
    public String user_id;
    public String user_name;
    public String video_num;

    public String csx() {
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
        parcel.writeString(this.jwr);
        parcel.writeString(this.jws);
        parcel.writeString(this.fans_num);
        parcel.writeString(this.video_num);
        parcel.writeString(this.agree_num);
        parcel.writeString(this.intro);
        parcel.writeString(this.jwt);
        parcel.writeString(this.jwu);
        parcel.writeString(this.is_follow);
    }

    public UserItemData() {
    }

    protected UserItemData(Parcel parcel) {
        this.user_id = parcel.readString();
        this.user_name = parcel.readString();
        this.name_show = parcel.readString();
        this.portrait = parcel.readString();
        this.jwr = parcel.readString();
        this.jws = parcel.readString();
        this.fans_num = parcel.readString();
        this.video_num = parcel.readString();
        this.agree_num = parcel.readString();
        this.intro = parcel.readString();
        this.jwt = parcel.readString();
        this.jwu = parcel.readString();
        this.is_follow = parcel.readString();
    }
}
