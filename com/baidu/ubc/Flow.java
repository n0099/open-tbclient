package com.baidu.ubc;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.searchbox.config.AppConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes11.dex */
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
        /* renamed from: Ib */
        public Flow[] newArray(int i) {
            return new Flow[i];
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: ai */
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
        aa aaVar = (aa) com.baidu.pyramid.runtime.service.c.a(aa.SERVICE_REFERENCE);
        if (aaVar != null) {
            aaVar.flowAddEvent(this, str, str2);
        }
    }

    @Deprecated
    public final void addEvent(String str, String str2, long j) {
        aa aaVar = (aa) com.baidu.pyramid.runtime.service.c.a(aa.SERVICE_REFERENCE);
        if (aaVar != null) {
            aaVar.a(this, str, str2, j);
        }
    }

    @Deprecated
    public final void setValue(String str) {
        aa aaVar = (aa) com.baidu.pyramid.runtime.service.c.a(aa.SERVICE_REFERENCE);
        if (aaVar != null) {
            aaVar.flowSetValue(this, str);
        }
    }

    @Deprecated
    public void setValue(Map<String, String> map) {
        aa aaVar = (aa) com.baidu.pyramid.runtime.service.c.a(aa.SERVICE_REFERENCE);
        if (aaVar != null) {
            aaVar.a(this, map);
        }
    }

    @Deprecated
    public void setValueWithDuration(String str) {
        aa aaVar = (aa) com.baidu.pyramid.runtime.service.c.a(aa.SERVICE_REFERENCE);
        if (aaVar != null) {
            aaVar.flowSetValueWithDuration(this, str);
        }
    }

    @Deprecated
    public final void end() {
        aa aaVar = (aa) com.baidu.pyramid.runtime.service.c.a(aa.SERVICE_REFERENCE);
        if (aaVar != null) {
            aaVar.flowEnd(this);
        }
    }

    @Deprecated
    public final void cancel() {
        aa aaVar = (aa) com.baidu.pyramid.runtime.service.c.a(aa.SERVICE_REFERENCE);
        if (aaVar != null) {
            aaVar.flowCancel(this);
        }
    }

    @Deprecated
    public final void startSlot(String str, JSONObject jSONObject) {
        aa aaVar = (aa) com.baidu.pyramid.runtime.service.c.a(aa.SERVICE_REFERENCE);
        if (aaVar != null) {
            aaVar.a(this, str, jSONObject);
        }
    }

    @Deprecated
    public final void endSlot(String str) {
        aa aaVar = (aa) com.baidu.pyramid.runtime.service.c.a(aa.SERVICE_REFERENCE);
        if (aaVar != null) {
            aaVar.flowEndSlot(this, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getId() {
        return this.mId;
    }

    public int getHandle() {
        return this.mHandle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getOption() {
        return this.mOption;
    }

    public boolean getValid() {
        return this.mValid;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setValid(boolean z) {
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
