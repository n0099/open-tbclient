package com.baidu.tieba.video.meida;
/* loaded from: classes2.dex */
public abstract class d {
    int channelCount;
    String gHf;
    int gHg;

    public abstract void ty(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.gHf = str;
    }

    public void setSampleRate(int i) {
        this.gHg = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d tz(String str) {
        return new a(str);
    }
}
