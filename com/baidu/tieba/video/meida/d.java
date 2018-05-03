package com.baidu.tieba.video.meida;
/* loaded from: classes2.dex */
public abstract class d {
    int channelCount;
    String gPv;
    int gPw;

    public abstract void ug(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.gPv = str;
    }

    public void setSampleRate(int i) {
        this.gPw = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d uh(String str) {
        return new a(str);
    }
}
