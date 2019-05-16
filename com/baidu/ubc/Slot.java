package com.baidu.ubc;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class Slot implements Parcelable {
    public static final Parcelable.Creator<Slot> CREATOR = new Parcelable.Creator<Slot>() { // from class: com.baidu.ubc.Slot.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: U */
        public Slot createFromParcel(Parcel parcel) {
            return new Slot(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: CK */
        public Slot[] newArray(int i) {
            return new Slot[i];
        }
    };
    private long bvY;
    private JSONObject bvZ;
    private float bwa;
    private String mCategory;
    private long mStart;

    public Slot(String str, long j, JSONObject jSONObject) {
        this.mStart = 0L;
        this.bvY = 0L;
        this.mStart = j;
        this.mCategory = str;
        this.bvZ = jSONObject;
    }

    protected Slot(Parcel parcel) {
        this.mStart = 0L;
        this.bvY = 0L;
        this.mStart = parcel.readLong();
        this.bvY = parcel.readLong();
        this.mCategory = parcel.readString();
        this.bwa = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mStart);
        parcel.writeLong(this.bvY);
        parcel.writeString(this.mCategory);
        parcel.writeFloat(this.bwa);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void O(long j) {
        if (j > 0 && j > this.mStart) {
            this.bvY = j;
            this.bwa = (((float) (this.bvY - this.mStart)) / 1000.0f) + this.bwa;
        }
    }

    public void aR(JSONObject jSONObject) {
        this.bvZ = jSONObject;
    }

    public boolean Xo() {
        return this.mStart > 0;
    }

    public boolean Xp() {
        return this.bvY > 0;
    }

    public void clean() {
        this.mStart = 0L;
        this.bvY = 0L;
    }

    public JSONObject Xq() {
        JSONObject jSONObject;
        JSONException e;
        if (TextUtils.isEmpty(this.mCategory) || this.bwa <= 0.0f) {
            return null;
        }
        String format = String.format("%.3f", Float.valueOf(this.bwa));
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e2) {
            jSONObject = null;
            e = e2;
        }
        try {
            jSONObject.put("id", this.mCategory);
            jSONObject.put("d", format);
            if (this.bvZ != null) {
                jSONObject.put("info", this.bvZ);
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
