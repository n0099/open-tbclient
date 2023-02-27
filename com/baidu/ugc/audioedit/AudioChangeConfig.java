package com.baidu.ugc.audioedit;

import java.io.Serializable;
/* loaded from: classes7.dex */
public class AudioChangeConfig implements Serializable {
    public DelayConfig delayConfig;

    public DelayConfig getDelayConfig() {
        return this.delayConfig;
    }

    public boolean configEnabled(boolean z) {
        DelayConfig delayConfig = this.delayConfig;
        if (delayConfig != null && delayConfig.available()) {
            return true;
        }
        return z;
    }

    public AudioChangeConfig setDelayConfig(DelayConfig delayConfig) {
        this.delayConfig = delayConfig;
        return this;
    }
}
