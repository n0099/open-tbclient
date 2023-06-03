package com.baidu.ugc.editvideo.player;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
/* loaded from: classes8.dex */
public class AudioPlayData implements Parcelable, Serializable, Cloneable {
    public static final Parcelable.Creator<AudioPlayData> CREATOR = new Parcelable.Creator<AudioPlayData>() { // from class: com.baidu.ugc.editvideo.player.AudioPlayData.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AudioPlayData createFromParcel(Parcel parcel) {
            return new AudioPlayData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AudioPlayData[] newArray(int i) {
            return new AudioPlayData[i];
        }
    };
    public String audioName;
    public String audioPath;
    public int end;
    public String id;
    public int[] mSoundTypes;
    public float mSpeed;
    public int offset;
    public int realDuration;
    public int relativeMaxDuration;
    public int start;
    public float volume;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private boolean hasSoundTypes() {
        int[] iArr = this.mSoundTypes;
        if (iArr == null || iArr.length == 0) {
            return false;
        }
        boolean z = false;
        for (int i : iArr) {
            if (i > 0) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public AudioPlayData m153clone() {
        try {
            return (AudioPlayData) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isNeedEdit() {
        if (!hasSoundTypes() && this.mSpeed == 1.0f && this.start == 0 && this.end <= 0 && this.volume == 1.0f) {
            return false;
        }
        return true;
    }

    public AudioPlayData(Parcel parcel) {
        this.mSpeed = 1.0f;
        this.id = parcel.readString();
        this.audioPath = parcel.readString();
        this.audioName = parcel.readString();
        this.offset = parcel.readInt();
        this.start = parcel.readInt();
        this.end = parcel.readInt();
        this.realDuration = parcel.readInt();
        this.relativeMaxDuration = parcel.readInt();
        this.volume = parcel.readFloat();
        this.mSpeed = parcel.readFloat();
        this.mSoundTypes = parcel.createIntArray();
    }

    public AudioPlayData(String str, int i, int i2, float f) {
        this(str, i, i2, f, 1.0f);
    }

    public AudioPlayData(String str, int i, int i2, float f, float f2) {
        this(str, i, i2, f, f2, null);
    }

    public AudioPlayData(String str, int i, int i2, float f, float f2, int[] iArr) {
        this.mSpeed = 1.0f;
        this.audioPath = str;
        this.start = i;
        this.end = i2;
        this.volume = f;
        if (i2 < i) {
            this.end = i;
        }
        this.mSpeed = f2;
        this.mSoundTypes = iArr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.audioPath);
        parcel.writeString(this.audioName);
        parcel.writeInt(this.offset);
        parcel.writeInt(this.start);
        parcel.writeInt(this.end);
        parcel.writeInt(this.realDuration);
        parcel.writeInt(this.relativeMaxDuration);
        parcel.writeFloat(this.volume);
        parcel.writeFloat(this.mSpeed);
        parcel.writeIntArray(this.mSoundTypes);
    }
}
