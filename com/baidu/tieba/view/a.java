package com.baidu.tieba.view;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AudioAnimationView fAJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AudioAnimationView audioAnimationView) {
        this.fAJ = audioAnimationView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fAJ.aUj();
    }
}
