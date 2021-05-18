package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Preconditions;
/* loaded from: classes4.dex */
public final class PreFillType {
    @VisibleForTesting
    public static final Bitmap.Config DEFAULT_CONFIG = Bitmap.Config.RGB_565;
    public final Bitmap.Config config;
    public final int height;
    public final int weight;
    public final int width;

    /* loaded from: classes4.dex */
    public static class Builder {
        public Bitmap.Config config;
        public final int height;
        public int weight;
        public final int width;

        public Builder(int i2) {
            this(i2, i2);
        }

        public PreFillType build() {
            return new PreFillType(this.width, this.height, this.config, this.weight);
        }

        public Bitmap.Config getConfig() {
            return this.config;
        }

        public Builder setConfig(@Nullable Bitmap.Config config) {
            this.config = config;
            return this;
        }

        public Builder setWeight(int i2) {
            if (i2 > 0) {
                this.weight = i2;
                return this;
            }
            throw new IllegalArgumentException("Weight must be > 0");
        }

        public Builder(int i2, int i3) {
            this.weight = 1;
            if (i2 <= 0) {
                throw new IllegalArgumentException("Width must be > 0");
            }
            if (i3 > 0) {
                this.width = i2;
                this.height = i3;
                return;
            }
            throw new IllegalArgumentException("Height must be > 0");
        }
    }

    public PreFillType(int i2, int i3, Bitmap.Config config, int i4) {
        this.config = (Bitmap.Config) Preconditions.checkNotNull(config, "Config must not be null");
        this.width = i2;
        this.height = i3;
        this.weight = i4;
    }

    public boolean equals(Object obj) {
        if (obj instanceof PreFillType) {
            PreFillType preFillType = (PreFillType) obj;
            return this.height == preFillType.height && this.width == preFillType.width && this.weight == preFillType.weight && this.config == preFillType.config;
        }
        return false;
    }

    public Bitmap.Config getConfig() {
        return this.config;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((((this.width * 31) + this.height) * 31) + this.config.hashCode()) * 31) + this.weight;
    }

    public String toString() {
        return "PreFillSize{width=" + this.width + ", height=" + this.height + ", config=" + this.config + ", weight=" + this.weight + '}';
    }
}
