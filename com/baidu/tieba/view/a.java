package com.baidu.tieba.view;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AudioAnimationView gfa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AudioAnimationView audioAnimationView) {
        this.gfa = audioAnimationView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.gfa.bdT();
    }
}
