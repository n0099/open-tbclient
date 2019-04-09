package com.baidu.tieba.setting.officialAccountPush;

import android.os.Parcel;
import android.os.Parcelable;
import tbclient.GetOfficialSwitch.OfficialList;
/* loaded from: classes3.dex */
public class OfficialAccountPushInfo implements Parcelable {
    public static final Parcelable.Creator<OfficialAccountPushInfo> CREATOR = new Parcelable.Creator<OfficialAccountPushInfo>() { // from class: com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: L */
        public OfficialAccountPushInfo createFromParcel(Parcel parcel) {
            return new OfficialAccountPushInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: yB */
        public OfficialAccountPushInfo[] newArray(int i) {
            return new OfficialAccountPushInfo[i];
        }
    };
    public int iuo;
    public String name;
    public long uid;

    public OfficialAccountPushInfo(Parcel parcel) {
        this.uid = parcel.readLong();
        this.name = parcel.readString();
        this.iuo = parcel.readInt();
    }

    public OfficialAccountPushInfo() {
    }

    public void a(OfficialList officialList) {
        if (officialList != null) {
            this.uid = officialList.uid.longValue();
            this.name = officialList.name;
            this.iuo = officialList.is_on.intValue();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.uid);
        parcel.writeString(this.name);
        parcel.writeInt(this.iuo);
    }
}
