package com.baidu.tieba.social_share_sdk;

import android.location.Location;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class ShareInfoData implements Parcelable {
    public static final Parcelable.Creator<ShareInfoData> CREATOR = new Parcelable.Creator<ShareInfoData>() { // from class: com.baidu.tieba.social_share_sdk.ShareInfoData.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareInfoData createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            ShareInfoData shareInfoData = new ShareInfoData();
            shareInfoData.setTitle(parcel.readString());
            shareInfoData.setContent(parcel.readString());
            shareInfoData.setLinkUrl(parcel.readString());
            shareInfoData.setShareTo(parcel.readString());
            shareInfoData.setImageUri((Uri) parcel.readParcelable(Uri.class.getClassLoader()));
            shareInfoData.setLocation((Location) parcel.readParcelable(Location.class.getClassLoader()));
            return shareInfoData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareInfoData[] newArray(int i) {
            return new ShareInfoData[i];
        }
    };
    private String content;
    private Uri imageUri;
    private String linkUrl;
    private Location location;
    private String shareTo;
    private String title;

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

    public Uri getImageUri() {
        return this.imageUri;
    }

    public void setImageUri(Uri uri) {
        this.imageUri = uri;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getShareTo() {
        return this.shareTo;
    }

    public void setShareTo(String str) {
        this.shareTo = str;
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
        parcel.writeString(this.shareTo);
        parcel.writeParcelable(this.imageUri, i);
        parcel.writeParcelable(this.location, i);
    }
}
