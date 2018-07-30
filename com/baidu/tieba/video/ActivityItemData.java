package com.baidu.tieba.video;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ActivityItemData implements Parcelable, Serializable {
    public static final Parcelable.Creator<ActivityItemData> CREATOR = new Parcelable.Creator<ActivityItemData>() { // from class: com.baidu.tieba.video.ActivityItemData.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: u */
        public ActivityItemData createFromParcel(Parcel parcel) {
            return new ActivityItemData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: uw */
        public ActivityItemData[] newArray(int i) {
            return new ActivityItemData[i];
        }
    };
    public String activity_describe;
    public String activity_id;
    public String activity_name;
    public String banner_pic;
    public String link_url;
    public String play_count;
    public String topic_id;
    public ArrayList<UserItemData> user_list;
    public String video_num;

    public ActivityItemData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.activity_id);
        parcel.writeString(this.activity_name);
        parcel.writeString(this.activity_describe);
        parcel.writeString(this.banner_pic);
        parcel.writeString(this.play_count);
        parcel.writeString(this.topic_id);
        parcel.writeString(this.video_num);
        parcel.writeString(this.link_url);
        parcel.writeTypedList(this.user_list);
    }

    protected ActivityItemData(Parcel parcel) {
        this.activity_id = parcel.readString();
        this.activity_name = parcel.readString();
        this.activity_describe = parcel.readString();
        this.banner_pic = parcel.readString();
        this.play_count = parcel.readString();
        this.topic_id = parcel.readString();
        this.video_num = parcel.readString();
        this.link_url = parcel.readString();
        this.user_list = parcel.createTypedArrayList(UserItemData.CREATOR);
    }
}
