package com.bumptech.glide.util.pool;

import androidx.annotation.NonNull;
/* loaded from: classes9.dex */
public abstract class StateVerifier {
    public static final boolean DEBUG = false;

    public abstract void setRecycled(boolean z);

    public abstract void throwIfRecycled();

    /* loaded from: classes9.dex */
    public static class DebugStateVerifier extends StateVerifier {
        public volatile RuntimeException recycledAtStackTraceException;

        public DebugStateVerifier() {
            super();
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void throwIfRecycled() {
            if (this.recycledAtStackTraceException == null) {
                return;
            }
            throw new IllegalStateException("Already released", this.recycledAtStackTraceException);
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void setRecycled(boolean z) {
            if (z) {
                this.recycledAtStackTraceException = new RuntimeException("Released");
            } else {
                this.recycledAtStackTraceException = null;
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class DefaultStateVerifier extends StateVerifier {
        public volatile boolean isReleased;

        public DefaultStateVerifier() {
            super();
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void throwIfRecycled() {
            if (!this.isReleased) {
                return;
            }
            throw new IllegalStateException("Already released");
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void setRecycled(boolean z) {
            this.isReleased = z;
        }
    }

    public StateVerifier() {
    }

    @NonNull
    public static StateVerifier newInstance() {
        return new DefaultStateVerifier();
    }
}
