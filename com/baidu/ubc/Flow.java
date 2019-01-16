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
        /* renamed from: xU */
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
    private int igk;
    private int ign;
    private HashMap<String, Slot> igo;
    private String mId;
    private long mStartTime;
    private boolean mValid;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Flow() {
        this.mValid = true;
        this.igo = new HashMap<>();
        this.mId = "";
        this.ign = -1;
        this.igk = 0;
        this.mStartTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Flow(String str, int i, int i2) {
        this.mValid = true;
        this.igo = new HashMap<>();
        this.mId = str;
        this.ign = i;
        this.igk = i2;
        this.mStartTime = System.currentTimeMillis();
    }

    private Flow(Parcel parcel) {
        this.mValid = true;
        this.igo = new HashMap<>();
        this.mId = parcel.readString();
        this.ign = parcel.readInt();
        this.igk = parcel.readInt();
        this.mStartTime = parcel.readLong();
        this.mValid = parcel.readByte() != 0;
        this.igo = parcel.readHashMap(HashMap.class.getClassLoader());
    }

    public final void db(String str, String str2) {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.uP()) {
                d.bSn().a(this.mId, str, this.ign, str2, this.igk);
                return;
            }
            try {
                o.bSR().flowAddEvent(this, str, str2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void e(String str, String str2, long j) {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.uP()) {
                d.bSn().a(this.mId, str, this.ign, str2, j, this.igk);
                return;
            }
            try {
                o.bSR().flowAddEventWithTime(this, str, str2, j);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void setValue(String str) {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.uP()) {
                d.bSn().n(this.mId, this.ign, str);
                return;
            }
            try {
                o.bSR().flowSetValue(this, str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void yz(String str) {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.uP()) {
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
                d.bSn().n(this.mId, this.ign, jSONObject.toString());
                return;
            }
            try {
                o.bSR().flowSetValueWithDuration(this, str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void end() {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.uP()) {
                JSONArray jSONArray = new JSONArray();
                if (this.igo != null && (r3 = this.igo.entrySet().iterator()) != null) {
                    for (Map.Entry<String, Slot> entry : this.igo.entrySet()) {
                        Slot value = entry.getValue();
                        if (value.bSN() && !value.bSO()) {
                            value.setEnd(System.currentTimeMillis());
                        }
                        JSONObject bSP = entry.getValue().bSP();
                        if (bSP != null) {
                            jSONArray.put(bSP);
                        }
                    }
                }
                d.bSn().a(this.mId, this.ign, jSONArray);
                return;
            }
            try {
                o.bSR().flowEnd(this);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void cancel() {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.uP()) {
                d.bSn().bc(this.mId, this.ign);
                return;
            }
            try {
                o.bSR().flowCancel(this);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void i(String str, JSONObject jSONObject) {
        if (this.mValid && !TextUtils.isEmpty(str)) {
            Slot slot = this.igo.get(str);
            if (slot == null) {
                this.igo.put(str, new Slot(str, System.currentTimeMillis(), jSONObject));
                return;
            }
            slot.az(jSONObject);
        }
    }

    public final void yA(String str) {
        Slot slot;
        if (this.mValid && !TextUtils.isEmpty(str) && (slot = this.igo.get(str)) != null && slot.bSN()) {
            slot.setEnd(System.currentTimeMillis());
            slot.clean();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getId() {
        return this.mId;
    }

    public int getHandle() {
        return this.ign;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bSC() {
        return this.igk;
    }

    public boolean bSG() {
        return this.mValid;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void oP(boolean z) {
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
        parcel.writeInt(this.ign);
        parcel.writeInt(this.igk);
        parcel.writeLong(this.mStartTime);
        parcel.writeByte((byte) (this.mValid ? 1 : 0));
        parcel.writeMap(this.igo);
    }
}
