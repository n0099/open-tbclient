package com.bumptech.glide.load.data;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.data.DataRewinder;
import java.io.IOException;
/* loaded from: classes8.dex */
public final class ParcelFileDescriptorRewinder implements DataRewinder<ParcelFileDescriptor> {
    public final InternalRewinder rewinder;

    @Override // com.bumptech.glide.load.data.DataRewinder
    public void cleanup() {
    }

    @RequiresApi(21)
    /* loaded from: classes8.dex */
    public static final class Factory implements DataRewinder.Factory<ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        @NonNull
        public Class<ParcelFileDescriptor> getDataClass() {
            return ParcelFileDescriptor.class;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        @NonNull
        public DataRewinder<ParcelFileDescriptor> build(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
            return new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }
    }

    @RequiresApi(21)
    /* loaded from: classes8.dex */
    public static final class InternalRewinder {
        public final ParcelFileDescriptor parcelFileDescriptor;

        public InternalRewinder(ParcelFileDescriptor parcelFileDescriptor) {
            this.parcelFileDescriptor = parcelFileDescriptor;
        }

        public ParcelFileDescriptor rewind() throws IOException {
            try {
                Os.lseek(this.parcelFileDescriptor.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
                return this.parcelFileDescriptor;
            } catch (ErrnoException e) {
                throw new IOException(e);
            }
        }
    }

    @RequiresApi(21)
    public ParcelFileDescriptorRewinder(ParcelFileDescriptor parcelFileDescriptor) {
        this.rewinder = new InternalRewinder(parcelFileDescriptor);
    }

    public static boolean isSupported() {
        if (Build.VERSION.SDK_INT >= 21) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.DataRewinder
    @NonNull
    @RequiresApi(21)
    public ParcelFileDescriptor rewindAndGet() throws IOException {
        return this.rewinder.rewind();
    }
}
