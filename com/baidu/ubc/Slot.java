package com.baidu.ubc;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class Slot implements Parcelable {
    public static final Parcelable.Creator<Slot> CREATOR = new Parcelable.Creator<Slot>() { // from class: com.baidu.ubc.Slot.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: Z */
        public Slot createFromParcel(Parcel parcel) {
            return new Slot(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: BS */
        public Slot[] newArray(int i) {
            return new Slot[i];
        }
    };
    private long bPc;
    private JSONObject bPd;
    private float bPe;
    private String mCategory;
    private long mStart;

    public Slot(String str, long j, JSONObject jSONObject) {
        this.mStart = 0L;
        this.bPc = 0L;
        this.mStart = j;
        this.mCategory = str;
        this.bPd = jSONObject;
    }

    protected Slot(Parcel parcel) {
        this.mStart = 0L;
        this.bPc = 0L;
        this.mStart = parcel.readLong();
        this.bPc = parcel.readLong();
        this.mCategory = parcel.readString();
        this.bPe = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mStart);
        parcel.writeLong(this.bPc);
        parcel.writeString(this.mCategory);
        parcel.writeFloat(this.bPe);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void ag(long j) {
        if (j > 0 && j > this.mStart) {
            this.bPc = j;
            this.bPe = (((float) (this.bPc - this.mStart)) / 1000.0f) + this.bPe;
        }
    }

    public void bq(JSONObject jSONObject) {
        this.bPd = jSONObject;
    }

    public boolean adc() {
        return this.mStart > 0;
    }

    public boolean add() {
        return this.bPc > 0;
    }

    public void clean() {
        this.mStart = 0L;
        this.bPc = 0L;
    }

    public JSONObject ade() {
        JSONObject jSONObject;
        JSONException e;
        if (TextUtils.isEmpty(this.mCategory) || this.bPe <= 0.0f) {
            return null;
        }
        String format = String.format("%.3f", Float.valueOf(this.bPe));
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e2) {
            jSONObject = null;
            e = e2;
        }
        try {
            jSONObject.put("id", this.mCategory);
            jSONObject.put("d", format);
            if (this.bPd != null) {
                jSONObject.put(Config.LAUNCH_INFO, this.bPd);
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
