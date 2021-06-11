package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class MultiClassKey {
    public Class<?> first;
    public Class<?> second;
    public Class<?> third;

    public MultiClassKey() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MultiClassKey.class != obj.getClass()) {
            return false;
        }
        MultiClassKey multiClassKey = (MultiClassKey) obj;
        return this.first.equals(multiClassKey.first) && this.second.equals(multiClassKey.second) && Util.bothNullOrEqual(this.third, multiClassKey.third);
    }

    public int hashCode() {
        int hashCode = ((this.first.hashCode() * 31) + this.second.hashCode()) * 31;
        Class<?> cls = this.third;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public void set(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        set(cls, cls2, null);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.first + ", second=" + this.second + '}';
    }

    public MultiClassKey(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        set(cls, cls2);
    }

    public void set(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.first = cls;
        this.second = cls2;
        this.third = cls3;
    }

    public MultiClassKey(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        set(cls, cls2, cls3);
    }
}
