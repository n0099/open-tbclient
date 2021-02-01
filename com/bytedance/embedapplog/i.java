package com.bytedance.embedapplog;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public interface i {
    @AnyThread
    void onOaidLoaded(@NonNull a aVar);

    /* loaded from: classes6.dex */
    public static final class a {
        @Nullable
        public final String id;

        public a(@Nullable String str) {
            this.id = str;
        }
    }
}
