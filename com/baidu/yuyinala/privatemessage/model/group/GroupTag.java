package com.baidu.yuyinala.privatemessage.model.group;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes10.dex */
public class GroupTag implements Parcelable {
    public static final Parcelable.Creator<GroupTag> CREATOR = new Parcelable.Creator<GroupTag>() { // from class: com.baidu.yuyinala.privatemessage.model.group.GroupTag.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: am */
        public GroupTag createFromParcel(Parcel parcel) {
            return new GroupTag(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: Og */
        public GroupTag[] newArray(int i) {
            return new GroupTag[i];
        }
    };
    public static final int DEFAULT = -1;
    public static final int TC_TAG = 255;
    public String icon;
    public String tag;
    public int type;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeString(this.tag);
        parcel.writeString(this.icon);
    }

    public GroupTag() {
    }

    protected GroupTag(Parcel parcel) {
        this.type = parcel.readInt();
        this.tag = parcel.readString();
        this.icon = parcel.readString();
    }
}
