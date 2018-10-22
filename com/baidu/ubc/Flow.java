package com.baidu.ubc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class Flow implements Parcelable {
    public static final Parcelable.Creator<Flow> CREATOR = new Parcelable.Creator<Flow>() { // from class: com.baidu.ubc.Flow.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: wP */
        public Flow[] newArray(int i) {
            return new Flow[i];
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: z */
        public Flow createFromParcel(Parcel parcel) {
            return new Flow(parcel);
        }
    };
    private int hSW;
    private int hSZ;
    private HashMap<String, Slot> hTa;
    private String mId;
    private long mStartTime;
    private boolean mValid;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Flow() {
        this.mValid = true;
        this.hTa = new HashMap<>();
        this.mId = "";
        this.hSZ = -1;
        this.hSW = 0;
        this.mStartTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Flow(String str, int i, int i2) {
        this.mValid = true;
        this.hTa = new HashMap<>();
        this.mId = str;
        this.hSZ = i;
        this.hSW = i2;
        this.mStartTime = System.currentTimeMillis();
    }

    private Flow(Parcel parcel) {
        this.mValid = true;
        this.hTa = new HashMap<>();
        this.mId = parcel.readString();
        this.hSZ = parcel.readInt();
        this.hSW = parcel.readInt();
        this.mStartTime = parcel.readLong();
        this.mValid = parcel.readByte() != 0;
        this.hTa = parcel.readHashMap(HashMap.class.getClassLoader());
    }

    public final void cU(String str, String str2) {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.uh()) {
                d.bPk().a(this.mId, str, this.hSZ, str2, this.hSW);
                return;
            }
            try {
                o.bPO().flowAddEvent(this, str, str2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void d(String str, String str2, long j) {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.uh()) {
                d.bPk().a(this.mId, str, this.hSZ, str2, j, this.hSW);
                return;
            }
            try {
                o.bPO().flowAddEventWithTime(this, str, str2, j);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void setValue(String str) {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.uh()) {
                d.bPk().n(this.mId, this.hSZ, str);
                return;
            }
            try {
                o.bPO().flowSetValue(this, str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void xy(String str) {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.uh()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    float currentTimeMillis = ((float) (System.currentTimeMillis() - this.mStartTime)) / 1000.0f;
                    jSONObject.put("duration", String.format(Locale.ENGLISH, "%.3f", Float.valueOf(currentTimeMillis >= 0.0f ? currentTimeMillis : 0.0f)));
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("option", str);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                d.bPk().n(this.mId, this.hSZ, jSONObject.toString());
                return;
            }
            try {
                o.bPO().flowSetValueWithDuration(this, str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void end() {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.uh()) {
                JSONArray jSONArray = new JSONArray();
                if (this.hTa != null && (r3 = this.hTa.entrySet().iterator()) != null) {
                    for (Map.Entry<String, Slot> entry : this.hTa.entrySet()) {
                        Slot value = entry.getValue();
                        if (value.bPK() && !value.bPL()) {
                            value.setEnd(System.currentTimeMillis());
                        }
                        JSONObject bPM = entry.getValue().bPM();
                        if (bPM != null) {
                            jSONArray.put(bPM);
                        }
                    }
                }
                d.bPk().a(this.mId, this.hSZ, jSONArray);
                return;
            }
            try {
                o.bPO().flowEnd(this);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void cancel() {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.uh()) {
                d.bPk().ba(this.mId, this.hSZ);
                return;
            }
            try {
                o.bPO().flowCancel(this);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void h(String str, JSONObject jSONObject) {
        if (this.mValid && !TextUtils.isEmpty(str)) {
            Slot slot = this.hTa.get(str);
            if (slot == null) {
                this.hTa.put(str, new Slot(str, System.currentTimeMillis(), jSONObject));
                return;
            }
            slot.ax(jSONObject);
        }
    }

    public final void xz(String str) {
        Slot slot;
        if (this.mValid && !TextUtils.isEmpty(str) && (slot = this.hTa.get(str)) != null && slot.bPK()) {
            slot.setEnd(System.currentTimeMillis());
            slot.clean();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getId() {
        return this.mId;
    }

    public int getHandle() {
        return this.hSZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bPz() {
        return this.hSW;
    }

    public boolean bPD() {
        return this.mValid;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ov(boolean z) {
        this.mValid = z;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeInt(this.hSZ);
        parcel.writeInt(this.hSW);
        parcel.writeLong(this.mStartTime);
        parcel.writeByte((byte) (this.mValid ? 1 : 0));
        parcel.writeMap(this.hTa);
    }
}
