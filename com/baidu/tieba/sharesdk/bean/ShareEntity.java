package com.baidu.tieba.sharesdk.bean;

import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class ShareEntity implements Parcelable {
    public static final Parcelable.Creator<ShareEntity> CREATOR = new Parcelable.Creator<ShareEntity>() { // from class: com.baidu.tieba.sharesdk.bean.ShareEntity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: v */
        public ShareEntity createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            ShareEntity shareEntity = new ShareEntity();
            shareEntity.setTitle(parcel.readString());
            shareEntity.setContent(parcel.readString());
            shareEntity.setLinkUrl(parcel.readString());
            shareEntity.hq(parcel.readString());
            shareEntity.uR(parcel.readInt());
            shareEntity.setVideoUrl(parcel.readString());
            shareEntity.setImageUri((Uri) parcel.readParcelable(Uri.class.getClassLoader()));
            shareEntity.setLocation((Location) parcel.readParcelable(Location.class.getClassLoader()));
            shareEntity.k(parcel.readBundle());
            shareEntity.uS(parcel.readInt());
            shareEntity.topic = parcel.readString();
            shareEntity.aSY = parcel.readString();
            return shareEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: uT */
        public ShareEntity[] newArray(int i) {
            return new ShareEntity[i];
        }
    };
    private String aSO;
    private Location aSP;
    public String aSY;
    private Bundle aTa;
    private String content;
    private int hdG;
    private Uri imageUri;
    private String linkUrl;
    private int shareType;
    private String title;
    public String topic;
    private String videoUrl;

    public void k(Bundle bundle) {
        this.aTa = bundle;
    }

    public Bundle Kw() {
        return this.aTa;
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

    public void hq(String str) {
        this.aSO = str;
    }

    public String sb() {
        return this.aSO;
    }

    public String yF() {
        return this.imageUri == null ? "" : this.imageUri.toString();
    }

    public Uri getImageUri() {
        return this.imageUri;
    }

    public void setImageUri(Uri uri) {
        this.imageUri = uri;
    }

    public void setLocation(Location location) {
        this.aSP = location;
    }

    public int bAa() {
        return this.hdG;
    }

    public void uR(int i) {
        this.hdG = i;
    }

    public int bAb() {
        return this.shareType;
    }

    public void uS(int i) {
        this.shareType = i;
    }

    public boolean bAc() {
        return this.shareType != 0 && (this.hdG == 8 || this.hdG == 4 || this.hdG == 3 || this.hdG == 2);
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
        parcel.writeString(this.aSO);
        parcel.writeInt(this.hdG);
        parcel.writeString(this.videoUrl);
        parcel.writeParcelable(this.imageUri, i);
        parcel.writeParcelable(this.aSP, i);
        parcel.writeBundle(this.aTa);
        parcel.writeInt(this.shareType);
        parcel.writeString(this.topic);
        parcel.writeString(this.aSY);
    }
}
