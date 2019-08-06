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
        /* renamed from: R */
        public ShareEntity createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            ShareEntity shareEntity = new ShareEntity();
            shareEntity.setTitle(parcel.readString());
            shareEntity.setContent(parcel.readString());
            shareEntity.setLinkUrl(parcel.readString());
            shareEntity.Ei(parcel.readString());
            shareEntity.Ar(parcel.readInt());
            shareEntity.setVideoUrl(parcel.readString());
            shareEntity.setImageUri((Uri) parcel.readParcelable(Uri.class.getClassLoader()));
            shareEntity.setLocation((Location) parcel.readParcelable(Location.class.getClassLoader()));
            shareEntity.E(parcel.readBundle());
            shareEntity.As(parcel.readInt());
            shareEntity.setTid(parcel.readString());
            shareEntity.topic = parcel.readString();
            shareEntity.ckZ = parcel.readString();
            shareEntity.ckM = parcel.readBundle();
            shareEntity.clh = parcel.readByte() == 1;
            return shareEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: At */
        public ShareEntity[] newArray(int i) {
            return new ShareEntity[i];
        }
    };
    private String ckL;
    public Bundle ckM;
    private Location ckN;
    public String ckZ;
    private Bundle clb;
    public boolean clh = true;
    private String content;
    private int iVs;
    private Uri imageUri;
    private String linkUrl;
    private int shareType;
    private String tid;
    private String title;
    public String topic;
    private String videoUrl;

    public void E(Bundle bundle) {
        this.clb = bundle;
    }

    public Bundle apY() {
        return this.clb;
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

    public void Ei(String str) {
        this.ckL = str;
    }

    public String cmd() {
        return this.ckL;
    }

    public String acV() {
        return this.imageUri == null ? "" : this.imageUri.toString();
    }

    public Uri getImageUri() {
        return this.imageUri;
    }

    public void setImageUri(Uri uri) {
        this.imageUri = uri;
    }

    public void setLocation(Location location) {
        this.ckN = location;
    }

    public int cme() {
        return this.iVs;
    }

    public void Ar(int i) {
        this.iVs = i;
    }

    public int cmf() {
        return this.shareType;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public String getTid() {
        return this.tid;
    }

    public void As(int i) {
        this.shareType = i;
    }

    public boolean cmg() {
        return this.shareType != 0 && (this.iVs == 8 || this.iVs == 4 || this.iVs == 3 || this.iVs == 2);
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
        parcel.writeString(this.ckL);
        parcel.writeInt(this.iVs);
        parcel.writeString(this.videoUrl);
        parcel.writeParcelable(this.imageUri, i);
        parcel.writeParcelable(this.ckN, i);
        parcel.writeBundle(this.clb);
        parcel.writeInt(this.shareType);
        parcel.writeString(this.tid);
        parcel.writeString(this.topic);
        parcel.writeString(this.ckZ);
        parcel.writeBundle(this.ckM);
        parcel.writeByte((byte) (this.clh ? 1 : 0));
    }
}
