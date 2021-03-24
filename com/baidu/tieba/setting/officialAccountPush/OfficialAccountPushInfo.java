package com.baidu.tieba.setting.officialAccountPush;

import android.os.Parcel;
import android.os.Parcelable;
import tbclient.GetOfficialSwitch.OfficialList;
/* loaded from: classes5.dex */
public class OfficialAccountPushInfo implements Parcelable {
    public static final Parcelable.Creator<OfficialAccountPushInfo> CREATOR = new a();
    public int is_on;
    public String name;
    public long uid;

    /* loaded from: classes5.dex */
    public static class a implements Parcelable.Creator<OfficialAccountPushInfo> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public OfficialAccountPushInfo createFromParcel(Parcel parcel) {
            return new OfficialAccountPushInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public OfficialAccountPushInfo[] newArray(int i) {
            return new OfficialAccountPushInfo[i];
        }
    }

    public OfficialAccountPushInfo(Parcel parcel) {
        this.uid = parcel.readLong();
        this.name = parcel.readString();
        this.is_on = parcel.readInt();
    }

    public void a(OfficialList officialList) {
        if (officialList == null) {
            return;
        }
        this.uid = officialList.uid.longValue();
        this.name = officialList.name;
        this.is_on = officialList.is_on.intValue();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.uid);
        parcel.writeString(this.name);
        parcel.writeInt(this.is_on);
    }

    public OfficialAccountPushInfo() {
    }
}
