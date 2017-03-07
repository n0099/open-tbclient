package com.baidu.tieba.view;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AudioAnimationView fHr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AudioAnimationView audioAnimationView) {
        this.fHr = audioAnimationView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fHr.aYT();
    }
}
