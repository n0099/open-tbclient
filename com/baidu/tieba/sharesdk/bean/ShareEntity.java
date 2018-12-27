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
            shareEntity.uO(parcel.readInt());
            shareEntity.setVideoUrl(parcel.readString());
            shareEntity.setImageUri((Uri) parcel.readParcelable(Uri.class.getClassLoader()));
            shareEntity.setLocation((Location) parcel.readParcelable(Location.class.getClassLoader()));
            shareEntity.k(parcel.readBundle());
            shareEntity.uP(parcel.readInt());
            shareEntity.topic = parcel.readString();
            shareEntity.aSq = parcel.readString();
            return shareEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: uQ */
        public ShareEntity[] newArray(int i) {
            return new ShareEntity[i];
        }
    };
    private Location aSj;
    public String aSq;
    private Bundle aSs;
    private String content;
    private int hcA;
    private Uri imageUri;
    private String linkUrl;
    private int shareType;
    private String title;
    public String topic;
    private String videoUrl;

    public void k(Bundle bundle) {
        this.aSs = bundle;
    }

    public Bundle Kh() {
        return this.aSs;
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

    public String ys() {
        return this.imageUri == null ? "" : this.imageUri.toString();
    }

    public Uri getImageUri() {
        return this.imageUri;
    }

    public void setImageUri(Uri uri) {
        this.imageUri = uri;
    }

    public void setLocation(Location location) {
        this.aSj = location;
    }

    public int bzr() {
        return this.hcA;
    }

    public void uO(int i) {
        this.hcA = i;
    }

    public int bzs() {
        return this.shareType;
    }

    public void uP(int i) {
        this.shareType = i;
    }

    public boolean bzt() {
        return this.shareType != 0 && (this.hcA == 8 || this.hcA == 4 || this.hcA == 3 || this.hcA == 2);
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
        parcel.writeInt(this.hcA);
        parcel.writeString(this.videoUrl);
        parcel.writeParcelable(this.imageUri, i);
        parcel.writeParcelable(this.aSj, i);
        parcel.writeBundle(this.aSs);
        parcel.writeInt(this.shareType);
        parcel.writeString(this.topic);
        parcel.writeString(this.aSq);
    }
}
