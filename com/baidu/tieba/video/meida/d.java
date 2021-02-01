package com.baidu.tieba.video.meida;
/* loaded from: classes8.dex */
public abstract class d {
    int channelCount;
    String nPe;
    int sampleRate;

    public abstract void Uu(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.nPe = str;
    }

    public void setSampleRate(int i) {
        this.sampleRate = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d Uv(String str) {
        return new a(str);
    }
}
