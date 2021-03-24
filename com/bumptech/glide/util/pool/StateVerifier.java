package com.bumptech.glide.util.pool;

import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public abstract class StateVerifier {
    public static final boolean DEBUG = false;

    /* loaded from: classes5.dex */
    public static class DebugStateVerifier extends StateVerifier {
        public volatile RuntimeException recycledAtStackTraceException;

        public DebugStateVerifier() {
            super();
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void setRecycled(boolean z) {
            if (z) {
                this.recycledAtStackTraceException = new RuntimeException("Released");
            } else {
                this.recycledAtStackTraceException = null;
            }
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void throwIfRecycled() {
            if (this.recycledAtStackTraceException != null) {
                throw new IllegalStateException("Already released", this.recycledAtStackTraceException);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class DefaultStateVerifier extends StateVerifier {
        public volatile boolean isReleased;

        public DefaultStateVerifier() {
            super();
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void setRecycled(boolean z) {
            this.isReleased = z;
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void throwIfRecycled() {
            if (this.isReleased) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    @NonNull
    public static StateVerifier newInstance() {
        return new DefaultStateVerifier();
    }

    public abstract void setRecycled(boolean z);

    public abstract void throwIfRecycled();

    public StateVerifier() {
    }
}
