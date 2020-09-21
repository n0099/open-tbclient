package com.baidu.tieba.sharesdk.bean;

import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes23.dex */
public class ShareEntity implements Parcelable {
    public static final Parcelable.Creator<ShareEntity> CREATOR = new Parcelable.Creator<ShareEntity>() { // from class: com.baidu.tieba.sharesdk.bean.ShareEntity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: ae */
        public ShareEntity createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            ShareEntity shareEntity = new ShareEntity();
            shareEntity.setTitle(parcel.readString());
            shareEntity.setContent(parcel.readString());
            shareEntity.setLinkUrl(parcel.readString());
            shareEntity.Qy(parcel.readString());
            shareEntity.HC(parcel.readInt());
            shareEntity.setVideoUrl(parcel.readString());
            shareEntity.setImageUri((Uri) parcel.readParcelable(Uri.class.getClassLoader()));
            shareEntity.setLocation((Location) parcel.readParcelable(Location.class.getClassLoader()));
            shareEntity.ae(parcel.readBundle());
            shareEntity.HE(parcel.readInt());
            shareEntity.setTid(parcel.readString());
            shareEntity.HD(parcel.readInt());
            shareEntity.QA(parcel.readString());
            shareEntity.topic = parcel.readString();
            shareEntity.taskCompleteId = parcel.readString();
            shareEntity.diskPicOperate = parcel.readBundle();
            shareEntity.canShareBySmartApp = parcel.readByte() == 1;
            shareEntity.gi(parcel.readLong());
            shareEntity.vS(parcel.readByte() == 1);
            shareEntity.extLiveInfo = parcel.readString();
            return shareEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: HF */
        public ShareEntity[] newArray(int i) {
            return new ShareEntity[i];
        }
    };
    private String content;
    public Bundle diskPicOperate;
    private String extLiveInfo;
    private String fName;
    private Uri imageUri;
    private boolean isVideoThread;
    private String linkUrl;
    private String localFile;
    private Location location;
    private long readCount;
    private int shareTo;
    private int shareType;
    private Bundle stats;
    public String taskCompleteId;
    private String tid;
    private String title;
    public String topic;
    private String videoUrl;
    private int typeShareToSmallApp = 0;
    public boolean canShareBySmartApp = true;

    public void ae(Bundle bundle) {
        this.stats = bundle;
    }

    public Bundle bqr() {
        return this.stats;
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

    public void gi(long j) {
        this.readCount = j;
    }

    public long dwt() {
        return this.readCount;
    }

    public void vS(boolean z) {
        this.isVideoThread = z;
    }

    public boolean dwu() {
        return this.isVideoThread;
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public void setLinkUrl(String str) {
        this.linkUrl = str;
    }

    public void Qy(String str) {
        this.localFile = str;
    }

    public String dwv() {
        return this.localFile;
    }

    public String bdu() {
        return this.imageUri == null ? "" : this.imageUri.toString();
    }

    public Uri getImageUri() {
        return this.imageUri;
    }

    public void setImageUri(Uri uri) {
        this.imageUri = uri;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int dww() {
        return this.shareTo;
    }

    public void HC(int i) {
        this.shareTo = i;
    }

    public int dwx() {
        return this.shareType;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public String getTid() {
        return this.tid;
    }

    public String dwy() {
        return this.extLiveInfo;
    }

    public void Qz(String str) {
        this.extLiveInfo = str;
    }

    public void QA(String str) {
        this.fName = str;
    }

    public String dwz() {
        return this.fName;
    }

    public void HD(int i) {
        this.typeShareToSmallApp = i;
    }

    public int dwA() {
        return this.typeShareToSmallApp;
    }

    public void HE(int i) {
        this.shareType = i;
    }

    public boolean dwB() {
        return this.shareType != 0 && (this.shareTo == 8 || this.shareTo == 4 || this.shareTo == 3 || this.shareTo == 2);
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
        parcel.writeString(this.localFile);
        parcel.writeInt(this.shareTo);
        parcel.writeString(this.videoUrl);
        parcel.writeParcelable(this.imageUri, i);
        parcel.writeParcelable(this.location, i);
        parcel.writeBundle(this.stats);
        parcel.writeInt(this.shareType);
        parcel.writeString(this.tid);
        parcel.writeInt(this.typeShareToSmallApp);
        parcel.writeString(this.fName);
        parcel.writeString(this.topic);
        parcel.writeString(this.taskCompleteId);
        parcel.writeBundle(this.diskPicOperate);
        parcel.writeByte((byte) (this.canShareBySmartApp ? 1 : 0));
        parcel.writeLong(this.readCount);
        parcel.writeByte((byte) (this.isVideoThread ? 1 : 0));
        parcel.writeString(this.extLiveInfo);
    }
}
