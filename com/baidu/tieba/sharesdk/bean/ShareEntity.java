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
        /* renamed from: s */
        public ShareEntity createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            ShareEntity shareEntity = new ShareEntity();
            shareEntity.setTitle(parcel.readString());
            shareEntity.setContent(parcel.readString());
            shareEntity.setLinkUrl(parcel.readString());
            shareEntity.sx(parcel.readInt());
            shareEntity.setVideoUrl(parcel.readString());
            shareEntity.g((Uri) parcel.readParcelable(Uri.class.getClassLoader()));
            shareEntity.setLocation((Location) parcel.readParcelable(Location.class.getClassLoader()));
            shareEntity.f(parcel.readBundle());
            shareEntity.lX(parcel.readInt() != 0);
            return shareEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: sy */
        public ShareEntity[] newArray(int i) {
            return new ShareEntity[i];
        }
    };
    private Uri awW;
    private Location awX;
    private boolean axe;
    private Bundle axg;
    private String content;
    private int glE;
    private String linkUrl;
    private String title;
    private String videoUrl;

    public void f(Bundle bundle) {
        this.axg = bundle;
    }

    public Bundle BJ() {
        return this.axg;
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

    public String qF() {
        return this.awW == null ? "" : this.awW.toString();
    }

    public Uri bno() {
        return this.awW;
    }

    public void g(Uri uri) {
        this.awW = uri;
    }

    public void setLocation(Location location) {
        this.awX = location;
    }

    public int bnp() {
        return this.glE;
    }

    public void sx(int i) {
        this.glE = i;
    }

    public boolean bnq() {
        return this.axe;
    }

    public void lX(boolean z) {
        this.axe = z;
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
        parcel.writeInt(this.glE);
        parcel.writeString(this.videoUrl);
        parcel.writeParcelable(this.awW, i);
        parcel.writeParcelable(this.awX, i);
        parcel.writeBundle(this.axg);
        parcel.writeInt(this.axe ? 1 : 0);
    }
}
