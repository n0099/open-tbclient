package com.baidu.tieba.video.meida;
/* loaded from: classes5.dex */
public abstract class d {
    int channelCount;
    String hwA;
    int sampleRate;

    public abstract void wl(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.hwA = str;
    }

    public void setSampleRate(int i) {
        this.sampleRate = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d wm(String str) {
        return new a(str);
    }
}
