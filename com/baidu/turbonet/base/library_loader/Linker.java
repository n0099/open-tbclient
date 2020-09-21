package com.baidu.turbonet.base.library_loader;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.baidu.turbonet.base.a;
import com.baidu.turbonet.base.annotations.AccessedByNative;
import java.io.IOException;
import java.util.Locale;
/* loaded from: classes15.dex */
public abstract class Linker {
    private static Linker nkk = null;
    private static Object nkl = new Object();
    protected int nki = 0;
    protected final Object mLock = new Object();
    private String nkj = null;

    private static native long nativeGetRandomBaseLoadAddress();

    /* loaded from: classes15.dex */
    public static class LibInfo implements Parcelable {
        public static final Parcelable.Creator<LibInfo> CREATOR = new Parcelable.Creator<LibInfo>() { // from class: com.baidu.turbonet.base.library_loader.Linker.LibInfo.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ai */
            public LibInfo createFromParcel(Parcel parcel) {
                return new LibInfo(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: KH */
            public LibInfo[] newArray(int i) {
                return new LibInfo[i];
            }
        };
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

        public LibInfo() {
            this.mLoadAddress = 0L;
            this.mLoadSize = 0L;
            this.mRelroStart = 0L;
            this.mRelroSize = 0L;
            this.mRelroFd = -1;
        }

        public LibInfo(Parcel parcel) {
            this.mLoadAddress = parcel.readLong();
            this.mLoadSize = parcel.readLong();
            this.mRelroStart = parcel.readLong();
            this.mRelroSize = parcel.readLong();
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            this.mRelroFd = parcelFileDescriptor == null ? -1 : parcelFileDescriptor.detachFd();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            if (this.mRelroFd >= 0) {
                parcel.writeLong(this.mLoadAddress);
                parcel.writeLong(this.mLoadSize);
                parcel.writeLong(this.mRelroStart);
                parcel.writeLong(this.mRelroSize);
                try {
                    ParcelFileDescriptor fromFd = ParcelFileDescriptor.fromFd(this.mRelroFd);
                    fromFd.writeToParcel(parcel, 0);
                    fromFd.close();
                } catch (IOException e) {
                    a.g("LibraryLoader", "Can't write LibInfo file descriptor to parcel", e);
                }
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 1;
        }

        public String toString() {
            return String.format(Locale.US, "[load=0x%x-0x%x relro=0x%x-0x%x fd=%d]", Long.valueOf(this.mLoadAddress), Long.valueOf(this.mLoadAddress + this.mLoadSize), Long.valueOf(this.mRelroStart), Long.valueOf(this.mRelroStart + this.mRelroSize), Integer.valueOf(this.mRelroFd));
        }
    }
}
