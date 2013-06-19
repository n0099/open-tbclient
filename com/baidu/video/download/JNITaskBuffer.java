package com.baidu.video.download;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class JNITaskBuffer implements Parcelable {
    public static final int BufferSize = 16384;
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.baidu.video.download.JNITaskBuffer.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        public JNITaskBuffer[] newArray(int i) {
            return new JNITaskBuffer[i];
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        public JNITaskBuffer createFromParcel(Parcel parcel) {
            return new JNITaskBuffer(parcel, null);
        }
    };
    private int nBlockSize;
    public byte[] szBuffer;

    public JNITaskBuffer() {
        this.szBuffer = new byte[BufferSize];
        this.nBlockSize = 0;
    }

    public byte[] getBuffer() {
        return this.szBuffer;
    }

    public void setBuffer(byte[] bArr) {
        this.szBuffer = bArr;
    }

    public int getBlockSize() {
        return this.nBlockSize;
    }

    private JNITaskBuffer(Parcel parcel) {
        this.szBuffer = new byte[BufferSize];
        this.nBlockSize = 0;
        readFromParcel(parcel);
    }

    /* synthetic */ JNITaskBuffer(Parcel parcel, JNITaskBuffer jNITaskBuffer) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.nBlockSize);
        parcel.writeByteArray(this.szBuffer);
    }

    public void readFromParcel(Parcel parcel) {
        this.nBlockSize = parcel.readInt();
        parcel.readByteArray(this.szBuffer);
    }
}
