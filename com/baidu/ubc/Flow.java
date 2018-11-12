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
        /* renamed from: xi */
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
    private int hUG;
    private int hUJ;
    private HashMap<String, Slot> hUK;
    private String mId;
    private long mStartTime;
    private boolean mValid;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Flow() {
        this.mValid = true;
        this.hUK = new HashMap<>();
        this.mId = "";
        this.hUJ = -1;
        this.hUG = 0;
        this.mStartTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Flow(String str, int i, int i2) {
        this.mValid = true;
        this.hUK = new HashMap<>();
        this.mId = str;
        this.hUJ = i;
        this.hUG = i2;
        this.mStartTime = System.currentTimeMillis();
    }

    private Flow(Parcel parcel) {
        this.mValid = true;
        this.hUK = new HashMap<>();
        this.mId = parcel.readString();
        this.hUJ = parcel.readInt();
        this.hUG = parcel.readInt();
        this.mStartTime = parcel.readLong();
        this.mValid = parcel.readByte() != 0;
        this.hUK = parcel.readHashMap(HashMap.class.getClassLoader());
    }

    public final void cU(String str, String str2) {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.ur()) {
                d.bOJ().a(this.mId, str, this.hUJ, str2, this.hUG);
                return;
            }
            try {
                o.bPn().flowAddEvent(this, str, str2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void e(String str, String str2, long j) {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.ur()) {
                d.bOJ().a(this.mId, str, this.hUJ, str2, j, this.hUG);
                return;
            }
            try {
                o.bPn().flowAddEventWithTime(this, str, str2, j);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void setValue(String str) {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.ur()) {
                d.bOJ().n(this.mId, this.hUJ, str);
                return;
            }
            try {
                o.bPn().flowSetValue(this, str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void xD(String str) {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.ur()) {
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
                d.bOJ().n(this.mId, this.hUJ, jSONObject.toString());
                return;
            }
            try {
                o.bPn().flowSetValueWithDuration(this, str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void end() {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.ur()) {
                JSONArray jSONArray = new JSONArray();
                if (this.hUK != null && (r3 = this.hUK.entrySet().iterator()) != null) {
                    for (Map.Entry<String, Slot> entry : this.hUK.entrySet()) {
                        Slot value = entry.getValue();
                        if (value.bPj() && !value.bPk()) {
                            value.setEnd(System.currentTimeMillis());
                        }
                        JSONObject bPl = entry.getValue().bPl();
                        if (bPl != null) {
                            jSONArray.put(bPl);
                        }
                    }
                }
                d.bOJ().a(this.mId, this.hUJ, jSONArray);
                return;
            }
            try {
                o.bPn().flowEnd(this);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void cancel() {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.ur()) {
                d.bOJ().ba(this.mId, this.hUJ);
                return;
            }
            try {
                o.bPn().flowCancel(this);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void h(String str, JSONObject jSONObject) {
        if (this.mValid && !TextUtils.isEmpty(str)) {
            Slot slot = this.hUK.get(str);
            if (slot == null) {
                this.hUK.put(str, new Slot(str, System.currentTimeMillis(), jSONObject));
                return;
            }
            slot.ax(jSONObject);
        }
    }

    public final void xE(String str) {
        Slot slot;
        if (this.mValid && !TextUtils.isEmpty(str) && (slot = this.hUK.get(str)) != null && slot.bPj()) {
            slot.setEnd(System.currentTimeMillis());
            slot.clean();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getId() {
        return this.mId;
    }

    public int getHandle() {
        return this.hUJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bOY() {
        return this.hUG;
    }

    public boolean bPc() {
        return this.mValid;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void oJ(boolean z) {
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
        parcel.writeInt(this.hUJ);
        parcel.writeInt(this.hUG);
        parcel.writeLong(this.mStartTime);
        parcel.writeByte((byte) (this.mValid ? 1 : 0));
        parcel.writeMap(this.hUK);
    }
}
