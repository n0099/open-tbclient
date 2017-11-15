package com.baidu.tieba.video.meida;
/* loaded from: classes2.dex */
public abstract class d {
    int channelCount;
    String gIn;
    int gIo;

    public abstract void tE(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.gIn = str;
    }

    public void setSampleRate(int i) {
        this.gIo = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d tF(String str) {
        return new a(str);
    }
}
