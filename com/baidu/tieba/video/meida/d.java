package com.baidu.tieba.video.meida;
/* loaded from: classes2.dex */
public abstract class d {
    int channelCount;
    String hgg;
    int hgh;

    public abstract void uZ(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.hgg = str;
    }

    public void setSampleRate(int i) {
        this.hgh = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d va(String str) {
        return new a(str);
    }
}
