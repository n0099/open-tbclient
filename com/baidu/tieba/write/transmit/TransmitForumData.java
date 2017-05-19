package com.baidu.tieba.write.transmit;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class TransmitForumData implements Parcelable, v {
    public boolean aaP;
    public long forumId;
    public String forumName;
    public int type;
    public static final BdUniqueId fOQ = BdUniqueId.gen();
    public static final Parcelable.Creator<TransmitForumData> CREATOR = new g();

    public TransmitForumData(long j, String str, boolean z, int i) {
        this.forumName = str;
        this.aaP = z;
        this.forumId = j;
        this.type = i;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return fOQ;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.forumName);
        parcel.writeLong(this.forumId);
        parcel.writeByte(this.aaP ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.type);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TransmitForumData(Parcel parcel) {
        this.forumName = parcel.readString();
        this.forumId = parcel.readLong();
        this.aaP = parcel.readByte() != 0;
        this.type = parcel.readInt();
    }
}
