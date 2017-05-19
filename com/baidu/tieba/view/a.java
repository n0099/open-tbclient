package com.baidu.tieba.view;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AudioAnimationView fHY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AudioAnimationView audioAnimationView) {
        this.fHY = audioAnimationView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fHY.aXC();
    }
}
