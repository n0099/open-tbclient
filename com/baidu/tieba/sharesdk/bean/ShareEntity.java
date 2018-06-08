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
            shareEntity.sJ(parcel.readInt());
            shareEntity.setVideoUrl(parcel.readString());
            shareEntity.g((Uri) parcel.readParcelable(Uri.class.getClassLoader()));
            shareEntity.setLocation((Location) parcel.readParcelable(Location.class.getClassLoader()));
            shareEntity.f(parcel.readBundle());
            shareEntity.md(parcel.readInt() != 0);
            return shareEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: sK */
        public ShareEntity[] newArray(int i) {
            return new ShareEntity[i];
        }
    };
    private Uri aFj;
    private Location aFk;
    private boolean aFr;
    private Bundle aFt;
    private String content;
    private int gxc;
    private String linkUrl;
    private String title;
    private String videoUrl;

    public void f(Bundle bundle) {
        this.aFt = bundle;
    }

    public Bundle Fl() {
        return this.aFt;
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

    public String ub() {
        return this.aFj == null ? "" : this.aFj.toString();
    }

    public Uri bso() {
        return this.aFj;
    }

    public void g(Uri uri) {
        this.aFj = uri;
    }

    public void setLocation(Location location) {
        this.aFk = location;
    }

    public int bsp() {
        return this.gxc;
    }

    public void sJ(int i) {
        this.gxc = i;
    }

    public boolean bsq() {
        return this.aFr;
    }

    public void md(boolean z) {
        this.aFr = z;
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
        parcel.writeInt(this.gxc);
        parcel.writeString(this.videoUrl);
        parcel.writeParcelable(this.aFj, i);
        parcel.writeParcelable(this.aFk, i);
        parcel.writeBundle(this.aFt);
        parcel.writeInt(this.aFr ? 1 : 0);
    }
}
