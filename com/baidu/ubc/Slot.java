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
        /* renamed from: xW */
        public Slot[] newArray(int i) {
            return new Slot[i];
        }
    };
    private long igu;
    private long igv;
    private JSONObject igw;
    private float igx;
    private String mCategory;

    public Slot(String str, long j, JSONObject jSONObject) {
        this.igu = 0L;
        this.igv = 0L;
        this.igu = j;
        this.mCategory = str;
        this.igw = jSONObject;
    }

    protected Slot(Parcel parcel) {
        this.igu = 0L;
        this.igv = 0L;
        this.igu = parcel.readLong();
        this.igv = parcel.readLong();
        this.mCategory = parcel.readString();
        this.igx = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.igu);
        parcel.writeLong(this.igv);
        parcel.writeString(this.mCategory);
        parcel.writeFloat(this.igx);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setEnd(long j) {
        if (j > 0 && j > this.igu) {
            this.igv = j;
            this.igx = (((float) (this.igv - this.igu)) / 1000.0f) + this.igx;
        }
    }

    public void az(JSONObject jSONObject) {
        this.igw = jSONObject;
    }

    public boolean bSN() {
        return this.igu > 0;
    }

    public boolean bSO() {
        return this.igv > 0;
    }

    public void clean() {
        this.igu = 0L;
        this.igv = 0L;
    }

    public JSONObject bSP() {
        JSONObject jSONObject;
        JSONException e;
        if (TextUtils.isEmpty(this.mCategory) || this.igx <= 0.0f) {
            return null;
        }
        String format = String.format("%.3f", Float.valueOf(this.igx));
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e2) {
            jSONObject = null;
            e = e2;
        }
        try {
            jSONObject.put("id", this.mCategory);
            jSONObject.put("d", format);
            if (this.igw != null) {
                jSONObject.put("info", this.igw);
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
