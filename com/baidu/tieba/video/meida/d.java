package com.baidu.tieba.video.meida;
/* loaded from: classes23.dex */
public abstract class d {
    int channelCount;
    String nGG;
    int sampleRate;

    public abstract void Vb(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.nGG = str;
    }

    public void setSampleRate(int i) {
        this.sampleRate = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d Vc(String str) {
        return new a(str);
    }
}
