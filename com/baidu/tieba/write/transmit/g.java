package com.baidu.tieba.write.transmit;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
class g implements Parcelable.Creator<TransmitForumData> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: n */
    public TransmitForumData createFromParcel(Parcel parcel) {
        return new TransmitForumData(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: sV */
    public TransmitForumData[] newArray(int i) {
        return new TransmitForumData[i];
    }
}
