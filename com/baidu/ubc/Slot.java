package com.baidu.ubc;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class Slot implements Parcelable {
    public static final String CATEGORY = "id";
    public static final Parcelable.Creator<Slot> CREATOR = new Parcelable.Creator<Slot>() { // from class: com.baidu.ubc.Slot.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: ak */
        public Slot createFromParcel(Parcel parcel) {
            return new Slot(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: Ep */
        public Slot[] newArray(int i) {
            return new Slot[i];
        }
    };
    private static final int DEFAULT_VALUE = 0;
    public static final String DURATION = "d";
    public static final String INFO = "info";
    private static final int MILLISECOND = 1000;
    private String mCategory;
    private float mDuration;
    private long mEnd;
    private JSONObject mOption;
    private long mStart;

    protected Slot(Parcel parcel) {
        this.mStart = 0L;
        this.mEnd = 0L;
        this.mStart = parcel.readLong();
        this.mEnd = parcel.readLong();
        this.mCategory = parcel.readString();
        this.mDuration = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mStart);
        parcel.writeLong(this.mEnd);
        parcel.writeString(this.mCategory);
        parcel.writeFloat(this.mDuration);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
