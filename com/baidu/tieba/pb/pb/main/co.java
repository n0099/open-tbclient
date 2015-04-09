package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class co implements Animation.AnimationListener {
    final /* synthetic */ cj bMC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(cj cjVar) {
        this.bMC = cjVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        PbEditor pbEditor;
        PbEditor pbEditor2;
        View view;
        z = this.bMC.bMm;
        if (!z) {
            pbEditor = this.bMC.bMh;
            if (pbEditor != null) {
                pbEditor2 = this.bMC.bMh;
                pbEditor2.setVisibility(0);
                return;
            }
            return;
        }
        view = this.bMC.bMj;
        view.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
