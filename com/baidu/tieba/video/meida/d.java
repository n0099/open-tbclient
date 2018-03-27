package com.baidu.tieba.video.meida;
/* loaded from: classes2.dex */
public abstract class d {
    int channelCount;
    String htS;
    int htT;

    public abstract void tZ(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.htS = str;
    }

    public void setSampleRate(int i) {
        this.htT = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d ua(String str) {
        return new a(str);
    }
}
