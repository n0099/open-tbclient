package com.baidu.ugc.editvideo.editvideo.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
/* loaded from: classes8.dex */
public class MusicInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<MusicInfo> CREATOR = new Parcelable.Creator<MusicInfo>() { // from class: com.baidu.ugc.editvideo.editvideo.data.MusicInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MusicInfo createFromParcel(Parcel parcel) {
            return new MusicInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MusicInfo[] newArray(int i) {
            return new MusicInfo[i];
        }
    };
    public static final long serialVersionUID = 3;
    public String author_name;
    public int downloadRetryTimes;
    public int duration;
    public String image;
    public boolean isChoosedBySticker;
    public boolean isLoading;
    public boolean isPlaying;
    public String localPath;
    public long mClipStartTime;
    public int mIsCollect;
    public String mMusicId;
    public int mMusicType;
    public int mUsedTime;
    public String name;
    public long realDuration;
    public String resource;

    public MusicInfo() {
        this.isLoading = false;
        this.isPlaying = false;
    }

    public MusicInfo(Parcel parcel) {
        this.isLoading = false;
        this.isPlaying = false;
        this.mMusicId = parcel.readString();
        this.name = parcel.readString();
        this.image = parcel.readString();
        this.resource = parcel.readString();
        this.localPath = parcel.readString();
        this.author_name = parcel.readString();
        this.duration = parcel.readInt();
        this.realDuration = parcel.readLong();
        this.mIsCollect = parcel.readInt();
        this.mMusicType = parcel.readInt();
        this.mUsedTime = parcel.readInt();
        this.isLoading = parcel.readByte() != 0;
        this.isPlaying = parcel.readByte() != 0;
        this.downloadRetryTimes = parcel.readInt();
        this.mClipStartTime = parcel.readLong();
        this.isChoosedBySticker = parcel.readByte() != 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public MusicInfo m97clone() {
        MusicInfo musicInfo = new MusicInfo();
        musicInfo.mMusicId = this.mMusicId;
        musicInfo.name = this.name;
        musicInfo.image = this.image;
        musicInfo.resource = this.resource;
        musicInfo.localPath = this.localPath;
        musicInfo.author_name = this.author_name;
        musicInfo.duration = this.duration;
        musicInfo.mIsCollect = this.mIsCollect;
        musicInfo.mUsedTime = this.mUsedTime;
        musicInfo.mClipStartTime = this.mClipStartTime;
        musicInfo.isLoading = this.isLoading;
        musicInfo.isPlaying = this.isPlaying;
        musicInfo.isChoosedBySticker = this.isChoosedBySticker;
        return musicInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MusicInfo.class != obj.getClass()) {
            return false;
        }
        MusicInfo musicInfo = (MusicInfo) obj;
        if (this.duration != musicInfo.duration) {
            return false;
        }
        String str = this.mMusicId;
        if (str == null ? musicInfo.mMusicId == null : str.equals(musicInfo.mMusicId)) {
            String str2 = this.name;
            if (str2 == null ? musicInfo.name == null : str2.equals(musicInfo.name)) {
                String str3 = this.image;
                if (str3 == null ? musicInfo.image == null : str3.equals(musicInfo.image)) {
                    String str4 = this.resource;
                    if (str4 == null ? musicInfo.resource == null : str4.equals(musicInfo.resource)) {
                        return this.mClipStartTime == musicInfo.mClipStartTime;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.image;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.resource;
        int hashCode3 = (((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.duration) * 31;
        String str4 = this.mMusicId;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public boolean isBaiduMusic() {
        return this.mMusicType == 3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mMusicId);
        parcel.writeString(this.name);
        parcel.writeString(this.image);
        parcel.writeString(this.resource);
        parcel.writeString(this.localPath);
        parcel.writeString(this.author_name);
        parcel.writeInt(this.duration);
        parcel.writeLong(this.realDuration);
        parcel.writeInt(this.mIsCollect);
        parcel.writeInt(this.mMusicType);
        parcel.writeInt(this.mUsedTime);
        parcel.writeByte(this.isLoading ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isPlaying ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.downloadRetryTimes);
        parcel.writeLong(this.mClipStartTime);
        parcel.writeByte(this.isChoosedBySticker ? (byte) 1 : (byte) 0);
    }
}
