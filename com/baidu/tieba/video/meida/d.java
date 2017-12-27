package com.baidu.tieba.video.meida;
/* loaded from: classes2.dex */
public abstract class d {
    int channelCount;
    String hCu;
    int hCv;

    public abstract void us(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.hCu = str;
    }

    public void setSampleRate(int i) {
        this.hCv = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d ut(String str) {
        return new a(str);
    }
}
