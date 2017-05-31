package com.baidu.tieba.write.transmit;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class TransmitForumData implements Parcelable, v {
    public boolean aaO;
    public long forumId;
    public String forumName;
    public int type;
    public static final BdUniqueId fWM = BdUniqueId.gen();
    public static final Parcelable.Creator<TransmitForumData> CREATOR = new g();

    public TransmitForumData(long j, String str, boolean z, int i) {
        this.forumName = str;
        this.aaO = z;
        this.forumId = j;
        this.type = i;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return fWM;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.forumName);
        parcel.writeLong(this.forumId);
        parcel.writeByte(this.aaO ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.type);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TransmitForumData(Parcel parcel) {
        this.forumName = parcel.readString();
        this.forumId = parcel.readLong();
        this.aaO = parcel.readByte() != 0;
        this.type = parcel.readInt();
    }
}
