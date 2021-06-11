package com.baidu.tieba.video;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Objects;
/* loaded from: classes5.dex */
public class VideoItemModel implements Serializable, Parcelable {
    public static final Parcelable.Creator<VideoItemModel> CREATOR = new a();
    public final boolean funAdType;
    public final int mHashCode;
    public final VideoItemData videoItemData;

    /* loaded from: classes5.dex */
    public static class a implements Parcelable.Creator<VideoItemModel> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public VideoItemModel createFromParcel(Parcel parcel) {
            return new VideoItemModel(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public VideoItemModel[] newArray(int i2) {
            return new VideoItemModel[i2];
        }
    }

    public VideoItemModel(VideoItemData videoItemData, boolean z) {
        this.videoItemData = videoItemData;
        this.funAdType = z;
        this.mHashCode = hashCode();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || VideoItemModel.class != obj.getClass()) {
            return false;
        }
        VideoItemModel videoItemModel = (VideoItemModel) obj;
        return (this.funAdType && videoItemModel.funAdType) ? this.mHashCode == videoItemModel.hashCode() : this.funAdType == videoItemModel.funAdType && Objects.equals(this.videoItemData, videoItemModel.videoItemData);
    }

    public int getHashCode() {
        return this.mHashCode;
    }

    public VideoItemData getVideoItemData() {
        return this.videoItemData;
    }

    public boolean isFunAdType() {
        return this.funAdType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.videoItemData, i2);
        parcel.writeByte(this.funAdType ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mHashCode);
    }

    public VideoItemModel(Parcel parcel) {
        this.videoItemData = (VideoItemData) parcel.readParcelable(VideoItemData.class.getClassLoader());
        this.funAdType = parcel.readByte() == 1;
        this.mHashCode = parcel.readInt();
    }
}
