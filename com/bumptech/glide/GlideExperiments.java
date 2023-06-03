package com.bumptech.glide;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class GlideExperiments {
    public final Map<Class<?>, Experiment> experiments;

    /* loaded from: classes9.dex */
    public interface Experiment {
    }

    /* loaded from: classes9.dex */
    public static final class Builder {
        public final Map<Class<?>, Experiment> experiments = new HashMap();

        public GlideExperiments build() {
            return new GlideExperiments(this);
        }

        public Builder add(Experiment experiment) {
            this.experiments.put(experiment.getClass(), experiment);
            return this;
        }

        public Builder update(Experiment experiment, boolean z) {
            if (z) {
                add(experiment);
            } else {
                this.experiments.remove(experiment.getClass());
            }
            return this;
        }
    }

    public GlideExperiments(Builder builder) {
        this.experiments = Collections.unmodifiableMap(new HashMap(builder.experiments));
    }

    @Nullable
    public <T extends Experiment> T get(Class<T> cls) {
        return (T) this.experiments.get(cls);
    }

    public boolean isEnabled(Class<? extends Experiment> cls) {
        return this.experiments.containsKey(cls);
    }
}
