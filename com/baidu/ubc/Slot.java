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
        /* renamed from: wR */
        public Slot[] newArray(int i) {
            return new Slot[i];
        }
    };
    private long hTf;
    private long hTg;
    private JSONObject hTh;
    private float hTi;
    private String mCategory;

    public Slot(String str, long j, JSONObject jSONObject) {
        this.hTf = 0L;
        this.hTg = 0L;
        this.hTf = j;
        this.mCategory = str;
        this.hTh = jSONObject;
    }

    protected Slot(Parcel parcel) {
        this.hTf = 0L;
        this.hTg = 0L;
        this.hTf = parcel.readLong();
        this.hTg = parcel.readLong();
        this.mCategory = parcel.readString();
        this.hTi = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.hTf);
        parcel.writeLong(this.hTg);
        parcel.writeString(this.mCategory);
        parcel.writeFloat(this.hTi);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setEnd(long j) {
        if (j > 0 && j > this.hTf) {
            this.hTg = j;
            this.hTi = (((float) (this.hTg - this.hTf)) / 1000.0f) + this.hTi;
        }
    }

    public void ax(JSONObject jSONObject) {
        this.hTh = jSONObject;
    }

    public boolean bPK() {
        return this.hTf > 0;
    }

    public boolean bPL() {
        return this.hTg > 0;
    }

    public void clean() {
        this.hTf = 0L;
        this.hTg = 0L;
    }

    public JSONObject bPM() {
        JSONObject jSONObject;
        JSONException e;
        if (TextUtils.isEmpty(this.mCategory) || this.hTi <= 0.0f) {
            return null;
        }
        String format = String.format("%.3f", Float.valueOf(this.hTi));
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e2) {
            jSONObject = null;
            e = e2;
        }
        try {
            jSONObject.put("id", this.mCategory);
            jSONObject.put("d", format);
            if (this.hTh != null) {
                jSONObject.put("info", this.hTh);
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
