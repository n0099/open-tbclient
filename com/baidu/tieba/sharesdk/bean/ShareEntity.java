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
        /* renamed from: G */
        public ShareEntity createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            ShareEntity shareEntity = new ShareEntity();
            shareEntity.setTitle(parcel.readString());
            shareEntity.setContent(parcel.readString());
            shareEntity.setLinkUrl(parcel.readString());
            shareEntity.uW(parcel.readInt());
            shareEntity.setVideoUrl(parcel.readString());
            shareEntity.j((Uri) parcel.readParcelable(Uri.class.getClassLoader()));
            shareEntity.setLocation((Location) parcel.readParcelable(Location.class.getClassLoader()));
            shareEntity.i(parcel.readBundle());
            shareEntity.mq(parcel.readInt() != 0);
            return shareEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: uX */
        public ShareEntity[] newArray(int i) {
            return new ShareEntity[i];
        }
    };
    private Uri blo;
    private Location blp;
    private boolean blw;
    private Bundle bly;
    private String content;
    private int gPf;
    private String linkUrl;
    private String title;
    private String videoUrl;

    public void i(Bundle bundle) {
        this.bly = bundle;
    }

    public Bundle IW() {
        return this.bly;
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

    public String ya() {
        return this.blo == null ? "" : this.blo.toString();
    }

    public void j(Uri uri) {
        this.blo = uri;
    }

    public void setLocation(Location location) {
        this.blp = location;
    }

    public int bsh() {
        return this.gPf;
    }

    public void uW(int i) {
        this.gPf = i;
    }

    public boolean bsi() {
        return this.blw;
    }

    public void mq(boolean z) {
        this.blw = z;
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
        parcel.writeInt(this.gPf);
        parcel.writeString(this.videoUrl);
        parcel.writeParcelable(this.blo, i);
        parcel.writeParcelable(this.blp, i);
        parcel.writeBundle(this.bly);
        parcel.writeInt(this.blw ? 1 : 0);
    }
}
