package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl implements Animation.AnimationListener {
    final /* synthetic */ ch bOF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(ch chVar) {
        this.bOF = chVar;
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
        z = this.bOF.bOn;
        if (!z) {
            pbEditor = this.bOF.bOh;
            if (pbEditor != null) {
                pbEditor2 = this.bOF.bOh;
                pbEditor2.setVisibility(0);
                return;
            }
            return;
        }
        view = this.bOF.bOj;
        view.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
