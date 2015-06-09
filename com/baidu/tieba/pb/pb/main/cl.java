package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl implements Animation.AnimationListener {
    final /* synthetic */ ch bOG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(ch chVar) {
        this.bOG = chVar;
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
        z = this.bOG.bOo;
        if (!z) {
            pbEditor = this.bOG.bOi;
            if (pbEditor != null) {
                pbEditor2 = this.bOG.bOi;
                pbEditor2.setVisibility(0);
                return;
            }
            return;
        }
        view = this.bOG.bOk;
        view.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
