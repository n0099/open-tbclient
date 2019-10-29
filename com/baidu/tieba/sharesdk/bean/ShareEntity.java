package com.baidu.tieba.sharesdk.bean;

import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes6.dex */
public class ShareEntity implements Parcelable {
    public static final Parcelable.Creator<ShareEntity> CREATOR = new Parcelable.Creator<ShareEntity>() { // from class: com.baidu.tieba.sharesdk.bean.ShareEntity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: U */
        public ShareEntity createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            ShareEntity shareEntity = new ShareEntity();
            shareEntity.setTitle(parcel.readString());
            shareEntity.setContent(parcel.readString());
            shareEntity.setLinkUrl(parcel.readString());
            shareEntity.Dn(parcel.readString());
            shareEntity.zc(parcel.readInt());
            shareEntity.setVideoUrl(parcel.readString());
            shareEntity.setImageUri((Uri) parcel.readParcelable(Uri.class.getClassLoader()));
            shareEntity.setLocation((Location) parcel.readParcelable(Location.class.getClassLoader()));
            shareEntity.E(parcel.readBundle());
            shareEntity.zd(parcel.readInt());
            shareEntity.setTid(parcel.readString());
            shareEntity.topic = parcel.readString();
            shareEntity.cyU = parcel.readString();
            shareEntity.cyH = parcel.readBundle();
            shareEntity.czc = parcel.readByte() == 1;
            return shareEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: ze */
        public ShareEntity[] newArray(int i) {
            return new ShareEntity[i];
        }
    };
    private String content;
    private String cyG;
    public Bundle cyH;
    private Location cyI;
    public String cyU;
    private Bundle cyW;
    public boolean czc = true;
    private int iXC;
    private Uri imageUri;
    private String linkUrl;
    private int shareType;
    private String tid;
    private String title;
    public String topic;
    private String videoUrl;

    public void E(Bundle bundle) {
        this.cyW = bundle;
    }

    public Bundle ase() {
        return this.cyW;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public void setVideoUrl(String str) {
        this.videoUrl = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public void setLinkUrl(String str) {
        this.linkUrl = str;
    }

    public void Dn(String str) {
        this.cyG = str;
    }

    public String ckE() {
        return this.cyG;
    }

    public String ahf() {
        return this.imageUri == null ? "" : this.imageUri.toString();
    }

    public Uri getImageUri() {
        return this.imageUri;
    }

    public void setImageUri(Uri uri) {
        this.imageUri = uri;
    }

    public void setLocation(Location location) {
        this.cyI = location;
    }

    public int ckF() {
        return this.iXC;
    }

    public void zc(int i) {
        this.iXC = i;
    }

    public int ckG() {
        return this.shareType;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public String getTid() {
        return this.tid;
    }

    public void zd(int i) {
        this.shareType = i;
    }

    public boolean ckH() {
        return this.shareType != 0 && (this.iXC == 8 || this.iXC == 4 || this.iXC == 3 || this.iXC == 2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.content);
        parcel.writeString(this.linkUrl);
        parcel.writeString(this.cyG);
        parcel.writeInt(this.iXC);
        parcel.writeString(this.videoUrl);
        parcel.writeParcelable(this.imageUri, i);
        parcel.writeParcelable(this.cyI, i);
        parcel.writeBundle(this.cyW);
        parcel.writeInt(this.shareType);
        parcel.writeString(this.tid);
        parcel.writeString(this.topic);
        parcel.writeString(this.cyU);
        parcel.writeBundle(this.cyH);
        parcel.writeByte((byte) (this.czc ? 1 : 0));
    }
}
