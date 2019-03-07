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
        /* renamed from: R */
        public Slot createFromParcel(Parcel parcel) {
            return new Slot(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: BJ */
        public Slot[] newArray(int i) {
            return new Slot[i];
        }
    };
    private long bpE;
    private JSONObject bpF;
    private float bpG;
    private String mCategory;
    private long mStart;

    public Slot(String str, long j, JSONObject jSONObject) {
        this.mStart = 0L;
        this.bpE = 0L;
        this.mStart = j;
        this.mCategory = str;
        this.bpF = jSONObject;
    }

    protected Slot(Parcel parcel) {
        this.mStart = 0L;
        this.bpE = 0L;
        this.mStart = parcel.readLong();
        this.bpE = parcel.readLong();
        this.mCategory = parcel.readString();
        this.bpG = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mStart);
        parcel.writeLong(this.bpE);
        parcel.writeString(this.mCategory);
        parcel.writeFloat(this.bpG);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void C(long j) {
        if (j > 0 && j > this.mStart) {
            this.bpE = j;
            this.bpG = (((float) (this.bpE - this.mStart)) / 1000.0f) + this.bpG;
        }
    }

    public void aF(JSONObject jSONObject) {
        this.bpF = jSONObject;
    }

    public boolean Tp() {
        return this.mStart > 0;
    }

    public boolean Tq() {
        return this.bpE > 0;
    }

    public void clean() {
        this.mStart = 0L;
        this.bpE = 0L;
    }

    public JSONObject Tr() {
        JSONObject jSONObject;
        JSONException e;
        if (TextUtils.isEmpty(this.mCategory) || this.bpG <= 0.0f) {
            return null;
        }
        String format = String.format("%.3f", Float.valueOf(this.bpG));
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e2) {
            jSONObject = null;
            e = e2;
        }
        try {
            jSONObject.put("id", this.mCategory);
            jSONObject.put("d", format);
            if (this.bpF != null) {
                jSONObject.put("info", this.bpF);
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
