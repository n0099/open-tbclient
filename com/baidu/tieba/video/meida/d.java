package com.baidu.tieba.video.meida;
/* loaded from: classes5.dex */
public abstract class d {
    int aWk;
    int channelCount;
    String jCE;

    public abstract void Fc(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.jCE = str;
    }

    public void setSampleRate(int i) {
        this.aWk = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d Fd(String str) {
        return new a(str);
    }
}
