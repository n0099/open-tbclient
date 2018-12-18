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
        /* renamed from: A */
        public Slot createFromParcel(Parcel parcel) {
            return new Slot(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: xH */
        public Slot[] newArray(int i) {
            return new Slot[i];
        }
    };
    private long ibZ;
    private long ica;
    private JSONObject icb;
    private float icc;
    private String mCategory;

    public Slot(String str, long j, JSONObject jSONObject) {
        this.ibZ = 0L;
        this.ica = 0L;
        this.ibZ = j;
        this.mCategory = str;
        this.icb = jSONObject;
    }

    protected Slot(Parcel parcel) {
        this.ibZ = 0L;
        this.ica = 0L;
        this.ibZ = parcel.readLong();
        this.ica = parcel.readLong();
        this.mCategory = parcel.readString();
        this.icc = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.ibZ);
        parcel.writeLong(this.ica);
        parcel.writeString(this.mCategory);
        parcel.writeFloat(this.icc);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setEnd(long j) {
        if (j > 0 && j > this.ibZ) {
            this.ica = j;
            this.icc = (((float) (this.ica - this.ibZ)) / 1000.0f) + this.icc;
        }
    }

    public void az(JSONObject jSONObject) {
        this.icb = jSONObject;
    }

    public boolean bRo() {
        return this.ibZ > 0;
    }

    public boolean bRp() {
        return this.ica > 0;
    }

    public void clean() {
        this.ibZ = 0L;
        this.ica = 0L;
    }

    public JSONObject bRq() {
        JSONObject jSONObject;
        JSONException e;
        if (TextUtils.isEmpty(this.mCategory) || this.icc <= 0.0f) {
            return null;
        }
        String format = String.format("%.3f", Float.valueOf(this.icc));
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e2) {
            jSONObject = null;
            e = e2;
        }
        try {
            jSONObject.put("id", this.mCategory);
            jSONObject.put("d", format);
            if (this.icb != null) {
                jSONObject.put("info", this.icb);
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
