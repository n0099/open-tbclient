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
        /* renamed from: xU */
        public Slot[] newArray(int i) {
            return new Slot[i];
        }
    };
    private long ifm;
    private long ifn;
    private JSONObject ifo;
    private float ifp;
    private String mCategory;

    public Slot(String str, long j, JSONObject jSONObject) {
        this.ifm = 0L;
        this.ifn = 0L;
        this.ifm = j;
        this.mCategory = str;
        this.ifo = jSONObject;
    }

    protected Slot(Parcel parcel) {
        this.ifm = 0L;
        this.ifn = 0L;
        this.ifm = parcel.readLong();
        this.ifn = parcel.readLong();
        this.mCategory = parcel.readString();
        this.ifp = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.ifm);
        parcel.writeLong(this.ifn);
        parcel.writeString(this.mCategory);
        parcel.writeFloat(this.ifp);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setEnd(long j) {
        if (j > 0 && j > this.ifm) {
            this.ifn = j;
            this.ifp = (((float) (this.ifn - this.ifm)) / 1000.0f) + this.ifp;
        }
    }

    public void az(JSONObject jSONObject) {
        this.ifo = jSONObject;
    }

    public boolean bSf() {
        return this.ifm > 0;
    }

    public boolean bSg() {
        return this.ifn > 0;
    }

    public void clean() {
        this.ifm = 0L;
        this.ifn = 0L;
    }

    public JSONObject bSh() {
        JSONObject jSONObject;
        JSONException e;
        if (TextUtils.isEmpty(this.mCategory) || this.ifp <= 0.0f) {
            return null;
        }
        String format = String.format("%.3f", Float.valueOf(this.ifp));
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e2) {
            jSONObject = null;
            e = e2;
        }
        try {
            jSONObject.put("id", this.mCategory);
            jSONObject.put("d", format);
            if (this.ifo != null) {
                jSONObject.put("info", this.ifo);
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
