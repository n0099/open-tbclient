package com.baidu.ugc.audioedit;

import java.io.Serializable;
/* loaded from: classes8.dex */
public class BaseAudioConfig implements Serializable {
    public int audioType;
    public boolean enable;

    public int getAudioType() {
        return this.audioType;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setAudioType(int i) {
        this.audioType = i;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }
}
