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
        /* renamed from: t */
        public ShareEntity createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            ShareEntity shareEntity = new ShareEntity();
            shareEntity.setTitle(parcel.readString());
            shareEntity.setContent(parcel.readString());
            shareEntity.setLinkUrl(parcel.readString());
            shareEntity.sR(parcel.readInt());
            shareEntity.setVideoUrl(parcel.readString());
            shareEntity.setImageUri((Uri) parcel.readParcelable(Uri.class.getClassLoader()));
            shareEntity.setLocation((Location) parcel.readParcelable(Location.class.getClassLoader()));
            shareEntity.f(parcel.readBundle());
            shareEntity.lZ(parcel.readInt() != 0);
            return shareEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: sS */
        public ShareEntity[] newArray(int i) {
            return new ShareEntity[i];
        }
    };
    private Location aGd;
    private boolean aGk;
    private Bundle aGm;
    private String content;
    private int gCd;
    private Uri imageUri;
    private String linkUrl;
    private String title;
    private String videoUrl;

    public void f(Bundle bundle) {
        this.aGm = bundle;
    }

    public Bundle Fz() {
        return this.aGm;
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

    public String tU() {
        return this.imageUri == null ? "" : this.imageUri.toString();
    }

    public Uri getImageUri() {
        return this.imageUri;
    }

    public void setImageUri(Uri uri) {
        this.imageUri = uri;
    }

    public void setLocation(Location location) {
        this.aGd = location;
    }

    public int brs() {
        return this.gCd;
    }

    public void sR(int i) {
        this.gCd = i;
    }

    public boolean brt() {
        return this.aGk;
    }

    public void lZ(boolean z) {
        this.aGk = z;
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
        parcel.writeInt(this.gCd);
        parcel.writeString(this.videoUrl);
        parcel.writeParcelable(this.imageUri, i);
        parcel.writeParcelable(this.aGd, i);
        parcel.writeBundle(this.aGm);
        parcel.writeInt(this.aGk ? 1 : 0);
    }
}
