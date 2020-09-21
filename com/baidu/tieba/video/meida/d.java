package com.baidu.tieba.video.meida;
/* loaded from: classes22.dex */
public abstract class d {
    int channelCount;
    String mJu;
    int sampleRate;

    public abstract void Sx(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.mJu = str;
    }

    public void setSampleRate(int i) {
        this.sampleRate = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d Sy(String str) {
        return new a(str);
    }
}
