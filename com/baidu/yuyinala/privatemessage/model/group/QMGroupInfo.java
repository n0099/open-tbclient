package com.baidu.yuyinala.privatemessage.model.group;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.group.GroupInfo;
/* loaded from: classes4.dex */
public class QMGroupInfo implements Parcelable {
    public static final Parcelable.Creator<QMGroupInfo> CREATOR = new Parcelable.Creator<QMGroupInfo>() { // from class: com.baidu.yuyinala.privatemessage.model.group.QMGroupInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: am */
        public QMGroupInfo createFromParcel(Parcel parcel) {
            return new QMGroupInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: OC */
        public QMGroupInfo[] newArray(int i) {
            return new QMGroupInfo[i];
        }
    };
    public String cityCode;
    public String cityName;
    public int gType;
    public String gTypeName;
    public String groupHead;
    public String lat;
    public String lon;
    public GroupInfo mInfo;
    public boolean mIsAdmin;
    public boolean mIsFull;
    private boolean mJoined;
    public int mManagerMaxLimit;
    public int mRole;
    public String posName;
    public String poster;

    public QMGroupInfo(GroupInfo groupInfo) {
        this.cityCode = "";
        this.lat = "";
        this.lon = "";
        this.posName = "";
        this.mRole = -1;
        this.mManagerMaxLimit = 10;
        this.mInfo = groupInfo;
    }

    public QMGroupInfo(Parcel parcel) {
        this.cityCode = "";
        this.lat = "";
        this.lon = "";
        this.posName = "";
        this.mRole = -1;
        this.mManagerMaxLimit = 10;
        this.poster = parcel.readString();
        this.mInfo = (GroupInfo) parcel.readParcelable(GroupInfo.class.getClassLoader());
        this.mIsFull = parcel.readByte() != 0;
        this.mIsAdmin = parcel.readByte() != 0;
        this.mJoined = parcel.readByte() != 0;
        this.gTypeName = parcel.readString();
        this.mRole = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.poster);
        parcel.writeParcelable(this.mInfo, i);
        parcel.writeByte(this.mIsFull ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsAdmin ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mJoined ? (byte) 1 : (byte) 0);
        parcel.writeString(this.gTypeName);
        parcel.writeInt(this.mRole);
    }
}
