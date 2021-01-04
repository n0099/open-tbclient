package com.baidu.tieba.video.meida;
/* loaded from: classes8.dex */
public abstract class d {
    int channelCount;
    String nJZ;
    int sampleRate;

    public abstract void UF(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.nJZ = str;
    }

    public void setSampleRate(int i) {
        this.sampleRate = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d UG(String str) {
        return new a(str);
    }
}
