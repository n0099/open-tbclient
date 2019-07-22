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
        /* renamed from: R */
        public ShareEntity createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            ShareEntity shareEntity = new ShareEntity();
            shareEntity.setTitle(parcel.readString());
            shareEntity.setContent(parcel.readString());
            shareEntity.setLinkUrl(parcel.readString());
            shareEntity.Eh(parcel.readString());
            shareEntity.Ap(parcel.readInt());
            shareEntity.setVideoUrl(parcel.readString());
            shareEntity.setImageUri((Uri) parcel.readParcelable(Uri.class.getClassLoader()));
            shareEntity.setLocation((Location) parcel.readParcelable(Location.class.getClassLoader()));
            shareEntity.E(parcel.readBundle());
            shareEntity.Aq(parcel.readInt());
            shareEntity.setTid(parcel.readString());
            shareEntity.topic = parcel.readString();
            shareEntity.ckS = parcel.readString();
            shareEntity.ckF = parcel.readBundle();
            shareEntity.cla = parcel.readByte() == 1;
            return shareEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: Ar */
        public ShareEntity[] newArray(int i) {
            return new ShareEntity[i];
        }
    };
    private String ckE;
    public Bundle ckF;
    private Location ckG;
    public String ckS;
    private Bundle ckU;
    public boolean cla = true;
    private String content;
    private int iUo;
    private Uri imageUri;
    private String linkUrl;
    private int shareType;
    private String tid;
    private String title;
    public String topic;
    private String videoUrl;

    public void E(Bundle bundle) {
        this.ckU = bundle;
    }

    public Bundle apW() {
        return this.ckU;
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

    public void Eh(String str) {
        this.ckE = str;
    }

    public String clL() {
        return this.ckE;
    }

    public String acU() {
        return this.imageUri == null ? "" : this.imageUri.toString();
    }

    public Uri getImageUri() {
        return this.imageUri;
    }

    public void setImageUri(Uri uri) {
        this.imageUri = uri;
    }

    public void setLocation(Location location) {
        this.ckG = location;
    }

    public int clM() {
        return this.iUo;
    }

    public void Ap(int i) {
        this.iUo = i;
    }

    public int clN() {
        return this.shareType;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public String getTid() {
        return this.tid;
    }

    public void Aq(int i) {
        this.shareType = i;
    }

    public boolean clO() {
        return this.shareType != 0 && (this.iUo == 8 || this.iUo == 4 || this.iUo == 3 || this.iUo == 2);
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
        parcel.writeString(this.ckE);
        parcel.writeInt(this.iUo);
        parcel.writeString(this.videoUrl);
        parcel.writeParcelable(this.imageUri, i);
        parcel.writeParcelable(this.ckG, i);
        parcel.writeBundle(this.ckU);
        parcel.writeInt(this.shareType);
        parcel.writeString(this.tid);
        parcel.writeString(this.topic);
        parcel.writeString(this.ckS);
        parcel.writeBundle(this.ckF);
        parcel.writeByte((byte) (this.cla ? 1 : 0));
    }
}
