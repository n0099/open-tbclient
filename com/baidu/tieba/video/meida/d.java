package com.baidu.tieba.video.meida;
/* loaded from: classes23.dex */
public abstract class d {
    int channelCount;
    String nry;
    int sampleRate;

    public abstract void Ub(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.nry = str;
    }

    public void setSampleRate(int i) {
        this.sampleRate = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d Uc(String str) {
        return new a(str);
    }
}
