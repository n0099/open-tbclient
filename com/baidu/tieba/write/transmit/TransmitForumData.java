package com.baidu.tieba.write.transmit;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class TransmitForumData implements Parcelable, v {
    public boolean aaP;
    public String avatar;
    public long forumId;
    public String forumName;
    public boolean ghN;
    public int type;
    public static final BdUniqueId ghM = BdUniqueId.gen();
    public static final Parcelable.Creator<TransmitForumData> CREATOR = new j();

    public TransmitForumData(long j, String str, boolean z, int i) {
        this(j, str, z, i, "");
    }

    public TransmitForumData(long j, String str, boolean z, int i, String str2) {
        this.ghN = false;
        this.forumName = str;
        this.aaP = z;
        this.forumId = j;
        this.type = i;
        this.avatar = str2;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return ghM;
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
        parcel.writeString(this.avatar);
        parcel.writeByte(this.ghN ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TransmitForumData(Parcel parcel) {
        this.ghN = false;
        this.forumName = parcel.readString();
        this.forumId = parcel.readLong();
        this.aaP = parcel.readByte() != 0;
        this.type = parcel.readInt();
        this.avatar = parcel.readString();
        this.ghN = parcel.readByte() != 0;
    }
}
