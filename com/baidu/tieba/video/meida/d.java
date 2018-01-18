package com.baidu.tieba.video.meida;
/* loaded from: classes2.dex */
public abstract class d {
    int channelCount;
    String hrX;
    int hrY;

    public abstract void tN(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.hrX = str;
    }

    public void setSampleRate(int i) {
        this.hrY = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d tO(String str) {
        return new a(str);
    }
}
