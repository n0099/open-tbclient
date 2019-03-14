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
        /* renamed from: M */
        public ShareEntity createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            ShareEntity shareEntity = new ShareEntity();
            shareEntity.setTitle(parcel.readString());
            shareEntity.setContent(parcel.readString());
            shareEntity.setLinkUrl(parcel.readString());
            shareEntity.BX(parcel.readString());
            shareEntity.yG(parcel.readInt());
            shareEntity.setVideoUrl(parcel.readString());
            shareEntity.setImageUri((Uri) parcel.readParcelable(Uri.class.getClassLoader()));
            shareEntity.setLocation((Location) parcel.readParcelable(Location.class.getClassLoader()));
            shareEntity.D(parcel.readBundle());
            shareEntity.yH(parcel.readInt());
            shareEntity.setTid(parcel.readString());
            shareEntity.topic = parcel.readString();
            shareEntity.cbI = parcel.readString();
            shareEntity.cbv = parcel.readBundle();
            return shareEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: yI */
        public ShareEntity[] newArray(int i) {
            return new ShareEntity[i];
        }
    };
    public String cbI;
    private Bundle cbK;
    private String cbu;
    public Bundle cbv;
    private Location cbw;
    private String content;
    private Uri imageUri;
    private int ivr;
    private String linkUrl;
    private int shareType;
    private String tid;
    private String title;
    public String topic;
    private String videoUrl;

    public void D(Bundle bundle) {
        this.cbK = bundle;
    }

    public Bundle ajS() {
        return this.cbK;
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

    public void BX(String str) {
        this.cbu = str;
    }

    public String caR() {
        return this.cbu;
    }

    public String Xn() {
        return this.imageUri == null ? "" : this.imageUri.toString();
    }

    public Uri getImageUri() {
        return this.imageUri;
    }

    public void setImageUri(Uri uri) {
        this.imageUri = uri;
    }

    public void setLocation(Location location) {
        this.cbw = location;
    }

    public int caS() {
        return this.ivr;
    }

    public void yG(int i) {
        this.ivr = i;
    }

    public int caT() {
        return this.shareType;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public String getTid() {
        return this.tid;
    }

    public void yH(int i) {
        this.shareType = i;
    }

    public boolean caU() {
        return this.shareType != 0 && (this.ivr == 8 || this.ivr == 4 || this.ivr == 3 || this.ivr == 2);
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
        parcel.writeString(this.cbu);
        parcel.writeInt(this.ivr);
        parcel.writeString(this.videoUrl);
        parcel.writeParcelable(this.imageUri, i);
        parcel.writeParcelable(this.cbw, i);
        parcel.writeBundle(this.cbK);
        parcel.writeInt(this.shareType);
        parcel.writeString(this.tid);
        parcel.writeString(this.topic);
        parcel.writeString(this.cbI);
        parcel.writeBundle(this.cbv);
    }
}
