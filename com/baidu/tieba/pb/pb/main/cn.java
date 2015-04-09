package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cn implements Animation.AnimationListener {
    final /* synthetic */ cj bMC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(cj cjVar) {
        this.bMC = cjVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        PbEditor pbEditor;
        View view2;
        PbEditor pbEditor2;
        cj cjVar = this.bMC;
        view = this.bMC.bMj;
        cjVar.bMm = view.getVisibility() == 0;
        pbEditor = this.bMC.bMh;
        if (pbEditor != null) {
            pbEditor2 = this.bMC.bMh;
            pbEditor2.setVisibility(8);
        }
        view2 = this.bMC.bMj;
        view2.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
