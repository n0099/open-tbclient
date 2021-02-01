package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Encoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes15.dex */
public class EncoderRegistry {
    private final List<Entry<?>> encoders = new ArrayList();

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        r0 = (com.bumptech.glide.load.Encoder<T>) r0.encoder;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized <T> Encoder<T> getEncoder(@NonNull Class<T> cls) {
        Encoder<T> encoder;
        Iterator<Entry<?>> it = this.encoders.iterator();
        while (true) {
            if (!it.hasNext()) {
                encoder = null;
                break;
            }
            Entry<?> next = it.next();
            if (next.handles(cls)) {
                break;
            }
        }
        return encoder;
    }

    public synchronized <T> void append(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
        this.encoders.add(new Entry<>(cls, encoder));
    }

    public synchronized <T> void prepend(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
        this.encoders.add(0, new Entry<>(cls, encoder));
    }

    /* loaded from: classes15.dex */
    private static final class Entry<T> {
        private final Class<T> dataClass;
        final Encoder<T> encoder;

        Entry(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
            this.dataClass = cls;
            this.encoder = encoder;
        }

        boolean handles(@NonNull Class<?> cls) {
            return this.dataClass.isAssignableFrom(cls);
        }
    }
}
