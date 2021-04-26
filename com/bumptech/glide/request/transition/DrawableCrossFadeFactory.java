package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
/* loaded from: classes5.dex */
public class DrawableCrossFadeFactory implements TransitionFactory<Drawable> {
    public final int duration;
    public final boolean isCrossFadeEnabled;
    public DrawableCrossFadeTransition resourceTransition;

    /* loaded from: classes5.dex */
    public static class Builder {
        public static final int DEFAULT_DURATION_MS = 300;
        public final int durationMillis;
        public boolean isCrossFadeEnabled;

        public Builder() {
            this(300);
        }

        public DrawableCrossFadeFactory build() {
            return new DrawableCrossFadeFactory(this.durationMillis, this.isCrossFadeEnabled);
        }

        public Builder setCrossFadeEnabled(boolean z) {
            this.isCrossFadeEnabled = z;
            return this;
        }

        public Builder(int i2) {
            this.durationMillis = i2;
        }
    }

    public DrawableCrossFadeFactory(int i2, boolean z) {
        this.duration = i2;
        this.isCrossFadeEnabled = z;
    }

    private Transition<Drawable> getResourceTransition() {
        if (this.resourceTransition == null) {
            this.resourceTransition = new DrawableCrossFadeTransition(this.duration, this.isCrossFadeEnabled);
        }
        return this.resourceTransition;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<Drawable> build(DataSource dataSource, boolean z) {
        return dataSource == DataSource.MEMORY_CACHE ? NoTransition.get() : getResourceTransition();
    }
}
