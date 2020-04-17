package com.baidu.tieba.video.meida;
/* loaded from: classes10.dex */
public abstract class d {
    int channelCount;
    String lmv;
    int sampleRate;

    public abstract void LX(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.lmv = str;
    }

    public void setSampleRate(int i) {
        this.sampleRate = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d LY(String str) {
        return new a(str);
    }
}
