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
        /* renamed from: xF */
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
    private int ibQ;
    private int ibT;
    private HashMap<String, Slot> ibU;
    private String mId;
    private long mStartTime;
    private boolean mValid;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Flow() {
        this.mValid = true;
        this.ibU = new HashMap<>();
        this.mId = "";
        this.ibT = -1;
        this.ibQ = 0;
        this.mStartTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Flow(String str, int i, int i2) {
        this.mValid = true;
        this.ibU = new HashMap<>();
        this.mId = str;
        this.ibT = i;
        this.ibQ = i2;
        this.mStartTime = System.currentTimeMillis();
    }

    private Flow(Parcel parcel) {
        this.mValid = true;
        this.ibU = new HashMap<>();
        this.mId = parcel.readString();
        this.ibT = parcel.readInt();
        this.ibQ = parcel.readInt();
        this.mStartTime = parcel.readLong();
        this.mValid = parcel.readByte() != 0;
        this.ibU = parcel.readHashMap(HashMap.class.getClassLoader());
    }

    public final void cZ(String str, String str2) {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.uL()) {
                d.bQP().a(this.mId, str, this.ibT, str2, this.ibQ);
                return;
            }
            try {
                o.bRt().flowAddEvent(this, str, str2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void e(String str, String str2, long j) {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.uL()) {
                d.bQP().a(this.mId, str, this.ibT, str2, j, this.ibQ);
                return;
            }
            try {
                o.bRt().flowAddEventWithTime(this, str, str2, j);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void setValue(String str) {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.uL()) {
                d.bQP().n(this.mId, this.ibT, str);
                return;
            }
            try {
                o.bRt().flowSetValue(this, str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void yg(String str) {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.uL()) {
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
                d.bQP().n(this.mId, this.ibT, jSONObject.toString());
                return;
            }
            try {
                o.bRt().flowSetValueWithDuration(this, str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void end() {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.uL()) {
                JSONArray jSONArray = new JSONArray();
                if (this.ibU != null && (r3 = this.ibU.entrySet().iterator()) != null) {
                    for (Map.Entry<String, Slot> entry : this.ibU.entrySet()) {
                        Slot value = entry.getValue();
                        if (value.bRp() && !value.bRq()) {
                            value.setEnd(System.currentTimeMillis());
                        }
                        JSONObject bRr = entry.getValue().bRr();
                        if (bRr != null) {
                            jSONArray.put(bRr);
                        }
                    }
                }
                d.bQP().a(this.mId, this.ibT, jSONArray);
                return;
            }
            try {
                o.bRt().flowEnd(this);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void cancel() {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.uL()) {
                d.bQP().bb(this.mId, this.ibT);
                return;
            }
            try {
                o.bRt().flowCancel(this);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void h(String str, JSONObject jSONObject) {
        if (this.mValid && !TextUtils.isEmpty(str)) {
            Slot slot = this.ibU.get(str);
            if (slot == null) {
                this.ibU.put(str, new Slot(str, System.currentTimeMillis(), jSONObject));
                return;
            }
            slot.az(jSONObject);
        }
    }

    public final void yh(String str) {
        Slot slot;
        if (this.mValid && !TextUtils.isEmpty(str) && (slot = this.ibU.get(str)) != null && slot.bRp()) {
            slot.setEnd(System.currentTimeMillis());
            slot.clean();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getId() {
        return this.mId;
    }

    public int getHandle() {
        return this.ibT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bRe() {
        return this.ibQ;
    }

    public boolean bRi() {
        return this.mValid;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void oL(boolean z) {
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
        parcel.writeInt(this.ibT);
        parcel.writeInt(this.ibQ);
        parcel.writeLong(this.mStartTime);
        parcel.writeByte((byte) (this.mValid ? 1 : 0));
        parcel.writeMap(this.ibU);
    }
}
