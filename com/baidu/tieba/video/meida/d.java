package com.baidu.tieba.video.meida;
/* loaded from: classes2.dex */
public abstract class d {
    int channelCount;
    String gxN;
    int gxO;

    public abstract void sN(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.gxN = str;
    }

    public void setSampleRate(int i) {
        this.gxO = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d sO(String str) {
        return new a(str);
    }
}
