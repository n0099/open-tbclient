package com.baidu.tieba.pb.main;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements Animation.AnimationListener {
    final /* synthetic */ bz bCR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(bz bzVar) {
        this.bCR = bzVar;
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
        View view2;
        z = this.bCR.bCD;
        if (!z) {
            pbEditor = this.bCR.bCu;
            if (pbEditor != null) {
                pbEditor2 = this.bCR.bCu;
                pbEditor2.setVisibility(0);
                return;
            }
            return;
        }
        view = this.bCR.bCx;
        view.setVisibility(0);
        view2 = this.bCR.bCw;
        view2.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
