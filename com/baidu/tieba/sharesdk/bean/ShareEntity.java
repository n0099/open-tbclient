package com.baidu.tieba.sharesdk.bean;

import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes5.dex */
public class ShareEntity implements Parcelable {
    public static final Parcelable.Creator<ShareEntity> CREATOR = new a();
    public String content;
    public Bundle diskPicOperate;
    public String extLiveInfo;
    public String fName;
    public Uri imageUri;
    public boolean isVideoThread;
    public String linkUrl;
    public String localFile;
    public Location location;
    public long readCount;
    public int shareTo;
    public int shareType;
    public Bundle stats;
    public String taskCompleteId;
    public String tid;
    public String title;
    public String topic;
    public String videoUrl;
    public int typeShareToSmallApp = 0;
    public boolean canShareBySmartApp = true;

    /* loaded from: classes5.dex */
    public static class a implements Parcelable.Creator<ShareEntity> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareEntity createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            ShareEntity shareEntity = new ShareEntity();
            shareEntity.E(parcel.readString());
            shareEntity.s(parcel.readString());
            shareEntity.w(parcel.readString());
            shareEntity.x(parcel.readString());
            shareEntity.B(parcel.readInt());
            shareEntity.G(parcel.readString());
            shareEntity.u((Uri) parcel.readParcelable(Uri.class.getClassLoader()));
            shareEntity.y((Location) parcel.readParcelable(Location.class.getClassLoader()));
            shareEntity.C(parcel.readBundle());
            shareEntity.z(parcel.readInt());
            shareEntity.D(parcel.readString());
            shareEntity.F(parcel.readInt());
            shareEntity.H(parcel.readString());
            shareEntity.topic = parcel.readString();
            shareEntity.taskCompleteId = parcel.readString();
            shareEntity.diskPicOperate = parcel.readBundle();
            shareEntity.canShareBySmartApp = parcel.readByte() == 1;
            shareEntity.A(parcel.readLong());
            shareEntity.v(parcel.readByte() == 1);
            shareEntity.extLiveInfo = parcel.readString();
            return shareEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ShareEntity[] newArray(int i2) {
            return new ShareEntity[i2];
        }
    }

    public void A(long j) {
        this.readCount = j;
    }

    public void B(int i2) {
        this.shareTo = i2;
    }

    public void C(Bundle bundle) {
        this.stats = bundle;
    }

    public void D(String str) {
        this.tid = str;
    }

    public void E(String str) {
        this.title = str;
    }

    public void F(int i2) {
        this.typeShareToSmallApp = i2;
    }

    public void G(String str) {
        this.videoUrl = str;
    }

    public void H(String str) {
        this.fName = str;
    }

    public String b() {
        return this.content;
    }

    public String c() {
        return this.extLiveInfo;
    }

    public Uri d() {
        return this.imageUri;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        Uri uri = this.imageUri;
        return uri == null ? "" : uri.toString();
    }

    public boolean f() {
        return this.isVideoThread;
    }

    public String g() {
        return this.linkUrl;
    }

    public String h() {
        return this.localFile;
    }

    public long i() {
        return this.readCount;
    }

    public int j() {
        return this.shareTo;
    }

    public int k() {
        return this.shareType;
    }

    public Bundle l() {
        return this.stats;
    }

    public String m() {
        return this.tid;
    }

    public String n() {
        return this.title;
    }

    public int o() {
        return this.typeShareToSmallApp;
    }

    public String p() {
        return this.videoUrl;
    }

    public String q() {
        return this.fName;
    }

    public boolean r() {
        if (this.shareType != 0) {
            int i2 = this.shareTo;
            return i2 == 8 || i2 == 4 || i2 == 3 || i2 == 2;
        }
        return false;
    }

    public void s(String str) {
        this.content = str;
    }

    public void t(String str) {
        this.extLiveInfo = str;
    }

    public void u(Uri uri) {
        this.imageUri = uri;
    }

    public void v(boolean z) {
        this.isVideoThread = z;
    }

    public void w(String str) {
        this.linkUrl = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.title);
        parcel.writeString(this.content);
        parcel.writeString(this.linkUrl);
        parcel.writeString(this.localFile);
        parcel.writeInt(this.shareTo);
        parcel.writeString(this.videoUrl);
        parcel.writeParcelable(this.imageUri, i2);
        parcel.writeParcelable(this.location, i2);
        parcel.writeBundle(this.stats);
        parcel.writeInt(this.shareType);
        parcel.writeString(this.tid);
        parcel.writeInt(this.typeShareToSmallApp);
        parcel.writeString(this.fName);
        parcel.writeString(this.topic);
        parcel.writeString(this.taskCompleteId);
        parcel.writeBundle(this.diskPicOperate);
        parcel.writeByte(this.canShareBySmartApp ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.readCount);
        parcel.writeByte(this.isVideoThread ? (byte) 1 : (byte) 0);
        parcel.writeString(this.extLiveInfo);
    }

    public void x(String str) {
        this.localFile = str;
    }

    public void y(Location location) {
        this.location = location;
    }

    public void z(int i2) {
        this.shareType = i2;
    }
}
