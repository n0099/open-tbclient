package com.baidu.ubc;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
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
        /* renamed from: Ni */
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

    public Slot(String str, long j, JSONObject jSONObject) {
        this.mStart = 0L;
        this.mEnd = 0L;
        this.mStart = j;
        this.mCategory = str;
        this.mOption = jSONObject;
    }

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

    public void setEnd(long j) {
        this.mEnd = j;
        if (j > 0 && j > this.mStart) {
            this.mDuration = (((float) (this.mEnd - this.mStart)) / 1000.0f) + this.mDuration;
        }
    }

    public void dg(JSONObject jSONObject) {
        this.mOption = jSONObject;
    }

    public boolean bdX() {
        return this.mStart > 0;
    }

    public boolean bdY() {
        return this.mEnd > 0;
    }

    public JSONObject bdZ() {
        JSONObject jSONObject;
        JSONException e;
        if (TextUtils.isEmpty(this.mCategory) || this.mDuration <= 0.0f) {
            return null;
        }
        String format = String.format("%.3f", Float.valueOf(this.mDuration));
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e2) {
            jSONObject = null;
            e = e2;
        }
        try {
            jSONObject.put("id", this.mCategory);
            jSONObject.put("d", format);
            if (this.mOption != null) {
                jSONObject.put("info", this.mOption);
                return jSONObject;
            }
            return jSONObject;
        } catch (JSONException e3) {
            e = e3;
            e.printStackTrace();
            return jSONObject;
        }
    }
}
