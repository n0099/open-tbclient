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
        /* renamed from: P */
        public ShareEntity createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            ShareEntity shareEntity = new ShareEntity();
            shareEntity.setTitle(parcel.readString());
            shareEntity.setContent(parcel.readString());
            shareEntity.setLinkUrl(parcel.readString());
            shareEntity.Ds(parcel.readString());
            shareEntity.zJ(parcel.readInt());
            shareEntity.setVideoUrl(parcel.readString());
            shareEntity.setImageUri((Uri) parcel.readParcelable(Uri.class.getClassLoader()));
            shareEntity.setLocation((Location) parcel.readParcelable(Location.class.getClassLoader()));
            shareEntity.E(parcel.readBundle());
            shareEntity.zK(parcel.readInt());
            shareEntity.setTid(parcel.readString());
            shareEntity.topic = parcel.readString();
            shareEntity.cjM = parcel.readString();
            shareEntity.cjz = parcel.readBundle();
            return shareEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: zL */
        public ShareEntity[] newArray(int i) {
            return new ShareEntity[i];
        }
    };
    private Location cjA;
    public String cjM;
    private Bundle cjO;
    private String cjy;
    public Bundle cjz;
    private String content;
    private int iNS;
    private Uri imageUri;
    private String linkUrl;
    private int shareType;
    private String tid;
    private String title;
    public String topic;
    private String videoUrl;

    public void E(Bundle bundle) {
        this.cjO = bundle;
    }

    public Bundle aoQ() {
        return this.cjO;
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

    public void Ds(String str) {
        this.cjy = str;
    }

    public String ciT() {
        return this.cjy;
    }

    public String abS() {
        return this.imageUri == null ? "" : this.imageUri.toString();
    }

    public Uri getImageUri() {
        return this.imageUri;
    }

    public void setImageUri(Uri uri) {
        this.imageUri = uri;
    }

    public void setLocation(Location location) {
        this.cjA = location;
    }

    public int ciU() {
        return this.iNS;
    }

    public void zJ(int i) {
        this.iNS = i;
    }

    public int ciV() {
        return this.shareType;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public String getTid() {
        return this.tid;
    }

    public void zK(int i) {
        this.shareType = i;
    }

    public boolean ciW() {
        return this.shareType != 0 && (this.iNS == 8 || this.iNS == 4 || this.iNS == 3 || this.iNS == 2);
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
        parcel.writeString(this.cjy);
        parcel.writeInt(this.iNS);
        parcel.writeString(this.videoUrl);
        parcel.writeParcelable(this.imageUri, i);
        parcel.writeParcelable(this.cjA, i);
        parcel.writeBundle(this.cjO);
        parcel.writeInt(this.shareType);
        parcel.writeString(this.tid);
        parcel.writeString(this.topic);
        parcel.writeString(this.cjM);
        parcel.writeBundle(this.cjz);
    }
}
