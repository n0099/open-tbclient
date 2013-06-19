package com.baidu.video.download;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class JNITaskInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.baidu.video.download.JNITaskInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        public JNITaskInfo[] newArray(int i) {
            return new JNITaskInfo[i];
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        public JNITaskInfo createFromParcel(Parcel parcel) {
            return new JNITaskInfo(parcel, null);
        }
    };
    public int nDiskFiles;
    public long nDownloadLen;
    public int nDownloadRate;
    public int nErrorCode;
    public long nFileLen;
    public int nStatus;
    public byte[] szFileName;
    public byte[] szUrl;

    public JNITaskInfo() {
        this.szUrl = null;
        this.szFileName = null;
        this.nFileLen = 0L;
        this.nErrorCode = 0;
        this.nStatus = 0;
        this.nDownloadLen = 0L;
        this.nDownloadRate = 0;
        this.nDiskFiles = 0;
    }

    public String getUrl() {
        return StringUtil.bytes2String(this.szUrl);
    }

    public String getFileName() {
        return StringUtil.bytes2String(this.szFileName);
    }

    public int getState() {
        return this.nStatus;
    }

    public long getTotalSize() {
        return this.nFileLen;
    }

    public long getDownloadedSize() {
        return this.nDownloadLen;
    }

    public int getErrorCode() {
        return this.nErrorCode;
    }

    public int getSpeed() {
        return this.nDownloadRate;
    }

    public int getDiskFiles() {
        return this.nDiskFiles;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", getUrl());
            jSONObject.put("fileName", getFileName());
            jSONObject.put("state", this.nStatus);
            jSONObject.put("errorCode", this.nErrorCode);
            jSONObject.put("totalSize", this.nFileLen);
            jSONObject.put("downloadedSize", this.nDownloadLen);
            jSONObject.put("speed", this.nDownloadRate);
            jSONObject.put("diskFiles", this.nDiskFiles);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    private JNITaskInfo(Parcel parcel) {
        this.szUrl = null;
        this.szFileName = null;
        this.nFileLen = 0L;
        this.nErrorCode = 0;
        this.nStatus = 0;
        this.nDownloadLen = 0L;
        this.nDownloadRate = 0;
        this.nDiskFiles = 0;
        readFromParcel(parcel);
    }

    /* synthetic */ JNITaskInfo(Parcel parcel, JNITaskInfo jNITaskInfo) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        String bytes2String = StringUtil.bytes2String(this.szUrl);
        String bytes2String2 = StringUtil.bytes2String(this.szFileName);
        parcel.writeString(bytes2String);
        parcel.writeString(bytes2String2);
        parcel.writeLong(this.nFileLen);
        parcel.writeInt(this.nErrorCode);
        parcel.writeInt(this.nStatus);
        parcel.writeLong(this.nDownloadLen);
        parcel.writeInt(this.nDownloadRate);
        parcel.writeInt(this.nDiskFiles);
    }

    public void readFromParcel(Parcel parcel) {
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        this.nFileLen = parcel.readLong();
        this.nErrorCode = parcel.readInt();
        this.nStatus = parcel.readInt();
        this.nDownloadLen = parcel.readLong();
        this.nDownloadRate = parcel.readInt();
        this.nDiskFiles = parcel.readInt();
        this.szUrl = readString.getBytes();
        this.szFileName = readString2.getBytes();
    }
}
