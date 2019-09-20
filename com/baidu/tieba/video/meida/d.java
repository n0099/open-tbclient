package com.baidu.tieba.video.meida;
/* loaded from: classes5.dex */
public abstract class d {
    int aCV;
    int channelCount;
    String jCM;

    public abstract void GA(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.jCM = str;
    }

    public void setSampleRate(int i) {
        this.aCV = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d GB(String str) {
        return new a(str);
    }
}
