package com.baidu.tieba.pb.main;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements Animation.AnimationListener {
    final /* synthetic */ bz bEB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(bz bzVar) {
        this.bEB = bzVar;
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
        z = this.bEB.bEn;
        if (!z) {
            pbEditor = this.bEB.bEe;
            if (pbEditor != null) {
                pbEditor2 = this.bEB.bEe;
                pbEditor2.setVisibility(0);
                return;
            }
            return;
        }
        view = this.bEB.bEh;
        view.setVisibility(0);
        view2 = this.bEB.bEg;
        view2.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
