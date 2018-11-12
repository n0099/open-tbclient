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
        /* renamed from: xk */
        public Slot[] newArray(int i) {
            return new Slot[i];
        }
    };
    private long hUP;
    private long hUQ;
    private JSONObject hUR;
    private float hUS;
    private String mCategory;

    public Slot(String str, long j, JSONObject jSONObject) {
        this.hUP = 0L;
        this.hUQ = 0L;
        this.hUP = j;
        this.mCategory = str;
        this.hUR = jSONObject;
    }

    protected Slot(Parcel parcel) {
        this.hUP = 0L;
        this.hUQ = 0L;
        this.hUP = parcel.readLong();
        this.hUQ = parcel.readLong();
        this.mCategory = parcel.readString();
        this.hUS = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.hUP);
        parcel.writeLong(this.hUQ);
        parcel.writeString(this.mCategory);
        parcel.writeFloat(this.hUS);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setEnd(long j) {
        if (j > 0 && j > this.hUP) {
            this.hUQ = j;
            this.hUS = (((float) (this.hUQ - this.hUP)) / 1000.0f) + this.hUS;
        }
    }

    public void ax(JSONObject jSONObject) {
        this.hUR = jSONObject;
    }

    public boolean bPj() {
        return this.hUP > 0;
    }

    public boolean bPk() {
        return this.hUQ > 0;
    }

    public void clean() {
        this.hUP = 0L;
        this.hUQ = 0L;
    }

    public JSONObject bPl() {
        JSONObject jSONObject;
        JSONException e;
        if (TextUtils.isEmpty(this.mCategory) || this.hUS <= 0.0f) {
            return null;
        }
        String format = String.format("%.3f", Float.valueOf(this.hUS));
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e2) {
            jSONObject = null;
            e = e2;
        }
        try {
            jSONObject.put("id", this.mCategory);
            jSONObject.put("d", format);
            if (this.hUR != null) {
                jSONObject.put("info", this.hUR);
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
