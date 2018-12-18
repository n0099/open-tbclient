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
            shareEntity.uB(parcel.readInt());
            shareEntity.setVideoUrl(parcel.readString());
            shareEntity.setImageUri((Uri) parcel.readParcelable(Uri.class.getClassLoader()));
            shareEntity.setLocation((Location) parcel.readParcelable(Location.class.getClassLoader()));
            shareEntity.k(parcel.readBundle());
            shareEntity.uC(parcel.readInt());
            shareEntity.topic = parcel.readString();
            shareEntity.aSo = parcel.readString();
            return shareEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: uD */
        public ShareEntity[] newArray(int i) {
            return new ShareEntity[i];
        }
    };
    private Location aSh;
    public String aSo;
    private Bundle aSq;
    private String content;
    private int gZw;
    private Uri imageUri;
    private String linkUrl;
    private int shareType;
    private String title;
    public String topic;
    private String videoUrl;

    public void k(Bundle bundle) {
        this.aSq = bundle;
    }

    public Bundle Kg() {
        return this.aSq;
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
        this.aSh = location;
    }

    public int byB() {
        return this.gZw;
    }

    public void uB(int i) {
        this.gZw = i;
    }

    public int byC() {
        return this.shareType;
    }

    public void uC(int i) {
        this.shareType = i;
    }

    public boolean byD() {
        return this.shareType != 0 && (this.gZw == 8 || this.gZw == 4 || this.gZw == 3 || this.gZw == 2);
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
        parcel.writeInt(this.gZw);
        parcel.writeString(this.videoUrl);
        parcel.writeParcelable(this.imageUri, i);
        parcel.writeParcelable(this.aSh, i);
        parcel.writeBundle(this.aSq);
        parcel.writeInt(this.shareType);
        parcel.writeString(this.topic);
        parcel.writeString(this.aSo);
    }
}
