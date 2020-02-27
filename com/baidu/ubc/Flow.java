package com.baidu.ubc;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.pyramid.runtime.service.c;
import com.baidu.searchbox.config.AppConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class Flow implements Parcelable {
    private static final int INVALID_HANDLE = -1;
    public static final String TAG = "UBCFlow";
    private int mHandle;
    private String mId;
    private int mOption;
    private HashMap<String, Slot> mSlotMaps;
    private long mStartTime;
    private boolean mValid;
    private static final boolean DEBUG = AppConfig.isDebug();
    public static final Parcelable.Creator<Flow> CREATOR = new Parcelable.Creator<Flow>() { // from class: com.baidu.ubc.Flow.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: Ey */
        public Flow[] newArray(int i) {
            return new Flow[i];
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: aj */
        public Flow createFromParcel(Parcel parcel) {
            return new Flow(parcel);
        }
    };

    public Flow() {
        this.mValid = true;
        this.mId = "";
        this.mHandle = -1;
        this.mOption = 0;
        this.mStartTime = System.currentTimeMillis();
        this.mSlotMaps = new HashMap<>();
    }

    public Flow(String str, int i, int i2) {
        this.mValid = true;
        this.mId = str;
        this.mHandle = i;
        this.mOption = i2;
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

    @Deprecated
    public final void addEvent(String str) {
        addEvent(str, null);
    }

    @Deprecated
    public final void addEvent(String str, String str2) {
        a aVar = (a) c.a(a.SERVICE_REFERENCE);
        if (aVar != null) {
            aVar.a(this, str, str2);
        }
    }

    @Deprecated
    public final void addEvent(String str, String str2, long j) {
        a aVar = (a) c.a(a.SERVICE_REFERENCE);
        if (aVar != null) {
            aVar.a(this, str, str2, j);
        }
    }

    @Deprecated
    public final void setValue(String str) {
        a aVar = (a) c.a(a.SERVICE_REFERENCE);
        if (aVar != null) {
            aVar.a(this, str);
        }
    }

    @Deprecated
    public void setValue(Map<String, String> map) {
        a aVar = (a) c.a(a.SERVICE_REFERENCE);
        if (aVar != null) {
            aVar.a(this, map);
        }
    }

    @Deprecated
    public void setValueWithDuration(String str) {
        a aVar = (a) c.a(a.SERVICE_REFERENCE);
        if (aVar != null) {
            aVar.b(this, str);
        }
    }

    @Deprecated
    public final void end() {
        a aVar = (a) c.a(a.SERVICE_REFERENCE);
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Deprecated
    public final void cancel() {
        a aVar = (a) c.a(a.SERVICE_REFERENCE);
        if (aVar != null) {
            aVar.b(this);
        }
    }

    @Deprecated
    public final void startSlot(String str, JSONObject jSONObject) {
        a aVar = (a) c.a(a.SERVICE_REFERENCE);
        if (aVar != null) {
            aVar.a(this, str, jSONObject);
        }
    }

    @Deprecated
    public final void endSlot(String str) {
        a aVar = (a) c.a(a.SERVICE_REFERENCE);
        if (aVar != null) {
            aVar.c(this, str);
        }
    }

    String getId() {
        return this.mId;
    }

    public int getHandle() {
        return this.mHandle;
    }

    int getOption() {
        return this.mOption;
    }

    public boolean getValid() {
        return this.mValid;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    void setValid(boolean z) {
        this.mValid = z;
    }

    public HashMap<String, Slot> getSlotMaps() {
        return this.mSlotMaps;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeInt(this.mHandle);
        parcel.writeInt(this.mOption);
        parcel.writeLong(this.mStartTime);
        parcel.writeByte((byte) (this.mValid ? 1 : 0));
        parcel.writeMap(this.mSlotMaps);
    }
}
