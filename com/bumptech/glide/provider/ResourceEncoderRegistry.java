package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.ResourceEncoder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class ResourceEncoderRegistry {
    private final List<Entry<?>> encoders = new ArrayList();

    public synchronized <Z> void append(@NonNull Class<Z> cls, @NonNull ResourceEncoder<Z> resourceEncoder) {
        this.encoders.add(new Entry<>(cls, resourceEncoder));
    }

    public synchronized <Z> void prepend(@NonNull Class<Z> cls, @NonNull ResourceEncoder<Z> resourceEncoder) {
        this.encoders.add(0, new Entry<>(cls, resourceEncoder));
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        r0 = (com.bumptech.glide.load.ResourceEncoder<Z>) r0.encoder;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized <Z> ResourceEncoder<Z> get(@NonNull Class<Z> cls) {
        ResourceEncoder<Z> resourceEncoder;
        int size = this.encoders.size();
        int i = 0;
        while (true) {
            if (i < size) {
                Entry<?> entry = this.encoders.get(i);
                if (entry.handles(cls)) {
                    break;
                }
                i++;
            } else {
                resourceEncoder = null;
                break;
            }
        }
        return resourceEncoder;
    }

    /* loaded from: classes15.dex */
    private static final class Entry<T> {
        final ResourceEncoder<T> encoder;
        private final Class<T> resourceClass;

        Entry(@NonNull Class<T> cls, @NonNull ResourceEncoder<T> resourceEncoder) {
            this.resourceClass = cls;
            this.encoder = resourceEncoder;
        }

        boolean handles(@NonNull Class<?> cls) {
            return this.resourceClass.isAssignableFrom(cls);
        }
    }
}
