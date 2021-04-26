package com.baidu.ubc;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class Flow implements Parcelable {
    public static final int INVALID_HANDLE = -1;
    public static final String TAG = "UBCFlow";
    public int mHandle;
    public String mId;
    public int mOption;
    public HashMap<String, Slot> mSlotMaps;
    public long mStartTime;
    public boolean mValid;
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final Parcelable.Creator<Flow> CREATOR = new a();

    /* loaded from: classes5.dex */
    public static class a implements Parcelable.Creator<Flow> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Flow createFromParcel(Parcel parcel) {
            return new Flow(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public Flow[] newArray(int i2) {
            return new Flow[i2];
        }
    }

    public Flow() {
        this.mValid = true;
        this.mId = "";
        this.mHandle = -1;
        this.mOption = 0;
        this.mStartTime = System.currentTimeMillis();
        this.mSlotMaps = new HashMap<>();
    }

    @Deprecated
    public final void addEvent(String str) {
        addEvent(str, null);
    }

    @Deprecated
    public final void cancel() {
        UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            uBCManager.flowCancel(this);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public final void end() {
        UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            uBCManager.flowEnd(this);
        }
    }

    @Deprecated
    public final void endSlot(String str) {
        UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            uBCManager.flowEndSlot(this, str);
        }
    }

    public int getHandle() {
        return this.mHandle;
    }

    public String getId() {
        return this.mId;
    }

    public int getOption() {
        return this.mOption;
    }

    public HashMap<String, Slot> getSlotMaps() {
        return this.mSlotMaps;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public boolean getValid() {
        return this.mValid;
    }

    public void setValid(boolean z) {
        this.mValid = z;
    }

    @Deprecated
    public final void setValue(String str) {
        UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            uBCManager.flowSetValue(this, str);
        }
    }

    @Deprecated
    public void setValueWithDuration(String str) {
        UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            uBCManager.flowSetValueWithDuration(this, str);
        }
    }

    @Deprecated
    public final void startSlot(String str, JSONObject jSONObject) {
        UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            uBCManager.flowStartSlot(this, str, jSONObject);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mId);
        parcel.writeInt(this.mHandle);
        parcel.writeInt(this.mOption);
        parcel.writeLong(this.mStartTime);
        parcel.writeByte(this.mValid ? (byte) 1 : (byte) 0);
        parcel.writeMap(this.mSlotMaps);
    }

    @Deprecated
    public final void addEvent(String str, String str2) {
        UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            uBCManager.flowAddEvent(this, str, str2);
        }
    }

    @Deprecated
    public void setValue(Map<String, String> map) {
        UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            uBCManager.flowSetValue(this, map);
        }
    }

    @Deprecated
    public final void addEvent(String str, String str2, long j) {
        UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            uBCManager.flowAddEventWithDate(this, str, str2, j);
        }
    }

    public Flow(String str, int i2, int i3) {
        this.mValid = true;
        this.mId = str;
        this.mHandle = i2;
        this.mOption = i3;
        this.mStartTime = System.currentTimeMillis();
        this.mSlotMaps = new HashMap<>();
    }

    public Flow(Parcel parcel) {
        this.mValid = true;
        this.mId = parcel.readString();
        this.mHandle = parcel.readInt();
        this.mOption = parcel.readInt();
        this.mStartTime = parcel.readLong();
        this.mValid = parcel.readByte() != 0;
        this.mSlotMaps = parcel.readHashMap(Flow.class.getClassLoader());
    }
}
