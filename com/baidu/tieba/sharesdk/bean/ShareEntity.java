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
            shareEntity.uV(parcel.readInt());
            shareEntity.setVideoUrl(parcel.readString());
            shareEntity.j((Uri) parcel.readParcelable(Uri.class.getClassLoader()));
            shareEntity.setLocation((Location) parcel.readParcelable(Location.class.getClassLoader()));
            shareEntity.i(parcel.readBundle());
            shareEntity.mq(parcel.readInt() != 0);
            return shareEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: uW */
        public ShareEntity[] newArray(int i) {
            return new ShareEntity[i];
        }
    };
    private Uri blB;
    private Location blC;
    private boolean blJ;
    private Bundle blL;
    private String content;
    private int gPu;
    private String linkUrl;
    private String title;
    private String videoUrl;

    public void i(Bundle bundle) {
        this.blL = bundle;
    }

    public Bundle IX() {
        return this.blL;
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
        return this.blB == null ? "" : this.blB.toString();
    }

    public void j(Uri uri) {
        this.blB = uri;
    }

    public void setLocation(Location location) {
        this.blC = location;
    }

    public int bsi() {
        return this.gPu;
    }

    public void uV(int i) {
        this.gPu = i;
    }

    public boolean bsj() {
        return this.blJ;
    }

    public void mq(boolean z) {
        this.blJ = z;
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
        parcel.writeInt(this.gPu);
        parcel.writeString(this.videoUrl);
        parcel.writeParcelable(this.blB, i);
        parcel.writeParcelable(this.blC, i);
        parcel.writeBundle(this.blL);
        parcel.writeInt(this.blJ ? 1 : 0);
    }
}
