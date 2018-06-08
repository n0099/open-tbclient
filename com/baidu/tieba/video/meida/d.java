package com.baidu.tieba.video.meida;
/* loaded from: classes2.dex */
public abstract class d {
    int channelCount;
    String hcb;
    int hcc;

    public abstract void vd(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.hcb = str;
    }

    public void setSampleRate(int i) {
        this.hcc = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d ve(String str) {
        return new a(str);
    }
}
