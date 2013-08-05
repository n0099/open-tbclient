package com.baidu.video.download;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mm.sdk.conversation.RConversation;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class JNITaskCreateParam implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.baidu.video.download.JNITaskCreateParam.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        public JNITaskCreateParam[] newArray(int i) {
            return new JNITaskCreateParam[i];
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        public JNITaskCreateParam createFromParcel(Parcel parcel) {
            return new JNITaskCreateParam(parcel, null);
        }
    };
    private int nFlag;
    private long nHandle;
    private String strFileName;
    private String strRefer;
    private String strSavePath;
    private String strUrl;

    /* loaded from: classes.dex */
    public class FlagType {
        public static final int NormalNoSplit = 1;
        public static final int NormalSplit = 3;
        public static final int StreamFile = 2;
        public static final int StreamMemory = 4;

        public FlagType() {
        }
    }

    public JNITaskCreateParam() {
        this.nHandle = 0L;
        this.strUrl = "";
        this.strRefer = "";
        this.strSavePath = "";
    }

    public long getHandle() {
        return this.nHandle;
    }

    public void setHandle(long j) {
        this.nHandle = j;
    }

    public String getUrl() {
        return this.strUrl;
    }

    public void setUrl(String str) {
        this.strUrl = str;
    }

    public String getRefer() {
        return this.strRefer;
    }

    public void setRefer(String str) {
        this.strRefer = str;
    }

    public String getSavePath() {
        return this.strSavePath;
    }

    public void setSavePath(String str) {
        this.strSavePath = str;
    }

    public String getFileName() {
        return this.strFileName;
    }

    public void setFileName(String str) {
        this.strFileName = str;
    }

    public int getFlag() {
        return this.nFlag;
    }

    public void setFlag(int i) {
        this.nFlag = i;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fileName", this.strFileName);
            jSONObject.put("savePath", this.strSavePath);
            jSONObject.put("url", this.strUrl);
            jSONObject.put(RConversation.COL_FLAG, this.nFlag);
            jSONObject.put("handle", this.nHandle);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    private JNITaskCreateParam(Parcel parcel) {
        this.nHandle = 0L;
        this.strUrl = "";
        this.strRefer = "";
        this.strSavePath = "";
        readFromParcel(parcel);
    }

    /* synthetic */ JNITaskCreateParam(Parcel parcel, JNITaskCreateParam jNITaskCreateParam) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.nHandle);
        parcel.writeString(this.strUrl);
        parcel.writeString(this.strRefer);
        parcel.writeString(this.strSavePath);
        parcel.writeString(this.strFileName);
        parcel.writeInt(this.nFlag);
    }

    public void readFromParcel(Parcel parcel) {
        this.nHandle = parcel.readLong();
        this.strUrl = parcel.readString();
        this.strRefer = parcel.readString();
        this.strSavePath = parcel.readString();
        this.strFileName = parcel.readString();
        this.nFlag = parcel.readInt();
    }
}
