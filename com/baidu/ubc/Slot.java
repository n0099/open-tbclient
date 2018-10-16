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
    private long hTe;
    private long hTf;
    private JSONObject hTg;
    private float hTh;
    private String mCategory;

    public Slot(String str, long j, JSONObject jSONObject) {
        this.hTe = 0L;
        this.hTf = 0L;
        this.hTe = j;
        this.mCategory = str;
        this.hTg = jSONObject;
    }

    protected Slot(Parcel parcel) {
        this.hTe = 0L;
        this.hTf = 0L;
        this.hTe = parcel.readLong();
        this.hTf = parcel.readLong();
        this.mCategory = parcel.readString();
        this.hTh = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.hTe);
        parcel.writeLong(this.hTf);
        parcel.writeString(this.mCategory);
        parcel.writeFloat(this.hTh);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setEnd(long j) {
        if (j > 0 && j > this.hTe) {
            this.hTf = j;
            this.hTh = (((float) (this.hTf - this.hTe)) / 1000.0f) + this.hTh;
        }
    }

    public void ax(JSONObject jSONObject) {
        this.hTg = jSONObject;
    }

    public boolean bPK() {
        return this.hTe > 0;
    }

    public boolean bPL() {
        return this.hTf > 0;
    }

    public void clean() {
        this.hTe = 0L;
        this.hTf = 0L;
    }

    public JSONObject bPM() {
        JSONObject jSONObject;
        JSONException e;
        if (TextUtils.isEmpty(this.mCategory) || this.hTh <= 0.0f) {
            return null;
        }
        String format = String.format("%.3f", Float.valueOf(this.hTh));
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e2) {
            jSONObject = null;
            e = e2;
        }
        try {
            jSONObject.put("id", this.mCategory);
            jSONObject.put("d", format);
            if (this.hTg != null) {
                jSONObject.put("info", this.hTg);
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
