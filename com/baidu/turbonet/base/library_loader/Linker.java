package com.baidu.turbonet.base.library_loader;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.baidu.turbonet.base.annotations.AccessedByNative;
import java.io.IOException;
import java.util.Locale;
/* loaded from: classes5.dex */
public abstract class Linker {
    public static native long nativeGetRandomBaseLoadAddress();

    /* loaded from: classes5.dex */
    public static class LibInfo implements Parcelable {
        public static final Parcelable.Creator<LibInfo> CREATOR = new a();
        @AccessedByNative
        public long mLoadAddress;
        @AccessedByNative
        public long mLoadSize;
        @AccessedByNative
        public int mRelroFd;
        @AccessedByNative
        public long mRelroSize;
        @AccessedByNative
        public long mRelroStart;

        /* loaded from: classes5.dex */
        public static class a implements Parcelable.Creator<LibInfo> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public LibInfo createFromParcel(Parcel parcel) {
                return new LibInfo(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public LibInfo[] newArray(int i2) {
                return new LibInfo[i2];
            }
        }

        public LibInfo() {
            this.mLoadAddress = 0L;
            this.mLoadSize = 0L;
            this.mRelroStart = 0L;
            this.mRelroSize = 0L;
            this.mRelroFd = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 1;
        }

        public String toString() {
            return String.format(Locale.US, "[load=0x%x-0x%x relro=0x%x-0x%x fd=%d]", Long.valueOf(this.mLoadAddress), Long.valueOf(this.mLoadAddress + this.mLoadSize), Long.valueOf(this.mRelroStart), Long.valueOf(this.mRelroStart + this.mRelroSize), Integer.valueOf(this.mRelroFd));
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            if (this.mRelroFd >= 0) {
                parcel.writeLong(this.mLoadAddress);
                parcel.writeLong(this.mLoadSize);
                parcel.writeLong(this.mRelroStart);
                parcel.writeLong(this.mRelroSize);
                try {
                    ParcelFileDescriptor fromFd = ParcelFileDescriptor.fromFd(this.mRelroFd);
                    fromFd.writeToParcel(parcel, 0);
                    fromFd.close();
                } catch (IOException e2) {
                    d.a.k0.a.a.c("LibraryLoader", "Can't write LibInfo file descriptor to parcel", e2);
                }
            }
        }

        public LibInfo(Parcel parcel) {
            this.mLoadAddress = parcel.readLong();
            this.mLoadSize = parcel.readLong();
            this.mRelroStart = parcel.readLong();
            this.mRelroSize = parcel.readLong();
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            this.mRelroFd = parcelFileDescriptor == null ? -1 : parcelFileDescriptor.detachFd();
        }
    }
}
