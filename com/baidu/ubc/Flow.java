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
        /* renamed from: xS */
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
    private int ifd;
    private int ifg;
    private HashMap<String, Slot> ifh;
    private String mId;
    private long mStartTime;
    private boolean mValid;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Flow() {
        this.mValid = true;
        this.ifh = new HashMap<>();
        this.mId = "";
        this.ifg = -1;
        this.ifd = 0;
        this.mStartTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Flow(String str, int i, int i2) {
        this.mValid = true;
        this.ifh = new HashMap<>();
        this.mId = str;
        this.ifg = i;
        this.ifd = i2;
        this.mStartTime = System.currentTimeMillis();
    }

    private Flow(Parcel parcel) {
        this.mValid = true;
        this.ifh = new HashMap<>();
        this.mId = parcel.readString();
        this.ifg = parcel.readInt();
        this.ifd = parcel.readInt();
        this.mStartTime = parcel.readLong();
        this.mValid = parcel.readByte() != 0;
        this.ifh = parcel.readHashMap(HashMap.class.getClassLoader());
    }

    public final void cZ(String str, String str2) {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.uL()) {
                d.bRF().a(this.mId, str, this.ifg, str2, this.ifd);
                return;
            }
            try {
                o.bSj().flowAddEvent(this, str, str2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void e(String str, String str2, long j) {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.uL()) {
                d.bRF().a(this.mId, str, this.ifg, str2, j, this.ifd);
                return;
            }
            try {
                o.bSj().flowAddEventWithTime(this, str, str2, j);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void setValue(String str) {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.uL()) {
                d.bRF().n(this.mId, this.ifg, str);
                return;
            }
            try {
                o.bSj().flowSetValue(this, str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void yj(String str) {
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
                d.bRF().n(this.mId, this.ifg, jSONObject.toString());
                return;
            }
            try {
                o.bSj().flowSetValueWithDuration(this, str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void end() {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.uL()) {
                JSONArray jSONArray = new JSONArray();
                if (this.ifh != null && (r3 = this.ifh.entrySet().iterator()) != null) {
                    for (Map.Entry<String, Slot> entry : this.ifh.entrySet()) {
                        Slot value = entry.getValue();
                        if (value.bSf() && !value.bSg()) {
                            value.setEnd(System.currentTimeMillis());
                        }
                        JSONObject bSh = entry.getValue().bSh();
                        if (bSh != null) {
                            jSONArray.put(bSh);
                        }
                    }
                }
                d.bRF().a(this.mId, this.ifg, jSONArray);
                return;
            }
            try {
                o.bSj().flowEnd(this);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void cancel() {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.uL()) {
                d.bRF().bc(this.mId, this.ifg);
                return;
            }
            try {
                o.bSj().flowCancel(this);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void h(String str, JSONObject jSONObject) {
        if (this.mValid && !TextUtils.isEmpty(str)) {
            Slot slot = this.ifh.get(str);
            if (slot == null) {
                this.ifh.put(str, new Slot(str, System.currentTimeMillis(), jSONObject));
                return;
            }
            slot.az(jSONObject);
        }
    }

    public final void yk(String str) {
        Slot slot;
        if (this.mValid && !TextUtils.isEmpty(str) && (slot = this.ifh.get(str)) != null && slot.bSf()) {
            slot.setEnd(System.currentTimeMillis());
            slot.clean();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getId() {
        return this.mId;
    }

    public int getHandle() {
        return this.ifg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bRU() {
        return this.ifd;
    }

    public boolean bRY() {
        return this.mValid;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void oO(boolean z) {
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
        parcel.writeInt(this.ifg);
        parcel.writeInt(this.ifd);
        parcel.writeLong(this.mStartTime);
        parcel.writeByte((byte) (this.mValid ? 1 : 0));
        parcel.writeMap(this.ifh);
    }
}
