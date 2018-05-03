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
        /* renamed from: r */
        public ShareEntity createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            ShareEntity shareEntity = new ShareEntity();
            shareEntity.setTitle(parcel.readString());
            shareEntity.setContent(parcel.readString());
            shareEntity.setLinkUrl(parcel.readString());
            shareEntity.sy(parcel.readInt());
            shareEntity.setVideoUrl(parcel.readString());
            shareEntity.g((Uri) parcel.readParcelable(Uri.class.getClassLoader()));
            shareEntity.setLocation((Location) parcel.readParcelable(Location.class.getClassLoader()));
            shareEntity.f(parcel.readBundle());
            shareEntity.lW(parcel.readInt() != 0);
            return shareEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: sz */
        public ShareEntity[] newArray(int i) {
            return new ShareEntity[i];
        }
    };
    private Uri awV;
    private Location awW;
    private boolean axd;
    private Bundle axf;
    private String content;
    private int gky;
    private String linkUrl;
    private String title;
    private String videoUrl;

    public void f(Bundle bundle) {
        this.axf = bundle;
    }

    public Bundle BL() {
        return this.axf;
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

    public String qG() {
        return this.awV == null ? "" : this.awV.toString();
    }

    public Uri bnq() {
        return this.awV;
    }

    public void g(Uri uri) {
        this.awV = uri;
    }

    public void setLocation(Location location) {
        this.awW = location;
    }

    public int bnr() {
        return this.gky;
    }

    public void sy(int i) {
        this.gky = i;
    }

    public boolean bns() {
        return this.axd;
    }

    public void lW(boolean z) {
        this.axd = z;
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
        parcel.writeInt(this.gky);
        parcel.writeString(this.videoUrl);
        parcel.writeParcelable(this.awV, i);
        parcel.writeParcelable(this.awW, i);
        parcel.writeBundle(this.axf);
        parcel.writeInt(this.axd ? 1 : 0);
    }
}
