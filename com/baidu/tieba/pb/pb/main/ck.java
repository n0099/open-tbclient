package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck implements Animation.AnimationListener {
    final /* synthetic */ ch bOG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(ch chVar) {
        this.bOG = chVar;
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
        ch chVar = this.bOG;
        view = this.bOG.bOk;
        chVar.bOo = view.getVisibility() == 0;
        pbEditor = this.bOG.bOi;
        if (pbEditor != null) {
            pbEditor2 = this.bOG.bOi;
            pbEditor2.setVisibility(8);
        }
        view2 = this.bOG.bOk;
        view2.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
