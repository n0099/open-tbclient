package com.baidu.tieba.video.meida;
/* loaded from: classes5.dex */
public abstract class d {
    int aBP;
    int channelCount;
    String jsY;

    public abstract void Fi(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.jsY = str;
    }

    public void setSampleRate(int i) {
        this.aBP = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d Fj(String str) {
        return new a(str);
    }
}
