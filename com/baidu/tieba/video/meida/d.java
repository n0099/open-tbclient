package com.baidu.tieba.video.meida;
/* loaded from: classes5.dex */
public abstract class d {
    int aVS;
    int channelCount;
    String jBN;

    public abstract void Fc(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.jBN = str;
    }

    public void setSampleRate(int i) {
        this.aVS = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d Fd(String str) {
        return new a(str);
    }
}
