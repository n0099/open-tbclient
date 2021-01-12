package com.bumptech.glide.load.resource.transcode;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class TranscoderRegistry {
    private final List<Entry<?, ?>> transcoders = new ArrayList();

    public synchronized <Z, R> void register(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull ResourceTranscoder<Z, R> resourceTranscoder) {
        this.transcoders.add(new Entry<>(cls, cls2, resourceTranscoder));
    }

    @NonNull
    public synchronized <Z, R> ResourceTranscoder<Z, R> get(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        ResourceTranscoder<Z, R> resourceTranscoder;
        if (cls2.isAssignableFrom(cls)) {
            resourceTranscoder = UnitTranscoder.get();
        } else {
            for (Entry<?, ?> entry : this.transcoders) {
                if (entry.handles(cls, cls2)) {
                    resourceTranscoder = (ResourceTranscoder<Z, R>) entry.transcoder;
                }
            }
            throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
        }
        return resourceTranscoder;
    }

    @NonNull
    public synchronized <Z, R> List<Class<R>> getTranscodeClasses(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList2.add(cls2);
            arrayList = arrayList2;
        } else {
            for (Entry<?, ?> entry : this.transcoders) {
                if (entry.handles(cls, cls2)) {
                    arrayList2.add(cls2);
                }
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    /* loaded from: classes5.dex */
    private static final class Entry<Z, R> {
        private final Class<Z> fromClass;
        private final Class<R> toClass;
        final ResourceTranscoder<Z, R> transcoder;

        Entry(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull ResourceTranscoder<Z, R> resourceTranscoder) {
            this.fromClass = cls;
            this.toClass = cls2;
            this.transcoder = resourceTranscoder;
        }

        public boolean handles(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.fromClass.isAssignableFrom(cls) && cls2.isAssignableFrom(this.toClass);
        }
    }
}
